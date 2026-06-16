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
        if (studentRepository.existsByUsername(form.getUsername())) {
            throw new IllegalArgumentException("Username already taken");
        }
        if (form.getEmail() != null && studentRepository.existsByEmail(form.getEmail())) {
            throw new IllegalArgumentException("Email already registered");
        }
        Student student = new Student();
        student.setUsername(form.getUsername());
        student.setFullName(form.getFullName());
        student.setEmail(form.getEmail());
        student.setPassword(passwordEncoder.encode(form.getPassword()));
        student.setRole("ROLE_STUDENT");
        return studentRepository.save(student);
    }

    public Student getByUsername(String username) {
        return studentRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalStateException("Student not found: " + username));
    }
}
