package com.libsysbackend.libsysbackend.customerSide.controller;

import com.libsysbackend.libsysbackend.customerSide.service.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BorrowerController {

    @Autowired
    BorrowerService borrowerService;

    public BorrowerController(BorrowerService borrowerService){
        this.borrowerService = borrowerService;
    }

    @GetMapping("/insertBorrower")
    public void insertBorrower(@RequestParam(value = "name", defaultValue = "No name")String name,
                               @RequestParam(value = "lastName", defaultValue = "No lastName")String lastName,
                               @RequestParam(value = "SSN", defaultValue = "No SSN")String SSN){
        borrowerService.insertBorrower(name, lastName, SSN);
    }
}
