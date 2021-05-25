package com.skend.news.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Author {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String _id;
    private String name;

    @ManyToOne
    @JoinColumn
    private Publisher publisher;

    private String url;
    private List<Article> articles;

}
