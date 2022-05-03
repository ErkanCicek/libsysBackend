package com.libsysbackend.libsysbackend.Book;

import com.google.gson.Gson;
import com.libsysbackend.libsysbackend.Author.Author;
import com.libsysbackend.libsysbackend.Genre.Genre;
import com.libsysbackend.libsysbackend.Author.AuthorService;
import com.libsysbackend.libsysbackend.Genre.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

	@Autowired
	BookService bookService;

	//GET
	@GetMapping("getBook/byISBN")
	public String getBookByISBN(@RequestParam("value")int isbn_in){
		return this.bookService.getBookByISBN(isbn_in);
	}

	@GetMapping("getBooks/byGenre")
	public String getBooksByGenre(@RequestParam ("id")int id_in){
		return this.bookService.getAllBooksByGenre(id_in);
	}

	@GetMapping("getBooks/byAuthor")
	public String getBooksByAuthor(@RequestParam("Id") int id_in){
		return this.bookService.getAllBooksByAuthor(id_in);
	}

	@GetMapping("getBooks/all")
	public String getAllBooks(){
		return this.bookService.getAllBooks();
	}
	//END OF GET
}
