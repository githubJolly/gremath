/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Controller
 *  org.springframework.ui.Model
 *  org.springframework.web.bind.annotation.GetMapping
 *  org.springframework.web.bind.annotation.PathVariable
 */
package com.gremath.controller;

import com.gremath.content.Enrich;
import com.gremath.model.Lesson;
import com.gremath.model.Topic;
import com.gremath.service.TopicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TopicController {
    private final TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping(value={"/topics/{slug}"})
    public String topic(@PathVariable String slug, Model model) {
        Topic topic = this.topicService.getBySlug(slug);
        for (Lesson lesson : topic.getLessons()) {
            lesson.setContent(Enrich.normalizeLessonContent(lesson.getTitle(), lesson.getOrderIndex(), lesson.getContent()));
        }
        model.addAttribute("topic", (Object)topic);
        return "topic";
    }
}

