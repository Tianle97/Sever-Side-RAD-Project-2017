<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

     
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SS RAD Final Project</title>
</head>
<body>
<form:form modelAttribute="p1">
	<h1>Add New Product</h1>
  <table>
  
    <tr>
      <td>Product Description:</td>
      <td><form:input path="pDesc"></form:input></td>
      <td><form:errors path="pDesc"></form:errors></td>
    </tr>
     <tr>
      <td>Quantity in Stock:</td>
      <td><form:input path="qtyInStock"></form:input></td>
      <td><form:errors path="qtyInStock"></form:errors></td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="Add"/>
      </td>
    </tr>
     <tr>
	    <td><a href="/">Home</a></td>
	    <td><a href="/showOrders">List Orders</a></td>
	    <td><a href="/showProducts">List Products</a></td> 
	  </tr>
  </table>
</form:form>
</body>
</html>