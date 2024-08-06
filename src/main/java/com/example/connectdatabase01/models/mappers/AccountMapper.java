package com.example.connectdatabase01.models.mappers;

import com.example.connectdatabase01.models.DAO.AccountDAO;
import com.example.connectdatabase01.models.DTO.AccountDTO;
import com.example.connectdatabase01.repos.DbContext;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public static AccountDAO toDAO(AccountDTO dto, DbContext dbContext){
        if(dbContext.accountRepo.existsById(dto.getId())){
            return dbContext.accountRepo.findById(dto.getId()).orElseThrow();
        }


        AccountDAO dao = new AccountDAO();
        if(dto.getFirstname() != null && !dto.getFirstname().isEmpty())
            dao.setFirstname(dto.getFirstname());
        if(dto.getLastname() != null && !dto.getFirstname().isEmpty())
            dao.setLastname(dto.getLastname());
        dao.setUsername(dto.getUsername());
        dao.setPassword(dto.getPassword());

        return dao;
    }

    public static AccountDTO toDTO(AccountDAO dao){
        AccountDTO dto = new AccountDTO();

        dto.setId(dao.getId());
        dto.setFirstname(dao.getFirstname());
        dto.setLastname(dao.getLastname());
        dto.setUsername(dao.getUsername());
        dto.setPassword(dao.getPassword());

        return dto;
    }
}
