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

package fi.javaguru.akismet.mb.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

import java.util.Date;
import java.util.List;

import fi.javaguru.akismet.mb.NoSuchMBMessageException;
import fi.javaguru.akismet.mb.model.AkismetMBMessage;
import fi.javaguru.akismet.mb.service.base.AkismetMBMessageLocalServiceBaseImpl;

/**
 * The implementation of the akismet m b message local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link fi.javaguru.akismet.mb.service.AkismetMBMessageLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mika Koivisto
 * @see fi.javaguru.akismet.mb.service.base.AkismetMBMessageLocalServiceBaseImpl
 * @see fi.javaguru.akismet.mb.service.AkismetMBMessageLocalServiceUtil
 */
public class AkismetMBMessageLocalServiceImpl
	extends AkismetMBMessageLocalServiceBaseImpl {

	public AkismetMBMessage addAkismetMBMessage(
			long userId, long mbMessageId, boolean spam, String author, String authorEmail,
			String authorUrl, String content, String permalink, String referrer,
			String type, String userAgent, String userIp,
			ServiceContext serviceContext)
		throws SystemException {

		long akismetMBMessageId = counterLocalService.increment(
			AkismetMBMessage.class.getName());

		AkismetMBMessage akismetMBMessage = akismetMBMessagePersistence.create(
			akismetMBMessageId);

		Date now = new Date();

		akismetMBMessage.setCompanyId(serviceContext.getCompanyId());
		akismetMBMessage.setGroupId(serviceContext.getScopeGroupId());
		akismetMBMessage.setCreateDate(now);
		akismetMBMessage.setModifiedDate(now);

		akismetMBMessage.setAuthor(author);
		akismetMBMessage.setAuthorEmail(authorEmail);
		akismetMBMessage.setAuthorUrl(authorUrl);
		akismetMBMessage.setContent(content);
		akismetMBMessage.setMbMessageId(mbMessageId);
		akismetMBMessage.setPermalink(permalink);
		akismetMBMessage.setReferrer(referrer);
		akismetMBMessage.setSpam(spam);
		akismetMBMessage.setType(type);
		akismetMBMessage.setUserAgent(userAgent);
		akismetMBMessage.setUserId(userId);
		akismetMBMessage.setUserIp(userIp);

		akismetMBMessagePersistence.update(akismetMBMessage, false);

		return akismetMBMessage;
	}

	public AkismetMBMessage updateAkismetMBMessage(
			long akismetMBMessageId, long userId, long mbMessageId, boolean spam,
			String author, String authorEmail, String authorUrl, String content,
			String permalink, String referrer, String type, String userAgent,
			String userIp, ServiceContext serviceContext)
		throws SystemException {

		AkismetMBMessage akismetMBMessage =
			akismetMBMessagePersistence.fetchByPrimaryKey(akismetMBMessageId);

		akismetMBMessage.setModifiedDate(new Date());

		akismetMBMessage.setAuthor(author);
		akismetMBMessage.setAuthorEmail(authorEmail);
		akismetMBMessage.setAuthorUrl(authorUrl);
		akismetMBMessage.setContent(content);
		akismetMBMessage.setMbMessageId(mbMessageId);
		akismetMBMessage.setPermalink(permalink);
		akismetMBMessage.setReferrer(referrer);
		akismetMBMessage.setSpam(spam);
		akismetMBMessage.setType(type);
		akismetMBMessage.setUserAgent(userAgent);
		akismetMBMessage.setUserId(userId);
		akismetMBMessage.setUserIp(userIp);

		akismetMBMessagePersistence.update(akismetMBMessage, false);

		return akismetMBMessage;
	}
	
	public int countByGroupId(long groupId) throws SystemException {
		return akismetMBMessagePersistence.countByGroupId(groupId);
	}

	public List<AkismetMBMessage> findByGroupId(long groupId)
		throws SystemException {

		return akismetMBMessagePersistence.findByGroupId(groupId);
	}

	public List<AkismetMBMessage> getByGroupId(
			long groupId, int start, int end)
		throws SystemException {

		return akismetMBMessagePersistence.findByGroupId(groupId, start, end);
	}

	public List<AkismetMBMessage> getByGroupId(
			long groupId, int start, int end, OrderByComparator obc)
		throws SystemException {

		return akismetMBMessagePersistence.findByGroupId(
			groupId, start, end, obc);
	}

	public AkismetMBMessage getByMessageId(long mbMessageId) throws PortalException, SystemException {
		return akismetMBMessagePersistence.findByMessageId(mbMessageId);
	}
}
