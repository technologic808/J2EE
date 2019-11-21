<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Departments</title>
</head>
<body>
	<table>
	<tr>
	<th>Department</th>
	<th>Location</th>
	<th>Strength</th>
	</tr>
		<c:forEach var="department" items="${requestScope.list}">
			<tr>
				<td>${department.deptName}</td>
				<td>${department.location}</td>
				<td>${department.strength}</td>
				<%-- 
			<td><a href="<spring:url value='/admin/update?vid=${v.id}'/>">Update</a></td>
			<td><a href="<spring:url value='/admin/delete?vid=${v.id}'/>">Delete</a></td> --%>

			</tr>
		</c:forEach>
	</table>
</body>
</html>