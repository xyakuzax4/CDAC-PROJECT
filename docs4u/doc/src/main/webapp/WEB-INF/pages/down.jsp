<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
	  <%  if(session.getAttribute("role")==null){
    		response.sendRedirect("login");
    	}else{
    		if((int)(session.getAttribute("role"))!=3)
    		{
    			response.sendRedirect("login");
    		}
    	} %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DOWNLOAD FILES</title>
<link rel="stylesheet" href="static/styles/s.css">
<link rel="stylesheet" href="static/styles/style.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,300;1,200;1,400&display=swap" rel="stylesheet">

</head>

<style>
body {
  background-image: url('static/styles/cloud.jpg') ;
   background-repeat: no-repeat;
   background-attachment: fixed; ;
    background-size: cover ;
 
}
</style>
<body>

<div class=container>
<div class="bg-text">
	<div class=login-form>
	<form action="index"><button class="raise">Back</button></form>
		<table>
			<tr>
			<th>name</th>
			<th>url</th>
			<th>size</th>
			</tr>
			<c:forEach var="files" items="${files}">
			<tr>
			<td>${files.name }</td>
			<td><form action="${files.url }">
			  <button class="raise">Download -- ${files.name }</button></form>
			</td>
			<td>${files.size }</td>
			</tr>
			</c:forEach>
			</table>
		</div>
		
		</div>
	</div>
</body>
</html>