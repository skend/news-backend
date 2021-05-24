package com.skend.news.entities;

import com.skend.news.UserType;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class ArticleEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String _id;
    private String title;
    private String author;
    private Date date;
    private String thumbnailFilename;
    private String imageFilename;
    private PublisherEntity publisher;

}
