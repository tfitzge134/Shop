package com.shop.dao;

import java.util.List;

import com.shop.exception.BusinessException;
import com.shop.model.Item;

public interface ItemDAO {
	public int addItem(Item item) throws BusinessException;
	//public int viewAvailableItems(Items items)throws BusinessException;//view available times
	//public int updateItemPricebyId(int itemid)throws BusinessException;// update offerpice by custoer

	public int updateItemPricebyId(int itemid)throws BusinessException; // udate item price when offer ic amakde

	public int getAvailableItemsbyId(int itemid)throws BusinessException;// view times

	public int deleteItemById(int id)throws BusinessException;

	public List<Item> getAvailableItems() throws BusinessException; // view allitems
	
	

}
