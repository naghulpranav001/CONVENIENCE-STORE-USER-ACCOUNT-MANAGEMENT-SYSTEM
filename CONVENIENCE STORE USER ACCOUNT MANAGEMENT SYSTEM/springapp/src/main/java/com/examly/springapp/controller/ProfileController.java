package com.examly.springapp.controller;

import com.examly.springapp.model.Profile;
import com.examly.springapp.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {
    
    @Autowired
    private ProfileService profileService;
    
    @PostMapping
    public ResponseEntity<Profile> createProfile(@RequestBody Profile profile) {
        Profile savedProfile = profileService.save(profile);
        return new ResponseEntity<>(savedProfile, HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<Profile>> getAllProfiles() {
        List<Profile> profiles = profileService.findAll();
        return ResponseEntity.ok(profiles);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable Long id) {
        Optional<Profile> profile = profileService.findById(id);
        return profile.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable Long id, @RequestBody Profile profile) {
        Profile updatedProfile = profileService.update(id, profile);
        return ResponseEntity.ok(updatedProfile);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfile(@PathVariable Long id) {
        profileService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/name/{firstName}")
    public ResponseEntity<List<Profile>> getProfilesByName(@PathVariable String firstName) {
        List<Profile> profiles = profileService.findByFirstName(firstName);
        return ResponseEntity.ok(profiles);
    }
    
    @GetMapping("/search/{firstName}/{address}")
    public ResponseEntity<List<Profile>> getProfilesByNameAndAddress(@PathVariable String firstName, @PathVariable String address) {
        List<Profile> profiles = profileService.findByFirstNameAndAddress(firstName, address);
        return ResponseEntity.ok(profiles);
    }
}