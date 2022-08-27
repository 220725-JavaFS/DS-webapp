package com.revature.utils;

import java.sql.Connection;//java.sql is JDBC package
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	//A singleton design pattern only allows one instance of a Class to exist in memory at a time.
	//connection here is a singleton
	private static Connection connection;
	
	public static Connection getConnection() throws SQLException {
		if (connection!=null && !connection.isClosed()){
			return connection;
		}else {
			//for many frameworks or multiple SQL drivers, need to register which driver 
			//for the the connection interface.  Class.forName method does this.
			//this step unnecessary for simple projects. but is best practice.
			
			try {
				Class.forName("org.postgresql.Driver");
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			String url = "jdbc:postgresql://javafs220725.c3segtbs0p7g.us-east-2.rds.amazonaws.com:5432/proj0";
			String username = "postgres";//possible to hide raw credentials using env variables
			String password = "password";//access variables with System.getenv("var-name");
				
			connection = DriverManager.getConnection(url, username, password);
			
			return connection;
			
		}
	}

	public static void main (String[] args) {
		try {
			getConnection();
			System.out.println("Connection Successful!");
		}catch (SQLException e) {
			e.printStackTrace();
	}
}
}
