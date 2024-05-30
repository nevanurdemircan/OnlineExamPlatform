package com.example.OnlineExamPlatform.controller;

import com.example.OnlineExamPlatform.dto.LessonDto;
import com.example.OnlineExamPlatform.entity.Lesson;
import com.example.OnlineExamPlatform.service.LessonService;
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
@RequestMapping("/api/lesson")
public class LessonController {
    private final LessonService lessonService;

    @PostMapping("/save")
    public ResponseEntity<Lesson> save(@RequestBody Lesson lesson){
        Lesson save = lessonService.save(lesson);
        return ResponseEntity.ok(save);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<LessonDto>> getAll(){
        List<LessonDto> all = lessonService.getAll();
        return ResponseEntity.ok(all);
    }
}
