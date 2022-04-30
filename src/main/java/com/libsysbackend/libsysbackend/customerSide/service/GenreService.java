package com.libsysbackend.libsysbackend.customerSide.service;

import com.libsysbackend.libsysbackend.customerSide.dao.GenreDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreService {

	@Autowired
	GenreDAO genreDAO;

	public String getGenreByName(String genreName_in){
		return genreDAO.getGenreByName(genreName_in);
	}
}
