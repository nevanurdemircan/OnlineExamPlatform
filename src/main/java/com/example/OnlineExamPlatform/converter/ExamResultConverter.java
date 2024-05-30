package com.example.OnlineExamPlatform.converter;

import com.example.OnlineExamPlatform.dto.ExamResultDto;
import com.example.OnlineExamPlatform.entity.Exam;
import com.example.OnlineExamPlatform.entity.ExamResult;
import com.example.OnlineExamPlatform.entity.User;
import org.springframework.stereotype.Component;

@Component
public class ExamResultConverter {
    public ExamResult convertToExamResult(ExamResultDto examResultDto) {
        ExamResult examResult = new ExamResult();

        Exam exam = new Exam();
        exam.setId(examResultDto.getExamId());

        User user = new User();
        user.setId(examResultDto.getUserId());

        examResult.setUser(user);
        examResult.setExam(exam);
        examResult.setScore(examResultDto.getScore());
        examResult.setCompletedAt(examResultDto.getCompletedAt());
        return examResult;
    }

    public ExamResultDto convertToExamResultDto(ExamResult entity) {
        ExamResultDto dto = new ExamResultDto();
        dto.setId(entity.getId());
        dto.setScore(entity.getScore());
        dto.setCompletedAt(entity.getCompletedAt());
        dto.setExamId(entity.getExam().getId());
        dto.setUserId(entity.getUser().getId());

        return dto;
    }
}
