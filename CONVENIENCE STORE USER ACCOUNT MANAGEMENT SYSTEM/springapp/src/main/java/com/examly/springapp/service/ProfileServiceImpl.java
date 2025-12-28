package com.examly.springapp.service;

import com.examly.springapp.model.Profile;
import com.examly.springapp.repository.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService {
    
    @Autowired
    private ProfileRepo profileRepo;
    
    @Override
    public Profile save(Profile profile) {
        return profileRepo.save(profile);
    }
    
    @Override
    public List<Profile> findAll() {
        return profileRepo.findAll();
    }
    
    @Override
    public Optional<Profile> findById(Long id) {
        return profileRepo.findById(id);
    }
    
    @Override
    public Profile update(Long id, Profile profile) {
        profile.setId(id);
        return profileRepo.save(profile);
    }
    
    @Override
    public void deleteById(Long id) {
        profileRepo.deleteById(id);
    }
    
    @Override
    public List<Profile> findByFirstName(String firstName) {
        return profileRepo.findByFirstName(firstName);
    }
    
    @Override
    public List<Profile> findByFirstNameAndAddress(String firstName, String address) {
        return profileRepo.findByFirstNameAndAddress(firstName, address);
    }
}