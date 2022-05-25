package com.libsysbackend.libsysbackend.personnelSide.service;

import com.libsysbackend.libsysbackend.personnelSide.dao.BorrowedBooksLibDao;
import com.libsysbackend.libsysbackend.personnelSide.model.BookLib;
import com.libsysbackend.libsysbackend.personnelSide.model.BorrowedBooksLib;
import com.libsysbackend.libsysbackend.personnelSide.model.Librarian;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

@Repository
@Service
public class BorrowedBooksLibService {
	
	@Autowired
	BorrowedBooksLibDao borrowedBooksLibDao;
	
	public ArrayList<BorrowedBooksLib> getAllBorrowedBooks(){
		return (ArrayList<BorrowedBooksLib>) borrowedBooksLibDao.getAllBorrowedBooks();}
	
	public void loanBook(String borrowerSSN, String borrowedBookISBN){
		borrowedBooksLibDao.loanBook(URLDecoder.decode(borrowerSSN), URLDecoder.decode(borrowedBookISBN));}
	
	public String returnBookByISBN(String bookISBN){return borrowedBooksLibDao.returnBookByISBN(String.valueOf(bookISBN));}
	
	public BorrowedBooksLib getBorrowedBookByISBN(String ISBN){return borrowedBooksLibDao.getBorrowedBookByISBN(URLDecoder.decode(ISBN,
			StandardCharsets.UTF_8));}
}
