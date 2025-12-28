package com.examly.springapp.service;

import com.examly.springapp.model.Profile;
import java.util.List;
import java.util.Optional;

public interface ProfileService {
    Profile save(Profile profile);
    List<Profile> findAll();
    Optional<Profile> findById(Long id);
    Profile update(Long id, Profile profile);
    void deleteById(Long id);
    List<Profile> findByFirstName(String firstName);
    List<Profile> findByFirstNameAndAddress(String firstName, String address);
}