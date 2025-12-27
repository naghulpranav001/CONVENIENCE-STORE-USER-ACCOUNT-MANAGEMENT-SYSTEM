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
@RequestMapping("/api/logs")
public class AccountStatusLogController {

    @Autowired
    private AccountStatusLogService service;

    @PostMapping
    public ResponseEntity<AccountStatusLog> create(@RequestBody AccountStatusLog log) {
        return new ResponseEntity<>(service.save(log), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AccountStatusLog>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountStatusLog> getById(@PathVariable Long id) {
        Optional<AccountStatusLog> log = service.findById(id);
        return log.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountStatusLog> update(@PathVariable Long id, @RequestBody AccountStatusLog log) {
        return ResponseEntity.ok(service.update(id, log));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

