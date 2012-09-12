package fi.javaguru.akismet.mb.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * The interface for the akismet m b message local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mika Koivisto
 * @see AkismetMBMessageLocalServiceUtil
 * @see fi.javaguru.akismet.mb.service.base.AkismetMBMessageLocalServiceBaseImpl
 * @see fi.javaguru.akismet.mb.service.impl.AkismetMBMessageLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface AkismetMBMessageLocalService extends BaseLocalService,
    InvokableLocalService, PersistedModelLocalService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link AkismetMBMessageLocalServiceUtil} to access the akismet m b message local service. Add custom service methods to {@link fi.javaguru.akismet.mb.service.impl.AkismetMBMessageLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Adds the akismet m b message to the database. Also notifies the appropriate model listeners.
    *
    * @param akismetMBMessage the akismet m b message
    * @return the akismet m b message that was added
    * @throws SystemException if a system exception occurred
    */
    public fi.javaguru.akismet.mb.model.AkismetMBMessage addAkismetMBMessage(
        fi.javaguru.akismet.mb.model.AkismetMBMessage akismetMBMessage)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Creates a new akismet m b message with the primary key. Does not add the akismet m b message to the database.
    *
    * @param akismetMBMessageId the primary key for the new akismet m b message
    * @return the new akismet m b message
    */
    public fi.javaguru.akismet.mb.model.AkismetMBMessage createAkismetMBMessage(
        long akismetMBMessageId);

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
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Deletes the akismet m b message from the database. Also notifies the appropriate model listeners.
    *
    * @param akismetMBMessage the akismet m b message
    * @return the akismet m b message that was removed
    * @throws SystemException if a system exception occurred
    */
    public fi.javaguru.akismet.mb.model.AkismetMBMessage deleteAkismetMBMessage(
        fi.javaguru.akismet.mb.model.AkismetMBMessage akismetMBMessage)
        throws com.liferay.portal.kernel.exception.SystemException;

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

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
        throws com.liferay.portal.kernel.exception.SystemException;

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
        int end) throws com.liferay.portal.kernel.exception.SystemException;

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
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public fi.javaguru.akismet.mb.model.AkismetMBMessage fetchAkismetMBMessage(
        long akismetMBMessageId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the akismet m b message with the primary key.
    *
    * @param akismetMBMessageId the primary key of the akismet m b message
    * @return the akismet m b message
    * @throws PortalException if a akismet m b message with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public fi.javaguru.akismet.mb.model.AkismetMBMessage getAkismetMBMessage(
        long akismetMBMessageId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<fi.javaguru.akismet.mb.model.AkismetMBMessage> getAkismetMBMessages(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of akismet m b messages.
    *
    * @return the number of akismet m b messages
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getAkismetMBMessagesCount()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Updates the akismet m b message in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param akismetMBMessage the akismet m b message
    * @return the akismet m b message that was updated
    * @throws SystemException if a system exception occurred
    */
    public fi.javaguru.akismet.mb.model.AkismetMBMessage updateAkismetMBMessage(
        fi.javaguru.akismet.mb.model.AkismetMBMessage akismetMBMessage)
        throws com.liferay.portal.kernel.exception.SystemException;

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
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier();

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier);

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable;

    public fi.javaguru.akismet.mb.model.AkismetMBMessage addAkismetMBMessage(
        long userId, long mbMessageId, boolean spam, java.lang.String author,
        java.lang.String authorEmail, java.lang.String authorUrl,
        java.lang.String content, java.lang.String permalink,
        java.lang.String referrer, java.lang.String type,
        java.lang.String userAgent, java.lang.String userIp,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.SystemException;

    public fi.javaguru.akismet.mb.model.AkismetMBMessage updateAkismetMBMessage(
        long akismetMBMessageId, long userId, long mbMessageId, boolean spam,
        java.lang.String author, java.lang.String authorEmail,
        java.lang.String authorUrl, java.lang.String content,
        java.lang.String permalink, java.lang.String referrer,
        java.lang.String type, java.lang.String userAgent,
        java.lang.String userIp,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.SystemException;

    public int countByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    public java.util.List<fi.javaguru.akismet.mb.model.AkismetMBMessage> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<fi.javaguru.akismet.mb.model.AkismetMBMessage> getByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<fi.javaguru.akismet.mb.model.AkismetMBMessage> getByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public fi.javaguru.akismet.mb.model.AkismetMBMessage getByMessageId(
        long mbMessageId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;
}
