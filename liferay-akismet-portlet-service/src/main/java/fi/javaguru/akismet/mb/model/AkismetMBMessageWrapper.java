package fi.javaguru.akismet.mb.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AkismetMBMessage}.
 * </p>
 *
 * @author    Mika Koivisto
 * @see       AkismetMBMessage
 * @generated
 */
public class AkismetMBMessageWrapper implements AkismetMBMessage,
    ModelWrapper<AkismetMBMessage> {
    private AkismetMBMessage _akismetMBMessage;

    public AkismetMBMessageWrapper(AkismetMBMessage akismetMBMessage) {
        _akismetMBMessage = akismetMBMessage;
    }

    public Class<?> getModelClass() {
        return AkismetMBMessage.class;
    }

    public String getModelClassName() {
        return AkismetMBMessage.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("akismetMBMessageId", getAkismetMBMessageId());
        attributes.put("companyId", getCompanyId());
        attributes.put("groupId", getGroupId());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("mbMessageId", getMbMessageId());
        attributes.put("spam", getSpam());
        attributes.put("author", getAuthor());
        attributes.put("authorEmail", getAuthorEmail());
        attributes.put("authorUrl", getAuthorUrl());
        attributes.put("content", getContent());
        attributes.put("permalink", getPermalink());
        attributes.put("referrer", getReferrer());
        attributes.put("type", getType());
        attributes.put("userAgent", getUserAgent());
        attributes.put("userId", getUserId());
        attributes.put("userIp", getUserIp());

        return attributes;
    }

    public void setModelAttributes(Map<String, Object> attributes) {
        Long akismetMBMessageId = (Long) attributes.get("akismetMBMessageId");

        if (akismetMBMessageId != null) {
            setAkismetMBMessageId(akismetMBMessageId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        Date modifiedDate = (Date) attributes.get("modifiedDate");

        if (modifiedDate != null) {
            setModifiedDate(modifiedDate);
        }

        Long mbMessageId = (Long) attributes.get("mbMessageId");

        if (mbMessageId != null) {
            setMbMessageId(mbMessageId);
        }

        Boolean spam = (Boolean) attributes.get("spam");

        if (spam != null) {
            setSpam(spam);
        }

        String author = (String) attributes.get("author");

        if (author != null) {
            setAuthor(author);
        }

        String authorEmail = (String) attributes.get("authorEmail");

        if (authorEmail != null) {
            setAuthorEmail(authorEmail);
        }

        String authorUrl = (String) attributes.get("authorUrl");

        if (authorUrl != null) {
            setAuthorUrl(authorUrl);
        }

        String content = (String) attributes.get("content");

        if (content != null) {
            setContent(content);
        }

        String permalink = (String) attributes.get("permalink");

        if (permalink != null) {
            setPermalink(permalink);
        }

        String referrer = (String) attributes.get("referrer");

        if (referrer != null) {
            setReferrer(referrer);
        }

        String type = (String) attributes.get("type");

        if (type != null) {
            setType(type);
        }

        String userAgent = (String) attributes.get("userAgent");

        if (userAgent != null) {
            setUserAgent(userAgent);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        String userIp = (String) attributes.get("userIp");

        if (userIp != null) {
            setUserIp(userIp);
        }
    }

    /**
    * Returns the primary key of this akismet m b message.
    *
    * @return the primary key of this akismet m b message
    */
    public long getPrimaryKey() {
        return _akismetMBMessage.getPrimaryKey();
    }

    /**
    * Sets the primary key of this akismet m b message.
    *
    * @param primaryKey the primary key of this akismet m b message
    */
    public void setPrimaryKey(long primaryKey) {
        _akismetMBMessage.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the akismet m b message ID of this akismet m b message.
    *
    * @return the akismet m b message ID of this akismet m b message
    */
    public long getAkismetMBMessageId() {
        return _akismetMBMessage.getAkismetMBMessageId();
    }

    /**
    * Sets the akismet m b message ID of this akismet m b message.
    *
    * @param akismetMBMessageId the akismet m b message ID of this akismet m b message
    */
    public void setAkismetMBMessageId(long akismetMBMessageId) {
        _akismetMBMessage.setAkismetMBMessageId(akismetMBMessageId);
    }

    /**
    * Returns the company ID of this akismet m b message.
    *
    * @return the company ID of this akismet m b message
    */
    public long getCompanyId() {
        return _akismetMBMessage.getCompanyId();
    }

    /**
    * Sets the company ID of this akismet m b message.
    *
    * @param companyId the company ID of this akismet m b message
    */
    public void setCompanyId(long companyId) {
        _akismetMBMessage.setCompanyId(companyId);
    }

    /**
    * Returns the group ID of this akismet m b message.
    *
    * @return the group ID of this akismet m b message
    */
    public long getGroupId() {
        return _akismetMBMessage.getGroupId();
    }

    /**
    * Sets the group ID of this akismet m b message.
    *
    * @param groupId the group ID of this akismet m b message
    */
    public void setGroupId(long groupId) {
        _akismetMBMessage.setGroupId(groupId);
    }

    /**
    * Returns the create date of this akismet m b message.
    *
    * @return the create date of this akismet m b message
    */
    public java.util.Date getCreateDate() {
        return _akismetMBMessage.getCreateDate();
    }

    /**
    * Sets the create date of this akismet m b message.
    *
    * @param createDate the create date of this akismet m b message
    */
    public void setCreateDate(java.util.Date createDate) {
        _akismetMBMessage.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this akismet m b message.
    *
    * @return the modified date of this akismet m b message
    */
    public java.util.Date getModifiedDate() {
        return _akismetMBMessage.getModifiedDate();
    }

    /**
    * Sets the modified date of this akismet m b message.
    *
    * @param modifiedDate the modified date of this akismet m b message
    */
    public void setModifiedDate(java.util.Date modifiedDate) {
        _akismetMBMessage.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the mb message ID of this akismet m b message.
    *
    * @return the mb message ID of this akismet m b message
    */
    public long getMbMessageId() {
        return _akismetMBMessage.getMbMessageId();
    }

    /**
    * Sets the mb message ID of this akismet m b message.
    *
    * @param mbMessageId the mb message ID of this akismet m b message
    */
    public void setMbMessageId(long mbMessageId) {
        _akismetMBMessage.setMbMessageId(mbMessageId);
    }

    /**
    * Returns the spam of this akismet m b message.
    *
    * @return the spam of this akismet m b message
    */
    public boolean getSpam() {
        return _akismetMBMessage.getSpam();
    }

    /**
    * Returns <code>true</code> if this akismet m b message is spam.
    *
    * @return <code>true</code> if this akismet m b message is spam; <code>false</code> otherwise
    */
    public boolean isSpam() {
        return _akismetMBMessage.isSpam();
    }

    /**
    * Sets whether this akismet m b message is spam.
    *
    * @param spam the spam of this akismet m b message
    */
    public void setSpam(boolean spam) {
        _akismetMBMessage.setSpam(spam);
    }

    /**
    * Returns the author of this akismet m b message.
    *
    * @return the author of this akismet m b message
    */
    public java.lang.String getAuthor() {
        return _akismetMBMessage.getAuthor();
    }

    /**
    * Sets the author of this akismet m b message.
    *
    * @param author the author of this akismet m b message
    */
    public void setAuthor(java.lang.String author) {
        _akismetMBMessage.setAuthor(author);
    }

    /**
    * Returns the author email of this akismet m b message.
    *
    * @return the author email of this akismet m b message
    */
    public java.lang.String getAuthorEmail() {
        return _akismetMBMessage.getAuthorEmail();
    }

    /**
    * Sets the author email of this akismet m b message.
    *
    * @param authorEmail the author email of this akismet m b message
    */
    public void setAuthorEmail(java.lang.String authorEmail) {
        _akismetMBMessage.setAuthorEmail(authorEmail);
    }

    /**
    * Returns the author url of this akismet m b message.
    *
    * @return the author url of this akismet m b message
    */
    public java.lang.String getAuthorUrl() {
        return _akismetMBMessage.getAuthorUrl();
    }

    /**
    * Sets the author url of this akismet m b message.
    *
    * @param authorUrl the author url of this akismet m b message
    */
    public void setAuthorUrl(java.lang.String authorUrl) {
        _akismetMBMessage.setAuthorUrl(authorUrl);
    }

    /**
    * Returns the content of this akismet m b message.
    *
    * @return the content of this akismet m b message
    */
    public java.lang.String getContent() {
        return _akismetMBMessage.getContent();
    }

    /**
    * Sets the content of this akismet m b message.
    *
    * @param content the content of this akismet m b message
    */
    public void setContent(java.lang.String content) {
        _akismetMBMessage.setContent(content);
    }

    /**
    * Returns the permalink of this akismet m b message.
    *
    * @return the permalink of this akismet m b message
    */
    public java.lang.String getPermalink() {
        return _akismetMBMessage.getPermalink();
    }

    /**
    * Sets the permalink of this akismet m b message.
    *
    * @param permalink the permalink of this akismet m b message
    */
    public void setPermalink(java.lang.String permalink) {
        _akismetMBMessage.setPermalink(permalink);
    }

    /**
    * Returns the referrer of this akismet m b message.
    *
    * @return the referrer of this akismet m b message
    */
    public java.lang.String getReferrer() {
        return _akismetMBMessage.getReferrer();
    }

    /**
    * Sets the referrer of this akismet m b message.
    *
    * @param referrer the referrer of this akismet m b message
    */
    public void setReferrer(java.lang.String referrer) {
        _akismetMBMessage.setReferrer(referrer);
    }

    /**
    * Returns the type of this akismet m b message.
    *
    * @return the type of this akismet m b message
    */
    public java.lang.String getType() {
        return _akismetMBMessage.getType();
    }

    /**
    * Sets the type of this akismet m b message.
    *
    * @param type the type of this akismet m b message
    */
    public void setType(java.lang.String type) {
        _akismetMBMessage.setType(type);
    }

    /**
    * Returns the user agent of this akismet m b message.
    *
    * @return the user agent of this akismet m b message
    */
    public java.lang.String getUserAgent() {
        return _akismetMBMessage.getUserAgent();
    }

    /**
    * Sets the user agent of this akismet m b message.
    *
    * @param userAgent the user agent of this akismet m b message
    */
    public void setUserAgent(java.lang.String userAgent) {
        _akismetMBMessage.setUserAgent(userAgent);
    }

    /**
    * Returns the user ID of this akismet m b message.
    *
    * @return the user ID of this akismet m b message
    */
    public long getUserId() {
        return _akismetMBMessage.getUserId();
    }

    /**
    * Sets the user ID of this akismet m b message.
    *
    * @param userId the user ID of this akismet m b message
    */
    public void setUserId(long userId) {
        _akismetMBMessage.setUserId(userId);
    }

    /**
    * Returns the user uuid of this akismet m b message.
    *
    * @return the user uuid of this akismet m b message
    * @throws SystemException if a system exception occurred
    */
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _akismetMBMessage.getUserUuid();
    }

    /**
    * Sets the user uuid of this akismet m b message.
    *
    * @param userUuid the user uuid of this akismet m b message
    */
    public void setUserUuid(java.lang.String userUuid) {
        _akismetMBMessage.setUserUuid(userUuid);
    }

    /**
    * Returns the user ip of this akismet m b message.
    *
    * @return the user ip of this akismet m b message
    */
    public java.lang.String getUserIp() {
        return _akismetMBMessage.getUserIp();
    }

    /**
    * Sets the user ip of this akismet m b message.
    *
    * @param userIp the user ip of this akismet m b message
    */
    public void setUserIp(java.lang.String userIp) {
        _akismetMBMessage.setUserIp(userIp);
    }

    public boolean isNew() {
        return _akismetMBMessage.isNew();
    }

    public void setNew(boolean n) {
        _akismetMBMessage.setNew(n);
    }

    public boolean isCachedModel() {
        return _akismetMBMessage.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _akismetMBMessage.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _akismetMBMessage.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _akismetMBMessage.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _akismetMBMessage.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _akismetMBMessage.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _akismetMBMessage.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new AkismetMBMessageWrapper((AkismetMBMessage) _akismetMBMessage.clone());
    }

    public int compareTo(AkismetMBMessage akismetMBMessage) {
        return _akismetMBMessage.compareTo(akismetMBMessage);
    }

    @Override
    public int hashCode() {
        return _akismetMBMessage.hashCode();
    }

    public com.liferay.portal.model.CacheModel<AkismetMBMessage> toCacheModel() {
        return _akismetMBMessage.toCacheModel();
    }

    public AkismetMBMessage toEscapedModel() {
        return new AkismetMBMessageWrapper(_akismetMBMessage.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _akismetMBMessage.toString();
    }

    public java.lang.String toXmlString() {
        return _akismetMBMessage.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _akismetMBMessage.persist();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedModel}
     */
    public AkismetMBMessage getWrappedAkismetMBMessage() {
        return _akismetMBMessage;
    }

    public AkismetMBMessage getWrappedModel() {
        return _akismetMBMessage;
    }

    public void resetOriginalValues() {
        _akismetMBMessage.resetOriginalValues();
    }
}
