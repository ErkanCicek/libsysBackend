package com.libsysbackend.libsysbackend.Borrower;

import com.libsysbackend.libsysbackend.Borrower.BorrowerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowerService {

    @Autowired
    BorrowerDAO borrowerDAO;

}
