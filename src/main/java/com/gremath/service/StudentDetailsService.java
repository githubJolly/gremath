/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.security.core.authority.SimpleGrantedAuthority
 *  org.springframework.security.core.userdetails.User
 *  org.springframework.security.core.userdetails.UserDetails
 *  org.springframework.security.core.userdetails.UserDetailsService
 *  org.springframework.security.core.userdetails.UsernameNotFoundException
 *  org.springframework.stereotype.Service
 */
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
public class StudentDetailsService
implements UserDetailsService {
    private final StudentRepository studentRepository;

    public StudentDetailsService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student = this.studentRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("No student found with username: " + username));
        return new User(student.getUsername(), student.getPassword(), List.of(new SimpleGrantedAuthority(student.getRole())));
    }
}

