package com.shop.dao;


import java.util.List;

import com.shop.exception.BusinessException;

import com.shop.model.Payment;

public interface PaymentDAO {
	public int addPayment(Payment payment) throws BusinessException;
	
	public List<Payment> getPaymentsByCustomerId(int customerId) throws BusinessException;
	
	public List<Payment> getPaymentsByItemOfferId(int itemOfferId) throws BusinessException;
	

}
