package com.luv2code.jdbc;

import java.sql.Connection;

public class TestJdbc {

	public static void main(String[] args) {
		try {
			Connection conn = ConnectionManager.getConnection();
			System.out.println("Connection Successful!");
		}catch(Exception exc){
			exc.printStackTrace();
		}

	}

}
