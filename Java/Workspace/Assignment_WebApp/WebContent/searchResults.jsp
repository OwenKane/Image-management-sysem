<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import= "com.example.business.Images" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Assignment - Images</title>
<style>table, th, td  { 
   border: 1px solid black; }
table {
	display: table;
    border-collapse: separate;
    border-spacing: 2px;
    border-color: gray;}
</style>
</head>
<body>
<table style="width:50%">
<tr>
    <th>Title</th>
    <th>Rating</th> 
    <th>File Name</th>
    <th>Rate Image</th>
  </tr>
<% 
	List<Images> images;
	images = (List)(request.getSession().getAttribute("imagesfromTitle"));
	
	for(int i = 0; i < images.size(); i++) {
		int avg = images.get(i).getRating() / images.get(i).getNorating();
		if(avg > 5){
			avg = 5;
		}
		else if(avg < 1){
			avg = 1;
		}	
		%>
		<tr>
			<td><%=images.get(i).getTitle() %></td>
			<td><%=avg%></td>
			<td><%=images.get(i).getFileName() %></td>
			<td><form action="FrontController" method="post">
		 		<input type="hidden" name="imageID" value="<%=images.get(i).getId() %>"/>
		     	<input type="hidden" name="action" value="RateImage" />
	         	<input type="submit" value="Rate Image" />
	    	</td></form>
		</tr>
		<%
		
	}
%>
	

	
</table>	
</body>

</html>