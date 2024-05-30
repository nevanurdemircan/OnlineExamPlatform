package com.example.OnlineExamPlatform.converter;

import com.example.OnlineExamPlatform.dto.ExamDto;
import com.example.OnlineExamPlatform.entity.Exam;

import org.springframework.stereotype.Component;

@Component
public class ExamConverter {
    public Exam convertToExam(ExamDto examDto) {
        Exam exam = new Exam();
        exam.setTitle(examDto.getTitle());
        exam.setDate(examDto.getDate());
        exam.setDurationInMinutes(examDto.getDurationInMinutes());
        exam.setQuestions(examDto.getQuestions());
        exam.setLesson(examDto.getLesson());
        return exam;
    }

    public ExamDto convertToExamDto(Exam exam) {
        ExamDto examDto = new ExamDto();
        examDto.setDate(examDto.getDate());
        examDto.setQuestions(examDto.getQuestions());
        examDto.setTitle(examDto.getTitle());
        examDto.setDurationInMinutes(examDto.getDurationInMinutes());
        return examDto;
    }
}
