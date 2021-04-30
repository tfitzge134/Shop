package com.shop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shop.dao.UserDAO;
import com.shop.dao.dbutil.PostgresConnection;
import com.shop.exception.BusinessException;
import com.shop.model.User;

public class UserDAOImpl implements UserDAO {

	public boolean addUser(User user) throws BusinessException {
		try {
			Connection conn = PostgresConnection.openConnection();
			String sql = "Insert into shop.user (email, password, role) " + " values (?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getEmail());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getRole());

			int count = pstmt.executeUpdate();
			if (count == 1) {
				return true;
			} else {
				return false;
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	public User verifyPassword(String email, String password) throws BusinessException {
		try (Connection conn = PostgresConnection.openConnection()) {

			String sql = "select * from shop.user where email = ? and password = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, password);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));
				return user;
			} else {
				return null;
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public boolean isEmailInUse(String email) throws BusinessException {
		try {
			Connection conn = PostgresConnection.openConnection();
			String sql = "select id from shop.user where email = ? ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				// Record found. //So, email is in use
				return true;
			} else {
				return false;
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public User getByEmail(String email) throws BusinessException {
		try (Connection conn = PostgresConnection.openConnection()) {

			String sql = "select * from shop.user where email = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));
				return user;
			} else {
				return null;
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}

	}

	@Override
	public boolean deleteById(int id) throws BusinessException {
		try {
			Connection conn = PostgresConnection.openConnection();
			String sql = "DELETE FROM shop.user WHERE id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);

			int count = pstmt.executeUpdate();
			if (count == 1) {
				return true;
			} else {
				return false;
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}
}
