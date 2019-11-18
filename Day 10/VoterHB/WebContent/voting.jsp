<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Voting List</title>
</head>

<jsp:useBean id="candidate" class="beans.CandidateBean" scope="session" />


<body>
	<!-- Generate the voting form dynamically -->
	<h5>${sessionScope.voter.message}</h5>
	<h4>Hello, ${sessionScope.voter.details.v_email}</h4>
	<h3 align=center>Please choose a Candidate</h3>
	<form action='status.jsp' method='post'>

		<c:forEach items="${sessionScope.candidate.candidateList}" var="c">
			<input type="radio" name="cId" value="${c.id}"> ${c.c_name} ( ${c.party} ) <br>
		</c:forEach>
		<input type='submit' value='Cast Vote'> <input type='submit'
			value='Logout' formaction='logout.jsp'>
	</form>
</body>
</html>