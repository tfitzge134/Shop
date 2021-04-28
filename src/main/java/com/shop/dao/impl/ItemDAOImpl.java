package com.shop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shop.dao.ItemDAO;
import com.shop.dao.dbutil.PostgresConnection;
import com.shop.exception.BusinessException;
//import com.shop.dao.impl.ItemDAOImpl;
import com.shop.model.Item;

public class ItemDAOImpl implements ItemDAO {

	@Override
	public int addItem(Item item) throws BusinessException {
		try (Connection connection = PostgresConnection.openConnection()) {

			String sql = "INSERT INTO shop.items (" + "	itemName, " + " itemPrice, "
					+ " item_promotion_discount, item_quantity," + " promotion_start_date, promotion_end_date) "
					+ "	VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			int index = 1;
			preparedStatement.setString(index++, item.getItemName());
			preparedStatement.setDouble(index++, item.getItemPrice());
			preparedStatement.setDouble(index++, item.getItemPromotionalDiscount());
			preparedStatement.setInt(index++, item.getItemQuantity());
			preparedStatement.setDate(index++, item.getPromotionStartDate());
			preparedStatement.setDate(index++, item.getItemPromotionEndDate());
			int count = preparedStatement.executeUpdate();
			return count;

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Internal error: " + e.getMessage());
		}

	}

	public List<Item> getAvailableItems() throws BusinessException {
		List<Item> itemsList = new ArrayList<>();
		try (Connection connection = PostgresConnection.openConnection()) {
			String sql = "Select * from shop.items where item_quantity > 0";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Item item1 = new Item();
				item1.setItemid(resultSet.getInt("itemid"));
				item1.setItemName(resultSet.getString("itemname"));
				item1.setItemPrice(resultSet.getDouble("itemprice"));
				item1.setItemPromotionalDiscount(resultSet.getDouble("item_promotion_discount"));
				item1.setItemQuantity(resultSet.getInt("item_quantity"));
				item1.setItemPromotionEndDate(resultSet.getDate("promotion_end_date"));
				item1.setPromotionStartDate(resultSet.getDate("promotion_start_date"));

				itemsList.add(item1);
			}
			return itemsList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("Internal error: " + e.getMessage());
		}
	}

	@Override
	public int updateItemPricebyId(int itemid) throws BusinessException {

		return 0;
	}

	@Override
	public int getAvailableItemsbyId(int itemid) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

}
