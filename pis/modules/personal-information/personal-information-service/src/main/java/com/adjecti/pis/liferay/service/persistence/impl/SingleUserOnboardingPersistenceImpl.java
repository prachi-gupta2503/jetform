/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.adjecti.pis.liferay.service.persistence.impl;

import com.adjecti.pis.liferay.exception.NoSuchSingleUserOnboardingException;
import com.adjecti.pis.liferay.model.SingleUserOnboarding;
import com.adjecti.pis.liferay.model.impl.SingleUserOnboardingImpl;
import com.adjecti.pis.liferay.model.impl.SingleUserOnboardingModelImpl;
import com.adjecti.pis.liferay.service.persistence.SingleUserOnboardingPersistence;
import com.adjecti.pis.liferay.service.persistence.impl.constants.pisPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the single user onboarding service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = SingleUserOnboardingPersistence.class)
public class SingleUserOnboardingPersistenceImpl
	extends BasePersistenceImpl<SingleUserOnboarding>
	implements SingleUserOnboardingPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SingleUserOnboardingUtil</code> to access the single user onboarding persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SingleUserOnboardingImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the single user onboardings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the single user onboardings where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @return the range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<SingleUserOnboarding> list = null;

		if (useFinderCache) {
			list = (List<SingleUserOnboarding>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SingleUserOnboarding singleUserOnboarding : list) {
					if (!uuid.equals(singleUserOnboarding.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_SINGLEUSERONBOARDING_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SingleUserOnboardingModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<SingleUserOnboarding>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first single user onboarding in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding findByUuid_First(
			String uuid,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		SingleUserOnboarding singleUserOnboarding = fetchByUuid_First(
			uuid, orderByComparator);

		if (singleUserOnboarding != null) {
			return singleUserOnboarding;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSingleUserOnboardingException(sb.toString());
	}

	/**
	 * Returns the first single user onboarding in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding fetchByUuid_First(
		String uuid,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		List<SingleUserOnboarding> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last single user onboarding in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding findByUuid_Last(
			String uuid,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		SingleUserOnboarding singleUserOnboarding = fetchByUuid_Last(
			uuid, orderByComparator);

		if (singleUserOnboarding != null) {
			return singleUserOnboarding;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSingleUserOnboardingException(sb.toString());
	}

	/**
	 * Returns the last single user onboarding in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding fetchByUuid_Last(
		String uuid,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<SingleUserOnboarding> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the single user onboardings before and after the current single user onboarding in the ordered set where uuid = &#63;.
	 *
	 * @param singleUserRegistrationId the primary key of the current single user onboarding
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a single user onboarding with the primary key could not be found
	 */
	@Override
	public SingleUserOnboarding[] findByUuid_PrevAndNext(
			long singleUserRegistrationId, String uuid,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		uuid = Objects.toString(uuid, "");

		SingleUserOnboarding singleUserOnboarding = findByPrimaryKey(
			singleUserRegistrationId);

		Session session = null;

		try {
			session = openSession();

			SingleUserOnboarding[] array = new SingleUserOnboardingImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, singleUserOnboarding, uuid, orderByComparator, true);

			array[1] = singleUserOnboarding;

			array[2] = getByUuid_PrevAndNext(
				session, singleUserOnboarding, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SingleUserOnboarding getByUuid_PrevAndNext(
		Session session, SingleUserOnboarding singleUserOnboarding, String uuid,
		OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SINGLEUSERONBOARDING_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SingleUserOnboardingModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						singleUserOnboarding)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SingleUserOnboarding> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the single user onboardings where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (SingleUserOnboarding singleUserOnboarding :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(singleUserOnboarding);
		}
	}

	/**
	 * Returns the number of single user onboardings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching single user onboardings
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SINGLEUSERONBOARDING_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"singleUserOnboarding.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(singleUserOnboarding.uuid IS NULL OR singleUserOnboarding.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the single user onboarding where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSingleUserOnboardingException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding findByUUID_G(String uuid, long groupId)
		throws NoSuchSingleUserOnboardingException {

		SingleUserOnboarding singleUserOnboarding = fetchByUUID_G(
			uuid, groupId);

		if (singleUserOnboarding == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchSingleUserOnboardingException(sb.toString());
		}

		return singleUserOnboarding;
	}

	/**
	 * Returns the single user onboarding where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the single user onboarding where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof SingleUserOnboarding) {
			SingleUserOnboarding singleUserOnboarding =
				(SingleUserOnboarding)result;

			if (!Objects.equals(uuid, singleUserOnboarding.getUuid()) ||
				(groupId != singleUserOnboarding.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_SINGLEUSERONBOARDING_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<SingleUserOnboarding> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					SingleUserOnboarding singleUserOnboarding = list.get(0);

					result = singleUserOnboarding;

					cacheResult(singleUserOnboarding);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (SingleUserOnboarding)result;
		}
	}

	/**
	 * Removes the single user onboarding where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the single user onboarding that was removed
	 */
	@Override
	public SingleUserOnboarding removeByUUID_G(String uuid, long groupId)
		throws NoSuchSingleUserOnboardingException {

		SingleUserOnboarding singleUserOnboarding = findByUUID_G(uuid, groupId);

		return remove(singleUserOnboarding);
	}

	/**
	 * Returns the number of single user onboardings where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching single user onboardings
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SINGLEUSERONBOARDING_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"singleUserOnboarding.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(singleUserOnboarding.uuid IS NULL OR singleUserOnboarding.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"singleUserOnboarding.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the single user onboardings where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the single user onboardings where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @return the range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<SingleUserOnboarding> list = null;

		if (useFinderCache) {
			list = (List<SingleUserOnboarding>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SingleUserOnboarding singleUserOnboarding : list) {
					if (!uuid.equals(singleUserOnboarding.getUuid()) ||
						(companyId != singleUserOnboarding.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_SINGLEUSERONBOARDING_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SingleUserOnboardingModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<SingleUserOnboarding>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first single user onboarding in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		SingleUserOnboarding singleUserOnboarding = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (singleUserOnboarding != null) {
			return singleUserOnboarding;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchSingleUserOnboardingException(sb.toString());
	}

	/**
	 * Returns the first single user onboarding in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		List<SingleUserOnboarding> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last single user onboarding in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		SingleUserOnboarding singleUserOnboarding = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (singleUserOnboarding != null) {
			return singleUserOnboarding;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchSingleUserOnboardingException(sb.toString());
	}

	/**
	 * Returns the last single user onboarding in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<SingleUserOnboarding> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the single user onboardings before and after the current single user onboarding in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param singleUserRegistrationId the primary key of the current single user onboarding
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a single user onboarding with the primary key could not be found
	 */
	@Override
	public SingleUserOnboarding[] findByUuid_C_PrevAndNext(
			long singleUserRegistrationId, String uuid, long companyId,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		uuid = Objects.toString(uuid, "");

		SingleUserOnboarding singleUserOnboarding = findByPrimaryKey(
			singleUserRegistrationId);

		Session session = null;

		try {
			session = openSession();

			SingleUserOnboarding[] array = new SingleUserOnboardingImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, singleUserOnboarding, uuid, companyId,
				orderByComparator, true);

			array[1] = singleUserOnboarding;

			array[2] = getByUuid_C_PrevAndNext(
				session, singleUserOnboarding, uuid, companyId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SingleUserOnboarding getByUuid_C_PrevAndNext(
		Session session, SingleUserOnboarding singleUserOnboarding, String uuid,
		long companyId,
		OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_SINGLEUSERONBOARDING_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SingleUserOnboardingModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						singleUserOnboarding)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SingleUserOnboarding> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the single user onboardings where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (SingleUserOnboarding singleUserOnboarding :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(singleUserOnboarding);
		}
	}

	/**
	 * Returns the number of single user onboardings where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching single user onboardings
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SINGLEUSERONBOARDING_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"singleUserOnboarding.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(singleUserOnboarding.uuid IS NULL OR singleUserOnboarding.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"singleUserOnboarding.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByStatus;
	private FinderPath _finderPathWithoutPaginationFindByStatus;
	private FinderPath _finderPathCountByStatus;

	/**
	 * Returns all the single user onboardings where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByStatus(int status) {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the single user onboardings where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @return the range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByStatus(
		int status, int start, int end) {

		return findByStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByStatus(
		int status, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return findByStatus(status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByStatus(
		int status, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByStatus;
				finderArgs = new Object[] {status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByStatus;
			finderArgs = new Object[] {status, start, end, orderByComparator};
		}

		List<SingleUserOnboarding> list = null;

		if (useFinderCache) {
			list = (List<SingleUserOnboarding>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SingleUserOnboarding singleUserOnboarding : list) {
					if (status != singleUserOnboarding.getStatus()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_SINGLEUSERONBOARDING_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SingleUserOnboardingModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

				list = (List<SingleUserOnboarding>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first single user onboarding in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding findByStatus_First(
			int status,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		SingleUserOnboarding singleUserOnboarding = fetchByStatus_First(
			status, orderByComparator);

		if (singleUserOnboarding != null) {
			return singleUserOnboarding;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchSingleUserOnboardingException(sb.toString());
	}

	/**
	 * Returns the first single user onboarding in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding fetchByStatus_First(
		int status, OrderByComparator<SingleUserOnboarding> orderByComparator) {

		List<SingleUserOnboarding> list = findByStatus(
			status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last single user onboarding in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding findByStatus_Last(
			int status,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		SingleUserOnboarding singleUserOnboarding = fetchByStatus_Last(
			status, orderByComparator);

		if (singleUserOnboarding != null) {
			return singleUserOnboarding;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchSingleUserOnboardingException(sb.toString());
	}

	/**
	 * Returns the last single user onboarding in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding fetchByStatus_Last(
		int status, OrderByComparator<SingleUserOnboarding> orderByComparator) {

		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<SingleUserOnboarding> list = findByStatus(
			status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the single user onboardings before and after the current single user onboarding in the ordered set where status = &#63;.
	 *
	 * @param singleUserRegistrationId the primary key of the current single user onboarding
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a single user onboarding with the primary key could not be found
	 */
	@Override
	public SingleUserOnboarding[] findByStatus_PrevAndNext(
			long singleUserRegistrationId, int status,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		SingleUserOnboarding singleUserOnboarding = findByPrimaryKey(
			singleUserRegistrationId);

		Session session = null;

		try {
			session = openSession();

			SingleUserOnboarding[] array = new SingleUserOnboardingImpl[3];

			array[0] = getByStatus_PrevAndNext(
				session, singleUserOnboarding, status, orderByComparator, true);

			array[1] = singleUserOnboarding;

			array[2] = getByStatus_PrevAndNext(
				session, singleUserOnboarding, status, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SingleUserOnboarding getByStatus_PrevAndNext(
		Session session, SingleUserOnboarding singleUserOnboarding, int status,
		OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SINGLEUSERONBOARDING_WHERE);

		sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SingleUserOnboardingModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						singleUserOnboarding)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SingleUserOnboarding> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the single user onboardings where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	@Override
	public void removeByStatus(int status) {
		for (SingleUserOnboarding singleUserOnboarding :
				findByStatus(
					status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(singleUserOnboarding);
		}
	}

	/**
	 * Returns the number of single user onboardings where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching single user onboardings
	 */
	@Override
	public int countByStatus(int status) {
		FinderPath finderPath = _finderPathCountByStatus;

		Object[] finderArgs = new Object[] {status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SINGLEUSERONBOARDING_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 =
		"singleUserOnboarding.status = ?";

	private FinderPath _finderPathWithPaginationFindByUnitId;
	private FinderPath _finderPathWithoutPaginationFindByUnitId;
	private FinderPath _finderPathCountByUnitId;

	/**
	 * Returns all the single user onboardings where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @return the matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByUnitId(long unitId) {
		return findByUnitId(unitId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the single user onboardings where unitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @return the range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByUnitId(
		long unitId, int start, int end) {

		return findByUnitId(unitId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where unitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByUnitId(
		long unitId, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return findByUnitId(unitId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where unitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByUnitId(
		long unitId, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUnitId;
				finderArgs = new Object[] {unitId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUnitId;
			finderArgs = new Object[] {unitId, start, end, orderByComparator};
		}

		List<SingleUserOnboarding> list = null;

		if (useFinderCache) {
			list = (List<SingleUserOnboarding>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SingleUserOnboarding singleUserOnboarding : list) {
					if (unitId != singleUserOnboarding.getUnitId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_SINGLEUSERONBOARDING_WHERE);

			sb.append(_FINDER_COLUMN_UNITID_UNITID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SingleUserOnboardingModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(unitId);

				list = (List<SingleUserOnboarding>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first single user onboarding in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding findByUnitId_First(
			long unitId,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		SingleUserOnboarding singleUserOnboarding = fetchByUnitId_First(
			unitId, orderByComparator);

		if (singleUserOnboarding != null) {
			return singleUserOnboarding;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("unitId=");
		sb.append(unitId);

		sb.append("}");

		throw new NoSuchSingleUserOnboardingException(sb.toString());
	}

	/**
	 * Returns the first single user onboarding in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding fetchByUnitId_First(
		long unitId,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		List<SingleUserOnboarding> list = findByUnitId(
			unitId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last single user onboarding in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding findByUnitId_Last(
			long unitId,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		SingleUserOnboarding singleUserOnboarding = fetchByUnitId_Last(
			unitId, orderByComparator);

		if (singleUserOnboarding != null) {
			return singleUserOnboarding;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("unitId=");
		sb.append(unitId);

		sb.append("}");

		throw new NoSuchSingleUserOnboardingException(sb.toString());
	}

	/**
	 * Returns the last single user onboarding in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding fetchByUnitId_Last(
		long unitId,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		int count = countByUnitId(unitId);

		if (count == 0) {
			return null;
		}

		List<SingleUserOnboarding> list = findByUnitId(
			unitId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the single user onboardings before and after the current single user onboarding in the ordered set where unitId = &#63;.
	 *
	 * @param singleUserRegistrationId the primary key of the current single user onboarding
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a single user onboarding with the primary key could not be found
	 */
	@Override
	public SingleUserOnboarding[] findByUnitId_PrevAndNext(
			long singleUserRegistrationId, long unitId,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		SingleUserOnboarding singleUserOnboarding = findByPrimaryKey(
			singleUserRegistrationId);

		Session session = null;

		try {
			session = openSession();

			SingleUserOnboarding[] array = new SingleUserOnboardingImpl[3];

			array[0] = getByUnitId_PrevAndNext(
				session, singleUserOnboarding, unitId, orderByComparator, true);

			array[1] = singleUserOnboarding;

			array[2] = getByUnitId_PrevAndNext(
				session, singleUserOnboarding, unitId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SingleUserOnboarding getByUnitId_PrevAndNext(
		Session session, SingleUserOnboarding singleUserOnboarding, long unitId,
		OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SINGLEUSERONBOARDING_WHERE);

		sb.append(_FINDER_COLUMN_UNITID_UNITID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SingleUserOnboardingModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(unitId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						singleUserOnboarding)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SingleUserOnboarding> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the single user onboardings where unitId = &#63; from the database.
	 *
	 * @param unitId the unit ID
	 */
	@Override
	public void removeByUnitId(long unitId) {
		for (SingleUserOnboarding singleUserOnboarding :
				findByUnitId(
					unitId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(singleUserOnboarding);
		}
	}

	/**
	 * Returns the number of single user onboardings where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @return the number of matching single user onboardings
	 */
	@Override
	public int countByUnitId(long unitId) {
		FinderPath finderPath = _finderPathCountByUnitId;

		Object[] finderArgs = new Object[] {unitId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SINGLEUSERONBOARDING_WHERE);

			sb.append(_FINDER_COLUMN_UNITID_UNITID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(unitId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UNITID_UNITID_2 =
		"singleUserOnboarding.unitId = ?";

	private FinderPath _finderPathWithPaginationFindByUnitIdAndStatus;
	private FinderPath _finderPathWithoutPaginationFindByUnitIdAndStatus;
	private FinderPath _finderPathCountByUnitIdAndStatus;

	/**
	 * Returns all the single user onboardings where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @return the matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByUnitIdAndStatus(
		long unitId, int status) {

		return findByUnitIdAndStatus(
			unitId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the single user onboardings where unitId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @return the range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByUnitIdAndStatus(
		long unitId, int status, int start, int end) {

		return findByUnitIdAndStatus(unitId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where unitId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByUnitIdAndStatus(
		long unitId, int status, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return findByUnitIdAndStatus(
			unitId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where unitId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByUnitIdAndStatus(
		long unitId, int status, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUnitIdAndStatus;
				finderArgs = new Object[] {unitId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUnitIdAndStatus;
			finderArgs = new Object[] {
				unitId, status, start, end, orderByComparator
			};
		}

		List<SingleUserOnboarding> list = null;

		if (useFinderCache) {
			list = (List<SingleUserOnboarding>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SingleUserOnboarding singleUserOnboarding : list) {
					if ((unitId != singleUserOnboarding.getUnitId()) ||
						(status != singleUserOnboarding.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_SINGLEUSERONBOARDING_WHERE);

			sb.append(_FINDER_COLUMN_UNITIDANDSTATUS_UNITID_2);

			sb.append(_FINDER_COLUMN_UNITIDANDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SingleUserOnboardingModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(unitId);

				queryPos.add(status);

				list = (List<SingleUserOnboarding>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first single user onboarding in the ordered set where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding findByUnitIdAndStatus_First(
			long unitId, int status,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		SingleUserOnboarding singleUserOnboarding =
			fetchByUnitIdAndStatus_First(unitId, status, orderByComparator);

		if (singleUserOnboarding != null) {
			return singleUserOnboarding;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("unitId=");
		sb.append(unitId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchSingleUserOnboardingException(sb.toString());
	}

	/**
	 * Returns the first single user onboarding in the ordered set where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding fetchByUnitIdAndStatus_First(
		long unitId, int status,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		List<SingleUserOnboarding> list = findByUnitIdAndStatus(
			unitId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last single user onboarding in the ordered set where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding findByUnitIdAndStatus_Last(
			long unitId, int status,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		SingleUserOnboarding singleUserOnboarding = fetchByUnitIdAndStatus_Last(
			unitId, status, orderByComparator);

		if (singleUserOnboarding != null) {
			return singleUserOnboarding;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("unitId=");
		sb.append(unitId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchSingleUserOnboardingException(sb.toString());
	}

	/**
	 * Returns the last single user onboarding in the ordered set where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding fetchByUnitIdAndStatus_Last(
		long unitId, int status,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		int count = countByUnitIdAndStatus(unitId, status);

		if (count == 0) {
			return null;
		}

		List<SingleUserOnboarding> list = findByUnitIdAndStatus(
			unitId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the single user onboardings before and after the current single user onboarding in the ordered set where unitId = &#63; and status = &#63;.
	 *
	 * @param singleUserRegistrationId the primary key of the current single user onboarding
	 * @param unitId the unit ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a single user onboarding with the primary key could not be found
	 */
	@Override
	public SingleUserOnboarding[] findByUnitIdAndStatus_PrevAndNext(
			long singleUserRegistrationId, long unitId, int status,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		SingleUserOnboarding singleUserOnboarding = findByPrimaryKey(
			singleUserRegistrationId);

		Session session = null;

		try {
			session = openSession();

			SingleUserOnboarding[] array = new SingleUserOnboardingImpl[3];

			array[0] = getByUnitIdAndStatus_PrevAndNext(
				session, singleUserOnboarding, unitId, status,
				orderByComparator, true);

			array[1] = singleUserOnboarding;

			array[2] = getByUnitIdAndStatus_PrevAndNext(
				session, singleUserOnboarding, unitId, status,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SingleUserOnboarding getByUnitIdAndStatus_PrevAndNext(
		Session session, SingleUserOnboarding singleUserOnboarding, long unitId,
		int status, OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_SINGLEUSERONBOARDING_WHERE);

		sb.append(_FINDER_COLUMN_UNITIDANDSTATUS_UNITID_2);

		sb.append(_FINDER_COLUMN_UNITIDANDSTATUS_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SingleUserOnboardingModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(unitId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						singleUserOnboarding)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SingleUserOnboarding> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the single user onboardings where unitId = &#63; and status = &#63; from the database.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 */
	@Override
	public void removeByUnitIdAndStatus(long unitId, int status) {
		for (SingleUserOnboarding singleUserOnboarding :
				findByUnitIdAndStatus(
					unitId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(singleUserOnboarding);
		}
	}

	/**
	 * Returns the number of single user onboardings where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @return the number of matching single user onboardings
	 */
	@Override
	public int countByUnitIdAndStatus(long unitId, int status) {
		FinderPath finderPath = _finderPathCountByUnitIdAndStatus;

		Object[] finderArgs = new Object[] {unitId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SINGLEUSERONBOARDING_WHERE);

			sb.append(_FINDER_COLUMN_UNITIDANDSTATUS_UNITID_2);

			sb.append(_FINDER_COLUMN_UNITIDANDSTATUS_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(unitId);

				queryPos.add(status);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UNITIDANDSTATUS_UNITID_2 =
		"singleUserOnboarding.unitId = ? AND ";

	private static final String _FINDER_COLUMN_UNITIDANDSTATUS_STATUS_2 =
		"singleUserOnboarding.status = ?";

	private FinderPath _finderPathWithPaginationFindByUnitIdsAndStatusList;
	private FinderPath _finderPathWithoutPaginationFindByUnitIdsAndStatusList;
	private FinderPath _finderPathCountByUnitIdsAndStatusList;
	private FinderPath _finderPathWithPaginationCountByUnitIdsAndStatusList;

	/**
	 * Returns all the single user onboardings where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @return the matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByUnitIdsAndStatusList(
		long unitId, int status) {

		return findByUnitIdsAndStatusList(
			unitId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the single user onboardings where unitId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @return the range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByUnitIdsAndStatusList(
		long unitId, int status, int start, int end) {

		return findByUnitIdsAndStatusList(unitId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where unitId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByUnitIdsAndStatusList(
		long unitId, int status, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return findByUnitIdsAndStatusList(
			unitId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where unitId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByUnitIdsAndStatusList(
		long unitId, int status, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByUnitIdsAndStatusList;
				finderArgs = new Object[] {unitId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUnitIdsAndStatusList;
			finderArgs = new Object[] {
				unitId, status, start, end, orderByComparator
			};
		}

		List<SingleUserOnboarding> list = null;

		if (useFinderCache) {
			list = (List<SingleUserOnboarding>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SingleUserOnboarding singleUserOnboarding : list) {
					if ((unitId != singleUserOnboarding.getUnitId()) ||
						(status != singleUserOnboarding.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_SINGLEUSERONBOARDING_WHERE);

			sb.append(_FINDER_COLUMN_UNITIDSANDSTATUSLIST_UNITID_2);

			sb.append(_FINDER_COLUMN_UNITIDSANDSTATUSLIST_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SingleUserOnboardingModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(unitId);

				queryPos.add(status);

				list = (List<SingleUserOnboarding>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first single user onboarding in the ordered set where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding findByUnitIdsAndStatusList_First(
			long unitId, int status,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		SingleUserOnboarding singleUserOnboarding =
			fetchByUnitIdsAndStatusList_First(
				unitId, status, orderByComparator);

		if (singleUserOnboarding != null) {
			return singleUserOnboarding;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("unitId=");
		sb.append(unitId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchSingleUserOnboardingException(sb.toString());
	}

	/**
	 * Returns the first single user onboarding in the ordered set where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding fetchByUnitIdsAndStatusList_First(
		long unitId, int status,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		List<SingleUserOnboarding> list = findByUnitIdsAndStatusList(
			unitId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last single user onboarding in the ordered set where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding findByUnitIdsAndStatusList_Last(
			long unitId, int status,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		SingleUserOnboarding singleUserOnboarding =
			fetchByUnitIdsAndStatusList_Last(unitId, status, orderByComparator);

		if (singleUserOnboarding != null) {
			return singleUserOnboarding;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("unitId=");
		sb.append(unitId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchSingleUserOnboardingException(sb.toString());
	}

	/**
	 * Returns the last single user onboarding in the ordered set where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding fetchByUnitIdsAndStatusList_Last(
		long unitId, int status,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		int count = countByUnitIdsAndStatusList(unitId, status);

		if (count == 0) {
			return null;
		}

		List<SingleUserOnboarding> list = findByUnitIdsAndStatusList(
			unitId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the single user onboardings before and after the current single user onboarding in the ordered set where unitId = &#63; and status = &#63;.
	 *
	 * @param singleUserRegistrationId the primary key of the current single user onboarding
	 * @param unitId the unit ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a single user onboarding with the primary key could not be found
	 */
	@Override
	public SingleUserOnboarding[] findByUnitIdsAndStatusList_PrevAndNext(
			long singleUserRegistrationId, long unitId, int status,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		SingleUserOnboarding singleUserOnboarding = findByPrimaryKey(
			singleUserRegistrationId);

		Session session = null;

		try {
			session = openSession();

			SingleUserOnboarding[] array = new SingleUserOnboardingImpl[3];

			array[0] = getByUnitIdsAndStatusList_PrevAndNext(
				session, singleUserOnboarding, unitId, status,
				orderByComparator, true);

			array[1] = singleUserOnboarding;

			array[2] = getByUnitIdsAndStatusList_PrevAndNext(
				session, singleUserOnboarding, unitId, status,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SingleUserOnboarding getByUnitIdsAndStatusList_PrevAndNext(
		Session session, SingleUserOnboarding singleUserOnboarding, long unitId,
		int status, OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_SINGLEUSERONBOARDING_WHERE);

		sb.append(_FINDER_COLUMN_UNITIDSANDSTATUSLIST_UNITID_2);

		sb.append(_FINDER_COLUMN_UNITIDSANDSTATUSLIST_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SingleUserOnboardingModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(unitId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						singleUserOnboarding)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SingleUserOnboarding> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the single user onboardings where unitId = any &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param unitIds the unit IDs
	 * @param statuses the statuses
	 * @return the matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByUnitIdsAndStatusList(
		long[] unitIds, int[] statuses) {

		return findByUnitIdsAndStatusList(
			unitIds, statuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the single user onboardings where unitId = any &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param unitIds the unit IDs
	 * @param statuses the statuses
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @return the range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByUnitIdsAndStatusList(
		long[] unitIds, int[] statuses, int start, int end) {

		return findByUnitIdsAndStatusList(unitIds, statuses, start, end, null);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where unitId = any &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param unitIds the unit IDs
	 * @param statuses the statuses
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByUnitIdsAndStatusList(
		long[] unitIds, int[] statuses, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return findByUnitIdsAndStatusList(
			unitIds, statuses, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where unitId = &#63; and status = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByUnitIdsAndStatusList(
		long[] unitIds, int[] statuses, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean useFinderCache) {

		if (unitIds == null) {
			unitIds = new long[0];
		}
		else if (unitIds.length > 1) {
			unitIds = ArrayUtil.sortedUnique(unitIds);
		}

		if (statuses == null) {
			statuses = new int[0];
		}
		else if (statuses.length > 1) {
			statuses = ArrayUtil.sortedUnique(statuses);
		}

		if ((unitIds.length == 1) && (statuses.length == 1)) {
			return findByUnitIdsAndStatusList(
				unitIds[0], statuses[0], start, end, orderByComparator);
		}

		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderArgs = new Object[] {
					StringUtil.merge(unitIds), StringUtil.merge(statuses)
				};
			}
		}
		else if (useFinderCache) {
			finderArgs = new Object[] {
				StringUtil.merge(unitIds), StringUtil.merge(statuses), start,
				end, orderByComparator
			};
		}

		List<SingleUserOnboarding> list = null;

		if (useFinderCache) {
			list = (List<SingleUserOnboarding>)finderCache.getResult(
				_finderPathWithPaginationFindByUnitIdsAndStatusList, finderArgs,
				this);

			if ((list != null) && !list.isEmpty()) {
				for (SingleUserOnboarding singleUserOnboarding : list) {
					if (!ArrayUtil.contains(
							unitIds, singleUserOnboarding.getUnitId()) ||
						!ArrayUtil.contains(
							statuses, singleUserOnboarding.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_SELECT_SINGLEUSERONBOARDING_WHERE);

			if (unitIds.length > 0) {
				sb.append("(");

				sb.append(_FINDER_COLUMN_UNITIDSANDSTATUSLIST_UNITID_7);

				sb.append(StringUtil.merge(unitIds));

				sb.append(")");

				sb.append(")");

				sb.append(WHERE_AND);
			}

			if (statuses.length > 0) {
				sb.append("(");

				sb.append(_FINDER_COLUMN_UNITIDSANDSTATUSLIST_STATUS_7);

				sb.append(StringUtil.merge(statuses));

				sb.append(")");

				sb.append(")");
			}

			sb.setStringAt(
				removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SingleUserOnboardingModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SingleUserOnboarding>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(
						_finderPathWithPaginationFindByUnitIdsAndStatusList,
						finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the single user onboardings where unitId = &#63; and status = &#63; from the database.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 */
	@Override
	public void removeByUnitIdsAndStatusList(long unitId, int status) {
		for (SingleUserOnboarding singleUserOnboarding :
				findByUnitIdsAndStatusList(
					unitId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(singleUserOnboarding);
		}
	}

	/**
	 * Returns the number of single user onboardings where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @return the number of matching single user onboardings
	 */
	@Override
	public int countByUnitIdsAndStatusList(long unitId, int status) {
		FinderPath finderPath = _finderPathCountByUnitIdsAndStatusList;

		Object[] finderArgs = new Object[] {unitId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SINGLEUSERONBOARDING_WHERE);

			sb.append(_FINDER_COLUMN_UNITIDSANDSTATUSLIST_UNITID_2);

			sb.append(_FINDER_COLUMN_UNITIDSANDSTATUSLIST_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(unitId);

				queryPos.add(status);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of single user onboardings where unitId = any &#63; and status = any &#63;.
	 *
	 * @param unitIds the unit IDs
	 * @param statuses the statuses
	 * @return the number of matching single user onboardings
	 */
	@Override
	public int countByUnitIdsAndStatusList(long[] unitIds, int[] statuses) {
		if (unitIds == null) {
			unitIds = new long[0];
		}
		else if (unitIds.length > 1) {
			unitIds = ArrayUtil.sortedUnique(unitIds);
		}

		if (statuses == null) {
			statuses = new int[0];
		}
		else if (statuses.length > 1) {
			statuses = ArrayUtil.sortedUnique(statuses);
		}

		Object[] finderArgs = new Object[] {
			StringUtil.merge(unitIds), StringUtil.merge(statuses)
		};

		Long count = (Long)finderCache.getResult(
			_finderPathWithPaginationCountByUnitIdsAndStatusList, finderArgs,
			this);

		if (count == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_COUNT_SINGLEUSERONBOARDING_WHERE);

			if (unitIds.length > 0) {
				sb.append("(");

				sb.append(_FINDER_COLUMN_UNITIDSANDSTATUSLIST_UNITID_7);

				sb.append(StringUtil.merge(unitIds));

				sb.append(")");

				sb.append(")");

				sb.append(WHERE_AND);
			}

			if (statuses.length > 0) {
				sb.append("(");

				sb.append(_FINDER_COLUMN_UNITIDSANDSTATUSLIST_STATUS_7);

				sb.append(StringUtil.merge(statuses));

				sb.append(")");

				sb.append(")");
			}

			sb.setStringAt(
				removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathWithPaginationCountByUnitIdsAndStatusList,
					finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UNITIDSANDSTATUSLIST_UNITID_2 =
		"singleUserOnboarding.unitId = ? AND ";

	private static final String _FINDER_COLUMN_UNITIDSANDSTATUSLIST_UNITID_7 =
		"singleUserOnboarding.unitId IN (";

	private static final String _FINDER_COLUMN_UNITIDSANDSTATUSLIST_STATUS_2 =
		"singleUserOnboarding.status = ?";

	private static final String _FINDER_COLUMN_UNITIDSANDSTATUSLIST_STATUS_7 =
		"singleUserOnboarding.status IN (";

	private FinderPath _finderPathWithPaginationFindByUnitIdAndState;
	private FinderPath _finderPathWithoutPaginationFindByUnitIdAndState;
	private FinderPath _finderPathCountByUnitIdAndState;

	/**
	 * Returns all the single user onboardings where unitId = &#63; and state = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param state the state
	 * @return the matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByUnitIdAndState(
		long unitId, String state) {

		return findByUnitIdAndState(
			unitId, state, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the single user onboardings where unitId = &#63; and state = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param state the state
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @return the range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByUnitIdAndState(
		long unitId, String state, int start, int end) {

		return findByUnitIdAndState(unitId, state, start, end, null);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where unitId = &#63; and state = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param state the state
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByUnitIdAndState(
		long unitId, String state, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return findByUnitIdAndState(
			unitId, state, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where unitId = &#63; and state = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param state the state
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByUnitIdAndState(
		long unitId, String state, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean useFinderCache) {

		state = Objects.toString(state, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUnitIdAndState;
				finderArgs = new Object[] {unitId, state};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUnitIdAndState;
			finderArgs = new Object[] {
				unitId, state, start, end, orderByComparator
			};
		}

		List<SingleUserOnboarding> list = null;

		if (useFinderCache) {
			list = (List<SingleUserOnboarding>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SingleUserOnboarding singleUserOnboarding : list) {
					if ((unitId != singleUserOnboarding.getUnitId()) ||
						!state.equals(singleUserOnboarding.getState())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_SINGLEUSERONBOARDING_WHERE);

			sb.append(_FINDER_COLUMN_UNITIDANDSTATE_UNITID_2);

			boolean bindState = false;

			if (state.isEmpty()) {
				sb.append(_FINDER_COLUMN_UNITIDANDSTATE_STATE_3);
			}
			else {
				bindState = true;

				sb.append(_FINDER_COLUMN_UNITIDANDSTATE_STATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SingleUserOnboardingModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(unitId);

				if (bindState) {
					queryPos.add(state);
				}

				list = (List<SingleUserOnboarding>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first single user onboarding in the ordered set where unitId = &#63; and state = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param state the state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding findByUnitIdAndState_First(
			long unitId, String state,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		SingleUserOnboarding singleUserOnboarding = fetchByUnitIdAndState_First(
			unitId, state, orderByComparator);

		if (singleUserOnboarding != null) {
			return singleUserOnboarding;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("unitId=");
		sb.append(unitId);

		sb.append(", state=");
		sb.append(state);

		sb.append("}");

		throw new NoSuchSingleUserOnboardingException(sb.toString());
	}

	/**
	 * Returns the first single user onboarding in the ordered set where unitId = &#63; and state = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param state the state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding fetchByUnitIdAndState_First(
		long unitId, String state,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		List<SingleUserOnboarding> list = findByUnitIdAndState(
			unitId, state, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last single user onboarding in the ordered set where unitId = &#63; and state = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param state the state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding findByUnitIdAndState_Last(
			long unitId, String state,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		SingleUserOnboarding singleUserOnboarding = fetchByUnitIdAndState_Last(
			unitId, state, orderByComparator);

		if (singleUserOnboarding != null) {
			return singleUserOnboarding;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("unitId=");
		sb.append(unitId);

		sb.append(", state=");
		sb.append(state);

		sb.append("}");

		throw new NoSuchSingleUserOnboardingException(sb.toString());
	}

	/**
	 * Returns the last single user onboarding in the ordered set where unitId = &#63; and state = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param state the state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding fetchByUnitIdAndState_Last(
		long unitId, String state,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		int count = countByUnitIdAndState(unitId, state);

		if (count == 0) {
			return null;
		}

		List<SingleUserOnboarding> list = findByUnitIdAndState(
			unitId, state, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the single user onboardings before and after the current single user onboarding in the ordered set where unitId = &#63; and state = &#63;.
	 *
	 * @param singleUserRegistrationId the primary key of the current single user onboarding
	 * @param unitId the unit ID
	 * @param state the state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a single user onboarding with the primary key could not be found
	 */
	@Override
	public SingleUserOnboarding[] findByUnitIdAndState_PrevAndNext(
			long singleUserRegistrationId, long unitId, String state,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		state = Objects.toString(state, "");

		SingleUserOnboarding singleUserOnboarding = findByPrimaryKey(
			singleUserRegistrationId);

		Session session = null;

		try {
			session = openSession();

			SingleUserOnboarding[] array = new SingleUserOnboardingImpl[3];

			array[0] = getByUnitIdAndState_PrevAndNext(
				session, singleUserOnboarding, unitId, state, orderByComparator,
				true);

			array[1] = singleUserOnboarding;

			array[2] = getByUnitIdAndState_PrevAndNext(
				session, singleUserOnboarding, unitId, state, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SingleUserOnboarding getByUnitIdAndState_PrevAndNext(
		Session session, SingleUserOnboarding singleUserOnboarding, long unitId,
		String state, OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_SINGLEUSERONBOARDING_WHERE);

		sb.append(_FINDER_COLUMN_UNITIDANDSTATE_UNITID_2);

		boolean bindState = false;

		if (state.isEmpty()) {
			sb.append(_FINDER_COLUMN_UNITIDANDSTATE_STATE_3);
		}
		else {
			bindState = true;

			sb.append(_FINDER_COLUMN_UNITIDANDSTATE_STATE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SingleUserOnboardingModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(unitId);

		if (bindState) {
			queryPos.add(state);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						singleUserOnboarding)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SingleUserOnboarding> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the single user onboardings where unitId = &#63; and state = &#63; from the database.
	 *
	 * @param unitId the unit ID
	 * @param state the state
	 */
	@Override
	public void removeByUnitIdAndState(long unitId, String state) {
		for (SingleUserOnboarding singleUserOnboarding :
				findByUnitIdAndState(
					unitId, state, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(singleUserOnboarding);
		}
	}

	/**
	 * Returns the number of single user onboardings where unitId = &#63; and state = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param state the state
	 * @return the number of matching single user onboardings
	 */
	@Override
	public int countByUnitIdAndState(long unitId, String state) {
		state = Objects.toString(state, "");

		FinderPath finderPath = _finderPathCountByUnitIdAndState;

		Object[] finderArgs = new Object[] {unitId, state};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SINGLEUSERONBOARDING_WHERE);

			sb.append(_FINDER_COLUMN_UNITIDANDSTATE_UNITID_2);

			boolean bindState = false;

			if (state.isEmpty()) {
				sb.append(_FINDER_COLUMN_UNITIDANDSTATE_STATE_3);
			}
			else {
				bindState = true;

				sb.append(_FINDER_COLUMN_UNITIDANDSTATE_STATE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(unitId);

				if (bindState) {
					queryPos.add(state);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UNITIDANDSTATE_UNITID_2 =
		"singleUserOnboarding.unitId = ? AND ";

	private static final String _FINDER_COLUMN_UNITIDANDSTATE_STATE_2 =
		"singleUserOnboarding.state = ?";

	private static final String _FINDER_COLUMN_UNITIDANDSTATE_STATE_3 =
		"(singleUserOnboarding.state IS NULL OR singleUserOnboarding.state = '')";

	private FinderPath _finderPathWithPaginationFindByUnit;
	private FinderPath _finderPathWithoutPaginationFindByUnit;
	private FinderPath _finderPathCountByUnit;

	/**
	 * Returns all the single user onboardings where unit = &#63;.
	 *
	 * @param unit the unit
	 * @return the matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByUnit(String unit) {
		return findByUnit(unit, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the single user onboardings where unit = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param unit the unit
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @return the range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByUnit(
		String unit, int start, int end) {

		return findByUnit(unit, start, end, null);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where unit = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param unit the unit
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByUnit(
		String unit, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return findByUnit(unit, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where unit = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param unit the unit
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByUnit(
		String unit, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean useFinderCache) {

		unit = Objects.toString(unit, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUnit;
				finderArgs = new Object[] {unit};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUnit;
			finderArgs = new Object[] {unit, start, end, orderByComparator};
		}

		List<SingleUserOnboarding> list = null;

		if (useFinderCache) {
			list = (List<SingleUserOnboarding>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SingleUserOnboarding singleUserOnboarding : list) {
					if (!unit.equals(singleUserOnboarding.getUnit())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_SINGLEUSERONBOARDING_WHERE);

			boolean bindUnit = false;

			if (unit.isEmpty()) {
				sb.append(_FINDER_COLUMN_UNIT_UNIT_3);
			}
			else {
				bindUnit = true;

				sb.append(_FINDER_COLUMN_UNIT_UNIT_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SingleUserOnboardingModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUnit) {
					queryPos.add(unit);
				}

				list = (List<SingleUserOnboarding>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first single user onboarding in the ordered set where unit = &#63;.
	 *
	 * @param unit the unit
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding findByUnit_First(
			String unit,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		SingleUserOnboarding singleUserOnboarding = fetchByUnit_First(
			unit, orderByComparator);

		if (singleUserOnboarding != null) {
			return singleUserOnboarding;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("unit=");
		sb.append(unit);

		sb.append("}");

		throw new NoSuchSingleUserOnboardingException(sb.toString());
	}

	/**
	 * Returns the first single user onboarding in the ordered set where unit = &#63;.
	 *
	 * @param unit the unit
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding fetchByUnit_First(
		String unit,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		List<SingleUserOnboarding> list = findByUnit(
			unit, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last single user onboarding in the ordered set where unit = &#63;.
	 *
	 * @param unit the unit
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding findByUnit_Last(
			String unit,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		SingleUserOnboarding singleUserOnboarding = fetchByUnit_Last(
			unit, orderByComparator);

		if (singleUserOnboarding != null) {
			return singleUserOnboarding;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("unit=");
		sb.append(unit);

		sb.append("}");

		throw new NoSuchSingleUserOnboardingException(sb.toString());
	}

	/**
	 * Returns the last single user onboarding in the ordered set where unit = &#63;.
	 *
	 * @param unit the unit
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding fetchByUnit_Last(
		String unit,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		int count = countByUnit(unit);

		if (count == 0) {
			return null;
		}

		List<SingleUserOnboarding> list = findByUnit(
			unit, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the single user onboardings before and after the current single user onboarding in the ordered set where unit = &#63;.
	 *
	 * @param singleUserRegistrationId the primary key of the current single user onboarding
	 * @param unit the unit
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a single user onboarding with the primary key could not be found
	 */
	@Override
	public SingleUserOnboarding[] findByUnit_PrevAndNext(
			long singleUserRegistrationId, String unit,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		unit = Objects.toString(unit, "");

		SingleUserOnboarding singleUserOnboarding = findByPrimaryKey(
			singleUserRegistrationId);

		Session session = null;

		try {
			session = openSession();

			SingleUserOnboarding[] array = new SingleUserOnboardingImpl[3];

			array[0] = getByUnit_PrevAndNext(
				session, singleUserOnboarding, unit, orderByComparator, true);

			array[1] = singleUserOnboarding;

			array[2] = getByUnit_PrevAndNext(
				session, singleUserOnboarding, unit, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SingleUserOnboarding getByUnit_PrevAndNext(
		Session session, SingleUserOnboarding singleUserOnboarding, String unit,
		OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SINGLEUSERONBOARDING_WHERE);

		boolean bindUnit = false;

		if (unit.isEmpty()) {
			sb.append(_FINDER_COLUMN_UNIT_UNIT_3);
		}
		else {
			bindUnit = true;

			sb.append(_FINDER_COLUMN_UNIT_UNIT_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SingleUserOnboardingModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUnit) {
			queryPos.add(unit);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						singleUserOnboarding)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SingleUserOnboarding> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the single user onboardings where unit = &#63; from the database.
	 *
	 * @param unit the unit
	 */
	@Override
	public void removeByUnit(String unit) {
		for (SingleUserOnboarding singleUserOnboarding :
				findByUnit(unit, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(singleUserOnboarding);
		}
	}

	/**
	 * Returns the number of single user onboardings where unit = &#63;.
	 *
	 * @param unit the unit
	 * @return the number of matching single user onboardings
	 */
	@Override
	public int countByUnit(String unit) {
		unit = Objects.toString(unit, "");

		FinderPath finderPath = _finderPathCountByUnit;

		Object[] finderArgs = new Object[] {unit};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SINGLEUSERONBOARDING_WHERE);

			boolean bindUnit = false;

			if (unit.isEmpty()) {
				sb.append(_FINDER_COLUMN_UNIT_UNIT_3);
			}
			else {
				bindUnit = true;

				sb.append(_FINDER_COLUMN_UNIT_UNIT_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUnit) {
					queryPos.add(unit);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UNIT_UNIT_2 =
		"singleUserOnboarding.unit = ?";

	private static final String _FINDER_COLUMN_UNIT_UNIT_3 =
		"(singleUserOnboarding.unit IS NULL OR singleUserOnboarding.unit = '')";

	private FinderPath _finderPathWithPaginationFindByUnitAndStatus;
	private FinderPath _finderPathWithoutPaginationFindByUnitAndStatus;
	private FinderPath _finderPathCountByUnitAndStatus;

	/**
	 * Returns all the single user onboardings where unit = &#63; and status = &#63;.
	 *
	 * @param unit the unit
	 * @param status the status
	 * @return the matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByUnitAndStatus(
		String unit, int status) {

		return findByUnitAndStatus(
			unit, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the single user onboardings where unit = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param unit the unit
	 * @param status the status
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @return the range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByUnitAndStatus(
		String unit, int status, int start, int end) {

		return findByUnitAndStatus(unit, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where unit = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param unit the unit
	 * @param status the status
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByUnitAndStatus(
		String unit, int status, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return findByUnitAndStatus(
			unit, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where unit = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param unit the unit
	 * @param status the status
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByUnitAndStatus(
		String unit, int status, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean useFinderCache) {

		unit = Objects.toString(unit, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUnitAndStatus;
				finderArgs = new Object[] {unit, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUnitAndStatus;
			finderArgs = new Object[] {
				unit, status, start, end, orderByComparator
			};
		}

		List<SingleUserOnboarding> list = null;

		if (useFinderCache) {
			list = (List<SingleUserOnboarding>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SingleUserOnboarding singleUserOnboarding : list) {
					if (!unit.equals(singleUserOnboarding.getUnit()) ||
						(status != singleUserOnboarding.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_SINGLEUSERONBOARDING_WHERE);

			boolean bindUnit = false;

			if (unit.isEmpty()) {
				sb.append(_FINDER_COLUMN_UNITANDSTATUS_UNIT_3);
			}
			else {
				bindUnit = true;

				sb.append(_FINDER_COLUMN_UNITANDSTATUS_UNIT_2);
			}

			sb.append(_FINDER_COLUMN_UNITANDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SingleUserOnboardingModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUnit) {
					queryPos.add(unit);
				}

				queryPos.add(status);

				list = (List<SingleUserOnboarding>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first single user onboarding in the ordered set where unit = &#63; and status = &#63;.
	 *
	 * @param unit the unit
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding findByUnitAndStatus_First(
			String unit, int status,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		SingleUserOnboarding singleUserOnboarding = fetchByUnitAndStatus_First(
			unit, status, orderByComparator);

		if (singleUserOnboarding != null) {
			return singleUserOnboarding;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("unit=");
		sb.append(unit);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchSingleUserOnboardingException(sb.toString());
	}

	/**
	 * Returns the first single user onboarding in the ordered set where unit = &#63; and status = &#63;.
	 *
	 * @param unit the unit
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding fetchByUnitAndStatus_First(
		String unit, int status,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		List<SingleUserOnboarding> list = findByUnitAndStatus(
			unit, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last single user onboarding in the ordered set where unit = &#63; and status = &#63;.
	 *
	 * @param unit the unit
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding findByUnitAndStatus_Last(
			String unit, int status,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		SingleUserOnboarding singleUserOnboarding = fetchByUnitAndStatus_Last(
			unit, status, orderByComparator);

		if (singleUserOnboarding != null) {
			return singleUserOnboarding;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("unit=");
		sb.append(unit);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchSingleUserOnboardingException(sb.toString());
	}

	/**
	 * Returns the last single user onboarding in the ordered set where unit = &#63; and status = &#63;.
	 *
	 * @param unit the unit
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding fetchByUnitAndStatus_Last(
		String unit, int status,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		int count = countByUnitAndStatus(unit, status);

		if (count == 0) {
			return null;
		}

		List<SingleUserOnboarding> list = findByUnitAndStatus(
			unit, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the single user onboardings before and after the current single user onboarding in the ordered set where unit = &#63; and status = &#63;.
	 *
	 * @param singleUserRegistrationId the primary key of the current single user onboarding
	 * @param unit the unit
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a single user onboarding with the primary key could not be found
	 */
	@Override
	public SingleUserOnboarding[] findByUnitAndStatus_PrevAndNext(
			long singleUserRegistrationId, String unit, int status,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		unit = Objects.toString(unit, "");

		SingleUserOnboarding singleUserOnboarding = findByPrimaryKey(
			singleUserRegistrationId);

		Session session = null;

		try {
			session = openSession();

			SingleUserOnboarding[] array = new SingleUserOnboardingImpl[3];

			array[0] = getByUnitAndStatus_PrevAndNext(
				session, singleUserOnboarding, unit, status, orderByComparator,
				true);

			array[1] = singleUserOnboarding;

			array[2] = getByUnitAndStatus_PrevAndNext(
				session, singleUserOnboarding, unit, status, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SingleUserOnboarding getByUnitAndStatus_PrevAndNext(
		Session session, SingleUserOnboarding singleUserOnboarding, String unit,
		int status, OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_SINGLEUSERONBOARDING_WHERE);

		boolean bindUnit = false;

		if (unit.isEmpty()) {
			sb.append(_FINDER_COLUMN_UNITANDSTATUS_UNIT_3);
		}
		else {
			bindUnit = true;

			sb.append(_FINDER_COLUMN_UNITANDSTATUS_UNIT_2);
		}

		sb.append(_FINDER_COLUMN_UNITANDSTATUS_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SingleUserOnboardingModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUnit) {
			queryPos.add(unit);
		}

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						singleUserOnboarding)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SingleUserOnboarding> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the single user onboardings where unit = &#63; and status = &#63; from the database.
	 *
	 * @param unit the unit
	 * @param status the status
	 */
	@Override
	public void removeByUnitAndStatus(String unit, int status) {
		for (SingleUserOnboarding singleUserOnboarding :
				findByUnitAndStatus(
					unit, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(singleUserOnboarding);
		}
	}

	/**
	 * Returns the number of single user onboardings where unit = &#63; and status = &#63;.
	 *
	 * @param unit the unit
	 * @param status the status
	 * @return the number of matching single user onboardings
	 */
	@Override
	public int countByUnitAndStatus(String unit, int status) {
		unit = Objects.toString(unit, "");

		FinderPath finderPath = _finderPathCountByUnitAndStatus;

		Object[] finderArgs = new Object[] {unit, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SINGLEUSERONBOARDING_WHERE);

			boolean bindUnit = false;

			if (unit.isEmpty()) {
				sb.append(_FINDER_COLUMN_UNITANDSTATUS_UNIT_3);
			}
			else {
				bindUnit = true;

				sb.append(_FINDER_COLUMN_UNITANDSTATUS_UNIT_2);
			}

			sb.append(_FINDER_COLUMN_UNITANDSTATUS_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUnit) {
					queryPos.add(unit);
				}

				queryPos.add(status);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UNITANDSTATUS_UNIT_2 =
		"singleUserOnboarding.unit = ? AND ";

	private static final String _FINDER_COLUMN_UNITANDSTATUS_UNIT_3 =
		"(singleUserOnboarding.unit IS NULL OR singleUserOnboarding.unit = '') AND ";

	private static final String _FINDER_COLUMN_UNITANDSTATUS_STATUS_2 =
		"singleUserOnboarding.status = ?";

	private FinderPath _finderPathWithPaginationFindByUnitAndState;
	private FinderPath _finderPathWithoutPaginationFindByUnitAndState;
	private FinderPath _finderPathCountByUnitAndState;

	/**
	 * Returns all the single user onboardings where unit = &#63; and state = &#63;.
	 *
	 * @param unit the unit
	 * @param state the state
	 * @return the matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByUnitAndState(
		String unit, String state) {

		return findByUnitAndState(
			unit, state, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the single user onboardings where unit = &#63; and state = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param unit the unit
	 * @param state the state
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @return the range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByUnitAndState(
		String unit, String state, int start, int end) {

		return findByUnitAndState(unit, state, start, end, null);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where unit = &#63; and state = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param unit the unit
	 * @param state the state
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByUnitAndState(
		String unit, String state, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return findByUnitAndState(
			unit, state, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where unit = &#63; and state = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param unit the unit
	 * @param state the state
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByUnitAndState(
		String unit, String state, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean useFinderCache) {

		unit = Objects.toString(unit, "");
		state = Objects.toString(state, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUnitAndState;
				finderArgs = new Object[] {unit, state};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUnitAndState;
			finderArgs = new Object[] {
				unit, state, start, end, orderByComparator
			};
		}

		List<SingleUserOnboarding> list = null;

		if (useFinderCache) {
			list = (List<SingleUserOnboarding>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SingleUserOnboarding singleUserOnboarding : list) {
					if (!unit.equals(singleUserOnboarding.getUnit()) ||
						!state.equals(singleUserOnboarding.getState())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_SINGLEUSERONBOARDING_WHERE);

			boolean bindUnit = false;

			if (unit.isEmpty()) {
				sb.append(_FINDER_COLUMN_UNITANDSTATE_UNIT_3);
			}
			else {
				bindUnit = true;

				sb.append(_FINDER_COLUMN_UNITANDSTATE_UNIT_2);
			}

			boolean bindState = false;

			if (state.isEmpty()) {
				sb.append(_FINDER_COLUMN_UNITANDSTATE_STATE_3);
			}
			else {
				bindState = true;

				sb.append(_FINDER_COLUMN_UNITANDSTATE_STATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SingleUserOnboardingModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUnit) {
					queryPos.add(unit);
				}

				if (bindState) {
					queryPos.add(state);
				}

				list = (List<SingleUserOnboarding>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first single user onboarding in the ordered set where unit = &#63; and state = &#63;.
	 *
	 * @param unit the unit
	 * @param state the state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding findByUnitAndState_First(
			String unit, String state,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		SingleUserOnboarding singleUserOnboarding = fetchByUnitAndState_First(
			unit, state, orderByComparator);

		if (singleUserOnboarding != null) {
			return singleUserOnboarding;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("unit=");
		sb.append(unit);

		sb.append(", state=");
		sb.append(state);

		sb.append("}");

		throw new NoSuchSingleUserOnboardingException(sb.toString());
	}

	/**
	 * Returns the first single user onboarding in the ordered set where unit = &#63; and state = &#63;.
	 *
	 * @param unit the unit
	 * @param state the state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding fetchByUnitAndState_First(
		String unit, String state,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		List<SingleUserOnboarding> list = findByUnitAndState(
			unit, state, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last single user onboarding in the ordered set where unit = &#63; and state = &#63;.
	 *
	 * @param unit the unit
	 * @param state the state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding findByUnitAndState_Last(
			String unit, String state,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		SingleUserOnboarding singleUserOnboarding = fetchByUnitAndState_Last(
			unit, state, orderByComparator);

		if (singleUserOnboarding != null) {
			return singleUserOnboarding;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("unit=");
		sb.append(unit);

		sb.append(", state=");
		sb.append(state);

		sb.append("}");

		throw new NoSuchSingleUserOnboardingException(sb.toString());
	}

	/**
	 * Returns the last single user onboarding in the ordered set where unit = &#63; and state = &#63;.
	 *
	 * @param unit the unit
	 * @param state the state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding fetchByUnitAndState_Last(
		String unit, String state,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		int count = countByUnitAndState(unit, state);

		if (count == 0) {
			return null;
		}

		List<SingleUserOnboarding> list = findByUnitAndState(
			unit, state, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the single user onboardings before and after the current single user onboarding in the ordered set where unit = &#63; and state = &#63;.
	 *
	 * @param singleUserRegistrationId the primary key of the current single user onboarding
	 * @param unit the unit
	 * @param state the state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a single user onboarding with the primary key could not be found
	 */
	@Override
	public SingleUserOnboarding[] findByUnitAndState_PrevAndNext(
			long singleUserRegistrationId, String unit, String state,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		unit = Objects.toString(unit, "");
		state = Objects.toString(state, "");

		SingleUserOnboarding singleUserOnboarding = findByPrimaryKey(
			singleUserRegistrationId);

		Session session = null;

		try {
			session = openSession();

			SingleUserOnboarding[] array = new SingleUserOnboardingImpl[3];

			array[0] = getByUnitAndState_PrevAndNext(
				session, singleUserOnboarding, unit, state, orderByComparator,
				true);

			array[1] = singleUserOnboarding;

			array[2] = getByUnitAndState_PrevAndNext(
				session, singleUserOnboarding, unit, state, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SingleUserOnboarding getByUnitAndState_PrevAndNext(
		Session session, SingleUserOnboarding singleUserOnboarding, String unit,
		String state, OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_SINGLEUSERONBOARDING_WHERE);

		boolean bindUnit = false;

		if (unit.isEmpty()) {
			sb.append(_FINDER_COLUMN_UNITANDSTATE_UNIT_3);
		}
		else {
			bindUnit = true;

			sb.append(_FINDER_COLUMN_UNITANDSTATE_UNIT_2);
		}

		boolean bindState = false;

		if (state.isEmpty()) {
			sb.append(_FINDER_COLUMN_UNITANDSTATE_STATE_3);
		}
		else {
			bindState = true;

			sb.append(_FINDER_COLUMN_UNITANDSTATE_STATE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SingleUserOnboardingModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUnit) {
			queryPos.add(unit);
		}

		if (bindState) {
			queryPos.add(state);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						singleUserOnboarding)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SingleUserOnboarding> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the single user onboardings where unit = &#63; and state = &#63; from the database.
	 *
	 * @param unit the unit
	 * @param state the state
	 */
	@Override
	public void removeByUnitAndState(String unit, String state) {
		for (SingleUserOnboarding singleUserOnboarding :
				findByUnitAndState(
					unit, state, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(singleUserOnboarding);
		}
	}

	/**
	 * Returns the number of single user onboardings where unit = &#63; and state = &#63;.
	 *
	 * @param unit the unit
	 * @param state the state
	 * @return the number of matching single user onboardings
	 */
	@Override
	public int countByUnitAndState(String unit, String state) {
		unit = Objects.toString(unit, "");
		state = Objects.toString(state, "");

		FinderPath finderPath = _finderPathCountByUnitAndState;

		Object[] finderArgs = new Object[] {unit, state};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SINGLEUSERONBOARDING_WHERE);

			boolean bindUnit = false;

			if (unit.isEmpty()) {
				sb.append(_FINDER_COLUMN_UNITANDSTATE_UNIT_3);
			}
			else {
				bindUnit = true;

				sb.append(_FINDER_COLUMN_UNITANDSTATE_UNIT_2);
			}

			boolean bindState = false;

			if (state.isEmpty()) {
				sb.append(_FINDER_COLUMN_UNITANDSTATE_STATE_3);
			}
			else {
				bindState = true;

				sb.append(_FINDER_COLUMN_UNITANDSTATE_STATE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUnit) {
					queryPos.add(unit);
				}

				if (bindState) {
					queryPos.add(state);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UNITANDSTATE_UNIT_2 =
		"singleUserOnboarding.unit = ? AND ";

	private static final String _FINDER_COLUMN_UNITANDSTATE_UNIT_3 =
		"(singleUserOnboarding.unit IS NULL OR singleUserOnboarding.unit = '') AND ";

	private static final String _FINDER_COLUMN_UNITANDSTATE_STATE_2 =
		"singleUserOnboarding.state = ?";

	private static final String _FINDER_COLUMN_UNITANDSTATE_STATE_3 =
		"(singleUserOnboarding.state IS NULL OR singleUserOnboarding.state = '')";

	private FinderPath _finderPathWithPaginationFindByG_S;
	private FinderPath _finderPathWithoutPaginationFindByG_S;
	private FinderPath _finderPathCountByG_S;

	/**
	 * Returns all the single user onboardings where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByG_S(long groupId, int status) {
		return findByG_S(
			groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the single user onboardings where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @return the range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByG_S(
		long groupId, int status, int start, int end) {

		return findByG_S(groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return findByG_S(groupId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_S;
				finderArgs = new Object[] {groupId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_S;
			finderArgs = new Object[] {
				groupId, status, start, end, orderByComparator
			};
		}

		List<SingleUserOnboarding> list = null;

		if (useFinderCache) {
			list = (List<SingleUserOnboarding>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SingleUserOnboarding singleUserOnboarding : list) {
					if ((groupId != singleUserOnboarding.getGroupId()) ||
						(status != singleUserOnboarding.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_SINGLEUSERONBOARDING_WHERE);

			sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SingleUserOnboardingModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(status);

				list = (List<SingleUserOnboarding>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first single user onboarding in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding findByG_S_First(
			long groupId, int status,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		SingleUserOnboarding singleUserOnboarding = fetchByG_S_First(
			groupId, status, orderByComparator);

		if (singleUserOnboarding != null) {
			return singleUserOnboarding;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchSingleUserOnboardingException(sb.toString());
	}

	/**
	 * Returns the first single user onboarding in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding fetchByG_S_First(
		long groupId, int status,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		List<SingleUserOnboarding> list = findByG_S(
			groupId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last single user onboarding in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding findByG_S_Last(
			long groupId, int status,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		SingleUserOnboarding singleUserOnboarding = fetchByG_S_Last(
			groupId, status, orderByComparator);

		if (singleUserOnboarding != null) {
			return singleUserOnboarding;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchSingleUserOnboardingException(sb.toString());
	}

	/**
	 * Returns the last single user onboarding in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding fetchByG_S_Last(
		long groupId, int status,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		int count = countByG_S(groupId, status);

		if (count == 0) {
			return null;
		}

		List<SingleUserOnboarding> list = findByG_S(
			groupId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the single user onboardings before and after the current single user onboarding in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param singleUserRegistrationId the primary key of the current single user onboarding
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a single user onboarding with the primary key could not be found
	 */
	@Override
	public SingleUserOnboarding[] findByG_S_PrevAndNext(
			long singleUserRegistrationId, long groupId, int status,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		SingleUserOnboarding singleUserOnboarding = findByPrimaryKey(
			singleUserRegistrationId);

		Session session = null;

		try {
			session = openSession();

			SingleUserOnboarding[] array = new SingleUserOnboardingImpl[3];

			array[0] = getByG_S_PrevAndNext(
				session, singleUserOnboarding, groupId, status,
				orderByComparator, true);

			array[1] = singleUserOnboarding;

			array[2] = getByG_S_PrevAndNext(
				session, singleUserOnboarding, groupId, status,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SingleUserOnboarding getByG_S_PrevAndNext(
		Session session, SingleUserOnboarding singleUserOnboarding,
		long groupId, int status,
		OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_SINGLEUSERONBOARDING_WHERE);

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SingleUserOnboardingModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						singleUserOnboarding)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SingleUserOnboarding> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the single user onboardings where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	@Override
	public void removeByG_S(long groupId, int status) {
		for (SingleUserOnboarding singleUserOnboarding :
				findByG_S(
					groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(singleUserOnboarding);
		}
	}

	/**
	 * Returns the number of single user onboardings where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching single user onboardings
	 */
	@Override
	public int countByG_S(long groupId, int status) {
		FinderPath finderPath = _finderPathCountByG_S;

		Object[] finderArgs = new Object[] {groupId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SINGLEUSERONBOARDING_WHERE);

			sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_S_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(status);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_G_S_GROUPID_2 =
		"singleUserOnboarding.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_S_STATUS_2 =
		"singleUserOnboarding.status = ?";

	private FinderPath _finderPathWithPaginationFindBySectionAndStatus;
	private FinderPath _finderPathWithoutPaginationFindBySectionAndStatus;
	private FinderPath _finderPathCountBySectionAndStatus;

	/**
	 * Returns all the single user onboardings where sectionId = &#63; and status = &#63;.
	 *
	 * @param sectionId the section ID
	 * @param status the status
	 * @return the matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findBySectionAndStatus(
		long sectionId, int status) {

		return findBySectionAndStatus(
			sectionId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the single user onboardings where sectionId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param sectionId the section ID
	 * @param status the status
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @return the range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findBySectionAndStatus(
		long sectionId, int status, int start, int end) {

		return findBySectionAndStatus(sectionId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where sectionId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param sectionId the section ID
	 * @param status the status
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findBySectionAndStatus(
		long sectionId, int status, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return findBySectionAndStatus(
			sectionId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where sectionId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param sectionId the section ID
	 * @param status the status
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findBySectionAndStatus(
		long sectionId, int status, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBySectionAndStatus;
				finderArgs = new Object[] {sectionId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBySectionAndStatus;
			finderArgs = new Object[] {
				sectionId, status, start, end, orderByComparator
			};
		}

		List<SingleUserOnboarding> list = null;

		if (useFinderCache) {
			list = (List<SingleUserOnboarding>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SingleUserOnboarding singleUserOnboarding : list) {
					if ((sectionId != singleUserOnboarding.getSectionId()) ||
						(status != singleUserOnboarding.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_SINGLEUSERONBOARDING_WHERE);

			sb.append(_FINDER_COLUMN_SECTIONANDSTATUS_SECTIONID_2);

			sb.append(_FINDER_COLUMN_SECTIONANDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SingleUserOnboardingModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(sectionId);

				queryPos.add(status);

				list = (List<SingleUserOnboarding>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first single user onboarding in the ordered set where sectionId = &#63; and status = &#63;.
	 *
	 * @param sectionId the section ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding findBySectionAndStatus_First(
			long sectionId, int status,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		SingleUserOnboarding singleUserOnboarding =
			fetchBySectionAndStatus_First(sectionId, status, orderByComparator);

		if (singleUserOnboarding != null) {
			return singleUserOnboarding;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("sectionId=");
		sb.append(sectionId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchSingleUserOnboardingException(sb.toString());
	}

	/**
	 * Returns the first single user onboarding in the ordered set where sectionId = &#63; and status = &#63;.
	 *
	 * @param sectionId the section ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding fetchBySectionAndStatus_First(
		long sectionId, int status,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		List<SingleUserOnboarding> list = findBySectionAndStatus(
			sectionId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last single user onboarding in the ordered set where sectionId = &#63; and status = &#63;.
	 *
	 * @param sectionId the section ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding findBySectionAndStatus_Last(
			long sectionId, int status,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		SingleUserOnboarding singleUserOnboarding =
			fetchBySectionAndStatus_Last(sectionId, status, orderByComparator);

		if (singleUserOnboarding != null) {
			return singleUserOnboarding;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("sectionId=");
		sb.append(sectionId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchSingleUserOnboardingException(sb.toString());
	}

	/**
	 * Returns the last single user onboarding in the ordered set where sectionId = &#63; and status = &#63;.
	 *
	 * @param sectionId the section ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding fetchBySectionAndStatus_Last(
		long sectionId, int status,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		int count = countBySectionAndStatus(sectionId, status);

		if (count == 0) {
			return null;
		}

		List<SingleUserOnboarding> list = findBySectionAndStatus(
			sectionId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the single user onboardings before and after the current single user onboarding in the ordered set where sectionId = &#63; and status = &#63;.
	 *
	 * @param singleUserRegistrationId the primary key of the current single user onboarding
	 * @param sectionId the section ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a single user onboarding with the primary key could not be found
	 */
	@Override
	public SingleUserOnboarding[] findBySectionAndStatus_PrevAndNext(
			long singleUserRegistrationId, long sectionId, int status,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		SingleUserOnboarding singleUserOnboarding = findByPrimaryKey(
			singleUserRegistrationId);

		Session session = null;

		try {
			session = openSession();

			SingleUserOnboarding[] array = new SingleUserOnboardingImpl[3];

			array[0] = getBySectionAndStatus_PrevAndNext(
				session, singleUserOnboarding, sectionId, status,
				orderByComparator, true);

			array[1] = singleUserOnboarding;

			array[2] = getBySectionAndStatus_PrevAndNext(
				session, singleUserOnboarding, sectionId, status,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SingleUserOnboarding getBySectionAndStatus_PrevAndNext(
		Session session, SingleUserOnboarding singleUserOnboarding,
		long sectionId, int status,
		OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_SINGLEUSERONBOARDING_WHERE);

		sb.append(_FINDER_COLUMN_SECTIONANDSTATUS_SECTIONID_2);

		sb.append(_FINDER_COLUMN_SECTIONANDSTATUS_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SingleUserOnboardingModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(sectionId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						singleUserOnboarding)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SingleUserOnboarding> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the single user onboardings where sectionId = &#63; and status = &#63; from the database.
	 *
	 * @param sectionId the section ID
	 * @param status the status
	 */
	@Override
	public void removeBySectionAndStatus(long sectionId, int status) {
		for (SingleUserOnboarding singleUserOnboarding :
				findBySectionAndStatus(
					sectionId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(singleUserOnboarding);
		}
	}

	/**
	 * Returns the number of single user onboardings where sectionId = &#63; and status = &#63;.
	 *
	 * @param sectionId the section ID
	 * @param status the status
	 * @return the number of matching single user onboardings
	 */
	@Override
	public int countBySectionAndStatus(long sectionId, int status) {
		FinderPath finderPath = _finderPathCountBySectionAndStatus;

		Object[] finderArgs = new Object[] {sectionId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SINGLEUSERONBOARDING_WHERE);

			sb.append(_FINDER_COLUMN_SECTIONANDSTATUS_SECTIONID_2);

			sb.append(_FINDER_COLUMN_SECTIONANDSTATUS_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(sectionId);

				queryPos.add(status);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_SECTIONANDSTATUS_SECTIONID_2 =
		"singleUserOnboarding.sectionId = ? AND ";

	private static final String _FINDER_COLUMN_SECTIONANDSTATUS_STATUS_2 =
		"singleUserOnboarding.status = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the single user onboardings where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the single user onboardings where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @return the range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByGroupId(
		long groupId, int start, int end) {

		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGroupId;
				finderArgs = new Object[] {groupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroupId;
			finderArgs = new Object[] {groupId, start, end, orderByComparator};
		}

		List<SingleUserOnboarding> list = null;

		if (useFinderCache) {
			list = (List<SingleUserOnboarding>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SingleUserOnboarding singleUserOnboarding : list) {
					if (groupId != singleUserOnboarding.getGroupId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_SINGLEUSERONBOARDING_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SingleUserOnboardingModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<SingleUserOnboarding>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first single user onboarding in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding findByGroupId_First(
			long groupId,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		SingleUserOnboarding singleUserOnboarding = fetchByGroupId_First(
			groupId, orderByComparator);

		if (singleUserOnboarding != null) {
			return singleUserOnboarding;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchSingleUserOnboardingException(sb.toString());
	}

	/**
	 * Returns the first single user onboarding in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding fetchByGroupId_First(
		long groupId,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		List<SingleUserOnboarding> list = findByGroupId(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last single user onboarding in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding findByGroupId_Last(
			long groupId,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		SingleUserOnboarding singleUserOnboarding = fetchByGroupId_Last(
			groupId, orderByComparator);

		if (singleUserOnboarding != null) {
			return singleUserOnboarding;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchSingleUserOnboardingException(sb.toString());
	}

	/**
	 * Returns the last single user onboarding in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding fetchByGroupId_Last(
		long groupId,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<SingleUserOnboarding> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the single user onboardings before and after the current single user onboarding in the ordered set where groupId = &#63;.
	 *
	 * @param singleUserRegistrationId the primary key of the current single user onboarding
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a single user onboarding with the primary key could not be found
	 */
	@Override
	public SingleUserOnboarding[] findByGroupId_PrevAndNext(
			long singleUserRegistrationId, long groupId,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		SingleUserOnboarding singleUserOnboarding = findByPrimaryKey(
			singleUserRegistrationId);

		Session session = null;

		try {
			session = openSession();

			SingleUserOnboarding[] array = new SingleUserOnboardingImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, singleUserOnboarding, groupId, orderByComparator,
				true);

			array[1] = singleUserOnboarding;

			array[2] = getByGroupId_PrevAndNext(
				session, singleUserOnboarding, groupId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SingleUserOnboarding getByGroupId_PrevAndNext(
		Session session, SingleUserOnboarding singleUserOnboarding,
		long groupId, OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SINGLEUSERONBOARDING_WHERE);

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SingleUserOnboardingModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						singleUserOnboarding)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SingleUserOnboarding> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the single user onboardings where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (SingleUserOnboarding singleUserOnboarding :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(singleUserOnboarding);
		}
	}

	/**
	 * Returns the number of single user onboardings where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching single user onboardings
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SINGLEUSERONBOARDING_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 =
		"singleUserOnboarding.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUserId;
	private FinderPath _finderPathWithoutPaginationFindByUserId;
	private FinderPath _finderPathCountByUserId;

	/**
	 * Returns all the single user onboardings where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByUserId(long userId) {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the single user onboardings where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @return the range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByUserId(
		long userId, int start, int end) {

		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByUserId(
		long userId, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return findByUserId(userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByUserId(
		long userId, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUserId;
				finderArgs = new Object[] {userId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUserId;
			finderArgs = new Object[] {userId, start, end, orderByComparator};
		}

		List<SingleUserOnboarding> list = null;

		if (useFinderCache) {
			list = (List<SingleUserOnboarding>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SingleUserOnboarding singleUserOnboarding : list) {
					if (userId != singleUserOnboarding.getUserId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_SINGLEUSERONBOARDING_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SingleUserOnboardingModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				list = (List<SingleUserOnboarding>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first single user onboarding in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding findByUserId_First(
			long userId,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		SingleUserOnboarding singleUserOnboarding = fetchByUserId_First(
			userId, orderByComparator);

		if (singleUserOnboarding != null) {
			return singleUserOnboarding;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchSingleUserOnboardingException(sb.toString());
	}

	/**
	 * Returns the first single user onboarding in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding fetchByUserId_First(
		long userId,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		List<SingleUserOnboarding> list = findByUserId(
			userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last single user onboarding in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding findByUserId_Last(
			long userId,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		SingleUserOnboarding singleUserOnboarding = fetchByUserId_Last(
			userId, orderByComparator);

		if (singleUserOnboarding != null) {
			return singleUserOnboarding;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchSingleUserOnboardingException(sb.toString());
	}

	/**
	 * Returns the last single user onboarding in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding fetchByUserId_Last(
		long userId,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<SingleUserOnboarding> list = findByUserId(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the single user onboardings before and after the current single user onboarding in the ordered set where userId = &#63;.
	 *
	 * @param singleUserRegistrationId the primary key of the current single user onboarding
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a single user onboarding with the primary key could not be found
	 */
	@Override
	public SingleUserOnboarding[] findByUserId_PrevAndNext(
			long singleUserRegistrationId, long userId,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		SingleUserOnboarding singleUserOnboarding = findByPrimaryKey(
			singleUserRegistrationId);

		Session session = null;

		try {
			session = openSession();

			SingleUserOnboarding[] array = new SingleUserOnboardingImpl[3];

			array[0] = getByUserId_PrevAndNext(
				session, singleUserOnboarding, userId, orderByComparator, true);

			array[1] = singleUserOnboarding;

			array[2] = getByUserId_PrevAndNext(
				session, singleUserOnboarding, userId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SingleUserOnboarding getByUserId_PrevAndNext(
		Session session, SingleUserOnboarding singleUserOnboarding, long userId,
		OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SINGLEUSERONBOARDING_WHERE);

		sb.append(_FINDER_COLUMN_USERID_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SingleUserOnboardingModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						singleUserOnboarding)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SingleUserOnboarding> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the single user onboardings where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByUserId(long userId) {
		for (SingleUserOnboarding singleUserOnboarding :
				findByUserId(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(singleUserOnboarding);
		}
	}

	/**
	 * Returns the number of single user onboardings where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching single user onboardings
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = _finderPathCountByUserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SINGLEUSERONBOARDING_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERID_USERID_2 =
		"singleUserOnboarding.userId = ?";

	private FinderPath _finderPathWithPaginationFindByPersonalNo;
	private FinderPath _finderPathWithoutPaginationFindByPersonalNo;
	private FinderPath _finderPathCountByPersonalNo;

	/**
	 * Returns all the single user onboardings where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @return the matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByPersonalNo(long personalNo) {
		return findByPersonalNo(
			personalNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the single user onboardings where personalNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param personalNo the personal no
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @return the range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByPersonalNo(
		long personalNo, int start, int end) {

		return findByPersonalNo(personalNo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where personalNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param personalNo the personal no
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByPersonalNo(
		long personalNo, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return findByPersonalNo(
			personalNo, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where personalNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param personalNo the personal no
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByPersonalNo(
		long personalNo, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByPersonalNo;
				finderArgs = new Object[] {personalNo};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByPersonalNo;
			finderArgs = new Object[] {
				personalNo, start, end, orderByComparator
			};
		}

		List<SingleUserOnboarding> list = null;

		if (useFinderCache) {
			list = (List<SingleUserOnboarding>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SingleUserOnboarding singleUserOnboarding : list) {
					if (personalNo != singleUserOnboarding.getPersonalNo()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_SINGLEUSERONBOARDING_WHERE);

			sb.append(_FINDER_COLUMN_PERSONALNO_PERSONALNO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SingleUserOnboardingModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(personalNo);

				list = (List<SingleUserOnboarding>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first single user onboarding in the ordered set where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding findByPersonalNo_First(
			long personalNo,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		SingleUserOnboarding singleUserOnboarding = fetchByPersonalNo_First(
			personalNo, orderByComparator);

		if (singleUserOnboarding != null) {
			return singleUserOnboarding;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("personalNo=");
		sb.append(personalNo);

		sb.append("}");

		throw new NoSuchSingleUserOnboardingException(sb.toString());
	}

	/**
	 * Returns the first single user onboarding in the ordered set where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding fetchByPersonalNo_First(
		long personalNo,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		List<SingleUserOnboarding> list = findByPersonalNo(
			personalNo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last single user onboarding in the ordered set where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding findByPersonalNo_Last(
			long personalNo,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		SingleUserOnboarding singleUserOnboarding = fetchByPersonalNo_Last(
			personalNo, orderByComparator);

		if (singleUserOnboarding != null) {
			return singleUserOnboarding;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("personalNo=");
		sb.append(personalNo);

		sb.append("}");

		throw new NoSuchSingleUserOnboardingException(sb.toString());
	}

	/**
	 * Returns the last single user onboarding in the ordered set where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding fetchByPersonalNo_Last(
		long personalNo,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		int count = countByPersonalNo(personalNo);

		if (count == 0) {
			return null;
		}

		List<SingleUserOnboarding> list = findByPersonalNo(
			personalNo, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the single user onboardings before and after the current single user onboarding in the ordered set where personalNo = &#63;.
	 *
	 * @param singleUserRegistrationId the primary key of the current single user onboarding
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a single user onboarding with the primary key could not be found
	 */
	@Override
	public SingleUserOnboarding[] findByPersonalNo_PrevAndNext(
			long singleUserRegistrationId, long personalNo,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		SingleUserOnboarding singleUserOnboarding = findByPrimaryKey(
			singleUserRegistrationId);

		Session session = null;

		try {
			session = openSession();

			SingleUserOnboarding[] array = new SingleUserOnboardingImpl[3];

			array[0] = getByPersonalNo_PrevAndNext(
				session, singleUserOnboarding, personalNo, orderByComparator,
				true);

			array[1] = singleUserOnboarding;

			array[2] = getByPersonalNo_PrevAndNext(
				session, singleUserOnboarding, personalNo, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SingleUserOnboarding getByPersonalNo_PrevAndNext(
		Session session, SingleUserOnboarding singleUserOnboarding,
		long personalNo,
		OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SINGLEUSERONBOARDING_WHERE);

		sb.append(_FINDER_COLUMN_PERSONALNO_PERSONALNO_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SingleUserOnboardingModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(personalNo);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						singleUserOnboarding)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SingleUserOnboarding> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the single user onboardings where personalNo = &#63; from the database.
	 *
	 * @param personalNo the personal no
	 */
	@Override
	public void removeByPersonalNo(long personalNo) {
		for (SingleUserOnboarding singleUserOnboarding :
				findByPersonalNo(
					personalNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(singleUserOnboarding);
		}
	}

	/**
	 * Returns the number of single user onboardings where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @return the number of matching single user onboardings
	 */
	@Override
	public int countByPersonalNo(long personalNo) {
		FinderPath finderPath = _finderPathCountByPersonalNo;

		Object[] finderArgs = new Object[] {personalNo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SINGLEUSERONBOARDING_WHERE);

			sb.append(_FINDER_COLUMN_PERSONALNO_PERSONALNO_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(personalNo);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PERSONALNO_PERSONALNO_2 =
		"singleUserOnboarding.personalNo = ?";

	private FinderPath _finderPathWithPaginationFindByRecordNo;
	private FinderPath _finderPathWithoutPaginationFindByRecordNo;
	private FinderPath _finderPathCountByRecordNo;

	/**
	 * Returns all the single user onboardings where recordNo = &#63;.
	 *
	 * @param recordNo the record no
	 * @return the matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByRecordNo(long recordNo) {
		return findByRecordNo(
			recordNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the single user onboardings where recordNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param recordNo the record no
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @return the range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByRecordNo(
		long recordNo, int start, int end) {

		return findByRecordNo(recordNo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where recordNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param recordNo the record no
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByRecordNo(
		long recordNo, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return findByRecordNo(recordNo, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where recordNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param recordNo the record no
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByRecordNo(
		long recordNo, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByRecordNo;
				finderArgs = new Object[] {recordNo};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByRecordNo;
			finderArgs = new Object[] {recordNo, start, end, orderByComparator};
		}

		List<SingleUserOnboarding> list = null;

		if (useFinderCache) {
			list = (List<SingleUserOnboarding>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SingleUserOnboarding singleUserOnboarding : list) {
					if (recordNo != singleUserOnboarding.getRecordNo()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_SINGLEUSERONBOARDING_WHERE);

			sb.append(_FINDER_COLUMN_RECORDNO_RECORDNO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SingleUserOnboardingModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(recordNo);

				list = (List<SingleUserOnboarding>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first single user onboarding in the ordered set where recordNo = &#63;.
	 *
	 * @param recordNo the record no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding findByRecordNo_First(
			long recordNo,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		SingleUserOnboarding singleUserOnboarding = fetchByRecordNo_First(
			recordNo, orderByComparator);

		if (singleUserOnboarding != null) {
			return singleUserOnboarding;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("recordNo=");
		sb.append(recordNo);

		sb.append("}");

		throw new NoSuchSingleUserOnboardingException(sb.toString());
	}

	/**
	 * Returns the first single user onboarding in the ordered set where recordNo = &#63;.
	 *
	 * @param recordNo the record no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding fetchByRecordNo_First(
		long recordNo,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		List<SingleUserOnboarding> list = findByRecordNo(
			recordNo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last single user onboarding in the ordered set where recordNo = &#63;.
	 *
	 * @param recordNo the record no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding findByRecordNo_Last(
			long recordNo,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		SingleUserOnboarding singleUserOnboarding = fetchByRecordNo_Last(
			recordNo, orderByComparator);

		if (singleUserOnboarding != null) {
			return singleUserOnboarding;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("recordNo=");
		sb.append(recordNo);

		sb.append("}");

		throw new NoSuchSingleUserOnboardingException(sb.toString());
	}

	/**
	 * Returns the last single user onboarding in the ordered set where recordNo = &#63;.
	 *
	 * @param recordNo the record no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding fetchByRecordNo_Last(
		long recordNo,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		int count = countByRecordNo(recordNo);

		if (count == 0) {
			return null;
		}

		List<SingleUserOnboarding> list = findByRecordNo(
			recordNo, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the single user onboardings before and after the current single user onboarding in the ordered set where recordNo = &#63;.
	 *
	 * @param singleUserRegistrationId the primary key of the current single user onboarding
	 * @param recordNo the record no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a single user onboarding with the primary key could not be found
	 */
	@Override
	public SingleUserOnboarding[] findByRecordNo_PrevAndNext(
			long singleUserRegistrationId, long recordNo,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		SingleUserOnboarding singleUserOnboarding = findByPrimaryKey(
			singleUserRegistrationId);

		Session session = null;

		try {
			session = openSession();

			SingleUserOnboarding[] array = new SingleUserOnboardingImpl[3];

			array[0] = getByRecordNo_PrevAndNext(
				session, singleUserOnboarding, recordNo, orderByComparator,
				true);

			array[1] = singleUserOnboarding;

			array[2] = getByRecordNo_PrevAndNext(
				session, singleUserOnboarding, recordNo, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SingleUserOnboarding getByRecordNo_PrevAndNext(
		Session session, SingleUserOnboarding singleUserOnboarding,
		long recordNo,
		OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SINGLEUSERONBOARDING_WHERE);

		sb.append(_FINDER_COLUMN_RECORDNO_RECORDNO_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SingleUserOnboardingModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(recordNo);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						singleUserOnboarding)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SingleUserOnboarding> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the single user onboardings where recordNo = &#63; from the database.
	 *
	 * @param recordNo the record no
	 */
	@Override
	public void removeByRecordNo(long recordNo) {
		for (SingleUserOnboarding singleUserOnboarding :
				findByRecordNo(
					recordNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(singleUserOnboarding);
		}
	}

	/**
	 * Returns the number of single user onboardings where recordNo = &#63;.
	 *
	 * @param recordNo the record no
	 * @return the number of matching single user onboardings
	 */
	@Override
	public int countByRecordNo(long recordNo) {
		FinderPath finderPath = _finderPathCountByRecordNo;

		Object[] finderArgs = new Object[] {recordNo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SINGLEUSERONBOARDING_WHERE);

			sb.append(_FINDER_COLUMN_RECORDNO_RECORDNO_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(recordNo);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_RECORDNO_RECORDNO_2 =
		"singleUserOnboarding.recordNo = ?";

	private FinderPath _finderPathWithPaginationFindByEmailAddress;
	private FinderPath _finderPathWithoutPaginationFindByEmailAddress;
	private FinderPath _finderPathCountByEmailAddress;

	/**
	 * Returns all the single user onboardings where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @return the matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByEmailAddress(String emailAddress) {
		return findByEmailAddress(
			emailAddress, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the single user onboardings where emailAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param emailAddress the email address
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @return the range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByEmailAddress(
		String emailAddress, int start, int end) {

		return findByEmailAddress(emailAddress, start, end, null);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where emailAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param emailAddress the email address
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByEmailAddress(
		String emailAddress, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return findByEmailAddress(
			emailAddress, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where emailAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param emailAddress the email address
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByEmailAddress(
		String emailAddress, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean useFinderCache) {

		emailAddress = Objects.toString(emailAddress, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByEmailAddress;
				finderArgs = new Object[] {emailAddress};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByEmailAddress;
			finderArgs = new Object[] {
				emailAddress, start, end, orderByComparator
			};
		}

		List<SingleUserOnboarding> list = null;

		if (useFinderCache) {
			list = (List<SingleUserOnboarding>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SingleUserOnboarding singleUserOnboarding : list) {
					if (!emailAddress.equals(
							singleUserOnboarding.getEmailAddress())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_SINGLEUSERONBOARDING_WHERE);

			boolean bindEmailAddress = false;

			if (emailAddress.isEmpty()) {
				sb.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_3);
			}
			else {
				bindEmailAddress = true;

				sb.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SingleUserOnboardingModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindEmailAddress) {
					queryPos.add(emailAddress);
				}

				list = (List<SingleUserOnboarding>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first single user onboarding in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding findByEmailAddress_First(
			String emailAddress,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		SingleUserOnboarding singleUserOnboarding = fetchByEmailAddress_First(
			emailAddress, orderByComparator);

		if (singleUserOnboarding != null) {
			return singleUserOnboarding;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("emailAddress=");
		sb.append(emailAddress);

		sb.append("}");

		throw new NoSuchSingleUserOnboardingException(sb.toString());
	}

	/**
	 * Returns the first single user onboarding in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding fetchByEmailAddress_First(
		String emailAddress,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		List<SingleUserOnboarding> list = findByEmailAddress(
			emailAddress, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last single user onboarding in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding findByEmailAddress_Last(
			String emailAddress,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		SingleUserOnboarding singleUserOnboarding = fetchByEmailAddress_Last(
			emailAddress, orderByComparator);

		if (singleUserOnboarding != null) {
			return singleUserOnboarding;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("emailAddress=");
		sb.append(emailAddress);

		sb.append("}");

		throw new NoSuchSingleUserOnboardingException(sb.toString());
	}

	/**
	 * Returns the last single user onboarding in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding fetchByEmailAddress_Last(
		String emailAddress,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		int count = countByEmailAddress(emailAddress);

		if (count == 0) {
			return null;
		}

		List<SingleUserOnboarding> list = findByEmailAddress(
			emailAddress, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the single user onboardings before and after the current single user onboarding in the ordered set where emailAddress = &#63;.
	 *
	 * @param singleUserRegistrationId the primary key of the current single user onboarding
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a single user onboarding with the primary key could not be found
	 */
	@Override
	public SingleUserOnboarding[] findByEmailAddress_PrevAndNext(
			long singleUserRegistrationId, String emailAddress,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		emailAddress = Objects.toString(emailAddress, "");

		SingleUserOnboarding singleUserOnboarding = findByPrimaryKey(
			singleUserRegistrationId);

		Session session = null;

		try {
			session = openSession();

			SingleUserOnboarding[] array = new SingleUserOnboardingImpl[3];

			array[0] = getByEmailAddress_PrevAndNext(
				session, singleUserOnboarding, emailAddress, orderByComparator,
				true);

			array[1] = singleUserOnboarding;

			array[2] = getByEmailAddress_PrevAndNext(
				session, singleUserOnboarding, emailAddress, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SingleUserOnboarding getByEmailAddress_PrevAndNext(
		Session session, SingleUserOnboarding singleUserOnboarding,
		String emailAddress,
		OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SINGLEUSERONBOARDING_WHERE);

		boolean bindEmailAddress = false;

		if (emailAddress.isEmpty()) {
			sb.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_3);
		}
		else {
			bindEmailAddress = true;

			sb.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SingleUserOnboardingModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindEmailAddress) {
			queryPos.add(emailAddress);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						singleUserOnboarding)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SingleUserOnboarding> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the single user onboardings where emailAddress = &#63; from the database.
	 *
	 * @param emailAddress the email address
	 */
	@Override
	public void removeByEmailAddress(String emailAddress) {
		for (SingleUserOnboarding singleUserOnboarding :
				findByEmailAddress(
					emailAddress, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(singleUserOnboarding);
		}
	}

	/**
	 * Returns the number of single user onboardings where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @return the number of matching single user onboardings
	 */
	@Override
	public int countByEmailAddress(String emailAddress) {
		emailAddress = Objects.toString(emailAddress, "");

		FinderPath finderPath = _finderPathCountByEmailAddress;

		Object[] finderArgs = new Object[] {emailAddress};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SINGLEUSERONBOARDING_WHERE);

			boolean bindEmailAddress = false;

			if (emailAddress.isEmpty()) {
				sb.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_3);
			}
			else {
				bindEmailAddress = true;

				sb.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindEmailAddress) {
					queryPos.add(emailAddress);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_2 =
		"singleUserOnboarding.emailAddress = ?";

	private static final String _FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_3 =
		"(singleUserOnboarding.emailAddress IS NULL OR singleUserOnboarding.emailAddress = '')";

	private FinderPath _finderPathWithPaginationFindByLoginIdAndStatus;
	private FinderPath _finderPathWithoutPaginationFindByLoginIdAndStatus;
	private FinderPath _finderPathCountByLoginIdAndStatus;

	/**
	 * Returns all the single user onboardings where loginId = &#63; and status = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @return the matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByLoginIdAndStatus(
		String loginId, int status) {

		return findByLoginIdAndStatus(
			loginId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the single user onboardings where loginId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @return the range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByLoginIdAndStatus(
		String loginId, int status, int start, int end) {

		return findByLoginIdAndStatus(loginId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where loginId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByLoginIdAndStatus(
		String loginId, int status, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return findByLoginIdAndStatus(
			loginId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where loginId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findByLoginIdAndStatus(
		String loginId, int status, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean useFinderCache) {

		loginId = Objects.toString(loginId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByLoginIdAndStatus;
				finderArgs = new Object[] {loginId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByLoginIdAndStatus;
			finderArgs = new Object[] {
				loginId, status, start, end, orderByComparator
			};
		}

		List<SingleUserOnboarding> list = null;

		if (useFinderCache) {
			list = (List<SingleUserOnboarding>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SingleUserOnboarding singleUserOnboarding : list) {
					if (!loginId.equals(singleUserOnboarding.getLoginId()) ||
						(status != singleUserOnboarding.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_SINGLEUSERONBOARDING_WHERE);

			boolean bindLoginId = false;

			if (loginId.isEmpty()) {
				sb.append(_FINDER_COLUMN_LOGINIDANDSTATUS_LOGINID_3);
			}
			else {
				bindLoginId = true;

				sb.append(_FINDER_COLUMN_LOGINIDANDSTATUS_LOGINID_2);
			}

			sb.append(_FINDER_COLUMN_LOGINIDANDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SingleUserOnboardingModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindLoginId) {
					queryPos.add(loginId);
				}

				queryPos.add(status);

				list = (List<SingleUserOnboarding>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first single user onboarding in the ordered set where loginId = &#63; and status = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding findByLoginIdAndStatus_First(
			String loginId, int status,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		SingleUserOnboarding singleUserOnboarding =
			fetchByLoginIdAndStatus_First(loginId, status, orderByComparator);

		if (singleUserOnboarding != null) {
			return singleUserOnboarding;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("loginId=");
		sb.append(loginId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchSingleUserOnboardingException(sb.toString());
	}

	/**
	 * Returns the first single user onboarding in the ordered set where loginId = &#63; and status = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding fetchByLoginIdAndStatus_First(
		String loginId, int status,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		List<SingleUserOnboarding> list = findByLoginIdAndStatus(
			loginId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last single user onboarding in the ordered set where loginId = &#63; and status = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding findByLoginIdAndStatus_Last(
			String loginId, int status,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		SingleUserOnboarding singleUserOnboarding =
			fetchByLoginIdAndStatus_Last(loginId, status, orderByComparator);

		if (singleUserOnboarding != null) {
			return singleUserOnboarding;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("loginId=");
		sb.append(loginId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchSingleUserOnboardingException(sb.toString());
	}

	/**
	 * Returns the last single user onboarding in the ordered set where loginId = &#63; and status = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding fetchByLoginIdAndStatus_Last(
		String loginId, int status,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		int count = countByLoginIdAndStatus(loginId, status);

		if (count == 0) {
			return null;
		}

		List<SingleUserOnboarding> list = findByLoginIdAndStatus(
			loginId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the single user onboardings before and after the current single user onboarding in the ordered set where loginId = &#63; and status = &#63;.
	 *
	 * @param singleUserRegistrationId the primary key of the current single user onboarding
	 * @param loginId the login ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a single user onboarding with the primary key could not be found
	 */
	@Override
	public SingleUserOnboarding[] findByLoginIdAndStatus_PrevAndNext(
			long singleUserRegistrationId, String loginId, int status,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		loginId = Objects.toString(loginId, "");

		SingleUserOnboarding singleUserOnboarding = findByPrimaryKey(
			singleUserRegistrationId);

		Session session = null;

		try {
			session = openSession();

			SingleUserOnboarding[] array = new SingleUserOnboardingImpl[3];

			array[0] = getByLoginIdAndStatus_PrevAndNext(
				session, singleUserOnboarding, loginId, status,
				orderByComparator, true);

			array[1] = singleUserOnboarding;

			array[2] = getByLoginIdAndStatus_PrevAndNext(
				session, singleUserOnboarding, loginId, status,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SingleUserOnboarding getByLoginIdAndStatus_PrevAndNext(
		Session session, SingleUserOnboarding singleUserOnboarding,
		String loginId, int status,
		OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_SINGLEUSERONBOARDING_WHERE);

		boolean bindLoginId = false;

		if (loginId.isEmpty()) {
			sb.append(_FINDER_COLUMN_LOGINIDANDSTATUS_LOGINID_3);
		}
		else {
			bindLoginId = true;

			sb.append(_FINDER_COLUMN_LOGINIDANDSTATUS_LOGINID_2);
		}

		sb.append(_FINDER_COLUMN_LOGINIDANDSTATUS_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SingleUserOnboardingModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindLoginId) {
			queryPos.add(loginId);
		}

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						singleUserOnboarding)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SingleUserOnboarding> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the single user onboardings where loginId = &#63; and status = &#63; from the database.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 */
	@Override
	public void removeByLoginIdAndStatus(String loginId, int status) {
		for (SingleUserOnboarding singleUserOnboarding :
				findByLoginIdAndStatus(
					loginId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(singleUserOnboarding);
		}
	}

	/**
	 * Returns the number of single user onboardings where loginId = &#63; and status = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @return the number of matching single user onboardings
	 */
	@Override
	public int countByLoginIdAndStatus(String loginId, int status) {
		loginId = Objects.toString(loginId, "");

		FinderPath finderPath = _finderPathCountByLoginIdAndStatus;

		Object[] finderArgs = new Object[] {loginId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SINGLEUSERONBOARDING_WHERE);

			boolean bindLoginId = false;

			if (loginId.isEmpty()) {
				sb.append(_FINDER_COLUMN_LOGINIDANDSTATUS_LOGINID_3);
			}
			else {
				bindLoginId = true;

				sb.append(_FINDER_COLUMN_LOGINIDANDSTATUS_LOGINID_2);
			}

			sb.append(_FINDER_COLUMN_LOGINIDANDSTATUS_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindLoginId) {
					queryPos.add(loginId);
				}

				queryPos.add(status);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_LOGINIDANDSTATUS_LOGINID_2 =
		"singleUserOnboarding.loginId = ? AND ";

	private static final String _FINDER_COLUMN_LOGINIDANDSTATUS_LOGINID_3 =
		"(singleUserOnboarding.loginId IS NULL OR singleUserOnboarding.loginId = '') AND ";

	private static final String _FINDER_COLUMN_LOGINIDANDSTATUS_STATUS_2 =
		"singleUserOnboarding.status = ?";

	private FinderPath
		_finderPathWithPaginationFindByLoginIdStatusStateAndIdamUserCreated;
	private FinderPath
		_finderPathWithoutPaginationFindByLoginIdStatusStateAndIdamUserCreated;
	private FinderPath _finderPathCountByLoginIdStatusStateAndIdamUserCreated;

	/**
	 * Returns all the single user onboardings where loginId = &#63; and status = &#63; and state = &#63; and idamUserCreated = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param state the state
	 * @param idamUserCreated the idam user created
	 * @return the matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding>
		findByLoginIdStatusStateAndIdamUserCreated(
			String loginId, int status, String state, boolean idamUserCreated) {

		return findByLoginIdStatusStateAndIdamUserCreated(
			loginId, status, state, idamUserCreated, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the single user onboardings where loginId = &#63; and status = &#63; and state = &#63; and idamUserCreated = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param state the state
	 * @param idamUserCreated the idam user created
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @return the range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding>
		findByLoginIdStatusStateAndIdamUserCreated(
			String loginId, int status, String state, boolean idamUserCreated,
			int start, int end) {

		return findByLoginIdStatusStateAndIdamUserCreated(
			loginId, status, state, idamUserCreated, start, end, null);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where loginId = &#63; and status = &#63; and state = &#63; and idamUserCreated = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param state the state
	 * @param idamUserCreated the idam user created
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding>
		findByLoginIdStatusStateAndIdamUserCreated(
			String loginId, int status, String state, boolean idamUserCreated,
			int start, int end,
			OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return findByLoginIdStatusStateAndIdamUserCreated(
			loginId, status, state, idamUserCreated, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where loginId = &#63; and status = &#63; and state = &#63; and idamUserCreated = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param state the state
	 * @param idamUserCreated the idam user created
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding>
		findByLoginIdStatusStateAndIdamUserCreated(
			String loginId, int status, String state, boolean idamUserCreated,
			int start, int end,
			OrderByComparator<SingleUserOnboarding> orderByComparator,
			boolean useFinderCache) {

		loginId = Objects.toString(loginId, "");
		state = Objects.toString(state, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByLoginIdStatusStateAndIdamUserCreated;
				finderArgs = new Object[] {
					loginId, status, state, idamUserCreated
				};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByLoginIdStatusStateAndIdamUserCreated;
			finderArgs = new Object[] {
				loginId, status, state, idamUserCreated, start, end,
				orderByComparator
			};
		}

		List<SingleUserOnboarding> list = null;

		if (useFinderCache) {
			list = (List<SingleUserOnboarding>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SingleUserOnboarding singleUserOnboarding : list) {
					if (!loginId.equals(singleUserOnboarding.getLoginId()) ||
						(status != singleUserOnboarding.getStatus()) ||
						!state.equals(singleUserOnboarding.getState()) ||
						(idamUserCreated !=
							singleUserOnboarding.isIdamUserCreated())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					6 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(6);
			}

			sb.append(_SQL_SELECT_SINGLEUSERONBOARDING_WHERE);

			boolean bindLoginId = false;

			if (loginId.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_LOGINIDSTATUSSTATEANDIDAMUSERCREATED_LOGINID_3);
			}
			else {
				bindLoginId = true;

				sb.append(
					_FINDER_COLUMN_LOGINIDSTATUSSTATEANDIDAMUSERCREATED_LOGINID_2);
			}

			sb.append(
				_FINDER_COLUMN_LOGINIDSTATUSSTATEANDIDAMUSERCREATED_STATUS_2);

			boolean bindState = false;

			if (state.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_LOGINIDSTATUSSTATEANDIDAMUSERCREATED_STATE_3);
			}
			else {
				bindState = true;

				sb.append(
					_FINDER_COLUMN_LOGINIDSTATUSSTATEANDIDAMUSERCREATED_STATE_2);
			}

			sb.append(
				_FINDER_COLUMN_LOGINIDSTATUSSTATEANDIDAMUSERCREATED_IDAMUSERCREATED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SingleUserOnboardingModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindLoginId) {
					queryPos.add(loginId);
				}

				queryPos.add(status);

				if (bindState) {
					queryPos.add(state);
				}

				queryPos.add(idamUserCreated);

				list = (List<SingleUserOnboarding>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first single user onboarding in the ordered set where loginId = &#63; and status = &#63; and state = &#63; and idamUserCreated = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param state the state
	 * @param idamUserCreated the idam user created
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding
			findByLoginIdStatusStateAndIdamUserCreated_First(
				String loginId, int status, String state,
				boolean idamUserCreated,
				OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		SingleUserOnboarding singleUserOnboarding =
			fetchByLoginIdStatusStateAndIdamUserCreated_First(
				loginId, status, state, idamUserCreated, orderByComparator);

		if (singleUserOnboarding != null) {
			return singleUserOnboarding;
		}

		StringBundler sb = new StringBundler(10);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("loginId=");
		sb.append(loginId);

		sb.append(", status=");
		sb.append(status);

		sb.append(", state=");
		sb.append(state);

		sb.append(", idamUserCreated=");
		sb.append(idamUserCreated);

		sb.append("}");

		throw new NoSuchSingleUserOnboardingException(sb.toString());
	}

	/**
	 * Returns the first single user onboarding in the ordered set where loginId = &#63; and status = &#63; and state = &#63; and idamUserCreated = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param state the state
	 * @param idamUserCreated the idam user created
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding
		fetchByLoginIdStatusStateAndIdamUserCreated_First(
			String loginId, int status, String state, boolean idamUserCreated,
			OrderByComparator<SingleUserOnboarding> orderByComparator) {

		List<SingleUserOnboarding> list =
			findByLoginIdStatusStateAndIdamUserCreated(
				loginId, status, state, idamUserCreated, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last single user onboarding in the ordered set where loginId = &#63; and status = &#63; and state = &#63; and idamUserCreated = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param state the state
	 * @param idamUserCreated the idam user created
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding findByLoginIdStatusStateAndIdamUserCreated_Last(
			String loginId, int status, String state, boolean idamUserCreated,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		SingleUserOnboarding singleUserOnboarding =
			fetchByLoginIdStatusStateAndIdamUserCreated_Last(
				loginId, status, state, idamUserCreated, orderByComparator);

		if (singleUserOnboarding != null) {
			return singleUserOnboarding;
		}

		StringBundler sb = new StringBundler(10);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("loginId=");
		sb.append(loginId);

		sb.append(", status=");
		sb.append(status);

		sb.append(", state=");
		sb.append(state);

		sb.append(", idamUserCreated=");
		sb.append(idamUserCreated);

		sb.append("}");

		throw new NoSuchSingleUserOnboardingException(sb.toString());
	}

	/**
	 * Returns the last single user onboarding in the ordered set where loginId = &#63; and status = &#63; and state = &#63; and idamUserCreated = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param state the state
	 * @param idamUserCreated the idam user created
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	@Override
	public SingleUserOnboarding
		fetchByLoginIdStatusStateAndIdamUserCreated_Last(
			String loginId, int status, String state, boolean idamUserCreated,
			OrderByComparator<SingleUserOnboarding> orderByComparator) {

		int count = countByLoginIdStatusStateAndIdamUserCreated(
			loginId, status, state, idamUserCreated);

		if (count == 0) {
			return null;
		}

		List<SingleUserOnboarding> list =
			findByLoginIdStatusStateAndIdamUserCreated(
				loginId, status, state, idamUserCreated, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the single user onboardings before and after the current single user onboarding in the ordered set where loginId = &#63; and status = &#63; and state = &#63; and idamUserCreated = &#63;.
	 *
	 * @param singleUserRegistrationId the primary key of the current single user onboarding
	 * @param loginId the login ID
	 * @param status the status
	 * @param state the state
	 * @param idamUserCreated the idam user created
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a single user onboarding with the primary key could not be found
	 */
	@Override
	public SingleUserOnboarding[]
			findByLoginIdStatusStateAndIdamUserCreated_PrevAndNext(
				long singleUserRegistrationId, String loginId, int status,
				String state, boolean idamUserCreated,
				OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException {

		loginId = Objects.toString(loginId, "");
		state = Objects.toString(state, "");

		SingleUserOnboarding singleUserOnboarding = findByPrimaryKey(
			singleUserRegistrationId);

		Session session = null;

		try {
			session = openSession();

			SingleUserOnboarding[] array = new SingleUserOnboardingImpl[3];

			array[0] = getByLoginIdStatusStateAndIdamUserCreated_PrevAndNext(
				session, singleUserOnboarding, loginId, status, state,
				idamUserCreated, orderByComparator, true);

			array[1] = singleUserOnboarding;

			array[2] = getByLoginIdStatusStateAndIdamUserCreated_PrevAndNext(
				session, singleUserOnboarding, loginId, status, state,
				idamUserCreated, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SingleUserOnboarding
		getByLoginIdStatusStateAndIdamUserCreated_PrevAndNext(
			Session session, SingleUserOnboarding singleUserOnboarding,
			String loginId, int status, String state, boolean idamUserCreated,
			OrderByComparator<SingleUserOnboarding> orderByComparator,
			boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(6);
		}

		sb.append(_SQL_SELECT_SINGLEUSERONBOARDING_WHERE);

		boolean bindLoginId = false;

		if (loginId.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_LOGINIDSTATUSSTATEANDIDAMUSERCREATED_LOGINID_3);
		}
		else {
			bindLoginId = true;

			sb.append(
				_FINDER_COLUMN_LOGINIDSTATUSSTATEANDIDAMUSERCREATED_LOGINID_2);
		}

		sb.append(_FINDER_COLUMN_LOGINIDSTATUSSTATEANDIDAMUSERCREATED_STATUS_2);

		boolean bindState = false;

		if (state.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_LOGINIDSTATUSSTATEANDIDAMUSERCREATED_STATE_3);
		}
		else {
			bindState = true;

			sb.append(
				_FINDER_COLUMN_LOGINIDSTATUSSTATEANDIDAMUSERCREATED_STATE_2);
		}

		sb.append(
			_FINDER_COLUMN_LOGINIDSTATUSSTATEANDIDAMUSERCREATED_IDAMUSERCREATED_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SingleUserOnboardingModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindLoginId) {
			queryPos.add(loginId);
		}

		queryPos.add(status);

		if (bindState) {
			queryPos.add(state);
		}

		queryPos.add(idamUserCreated);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						singleUserOnboarding)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SingleUserOnboarding> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the single user onboardings where loginId = &#63; and status = &#63; and state = &#63; and idamUserCreated = &#63; from the database.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param state the state
	 * @param idamUserCreated the idam user created
	 */
	@Override
	public void removeByLoginIdStatusStateAndIdamUserCreated(
		String loginId, int status, String state, boolean idamUserCreated) {

		for (SingleUserOnboarding singleUserOnboarding :
				findByLoginIdStatusStateAndIdamUserCreated(
					loginId, status, state, idamUserCreated, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(singleUserOnboarding);
		}
	}

	/**
	 * Returns the number of single user onboardings where loginId = &#63; and status = &#63; and state = &#63; and idamUserCreated = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param state the state
	 * @param idamUserCreated the idam user created
	 * @return the number of matching single user onboardings
	 */
	@Override
	public int countByLoginIdStatusStateAndIdamUserCreated(
		String loginId, int status, String state, boolean idamUserCreated) {

		loginId = Objects.toString(loginId, "");
		state = Objects.toString(state, "");

		FinderPath finderPath =
			_finderPathCountByLoginIdStatusStateAndIdamUserCreated;

		Object[] finderArgs = new Object[] {
			loginId, status, state, idamUserCreated
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_COUNT_SINGLEUSERONBOARDING_WHERE);

			boolean bindLoginId = false;

			if (loginId.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_LOGINIDSTATUSSTATEANDIDAMUSERCREATED_LOGINID_3);
			}
			else {
				bindLoginId = true;

				sb.append(
					_FINDER_COLUMN_LOGINIDSTATUSSTATEANDIDAMUSERCREATED_LOGINID_2);
			}

			sb.append(
				_FINDER_COLUMN_LOGINIDSTATUSSTATEANDIDAMUSERCREATED_STATUS_2);

			boolean bindState = false;

			if (state.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_LOGINIDSTATUSSTATEANDIDAMUSERCREATED_STATE_3);
			}
			else {
				bindState = true;

				sb.append(
					_FINDER_COLUMN_LOGINIDSTATUSSTATEANDIDAMUSERCREATED_STATE_2);
			}

			sb.append(
				_FINDER_COLUMN_LOGINIDSTATUSSTATEANDIDAMUSERCREATED_IDAMUSERCREATED_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindLoginId) {
					queryPos.add(loginId);
				}

				queryPos.add(status);

				if (bindState) {
					queryPos.add(state);
				}

				queryPos.add(idamUserCreated);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_LOGINIDSTATUSSTATEANDIDAMUSERCREATED_LOGINID_2 =
			"singleUserOnboarding.loginId = ? AND ";

	private static final String
		_FINDER_COLUMN_LOGINIDSTATUSSTATEANDIDAMUSERCREATED_LOGINID_3 =
			"(singleUserOnboarding.loginId IS NULL OR singleUserOnboarding.loginId = '') AND ";

	private static final String
		_FINDER_COLUMN_LOGINIDSTATUSSTATEANDIDAMUSERCREATED_STATUS_2 =
			"singleUserOnboarding.status = ? AND ";

	private static final String
		_FINDER_COLUMN_LOGINIDSTATUSSTATEANDIDAMUSERCREATED_STATE_2 =
			"singleUserOnboarding.state = ? AND ";

	private static final String
		_FINDER_COLUMN_LOGINIDSTATUSSTATEANDIDAMUSERCREATED_STATE_3 =
			"(singleUserOnboarding.state IS NULL OR singleUserOnboarding.state = '') AND ";

	private static final String
		_FINDER_COLUMN_LOGINIDSTATUSSTATEANDIDAMUSERCREATED_IDAMUSERCREATED_2 =
			"singleUserOnboarding.idamUserCreated = ?";

	public SingleUserOnboardingPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("state", "state_");
		dbColumnNames.put("rank", "rank_");

		setDBColumnNames(dbColumnNames);

		setModelClass(SingleUserOnboarding.class);

		setModelImplClass(SingleUserOnboardingImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the single user onboarding in the entity cache if it is enabled.
	 *
	 * @param singleUserOnboarding the single user onboarding
	 */
	@Override
	public void cacheResult(SingleUserOnboarding singleUserOnboarding) {
		entityCache.putResult(
			SingleUserOnboardingImpl.class,
			singleUserOnboarding.getPrimaryKey(), singleUserOnboarding);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				singleUserOnboarding.getUuid(),
				singleUserOnboarding.getGroupId()
			},
			singleUserOnboarding);
	}

	/**
	 * Caches the single user onboardings in the entity cache if it is enabled.
	 *
	 * @param singleUserOnboardings the single user onboardings
	 */
	@Override
	public void cacheResult(List<SingleUserOnboarding> singleUserOnboardings) {
		for (SingleUserOnboarding singleUserOnboarding :
				singleUserOnboardings) {

			if (entityCache.getResult(
					SingleUserOnboardingImpl.class,
					singleUserOnboarding.getPrimaryKey()) == null) {

				cacheResult(singleUserOnboarding);
			}
		}
	}

	/**
	 * Clears the cache for all single user onboardings.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SingleUserOnboardingImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the single user onboarding.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SingleUserOnboarding singleUserOnboarding) {
		entityCache.removeResult(
			SingleUserOnboardingImpl.class, singleUserOnboarding);
	}

	@Override
	public void clearCache(List<SingleUserOnboarding> singleUserOnboardings) {
		for (SingleUserOnboarding singleUserOnboarding :
				singleUserOnboardings) {

			entityCache.removeResult(
				SingleUserOnboardingImpl.class, singleUserOnboarding);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				SingleUserOnboardingImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		SingleUserOnboardingModelImpl singleUserOnboardingModelImpl) {

		Object[] args = new Object[] {
			singleUserOnboardingModelImpl.getUuid(),
			singleUserOnboardingModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, singleUserOnboardingModelImpl,
			false);
	}

	/**
	 * Creates a new single user onboarding with the primary key. Does not add the single user onboarding to the database.
	 *
	 * @param singleUserRegistrationId the primary key for the new single user onboarding
	 * @return the new single user onboarding
	 */
	@Override
	public SingleUserOnboarding create(long singleUserRegistrationId) {
		SingleUserOnboarding singleUserOnboarding =
			new SingleUserOnboardingImpl();

		singleUserOnboarding.setNew(true);
		singleUserOnboarding.setPrimaryKey(singleUserRegistrationId);

		String uuid = PortalUUIDUtil.generate();

		singleUserOnboarding.setUuid(uuid);

		singleUserOnboarding.setCompanyId(CompanyThreadLocal.getCompanyId());

		return singleUserOnboarding;
	}

	/**
	 * Removes the single user onboarding with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param singleUserRegistrationId the primary key of the single user onboarding
	 * @return the single user onboarding that was removed
	 * @throws NoSuchSingleUserOnboardingException if a single user onboarding with the primary key could not be found
	 */
	@Override
	public SingleUserOnboarding remove(long singleUserRegistrationId)
		throws NoSuchSingleUserOnboardingException {

		return remove((Serializable)singleUserRegistrationId);
	}

	/**
	 * Removes the single user onboarding with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the single user onboarding
	 * @return the single user onboarding that was removed
	 * @throws NoSuchSingleUserOnboardingException if a single user onboarding with the primary key could not be found
	 */
	@Override
	public SingleUserOnboarding remove(Serializable primaryKey)
		throws NoSuchSingleUserOnboardingException {

		Session session = null;

		try {
			session = openSession();

			SingleUserOnboarding singleUserOnboarding =
				(SingleUserOnboarding)session.get(
					SingleUserOnboardingImpl.class, primaryKey);

			if (singleUserOnboarding == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSingleUserOnboardingException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(singleUserOnboarding);
		}
		catch (NoSuchSingleUserOnboardingException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected SingleUserOnboarding removeImpl(
		SingleUserOnboarding singleUserOnboarding) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(singleUserOnboarding)) {
				singleUserOnboarding = (SingleUserOnboarding)session.get(
					SingleUserOnboardingImpl.class,
					singleUserOnboarding.getPrimaryKeyObj());
			}

			if (singleUserOnboarding != null) {
				session.delete(singleUserOnboarding);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (singleUserOnboarding != null) {
			clearCache(singleUserOnboarding);
		}

		return singleUserOnboarding;
	}

	@Override
	public SingleUserOnboarding updateImpl(
		SingleUserOnboarding singleUserOnboarding) {

		boolean isNew = singleUserOnboarding.isNew();

		if (!(singleUserOnboarding instanceof SingleUserOnboardingModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(singleUserOnboarding.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					singleUserOnboarding);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in singleUserOnboarding proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SingleUserOnboarding implementation " +
					singleUserOnboarding.getClass());
		}

		SingleUserOnboardingModelImpl singleUserOnboardingModelImpl =
			(SingleUserOnboardingModelImpl)singleUserOnboarding;

		if (Validator.isNull(singleUserOnboarding.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			singleUserOnboarding.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (singleUserOnboarding.getCreateDate() == null)) {
			if (serviceContext == null) {
				singleUserOnboarding.setCreateDate(now);
			}
			else {
				singleUserOnboarding.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!singleUserOnboardingModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				singleUserOnboarding.setModifiedDate(now);
			}
			else {
				singleUserOnboarding.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(singleUserOnboarding);
			}
			else {
				singleUserOnboarding = (SingleUserOnboarding)session.merge(
					singleUserOnboarding);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			SingleUserOnboardingImpl.class, singleUserOnboardingModelImpl,
			false, true);

		cacheUniqueFindersCache(singleUserOnboardingModelImpl);

		if (isNew) {
			singleUserOnboarding.setNew(false);
		}

		singleUserOnboarding.resetOriginalValues();

		return singleUserOnboarding;
	}

	/**
	 * Returns the single user onboarding with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the single user onboarding
	 * @return the single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a single user onboarding with the primary key could not be found
	 */
	@Override
	public SingleUserOnboarding findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSingleUserOnboardingException {

		SingleUserOnboarding singleUserOnboarding = fetchByPrimaryKey(
			primaryKey);

		if (singleUserOnboarding == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSingleUserOnboardingException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return singleUserOnboarding;
	}

	/**
	 * Returns the single user onboarding with the primary key or throws a <code>NoSuchSingleUserOnboardingException</code> if it could not be found.
	 *
	 * @param singleUserRegistrationId the primary key of the single user onboarding
	 * @return the single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a single user onboarding with the primary key could not be found
	 */
	@Override
	public SingleUserOnboarding findByPrimaryKey(long singleUserRegistrationId)
		throws NoSuchSingleUserOnboardingException {

		return findByPrimaryKey((Serializable)singleUserRegistrationId);
	}

	/**
	 * Returns the single user onboarding with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param singleUserRegistrationId the primary key of the single user onboarding
	 * @return the single user onboarding, or <code>null</code> if a single user onboarding with the primary key could not be found
	 */
	@Override
	public SingleUserOnboarding fetchByPrimaryKey(
		long singleUserRegistrationId) {

		return fetchByPrimaryKey((Serializable)singleUserRegistrationId);
	}

	/**
	 * Returns all the single user onboardings.
	 *
	 * @return the single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the single user onboardings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @return the range of single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the single user onboardings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findAll(
		int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the single user onboardings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of single user onboardings
	 */
	@Override
	public List<SingleUserOnboarding> findAll(
		int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<SingleUserOnboarding> list = null;

		if (useFinderCache) {
			list = (List<SingleUserOnboarding>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SINGLEUSERONBOARDING);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SINGLEUSERONBOARDING;

				sql = sql.concat(SingleUserOnboardingModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SingleUserOnboarding>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the single user onboardings from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SingleUserOnboarding singleUserOnboarding : findAll()) {
			remove(singleUserOnboarding);
		}
	}

	/**
	 * Returns the number of single user onboardings.
	 *
	 * @return the number of single user onboardings
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_SINGLEUSERONBOARDING);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "singleUserRegistrationId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SINGLEUSERONBOARDING;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SingleUserOnboardingModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the single user onboarding persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new SingleUserOnboardingModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", SingleUserOnboarding.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByUUID_G = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByUuid_C = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathWithPaginationFindByStatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"status"}, true);

		_finderPathWithoutPaginationFindByStatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] {Integer.class.getName()}, new String[] {"status"},
			true);

		_finderPathCountByStatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] {Integer.class.getName()}, new String[] {"status"},
			false);

		_finderPathWithPaginationFindByUnitId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUnitId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"unitId"}, true);

		_finderPathWithoutPaginationFindByUnitId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUnitId",
			new String[] {Long.class.getName()}, new String[] {"unitId"}, true);

		_finderPathCountByUnitId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUnitId",
			new String[] {Long.class.getName()}, new String[] {"unitId"},
			false);

		_finderPathWithPaginationFindByUnitIdAndStatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUnitIdAndStatus",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"unitId", "status"}, true);

		_finderPathWithoutPaginationFindByUnitIdAndStatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUnitIdAndStatus",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"unitId", "status"}, true);

		_finderPathCountByUnitIdAndStatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUnitIdAndStatus",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"unitId", "status"}, false);

		_finderPathWithPaginationFindByUnitIdsAndStatusList = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUnitIdsAndStatusList",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"unitId", "status"}, true);

		_finderPathWithoutPaginationFindByUnitIdsAndStatusList =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByUnitIdsAndStatusList",
				new String[] {Long.class.getName(), Integer.class.getName()},
				new String[] {"unitId", "status"}, true);

		_finderPathCountByUnitIdsAndStatusList = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUnitIdsAndStatusList",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"unitId", "status"}, false);

		_finderPathWithPaginationCountByUnitIdsAndStatusList =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"countByUnitIdsAndStatusList",
				new String[] {Long.class.getName(), Integer.class.getName()},
				new String[] {"unitId", "status"}, false);

		_finderPathWithPaginationFindByUnitIdAndState = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUnitIdAndState",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"unitId", "state_"}, true);

		_finderPathWithoutPaginationFindByUnitIdAndState = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUnitIdAndState",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"unitId", "state_"}, true);

		_finderPathCountByUnitIdAndState = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUnitIdAndState",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"unitId", "state_"}, false);

		_finderPathWithPaginationFindByUnit = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUnit",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"unit"}, true);

		_finderPathWithoutPaginationFindByUnit = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUnit",
			new String[] {String.class.getName()}, new String[] {"unit"}, true);

		_finderPathCountByUnit = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUnit",
			new String[] {String.class.getName()}, new String[] {"unit"},
			false);

		_finderPathWithPaginationFindByUnitAndStatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUnitAndStatus",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"unit", "status"}, true);

		_finderPathWithoutPaginationFindByUnitAndStatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUnitAndStatus",
			new String[] {String.class.getName(), Integer.class.getName()},
			new String[] {"unit", "status"}, true);

		_finderPathCountByUnitAndStatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUnitAndStatus",
			new String[] {String.class.getName(), Integer.class.getName()},
			new String[] {"unit", "status"}, false);

		_finderPathWithPaginationFindByUnitAndState = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUnitAndState",
			new String[] {
				String.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"unit", "state_"}, true);

		_finderPathWithoutPaginationFindByUnitAndState = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUnitAndState",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"unit", "state_"}, true);

		_finderPathCountByUnitAndState = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUnitAndState",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"unit", "state_"}, false);

		_finderPathWithPaginationFindByG_S = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_S",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"groupId", "status"}, true);

		_finderPathWithoutPaginationFindByG_S = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_S",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"groupId", "status"}, true);

		_finderPathCountByG_S = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_S",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"groupId", "status"}, false);

		_finderPathWithPaginationFindBySectionAndStatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySectionAndStatus",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"sectionId", "status"}, true);

		_finderPathWithoutPaginationFindBySectionAndStatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySectionAndStatus",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"sectionId", "status"}, true);

		_finderPathCountBySectionAndStatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySectionAndStatus",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"sectionId", "status"}, false);

		_finderPathWithPaginationFindByGroupId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"groupId"}, true);

		_finderPathWithoutPaginationFindByGroupId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()}, new String[] {"groupId"},
			true);

		_finderPathCountByGroupId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()}, new String[] {"groupId"},
			false);

		_finderPathWithPaginationFindByUserId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"userId"}, true);

		_finderPathWithoutPaginationFindByUserId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] {Long.class.getName()}, new String[] {"userId"}, true);

		_finderPathCountByUserId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] {Long.class.getName()}, new String[] {"userId"},
			false);

		_finderPathWithPaginationFindByPersonalNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPersonalNo",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"personalNo"}, true);

		_finderPathWithoutPaginationFindByPersonalNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPersonalNo",
			new String[] {Long.class.getName()}, new String[] {"personalNo"},
			true);

		_finderPathCountByPersonalNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPersonalNo",
			new String[] {Long.class.getName()}, new String[] {"personalNo"},
			false);

		_finderPathWithPaginationFindByRecordNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRecordNo",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"recordNo"}, true);

		_finderPathWithoutPaginationFindByRecordNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRecordNo",
			new String[] {Long.class.getName()}, new String[] {"recordNo"},
			true);

		_finderPathCountByRecordNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRecordNo",
			new String[] {Long.class.getName()}, new String[] {"recordNo"},
			false);

		_finderPathWithPaginationFindByEmailAddress = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEmailAddress",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"emailAddress"}, true);

		_finderPathWithoutPaginationFindByEmailAddress = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEmailAddress",
			new String[] {String.class.getName()},
			new String[] {"emailAddress"}, true);

		_finderPathCountByEmailAddress = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmailAddress",
			new String[] {String.class.getName()},
			new String[] {"emailAddress"}, false);

		_finderPathWithPaginationFindByLoginIdAndStatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLoginIdAndStatus",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"loginId", "status"}, true);

		_finderPathWithoutPaginationFindByLoginIdAndStatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLoginIdAndStatus",
			new String[] {String.class.getName(), Integer.class.getName()},
			new String[] {"loginId", "status"}, true);

		_finderPathCountByLoginIdAndStatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByLoginIdAndStatus",
			new String[] {String.class.getName(), Integer.class.getName()},
			new String[] {"loginId", "status"}, false);

		_finderPathWithPaginationFindByLoginIdStatusStateAndIdamUserCreated =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByLoginIdStatusStateAndIdamUserCreated",
				new String[] {
					String.class.getName(), Integer.class.getName(),
					String.class.getName(), Boolean.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {"loginId", "status", "state_", "idamUserCreated"},
				true);

		_finderPathWithoutPaginationFindByLoginIdStatusStateAndIdamUserCreated =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByLoginIdStatusStateAndIdamUserCreated",
				new String[] {
					String.class.getName(), Integer.class.getName(),
					String.class.getName(), Boolean.class.getName()
				},
				new String[] {"loginId", "status", "state_", "idamUserCreated"},
				true);

		_finderPathCountByLoginIdStatusStateAndIdamUserCreated =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"countByLoginIdStatusStateAndIdamUserCreated",
				new String[] {
					String.class.getName(), Integer.class.getName(),
					String.class.getName(), Boolean.class.getName()
				},
				new String[] {"loginId", "status", "state_", "idamUserCreated"},
				false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(SingleUserOnboardingImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	@Override
	@Reference(
		target = pisPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = pisPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = pisPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private BundleContext _bundleContext;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_SINGLEUSERONBOARDING =
		"SELECT singleUserOnboarding FROM SingleUserOnboarding singleUserOnboarding";

	private static final String _SQL_SELECT_SINGLEUSERONBOARDING_WHERE =
		"SELECT singleUserOnboarding FROM SingleUserOnboarding singleUserOnboarding WHERE ";

	private static final String _SQL_COUNT_SINGLEUSERONBOARDING =
		"SELECT COUNT(singleUserOnboarding) FROM SingleUserOnboarding singleUserOnboarding";

	private static final String _SQL_COUNT_SINGLEUSERONBOARDING_WHERE =
		"SELECT COUNT(singleUserOnboarding) FROM SingleUserOnboarding singleUserOnboarding WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"singleUserOnboarding.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SingleUserOnboarding exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No SingleUserOnboarding exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SingleUserOnboardingPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "state", "rank"});

	private FinderPath _createFinderPath(
		String cacheName, String methodName, String[] params,
		String[] columnNames, boolean baseModelResult) {

		FinderPath finderPath = new FinderPath(
			cacheName, methodName, params, columnNames, baseModelResult);

		if (!cacheName.equals(FINDER_CLASS_NAME_LIST_WITH_PAGINATION)) {
			_serviceRegistrations.add(
				_bundleContext.registerService(
					FinderPath.class, finderPath,
					MapUtil.singletonDictionary("cache.name", cacheName)));
		}

		return finderPath;
	}

	private Set<ServiceRegistration<FinderPath>> _serviceRegistrations =
		new HashSet<>();
	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class SingleUserOnboardingModelArgumentsResolver
		implements ArgumentsResolver {

		@Override
		public Object[] getArguments(
			FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
			boolean original) {

			String[] columnNames = finderPath.getColumnNames();

			if ((columnNames == null) || (columnNames.length == 0)) {
				if (baseModel.isNew()) {
					return FINDER_ARGS_EMPTY;
				}

				return null;
			}

			SingleUserOnboardingModelImpl singleUserOnboardingModelImpl =
				(SingleUserOnboardingModelImpl)baseModel;

			long columnBitmask =
				singleUserOnboardingModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					singleUserOnboardingModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						singleUserOnboardingModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					singleUserOnboardingModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			SingleUserOnboardingModelImpl singleUserOnboardingModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						singleUserOnboardingModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = singleUserOnboardingModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}