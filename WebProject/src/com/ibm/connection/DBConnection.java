package com.ibm.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection getConnection() {
		Connection connection = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver"); //load driver in the program
			DriverManager.setLoginTimeout(10); //optional
			                                         //constant                //port//database //username //password
			connection = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/WebTech","root","root");
		    System.out.println("CONNECTION: " + connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}
}
