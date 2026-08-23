package com.gremath.controller;

import com.gremath.model.Student;
import com.gremath.reward.GoodieCatalog;
import com.gremath.service.StudentService;
import java.security.Principal;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class RewardAdvice {
    private final StudentService studentService;

    public RewardAdvice(StudentService studentService) {
        this.studentService = studentService;
    }

    @ModelAttribute("navStars")
    public Integer navStars(Principal principal) {
        Student student = student(principal);
        return student == null ? null : student.getStars();
    }

    @ModelAttribute("navRbx")
    public Integer navRbx(Principal principal) {
        Student student = student(principal);
        return student == null ? null : student.getRbxPoints();
    }

    @ModelAttribute("navStreak")
    public Integer navStreak(Principal principal) {
        Student student = student(principal);
        return student == null ? null : student.getStreakDays();
    }

    @ModelAttribute("navTitle")
    public String navTitle(Principal principal) {
        Student student = student(principal);
        if (student == null || student.getEquippedTitle() == null) {
            return null;
        }
        return GoodieCatalog.find(student.getEquippedTitle()).map(g -> g.emoji() + " " + g.name()).orElse(null);
    }

    private Student student(Principal principal) {
        if (principal == null) {
            return null;
        }
        try {
            return this.studentService.getByUsername(principal.getName());
        } catch (RuntimeException ignored) {
            return null;
        }
    }
}
