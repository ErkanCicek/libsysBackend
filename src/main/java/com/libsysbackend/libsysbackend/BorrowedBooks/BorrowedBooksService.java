package com.libsysbackend.libsysbackend.BorrowedBooks;

import org.springframework.stereotype.Service;

@Service
public record BorrowedBooksService(BorrowedBooksDAO borrowedBooksDAO) {

    public String insertBorrowedBooks(String returnDate, String bookISBN, String borrowerSSN){
        return borrowedBooksDAO.insertBorrowedBooks(returnDate, bookISBN, borrowerSSN);
    }
}
