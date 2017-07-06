<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
table, th, td {
	border: 1px solid black;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SS RAD Final Project</title>
</head>
<body>
<h1>List of Customers</h1>
<table>
 <c:forEach items="${c1}" var="customer">
 <br>
 <h1>${customer.cId} ${customer.cName}</h1>
 <br>
 <h2>${customer.cName}'s Orders</h2>
 <table>
 <tr>
 <th>Order ID</th>
 <th>Quantity</th>
 <th>Product ID</th>
 <th>Description</th>
 </tr>
 <tr>
 <c:forEach items="${customer.orders}" var="order">
 <tr>
 <td>${order.oId}</td>
 <td>${order.qty}</td>
 <td>${order.prod.pId}</td>
 <td>${order.prod.pDesc}</td>
 </c:forEach>
 </tr>
</table>
</c:forEach>
<tr>
	    <td><a href="/">Home</a></td>
	    <td><a href="/addProduct">Add Product</a></td>
	    <td><a href="/showProducts">List Products</a></td>
	    <td><a href="/showOrders">List Orders</a></td>
	    <td><a href="logout">Logout</a></td>	    
	  </tr>
</table>

</body>
</html>