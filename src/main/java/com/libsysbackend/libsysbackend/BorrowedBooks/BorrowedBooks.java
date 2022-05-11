package com.libsysbackend.libsysbackend.BorrowedBooks;

public class BorrowedBooks {
    private int borrowedBooksID;
    private String returnDate;
    private String SSN;
    private String ISBN;

    public BorrowedBooks(int borrowedBooksID, String returnDate, String SSN, String ISBN) {
        this.borrowedBooksID = borrowedBooksID;
        this.returnDate = returnDate;
        this.SSN = SSN;
        this.ISBN = ISBN;
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

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public String toString() {
        return "BorrowedBooks{" +
                "borrowedBooksID=" + borrowedBooksID +
                ", returnDate='" + returnDate + '\'' +
                ", SSN='" + SSN + '\'' +
                ", ISBN='" + ISBN + '\'' +
                '}';
    }
}
