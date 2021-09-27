<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,300;1,200;1,400&display=swap" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Edit Admin</title>
<link rel="stylesheet" href="static/styles/s.css">
<link rel="stylesheet" href="static/styles/style.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,300;1,200;1,400&display=swap" rel="stylesheet">
</head>
<body>
<form action="showteacherlist"><button class="raise">Back</button></form>
	<div class=container>
	
	<div class=login-form>
	<form class="lform" action="update" method="post">
	<input type="hidden" name="id" value="<c:out value='${adminObj.id}'/>">
	<input type="hidden" name="role" value="<c:out value='${adminObj.role}'/>">
		<label>First Name</label>
		<input type="text" name="firstName" value="<c:out value='${adminObj.firstName}'/>">
		<br>
		<label>Last Name</label>
		<input type="text" name = "lastName" value="<c:out value='${adminObj.lastName}'/>">
		<br>
		<label>Password</label>
		<input type="text" name = "password" value="<c:out value='${adminObj.password}'/>">
		<br>
		<label>Email</label>
		<input type="text" name="email" value="<c:out value='${adminObj.email}'/>">
		<br>
		<button class="raise">SAVE</button>
		
	</form>
	</div>
	</div>
</body>
</html>