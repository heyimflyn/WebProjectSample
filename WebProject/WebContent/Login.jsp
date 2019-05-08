<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WebTech Log In</title>
</head>
<style>
div {
  background-color: gainsboro;
  width: 200px;
  padding: 30px;
  margin: 15px;
}
</style>
<script>
function validate()
{ 
 var username = document.form.username.value; 
 var password = document.form.password.value;
 var division = document.form.password.value;
 
 if (username==null || username=="")
 { 
 alert("Username cannot be blank"); 
 return false; 
 }
 else if(password==null || password=="")
 { 
 alert("Password cannot be blank"); 
 return false; 
 } 
 else if(division.selectedIndex == 0)
 {
 alert("Division cannot be blank");
 return false;
 }
 
}
</script> 
<body>
<div>
<center><font face = "Arial" size = "5"><b>Login application</b></font></center>
<br>
<form name="form" action="LoginServlet" method="post" onsubmit="return validate()">
 <font face = "Arial" size = "3"><b>Choose Division</b></font>
 <select id= "division" name="division" onchange="getData(this.value)" >
    <option>-----</option>
	<option value = "Student">Student</option>
	<option value = "Employee">Employee</option>
	<option value = "Admin">Admin</option>
</select>
<br>
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&ensp;&ensp; 
<font face = "Arial" size = "3"><b>Username</b></font>
<input type="text" placeholder="Enter Username" name="username" />
<br>
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&ensp;&ensp; 
<font face = "Arial" size = "3"><b>Password</b></font>
<input type="password" placeholder="Enter Password" name="password" />
<br>
<br>
<span style="color:red"><%=(request.getAttribute("errMessage") == null) ? ""
 : request.getAttribute("errMessage")%></span>

<input type="submit" value="Login"></input>
<br>
<br>
<font face = "Arial" size= "2">Create an <a href="Register.jsp">account</a></font>
</form>
</div>
</body>
</html>