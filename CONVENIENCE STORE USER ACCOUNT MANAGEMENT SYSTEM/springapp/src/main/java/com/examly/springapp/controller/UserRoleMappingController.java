package com.examly.springapp.controller;

import com.examly.springapp.model.UserRoleMapping;
import com.examly.springapp.service.UserRoleMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/userRoleMappings")
public class UserRoleMappingController {
    
    @Autowired
    private UserRoleMappingService userRoleMappingService;
    
    @PostMapping
    public ResponseEntity<UserRoleMapping> createUserRoleMapping(@RequestBody UserRoleMapping userRoleMapping) {
        UserRoleMapping savedMapping = userRoleMappingService.save(userRoleMapping);
        return new ResponseEntity<>(savedMapping, HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<UserRoleMapping>> getAllUserRoleMappings() {
        List<UserRoleMapping> mappings = userRoleMappingService.findAll();
        return ResponseEntity.ok(mappings);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<UserRoleMapping> getUserRoleMappingById(@PathVariable Long id) {
        Optional<UserRoleMapping> mapping = userRoleMappingService.findById(id);
        return mapping.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<UserRoleMapping> updateUserRoleMapping(@PathVariable Long id, @RequestBody UserRoleMapping userRoleMapping) {
        UserRoleMapping updatedMapping = userRoleMappingService.update(id, userRoleMapping);
        return ResponseEntity.ok(updatedMapping);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserRoleMapping(@PathVariable Long id) {
        userRoleMappingService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserRoleMapping>> getUserRoleMappingsByUserId(@PathVariable Long userId) {
        List<UserRoleMapping> mappings = userRoleMappingService.findByUserId(userId);
        if (mappings.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(mappings);
    }
    
    @GetMapping("/user/{userId}/role/{roleId}")
    public ResponseEntity<UserRoleMapping> getUserRoleMappingByUserIdAndRoleId(@PathVariable Long userId, @PathVariable Long roleId) {
        Optional<UserRoleMapping> mapping = userRoleMappingService.findByUserIdAndRoleId(userId, roleId);
        return mapping.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}