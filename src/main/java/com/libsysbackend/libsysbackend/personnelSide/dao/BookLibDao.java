package com.libsysbackend.libsysbackend.personnelSide.dao;

import com.libsysbackend.libsysbackend.personnelSide.model.BookLib;
import com.libsysbackend.libsysbackend.personnelSide.model.BorrowedBooksLib;
import com.libsysbackend.libsysbackend.personnelSide.model.BorrowerLib;
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
public class BookLibDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public BookLib getBookByISBN(String ISBN) {
		String query = "SELECT * FROM book WHERE ISBN = ? LIMIT 1";
		
		BookLib bookLib = jdbcTemplate.queryForObject(query, new RowMapper<BookLib>() {
			@Override
			public BookLib mapRow(ResultSet rs, int rowNum) throws SQLException {
				BookLib bookLib = new BookLib(rs.getInt("bookID"),
						rs.getString("ISBN"),
						rs.getString("title"),
						rs.getString("bookDesc"),
						rs.getString("authorID"),
						rs.getString("genreID"),
						rs.getString("isBookAvailable"));
				
				return bookLib;
			}
		}, ISBN);
		
		return bookLib;
	}
	
	public BookLib getBookByTitle(String title) {
		String query = "SELECT * FROM book WHERE title = ? LIMIT 1";
		
		BookLib bookLib = jdbcTemplate.queryForObject(query, new RowMapper<BookLib>() {
			@Override
			public BookLib mapRow(ResultSet rs, int rowNum) throws SQLException {
				BookLib bookLib = new BookLib(rs.getInt("bookID"),
						rs.getString("ISBN"),
						rs.getString("title"),
						rs.getString("bookDesc"),
						rs.getString("authorID"),
						rs.getString("genreID"),
						rs.getString("isBookAvailable"));
				
				return bookLib;
			}
		}, title);
		
		return bookLib;
	}
	
	public BookLib getBookByAuthorName(String authorName) {
		
		String query = "SELECT * FROM book INNER JOIN author USING (authorID) WHERE authorName = ? LIMIT 1";
		
		BookLib bookLib = jdbcTemplate.queryForObject(query, new RowMapper<BookLib>() {
			@Override
			public BookLib mapRow(ResultSet rs, int rowNum) throws SQLException {
				BookLib bookLib = new BookLib(rs.getInt("bookID"),
						rs.getString("ISBN"),
						rs.getString("title"),
						rs.getString("bookDesc"),
						rs.getString("authorID"),
						rs.getString("genreID"),
						rs.getString("isBookAvailable"));
				
				return bookLib;
			}
		}, authorName);
		
		return bookLib;
	}
	
	public BookLib getBookByGenreName(String genreName) {
		String query = "SELECT * FROM book INNER JOIN genre USING (genreID) WHERE genreName = ? LIMIT 1";
		
		
		
		BookLib bookLib = jdbcTemplate.queryForObject(query, new RowMapper<BookLib>() {
			@Override
			public BookLib mapRow(ResultSet rs, int rowNum) throws SQLException {
				BookLib bookLib = new BookLib(rs.getInt("bookID"),
						rs.getString("ISBN"),
						rs.getString("title"),
						rs.getString("bookDesc"),
						rs.getString("authorID"),
						rs.getString("genreID"),
						rs.getString("isBookAvailable"));
				
				return bookLib;
			}
		}, genreName);
		
		return bookLib;
	}
	
	public String deleteBookByID(String bookID) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("delete_book");
		Integer bookIDToInt = Integer.parseInt(bookID);
		String returnable = String.valueOf(simpleJdbcCall.execute(bookIDToInt));
		
		return returnable;
	}
	
	public void addBook(String ISBN, String title, String bookDesc, String authorID, String genreID)
	{
		// If a space (" ") was added from frontend it will be replaced by the phrase "WHITESPACEHEREX".
		// This phrase is raplaced back with a space here so that the String takes its original form with spaces included
		// (This was done to fix an annoying bug where the program simply refused to take in spaces in Strings...)
		String bookISBNSpaceFixed = ISBN.replace("WHITESPACEHEREX", " ");
		String bookTitleSpaceFixed = title.replace("WHITESPACEHEREX", " ");
		String bookDescSpaceFixed = bookDesc.replace("WHITESPACEHEREX", " ");
		String bookAuthorSpaceFixed = authorID.replace("WHITESPACEHEREX", " ");
		String bookGenreSpaceFixed = genreID.replace("WHITESPACEHEREX", " ");
		
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("add_book");
		
		Map<String, String> inParameters = new HashMap<>();
		
		inParameters.put("ISBN", bookISBNSpaceFixed);
		inParameters.put("title", bookTitleSpaceFixed);
		inParameters.put("bookDesc", bookDescSpaceFixed);
		inParameters.put("authorID", bookAuthorSpaceFixed);
		inParameters.put("genreID", bookGenreSpaceFixed);
		
		SqlParameterSource in = new MapSqlParameterSource(inParameters);
		
		simpleJdbcCall.execute(in);
	}
	
	public void addAuthor(String authorName)
	{
		// If a space (" ") was added from frontend it will be replaced by the phrase "WHITESPACEHEREX".
		// This phrase is raplaced back with a space here so that the String takes its original form with spaces included
		// (This was done to fix an annoying bug where the program simply refused to take in spaces in Strings...)
		String authorNameSpaceFixed = authorName.replace("WHITESPACEHEREX", " ");
		
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("add_author");
		
		Map<String, String> inParameters = new HashMap<>();
		
		inParameters.put("authorName", authorNameSpaceFixed);
		
		SqlParameterSource in = new MapSqlParameterSource(inParameters);
		
		simpleJdbcCall.execute(in);
	}
	
	public String deleteAuthorByID(String authorID) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("delete_author");
		Integer authorIDToInt = Integer.parseInt(authorID);
		String returnable = String.valueOf(simpleJdbcCall.execute(authorIDToInt));
		
		return returnable;
	}
	
	public void addGenre(String genreName, String genreDesc)
	{
		// If a space (" ") was added from frontend it will be replaced by the phrase "WHITESPACEHEREX".
		// This phrase is raplaced back with a space here so that the String takes its original form with spaces included
		// (This was done to fix an annoying bug where the program simply refused to take in spaces in Strings...)
		String genreNameSpaceFixed = genreName.replace("WHITESPACEHEREX", " ");
		String genreDescSpaceFixed = genreDesc.replace("WHITESPACEHEREX", " ");
		
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("add_genre");
		
		Map<String, String> inParameters = new HashMap<>();
		
		inParameters.put("genreName", genreNameSpaceFixed);
		inParameters.put("genreDesc", genreDescSpaceFixed);
		
		SqlParameterSource in = new MapSqlParameterSource(inParameters);
		
		simpleJdbcCall.execute(in);
	}
	
	public String deleteGenreByID(String genreID) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("delete_genre");
		Integer authorIDToInt = Integer.parseInt(genreID);
		String returnable = String.valueOf(simpleJdbcCall.execute(authorIDToInt));
		
		return returnable;
	}
}