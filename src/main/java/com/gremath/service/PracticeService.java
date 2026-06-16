/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Service
 *  org.springframework.transaction.annotation.Transactional
 */
package com.gremath.service;

import com.gremath.model.AttemptAnswer;
import com.gremath.model.PracticeAttempt;
import com.gremath.model.Question;
import com.gremath.model.Student;
import com.gremath.model.Topic;
import com.gremath.repository.PracticeAttemptRepository;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PracticeService {
    private final PracticeAttemptRepository attemptRepository;

    public PracticeService(PracticeAttemptRepository attemptRepository) {
        this.attemptRepository = attemptRepository;
    }

    @Transactional
    public PracticeAttempt grade(Student student, Topic topic, Map<Long, Integer> responses) {
        PracticeAttempt attempt = new PracticeAttempt();
        attempt.setStudent(student);
        attempt.setTopic(topic);
        List<Question> questions = topic.getQuestions();
        int score = 0;
        for (Question question : questions) {
            boolean correct;
            int selected = responses.getOrDefault(question.getId(), -1);
            boolean bl = correct = selected == question.getCorrectOption();
            if (correct) {
                ++score;
            }
            AttemptAnswer answer = new AttemptAnswer();
            answer.setQuestion(question);
            answer.setSelectedOption(selected);
            answer.setCorrect(correct);
            attempt.addAnswer(answer);
        }
        attempt.setScore(score);
        attempt.setTotalQuestions(questions.size());
        return (PracticeAttempt)this.attemptRepository.save(attempt);
    }

    @Transactional(readOnly=true)
    public List<PracticeAttempt> getHistory(Student student) {
        List<PracticeAttempt> attempts = this.attemptRepository.findByStudentOrderByTakenAtDesc(student);
        attempts.forEach(a -> a.getTopic().getName());
        return attempts;
    }

    @Transactional(readOnly=true)
    public PracticeAttempt getAttempt(Long id) {
        PracticeAttempt attempt = (PracticeAttempt)this.attemptRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Attempt not found: " + id));
        attempt.getTopic().getName();
        attempt.getStudent().getId();
        attempt.getAnswers().forEach(ans -> ans.getQuestion().getOptions().size());
        return attempt;
    }
}

