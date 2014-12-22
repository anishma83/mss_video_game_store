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
<jsp:include page="header.jsp"></jsp:include>

<p>Customer Test</p>

<p>Customer Name: ${customer.first_Name}&nbsp${customer.last_Name }</p>

<p>Order Count:${customer.orders.size}</p>


<!-- hello Test -->
<%-- <p>${hello}</p> --%>
<!-- <p>Customers</p> -->
<!-- <table> -->
<%-- <c:forEach var="customer" items="${customers}"> --%>
<!-- <tr> -->
<%-- <td>${customer.first_Name}</td> --%>
<!-- </tr> -->
<%-- </c:forEach> --%>
<!-- </table> -->
<!-- <p>Categories</p> -->
<!-- <table> -->
<%-- <c:forEach var="category" items="${categories}"> --%>
<!-- <tr> -->
<%-- <td>${category.name}</td> --%>
<!-- </tr> -->
<%-- </c:forEach> --%>
<!-- </table> -->

<!-- <p>Orders</p> -->
<!-- <table> -->
<%-- <c:forEach var="order" items="${orders}"> --%>
<!-- <td>{$order.order_Id}</td> -->
<%-- </c:forEach> --%>
<!-- </table> -->

<!-- <p> Order Details </p> -->
<!-- <table> -->
<%-- <c:forEach var="orderDetail" items="${orderDetails}"> --%>
<!-- <tr> -->
<%-- <td>${orderDetail.order_Detail_Id}</td> --%>
<!-- </tr> -->
<%-- </c:forEach> --%>
<!-- </table> -->

<!-- <p>Product</p> -->
<%-- <c:forEach var="product" items="${products}"> --%>
<%-- <%@include file="product.jsp"%> --%>
<%-- </c:forEach> --%>


<!-- <p>Shippers</p> -->
<!-- <table> -->
<%-- <c:forEach var="shipper" items="${shippers}"> --%>
<!-- <tr> -->
<%-- <td>${shipper.shipper_Name}</td> --%>
<!-- </tr> -->
<%-- </c:forEach> --%>
<!-- </table> -->

<!-- <p>Suppliers</p> -->
<!-- <table> -->
<%-- <c:forEach var="supplier" items="${suppliers}"> --%>
<!-- <tr> -->
<%-- <td>${supplier.supplier_Id}</td> --%>
<!-- </tr> -->
<%-- </c:forEach> --%>
<!-- </table> -->

<jsp:include page="footer.jsp" ></jsp:include>
<jsp:include page="jsFiles.html"></jsp:include>
</body>
</html>