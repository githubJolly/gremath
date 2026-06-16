/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Service
 *  org.springframework.transaction.annotation.Transactional
 */
package com.gremath.service;

import com.gremath.model.SheetAnswer;
import com.gremath.model.SheetAttempt;
import com.gremath.model.Student;
import com.gremath.practice.GeneratedQuestion;
import com.gremath.practice.SheetService;
import com.gremath.practice.SheetType;
import com.gremath.repository.SheetAttemptRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SheetPracticeService {
    private final SheetService sheetService;
    private final SheetAttemptRepository attemptRepository;

    public SheetPracticeService(SheetService sheetService, SheetAttemptRepository attemptRepository) {
        this.sheetService = sheetService;
        this.attemptRepository = attemptRepository;
    }

    @Transactional
    public SheetAttempt grade(Student student, String lessonKey, SheetType type, int number, Map<Integer, Integer> responses) {
        List<GeneratedQuestion> questions = this.sheetService.buildSheet(lessonKey, type, number);
        SheetAttempt attempt = new SheetAttempt();
        attempt.setStudent(student);
        attempt.setTopicSlug(this.sheetService.topicSlug(lessonKey));
        attempt.setLessonKey(lessonKey);
        attempt.setLessonTitle(this.sheetService.lessonTitle(lessonKey));
        attempt.setSheetType(type.name());
        attempt.setSheetNumber(number);
        int score = 0;
        for (int i = 0; i < questions.size(); ++i) {
            boolean correct;
            GeneratedQuestion q = questions.get(i);
            int selected = responses.getOrDefault(i, -1);
            boolean bl = correct = selected == q.getCorrectOption();
            if (correct) {
                ++score;
            }
            SheetAnswer answer = new SheetAnswer();
            answer.setQuestionText(q.getText());
            answer.setOptions(new ArrayList<String>(q.getOptions()));
            answer.setCorrectOption(q.getCorrectOption());
            answer.setSelectedOption(selected);
            answer.setCorrect(correct);
            answer.setExplanation(q.getExplanation());
            answer.setTag(q.getTag());
            attempt.addAnswer(answer);
        }
        attempt.setScore(score);
        attempt.setTotalQuestions(questions.size());
        return (SheetAttempt)this.attemptRepository.save(attempt);
    }

    @Transactional(readOnly=true)
    public SheetAttempt getAttempt(Long id) {
        SheetAttempt attempt = (SheetAttempt)this.attemptRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Attempt not found: " + id));
        attempt.getStudent().getId();
        attempt.getAnswers().forEach(a -> a.getOptions().size());
        return attempt;
    }

    @Transactional(readOnly=true)
    public List<SheetAttempt> getHistory(Student student) {
        return this.attemptRepository.findByStudentOrderByTakenAtDesc(student);
    }
}

