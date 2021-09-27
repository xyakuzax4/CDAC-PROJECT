<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%
    	if(session.getAttribute("role")==null || session.getAttribute("user_id")==null){
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
<title>Insert title here</title>
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
		<div class=login-form>	
		<form action="index"><button class="raise">Back</button></form>
			<h2 style="color: white;">My Details</h2>
			
	<table>
	<tr>
	<th><b>First Name</b></th>
	<th><b>Last Name</b></th>
	<th><b>Email</b></th>
	</tr>
	<tr>
	<td><b>${viewList.firstName }</b></td>
	<td><b>${viewList.lastName }</b></td>
	<td><b>${viewList.email }</b></td>
	</tr>
	</table>
	</div>
</div>
</div>
</body>
</html>