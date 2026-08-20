package com.gremath.config;

import com.gremath.content.AlgebraContent;
import com.gremath.content.AveragesContent;
import com.gremath.content.Class6NzEnglishContent;
import com.gremath.content.Class6NzMathematicsContent;
import com.gremath.content.Class6NzScienceContent;
import com.gremath.content.Class7NzMathematicsContent;
import com.gremath.content.CountingContent;
import com.gremath.content.NzCurriculumTopicFactory;
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
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Configuration
public class DataInitializer {

    private static final Logger log = LoggerFactory.getLogger(DataInitializer.class);

    private static final List<TopicContent> CONTENT = buildContentList();

    private static List<TopicContent> buildContentList() {
        List<TopicContent> all = new ArrayList<>();
        all.add(new NumberPropertiesContent());
        all.add(new PercentagesContent());
        all.add(new RatiosContent());
        all.add(new AveragesContent());
        all.add(new AlgebraContent());
        all.add(new GeometryContent());
        all.add(new TimeSpeedDistanceContent());
        all.add(new CountingContent());
        all.add(new ProbabilityContent());
        all.add(new ProfitInterestContent());
        all.add(new Class6NzMathematicsContent());
        all.add(new Class6NzEnglishContent());
        all.add(new Class6NzScienceContent());
        all.add(new Class7NzMathematicsContent());
        all.addAll(NzCurriculumTopicFactory.allGenerated());
        return List.copyOf(all);
    }

    @Bean
    CommandLineRunner seedData(TopicRepository topicRepository, LessonRepository lessonRepository,
                               PlatformTransactionManager transactionManager) {
        TransactionTemplate tx = new TransactionTemplate(transactionManager);
        return args -> {
            Long count = tx.execute(status -> topicRepository.count());
            if (count == null || count == 0L) {
                log.info("Seeding initial topic and lesson content.");
                for (TopicContent content : CONTENT) {
                    tx.executeWithoutResult(status -> topicRepository.save(content.build()));
                }
                log.info("Finished seeding {} topics.", CONTENT.size());
                return;
            }

            int added = 0;
            int updated = 0;
            Map<String, Topic> existingBySlug = tx.execute(status -> {
                Map<String, Topic> map = new HashMap<>();
                for (Topic t : topicRepository.findAll()) {
                    t.getLessons().size();
                    map.put(t.getSlug(), t);
                }
                return map;
            });
            if (existingBySlug == null) {
                existingBySlug = new HashMap<>();
            }

            boolean practiceMissing = tx.execute(status -> {
                List<Lesson> lessons = lessonRepository.findAll();
                return lessons.isEmpty() || lessons.stream().anyMatch(lesson -> !lesson.hasPractice());
            });

            for (TopicContent content : CONTENT) {
                Topic fresh = content.build();
                Topic existing = existingBySlug.get(fresh.getSlug());
                if (existing == null) {
                    tx.executeWithoutResult(status -> topicRepository.save(fresh));
                    added++;
                    continue;
                }
                if (Boolean.TRUE.equals(practiceMissing) || needsSync(existing, fresh)) {
                    tx.executeWithoutResult(status -> {
                        Topic current = topicRepository.findBySlug(fresh.getSlug()).orElse(null);
                        if (current == null) {
                            topicRepository.save(fresh);
                            return;
                        }
                        current.getLessons().size();
                        syncTopicContent(current, fresh);
                        topicRepository.save(current);
                    });
                    updated++;
                }
            }
            if (added > 0 || updated > 0) {
                log.info("Curriculum sync complete: {} topics added, {} updated.", added, updated);
            }
        };
    }

    private boolean needsSync(Topic existing, Topic fresh) {
        if (existing.getLessons().size() != fresh.getLessons().size()) {
            return true;
        }
        if (!java.util.Objects.equals(existing.getName(), fresh.getName())
                || !java.util.Objects.equals(existing.getExamType(), fresh.getExamType())) {
            return true;
        }
        Map<Integer, Lesson> existingByOrder = new HashMap<>();
        for (Lesson l : existing.getLessons()) {
            existingByOrder.put(l.getOrderIndex(), l);
        }
        for (Lesson fl : fresh.getLessons()) {
            Lesson el = existingByOrder.get(fl.getOrderIndex());
            if (el == null) {
                return true;
            }
            if (!java.util.Objects.equals(el.getTitle(), fl.getTitle())) {
                return true;
            }
            if (!java.util.Objects.equals(el.getPracticeKey(), fl.getPracticeKey())) {
                return true;
            }
        }
        return false;
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
