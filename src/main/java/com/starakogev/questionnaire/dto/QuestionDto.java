package com.starakogev.questionnaire.dto;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionDto {
    private Long id;
    private String question;
    private String answerOne;
    private String answerTwo;
    private Long questionnaireId;
}
