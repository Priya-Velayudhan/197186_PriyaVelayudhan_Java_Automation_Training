package com.servicelayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.applayer.Product;

public class DBConnection {
	private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	static Connection conn;

	public static Connection getConnection() {

		// load driverlass
		try {
			Class.forName(DRIVER_NAME);

			// connection to db server
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sept2", "root", "pass@word1");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return conn;

	}

	public static void dbClose() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}