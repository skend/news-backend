package com.skend.news.entities;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import java.util.Set;

@Data
@Document
public class Author {

    @MongoId
    private ObjectId _id;
    private final String name;

    @DBRef
    private final Publisher publisher;

    private final String url;

    @DBRef
    private final Set<Article> articles;

}
