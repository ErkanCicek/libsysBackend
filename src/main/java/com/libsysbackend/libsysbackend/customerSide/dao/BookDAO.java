package com.libsysbackend.libsysbackend.customerSide.dao;

import com.google.gson.Gson;
import com.libsysbackend.libsysbackend.customerSide.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class BookDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;


	public String getBookByISBN(int isbn_in){
		String query = "Select * From Book Where ISBN = ? And isBookAvailable = 1";
		Book book = this.jdbcTemplate.queryForObject(query, (rs, rowNum) -> new Book(
				rs.getString("ISBN"),
				rs.getString("title"),
				rs.getString("bookDesc"),
				rs.getInt("authorID"),
				rs.getInt("genreID"),
				rs.getInt("amount")
		), isbn_in);
		return new Gson().toJson(book);
	}

	public String getAllBooksByGenre(int genreId_in){
		String query = "SELECT * FROM book where genreID = " + genreId_in;
		ArrayList<Book>books = new ArrayList<>();
		List<Map<String, Object>> rows = this.jdbcTemplate.queryForList(query);

		for (Map<String, Object> row : rows){
			Book book = new Book(
					(String) row.get("ISBN"),
					(String) row.get("title"),
					(String) row.get("bookDesc"),
					(Integer) row.get("authorID"),
					(Integer) row.get("genreID"),
					(Integer) row.get("amount")
			);
			books.add(book);
		}
		return new Gson().toJson(books);
	}

	public String getAllBooksByAuthorId(int authorId_in){
		String query = "SELECT * FROM book WHERE authorID = " + authorId_in;
		ArrayList<Book>books = new ArrayList<>();
		List<Map<String, Object>>rows = this.jdbcTemplate.queryForList(query);

		for (Map<String, Object> row : rows){
			Book book = new Book(
					(String) row.get("ISBN"),
					(String) row.get("title"),
					(String) row.get("bookDesc"),
					(Integer) row.get("authorID"),
					(Integer) row.get("genreID"),
					(Integer) row.get("amount")
			);
			books.add(book);
		}
		return new Gson().toJson(books);
	}

	public String getAllBooks(){
		String query = "SELECT * FROM book";
		ArrayList<Book>books = new ArrayList<>();
		List<Map<String, Object>> rows = this.jdbcTemplate.queryForList(query);

		for (Map<String, Object> row : rows){
			Book book = new Book(
					(String) row.get("ISBN"),
					(String) row.get("title"),
					(String) row.get("bookDesc"),
					(Integer) row.get("authorID"),
					(Integer) row.get("genreID"),
					(Integer) row.get("amount")
			);
			books.add(book);
		}
		return new Gson().toJson(books);
	}
}
