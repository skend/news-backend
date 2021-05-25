package com.skend.news.entities;

import com.skend.news.types.SectionType;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Section {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String _id;
    private SectionType section;
    private String description;

    @OneToMany
    private List<Article> articles;

}
