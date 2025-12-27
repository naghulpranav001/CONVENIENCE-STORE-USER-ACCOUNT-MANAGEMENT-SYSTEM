package com.examly.springapp.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.examly.springapp.model.UserRoleMapping;

@Repository
public interface UserRoleMappingRepo extends JpaRepository<UserRoleMapping, Long> {

    java.util.List<UserRoleMapping> findByUserId(Long userId);
    java.util.Optional<UserRoleMapping> findByUserIdAndRoleId(Long userId, Long roleId);
}
