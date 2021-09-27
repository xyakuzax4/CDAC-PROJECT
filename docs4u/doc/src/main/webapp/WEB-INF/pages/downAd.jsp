<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
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
<title>DOWNLOAD FILES</title>
<link rel="stylesheet" href="static/styles/s.css">
<link rel="stylesheet" href="static/styles/style.css">
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

<form action="indexad"><button class="raise">Back</button></form>
	<div class=login-form>
		<table>
			<tr>
			<th>name</th>
			<th>url</th>
			<th>size</th>
			<th></th>
			</tr>
			<c:forEach var="files" items="${files}">
			<tr>
			<td>${files.name }</td>
			<td><form action="${files.url }">
			  <button class="raise">Download -- ${files.name }</button></form>
			</td>
			<td>${files.size }</td>
			<td ><a href="deletefile?id=<c:out value='${files.file_id } '/>" style="color: gold;">Delete File</a></td>
			</tr>
			</c:forEach>
			</table>
		</div>
	</div>
	</div>
</body>
</html>