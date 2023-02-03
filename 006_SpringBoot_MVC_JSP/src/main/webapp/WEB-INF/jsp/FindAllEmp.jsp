<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
</head>
<meta charset="ISO-8859-1">
<title>Employees list</title>

<table border="3px">

<tr>
<th>Id</th><th>Name</th><th>Salary</th><th>Email ID</th><th>Update</th><th>Delete</th></tr>
<c:forEach items="${empls}" var="emp">
<tr><td><c:out value="${emp.id}"></c:out></td>
<td><c:out value="${emp.name}"></c:out></td>
<td><c:out value="${emp.salary}"></c:out></td>
<td><c:out value="${emp.email}"></c:out></td>

<td><a href="./update?id=${emp.id}" >Update</a></td>
<td><a href="./delete?id=${emp.id}">Delete</a></td>
<tr>
</c:forEach>
</table>



<body>
<h1>
</h1>
</body>
</html>