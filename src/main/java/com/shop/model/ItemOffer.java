package com.shop.model;

import java.sql.Date;

public class ItemOffer {

	private int id;
	private int item_id;
	private int customer_id;
	private double offer_price;
	private Date offer_date;
	private int quantity;
	private boolean is_accepted;
	private int plan_weeks_count;
	private boolean is_paid;
	private int paid_weeks_count;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public double getOffer_price() {
		return offer_price;
	}

	public void setOffer_price(double offer_price) {
		this.offer_price = offer_price;
	}

	public Date getOffer_date() {
		return offer_date;
	}

	public void setOffer_date(Date offer_date) {
		this.offer_date = offer_date;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isIs_accepted() {
		return is_accepted;
	}

	public void setIs_accepted(boolean is_accepted) {
		this.is_accepted = is_accepted;
	}

	public int getPlan_weeks_count() {
		return plan_weeks_count;
	}

	public void setPlan_weeks_count(int plan_weeks_count) {
		this.plan_weeks_count = plan_weeks_count;
	}

	public boolean isIs_paid() {
		return is_paid;
	}

	public void setIs_paid(boolean is_paid) {
		this.is_paid = is_paid;
	}

	public int getPaid_weeks_count() {
		return paid_weeks_count;
	}

	public void setPaid_weeks_count(int paid_weeks_count) {
		this.paid_weeks_count = paid_weeks_count;
	}

	@Override
	public String toString() {
		return "ItemOffer [id=" + id + ", item_id=" + item_id + ", customer_id=" + customer_id + ", offer_price="
				+ offer_price + ", offer_date=" + offer_date + ", quantity=" + quantity + ", is_accepted=" + is_accepted
				+ ", plan_weeks_count=" + plan_weeks_count + ", is_paid=" + is_paid + ", paid_weeks_count="
				+ paid_weeks_count + "]";
	}

}
