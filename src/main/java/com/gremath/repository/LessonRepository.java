/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.data.jpa.repository.JpaRepository
 */
package com.gremath.repository;

import com.gremath.model.Lesson;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository
extends JpaRepository<Lesson, Long> {
    public Optional<Lesson> findByPracticeKey(String var1);
}

