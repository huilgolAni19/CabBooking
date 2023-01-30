package com.example.CabApi.controller;

import com.example.CabApi.model.User;
import com.example.CabApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Users")
public class UsersController {

    @Autowired
    UserRepository repository;


    @PostMapping("/registerUser")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        User savedUser = repository.save(user);
        return ResponseEntity.ok(savedUser);
    }
}
