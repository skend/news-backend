package com.skend.news.entities;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import java.util.Date;
import java.util.Set;

@Document
@Data
public class Publisher {

    @MongoId
    private ObjectId _id;
    private final String name;
    private final String url;
    private final Date lastQuery;

    @DBRef
    private final Set<Author> authors;

    @DBRef
    private final Set<Article> articles;

}
