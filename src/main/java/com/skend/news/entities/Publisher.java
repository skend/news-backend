package com.skend.news.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="publisher")
@Data
public class Publisher {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="publisher_id")
    private long _id;
    private String name;
    private String url;
    private Date lastQuery;

//    @OneToMany(mappedBy="authors")
//    private Set<Author> authors;
//
//    @OneToMany(mappedBy="articles")
//    private Set<Article> articles;

}
