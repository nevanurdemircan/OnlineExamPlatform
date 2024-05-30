package com.example.OnlineExamPlatform.dto;

import com.example.OnlineExamPlatform.entity.Exam;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class LessonDto {
    private Long id;
    private String name;
    private List<Exam> exam;
}
