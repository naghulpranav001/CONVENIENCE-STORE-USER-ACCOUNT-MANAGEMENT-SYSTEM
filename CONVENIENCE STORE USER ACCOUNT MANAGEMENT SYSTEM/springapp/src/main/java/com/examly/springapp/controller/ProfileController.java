package com.examly.springapp.controller;

import com.examly.springapp.model.Profile;
import com.examly.springapp.repository.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    @Autowired
    private ProfileRepo repo;

    // Create
    @PostMapping
    public ResponseEntity<Profile> addProfile(@RequestBody Profile profile){
        Profile saved = repo.save(profile);
        return ResponseEntity.status(201).body(saved);
    }

    // Get All
    @GetMapping
    public ResponseEntity<List<Profile>> getAll(){
        return ResponseEntity.ok(repo.findAll());
    }

    // Get by Id
    @GetMapping("/{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable Long id){
        Optional<Profile> obj = repo.findById(id);
        return obj.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable Long id,
                                                 @RequestBody Profile profile){
        if(!repo.existsById(id))
            return ResponseEntity.notFound().build();

        profile.setId(id);
        return ResponseEntity.ok(repo.save(profile));
    }

    // DAY-12 — Get By Name
    @GetMapping("/name/{name}")
    public ResponseEntity<List<Profile>> getByName(@PathVariable String name){
        return ResponseEntity.ok(repo.findByFirstName(name));
    }

    //  DAY-12 — Get By Name & Address
    @GetMapping("/search/{name}/{address}")
    public ResponseEntity<List<Profile>> getByNameAndAddress(
            @PathVariable String name,
            @PathVariable String address){

        return ResponseEntity.ok(repo.findByFirstNameAndAddress(name, address));
    }
}
