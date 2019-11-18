<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="voter" class="beans.VoterBean" scope="session" />
<jsp:setProperty property="*" name="voter" />
<c:redirect url="${sessionScope.voter.registerVoter()}.jsp" />
