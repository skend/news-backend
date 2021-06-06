package com.skend.news.controllers;

import com.skend.news.entities.Article;
import com.skend.news.services.ArticleService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Log
@RestController
@RequestMapping("/article")
@CrossOrigin("*")
public class ArticleController {

    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public ResponseEntity<?> getArticlesByKeywords(@RequestParam String words,
                                                   @RequestParam(required=false) int limit,
                                                   @RequestParam(required=false) int skip) {
        return ResponseEntity.ok().body(articleService.getArticlesByKeywords(words, limit, skip));
    }

    @GetMapping
    public ResponseEntity<?> getArticlesByDate(@RequestParam Date date,
                                               @RequestParam(required=false) int limit,
                                               @RequestParam(required=false) int skip) {
        return ResponseEntity.ok().body(articleService.getArticlesByDate(date, limit, skip));
    }

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody Article article) {
        return ResponseEntity.ok().body(articleService.addArticle(article));
    }

}
