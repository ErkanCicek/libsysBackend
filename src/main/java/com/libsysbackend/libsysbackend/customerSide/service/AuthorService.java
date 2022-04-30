package com.libsysbackend.libsysbackend.customerSide.service;

import com.libsysbackend.libsysbackend.customerSide.dao.AuthorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

	@Autowired
	AuthorDAO authorDAO;

	public String getAuthorById(int authorId_in){
		return authorDAO.getAuthorById(authorId_in);
	}

	public String getAuthorByName(String authorName_in){
		return authorDAO.getAuthorByName(authorName_in);
	}
}
