package com.gremath.service;

import com.gremath.model.Student;
import com.gremath.repository.StudentRepository;
import java.util.List;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class StudentDetailsService implements UserDetailsService {
    private final StudentRepository studentRepository;

    public StudentDetailsService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student = this.studentRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("No student found with username: " + username));
        // enabled=false blocks login until /verify-email succeeds
        return User.withUsername(student.getUsername())
                .password(student.getPassword())
                .disabled(!student.isEmailVerified())
                .authorities(List.of(new SimpleGrantedAuthority(student.getRole())))
                .build();
    }
}
