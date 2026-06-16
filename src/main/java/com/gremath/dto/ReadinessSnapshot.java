/*
 * Decompiled with CFR 0.152.
 */
package com.gremath.dto;

public class ReadinessSnapshot {
    private final int greProbability;
    private final int catProbability;
    private final int readinessScore;
    private final int confidence;
    private final int attemptsUsed;
    private final int averageScore;
    private final int recentScore;
    private final int accuracyComponent;
    private final int consistencyComponent;
    private final int completionComponent;
    private final String band;

    public ReadinessSnapshot(int greProbability, int catProbability, int readinessScore, int confidence, int attemptsUsed, int averageScore, int recentScore, int accuracyComponent, int consistencyComponent, int completionComponent, String band) {
        this.greProbability = greProbability;
        this.catProbability = catProbability;
        this.readinessScore = readinessScore;
        this.confidence = confidence;
        this.attemptsUsed = attemptsUsed;
        this.averageScore = averageScore;
        this.recentScore = recentScore;
        this.accuracyComponent = accuracyComponent;
        this.consistencyComponent = consistencyComponent;
        this.completionComponent = completionComponent;
        this.band = band;
    }

    public int getGreProbability() {
        return this.greProbability;
    }

    public int getCatProbability() {
        return this.catProbability;
    }

    public int getReadinessScore() {
        return this.readinessScore;
    }

    public int getConfidence() {
        return this.confidence;
    }

    public int getAttemptsUsed() {
        return this.attemptsUsed;
    }

    public int getAverageScore() {
        return this.averageScore;
    }

    public int getRecentScore() {
        return this.recentScore;
    }

    public int getAccuracyComponent() {
        return this.accuracyComponent;
    }

    public int getConsistencyComponent() {
        return this.consistencyComponent;
    }

    public int getCompletionComponent() {
        return this.completionComponent;
    }

    public String getBand() {
        return this.band;
    }
}

