package com.ibm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.bean.RegisterBean;
import com.ibm.dao.LoginDao;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String division = request.getParameter("division");
		
		RegisterBean loginBean = new RegisterBean();
		 
		loginBean.setUserName(userName);
		loginBean.setPassword(password);
		loginBean.setDivision(division);
		 
		LoginDao loginDao = new LoginDao(); 
		 
		String userValidate = loginDao.authenticateUser(loginBean);
		 
		if(userValidate.equals("SUCCESS"))
		 {
		   request.setAttribute("userName", userName);
		   
		    if(division.equals("Employee")) {
		 	request.getRequestDispatcher("/EmployeeMenu.jsp").forward(request, response);
		 	    }
		 	else if(division.equals("Student")) {
			 	request.getRequestDispatcher("/StudentMenu.jsp").forward(request, response);
			 	    }
		 	else if(division.equals("Admin")) {
			 	request.getRequestDispatcher("/AdminMenu.jsp").forward(request, response);
			 	    }
		 }
		 else
		 {
		 request.setAttribute("errMessage", userValidate); 
		 request.getRequestDispatcher("/Login.jsp").forward(request, response);
		 }
		doGet(request, response);
	}

}
