<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SS RAD Final Project</title>
</head>
<body>
<form:form modelAttribute="o1">
<h1>New Order</h1>
<table>

<tr>
<td>Customer ID:</td>
<td><form:input path="cust.cId"></form:input></td>
</tr>

<tr>
<td>Product ID:</td>
<td><form:input path="prod.pId"></form:input></td>
</tr>

<tr>
<td>Quantity:</td>
<td><form:input path="qty"></form:input></td>
<td><form:errors path="qty"></form:errors></td>
</tr>
 <tr>
      <td colspan="2">
        <input type="submit" value="Add"/>
      </td>
    </tr>
   
</table>
  <tr>
	    <td><a href="/">Home</a></td>
	    <td><a href="/showOrders">List Orders</a></td>
	    <td><a href="/showProducts">List Products</a></td> 
	  </tr>
</form:form>
</body>
</html>