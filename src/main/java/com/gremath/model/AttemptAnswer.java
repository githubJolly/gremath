/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  jakarta.persistence.Entity
 *  jakarta.persistence.FetchType
 *  jakarta.persistence.GeneratedValue
 *  jakarta.persistence.GenerationType
 *  jakarta.persistence.Id
 *  jakarta.persistence.JoinColumn
 *  jakarta.persistence.ManyToOne
 *  jakarta.persistence.Table
 */
package com.gremath.model;

import com.gremath.model.PracticeAttempt;
import com.gremath.model.Question;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="attempt_answers")
public class AttemptAnswer {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="attempt_id")
    private PracticeAttempt attempt;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="question_id")
    private Question question;
    private int selectedOption;
    private boolean correct;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PracticeAttempt getAttempt() {
        return this.attempt;
    }

    public void setAttempt(PracticeAttempt attempt) {
        this.attempt = attempt;
    }

    public Question getQuestion() {
        return this.question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public int getSelectedOption() {
        return this.selectedOption;
    }

    public void setSelectedOption(int selectedOption) {
        this.selectedOption = selectedOption;
    }

    public boolean isCorrect() {
        return this.correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}

