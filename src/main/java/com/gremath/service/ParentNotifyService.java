package com.gremath.service;

import com.gremath.dto.FocusArea;
import com.gremath.dto.ParentProgressSnapshot;
import com.gremath.model.SheetAttempt;
import com.gremath.model.Student;
import com.gremath.repository.SheetAttemptRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ParentNotifyService {
    private final EmailService emailService;
    private final ParentProgressService parentProgressService;
    private final SheetAttemptRepository attemptRepository;
    private final String appBaseUrl;

    public ParentNotifyService(EmailService emailService,
                               ParentProgressService parentProgressService,
                               SheetAttemptRepository attemptRepository,
                               @Value("${app.base-url:http://localhost:8080}") String appBaseUrl) {
        this.emailService = emailService;
        this.parentProgressService = parentProgressService;
        this.attemptRepository = attemptRepository;
        this.appBaseUrl = appBaseUrl;
    }

    public void notifyAfterSheet(Student student, SheetAttempt latest) {
        if (student == null || !student.isParentNotifyEnabled()) {
            return;
        }
        String to = student.progressEmail();
        if (to == null || to.isBlank()) {
            return;
        }
        ParentProgressSnapshot snap = this.parentProgressService.build(
                this.attemptRepository.findByStudentOrderByTakenAtDesc(student));
        String latestLine = student.getFullName() + " just finished "
                + (latest.getLessonTitle() == null ? "a lesson" : latest.getLessonTitle())
                + " (" + latest.getSheetLabel() + ") and scored "
                + latest.getScore() + "/" + latest.getTotalQuestions()
                + " (" + latest.getPercentage() + "%).";
        String subjects = snap.getSubjectScores().stream()
                .map(s -> s.getSubject() + ": " + s.getAveragePercent() + "% average across "
                        + s.getSessions() + " sheet" + (s.getSessions() == 1 ? "" : "s")
                        + " — latest: " + s.getLatestLesson())
                .collect(Collectors.joining("\n"));
        String dash = appBaseUrl.replaceAll("/$", "") + "/dashboard";
        this.emailService.sendParentProgressEmail(to, student.getFullName(), latestLine, subjects,
                formatAreas(snap.getNeedsFocus()), formatAreas(snap.getGoingWell()), dash);
    }

    private static String formatAreas(List<FocusArea> areas) {
        if (areas == null || areas.isEmpty()) {
            return "";
        }
        return areas.stream()
                .map(a -> "• " + a.getLessonTitle() + " — " + a.getAveragePercent() + "% avg (" + a.getAttempts()
                        + " sheets). " + a.getGuidance())
                .collect(Collectors.joining("\n"));
    }
}
