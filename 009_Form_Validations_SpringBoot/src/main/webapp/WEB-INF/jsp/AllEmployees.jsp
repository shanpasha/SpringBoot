<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Employees</title>
</head>
<body>


<table border="2px">
<tr><th>Employee ID</th><th>Employee Name</th><th>Salary</th><th>Email</th></tr>
<c:forEach items="${getEmps}" var="emp">
<tr>
<td><c:out value="${emp.id}"></c:out></td>

<td><c:out value="${emp.name}"></c:out></td>
<td><c:out value="${emp.salary}"></c:out></td>
<td><c:out value="${emp.email}"></c:out></td>

</tr>

</c:forEach>

</table>

</body>
</html>