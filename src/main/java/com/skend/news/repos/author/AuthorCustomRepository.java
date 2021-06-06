package com.skend.news.repos.author;

import com.skend.news.entities.Author;

public interface AuthorCustomRepository {
    public Author findAuthorByName(String name);
}
