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
public class Article {

    @MongoId
    private ObjectId _id;
    private final String title;
    private final String description;
    private final Date date;
    private final String thumbnailFilename;
    private final String imageFilename;

    @DBRef
    private final Set<Author> authors;

    @DBRef
    private final Publisher publisher;

    @DBRef
    private final Set<Section> sections;

}
