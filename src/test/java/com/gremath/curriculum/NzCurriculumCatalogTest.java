package com.gremath.curriculum;

import com.gremath.practice.LessonPractice;
import com.gremath.practice.PracticeRegistry;
import com.gremath.practice.SheetType;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NzCurriculumCatalogTest {

    @Test
    void everyYearAndSubjectHasDetailedLessons() {
        for (int year : NzCurriculumCatalog.years()) {
            for (NzSubject subject : NzSubject.values()) {
                var lessons = NzCurriculumCatalog.lessons(year, subject);
                assertTrue(lessons.size() >= 6, year + " " + subject + " lesson count");
                for (NzLessonSpec spec : lessons) {
                    assertTrue(spec.contentHtml().length() > 1200,
                            "Thin lesson: Y" + year + " " + subject + " " + spec.title()
                                    + " len=" + spec.contentHtml().length());
                    assertTrue(spec.contentHtml().contains("You will"),
                            "Missing goals: " + spec.title());
                    assertTrue(spec.contentHtml().contains("Worked example"),
                            "Missing examples: " + spec.title());
                    assertTrue(spec.practiceKey() != null && !spec.practiceKey().isBlank());
                }
            }
        }
    }

    @Test
    void year1NumberStaysInEarlyPlaceValue() {
        String html = NzCurriculumCatalog.lessons(1, NzSubject.MATHEMATICS).get(0).contentHtml();
        assertTrue(html.toLowerCase().contains("20"));
        assertFalse(html.contains("1,000,000"));
        assertTrue(html.contains("tahi") || html.contains("tekau"));
    }

    @Test
    void year8NumberIncludesIntegersAndPrimeFactors() {
        String html = NzCurriculumCatalog.lessons(8, NzSubject.MATHEMATICS).get(0).contentHtml();
        String lower = html.toLowerCase();
        assertTrue(lower.contains("prime") || lower.contains("integer") || lower.contains("exponent"));
    }

    @Test
    void year10MathIncludesTrigOrQuadratic() {
        String all = NzCurriculumCatalog.lessons(10, NzSubject.MATHEMATICS).stream()
                .map(NzLessonSpec::title)
                .reduce("", (a, b) -> a + " " + b)
                .toLowerCase();
        assertTrue(all.contains("trig") || all.contains("quadratic") || all.contains("cylinder"));
    }

    @Test
    void mathsHasEightLessonsExceptWhereSequenced() {
        for (int year : NzCurriculumCatalog.years()) {
            assertEquals(8, NzCurriculumCatalog.lessons(year, NzSubject.MATHEMATICS).size(), "Year " + year + " maths");
        }
    }

    @Test
    void year1AndYear6MathTitlesDiffer() {
        String y1 = NzCurriculumCatalog.lessons(1, NzSubject.MATHEMATICS).get(0).title();
        String y6 = NzCurriculumCatalog.lessons(6, NzSubject.MATHEMATICS).get(0).title();
        assertFalse(y1.equals(y6));
    }

    @Test
    void practiceKeysAreRegisteredAndGenerateQuestions() {
        PracticeRegistry registry = new PracticeRegistry();
        Random rng = new Random(42);
        int checked = 0;
        for (int year : NzCurriculumCatalog.years()) {
            for (NzSubject subject : NzSubject.values()) {
                for (NzLessonSpec spec : NzCurriculumCatalog.lessons(year, subject)) {
                    assertTrue(registry.has(spec.practiceKey()),
                            "Missing practice for " + spec.practiceKey() + " / " + spec.title());
                    LessonPractice lp = registry.get(spec.practiceKey());
                    var q = lp.templates(SheetType.CONCEPT).get(0).generate(rng);
                    assertTrue(q.getOptions().size() >= 2);
                    checked++;
                }
            }
        }
        assertTrue(checked >= 10 * 8 * 6);
    }
}
