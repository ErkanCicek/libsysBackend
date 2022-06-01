package com.libsysbackend.libsysbackend.entity.Book;

import org.apache.catalina.util.URLEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping(value = "book/", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
public class BookController {

	@Autowired
	private final BookService bookService;
	private final URLEncoder encoder = new URLEncoder();

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping("get/bookByIsbnAndId")
	public String getBookByIsbnAndId(@RequestParam("value")String isbn_in, @RequestParam("bookId") int bookId){
		return this.bookService.getBookByIsbnAndBookId(isbn_in, bookId);
	}

	@GetMapping("get/bookByISBN")
	public String getBookByISBN(@RequestParam("bookIsbn")String isbn){
		return this.bookService.getBookByISBN(isbn);
	}

	@GetMapping("get/booksByGenreId")
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
	public String updateBookByISBN(
			@RequestParam("bookId") int bookId,
			@RequestParam("isbn") String isbn_in,
			@RequestParam("title") String newtTitle,
			@RequestParam("desc") String newBookDesc,
			@RequestParam("authorId") int newAuthorId,
			@RequestParam("genreId") int newGenreId
	)
	{
		return this.bookService.updateBookByISBN(bookId, isbn_in, encoder.encode(newtTitle, StandardCharsets.UTF_8), encoder.encode(newBookDesc, StandardCharsets.UTF_8), newAuthorId, newGenreId);
	}

	@PutMapping("put/reserveBook")
	public String updateBookByISBN2(
			@RequestParam("bookId") int bookId,
			@RequestParam("isbn") String isbn_in)
	{
		return this.bookService.reserveBook(bookId, isbn_in);
	}

	@PostMapping("post/newBook")
	public String insertBook(
			@RequestParam("isbnValue")String isbn_in,
			@RequestParam("titleValue")String title_in,
			@RequestParam("bookDescValue")String bookDesc_in,
			@RequestParam("authorIdValue") int authorId_in,
			@RequestParam("genreIdValue") int genreId_in
	){
		return this.bookService.insertBook(isbn_in,encoder.encode(title_in, StandardCharsets.UTF_8) , encoder.encode(bookDesc_in, StandardCharsets.UTF_8), authorId_in, genreId_in);
	}

	@GetMapping("get/countBook")
	public Integer countBooksByIsbn(
			@RequestParam("bookIsbn") String isbn
	){
		return this.bookService.countBookByIsbn(isbn);
	}

	@GetMapping("get/mostPopularAvailableBook")
	public List<Book> getMostPopularAvailableBook(){
		return this.bookService.getMostPopularAvailableBook();
	}

}
