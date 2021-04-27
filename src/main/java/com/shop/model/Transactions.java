package com.shop.model;

import java.sql.Date;

public class Transactions {
	public Transactions(int transactionId, int accNumber, int custid, double totalTransaction, double paymentAmount,
			Date paymentDate, int itemid) {
		super();
		this.transactionId = transactionId;
		this.accNumber = accNumber;
		this.custid = custid;
		TotalTransaction = totalTransaction;
		this.paymentAmount = paymentAmount;
		this.paymentDate = paymentDate;
		this.itemid = itemid;
	}
	private int transactionId;
	private int accNumber;
	private int custid;
	private double TotalTransaction;
	private double paymentAmount;
	private Date paymentDate;
	private int itemid;
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public int getAccNumber() {
		return accNumber;
	}
	public void setAccNumber(int accNumber) {
		this.accNumber = accNumber;
	}
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public double getTotalTransaction() {
		return TotalTransaction;
	}
	public void setTotalTransaction(double totalTransaction) {
		TotalTransaction = totalTransaction;
	}
	public double getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	
	

}
