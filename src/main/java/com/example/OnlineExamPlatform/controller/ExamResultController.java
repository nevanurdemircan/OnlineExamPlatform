package com.example.OnlineExamPlatform.controller;

import com.example.OnlineExamPlatform.dto.ExamResultDto;
import com.example.OnlineExamPlatform.entity.ExamResult;
import com.example.OnlineExamPlatform.service.ExamResultService;
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
@RequestMapping("/api/examResult")
public class ExamResultController {
    private final ExamResultService examResultService;

    @PostMapping("/save")
    public ResponseEntity<ExamResultDto> saveExamResult(@RequestBody ExamResultDto examResultDto) {
        ExamResultDto result = examResultService.saveExamResult(examResultDto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ExamResult>> getExamResultsByUserId(@PathVariable Long userId) {
        List<ExamResult> examResultsByStudentId = examResultService.getExamResultsByUserId(userId);
        return ResponseEntity.ok(examResultsByStudentId);
    }

    @GetMapping("/exam/{examId}")
    public ResponseEntity<List<ExamResult>> getExamResultsByExamId(@PathVariable Long examId) {
        List<ExamResult> examResultsByExamId = examResultService.getExamResultsByExamId(examId);
        return ResponseEntity.ok(examResultsByExamId);
    }
}
