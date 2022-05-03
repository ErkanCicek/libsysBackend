package com.libsysbackend.libsysbackend.Borrower;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BorrowerDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;


}
