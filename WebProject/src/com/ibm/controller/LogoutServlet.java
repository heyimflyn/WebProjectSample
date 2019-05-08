package com.ibm.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		{ 
			 HttpSession session = request.getSession(false);
			 
			if(session!=null) 
			 {
			 session.invalidate(); //removes all session attributes bound to the session
			 System.out.println("/n");
			 request.setAttribute("errMessage", "logged out successfully");
			 RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Login.jsp");
			 requestDispatcher.forward(request, response);
			 System.out.println("Logged out");
			 }
			 }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
