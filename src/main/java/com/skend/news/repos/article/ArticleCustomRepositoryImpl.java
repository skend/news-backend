package com.skend.news.repos.article;

import com.skend.news.entities.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleCustomRepositoryImpl implements ArticleCustomRepository {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<Article> findArticlesByKeywords(String[] keywords, int limit, int skip) {
        final Query query = new Query();
        final List<Criteria> criteria = new ArrayList<>();

        for (String keyword : keywords) {
            if (keyword != null && !keyword.isBlank()) {
                criteria.add(Criteria.where("title").is(keyword));
            }
        }

        query.addCriteria(new Criteria().orOperator(criteria.toArray(new Criteria[criteria.size()])));
        query.limit(limit);
        query.skip(skip);

        if (!criteria.isEmpty()) {
            return mongoTemplate.find(query, Article.class);
        }

        return null;
    }

    @Override
    public List<Article> findArticlesByDate(Date date, int limit, int skip) {
        final Query query = new Query();
        final List<Criteria> criteria = new ArrayList<>();

        if (date != null) {
            criteria.add(Criteria.where("date").is(date));
        }

        query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[criteria.size()])));
        query.limit(limit);
        query.skip(skip);

        if (!criteria.isEmpty()) {
            return mongoTemplate.find(query, Article.class);
        }

        return null;
    }
}
