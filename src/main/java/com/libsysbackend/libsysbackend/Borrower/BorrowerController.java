package com.libsysbackend.libsysbackend.Borrower;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BorrowerController {

    private final BorrowerService borrowerService;

    public BorrowerController(BorrowerService borrowerService) {
        this.borrowerService = borrowerService;
    }

    @GetMapping("get/allBorrowers")
    public String getAllBorrowers(){
        return this.borrowerService.getAllBorrowers();
    }
    @GetMapping("get/borrowerBySSN")
    public String getBorrowerBySSN(@RequestParam("value")String ssn_in){
        return this.borrowerService.getBorrowerBySSN(ssn_in);
    }
}
