/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  jakarta.persistence.CollectionTable
 *  jakarta.persistence.Column
 *  jakarta.persistence.ElementCollection
 *  jakarta.persistence.Entity
 *  jakarta.persistence.FetchType
 *  jakarta.persistence.GeneratedValue
 *  jakarta.persistence.GenerationType
 *  jakarta.persistence.Id
 *  jakarta.persistence.JoinColumn
 *  jakarta.persistence.ManyToOne
 *  jakarta.persistence.OrderColumn
 *  jakarta.persistence.Table
 */
package com.gremath.model;

import com.gremath.model.Topic;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="questions")
public class Question {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false, length=2000)
    private String text;
    @ElementCollection(fetch=FetchType.EAGER)
    @CollectionTable(name="question_options", joinColumns={@JoinColumn(name="question_id")})
    @Column(name="option_text", length=1000)
    @OrderColumn(name="option_index")
    private List<String> options = new ArrayList<String>();
    private int correctOption;
    @Column(length=2000)
    private String explanation;
    private String difficulty = "MEDIUM";
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="topic_id")
    private Topic topic;

    public Question() {
    }

    public Question(String text, List<String> options, int correctOption, String explanation, String difficulty) {
        this.text = text;
        this.options = options;
        this.correctOption = correctOption;
        this.explanation = explanation;
        this.difficulty = difficulty;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getOptions() {
        return this.options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public int getCorrectOption() {
        return this.correctOption;
    }

    public void setCorrectOption(int correctOption) {
        this.correctOption = correctOption;
    }

    public String getExplanation() {
        return this.explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getDifficulty() {
        return this.difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public Topic getTopic() {
        return this.topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}

