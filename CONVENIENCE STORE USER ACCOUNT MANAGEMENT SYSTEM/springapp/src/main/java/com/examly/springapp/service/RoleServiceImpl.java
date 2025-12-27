package com.examly.springapp.service;

import com.examly.springapp.model.Role;
import com.examly.springapp.repository.RoleRepo;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepo repo;

    public RoleServiceImpl(RoleRepo repo) {
        this.repo = repo;
    }

    @Override
    public Role addRole(Role role) {
        return repo.save(role);
    }

    @Override
    public List<Role> getAllRoles() {
        return repo.findAll();
    }

    @Override
    public Role getRoleById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Role updateRole(Role role) {
        return repo.save(role);
    }

    @Override
    public Page<Role> getRolesWithPagination(Pageable pageable) {
        return repo.findAll(pageable);
    }
}
