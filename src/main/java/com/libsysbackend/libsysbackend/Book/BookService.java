package com.libsysbackend.libsysbackend.Book;

import com.libsysbackend.libsysbackend.Book.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

	@Autowired
	private BookDAO bookDAO;

	public String getBookByISBN(int isbn_in){
		return this.bookDAO.getBookByISBN(isbn_in);
	}

	public String getAllBooksByGenre(int genreId_in){
		return this.bookDAO.getAllBooksByGenre(genreId_in);
	}

	public String getAllBooksByAuthor(int authorId_in){
		return this.bookDAO.getAllBooksByAuthorId(authorId_in);
	}

	public String getAllBooks(){
		return this.bookDAO.getAllBooks();
	}
}
