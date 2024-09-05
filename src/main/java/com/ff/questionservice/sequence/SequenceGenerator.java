package com.ff.questionservice.sequence;


import com.ff.questionservice.entity.Sequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class SequenceGenerator {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private MongoOperations mongoOperations;

    public long getSequenceNumber(String sequenceName)
    {
        Query query = new Query(Criteria.where("id").is(sequenceName));
        Update update = new Update().inc("count",1);

        Sequence sequence = mongoTemplate.findAndModify(query, update, new FindAndModifyOptions().returnNew(true).upsert(true), Sequence.class);
//        if(sequence != null)
//        {
//            return mongoTemplate.save(sequence).getCount();
//        }
//        else{
//            Sequence seq = new Sequence("question_seq", 1L);
//           mongoTemplate.save(seq).getCount();
//            return seq.getCount();
//        }

        return Objects.nonNull(sequence)?sequence.getCount():1L;


    }
}
