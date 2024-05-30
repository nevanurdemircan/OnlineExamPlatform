package com.example.OnlineExamPlatform.service;

import com.example.OnlineExamPlatform.converter.ExamResultConverter;
import com.example.OnlineExamPlatform.dto.ExamResultDto;
import com.example.OnlineExamPlatform.entity.Exam;
import com.example.OnlineExamPlatform.entity.ExamResult;
import com.example.OnlineExamPlatform.entity.User;
import com.example.OnlineExamPlatform.repository.ExamRepository;
import com.example.OnlineExamPlatform.repository.ExamResultRepository;
import com.example.OnlineExamPlatform.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExamResultService {
    private final ExamResultRepository examResultRepository;
    private final ExamResultConverter examResultConverter;

    public ExamResultDto saveExamResult(ExamResultDto examResultDto) {
        ExamResult examResult = examResultConverter.convertToExamResult(examResultDto);
        ExamResult entity = examResultRepository.save(examResult);
        return examResultConverter.convertToExamResultDto(entity);
    }

    public List<ExamResult> getExamResultsByUserId(Long userId) {
        return examResultRepository.findByUserId(userId);
    }

    public List<ExamResult> getExamResultsByExamId(Long examId) {
        return examResultRepository.findByExamId(examId);
    }
}
