package com.skend.news.services;

import com.skend.news.entities.Article;
import com.skend.news.repos.article.ArticleRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Log
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Article addArticle(Article article) {
        log.info("Adding article with id: " + article.get_id());
        return articleRepository.save(article);
    }

    public List<Article> getArticlesByKeywords(String keywords, int limit, int skip) {
        log.info("Getting article with keywords: '" + keywords + "'");
        return articleRepository.findArticlesByKeywords(keywords.split(" "), limit, skip);
    }

    public List<Article> getArticlesByDate(Date date, int limit, int skip) {
        log.info("Getting article with date: " + date.toString());
        return articleRepository.findArticlesByDate(date, limit, skip);
    }

}
