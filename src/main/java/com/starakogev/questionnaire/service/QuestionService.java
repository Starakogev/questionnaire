package com.starakogev.questionnaire.service;

import com.starakogev.questionnaire.dto.QuestionDto;
import com.starakogev.questionnaire.entity.Question;
import com.starakogev.questionnaire.repository.QuestionRepository;
import com.starakogev.questionnaire.repository.QuestionnaireRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final QuestionnaireRepository questionnaireRepository;

    public Question addQuestion(QuestionDto questionDto) {
        Question question = Question.builder()
                .id(questionDto.getId())
                .question(questionDto.getQuestion())
                .answerOne(questionDto.getAnswerOne())
                .answerTwo(questionDto.getAnswerTwo())
                .questionnaire(questionnaireRepository.findById(questionDto.getQuestionnaireId()).get())
                .build();

        return questionRepository.save(question);
    }

    public String deleteQuestion(Long id) {
        questionRepository.deleteById(id);
        return ("Вопрос с id: " + id + " успешно удалён.");
    }
}
