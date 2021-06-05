package com.skend.news.repos.user;

import com.skend.news.entities.User;

public interface UserCustomRepository {
    public User findUserByUsername(String name);
}
