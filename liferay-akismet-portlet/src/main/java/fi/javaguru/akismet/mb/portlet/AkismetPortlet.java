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

package fi.javaguru.akismet.mb.portlet;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import fi.javaguru.akismet.Akismet;
import fi.javaguru.akismet.AkismetException;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;

/**
 * @author Mika Koivisto
 */
public class AkismetPortlet extends MVCPortlet {

	public void updateConfiguration(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException {

		long companyId = PortalUtil.getCompanyId(actionRequest);
		String apiKey = ParamUtil.getString(actionRequest, "akismet.api.key");
		boolean enabled = ParamUtil.getBoolean(actionRequest, "akismet.enabled");

		try {
			if (Validator.isNotNull(apiKey)) {
				Akismet akismet = new Akismet(
					apiKey, PortalUtil.getPortalURL(actionRequest));

				if (!akismet.verifyKey()) {
					throw new AkismetException("Unable to verify api key");
				}
			}
			else if (enabled) {
				throw new AkismetException("Unable to verify api key");
			}

			PortletPreferences preferences = PrefsPropsUtil.getPreferences(
				companyId);

			preferences.setValue("akismet.api.key", apiKey);
			preferences.setValue("akismet.enabled", String.valueOf(enabled));

			preferences.store();
		}
		catch (AkismetException ae) {
			SessionErrors.add(actionRequest, AkismetException.class);
		}
		catch (SystemException se) {
			SessionErrors.add(actionRequest, se.getClass());
		}
	}

}
