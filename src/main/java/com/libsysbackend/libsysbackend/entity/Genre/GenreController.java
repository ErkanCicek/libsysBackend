package com.libsysbackend.libsysbackend.entity.Genre;

import org.apache.catalina.util.URLEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "genre/", method = {POST, GET})
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
	public String getGenreById(@RequestParam("id") int id_in){
		return this.genreService.getGenreById(id_in);
	}
}
