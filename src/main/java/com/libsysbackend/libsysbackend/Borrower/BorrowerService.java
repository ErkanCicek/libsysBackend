package com.libsysbackend.libsysbackend.Borrower;

import org.springframework.stereotype.Service;

@Service
public record BorrowerService(BorrowerDAO borrowerDAO) {

    public String getAllBorrowers() {
        return this.borrowerDAO.getAllBorrowers();
    }

    public String getBorrowerBySSN(String ssn_in) {
        return this.borrowerDAO.getBorrowerBySSN(ssn_in);
    }

}
