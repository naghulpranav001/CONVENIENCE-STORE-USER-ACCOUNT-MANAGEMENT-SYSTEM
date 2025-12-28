package com.examly.springapp.controller;

import com.examly.springapp.model.AccountStatusLog;
import com.examly.springapp.service.AccountStatusLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/accountStatusLogs")
public class AccountStatusLogController {
    
    @Autowired
    private AccountStatusLogService accountStatusLogService;
    
    @PostMapping
    public ResponseEntity<AccountStatusLog> createAccountStatusLog(@RequestBody AccountStatusLog accountStatusLog) {
        AccountStatusLog savedLog = accountStatusLogService.save(accountStatusLog);
        return new ResponseEntity<>(savedLog, HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<AccountStatusLog>> getAllAccountStatusLogs() {
        List<AccountStatusLog> logs = accountStatusLogService.findAll();
        return ResponseEntity.ok(logs);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<AccountStatusLog> getAccountStatusLogById(@PathVariable Long id) {
        Optional<AccountStatusLog> log = accountStatusLogService.findById(id);
        return log.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<AccountStatusLog> updateAccountStatusLog(@PathVariable Long id, @RequestBody AccountStatusLog accountStatusLog) {
        AccountStatusLog updatedLog = accountStatusLogService.update(id, accountStatusLog);
        return ResponseEntity.ok(updatedLog);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccountStatusLog(@PathVariable Long id) {
        accountStatusLogService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}