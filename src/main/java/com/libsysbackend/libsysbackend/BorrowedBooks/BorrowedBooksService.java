package com.libsysbackend.libsysbackend.BorrowedBooks;

import org.springframework.stereotype.Service;

@Service
public record BorrowedBooksService(BorrowedBooksDAO borrowedBooksDAO) {

    public String insertBorrowedBooks(String returnDate, String SSN, String ISBN){
        return borrowedBooksDAO.insertBorrowedBooks(returnDate, SSN, ISBN);
    }
}
