package com.examly.springapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.UserAccount;
import com.examly.springapp.repository.UserAccountRepo;

@RestController
@RequestMapping("/api/users")
public class UserAccountController {

    private final UserAccountRepo repo;

    public UserAccountController(UserAccountRepo repo) {
        this.repo = repo;
    }

    @PostMapping
    public ResponseEntity<UserAccount> createUser(@RequestBody UserAccount user) {
        UserAccount saved = repo.save(user);
        return ResponseEntity.ok(saved); // Day10 expects 200 OK
    }
}
