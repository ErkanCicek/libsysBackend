package com.libsysbackend.libsysbackend.personnelSide.dao;

import com.libsysbackend.libsysbackend.personnelSide.model.BookLib;
import com.libsysbackend.libsysbackend.personnelSide.model.BorrowedBooksLib;
import com.libsysbackend.libsysbackend.personnelSide.model.Librarian;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class BorrowedBooksLibDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	public List<BorrowedBooksLib> getAllBorrowedBooks() {
		String query = "SELECT * FROM borrowedbooks";
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);
		List<BorrowedBooksLib> borrowedBooksList = new ArrayList<>();
		
		for (Map<String, Object> row : rows) {
			BorrowedBooksLib borrowedBooksLib =
					new BorrowedBooksLib(Integer.parseInt(row.get("borrowedBooksID").toString()),
					(String) row.get("returnDate"),
					(String) row.get("borrowerSSN"),
					(Integer.parseInt(row.get("bookId").toString())),
					(String) row.get("bookISBN"));
			borrowedBooksList.add(borrowedBooksLib);
		}
		return borrowedBooksList;
	}
}
