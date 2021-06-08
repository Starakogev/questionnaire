create table questionnaire_schema.questions
(
        id bigint primary key,
        question text unique,
        answer_one text,
        answer_two text,
        questionnaire_id bigint references questionnaire_schema.questionnaire(id)
)