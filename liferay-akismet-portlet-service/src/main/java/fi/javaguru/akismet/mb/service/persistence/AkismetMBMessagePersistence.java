package fi.javaguru.akismet.mb.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import fi.javaguru.akismet.mb.model.AkismetMBMessage;

/**
 * The persistence interface for the akismet m b message service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mika Koivisto
 * @see AkismetMBMessagePersistenceImpl
 * @see AkismetMBMessageUtil
 * @generated
 */
public interface AkismetMBMessagePersistence extends BasePersistence<AkismetMBMessage> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link AkismetMBMessageUtil} to access the akismet m b message persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the akismet m b message in the entity cache if it is enabled.
    *
    * @param akismetMBMessage the akismet m b message
    */
    public void cacheResult(
        fi.javaguru.akismet.mb.model.AkismetMBMessage akismetMBMessage);

    /**
    * Caches the akismet m b messages in the entity cache if it is enabled.
    *
    * @param akismetMBMessages the akismet m b messages
    */
    public void cacheResult(
        java.util.List<fi.javaguru.akismet.mb.model.AkismetMBMessage> akismetMBMessages);

    /**
    * Creates a new akismet m b message with the primary key. Does not add the akismet m b message to the database.
    *
    * @param akismetMBMessageId the primary key for the new akismet m b message
    * @return the new akismet m b message
    */
    public fi.javaguru.akismet.mb.model.AkismetMBMessage create(
        long akismetMBMessageId);

    /**
    * Removes the akismet m b message with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param akismetMBMessageId the primary key of the akismet m b message
    * @return the akismet m b message that was removed
    * @throws fi.javaguru.akismet.mb.NoSuchMBMessageException if a akismet m b message with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.javaguru.akismet.mb.model.AkismetMBMessage remove(
        long akismetMBMessageId)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.javaguru.akismet.mb.NoSuchMBMessageException;

    public fi.javaguru.akismet.mb.model.AkismetMBMessage updateImpl(
        fi.javaguru.akismet.mb.model.AkismetMBMessage akismetMBMessage,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the akismet m b message with the primary key or throws a {@link fi.javaguru.akismet.mb.NoSuchMBMessageException} if it could not be found.
    *
    * @param akismetMBMessageId the primary key of the akismet m b message
    * @return the akismet m b message
    * @throws fi.javaguru.akismet.mb.NoSuchMBMessageException if a akismet m b message with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.javaguru.akismet.mb.model.AkismetMBMessage findByPrimaryKey(
        long akismetMBMessageId)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.javaguru.akismet.mb.NoSuchMBMessageException;

    /**
    * Returns the akismet m b message with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param akismetMBMessageId the primary key of the akismet m b message
    * @return the akismet m b message, or <code>null</code> if a akismet m b message with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.javaguru.akismet.mb.model.AkismetMBMessage fetchByPrimaryKey(
        long akismetMBMessageId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the akismet m b messages where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching akismet m b messages
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<fi.javaguru.akismet.mb.model.AkismetMBMessage> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<fi.javaguru.akismet.mb.model.AkismetMBMessage> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<fi.javaguru.akismet.mb.model.AkismetMBMessage> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first akismet m b message in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching akismet m b message
    * @throws fi.javaguru.akismet.mb.NoSuchMBMessageException if a matching akismet m b message could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.javaguru.akismet.mb.model.AkismetMBMessage findByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.javaguru.akismet.mb.NoSuchMBMessageException;

    /**
    * Returns the first akismet m b message in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching akismet m b message, or <code>null</code> if a matching akismet m b message could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.javaguru.akismet.mb.model.AkismetMBMessage fetchByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last akismet m b message in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching akismet m b message
    * @throws fi.javaguru.akismet.mb.NoSuchMBMessageException if a matching akismet m b message could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.javaguru.akismet.mb.model.AkismetMBMessage findByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.javaguru.akismet.mb.NoSuchMBMessageException;

    /**
    * Returns the last akismet m b message in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching akismet m b message, or <code>null</code> if a matching akismet m b message could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.javaguru.akismet.mb.model.AkismetMBMessage fetchByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public fi.javaguru.akismet.mb.model.AkismetMBMessage[] findByGroupId_PrevAndNext(
        long akismetMBMessageId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.javaguru.akismet.mb.NoSuchMBMessageException;

    /**
    * Returns the akismet m b message where mbMessageId = &#63; or throws a {@link fi.javaguru.akismet.mb.NoSuchMBMessageException} if it could not be found.
    *
    * @param mbMessageId the mb message ID
    * @return the matching akismet m b message
    * @throws fi.javaguru.akismet.mb.NoSuchMBMessageException if a matching akismet m b message could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.javaguru.akismet.mb.model.AkismetMBMessage findByMessageId(
        long mbMessageId)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.javaguru.akismet.mb.NoSuchMBMessageException;

    /**
    * Returns the akismet m b message where mbMessageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param mbMessageId the mb message ID
    * @return the matching akismet m b message, or <code>null</code> if a matching akismet m b message could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.javaguru.akismet.mb.model.AkismetMBMessage fetchByMessageId(
        long mbMessageId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the akismet m b message where mbMessageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param mbMessageId the mb message ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching akismet m b message, or <code>null</code> if a matching akismet m b message could not be found
    * @throws SystemException if a system exception occurred
    */
    public fi.javaguru.akismet.mb.model.AkismetMBMessage fetchByMessageId(
        long mbMessageId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the akismet m b messages.
    *
    * @return the akismet m b messages
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<fi.javaguru.akismet.mb.model.AkismetMBMessage> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<fi.javaguru.akismet.mb.model.AkismetMBMessage> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<fi.javaguru.akismet.mb.model.AkismetMBMessage> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the akismet m b messages where groupId = &#63; from the database.
    *
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the akismet m b message where mbMessageId = &#63; from the database.
    *
    * @param mbMessageId the mb message ID
    * @return the akismet m b message that was removed
    * @throws SystemException if a system exception occurred
    */
    public fi.javaguru.akismet.mb.model.AkismetMBMessage removeByMessageId(
        long mbMessageId)
        throws com.liferay.portal.kernel.exception.SystemException,
            fi.javaguru.akismet.mb.NoSuchMBMessageException;

    /**
    * Removes all the akismet m b messages from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of akismet m b messages where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching akismet m b messages
    * @throws SystemException if a system exception occurred
    */
    public int countByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of akismet m b messages where mbMessageId = &#63;.
    *
    * @param mbMessageId the mb message ID
    * @return the number of matching akismet m b messages
    * @throws SystemException if a system exception occurred
    */
    public int countByMessageId(long mbMessageId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of akismet m b messages.
    *
    * @return the number of akismet m b messages
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
