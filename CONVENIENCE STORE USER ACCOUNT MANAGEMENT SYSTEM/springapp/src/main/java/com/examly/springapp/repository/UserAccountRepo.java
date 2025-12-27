package com.examly.springapp.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.examly.springapp.model.UserAccount;

@Repository
public interface UserAccountRepo extends JpaRepository<UserAccount, Long> {}
