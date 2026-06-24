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
import org.springframework.web.bind.annotation.RequestParam;

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
    public String dashboard(Principal principal,
                            @RequestParam(name="track", required=false, defaultValue="gre-cat") String track,
                            @RequestParam(name="paid", required=false, defaultValue="0") int paid,
                            @RequestParam(name="until", required=false) String until,
                            Model model) {
        Student student = this.studentService.getByUsername(principal.getName());
        List<PracticeAttempt> history = this.practiceService.getHistory(student);
        List<SheetAttempt> sheetHistory = this.sheetPracticeService.getHistory(student);
        int bestTopic = history.stream().mapToInt(PracticeAttempt::getPercentage).max().orElse(0);
        int bestSheet = sheetHistory.stream().mapToInt(SheetAttempt::getPercentage).max().orElse(0);
        String activeTrack = "class6-nz".equalsIgnoreCase(track) ? "class6-nz" : "gre-cat";
        boolean hasSubscription = this.studentService.hasTrackAccess(student, activeTrack);
        model.addAttribute("student", (Object)student);
        model.addAttribute("topics", hasSubscription ? this.topicService.getTopicsForTrack(activeTrack) : java.util.List.of());
        model.addAttribute("track", activeTrack);
        model.addAttribute("trackLabel", "class6-nz".equals(activeTrack) ? "Class 6 (New Zealand Curriculum)" : "GRE / CAT");
        model.addAttribute("trackPrice", "class6-nz".equals(activeTrack) ? 10 : 20);
        model.addAttribute("hasActiveSubscription", hasSubscription);
        model.addAttribute("paid", paid == 1);
        model.addAttribute("paidUntil", until);
        model.addAttribute("history", history);
        model.addAttribute("sheetHistory", sheetHistory);
        model.addAttribute("attemptsCount", (Object)(history.size() + sheetHistory.size()));
        model.addAttribute("bestPercentage", (Object)Math.max(bestTopic, bestSheet));
        model.addAttribute("readiness", (Object)this.readinessService.estimate(history, sheetHistory));
        return "dashboard";
    }
}

