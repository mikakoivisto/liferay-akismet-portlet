package fi.javaguru.akismet.mb.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import fi.javaguru.akismet.mb.model.AkismetMBMessage;

import java.util.List;

/**
 * The persistence utility for the akismet m b message service. This utility wraps {@link AkismetMBMessagePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mika Koivisto
 * @see AkismetMBMessagePersistence
 * @see AkismetMBMessagePersistenceImpl
 * @generated
 */
public class AkismetMBMessageUtil {
    private static AkismetMBMessagePersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(AkismetMBMessage akismetMBMessage) {
        getPersistence().clearCache(akismetMBMessage);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<AkismetMBMessage> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<AkismetMBMessage> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<AkismetMBMessage> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static AkismetMBMessage update(AkismetMBMessage akismetMBMessage,
        boolean merge) throws SystemException {
        return getPersistence().update(akismetMBMessage, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static AkismetMBMessage update(AkismetMBMessage akismetMBMessage,
        boolean merge, ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(akismetMBMessage, merge, serviceContext);
    }

    /**
    * Caches the akismet m b message in the entity cache if it is enabled.
    *
    * @param akismetMBMessage the akismet m b message
    */
    public static void cacheResult(
        fi.javaguru.akismet.mb.model.AkismetMBMessage akismetMBMessage) {
        getPersistence().cacheResult(akismetMBMessage);
    }

    /**
    * Caches the akismet m b messages in the entity cache if it is enabled.
    *
    * @param akismetMBMessages the akismet m b messages
    */
    public static void cacheResult(
        java.util.List<fi.javaguru.akismet.mb.model.AkismetMBMessage> akismetMBMessages) {
        getPersistence().cacheResult(akismetMBMessages);
    }

    /**
    * Creates a new akismet m b message with the primary key. Does not add the akismet m b message to the database.
    *
    * @param akismetMBMessageId the primary key for the new akismet m b message
    * @return the new akismet m b message
    */
    public static fi.javaguru.akismet.mb.model.AkismetMBMessage create(
        long akismetMBMessageId) {
        return getPersistence().create(akismetMBMessageId);
    }

    /**
    * Removes the akismet m b message with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param akismetMBMessageId the primary key of the akismet m b message
    * @return the akismet m b message that was removed
    * @throws fi.javaguru.akismet.mb.NoSuchMBMessageException if a akismet m b message with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.javaguru.akismet.mb.model.AkismetMBMessage remove(
        long akismetMBMessageId)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.javaguru.akismet.mb.NoSuchMBMessageException {
        return getPersistence().remove(akismetMBMessageId);
    }

    public static fi.javaguru.akismet.mb.model.AkismetMBMessage updateImpl(
        fi.javaguru.akismet.mb.model.AkismetMBMessage akismetMBMessage,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(akismetMBMessage, merge);
    }

    /**
    * Returns the akismet m b message with the primary key or throws a {@link fi.javaguru.akismet.mb.NoSuchMBMessageException} if it could not be found.
    *
    * @param akismetMBMessageId the primary key of the akismet m b message
    * @return the akismet m b message
    * @throws fi.javaguru.akismet.mb.NoSuchMBMessageException if a akismet m b message with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.javaguru.akismet.mb.model.AkismetMBMessage findByPrimaryKey(
        long akismetMBMessageId)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.javaguru.akismet.mb.NoSuchMBMessageException {
        return getPersistence().findByPrimaryKey(akismetMBMessageId);
    }

    /**
    * Returns the akismet m b message with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param akismetMBMessageId the primary key of the akismet m b message
    * @return the akismet m b message, or <code>null</code> if a akismet m b message with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.javaguru.akismet.mb.model.AkismetMBMessage fetchByPrimaryKey(
        long akismetMBMessageId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(akismetMBMessageId);
    }

    /**
    * Returns all the akismet m b messages where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching akismet m b messages
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fi.javaguru.akismet.mb.model.AkismetMBMessage> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId(groupId);
    }

    /**
    * Returns a range of all the akismet m b messages where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of akismet m b messages
    * @param end the upper bound of the range of akismet m b messages (not inclusive)
    * @return the range of matching akismet m b messages
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fi.javaguru.akismet.mb.model.AkismetMBMessage> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId(groupId, start, end);
    }

    /**
    * Returns an ordered range of all the akismet m b messages where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of akismet m b messages
    * @param end the upper bound of the range of akismet m b messages (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching akismet m b messages
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fi.javaguru.akismet.mb.model.AkismetMBMessage> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupId(groupId, start, end, orderByComparator);
    }

    /**
    * Returns the first akismet m b message in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching akismet m b message
    * @throws fi.javaguru.akismet.mb.NoSuchMBMessageException if a matching akismet m b message could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.javaguru.akismet.mb.model.AkismetMBMessage findByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.javaguru.akismet.mb.NoSuchMBMessageException {
        return getPersistence().findByGroupId_First(groupId, orderByComparator);
    }

    /**
    * Returns the first akismet m b message in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching akismet m b message, or <code>null</code> if a matching akismet m b message could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.javaguru.akismet.mb.model.AkismetMBMessage fetchByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
    }

    /**
    * Returns the last akismet m b message in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching akismet m b message
    * @throws fi.javaguru.akismet.mb.NoSuchMBMessageException if a matching akismet m b message could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.javaguru.akismet.mb.model.AkismetMBMessage findByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.javaguru.akismet.mb.NoSuchMBMessageException {
        return getPersistence().findByGroupId_Last(groupId, orderByComparator);
    }

    /**
    * Returns the last akismet m b message in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching akismet m b message, or <code>null</code> if a matching akismet m b message could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.javaguru.akismet.mb.model.AkismetMBMessage fetchByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
    }

    /**
    * Returns the akismet m b messages before and after the current akismet m b message in the ordered set where groupId = &#63;.
    *
    * @param akismetMBMessageId the primary key of the current akismet m b message
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next akismet m b message
    * @throws fi.javaguru.akismet.mb.NoSuchMBMessageException if a akismet m b message with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.javaguru.akismet.mb.model.AkismetMBMessage[] findByGroupId_PrevAndNext(
        long akismetMBMessageId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.javaguru.akismet.mb.NoSuchMBMessageException {
        return getPersistence()
                   .findByGroupId_PrevAndNext(akismetMBMessageId, groupId,
            orderByComparator);
    }

    /**
    * Returns the akismet m b message where mbMessageId = &#63; or throws a {@link fi.javaguru.akismet.mb.NoSuchMBMessageException} if it could not be found.
    *
    * @param mbMessageId the mb message ID
    * @return the matching akismet m b message
    * @throws fi.javaguru.akismet.mb.NoSuchMBMessageException if a matching akismet m b message could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.javaguru.akismet.mb.model.AkismetMBMessage findByMessageId(
        long mbMessageId)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.javaguru.akismet.mb.NoSuchMBMessageException {
        return getPersistence().findByMessageId(mbMessageId);
    }

    /**
    * Returns the akismet m b message where mbMessageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param mbMessageId the mb message ID
    * @return the matching akismet m b message, or <code>null</code> if a matching akismet m b message could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.javaguru.akismet.mb.model.AkismetMBMessage fetchByMessageId(
        long mbMessageId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByMessageId(mbMessageId);
    }

    /**
    * Returns the akismet m b message where mbMessageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param mbMessageId the mb message ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching akismet m b message, or <code>null</code> if a matching akismet m b message could not be found
    * @throws SystemException if a system exception occurred
    */
    public static fi.javaguru.akismet.mb.model.AkismetMBMessage fetchByMessageId(
        long mbMessageId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByMessageId(mbMessageId, retrieveFromCache);
    }

    /**
    * Returns all the akismet m b messages.
    *
    * @return the akismet m b messages
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fi.javaguru.akismet.mb.model.AkismetMBMessage> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<fi.javaguru.akismet.mb.model.AkismetMBMessage> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the akismet m b messages.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of akismet m b messages
    * @param end the upper bound of the range of akismet m b messages (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of akismet m b messages
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<fi.javaguru.akismet.mb.model.AkismetMBMessage> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the akismet m b messages where groupId = &#63; from the database.
    *
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByGroupId(groupId);
    }

    /**
    * Removes the akismet m b message where mbMessageId = &#63; from the database.
    *
    * @param mbMessageId the mb message ID
    * @return the akismet m b message that was removed
    * @throws SystemException if a system exception occurred
    */
    public static fi.javaguru.akismet.mb.model.AkismetMBMessage removeByMessageId(
        long mbMessageId)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.javaguru.akismet.mb.NoSuchMBMessageException {
        return getPersistence().removeByMessageId(mbMessageId);
    }

    /**
    * Removes all the akismet m b messages from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of akismet m b messages where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching akismet m b messages
    * @throws SystemException if a system exception occurred
    */
    public static int countByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByGroupId(groupId);
    }

    /**
    * Returns the number of akismet m b messages where mbMessageId = &#63;.
    *
    * @param mbMessageId the mb message ID
    * @return the number of matching akismet m b messages
    * @throws SystemException if a system exception occurred
    */
    public static int countByMessageId(long mbMessageId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByMessageId(mbMessageId);
    }

    /**
    * Returns the number of akismet m b messages.
    *
    * @return the number of akismet m b messages
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static AkismetMBMessagePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (AkismetMBMessagePersistence) PortletBeanLocatorUtil.locate(fi.javaguru.akismet.mb.service.ClpSerializer.getServletContextName(),
                    AkismetMBMessagePersistence.class.getName());

            ReferenceRegistry.registerReference(AkismetMBMessageUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(AkismetMBMessagePersistence persistence) {
    }
}
