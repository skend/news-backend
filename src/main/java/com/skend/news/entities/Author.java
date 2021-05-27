package com.skend.news.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="author")
@Data
public class Author {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="author_id")
    private long _id;
    private String name;

//    @ManyToOne
//    @JoinColumn(name="publisher_id", nullable=false)
//    private Publisher publisher;

    private String url;

    @ManyToMany
    @JoinTable(
            name="author_articles",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "article_id"))
    private Set<Article> articles;

}
