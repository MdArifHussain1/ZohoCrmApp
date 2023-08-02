<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="menu.jsp" %>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contacts</title>
</head>
<body>
	<h2>List of contacts</h2>
	<table border="1">
	<tr>
	<th>First Name</th>
	<th>Last Name</th>
	<th>Email</th>
	<th>Mobile</th>
	<th>Source</th>
	<th>Billing</th>
	</tr>
	
	<c:forEach var="data" items="${contacts }">
	<tr>
	<td><a href="contactInfo?id=${data.id }">${data.firstName }</a></td>
	<td>${data.lastName }</td>
	<td>${data.email }</td>
	<td>${data.mobile }</td>
	<td>${data.source }</td>
	<td><a href="generateBill?id=${data.id }">billing</a></td>
	</tr>
	</c:forEach>
	
	</table>
</body>
</html>