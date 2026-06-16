/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  jakarta.persistence.CascadeType
 *  jakarta.persistence.Entity
 *  jakarta.persistence.FetchType
 *  jakarta.persistence.GeneratedValue
 *  jakarta.persistence.GenerationType
 *  jakarta.persistence.Id
 *  jakarta.persistence.JoinColumn
 *  jakarta.persistence.ManyToOne
 *  jakarta.persistence.OneToMany
 *  jakarta.persistence.OrderColumn
 *  jakarta.persistence.Table
 */
package com.gremath.model;

import com.gremath.model.SheetAnswer;
import com.gremath.model.Student;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="sheet_attempts")
public class SheetAttempt {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="student_id")
    private Student student;
    private String topicSlug;
    private String lessonKey;
    private String lessonTitle;
    private String sheetType;
    private int sheetNumber;
    private int score;
    private int totalQuestions;
    private LocalDateTime takenAt = LocalDateTime.now();
    @OneToMany(mappedBy="attempt", cascade={CascadeType.ALL}, orphanRemoval=true)
    @OrderColumn(name="position")
    private List<SheetAnswer> answers = new ArrayList<SheetAnswer>();

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getTopicSlug() {
        return this.topicSlug;
    }

    public void setTopicSlug(String topicSlug) {
        this.topicSlug = topicSlug;
    }

    public String getLessonKey() {
        return this.lessonKey;
    }

    public void setLessonKey(String lessonKey) {
        this.lessonKey = lessonKey;
    }

    public String getLessonTitle() {
        return this.lessonTitle;
    }

    public void setLessonTitle(String lessonTitle) {
        this.lessonTitle = lessonTitle;
    }

    public String getSheetType() {
        return this.sheetType;
    }

    public void setSheetType(String sheetType) {
        this.sheetType = sheetType;
    }

    public int getSheetNumber() {
        return this.sheetNumber;
    }

    public void setSheetNumber(int sheetNumber) {
        this.sheetNumber = sheetNumber;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTotalQuestions() {
        return this.totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public LocalDateTime getTakenAt() {
        return this.takenAt;
    }

    public void setTakenAt(LocalDateTime takenAt) {
        this.takenAt = takenAt;
    }

    public List<SheetAnswer> getAnswers() {
        return this.answers;
    }

    public void setAnswers(List<SheetAnswer> answers) {
        this.answers = answers;
    }

    public void addAnswer(SheetAnswer answer) {
        answer.setAttempt(this);
        this.answers.add(answer);
    }

    public int getPercentage() {
        if (this.totalQuestions == 0) {
            return 0;
        }
        return Math.round((float)this.score * 100.0f / (float)this.totalQuestions);
    }

    public String getSheetLabel() {
        String kind;
        String string = kind = "WORD".equals(this.sheetType) ? "Word-Problem Sheet" : "Practice Sheet";
        return this.sheetNumber == 0 ? "Classic " + ("WORD".equals(this.sheetType) ? "word problems" : "exam-style") : kind + " " + this.sheetNumber;
    }
}

