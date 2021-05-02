package com.shop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shop.dao.ItemOfferDAO;
import com.shop.dao.dbutil.PostgresConnection;
import com.shop.exception.BusinessException;
import com.shop.model.ItemOffer;

public class ItemOfferDAOImpl implements ItemOfferDAO {

	@Override
	public int addItemOffer(ItemOffer itemOffer) throws BusinessException {
		try (Connection connection = PostgresConnection.openConnection()) {

			String sql = "INSERT INTO shop.itemoffer (item_id,  customer_id, offer_price,"
					+ " offer_date, quantity, plan_weeks_count) " + "	VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			int index = 1;
			preparedStatement.setInt(index++, itemOffer.getItem_id());
			preparedStatement.setInt(index++, itemOffer.getCustomer_id());
			preparedStatement.setDouble(index++, itemOffer.getOffer_price());
			preparedStatement.setDate(index++, itemOffer.getOffer_date());
			preparedStatement.setInt(index++, itemOffer.getQuantity());
			preparedStatement.setInt(index++, itemOffer.getPlan_weeks_count());
			int count = preparedStatement.executeUpdate();
			return count;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Internal error: " + e.getMessage());
		}

	}

	public List<ItemOffer> getAvailableItemOffers() throws BusinessException {
		List<ItemOffer> itemOffersList = new ArrayList<>();
		try (Connection connection = PostgresConnection.openConnection()) {
			String sql = "Select * from shop.itemoffer where" + " is_accepted is null";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ItemOffer itemOffer1 = new ItemOffer();

				itemOffer1.setId(resultSet.getInt("id"));
				itemOffer1.setItem_id(resultSet.getInt("item_id"));
				itemOffer1.setCustomer_id(resultSet.getInt("customer_id"));
				itemOffer1.setOffer_price(resultSet.getDouble("offer_price"));
				itemOffer1.setOffer_date(resultSet.getDate("offer_date"));
				itemOffer1.setQuantity(resultSet.getInt("quantity"));
				itemOffer1.setIs_accepted(resultSet.getBoolean("is_accepted"));
				itemOffer1.setPlan_weeks_count(resultSet.getInt("plan_weeks_count"));
				itemOffer1.setPaid_weeks_count(resultSet.getInt("paid_weeks_count"));

				itemOffersList.add(itemOffer1);
			}
			return itemOffersList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("Internal error: " + e.getMessage());
		}
	}

	@Override
	public int acceptOrReject(int itemOfferId, boolean accept) throws BusinessException {
		try (Connection connection = PostgresConnection.openConnection()) {

			String sql = "UPDATE shop.itemoffer SET is_accepted = ? WHERE id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			int index = 1;
			preparedStatement.setBoolean(index++, accept);
			preparedStatement.setInt(index++, itemOfferId);
			int count = preparedStatement.executeUpdate();
			return count;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Internal error: " + e.getMessage());
		}

	}

	@Override
	public List<ItemOffer> getItemOffersByCustomerId(int customerId) throws BusinessException {
		List<ItemOffer> itemOffersList = new ArrayList<>();
		try (Connection connection = PostgresConnection.openConnection()) {
			String sql = "Select * from shop.itemoffer where "
					+ " customer_id = ? AND paid_weeks_count < plan_weeks_count";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, customerId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ItemOffer itemOffer1 = new ItemOffer();

				itemOffer1.setId(resultSet.getInt("id"));
				itemOffer1.setItem_id(resultSet.getInt("item_id"));
				itemOffer1.setCustomer_id(resultSet.getInt("customer_id"));
				itemOffer1.setOffer_price(resultSet.getDouble("offer_price"));
				itemOffer1.setOffer_date(resultSet.getDate("offer_date"));
				itemOffer1.setQuantity(resultSet.getInt("quantity"));
				itemOffer1.setIs_accepted(resultSet.getBoolean("is_accepted"));
				itemOffer1.setPlan_weeks_count(resultSet.getInt("plan_weeks_count"));
				itemOffer1.setPaid_weeks_count(resultSet.getInt("paid_weeks_count"));

				itemOffersList.add(itemOffer1);
			}
			return itemOffersList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("Internal error: " + e.getMessage());
		}
	}

	@Override
	public List<ItemOffer> getAcceptedItemOffersByCustomerId(int customerId) throws BusinessException {
		List<ItemOffer> itemOffersList = new ArrayList<>();
		try (Connection connection = PostgresConnection.openConnection()) {
			String sql = "Select * from shop.itemoffer where "
					+ " customer_id = ? AND is_accepted = 'true' AND paid_weeks_count < plan_weeks_count";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, customerId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ItemOffer itemOffer1 = new ItemOffer();

				itemOffer1.setId(resultSet.getInt("id"));
				itemOffer1.setItem_id(resultSet.getInt("item_id"));
				itemOffer1.setCustomer_id(resultSet.getInt("customer_id"));
				itemOffer1.setOffer_price(resultSet.getDouble("offer_price"));
				itemOffer1.setOffer_date(resultSet.getDate("offer_date"));
				itemOffer1.setQuantity(resultSet.getInt("quantity"));
				itemOffer1.setIs_accepted(resultSet.getBoolean("is_accepted"));
				itemOffer1.setPlan_weeks_count(resultSet.getInt("plan_weeks_count"));
				itemOffer1.setPaid_weeks_count(resultSet.getInt("paid_weeks_count"));

				itemOffersList.add(itemOffer1);
			}
			return itemOffersList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("Internal error: " + e.getMessage());
		}
	}

//	@Override
//	public List<ItemOffer> getAcceptedItemOffersByCustomerId(int customerId) throws BusinessException {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
