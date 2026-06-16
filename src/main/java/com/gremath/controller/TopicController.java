package com.gremath.controller;

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

    @GetMapping("/topics/{slug}")
    public String topic(@PathVariable String slug, Model model) {
        Topic topic = topicService.getBySlug(slug);
        model.addAttribute("topic", topic);
        return "topic";
    }
}
