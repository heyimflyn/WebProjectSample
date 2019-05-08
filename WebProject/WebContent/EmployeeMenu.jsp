<%@page import="java.util.ArrayList"%>      <%--Importing all the dependent classes--%>
<%@page import="com.ibm.dao.EmployeeDao"%>
<%@page import="java.util.Iterator"%> 
<%@page import="com.ibm.bean.RegisterBean"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
table {
  width:100%;
}
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
th, td {
  padding: 15px;
  text-align: left;
}
table#t01 tr:nth-child(even) {
  background-color: #eee;
}
table#t01 tr:nth-child(odd) {
 background-color: #fff;
}
table#t01 th {
  background-color: black;
  color: white;
}
</style>
</head>
<body>  
<center><h2>EMPLOYEE MENU</h2></center>
 Welcome <%=request.getAttribute("userName") %> 
 <div style="text-align: right"><a href="LogoutServlet">Logout</a></div>

<% ArrayList<EmployeeDao> employeeList = (ArrayList) request.getAttribute("EmpList"); %>)

 <table id="t01">
 <tr>
 	<th>Firstname</th>
 	<th>Lastname</th>
 </tr>
 </tr>
    <%for(int i=0; i < employee.size(); i++)
    {
        EmployeeDao user = new EmployeeDao();
        user = (EmployeeDao) employee.get(i);
        %>
        <tr>
  
            <td><%= user.getFirstName() %></td>
            <td><%= user.getLastName() %></td>
        </tr>
          <%}%>
</body>
</html>