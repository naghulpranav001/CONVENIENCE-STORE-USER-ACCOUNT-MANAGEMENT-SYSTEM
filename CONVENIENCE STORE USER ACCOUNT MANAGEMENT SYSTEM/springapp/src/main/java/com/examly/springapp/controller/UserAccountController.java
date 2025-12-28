package com.examly.springapp.controller;

import com.examly.springapp.model.UserAccount;
import com.examly.springapp.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserAccountController {
    
    @Autowired
    private UserAccountService userAccountService;
    
    @PostMapping
    public ResponseEntity<UserAccount> createUser(@RequestBody UserAccount userAccount) {
        UserAccount savedUser = userAccountService.save(userAccount);
        return ResponseEntity.ok(savedUser);
    }
    
    @GetMapping
    public ResponseEntity<List<UserAccount>> getAllUsers() {
        List<UserAccount> users = userAccountService.findAll();
        return ResponseEntity.ok(users);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<UserAccount> getUserById(@PathVariable Long id) {
        Optional<UserAccount> user = userAccountService.findById(id);
        return user.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<UserAccount> updateUser(@PathVariable Long id, @RequestBody UserAccount userAccount) {
        UserAccount updatedUser = userAccountService.update(id, userAccount);
        return ResponseEntity.ok(updatedUser);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userAccountService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}