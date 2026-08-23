/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Service
 */
package com.gremath.practice;

import com.gremath.practice.GeneratedQuestion;
import com.gremath.practice.LessonPractice;
import com.gremath.practice.PracticeRegistry;
import com.gremath.practice.QuestionTemplate;
import com.gremath.practice.SheetRef;
import com.gremath.practice.SheetType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class SheetService {
    private final PracticeRegistry registry;

    public SheetService(PracticeRegistry registry) {
        this.registry = registry;
    }

    public boolean hasPractice(String key) {
        return this.registry.has(key);
    }

    public List<SheetRef> sheetRefs(String key, SheetType type) {
        LessonPractice lp = this.registry.get(key);
        ArrayList<SheetRef> refs = new ArrayList<SheetRef>();
        if (!lp.classics(type).isEmpty()) {
            refs.add(new SheetRef(type, 0, type == SheetType.WORD ? "Classic word problems" : "Classic exam-style", lp.classics(type).size(), true));
        }
        String word = type == SheetType.WORD ? "Word-Problem Sheet" : "Practice Sheet";
        for (int n = 1; n <= lp.sheetCount(type); ++n) {
            refs.add(new SheetRef(type, n, word + " " + n, lp.getQuestionsPerSheet(), false));
        }
        return refs;
    }

    public List<GeneratedQuestion> buildSheet(String key, SheetType type, int number) {
        LessonPractice lp = this.registry.get(key);
        if (number == 0) {
            return new ArrayList<GeneratedQuestion>(lp.classics(type));
        }
        List<QuestionTemplate> templates = lp.templates(type);
        if (templates.isEmpty()) {
            return new ArrayList<GeneratedQuestion>(lp.classics(type));
        }
        int target = lp.getQuestionsPerSheet();
        Random rng = new Random(this.seed(key, type, number));
        ArrayList<QuestionTemplate> pool = new ArrayList<QuestionTemplate>(templates);
        Collections.shuffle(pool, rng);
        ArrayList<GeneratedQuestion> out = new ArrayList<GeneratedQuestion>();
        HashSet<String> seenExact = new HashSet<String>();
        HashSet<String> seenShape = new HashSet<String>();
        int index = 0;
        int safetyLimit = target * 40;
        for (int safety = 0; out.size() < target && safety < safetyLimit; ++safety) {
            QuestionTemplate template = pool.get(index % pool.size());
            GeneratedQuestion q = template.generate(rng);
            String shape = fingerprint(q.getText());
            boolean uniqueExact = seenExact.add(q.getText());
            boolean uniqueShape = shape.length() < 12 || seenShape.size() >= pool.size() || seenShape.add(shape);
            if (uniqueExact && uniqueShape) {
                out.add(q);
            }
            ++index;
            if (index % pool.size() == 0) {
                Collections.shuffle(pool, rng);
            }
        }
        return out;
    }

    /** Same wording with different numbers counts as the same question shape. */
    public static String fingerprint(String text) {
        if (text == null) {
            return "";
        }
        return text.replaceAll("(?is)<svg.*?</svg>", " ")
                .replaceAll("<[^>]+>", " ")
                .replaceAll("\\d+", "#")
                .replaceAll("[^a-zA-Z# ]", " ")
                .replaceAll("\\s+", " ")
                .trim()
                .toLowerCase();
    }

    public String lessonTitle(String key) {
        return this.registry.get(key).getLessonTitle();
    }

    public String topicSlug(String key) {
        return this.registry.get(key).getTopicSlug();
    }

    private long seed(String key, SheetType type, int number) {
        return (key + "|" + type.name() + "|" + number).hashCode();
    }
}

