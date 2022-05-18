package com.libsysbackend.libsysbackend.entity.BorrowedBooks;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BorrowedBooksDAO {

    private final JdbcTemplate jdbcTemplate;

    public BorrowedBooksDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    public String insertBorrowedBooks(String returnDate, String bookISBN, String bookId,String borrowerSSN ){
        String query = "INSERT IGNORE INTO borrowedbooks(returnDate, bookISBN, bookId, borrowerSSN) VALUE (?,?,?,?)";

        if (jdbcTemplate.update(query, returnDate, bookISBN, bookId ,borrowerSSN) > 0){
            return "Borrower has been added in the database";
        } else {
            return "Could not add this borrower" +
                    "Borrower already exist";
        }
    }
}
