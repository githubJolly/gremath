/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.data.jpa.repository.JpaRepository
 */
package com.gremath.repository;

import com.gremath.model.Student;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository
extends JpaRepository<Student, Long> {
    public Optional<Student> findByUsername(String var1);

    public boolean existsByUsername(String var1);

    public boolean existsByEmail(String var1);
}

