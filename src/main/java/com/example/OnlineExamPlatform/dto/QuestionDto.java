package com.example.OnlineExamPlatform.dto;

import com.example.OnlineExamPlatform.entity.Exam;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionDto {
    private String questionText;
    private String options;
    private String correctAnswer;
    private Exam exam;

}
