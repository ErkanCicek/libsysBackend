package com.libsysbackend.libsysbackend.personnelSide.model;

public class Librarian {
	private long personelID;
	private String name;
	private String lastName;
	private String SSN;
	private String role;
	
	public Librarian(long personelID, String name, String lastName, String SSN, String role) {
		this.personelID = personelID;
		this.name = name;
		this.lastName = lastName;
		this.SSN = SSN;
		this.role = role;
	}
	
	public Librarian(String role) {
		this.role = role;
	}
	
	public long getPersonelID() {
		return personelID;
	}
	
	public void setPersonelID(long personelID) {
		this.personelID = personelID;
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
		return "Librarian{" +
				"personelID=" + personelID +
				", name='" + name + '\'' +
				", lastName='" + lastName + '\'' +
				", SSN='" + SSN + '\'' +
				", role='" + role + '\'' + '}';
	}
}
