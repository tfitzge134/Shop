package com.shop.dao;

import java.util.List;

import com.shop.exception.BusinessException;
import com.shop.model.Item;

public interface ItemDAO {
	public int addItem(Item item) throws BusinessException;

	public int updateItemPricebyID(int itemid);// update offerpice by custoer

	public int updateItembyId(int itemid); // udate item when offer ic amakde

	public int getAvailableItems(int itemId);// view times

	public int deleteItemsById(int itemId);// delete items when offer is made

	public List<Item> getAvailableItems() throws BusinessException; // view allitems

}
