<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="bootstrap.jsp" %>
</head>
<body>

<form action="register" method="post"> 
<input type="text" placeholder="enter name" class="form-control" name = "Name">

<input type="email" placeholder="enter email" class="form-control" name = "Email">

<button type="submit">Register</button>

</form>

</body>
</html>