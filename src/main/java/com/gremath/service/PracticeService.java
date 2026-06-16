package com.gremath.service;

import com.gremath.model.*;
import com.gremath.repository.PracticeAttemptRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class PracticeService {

    private final PracticeAttemptRepository attemptRepository;

    public PracticeService(PracticeAttemptRepository attemptRepository) {
        this.attemptRepository = attemptRepository;
    }

    /**
     * Grades a submitted practice sheet and persists the attempt with per-question feedback.
     *
     * @param student   the logged in student
     * @param topic     the topic being practised
     * @param responses map of question id -> selected option index
     */
    @Transactional
    public PracticeAttempt grade(Student student, Topic topic, Map<Long, Integer> responses) {
        PracticeAttempt attempt = new PracticeAttempt();
        attempt.setStudent(student);
        attempt.setTopic(topic);

        List<Question> questions = topic.getQuestions();
        int score = 0;

        for (Question question : questions) {
            int selected = responses.getOrDefault(question.getId(), -1);
            boolean correct = selected == question.getCorrectOption();
            if (correct) {
                score++;
            }
            AttemptAnswer answer = new AttemptAnswer();
            answer.setQuestion(question);
            answer.setSelectedOption(selected);
            answer.setCorrect(correct);
            attempt.addAnswer(answer);
        }

        attempt.setScore(score);
        attempt.setTotalQuestions(questions.size());

        return attemptRepository.save(attempt);
    }

    @Transactional(readOnly = true)
    public List<PracticeAttempt> getHistory(Student student) {
        List<PracticeAttempt> attempts = attemptRepository.findByStudentOrderByTakenAtDesc(student);
        // Touch the lazy topic so the dashboard can show its name.
        attempts.forEach(a -> a.getTopic().getName());
        return attempts;
    }

    @Transactional(readOnly = true)
    public PracticeAttempt getAttempt(Long id) {
        PracticeAttempt attempt = attemptRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Attempt not found: " + id));
        attempt.getTopic().getName();
        attempt.getStudent().getId();
        // Initialise answers and their question options for the results page.
        attempt.getAnswers().forEach(ans -> ans.getQuestion().getOptions().size());
        return attempt;
    }
}
