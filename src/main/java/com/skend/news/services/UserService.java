package com.skend.news.services;

import com.skend.news.entities.User;
import com.skend.news.repos.user.UserRepository;
import com.skend.news.util.EncryptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User getUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    public String getUsername() {
        List<User> users = userRepository.findAll();
        return users.get(0).username;
    }

}
