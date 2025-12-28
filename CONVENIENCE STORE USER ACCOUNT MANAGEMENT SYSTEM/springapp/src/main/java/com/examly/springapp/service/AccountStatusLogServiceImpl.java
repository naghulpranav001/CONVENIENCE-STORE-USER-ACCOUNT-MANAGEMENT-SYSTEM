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
    private AccountStatusLogRepo accountStatusLogRepo;
    
    @Override
    public AccountStatusLog save(AccountStatusLog accountStatusLog) {
        return accountStatusLogRepo.save(accountStatusLog);
    }
    
    @Override
    public List<AccountStatusLog> findAll() {
        return accountStatusLogRepo.findAll();
    }
    
    @Override
    public Optional<AccountStatusLog> findById(Long id) {
        return accountStatusLogRepo.findById(id);
    }
    
    @Override
    public AccountStatusLog update(Long id, AccountStatusLog accountStatusLog) {
        accountStatusLog.setId(id);
        return accountStatusLogRepo.save(accountStatusLog);
    }
    
    @Override
    public void deleteById(Long id) {
        accountStatusLogRepo.deleteById(id);
    }
}