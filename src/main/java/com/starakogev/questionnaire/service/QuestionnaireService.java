package com.starakogev.questionnaire.service;

import com.starakogev.questionnaire.dto.QuestionnaireDto;
import com.starakogev.questionnaire.entity.Questionnaire;
import com.starakogev.questionnaire.repository.QuestionnaireRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionnaireService {

    private final QuestionnaireRepository questionnaireRepository;

    public Questionnaire create(QuestionnaireDto questionnaireDto) {
        Questionnaire questionnaire = Questionnaire.builder()
                .id(questionnaireDto.getId())
                .name(questionnaireDto.getName())
                .startTime(questionnaireDto.getStartTime())
                .endTime(questionnaireDto.getEndTime())
                .description(questionnaireDto.getDescription())
                .build();

        return questionnaireRepository.save(questionnaire);
    }

    public String delete(Long id) {
        questionnaireRepository.deleteById(id);
        return ("Опросник с id: " + id + " успешно удалён.");
    }

    public Questionnaire update(Long id, QuestionnaireDto questionnaireDto) {
        Questionnaire questionnaire = questionnaireRepository.findById(id).get();
        if (questionnaireDto.getName() != null) {
            questionnaire.setName(questionnaireDto.getName());
        }
        if (questionnaireDto.getEndTime() != null) {
            questionnaire.setEndTime(questionnaireDto.getEndTime());
        }
        if (questionnaireDto.getDescription() != null) {
            questionnaire.setDescription(questionnaireDto.getDescription());
        }
        return questionnaireRepository.save(questionnaire);
    }

    public List<Questionnaire> getListOfQuestionnaires() {
        List<Questionnaire> questionnaires = new ArrayList<>();
        questionnaireRepository.findAll().forEach(questionnaires::add);
        return questionnaires;
    }
}
