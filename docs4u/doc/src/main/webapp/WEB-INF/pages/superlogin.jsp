<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SUPER ADMIN LOGIN</title>
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
	<form action="/doc"><button class="raise">HOME</button></form>
		<div class=login-form>
			<h2 style="color: white;">Super Admin Login</h2>
			<form id="superlogin" action="superlogin" method="post">
				<table>
					<tr><td>Email</td> <td><input type="text" name="email"/></td></tr>
					<tr><td>Password</td> <td><input type="text" name="password"/></td></tr>
				</table>
				<div class=login-form>
			<BR>
			<button class="raise">LOGIN</button>
			<!-- <input type="submit" value="Login"/> -->
			</div>
			</form>
		</div>
		</div>
	</div>
</body>
</html>