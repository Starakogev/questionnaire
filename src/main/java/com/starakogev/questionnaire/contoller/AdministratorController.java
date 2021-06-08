package com.starakogev.questionnaire.contoller;

import com.starakogev.questionnaire.dto.QuestionDto;
import com.starakogev.questionnaire.dto.QuestionnaireDto;
import com.starakogev.questionnaire.entity.Question;
import com.starakogev.questionnaire.entity.Questionnaire;
import com.starakogev.questionnaire.service.QuestionService;
import com.starakogev.questionnaire.service.QuestionnaireService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AdministratorController {

    private final QuestionnaireService questionnaireService;
    private final QuestionService questionService;

    @PostMapping("questionnaire/create")
    public Questionnaire createQuestionnaire(@RequestBody QuestionnaireDto questionnaireDto) {
        return questionnaireService.create(questionnaireDto);
    }

    @DeleteMapping("questionnaire/delete/{id}")
    public String deleteQuestionnaire(@PathVariable Long id) {
        return questionnaireService.delete(id);
    }

    @PutMapping("questionnaire/update/{id}")
    public Questionnaire updateQuestionnaire(@PathVariable Long id, @RequestBody QuestionnaireDto questionnaireDto) {
        return questionnaireService.update(id, questionnaireDto);
    }

    @GetMapping("questionnaire/get/all")
    public List<Questionnaire> getListOfQuestionnaires() {
        return questionnaireService.getListOfQuestionnaires();
    }

    @PostMapping("questions/add")
    public Question addQuestion(@RequestBody QuestionDto questionDto) {
        return questionService.addQuestion(questionDto);
    }

    @DeleteMapping("question/delete/{id}")
    public String deleteQuestion(@PathVariable Long id){
        return questionService.deleteQuestion(id);
    }
}
