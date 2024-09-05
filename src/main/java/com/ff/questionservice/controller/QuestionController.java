package com.ff.questionservice.controller;

import com.ff.questionservice.dto.QuestionWrapper;
import com.ff.questionservice.dto.ResponseStructure;
import com.ff.questionservice.entity.Question;
import com.ff.questionservice.sequence.SequenceGenerator;
import com.ff.questionservice.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;
    @Autowired
    private SequenceGenerator seq_gen;

    @PostMapping
    public ResponseEntity<ResponseStructure<Question>> saveQuestion(@RequestBody Question question) {
        question.setId(seq_gen.getSequenceNumber(Question.SEQUENCE_ID));
        return questionService.saveQuestion(question);
    }

    @GetMapping
    public ResponseEntity<ResponseStructure<Question>> getAllQuestion() {
        return questionService.getAllQuestion();
    }

    @GetMapping("/Id")
    public List<Long> getAllQuestionIds() {
        return questionService.getAllQuestionIds();
    }

    @GetMapping("{id}")
    public QuestionWrapper getQuestionById(@PathVariable Long id) {
        return questionService.getQuestionById(id);
    }

}

