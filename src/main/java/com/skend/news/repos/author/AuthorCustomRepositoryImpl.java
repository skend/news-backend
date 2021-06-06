package com.skend.news.repos.author;

import com.skend.news.entities.Author;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AuthorCustomRepositoryImpl implements AuthorCustomRepository {
    final MongoTemplate mongoTemplate;

    public AuthorCustomRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Author findAuthorByName(String name) {
        final Query query = new Query();
        final List<Criteria> criteria = new ArrayList<>();

        if (name != null && !name.isBlank()) {
            criteria.add(Criteria.where("name").is(name));
        }

        query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[criteria.size()])));

        if (!criteria.isEmpty()) {
            return mongoTemplate.findOne(query, Author.class);
        }

        return null;
    }
}
