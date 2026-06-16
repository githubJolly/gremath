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

import com.gremath.model.SheetAttempt;
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
@Table(name="sheet_answers")
public class SheetAnswer {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="attempt_id")
    private SheetAttempt attempt;
    @Column(length=2000)
    private String questionText;
    @ElementCollection(fetch=FetchType.EAGER)
    @CollectionTable(name="sheet_answer_options", joinColumns={@JoinColumn(name="answer_id")})
    @Column(name="option_text", length=1000)
    @OrderColumn(name="option_index")
    private List<String> options = new ArrayList<String>();
    private int correctOption;
    private int selectedOption;
    private boolean correct;
    @Column(length=2000)
    private String explanation;
    private String tag;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SheetAttempt getAttempt() {
        return this.attempt;
    }

    public void setAttempt(SheetAttempt attempt) {
        this.attempt = attempt;
    }

    public String getQuestionText() {
        return this.questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
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

    public String getExplanation() {
        return this.explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}

