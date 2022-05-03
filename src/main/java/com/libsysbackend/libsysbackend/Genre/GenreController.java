package com.libsysbackend.libsysbackend.Genre;

import org.apache.catalina.util.URLEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;

@RestController
public class GenreController {

	@Autowired
	GenreService genreService;

	@GetMapping("getGenre/all")
	public String getAllGenre(){
		return this.genreService.getAllGenre();
	}

	@GetMapping("getGenre/byName")
	public String getGenreByName(@RequestParam("value") String genreName_in){
		return this.genreService.getGenreByName(new URLEncoder().encode(genreName_in, StandardCharsets.UTF_8));
	}

	@GetMapping("getGenre/byId")
	public String getGenreById(int id_in){
		return this.genreService.getGenreById(id_in);
	}
}
