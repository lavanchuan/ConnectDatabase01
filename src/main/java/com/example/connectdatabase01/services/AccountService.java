package com.example.connectdatabase01.services;

import com.example.connectdatabase01.models.DTO.AccountDTO;
import com.example.connectdatabase01.models.mappers.AccountMapper;
import com.example.connectdatabase01.repos.DbContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class AccountService {

    @Autowired
    DbContext dbContext;

    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(dbContext.accountRepo.findAll()
                .stream().map(AccountMapper::toDTO)
                .collect(Collectors.toList()));
    }

    public ResponseEntity<?> add(AccountDTO request){
        return ResponseEntity.ok(AccountMapper.toDTO(dbContext.accountRepo
                .save(AccountMapper.toDAO(request, dbContext))));
    }
}
