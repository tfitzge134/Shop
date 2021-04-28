package com.shop.dao;

import java.util.List;

import com.shop.exception.BusinessException;
import com.shop.model.ItemOffer;

public interface ItemOfferDAO {
	public int addItemOffer(ItemOffer itemOffer) throws BusinessException;

	public int acceptOrReject(int itemOfferId, boolean accept) throws BusinessException;

	public List<ItemOffer> getAvailableItemOffers() throws BusinessException;

}
