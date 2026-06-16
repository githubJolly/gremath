package com.gremath.controller;

import com.gremath.model.PracticeAttempt;
import com.gremath.model.Student;
import com.gremath.model.Topic;
import com.gremath.service.PracticeService;
import com.gremath.service.StudentService;
import com.gremath.service.TopicService;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@Controller
public class PracticeController {

    private final TopicService topicService;
    private final StudentService studentService;
    private final PracticeService practiceService;

    public PracticeController(TopicService topicService,
                             StudentService studentService,
                             PracticeService practiceService) {
        this.topicService = topicService;
        this.studentService = studentService;
        this.practiceService = practiceService;
    }

    @GetMapping("/practice/{slug}")
    public String practiceSheet(@PathVariable String slug, Model model) {
        Topic topic = topicService.getBySlug(slug);
        model.addAttribute("topic", topic);
        return "practice";
    }

    @PostMapping("/practice/{slug}")
    public String submit(@PathVariable String slug,
                         @RequestParam Map<String, String> params,
                         Principal principal) {
        Topic topic = topicService.getBySlug(slug);
        Student student = studentService.getByUsername(principal.getName());

        Map<Long, Integer> responses = new HashMap<>();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (entry.getKey().startsWith("q_")) {
                try {
                    Long questionId = Long.parseLong(entry.getKey().substring(2));
                    int option = Integer.parseInt(entry.getValue());
                    responses.put(questionId, option);
                } catch (NumberFormatException ignored) {
                    // skip malformed values
                }
            }
        }

        PracticeAttempt attempt = practiceService.grade(student, topic, responses);
        return "redirect:/result/" + attempt.getId();
    }

    @GetMapping("/result/{attemptId}")
    public String result(@PathVariable Long attemptId, Principal principal, Model model) {
        PracticeAttempt attempt = practiceService.getAttempt(attemptId);
        Student student = studentService.getByUsername(principal.getName());

        // A student may only view their own results.
        if (!attempt.getStudent().getId().equals(student.getId())) {
            throw new AccessDeniedException("You cannot view this result.");
        }

        model.addAttribute("attempt", attempt);
        model.addAttribute("topic", attempt.getTopic());
        return "result";
    }
}
