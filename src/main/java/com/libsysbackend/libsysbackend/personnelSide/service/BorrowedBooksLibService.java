package com.libsysbackend.libsysbackend.personnelSide.service;

import com.libsysbackend.libsysbackend.personnelSide.dao.BorrowedBooksLibDao;
import com.libsysbackend.libsysbackend.personnelSide.model.BorrowedBooksLib;
import com.libsysbackend.libsysbackend.personnelSide.model.Librarian;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Repository
@Service
public class BorrowedBooksLibService {
	
	@Autowired
	BorrowedBooksLibDao borrowedBooksLibDao;
	
	public ArrayList<BorrowedBooksLib> getAllBorrowedBooks(){
		return (ArrayList<BorrowedBooksLib>) borrowedBooksLibDao.getAllBorrowedBooks();}
}
