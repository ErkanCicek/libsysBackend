package com.libsysbackend.libsysbackend.customerSide.dao;

import com.libsysbackend.libsysbackend.customerSide.model.Borrower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BorrowerDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertBorrower(String name, String lastName, String SSN){
        String query = "INSERT INTO borrower (query, name, lastName, SSN)";

        int result = jdbcTemplate.update(query, name, lastName, SSN);

        if (result > 0){
            System.out.println(result + "borrower has been added!");
        }
    }
}
