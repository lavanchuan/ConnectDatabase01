package com.example.connectdatabase01.models.DAO;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_account")
@Data
public class AccountDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstname;
    private String lastname;
    @Column(unique = true)
    private String username;
    private String password = "password";
}
