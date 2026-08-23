package com.gremath.service;

import com.gremath.dto.ParentProgressSnapshot;
import com.gremath.dto.SubjectScore;
import com.gremath.model.SheetAttempt;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ParentProgressServiceTest {

    @Test
    void groupsAveragesBySubjectAndKeepsLatestLesson() {
        SheetAttempt mathsEarly = attempt("nz-6-mathematics", "nz-6-math-fractions", "Fractions", 8, 10, LocalDateTime.now().minusDays(1));
        SheetAttempt mathsLater = attempt("nz-6-mathematics", "nz-6-math-decimals", "Decimals", 6, 10, LocalDateTime.now());
        SheetAttempt english = attempt("nz-6-english", "nz-6-eng-narrative", "Narrative writing", 5, 10, LocalDateTime.now());

        ParentProgressSnapshot snap = new ParentProgressService().build(List.of(mathsEarly, mathsLater, english));

        assertEquals(2, snap.getSubjectScores().size());
        SubjectScore maths = snap.getSubjectScores().stream()
                .filter(s -> "Mathematics".equals(s.getSubject()))
                .findFirst()
                .orElseThrow();
        assertEquals(70, maths.getAveragePercent());
        assertEquals(2, maths.getSessions());
        assertEquals("Decimals", maths.getLatestLesson());
        assertEquals(2, snap.getFocusAreasCount());
        assertTrue(snap.getSummary().contains("Focus this week"));
    }

    @Test
    void labelsKnownLearningAreas() {
        assertEquals("Science", ParentProgressService.subjectLabel("nz-8-science"));
        assertEquals("Social Sciences", ParentProgressService.subjectLabel("year-4-social-sciences"));
        assertEquals("Health and PE", ParentProgressService.subjectLabel("nz-3-health-pe"));
        assertEquals("Other", ParentProgressService.subjectLabel("unknown"));
    }

    private static SheetAttempt attempt(String slug, String lessonKey, String title, int score, int total, LocalDateTime takenAt) {
        SheetAttempt a = new SheetAttempt();
        a.setTopicSlug(slug);
        a.setLessonKey(lessonKey);
        a.setLessonTitle(title);
        a.setScore(score);
        a.setTotalQuestions(total);
        a.setTakenAt(takenAt);
        return a;
    }
}
