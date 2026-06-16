package com.gremath.repository;

import com.gremath.model.PracticeAttempt;
import com.gremath.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PracticeAttemptRepository extends JpaRepository<PracticeAttempt, Long> {

    List<PracticeAttempt> findByStudentOrderByTakenAtDesc(Student student);

    long countByStudent(Student student);
}
