package com.libsysbackend.libsysbackend.personnelSide.model;

public class BorrowerLib {
	private long borrowerID;
	private String name;
	private String lastName;
	private String SSN;
	private String role;
	
	public BorrowerLib(long borrowerID, String name, String lastName, String SSN, String role) {
		this.borrowerID = borrowerID;
		this.name = name;
		this.lastName = name;
		this.SSN = SSN;
		this.role = role;
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
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "BorrowerLib{" + "borrowerID=" + borrowerID + ", name='" + name + '\'' + ", lastName='" + lastName + '\'' + ", SSN='" + SSN + '\'' + ", role='" + role + '\'' + '}';
	}
}
