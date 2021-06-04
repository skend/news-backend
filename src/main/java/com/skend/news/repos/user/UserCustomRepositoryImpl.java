package com.skend.news.repos.user;

import com.skend.news.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserCustomRepositoryImpl implements UserCustomRepository {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public User findUserByUsername(byte[] name) {
        final Query query = new Query();
        final List<Criteria> criteria = new ArrayList<>();

        if (name != null && name.length > 0) {
            criteria.add(Criteria.where("username").is(name));
        }

        query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[criteria.size()])));

        if (!criteria.isEmpty()) {
            return mongoTemplate.findOne(query, User.class);
        }

        return null;
    }
}
