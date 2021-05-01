package com.shop.dao.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.shop.dao.UserDAO;
import com.shop.exception.BusinessException;
import com.shop.model.User;

class UserDAOImplTest {

//	private String email;
//
//	@BeforeEach
//	void createTestData() {
//		User user = new User();
//		email = "test" + System.currentTimeMillis() + "@example.com";
//		user.setEmail(email);
//		user.setPassword("abc123");
//
//		UserDAO dao = new UserDAOImpl();
//		try {
//			boolean success = dao.addUser(user);
//			if (!success) {
//				fail("Add user failed.");
//			}
//		} catch (BusinessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			fail("Add user failed.");
//		}
//	}
//
//	@AfterEach
//	void deleteTestData() {
//		email = "test" + System.currentTimeMillis() + "@example.com";
//
//		UserDAO dao = new UserDAOImpl();
//		try {
//			User userCreated = dao.getByEmail(email);
//			assertNotNull(userCreated, "Get user by Email failed.");
//			boolean deleted = dao.deleteById(userCreated.getId());
//			assertTrue(deleted, "Delete user failed.");
//			User userFromDB = dao.getByEmail(email);
//			assertNull(userFromDB, "Delete user failed.");
//		} catch (BusinessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			fail("ERROR: " + e.getMessage());
//		}
//	}

	@Test
	void testAddUser() {
		User user = new User();
		String emailNew = "test" + System.currentTimeMillis() + 10000 + "@example.com";
		user.setEmail(emailNew);
		user.setPassword("abc123");

		UserDAO dao = new UserDAOImpl();
		try {
			boolean success = dao.addUser(user);
			assertTrue(success, "Add user failed.");
			User userCreated = dao.getByEmail(emailNew);
			assertNotNull(userCreated, "Get user by Email failed.");
			boolean deleted = dao.deleteById(userCreated.getId());
			assertTrue(deleted, "Delete user failed.");
			User userFromDB = dao.getByEmail(emailNew);
			assertNull(userFromDB, "Delete user failed.");
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("ERROR: " + e.getMessage());
		}
	}

//	@Test
//	void testVerifyPassword() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testIsEmailInUse() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetByEmail() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testDeleteById() {
//		fail("Not yet implemented");
//	}

}
