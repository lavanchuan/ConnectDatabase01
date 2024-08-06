package com.example.connectdatabase01.models.DTO;

import lombok.Data;

@Data
public class AccountDTO {
    private int id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
}
