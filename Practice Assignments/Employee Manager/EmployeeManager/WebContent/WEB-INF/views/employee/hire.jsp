<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hire Employee</title>
</head>
<body>
	<form method="post" action="hire">
	<input type="text" value="${param.deptId}" name = "deptId"/>
		<table style="background-color: cyan; margin: auto;">
			<tr>
				<td>Employee Name</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>Salary</td>
				<td><input type="number" name="salary" /></td>
			</tr>

			<tr>
				<td>Date of Birth</td>
				<td><input type="date" name="dob" /></td>
			</tr>


			<tr>
				<td><input type="submit" value="Hire Employee" /></td>
			</tr>
		</table>
	</form>
</body>
</html>