package com.example.OnlineExamPlatform.service;

import com.example.OnlineExamPlatform.converter.QuestionConverter;
import com.example.OnlineExamPlatform.dto.QuestionDto;
import com.example.OnlineExamPlatform.entity.Question;
import com.example.OnlineExamPlatform.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final QuestionConverter questionConverter;

    public Question save(QuestionDto questionDto) {
        Question question = questionConverter.convertToQuestionDto(questionDto);
        return questionRepository.save(question);
    }

    public List<Question> getAll() {
        return questionRepository.findAll();
    }
}
