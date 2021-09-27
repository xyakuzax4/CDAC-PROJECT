<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<title>USER HOME</title>
<link rel="stylesheet" href="static/styles/style.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link rel="stylesheet" href="static/styles/ss.css">
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
<div class=login-form>
<div class="bg-text">
	<h1 style="color: white;">Welcome to User Home Page</h1>
   <form action="logoutusr"><button class="raise">LOGOUT</button></form>
    <br>
    <form action="teachList" method="get">
        <button class="raise">DOWNLOAD FILES</button></form>
        
        <form action="showMyUser"><button class="raise">My Details</button></form>
   
    
    <!--  <form action="files" method="get"> -->
    
</div>
    </div> 
   </div>
</body>
</html>