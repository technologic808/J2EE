<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
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
				<td><a href="<spring:url value='hire?deptId=${department.deptId}'/>">${department.deptName}</a></td>
				<td>${department.location}</td>
				<td>${department.strength}</td>
				

			</tr>
		</c:forEach>
	</table>
</body>
</html>