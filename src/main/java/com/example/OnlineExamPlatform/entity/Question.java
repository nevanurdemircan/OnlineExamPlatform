package com.example.OnlineExamPlatform.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Question {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String questionText;
    private String options;
    private String correctAnswer;

    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;
}
