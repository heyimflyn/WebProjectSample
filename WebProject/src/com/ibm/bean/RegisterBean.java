package com.ibm.bean;

public class RegisterBean {
	 private String firstName;
	 private String lastName;
	 private String email;
	 private String division;
	 
	 public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	private String userName;
	 private String password;
	 
	 public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
	 return userName;
	 }
	 public void setUserName(String userName) {
	 this.userName = userName;
	 }
	 public String getPassword() {
	 return password;
	 }
	 public void setPassword(String password) {
	 this.password = password;
	 }
	 public void setEmail(String email) {
	 this.email = email;
	 }
	 public String getEmail() {
	 return email;
	 }
}
