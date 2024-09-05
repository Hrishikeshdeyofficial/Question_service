package com.ff.questionservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "questions")
public class Question {

    public static final String SEQUENCE_ID = "question_seq";
    @Id
	private long id;
	private String question;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String rightAnswer;
	private String category;
	private String difficultyLevel;
	
}
