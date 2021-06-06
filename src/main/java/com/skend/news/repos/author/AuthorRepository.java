package com.skend.news.repos.author;

import com.skend.news.entities.Author;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository  extends MongoRepository<Author, String>, AuthorCustomRepository {}
