package com.example.OnlineExamPlatform.entity;

import com.example.OnlineExamPlatform.dto.ExamStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Exam {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String title;
    private Date date;
    private  int durationInMinutes;

    @OneToMany(mappedBy = "exam")
    private List<Question> questions;

    @Enumerated(EnumType.STRING)
    private ExamStatus status;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;
}
