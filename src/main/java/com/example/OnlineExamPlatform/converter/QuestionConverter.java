package com.example.OnlineExamPlatform.converter;

import com.example.OnlineExamPlatform.dto.QuestionDto;
import com.example.OnlineExamPlatform.entity.Question;
import org.springframework.stereotype.Component;

@Component
public class QuestionConverter {

    public Question convertToQuestionDto(QuestionDto questionDto){
        Question question = new Question();
        questionDto.setQuestionText(questionDto.getQuestionText());
        questionDto.setOptions(question.getOptions());
        questionDto.setCorrectAnswer(question.getCorrectAnswer());
        questionDto.setExam(question.getExam());
        return question;
    }
}
