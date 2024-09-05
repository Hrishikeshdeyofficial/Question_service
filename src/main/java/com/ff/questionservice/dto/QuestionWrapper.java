package com.ff.questionservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuestionWrapper {
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
}
