package com.libsysbackend.libsysbackend.personnelSide.service;

//import com.libsysbackend.Dao.StaffDao;
//import basePackage.dataBaseClasses.Staff;
import com.libsysbackend.libsysbackend.personnelSide.dao.LibrarianDao;
import com.libsysbackend.libsysbackend.personnelSide.model.BorrowerLib;
import com.libsysbackend.libsysbackend.personnelSide.model.Librarian;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Repository
@Service
public class LibrarianService {
	
	@Autowired
	LibrarianDao librarianDao;
	
	public ArrayList<Librarian> getAllPersonel(){
		return (ArrayList<Librarian>) librarianDao.getAllPersonel();}
	
	public void addPersonel(String name, String lastName, String SSN, String ROLE, String email, String phoneNr){
		librarianDao.addPersonel(name, lastName, SSN, ROLE, email, phoneNr);}
	
	public void addPersonelCredentials(String personelID, String password){
		librarianDao.addPersonelCredentials(personelID, password);}
	
	public String deletePersonelByID(String personelID){return librarianDao.deletePersonelByID(String.valueOf(personelID));}
	
	public Librarian getLibrarianByID(int personelID){return librarianDao.getPersonelById(String.valueOf(personelID));}
	
	public Librarian getRoleByID(int personelID){
		return librarianDao.getRoleById(String.valueOf(personelID));
	}
	
	public String getValidationNumber(){String returnable = librarianDao.getValidationNumber();
		return returnable;}
	
	public void libLogin(String personelID, String password){
		librarianDao.libLogin(personelID, password);
	}
}
