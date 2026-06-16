/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.data.jpa.repository.JpaRepository
 */
package com.gremath.repository;

import com.gremath.model.Topic;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository
extends JpaRepository<Topic, Long> {
    public List<Topic> findAllByOrderByOrderIndexAsc();

    public Optional<Topic> findBySlug(String var1);
}

