<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
    <%
    	if(session.getAttribute("role")==null){
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
<title>Student List</title>
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
    background-image: url('static/styles/super.jpg'); 
     filter: blur(8px);
  -webkit-filter: blur(5px);
   background-repeat: no-repeat;
   background-attachment: fixed; 
    background-size: cover ;
    height: 100%; 
}
<style>
body,html {
margin: 0;
  height: 100%;
}
.bg-image {
    background-image: url('static/styles/super.jpg'); 
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



<form action="superwelcome"><button class="raise">Back</button></form>
	<div class=container>
		<div class=login-form>
			<h2>Student Details</h2>
	<table>
	<tr>
	<th>First Name</th>
	<th>Last Name</th>
	<th>Email</th>
	<th>Edit</th>
	<th>Delete</th>
	</tr>
	<c:forEach var="memberView" items="${viewList }">
	<tr>
	<td>${memberView.firstName }</td>
	<td>${memberView.lastName }</td>
	<td>${memberView.email }</td>
	<td><a href="editStudentDetail?id=<c:out value='${memberView.id } '/>">Edit Details</a></td>
	<td><a href="deletestu?id=<c:out value='${memberView.id }'/>">Delete Student</a></td>
	
	</tr>
	</c:forEach>
	</table>
	
</div>
</div>
</div>
</div>
</body>
</html>