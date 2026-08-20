package com.gremath.controller;

import com.gremath.curriculum.NzCurriculumMap;
import com.gremath.model.Student;
import com.gremath.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class CurriculumController {
    private final StudentService studentService;

    public CurriculumController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/curriculum/nz")
    public String nzCurriculum(@RequestParam(name = "year", required = false, defaultValue = "6") int year,
                               Principal principal,
                               Model model) {
        int selected = Math.max(1, Math.min(10, year));
        if (principal != null) {
            Student student = this.studentService.getByUsername(principal.getName());
            model.addAttribute("hasAccess", this.studentService.hasTrackAccess(student, "class6-nz"));
            model.addAttribute("student", student);
        } else {
            model.addAttribute("hasAccess", false);
        }
        model.addAttribute("years", NzCurriculumMap.years());
        model.addAttribute("selectedYear", selected);
        model.addAttribute("subjects", NzCurriculumMap.cardsForYear(selected));
        model.addAttribute("curriculumHome", "https://newzealandcurriculum.tahurangi.education.govt.nz/");
        String band = selected <= 3 ? "Junior primary" : selected <= 6 ? "Upper primary" : selected <= 8 ? "Intermediate" : "Junior secondary";
        model.addAttribute("yearBand", band);
        return "nz-curriculum";
    }
}
