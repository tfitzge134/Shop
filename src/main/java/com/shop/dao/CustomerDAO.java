package com.shop.dao;

import com.shop.exception.BusinessException;
import com.shop.model.Customer;


public interface CustomerDAO {
	public int addCustomer(Customer customer) throws BusinessException;

	public Customer verifyPassword(String email, String password) throws BusinessException;

	public int deleteCustomerByEmail(String email) throws BusinessException;
}
