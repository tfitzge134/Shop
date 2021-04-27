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

}
