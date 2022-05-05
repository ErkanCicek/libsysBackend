package com.libsysbackend.libsysbackend.Borrower;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("borrower/")
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
    @PutMapping("put/borrwerBySSN")
    public String updateBorrowerBySSN(@RequestParam("value")String ssn_in, @RequestParam("newEpost") String newEpost_in, @RequestParam("newTel") String newTel_in){
        return this.borrowerService.updateBorrowerBySSN(ssn_in, newEpost_in, newTel_in);
    }

}
