package com.libsysbackend.libsysbackend.personnelSide.model;

public class BorrowedBooksLib {
	private long borrowedBooksID;
	private String returnDate;
	private String borrowerSSN;
	private int bookId;
	private String bookISBN;
	
	public BorrowedBooksLib(long borrowedBooksID, String returnDate, String borrowerSSN, int bookId, String bookISBN) {
		this.borrowedBooksID = borrowedBooksID;
		this.returnDate = returnDate;
		this.borrowerSSN = borrowerSSN;
		this.bookId = bookId;
		this.bookISBN = bookISBN;
	}
	
	public long getBorrowedBooksID() {
		return borrowedBooksID;
	}
	
	public void setBorrowedBooksID(long borrowedBooksID) {
		this.borrowedBooksID = borrowedBooksID;
	}
	
	public String getReturnDate() {
		return returnDate;
	}
	
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	
	public String getBorrowerSSN() {
		return borrowerSSN;
	}
	
	public void setBorrowerSSN(String borrowerSSN) {
		this.borrowerSSN = borrowerSSN;
	}
	
	public int getBookId() {
		return bookId;
	}
	
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	
	public String getBookISBN() {
		return bookISBN;
	}
	
	public void setBookISBN(String bookISBN) {
		this.bookISBN = bookISBN;
	}
	
	@Override
	public String toString() {
		return "BorrowedBooksLib{" + "borrowedBooksID=" + borrowedBooksID + ", returnDate='" + returnDate + '\'' + ", borrowerSSN='" + borrowerSSN + '\'' + ", bookId='" + bookId + '\'' + ", bookISBN='" + bookISBN + '\'' + '}';
	}
}
