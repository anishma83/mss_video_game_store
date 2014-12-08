<!DOCTYPE HTML><%@page language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
<%@include file="cssFiles.html"%>
<title>Mss Video Game Store</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div id="body">
<jsp:include page="product.jsp" />
</div>
<jsp:include page="footer.jsp"></jsp:include>
<%@include file="jsFiles.html"%>
</body>
</html>