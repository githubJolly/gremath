/*
 * Decompiled with CFR 0.152.
 */
package com.gremath.practice;

import com.gremath.practice.GeneratedQuestion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;

public final class QBuilder {
    private QBuilder() {
    }

    public static GeneratedQuestion build(Random rng, String text, String correct, List<String> distractors, String explanation, String difficulty, String tag) {
        LinkedHashSet<String> opts = new LinkedHashSet<String>();
        opts.add(correct);
        for (String d : distractors) {
            if (opts.size() >= 4) break;
            opts.add(d);
        }
        ArrayList<String> optionList = new ArrayList<String>(opts);
        Collections.shuffle(optionList, rng);
        int correctIndex = optionList.indexOf(correct);
        return new GeneratedQuestion(text, optionList, correctIndex, explanation, difficulty, tag);
    }

    public static GeneratedQuestion build(Random rng, String text, String correct, String explanation, String difficulty, String tag, String ... distractors) {
        return QBuilder.build(rng, text, correct, List.of(distractors), explanation, difficulty, tag);
    }

    public static int range(Random rng, int min, int max) {
        return min + rng.nextInt(max - min + 1);
    }

    @SafeVarargs
    public static <T> T pick(Random rng, T ... choices) {
        return choices[rng.nextInt(choices.length)];
    }
}

