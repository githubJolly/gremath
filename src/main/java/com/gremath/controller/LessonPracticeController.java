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
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RequestParam
 */
package com.gremath.controller;

import com.gremath.content.Enrich;
import com.gremath.model.Lesson;
import com.gremath.model.SheetAttempt;
import com.gremath.model.Student;
import com.gremath.practice.GeneratedQuestion;
import com.gremath.practice.SheetService;
import com.gremath.practice.SheetType;
import com.gremath.repository.LessonRepository;
import com.gremath.service.SheetPracticeService;
import com.gremath.service.StudentService;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value={"/practice"})
public class LessonPracticeController {
    private final SheetService sheetService;
    private final SheetPracticeService sheetPracticeService;
    private final StudentService studentService;
    private final LessonRepository lessonRepository;

    public LessonPracticeController(SheetService sheetService, SheetPracticeService sheetPracticeService, StudentService studentService, LessonRepository lessonRepository) {
        this.sheetService = sheetService;
        this.sheetPracticeService = sheetPracticeService;
        this.studentService = studentService;
        this.lessonRepository = lessonRepository;
    }

    @GetMapping(value={"/lesson/{lessonKey}"})
    public String lessonPractice(@PathVariable String lessonKey, Model model) {
        Lesson lesson = this.lessonRepository.findByPracticeKey(lessonKey).orElse(null);
        model.addAttribute("lessonKey", (Object)lessonKey);
        model.addAttribute("lessonTitle", (Object)this.sheetService.lessonTitle(lessonKey));
        model.addAttribute("topicSlug", (Object)this.sheetService.topicSlug(lessonKey));
        model.addAttribute("wordStrategy", lesson != null ? Enrich.adaptStrategy(lesson.getTitle(), lesson.getPracticeKey(), lesson.getWordStrategy()) : null);
        model.addAttribute("conceptSheets", this.sheetService.sheetRefs(lessonKey, SheetType.CONCEPT));
        model.addAttribute("wordSheets", this.sheetService.sheetRefs(lessonKey, SheetType.WORD));
        return "lesson-practice";
    }

    @GetMapping(value={"/sheet/{lessonKey}/{type}/{number}"})
    public String showSheet(@PathVariable String lessonKey, @PathVariable String type, @PathVariable int number, Model model) {
        SheetType sheetType = SheetType.from(type);
        List<GeneratedQuestion> questions = this.sheetService.buildSheet(lessonKey, sheetType, number);
        int timerSeconds = this.recommendedTimerSeconds(sheetType, questions.size());
        String sheetTitle = this.sheetTitle(sheetType, number);
        Lesson lesson = this.lessonRepository.findByPracticeKey(lessonKey).orElse(null);
        List<String> difficulties = new java.util.ArrayList<String>();
        List<String> tags = new java.util.ArrayList<String>();
        for (GeneratedQuestion q : questions) {
            difficulties.add(q.getDifficulty());
            tags.add(q.getTag());
        }
        String sheetStrategy = lesson != null
                ? Enrich.sheetStrategy(lesson.getTitle(), lesson.getPracticeKey(), lesson.getWordStrategy(),
                        sheetType == SheetType.WORD, sheetTitle, difficulties, tags)
                : null;
        model.addAttribute("lessonKey", (Object)lessonKey);
        model.addAttribute("lessonTitle", (Object)this.sheetService.lessonTitle(lessonKey));
        model.addAttribute("topicSlug", (Object)this.sheetService.topicSlug(lessonKey));
        model.addAttribute("type", (Object)sheetType.name());
        model.addAttribute("number", (Object)number);
        model.addAttribute("questions", questions);
        model.addAttribute("sheetTitle", (Object)sheetTitle);
        model.addAttribute("sheetStrategy", (Object)sheetStrategy);
        model.addAttribute("timerSeconds", (Object)timerSeconds);
        model.addAttribute("timerDisplay", (Object)this.formatTimer(timerSeconds));
        model.addAttribute("timerGuidance", (Object)this.timerGuidance(sheetType, questions.size(), timerSeconds));
        return "sheet";
    }

    @PostMapping(value={"/sheet/{lessonKey}/{type}/{number}"})
    public String submitSheet(@PathVariable String lessonKey, @PathVariable String type, @PathVariable int number, @RequestParam Map<String, String> params, Principal principal) {
        SheetType sheetType = SheetType.from(type);
        Student student = this.studentService.getByUsername(principal.getName());
        HashMap<Integer, Integer> responses = new HashMap<Integer, Integer>();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (!entry.getKey().startsWith("q_")) continue;
            try {
                int idx = Integer.parseInt(entry.getKey().substring(2));
                int opt = Integer.parseInt(entry.getValue());
                responses.put(idx, opt);
            }
            catch (NumberFormatException numberFormatException) {}
        }
        SheetAttempt attempt = this.sheetPracticeService.grade(student, lessonKey, sheetType, number, responses);
        return "redirect:/practice/result/" + attempt.getId();
    }

    @GetMapping(value={"/result/{attemptId}"})
    public String result(@PathVariable Long attemptId, Principal principal, Model model) {
        SheetAttempt attempt = this.sheetPracticeService.getAttempt(attemptId);
        Student student = this.studentService.getByUsername(principal.getName());
        if (!attempt.getStudent().getId().equals(student.getId())) {
            throw new AccessDeniedException("You cannot view this result.");
        }
        model.addAttribute("attempt", (Object)attempt);
        return "sheet-result";
    }

    private String sheetTitle(SheetType type, int number) {
        if (number == 0) {
            return type == SheetType.WORD ? "Classic word problems" : "Classic exam-style questions";
        }
        return (type == SheetType.WORD ? "Word-Problem Sheet " : "Practice Sheet ") + number;
    }

    private int recommendedTimerSeconds(SheetType type, int questionCount) {
        int perQuestion = type == SheetType.WORD ? 120 : 90;
        int raw = questionCount * perQuestion;
        int min = 300;
        int max = 3600;
        return Math.max(min, Math.min(raw, max));
    }

    private String formatTimer(int totalSeconds) {
        int mins = totalSeconds / 60;
        int secs = totalSeconds % 60;
        return String.format("%02d:%02d", mins, secs);
    }

    private String timerGuidance(SheetType type, int questionCount, int totalSeconds) {
        int perQuestion = totalSeconds / Math.max(questionCount, 1);
        return (type == SheetType.WORD ? "Word-problem pace" : "Concept-drill pace") + ": about " + perQuestion + " sec/question.";
    }
}

