package com.libsysbackend.libsysbackend.Genre;

import com.libsysbackend.libsysbackend.Genre.GenreDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@Service
public class GenreService {

	@Autowired
	GenreDAO genreDAO;

	public String getGenreByName(String genreName_in){
		return this.genreDAO.getGenreByName(URLDecoder.decode(genreName_in, StandardCharsets.UTF_8));
	}
	public String getAllGenre(){
		return this.genreDAO.getAllGenre();
	}
	public String  getGenreById(int id_in){
		return this.genreDAO.getGenreById(id_in);
	}
}
