<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADMIN LOGIN</title>
<link rel="stylesheet" href="static/styles/style.css">
<link rel="stylesheet" href="static/styles/s.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,300;1,200;1,400&display=swap" rel="stylesheet">
</head>

<style>
body {
  background-image: url('static/styles/lock.jpg') ;
   background-repeat: no-repeat;
   background-attachment: fixed; ;
    background-size: cover ;
 
}
input[type="text"]
{   
    border: none;
     opacity: 30%;
    outline: none;
}
</style>


<body>
<form action="/doc"><button class="raise">Home Page</button></form>

<div class=container>
<div class="bg-text">
		<div class=login-form>
			<h2 style="color: white;"> Admin Login</h2>
			<form id="loginad" action="loginad" method="post">
				<table>
					<tr><td>Email</td> <td><input type="text" name="email"/></td></tr>
					<tr><td>Password</td> <td><input type="text" name="password"/></td></tr>
				</table>
				<br>
				<div class=login-form>
				<button class="raise">LOGIN</button>
				</div>
			</form>
		</div>
		</div>
	</div>
</body>
</html>