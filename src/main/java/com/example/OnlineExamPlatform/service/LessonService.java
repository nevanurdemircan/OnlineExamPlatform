package com.example.OnlineExamPlatform.service;

import com.example.OnlineExamPlatform.converter.LessonConverter;
import com.example.OnlineExamPlatform.dto.LessonDto;
import com.example.OnlineExamPlatform.entity.Lesson;
import com.example.OnlineExamPlatform.repository.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonService {
    private final LessonRepository lessonRepository;
    private final LessonConverter converter;

    public Lesson save(Lesson lesson){
        return lessonRepository.save(lesson);
    }

    public List<LessonDto> getAll() {
        List<Lesson> lessons = lessonRepository.findAll();
        List<LessonDto> lessonDtos = new ArrayList<>();

        for (Lesson lesson : lessons) {
            LessonDto lessonDto =converter.lessonDtoConvertToLesson(lesson);
            lessonDtos.add(lessonDto);
        }

        return lessonDtos;
    }
}
