package com.skend.news.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="article")
@Data
public class Article {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="article_id")
    private long _id;
    private String title;
    private String description;
    private Date date;
    private String thumbnailFilename;
    private String imageFilename;

    @ManyToMany
    private Set<Author> authors;

//    @ManyToOne
//    @JoinColumn(name="publisher_id", nullable=false)
//    private Publisher publisher;

    @ManyToMany
    @JoinTable(
            name="article_sections",
            joinColumns = @JoinColumn(name="article_id"),
            inverseJoinColumns = @JoinColumn(name="section_id"))
    private Set<Section> sections;

}
