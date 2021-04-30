package com.shop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shop.dao.PaymentDAO;
import com.shop.dao.dbutil.PostgresConnection;
import com.shop.exception.BusinessException;
import com.shop.model.ItemOffer;
import com.shop.model.Payment;

public class PaymentDAOImpl implements PaymentDAO{

	@Override
	public int makePayment(Payment payment) throws BusinessException {
		try {
			Connection connection = PostgresConnection.openConnection();
			String sql  = "INSERT INTO shop.payment(itemoffer_id, amount, paid_date, user_id) VALUES (?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			//preparedStatement.setInt(1, payment.getId());
			preparedStatement.setInt(1, payment.getItemoffer_id());
			preparedStatement.setDouble(2, payment.getAmount());
			preparedStatement.setDate(3,  payment.getPaid_date());
			preparedStatement.setInt(4,  payment.getUser_id());
			int count = preparedStatement.executeUpdate();
			return count;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		return 0;
	}

	@Override
	public List<Payment> getPaymentsByCustomerId(int customerId) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}
	/*
	 * 
	 */
	
	
//	@Override
//	public List<Payment> viewPayments() throws BusinessException {
////		List<Payment> PaymentList = new ArrayList<>();
////		try (Connection connection = PostgresConnection.openConnection()) {
////			String sql = "Select * from shop.payment";
////			PreparedStatement preparedStatement = connection.prepareStatement(sql);
////			ResultSet resultSet = preparedStatement.executeQuery();
////			while (resultSet.next()) {
////				Payment Payment1 = new Payment();
////				Payment1.setItemoffer_id(resultSet.getInt("itemoffer_id"));
////				Payment1.setAmount(resultSet.getDouble("amount"));
////				Payment1.setPaid_date(resultSet.getDate(sql));
////
////
////				PaymentList.add(Payment1);
////			}
////			return PaymentList ;
////		} catch (Exception e) {
////			e.printStackTrace();
////			throw new BusinessException("Internal error: " + e.getMessage());
////		}
////	}
//	}

	


