package com.skend.news.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Publisher {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String _id;
    private String name;
    private String url;
    private Date lastQuery;

    @OneToMany
    @JoinColumn
    private List<Author> authors;

    @OneToMany
    @JoinColumn
    private List<Article> articles;

}
