package com.shop.main;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.shop.dao.ItemDAO;
import com.shop.dao.ItemOfferDAO;
import com.shop.dao.UserDAO;
import com.shop.dao.impl.ItemDAOImpl;
import com.shop.dao.impl.ItemOfferDAOImpl;
import com.shop.dao.impl.UserDAOImpl;
import com.shop.exception.BusinessException;
import com.shop.model.Item;
import com.shop.model.ItemOffer;
import com.shop.model.User;
import com.shop.util.DataValidations;

//Run the program with argument: -Dlog4j.configuration=log4j.properties
public class ShopMain {
	private static Logger log = Logger.getLogger(ShopMain.class);
	private static Scanner scanner = new Scanner(System.in);
	private static User currentUser;

	public static void main(String[] args) {
		log.info("Shop Appplication Started.");

		log.info("Welcome to Teresa's Shop," + "  where every day is a happy day");
		log.info("================================================");
		log.info("Teresa's Shop App V1.0");
		log.info("================================================");
		int ch = 0;
		do {
			log.info("\n-----------------");
			log.info("Shop MENU");
			log.info("-----------------");
			log.info("1)Login");
			log.info("2)Signup for User Account");

			log.info("0)Exit");

			log.info("Please enter an appropriate Search Option(1-8)");
			try {
				ch = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {

			}
			switch (ch) {
			case 1:
				login();

				break;
			case 2:
				signup();

				break;
			case 4:
				log.info("Under construction");

				break;
			case 0:
				log.info("Thank You for using the Shop APP V1.0.....");
				break;

			default:
				log.info("Invalid Choice... Please enter a proper choice between 1-? only.......");
				break;
			}
		} while (ch != 0);
		log.info("Shop Appplication Ended.\n------------");
	}

	// }
	private static void login() {
		log.info("Enter below Details to Login");
//validate if email exists in the database 
		// if not error

		log.info("Enter email:");
		String email = scanner.nextLine();

		log.info("Enter password:");
		String password = scanner.nextLine();

		try {
			UserDAO userDAO = new UserDAOImpl();
			User user = userDAO.verifyPassword(email, password);
			if (user != null) {
				currentUser = user;
				log.info("------------Login result---------");
				log.info("Person LOGIN Success!");
				log.info(user);

				if ("employee".equalsIgnoreCase(user.getRole())) {
					employeeMenu();
				} else if ("manager".equalsIgnoreCase(user.getRole())) {
					managerMenu();
				} else {
					customerMenu();
				}
			} else {
				log.info("User LOGIN FAILED!");
			}
		} catch (BusinessException e) {
			// log.error(e);
			log.error("....ERROR: " + e.getMessage());
			log.info("------------RETRY WITH VALID VALUES---------");
		}
	}

	private static void employeeMenu() {
		int ch = 0;
		do {
			log.info("------------EMPLOYEE MENU---------");
			log.info("1)Add Item");
			log.info("2)Accept or reject a pending offer");
			log.info("3)Remove an item from the shop");
			log.info("4)view all payments");
			// remove an item from the shop
			log.info("0)Back to Main Menu");
			log.info("-----------------");

			try {
				ch = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
			}
			switch (ch) {
			case 1:
				addItem();
				break;
			case 2:
				log.info("2)Accept or reject a pending offer");
				acceptOrRejectOffer();
				break;
			case 3:
				log.info("3)Remove an item from the shop");
				removeItemFromShop();
				break;
			case 0:
				log.info("....0)Back to Main Menu");

			default:
				log.info("Invalid Choice... Please enter a proper choice.");
				break;
			}

		} while (ch != 0);

	}

	private static void removeItemFromShop() {
		boolean available = printAvailableItems();
		if (!available) {
			return;
		}
		int itemId = getInputInt("Item Id");
		ItemDAO itemDAO = new ItemDAOImpl();
		try {
			int count = itemDAO.deleteItemById(itemId);
			if (count == 1) {
				log.info("------------Item Deleted successfully.--------");
			} else {
				log.info("------------Could NOT Delete Item.--------");
			}
		} catch (BusinessException e) {
			log.error("....ERROR: " + e.getMessage());
			log.info("------------RETRY WITH VALID VALUES---------");
		}

	}

	private static void acceptOrRejectOffer() {
		boolean available = printAvailableOffers();
		if (!available) {
			return;
		}
		int offerId = getInputInt("Offer Id");
		String input = getInputString("Accept OR Reject");
		boolean isAccepted = false;
		if ("Accept".equalsIgnoreCase(input)) {
			isAccepted = true;
		} else if ("Reject".equalsIgnoreCase(input)) {
			isAccepted = false;
		} else {
			System.out.println("----Invalid input: " + input);
			return;
		}

		ItemOfferDAO itemOfferDAO = new ItemOfferDAOImpl();
		try {
			itemOfferDAO.acceptOrReject(offerId, isAccepted);

			System.out.println("----Item Offer updated: isAccepted " + isAccepted);
		} catch (BusinessException e) {
			log.error("....ERROR: " + e.getMessage());
			log.info("------------RETRY WITH VALID VALUES---------");
		}

	}

	private static boolean printAvailableOffers() {
		ItemOfferDAO itemOfferDAO = new ItemOfferDAOImpl();
		try {
			List<ItemOffer> list = itemOfferDAO.getAvailableItemOffers();
			return printItemOffers(list);
		} catch (BusinessException e) {
			log.error("....ERROR: " + e.getMessage());
			log.info("------------RETRY WITH VALID VALUES---------");
			return false;
		}
	}

	private static boolean printItemOffers(List<ItemOffer> list) {
		if (list == null || list.isEmpty()) {
			System.out.println("----NO ItemOffers are Available.");
			return false;

		}
		System.out.println("----Available ItemOffers: ");
		for (ItemOffer itemOffer : list) {
			System.out.println(itemOffer);
		}
		System.out.println("--x--");
		return true;
	}

	private static void addItem() {
		String itemName = getInputString("itemName");
		double itemPrice = getInputDouble("itemPrice");
		double itemPromotionalDiscount = getInputDouble("itemPromotionalDiscount");
		int itemQuantity = getInputInt("itemQuantity");
		Date promotionStartDate = getInputDate("promotionStartDate");
		Date itemPromotionEndDate = getInputDate("itemPromotionEndDate");

		Item item = new Item();
		item.setItemName(itemName);
		item.setItemPrice(itemPrice);
		item.setItemPromotionalDiscount(itemPromotionalDiscount);
		item.setItemQuantity(itemQuantity);
		item.setPromotionStartDate(promotionStartDate);
		item.setItemPromotionEndDate(itemPromotionEndDate);

		ItemDAO itemDAO = new ItemDAOImpl();
		try {
			itemDAO.addItem(item);
			log.info("------------ITEM ADDED---------");
		} catch (BusinessException e) {
			log.error("....ERROR: " + e.getMessage());
			log.info("------------RETRY WITH VALID VALUES---------");
		}
	}

	private static int getInputInt(String name) {
		int value;
		do {
			log.info("Please enter " + name + ": ");
			try {
				value = Integer.parseInt(scanner.nextLine());
				break;
			} catch (NumberFormatException e) {
				log.info("Please enter an appropriate integer number.");
			}
		} while (true);
		return value;
	}

	public static Date getInputDate(String name) {
		String dateFormat = "MM/dd/yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		Date sqlDate = null;
		do {
			log.info("Please enter " + name + " " + dateFormat + ": ");
			try {
				java.util.Date utilDate = sdf.parse(scanner.nextLine());
				sqlDate = new Date(utilDate.getTime());
				break;
			} catch (Exception e) {
				log.info("Please enter an appropriate date in format: " + dateFormat);
			}
		} while (true);
		return sqlDate;
	}

	private static double getInputDouble(String name) {
		double value;
		do {
			log.info("Please enter " + name + ": ");
			try {
				value = Double.parseDouble(scanner.nextLine());
				break;
			} catch (NumberFormatException e) {
				log.info("Please enter an appropriate double number.");
			}
		} while (true);
		return value;
	}

	private static String getInputString(String name) {
		String value;
		do {
			log.info("Please enter " + name + ": ");
			value = scanner.nextLine();
			if (value.trim().isBlank()) {
				log.info("Please enter an appropriate non blank value.");
			} else {
				break;
			}
		} while (true);
		return value;
	}

	private static void customerMenu() {
		int ch = 0;
		do {
			log.info("------------CUSTOMER MENU---------");
			log.info("1)View available items");
			log.info("....2)View my purchases");
			log.info("....3)Make an offer for an item");
			log.info("....4)Make payments an item");
			log.info("....5)view paymentsfor  an item");
			log.info("0)Back to Main Menu");
			log.info("-----------------");

			try {
				ch = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
			}
			switch (ch) {
			case 1:
				log.info("1)View available items");
				printAvailableItems();
				break;
			case 2:
				log.info("....2)View my purchases");
				viewMyPurchases();

				break;
			case 3:
				log.info("....3)Make an offer for an item");
				makeOfferForItem();
				break;
			case 4:
				log.info("....4)Make payments an item");
				makePayments();
				break;
			case 5:
				log.info("....5)view payments for an item");
				viewPayments();
				break;
			case 6:
				log.info("....6) View documents");
				latePaymentLetter();
				break;

			case 0:
				log.info("....0)Back to Main Menu");

			default:
				log.info("Invalid Choice... Please enter a proper choice.");
				break;
			}

		} while (ch != 0);
	}

	private static void viewMyPurchases() {
		ItemOfferDAO dao = new ItemOfferDAOImpl();
		try {
			List<ItemOffer> list = dao.getAvailableItemOffersByCustomerId(currentUser.getId());
			printItemOffers(list);
		} catch (BusinessException e) {
			log.error("....ERROR: " + e.getMessage());
			log.info("------------RETRY WITH VALID VALUES---------");
		}
		
	}

	private static void latePaymentLetter() {
		// TODO Auto-generated method stub

	}

	private static void makeOfferForItem() {

		int item_id = getInputInt("item_id");
		int customer_id = currentUser.getId();
		double offer_price = getInputDouble("offer_price");
		int quantity = getInputInt("quantity");
		int plan_weeks_count = getInputInt("plan_weeks_count");
		Date sqlDate = new Date(System.currentTimeMillis());

		ItemOffer itemOffer = new ItemOffer();
		itemOffer.setItem_id(item_id);
		itemOffer.setCustomer_id(customer_id);
		itemOffer.setOffer_price(offer_price);
		itemOffer.setOffer_date(sqlDate);
		itemOffer.setQuantity(quantity);
		itemOffer.setPlan_weeks_count(plan_weeks_count);

		ItemOfferDAO dao = new ItemOfferDAOImpl();
		try {
			dao.addItemOffer(itemOffer);
			log.info("------------Item OFFER Added---------");
		} catch (BusinessException e) {
			log.error("....ERROR: " + e.getMessage());
			log.info("------------RETRY WITH VALID VALUES---------");
		}

	}

	private static void viewPayments() {
		// TODO Auto-generated method stub

	}

	private static void makePayments() {
		// TODO Auto-generated method stub

	}

	private static void updateItemPricebyId() {
		// TODO Auto-generated method stub

	}

	private static boolean printAvailableItems() {
		ItemDAO itemDAO = new ItemDAOImpl();
		try {
			List<Item> list = itemDAO.getAvailableItems();
			if (list == null || list.isEmpty()) {
				System.out.println("----NO Items are Available.");
				return false;

			}
			System.out.println("----Available Items: ");
			for (Item item : list) {
				System.out.println(item);
			}
			System.out.println("--x--");
			return true;
		} catch (BusinessException e) {
			e.printStackTrace();
			System.out.println("ERROR: " + e.getMessage());
			return false;
		}

	}

	private static void signup() {
		UserDAO userDAO = new UserDAOImpl();

		System.out.println("Enter user email for new account: ");
		String email = scanner.nextLine();
		if (!DataValidations.isValidEmail(email)) {
			System.out.println("Email is invalid.");
			return;
		}

		try {
			boolean emailInUse = userDAO.isEmailInUse(email);
			if (emailInUse) {
				System.out.println("Email is already in use.");
				return;
			}
		} catch (BusinessException e1) {
			e1.printStackTrace();
			System.out.println("ERROR: " + e1.getMessage());
			return;
		}

		String password = getInputString("password");
		String role = getInputString("role");

		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		user.setRole(role);

		try {
			boolean success = userDAO.addUser(user);
			if (success) {
				System.out.println("User added successfully.");
			} else {
				System.out.println("Add User FAILED.");
			}
		} catch (BusinessException e) {
			e.printStackTrace();
			System.out.println("ERROR: " + e.getMessage());
		}

	}

	private static void managerMenu() {
		int ch = 0;
		do {
			log.info("------------Manager MENU---------");
			log.info("1)Add employee accounts");
			log.info("2)edit existing items");
			log.info("3.fire employees");
			log.info("4.view sales history of all offers");
			log.info("0)Back to Main Menu");
			log.info("-----------------");

			try {
				ch = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
			}
			switch (ch) {
			case 1:
				log.info("1)Add employee accounts");
				addEmployeeAccount();
				break;
			case 2:
				log.info("....2)edit existing items");
				viewMyAccounts();
				break;
			case 3:
				log.info("....2)fire employees");
				fireEmployee();
				break;
			case 4:
				log.info("....2)view sales history of all offers");
				makePayments();
				break;

			case 0:
				log.info("....0)Back to Main Menu");

			default:
				log.info("Invalid Choice... Please enter a proper choice.");
				break;
			}

		} while (ch != 0);
	}

	private static void fireEmployee() {
		// TODO Auto-generated method stub

	}

	private static void viewMyAccounts() {
		ItemDAO itemdao = new ItemDAOImpl();
		System.out.println("View my items purchased");
		String purchases = scanner.nextLine();
		System.out.println("Enter a ten digit item number");
		int itemid = scanner.nextInt();
		if (!DataValidations.isValidItemNumber(itemid)) {
			System.out.println("invalid item number");
			return;
		}

	}

	private static void addEmployeeAccount() {
		UserDAO userDAO = new UserDAOImpl();

		System.out.println("Enter Employee email: ");
		String email = scanner.nextLine();
		if (!DataValidations.isValidEmail(email)) {
			System.out.println("Email is invalid.");
			return;
		}

		try {
			boolean emailInUse = userDAO.isEmailInUse(email);
			if (emailInUse) {
				System.out.println("Email is already in use.");
				return;
			}
		} catch (BusinessException e1) {
			e1.printStackTrace();
			System.out.println("ERROR: " + e1.getMessage());
			return;
		}

		String password = getInputString("password");
		String role = "employee";

		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		user.setRole(role);

		try {
			boolean success = userDAO.addUser(user);
			if (success) {
				System.out.println("Employee added successfully.");
			} else {
				System.out.println("Add Employee FAILED.");
			}
		} catch (BusinessException e) {
			e.printStackTrace();
			System.out.println("ERROR: " + e.getMessage());
		}

	}

}
