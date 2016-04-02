<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import= "com.example.command.RateImageCommand" %>
<%@ page import= "com.example.business.Images" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Assignment</title>
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
    <th>ID</th>
    <th>Title</th> 
    <th>Rating</th>
    <th>File Name</th>
    <th>Add Rating</th>
  </tr>

<% 
	Images ImageToRate;
	ImageToRate = (Images)(request.getSession().getAttribute("imageToRate"));
	int avg = ImageToRate.getRating() / ImageToRate.getNorating();
	if(avg > 5){
		avg = 5;
	}
	else if(avg < 1){
		avg = 1;
	}
%>
		<tr>
			<td><%=ImageToRate.getId() %></td>
			<td><%=ImageToRate.getTitle() %></td>
			<td><%=avg%></td>
			<td><%=ImageToRate.getFileName() %></td>
			<td>
			<form action="FrontController" method="post">
				<select name="ratingValue">
					  <option value="1">1</option>
					  <option value="2">2</option>
					  <option value="3">3</option>
					  <option value="4">4</option>
					  <option value="5">5</option>
				</select>
				<input type="hidden" name="imageID" value="<%=ImageToRate.getId()%>"/>
				<input type="hidden" name="action" value="UpdateRating" />
				<input type="submit" value="Update Rating">
			  </form>
			</td>
		</tr>

	
</table>	
</body>

</html>