package com.examly.springapp.service;

import com.examly.springapp.model.AccountStatusLog;
import java.util.List;
import java.util.Optional;

public interface AccountStatusLogService {
    AccountStatusLog save(AccountStatusLog accountStatusLog);
    List<AccountStatusLog> findAll();
    Optional<AccountStatusLog> findById(Long id);
    AccountStatusLog update(Long id, AccountStatusLog accountStatusLog);
    void deleteById(Long id);
}