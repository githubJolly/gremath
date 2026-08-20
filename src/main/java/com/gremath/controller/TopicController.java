/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Controller
 *  org.springframework.ui.Model
 *  org.springframework.web.bind.annotation.GetMapping
 *  org.springframework.web.bind.annotation.PathVariable
 */
package com.gremath.controller;

import com.gremath.content.Enrich;
import com.gremath.curriculum.NzCurriculumCatalog;
import com.gremath.model.Lesson;
import com.gremath.model.Student;
import com.gremath.model.Topic;
import com.gremath.service.StudentService;
import com.gremath.service.TopicService;
import java.security.Principal;
import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TopicController {
    private final TopicService topicService;
    private final StudentService studentService;

    public TopicController(TopicService topicService, StudentService studentService) {
        this.topicService = topicService;
        this.studentService = studentService;
    }

    @GetMapping(value={"/topics/{slug}"})
    public String topic(@PathVariable String slug, Principal principal, Model model) {
        Topic topic = this.topicService.getBySlug(slug);
        String examType = topic.getExamType();
        boolean nzTrack = examType != null && examType.contains("NZ");
        String requiredTrack = nzTrack ? "class6-nz" : "gre-cat";
        Student student = this.studentService.getByUsername(principal.getName());
        if (!this.studentService.hasTrackAccess(student, requiredTrack)) {
            return "redirect:/pricing?required=" + requiredTrack;
        }
        for (Lesson lesson : topic.getLessons()) {
            lesson.setContent(Enrich.normalizeLessonContent(lesson.getTitle(), lesson.getOrderIndex(), lesson.getContent()));
        }
        model.addAttribute("topic", topic);
        Optional<NzCurriculumCatalog.YearSubject> mapped = NzCurriculumCatalog.fromTopicSlug(slug);
        if (mapped.isPresent()) {
            NzCurriculumCatalog.YearSubject ys = mapped.get();
            model.addAttribute("yearLevel", ys.year());
            model.addAttribute("subjectName", ys.subject().displayName());
            model.addAttribute("subjectTheme", ys.subject().themeClass());
            model.addAttribute("subjectEmoji", ys.subject().emoji());
            model.addAttribute("curriculumYearHref", "/curriculum/nz?year=" + ys.year());
        }
        return "topic";
    }
}

