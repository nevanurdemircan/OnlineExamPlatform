package com.example.OnlineExamPlatform.converter;

import com.example.OnlineExamPlatform.dto.LessonDto;
import com.example.OnlineExamPlatform.entity.Lesson;
import org.springframework.stereotype.Component;

@Component
public class LessonConverter {
    public Lesson lessonConvertToLessonDto(LessonDto lessonDto) {
        Lesson lesson = new Lesson();
        lesson.setId(lessonDto.getId());
        lesson.setExam(lessonDto.getExam());
        lesson.setName(lessonDto.getName());
        return lesson;
    }

    public LessonDto lessonDtoConvertToLesson(Lesson lesson) {
        LessonDto lessonDto = new LessonDto();
        lessonDto.setId(lesson.getId());
        lessonDto.setName(lesson.getName());
        lessonDto.setExam(lesson.getExam());
        return lessonDto;
    }

}
