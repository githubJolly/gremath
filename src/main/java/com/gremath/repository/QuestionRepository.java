/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.data.jpa.repository.JpaRepository
 */
package com.gremath.repository;

import com.gremath.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository
extends JpaRepository<Question, Long> {
}

