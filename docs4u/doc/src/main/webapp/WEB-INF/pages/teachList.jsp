<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%
    	if(session.getAttribute("role")==null){
    		response.sendRedirect("login");
    	}else{
    		if((int)(session.getAttribute("role"))!=3)
    		{
    			response.sendRedirect("login");
    		}
    	}
    	
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Documents</title>
<link rel="stylesheet" href="static/styles/style.css">
<link rel="stylesheet" href="static/styles/s.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,300;1,200;1,400&display=swap" rel="stylesheet">
</head>
<style>
body,html {
margin: 0;
  height: 100%;
}
.bg-image {
    background-image: url('static/styles/cloud.jpg'); 
     filter: blur(8px);
  -webkit-filter: blur(5px);
   background-repeat: no-repeat;
   background-attachment: fixed; 
    background-size: cover ;
    height: 100%; 
}
</style>
<body>
<div class="bg-image"></div>
	<div class=container>
	<div class="bg-text">
	<form action="index"><button class="raise">Back</button></form>
		<div class=login-form>
		
			<h2 style="color: white;">Teacher List</h2>
	<table>
	<tr>
	<th>First Name</th>
	<th>Last Name</th>
	<th>Email</th>
	<th></th>

	</tr>
	<c:forEach var="memberView" items="${viewList }">
	<tr>
	<td><b>${memberView.firstName }</b></td>
	<td><b>${memberView.lastName }</b></td>
	<td><b>${memberView.email }</b></td>
	<td><a href="showFiles?id=<c:out value='${memberView.id}'/>" style="color: gold;"><b>Show Files</b></a></td>
	
	</tr>
	</c:forEach>
	</table>
</div>
</div>

</div>
</body>
</html>