package com.example.OnlineExamPlatform.service;

import com.example.OnlineExamPlatform.converter.ExamConverter;
import com.example.OnlineExamPlatform.entity.Exam;
import com.example.OnlineExamPlatform.dto.ExamDto;
import com.example.OnlineExamPlatform.repository.ExamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExamService {
    private final ExamRepository examRepository;
    private final ExamConverter examConverter;

    public Exam save(ExamDto examDto) {
        Exam exam = examConverter.convertToExam(examDto);
        return examRepository.save(exam);
    }

    public List<Exam> getAll() {
        return examRepository.findAll();
    }

    public List<Exam> findByLessonName(String lessonName) {
        return examRepository.findByLessonName(lessonName);
    }
}
