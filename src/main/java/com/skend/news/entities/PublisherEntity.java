package com.skend.news.entities;

import com.skend.news.UserType;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class PublisherEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String _id;
    private String name;
    private String url;
    private Date lastQuery;
    private List<ArticleEntity> articles;

}
