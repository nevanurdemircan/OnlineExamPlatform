package com.example.OnlineExamPlatform.repository;

import com.example.OnlineExamPlatform.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
