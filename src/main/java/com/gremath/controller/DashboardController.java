package com.gremath.controller;

import com.gremath.curriculum.NzCurriculumMap;
import com.gremath.dto.ParentProgressSnapshot;
import com.gremath.model.PracticeAttempt;
import com.gremath.model.SheetAttempt;
import com.gremath.model.Student;
import com.gremath.service.ParentProgressService;
import com.gremath.service.PracticeService;
import com.gremath.service.SheetPracticeService;
import com.gremath.service.StudentService;
import java.security.Principal;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DashboardController {
    private final StudentService studentService;
    private final PracticeService practiceService;
    private final SheetPracticeService sheetPracticeService;
    private final ParentProgressService parentProgressService;

    public DashboardController(StudentService studentService,
                               PracticeService practiceService,
                               SheetPracticeService sheetPracticeService,
                               ParentProgressService parentProgressService) {
        this.studentService = studentService;
        this.practiceService = practiceService;
        this.sheetPracticeService = sheetPracticeService;
        this.parentProgressService = parentProgressService;
    }

    @GetMapping(value = {"/dashboard"})
    public String dashboard(Principal principal,
                            @RequestParam(name = "track", required = false, defaultValue = "class6-nz") String track,
                            @RequestParam(name = "year", required = false, defaultValue = "6") int year,
                            @RequestParam(name = "paid", required = false, defaultValue = "0") int paid,
                            @RequestParam(name = "until", required = false) String until,
                            Model model) {
        Student student = this.studentService.getByUsername(principal.getName());
        // NZ-first: auto-start complimentary trial for accounts that have never used one
        if (!student.hasPaidNzSubscription() && !student.isNzTrialUsed()) {
            this.studentService.startNzTrialIfEligible(student);
            student = this.studentService.getByUsername(principal.getName());
        }

        List<PracticeAttempt> history = this.practiceService.getHistory(student);
        List<SheetAttempt> sheetHistory = this.sheetPracticeService.getHistory(student);
        int bestTopic = history.stream().mapToInt(PracticeAttempt::getPercentage).max().orElse(0);
        int bestSheet = sheetHistory.stream().mapToInt(SheetAttempt::getPercentage).max().orElse(0);

        // GRE/CAT hidden for now — always use NZ curriculum track
        String activeTrack = "class6-nz";
        boolean hasSubscription = this.studentService.hasTrackAccess(student, activeTrack);
        ParentProgressSnapshot parentProgress = this.parentProgressService.build(sheetHistory);

        model.addAttribute("student", student);
        model.addAttribute("topics", List.of());
        model.addAttribute("track", activeTrack);
        model.addAttribute("trackLabel", "NZ Curriculum");
        model.addAttribute("trackPrice", 10);
        model.addAttribute("hasActiveSubscription", hasSubscription);
        model.addAttribute("onTrial", student.hasActiveNzTrial() && !student.hasPaidNzSubscription());
        model.addAttribute("trialUntil", student.getNzTrialUntil());
        model.addAttribute("paidNz", student.hasPaidNzSubscription());
        model.addAttribute("paid", paid == 1);
        model.addAttribute("paidUntil", until);
        model.addAttribute("history", history);
        model.addAttribute("sheetHistory", sheetHistory);
        model.addAttribute("attemptsCount", history.size() + sheetHistory.size());
        model.addAttribute("bestPercentage", Math.max(bestTopic, bestSheet));
        model.addAttribute("parentProgress", parentProgress);
        int selectedYear = Math.max(1, Math.min(10, year));
        model.addAttribute("years", NzCurriculumMap.years());
        model.addAttribute("selectedYear", selectedYear);
        model.addAttribute("subjects", NzCurriculumMap.cardsForYear(selectedYear));
        return "dashboard";
    }
}
