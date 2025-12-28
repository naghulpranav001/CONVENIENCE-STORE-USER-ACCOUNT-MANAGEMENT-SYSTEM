package com.examly.springapp.service;

import com.examly.springapp.model.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

public interface RoleService {
    Role save(Role role);
    List<Role> findAll();
    Optional<Role> findById(Long id);
    Role update(Long id, Role role);
    void deleteById(Long id);
    Page<Role> findAll(Pageable pageable);
}