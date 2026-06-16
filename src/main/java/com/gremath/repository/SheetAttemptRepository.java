/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.data.jpa.repository.JpaRepository
 */
package com.gremath.repository;

import com.gremath.model.SheetAttempt;
import com.gremath.model.Student;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SheetAttemptRepository
extends JpaRepository<SheetAttempt, Long> {
    public List<SheetAttempt> findByStudentOrderByTakenAtDesc(Student var1);
}

