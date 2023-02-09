<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>


<style type="text/css">

.error{
color: red;
}



</style>
</head>
<body>

<form:form action="" method="post" modelAttribute="emps">



<table>
<tr>
<td>Employee ID</td>
<td><form:input path="id"/>  </td>
<td><form:errors path="id" class="error"/>  </td>
<tr>
<tr>
<td>Employee Name</td>
<td><form:input path="name"  class="error"/>  </td>
<td><form:errors path="name" class="error"/>  </td>
<tr>
<tr>
<td>Salary</td>
<td><form:input path="salary"/>  </td>
<td><form:errors path="salary" class="error"/>  </td>
<tr>
<tr>
<td>Email ID</td>
<td><form:input path="email"/>  </td>
<td><form:errors path="email" class="error"/>  </td>
<tr>
<td><input type="submit" value="Save">  </td>
<tr>

</table>






</form:form>

</body>
</html>