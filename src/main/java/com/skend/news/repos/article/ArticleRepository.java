package com.skend.news.repos.article;

import com.skend.news.entities.Article;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends MongoRepository<Article, String>, ArticleCustomRepository {}
