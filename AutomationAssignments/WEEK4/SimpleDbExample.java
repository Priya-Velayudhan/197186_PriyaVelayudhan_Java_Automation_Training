package com.dbeg.week4;

//Java program to set up connection and get all data from table
import java.sql.*;

public class SimpleDbExample {
	public static void main(String arg[]) {
		Connection connection = null;
		try {
			// below two lines are used for connectivity.
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sept2", "root", "pass@word1");

			// sept2 is database
			// roo is name of database
			// pass@word1 is password of database

			Statement statement;
			statement = connection.createStatement();
			ResultSet resultSet;
			resultSet = statement.executeQuery("select * from messages where name like '%1%' ");
			int code;
			String name, msg, ptype;
			while (resultSet.next()) {
				code = resultSet.getInt("id");
				name = resultSet.getString("name").trim();
				msg = resultSet.getString("msg").trim();
				ptype = resultSet.getString("ptype").trim();
				System.out.println("Code : " + code + " Name : " + name + " Message: " + msg + " ptyp : " + ptype);
			}
			resultSet.close();
			statement.close();
			connection.close();
		} catch (Exception exception) {
			System.out.println(exception);
		}
	} // function ends
} // class ends
