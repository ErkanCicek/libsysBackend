package com.libsysbackend.libsysbackend.entity.BorrowedBooks;

public class BorrowedBooks {
    private int borrowedBooksID;
    private String returnDate;
    private String bookISBN;
    private String borrowerSSN;


    public BorrowedBooks(int borrowedBooksID, String returnDate, String bookISBN, String borrowerSSN) {
        this.borrowedBooksID = borrowedBooksID;
        this.returnDate = returnDate;
        this.bookISBN = bookISBN;
        this.borrowerSSN = borrowerSSN;
    }

    public int getBorrowedBooksID() {
        return borrowedBooksID;
    }

    public void setBorrowedBooksID(int borrowedBooksID) {
        this.borrowedBooksID = borrowedBooksID;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getBookISBN() {
        return bookISBN;
    }

    public void setBookISBN(String bookISBN) {
        this.bookISBN = bookISBN;
    }

    public String getBorrowerSSN() {
        return borrowerSSN;
    }

    public void setBorrowerSSN(String borrowerSSN) {
        this.borrowerSSN = borrowerSSN;
    }

    @Override
    public String toString() {
        return "BorrowedBooks{" +
                "borrowedBooksID=" + borrowedBooksID +
                ", returnDate='" + returnDate + '\'' +
                ", bookISBN='" + bookISBN + '\'' +
                ", borrowerSSN='" + borrowerSSN + '\'' +
                '}';
    }
}
