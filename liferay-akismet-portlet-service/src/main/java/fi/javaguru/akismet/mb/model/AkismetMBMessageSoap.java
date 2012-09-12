package fi.javaguru.akismet.mb.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    Mika Koivisto
 * @generated
 */
public class AkismetMBMessageSoap implements Serializable {
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
    private String _userIp;

    public AkismetMBMessageSoap() {
    }

    public static AkismetMBMessageSoap toSoapModel(AkismetMBMessage model) {
        AkismetMBMessageSoap soapModel = new AkismetMBMessageSoap();

        soapModel.setAkismetMBMessageId(model.getAkismetMBMessageId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setMbMessageId(model.getMbMessageId());
        soapModel.setSpam(model.getSpam());
        soapModel.setAuthor(model.getAuthor());
        soapModel.setAuthorEmail(model.getAuthorEmail());
        soapModel.setAuthorUrl(model.getAuthorUrl());
        soapModel.setContent(model.getContent());
        soapModel.setPermalink(model.getPermalink());
        soapModel.setReferrer(model.getReferrer());
        soapModel.setType(model.getType());
        soapModel.setUserAgent(model.getUserAgent());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserIp(model.getUserIp());

        return soapModel;
    }

    public static AkismetMBMessageSoap[] toSoapModels(AkismetMBMessage[] models) {
        AkismetMBMessageSoap[] soapModels = new AkismetMBMessageSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static AkismetMBMessageSoap[][] toSoapModels(
        AkismetMBMessage[][] models) {
        AkismetMBMessageSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new AkismetMBMessageSoap[models.length][models[0].length];
        } else {
            soapModels = new AkismetMBMessageSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static AkismetMBMessageSoap[] toSoapModels(
        List<AkismetMBMessage> models) {
        List<AkismetMBMessageSoap> soapModels = new ArrayList<AkismetMBMessageSoap>(models.size());

        for (AkismetMBMessage model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new AkismetMBMessageSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _akismetMBMessageId;
    }

    public void setPrimaryKey(long pk) {
        setAkismetMBMessageId(pk);
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

    public String getUserIp() {
        return _userIp;
    }

    public void setUserIp(String userIp) {
        _userIp = userIp;
    }
}
