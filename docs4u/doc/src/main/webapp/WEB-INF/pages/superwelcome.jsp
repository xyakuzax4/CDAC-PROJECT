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
<title>!ADMIN!</title>

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

input[type="text"]
{   
    border: none;
     opacity: 30%;
    outline: none;
}
</style>
<body>
<div class="bg-image"></div>
<div class=container>
<div class="bg-text">
	<div class=header><h1>Welcome</h1></div>
		<div class="login-form">
			<ul>
		<li><form action="logout"><button class="raise">LOGOUT</button></form></li>
		<li><form action="addUser"><button class="raise">CREATE USER</button></form></li>
		<li><form action="addTeachers"><button class="raise">CREATE TEACHER</button></form></li>
		<li><form action="showMydetail"><button class="raise">MY DETAILS</button></form></li>
		<li><form action="showteacherlist"><button class="raise">SHOW TEACHERS</button></form></li>
		<li><form action="showstudentlist"><button class="raise">SHOW STUDENTS</button></form></li>
	</ul>    
	</div>
	</div>
	    </div>
	 
</body>
</html>