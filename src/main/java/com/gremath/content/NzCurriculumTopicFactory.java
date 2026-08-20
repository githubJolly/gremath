package com.gremath.content;

import com.gremath.curriculum.NzCurriculumCatalog;
import com.gremath.curriculum.NzLessonSpec;
import com.gremath.curriculum.NzSubject;
import com.gremath.model.Lesson;
import com.gremath.model.Topic;

import java.util.ArrayList;
import java.util.List;

/**
 * Builds a Topic for any generated NZ year × subject cell.
 */
public final class NzCurriculumTopicFactory implements TopicContent {
    private final int year;
    private final NzSubject subject;

    public NzCurriculumTopicFactory(int year, NzSubject subject) {
        this.year = year;
        this.subject = subject;
    }

    public static List<TopicContent> allGenerated() {
        List<TopicContent> out = new ArrayList<>();
        for (int year : NzCurriculumCatalog.years()) {
            for (NzSubject subject : NzSubject.values()) {
                if (!NzCurriculumCatalog.isHandcrafted(year, subject)) {
                    out.add(new NzCurriculumTopicFactory(year, subject));
                }
            }
        }
        return out;
    }

    @Override
    public Topic build() {
        Topic topic = new Topic(
                NzCurriculumCatalog.topicSlug(year, subject),
                NzCurriculumCatalog.topicName(year, subject),
                NzCurriculumCatalog.topicDescription(year, subject),
                NzCurriculumCatalog.examType(year),
                year * 10 + subject.ordinal()
        );
        for (NzLessonSpec spec : NzCurriculumCatalog.lessons(year, subject)) {
            topic.addLesson(new Lesson(
                    spec.title(),
                    spec.contentHtml(),
                    spec.order(),
                    spec.practiceKey(),
                    spec.wordStrategy()
            ));
        }
        return topic;
    }
}
