package com.libsysbackend.libsysbackend.entity.BorrowedBooks;

import org.springframework.stereotype.Service;

@Service
public record BorrowedBooksService(BorrowedBooksDAO borrowedBooksDAO) {

    public String insertBorrowedBooks(String returnDate, String bookISBN, String bookId,String borrowerSSN){
        return borrowedBooksDAO.insertBorrowedBooks(returnDate, bookISBN, bookId, borrowerSSN);
    }
    public String getBorrowedBooksBySSN(String ssn_in){
        return this.borrowedBooksDAO.getBorrowedBooksBySSN(ssn_in);
    }
    public String getAllBorrowedBooksBySSN(String SSN){
        return this.borrowedBooksDAO.getAllBorrowedBooksBySSN(SSN);
    }

}
