/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Component
 */
package com.gremath.practice;

import com.gremath.practice.LessonPractice;
import com.gremath.practice.content.AlgebraPractice;
import com.gremath.practice.content.AveragesPractice;
import com.gremath.practice.content.CountingPractice;
import com.gremath.practice.content.GeometryPractice;
import com.gremath.practice.content.NumberPropertiesPractice;
import com.gremath.practice.content.PercentagesPractice;
import com.gremath.practice.content.ProbabilityPractice;
import com.gremath.practice.content.ProfitInterestPractice;
import com.gremath.practice.content.RatiosPractice;
import com.gremath.practice.content.TimeSpeedDistancePractice;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class PracticeRegistry {
    private final Map<String, LessonPractice> byKey = new LinkedHashMap<String, LessonPractice>();

    public PracticeRegistry() {
        PercentagesPractice.register(this);
        NumberPropertiesPractice.register(this);
        RatiosPractice.register(this);
        AveragesPractice.register(this);
        AlgebraPractice.register(this);
        GeometryPractice.register(this);
        TimeSpeedDistancePractice.register(this);
        CountingPractice.register(this);
        ProbabilityPractice.register(this);
        ProfitInterestPractice.register(this);
    }

    public void add(LessonPractice lessonPractice) {
        this.byKey.put(lessonPractice.getKey(), lessonPractice);
    }

    public LessonPractice get(String key) {
        LessonPractice lp = this.byKey.get(key);
        if (lp == null) {
            throw new IllegalArgumentException("No practice registered for key: " + key);
        }
        return lp;
    }

    public boolean has(String key) {
        return key != null && this.byKey.containsKey(key);
    }
}

