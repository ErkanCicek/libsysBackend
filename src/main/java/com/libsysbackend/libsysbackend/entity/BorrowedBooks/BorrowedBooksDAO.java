package com.libsysbackend.libsysbackend.entity.BorrowedBooks;

import com.google.gson.Gson;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    public String getBorrowedBooksBySSN(String ssn_in){
    String query = "select borrowedbooks.borrowedBooksID, borrowedbooks.returnDate, borrowedbooks.borrowerSSN, borrowedbooks.bookId, borrowedbooks.bookISBN from borrowedbooks inner join borrower on borrowedbooks.borrowerSSN = borrower.SSN where borrower.SSN = ?";
    BorrowedBooks borrowedBooks = this.jdbcTemplate.queryForObject(query, (rs, rowNum) -> new BorrowedBooks(
            rs.getInt("borrowedBooksID"),
            rs.getString("returnDate"),
            rs.getString("bookISBN"),
            rs.getString("borrowerSSN"),
            rs.getInt("bookId")
    ), ssn_in);
    return new Gson().toJson(borrowedBooks);
    }

    public String getAllBorrowedBooksBySSN(String SSN){
        String query = "select borrowedbooks.borrowedBooksID, borrowedbooks.returnDate, borrowedbooks.borrowerSSN, borrowedbooks.bookId, borrowedbooks.bookISBN from borrowedbooks inner join borrower on borrowedbooks.borrowerSSN = borrower.SSN where borrower.SSN = " + SSN;
        ArrayList<BorrowedBooks>borrowedBooks = new ArrayList<>();
        List<Map<String, Object>> rows = this.jdbcTemplate.queryForList(query);
        for (Map<String , Object> row : rows){
            BorrowedBooks borrowedBooks1 = new BorrowedBooks(
                    (int) row.get("borrowedBooksID"),
                    (String) row.get("returnDate"),
                    (String) row.get("bookISBN"),
                    (String) row.get("borrowerSSN"),
                    (int)row.get("bookId")
            );
            borrowedBooks.add(borrowedBooks1);
        }
        return new Gson().toJson(borrowedBooks);
    }
}
