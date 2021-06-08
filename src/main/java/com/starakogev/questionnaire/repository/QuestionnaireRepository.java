package com.starakogev.questionnaire.repository;

import com.starakogev.questionnaire.entity.Questionnaire;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionnaireRepository extends CrudRepository<Questionnaire, Long> {

}
