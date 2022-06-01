package com.libsysbackend.libsysbackend.personnelSide.service;
import com.libsysbackend.libsysbackend.personnelSide.dao.BookLibDao;
import com.libsysbackend.libsysbackend.personnelSide.model.BookLib;
import com.libsysbackend.libsysbackend.personnelSide.model.BorrowedBooksLib;
import com.libsysbackend.libsysbackend.personnelSide.model.BorrowerLib;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

@Repository
@Service
public class BookLibService {
	
	@Autowired
	BookLibDao bookLibDao;
	
	public BookLib getBookByISBN(String ISBN){return bookLibDao.getBookByISBN(String.valueOf(ISBN));}
	
	public BookLib getBookByTitle(String title){return bookLibDao.getBookByTitle(URLDecoder.decode(title, StandardCharsets.UTF_8));}
	
	public BookLib getBookByAuthorName(String authorName){return bookLibDao.getBookByAuthorName(URLDecoder.decode(authorName, StandardCharsets.UTF_8));}
	
	public BookLib getBookByGenreName(String genreName){return bookLibDao.getBookByGenreName(URLDecoder.decode(genreName, StandardCharsets.UTF_8));}
	
	public String deleteBookByID(String bookID){return bookLibDao.deleteBookByID(String.valueOf(bookID));}
	
	public void addBook(String ISBN, String title, String bookDesc, String authorID, String genreID){
		bookLibDao.addBook(URLDecoder.decode(ISBN), URLDecoder.decode(title), URLDecoder.decode(bookDesc),
				URLDecoder.decode(authorID), URLDecoder.decode(genreID));}
	
	public void addAuthor(String authorName){bookLibDao.addAuthor(URLDecoder.decode(authorName));}
	
	public String deleteAuthorByID(String authorID){return bookLibDao.deleteAuthorByID(URLDecoder.decode(authorID));}
	
	public void addGenre(String genreName, String genreDesc){bookLibDao.addGenre(URLDecoder.decode(genreName,
			StandardCharsets.UTF_8), URLDecoder.decode(genreDesc, StandardCharsets.UTF_8));}
	
	public String deleteGenreByID(String genreID){return bookLibDao.deleteGenreByID(URLDecoder.decode(genreID));}
	
	public BookLib getIsBookAvailable(String isBookAvailable){return bookLibDao.getIsBookAvailable(String.valueOf(isBookAvailable));}
}
