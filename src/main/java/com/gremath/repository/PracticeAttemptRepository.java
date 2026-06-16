/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.data.jpa.repository.JpaRepository
 */
package com.gremath.repository;

import com.gremath.model.PracticeAttempt;
import com.gremath.model.Student;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PracticeAttemptRepository
extends JpaRepository<PracticeAttempt, Long> {
    public List<PracticeAttempt> findByStudentOrderByTakenAtDesc(Student var1);

    public long countByStudent(Student var1);
}

