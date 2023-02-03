<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Employee</title>
</head>
<body>
<table>
<form action="./updateEmp" method="post">

<label>ID</label><br>
<input type="text" name="id" value="${employee.id}" readonly="readonly"><br>

<label>Name</label><br>
<input type="text" name="name"  value="${employee.name}"><br>

<label>Salary</label><br>
<input type="text" name="salary"  value="${employee.salary}"><br>


<label>Email</label><br>
<input type="text" name="email"  value="${employee.email}"><br>

<input type="submit" value="update">
</form>
</table>
</body>
</html>