package com.shop.model;

import java.sql.Date;

public class ItemPurchase {
	private int itemId ;
	private int customerId;
	private double offerPrice;
	private Date offerDate;
	private double quantity;
	boolean isAccepted;
	public ItemPurchase(int itemId, int customerId, double offerPrice, Date offerDate, double quantity,
			boolean isAccepted) {
		super();
		this.itemId = itemId;
		this.customerId = customerId;
		this.offerPrice = offerPrice;
		this.offerDate = offerDate;
		this.quantity = quantity;
		this.isAccepted = isAccepted;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public double getOfferPrice() {
		return offerPrice;
	}
	public void setOfferPrice(double offerPrice) {
		this.offerPrice = offerPrice;
	}
	public Date getOfferDate() {
		return offerDate;
	}
	public void setOfferDate(Date offerDate) {
		this.offerDate = offerDate;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public boolean isAccepted() {
		return isAccepted;
	}
	public void setAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}
	@Override
	public String toString() {
		return "itemPurchase [itemId=" + itemId + ", customerId=" + customerId + ", offerPrice=" + offerPrice
				+ ", offerDate=" + offerDate + ", quantity=" + quantity + ", isAccepted=" + isAccepted + "]";
	}
	
	
/*
 * SELECT id, "itemId", "customerId",
 *  "offerPrice", "offerDate", quantity, "isAccepted", "paidDate"
	FROM shop."itemPurchase";
 */
}
