package com.gremath.controller;

import com.gremath.model.PracticeAttempt;
import com.gremath.model.Student;
import com.gremath.service.PracticeService;
import com.gremath.service.StudentService;
import com.gremath.service.TopicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class DashboardController {

    private final TopicService topicService;
    private final StudentService studentService;
    private final PracticeService practiceService;

    public DashboardController(TopicService topicService,
                              StudentService studentService,
                              PracticeService practiceService) {
        this.topicService = topicService;
        this.studentService = studentService;
        this.practiceService = practiceService;
    }

    @GetMapping("/dashboard")
    public String dashboard(Principal principal, Model model) {
        Student student = studentService.getByUsername(principal.getName());
        List<PracticeAttempt> history = practiceService.getHistory(student);

        int bestPercentage = history.stream()
                .mapToInt(PracticeAttempt::getPercentage)
                .max()
                .orElse(0);

        model.addAttribute("student", student);
        model.addAttribute("topics", topicService.getAllTopics());
        model.addAttribute("history", history);
        model.addAttribute("attemptsCount", history.size());
        model.addAttribute("bestPercentage", bestPercentage);
        return "dashboard";
    }
}
