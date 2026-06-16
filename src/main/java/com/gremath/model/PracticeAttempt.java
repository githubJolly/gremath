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
 *  jakarta.persistence.Table
 */
package com.gremath.model;

import com.gremath.model.AttemptAnswer;
import com.gremath.model.Student;
import com.gremath.model.Topic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="practice_attempts")
public class PracticeAttempt {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="student_id")
    private Student student;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="topic_id")
    private Topic topic;
    private int score;
    private int totalQuestions;
    private LocalDateTime takenAt = LocalDateTime.now();
    @OneToMany(mappedBy="attempt", cascade={CascadeType.ALL}, orphanRemoval=true)
    private List<AttemptAnswer> answers = new ArrayList<AttemptAnswer>();

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

    public Topic getTopic() {
        return this.topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
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

    public List<AttemptAnswer> getAnswers() {
        return this.answers;
    }

    public void setAnswers(List<AttemptAnswer> answers) {
        this.answers = answers;
    }

    public void addAnswer(AttemptAnswer answer) {
        answer.setAttempt(this);
        this.answers.add(answer);
    }

    public int getPercentage() {
        if (this.totalQuestions == 0) {
            return 0;
        }
        return Math.round((float)this.score * 100.0f / (float)this.totalQuestions);
    }
}

