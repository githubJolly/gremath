/*
 * Decompiled with CFR 0.152.
 */
package com.gremath.practice;

import com.gremath.practice.GeneratedQuestion;
import java.util.Random;

@FunctionalInterface
public interface QuestionTemplate {
    public GeneratedQuestion generate(Random var1);
}

