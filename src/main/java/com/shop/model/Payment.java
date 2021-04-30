package com.shop.model;

import java.sql.Date;

public class Payment {

	private int id;
	private int itemoffer_id;
	private double amount;
	private Date paid_date;
	private int user_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getItemoffer_id() {
		return itemoffer_id;
	}

	public void setItemoffer_id(int itemoffer_id) {
		this.itemoffer_id = itemoffer_id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getPaid_date() {
		return paid_date;
	}

	public void setPaid_date(Date paid_date) {
		this.paid_date = paid_date;
	}

	
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", itemoffer_id=" + itemoffer_id + ", amount=" + amount + ", paid_date="
				+ paid_date + ", user_id=" + user_id + "]";
	}


}
