package com.example.OnlineExamPlatform.controller;

import com.example.OnlineExamPlatform.dto.ExamDto;
import com.example.OnlineExamPlatform.entity.Exam;
import com.example.OnlineExamPlatform.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/exam")
public class ExamController {
    private final ExamService examService;

    @PostMapping("/save")
    public ResponseEntity<Exam> save(@RequestBody ExamDto examDto) {
        Exam exam = examService.save(examDto);
        return ResponseEntity.ok(exam);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Exam>> getAll() {
        List<Exam> exams = examService.getAll();
        return ResponseEntity.ok(exams);
    }

    @GetMapping("/lessonName/{lessonName}")
    public ResponseEntity<List<Exam>> findByLessonName(@PathVariable String lessonName){
        List<Exam> byLessonName = examService.findByLessonName(lessonName);
        return ResponseEntity.ok(byLessonName);
    }
}
