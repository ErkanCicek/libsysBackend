package com.libsysbackend.libsysbackend.customerSide.model;

public class BorroweContact {
    private int borrowerContactID;
    private int borrowerID;
    private String epost;
    private String tel;

    public BorroweContact(int borrowerContactID, int borrowerID, String epost, String tel) {
        this.borrowerContactID = borrowerContactID;
        this.borrowerID = borrowerID;
        this.epost = epost;
        this.tel = tel;
    }

    public int getBorrowerContactID() {
        return borrowerContactID;
    }

    public void setBorrowerContactID(int borrowerContactID) {
        this.borrowerContactID = borrowerContactID;
    }

    public int getBorrowerID() {
        return borrowerID;
    }

    public void setBorrowerID(int borrowerID) {
        this.borrowerID = borrowerID;
    }

    public String getEpost() {
        return epost;
    }

    public void setEpost(String epost) {
        this.epost = epost;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "BorroweContact{" +
                "borrowerContactID=" + borrowerContactID +
                ", borrowerID=" + borrowerID +
                ", epost='" + epost + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
