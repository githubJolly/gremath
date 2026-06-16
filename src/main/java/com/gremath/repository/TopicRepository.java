package com.gremath.repository;

import com.gremath.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TopicRepository extends JpaRepository<Topic, Long> {

    List<Topic> findAllByOrderByOrderIndexAsc();

    Optional<Topic> findBySlug(String slug);
}
