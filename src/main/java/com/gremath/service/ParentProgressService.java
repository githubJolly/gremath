package com.gremath.service;

import com.gremath.dto.FocusArea;
import com.gremath.dto.ParentProgressSnapshot;
import com.gremath.dto.SubjectScore;
import com.gremath.model.SheetAttempt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ParentProgressService {

    public ParentProgressSnapshot build(List<SheetAttempt> sheetHistory) {
        if (sheetHistory == null || sheetHistory.isEmpty()) {
            return new ParentProgressSnapshot(
                    0, 0, 0, 0,
                    "No practice yet. After your child completes a few sheets, you will see clear focus areas here.",
                    List.of(), List.of(), List.of()
            );
        }

        Map<String, List<SheetAttempt>> byLesson = new HashMap<>();
        for (SheetAttempt attempt : sheetHistory) {
            String key = (attempt.getLessonKey() == null ? "unknown" : attempt.getLessonKey());
            byLesson.computeIfAbsent(key, k -> new ArrayList<>()).add(attempt);
        }

        List<FocusArea> all = new ArrayList<>();
        for (Map.Entry<String, List<SheetAttempt>> entry : byLesson.entrySet()) {
            List<SheetAttempt> attempts = entry.getValue();
            double avg = attempts.stream().mapToInt(SheetAttempt::getPercentage).average().orElse(0);
            SheetAttempt sample = attempts.get(0);
            String guidance = avg < 50
                    ? "Needs guided revision and shorter practice sessions this week."
                    : avg < 70
                    ? "Improving — keep practising this skill 2–3 times this week."
                    : "Strong area — maintain with occasional mixed review.";
            all.add(new FocusArea(
                    sample.getLessonTitle() == null ? "Lesson" : sample.getLessonTitle(),
                    sample.getTopicSlug(),
                    sample.getLessonKey(),
                    (int) Math.round(avg),
                    attempts.size(),
                    guidance
            ));
        }

        List<FocusArea> needsFocus = all.stream()
                .filter(a -> a.getAveragePercent() < 70)
                .sorted(Comparator.comparingInt(FocusArea::getAveragePercent))
                .limit(5)
                .collect(Collectors.toList());

        List<FocusArea> goingWell = all.stream()
                .filter(a -> a.getAveragePercent() >= 70)
                .sorted(Comparator.comparingInt(FocusArea::getAveragePercent).reversed())
                .limit(5)
                .collect(Collectors.toList());

        int overall = (int) Math.round(sheetHistory.stream().mapToInt(SheetAttempt::getPercentage).average().orElse(0));
        String summary;
        if (needsFocus.isEmpty()) {
            summary = "Your child is performing well across practised lessons. Keep a steady weekly rhythm.";
        } else {
            summary = "Focus this week on " + needsFocus.size() + " skill area"
                    + (needsFocus.size() == 1 ? "" : "s")
                    + " below 70%. Short, regular practice will help most.";
        }

        return new ParentProgressSnapshot(
                overall,
                sheetHistory.size(),
                goingWell.size(),
                needsFocus.size(),
                summary,
                needsFocus,
                goingWell,
                subjectScores(sheetHistory)
        );
    }

    public static String subjectLabel(String topicSlug) {
        String s = topicSlug == null ? "" : topicSlug.toLowerCase();
        if (s.contains("mathematics") || s.contains("math")) {
            return "Mathematics";
        }
        if (s.contains("english")) {
            return "English";
        }
        if (s.contains("social")) {
            return "Social Sciences";
        }
        if (s.contains("science")) {
            return "Science";
        }
        if (s.contains("technolog")) {
            return "Technology";
        }
        if (s.contains("arts")) {
            return "The Arts";
        }
        if (s.contains("health") || s.contains("hpe")) {
            return "Health and PE";
        }
        if (s.contains("language")) {
            return "Learning Languages";
        }
        return "Other";
    }

    private static List<SubjectScore> subjectScores(List<SheetAttempt> sheetHistory) {
        Map<String, List<SheetAttempt>> bySubject = new HashMap<>();
        for (SheetAttempt attempt : sheetHistory) {
            bySubject.computeIfAbsent(subjectLabel(attempt.getTopicSlug()), k -> new ArrayList<>()).add(attempt);
        }
        List<SubjectScore> out = new ArrayList<>();
        for (Map.Entry<String, List<SheetAttempt>> entry : bySubject.entrySet()) {
            List<SheetAttempt> attempts = entry.getValue();
            int avg = (int) Math.round(attempts.stream().mapToInt(SheetAttempt::getPercentage).average().orElse(0));
            SheetAttempt latest = attempts.stream()
                    .max(Comparator.comparing(SheetAttempt::getTakenAt, Comparator.nullsLast(Comparator.naturalOrder())))
                    .orElse(attempts.get(0));
            out.add(new SubjectScore(entry.getKey(), avg, attempts.size(),
                    latest.getLessonTitle() == null ? "Lesson" : latest.getLessonTitle()));
        }
        out.sort(Comparator.comparing(SubjectScore::getSubject));
        return out;
    }
}
