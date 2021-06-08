package com.starakogev.questionnaire.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(schema = "questionnaire_schema", name = "questions")
public class Question {
    @Id
    private Long id;
    @Column
    private String question;
    @Column
    private String answerOne;
    @Column
    private String answerTwo;
    @ManyToOne
    @JoinColumn(name = "questionnaire_id")
    private Questionnaire questionnaire;
}
