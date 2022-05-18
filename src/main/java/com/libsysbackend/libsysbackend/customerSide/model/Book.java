package com.libsysbackend.libsysbackend.customerSide.model;

public class Book {
	private int bookID;
	private String title;
	private String bookDesc;
	private String authorID;
	private String genreID;
	private String isBookAvailable;
	private String ISBN;

	
	
	public Book(int bookID,
	            String title,
	            String bookDesc,
	            String authorID,
	            String genreID,
	            String isBookAvailable,
	            String isbn,
	            String bookAvailable) {
		this.bookID = bookID;
		this.title = title;
		this.bookDesc = bookDesc;
		this.authorID = authorID;
		this.genreID = genreID;
		this.ISBN = ISBN;
	}
	
	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
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

	public String isBookAvailable() {
		return isBookAvailable;
	}

	public void setBookAvailable(String bookAvailable) {
		isBookAvailable = bookAvailable;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}

	@Override
	public String toString() {
		return "Book{" +
				"bookID=" + bookID +
				", title='" + title + '\'' +
				", bookDesc='" + bookDesc + '\'' +
				", authorID=" + authorID +
				", genreID=" + genreID +
				", isBookAvailable=" + isBookAvailable +
				", ISBN='" + ISBN + '\'' +
				'}';
	}
}
