<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="menu.jsp" %>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lead List</title>
</head>
<body>
	<a href="viewCreateLeadPage">Create Lead</a>
	<h2>List of leads</h2>
	<table border="1">
	<tr>
	<th>First Name</th>
	<th>Last Name</th>
	<th>Email</th>
	<th>Mobile</th>
	<th>Source</th>
	</tr>
	
	<c:forEach var="data" items="${leads }">
	<tr>
	<td><a href="leadInfo?id=${data.id }">${data.firstName }</a></td>
	<td>${data.lastName }</td>
	<td>${data.email }</td>
	<td>${data.mobile }</td>
	<td>${data.source }</td>
	</tr>
	</c:forEach>
	
	</table>
</body>
</html>