package com.skend.news.repos.article;

import com.skend.news.entities.Article;
import com.skend.news.types.SectionType;

import java.util.Date;
import java.util.List;

public interface ArticleCustomRepository {

    List<Article> findArticlesByAuthor(String firstName, String lastName);
    List<Article> findArticlesByPublisher(String publisherName);
    List<Article> findArticlesBySection(SectionType section);
    List<Article> findArticlesByDate(Date date);

}
