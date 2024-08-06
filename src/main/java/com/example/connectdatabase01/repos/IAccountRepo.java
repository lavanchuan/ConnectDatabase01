package com.example.connectdatabase01.repos;

import com.example.connectdatabase01.models.DAO.AccountDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRepo extends JpaRepository<AccountDAO, Integer> {
}
