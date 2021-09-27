<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%  if(session.getAttribute("role")==null){
    		response.sendRedirect("loginad");
    	}else{
    		if((int)(session.getAttribute("role"))!=2)
    		{
    			response.sendRedirect("loginad");
    		}
    	} %>
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
    background-image: url('static/styles/admi.jpg'); 
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
<div class = login-form>
	<h1>Welcome to Admin Home</h1>
   <form action="logoutadm" method="get">
       <button class="raise">LOGOUT</button>
    </form>
    <br>
    <form action="uploadpage" method="get">
        <button class="raise">UPLOAD FILES</button>
    </form>
    
    <form action="filesS" method="get">
    <input type="hidden" name="teacherId" value="${user_id}"/>
        <button class="raise">SHOW FILES</button>
    </form>
   
    </div>

    </div>
   </div>
</body>
</html>