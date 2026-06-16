/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.security.access.AccessDeniedException
 *  org.springframework.stereotype.Controller
 *  org.springframework.ui.Model
 *  org.springframework.web.bind.annotation.GetMapping
 *  org.springframework.web.bind.annotation.PathVariable
 *  org.springframework.web.bind.annotation.PostMapping
 *  org.springframework.web.bind.annotation.RequestParam
 */
package com.gremath.controller;

import com.gremath.model.PracticeAttempt;
import com.gremath.model.Student;
import com.gremath.model.Topic;
import com.gremath.service.PracticeService;
import com.gremath.service.StudentService;
import com.gremath.service.TopicService;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PracticeController {
    private final TopicService topicService;
    private final StudentService studentService;
    private final PracticeService practiceService;

    public PracticeController(TopicService topicService, StudentService studentService, PracticeService practiceService) {
        this.topicService = topicService;
        this.studentService = studentService;
        this.practiceService = practiceService;
    }

    @GetMapping(value={"/practice/{slug}"})
    public String practiceSheet(@PathVariable String slug, Model model) {
        Topic topic = this.topicService.getBySlug(slug);
        model.addAttribute("topic", (Object)topic);
        return "practice";
    }

    @PostMapping(value={"/practice/{slug}"})
    public String submit(@PathVariable String slug, @RequestParam Map<String, String> params, Principal principal) {
        Topic topic = this.topicService.getBySlug(slug);
        Student student = this.studentService.getByUsername(principal.getName());
        HashMap<Long, Integer> responses = new HashMap<Long, Integer>();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (!entry.getKey().startsWith("q_")) continue;
            try {
                Long questionId = Long.parseLong(entry.getKey().substring(2));
                int option = Integer.parseInt(entry.getValue());
                responses.put(questionId, option);
            }
            catch (NumberFormatException numberFormatException) {}
        }
        PracticeAttempt attempt = this.practiceService.grade(student, topic, responses);
        return "redirect:/result/" + attempt.getId();
    }

    @GetMapping(value={"/result/{attemptId}"})
    public String result(@PathVariable Long attemptId, Principal principal, Model model) {
        PracticeAttempt attempt = this.practiceService.getAttempt(attemptId);
        Student student = this.studentService.getByUsername(principal.getName());
        if (!attempt.getStudent().getId().equals(student.getId())) {
            throw new AccessDeniedException("You cannot view this result.");
        }
        model.addAttribute("attempt", (Object)attempt);
        model.addAttribute("topic", (Object)attempt.getTopic());
        return "result";
    }
}

