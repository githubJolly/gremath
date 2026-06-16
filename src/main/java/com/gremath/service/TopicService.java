/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Service
 *  org.springframework.transaction.annotation.Transactional
 */
package com.gremath.service;

import com.gremath.model.Topic;
import com.gremath.repository.TopicRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TopicService {
    private final TopicRepository topicRepository;

    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @Transactional(readOnly=true)
    public List<Topic> getAllTopics() {
        List<Topic> topics = this.topicRepository.findAllByOrderByOrderIndexAsc();
        topics.forEach(t -> {
            t.getLessons().size();
            t.getQuestions().size();
        });
        return topics;
    }

    @Transactional(readOnly=true)
    public Topic getBySlug(String slug) {
        Topic topic = this.topicRepository.findBySlug(slug).orElseThrow(() -> new IllegalArgumentException("Unknown topic: " + slug));
        topic.getLessons().size();
        topic.getQuestions().forEach(q -> q.getOptions().size());
        return topic;
    }
}

