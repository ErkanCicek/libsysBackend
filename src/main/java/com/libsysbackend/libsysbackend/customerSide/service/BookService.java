package com.libsysbackend.libsysbackend.customerSide.service;

import com.google.gson.Gson;
import com.libsysbackend.libsysbackend.customerSide.dao.BookDAO;
import com.libsysbackend.libsysbackend.customerSide.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BookService {

	@Autowired
	private BookDAO bookDAO;

	public String getBookByISBN(int isbn_in){
		return bookDAO.getBookByISBN(isbn_in);
	}

	public String getAllBooksByGenre(int genreId_in){
		return bookDAO.getAllBooksByGenre(genreId_in);
	}

	public String getAllBooksByAuthor(int authorId_in){
		return bookDAO.getAllBooksByAuthorId(authorId_in);
	}

	public String getAllBooks(){
		return bookDAO.getAllBooks();
	}
}
