package fi.javaguru.akismet.mb.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the akismet m b message local service. This utility wraps {@link fi.javaguru.akismet.mb.service.impl.AkismetMBMessageLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mika Koivisto
 * @see AkismetMBMessageLocalService
 * @see fi.javaguru.akismet.mb.service.base.AkismetMBMessageLocalServiceBaseImpl
 * @see fi.javaguru.akismet.mb.service.impl.AkismetMBMessageLocalServiceImpl
 * @generated
 */
public class AkismetMBMessageLocalServiceUtil {
    private static AkismetMBMessageLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link fi.javaguru.akismet.mb.service.impl.AkismetMBMessageLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the akismet m b message to the database. Also notifies the appropriate model listeners.
    *
    * @param akismetMBMessage the akismet m b message
    * @return the akismet m b message that was added
    * @throws SystemException if a system exception occurred
    */
    public static fi.javaguru.akismet.mb.model.AkismetMBMessage addAkismetMBMessage(
        fi.javaguru.akismet.mb.model.AkismetMBMessage akismetMBMessage)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addAkismetMBMessage(akismetMBMessage);
    }

    /**
    * Creates a new akismet m b message with the primary key. Does not add the akismet m b message to the database.
    *
    * @param akismetMBMessageId the primary key for the new akismet m b message
    * @return the new akismet m b message
    */
    public static fi.javaguru.akismet.mb.model.AkismetMBMessage createAkismetMBMessage(
        long akismetMBMessageId) {
        return getService().createAkismetMBMessage(akismetMBMessageId);
    }

    /**
    * Deletes the akismet m b message with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param akismetMBMessageId the primary key of the akismet m b message
    * @return the akismet m b message that was removed
    * @throws PortalException if a akismet m b message with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.javaguru.akismet.mb.model.AkismetMBMessage deleteAkismetMBMessage(
        long akismetMBMessageId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteAkismetMBMessage(akismetMBMessageId);
    }

    /**
    * Deletes the akismet m b message from the database. Also notifies the appropriate model listeners.
    *
    * @param akismetMBMessage the akismet m b message
    * @return the akismet m b message that was removed
    * @throws SystemException if a system exception occurred
    */
    public static fi.javaguru.akismet.mb.model.AkismetMBMessage deleteAkismetMBMessage(
        fi.javaguru.akismet.mb.model.AkismetMBMessage akismetMBMessage)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteAkismetMBMessage(akismetMBMessage);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
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
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
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
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    public static fi.javaguru.akismet.mb.model.AkismetMBMessage fetchAkismetMBMessage(
        long akismetMBMessageId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchAkismetMBMessage(akismetMBMessageId);
    }

    /**
    * Returns the akismet m b message with the primary key.
    *
    * @param akismetMBMessageId the primary key of the akismet m b message
    * @return the akismet m b message
    * @throws PortalException if a akismet m b message with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.javaguru.akismet.mb.model.AkismetMBMessage getAkismetMBMessage(
        long akismetMBMessageId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getAkismetMBMessage(akismetMBMessageId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<fi.javaguru.akismet.mb.model.AkismetMBMessage> getAkismetMBMessages(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAkismetMBMessages(start, end);
    }

    /**
    * Returns the number of akismet m b messages.
    *
    * @return the number of akismet m b messages
    * @throws SystemException if a system exception occurred
    */
    public static int getAkismetMBMessagesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAkismetMBMessagesCount();
    }

    /**
    * Updates the akismet m b message in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param akismetMBMessage the akismet m b message
    * @return the akismet m b message that was updated
    * @throws SystemException if a system exception occurred
    */
    public static fi.javaguru.akismet.mb.model.AkismetMBMessage updateAkismetMBMessage(
        fi.javaguru.akismet.mb.model.AkismetMBMessage akismetMBMessage)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateAkismetMBMessage(akismetMBMessage);
    }

    /**
    * Updates the akismet m b message in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param akismetMBMessage the akismet m b message
    * @param merge whether to merge the akismet m b message with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the akismet m b message that was updated
    * @throws SystemException if a system exception occurred
    */
    public static fi.javaguru.akismet.mb.model.AkismetMBMessage updateAkismetMBMessage(
        fi.javaguru.akismet.mb.model.AkismetMBMessage akismetMBMessage,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateAkismetMBMessage(akismetMBMessage, merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static fi.javaguru.akismet.mb.model.AkismetMBMessage addAkismetMBMessage(
        long userId, long mbMessageId, boolean spam, java.lang.String author,
        java.lang.String authorEmail, java.lang.String authorUrl,
        java.lang.String content, java.lang.String permalink,
        java.lang.String referrer, java.lang.String type,
        java.lang.String userAgent, java.lang.String userIp,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .addAkismetMBMessage(userId, mbMessageId, spam, author,
            authorEmail, authorUrl, content, permalink, referrer, type,
            userAgent, userIp, serviceContext);
    }

    public static fi.javaguru.akismet.mb.model.AkismetMBMessage updateAkismetMBMessage(
        long akismetMBMessageId, long userId, long mbMessageId, boolean spam,
        java.lang.String author, java.lang.String authorEmail,
        java.lang.String authorUrl, java.lang.String content,
        java.lang.String permalink, java.lang.String referrer,
        java.lang.String type, java.lang.String userAgent,
        java.lang.String userIp,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .updateAkismetMBMessage(akismetMBMessageId, userId,
            mbMessageId, spam, author, authorEmail, authorUrl, content,
            permalink, referrer, type, userAgent, userIp, serviceContext);
    }

    public static int countByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().countByGroupId(groupId);
    }

    public static java.util.List<fi.javaguru.akismet.mb.model.AkismetMBMessage> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByGroupId(groupId);
    }

    public static java.util.List<fi.javaguru.akismet.mb.model.AkismetMBMessage> getByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getByGroupId(groupId, start, end);
    }

    public static java.util.List<fi.javaguru.akismet.mb.model.AkismetMBMessage> getByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getByGroupId(groupId, start, end, obc);
    }

    public static fi.javaguru.akismet.mb.model.AkismetMBMessage getByMessageId(
        long mbMessageId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getByMessageId(mbMessageId);
    }

    public static void clearService() {
        _service = null;
    }

    public static AkismetMBMessageLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    AkismetMBMessageLocalService.class.getName());

            if (invokableLocalService instanceof AkismetMBMessageLocalService) {
                _service = (AkismetMBMessageLocalService) invokableLocalService;
            } else {
                _service = new AkismetMBMessageLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(AkismetMBMessageLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated
     */
    public void setService(AkismetMBMessageLocalService service) {
    }
}
