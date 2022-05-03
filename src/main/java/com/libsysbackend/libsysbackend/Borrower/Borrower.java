package com.libsysbackend.libsysbackend.Borrower;

public class Borrower {
    private int borrowerID;
    private String name;
    private String lastName;
    private String SSN;

    public Borrower(int borrowerID, String name, String lastName, String SSN) {
        this.borrowerID = borrowerID;
        this.name = name;
        this.lastName = lastName;
        this.SSN = SSN;
    }

    public int getBorrowerID() {
        return borrowerID;
    }

    public void setBorrowerID(int borrowerID) {
        this.borrowerID = borrowerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    @Override
    public String toString() {
        return "Borrower{" +
                "borrowerID=" + borrowerID +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", SSN='" + SSN + '\'' +
                '}';
    }
}
