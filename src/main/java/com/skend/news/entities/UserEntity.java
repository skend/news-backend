package com.skend.news.entities;

import com.skend.news.types.UserType;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String _id;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserType userType;

}
