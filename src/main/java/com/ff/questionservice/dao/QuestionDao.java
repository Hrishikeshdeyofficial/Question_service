package com.ff.questionservice.dao;

import com.ff.questionservice.entity.Question;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends MongoRepository<Question, Long>{

}

