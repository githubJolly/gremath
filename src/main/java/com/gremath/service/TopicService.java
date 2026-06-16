package com.gremath.service;

import com.gremath.model.Topic;
import com.gremath.repository.TopicRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TopicService {

    private final TopicRepository topicRepository;

    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @Transactional(readOnly = true)
    public List<Topic> getAllTopics() {
        List<Topic> topics = topicRepository.findAllByOrderByOrderIndexAsc();
        // Initialise lazy collections so the view can read their sizes.
        topics.forEach(t -> {
            t.getLessons().size();
            t.getQuestions().size();
        });
        return topics;
    }

    @Transactional(readOnly = true)
    public Topic getBySlug(String slug) {
        Topic topic = topicRepository.findBySlug(slug)
                .orElseThrow(() -> new IllegalArgumentException("Unknown topic: " + slug));
        topic.getLessons().size();
        topic.getQuestions().forEach(q -> q.getOptions().size());
        return topic;
    }
}
