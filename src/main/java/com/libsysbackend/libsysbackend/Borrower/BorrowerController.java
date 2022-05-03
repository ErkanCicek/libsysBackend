package com.libsysbackend.libsysbackend.Borrower;

import com.libsysbackend.libsysbackend.Borrower.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BorrowerController {

    @Autowired
    BorrowerService borrowerService;

    public BorrowerController(BorrowerService borrowerService){
        this.borrowerService = borrowerService;
    }


}
