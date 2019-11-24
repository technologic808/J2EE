<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admission Form</title>
</head>
<body>
<h3>Student Admission Form</h3>
	<spring:form method="post" action="admission" modelAttribute="student">
	<input type="text" value="${param.cId}" name = "cId" hidden="true"/>
		<table style="background-color: cyan; margin: auto;">
			<tr>
				<td>Student Name</td>
				<td><spring:input  path="name" /></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><spring:input path="address" /></td>
			</tr>
			<tr>
				<td>Date of Birth</td>
				<td><input name="dob"  type="date"/></td>
			</tr>
			<tr>
				<td>CGPA</td>
				<td><spring:input path="cgpa" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Admit Student" /></td>
			</tr>
		</table>
	</spring:form>

</body>
</html>