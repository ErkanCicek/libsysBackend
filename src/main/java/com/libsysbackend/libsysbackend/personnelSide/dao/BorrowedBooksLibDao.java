package com.libsysbackend.libsysbackend.personnelSide.dao;

import com.libsysbackend.libsysbackend.personnelSide.model.BookLib;
import com.libsysbackend.libsysbackend.personnelSide.model.BorrowedBooksLib;
import com.libsysbackend.libsysbackend.personnelSide.model.Librarian;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
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
	
	public void loanBook(String borrowerSSN, String borrowedBookISBN)
	{
		// If a space (" ") was added from frontend it will be replaced by the phrase "WHITESPACEHEREX".
		// This phrase is raplaced back with a space here so that the String takes its original form with spaces included
		// (This was done to fix an annoying bug where the program simply refused to take in spaces in Strings...)
		String borrowerSSNSpaceFixed = borrowerSSN.replace("WHITESPACEHEREX", " ");
		String borrowedBookISBNSpaceFixed = borrowedBookISBN.replace("WHITESPACEHEREX", " ");
		
		
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("loan_book");
		
		Map<String, String> inParameters = new HashMap<>();
		
		inParameters.put("SSN", borrowerSSNSpaceFixed);
		inParameters.put("loanISBN", borrowedBookISBNSpaceFixed);
		
		
		SqlParameterSource in = new MapSqlParameterSource(inParameters);
		
		simpleJdbcCall.execute(in);
	}
	
	public String returnBookByISBN(String bookISBN) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("return_book");
		Integer bookISBNToInt = Integer.parseInt(bookISBN);
		String returnable = String.valueOf(simpleJdbcCall.execute(bookISBNToInt));
		
		return returnable;
	}
	
	public BorrowedBooksLib getBorrowedBookByISBN(String ISBN) {
		String query = "SELECT * FROM borrowedbooks WHERE bookISBN = ? LIMIT 1";
		
		BorrowedBooksLib borrowedBooksLib = jdbcTemplate.queryForObject(query, new RowMapper<BorrowedBooksLib>() {
			@Override
			public BorrowedBooksLib mapRow(ResultSet rs, int rowNum) throws SQLException {
				BorrowedBooksLib borrowedBooksLib = new BorrowedBooksLib(rs.getInt("borrowedBooksID"),
						rs.getString("returnDate"),
						rs.getString("borrowerSSN"),
						rs.getInt("bookId"),
						rs.getString("bookISBN"));
				
				return borrowedBooksLib;
			}
		}, ISBN);
		
		return borrowedBooksLib;
	}
}
