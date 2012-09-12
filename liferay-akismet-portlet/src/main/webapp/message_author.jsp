
<%@ include file="init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

AkismetMBMessage akismetMBMessage = (AkismetMBMessage)row.getObject();

%>