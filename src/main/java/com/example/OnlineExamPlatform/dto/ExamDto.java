package com.example.OnlineExamPlatform.dto;

import com.example.OnlineExamPlatform.entity.ExamResult;
import com.example.OnlineExamPlatform.entity.Lesson;
import com.example.OnlineExamPlatform.entity.Question;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ExamDto {
    private String title;
    private Date date;
    private  int durationInMinutes;
    private List<Question> questions;
    private Lesson lesson;


}
