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

	@GetMapping("get/allGenres")
	public String getAllGenre(){
		return this.genreService.getAllGenre();
	}

	@GetMapping("get/genreByName")
	public String getGenreByName(@RequestParam("value") String genreName_in){
		return this.genreService.getGenreByName(new URLEncoder().encode(genreName_in, StandardCharsets.UTF_8));
	}

	@GetMapping("get/genreById")
	public String getGenreById(int id_in){
		return this.genreService.getGenreById(id_in);
	}
}
