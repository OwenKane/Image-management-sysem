<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import= "com.example.business.User" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>assignment</title>
<style>
</style>
</head>
<body>
<table style="width:50%">
<tr>
    <th>Profile</th>
  </tr>

<% 
	User users;
	users = (User)(request.getSession().getAttribute("user"));
		%>
		<tr>
			<td>First Name: <%=users.getFirstName() %></td>
		</tr>
		<tr>
			<td>Last Name: <%=users.getLastName() %></td>
		</tr>
		<tr>
			<td>User Name: <%=users.getUsername() %></td>
		</tr>
		<tr>
			<td>Password: <%=users.getPassword() %></td>
		</tr>
		<%
%>
	
</table>	
</body>

</html>