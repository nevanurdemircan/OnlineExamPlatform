package com.example.OnlineExamPlatform.controller;

import com.example.OnlineExamPlatform.dto.QuestionDto;
import com.example.OnlineExamPlatform.entity.Question;
import com.example.OnlineExamPlatform.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/question")
public class QuestionController {
    private final QuestionService questionService;

    @PostMapping("/save")
    public ResponseEntity<Question> save(@RequestBody QuestionDto questionDto) {
        Question question = questionService.save(questionDto);
        return ResponseEntity.ok(question);
    }

    @GetMapping("/GetAll")
    public ResponseEntity<List<Question>> getAll() {
        List<Question> all = questionService.getAll();
        return ResponseEntity.ok(all);
    }
}
