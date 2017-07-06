<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SS RAD Final Project</title>
</head>
<body>
<form:form modelAttribute="c1">
	<h1>Add New Customer</h1>
  <table>
    <tr>
      <td>Customer Name:</td>
      <td><form:input path="cName"></form:input></td>
      <td><form:errors path="cName"></form:errors></td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="Add"/>
      </td>
    </tr>
     <tr>
	    <td><a href="/">Home</a></td>
	    <td><a href="/listOrders">List Orders</a></td>
	    <td><a href="/listProducts">List Products</a></td> 
	  </tr>
  </table>
</form:form>
</body>
</html>