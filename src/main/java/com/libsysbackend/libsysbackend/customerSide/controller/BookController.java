package com.libsysbackend.libsysbackend.customerSide.controller;

import com.google.gson.Gson;
import com.libsysbackend.libsysbackend.customerSide.model.Author;
import com.libsysbackend.libsysbackend.customerSide.model.Genre;
import com.libsysbackend.libsysbackend.customerSide.service.AuthorService;
import com.libsysbackend.libsysbackend.customerSide.service.BookService;
import com.libsysbackend.libsysbackend.customerSide.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

	@Autowired
	BookService bookService;
	@Autowired
	GenreService genreService;
	@Autowired
	AuthorService authorService;


	//GET
	@GetMapping("getBook/byISBN")
	public String getBookByISBN(@RequestParam("value")int isbn_in){
		return bookService.getBookByISBN(isbn_in);
	}

	@GetMapping("getBooks/byGenre")
	public String getBooksByGenre(@RequestParam ("genreName")String genreName_in){
		Genre genre = new Gson().fromJson(genreService.getGenreByName(genreName_in), Genre.class);
		return bookService.getAllBooksByGenre(genre.getGenreID());
	}

	@GetMapping("getBooks/byAuthor")
	public String getBooksByAuthor(@RequestParam("authorName") String authorName_in){
		Author author = new Gson().fromJson(authorService.getAuthorByName(authorName_in), Author.class);
		return bookService.getAllBooksByAuthor(author.getAuthorID());
	}

	@GetMapping("getBooks/all")
	public String getAllBooks(){
		return bookService.getAllBooks();
	}
	//END OF GET
}
