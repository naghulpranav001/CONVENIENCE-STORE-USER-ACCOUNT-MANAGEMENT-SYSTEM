package com.examly.springapp.service;

import com.examly.springapp.model.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RoleService {

    Role addRole(Role role);

    List<Role> getAllRoles();

    Role getRoleById(Long id);

    Role updateRole(Role role);

    Page<Role> getRolesWithPagination(Pageable pageable);
}
