package com.skend.news.repos.article;

import com.skend.news.entities.Article;
import com.skend.news.types.SectionType;

import java.util.Date;
import java.util.List;

public interface ArticleCustomRepository {

    List<Article> findArticlesByKeywords(String[] keywords, int limit, int skip);
    List<Article> findArticlesByDate(Date date, int limit, int skip);

}
