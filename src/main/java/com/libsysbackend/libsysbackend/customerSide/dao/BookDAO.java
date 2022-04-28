package com.libsysbackend.libsysbackend.customerSide.dao;

import com.google.gson.Gson;
import com.libsysbackend.libsysbackend.customerSide.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public BookDAO(){
		this.jdbcTemplate = new JdbcTemplate();
	}

	public String getBookByISBN(int isbn_in){
		String query = "Select * From Book Where ISBN = ? And isBookAvailable = 1";
		Book book = this.jdbcTemplate.queryForObject(query, (rs, rowNum) -> new Book(
				rs.getInt("bookID"),
				rs.getString("title"),
				rs.getString("bookDesc"),
				rs.getInt("authorID"),
				rs.getInt("genreID"),
				rs.getString("ISBN")
		), isbn_in);
		return new Gson().toJson(book);
	}
}
