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

public class PaymentDAOImpl implements PaymentDAO {

	@Override
	public int addPayment(Payment payment) throws BusinessException {
		try {
			Connection connection = PostgresConnection.openConnection();
			String sql = "INSERT INTO shop.payment(itemoffer_id, amount, paid_date, user_id) VALUES (?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			// preparedStatement.setInt(1, payment.getId());
			preparedStatement.setInt(1, payment.getItemoffer_id());
			preparedStatement.setDouble(2, payment.getAmount());
			preparedStatement.setDate(3, payment.getPaid_date());
			preparedStatement.setInt(4, payment.getUser_id());
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

	@Override
	public List<Payment> getPaymentsByItemOfferId(int itemOfferId) throws BusinessException {
		List<Payment> paymentList = new ArrayList<>();
		try (Connection connection = PostgresConnection.openConnection()) {
			String sql = "Select * from shop.payment where itemoffer_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, itemOfferId);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Payment Payment1 = new Payment();
				Payment1.setId(resultSet.getInt("id"));
				Payment1.setItemoffer_id(resultSet.getInt("itemoffer_id"));
				Payment1.setAmount(resultSet.getDouble("amount"));
				Payment1.setPaid_date(resultSet.getDate("paid_date"));
				Payment1.setUser_id(resultSet.getInt("user_id"));

				paymentList.add(Payment1);
			}
			return paymentList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("Internal error: " + e.getMessage());
		}
	}

}

