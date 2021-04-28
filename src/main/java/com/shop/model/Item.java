package com.shop.model;

import java.sql.Date;

public class Item {
	private int itemid;
	private String itemName;
	private double itemPrice;
	private double itemPromotionalDiscount;
	private int itemQuantity;
	private Date promotionStartDate;
	private Date itemPromotionEndDate;

	public int getItemid() {
		return itemid;
	}

	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public double getItemPromotionalDiscount() {
		return itemPromotionalDiscount;
	}

	public void setItemPromotionalDiscount(double itemPromotionalDiscount) {
		this.itemPromotionalDiscount = itemPromotionalDiscount;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public Date getPromotionStartDate() {
		return promotionStartDate;
	}

	public void setPromotionStartDate(Date promotionStartDate) {
		this.promotionStartDate = promotionStartDate;
	}

	public Date getItemPromotionEndDate() {
		return itemPromotionEndDate;
	}

	public void setItemPromotionEndDate(Date itemPromotionEndDate) {
		this.itemPromotionEndDate = itemPromotionEndDate;
	}

	@Override
	public String toString() {
		return "Item [itemid=" + itemid + ", itemName=" + itemName + ", itemPrice=" + itemPrice
				+ ", itemPromotionalDiscount=" + itemPromotionalDiscount + ", itemQuantity=" + itemQuantity
				+ ", promotionStartDate=" + promotionStartDate + ", itemPromotionEndDate=" + itemPromotionEndDate + "]";
	}


}
