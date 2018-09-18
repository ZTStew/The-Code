<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>The Lock</title>
</head>
<body>

<h3><c:out value="${error}"/></h3>
<h2>What is the code?</h2>
<form action="/check" method = "post">
	<input type="text" name = "answer">
	<input type="submit" value="Answer">
</form>

</body>
</html>