package com.example.connectdatabase01.controllers;

import com.example.connectdatabase01.models.DTO.AccountDTO;
import com.example.connectdatabase01.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    AccountService accountService;

    @GetMapping("")
    public String getName() {
        return "Name";
    }

    @GetMapping("/accounts")
    public ResponseEntity<?> accountAll(){
        return accountService.findAll();
    }

    @GetMapping("/account-add")
    public ResponseEntity<?> accountAdd(@RequestParam(name = "firstname", defaultValue = "firstname") String firstname,
                                        @RequestParam(name = "lastname", defaultValue = "lastname") String lastname,
                                        @RequestParam(name = "username", required = true) String username,
                                        @RequestParam(name = "password", defaultValue = "password") String password){
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setFirstname(firstname);
        accountDTO.setLastname(lastname);
        accountDTO.setUsername(username);
        accountDTO.setPassword(password);
        return accountService.add(accountDTO);
    }
}
