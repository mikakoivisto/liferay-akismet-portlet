package fi.javaguru.akismet.mb.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import fi.javaguru.akismet.mb.service.AkismetMBMessageLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class AkismetMBMessageClp extends BaseModelImpl<AkismetMBMessage>
    implements AkismetMBMessage {
    private long _akismetMBMessageId;
    private long _companyId;
    private long _groupId;
    private Date _createDate;
    private Date _modifiedDate;
    private long _mbMessageId;
    private boolean _spam;
    private String _author;
    private String _authorEmail;
    private String _authorUrl;
    private String _content;
    private String _permalink;
    private String _referrer;
    private String _type;
    private String _userAgent;
    private long _userId;
    private String _userUuid;
    private String _userIp;
    private BaseModel<?> _akismetMBMessageRemoteModel;

    public AkismetMBMessageClp() {
    }

    public Class<?> getModelClass() {
        return AkismetMBMessage.class;
    }

    public String getModelClassName() {
        return AkismetMBMessage.class.getName();
    }

    public long getPrimaryKey() {
        return _akismetMBMessageId;
    }

    public void setPrimaryKey(long primaryKey) {
        setAkismetMBMessageId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_akismetMBMessageId);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
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

    @Override
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

    public long getAkismetMBMessageId() {
        return _akismetMBMessageId;
    }

    public void setAkismetMBMessageId(long akismetMBMessageId) {
        _akismetMBMessageId = akismetMBMessageId;
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    public Date getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    public Date getModifiedDate() {
        return _modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }

    public long getMbMessageId() {
        return _mbMessageId;
    }

    public void setMbMessageId(long mbMessageId) {
        _mbMessageId = mbMessageId;
    }

    public boolean getSpam() {
        return _spam;
    }

    public boolean isSpam() {
        return _spam;
    }

    public void setSpam(boolean spam) {
        _spam = spam;
    }

    public String getAuthor() {
        return _author;
    }

    public void setAuthor(String author) {
        _author = author;
    }

    public String getAuthorEmail() {
        return _authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        _authorEmail = authorEmail;
    }

    public String getAuthorUrl() {
        return _authorUrl;
    }

    public void setAuthorUrl(String authorUrl) {
        _authorUrl = authorUrl;
    }

    public String getContent() {
        return _content;
    }

    public void setContent(String content) {
        _content = content;
    }

    public String getPermalink() {
        return _permalink;
    }

    public void setPermalink(String permalink) {
        _permalink = permalink;
    }

    public String getReferrer() {
        return _referrer;
    }

    public void setReferrer(String referrer) {
        _referrer = referrer;
    }

    public String getType() {
        return _type;
    }

    public void setType(String type) {
        _type = type;
    }

    public String getUserAgent() {
        return _userAgent;
    }

    public void setUserAgent(String userAgent) {
        _userAgent = userAgent;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    public String getUserIp() {
        return _userIp;
    }

    public void setUserIp(String userIp) {
        _userIp = userIp;
    }

    public BaseModel<?> getAkismetMBMessageRemoteModel() {
        return _akismetMBMessageRemoteModel;
    }

    public void setAkismetMBMessageRemoteModel(
        BaseModel<?> akismetMBMessageRemoteModel) {
        _akismetMBMessageRemoteModel = akismetMBMessageRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            AkismetMBMessageLocalServiceUtil.addAkismetMBMessage(this);
        } else {
            AkismetMBMessageLocalServiceUtil.updateAkismetMBMessage(this);
        }
    }

    @Override
    public AkismetMBMessage toEscapedModel() {
        return (AkismetMBMessage) Proxy.newProxyInstance(AkismetMBMessage.class.getClassLoader(),
            new Class[] { AkismetMBMessage.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        AkismetMBMessageClp clone = new AkismetMBMessageClp();

        clone.setAkismetMBMessageId(getAkismetMBMessageId());
        clone.setCompanyId(getCompanyId());
        clone.setGroupId(getGroupId());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());
        clone.setMbMessageId(getMbMessageId());
        clone.setSpam(getSpam());
        clone.setAuthor(getAuthor());
        clone.setAuthorEmail(getAuthorEmail());
        clone.setAuthorUrl(getAuthorUrl());
        clone.setContent(getContent());
        clone.setPermalink(getPermalink());
        clone.setReferrer(getReferrer());
        clone.setType(getType());
        clone.setUserAgent(getUserAgent());
        clone.setUserId(getUserId());
        clone.setUserIp(getUserIp());

        return clone;
    }

    public int compareTo(AkismetMBMessage akismetMBMessage) {
        long primaryKey = akismetMBMessage.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        AkismetMBMessageClp akismetMBMessage = null;

        try {
            akismetMBMessage = (AkismetMBMessageClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = akismetMBMessage.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(35);

        sb.append("{akismetMBMessageId=");
        sb.append(getAkismetMBMessageId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", modifiedDate=");
        sb.append(getModifiedDate());
        sb.append(", mbMessageId=");
        sb.append(getMbMessageId());
        sb.append(", spam=");
        sb.append(getSpam());
        sb.append(", author=");
        sb.append(getAuthor());
        sb.append(", authorEmail=");
        sb.append(getAuthorEmail());
        sb.append(", authorUrl=");
        sb.append(getAuthorUrl());
        sb.append(", content=");
        sb.append(getContent());
        sb.append(", permalink=");
        sb.append(getPermalink());
        sb.append(", referrer=");
        sb.append(getReferrer());
        sb.append(", type=");
        sb.append(getType());
        sb.append(", userAgent=");
        sb.append(getUserAgent());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", userIp=");
        sb.append(getUserIp());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(55);

        sb.append("<model><model-name>");
        sb.append("fi.javaguru.akismet.mb.model.AkismetMBMessage");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>akismetMBMessageId</column-name><column-value><![CDATA[");
        sb.append(getAkismetMBMessageId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>companyId</column-name><column-value><![CDATA[");
        sb.append(getCompanyId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>groupId</column-name><column-value><![CDATA[");
        sb.append(getGroupId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createDate</column-name><column-value><![CDATA[");
        sb.append(getCreateDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
        sb.append(getModifiedDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>mbMessageId</column-name><column-value><![CDATA[");
        sb.append(getMbMessageId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>spam</column-name><column-value><![CDATA[");
        sb.append(getSpam());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>author</column-name><column-value><![CDATA[");
        sb.append(getAuthor());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>authorEmail</column-name><column-value><![CDATA[");
        sb.append(getAuthorEmail());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>authorUrl</column-name><column-value><![CDATA[");
        sb.append(getAuthorUrl());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>content</column-name><column-value><![CDATA[");
        sb.append(getContent());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>permalink</column-name><column-value><![CDATA[");
        sb.append(getPermalink());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>referrer</column-name><column-value><![CDATA[");
        sb.append(getReferrer());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>type</column-name><column-value><![CDATA[");
        sb.append(getType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userAgent</column-name><column-value><![CDATA[");
        sb.append(getUserAgent());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userIp</column-name><column-value><![CDATA[");
        sb.append(getUserIp());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
