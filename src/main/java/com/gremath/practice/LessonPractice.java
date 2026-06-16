/*
 * Decompiled with CFR 0.152.
 */
package com.gremath.practice;

import com.gremath.practice.GeneratedQuestion;
import com.gremath.practice.QuestionTemplate;
import com.gremath.practice.SheetType;
import java.util.ArrayList;
import java.util.List;

public class LessonPractice {
    private final String key;
    private final String topicSlug;
    private final String lessonTitle;
    private final List<QuestionTemplate> conceptTemplates = new ArrayList<QuestionTemplate>();
    private final List<QuestionTemplate> wordTemplates = new ArrayList<QuestionTemplate>();
    private final List<GeneratedQuestion> classicConcept = new ArrayList<GeneratedQuestion>();
    private final List<GeneratedQuestion> classicWord = new ArrayList<GeneratedQuestion>();
    private int conceptSheets = 20;
    private int wordSheets = 10;
    private int questionsPerSheet = 20;

    public LessonPractice(String key, String topicSlug, String lessonTitle) {
        this.key = key;
        this.topicSlug = topicSlug;
        this.lessonTitle = lessonTitle;
    }

    public LessonPractice concept(QuestionTemplate ... templates) {
        for (QuestionTemplate t : templates) {
            this.conceptTemplates.add(t);
        }
        return this;
    }

    public LessonPractice word(QuestionTemplate ... templates) {
        for (QuestionTemplate t : templates) {
            this.wordTemplates.add(t);
        }
        return this;
    }

    public LessonPractice classicConcept(GeneratedQuestion ... questions) {
        for (GeneratedQuestion q : questions) {
            this.classicConcept.add(q);
        }
        return this;
    }

    public LessonPractice classicWord(GeneratedQuestion ... questions) {
        for (GeneratedQuestion q : questions) {
            this.classicWord.add(q);
        }
        return this;
    }

    public LessonPractice sheets(int conceptSheets, int wordSheets, int questionsPerSheet) {
        this.conceptSheets = conceptSheets;
        this.wordSheets = wordSheets;
        this.questionsPerSheet = questionsPerSheet;
        return this;
    }

    public List<QuestionTemplate> templates(SheetType type) {
        return type == SheetType.WORD ? this.wordTemplates : this.conceptTemplates;
    }

    public List<GeneratedQuestion> classics(SheetType type) {
        return type == SheetType.WORD ? this.classicWord : this.classicConcept;
    }

    public String getKey() {
        return this.key;
    }

    public String getTopicSlug() {
        return this.topicSlug;
    }

    public String getLessonTitle() {
        return this.lessonTitle;
    }

    public int getConceptSheets() {
        return this.conceptSheets;
    }

    public int getWordSheets() {
        return this.wordSheets;
    }

    public int getQuestionsPerSheet() {
        return this.questionsPerSheet;
    }

    public int sheetCount(SheetType type) {
        return type == SheetType.WORD ? this.wordSheets : this.conceptSheets;
    }
}

