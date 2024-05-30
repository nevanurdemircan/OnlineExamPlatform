package com.example.OnlineExamPlatform.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ExamResultDto {
    private Long id;
    private int score;
    private LocalDateTime completedAt;
    private Long examId;
    private Long userId;
}
