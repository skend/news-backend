package com.skend.news.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Article {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String _id;
    private String title;
    private String description;
    private Date date;
    private String thumbnailFilename;
    private String imageFilename;

    @OneToMany
    private Set<Author> authors;

    @ManyToOne
    private Publisher publisher;

    @OneToMany
    private List<Section> sections;

}
