<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
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
		<div class=login-form>
			<h2> Teacher Form</h2>
				<form id="insertTeacher" action="insertTeacher" onsubmit="myFunction()" method="post">
				<table>
					<tr><td>First Name:</td> <td><input type="text" name="firstName"/></td></tr>
					<tr><td>Last Name:</td> <td><input type="text" name="lastName"/></td></tr>
					<tr><td>Password:</td> <td><input type="text" name="password"/></td></tr>
					<tr><td>Email:</td> <td><input type="text" name="email"/></td></tr>
				</table>
				
				<div class=login-form>
			<BR>
			<button class="raise">ADD TEACHER</button>
			<!-- <input type="submit" value="Login"/> -->
			</div>
			</form>
			<script>
				function myFunction() {
 				 alert("Successully Added");
				}
					</script>
		</div>
	</div>
	</div>
</body>
</html>