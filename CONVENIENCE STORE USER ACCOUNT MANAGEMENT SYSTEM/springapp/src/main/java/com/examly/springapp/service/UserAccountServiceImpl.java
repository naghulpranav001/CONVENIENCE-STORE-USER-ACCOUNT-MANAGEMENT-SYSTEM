package com.examly.springapp.service;

import com.examly.springapp.model.UserAccount;
import com.examly.springapp.repository.UserAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserAccountServiceImpl implements UserAccountService {
    
    @Autowired
    private UserAccountRepo userAccountRepo;
    
    @Override
    public UserAccount save(UserAccount userAccount) {
        return userAccountRepo.save(userAccount);
    }
    
    @Override
    public List<UserAccount> findAll() {
        return userAccountRepo.findAll();
    }
    
    @Override
    public Optional<UserAccount> findById(Long id) {
        return userAccountRepo.findById(id);
    }
    
    @Override
    public UserAccount update(Long id, UserAccount userAccount) {
        userAccount.setId(id);
        return userAccountRepo.save(userAccount);
    }
    
    @Override
    public void deleteById(Long id) {
        userAccountRepo.deleteById(id);
    }
}