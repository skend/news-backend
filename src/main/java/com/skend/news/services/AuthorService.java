package com.skend.news.services;

import com.skend.news.entities.Author;
import com.skend.news.repos.author.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Author findAuthorByName(String name) {
        return authorRepository.findAuthorByName(name);
    }
}
