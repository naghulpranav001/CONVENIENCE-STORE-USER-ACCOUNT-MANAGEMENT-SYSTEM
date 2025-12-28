package com.examly.springapp.service;

import com.examly.springapp.model.UserRoleMapping;
import com.examly.springapp.repository.UserRoleMappingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserRoleMappingServiceImpl implements UserRoleMappingService {
    
    @Autowired
    private UserRoleMappingRepo userRoleMappingRepo;
    
    @Override
    public UserRoleMapping save(UserRoleMapping userRoleMapping) {
        return userRoleMappingRepo.save(userRoleMapping);
    }
    
    @Override
    public List<UserRoleMapping> findAll() {
        return userRoleMappingRepo.findAll();
    }
    
    @Override
    public Optional<UserRoleMapping> findById(Long id) {
        return userRoleMappingRepo.findById(id);
    }
    
    @Override
    public UserRoleMapping update(Long id, UserRoleMapping userRoleMapping) {
        userRoleMapping.setId(id);
        return userRoleMappingRepo.save(userRoleMapping);
    }
    
    @Override
    public void deleteById(Long id) {
        userRoleMappingRepo.deleteById(id);
    }
    
    @Override
    public List<UserRoleMapping> findByUserId(Long userId) {
        return userRoleMappingRepo.findByUserId(userId);
    }
    
    @Override
    public Optional<UserRoleMapping> findByUserIdAndRoleId(Long userId, Long roleId) {
        return userRoleMappingRepo.findByUserIdAndRoleId(userId, roleId);
    }
}