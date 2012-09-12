package fi.javaguru.akismet.mb.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link AkismetMBMessageLocalService}.
 * </p>
 *
 * @author    Mika Koivisto
 * @see       AkismetMBMessageLocalService
 * @generated
 */
public class AkismetMBMessageLocalServiceWrapper
    implements AkismetMBMessageLocalService,
        ServiceWrapper<AkismetMBMessageLocalService> {
    private AkismetMBMessageLocalService _akismetMBMessageLocalService;

    public AkismetMBMessageLocalServiceWrapper(
        AkismetMBMessageLocalService akismetMBMessageLocalService) {
        _akismetMBMessageLocalService = akismetMBMessageLocalService;
    }

    /**
    * Adds the akismet m b message to the database. Also notifies the appropriate model listeners.
    *
    * @param akismetMBMessage the akismet m b message
    * @return the akismet m b message that was added
    * @throws SystemException if a system exception occurred
    */
    public fi.javaguru.akismet.mb.model.AkismetMBMessage addAkismetMBMessage(
        fi.javaguru.akismet.mb.model.AkismetMBMessage akismetMBMessage)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _akismetMBMessageLocalService.addAkismetMBMessage(akismetMBMessage);
    }

    /**
    * Creates a new akismet m b message with the primary key. Does not add the akismet m b message to the database.
    *
    * @param akismetMBMessageId the primary key for the new akismet m b message
    * @return the new akismet m b message
    */
    public fi.javaguru.akismet.mb.model.AkismetMBMessage createAkismetMBMessage(
        long akismetMBMessageId) {
        return _akismetMBMessageLocalService.createAkismetMBMessage(akismetMBMessageId);
    }

    /**
    * Deletes the akismet m b message with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param akismetMBMessageId the primary key of the akismet m b message
    * @return the akismet m b message that was removed
    * @throws PortalException if a akismet m b message with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.javaguru.akismet.mb.model.AkismetMBMessage deleteAkismetMBMessage(
        long akismetMBMessageId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _akismetMBMessageLocalService.deleteAkismetMBMessage(akismetMBMessageId);
    }

    /**
    * Deletes the akismet m b message from the database. Also notifies the appropriate model listeners.
    *
    * @param akismetMBMessage the akismet m b message
    * @return the akismet m b message that was removed
    * @throws SystemException if a system exception occurred
    */
    public fi.javaguru.akismet.mb.model.AkismetMBMessage deleteAkismetMBMessage(
        fi.javaguru.akismet.mb.model.AkismetMBMessage akismetMBMessage)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _akismetMBMessageLocalService.deleteAkismetMBMessage(akismetMBMessage);
    }

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _akismetMBMessageLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _akismetMBMessageLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _akismetMBMessageLocalService.dynamicQuery(dynamicQuery, start,
            end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _akismetMBMessageLocalService.dynamicQuery(dynamicQuery, start,
            end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _akismetMBMessageLocalService.dynamicQueryCount(dynamicQuery);
    }

    public fi.javaguru.akismet.mb.model.AkismetMBMessage fetchAkismetMBMessage(
        long akismetMBMessageId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _akismetMBMessageLocalService.fetchAkismetMBMessage(akismetMBMessageId);
    }

    /**
    * Returns the akismet m b message with the primary key.
    *
    * @param akismetMBMessageId the primary key of the akismet m b message
    * @return the akismet m b message
    * @throws PortalException if a akismet m b message with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.javaguru.akismet.mb.model.AkismetMBMessage getAkismetMBMessage(
        long akismetMBMessageId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _akismetMBMessageLocalService.getAkismetMBMessage(akismetMBMessageId);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _akismetMBMessageLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the akismet m b messages.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of akismet m b messages
    * @param end the upper bound of the range of akismet m b messages (not inclusive)
    * @return the range of akismet m b messages
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<fi.javaguru.akismet.mb.model.AkismetMBMessage> getAkismetMBMessages(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _akismetMBMessageLocalService.getAkismetMBMessages(start, end);
    }

    /**
    * Returns the number of akismet m b messages.
    *
    * @return the number of akismet m b messages
    * @throws SystemException if a system exception occurred
    */
    public int getAkismetMBMessagesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _akismetMBMessageLocalService.getAkismetMBMessagesCount();
    }

    /**
    * Updates the akismet m b message in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param akismetMBMessage the akismet m b message
    * @return the akismet m b message that was updated
    * @throws SystemException if a system exception occurred
    */
    public fi.javaguru.akismet.mb.model.AkismetMBMessage updateAkismetMBMessage(
        fi.javaguru.akismet.mb.model.AkismetMBMessage akismetMBMessage)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _akismetMBMessageLocalService.updateAkismetMBMessage(akismetMBMessage);
    }

    /**
    * Updates the akismet m b message in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param akismetMBMessage the akismet m b message
    * @param merge whether to merge the akismet m b message with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the akismet m b message that was updated
    * @throws SystemException if a system exception occurred
    */
    public fi.javaguru.akismet.mb.model.AkismetMBMessage updateAkismetMBMessage(
        fi.javaguru.akismet.mb.model.AkismetMBMessage akismetMBMessage,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _akismetMBMessageLocalService.updateAkismetMBMessage(akismetMBMessage,
            merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _akismetMBMessageLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _akismetMBMessageLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _akismetMBMessageLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    public fi.javaguru.akismet.mb.model.AkismetMBMessage addAkismetMBMessage(
        long userId, long mbMessageId, boolean spam, java.lang.String author,
        java.lang.String authorEmail, java.lang.String authorUrl,
        java.lang.String content, java.lang.String permalink,
        java.lang.String referrer, java.lang.String type,
        java.lang.String userAgent, java.lang.String userIp,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _akismetMBMessageLocalService.addAkismetMBMessage(userId,
            mbMessageId, spam, author, authorEmail, authorUrl, content,
            permalink, referrer, type, userAgent, userIp, serviceContext);
    }

    public fi.javaguru.akismet.mb.model.AkismetMBMessage updateAkismetMBMessage(
        long akismetMBMessageId, long userId, long mbMessageId, boolean spam,
        java.lang.String author, java.lang.String authorEmail,
        java.lang.String authorUrl, java.lang.String content,
        java.lang.String permalink, java.lang.String referrer,
        java.lang.String type, java.lang.String userAgent,
        java.lang.String userIp,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _akismetMBMessageLocalService.updateAkismetMBMessage(akismetMBMessageId,
            userId, mbMessageId, spam, author, authorEmail, authorUrl, content,
            permalink, referrer, type, userAgent, userIp, serviceContext);
    }

    public int countByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _akismetMBMessageLocalService.countByGroupId(groupId);
    }

    public java.util.List<fi.javaguru.akismet.mb.model.AkismetMBMessage> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _akismetMBMessageLocalService.findByGroupId(groupId);
    }

    public java.util.List<fi.javaguru.akismet.mb.model.AkismetMBMessage> getByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _akismetMBMessageLocalService.getByGroupId(groupId, start, end);
    }

    public java.util.List<fi.javaguru.akismet.mb.model.AkismetMBMessage> getByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _akismetMBMessageLocalService.getByGroupId(groupId, start, end,
            obc);
    }

    public fi.javaguru.akismet.mb.model.AkismetMBMessage getByMessageId(
        long mbMessageId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _akismetMBMessageLocalService.getByMessageId(mbMessageId);
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public AkismetMBMessageLocalService getWrappedAkismetMBMessageLocalService() {
        return _akismetMBMessageLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedAkismetMBMessageLocalService(
        AkismetMBMessageLocalService akismetMBMessageLocalService) {
        _akismetMBMessageLocalService = akismetMBMessageLocalService;
    }

    public AkismetMBMessageLocalService getWrappedService() {
        return _akismetMBMessageLocalService;
    }

    public void setWrappedService(
        AkismetMBMessageLocalService akismetMBMessageLocalService) {
        _akismetMBMessageLocalService = akismetMBMessageLocalService;
    }
}
