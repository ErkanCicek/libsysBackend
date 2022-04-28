package com.libsysbackend.libsysbackend.customerSide.service;

import com.libsysbackend.libsysbackend.customerSide.dao.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

	@Autowired
	private BookDAO bookDAO;

	public String getBookByISBN(int isbn_in){
		return bookDAO.getBookByISBN(isbn_in);
	}

}
