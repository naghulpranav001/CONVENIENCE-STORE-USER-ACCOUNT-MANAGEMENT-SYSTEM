package com.examly.springapp.service;

import com.examly.springapp.model.UserRoleMapping;
import java.util.List;
import java.util.Optional;

public interface UserRoleMappingService {
    UserRoleMapping save(UserRoleMapping userRoleMapping);
    List<UserRoleMapping> findAll();
    Optional<UserRoleMapping> findById(Long id);
    UserRoleMapping update(Long id, UserRoleMapping userRoleMapping);
    void deleteById(Long id);
    List<UserRoleMapping> findByUserId(Long userId);
    Optional<UserRoleMapping> findByUserIdAndRoleId(Long userId, Long roleId);
}