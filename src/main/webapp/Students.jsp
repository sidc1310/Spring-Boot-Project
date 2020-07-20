<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>First JSP</title>
</head>
<%@ page import="java.util.Date" %>
<body>
<h3>Students</h3><br>
<strong>Current Time is</strong>: <%=new Date() %>

	<form action="addstudent">  
		<input type="text" name="id" value="ID..." /><br/>  
		<input type="text" name="fname" value="First Name..." /><br/>  
		<input type="text" name="lname"  value="Last Name..." /><br/>  
		<input type="submit" value="register"/>  
	</form>  
	<br><br><br><br>
	<h3>Get Student Details</h3>
	<form action="getstudent">  
		<input type="text" name="id" value="ID..." /><br/>
		<input type="submit" value="Find"/>  
	</form>
</body>
</html>