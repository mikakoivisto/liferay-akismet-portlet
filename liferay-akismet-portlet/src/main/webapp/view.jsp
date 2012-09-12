<%--
/**
 * Copyright (c) 2012 Mika Koivisto <mika@javaguru.fi>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
--%>
<%@ include file="init.jsp" %>

<%
PortletURL portletURL = renderResponse.createRenderURL();
String currentURL = PortalUtil.getCurrentURL(request);
%>
<liferay-ui:search-container
	emptyResultsMessage="there-are-no-comments"
	headerNames="name"
	iteratorURL="<%= portletURL %>">

	<liferay-ui:search-container-results
		results="<%= AkismetMBMessageLocalServiceUtil.findByGroupId(scopeGroupId, searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= AkismetMBMessageLocalServiceUtil.countByGroupId(scopeGroupId) %>"
	/>

	<liferay-ui:search-container-row
		className="fi.javaguru.akismet.mb.model.AkismetMBMessage"
		escapedModel="<%= true %>"
		keyProperty="akismetMBMessageId"
		modelVar="akismetMBMessage"
	>

		<liferay-ui:search-container-column-jsp
			align="right"
			path="/message_author.jsp"
			valign="top"
		/>
	</liferay-ui:search-container-row>

	<portlet:renderURL var="addServiceProviderURL">
		<portlet:param name="mvcPath" value="/admin/edit_sp_connection.jsp" />
		<portlet:param name="redirect" value="<%= currentURL %>" />
	</portlet:renderURL>
	<aui:button-row>
		<aui:button id="saml-menu" value="add-service-provider" href="<%= addServiceProviderURL %>" />
	</aui:button-row>

	<br />
		<liferay-ui:search-iterator />
</liferay-ui:search-container>
