package fi.javaguru.akismet.mb.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import fi.javaguru.akismet.mb.model.AkismetMBMessage;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing AkismetMBMessage in entity cache.
 *
 * @author Mika Koivisto
 * @see AkismetMBMessage
 * @generated
 */
public class AkismetMBMessageCacheModel implements CacheModel<AkismetMBMessage>,
    Serializable {
    public long akismetMBMessageId;
    public long companyId;
    public long groupId;
    public long createDate;
    public long modifiedDate;
    public long mbMessageId;
    public boolean spam;
    public String author;
    public String authorEmail;
    public String authorUrl;
    public String content;
    public String permalink;
    public String referrer;
    public String type;
    public String userAgent;
    public long userId;
    public String userIp;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(35);

        sb.append("{akismetMBMessageId=");
        sb.append(akismetMBMessageId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", createDate=");
        sb.append(createDate);
        sb.append(", modifiedDate=");
        sb.append(modifiedDate);
        sb.append(", mbMessageId=");
        sb.append(mbMessageId);
        sb.append(", spam=");
        sb.append(spam);
        sb.append(", author=");
        sb.append(author);
        sb.append(", authorEmail=");
        sb.append(authorEmail);
        sb.append(", authorUrl=");
        sb.append(authorUrl);
        sb.append(", content=");
        sb.append(content);
        sb.append(", permalink=");
        sb.append(permalink);
        sb.append(", referrer=");
        sb.append(referrer);
        sb.append(", type=");
        sb.append(type);
        sb.append(", userAgent=");
        sb.append(userAgent);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", userIp=");
        sb.append(userIp);
        sb.append("}");

        return sb.toString();
    }

    public AkismetMBMessage toEntityModel() {
        AkismetMBMessageImpl akismetMBMessageImpl = new AkismetMBMessageImpl();

        akismetMBMessageImpl.setAkismetMBMessageId(akismetMBMessageId);
        akismetMBMessageImpl.setCompanyId(companyId);
        akismetMBMessageImpl.setGroupId(groupId);

        if (createDate == Long.MIN_VALUE) {
            akismetMBMessageImpl.setCreateDate(null);
        } else {
            akismetMBMessageImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            akismetMBMessageImpl.setModifiedDate(null);
        } else {
            akismetMBMessageImpl.setModifiedDate(new Date(modifiedDate));
        }

        akismetMBMessageImpl.setMbMessageId(mbMessageId);
        akismetMBMessageImpl.setSpam(spam);

        if (author == null) {
            akismetMBMessageImpl.setAuthor(StringPool.BLANK);
        } else {
            akismetMBMessageImpl.setAuthor(author);
        }

        if (authorEmail == null) {
            akismetMBMessageImpl.setAuthorEmail(StringPool.BLANK);
        } else {
            akismetMBMessageImpl.setAuthorEmail(authorEmail);
        }

        if (authorUrl == null) {
            akismetMBMessageImpl.setAuthorUrl(StringPool.BLANK);
        } else {
            akismetMBMessageImpl.setAuthorUrl(authorUrl);
        }

        if (content == null) {
            akismetMBMessageImpl.setContent(StringPool.BLANK);
        } else {
            akismetMBMessageImpl.setContent(content);
        }

        if (permalink == null) {
            akismetMBMessageImpl.setPermalink(StringPool.BLANK);
        } else {
            akismetMBMessageImpl.setPermalink(permalink);
        }

        if (referrer == null) {
            akismetMBMessageImpl.setReferrer(StringPool.BLANK);
        } else {
            akismetMBMessageImpl.setReferrer(referrer);
        }

        if (type == null) {
            akismetMBMessageImpl.setType(StringPool.BLANK);
        } else {
            akismetMBMessageImpl.setType(type);
        }

        if (userAgent == null) {
            akismetMBMessageImpl.setUserAgent(StringPool.BLANK);
        } else {
            akismetMBMessageImpl.setUserAgent(userAgent);
        }

        akismetMBMessageImpl.setUserId(userId);

        if (userIp == null) {
            akismetMBMessageImpl.setUserIp(StringPool.BLANK);
        } else {
            akismetMBMessageImpl.setUserIp(userIp);
        }

        akismetMBMessageImpl.resetOriginalValues();

        return akismetMBMessageImpl;
    }
}
