package com.shop.model;

import java.sql.Date;

public class Customer {
	private int customerid;
	private String firsName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Date customerSince;
	private boolean isemployee;
	private String password;
	private int accountNumber;
	public Customer(int customerid, String firsName, String lastName, String email, String phoneNumber,
			Date customerSince, boolean isemployee, String password, int accountNumber) {
		super();
		this.customerid = customerid;
		this.firsName = firsName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.customerSince = customerSince;
		this.isemployee = isemployee;
		this.password = password;
		this.accountNumber = accountNumber;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getFirsName() {
		return firsName;
	}
	public void setFirsName(String firsName) {
		this.firsName = firsName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Date getCustomerSince() {
		return customerSince;
	}
	public void setCustomerSince(Date customerSince) {
		this.customerSince = customerSince;
	}
	public boolean isIsemployee() {
		return isemployee;
	}
	public void setIsemployee(boolean isemployee) {
		this.isemployee = isemployee;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	

}
