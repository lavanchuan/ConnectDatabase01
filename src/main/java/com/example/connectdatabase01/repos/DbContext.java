package com.example.connectdatabase01.repos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DbContext {

    @Autowired
    public IAccountRepo accountRepo;
}
