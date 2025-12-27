package com.examly.springapp.controller;

import com.examly.springapp.model.UserRoleMapping;
import com.examly.springapp.repository.UserRoleMappingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/userRoleMappings")
public class UserRoleMappingController {

    @Autowired
    private UserRoleMappingRepo repo;

    //  Create Mapping
    @PostMapping
    public ResponseEntity<UserRoleMapping> create(@RequestBody UserRoleMapping mapping){
        UserRoleMapping saved = repo.save(mapping);
        return ResponseEntity.status(201).body(saved);
    }

    //  Get All Mappings
    @GetMapping
    public ResponseEntity<List<UserRoleMapping>> getAll(){
        return ResponseEntity.ok(repo.findAll());
    }

    //  Get Mapping By Id
    @GetMapping("/{id}")
    public ResponseEntity<UserRoleMapping> getById(@PathVariable Long id){
        Optional<UserRoleMapping> obj = repo.findById(id);
        return obj.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //  Update Mapping
    @PutMapping("/{id}")
    public ResponseEntity<UserRoleMapping> update(@PathVariable Long id,
                                                  @RequestBody UserRoleMapping mapping){
        if(!repo.existsById(id))
            return ResponseEntity.notFound().build();

        mapping.setId(id);
        return ResponseEntity.ok(repo.save(mapping));
    }

    //  Get By User Id
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserRoleMapping>> getByUserId(@PathVariable Long userId){
        List<UserRoleMapping> list = repo.findByUserId(userId);
        if(list.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(list);
    }

    // Get By User Id AND Role Id
    @GetMapping("/user/{userId}/role/{roleId}")
    public ResponseEntity<UserRoleMapping> getByUserIdAndRoleId(
            @PathVariable Long userId,
            @PathVariable Long roleId){

        return repo.findByUserIdAndRoleId(userId, roleId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
