/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Controller
 *  org.springframework.ui.Model
 *  org.springframework.web.bind.annotation.GetMapping
 */
package com.gremath.controller;

import com.gremath.model.PracticeAttempt;
import com.gremath.model.SheetAttempt;
import com.gremath.model.Student;
import com.gremath.service.PracticeService;
import com.gremath.service.ReadinessService;
import com.gremath.service.SheetPracticeService;
import com.gremath.service.StudentService;
import com.gremath.service.TopicService;
import java.security.Principal;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    private final TopicService topicService;
    private final StudentService studentService;
    private final PracticeService practiceService;
    private final SheetPracticeService sheetPracticeService;
    private final ReadinessService readinessService;

    public DashboardController(TopicService topicService, StudentService studentService, PracticeService practiceService, SheetPracticeService sheetPracticeService, ReadinessService readinessService) {
        this.topicService = topicService;
        this.studentService = studentService;
        this.practiceService = practiceService;
        this.sheetPracticeService = sheetPracticeService;
        this.readinessService = readinessService;
    }

    @GetMapping(value={"/dashboard"})
    public String dashboard(Principal principal, Model model) {
        Student student = this.studentService.getByUsername(principal.getName());
        List<PracticeAttempt> history = this.practiceService.getHistory(student);
        List<SheetAttempt> sheetHistory = this.sheetPracticeService.getHistory(student);
        int bestTopic = history.stream().mapToInt(PracticeAttempt::getPercentage).max().orElse(0);
        int bestSheet = sheetHistory.stream().mapToInt(SheetAttempt::getPercentage).max().orElse(0);
        model.addAttribute("student", (Object)student);
        model.addAttribute("topics", this.topicService.getAllTopics());
        model.addAttribute("history", history);
        model.addAttribute("sheetHistory", sheetHistory);
        model.addAttribute("attemptsCount", (Object)(history.size() + sheetHistory.size()));
        model.addAttribute("bestPercentage", (Object)Math.max(bestTopic, bestSheet));
        model.addAttribute("readiness", (Object)this.readinessService.estimate(history, sheetHistory));
        return "dashboard";
    }
}

