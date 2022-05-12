package com.libsysbackend.libsysbackend.entity.Book;

import com.google.gson.Gson;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class BookDAO {

	private final JdbcTemplate jdbcTemplate;

	public BookDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public String getBookByISBN(String isbn_in){
		try {
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
		} catch (EmptyResultDataAccessException e){
			return "boken finns ej";
		}
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
	public String insertBook(String isbn_in, String title, String bookDesc, int authorID, int genreID, int amount){
		String query = "INSERT IGNORE INTO book(isbn, title, bookdesc, authorid, genreid, amount, isbookavailable) VALUE (?,?,?,?,?,?,?)";
		if (this.jdbcTemplate.update(query, isbn_in, title, bookDesc, authorID, genreID, amount, true) > 0){
			return "book has been added to the database";
		}else{
			return "could not add book: " +
					"this book already exists";
		}
	}
	/*
	public String deleteBookByISBN(String isbn_in){
		String query = "DELETE FROM book WHERE book.ISBN = ?";
		if (this.jdbcTemplate.update(query, isbn_in) > 0){
			return "book deleted";
		}
		return "book could not be deleted";
	} //NOT IN USE*/ //METHOD NOT IN USE
	public String updateBookByISBN(String isbn_in, String newtTitle, String newBookDesc, int newAuthorId, int newGenreId, int newAmount){
		String query = "UPDATE book SET title = ?, bookdesc = ?, authorid = ?, genreId=?, amount = ? WHERE isbn = ?;";
		if (this.jdbcTemplate.update(query,newtTitle, newBookDesc, newAuthorId, newGenreId, newAmount, isbn_in) > 0){
			return "book updated";
		}
		return "could not update book";
	}

	public String updateBookByISBN2(String isbn_in, String newtTitle, String newBookDesc, int newAuthorId, int newGenreId, int newAmount, boolean isBookAvailable){
		String query = "UPDATE book SET title = ?, bookdesc = ?, authorid = ?, genreId=?, amount = ?, isBookAvailable = ? WHERE isbn = ?;";
		if (this.jdbcTemplate.update(query,newtTitle, newBookDesc, newAuthorId, newGenreId, newAmount, isBookAvailable, isbn_in) > 0){
			return "book updated";
		}
		return "could not update book";
	}

}
