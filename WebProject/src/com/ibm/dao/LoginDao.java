package com.ibm.dao;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ibm.bean.RegisterBean;
import com.ibm.connection.DBConnection;

public class LoginDao {
	public String authenticateUser(RegisterBean loginBean)
	 {
	 	 String userName = loginBean.getUserName(); //Keeping user entered values in temporary variables.
		 String password = loginBean.getPassword();
		 String division = loginBean.getDivision();
		 
		Connection con = null;
		 Statement statement = null;
		 ResultSet resultSet = null;
		 
		 String userNameDB = "";
		 String passwordDB = "";
		 String divisionDB = "";
		 
		try
		 {
		 con = DBConnection.getConnection(); //establishing connection
		 statement = con.createStatement(); //Statement is used to write queries. Read more about it.
		 resultSet = statement.executeQuery("select userName,password,division from users"); //Here table name is users and userName,password are columns. fetching all the records and storing in a resultSet.
		 
		while(resultSet.next()) // Until next row is present otherwise it return false
		 {
		  userNameDB = resultSet.getString("userName"); //fetch the values present in database
		  passwordDB = resultSet.getString("password");
	      divisionDB = resultSet.getString("division");
		  
		   if(userName.equals(userNameDB) && password.equals(passwordDB) && division.equals(divisionDB))
		   {
		      return "SUCCESS"; ////If the user entered values are already present in database, which means user has already registered so I will return SUCCESS message.
		   }
		 }
		 }
		 catch(SQLException e)
		 {
		 e.printStackTrace();
		 }
		 return "Invalid user credentials"; // Just returning appropriate message otherwise
		 
		 }
}