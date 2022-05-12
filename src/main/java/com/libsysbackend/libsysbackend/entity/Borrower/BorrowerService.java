package com.libsysbackend.libsysbackend.entity.Borrower;

import com.libsysbackend.libsysbackend.entity.Borrower.BorrowerDAO;
import org.springframework.stereotype.Service;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@Service
public record BorrowerService(BorrowerDAO borrowerDAO) {

    public String getAllBorrowers() {
        return this.borrowerDAO.getAllBorrowers();
    }
    public String getBorrowerBySSN(String ssn_in) {
        return this.borrowerDAO.getBorrowerBySSN(ssn_in);
    }
    public String updateBorrowerContactBySSN(String ssn_in, String newEpost, String newTel){
        return borrowerDAO.updateBorrowerContactBySSN(ssn_in, URLDecoder.decode(newEpost, StandardCharsets.UTF_8), newTel);
    }
    public String updateBorrowerPasswordBySSN(String ssn_in, String newPassword_in){
        return this.borrowerDAO.updateBorrowerPasswordBySSN(ssn_in, URLDecoder.decode(newPassword_in, StandardCharsets.UTF_8));
    }

}
