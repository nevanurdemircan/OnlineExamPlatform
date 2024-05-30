package com.example.OnlineExamPlatform.repository;

import com.example.OnlineExamPlatform.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Long> {
}
