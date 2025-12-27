package com.examly.springapp.service;

import com.examly.springapp.model.AccountStatusLog;
import com.examly.springapp.repository.AccountStatusLogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AccountStatusLogServiceImpl implements AccountStatusLogService {

    @Autowired
    private AccountStatusLogRepo repository;

    @Override
    public AccountStatusLog save(AccountStatusLog log) {
        return repository.save(log);
    }

    @Override
    public List<AccountStatusLog> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<AccountStatusLog> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public AccountStatusLog update(Long id, AccountStatusLog log) {
        log.setId(id);
        return repository.save(log);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

