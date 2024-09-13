package com.dbeg.week4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUpdateEg {

	private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

	public static void main(String[] args) {
		try {
			// load driverlass
			Class.forName(DRIVER_NAME);

			// connection to db server
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sept2", "root", "pass@word1");

			// prepare the statement
			PreparedStatement ps = conn.prepareStatement("update messages set ptype=? where ptype=?");
			// set the required fields in the above prepared statement
			ps.setString(1, "Internal");
			ps.setString(2, "I");
			// execue prepared statement
			int nrecs = ps.executeUpdate();
			System.out.println("Excuted Query" + nrecs);
			ps.setString(1, "External");
			ps.setString(2, "E");
			ps.executeUpdate();
			ResultSet rs = ps.executeQuery("Select * from messages");
			while (rs.next()) {
				int code = rs.getInt("id");
				String name = rs.getString("name").trim();
				String msg = rs.getString("msg").trim();
				String ptype = rs.getString("ptype").trim();
				System.out.println("Code : " + code + " Name : " + name + " Message: " + msg + " ptyp : " + ptype);
			}
			// fetch results and display
			// handle required exceptions
			rs.close();
			ps.close();
			conn.close();
		} catch (ClassNotFoundException ce) {
			System.out.println("Error occured" + ce);
		} catch (SQLException se) {
			System.out.println("Error occured" + se);
		}
	}

}
