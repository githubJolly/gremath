package com.gremath.content;

import com.gremath.curriculum.NzCurriculumCatalog;
import com.gremath.curriculum.NzLessonSpec;
import com.gremath.curriculum.NzSubject;
import com.gremath.model.Lesson;
import com.gremath.model.Topic;

/**
 * Year 6 English — detailed NZC 2025 lessons (slug preserved).
 */
public class Class6NzEnglishContent implements TopicContent {
    @Override
    public Topic build() {
        Topic t = new Topic(
                "class6-nz-english",
                "Year 6 English",
                NzCurriculumCatalog.topicDescription(6, NzSubject.ENGLISH),
                "CLASS6_NZ",
                2
        );
        for (NzLessonSpec spec : NzCurriculumCatalog.lessons(6, NzSubject.ENGLISH)) {
            t.addLesson(new Lesson(spec.title(), spec.contentHtml(), spec.order(), spec.practiceKey(), spec.wordStrategy()));
        }
        return t;
    }
}
