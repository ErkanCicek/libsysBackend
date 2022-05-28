package com.libsysbackend.libsysbackend.entity.Book;

import com.google.gson.Gson;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class BookDAO {
	private final JdbcTemplate jdbcTemplate;

	public BookDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public String getBookByIsbnAndBookId(String isbn_in, int bookId){
		try {
			String query = "Select * From Book Where ISBN = ? AND bookId = ? And isBookAvailable = 1";
			Book book = this.jdbcTemplate.queryForObject(query, (rs, rowNum) -> new Book(
					rs.getInt("bookid"),
					rs.getString("ISBN"),
					rs.getString("title"),
					rs.getString("bookDesc"),
					rs.getInt("genreID"),
					rs.getInt("authorID")

			), isbn_in, bookId);
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
					(Integer) row.get("bookID"),
					(String) row.get("ISBN"),
					(String) row.get("title"),
					(String) row.get("bookDesc"),
					(Integer) row.get("authorID"),
					(Integer) row.get("genreID")
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
					(Integer) row.get("bookID"),
					(String) row.get("ISBN"),
					(String) row.get("title"),
					(String) row.get("bookDesc"),
					(Integer) row.get("authorID"),
					(Integer) row.get("genreID")
			);
			books.add(book);
		}
		return new Gson().toJson(books);
	}
	public String getAllBooks(){
		String query = "Select distinct (ISBN), title, bookDesc, isBookAvailable, genreId, authorId from book where book.isBookAvailable = 1";
		ArrayList<Book>books = new ArrayList<>();
		List<Map<String, Object>> rows = this.jdbcTemplate.queryForList(query);

		for (Map<String, Object> row : rows){
			Book book = new Book(
					(String) row.get("ISBN"),
					(String) row.get("title"),
					(String) row.get("bookDesc"),
					(Integer) row.get("authorID"),
					(Integer) row.get("genreID")
			);
			books.add(book);
		}
		return new Gson().toJson(books);
	}
	public String insertBook(String isbn_in, String title, String bookDesc, int authorID, int genreID){
		String query = "INSERT INTO book(isbn, title, bookdesc, authorID, genreID, isbookavailable) VALUE (?,?,?,?,?,?)";
		if (this.jdbcTemplate.update(query, isbn_in, title, bookDesc, authorID, genreID, true) > 0){
			return "book has been added to the database";
		}else{
			return "could not add book: " +
					"this book already exists";
		}
	}
	public String updateBookByIsbnAndBookId(int bookId, String isbn_in, String newtTitle, String newBookDesc, int newAuthorId, int newGenreId){
		String query = "UPDATE book SET title = ?, bookdesc = ?, authorID = ?, genreID=? WHERE isbn = ? AND bookId = ?;";
		if (this.jdbcTemplate.update(query,newtTitle, newBookDesc, newAuthorId, newGenreId, isbn_in, bookId) > 0){
			return "book updated";
		}
		return "could not update book";
	}

	public String reservedBookUpdate(int bookId, String isbn_in){
		SimpleJdbcCall reserveBookProcedure = new SimpleJdbcCall(this.jdbcTemplate).withProcedureName("reserveBook");
		SqlParameterSource in = new MapSqlParameterSource().addValue("bookIsbn", isbn_in).addValue("bookId", bookId);
		reserveBookProcedure.execute(in);
		return "book has been reserved";
	}

	public Integer countBookByIsbn(String isbn_in){
		String query = "SELECT count(bookId) from book where book.ISBN = ? and book.isBookAvailable = 1";
		int test = this.jdbcTemplate.queryForObject(query, Integer.class, isbn_in); //Ignore error
		System.out.println(test);
		return test;
	}

	public String getBookByISBN(String isbn){
		String query = "SELECT * FROM book WHERE ISBN = ? LIMIT 1";
		Book book = this.jdbcTemplate.queryForObject(query, (rs, rowNum) -> new Book(
				rs.getInt("bookid"),
				rs.getString("ISBN"),
				rs.getString("title"),
				rs.getString("bookDesc"),
				rs.getInt("genreID"),
				rs.getInt("authorID")
		), isbn);
		return new Gson().toJson(book);

	}

	public List<Book> getMostPopularAvailableBook(){
		SimpleJdbcCall getMostPopularBooks = new SimpleJdbcCall(this.jdbcTemplate).withProcedureName("getMostPopularBook")
				.returningResultSet("books", new RowMapper<Book>() {
					@Override
					public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
						Book book = new Book();
						book.setISBN(rs.getString("ISBN"));
						book.setTitle(rs.getString("title"));
						book.setBookDesc(rs.getString("bookDesc"));
						book.setGenreID(rs.getInt("genreID"));
						book.setAuthorID(rs.getInt("authorId"));
						book.setBookAvailable(true);
						return book;
					}
				});
		Map<String, Object> out = getMostPopularBooks.execute();
		@SuppressWarnings("unchecked") // The type is supposed to be a book
		List<Book>bookList = (List<Book>) out.get("books");
		return bookList;
	}
}
