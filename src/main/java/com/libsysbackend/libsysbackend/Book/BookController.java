package com.libsysbackend.libsysbackend.Book;

import org.apache.catalina.util.URLEncoder;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping(value = "book/", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
public class BookController {

	private final BookService bookService;
	private final URLEncoder encoder = new URLEncoder();

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping("get/bookByISBN")
	public String getBookByISBN(@RequestParam("value")String isbn_in){
		return this.bookService.getBookByISBN(isbn_in);
	}

	@GetMapping("get/booksById")
	public String getBooksByGenre(@RequestParam ("id")int id_in){
		return this.bookService.getAllBooksByGenre(id_in);
	}

	@GetMapping("get/booksByAuthorId")
	public String getBooksByAuthor(@RequestParam("Id") int id_in){
		return this.bookService.getAllBooksByAuthor(id_in);
	}

	@GetMapping("get/allBooks")
	public String getAllBooks(){
		return this.bookService.getAllBooks();
	}

	@PutMapping("put/bookByISBN")
	public String updateBookByISBN(@RequestParam("isbn") String isbn_in,
	                               @RequestParam("title") String newtTitle,
	                               @RequestParam("desc") String newBookDesc,
	                               @RequestParam("authorId") int newAuthorId,
	                               @RequestParam("genreId") int newGenreId,
	                               @RequestParam("amount") int newAmount)
	{
		return this.bookService.updateBookByISBN(isbn_in, encoder.encode(newtTitle, StandardCharsets.UTF_8), encoder.encode(newBookDesc, StandardCharsets.UTF_8), newAuthorId, newGenreId, newAmount);
	}

	@PostMapping("post/newBook")
	public String insertBook(
			@RequestParam("isbnValue")String isbn_in,
			@RequestParam("titleValue")String title_in,
			@RequestParam("bookDescValue")String bookDesc_in,
			@RequestParam("authorIdValue") int authorId_in,
			@RequestParam("genreIdValue") int genreId_in,
			@RequestParam("amountValue") int amount_in
	){
		return this.bookService.insertBook(isbn_in,encoder.encode(title_in, StandardCharsets.UTF_8) , encoder.encode(bookDesc_in, StandardCharsets.UTF_8), authorId_in, genreId_in, amount_in);
	}

}
