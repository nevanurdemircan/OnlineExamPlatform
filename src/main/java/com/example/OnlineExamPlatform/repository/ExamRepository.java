package com.example.OnlineExamPlatform.repository;

import com.example.OnlineExamPlatform.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExamRepository extends JpaRepository<Exam,Long> {
    List<Exam> findByLessonName(String lessonName);
}
