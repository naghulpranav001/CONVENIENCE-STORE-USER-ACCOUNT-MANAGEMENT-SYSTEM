package com.examly.springapp.service;

import com.examly.springapp.model.Role;
import com.examly.springapp.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    
    @Autowired
    private RoleRepo roleRepo;
    
    @Override
    public Role save(Role role) {
        return roleRepo.save(role);
    }
    
    @Override
    public List<Role> findAll() {
        return roleRepo.findAll();
    }
    
    @Override
    public Optional<Role> findById(Long id) {
        return roleRepo.findById(id);
    }
    
    @Override
    public Role update(Long id, Role role) {
        role.setId(id);
        return roleRepo.save(role);
    }
    
    @Override
    public void deleteById(Long id) {
        roleRepo.deleteById(id);
    }
    
    @Override
    public Page<Role> findAll(Pageable pageable) {
        return roleRepo.findAll(pageable);
    }
}