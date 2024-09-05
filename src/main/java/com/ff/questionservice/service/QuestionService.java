package com.ff.questionservice.service;

import com.ff.questionservice.dao.QuestionDao;
import com.ff.questionservice.dto.QuestionWrapper;
import com.ff.questionservice.dto.ResponseStructure;
import com.ff.questionservice.entity.Question;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@Slf4j
public class QuestionService {

//	private static final Logger log = LoggerFactory.getLogger(QuestionService.class);

    @Autowired
    private QuestionDao dao;

    public ResponseEntity<ResponseStructure<Question>> saveQuestion(Question question) {
        Question savedQuestion = dao.save(question);
        ResponseStructure<Question> structure = new ResponseStructure<Question>();
        structure.setStatusCode(HttpStatus.CREATED.value());
        structure.setMessage("Success");
        structure.setData(savedQuestion);
        return new ResponseEntity<ResponseStructure<Question>>(structure, HttpStatus.CREATED);
    }

    public ResponseEntity<ResponseStructure<Question>> getAllQuestion() {
        List<Question> questions = dao.findAll();
        ResponseStructure structure = new ResponseStructure();
        structure.setStatusCode(HttpStatus.OK.value());
        structure.setMessage("OK");
        structure.setData(questions);
        return new ResponseEntity<>(structure, HttpStatus.OK);
    }

    public List<Long> getAllQuestionIds() {
        List<Question> questions = dao.findAll();
        Collections.shuffle(questions);
        List<Long> collect = new ArrayList<>();
        questions.stream().limit(5).forEach((question) -> collect.add(question.getId()));

        return collect;
    }

    public QuestionWrapper getQuestionById(long id) {
        Question questionById = dao.findById(id).get();
		QuestionWrapper wrapper = QuestionWrapper.builder()
				.question(questionById.getQuestion())
				.option1(questionById.getOption1())
				.option2(questionById.getOption2())
				.option3(questionById.getOption3())
				.option4(questionById.getOption4())
				.build();
        System.out.println(wrapper);
			return wrapper;
	}
}
