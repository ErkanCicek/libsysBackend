package com.libsysbackend.libsysbackend.Author;

import org.apache.catalina.util.URLEncoder;
import org.springframework.web.bind.annotation.*;
import java.nio.charset.StandardCharsets;

@RestController
public class AuthorController {

	private final AuthorService authorService;
	public AuthorController(AuthorService authorService){
		this.authorService = authorService;
	}

	@GetMapping("get/authorByName")
	public String getAuthorByName(@RequestParam("value")String name_in){
		return this.authorService.getAuthorByName(new URLEncoder().encode(name_in, StandardCharsets.UTF_8));
	}

	@GetMapping("get/allAuthors")
	public String getAllAuthors(){
		return this.authorService.getAllAuthors();
	}

	@GetMapping("get/AuthorById")
	public String getAuthorById(int id){
		return this.authorService.getAuthorById(id);
	}

	@PostMapping("post/newAuthor")
	public String insertNewAuthor(@RequestParam("value")String name_in){
		return this.authorService.insertNewAuthor(URLEncoder.DEFAULT.encode(name_in, StandardCharsets.UTF_8));
	}
	@DeleteMapping("delete/authorById")
	public String deleteAuthorById(@RequestParam("value")int id_in){
		return this.authorService.deleteAuthorById(id_in);
	}
	@PutMapping("put/authorById")
	public String updateAuthorById(@RequestParam("id")int id_in, @RequestParam("value")String newAuthorName_in){
		return this.authorService.updateAuthorById(newAuthorName_in, id_in);
	}
}
