package com.libsysbackend.libsysbackend.personnelSide.service;

import com.libsysbackend.libsysbackend.personnelSide.dao.BorrowerLibDao;
import com.libsysbackend.libsysbackend.personnelSide.model.BookLib;
import com.libsysbackend.libsysbackend.personnelSide.model.BorrowerLib;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

@Repository
@Service
public class BorrowerLibService {
	
	@Autowired
	BorrowerLibDao borrowerLibDao;
	
	public ArrayList<BorrowerLib> getAllBorrowers(){
		return (ArrayList<BorrowerLib>) borrowerLibDao.getAllBorrowers();}
	
	public BorrowerLib getBorrowerByBorrowerID(String borrowerID){return borrowerLibDao.getBorrowerByBorrowerID(URLDecoder.decode(borrowerID,
			StandardCharsets.UTF_8));}
	
	public String deleteBorrowerByID(String borrowerID){return borrowerLibDao.deleteBorrowerByID(String.valueOf(borrowerID));}
	
	public void addBorrower(String name, String lastName, String SSN, String email, String phoneNr){
		borrowerLibDao.addBorrower(name, lastName, SSN, email, phoneNr);}
	
	public void addBorrowerCredentials(String borrower_BorrowerId, String borrowerPassword){
		borrowerLibDao.addBorrowerCredentials(borrower_BorrowerId, borrowerPassword);}
}