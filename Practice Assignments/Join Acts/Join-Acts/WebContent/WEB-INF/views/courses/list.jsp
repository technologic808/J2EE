<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Courses</title>
</head>
<body>

	<table>
		<tr>
			<th>Course Name</th>
			<th></th>
			<th></th>
		</tr>

		<c:forEach var="course" items="${requestScope.courses}">
			<tr>
				<td>${course.courseName}</td>
				
<%-- 			<td><a href = "courses/delete?cId=${course.cId}">Delete Course</a></td>
				<td><a href = "courses/admission?cId=${course.cId}">Admit Student</a></td> --%>
				
				<td><a href="<spring:url value='delete?cId=${course.cId}'/>">Delete Course</a></td>
				<td><a href="<spring:url value='admission?cId=${course.cId}'/>">Admit Student</a></td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>