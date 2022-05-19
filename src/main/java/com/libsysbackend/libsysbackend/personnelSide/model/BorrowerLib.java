package com.libsysbackend.libsysbackend.personnelSide.model;

public class BorrowerLib {
	private long borrowerID;
	private String name;
	private String lastName;
	private String SSN;
	private String email;
	private String phoneNr;
	
	public BorrowerLib(long borrowerID, String name, String lastName, String SSN, String email, String phoneNr) {
		this.borrowerID = borrowerID;
		this.name = name;
		this.lastName = name;
		this.SSN = SSN;
		this.email = email;
		this.phoneNr = phoneNr;
	}
	
	public BorrowerLib(long borrowerID, String name, String lastName, String SSN) {
		this.borrowerID = borrowerID;
		this.name = name;
		this.lastName = lastName;
		this.SSN = SSN;
	}
	
	public long getBorrowerID() {
		return borrowerID;
	}
	
	public void setBorrowerID(long borrowerID) {
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhoneNr() {
		return phoneNr;
	}
	
	public void setPhoneNr(String phoneNr) {
		this.phoneNr = phoneNr;
	}
	
	@Override
	public String toString() {
		return "BorrowerLib{" + "borrowerID=" + borrowerID + ", name='" + name + '\'' + ", lastName='" + lastName + '\'' + ", SSN='" + SSN + '\'' + ", email='" + email + '\'' + ", phoneNr='" + phoneNr + '\'' + '}';
	}
}