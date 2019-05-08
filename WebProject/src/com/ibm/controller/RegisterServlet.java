package com.ibm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.bean.RegisterBean;
import com.ibm.dao.RegisterDao;
@WebServlet("/RegisterServlet")

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String firstName = request.getParameter("firstname");
		 String lastName = request.getParameter("lastname");
		 String email = request.getParameter("email");
		 String division = request.getParameter("division");
		 String userName = request.getParameter("username");
		 String password = request.getParameter("password");
		
		 RegisterBean registerBean = new RegisterBean();
		 registerBean.setFirstName(firstName);
		 registerBean.setLastName(lastName);
		 registerBean.setEmail(email);
		 registerBean.setDivision(division);
		 registerBean.setUserName(userName);
		 registerBean.setPassword(password); 
		 
		 RegisterDao registerDao = new RegisterDao();
		 
		 String userRegistered = registerDao.registerUser(registerBean);
		 
		 String divi = request.getParameter("division") ;
	     PrintWriter writer =  response.getWriter();
	     response.setContentType("text/html");
	
	     
		 if(userRegistered.equals("SUCCESS"))   
		 {
		 request.getRequestDispatcher("/Home.jsp").forward(request, response);
		 }
		 else   
		 {
		 request.setAttribute("errMessage", userRegistered);
		// request.getRequestDispatcher("/index.jsp").forward(request, response);
		 }
		 
		 
		doGet(request, response);
	}

}
