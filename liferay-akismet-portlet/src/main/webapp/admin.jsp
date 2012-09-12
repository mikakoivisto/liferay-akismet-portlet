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
long companyId = PortalUtil.getCompanyId(request);

PortletPreferences preferences = PrefsPropsUtil.getPreferences(companyId);

String apiKey = PrefsParamUtil.getString(preferences, request, "akismet.api.key");
boolean enabled = PrefsParamUtil.getBoolean(preferences, request, "akismet.enabled");
%>
<portlet:actionURL name="updateConfiguration" var="updateConfigurationURL" />

<aui:form action="<%= updateConfigurationURL %>">

	<aui:fieldset label="configuration">
		<liferay-ui:error key="fi.javaguru.akismet.AkismetException" message="invalid-api-key" />

		<aui:input label="enabled" name="akismet.enabled" type="checkbox" value="<%= enabled %>"/>

		<aui:input label="api-key" name="akismet.api.key" value="<%= apiKey %>"/>
	</aui:fieldset>

	<aui:button-row>
		<aui:button label="save" type="submit" />
	</aui:button-row>
</aui:form>