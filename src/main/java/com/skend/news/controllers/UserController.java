package com.skend.news.controllers;

import com.bol.crypt.CryptVault;
import com.skend.news.entities.User;
import com.skend.news.services.UserService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;

@Log
@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CryptVault cryptVault;

    // TODO: doesn't work lol
    @GetMapping
    public ResponseEntity<?> getUserByUsername(@RequestParam(required=true) String username) {
        return ResponseEntity.ok().body(userService.getUserByUsername(cryptVault.encrypt(username.getBytes())));
    }

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody User user) {
        return ResponseEntity.ok().body(userService.addUser(user));
    }

}
