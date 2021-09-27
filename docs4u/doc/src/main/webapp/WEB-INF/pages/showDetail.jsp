<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%
    	if(session.getAttribute("role")==null || session.getAttribute("user_id")==null){
    		response.sendRedirect("loginsupa");
    	}else{
    		if((int)(session.getAttribute("role"))!=1)
    		{
    			response.sendRedirect("loginsupa");
    		}
    	} 	
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Detail</title>
<link rel="stylesheet" href="static/styles/style.css">
<link rel="stylesheet" href="static/styles/s.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,300;1,200;1,400&display=swap" rel="stylesheet">
</head>
<body>
<form action="superwelcome"><button class="raise">Back</button></form>
	<div class=container>

		<div class=login-form>
			<h2>My Details</h2>
	<table>
	<tr>
	<th>First Name</th>
	<th>Last Name</th>
	<th>Email</th>
	</tr>
	<tr>
	<td>${viewList.firstName }</td>
	<td>${viewList.lastName }</td>
	<td>${viewList.email }</td>
	</tr>
	</table>
</div>
</div>
</body>
</html>