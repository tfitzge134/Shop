package com.shop.dao;

import com.shop.exception.BusinessException;
import com.shop.model.User;


public interface UserDAO {
	public boolean addUser(User user) throws BusinessException;
	
	public boolean isEmailInUse(String email) throws BusinessException;

	public User verifyPassword(String email, String password) throws BusinessException;

}
