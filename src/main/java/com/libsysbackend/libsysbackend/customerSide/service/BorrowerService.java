package com.libsysbackend.libsysbackend.customerSide.service;

import com.libsysbackend.libsysbackend.customerSide.dao.BorrowerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowerService {

    @Autowired
    BorrowerDAO borrowerDAO;

    public void insertBorrower(String name, String lastName, String SSN){
        borrowerDAO.insertBorrower(name, lastName, SSN);
    }
}
