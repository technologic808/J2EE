<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--invalidate session --%>
${pageContext.session.invalidate()}
<c:redirect url="login.jsp" />