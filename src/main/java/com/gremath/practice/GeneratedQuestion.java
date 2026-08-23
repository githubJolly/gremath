/*
 * Decompiled with CFR 0.152.
 */
package com.gremath.practice;

import java.util.List;

public class GeneratedQuestion {
    private final String text;
    private final List<String> options;
    private final int correctOption;
    private final String explanation;
    private final String difficulty;
    private final String tag;
    private final String hint;

    public GeneratedQuestion(String text, List<String> options, int correctOption, String explanation, String difficulty, String tag) {
        this(text, options, correctOption, explanation, difficulty, tag, null);
    }

    public GeneratedQuestion(String text, List<String> options, int correctOption, String explanation, String difficulty, String tag, String hint) {
        this.text = text;
        this.options = options;
        this.correctOption = correctOption;
        this.explanation = explanation;
        this.difficulty = difficulty;
        this.tag = tag;
        this.hint = hint;
    }

    public GeneratedQuestion withHint(String hint) {
        return new GeneratedQuestion(text, options, correctOption, explanation, difficulty, tag, hint);
    }

    public String getText() {
        return this.text;
    }

    public List<String> getOptions() {
        return this.options;
    }

    public int getCorrectOption() {
        return this.correctOption;
    }

    public String getExplanation() {
        return this.explanation;
    }

    public String getDifficulty() {
        return this.difficulty;
    }

    public String getTag() {
        return this.tag;
    }

    public String getHint() {
        return this.hint;
    }
}

