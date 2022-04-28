package com.libsysbackend.libsysbackend.customerSide.model;

public class Book {
	private int bookID;
	private String title;
	private String bookDesc;
	private int authorID;
	private int genreID;
	private boolean isBookAvailable;
	private String ISBN;

	public Book(int bookID, String title, String bookDesc, int authorID, int genreID, String ISBN) {
		this.bookID = bookID;
		this.title = title;
		this.bookDesc = bookDesc;
		this.authorID = authorID;
		this.genreID = genreID;
		this.ISBN = ISBN;
		isBookAvailable = true;
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

	public int getAuthorID() {
		return authorID;
	}

	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}

	public int getGenreID() {
		return genreID;
	}

	public void setGenreID(int genreID) {
		this.genreID = genreID;
	}

	public boolean isBookAvailable() {
		return isBookAvailable;
	}

	public void setBookAvailable(boolean bookAvailable) {
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
