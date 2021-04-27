package com.shop.dao.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class PostgresConnection {
	private static Logger log = Logger.getLogger(PostgresConnection.class);

	private static Connection connection;

	/// disable constructor by making it private
	private PostgresConnection() {

	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {

		// step 2 open connection
		if (connection == null) {
			return openConnection();
		} else {
			return connection;
		}

	}

	public static Connection openConnection() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		// System.out.println("Driver loaded succesfully");

		String url = "jdbc:postgresql://localhost:5432/Shop";
//jdbc:postgresql://{host}[:{port}]/[{database}]
		String username = "postgres";
		String password = "Printer@2007";

		connection = DriverManager.getConnection(url, username, password);
		return connection;
	}
}
