package com.gremath.content;

import com.gremath.curriculum.NzCurriculumCatalog;
import com.gremath.curriculum.NzLessonSpec;
import com.gremath.curriculum.NzSubject;
import com.gremath.model.Lesson;
import com.gremath.model.Topic;

import java.util.List;

/**
 * Year 7 Mathematics and Statistics — detailed NZC 2025 Phase 3 lessons (slug preserved).
 */
public class Class7NzMathematicsContent implements TopicContent {
    @Override
    public Topic build() {
        Topic t = new Topic(
                "class7-nz-mathematics",
                "Year 7 Mathematics and Statistics",
                NzCurriculumCatalog.topicDescription(7, NzSubject.MATHEMATICS),
                "CLASS7_NZ",
                4
        );
        for (NzLessonSpec spec : NzCurriculumCatalog.lessons(7, NzSubject.MATHEMATICS)) {
            t.addLesson(new Lesson(spec.title(), spec.contentHtml(), spec.order(), spec.practiceKey(), spec.wordStrategy()));
        }
        t.addQuestion(Doc.q(
                "What is 10^3?",
                List.of("30", "100", "1,000", "10,000"),
                2,
                "10^3 = 10×10×10 = 1,000.",
                "EASY"
        ));
        t.addQuestion(Doc.q(
                "Using GEMA, evaluate 2 + 3 × 4.",
                List.of("20", "14", "9", "24"),
                1,
                "Multiplication before addition: 3×4 = 12, then 2+12 = 14.",
                "EASY"
        ));
        t.addQuestion(Doc.q(
                "Solve 3x − 4 = 11.",
                List.of("x = 5", "x = 3", "x = 7", "x = 15"),
                0,
                "3x = 15 → x = 5.",
                "MEDIUM"
        ));
        t.addQuestion(Doc.q(
                "A fair spinner has 5 equal sections; 2 are red. Theoretical P(red) is:",
                List.of("2/5", "3/5", "2/3", "5/2"),
                0,
                "Favourable 2 out of 5 equally likely outcomes.",
                "EASY"
        ));
        return t;
    }
}
