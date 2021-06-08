create table questionnaire_schema.questionnaire
(
    id          bigint primary key,
    name        text unique,
    start_time  timestamp,
    end_time    timestamp,
    description text
)