package com.ibm.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.DriverManager;

import com.ibm.bean.RegisterBean;

public class EmployeeDao {
	
	public EmployeeDao(String firstname, String lastname)
	 {
		 Connection con = null;
		 Statement stmt = null;
		 ResultSet rs = null; 
		 
		 String firstnameDB = "";
		 String lastnameDB = "";
		 
		 ArrayList<EmployeeDao> employ = new ArrayList<EmployeeDao>();
		 
		try{ 
			  
			 con = DriverManager.getConnection(firstnameDB + lastnameDB);
			 stmt =con.createStatement();
			 rs = stmt.executeQuery("SELECT FIRSTNAME,LASTNAME FROM USERS");
			 
			 while(rs.next()) // Until next row is present otherwise it return false
			 {
			    firstnameDB = rs.getString("firstname");
			    lastnameDB = rs.getString("lastname");
			    
			    EmployeeDao emp= new EmployeeDao(firstname, lastname);
			    
	         }

	        rs.close();
	        stmt.close();
	        con.close();
	      }catch(Exception e)
	         {
	           e.printStackTrace();
	           
	         }return;
	 }
}
