package com.gremath.service;

import com.gremath.dto.RegistrationForm;
import com.gremath.model.Student;
import com.gremath.repository.StudentRepository;
import java.time.LocalDate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public static final int NZ_TRIAL_DAYS = 2;

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
        startNzTrial(student);
        return (Student)this.studentRepository.save(student);
    }

    public Student getByUsername(String username) {
        return this.studentRepository.findByUsername(username).orElseThrow(() -> new IllegalStateException("Student not found: " + username));
    }

    public Student getById(Long id) {
        return this.studentRepository.findById(id).orElseThrow(() -> new IllegalStateException("Student not found: " + id));
    }

    public boolean hasTrackAccess(Student student, String track) {
        if ("class6-nz".equalsIgnoreCase(track) || "nz".equalsIgnoreCase(track)) {
            return student.hasActiveClass6NzSubscription();
        }
        // GRE/CAT hidden for now — deny access via UI; keep backend check intact
        return student.hasActiveGreCatSubscription();
    }

    /**
     * Starts a one-time 2-day NZ curriculum trial if the family has not used a trial yet
     * and does not already have paid access.
     */
    public LocalDate startNzTrialIfEligible(Student student) {
        if (student.hasPaidNzSubscription()) {
            return student.getClass6NzSubscribedUntil();
        }
        if (student.isNzTrialUsed() && !student.hasActiveNzTrial()) {
            throw new IllegalStateException("Your free trial has already been used. Please subscribe to continue.");
        }
        if (student.hasActiveNzTrial()) {
            return student.getNzTrialUntil();
        }
        startNzTrial(student);
        return this.studentRepository.save(student).getNzTrialUntil();
    }

    private void startNzTrial(Student student) {
        LocalDate until = LocalDate.now().plusDays(NZ_TRIAL_DAYS);
        student.setNzTrialUntil(until);
        student.setNzTrialUsed(true);
    }

    public LocalDate activateMonthlySubscription(Student student, String plan) {
        LocalDate today = LocalDate.now();
        if ("class6-nz".equalsIgnoreCase(plan) || "nz".equalsIgnoreCase(plan)) {
            LocalDate base = student.getClass6NzSubscribedUntil() != null && student.getClass6NzSubscribedUntil().isAfter(today)
                    ? student.getClass6NzSubscribedUntil() : today;
            // Prefer extending from later of paid end or active trial end
            if (student.hasActiveNzTrial() && student.getNzTrialUntil().isAfter(base)) {
                base = student.getNzTrialUntil();
            }
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
