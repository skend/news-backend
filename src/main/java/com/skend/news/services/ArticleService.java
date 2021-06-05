package com.skend.news.services;

import com.skend.news.entities.Article;
import com.skend.news.repos.article.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public Article addArticle(Article article) {
        return articleRepository.save(article);
    }

    public List<Article> getArticlesByKeywords(String[] keywords, int limit, int skip) {
        return articleRepository.findArticlesByKeywords(keywords, limit, skip);
    }

    public List<Article> getArticlesByDate(Date date, int limit, int skip) {
        return articleRepository.findArticlesByDate(date, limit, skip);
    }

}
