package com.gremath.config;

import com.gremath.content.AlgebraContent;
import com.gremath.content.AveragesContent;
import com.gremath.content.CountingContent;
import com.gremath.content.GeometryContent;
import com.gremath.content.NumberPropertiesContent;
import com.gremath.content.PercentagesContent;
import com.gremath.content.ProbabilityContent;
import com.gremath.content.ProfitInterestContent;
import com.gremath.content.RatiosContent;
import com.gremath.content.TimeSpeedDistanceContent;
import com.gremath.content.TopicContent;
import com.gremath.model.Lesson;
import com.gremath.model.Topic;
import com.gremath.repository.LessonRepository;
import com.gremath.repository.TopicRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Configuration
public class DataInitializer {

    private static final Logger log = LoggerFactory.getLogger(DataInitializer.class);

    private static final List<TopicContent> CONTENT = List.of(
            new NumberPropertiesContent(),
            new PercentagesContent(),
            new RatiosContent(),
            new AveragesContent(),
            new AlgebraContent(),
            new GeometryContent(),
            new TimeSpeedDistanceContent(),
            new CountingContent(),
            new ProbabilityContent(),
            new ProfitInterestContent());

    @Bean
    @Transactional
    CommandLineRunner seedData(TopicRepository topicRepository, LessonRepository lessonRepository) {
        return args -> {
            if (topicRepository.count() == 0L) {
                log.info("Seeding initial topic and lesson content.");
                seedAll(topicRepository);
                return;
            }

            if (needsContentRefresh(lessonRepository)) {
                log.info("Refreshing topic and lesson content from latest builders.");
                refreshAll(topicRepository);
            }
        };
    }

    private boolean needsContentRefresh(LessonRepository lessonRepository) {
        List<Lesson> lessons = lessonRepository.findAll();
        if (lessons.isEmpty()) {
            return true;
        }
        return lessons.stream().anyMatch(lesson -> !lesson.hasPractice());
    }

    private void seedAll(TopicRepository topicRepository) {
        CONTENT.forEach(content -> topicRepository.save(content.build()));
    }

    private void refreshAll(TopicRepository topicRepository) {
        Map<String, Topic> freshBySlug = new HashMap<>();
        for (TopicContent content : CONTENT) {
            freshBySlug.put(content.build().getSlug(), content.build());
        }

        for (Topic existing : topicRepository.findAll()) {
            Topic fresh = freshBySlug.get(existing.getSlug());
            if (fresh == null) {
                continue;
            }
            syncTopicContent(existing, fresh);
            topicRepository.save(existing);
        }

        Set<String> existingSlugs = topicRepository.findAll().stream()
                .map(Topic::getSlug)
                .collect(java.util.stream.Collectors.toSet());
        for (Topic fresh : freshBySlug.values()) {
            if (!existingSlugs.contains(fresh.getSlug())) {
                topicRepository.save(fresh);
            }
        }
    }

    private void syncTopicContent(Topic existing, Topic fresh) {
        existing.setName(fresh.getName());
        existing.setDescription(fresh.getDescription());
        existing.setExamType(fresh.getExamType());
        existing.setOrderIndex(fresh.getOrderIndex());

        Map<Integer, Lesson> freshByOrder = new HashMap<>();
        for (Lesson lesson : fresh.getLessons()) {
            freshByOrder.put(lesson.getOrderIndex(), lesson);
        }

        Set<Integer> syncedOrders = new HashSet<>();
        for (Lesson existingLesson : new ArrayList<>(existing.getLessons())) {
            Lesson source = freshByOrder.get(existingLesson.getOrderIndex());
            if (source == null) {
                existing.getLessons().remove(existingLesson);
                continue;
            }
            copyLessonFields(existingLesson, source);
            syncedOrders.add(existingLesson.getOrderIndex());
        }

        for (Lesson source : fresh.getLessons()) {
            if (!syncedOrders.contains(source.getOrderIndex())) {
                existing.addLesson(new Lesson(
                        source.getTitle(),
                        source.getContent(),
                        source.getOrderIndex(),
                        source.getPracticeKey(),
                        source.getWordStrategy()));
            }
        }
    }

    private void copyLessonFields(Lesson target, Lesson source) {
        target.setTitle(source.getTitle());
        target.setContent(source.getContent());
        target.setOrderIndex(source.getOrderIndex());
        target.setPracticeKey(source.getPracticeKey());
        target.setWordStrategy(source.getWordStrategy());
    }
}
