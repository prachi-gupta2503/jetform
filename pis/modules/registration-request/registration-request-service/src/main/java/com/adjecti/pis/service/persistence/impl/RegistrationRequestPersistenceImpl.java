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

package com.adjecti.pis.service.persistence.impl;

import com.adjecti.pis.exception.NoSuchRegistrationRequestException;
import com.adjecti.pis.model.RegistrationRequest;
import com.adjecti.pis.model.impl.RegistrationRequestImpl;
import com.adjecti.pis.model.impl.RegistrationRequestModelImpl;
import com.adjecti.pis.service.persistence.RegistrationRequestPersistence;
import com.adjecti.pis.service.persistence.impl.constants.OFBPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.security.permission.InlineSQLHelperUtil;
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
 * The persistence implementation for the registration request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = RegistrationRequestPersistence.class)
public class RegistrationRequestPersistenceImpl
	extends BasePersistenceImpl<RegistrationRequest>
	implements RegistrationRequestPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RegistrationRequestUtil</code> to access the registration request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RegistrationRequestImpl.class.getName();

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
	 * Returns all the registration requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the registration requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @return the range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the registration requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the registration requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator,
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

		List<RegistrationRequest> list = null;

		if (useFinderCache) {
			list = (List<RegistrationRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RegistrationRequest registrationRequest : list) {
					if (!uuid.equals(registrationRequest.getUuid())) {
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

			sb.append(_SQL_SELECT_REGISTRATIONREQUEST_WHERE);

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
				sb.append(RegistrationRequestModelImpl.ORDER_BY_JPQL);
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

				list = (List<RegistrationRequest>)QueryUtil.list(
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
	 * Returns the first registration request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest findByUuid_First(
			String uuid,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		RegistrationRequest registrationRequest = fetchByUuid_First(
			uuid, orderByComparator);

		if (registrationRequest != null) {
			return registrationRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchRegistrationRequestException(sb.toString());
	}

	/**
	 * Returns the first registration request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest fetchByUuid_First(
		String uuid, OrderByComparator<RegistrationRequest> orderByComparator) {

		List<RegistrationRequest> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last registration request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest findByUuid_Last(
			String uuid,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		RegistrationRequest registrationRequest = fetchByUuid_Last(
			uuid, orderByComparator);

		if (registrationRequest != null) {
			return registrationRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchRegistrationRequestException(sb.toString());
	}

	/**
	 * Returns the last registration request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest fetchByUuid_Last(
		String uuid, OrderByComparator<RegistrationRequest> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<RegistrationRequest> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the registration requests before and after the current registration request in the ordered set where uuid = &#63;.
	 *
	 * @param registrationRequestId the primary key of the current registration request
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	@Override
	public RegistrationRequest[] findByUuid_PrevAndNext(
			long registrationRequestId, String uuid,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		uuid = Objects.toString(uuid, "");

		RegistrationRequest registrationRequest = findByPrimaryKey(
			registrationRequestId);

		Session session = null;

		try {
			session = openSession();

			RegistrationRequest[] array = new RegistrationRequestImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, registrationRequest, uuid, orderByComparator, true);

			array[1] = registrationRequest;

			array[2] = getByUuid_PrevAndNext(
				session, registrationRequest, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected RegistrationRequest getByUuid_PrevAndNext(
		Session session, RegistrationRequest registrationRequest, String uuid,
		OrderByComparator<RegistrationRequest> orderByComparator,
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

		sb.append(_SQL_SELECT_REGISTRATIONREQUEST_WHERE);

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
			sb.append(RegistrationRequestModelImpl.ORDER_BY_JPQL);
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
						registrationRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RegistrationRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the registration requests where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (RegistrationRequest registrationRequest :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(registrationRequest);
		}
	}

	/**
	 * Returns the number of registration requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching registration requests
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_REGISTRATIONREQUEST_WHERE);

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
		"registrationRequest.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(registrationRequest.uuid IS NULL OR registrationRequest.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the registration request where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchRegistrationRequestException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest findByUUID_G(String uuid, long groupId)
		throws NoSuchRegistrationRequestException {

		RegistrationRequest registrationRequest = fetchByUUID_G(uuid, groupId);

		if (registrationRequest == null) {
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

			throw new NoSuchRegistrationRequestException(sb.toString());
		}

		return registrationRequest;
	}

	/**
	 * Returns the registration request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the registration request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest fetchByUUID_G(
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

		if (result instanceof RegistrationRequest) {
			RegistrationRequest registrationRequest =
				(RegistrationRequest)result;

			if (!Objects.equals(uuid, registrationRequest.getUuid()) ||
				(groupId != registrationRequest.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_REGISTRATIONREQUEST_WHERE);

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

				List<RegistrationRequest> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					RegistrationRequest registrationRequest = list.get(0);

					result = registrationRequest;

					cacheResult(registrationRequest);
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
			return (RegistrationRequest)result;
		}
	}

	/**
	 * Removes the registration request where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the registration request that was removed
	 */
	@Override
	public RegistrationRequest removeByUUID_G(String uuid, long groupId)
		throws NoSuchRegistrationRequestException {

		RegistrationRequest registrationRequest = findByUUID_G(uuid, groupId);

		return remove(registrationRequest);
	}

	/**
	 * Returns the number of registration requests where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching registration requests
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_REGISTRATIONREQUEST_WHERE);

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
		"registrationRequest.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(registrationRequest.uuid IS NULL OR registrationRequest.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"registrationRequest.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the registration requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the registration requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @return the range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the registration requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the registration requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator,
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

		List<RegistrationRequest> list = null;

		if (useFinderCache) {
			list = (List<RegistrationRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RegistrationRequest registrationRequest : list) {
					if (!uuid.equals(registrationRequest.getUuid()) ||
						(companyId != registrationRequest.getCompanyId())) {

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

			sb.append(_SQL_SELECT_REGISTRATIONREQUEST_WHERE);

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
				sb.append(RegistrationRequestModelImpl.ORDER_BY_JPQL);
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

				list = (List<RegistrationRequest>)QueryUtil.list(
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
	 * Returns the first registration request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		RegistrationRequest registrationRequest = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (registrationRequest != null) {
			return registrationRequest;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchRegistrationRequestException(sb.toString());
	}

	/**
	 * Returns the first registration request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		List<RegistrationRequest> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last registration request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		RegistrationRequest registrationRequest = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (registrationRequest != null) {
			return registrationRequest;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchRegistrationRequestException(sb.toString());
	}

	/**
	 * Returns the last registration request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<RegistrationRequest> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the registration requests before and after the current registration request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param registrationRequestId the primary key of the current registration request
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	@Override
	public RegistrationRequest[] findByUuid_C_PrevAndNext(
			long registrationRequestId, String uuid, long companyId,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		uuid = Objects.toString(uuid, "");

		RegistrationRequest registrationRequest = findByPrimaryKey(
			registrationRequestId);

		Session session = null;

		try {
			session = openSession();

			RegistrationRequest[] array = new RegistrationRequestImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, registrationRequest, uuid, companyId,
				orderByComparator, true);

			array[1] = registrationRequest;

			array[2] = getByUuid_C_PrevAndNext(
				session, registrationRequest, uuid, companyId,
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

	protected RegistrationRequest getByUuid_C_PrevAndNext(
		Session session, RegistrationRequest registrationRequest, String uuid,
		long companyId,
		OrderByComparator<RegistrationRequest> orderByComparator,
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

		sb.append(_SQL_SELECT_REGISTRATIONREQUEST_WHERE);

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
			sb.append(RegistrationRequestModelImpl.ORDER_BY_JPQL);
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
						registrationRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RegistrationRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the registration requests where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (RegistrationRequest registrationRequest :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(registrationRequest);
		}
	}

	/**
	 * Returns the number of registration requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching registration requests
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_REGISTRATIONREQUEST_WHERE);

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
		"registrationRequest.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(registrationRequest.uuid IS NULL OR registrationRequest.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"registrationRequest.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByBulkOnbordingFileId;
	private FinderPath _finderPathWithoutPaginationFindByBulkOnbordingFileId;
	private FinderPath _finderPathCountByBulkOnbordingFileId;

	/**
	 * Returns all the registration requests where bulkOnbordingFileId = &#63;.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @return the matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByBulkOnbordingFileId(
		long bulkOnbordingFileId) {

		return findByBulkOnbordingFileId(
			bulkOnbordingFileId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the registration requests where bulkOnbordingFileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @return the range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByBulkOnbordingFileId(
		long bulkOnbordingFileId, int start, int end) {

		return findByBulkOnbordingFileId(bulkOnbordingFileId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the registration requests where bulkOnbordingFileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByBulkOnbordingFileId(
		long bulkOnbordingFileId, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return findByBulkOnbordingFileId(
			bulkOnbordingFileId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the registration requests where bulkOnbordingFileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByBulkOnbordingFileId(
		long bulkOnbordingFileId, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByBulkOnbordingFileId;
				finderArgs = new Object[] {bulkOnbordingFileId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByBulkOnbordingFileId;
			finderArgs = new Object[] {
				bulkOnbordingFileId, start, end, orderByComparator
			};
		}

		List<RegistrationRequest> list = null;

		if (useFinderCache) {
			list = (List<RegistrationRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RegistrationRequest registrationRequest : list) {
					if (bulkOnbordingFileId !=
							registrationRequest.getBulkOnbordingFileId()) {

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

			sb.append(_SQL_SELECT_REGISTRATIONREQUEST_WHERE);

			sb.append(_FINDER_COLUMN_BULKONBORDINGFILEID_BULKONBORDINGFILEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RegistrationRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(bulkOnbordingFileId);

				list = (List<RegistrationRequest>)QueryUtil.list(
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
	 * Returns the first registration request in the ordered set where bulkOnbordingFileId = &#63;.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest findByBulkOnbordingFileId_First(
			long bulkOnbordingFileId,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		RegistrationRequest registrationRequest =
			fetchByBulkOnbordingFileId_First(
				bulkOnbordingFileId, orderByComparator);

		if (registrationRequest != null) {
			return registrationRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("bulkOnbordingFileId=");
		sb.append(bulkOnbordingFileId);

		sb.append("}");

		throw new NoSuchRegistrationRequestException(sb.toString());
	}

	/**
	 * Returns the first registration request in the ordered set where bulkOnbordingFileId = &#63;.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest fetchByBulkOnbordingFileId_First(
		long bulkOnbordingFileId,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		List<RegistrationRequest> list = findByBulkOnbordingFileId(
			bulkOnbordingFileId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last registration request in the ordered set where bulkOnbordingFileId = &#63;.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest findByBulkOnbordingFileId_Last(
			long bulkOnbordingFileId,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		RegistrationRequest registrationRequest =
			fetchByBulkOnbordingFileId_Last(
				bulkOnbordingFileId, orderByComparator);

		if (registrationRequest != null) {
			return registrationRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("bulkOnbordingFileId=");
		sb.append(bulkOnbordingFileId);

		sb.append("}");

		throw new NoSuchRegistrationRequestException(sb.toString());
	}

	/**
	 * Returns the last registration request in the ordered set where bulkOnbordingFileId = &#63;.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest fetchByBulkOnbordingFileId_Last(
		long bulkOnbordingFileId,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		int count = countByBulkOnbordingFileId(bulkOnbordingFileId);

		if (count == 0) {
			return null;
		}

		List<RegistrationRequest> list = findByBulkOnbordingFileId(
			bulkOnbordingFileId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the registration requests before and after the current registration request in the ordered set where bulkOnbordingFileId = &#63;.
	 *
	 * @param registrationRequestId the primary key of the current registration request
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	@Override
	public RegistrationRequest[] findByBulkOnbordingFileId_PrevAndNext(
			long registrationRequestId, long bulkOnbordingFileId,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		RegistrationRequest registrationRequest = findByPrimaryKey(
			registrationRequestId);

		Session session = null;

		try {
			session = openSession();

			RegistrationRequest[] array = new RegistrationRequestImpl[3];

			array[0] = getByBulkOnbordingFileId_PrevAndNext(
				session, registrationRequest, bulkOnbordingFileId,
				orderByComparator, true);

			array[1] = registrationRequest;

			array[2] = getByBulkOnbordingFileId_PrevAndNext(
				session, registrationRequest, bulkOnbordingFileId,
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

	protected RegistrationRequest getByBulkOnbordingFileId_PrevAndNext(
		Session session, RegistrationRequest registrationRequest,
		long bulkOnbordingFileId,
		OrderByComparator<RegistrationRequest> orderByComparator,
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

		sb.append(_SQL_SELECT_REGISTRATIONREQUEST_WHERE);

		sb.append(_FINDER_COLUMN_BULKONBORDINGFILEID_BULKONBORDINGFILEID_2);

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
			sb.append(RegistrationRequestModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(bulkOnbordingFileId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						registrationRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RegistrationRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the registration requests where bulkOnbordingFileId = &#63; from the database.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 */
	@Override
	public void removeByBulkOnbordingFileId(long bulkOnbordingFileId) {
		for (RegistrationRequest registrationRequest :
				findByBulkOnbordingFileId(
					bulkOnbordingFileId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(registrationRequest);
		}
	}

	/**
	 * Returns the number of registration requests where bulkOnbordingFileId = &#63;.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @return the number of matching registration requests
	 */
	@Override
	public int countByBulkOnbordingFileId(long bulkOnbordingFileId) {
		FinderPath finderPath = _finderPathCountByBulkOnbordingFileId;

		Object[] finderArgs = new Object[] {bulkOnbordingFileId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_REGISTRATIONREQUEST_WHERE);

			sb.append(_FINDER_COLUMN_BULKONBORDINGFILEID_BULKONBORDINGFILEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(bulkOnbordingFileId);

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
		_FINDER_COLUMN_BULKONBORDINGFILEID_BULKONBORDINGFILEID_2 =
			"registrationRequest.bulkOnbordingFileId = ?";

	private FinderPath
		_finderPathWithPaginationFindByBulkOnbordingFileIdAndStatus;
	private FinderPath
		_finderPathWithoutPaginationFindByBulkOnbordingFileIdAndStatus;
	private FinderPath _finderPathCountByBulkOnbordingFileIdAndStatus;

	/**
	 * Returns all the registration requests where bulkOnbordingFileId = &#63; and status = &#63;.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param status the status
	 * @return the matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByBulkOnbordingFileIdAndStatus(
		long bulkOnbordingFileId, int status) {

		return findByBulkOnbordingFileIdAndStatus(
			bulkOnbordingFileId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the registration requests where bulkOnbordingFileId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param status the status
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @return the range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByBulkOnbordingFileIdAndStatus(
		long bulkOnbordingFileId, int status, int start, int end) {

		return findByBulkOnbordingFileIdAndStatus(
			bulkOnbordingFileId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the registration requests where bulkOnbordingFileId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param status the status
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByBulkOnbordingFileIdAndStatus(
		long bulkOnbordingFileId, int status, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return findByBulkOnbordingFileIdAndStatus(
			bulkOnbordingFileId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the registration requests where bulkOnbordingFileId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param status the status
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByBulkOnbordingFileIdAndStatus(
		long bulkOnbordingFileId, int status, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByBulkOnbordingFileIdAndStatus;
				finderArgs = new Object[] {bulkOnbordingFileId, status};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByBulkOnbordingFileIdAndStatus;
			finderArgs = new Object[] {
				bulkOnbordingFileId, status, start, end, orderByComparator
			};
		}

		List<RegistrationRequest> list = null;

		if (useFinderCache) {
			list = (List<RegistrationRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RegistrationRequest registrationRequest : list) {
					if ((bulkOnbordingFileId !=
							registrationRequest.getBulkOnbordingFileId()) ||
						(status != registrationRequest.getStatus())) {

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

			sb.append(_SQL_SELECT_REGISTRATIONREQUEST_WHERE);

			sb.append(
				_FINDER_COLUMN_BULKONBORDINGFILEIDANDSTATUS_BULKONBORDINGFILEID_2);

			sb.append(_FINDER_COLUMN_BULKONBORDINGFILEIDANDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RegistrationRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(bulkOnbordingFileId);

				queryPos.add(status);

				list = (List<RegistrationRequest>)QueryUtil.list(
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
	 * Returns the first registration request in the ordered set where bulkOnbordingFileId = &#63; and status = &#63;.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest findByBulkOnbordingFileIdAndStatus_First(
			long bulkOnbordingFileId, int status,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		RegistrationRequest registrationRequest =
			fetchByBulkOnbordingFileIdAndStatus_First(
				bulkOnbordingFileId, status, orderByComparator);

		if (registrationRequest != null) {
			return registrationRequest;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("bulkOnbordingFileId=");
		sb.append(bulkOnbordingFileId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchRegistrationRequestException(sb.toString());
	}

	/**
	 * Returns the first registration request in the ordered set where bulkOnbordingFileId = &#63; and status = &#63;.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest fetchByBulkOnbordingFileIdAndStatus_First(
		long bulkOnbordingFileId, int status,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		List<RegistrationRequest> list = findByBulkOnbordingFileIdAndStatus(
			bulkOnbordingFileId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last registration request in the ordered set where bulkOnbordingFileId = &#63; and status = &#63;.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest findByBulkOnbordingFileIdAndStatus_Last(
			long bulkOnbordingFileId, int status,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		RegistrationRequest registrationRequest =
			fetchByBulkOnbordingFileIdAndStatus_Last(
				bulkOnbordingFileId, status, orderByComparator);

		if (registrationRequest != null) {
			return registrationRequest;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("bulkOnbordingFileId=");
		sb.append(bulkOnbordingFileId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchRegistrationRequestException(sb.toString());
	}

	/**
	 * Returns the last registration request in the ordered set where bulkOnbordingFileId = &#63; and status = &#63;.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest fetchByBulkOnbordingFileIdAndStatus_Last(
		long bulkOnbordingFileId, int status,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		int count = countByBulkOnbordingFileIdAndStatus(
			bulkOnbordingFileId, status);

		if (count == 0) {
			return null;
		}

		List<RegistrationRequest> list = findByBulkOnbordingFileIdAndStatus(
			bulkOnbordingFileId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the registration requests before and after the current registration request in the ordered set where bulkOnbordingFileId = &#63; and status = &#63;.
	 *
	 * @param registrationRequestId the primary key of the current registration request
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	@Override
	public RegistrationRequest[] findByBulkOnbordingFileIdAndStatus_PrevAndNext(
			long registrationRequestId, long bulkOnbordingFileId, int status,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		RegistrationRequest registrationRequest = findByPrimaryKey(
			registrationRequestId);

		Session session = null;

		try {
			session = openSession();

			RegistrationRequest[] array = new RegistrationRequestImpl[3];

			array[0] = getByBulkOnbordingFileIdAndStatus_PrevAndNext(
				session, registrationRequest, bulkOnbordingFileId, status,
				orderByComparator, true);

			array[1] = registrationRequest;

			array[2] = getByBulkOnbordingFileIdAndStatus_PrevAndNext(
				session, registrationRequest, bulkOnbordingFileId, status,
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

	protected RegistrationRequest getByBulkOnbordingFileIdAndStatus_PrevAndNext(
		Session session, RegistrationRequest registrationRequest,
		long bulkOnbordingFileId, int status,
		OrderByComparator<RegistrationRequest> orderByComparator,
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

		sb.append(_SQL_SELECT_REGISTRATIONREQUEST_WHERE);

		sb.append(
			_FINDER_COLUMN_BULKONBORDINGFILEIDANDSTATUS_BULKONBORDINGFILEID_2);

		sb.append(_FINDER_COLUMN_BULKONBORDINGFILEIDANDSTATUS_STATUS_2);

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
			sb.append(RegistrationRequestModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(bulkOnbordingFileId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						registrationRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RegistrationRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the registration requests where bulkOnbordingFileId = &#63; and status = &#63; from the database.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param status the status
	 */
	@Override
	public void removeByBulkOnbordingFileIdAndStatus(
		long bulkOnbordingFileId, int status) {

		for (RegistrationRequest registrationRequest :
				findByBulkOnbordingFileIdAndStatus(
					bulkOnbordingFileId, status, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(registrationRequest);
		}
	}

	/**
	 * Returns the number of registration requests where bulkOnbordingFileId = &#63; and status = &#63;.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param status the status
	 * @return the number of matching registration requests
	 */
	@Override
	public int countByBulkOnbordingFileIdAndStatus(
		long bulkOnbordingFileId, int status) {

		FinderPath finderPath = _finderPathCountByBulkOnbordingFileIdAndStatus;

		Object[] finderArgs = new Object[] {bulkOnbordingFileId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_REGISTRATIONREQUEST_WHERE);

			sb.append(
				_FINDER_COLUMN_BULKONBORDINGFILEIDANDSTATUS_BULKONBORDINGFILEID_2);

			sb.append(_FINDER_COLUMN_BULKONBORDINGFILEIDANDSTATUS_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(bulkOnbordingFileId);

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

	private static final String
		_FINDER_COLUMN_BULKONBORDINGFILEIDANDSTATUS_BULKONBORDINGFILEID_2 =
			"registrationRequest.bulkOnbordingFileId = ? AND ";

	private static final String
		_FINDER_COLUMN_BULKONBORDINGFILEIDANDSTATUS_STATUS_2 =
			"registrationRequest.status = ?";

	private FinderPath _finderPathWithPaginationFindByStatus;
	private FinderPath _finderPathWithoutPaginationFindByStatus;
	private FinderPath _finderPathCountByStatus;

	/**
	 * Returns all the registration requests where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByStatus(int status) {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the registration requests where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @return the range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByStatus(
		int status, int start, int end) {

		return findByStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the registration requests where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByStatus(
		int status, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return findByStatus(status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the registration requests where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByStatus(
		int status, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator,
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

		List<RegistrationRequest> list = null;

		if (useFinderCache) {
			list = (List<RegistrationRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RegistrationRequest registrationRequest : list) {
					if (status != registrationRequest.getStatus()) {
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

			sb.append(_SQL_SELECT_REGISTRATIONREQUEST_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RegistrationRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

				list = (List<RegistrationRequest>)QueryUtil.list(
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
	 * Returns the first registration request in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest findByStatus_First(
			int status,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		RegistrationRequest registrationRequest = fetchByStatus_First(
			status, orderByComparator);

		if (registrationRequest != null) {
			return registrationRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchRegistrationRequestException(sb.toString());
	}

	/**
	 * Returns the first registration request in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest fetchByStatus_First(
		int status, OrderByComparator<RegistrationRequest> orderByComparator) {

		List<RegistrationRequest> list = findByStatus(
			status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last registration request in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest findByStatus_Last(
			int status,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		RegistrationRequest registrationRequest = fetchByStatus_Last(
			status, orderByComparator);

		if (registrationRequest != null) {
			return registrationRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchRegistrationRequestException(sb.toString());
	}

	/**
	 * Returns the last registration request in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest fetchByStatus_Last(
		int status, OrderByComparator<RegistrationRequest> orderByComparator) {

		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<RegistrationRequest> list = findByStatus(
			status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the registration requests before and after the current registration request in the ordered set where status = &#63;.
	 *
	 * @param registrationRequestId the primary key of the current registration request
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	@Override
	public RegistrationRequest[] findByStatus_PrevAndNext(
			long registrationRequestId, int status,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		RegistrationRequest registrationRequest = findByPrimaryKey(
			registrationRequestId);

		Session session = null;

		try {
			session = openSession();

			RegistrationRequest[] array = new RegistrationRequestImpl[3];

			array[0] = getByStatus_PrevAndNext(
				session, registrationRequest, status, orderByComparator, true);

			array[1] = registrationRequest;

			array[2] = getByStatus_PrevAndNext(
				session, registrationRequest, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected RegistrationRequest getByStatus_PrevAndNext(
		Session session, RegistrationRequest registrationRequest, int status,
		OrderByComparator<RegistrationRequest> orderByComparator,
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

		sb.append(_SQL_SELECT_REGISTRATIONREQUEST_WHERE);

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
			sb.append(RegistrationRequestModelImpl.ORDER_BY_JPQL);
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
						registrationRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RegistrationRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the registration requests where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	@Override
	public void removeByStatus(int status) {
		for (RegistrationRequest registrationRequest :
				findByStatus(
					status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(registrationRequest);
		}
	}

	/**
	 * Returns the number of registration requests where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching registration requests
	 */
	@Override
	public int countByStatus(int status) {
		FinderPath finderPath = _finderPathCountByStatus;

		Object[] finderArgs = new Object[] {status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_REGISTRATIONREQUEST_WHERE);

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
		"registrationRequest.status = ?";

	private FinderPath _finderPathWithPaginationFindByUnitId;
	private FinderPath _finderPathWithoutPaginationFindByUnitId;
	private FinderPath _finderPathCountByUnitId;

	/**
	 * Returns all the registration requests where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @return the matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByUnitId(long unitId) {
		return findByUnitId(unitId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the registration requests where unitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @return the range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByUnitId(
		long unitId, int start, int end) {

		return findByUnitId(unitId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the registration requests where unitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByUnitId(
		long unitId, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return findByUnitId(unitId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the registration requests where unitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByUnitId(
		long unitId, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator,
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

		List<RegistrationRequest> list = null;

		if (useFinderCache) {
			list = (List<RegistrationRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RegistrationRequest registrationRequest : list) {
					if (unitId != registrationRequest.getUnitId()) {
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

			sb.append(_SQL_SELECT_REGISTRATIONREQUEST_WHERE);

			sb.append(_FINDER_COLUMN_UNITID_UNITID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RegistrationRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(unitId);

				list = (List<RegistrationRequest>)QueryUtil.list(
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
	 * Returns the first registration request in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest findByUnitId_First(
			long unitId,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		RegistrationRequest registrationRequest = fetchByUnitId_First(
			unitId, orderByComparator);

		if (registrationRequest != null) {
			return registrationRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("unitId=");
		sb.append(unitId);

		sb.append("}");

		throw new NoSuchRegistrationRequestException(sb.toString());
	}

	/**
	 * Returns the first registration request in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest fetchByUnitId_First(
		long unitId, OrderByComparator<RegistrationRequest> orderByComparator) {

		List<RegistrationRequest> list = findByUnitId(
			unitId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last registration request in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest findByUnitId_Last(
			long unitId,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		RegistrationRequest registrationRequest = fetchByUnitId_Last(
			unitId, orderByComparator);

		if (registrationRequest != null) {
			return registrationRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("unitId=");
		sb.append(unitId);

		sb.append("}");

		throw new NoSuchRegistrationRequestException(sb.toString());
	}

	/**
	 * Returns the last registration request in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest fetchByUnitId_Last(
		long unitId, OrderByComparator<RegistrationRequest> orderByComparator) {

		int count = countByUnitId(unitId);

		if (count == 0) {
			return null;
		}

		List<RegistrationRequest> list = findByUnitId(
			unitId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the registration requests before and after the current registration request in the ordered set where unitId = &#63;.
	 *
	 * @param registrationRequestId the primary key of the current registration request
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	@Override
	public RegistrationRequest[] findByUnitId_PrevAndNext(
			long registrationRequestId, long unitId,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		RegistrationRequest registrationRequest = findByPrimaryKey(
			registrationRequestId);

		Session session = null;

		try {
			session = openSession();

			RegistrationRequest[] array = new RegistrationRequestImpl[3];

			array[0] = getByUnitId_PrevAndNext(
				session, registrationRequest, unitId, orderByComparator, true);

			array[1] = registrationRequest;

			array[2] = getByUnitId_PrevAndNext(
				session, registrationRequest, unitId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected RegistrationRequest getByUnitId_PrevAndNext(
		Session session, RegistrationRequest registrationRequest, long unitId,
		OrderByComparator<RegistrationRequest> orderByComparator,
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

		sb.append(_SQL_SELECT_REGISTRATIONREQUEST_WHERE);

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
			sb.append(RegistrationRequestModelImpl.ORDER_BY_JPQL);
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
						registrationRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RegistrationRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the registration requests where unitId = &#63; from the database.
	 *
	 * @param unitId the unit ID
	 */
	@Override
	public void removeByUnitId(long unitId) {
		for (RegistrationRequest registrationRequest :
				findByUnitId(
					unitId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(registrationRequest);
		}
	}

	/**
	 * Returns the number of registration requests where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @return the number of matching registration requests
	 */
	@Override
	public int countByUnitId(long unitId) {
		FinderPath finderPath = _finderPathCountByUnitId;

		Object[] finderArgs = new Object[] {unitId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_REGISTRATIONREQUEST_WHERE);

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
		"registrationRequest.unitId = ?";

	private FinderPath _finderPathWithPaginationFindByUnitIdAndStatus;
	private FinderPath _finderPathWithoutPaginationFindByUnitIdAndStatus;
	private FinderPath _finderPathCountByUnitIdAndStatus;

	/**
	 * Returns all the registration requests where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @return the matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByUnitIdAndStatus(
		long unitId, int status) {

		return findByUnitIdAndStatus(
			unitId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the registration requests where unitId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @return the range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByUnitIdAndStatus(
		long unitId, int status, int start, int end) {

		return findByUnitIdAndStatus(unitId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the registration requests where unitId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByUnitIdAndStatus(
		long unitId, int status, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return findByUnitIdAndStatus(
			unitId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the registration requests where unitId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByUnitIdAndStatus(
		long unitId, int status, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator,
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

		List<RegistrationRequest> list = null;

		if (useFinderCache) {
			list = (List<RegistrationRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RegistrationRequest registrationRequest : list) {
					if ((unitId != registrationRequest.getUnitId()) ||
						(status != registrationRequest.getStatus())) {

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

			sb.append(_SQL_SELECT_REGISTRATIONREQUEST_WHERE);

			sb.append(_FINDER_COLUMN_UNITIDANDSTATUS_UNITID_2);

			sb.append(_FINDER_COLUMN_UNITIDANDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RegistrationRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(unitId);

				queryPos.add(status);

				list = (List<RegistrationRequest>)QueryUtil.list(
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
	 * Returns the first registration request in the ordered set where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest findByUnitIdAndStatus_First(
			long unitId, int status,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		RegistrationRequest registrationRequest = fetchByUnitIdAndStatus_First(
			unitId, status, orderByComparator);

		if (registrationRequest != null) {
			return registrationRequest;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("unitId=");
		sb.append(unitId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchRegistrationRequestException(sb.toString());
	}

	/**
	 * Returns the first registration request in the ordered set where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest fetchByUnitIdAndStatus_First(
		long unitId, int status,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		List<RegistrationRequest> list = findByUnitIdAndStatus(
			unitId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last registration request in the ordered set where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest findByUnitIdAndStatus_Last(
			long unitId, int status,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		RegistrationRequest registrationRequest = fetchByUnitIdAndStatus_Last(
			unitId, status, orderByComparator);

		if (registrationRequest != null) {
			return registrationRequest;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("unitId=");
		sb.append(unitId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchRegistrationRequestException(sb.toString());
	}

	/**
	 * Returns the last registration request in the ordered set where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest fetchByUnitIdAndStatus_Last(
		long unitId, int status,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		int count = countByUnitIdAndStatus(unitId, status);

		if (count == 0) {
			return null;
		}

		List<RegistrationRequest> list = findByUnitIdAndStatus(
			unitId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the registration requests before and after the current registration request in the ordered set where unitId = &#63; and status = &#63;.
	 *
	 * @param registrationRequestId the primary key of the current registration request
	 * @param unitId the unit ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	@Override
	public RegistrationRequest[] findByUnitIdAndStatus_PrevAndNext(
			long registrationRequestId, long unitId, int status,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		RegistrationRequest registrationRequest = findByPrimaryKey(
			registrationRequestId);

		Session session = null;

		try {
			session = openSession();

			RegistrationRequest[] array = new RegistrationRequestImpl[3];

			array[0] = getByUnitIdAndStatus_PrevAndNext(
				session, registrationRequest, unitId, status, orderByComparator,
				true);

			array[1] = registrationRequest;

			array[2] = getByUnitIdAndStatus_PrevAndNext(
				session, registrationRequest, unitId, status, orderByComparator,
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

	protected RegistrationRequest getByUnitIdAndStatus_PrevAndNext(
		Session session, RegistrationRequest registrationRequest, long unitId,
		int status, OrderByComparator<RegistrationRequest> orderByComparator,
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

		sb.append(_SQL_SELECT_REGISTRATIONREQUEST_WHERE);

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
			sb.append(RegistrationRequestModelImpl.ORDER_BY_JPQL);
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
						registrationRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RegistrationRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the registration requests where unitId = &#63; and status = &#63; from the database.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 */
	@Override
	public void removeByUnitIdAndStatus(long unitId, int status) {
		for (RegistrationRequest registrationRequest :
				findByUnitIdAndStatus(
					unitId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(registrationRequest);
		}
	}

	/**
	 * Returns the number of registration requests where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @return the number of matching registration requests
	 */
	@Override
	public int countByUnitIdAndStatus(long unitId, int status) {
		FinderPath finderPath = _finderPathCountByUnitIdAndStatus;

		Object[] finderArgs = new Object[] {unitId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_REGISTRATIONREQUEST_WHERE);

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
		"registrationRequest.unitId = ? AND ";

	private static final String _FINDER_COLUMN_UNITIDANDSTATUS_STATUS_2 =
		"registrationRequest.status = ?";

	private FinderPath _finderPathWithPaginationFindByUnitIdsAndStatusList;
	private FinderPath _finderPathWithoutPaginationFindByUnitIdsAndStatusList;
	private FinderPath _finderPathCountByUnitIdsAndStatusList;
	private FinderPath _finderPathWithPaginationCountByUnitIdsAndStatusList;

	/**
	 * Returns all the registration requests where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @return the matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByUnitIdsAndStatusList(
		long unitId, int status) {

		return findByUnitIdsAndStatusList(
			unitId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the registration requests where unitId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @return the range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByUnitIdsAndStatusList(
		long unitId, int status, int start, int end) {

		return findByUnitIdsAndStatusList(unitId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the registration requests where unitId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByUnitIdsAndStatusList(
		long unitId, int status, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return findByUnitIdsAndStatusList(
			unitId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the registration requests where unitId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByUnitIdsAndStatusList(
		long unitId, int status, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator,
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

		List<RegistrationRequest> list = null;

		if (useFinderCache) {
			list = (List<RegistrationRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RegistrationRequest registrationRequest : list) {
					if ((unitId != registrationRequest.getUnitId()) ||
						(status != registrationRequest.getStatus())) {

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

			sb.append(_SQL_SELECT_REGISTRATIONREQUEST_WHERE);

			sb.append(_FINDER_COLUMN_UNITIDSANDSTATUSLIST_UNITID_2);

			sb.append(_FINDER_COLUMN_UNITIDSANDSTATUSLIST_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RegistrationRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(unitId);

				queryPos.add(status);

				list = (List<RegistrationRequest>)QueryUtil.list(
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
	 * Returns the first registration request in the ordered set where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest findByUnitIdsAndStatusList_First(
			long unitId, int status,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		RegistrationRequest registrationRequest =
			fetchByUnitIdsAndStatusList_First(
				unitId, status, orderByComparator);

		if (registrationRequest != null) {
			return registrationRequest;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("unitId=");
		sb.append(unitId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchRegistrationRequestException(sb.toString());
	}

	/**
	 * Returns the first registration request in the ordered set where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest fetchByUnitIdsAndStatusList_First(
		long unitId, int status,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		List<RegistrationRequest> list = findByUnitIdsAndStatusList(
			unitId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last registration request in the ordered set where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest findByUnitIdsAndStatusList_Last(
			long unitId, int status,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		RegistrationRequest registrationRequest =
			fetchByUnitIdsAndStatusList_Last(unitId, status, orderByComparator);

		if (registrationRequest != null) {
			return registrationRequest;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("unitId=");
		sb.append(unitId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchRegistrationRequestException(sb.toString());
	}

	/**
	 * Returns the last registration request in the ordered set where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest fetchByUnitIdsAndStatusList_Last(
		long unitId, int status,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		int count = countByUnitIdsAndStatusList(unitId, status);

		if (count == 0) {
			return null;
		}

		List<RegistrationRequest> list = findByUnitIdsAndStatusList(
			unitId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the registration requests before and after the current registration request in the ordered set where unitId = &#63; and status = &#63;.
	 *
	 * @param registrationRequestId the primary key of the current registration request
	 * @param unitId the unit ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	@Override
	public RegistrationRequest[] findByUnitIdsAndStatusList_PrevAndNext(
			long registrationRequestId, long unitId, int status,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		RegistrationRequest registrationRequest = findByPrimaryKey(
			registrationRequestId);

		Session session = null;

		try {
			session = openSession();

			RegistrationRequest[] array = new RegistrationRequestImpl[3];

			array[0] = getByUnitIdsAndStatusList_PrevAndNext(
				session, registrationRequest, unitId, status, orderByComparator,
				true);

			array[1] = registrationRequest;

			array[2] = getByUnitIdsAndStatusList_PrevAndNext(
				session, registrationRequest, unitId, status, orderByComparator,
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

	protected RegistrationRequest getByUnitIdsAndStatusList_PrevAndNext(
		Session session, RegistrationRequest registrationRequest, long unitId,
		int status, OrderByComparator<RegistrationRequest> orderByComparator,
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

		sb.append(_SQL_SELECT_REGISTRATIONREQUEST_WHERE);

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
			sb.append(RegistrationRequestModelImpl.ORDER_BY_JPQL);
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
						registrationRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RegistrationRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the registration requests where unitId = any &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param unitIds the unit IDs
	 * @param statuses the statuses
	 * @return the matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByUnitIdsAndStatusList(
		long[] unitIds, int[] statuses) {

		return findByUnitIdsAndStatusList(
			unitIds, statuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the registration requests where unitId = any &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param unitIds the unit IDs
	 * @param statuses the statuses
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @return the range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByUnitIdsAndStatusList(
		long[] unitIds, int[] statuses, int start, int end) {

		return findByUnitIdsAndStatusList(unitIds, statuses, start, end, null);
	}

	/**
	 * Returns an ordered range of all the registration requests where unitId = any &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param unitIds the unit IDs
	 * @param statuses the statuses
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByUnitIdsAndStatusList(
		long[] unitIds, int[] statuses, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return findByUnitIdsAndStatusList(
			unitIds, statuses, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the registration requests where unitId = &#63; and status = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByUnitIdsAndStatusList(
		long[] unitIds, int[] statuses, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator,
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

		List<RegistrationRequest> list = null;

		if (useFinderCache) {
			list = (List<RegistrationRequest>)finderCache.getResult(
				_finderPathWithPaginationFindByUnitIdsAndStatusList, finderArgs,
				this);

			if ((list != null) && !list.isEmpty()) {
				for (RegistrationRequest registrationRequest : list) {
					if (!ArrayUtil.contains(
							unitIds, registrationRequest.getUnitId()) ||
						!ArrayUtil.contains(
							statuses, registrationRequest.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_SELECT_REGISTRATIONREQUEST_WHERE);

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
				sb.append(RegistrationRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<RegistrationRequest>)QueryUtil.list(
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
	 * Removes all the registration requests where unitId = &#63; and status = &#63; from the database.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 */
	@Override
	public void removeByUnitIdsAndStatusList(long unitId, int status) {
		for (RegistrationRequest registrationRequest :
				findByUnitIdsAndStatusList(
					unitId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(registrationRequest);
		}
	}

	/**
	 * Returns the number of registration requests where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @return the number of matching registration requests
	 */
	@Override
	public int countByUnitIdsAndStatusList(long unitId, int status) {
		FinderPath finderPath = _finderPathCountByUnitIdsAndStatusList;

		Object[] finderArgs = new Object[] {unitId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_REGISTRATIONREQUEST_WHERE);

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
	 * Returns the number of registration requests where unitId = any &#63; and status = any &#63;.
	 *
	 * @param unitIds the unit IDs
	 * @param statuses the statuses
	 * @return the number of matching registration requests
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

			sb.append(_SQL_COUNT_REGISTRATIONREQUEST_WHERE);

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
		"registrationRequest.unitId = ? AND ";

	private static final String _FINDER_COLUMN_UNITIDSANDSTATUSLIST_UNITID_7 =
		"registrationRequest.unitId IN (";

	private static final String _FINDER_COLUMN_UNITIDSANDSTATUSLIST_STATUS_2 =
		"registrationRequest.status = ?";

	private static final String _FINDER_COLUMN_UNITIDSANDSTATUSLIST_STATUS_7 =
		"registrationRequest.status IN (";

	private FinderPath _finderPathWithPaginationFindByUnitIdAndState;
	private FinderPath _finderPathWithoutPaginationFindByUnitIdAndState;
	private FinderPath _finderPathCountByUnitIdAndState;

	/**
	 * Returns all the registration requests where unitId = &#63; and state = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param state the state
	 * @return the matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByUnitIdAndState(
		long unitId, String state) {

		return findByUnitIdAndState(
			unitId, state, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the registration requests where unitId = &#63; and state = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param state the state
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @return the range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByUnitIdAndState(
		long unitId, String state, int start, int end) {

		return findByUnitIdAndState(unitId, state, start, end, null);
	}

	/**
	 * Returns an ordered range of all the registration requests where unitId = &#63; and state = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param state the state
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByUnitIdAndState(
		long unitId, String state, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return findByUnitIdAndState(
			unitId, state, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the registration requests where unitId = &#63; and state = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param state the state
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByUnitIdAndState(
		long unitId, String state, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator,
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

		List<RegistrationRequest> list = null;

		if (useFinderCache) {
			list = (List<RegistrationRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RegistrationRequest registrationRequest : list) {
					if ((unitId != registrationRequest.getUnitId()) ||
						!state.equals(registrationRequest.getState())) {

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

			sb.append(_SQL_SELECT_REGISTRATIONREQUEST_WHERE);

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
				sb.append(RegistrationRequestModelImpl.ORDER_BY_JPQL);
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

				list = (List<RegistrationRequest>)QueryUtil.list(
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
	 * Returns the first registration request in the ordered set where unitId = &#63; and state = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param state the state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest findByUnitIdAndState_First(
			long unitId, String state,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		RegistrationRequest registrationRequest = fetchByUnitIdAndState_First(
			unitId, state, orderByComparator);

		if (registrationRequest != null) {
			return registrationRequest;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("unitId=");
		sb.append(unitId);

		sb.append(", state=");
		sb.append(state);

		sb.append("}");

		throw new NoSuchRegistrationRequestException(sb.toString());
	}

	/**
	 * Returns the first registration request in the ordered set where unitId = &#63; and state = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param state the state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest fetchByUnitIdAndState_First(
		long unitId, String state,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		List<RegistrationRequest> list = findByUnitIdAndState(
			unitId, state, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last registration request in the ordered set where unitId = &#63; and state = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param state the state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest findByUnitIdAndState_Last(
			long unitId, String state,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		RegistrationRequest registrationRequest = fetchByUnitIdAndState_Last(
			unitId, state, orderByComparator);

		if (registrationRequest != null) {
			return registrationRequest;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("unitId=");
		sb.append(unitId);

		sb.append(", state=");
		sb.append(state);

		sb.append("}");

		throw new NoSuchRegistrationRequestException(sb.toString());
	}

	/**
	 * Returns the last registration request in the ordered set where unitId = &#63; and state = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param state the state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest fetchByUnitIdAndState_Last(
		long unitId, String state,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		int count = countByUnitIdAndState(unitId, state);

		if (count == 0) {
			return null;
		}

		List<RegistrationRequest> list = findByUnitIdAndState(
			unitId, state, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the registration requests before and after the current registration request in the ordered set where unitId = &#63; and state = &#63;.
	 *
	 * @param registrationRequestId the primary key of the current registration request
	 * @param unitId the unit ID
	 * @param state the state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	@Override
	public RegistrationRequest[] findByUnitIdAndState_PrevAndNext(
			long registrationRequestId, long unitId, String state,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		state = Objects.toString(state, "");

		RegistrationRequest registrationRequest = findByPrimaryKey(
			registrationRequestId);

		Session session = null;

		try {
			session = openSession();

			RegistrationRequest[] array = new RegistrationRequestImpl[3];

			array[0] = getByUnitIdAndState_PrevAndNext(
				session, registrationRequest, unitId, state, orderByComparator,
				true);

			array[1] = registrationRequest;

			array[2] = getByUnitIdAndState_PrevAndNext(
				session, registrationRequest, unitId, state, orderByComparator,
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

	protected RegistrationRequest getByUnitIdAndState_PrevAndNext(
		Session session, RegistrationRequest registrationRequest, long unitId,
		String state, OrderByComparator<RegistrationRequest> orderByComparator,
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

		sb.append(_SQL_SELECT_REGISTRATIONREQUEST_WHERE);

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
			sb.append(RegistrationRequestModelImpl.ORDER_BY_JPQL);
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
						registrationRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RegistrationRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the registration requests where unitId = &#63; and state = &#63; from the database.
	 *
	 * @param unitId the unit ID
	 * @param state the state
	 */
	@Override
	public void removeByUnitIdAndState(long unitId, String state) {
		for (RegistrationRequest registrationRequest :
				findByUnitIdAndState(
					unitId, state, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(registrationRequest);
		}
	}

	/**
	 * Returns the number of registration requests where unitId = &#63; and state = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param state the state
	 * @return the number of matching registration requests
	 */
	@Override
	public int countByUnitIdAndState(long unitId, String state) {
		state = Objects.toString(state, "");

		FinderPath finderPath = _finderPathCountByUnitIdAndState;

		Object[] finderArgs = new Object[] {unitId, state};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_REGISTRATIONREQUEST_WHERE);

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
		"registrationRequest.unitId = ? AND ";

	private static final String _FINDER_COLUMN_UNITIDANDSTATE_STATE_2 =
		"registrationRequest.state = ?";

	private static final String _FINDER_COLUMN_UNITIDANDSTATE_STATE_3 =
		"(registrationRequest.state IS NULL OR registrationRequest.state = '')";

	private FinderPath _finderPathWithPaginationFindByUnit;
	private FinderPath _finderPathWithoutPaginationFindByUnit;
	private FinderPath _finderPathCountByUnit;

	/**
	 * Returns all the registration requests where unit = &#63;.
	 *
	 * @param unit the unit
	 * @return the matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByUnit(String unit) {
		return findByUnit(unit, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the registration requests where unit = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param unit the unit
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @return the range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByUnit(
		String unit, int start, int end) {

		return findByUnit(unit, start, end, null);
	}

	/**
	 * Returns an ordered range of all the registration requests where unit = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param unit the unit
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByUnit(
		String unit, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return findByUnit(unit, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the registration requests where unit = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param unit the unit
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByUnit(
		String unit, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator,
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

		List<RegistrationRequest> list = null;

		if (useFinderCache) {
			list = (List<RegistrationRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RegistrationRequest registrationRequest : list) {
					if (!unit.equals(registrationRequest.getUnit())) {
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

			sb.append(_SQL_SELECT_REGISTRATIONREQUEST_WHERE);

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
				sb.append(RegistrationRequestModelImpl.ORDER_BY_JPQL);
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

				list = (List<RegistrationRequest>)QueryUtil.list(
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
	 * Returns the first registration request in the ordered set where unit = &#63;.
	 *
	 * @param unit the unit
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest findByUnit_First(
			String unit,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		RegistrationRequest registrationRequest = fetchByUnit_First(
			unit, orderByComparator);

		if (registrationRequest != null) {
			return registrationRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("unit=");
		sb.append(unit);

		sb.append("}");

		throw new NoSuchRegistrationRequestException(sb.toString());
	}

	/**
	 * Returns the first registration request in the ordered set where unit = &#63;.
	 *
	 * @param unit the unit
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest fetchByUnit_First(
		String unit, OrderByComparator<RegistrationRequest> orderByComparator) {

		List<RegistrationRequest> list = findByUnit(
			unit, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last registration request in the ordered set where unit = &#63;.
	 *
	 * @param unit the unit
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest findByUnit_Last(
			String unit,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		RegistrationRequest registrationRequest = fetchByUnit_Last(
			unit, orderByComparator);

		if (registrationRequest != null) {
			return registrationRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("unit=");
		sb.append(unit);

		sb.append("}");

		throw new NoSuchRegistrationRequestException(sb.toString());
	}

	/**
	 * Returns the last registration request in the ordered set where unit = &#63;.
	 *
	 * @param unit the unit
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest fetchByUnit_Last(
		String unit, OrderByComparator<RegistrationRequest> orderByComparator) {

		int count = countByUnit(unit);

		if (count == 0) {
			return null;
		}

		List<RegistrationRequest> list = findByUnit(
			unit, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the registration requests before and after the current registration request in the ordered set where unit = &#63;.
	 *
	 * @param registrationRequestId the primary key of the current registration request
	 * @param unit the unit
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	@Override
	public RegistrationRequest[] findByUnit_PrevAndNext(
			long registrationRequestId, String unit,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		unit = Objects.toString(unit, "");

		RegistrationRequest registrationRequest = findByPrimaryKey(
			registrationRequestId);

		Session session = null;

		try {
			session = openSession();

			RegistrationRequest[] array = new RegistrationRequestImpl[3];

			array[0] = getByUnit_PrevAndNext(
				session, registrationRequest, unit, orderByComparator, true);

			array[1] = registrationRequest;

			array[2] = getByUnit_PrevAndNext(
				session, registrationRequest, unit, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected RegistrationRequest getByUnit_PrevAndNext(
		Session session, RegistrationRequest registrationRequest, String unit,
		OrderByComparator<RegistrationRequest> orderByComparator,
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

		sb.append(_SQL_SELECT_REGISTRATIONREQUEST_WHERE);

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
			sb.append(RegistrationRequestModelImpl.ORDER_BY_JPQL);
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
						registrationRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RegistrationRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the registration requests where unit = &#63; from the database.
	 *
	 * @param unit the unit
	 */
	@Override
	public void removeByUnit(String unit) {
		for (RegistrationRequest registrationRequest :
				findByUnit(unit, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(registrationRequest);
		}
	}

	/**
	 * Returns the number of registration requests where unit = &#63;.
	 *
	 * @param unit the unit
	 * @return the number of matching registration requests
	 */
	@Override
	public int countByUnit(String unit) {
		unit = Objects.toString(unit, "");

		FinderPath finderPath = _finderPathCountByUnit;

		Object[] finderArgs = new Object[] {unit};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_REGISTRATIONREQUEST_WHERE);

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
		"registrationRequest.unit = ?";

	private static final String _FINDER_COLUMN_UNIT_UNIT_3 =
		"(registrationRequest.unit IS NULL OR registrationRequest.unit = '')";

	private FinderPath _finderPathWithPaginationFindByUnitAndStatus;
	private FinderPath _finderPathWithoutPaginationFindByUnitAndStatus;
	private FinderPath _finderPathCountByUnitAndStatus;

	/**
	 * Returns all the registration requests where unit = &#63; and status = &#63;.
	 *
	 * @param unit the unit
	 * @param status the status
	 * @return the matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByUnitAndStatus(
		String unit, int status) {

		return findByUnitAndStatus(
			unit, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the registration requests where unit = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param unit the unit
	 * @param status the status
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @return the range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByUnitAndStatus(
		String unit, int status, int start, int end) {

		return findByUnitAndStatus(unit, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the registration requests where unit = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param unit the unit
	 * @param status the status
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByUnitAndStatus(
		String unit, int status, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return findByUnitAndStatus(
			unit, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the registration requests where unit = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param unit the unit
	 * @param status the status
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByUnitAndStatus(
		String unit, int status, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator,
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

		List<RegistrationRequest> list = null;

		if (useFinderCache) {
			list = (List<RegistrationRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RegistrationRequest registrationRequest : list) {
					if (!unit.equals(registrationRequest.getUnit()) ||
						(status != registrationRequest.getStatus())) {

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

			sb.append(_SQL_SELECT_REGISTRATIONREQUEST_WHERE);

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
				sb.append(RegistrationRequestModelImpl.ORDER_BY_JPQL);
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

				list = (List<RegistrationRequest>)QueryUtil.list(
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
	 * Returns the first registration request in the ordered set where unit = &#63; and status = &#63;.
	 *
	 * @param unit the unit
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest findByUnitAndStatus_First(
			String unit, int status,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		RegistrationRequest registrationRequest = fetchByUnitAndStatus_First(
			unit, status, orderByComparator);

		if (registrationRequest != null) {
			return registrationRequest;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("unit=");
		sb.append(unit);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchRegistrationRequestException(sb.toString());
	}

	/**
	 * Returns the first registration request in the ordered set where unit = &#63; and status = &#63;.
	 *
	 * @param unit the unit
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest fetchByUnitAndStatus_First(
		String unit, int status,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		List<RegistrationRequest> list = findByUnitAndStatus(
			unit, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last registration request in the ordered set where unit = &#63; and status = &#63;.
	 *
	 * @param unit the unit
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest findByUnitAndStatus_Last(
			String unit, int status,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		RegistrationRequest registrationRequest = fetchByUnitAndStatus_Last(
			unit, status, orderByComparator);

		if (registrationRequest != null) {
			return registrationRequest;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("unit=");
		sb.append(unit);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchRegistrationRequestException(sb.toString());
	}

	/**
	 * Returns the last registration request in the ordered set where unit = &#63; and status = &#63;.
	 *
	 * @param unit the unit
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest fetchByUnitAndStatus_Last(
		String unit, int status,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		int count = countByUnitAndStatus(unit, status);

		if (count == 0) {
			return null;
		}

		List<RegistrationRequest> list = findByUnitAndStatus(
			unit, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the registration requests before and after the current registration request in the ordered set where unit = &#63; and status = &#63;.
	 *
	 * @param registrationRequestId the primary key of the current registration request
	 * @param unit the unit
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	@Override
	public RegistrationRequest[] findByUnitAndStatus_PrevAndNext(
			long registrationRequestId, String unit, int status,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		unit = Objects.toString(unit, "");

		RegistrationRequest registrationRequest = findByPrimaryKey(
			registrationRequestId);

		Session session = null;

		try {
			session = openSession();

			RegistrationRequest[] array = new RegistrationRequestImpl[3];

			array[0] = getByUnitAndStatus_PrevAndNext(
				session, registrationRequest, unit, status, orderByComparator,
				true);

			array[1] = registrationRequest;

			array[2] = getByUnitAndStatus_PrevAndNext(
				session, registrationRequest, unit, status, orderByComparator,
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

	protected RegistrationRequest getByUnitAndStatus_PrevAndNext(
		Session session, RegistrationRequest registrationRequest, String unit,
		int status, OrderByComparator<RegistrationRequest> orderByComparator,
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

		sb.append(_SQL_SELECT_REGISTRATIONREQUEST_WHERE);

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
			sb.append(RegistrationRequestModelImpl.ORDER_BY_JPQL);
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
						registrationRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RegistrationRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the registration requests where unit = &#63; and status = &#63; from the database.
	 *
	 * @param unit the unit
	 * @param status the status
	 */
	@Override
	public void removeByUnitAndStatus(String unit, int status) {
		for (RegistrationRequest registrationRequest :
				findByUnitAndStatus(
					unit, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(registrationRequest);
		}
	}

	/**
	 * Returns the number of registration requests where unit = &#63; and status = &#63;.
	 *
	 * @param unit the unit
	 * @param status the status
	 * @return the number of matching registration requests
	 */
	@Override
	public int countByUnitAndStatus(String unit, int status) {
		unit = Objects.toString(unit, "");

		FinderPath finderPath = _finderPathCountByUnitAndStatus;

		Object[] finderArgs = new Object[] {unit, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_REGISTRATIONREQUEST_WHERE);

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
		"registrationRequest.unit = ? AND ";

	private static final String _FINDER_COLUMN_UNITANDSTATUS_UNIT_3 =
		"(registrationRequest.unit IS NULL OR registrationRequest.unit = '') AND ";

	private static final String _FINDER_COLUMN_UNITANDSTATUS_STATUS_2 =
		"registrationRequest.status = ?";

	private FinderPath _finderPathWithPaginationFindByUnitAndState;
	private FinderPath _finderPathWithoutPaginationFindByUnitAndState;
	private FinderPath _finderPathCountByUnitAndState;

	/**
	 * Returns all the registration requests where unit = &#63; and state = &#63;.
	 *
	 * @param unit the unit
	 * @param state the state
	 * @return the matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByUnitAndState(
		String unit, String state) {

		return findByUnitAndState(
			unit, state, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the registration requests where unit = &#63; and state = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param unit the unit
	 * @param state the state
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @return the range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByUnitAndState(
		String unit, String state, int start, int end) {

		return findByUnitAndState(unit, state, start, end, null);
	}

	/**
	 * Returns an ordered range of all the registration requests where unit = &#63; and state = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param unit the unit
	 * @param state the state
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByUnitAndState(
		String unit, String state, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return findByUnitAndState(
			unit, state, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the registration requests where unit = &#63; and state = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param unit the unit
	 * @param state the state
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByUnitAndState(
		String unit, String state, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator,
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

		List<RegistrationRequest> list = null;

		if (useFinderCache) {
			list = (List<RegistrationRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RegistrationRequest registrationRequest : list) {
					if (!unit.equals(registrationRequest.getUnit()) ||
						!state.equals(registrationRequest.getState())) {

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

			sb.append(_SQL_SELECT_REGISTRATIONREQUEST_WHERE);

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
				sb.append(RegistrationRequestModelImpl.ORDER_BY_JPQL);
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

				list = (List<RegistrationRequest>)QueryUtil.list(
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
	 * Returns the first registration request in the ordered set where unit = &#63; and state = &#63;.
	 *
	 * @param unit the unit
	 * @param state the state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest findByUnitAndState_First(
			String unit, String state,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		RegistrationRequest registrationRequest = fetchByUnitAndState_First(
			unit, state, orderByComparator);

		if (registrationRequest != null) {
			return registrationRequest;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("unit=");
		sb.append(unit);

		sb.append(", state=");
		sb.append(state);

		sb.append("}");

		throw new NoSuchRegistrationRequestException(sb.toString());
	}

	/**
	 * Returns the first registration request in the ordered set where unit = &#63; and state = &#63;.
	 *
	 * @param unit the unit
	 * @param state the state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest fetchByUnitAndState_First(
		String unit, String state,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		List<RegistrationRequest> list = findByUnitAndState(
			unit, state, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last registration request in the ordered set where unit = &#63; and state = &#63;.
	 *
	 * @param unit the unit
	 * @param state the state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest findByUnitAndState_Last(
			String unit, String state,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		RegistrationRequest registrationRequest = fetchByUnitAndState_Last(
			unit, state, orderByComparator);

		if (registrationRequest != null) {
			return registrationRequest;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("unit=");
		sb.append(unit);

		sb.append(", state=");
		sb.append(state);

		sb.append("}");

		throw new NoSuchRegistrationRequestException(sb.toString());
	}

	/**
	 * Returns the last registration request in the ordered set where unit = &#63; and state = &#63;.
	 *
	 * @param unit the unit
	 * @param state the state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest fetchByUnitAndState_Last(
		String unit, String state,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		int count = countByUnitAndState(unit, state);

		if (count == 0) {
			return null;
		}

		List<RegistrationRequest> list = findByUnitAndState(
			unit, state, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the registration requests before and after the current registration request in the ordered set where unit = &#63; and state = &#63;.
	 *
	 * @param registrationRequestId the primary key of the current registration request
	 * @param unit the unit
	 * @param state the state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	@Override
	public RegistrationRequest[] findByUnitAndState_PrevAndNext(
			long registrationRequestId, String unit, String state,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		unit = Objects.toString(unit, "");
		state = Objects.toString(state, "");

		RegistrationRequest registrationRequest = findByPrimaryKey(
			registrationRequestId);

		Session session = null;

		try {
			session = openSession();

			RegistrationRequest[] array = new RegistrationRequestImpl[3];

			array[0] = getByUnitAndState_PrevAndNext(
				session, registrationRequest, unit, state, orderByComparator,
				true);

			array[1] = registrationRequest;

			array[2] = getByUnitAndState_PrevAndNext(
				session, registrationRequest, unit, state, orderByComparator,
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

	protected RegistrationRequest getByUnitAndState_PrevAndNext(
		Session session, RegistrationRequest registrationRequest, String unit,
		String state, OrderByComparator<RegistrationRequest> orderByComparator,
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

		sb.append(_SQL_SELECT_REGISTRATIONREQUEST_WHERE);

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
			sb.append(RegistrationRequestModelImpl.ORDER_BY_JPQL);
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
						registrationRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RegistrationRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the registration requests where unit = &#63; and state = &#63; from the database.
	 *
	 * @param unit the unit
	 * @param state the state
	 */
	@Override
	public void removeByUnitAndState(String unit, String state) {
		for (RegistrationRequest registrationRequest :
				findByUnitAndState(
					unit, state, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(registrationRequest);
		}
	}

	/**
	 * Returns the number of registration requests where unit = &#63; and state = &#63;.
	 *
	 * @param unit the unit
	 * @param state the state
	 * @return the number of matching registration requests
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

			sb.append(_SQL_COUNT_REGISTRATIONREQUEST_WHERE);

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
		"registrationRequest.unit = ? AND ";

	private static final String _FINDER_COLUMN_UNITANDSTATE_UNIT_3 =
		"(registrationRequest.unit IS NULL OR registrationRequest.unit = '') AND ";

	private static final String _FINDER_COLUMN_UNITANDSTATE_STATE_2 =
		"registrationRequest.state = ?";

	private static final String _FINDER_COLUMN_UNITANDSTATE_STATE_3 =
		"(registrationRequest.state IS NULL OR registrationRequest.state = '')";

	private FinderPath _finderPathWithPaginationFindByG_S;
	private FinderPath _finderPathWithoutPaginationFindByG_S;
	private FinderPath _finderPathCountByG_S;

	/**
	 * Returns all the registration requests where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByG_S(long groupId, int status) {
		return findByG_S(
			groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the registration requests where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @return the range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByG_S(
		long groupId, int status, int start, int end) {

		return findByG_S(groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the registration requests where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return findByG_S(groupId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the registration requests where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator,
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

		List<RegistrationRequest> list = null;

		if (useFinderCache) {
			list = (List<RegistrationRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RegistrationRequest registrationRequest : list) {
					if ((groupId != registrationRequest.getGroupId()) ||
						(status != registrationRequest.getStatus())) {

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

			sb.append(_SQL_SELECT_REGISTRATIONREQUEST_WHERE);

			sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RegistrationRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(status);

				list = (List<RegistrationRequest>)QueryUtil.list(
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
	 * Returns the first registration request in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest findByG_S_First(
			long groupId, int status,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		RegistrationRequest registrationRequest = fetchByG_S_First(
			groupId, status, orderByComparator);

		if (registrationRequest != null) {
			return registrationRequest;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchRegistrationRequestException(sb.toString());
	}

	/**
	 * Returns the first registration request in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest fetchByG_S_First(
		long groupId, int status,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		List<RegistrationRequest> list = findByG_S(
			groupId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last registration request in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest findByG_S_Last(
			long groupId, int status,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		RegistrationRequest registrationRequest = fetchByG_S_Last(
			groupId, status, orderByComparator);

		if (registrationRequest != null) {
			return registrationRequest;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchRegistrationRequestException(sb.toString());
	}

	/**
	 * Returns the last registration request in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest fetchByG_S_Last(
		long groupId, int status,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		int count = countByG_S(groupId, status);

		if (count == 0) {
			return null;
		}

		List<RegistrationRequest> list = findByG_S(
			groupId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the registration requests before and after the current registration request in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param registrationRequestId the primary key of the current registration request
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	@Override
	public RegistrationRequest[] findByG_S_PrevAndNext(
			long registrationRequestId, long groupId, int status,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		RegistrationRequest registrationRequest = findByPrimaryKey(
			registrationRequestId);

		Session session = null;

		try {
			session = openSession();

			RegistrationRequest[] array = new RegistrationRequestImpl[3];

			array[0] = getByG_S_PrevAndNext(
				session, registrationRequest, groupId, status,
				orderByComparator, true);

			array[1] = registrationRequest;

			array[2] = getByG_S_PrevAndNext(
				session, registrationRequest, groupId, status,
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

	protected RegistrationRequest getByG_S_PrevAndNext(
		Session session, RegistrationRequest registrationRequest, long groupId,
		int status, OrderByComparator<RegistrationRequest> orderByComparator,
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

		sb.append(_SQL_SELECT_REGISTRATIONREQUEST_WHERE);

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
			sb.append(RegistrationRequestModelImpl.ORDER_BY_JPQL);
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
						registrationRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RegistrationRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the registration requests that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching registration requests that the user has permission to view
	 */
	@Override
	public List<RegistrationRequest> filterFindByG_S(long groupId, int status) {
		return filterFindByG_S(
			groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the registration requests that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @return the range of matching registration requests that the user has permission to view
	 */
	@Override
	public List<RegistrationRequest> filterFindByG_S(
		long groupId, int status, int start, int end) {

		return filterFindByG_S(groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the registration requests that the user has permissions to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching registration requests that the user has permission to view
	 */
	@Override
	public List<RegistrationRequest> filterFindByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_S(groupId, status, start, end, orderByComparator);
		}

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByFields().length * 2));
		}
		else {
			sb = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_REGISTRATIONREQUEST_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_REGISTRATIONREQUEST_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_REGISTRATIONREQUEST_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(RegistrationRequestModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(RegistrationRequestModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), RegistrationRequest.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(
					_FILTER_ENTITY_ALIAS, RegistrationRequestImpl.class);
			}
			else {
				sqlQuery.addEntity(
					_FILTER_ENTITY_TABLE, RegistrationRequestImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(status);

			return (List<RegistrationRequest>)QueryUtil.list(
				sqlQuery, getDialect(), start, end);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the registration requests before and after the current registration request in the ordered set of registration requests that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param registrationRequestId the primary key of the current registration request
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	@Override
	public RegistrationRequest[] filterFindByG_S_PrevAndNext(
			long registrationRequestId, long groupId, int status,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_S_PrevAndNext(
				registrationRequestId, groupId, status, orderByComparator);
		}

		RegistrationRequest registrationRequest = findByPrimaryKey(
			registrationRequestId);

		Session session = null;

		try {
			session = openSession();

			RegistrationRequest[] array = new RegistrationRequestImpl[3];

			array[0] = filterGetByG_S_PrevAndNext(
				session, registrationRequest, groupId, status,
				orderByComparator, true);

			array[1] = registrationRequest;

			array[2] = filterGetByG_S_PrevAndNext(
				session, registrationRequest, groupId, status,
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

	protected RegistrationRequest filterGetByG_S_PrevAndNext(
		Session session, RegistrationRequest registrationRequest, long groupId,
		int status, OrderByComparator<RegistrationRequest> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_REGISTRATIONREQUEST_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_REGISTRATIONREQUEST_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_REGISTRATIONREQUEST_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByConditionFields[i],
							true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByConditionFields[i],
							true));
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByFields[i], true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByFields[i], true));
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(RegistrationRequestModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(RegistrationRequestModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), RegistrationRequest.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(
				_FILTER_ENTITY_ALIAS, RegistrationRequestImpl.class);
		}
		else {
			sqlQuery.addEntity(
				_FILTER_ENTITY_TABLE, RegistrationRequestImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						registrationRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RegistrationRequest> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the registration requests where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	@Override
	public void removeByG_S(long groupId, int status) {
		for (RegistrationRequest registrationRequest :
				findByG_S(
					groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(registrationRequest);
		}
	}

	/**
	 * Returns the number of registration requests where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching registration requests
	 */
	@Override
	public int countByG_S(long groupId, int status) {
		FinderPath finderPath = _finderPathCountByG_S;

		Object[] finderArgs = new Object[] {groupId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_REGISTRATIONREQUEST_WHERE);

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

	/**
	 * Returns the number of registration requests that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching registration requests that the user has permission to view
	 */
	@Override
	public int filterCountByG_S(long groupId, int status) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_S(groupId, status);
		}

		StringBundler sb = new StringBundler(3);

		sb.append(_FILTER_SQL_COUNT_REGISTRATIONREQUEST_WHERE);

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_STATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), RegistrationRequest.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(status);

			Long count = (Long)sqlQuery.uniqueResult();

			return count.intValue();
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_G_S_GROUPID_2 =
		"registrationRequest.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_S_STATUS_2 =
		"registrationRequest.status = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the registration requests where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the registration requests where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @return the range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByGroupId(
		long groupId, int start, int end) {

		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the registration requests where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the registration requests where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator,
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

		List<RegistrationRequest> list = null;

		if (useFinderCache) {
			list = (List<RegistrationRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RegistrationRequest registrationRequest : list) {
					if (groupId != registrationRequest.getGroupId()) {
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

			sb.append(_SQL_SELECT_REGISTRATIONREQUEST_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RegistrationRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<RegistrationRequest>)QueryUtil.list(
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
	 * Returns the first registration request in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest findByGroupId_First(
			long groupId,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		RegistrationRequest registrationRequest = fetchByGroupId_First(
			groupId, orderByComparator);

		if (registrationRequest != null) {
			return registrationRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchRegistrationRequestException(sb.toString());
	}

	/**
	 * Returns the first registration request in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest fetchByGroupId_First(
		long groupId,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		List<RegistrationRequest> list = findByGroupId(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last registration request in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest findByGroupId_Last(
			long groupId,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		RegistrationRequest registrationRequest = fetchByGroupId_Last(
			groupId, orderByComparator);

		if (registrationRequest != null) {
			return registrationRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchRegistrationRequestException(sb.toString());
	}

	/**
	 * Returns the last registration request in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest fetchByGroupId_Last(
		long groupId,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<RegistrationRequest> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the registration requests before and after the current registration request in the ordered set where groupId = &#63;.
	 *
	 * @param registrationRequestId the primary key of the current registration request
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	@Override
	public RegistrationRequest[] findByGroupId_PrevAndNext(
			long registrationRequestId, long groupId,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		RegistrationRequest registrationRequest = findByPrimaryKey(
			registrationRequestId);

		Session session = null;

		try {
			session = openSession();

			RegistrationRequest[] array = new RegistrationRequestImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, registrationRequest, groupId, orderByComparator, true);

			array[1] = registrationRequest;

			array[2] = getByGroupId_PrevAndNext(
				session, registrationRequest, groupId, orderByComparator,
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

	protected RegistrationRequest getByGroupId_PrevAndNext(
		Session session, RegistrationRequest registrationRequest, long groupId,
		OrderByComparator<RegistrationRequest> orderByComparator,
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

		sb.append(_SQL_SELECT_REGISTRATIONREQUEST_WHERE);

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
			sb.append(RegistrationRequestModelImpl.ORDER_BY_JPQL);
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
						registrationRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RegistrationRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the registration requests that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching registration requests that the user has permission to view
	 */
	@Override
	public List<RegistrationRequest> filterFindByGroupId(long groupId) {
		return filterFindByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the registration requests that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @return the range of matching registration requests that the user has permission to view
	 */
	@Override
	public List<RegistrationRequest> filterFindByGroupId(
		long groupId, int start, int end) {

		return filterFindByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the registration requests that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching registration requests that the user has permission to view
	 */
	@Override
	public List<RegistrationRequest> filterFindByGroupId(
		long groupId, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId(groupId, start, end, orderByComparator);
		}

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				3 + (orderByComparator.getOrderByFields().length * 2));
		}
		else {
			sb = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_REGISTRATIONREQUEST_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_REGISTRATIONREQUEST_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_REGISTRATIONREQUEST_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(RegistrationRequestModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(RegistrationRequestModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), RegistrationRequest.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(
					_FILTER_ENTITY_ALIAS, RegistrationRequestImpl.class);
			}
			else {
				sqlQuery.addEntity(
					_FILTER_ENTITY_TABLE, RegistrationRequestImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			return (List<RegistrationRequest>)QueryUtil.list(
				sqlQuery, getDialect(), start, end);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the registration requests before and after the current registration request in the ordered set of registration requests that the user has permission to view where groupId = &#63;.
	 *
	 * @param registrationRequestId the primary key of the current registration request
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	@Override
	public RegistrationRequest[] filterFindByGroupId_PrevAndNext(
			long registrationRequestId, long groupId,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(
				registrationRequestId, groupId, orderByComparator);
		}

		RegistrationRequest registrationRequest = findByPrimaryKey(
			registrationRequestId);

		Session session = null;

		try {
			session = openSession();

			RegistrationRequest[] array = new RegistrationRequestImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(
				session, registrationRequest, groupId, orderByComparator, true);

			array[1] = registrationRequest;

			array[2] = filterGetByGroupId_PrevAndNext(
				session, registrationRequest, groupId, orderByComparator,
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

	protected RegistrationRequest filterGetByGroupId_PrevAndNext(
		Session session, RegistrationRequest registrationRequest, long groupId,
		OrderByComparator<RegistrationRequest> orderByComparator,
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

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_REGISTRATIONREQUEST_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_REGISTRATIONREQUEST_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_REGISTRATIONREQUEST_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByConditionFields[i],
							true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByConditionFields[i],
							true));
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByFields[i], true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByFields[i], true));
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(RegistrationRequestModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(RegistrationRequestModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), RegistrationRequest.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(
				_FILTER_ENTITY_ALIAS, RegistrationRequestImpl.class);
		}
		else {
			sqlQuery.addEntity(
				_FILTER_ENTITY_TABLE, RegistrationRequestImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						registrationRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RegistrationRequest> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the registration requests where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (RegistrationRequest registrationRequest :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(registrationRequest);
		}
	}

	/**
	 * Returns the number of registration requests where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching registration requests
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_REGISTRATIONREQUEST_WHERE);

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

	/**
	 * Returns the number of registration requests that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching registration requests that the user has permission to view
	 */
	@Override
	public int filterCountByGroupId(long groupId) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler sb = new StringBundler(2);

		sb.append(_FILTER_SQL_COUNT_REGISTRATIONREQUEST_WHERE);

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), RegistrationRequest.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			Long count = (Long)sqlQuery.uniqueResult();

			return count.intValue();
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 =
		"registrationRequest.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUserId;
	private FinderPath _finderPathWithoutPaginationFindByUserId;
	private FinderPath _finderPathCountByUserId;

	/**
	 * Returns all the registration requests where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByUserId(long userId) {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the registration requests where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @return the range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByUserId(
		long userId, int start, int end) {

		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the registration requests where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByUserId(
		long userId, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return findByUserId(userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the registration requests where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByUserId(
		long userId, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator,
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

		List<RegistrationRequest> list = null;

		if (useFinderCache) {
			list = (List<RegistrationRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RegistrationRequest registrationRequest : list) {
					if (userId != registrationRequest.getUserId()) {
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

			sb.append(_SQL_SELECT_REGISTRATIONREQUEST_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RegistrationRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				list = (List<RegistrationRequest>)QueryUtil.list(
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
	 * Returns the first registration request in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest findByUserId_First(
			long userId,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		RegistrationRequest registrationRequest = fetchByUserId_First(
			userId, orderByComparator);

		if (registrationRequest != null) {
			return registrationRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchRegistrationRequestException(sb.toString());
	}

	/**
	 * Returns the first registration request in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest fetchByUserId_First(
		long userId, OrderByComparator<RegistrationRequest> orderByComparator) {

		List<RegistrationRequest> list = findByUserId(
			userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last registration request in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest findByUserId_Last(
			long userId,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		RegistrationRequest registrationRequest = fetchByUserId_Last(
			userId, orderByComparator);

		if (registrationRequest != null) {
			return registrationRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchRegistrationRequestException(sb.toString());
	}

	/**
	 * Returns the last registration request in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest fetchByUserId_Last(
		long userId, OrderByComparator<RegistrationRequest> orderByComparator) {

		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<RegistrationRequest> list = findByUserId(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the registration requests before and after the current registration request in the ordered set where userId = &#63;.
	 *
	 * @param registrationRequestId the primary key of the current registration request
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	@Override
	public RegistrationRequest[] findByUserId_PrevAndNext(
			long registrationRequestId, long userId,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		RegistrationRequest registrationRequest = findByPrimaryKey(
			registrationRequestId);

		Session session = null;

		try {
			session = openSession();

			RegistrationRequest[] array = new RegistrationRequestImpl[3];

			array[0] = getByUserId_PrevAndNext(
				session, registrationRequest, userId, orderByComparator, true);

			array[1] = registrationRequest;

			array[2] = getByUserId_PrevAndNext(
				session, registrationRequest, userId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected RegistrationRequest getByUserId_PrevAndNext(
		Session session, RegistrationRequest registrationRequest, long userId,
		OrderByComparator<RegistrationRequest> orderByComparator,
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

		sb.append(_SQL_SELECT_REGISTRATIONREQUEST_WHERE);

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
			sb.append(RegistrationRequestModelImpl.ORDER_BY_JPQL);
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
						registrationRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RegistrationRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the registration requests where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByUserId(long userId) {
		for (RegistrationRequest registrationRequest :
				findByUserId(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(registrationRequest);
		}
	}

	/**
	 * Returns the number of registration requests where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching registration requests
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = _finderPathCountByUserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_REGISTRATIONREQUEST_WHERE);

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
		"registrationRequest.userId = ?";

	private FinderPath _finderPathWithPaginationFindByPersonalNo;
	private FinderPath _finderPathWithoutPaginationFindByPersonalNo;
	private FinderPath _finderPathCountByPersonalNo;

	/**
	 * Returns all the registration requests where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @return the matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByPersonalNo(long personalNo) {
		return findByPersonalNo(
			personalNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the registration requests where personalNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param personalNo the personal no
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @return the range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByPersonalNo(
		long personalNo, int start, int end) {

		return findByPersonalNo(personalNo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the registration requests where personalNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param personalNo the personal no
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByPersonalNo(
		long personalNo, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return findByPersonalNo(
			personalNo, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the registration requests where personalNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param personalNo the personal no
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByPersonalNo(
		long personalNo, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator,
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

		List<RegistrationRequest> list = null;

		if (useFinderCache) {
			list = (List<RegistrationRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RegistrationRequest registrationRequest : list) {
					if (personalNo != registrationRequest.getPersonalNo()) {
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

			sb.append(_SQL_SELECT_REGISTRATIONREQUEST_WHERE);

			sb.append(_FINDER_COLUMN_PERSONALNO_PERSONALNO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RegistrationRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(personalNo);

				list = (List<RegistrationRequest>)QueryUtil.list(
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
	 * Returns the first registration request in the ordered set where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest findByPersonalNo_First(
			long personalNo,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		RegistrationRequest registrationRequest = fetchByPersonalNo_First(
			personalNo, orderByComparator);

		if (registrationRequest != null) {
			return registrationRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("personalNo=");
		sb.append(personalNo);

		sb.append("}");

		throw new NoSuchRegistrationRequestException(sb.toString());
	}

	/**
	 * Returns the first registration request in the ordered set where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest fetchByPersonalNo_First(
		long personalNo,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		List<RegistrationRequest> list = findByPersonalNo(
			personalNo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last registration request in the ordered set where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest findByPersonalNo_Last(
			long personalNo,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		RegistrationRequest registrationRequest = fetchByPersonalNo_Last(
			personalNo, orderByComparator);

		if (registrationRequest != null) {
			return registrationRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("personalNo=");
		sb.append(personalNo);

		sb.append("}");

		throw new NoSuchRegistrationRequestException(sb.toString());
	}

	/**
	 * Returns the last registration request in the ordered set where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest fetchByPersonalNo_Last(
		long personalNo,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		int count = countByPersonalNo(personalNo);

		if (count == 0) {
			return null;
		}

		List<RegistrationRequest> list = findByPersonalNo(
			personalNo, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the registration requests before and after the current registration request in the ordered set where personalNo = &#63;.
	 *
	 * @param registrationRequestId the primary key of the current registration request
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	@Override
	public RegistrationRequest[] findByPersonalNo_PrevAndNext(
			long registrationRequestId, long personalNo,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		RegistrationRequest registrationRequest = findByPrimaryKey(
			registrationRequestId);

		Session session = null;

		try {
			session = openSession();

			RegistrationRequest[] array = new RegistrationRequestImpl[3];

			array[0] = getByPersonalNo_PrevAndNext(
				session, registrationRequest, personalNo, orderByComparator,
				true);

			array[1] = registrationRequest;

			array[2] = getByPersonalNo_PrevAndNext(
				session, registrationRequest, personalNo, orderByComparator,
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

	protected RegistrationRequest getByPersonalNo_PrevAndNext(
		Session session, RegistrationRequest registrationRequest,
		long personalNo,
		OrderByComparator<RegistrationRequest> orderByComparator,
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

		sb.append(_SQL_SELECT_REGISTRATIONREQUEST_WHERE);

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
			sb.append(RegistrationRequestModelImpl.ORDER_BY_JPQL);
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
						registrationRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RegistrationRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the registration requests where personalNo = &#63; from the database.
	 *
	 * @param personalNo the personal no
	 */
	@Override
	public void removeByPersonalNo(long personalNo) {
		for (RegistrationRequest registrationRequest :
				findByPersonalNo(
					personalNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(registrationRequest);
		}
	}

	/**
	 * Returns the number of registration requests where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @return the number of matching registration requests
	 */
	@Override
	public int countByPersonalNo(long personalNo) {
		FinderPath finderPath = _finderPathCountByPersonalNo;

		Object[] finderArgs = new Object[] {personalNo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_REGISTRATIONREQUEST_WHERE);

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
		"registrationRequest.personalNo = ?";

	private FinderPath _finderPathWithPaginationFindByRecordNo;
	private FinderPath _finderPathWithoutPaginationFindByRecordNo;
	private FinderPath _finderPathCountByRecordNo;

	/**
	 * Returns all the registration requests where recordNo = &#63;.
	 *
	 * @param recordNo the record no
	 * @return the matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByRecordNo(long recordNo) {
		return findByRecordNo(
			recordNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the registration requests where recordNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param recordNo the record no
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @return the range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByRecordNo(
		long recordNo, int start, int end) {

		return findByRecordNo(recordNo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the registration requests where recordNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param recordNo the record no
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByRecordNo(
		long recordNo, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return findByRecordNo(recordNo, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the registration requests where recordNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param recordNo the record no
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByRecordNo(
		long recordNo, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator,
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

		List<RegistrationRequest> list = null;

		if (useFinderCache) {
			list = (List<RegistrationRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RegistrationRequest registrationRequest : list) {
					if (recordNo != registrationRequest.getRecordNo()) {
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

			sb.append(_SQL_SELECT_REGISTRATIONREQUEST_WHERE);

			sb.append(_FINDER_COLUMN_RECORDNO_RECORDNO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RegistrationRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(recordNo);

				list = (List<RegistrationRequest>)QueryUtil.list(
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
	 * Returns the first registration request in the ordered set where recordNo = &#63;.
	 *
	 * @param recordNo the record no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest findByRecordNo_First(
			long recordNo,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		RegistrationRequest registrationRequest = fetchByRecordNo_First(
			recordNo, orderByComparator);

		if (registrationRequest != null) {
			return registrationRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("recordNo=");
		sb.append(recordNo);

		sb.append("}");

		throw new NoSuchRegistrationRequestException(sb.toString());
	}

	/**
	 * Returns the first registration request in the ordered set where recordNo = &#63;.
	 *
	 * @param recordNo the record no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest fetchByRecordNo_First(
		long recordNo,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		List<RegistrationRequest> list = findByRecordNo(
			recordNo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last registration request in the ordered set where recordNo = &#63;.
	 *
	 * @param recordNo the record no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest findByRecordNo_Last(
			long recordNo,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		RegistrationRequest registrationRequest = fetchByRecordNo_Last(
			recordNo, orderByComparator);

		if (registrationRequest != null) {
			return registrationRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("recordNo=");
		sb.append(recordNo);

		sb.append("}");

		throw new NoSuchRegistrationRequestException(sb.toString());
	}

	/**
	 * Returns the last registration request in the ordered set where recordNo = &#63;.
	 *
	 * @param recordNo the record no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest fetchByRecordNo_Last(
		long recordNo,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		int count = countByRecordNo(recordNo);

		if (count == 0) {
			return null;
		}

		List<RegistrationRequest> list = findByRecordNo(
			recordNo, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the registration requests before and after the current registration request in the ordered set where recordNo = &#63;.
	 *
	 * @param registrationRequestId the primary key of the current registration request
	 * @param recordNo the record no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	@Override
	public RegistrationRequest[] findByRecordNo_PrevAndNext(
			long registrationRequestId, long recordNo,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		RegistrationRequest registrationRequest = findByPrimaryKey(
			registrationRequestId);

		Session session = null;

		try {
			session = openSession();

			RegistrationRequest[] array = new RegistrationRequestImpl[3];

			array[0] = getByRecordNo_PrevAndNext(
				session, registrationRequest, recordNo, orderByComparator,
				true);

			array[1] = registrationRequest;

			array[2] = getByRecordNo_PrevAndNext(
				session, registrationRequest, recordNo, orderByComparator,
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

	protected RegistrationRequest getByRecordNo_PrevAndNext(
		Session session, RegistrationRequest registrationRequest, long recordNo,
		OrderByComparator<RegistrationRequest> orderByComparator,
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

		sb.append(_SQL_SELECT_REGISTRATIONREQUEST_WHERE);

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
			sb.append(RegistrationRequestModelImpl.ORDER_BY_JPQL);
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
						registrationRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RegistrationRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the registration requests where recordNo = &#63; from the database.
	 *
	 * @param recordNo the record no
	 */
	@Override
	public void removeByRecordNo(long recordNo) {
		for (RegistrationRequest registrationRequest :
				findByRecordNo(
					recordNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(registrationRequest);
		}
	}

	/**
	 * Returns the number of registration requests where recordNo = &#63;.
	 *
	 * @param recordNo the record no
	 * @return the number of matching registration requests
	 */
	@Override
	public int countByRecordNo(long recordNo) {
		FinderPath finderPath = _finderPathCountByRecordNo;

		Object[] finderArgs = new Object[] {recordNo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_REGISTRATIONREQUEST_WHERE);

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
		"registrationRequest.recordNo = ?";

	private FinderPath _finderPathWithPaginationFindByEmailAddress;
	private FinderPath _finderPathWithoutPaginationFindByEmailAddress;
	private FinderPath _finderPathCountByEmailAddress;

	/**
	 * Returns all the registration requests where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @return the matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByEmailAddress(String emailAddress) {
		return findByEmailAddress(
			emailAddress, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the registration requests where emailAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param emailAddress the email address
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @return the range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByEmailAddress(
		String emailAddress, int start, int end) {

		return findByEmailAddress(emailAddress, start, end, null);
	}

	/**
	 * Returns an ordered range of all the registration requests where emailAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param emailAddress the email address
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByEmailAddress(
		String emailAddress, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return findByEmailAddress(
			emailAddress, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the registration requests where emailAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param emailAddress the email address
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByEmailAddress(
		String emailAddress, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator,
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

		List<RegistrationRequest> list = null;

		if (useFinderCache) {
			list = (List<RegistrationRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RegistrationRequest registrationRequest : list) {
					if (!emailAddress.equals(
							registrationRequest.getEmailAddress())) {

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

			sb.append(_SQL_SELECT_REGISTRATIONREQUEST_WHERE);

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
				sb.append(RegistrationRequestModelImpl.ORDER_BY_JPQL);
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

				list = (List<RegistrationRequest>)QueryUtil.list(
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
	 * Returns the first registration request in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest findByEmailAddress_First(
			String emailAddress,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		RegistrationRequest registrationRequest = fetchByEmailAddress_First(
			emailAddress, orderByComparator);

		if (registrationRequest != null) {
			return registrationRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("emailAddress=");
		sb.append(emailAddress);

		sb.append("}");

		throw new NoSuchRegistrationRequestException(sb.toString());
	}

	/**
	 * Returns the first registration request in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest fetchByEmailAddress_First(
		String emailAddress,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		List<RegistrationRequest> list = findByEmailAddress(
			emailAddress, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last registration request in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest findByEmailAddress_Last(
			String emailAddress,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		RegistrationRequest registrationRequest = fetchByEmailAddress_Last(
			emailAddress, orderByComparator);

		if (registrationRequest != null) {
			return registrationRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("emailAddress=");
		sb.append(emailAddress);

		sb.append("}");

		throw new NoSuchRegistrationRequestException(sb.toString());
	}

	/**
	 * Returns the last registration request in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest fetchByEmailAddress_Last(
		String emailAddress,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		int count = countByEmailAddress(emailAddress);

		if (count == 0) {
			return null;
		}

		List<RegistrationRequest> list = findByEmailAddress(
			emailAddress, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the registration requests before and after the current registration request in the ordered set where emailAddress = &#63;.
	 *
	 * @param registrationRequestId the primary key of the current registration request
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	@Override
	public RegistrationRequest[] findByEmailAddress_PrevAndNext(
			long registrationRequestId, String emailAddress,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		emailAddress = Objects.toString(emailAddress, "");

		RegistrationRequest registrationRequest = findByPrimaryKey(
			registrationRequestId);

		Session session = null;

		try {
			session = openSession();

			RegistrationRequest[] array = new RegistrationRequestImpl[3];

			array[0] = getByEmailAddress_PrevAndNext(
				session, registrationRequest, emailAddress, orderByComparator,
				true);

			array[1] = registrationRequest;

			array[2] = getByEmailAddress_PrevAndNext(
				session, registrationRequest, emailAddress, orderByComparator,
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

	protected RegistrationRequest getByEmailAddress_PrevAndNext(
		Session session, RegistrationRequest registrationRequest,
		String emailAddress,
		OrderByComparator<RegistrationRequest> orderByComparator,
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

		sb.append(_SQL_SELECT_REGISTRATIONREQUEST_WHERE);

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
			sb.append(RegistrationRequestModelImpl.ORDER_BY_JPQL);
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
						registrationRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RegistrationRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the registration requests where emailAddress = &#63; from the database.
	 *
	 * @param emailAddress the email address
	 */
	@Override
	public void removeByEmailAddress(String emailAddress) {
		for (RegistrationRequest registrationRequest :
				findByEmailAddress(
					emailAddress, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(registrationRequest);
		}
	}

	/**
	 * Returns the number of registration requests where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @return the number of matching registration requests
	 */
	@Override
	public int countByEmailAddress(String emailAddress) {
		emailAddress = Objects.toString(emailAddress, "");

		FinderPath finderPath = _finderPathCountByEmailAddress;

		Object[] finderArgs = new Object[] {emailAddress};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_REGISTRATIONREQUEST_WHERE);

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
		"registrationRequest.emailAddress = ?";

	private static final String _FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_3 =
		"(registrationRequest.emailAddress IS NULL OR registrationRequest.emailAddress = '')";

	private FinderPath _finderPathWithPaginationFindByLoginIdAndStatus;
	private FinderPath _finderPathWithoutPaginationFindByLoginIdAndStatus;
	private FinderPath _finderPathCountByLoginIdAndStatus;

	/**
	 * Returns all the registration requests where loginId = &#63; and status = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @return the matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByLoginIdAndStatus(
		String loginId, int status) {

		return findByLoginIdAndStatus(
			loginId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the registration requests where loginId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @return the range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByLoginIdAndStatus(
		String loginId, int status, int start, int end) {

		return findByLoginIdAndStatus(loginId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the registration requests where loginId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByLoginIdAndStatus(
		String loginId, int status, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return findByLoginIdAndStatus(
			loginId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the registration requests where loginId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByLoginIdAndStatus(
		String loginId, int status, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator,
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

		List<RegistrationRequest> list = null;

		if (useFinderCache) {
			list = (List<RegistrationRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RegistrationRequest registrationRequest : list) {
					if (!loginId.equals(registrationRequest.getLoginId()) ||
						(status != registrationRequest.getStatus())) {

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

			sb.append(_SQL_SELECT_REGISTRATIONREQUEST_WHERE);

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
				sb.append(RegistrationRequestModelImpl.ORDER_BY_JPQL);
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

				list = (List<RegistrationRequest>)QueryUtil.list(
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
	 * Returns the first registration request in the ordered set where loginId = &#63; and status = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest findByLoginIdAndStatus_First(
			String loginId, int status,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		RegistrationRequest registrationRequest = fetchByLoginIdAndStatus_First(
			loginId, status, orderByComparator);

		if (registrationRequest != null) {
			return registrationRequest;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("loginId=");
		sb.append(loginId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchRegistrationRequestException(sb.toString());
	}

	/**
	 * Returns the first registration request in the ordered set where loginId = &#63; and status = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest fetchByLoginIdAndStatus_First(
		String loginId, int status,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		List<RegistrationRequest> list = findByLoginIdAndStatus(
			loginId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last registration request in the ordered set where loginId = &#63; and status = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest findByLoginIdAndStatus_Last(
			String loginId, int status,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		RegistrationRequest registrationRequest = fetchByLoginIdAndStatus_Last(
			loginId, status, orderByComparator);

		if (registrationRequest != null) {
			return registrationRequest;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("loginId=");
		sb.append(loginId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchRegistrationRequestException(sb.toString());
	}

	/**
	 * Returns the last registration request in the ordered set where loginId = &#63; and status = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest fetchByLoginIdAndStatus_Last(
		String loginId, int status,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		int count = countByLoginIdAndStatus(loginId, status);

		if (count == 0) {
			return null;
		}

		List<RegistrationRequest> list = findByLoginIdAndStatus(
			loginId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the registration requests before and after the current registration request in the ordered set where loginId = &#63; and status = &#63;.
	 *
	 * @param registrationRequestId the primary key of the current registration request
	 * @param loginId the login ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	@Override
	public RegistrationRequest[] findByLoginIdAndStatus_PrevAndNext(
			long registrationRequestId, String loginId, int status,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		loginId = Objects.toString(loginId, "");

		RegistrationRequest registrationRequest = findByPrimaryKey(
			registrationRequestId);

		Session session = null;

		try {
			session = openSession();

			RegistrationRequest[] array = new RegistrationRequestImpl[3];

			array[0] = getByLoginIdAndStatus_PrevAndNext(
				session, registrationRequest, loginId, status,
				orderByComparator, true);

			array[1] = registrationRequest;

			array[2] = getByLoginIdAndStatus_PrevAndNext(
				session, registrationRequest, loginId, status,
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

	protected RegistrationRequest getByLoginIdAndStatus_PrevAndNext(
		Session session, RegistrationRequest registrationRequest,
		String loginId, int status,
		OrderByComparator<RegistrationRequest> orderByComparator,
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

		sb.append(_SQL_SELECT_REGISTRATIONREQUEST_WHERE);

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
			sb.append(RegistrationRequestModelImpl.ORDER_BY_JPQL);
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
						registrationRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RegistrationRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the registration requests where loginId = &#63; and status = &#63; from the database.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 */
	@Override
	public void removeByLoginIdAndStatus(String loginId, int status) {
		for (RegistrationRequest registrationRequest :
				findByLoginIdAndStatus(
					loginId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(registrationRequest);
		}
	}

	/**
	 * Returns the number of registration requests where loginId = &#63; and status = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @return the number of matching registration requests
	 */
	@Override
	public int countByLoginIdAndStatus(String loginId, int status) {
		loginId = Objects.toString(loginId, "");

		FinderPath finderPath = _finderPathCountByLoginIdAndStatus;

		Object[] finderArgs = new Object[] {loginId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_REGISTRATIONREQUEST_WHERE);

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
		"registrationRequest.loginId = ? AND ";

	private static final String _FINDER_COLUMN_LOGINIDANDSTATUS_LOGINID_3 =
		"(registrationRequest.loginId IS NULL OR registrationRequest.loginId = '') AND ";

	private static final String _FINDER_COLUMN_LOGINIDANDSTATUS_STATUS_2 =
		"registrationRequest.status = ?";

	private FinderPath
		_finderPathWithPaginationFindByLoginIdStatusStateAndIdamUserCreated;
	private FinderPath
		_finderPathWithoutPaginationFindByLoginIdStatusStateAndIdamUserCreated;
	private FinderPath _finderPathCountByLoginIdStatusStateAndIdamUserCreated;

	/**
	 * Returns all the registration requests where loginId = &#63; and status = &#63; and state = &#63; and idamUserCreated = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param state the state
	 * @param idamUserCreated the idam user created
	 * @return the matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByLoginIdStatusStateAndIdamUserCreated(
		String loginId, int status, String state, boolean idamUserCreated) {

		return findByLoginIdStatusStateAndIdamUserCreated(
			loginId, status, state, idamUserCreated, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the registration requests where loginId = &#63; and status = &#63; and state = &#63; and idamUserCreated = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param state the state
	 * @param idamUserCreated the idam user created
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @return the range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByLoginIdStatusStateAndIdamUserCreated(
		String loginId, int status, String state, boolean idamUserCreated,
		int start, int end) {

		return findByLoginIdStatusStateAndIdamUserCreated(
			loginId, status, state, idamUserCreated, start, end, null);
	}

	/**
	 * Returns an ordered range of all the registration requests where loginId = &#63; and status = &#63; and state = &#63; and idamUserCreated = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param state the state
	 * @param idamUserCreated the idam user created
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByLoginIdStatusStateAndIdamUserCreated(
		String loginId, int status, String state, boolean idamUserCreated,
		int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return findByLoginIdStatusStateAndIdamUserCreated(
			loginId, status, state, idamUserCreated, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the registration requests where loginId = &#63; and status = &#63; and state = &#63; and idamUserCreated = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param state the state
	 * @param idamUserCreated the idam user created
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching registration requests
	 */
	@Override
	public List<RegistrationRequest> findByLoginIdStatusStateAndIdamUserCreated(
		String loginId, int status, String state, boolean idamUserCreated,
		int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator,
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

		List<RegistrationRequest> list = null;

		if (useFinderCache) {
			list = (List<RegistrationRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RegistrationRequest registrationRequest : list) {
					if (!loginId.equals(registrationRequest.getLoginId()) ||
						(status != registrationRequest.getStatus()) ||
						!state.equals(registrationRequest.getState()) ||
						(idamUserCreated !=
							registrationRequest.isIdamUserCreated())) {

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

			sb.append(_SQL_SELECT_REGISTRATIONREQUEST_WHERE);

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
				sb.append(RegistrationRequestModelImpl.ORDER_BY_JPQL);
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

				list = (List<RegistrationRequest>)QueryUtil.list(
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
	 * Returns the first registration request in the ordered set where loginId = &#63; and status = &#63; and state = &#63; and idamUserCreated = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param state the state
	 * @param idamUserCreated the idam user created
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest findByLoginIdStatusStateAndIdamUserCreated_First(
			String loginId, int status, String state, boolean idamUserCreated,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		RegistrationRequest registrationRequest =
			fetchByLoginIdStatusStateAndIdamUserCreated_First(
				loginId, status, state, idamUserCreated, orderByComparator);

		if (registrationRequest != null) {
			return registrationRequest;
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

		throw new NoSuchRegistrationRequestException(sb.toString());
	}

	/**
	 * Returns the first registration request in the ordered set where loginId = &#63; and status = &#63; and state = &#63; and idamUserCreated = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param state the state
	 * @param idamUserCreated the idam user created
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest
		fetchByLoginIdStatusStateAndIdamUserCreated_First(
			String loginId, int status, String state, boolean idamUserCreated,
			OrderByComparator<RegistrationRequest> orderByComparator) {

		List<RegistrationRequest> list =
			findByLoginIdStatusStateAndIdamUserCreated(
				loginId, status, state, idamUserCreated, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last registration request in the ordered set where loginId = &#63; and status = &#63; and state = &#63; and idamUserCreated = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param state the state
	 * @param idamUserCreated the idam user created
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest findByLoginIdStatusStateAndIdamUserCreated_Last(
			String loginId, int status, String state, boolean idamUserCreated,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		RegistrationRequest registrationRequest =
			fetchByLoginIdStatusStateAndIdamUserCreated_Last(
				loginId, status, state, idamUserCreated, orderByComparator);

		if (registrationRequest != null) {
			return registrationRequest;
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

		throw new NoSuchRegistrationRequestException(sb.toString());
	}

	/**
	 * Returns the last registration request in the ordered set where loginId = &#63; and status = &#63; and state = &#63; and idamUserCreated = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param state the state
	 * @param idamUserCreated the idam user created
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	@Override
	public RegistrationRequest fetchByLoginIdStatusStateAndIdamUserCreated_Last(
		String loginId, int status, String state, boolean idamUserCreated,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		int count = countByLoginIdStatusStateAndIdamUserCreated(
			loginId, status, state, idamUserCreated);

		if (count == 0) {
			return null;
		}

		List<RegistrationRequest> list =
			findByLoginIdStatusStateAndIdamUserCreated(
				loginId, status, state, idamUserCreated, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the registration requests before and after the current registration request in the ordered set where loginId = &#63; and status = &#63; and state = &#63; and idamUserCreated = &#63;.
	 *
	 * @param registrationRequestId the primary key of the current registration request
	 * @param loginId the login ID
	 * @param status the status
	 * @param state the state
	 * @param idamUserCreated the idam user created
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	@Override
	public RegistrationRequest[]
			findByLoginIdStatusStateAndIdamUserCreated_PrevAndNext(
				long registrationRequestId, String loginId, int status,
				String state, boolean idamUserCreated,
				OrderByComparator<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException {

		loginId = Objects.toString(loginId, "");
		state = Objects.toString(state, "");

		RegistrationRequest registrationRequest = findByPrimaryKey(
			registrationRequestId);

		Session session = null;

		try {
			session = openSession();

			RegistrationRequest[] array = new RegistrationRequestImpl[3];

			array[0] = getByLoginIdStatusStateAndIdamUserCreated_PrevAndNext(
				session, registrationRequest, loginId, status, state,
				idamUserCreated, orderByComparator, true);

			array[1] = registrationRequest;

			array[2] = getByLoginIdStatusStateAndIdamUserCreated_PrevAndNext(
				session, registrationRequest, loginId, status, state,
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

	protected RegistrationRequest
		getByLoginIdStatusStateAndIdamUserCreated_PrevAndNext(
			Session session, RegistrationRequest registrationRequest,
			String loginId, int status, String state, boolean idamUserCreated,
			OrderByComparator<RegistrationRequest> orderByComparator,
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

		sb.append(_SQL_SELECT_REGISTRATIONREQUEST_WHERE);

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
			sb.append(RegistrationRequestModelImpl.ORDER_BY_JPQL);
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
						registrationRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RegistrationRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the registration requests where loginId = &#63; and status = &#63; and state = &#63; and idamUserCreated = &#63; from the database.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param state the state
	 * @param idamUserCreated the idam user created
	 */
	@Override
	public void removeByLoginIdStatusStateAndIdamUserCreated(
		String loginId, int status, String state, boolean idamUserCreated) {

		for (RegistrationRequest registrationRequest :
				findByLoginIdStatusStateAndIdamUserCreated(
					loginId, status, state, idamUserCreated, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(registrationRequest);
		}
	}

	/**
	 * Returns the number of registration requests where loginId = &#63; and status = &#63; and state = &#63; and idamUserCreated = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param state the state
	 * @param idamUserCreated the idam user created
	 * @return the number of matching registration requests
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

			sb.append(_SQL_COUNT_REGISTRATIONREQUEST_WHERE);

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
			"registrationRequest.loginId = ? AND ";

	private static final String
		_FINDER_COLUMN_LOGINIDSTATUSSTATEANDIDAMUSERCREATED_LOGINID_3 =
			"(registrationRequest.loginId IS NULL OR registrationRequest.loginId = '') AND ";

	private static final String
		_FINDER_COLUMN_LOGINIDSTATUSSTATEANDIDAMUSERCREATED_STATUS_2 =
			"registrationRequest.status = ? AND ";

	private static final String
		_FINDER_COLUMN_LOGINIDSTATUSSTATEANDIDAMUSERCREATED_STATE_2 =
			"registrationRequest.state = ? AND ";

	private static final String
		_FINDER_COLUMN_LOGINIDSTATUSSTATEANDIDAMUSERCREATED_STATE_3 =
			"(registrationRequest.state IS NULL OR registrationRequest.state = '') AND ";

	private static final String
		_FINDER_COLUMN_LOGINIDSTATUSSTATEANDIDAMUSERCREATED_IDAMUSERCREATED_2 =
			"registrationRequest.idamUserCreated = ?";

	public RegistrationRequestPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("state", "state_");
		dbColumnNames.put("rank", "rank_");

		setDBColumnNames(dbColumnNames);

		setModelClass(RegistrationRequest.class);

		setModelImplClass(RegistrationRequestImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the registration request in the entity cache if it is enabled.
	 *
	 * @param registrationRequest the registration request
	 */
	@Override
	public void cacheResult(RegistrationRequest registrationRequest) {
		entityCache.putResult(
			RegistrationRequestImpl.class, registrationRequest.getPrimaryKey(),
			registrationRequest);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				registrationRequest.getUuid(), registrationRequest.getGroupId()
			},
			registrationRequest);
	}

	/**
	 * Caches the registration requests in the entity cache if it is enabled.
	 *
	 * @param registrationRequests the registration requests
	 */
	@Override
	public void cacheResult(List<RegistrationRequest> registrationRequests) {
		for (RegistrationRequest registrationRequest : registrationRequests) {
			if (entityCache.getResult(
					RegistrationRequestImpl.class,
					registrationRequest.getPrimaryKey()) == null) {

				cacheResult(registrationRequest);
			}
		}
	}

	/**
	 * Clears the cache for all registration requests.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RegistrationRequestImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the registration request.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RegistrationRequest registrationRequest) {
		entityCache.removeResult(
			RegistrationRequestImpl.class, registrationRequest);
	}

	@Override
	public void clearCache(List<RegistrationRequest> registrationRequests) {
		for (RegistrationRequest registrationRequest : registrationRequests) {
			entityCache.removeResult(
				RegistrationRequestImpl.class, registrationRequest);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(RegistrationRequestImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		RegistrationRequestModelImpl registrationRequestModelImpl) {

		Object[] args = new Object[] {
			registrationRequestModelImpl.getUuid(),
			registrationRequestModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, registrationRequestModelImpl,
			false);
	}

	/**
	 * Creates a new registration request with the primary key. Does not add the registration request to the database.
	 *
	 * @param registrationRequestId the primary key for the new registration request
	 * @return the new registration request
	 */
	@Override
	public RegistrationRequest create(long registrationRequestId) {
		RegistrationRequest registrationRequest = new RegistrationRequestImpl();

		registrationRequest.setNew(true);
		registrationRequest.setPrimaryKey(registrationRequestId);

		String uuid = PortalUUIDUtil.generate();

		registrationRequest.setUuid(uuid);

		registrationRequest.setCompanyId(CompanyThreadLocal.getCompanyId());

		return registrationRequest;
	}

	/**
	 * Removes the registration request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param registrationRequestId the primary key of the registration request
	 * @return the registration request that was removed
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	@Override
	public RegistrationRequest remove(long registrationRequestId)
		throws NoSuchRegistrationRequestException {

		return remove((Serializable)registrationRequestId);
	}

	/**
	 * Removes the registration request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the registration request
	 * @return the registration request that was removed
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	@Override
	public RegistrationRequest remove(Serializable primaryKey)
		throws NoSuchRegistrationRequestException {

		Session session = null;

		try {
			session = openSession();

			RegistrationRequest registrationRequest =
				(RegistrationRequest)session.get(
					RegistrationRequestImpl.class, primaryKey);

			if (registrationRequest == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRegistrationRequestException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(registrationRequest);
		}
		catch (NoSuchRegistrationRequestException noSuchEntityException) {
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
	protected RegistrationRequest removeImpl(
		RegistrationRequest registrationRequest) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(registrationRequest)) {
				registrationRequest = (RegistrationRequest)session.get(
					RegistrationRequestImpl.class,
					registrationRequest.getPrimaryKeyObj());
			}

			if (registrationRequest != null) {
				session.delete(registrationRequest);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (registrationRequest != null) {
			clearCache(registrationRequest);
		}

		return registrationRequest;
	}

	@Override
	public RegistrationRequest updateImpl(
		RegistrationRequest registrationRequest) {

		boolean isNew = registrationRequest.isNew();

		if (!(registrationRequest instanceof RegistrationRequestModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(registrationRequest.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					registrationRequest);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in registrationRequest proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom RegistrationRequest implementation " +
					registrationRequest.getClass());
		}

		RegistrationRequestModelImpl registrationRequestModelImpl =
			(RegistrationRequestModelImpl)registrationRequest;

		if (Validator.isNull(registrationRequest.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			registrationRequest.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (registrationRequest.getCreateDate() == null)) {
			if (serviceContext == null) {
				registrationRequest.setCreateDate(now);
			}
			else {
				registrationRequest.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!registrationRequestModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				registrationRequest.setModifiedDate(now);
			}
			else {
				registrationRequest.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(registrationRequest);
			}
			else {
				registrationRequest = (RegistrationRequest)session.merge(
					registrationRequest);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			RegistrationRequestImpl.class, registrationRequestModelImpl, false,
			true);

		cacheUniqueFindersCache(registrationRequestModelImpl);

		if (isNew) {
			registrationRequest.setNew(false);
		}

		registrationRequest.resetOriginalValues();

		return registrationRequest;
	}

	/**
	 * Returns the registration request with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the registration request
	 * @return the registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	@Override
	public RegistrationRequest findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRegistrationRequestException {

		RegistrationRequest registrationRequest = fetchByPrimaryKey(primaryKey);

		if (registrationRequest == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRegistrationRequestException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return registrationRequest;
	}

	/**
	 * Returns the registration request with the primary key or throws a <code>NoSuchRegistrationRequestException</code> if it could not be found.
	 *
	 * @param registrationRequestId the primary key of the registration request
	 * @return the registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	@Override
	public RegistrationRequest findByPrimaryKey(long registrationRequestId)
		throws NoSuchRegistrationRequestException {

		return findByPrimaryKey((Serializable)registrationRequestId);
	}

	/**
	 * Returns the registration request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param registrationRequestId the primary key of the registration request
	 * @return the registration request, or <code>null</code> if a registration request with the primary key could not be found
	 */
	@Override
	public RegistrationRequest fetchByPrimaryKey(long registrationRequestId) {
		return fetchByPrimaryKey((Serializable)registrationRequestId);
	}

	/**
	 * Returns all the registration requests.
	 *
	 * @return the registration requests
	 */
	@Override
	public List<RegistrationRequest> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the registration requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @return the range of registration requests
	 */
	@Override
	public List<RegistrationRequest> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the registration requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of registration requests
	 */
	@Override
	public List<RegistrationRequest> findAll(
		int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the registration requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of registration requests
	 */
	@Override
	public List<RegistrationRequest> findAll(
		int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator,
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

		List<RegistrationRequest> list = null;

		if (useFinderCache) {
			list = (List<RegistrationRequest>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_REGISTRATIONREQUEST);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_REGISTRATIONREQUEST;

				sql = sql.concat(RegistrationRequestModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<RegistrationRequest>)QueryUtil.list(
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
	 * Removes all the registration requests from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RegistrationRequest registrationRequest : findAll()) {
			remove(registrationRequest);
		}
	}

	/**
	 * Returns the number of registration requests.
	 *
	 * @return the number of registration requests
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
					_SQL_COUNT_REGISTRATIONREQUEST);

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
		return "registrationRequestId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_REGISTRATIONREQUEST;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return RegistrationRequestModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the registration request persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new RegistrationRequestModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", RegistrationRequest.class.getName()));

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

		_finderPathWithPaginationFindByBulkOnbordingFileId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByBulkOnbordingFileId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"bulkOnbordingFileId"}, true);

		_finderPathWithoutPaginationFindByBulkOnbordingFileId =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByBulkOnbordingFileId",
				new String[] {Long.class.getName()},
				new String[] {"bulkOnbordingFileId"}, true);

		_finderPathCountByBulkOnbordingFileId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByBulkOnbordingFileId", new String[] {Long.class.getName()},
			new String[] {"bulkOnbordingFileId"}, false);

		_finderPathWithPaginationFindByBulkOnbordingFileIdAndStatus =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByBulkOnbordingFileIdAndStatus",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {"bulkOnbordingFileId", "status"}, true);

		_finderPathWithoutPaginationFindByBulkOnbordingFileIdAndStatus =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByBulkOnbordingFileIdAndStatus",
				new String[] {Long.class.getName(), Integer.class.getName()},
				new String[] {"bulkOnbordingFileId", "status"}, true);

		_finderPathCountByBulkOnbordingFileIdAndStatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByBulkOnbordingFileIdAndStatus",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"bulkOnbordingFileId", "status"}, false);

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
		entityCache.removeCache(RegistrationRequestImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	@Override
	@Reference(
		target = OFBPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = OFBPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = OFBPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_REGISTRATIONREQUEST =
		"SELECT registrationRequest FROM RegistrationRequest registrationRequest";

	private static final String _SQL_SELECT_REGISTRATIONREQUEST_WHERE =
		"SELECT registrationRequest FROM RegistrationRequest registrationRequest WHERE ";

	private static final String _SQL_COUNT_REGISTRATIONREQUEST =
		"SELECT COUNT(registrationRequest) FROM RegistrationRequest registrationRequest";

	private static final String _SQL_COUNT_REGISTRATIONREQUEST_WHERE =
		"SELECT COUNT(registrationRequest) FROM RegistrationRequest registrationRequest WHERE ";

	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN =
		"registrationRequest.registrationRequestId";

	private static final String _FILTER_SQL_SELECT_REGISTRATIONREQUEST_WHERE =
		"SELECT DISTINCT {registrationRequest.*} FROM OFB_RegistrationRequest registrationRequest WHERE ";

	private static final String
		_FILTER_SQL_SELECT_REGISTRATIONREQUEST_NO_INLINE_DISTINCT_WHERE_1 =
			"SELECT {OFB_RegistrationRequest.*} FROM (SELECT DISTINCT registrationRequest.registrationRequestId FROM OFB_RegistrationRequest registrationRequest WHERE ";

	private static final String
		_FILTER_SQL_SELECT_REGISTRATIONREQUEST_NO_INLINE_DISTINCT_WHERE_2 =
			") TEMP_TABLE INNER JOIN OFB_RegistrationRequest ON TEMP_TABLE.registrationRequestId = OFB_RegistrationRequest.registrationRequestId";

	private static final String _FILTER_SQL_COUNT_REGISTRATIONREQUEST_WHERE =
		"SELECT COUNT(DISTINCT registrationRequest.registrationRequestId) AS COUNT_VALUE FROM OFB_RegistrationRequest registrationRequest WHERE ";

	private static final String _FILTER_ENTITY_ALIAS = "registrationRequest";

	private static final String _FILTER_ENTITY_TABLE =
		"OFB_RegistrationRequest";

	private static final String _ORDER_BY_ENTITY_ALIAS = "registrationRequest.";

	private static final String _ORDER_BY_ENTITY_TABLE =
		"OFB_RegistrationRequest.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No RegistrationRequest exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No RegistrationRequest exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		RegistrationRequestPersistenceImpl.class);

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

	private static class RegistrationRequestModelArgumentsResolver
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

			RegistrationRequestModelImpl registrationRequestModelImpl =
				(RegistrationRequestModelImpl)baseModel;

			long columnBitmask =
				registrationRequestModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					registrationRequestModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						registrationRequestModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					registrationRequestModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			RegistrationRequestModelImpl registrationRequestModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						registrationRequestModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = registrationRequestModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}