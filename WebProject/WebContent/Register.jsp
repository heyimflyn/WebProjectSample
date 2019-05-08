<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<style>
div {
  background-color: gainsboro;
  width: 400px;
  padding: 15px;
  margin: 15px;
}

</style>
</head>
<script> 
function validate()
{ 
 var firstname = document.form.firstname.value;
 var lastname = document.form.lastname.value;
 var email = document.form.email.value;
 var division = document.form.division.value;
 var username = document.form.username.value; 
 var password = document.form.password.value;
 var conpassword= document.form.conpassword.value;
 
 if (firstname==null || firstname=="")
 { 
 	alert("First Name can't be blank"); 
 	return false; 
 }
 else if (lastname==null || lastname=="")
 { 
	 alert("First Name can't be blank"); 
	 return false; 
 }
 else if (email==null || email=="")
 { 
 	alert("Email can't be blank"); 
 	return false; 
 }
 else if(division.selectedIndex == 0)
 {
 alert("Division cannot be blank");
 return false;
 }
 else if (username==null || username=="")
 { 
 alert("Username can't be blank"); 
 	return false; 
 }
 	else if(password.length<6)
 { 
 alert("Password must be at least 6 characters long."); 
 	return false; 
 } 
	 else if (password!=conpassword)
 { 
 alert("Confirm Password should match with the Password"); 
	 return false; 
 } 
 } 
</script> 
<body>
<div>
<center><font face = "Arial" size = "5"><b>Register Account</b></font></center>
<br>
<form name="form" action="RegisterServlet" method="post" onsubmit="return validate()">
&emsp;&emsp;&emsp;&emsp;&emsp;&ensp;&ensp;
<font face = "Arial" size = "3"><b>First Name</b></font>
<input type="text" placeholder="Enter Firstname"name="firstname" />
<br>
<br> 
&emsp;&emsp;&emsp;&emsp;&emsp;&ensp;&ensp;
<font face = "Arial" size = "3"><b>Last Name</b></font>
<input type="text" placeholder="Enter Lastname" name="lastname" />
<br>
<br> 
&emsp;&emsp;&emsp;&emsp;&emsp;&ensp;&ensp;
<font face = "Arial" size = "3"><b>Email</b></font>
<input type="text" placeholder="Enter Email" name="email" />
<br>
<br> 
&emsp;&emsp;&emsp;&emsp;&emsp;&ensp;&ensp;
 <font face = "Arial" size = "3"><b>Choose Division</b></font>
 <select id= "division" name="division" onchange="getData(this.value)">
    <option>-----</option>
	<option value = "Student">Student</option>
	<option value = "Employee">Employee</option>
	<option value = "Admin">Admin</option>
</select>
<br>
<br>
&emsp;&emsp;&emsp;&emsp;&emsp;&ensp;&ensp; 
<font face = "Arial" size = "3"><b>Username</b></font>
<input type="text" placeholder="Enter Username" name="username" />
<br>
<br>
&emsp;&emsp;&emsp;&emsp;&emsp;&ensp;&ensp;
<font face = "Arial" size = "3"><b>Password</b></font>
<input type="password" placeholder="Enter Password" name="password" />
<br>
<br>
&emsp;&emsp;&ensp;&ensp; 
<font face = "Arial" size = "3"><b>Confirm Password</b></font>
<input type="password" placeholder="Confirm Password" name="conpassword" />
<br><br>
<p>
<%=(request.getAttribute("errMessage") == null) ? ""
 : request.getAttribute("errMessage")%>
 
&emsp;&emsp;&emsp;&emsp;&emsp;&ensp;&ensp;
<input type="submit" value="Register"></input>
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
<input type="reset" value="Reset"></input>

</form>
</div>
</body>
</html>