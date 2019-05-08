package com.ibm.dao;
import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;

import com.ibm.bean.RegisterBean;
import com.ibm.connection.DBConnection;

public class RegisterDao {
	
	public String registerUser(RegisterBean registerBean)
	 {
	 String firstName = registerBean.getFirstName();
	 String lastName = registerBean.getLastName();
	 String email = registerBean.getEmail();
	 String division = registerBean.getDivision();
	 String userName = registerBean.getUserName();
	 String password = registerBean.getPassword();
	 
	 Connection con = null;
	 PreparedStatement pstmt = null;
	 
	 try
	 {
	 String query = "INSERT INTO users (SIGN, FIRSTNAME, LASTNAME, EMAIL, DIVISION, USERNAME, PASSWORD ) values (NULL,?,?,?,?,?,?)"; //Insert user details into the table 'USERS'
	 con = DBConnection.getConnection();
	 pstmt = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
	 pstmt.setString(1, firstName);
	 pstmt.setString(2, lastName);
	 pstmt.setString(3, email);
	 pstmt.setString(4, division);
	 pstmt.setString(5, userName);
	 pstmt.setString(6, password);
	 pstmt.execute();
	// int i= pstmt.executeUpdate();
	 
	// if (i!=0)  //Just to ensure data has been inserted into the database
	// return "SUCCESS"; 
	 }
	 catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			try {
				pstmt.close();
				con.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return "SUCCESS";
	 }
}
