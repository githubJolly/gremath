package com.gremath.content;

import com.gremath.curriculum.NzCurriculumCatalog;
import com.gremath.curriculum.NzLessonSpec;
import com.gremath.curriculum.NzSubject;
import com.gremath.model.Lesson;
import com.gremath.model.Topic;

import java.util.List;

/**
 * Year 6 Mathematics and Statistics — detailed NZC 2025 lessons (slug preserved).
 */
public class Class6NzMathematicsContent implements TopicContent {
    @Override
    public Topic build() {
        Topic t = new Topic(
                "class6-nz-mathematics",
                "Year 6 Mathematics and Statistics",
                NzCurriculumCatalog.topicDescription(6, NzSubject.MATHEMATICS),
                "CLASS6_NZ",
                1
        );
        for (NzLessonSpec spec : NzCurriculumCatalog.lessons(6, NzSubject.MATHEMATICS)) {
            t.addLesson(new Lesson(spec.title(), spec.contentHtml(), spec.order(), spec.practiceKey(), spec.wordStrategy()));
        }
        t.addQuestion(Doc.q(
                "Which number is greater?",
                List.of("48,029", "48,209", "They are equal", "Cannot be compared"),
                1,
                "Compare place value from left to right. The hundreds digit decides this one.",
                "EASY"
        ));
        t.addQuestion(Doc.q(
                "Which is equivalent to 1/4?",
                List.of("0.4", "25%", "40%", "2/5"),
                1,
                "One-quarter equals 0.25 which is 25%.",
                "EASY"
        ));
        t.addQuestion(Doc.q(
                "How many millilitres are in 1.5 litres?",
                List.of("150", "1500", "1050", "15,000"),
                1,
                "1 litre = 1000 mL, so 1.5 L = 1500 mL.",
                "MEDIUM"
        ));
        t.addQuestion(Doc.q(
                "A pattern goes 5, 9, 13, 17, ... What is the next term?",
                List.of("19", "20", "21", "22"),
                2,
                "The pattern adds 4 each step, so after 17 comes 21.",
                "EASY"
        ));
        return t;
    }
}
