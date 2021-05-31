package com.luv2code.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConnectionManager {
	
	private static Connection conn;
	
	static Connection getConnection() {
		if (conn == null) {
			
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			
//			1.a) to register the driver class by giving a call to class.forName()
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
//				1.b) getting the connection object, DriverManager will give connection
				conn = DriverManager.getConnection(url,"vehaan","password");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return conn;
	}
	

}
