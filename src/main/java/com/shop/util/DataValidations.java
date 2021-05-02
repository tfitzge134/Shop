package com.shop.util;

import java.util.Date;

public class DataValidations {

	public static boolean isValidEmail(String email) {
		if (email == null) {
			return false;
		}
		int atLocation = email.indexOf("@");
		int dotLocation = email.indexOf(".");
		//a@x.com
		if(atLocation >= 1 && dotLocation >= atLocation + 2) {
			return true;
		}
		
		return false;
	}

	public static boolean isFutureDate(Date date) {
		Date today = new Date();
		if (date.after(today)) {
			return true;
		}
		return false;
	}

	public static boolean isValidDiscount(double discount) {
		if (discount <= 0 || discount >= 100) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean isValidItemQuantity(Integer quantity) {
		if (quantity > 0) {
			return true;
		}
		return false;
	}

	public static boolean isValidPrice(double price) {
		if (price > 0) {
			return true;
		}
		return false;
	}

}
