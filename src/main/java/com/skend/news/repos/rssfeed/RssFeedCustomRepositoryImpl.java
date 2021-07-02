package com.skend.news.repos.rssfeed;

import org.springframework.data.mongodb.core.MongoTemplate;

public class RssFeedCustomRepositoryImpl implements RssFeedCustomRepository {
    final MongoTemplate mongoTemplate;

    public RssFeedCustomRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
}
