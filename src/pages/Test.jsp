<!DOCTYPE HTML><%@page language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Test</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/main.css" >
<link rel="stylesheet" href="css/animate.css" >
<link rel="stylesheet" href="css/bootstrap.min.css" >
<link rel="stylesheet" href="css/font-awesome.min.css" >
<link rel="stylesheet" href="css/prettyPhoto.css" >
<link rel="stylesheet" href="css/price-range.css" >
<link rel="stylesheet" href="css/responsive.css" >
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


 <script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.scrollUp.min.js"></script>
	<script src="js/price-range.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/main.js"></script>
</body>
</html>