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

package fi.javaguru.akismet.mb.hook.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ObjectValuePair;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.liferay.portlet.messageboards.service.MBMessageLocalService;
import com.liferay.portlet.messageboards.service.MBMessageLocalServiceWrapper;

import java.io.InputStream;
import java.util.List;

import fi.javaguru.akismet.Akismet;
import fi.javaguru.akismet.AkismetComment;
import fi.javaguru.akismet.AkismetException;
import fi.javaguru.akismet.mb.NoSuchMBMessageException;
import fi.javaguru.akismet.mb.model.AkismetMBMessage;
import fi.javaguru.akismet.mb.service.AkismetMBMessageLocalServiceUtil;

/**
 * @author Mika Koivisto
 */
public class AkismetMBMessageLocalServiceImpl
	extends MBMessageLocalServiceWrapper {

	public AkismetMBMessageLocalServiceImpl(
		MBMessageLocalService mbMessageLocalService) {

		super(mbMessageLocalService);
	}

	public MBMessage addDiscussionMessage(
			long userId, String userName, long groupId, String className,
			long classPK, long threadId, long parentMessageId, String subject,
			String body, ServiceContext serviceContext)
		throws PortalException, SystemException {

		if (!isEnabled(serviceContext.getCompanyId())) {
			return super.addDiscussionMessage(
				userId, userName, groupId, className, classPK, threadId,
				parentMessageId, subject, body, serviceContext);
		}

		int workflowAction = serviceContext.getWorkflowAction();

		serviceContext.setWorkflowAction(WorkflowConstants.ACTION_SAVE_DRAFT);

		MBMessage mbMessage = super.addDiscussionMessage(
			userId, userName, groupId, className, classPK, threadId,
			parentMessageId, subject, body, serviceContext);

		AkismetComment comment = createComment(
			mbMessage.getMessageId(), userId, userName,
			subject.concat("\n\n").concat(body), serviceContext);

		boolean spam = checkSpam(comment, serviceContext);

		if (spam) {
			serviceContext.setWorkflowAction(
				WorkflowConstants.ACTION_SAVE_DRAFT);
		}
		else {
			serviceContext.setWorkflowAction(workflowAction);
		}

		updateStatus(userId, spam, comment, mbMessage, serviceContext);

		return mbMessage;
	}

	public MBMessage updateDiscussionMessage(
		long userId, long messageId, String className, long classPK,
		String subject, String body, ServiceContext serviceContext)
		throws PortalException, SystemException {

		if (!isEnabled(serviceContext.getCompanyId())) {
			return super.updateDiscussionMessage(
				userId, messageId, className, classPK, subject, body,
				serviceContext);
		}

		int workflowAction = serviceContext.getWorkflowAction();

		serviceContext.setWorkflowAction(WorkflowConstants.ACTION_SAVE_DRAFT);

		MBMessage mbMessage = super.updateDiscussionMessage(
			userId, messageId, className, classPK, subject, body,
			serviceContext);

		AkismetComment comment = createComment(
			mbMessage.getMessageId(), userId, null,
			subject.concat("\n\n").concat(body), serviceContext);

		boolean spam = checkSpam(comment, serviceContext);

		if (spam) {
			serviceContext.setWorkflowAction(
				WorkflowConstants.ACTION_SAVE_DRAFT);
		}
		else {
			serviceContext.setWorkflowAction(workflowAction);
		}

		updateStatus(userId, spam, comment, mbMessage, serviceContext);

		return mbMessage;
	}

	public MBMessage addMessage(
			long userId, String userName, long groupId, long categoryId,
			long threadId, long parentMessageId, String subject, String body,
			String format,
			List<ObjectValuePair<String, InputStream>> inputStreamOVPs,
			boolean anonymous, double priority, boolean allowPingbacks,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		if (!isEnabled(serviceContext.getCompanyId())) {
			return super.addMessage(
				userId, userName, groupId, categoryId, threadId,
				parentMessageId, subject, body, format, inputStreamOVPs,
				anonymous, priority, allowPingbacks, serviceContext);
		}

		int workflowAction = serviceContext.getWorkflowAction();

		serviceContext.setWorkflowAction(WorkflowConstants.ACTION_SAVE_DRAFT);

		MBMessage mbMessage = super.addMessage(
			userId, userName, groupId, categoryId, threadId, parentMessageId,
			subject, body, format, inputStreamOVPs, anonymous, priority,
			allowPingbacks, serviceContext);

		AkismetComment comment = createComment(
			mbMessage.getMessageId(), userId, userName,
			subject.concat("\n\n").concat(body), serviceContext);

		boolean spam = checkSpam(comment, serviceContext);

		if (spam) {
			serviceContext.setWorkflowAction(
				WorkflowConstants.ACTION_SAVE_DRAFT);
		}
		else {
			serviceContext.setWorkflowAction(workflowAction);
		}

		updateStatus(userId, spam, comment, mbMessage, serviceContext);

		return mbMessage;
	}

	public MBMessage addMessage(
			long userId, String userName, long groupId, long categoryId,
			String subject, String body, String format,
			List<ObjectValuePair<String, InputStream>> inputStreamOVPs,
			boolean anonymous, double priority, boolean allowPingbacks,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		if (!isEnabled(serviceContext.getCompanyId())) {
			return super.addMessage(
				userId, userName, groupId, categoryId, subject, body, format,
				inputStreamOVPs, anonymous, priority, allowPingbacks,
				serviceContext);
		}

		int workflowAction = serviceContext.getWorkflowAction();

		serviceContext.setWorkflowAction(WorkflowConstants.ACTION_SAVE_DRAFT);

		MBMessage mbMessage = super.addMessage(
			userId, userName, groupId, categoryId, subject, body, format,
			inputStreamOVPs, anonymous, priority, allowPingbacks,
			serviceContext);

		AkismetComment comment = createComment(
			mbMessage.getMessageId(), userId, userName,
			subject.concat("\n\n").concat(body), serviceContext);

		boolean spam = checkSpam(comment, serviceContext);

		if (spam) {
			serviceContext.setWorkflowAction(
				WorkflowConstants.ACTION_SAVE_DRAFT);
		}
		else {
			serviceContext.setWorkflowAction(workflowAction);
		}

		updateStatus(userId, spam, comment, mbMessage, serviceContext);

		return mbMessage;
	}

	public MBMessage updateMessage(
			long userId, long messageId, String subject, String body,
			List<ObjectValuePair<String, InputStream>> inputStreamOVPs,
			List<String> existingFiles, double priority, boolean allowPingbacks,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		if (!isEnabled(serviceContext.getCompanyId())) {
			return super.updateMessage(
				userId, messageId, subject, body, inputStreamOVPs,
				existingFiles, priority, allowPingbacks, serviceContext);
		}

		int workflowAction = serviceContext.getWorkflowAction();

		serviceContext.setWorkflowAction(WorkflowConstants.ACTION_SAVE_DRAFT);

		MBMessage mbMessage = super.updateMessage(
			userId, messageId, subject, body, inputStreamOVPs, existingFiles,
			priority, allowPingbacks, serviceContext);

		AkismetComment comment = createComment(
			mbMessage.getMessageId(), userId, null,
			subject.concat("\n\n").concat(body), serviceContext);

		boolean spam = checkSpam(comment, serviceContext);

		if (spam) {
			serviceContext.setWorkflowAction(
				WorkflowConstants.ACTION_SAVE_DRAFT);
		}
		else {
			serviceContext.setWorkflowAction(workflowAction);
		}

		updateStatus(userId, spam, comment, mbMessage, serviceContext);

		return mbMessage;

	}

	protected boolean checkSpam(
			AkismetComment comment, ServiceContext serviceContext)
		throws SystemException {

		long companyId = serviceContext.getCompanyId();

		String akismetApiKey = PrefsPropsUtil.getString(
			companyId, "akismet.api.key");

		try {
			Akismet akismet = new Akismet(
				akismetApiKey, serviceContext.getPortalURL());

			return akismet.checkComment(comment);
		}
		catch (AkismetException ae) {
			ae.printStackTrace();
		}

		return false;
	}

	protected AkismetComment createComment(
			long messageId, long userId, String userName, String body,
			ServiceContext serviceContext)
		throws SystemException {

		User user = UserLocalServiceUtil.fetchUser(userId);

		String authorEmail = StringPool.BLANK;

		if (user != null) {
			authorEmail = user.getEmailAddress();

			if (Validator.isNull(userName)) {
				userName = user.getFullName();
			}
		}

		String permalink = serviceContext.getPortalURL().concat(
			"/c/message_boards/find_entry?messageId=").concat(
				String.valueOf(messageId));

		AkismetComment comment = new AkismetComment();

		comment.setAuthor(userName);
		comment.setAuthorEmail(authorEmail);
		comment.setContent(body);
		comment.setPermalink(permalink);
		comment.setType(AkismetComment.TYPE_COMMENT);
		comment.setUserAgent(serviceContext.getUserAgent());
		comment.setUserIp(serviceContext.getRemoteAddr());

		return comment;
	}

	protected boolean isEnabled(long companyId) throws SystemException {
		return PrefsPropsUtil.getBoolean(companyId, "akismet.enabled");
	}

	protected void updateAkismetMBMessage(
			long messageId, long userId, boolean spam, AkismetComment comment,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		try {
			AkismetMBMessage akismetMBMessage =
				AkismetMBMessageLocalServiceUtil.getByMessageId(messageId);

			if (akismetMBMessage.isSpam() != spam) {
				akismetMBMessage.setSpam(spam);

				AkismetMBMessageLocalServiceUtil.updateAkismetMBMessage(
					akismetMBMessage.getAkismetMBMessageId(), userId, messageId,
					spam, comment.getAuthor(), comment.getAuthorEmail(),
					comment.getAuthorUrl(), comment.getContent(),
					comment.getPermalink(), comment.getReferrer(),
					comment.getType(), comment.getUserAgent(),
					comment.getUserIp(), serviceContext);
			}
		}
		catch (NoSuchMBMessageException nsme) {
			AkismetMBMessageLocalServiceUtil.addAkismetMBMessage(
				userId, messageId, spam, comment.getAuthor(),
				comment.getAuthorEmail(), comment.getAuthorUrl(),
				comment.getContent(), comment.getPermalink(),
				comment.getReferrer(), comment.getType(),
				comment.getUserAgent(), comment.getUserIp(), serviceContext);
		}
	}

	protected void updateStatus(
			long userId, boolean spam, AkismetComment comment,
			MBMessage mbMessage, ServiceContext serviceContext)
		throws PortalException, SystemException {

		if (spam) {
			mbMessage.setStatus(WorkflowConstants.STATUS_DENIED);

			super.updateStatus(
				userId, mbMessage.getMessageId(),
				WorkflowConstants.STATUS_DENIED, serviceContext);
		}

		updateAkismetMBMessage(
			mbMessage.getMessageId(), userId, spam, comment, serviceContext);
	}

}
