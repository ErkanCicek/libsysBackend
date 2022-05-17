package com.libsysbackend.libsysbackend.entity.Book;

import org.springframework.stereotype.Service;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@Service
public record BookService(BookDAO bookDAO) {

	public String getBookByIsbnAndBookId(String isbn_in, int bookId) {
		return this.bookDAO.getBookByIsbnAndBookId(isbn_in, bookId);
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

	public String updateBookByISBN(int bookId, String isbn_in, String newtTitle, String newBookDesc, int newAuthorId, int newGenreId){
		return this.bookDAO.updateBookByIsbnAndBookId(bookId, isbn_in, URLDecoder.decode(newtTitle, StandardCharsets.UTF_8), URLDecoder.decode(newBookDesc, StandardCharsets.UTF_8), newAuthorId, newGenreId);
	}

	public String insertBook(String isbn_in, String title, String bookDesc, int authorID, int genreID){
		return bookDAO.insertBook(isbn_in, URLDecoder.decode(title, StandardCharsets.UTF_8), URLDecoder.decode(bookDesc, StandardCharsets.UTF_8), authorID, genreID);
	}

	public String reserveBook(int bookId, String isbn_in, boolean isBookAvailable){
		return this.bookDAO.reservedBookUpdate(bookId,isbn_in, isBookAvailable);
	}

	public Integer countBookByIsbn(String isbn){
		return this.bookDAO.countBookByIsbn(isbn);
	}

	public String getBookByISBN(String isbn){
		return this.bookDAO.getBookByISBN(isbn);
	}
}
