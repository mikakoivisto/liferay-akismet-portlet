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

package fi.javaguru.akismet.mb.hook.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.struts.BaseStrutsPortletAction;
import com.liferay.portal.kernel.struts.StrutsPortletAction;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil;

import fi.javaguru.akismet.Akismet;
import fi.javaguru.akismet.AkismetComment;
import fi.javaguru.akismet.AkismetException;
import fi.javaguru.akismet.mb.NoSuchMBMessageException;
import fi.javaguru.akismet.mb.model.AkismetMBMessage;
import fi.javaguru.akismet.mb.service.AkismetMBMessageLocalServiceUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

/**
 * @author Mika Koivisto
 */
public class EditMessageAction extends BaseStrutsPortletAction {

	public void processAction(
			StrutsPortletAction originalStrutsPortletAction,
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse)
		throws Exception {

		long companyId = PortalUtil.getCompanyId(actionRequest);

		boolean enabled = PrefsPropsUtil.getBoolean(companyId, "akismet.enabled");

		String cmd = actionRequest.getParameter("cmd");
		String redirect = ParamUtil.getString(actionRequest, "redirect");

		if (enabled && Validator.isNotNull(cmd) &&
				(cmd.equals("SPAM") || cmd.equals("HAM"))) {

			try {
				updateStatus(actionRequest, actionResponse);

				SessionMessages.add(actionRequest, "request_processed", null);
			}
			catch (Exception e) {
				SessionErrors.add(actionRequest, e.getClass().getName());
			}

			redirect = PortalUtil.escapeRedirect(redirect);

			actionResponse.sendRedirect(redirect);
		}
		else {
			originalStrutsPortletAction.processAction(
				portletConfig, actionRequest, actionResponse);
		}
	}

	protected void updateStatus(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortalException, SystemException {

		String cmd = actionRequest.getParameter("cmd");
		long messageId = GetterUtil.getLong(actionRequest.getParameter("messageId"));
		boolean spam = cmd.equals("SPAM");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);

		AkismetMBMessage akismetMBMessage = null;

		try {
			akismetMBMessage =
				AkismetMBMessageLocalServiceUtil.getByMessageId(messageId);

			if (akismetMBMessage.isSpam() != spam) {
				akismetMBMessage.setSpam(spam);

				AkismetMBMessageLocalServiceUtil.updateAkismetMBMessage(
					akismetMBMessage.getAkismetMBMessageId(),
					akismetMBMessage.getUserId(), messageId,
					spam, akismetMBMessage.getAuthor(), akismetMBMessage.getAuthorEmail(),
					akismetMBMessage.getAuthorUrl(), akismetMBMessage.getContent(),
					akismetMBMessage.getPermalink(), akismetMBMessage.getReferrer(),
					akismetMBMessage.getType(), akismetMBMessage.getUserAgent(),
					akismetMBMessage.getUserIp(), serviceContext);
			}
		}
		catch (NoSuchMBMessageException nsme) {
			MBMessage mbMessage = MBMessageLocalServiceUtil.getMBMessage(messageId);

			User user = UserLocalServiceUtil.fetchUser(mbMessage.getUserId());

			String author = mbMessage.getUserName();
			String authorEmail = StringPool.BLANK;

			if (user != null) {
				author = user.getFullName();
				authorEmail = user.getEmailAddress();
			}
	
			String content = mbMessage.getSubject().concat(
				"\n\n").concat(mbMessage.getBody());

			String permalink = serviceContext.getPortalURL().concat(
				"/c/message_boards/find_entry?messageId=").concat(
					String.valueOf(messageId));

			akismetMBMessage =
				AkismetMBMessageLocalServiceUtil.addAkismetMBMessage(
				mbMessage.getUserId(), messageId, spam, author, authorEmail,
				StringPool.BLANK, content, permalink,
				serviceContext.getCurrentURL(), AkismetComment.TYPE_COMMENT,
				StringPool.BLANK, StringPool.BLANK, serviceContext);
		}

		int status = WorkflowConstants.STATUS_APPROVED;

		if (spam) {
			status = WorkflowConstants.STATUS_DENIED;
		}

		MBMessageLocalServiceUtil.updateStatus(
			serviceContext.getUserId(), messageId, status, serviceContext);

		AkismetComment comment = new AkismetComment();

		comment.setAuthor(akismetMBMessage.getAuthor());
		comment.setAuthorEmail(akismetMBMessage.getAuthorEmail());
		comment.setContent(akismetMBMessage.getContent());
		comment.setPermalink(akismetMBMessage.getPermalink());
		comment.setType(akismetMBMessage.getType());
		comment.setUserAgent(akismetMBMessage.getUserAgent());
		comment.setUserIp(akismetMBMessage.getUserIp());

		long companyId = serviceContext.getCompanyId();

		String akismetApiKey = PrefsPropsUtil.getString(
			companyId, "akismet.api.key");

		try {
			Akismet akismet = new Akismet(
				akismetApiKey, serviceContext.getPortalURL());

			if (spam) {
				akismet.submitSpam(comment);
			}
			else {
				akismet.submitHam(comment);
			}
		}
		catch (AkismetException ae) {
			ae.printStackTrace();
		}
	}

	public String render(
			StrutsPortletAction originalStrutsPortletAction,
			PortletConfig portletConfig, RenderRequest renderRequest,
			RenderResponse renderResponse)
		throws Exception {

		return originalStrutsPortletAction.render(
			portletConfig, renderRequest, renderResponse);
	}

	public void serveResource(
		StrutsPortletAction originalStrutsPortletAction,
		PortletConfig portletConfig, ResourceRequest resourceRequest,
		ResourceResponse resourceResponse)
		throws Exception {

		originalStrutsPortletAction.serveResource(
			portletConfig, resourceRequest, resourceResponse);
	}

	
}
