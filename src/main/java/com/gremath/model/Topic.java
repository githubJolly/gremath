/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  jakarta.persistence.CascadeType
 *  jakarta.persistence.Column
 *  jakarta.persistence.Entity
 *  jakarta.persistence.GeneratedValue
 *  jakarta.persistence.GenerationType
 *  jakarta.persistence.Id
 *  jakarta.persistence.OneToMany
 *  jakarta.persistence.OrderBy
 *  jakarta.persistence.Table
 */
package com.gremath.model;

import com.gremath.model.Lesson;
import com.gremath.model.Question;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="topics")
public class Topic {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false, unique=true)
    private String slug;
    @Column(nullable=false)
    private String name;
    @Column(length=1000)
    private String description;
    private String examType = "BOTH";
    private int orderIndex;
    @OneToMany(mappedBy="topic", cascade={CascadeType.ALL}, orphanRemoval=true)
    @OrderBy(value="orderIndex ASC")
    private List<Lesson> lessons = new ArrayList<Lesson>();
    @OneToMany(mappedBy="topic", cascade={CascadeType.ALL}, orphanRemoval=true)
    private List<Question> questions = new ArrayList<Question>();

    public Topic() {
    }

    public Topic(String slug, String name, String description, String examType, int orderIndex) {
        this.slug = slug;
        this.name = name;
        this.description = description;
        this.examType = examType;
        this.orderIndex = orderIndex;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSlug() {
        return this.slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExamType() {
        return this.examType;
    }

    public void setExamType(String examType) {
        this.examType = examType;
    }

    public int getOrderIndex() {
        return this.orderIndex;
    }

    public void setOrderIndex(int orderIndex) {
        this.orderIndex = orderIndex;
    }

    public List<Lesson> getLessons() {
        return this.lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public List<Question> getQuestions() {
        return this.questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public void addLesson(Lesson lesson) {
        lesson.setTopic(this);
        this.lessons.add(lesson);
    }

    public void addQuestion(Question question) {
        question.setTopic(this);
        this.questions.add(question);
    }
}

