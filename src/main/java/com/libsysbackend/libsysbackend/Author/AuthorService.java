package com.libsysbackend.libsysbackend.Author;

import com.libsysbackend.libsysbackend.Author.AuthorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@Service
public class AuthorService {

	@Autowired
	AuthorDAO authorDAO;

	public String getAuthorById(int authorId_in){
		return this.authorDAO.getAuthorById(authorId_in);
	}
	public String getAuthorByName(String authorName_in){
		return this.authorDAO.getAuthorByName(URLDecoder.decode(authorName_in, StandardCharsets.UTF_8));
	}
	public String getAllAuthors(){
		return this.authorDAO.getAllAuthors();
	}
}
