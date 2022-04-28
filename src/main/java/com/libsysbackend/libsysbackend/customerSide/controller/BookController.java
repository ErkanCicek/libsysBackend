package com.libsysbackend.libsysbackend.customerSide.controller;

import com.google.gson.Gson;
import com.libsysbackend.libsysbackend.customerSide.model.Book;
import com.libsysbackend.libsysbackend.customerSide.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

	@Autowired
	BookService bookService;

	public BookController(BookService bookService){
		this.bookService = bookService;
	}

	@GetMapping("getBookByISBN")
	public String getBookByISBN(@RequestParam("value")int isbn_in){
		Book book = new Gson().fromJson(bookService.getBookByISBN(isbn_in), Book.class);
		return book.getTitle();
	}
}
