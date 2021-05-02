package com.shop.dao;

import java.util.List;

import com.shop.exception.BusinessException;
import com.shop.model.Item;

public interface ItemDAO {
	public int addItem(Item item) throws BusinessException;

	public int updateItem(Item item) throws BusinessException;

	public Item getItemById(int itemid) throws BusinessException;// view times

	public int deleteItemById(int id) throws BusinessException;

	public List<Item> getAvailableItems() throws BusinessException; // view allitems

}
