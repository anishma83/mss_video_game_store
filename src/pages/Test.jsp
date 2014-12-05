<!DOCTYPE HTML><%@page language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Test</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@include file="cssFiles.html"%>
</head>
<body>
hello Test
<p>${hello}</p>
<p>Customers</p>
<table>
<c:forEach var="customer" items="${customers}">
<tr>
<td>${customer.first_Name}</td>
</tr>
</c:forEach>
</table>
<p>Categories</p>
<table>
<c:forEach var="category" items="${categories}">
<tr>
<td>${category.name}</td>
</tr>
</c:forEach>
</table>


<%@include file="jsFiles.html"%>
</body>
</html>