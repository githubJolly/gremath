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
import java.time.LocalDate;
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

    public boolean hasTrackAccess(Student student, String track) {
        if ("class6-nz".equalsIgnoreCase(track)) {
            return student.hasActiveClass6NzSubscription();
        }
        return student.hasActiveGreCatSubscription();
    }

    public LocalDate activateMonthlySubscription(Student student, String plan) {
        LocalDate today = LocalDate.now();
        if ("class6-nz".equalsIgnoreCase(plan)) {
            LocalDate base = student.getClass6NzSubscribedUntil() != null && student.getClass6NzSubscribedUntil().isAfter(today)
                    ? student.getClass6NzSubscribedUntil() : today;
            LocalDate until = base.plusMonths(1);
            student.setClass6NzSubscribedUntil(until);
            this.studentRepository.save(student);
            return until;
        }
        LocalDate base = student.getGreCatSubscribedUntil() != null && student.getGreCatSubscribedUntil().isAfter(today)
                ? student.getGreCatSubscribedUntil() : today;
        LocalDate until = base.plusMonths(1);
        student.setGreCatSubscribedUntil(until);
        this.studentRepository.save(student);
        return until;
    }
}

