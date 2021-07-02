package com.skend.news.entities;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Set;

@Document
@Data
public class RssFeed {

    @MongoId
    private ObjectId _id;
    private final String name;
    private final String url;

    @DBRef
    private final Set<Section> sections;

    @DBRef
    private Publisher publisher;

}
