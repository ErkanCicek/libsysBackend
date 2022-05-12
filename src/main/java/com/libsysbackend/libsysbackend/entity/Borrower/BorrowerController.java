package com.libsysbackend.libsysbackend.entity.Borrower;

import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

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
    @PutMapping("put/borrwerContactBySSN")
    public String updateBorrowerContactBySSN(@RequestParam("value")String ssn_in, @RequestParam("newEpost") String newEpost_in, @RequestParam("newTel") String newTel_in){
        return this.borrowerService.updateBorrowerContactBySSN(ssn_in, URLEncoder.encode(newEpost_in, StandardCharsets.UTF_8), newTel_in);
    }
    @PutMapping("put/borrwerPasswordBySSN")
    public String updateBorrowerPasswordBySSN(@RequestParam("ssnValue") String ssn_in, @RequestParam("newPass") String newPass_in){
        return this.borrowerService.updateBorrowerPasswordBySSN(ssn_in, URLEncoder.encode(newPass_in, StandardCharsets.UTF_8));
    }
}
