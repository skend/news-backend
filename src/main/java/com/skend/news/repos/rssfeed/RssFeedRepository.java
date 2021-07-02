package com.skend.news.repos.rssfeed;

import com.skend.news.entities.RssFeed;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RssFeedRepository extends MongoRepository<RssFeed, String>, RssFeedCustomRepository {}
