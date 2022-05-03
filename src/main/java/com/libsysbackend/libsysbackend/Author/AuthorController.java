package com.libsysbackend.libsysbackend.Author;

import org.apache.catalina.util.URLEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;

@RestController
public class AuthorController {

	@Autowired
	AuthorService authorService;

	@GetMapping("getAuthor/byName")
	public String getAuthorByName(@RequestParam("value")String name_in){
		return this.authorService.getAuthorByName(new URLEncoder().encode(name_in, StandardCharsets.UTF_8));
	}

	@GetMapping("getAuthor/all")
	public String getAllAuthors(){
		return this.authorService.getAllAuthors();
	}

	@GetMapping("getAuthor/byId")
	public String getAuthorById(int id){
		return this.authorService.getAuthorById(id);
	}
}
