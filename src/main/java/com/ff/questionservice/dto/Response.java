package com.ff.questionservice.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Builder
public class Response {
    @Id
    private String id;
    private String question;
    private String answer;
}
