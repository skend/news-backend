package com.skend.news.entities;

import com.skend.news.types.SectionType;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="section")
@Data
public class Section {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="section_id")
    private long _id;
    private SectionType section;
    private String description;

    @ManyToMany
    private List<Article> articles;

}
