package com.libsysbackend.libsysbackend.entity.Genre;

import org.springframework.stereotype.Service;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@Service
public record GenreService(GenreDAO genreDAO) {

	public String getGenreByName(String genreName_in) {
		return this.genreDAO.getGenreByName(URLDecoder.decode(genreName_in, StandardCharsets.UTF_8));
	}

	public String getAllGenre() {
		return this.genreDAO.getAllGenre();
	}

	public String getGenreById(int id_in) {
		return this.genreDAO.getGenreById(id_in);
	}
}
