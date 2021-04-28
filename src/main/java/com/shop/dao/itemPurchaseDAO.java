package com.shop.dao;

public interface itemPurchaseDAO {

public int addOfferPrice(int itemid, int customerid);//insert into offerfiel
public int offerIsAccepted(boolean isAccepted);
public int viewItemPurchased(int customerid, int itemid);

}
//log.info("1)View available items");
//log.info("....2)Make an offer for an item");
//log.info("....3)Make payments an item");
//log.info("....4)view paymentsfor  an item");
//log.info("0)Back to Main Menu");
//log.info("-----------------");