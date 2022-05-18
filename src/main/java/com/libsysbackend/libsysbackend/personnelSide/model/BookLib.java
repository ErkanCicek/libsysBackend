package com.libsysbackend.libsysbackend.personnelSide.model;

public class BookLib {
	private long bookID;
	private String ISBN;
	private String title;
	private String bookDesc;
	private String authorID;
	private String genreID;
	private String isBookAvailable;
	
	public BookLib(long bookID, String ISBN, String title, String bookDesc, String authorID, String genreID,
	               String isBookAvailable) {
		this.bookID = bookID;
		this.ISBN = ISBN;
		this.title = title;
		this.bookDesc = bookDesc;
		this.authorID = authorID;
		this.genreID = genreID;
		this.isBookAvailable = isBookAvailable;
	}
	
	public long getBookID() {
		return bookID;
	}
	
	public void setBookID(long bookID) {
		this.bookID = bookID;
	}
	
	public String getISBN() {
		return ISBN;
	}
	
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getBookDesc() {
		return bookDesc;
	}
	
	public void setBookDesc(String bookDesc) {
		this.bookDesc = bookDesc;
	}
	
	public String getAuthorID() {
		return authorID;
	}
	
	public void setAuthorID(String authorID) {
		this.authorID = authorID;
	}
	
	public String getGenreID() {
		return genreID;
	}
	
	public void setGenreID(String genreID) {
		this.genreID = genreID;
	}
	
	public String getIsBookAvailable() {
		return isBookAvailable;
	}
	
	public void setIsBookAvailable(String isBookAvailable) {
		this.isBookAvailable = isBookAvailable;
	}
	
	@Override
	public String toString() {
		return "Book{" + "bookID=" + bookID + ", ISBN='" + ISBN + '\'' + ", title='" + title + '\'' + ", bookDesc='" + bookDesc + '\'' + ", authorID='" + authorID + '\'' + ", genreID='" + genreID + '\'' + ", isBookAvailable='" + isBookAvailable + '\'' + '}';
	}
}
