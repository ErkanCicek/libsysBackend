package com.libsysbackend.libsysbackend.entity.Author;

import org.springframework.stereotype.Service;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@Service
public record AuthorService(AuthorDAO authorDAO) {

	public String getAuthorById(int authorId_in) {
		return this.authorDAO.getAuthorById(authorId_in);
	}

	public String getAuthorByName(String authorName_in) {
		return this.authorDAO.getAuthorByName(URLDecoder.decode(authorName_in, StandardCharsets.UTF_8));
	}

	public String getAllAuthors() {
		return this.authorDAO.getAllAuthors();
	}

	public String insertNewAuthor(String author_in) {
		return this.authorDAO.insertNewAuthor(URLDecoder.decode(author_in, StandardCharsets.UTF_8));
	}

	public String deleteAuthorById(int id_in) {
		return this.authorDAO.deleteAuthorById(id_in);
	}

	public String updateAuthorById(String newAuthorName_in, int id_in){
		return this.authorDAO.updateAuthorById(URLDecoder.decode(newAuthorName_in, StandardCharsets.UTF_8),id_in);
	}
}
