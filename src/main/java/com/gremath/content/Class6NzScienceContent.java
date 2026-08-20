package com.gremath.content;

import com.gremath.curriculum.NzCurriculumCatalog;
import com.gremath.curriculum.NzLessonSpec;
import com.gremath.curriculum.NzSubject;
import com.gremath.model.Lesson;
import com.gremath.model.Topic;

/**
 * Year 6 Science — detailed NZC lessons (slug preserved).
 */
public class Class6NzScienceContent implements TopicContent {
    @Override
    public Topic build() {
        Topic t = new Topic(
                "class6-nz-science",
                "Year 6 Science",
                NzCurriculumCatalog.topicDescription(6, NzSubject.SCIENCE),
                "CLASS6_NZ",
                3
        );
        for (NzLessonSpec spec : NzCurriculumCatalog.lessons(6, NzSubject.SCIENCE)) {
            t.addLesson(new Lesson(spec.title(), spec.contentHtml(), spec.order(), spec.practiceKey(), spec.wordStrategy()));
        }
        return t;
    }
}
