package com.gremath.service;

import com.gremath.model.Student;
import com.gremath.practice.SheetType;
import com.gremath.repository.StudentRepository;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestPropertySource(properties = {
        "spring.datasource.url=jdbc:h2:mem:sheetgrade;DB_CLOSE_DELAY=-1",
        "spring.jpa.hibernate.ddl-auto=update"
})
class SheetPracticeServiceTest {

    @Autowired
    private SheetPracticeService sheetPracticeService;
    @Autowired
    private StudentRepository studentRepository;

    @Test
    void gradesYear6PlaceValueSheetWithIllustratedStems() {
        Student student = new Student();
        student.setUsername("quizkid");
        student.setFullName("Quiz Kid");
        student.setEmail("quizkid@example.com");
        student.setPassword("hashed");
        student.setParentNotifyEnabled(false);
        student = this.studentRepository.save(student);

        var attempt = this.sheetPracticeService.grade(student, "c6nz-place-value", SheetType.CONCEPT, 1, Map.of());
        assertTrue(attempt.getId() != null);
        assertTrue(attempt.getTotalQuestions() >= 8);
        boolean anyLong = attempt.getAnswers().stream()
                .anyMatch(a -> a.getQuestionText() != null && a.getQuestionText().length() > 2000);
        assertTrue(anyLong, "expected an illustrated stem over 2000 chars to persist");
        assertFalse(attempt.getAnswers().isEmpty());
    }
}
