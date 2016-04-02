<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	Forwarded by servlet to here: loginSuccess.jsp
	
	<br/><br/>
	
	<c:set var="user" value="${sessionScope.user}"/>
	<b>Hello <c:out value="${user.firstName}"/></b>
	<b>Welcome to the main menu.</b>
	
	<br/><br/>
	
	<form action="FrontController" method="post">
	     <input type="hidden" name="action" value="ListUsers" />
         <input type="submit" value="List Users" />
    </form>
    <form action="FrontController" method="post">
	     <input type="hidden" name="action" value="ViewUserProfile" />
         <input type="submit" value="View My Profile" />
    </form>    
    <form action="FrontController" method="post">
	     <input type="hidden" name="action" value="ViewImages" />
         <input type="submit" value="View Top Images" />
    </form>      
    <form action="FrontController" method="post">
           <table>
	           <tr>
	           		<td> Search title : </td><td> <input name="userTitle" size=15 type="text" /> </td> 
	           </tr>
	           <tr>
	           		<input type="hidden" name="action" value="SearchImage" />
        			<input type="submit" value="Search Images" />
	           </tr>
           </table>
    </form>  
		
</body>

</html>