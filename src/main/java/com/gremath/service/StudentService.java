/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.security.crypto.password.PasswordEncoder
 *  org.springframework.stereotype.Service
 */
package com.gremath.service;

import com.gremath.dto.RegistrationForm;
import com.gremath.model.Student;
import com.gremath.repository.StudentRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;

    public StudentService(StudentRepository studentRepository, PasswordEncoder passwordEncoder) {
        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Student register(RegistrationForm form) {
        if (this.studentRepository.existsByUsername(form.getUsername())) {
            throw new IllegalArgumentException("Username already taken");
        }
        if (form.getEmail() != null && this.studentRepository.existsByEmail(form.getEmail())) {
            throw new IllegalArgumentException("Email already registered");
        }
        Student student = new Student();
        student.setUsername(form.getUsername());
        student.setFullName(form.getFullName());
        student.setEmail(form.getEmail());
        student.setPassword(this.passwordEncoder.encode((CharSequence)form.getPassword()));
        student.setRole("ROLE_STUDENT");
        return (Student)this.studentRepository.save(student);
    }

    public Student getByUsername(String username) {
        return this.studentRepository.findByUsername(username).orElseThrow(() -> new IllegalStateException("Student not found: " + username));
    }
}

