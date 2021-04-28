package com.shop.util;

public class DataValidations {
	
	public static boolean isValidEmail(String email) {
		if(email == null) {
			return false;
		}
		if(email.contains("@")) {
			return true;
		}
		return false;
	}
	public static boolean isValidDate(String OfferDate ) {
		return false;
		/*
		 * offer date has to be > todays date 
		 * 
		 */
		
	}
	public static boolean isValidDiscount(double itemQuantity ) {
		return false;
		/*
		 * offer date has to be > todays date 
		 * 
		 */
		
	}
	public static boolean isValidItemQuantity(Integer itemQuantity ) {
		return false;
		/*
		 * offer date has to be > todays date 
		 * 
		 */
	}
		public static boolean isValidPrice(double itemPrice) {
			return false;
			/*
			 * offer date has to be > todays date 
			 * 
			 */
		}
			
		public static boolean isValidItemNumber(int itemid) {
			// TODO Auto-generated method stub
			return false;
		}

}
