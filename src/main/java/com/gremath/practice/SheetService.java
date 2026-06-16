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
        ArrayList<GeneratedQuestion> out = new ArrayList<GeneratedQuestion>();
        HashSet<String> seenText = new HashSet<String>();
        int index = 0;
        int safetyLimit = target * 25;
        for (int safety = 0; out.size() < target && safety < safetyLimit; ++safety) {
            QuestionTemplate template = templates.get(index % templates.size());
            GeneratedQuestion q = template.generate(rng);
            if (seenText.add(q.getText())) {
                out.add(q);
            }
            ++index;
        }
        return out;
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

