package com.skend.news.entities;

import com.skend.news.types.SectionType;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import java.util.List;

@Document
@Data
public class Section {

    @MongoId
    private ObjectId _id;
    private final SectionType section;
    private final String description;

    @DBRef
    private final List<Article> articles;

}
