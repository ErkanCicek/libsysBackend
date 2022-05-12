package com.libsysbackend.libsysbackend.entity.Book;

import org.springframework.stereotype.Service;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@Service
public record BookService(BookDAO bookDAO) {

	public String getBookByISBN(String isbn_in) {
		return this.bookDAO.getBookByISBN(isbn_in);
	}

	public String getAllBooksByGenre(int genreId_in) {
		return this.bookDAO.getAllBooksByGenre(genreId_in);
	}

	public String getAllBooksByAuthor(int authorId_in) {
		return this.bookDAO.getAllBooksByAuthorId(authorId_in);
	}

	public String getAllBooks() {
		return this.bookDAO.getAllBooks();
	}

	public String updateBookByISBN(String isbn_in, String newtTitle, String newBookDesc, int newAuthorId, int newGenreId, int newAmount){
		return this.bookDAO.updateBookByISBN(isbn_in, URLDecoder.decode(newtTitle, StandardCharsets.UTF_8), URLDecoder.decode(newBookDesc, StandardCharsets.UTF_8), newAuthorId, newGenreId, newAmount);
	}

	public String insertBook(String isbn_in, String title, String bookDesc, int authorID, int genreID, int amount){
		return bookDAO.insertBook(isbn_in, URLDecoder.decode(title, StandardCharsets.UTF_8), URLDecoder.decode(bookDesc, StandardCharsets.UTF_8), authorID, genreID, amount);
	}

	public String updateBookByISBN2(String isbn_in, String newtTitle, String newBookDesc, int newAuthorId, int newGenreId, int newAmount, boolean isBookAvailable){
		return this.bookDAO.updateBookByISBN2(isbn_in, URLDecoder.decode(newtTitle, StandardCharsets.UTF_8), URLDecoder.decode(newBookDesc, StandardCharsets.UTF_8), newAuthorId, newGenreId, newAmount, isBookAvailable);
	}
}
