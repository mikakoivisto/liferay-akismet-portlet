<%@ include file="/html/portlet/message_boards/init.jsp" %>

<%
boolean canBan = MBPermission.contains(permissionChecker, scopeGroupId, ActionKeys.BAN_USER);
%>

<liferay-util:buffer var="html">
	<liferay-util:include page="/html/portlet/message_boards/view_message_content.portal.jsp" />
</liferay-util:buffer>

<c:if test="<%= canBan %>">
<%
int x = 0;
//String html = "";
while (x != -1) {
	x = html.indexOf("<ul class=\"edit-controls lfr-component\">", x);
	if (x == -1) {
		continue;
	}
	
	int y = html.indexOf("</ul>", x);
	String editControls = html.substring(x, y);
	int i = editControls.indexOf("_19_messageId=");
	if (i != -1 ) {
		int j = editControls.indexOf("\"", i);
		String messageId = editControls.substring(i + 14, j);
%>
<portlet:actionURL var="reportSpamURL">
	<portlet:param name="struts_action" value="/message_boards/edit_message" />
	<portlet:param name="<%= Constants.CMD %>" value="SPAM" />
	<portlet:param name="redirect" value="<%= currentURL %>" />
	<portlet:param name="messageId" value="<%= messageId %>" />
</portlet:actionURL>

<portlet:actionURL var="reportHamURL">
	<portlet:param name="struts_action" value="/message_boards/edit_message" />
	<portlet:param name="<%= Constants.CMD %>" value="HAM" />
	<portlet:param name="redirect" value="<%= currentURL %>" />
	<portlet:param name="messageId" value="<%= messageId %>" />
</portlet:actionURL>

<liferay-util:buffer var="spam">
	<li>
		<liferay-ui:icon
			image="unlink"
			label="<%= true %>"
			message="spam"
			url="<%= reportSpamURL %>"
		/>
	</li>
	<li>
		<liferay-ui:icon
			image="unlink"
			label="<%= true %>"
			message="ham"
			url="<%= reportHamURL %>"
		/>
	</li>
</liferay-util:buffer>
<%
		html = html.substring(0, y).concat(spam).concat(html.substring(y));
		y += spam.length();
	}
	x = y;
}
%>
</c:if>
<%= html %>