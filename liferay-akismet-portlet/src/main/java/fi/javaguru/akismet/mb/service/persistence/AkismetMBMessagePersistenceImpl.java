package fi.javaguru.akismet.mb.service.persistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import fi.javaguru.akismet.mb.NoSuchMBMessageException;
import fi.javaguru.akismet.mb.model.AkismetMBMessage;
import fi.javaguru.akismet.mb.model.impl.AkismetMBMessageImpl;
import fi.javaguru.akismet.mb.model.impl.AkismetMBMessageModelImpl;
import fi.javaguru.akismet.mb.service.persistence.AkismetMBMessagePersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the akismet m b message service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mika Koivisto
 * @see AkismetMBMessagePersistence
 * @see AkismetMBMessageUtil
 * @generated
 */
public class AkismetMBMessagePersistenceImpl extends BasePersistenceImpl<AkismetMBMessage>
    implements AkismetMBMessagePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link AkismetMBMessageUtil} to access the akismet m b message persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = AkismetMBMessageImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(AkismetMBMessageModelImpl.ENTITY_CACHE_ENABLED,
            AkismetMBMessageModelImpl.FINDER_CACHE_ENABLED,
            AkismetMBMessageImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByGroupId",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
        new FinderPath(AkismetMBMessageModelImpl.ENTITY_CACHE_ENABLED,
            AkismetMBMessageModelImpl.FINDER_CACHE_ENABLED,
            AkismetMBMessageImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
            new String[] { Long.class.getName() },
            AkismetMBMessageModelImpl.GROUPID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(AkismetMBMessageModelImpl.ENTITY_CACHE_ENABLED,
            AkismetMBMessageModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FETCH_BY_MESSAGEID = new FinderPath(AkismetMBMessageModelImpl.ENTITY_CACHE_ENABLED,
            AkismetMBMessageModelImpl.FINDER_CACHE_ENABLED,
            AkismetMBMessageImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchByMessageId", new String[] { Long.class.getName() },
            AkismetMBMessageModelImpl.MBMESSAGEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_MESSAGEID = new FinderPath(AkismetMBMessageModelImpl.ENTITY_CACHE_ENABLED,
            AkismetMBMessageModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMessageId",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AkismetMBMessageModelImpl.ENTITY_CACHE_ENABLED,
            AkismetMBMessageModelImpl.FINDER_CACHE_ENABLED,
            AkismetMBMessageImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AkismetMBMessageModelImpl.ENTITY_CACHE_ENABLED,
            AkismetMBMessageModelImpl.FINDER_CACHE_ENABLED,
            AkismetMBMessageImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AkismetMBMessageModelImpl.ENTITY_CACHE_ENABLED,
            AkismetMBMessageModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_AKISMETMBMESSAGE = "SELECT akismetMBMessage FROM AkismetMBMessage akismetMBMessage";
    private static final String _SQL_SELECT_AKISMETMBMESSAGE_WHERE = "SELECT akismetMBMessage FROM AkismetMBMessage akismetMBMessage WHERE ";
    private static final String _SQL_COUNT_AKISMETMBMESSAGE = "SELECT COUNT(akismetMBMessage) FROM AkismetMBMessage akismetMBMessage";
    private static final String _SQL_COUNT_AKISMETMBMESSAGE_WHERE = "SELECT COUNT(akismetMBMessage) FROM AkismetMBMessage akismetMBMessage WHERE ";
    private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "akismetMBMessage.groupId = ?";
    private static final String _FINDER_COLUMN_MESSAGEID_MBMESSAGEID_2 = "akismetMBMessage.mbMessageId = ?";
    private static final String _ORDER_BY_ENTITY_ALIAS = "akismetMBMessage.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AkismetMBMessage exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AkismetMBMessage exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(AkismetMBMessagePersistenceImpl.class);
    private static AkismetMBMessage _nullAkismetMBMessage = new AkismetMBMessageImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<AkismetMBMessage> toCacheModel() {
                return _nullAkismetMBMessageCacheModel;
            }
        };

    private static CacheModel<AkismetMBMessage> _nullAkismetMBMessageCacheModel = new CacheModel<AkismetMBMessage>() {
            public AkismetMBMessage toEntityModel() {
                return _nullAkismetMBMessage;
            }
        };

    @BeanReference(type = AkismetMBMessagePersistence.class)
    protected AkismetMBMessagePersistence akismetMBMessagePersistence;
    @BeanReference(type = ResourcePersistence.class)
    protected ResourcePersistence resourcePersistence;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;

    /**
     * Caches the akismet m b message in the entity cache if it is enabled.
     *
     * @param akismetMBMessage the akismet m b message
     */
    public void cacheResult(AkismetMBMessage akismetMBMessage) {
        EntityCacheUtil.putResult(AkismetMBMessageModelImpl.ENTITY_CACHE_ENABLED,
            AkismetMBMessageImpl.class, akismetMBMessage.getPrimaryKey(),
            akismetMBMessage);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MESSAGEID,
            new Object[] { Long.valueOf(akismetMBMessage.getMbMessageId()) },
            akismetMBMessage);

        akismetMBMessage.resetOriginalValues();
    }

    /**
     * Caches the akismet m b messages in the entity cache if it is enabled.
     *
     * @param akismetMBMessages the akismet m b messages
     */
    public void cacheResult(List<AkismetMBMessage> akismetMBMessages) {
        for (AkismetMBMessage akismetMBMessage : akismetMBMessages) {
            if (EntityCacheUtil.getResult(
                        AkismetMBMessageModelImpl.ENTITY_CACHE_ENABLED,
                        AkismetMBMessageImpl.class,
                        akismetMBMessage.getPrimaryKey()) == null) {
                cacheResult(akismetMBMessage);
            } else {
                akismetMBMessage.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all akismet m b messages.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(AkismetMBMessageImpl.class.getName());
        }

        EntityCacheUtil.clearCache(AkismetMBMessageImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the akismet m b message.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(AkismetMBMessage akismetMBMessage) {
        EntityCacheUtil.removeResult(AkismetMBMessageModelImpl.ENTITY_CACHE_ENABLED,
            AkismetMBMessageImpl.class, akismetMBMessage.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(akismetMBMessage);
    }

    @Override
    public void clearCache(List<AkismetMBMessage> akismetMBMessages) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (AkismetMBMessage akismetMBMessage : akismetMBMessages) {
            EntityCacheUtil.removeResult(AkismetMBMessageModelImpl.ENTITY_CACHE_ENABLED,
                AkismetMBMessageImpl.class, akismetMBMessage.getPrimaryKey());

            clearUniqueFindersCache(akismetMBMessage);
        }
    }

    protected void clearUniqueFindersCache(AkismetMBMessage akismetMBMessage) {
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MESSAGEID,
            new Object[] { Long.valueOf(akismetMBMessage.getMbMessageId()) });
    }

    /**
     * Creates a new akismet m b message with the primary key. Does not add the akismet m b message to the database.
     *
     * @param akismetMBMessageId the primary key for the new akismet m b message
     * @return the new akismet m b message
     */
    public AkismetMBMessage create(long akismetMBMessageId) {
        AkismetMBMessage akismetMBMessage = new AkismetMBMessageImpl();

        akismetMBMessage.setNew(true);
        akismetMBMessage.setPrimaryKey(akismetMBMessageId);

        return akismetMBMessage;
    }

    /**
     * Removes the akismet m b message with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param akismetMBMessageId the primary key of the akismet m b message
     * @return the akismet m b message that was removed
     * @throws fi.javaguru.akismet.mb.NoSuchMBMessageException if a akismet m b message with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public AkismetMBMessage remove(long akismetMBMessageId)
        throws NoSuchMBMessageException, SystemException {
        return remove(Long.valueOf(akismetMBMessageId));
    }

    /**
     * Removes the akismet m b message with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the akismet m b message
     * @return the akismet m b message that was removed
     * @throws fi.javaguru.akismet.mb.NoSuchMBMessageException if a akismet m b message with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AkismetMBMessage remove(Serializable primaryKey)
        throws NoSuchMBMessageException, SystemException {
        Session session = null;

        try {
            session = openSession();

            AkismetMBMessage akismetMBMessage = (AkismetMBMessage) session.get(AkismetMBMessageImpl.class,
                    primaryKey);

            if (akismetMBMessage == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchMBMessageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(akismetMBMessage);
        } catch (NoSuchMBMessageException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected AkismetMBMessage removeImpl(AkismetMBMessage akismetMBMessage)
        throws SystemException {
        akismetMBMessage = toUnwrappedModel(akismetMBMessage);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, akismetMBMessage);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(akismetMBMessage);

        return akismetMBMessage;
    }

    @Override
    public AkismetMBMessage updateImpl(
        fi.javaguru.akismet.mb.model.AkismetMBMessage akismetMBMessage,
        boolean merge) throws SystemException {
        akismetMBMessage = toUnwrappedModel(akismetMBMessage);

        boolean isNew = akismetMBMessage.isNew();

        AkismetMBMessageModelImpl akismetMBMessageModelImpl = (AkismetMBMessageModelImpl) akismetMBMessage;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, akismetMBMessage, merge);

            akismetMBMessage.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !AkismetMBMessageModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((akismetMBMessageModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(akismetMBMessageModelImpl.getOriginalGroupId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
                    args);

                args = new Object[] {
                        Long.valueOf(akismetMBMessageModelImpl.getGroupId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
                    args);
            }
        }

        EntityCacheUtil.putResult(AkismetMBMessageModelImpl.ENTITY_CACHE_ENABLED,
            AkismetMBMessageImpl.class, akismetMBMessage.getPrimaryKey(),
            akismetMBMessage);

        if (isNew) {
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MESSAGEID,
                new Object[] { Long.valueOf(akismetMBMessage.getMbMessageId()) },
                akismetMBMessage);
        } else {
            if ((akismetMBMessageModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_MESSAGEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(akismetMBMessageModelImpl.getOriginalMbMessageId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MESSAGEID,
                    args);

                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MESSAGEID,
                    args);

                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MESSAGEID,
                    new Object[] { Long.valueOf(
                            akismetMBMessage.getMbMessageId()) },
                    akismetMBMessage);
            }
        }

        return akismetMBMessage;
    }

    protected AkismetMBMessage toUnwrappedModel(
        AkismetMBMessage akismetMBMessage) {
        if (akismetMBMessage instanceof AkismetMBMessageImpl) {
            return akismetMBMessage;
        }

        AkismetMBMessageImpl akismetMBMessageImpl = new AkismetMBMessageImpl();

        akismetMBMessageImpl.setNew(akismetMBMessage.isNew());
        akismetMBMessageImpl.setPrimaryKey(akismetMBMessage.getPrimaryKey());

        akismetMBMessageImpl.setAkismetMBMessageId(akismetMBMessage.getAkismetMBMessageId());
        akismetMBMessageImpl.setCompanyId(akismetMBMessage.getCompanyId());
        akismetMBMessageImpl.setGroupId(akismetMBMessage.getGroupId());
        akismetMBMessageImpl.setCreateDate(akismetMBMessage.getCreateDate());
        akismetMBMessageImpl.setModifiedDate(akismetMBMessage.getModifiedDate());
        akismetMBMessageImpl.setMbMessageId(akismetMBMessage.getMbMessageId());
        akismetMBMessageImpl.setSpam(akismetMBMessage.isSpam());
        akismetMBMessageImpl.setAuthor(akismetMBMessage.getAuthor());
        akismetMBMessageImpl.setAuthorEmail(akismetMBMessage.getAuthorEmail());
        akismetMBMessageImpl.setAuthorUrl(akismetMBMessage.getAuthorUrl());
        akismetMBMessageImpl.setContent(akismetMBMessage.getContent());
        akismetMBMessageImpl.setPermalink(akismetMBMessage.getPermalink());
        akismetMBMessageImpl.setReferrer(akismetMBMessage.getReferrer());
        akismetMBMessageImpl.setType(akismetMBMessage.getType());
        akismetMBMessageImpl.setUserAgent(akismetMBMessage.getUserAgent());
        akismetMBMessageImpl.setUserId(akismetMBMessage.getUserId());
        akismetMBMessageImpl.setUserIp(akismetMBMessage.getUserIp());

        return akismetMBMessageImpl;
    }

    /**
     * Returns the akismet m b message with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the akismet m b message
     * @return the akismet m b message
     * @throws com.liferay.portal.NoSuchModelException if a akismet m b message with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AkismetMBMessage findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the akismet m b message with the primary key or throws a {@link fi.javaguru.akismet.mb.NoSuchMBMessageException} if it could not be found.
     *
     * @param akismetMBMessageId the primary key of the akismet m b message
     * @return the akismet m b message
     * @throws fi.javaguru.akismet.mb.NoSuchMBMessageException if a akismet m b message with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public AkismetMBMessage findByPrimaryKey(long akismetMBMessageId)
        throws NoSuchMBMessageException, SystemException {
        AkismetMBMessage akismetMBMessage = fetchByPrimaryKey(akismetMBMessageId);

        if (akismetMBMessage == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    akismetMBMessageId);
            }

            throw new NoSuchMBMessageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                akismetMBMessageId);
        }

        return akismetMBMessage;
    }

    /**
     * Returns the akismet m b message with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the akismet m b message
     * @return the akismet m b message, or <code>null</code> if a akismet m b message with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AkismetMBMessage fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the akismet m b message with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param akismetMBMessageId the primary key of the akismet m b message
     * @return the akismet m b message, or <code>null</code> if a akismet m b message with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public AkismetMBMessage fetchByPrimaryKey(long akismetMBMessageId)
        throws SystemException {
        AkismetMBMessage akismetMBMessage = (AkismetMBMessage) EntityCacheUtil.getResult(AkismetMBMessageModelImpl.ENTITY_CACHE_ENABLED,
                AkismetMBMessageImpl.class, akismetMBMessageId);

        if (akismetMBMessage == _nullAkismetMBMessage) {
            return null;
        }

        if (akismetMBMessage == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                akismetMBMessage = (AkismetMBMessage) session.get(AkismetMBMessageImpl.class,
                        Long.valueOf(akismetMBMessageId));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (akismetMBMessage != null) {
                    cacheResult(akismetMBMessage);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(AkismetMBMessageModelImpl.ENTITY_CACHE_ENABLED,
                        AkismetMBMessageImpl.class, akismetMBMessageId,
                        _nullAkismetMBMessage);
                }

                closeSession(session);
            }
        }

        return akismetMBMessage;
    }

    /**
     * Returns all the akismet m b messages where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the matching akismet m b messages
     * @throws SystemException if a system exception occurred
     */
    public List<AkismetMBMessage> findByGroupId(long groupId)
        throws SystemException {
        return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    public List<AkismetMBMessage> findByGroupId(long groupId, int start, int end)
        throws SystemException {
        return findByGroupId(groupId, start, end, null);
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
    public List<AkismetMBMessage> findByGroupId(long groupId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
            finderArgs = new Object[] { groupId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
            finderArgs = new Object[] { groupId, start, end, orderByComparator };
        }

        List<AkismetMBMessage> list = (List<AkismetMBMessage>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (AkismetMBMessage akismetMBMessage : list) {
                if ((groupId != akismetMBMessage.getGroupId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(2);
            }

            query.append(_SQL_SELECT_AKISMETMBMESSAGE_WHERE);

            query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                list = (List<AkismetMBMessage>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    FinderCacheUtil.removeResult(finderPath, finderArgs);
                } else {
                    cacheResult(list);

                    FinderCacheUtil.putResult(finderPath, finderArgs, list);
                }

                closeSession(session);
            }
        }

        return list;
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
    public AkismetMBMessage findByGroupId_First(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchMBMessageException, SystemException {
        AkismetMBMessage akismetMBMessage = fetchByGroupId_First(groupId,
                orderByComparator);

        if (akismetMBMessage != null) {
            return akismetMBMessage;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchMBMessageException(msg.toString());
    }

    /**
     * Returns the first akismet m b message in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching akismet m b message, or <code>null</code> if a matching akismet m b message could not be found
     * @throws SystemException if a system exception occurred
     */
    public AkismetMBMessage fetchByGroupId_First(long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        List<AkismetMBMessage> list = findByGroupId(groupId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    public AkismetMBMessage findByGroupId_Last(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchMBMessageException, SystemException {
        AkismetMBMessage akismetMBMessage = fetchByGroupId_Last(groupId,
                orderByComparator);

        if (akismetMBMessage != null) {
            return akismetMBMessage;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchMBMessageException(msg.toString());
    }

    /**
     * Returns the last akismet m b message in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching akismet m b message, or <code>null</code> if a matching akismet m b message could not be found
     * @throws SystemException if a system exception occurred
     */
    public AkismetMBMessage fetchByGroupId_Last(long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByGroupId(groupId);

        List<AkismetMBMessage> list = findByGroupId(groupId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    public AkismetMBMessage[] findByGroupId_PrevAndNext(
        long akismetMBMessageId, long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchMBMessageException, SystemException {
        AkismetMBMessage akismetMBMessage = findByPrimaryKey(akismetMBMessageId);

        Session session = null;

        try {
            session = openSession();

            AkismetMBMessage[] array = new AkismetMBMessageImpl[3];

            array[0] = getByGroupId_PrevAndNext(session, akismetMBMessage,
                    groupId, orderByComparator, true);

            array[1] = akismetMBMessage;

            array[2] = getByGroupId_PrevAndNext(session, akismetMBMessage,
                    groupId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected AkismetMBMessage getByGroupId_PrevAndNext(Session session,
        AkismetMBMessage akismetMBMessage, long groupId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_AKISMETMBMESSAGE_WHERE);

        query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(akismetMBMessage);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<AkismetMBMessage> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns the akismet m b message where mbMessageId = &#63; or throws a {@link fi.javaguru.akismet.mb.NoSuchMBMessageException} if it could not be found.
     *
     * @param mbMessageId the mb message ID
     * @return the matching akismet m b message
     * @throws fi.javaguru.akismet.mb.NoSuchMBMessageException if a matching akismet m b message could not be found
     * @throws SystemException if a system exception occurred
     */
    public AkismetMBMessage findByMessageId(long mbMessageId)
        throws NoSuchMBMessageException, SystemException {
        AkismetMBMessage akismetMBMessage = fetchByMessageId(mbMessageId);

        if (akismetMBMessage == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("mbMessageId=");
            msg.append(mbMessageId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchMBMessageException(msg.toString());
        }

        return akismetMBMessage;
    }

    /**
     * Returns the akismet m b message where mbMessageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param mbMessageId the mb message ID
     * @return the matching akismet m b message, or <code>null</code> if a matching akismet m b message could not be found
     * @throws SystemException if a system exception occurred
     */
    public AkismetMBMessage fetchByMessageId(long mbMessageId)
        throws SystemException {
        return fetchByMessageId(mbMessageId, true);
    }

    /**
     * Returns the akismet m b message where mbMessageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param mbMessageId the mb message ID
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching akismet m b message, or <code>null</code> if a matching akismet m b message could not be found
     * @throws SystemException if a system exception occurred
     */
    public AkismetMBMessage fetchByMessageId(long mbMessageId,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { mbMessageId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_MESSAGEID,
                    finderArgs, this);
        }

        if (result instanceof AkismetMBMessage) {
            AkismetMBMessage akismetMBMessage = (AkismetMBMessage) result;

            if ((mbMessageId != akismetMBMessage.getMbMessageId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_SELECT_AKISMETMBMESSAGE_WHERE);

            query.append(_FINDER_COLUMN_MESSAGEID_MBMESSAGEID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(mbMessageId);

                List<AkismetMBMessage> list = q.list();

                result = list;

                AkismetMBMessage akismetMBMessage = null;

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MESSAGEID,
                        finderArgs, list);
                } else {
                    akismetMBMessage = list.get(0);

                    cacheResult(akismetMBMessage);

                    if ((akismetMBMessage.getMbMessageId() != mbMessageId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MESSAGEID,
                            finderArgs, akismetMBMessage);
                    }
                }

                return akismetMBMessage;
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (result == null) {
                    FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MESSAGEID,
                        finderArgs);
                }

                closeSession(session);
            }
        } else {
            if (result instanceof List<?>) {
                return null;
            } else {
                return (AkismetMBMessage) result;
            }
        }
    }

    /**
     * Returns all the akismet m b messages.
     *
     * @return the akismet m b messages
     * @throws SystemException if a system exception occurred
     */
    public List<AkismetMBMessage> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    public List<AkismetMBMessage> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
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
    public List<AkismetMBMessage> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = new Object[] { start, end, orderByComparator };

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<AkismetMBMessage> list = (List<AkismetMBMessage>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_AKISMETMBMESSAGE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_AKISMETMBMESSAGE;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<AkismetMBMessage>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<AkismetMBMessage>) QueryUtil.list(q,
                            getDialect(), start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    FinderCacheUtil.removeResult(finderPath, finderArgs);
                } else {
                    cacheResult(list);

                    FinderCacheUtil.putResult(finderPath, finderArgs, list);
                }

                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the akismet m b messages where groupId = &#63; from the database.
     *
     * @param groupId the group ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByGroupId(long groupId) throws SystemException {
        for (AkismetMBMessage akismetMBMessage : findByGroupId(groupId)) {
            remove(akismetMBMessage);
        }
    }

    /**
     * Removes the akismet m b message where mbMessageId = &#63; from the database.
     *
     * @param mbMessageId the mb message ID
     * @return the akismet m b message that was removed
     * @throws SystemException if a system exception occurred
     */
    public AkismetMBMessage removeByMessageId(long mbMessageId)
        throws NoSuchMBMessageException, SystemException {
        AkismetMBMessage akismetMBMessage = findByMessageId(mbMessageId);

        return remove(akismetMBMessage);
    }

    /**
     * Removes all the akismet m b messages from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (AkismetMBMessage akismetMBMessage : findAll()) {
            remove(akismetMBMessage);
        }
    }

    /**
     * Returns the number of akismet m b messages where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the number of matching akismet m b messages
     * @throws SystemException if a system exception occurred
     */
    public int countByGroupId(long groupId) throws SystemException {
        Object[] finderArgs = new Object[] { groupId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_AKISMETMBMESSAGE_WHERE);

            query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of akismet m b messages where mbMessageId = &#63;.
     *
     * @param mbMessageId the mb message ID
     * @return the number of matching akismet m b messages
     * @throws SystemException if a system exception occurred
     */
    public int countByMessageId(long mbMessageId) throws SystemException {
        Object[] finderArgs = new Object[] { mbMessageId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MESSAGEID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_AKISMETMBMESSAGE_WHERE);

            query.append(_FINDER_COLUMN_MESSAGEID_MBMESSAGEID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(mbMessageId);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MESSAGEID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of akismet m b messages.
     *
     * @return the number of akismet m b messages
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_AKISMETMBMESSAGE);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Initializes the akismet m b message persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.fi.javaguru.akismet.mb.model.AkismetMBMessage")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<AkismetMBMessage>> listenersList = new ArrayList<ModelListener<AkismetMBMessage>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<AkismetMBMessage>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(AkismetMBMessageImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
