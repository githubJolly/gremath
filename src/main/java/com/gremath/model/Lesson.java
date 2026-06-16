/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  jakarta.persistence.Column
 *  jakarta.persistence.Entity
 *  jakarta.persistence.FetchType
 *  jakarta.persistence.GeneratedValue
 *  jakarta.persistence.GenerationType
 *  jakarta.persistence.Id
 *  jakarta.persistence.JoinColumn
 *  jakarta.persistence.Lob
 *  jakarta.persistence.ManyToOne
 *  jakarta.persistence.Table
 */
package com.gremath.model;

import com.gremath.model.Topic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="lessons")
public class Lesson {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false)
    private String title;
    @Lob
    @Column(nullable=false, length=20000)
    private String content;
    private int orderIndex;
    private String practiceKey;
    @Lob
    @Column(length=20000)
    private String wordStrategy;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="topic_id")
    private Topic topic;

    public Lesson() {
    }

    public Lesson(String title, String content, int orderIndex) {
        this.title = title;
        this.content = content;
        this.orderIndex = orderIndex;
    }

    public Lesson(String title, String content, int orderIndex, String practiceKey, String wordStrategy) {
        this.title = title;
        this.content = content;
        this.orderIndex = orderIndex;
        this.practiceKey = practiceKey;
        this.wordStrategy = wordStrategy;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getOrderIndex() {
        return this.orderIndex;
    }

    public void setOrderIndex(int orderIndex) {
        this.orderIndex = orderIndex;
    }

    public String getPracticeKey() {
        return this.practiceKey;
    }

    public void setPracticeKey(String practiceKey) {
        this.practiceKey = practiceKey;
    }

    public String getWordStrategy() {
        return this.wordStrategy;
    }

    public void setWordStrategy(String wordStrategy) {
        this.wordStrategy = wordStrategy;
    }

    public boolean hasPractice() {
        return this.practiceKey != null && !this.practiceKey.isBlank();
    }

    public Topic getTopic() {
        return this.topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}

