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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeDeputationRequestException;
import com.adjecti.pis.liferay.model.EmployeeDeputationRequest;
import com.adjecti.pis.liferay.model.impl.EmployeeDeputationRequestImpl;
import com.adjecti.pis.liferay.model.impl.EmployeeDeputationRequestModelImpl;
import com.adjecti.pis.liferay.service.persistence.EmployeeDeputationRequestPersistence;
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
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
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
 * The persistence implementation for the employee deputation request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EmployeeDeputationRequestPersistence.class)
public class EmployeeDeputationRequestPersistenceImpl
	extends BasePersistenceImpl<EmployeeDeputationRequest>
	implements EmployeeDeputationRequestPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EmployeeDeputationRequestUtil</code> to access the employee deputation request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EmployeeDeputationRequestImpl.class.getName();

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
	 * Returns all the employee deputation requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching employee deputation requests
	 */
	@Override
	public List<EmployeeDeputationRequest> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee deputation requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDeputationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee deputation requests
	 * @param end the upper bound of the range of employee deputation requests (not inclusive)
	 * @return the range of matching employee deputation requests
	 */
	@Override
	public List<EmployeeDeputationRequest> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee deputation requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDeputationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee deputation requests
	 * @param end the upper bound of the range of employee deputation requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee deputation requests
	 */
	@Override
	public List<EmployeeDeputationRequest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmployeeDeputationRequest> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee deputation requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDeputationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee deputation requests
	 * @param end the upper bound of the range of employee deputation requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee deputation requests
	 */
	@Override
	public List<EmployeeDeputationRequest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmployeeDeputationRequest> orderByComparator,
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

		List<EmployeeDeputationRequest> list = null;

		if (useFinderCache) {
			list = (List<EmployeeDeputationRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeDeputationRequest employeeDeputationRequest :
						list) {

					if (!uuid.equals(employeeDeputationRequest.getUuid())) {
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

			sb.append(_SQL_SELECT_EMPLOYEEDEPUTATIONREQUEST_WHERE);

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
				sb.append(EmployeeDeputationRequestModelImpl.ORDER_BY_JPQL);
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

				list = (List<EmployeeDeputationRequest>)QueryUtil.list(
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
	 * Returns the first employee deputation request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee deputation request
	 * @throws NoSuchEmployeeDeputationRequestException if a matching employee deputation request could not be found
	 */
	@Override
	public EmployeeDeputationRequest findByUuid_First(
			String uuid,
			OrderByComparator<EmployeeDeputationRequest> orderByComparator)
		throws NoSuchEmployeeDeputationRequestException {

		EmployeeDeputationRequest employeeDeputationRequest = fetchByUuid_First(
			uuid, orderByComparator);

		if (employeeDeputationRequest != null) {
			return employeeDeputationRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchEmployeeDeputationRequestException(sb.toString());
	}

	/**
	 * Returns the first employee deputation request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee deputation request, or <code>null</code> if a matching employee deputation request could not be found
	 */
	@Override
	public EmployeeDeputationRequest fetchByUuid_First(
		String uuid,
		OrderByComparator<EmployeeDeputationRequest> orderByComparator) {

		List<EmployeeDeputationRequest> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee deputation request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee deputation request
	 * @throws NoSuchEmployeeDeputationRequestException if a matching employee deputation request could not be found
	 */
	@Override
	public EmployeeDeputationRequest findByUuid_Last(
			String uuid,
			OrderByComparator<EmployeeDeputationRequest> orderByComparator)
		throws NoSuchEmployeeDeputationRequestException {

		EmployeeDeputationRequest employeeDeputationRequest = fetchByUuid_Last(
			uuid, orderByComparator);

		if (employeeDeputationRequest != null) {
			return employeeDeputationRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchEmployeeDeputationRequestException(sb.toString());
	}

	/**
	 * Returns the last employee deputation request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee deputation request, or <code>null</code> if a matching employee deputation request could not be found
	 */
	@Override
	public EmployeeDeputationRequest fetchByUuid_Last(
		String uuid,
		OrderByComparator<EmployeeDeputationRequest> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<EmployeeDeputationRequest> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee deputation requests before and after the current employee deputation request in the ordered set where uuid = &#63;.
	 *
	 * @param employeeDeputationRequestId the primary key of the current employee deputation request
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee deputation request
	 * @throws NoSuchEmployeeDeputationRequestException if a employee deputation request with the primary key could not be found
	 */
	@Override
	public EmployeeDeputationRequest[] findByUuid_PrevAndNext(
			long employeeDeputationRequestId, String uuid,
			OrderByComparator<EmployeeDeputationRequest> orderByComparator)
		throws NoSuchEmployeeDeputationRequestException {

		uuid = Objects.toString(uuid, "");

		EmployeeDeputationRequest employeeDeputationRequest = findByPrimaryKey(
			employeeDeputationRequestId);

		Session session = null;

		try {
			session = openSession();

			EmployeeDeputationRequest[] array =
				new EmployeeDeputationRequestImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, employeeDeputationRequest, uuid, orderByComparator,
				true);

			array[1] = employeeDeputationRequest;

			array[2] = getByUuid_PrevAndNext(
				session, employeeDeputationRequest, uuid, orderByComparator,
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

	protected EmployeeDeputationRequest getByUuid_PrevAndNext(
		Session session, EmployeeDeputationRequest employeeDeputationRequest,
		String uuid,
		OrderByComparator<EmployeeDeputationRequest> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEDEPUTATIONREQUEST_WHERE);

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
			sb.append(EmployeeDeputationRequestModelImpl.ORDER_BY_JPQL);
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
						employeeDeputationRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeDeputationRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee deputation requests where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (EmployeeDeputationRequest employeeDeputationRequest :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeeDeputationRequest);
		}
	}

	/**
	 * Returns the number of employee deputation requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching employee deputation requests
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEDEPUTATIONREQUEST_WHERE);

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
		"employeeDeputationRequest.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(employeeDeputationRequest.uuid IS NULL OR employeeDeputationRequest.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the employee deputation request where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmployeeDeputationRequestException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee deputation request
	 * @throws NoSuchEmployeeDeputationRequestException if a matching employee deputation request could not be found
	 */
	@Override
	public EmployeeDeputationRequest findByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeDeputationRequestException {

		EmployeeDeputationRequest employeeDeputationRequest = fetchByUUID_G(
			uuid, groupId);

		if (employeeDeputationRequest == null) {
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

			throw new NoSuchEmployeeDeputationRequestException(sb.toString());
		}

		return employeeDeputationRequest;
	}

	/**
	 * Returns the employee deputation request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee deputation request, or <code>null</code> if a matching employee deputation request could not be found
	 */
	@Override
	public EmployeeDeputationRequest fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the employee deputation request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee deputation request, or <code>null</code> if a matching employee deputation request could not be found
	 */
	@Override
	public EmployeeDeputationRequest fetchByUUID_G(
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

		if (result instanceof EmployeeDeputationRequest) {
			EmployeeDeputationRequest employeeDeputationRequest =
				(EmployeeDeputationRequest)result;

			if (!Objects.equals(uuid, employeeDeputationRequest.getUuid()) ||
				(groupId != employeeDeputationRequest.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_EMPLOYEEDEPUTATIONREQUEST_WHERE);

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

				List<EmployeeDeputationRequest> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					EmployeeDeputationRequest employeeDeputationRequest =
						list.get(0);

					result = employeeDeputationRequest;

					cacheResult(employeeDeputationRequest);
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
			return (EmployeeDeputationRequest)result;
		}
	}

	/**
	 * Removes the employee deputation request where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the employee deputation request that was removed
	 */
	@Override
	public EmployeeDeputationRequest removeByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeDeputationRequestException {

		EmployeeDeputationRequest employeeDeputationRequest = findByUUID_G(
			uuid, groupId);

		return remove(employeeDeputationRequest);
	}

	/**
	 * Returns the number of employee deputation requests where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching employee deputation requests
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_EMPLOYEEDEPUTATIONREQUEST_WHERE);

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
		"employeeDeputationRequest.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(employeeDeputationRequest.uuid IS NULL OR employeeDeputationRequest.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"employeeDeputationRequest.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the employee deputation requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching employee deputation requests
	 */
	@Override
	public List<EmployeeDeputationRequest> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee deputation requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDeputationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee deputation requests
	 * @param end the upper bound of the range of employee deputation requests (not inclusive)
	 * @return the range of matching employee deputation requests
	 */
	@Override
	public List<EmployeeDeputationRequest> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee deputation requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDeputationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee deputation requests
	 * @param end the upper bound of the range of employee deputation requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee deputation requests
	 */
	@Override
	public List<EmployeeDeputationRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeeDeputationRequest> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee deputation requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDeputationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee deputation requests
	 * @param end the upper bound of the range of employee deputation requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee deputation requests
	 */
	@Override
	public List<EmployeeDeputationRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeeDeputationRequest> orderByComparator,
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

		List<EmployeeDeputationRequest> list = null;

		if (useFinderCache) {
			list = (List<EmployeeDeputationRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeDeputationRequest employeeDeputationRequest :
						list) {

					if (!uuid.equals(employeeDeputationRequest.getUuid()) ||
						(companyId !=
							employeeDeputationRequest.getCompanyId())) {

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

			sb.append(_SQL_SELECT_EMPLOYEEDEPUTATIONREQUEST_WHERE);

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
				sb.append(EmployeeDeputationRequestModelImpl.ORDER_BY_JPQL);
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

				list = (List<EmployeeDeputationRequest>)QueryUtil.list(
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
	 * Returns the first employee deputation request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee deputation request
	 * @throws NoSuchEmployeeDeputationRequestException if a matching employee deputation request could not be found
	 */
	@Override
	public EmployeeDeputationRequest findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<EmployeeDeputationRequest> orderByComparator)
		throws NoSuchEmployeeDeputationRequestException {

		EmployeeDeputationRequest employeeDeputationRequest =
			fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (employeeDeputationRequest != null) {
			return employeeDeputationRequest;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchEmployeeDeputationRequestException(sb.toString());
	}

	/**
	 * Returns the first employee deputation request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee deputation request, or <code>null</code> if a matching employee deputation request could not be found
	 */
	@Override
	public EmployeeDeputationRequest fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<EmployeeDeputationRequest> orderByComparator) {

		List<EmployeeDeputationRequest> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee deputation request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee deputation request
	 * @throws NoSuchEmployeeDeputationRequestException if a matching employee deputation request could not be found
	 */
	@Override
	public EmployeeDeputationRequest findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<EmployeeDeputationRequest> orderByComparator)
		throws NoSuchEmployeeDeputationRequestException {

		EmployeeDeputationRequest employeeDeputationRequest =
			fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (employeeDeputationRequest != null) {
			return employeeDeputationRequest;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchEmployeeDeputationRequestException(sb.toString());
	}

	/**
	 * Returns the last employee deputation request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee deputation request, or <code>null</code> if a matching employee deputation request could not be found
	 */
	@Override
	public EmployeeDeputationRequest fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<EmployeeDeputationRequest> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<EmployeeDeputationRequest> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee deputation requests before and after the current employee deputation request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param employeeDeputationRequestId the primary key of the current employee deputation request
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee deputation request
	 * @throws NoSuchEmployeeDeputationRequestException if a employee deputation request with the primary key could not be found
	 */
	@Override
	public EmployeeDeputationRequest[] findByUuid_C_PrevAndNext(
			long employeeDeputationRequestId, String uuid, long companyId,
			OrderByComparator<EmployeeDeputationRequest> orderByComparator)
		throws NoSuchEmployeeDeputationRequestException {

		uuid = Objects.toString(uuid, "");

		EmployeeDeputationRequest employeeDeputationRequest = findByPrimaryKey(
			employeeDeputationRequestId);

		Session session = null;

		try {
			session = openSession();

			EmployeeDeputationRequest[] array =
				new EmployeeDeputationRequestImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, employeeDeputationRequest, uuid, companyId,
				orderByComparator, true);

			array[1] = employeeDeputationRequest;

			array[2] = getByUuid_C_PrevAndNext(
				session, employeeDeputationRequest, uuid, companyId,
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

	protected EmployeeDeputationRequest getByUuid_C_PrevAndNext(
		Session session, EmployeeDeputationRequest employeeDeputationRequest,
		String uuid, long companyId,
		OrderByComparator<EmployeeDeputationRequest> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEDEPUTATIONREQUEST_WHERE);

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
			sb.append(EmployeeDeputationRequestModelImpl.ORDER_BY_JPQL);
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
						employeeDeputationRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeDeputationRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee deputation requests where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (EmployeeDeputationRequest employeeDeputationRequest :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(employeeDeputationRequest);
		}
	}

	/**
	 * Returns the number of employee deputation requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching employee deputation requests
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_EMPLOYEEDEPUTATIONREQUEST_WHERE);

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
		"employeeDeputationRequest.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(employeeDeputationRequest.uuid IS NULL OR employeeDeputationRequest.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"employeeDeputationRequest.companyId = ?";

	public EmployeeDeputationRequestPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(EmployeeDeputationRequest.class);

		setModelImplClass(EmployeeDeputationRequestImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the employee deputation request in the entity cache if it is enabled.
	 *
	 * @param employeeDeputationRequest the employee deputation request
	 */
	@Override
	public void cacheResult(
		EmployeeDeputationRequest employeeDeputationRequest) {

		entityCache.putResult(
			EmployeeDeputationRequestImpl.class,
			employeeDeputationRequest.getPrimaryKey(),
			employeeDeputationRequest);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				employeeDeputationRequest.getUuid(),
				employeeDeputationRequest.getGroupId()
			},
			employeeDeputationRequest);
	}

	/**
	 * Caches the employee deputation requests in the entity cache if it is enabled.
	 *
	 * @param employeeDeputationRequests the employee deputation requests
	 */
	@Override
	public void cacheResult(
		List<EmployeeDeputationRequest> employeeDeputationRequests) {

		for (EmployeeDeputationRequest employeeDeputationRequest :
				employeeDeputationRequests) {

			if (entityCache.getResult(
					EmployeeDeputationRequestImpl.class,
					employeeDeputationRequest.getPrimaryKey()) == null) {

				cacheResult(employeeDeputationRequest);
			}
		}
	}

	/**
	 * Clears the cache for all employee deputation requests.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmployeeDeputationRequestImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the employee deputation request.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		EmployeeDeputationRequest employeeDeputationRequest) {

		entityCache.removeResult(
			EmployeeDeputationRequestImpl.class, employeeDeputationRequest);
	}

	@Override
	public void clearCache(
		List<EmployeeDeputationRequest> employeeDeputationRequests) {

		for (EmployeeDeputationRequest employeeDeputationRequest :
				employeeDeputationRequests) {

			entityCache.removeResult(
				EmployeeDeputationRequestImpl.class, employeeDeputationRequest);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				EmployeeDeputationRequestImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		EmployeeDeputationRequestModelImpl employeeDeputationRequestModelImpl) {

		Object[] args = new Object[] {
			employeeDeputationRequestModelImpl.getUuid(),
			employeeDeputationRequestModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, employeeDeputationRequestModelImpl,
			false);
	}

	/**
	 * Creates a new employee deputation request with the primary key. Does not add the employee deputation request to the database.
	 *
	 * @param employeeDeputationRequestId the primary key for the new employee deputation request
	 * @return the new employee deputation request
	 */
	@Override
	public EmployeeDeputationRequest create(long employeeDeputationRequestId) {
		EmployeeDeputationRequest employeeDeputationRequest =
			new EmployeeDeputationRequestImpl();

		employeeDeputationRequest.setNew(true);
		employeeDeputationRequest.setPrimaryKey(employeeDeputationRequestId);

		String uuid = PortalUUIDUtil.generate();

		employeeDeputationRequest.setUuid(uuid);

		employeeDeputationRequest.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return employeeDeputationRequest;
	}

	/**
	 * Removes the employee deputation request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeDeputationRequestId the primary key of the employee deputation request
	 * @return the employee deputation request that was removed
	 * @throws NoSuchEmployeeDeputationRequestException if a employee deputation request with the primary key could not be found
	 */
	@Override
	public EmployeeDeputationRequest remove(long employeeDeputationRequestId)
		throws NoSuchEmployeeDeputationRequestException {

		return remove((Serializable)employeeDeputationRequestId);
	}

	/**
	 * Removes the employee deputation request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the employee deputation request
	 * @return the employee deputation request that was removed
	 * @throws NoSuchEmployeeDeputationRequestException if a employee deputation request with the primary key could not be found
	 */
	@Override
	public EmployeeDeputationRequest remove(Serializable primaryKey)
		throws NoSuchEmployeeDeputationRequestException {

		Session session = null;

		try {
			session = openSession();

			EmployeeDeputationRequest employeeDeputationRequest =
				(EmployeeDeputationRequest)session.get(
					EmployeeDeputationRequestImpl.class, primaryKey);

			if (employeeDeputationRequest == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmployeeDeputationRequestException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(employeeDeputationRequest);
		}
		catch (NoSuchEmployeeDeputationRequestException noSuchEntityException) {
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
	protected EmployeeDeputationRequest removeImpl(
		EmployeeDeputationRequest employeeDeputationRequest) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(employeeDeputationRequest)) {
				employeeDeputationRequest =
					(EmployeeDeputationRequest)session.get(
						EmployeeDeputationRequestImpl.class,
						employeeDeputationRequest.getPrimaryKeyObj());
			}

			if (employeeDeputationRequest != null) {
				session.delete(employeeDeputationRequest);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (employeeDeputationRequest != null) {
			clearCache(employeeDeputationRequest);
		}

		return employeeDeputationRequest;
	}

	@Override
	public EmployeeDeputationRequest updateImpl(
		EmployeeDeputationRequest employeeDeputationRequest) {

		boolean isNew = employeeDeputationRequest.isNew();

		if (!(employeeDeputationRequest instanceof
				EmployeeDeputationRequestModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(employeeDeputationRequest.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					employeeDeputationRequest);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in employeeDeputationRequest proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EmployeeDeputationRequest implementation " +
					employeeDeputationRequest.getClass());
		}

		EmployeeDeputationRequestModelImpl employeeDeputationRequestModelImpl =
			(EmployeeDeputationRequestModelImpl)employeeDeputationRequest;

		if (Validator.isNull(employeeDeputationRequest.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			employeeDeputationRequest.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (employeeDeputationRequest.getCreateDate() == null)) {
			if (serviceContext == null) {
				employeeDeputationRequest.setCreateDate(now);
			}
			else {
				employeeDeputationRequest.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!employeeDeputationRequestModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				employeeDeputationRequest.setModifiedDate(now);
			}
			else {
				employeeDeputationRequest.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(employeeDeputationRequest);
			}
			else {
				employeeDeputationRequest =
					(EmployeeDeputationRequest)session.merge(
						employeeDeputationRequest);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EmployeeDeputationRequestImpl.class,
			employeeDeputationRequestModelImpl, false, true);

		cacheUniqueFindersCache(employeeDeputationRequestModelImpl);

		if (isNew) {
			employeeDeputationRequest.setNew(false);
		}

		employeeDeputationRequest.resetOriginalValues();

		return employeeDeputationRequest;
	}

	/**
	 * Returns the employee deputation request with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee deputation request
	 * @return the employee deputation request
	 * @throws NoSuchEmployeeDeputationRequestException if a employee deputation request with the primary key could not be found
	 */
	@Override
	public EmployeeDeputationRequest findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmployeeDeputationRequestException {

		EmployeeDeputationRequest employeeDeputationRequest = fetchByPrimaryKey(
			primaryKey);

		if (employeeDeputationRequest == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmployeeDeputationRequestException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return employeeDeputationRequest;
	}

	/**
	 * Returns the employee deputation request with the primary key or throws a <code>NoSuchEmployeeDeputationRequestException</code> if it could not be found.
	 *
	 * @param employeeDeputationRequestId the primary key of the employee deputation request
	 * @return the employee deputation request
	 * @throws NoSuchEmployeeDeputationRequestException if a employee deputation request with the primary key could not be found
	 */
	@Override
	public EmployeeDeputationRequest findByPrimaryKey(
			long employeeDeputationRequestId)
		throws NoSuchEmployeeDeputationRequestException {

		return findByPrimaryKey((Serializable)employeeDeputationRequestId);
	}

	/**
	 * Returns the employee deputation request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeDeputationRequestId the primary key of the employee deputation request
	 * @return the employee deputation request, or <code>null</code> if a employee deputation request with the primary key could not be found
	 */
	@Override
	public EmployeeDeputationRequest fetchByPrimaryKey(
		long employeeDeputationRequestId) {

		return fetchByPrimaryKey((Serializable)employeeDeputationRequestId);
	}

	/**
	 * Returns all the employee deputation requests.
	 *
	 * @return the employee deputation requests
	 */
	@Override
	public List<EmployeeDeputationRequest> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee deputation requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDeputationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee deputation requests
	 * @param end the upper bound of the range of employee deputation requests (not inclusive)
	 * @return the range of employee deputation requests
	 */
	@Override
	public List<EmployeeDeputationRequest> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee deputation requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDeputationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee deputation requests
	 * @param end the upper bound of the range of employee deputation requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee deputation requests
	 */
	@Override
	public List<EmployeeDeputationRequest> findAll(
		int start, int end,
		OrderByComparator<EmployeeDeputationRequest> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee deputation requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDeputationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee deputation requests
	 * @param end the upper bound of the range of employee deputation requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee deputation requests
	 */
	@Override
	public List<EmployeeDeputationRequest> findAll(
		int start, int end,
		OrderByComparator<EmployeeDeputationRequest> orderByComparator,
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

		List<EmployeeDeputationRequest> list = null;

		if (useFinderCache) {
			list = (List<EmployeeDeputationRequest>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EMPLOYEEDEPUTATIONREQUEST);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLOYEEDEPUTATIONREQUEST;

				sql = sql.concat(
					EmployeeDeputationRequestModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EmployeeDeputationRequest>)QueryUtil.list(
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
	 * Removes all the employee deputation requests from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EmployeeDeputationRequest employeeDeputationRequest : findAll()) {
			remove(employeeDeputationRequest);
		}
	}

	/**
	 * Returns the number of employee deputation requests.
	 *
	 * @return the number of employee deputation requests
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
					_SQL_COUNT_EMPLOYEEDEPUTATIONREQUEST);

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
		return "employeeDeputationRequestId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EMPLOYEEDEPUTATIONREQUEST;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EmployeeDeputationRequestModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the employee deputation request persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new EmployeeDeputationRequestModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", EmployeeDeputationRequest.class.getName()));

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
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(EmployeeDeputationRequestImpl.class.getName());

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

	private static final String _SQL_SELECT_EMPLOYEEDEPUTATIONREQUEST =
		"SELECT employeeDeputationRequest FROM EmployeeDeputationRequest employeeDeputationRequest";

	private static final String _SQL_SELECT_EMPLOYEEDEPUTATIONREQUEST_WHERE =
		"SELECT employeeDeputationRequest FROM EmployeeDeputationRequest employeeDeputationRequest WHERE ";

	private static final String _SQL_COUNT_EMPLOYEEDEPUTATIONREQUEST =
		"SELECT COUNT(employeeDeputationRequest) FROM EmployeeDeputationRequest employeeDeputationRequest";

	private static final String _SQL_COUNT_EMPLOYEEDEPUTATIONREQUEST_WHERE =
		"SELECT COUNT(employeeDeputationRequest) FROM EmployeeDeputationRequest employeeDeputationRequest WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"employeeDeputationRequest.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EmployeeDeputationRequest exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EmployeeDeputationRequest exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EmployeeDeputationRequestPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

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

	private static class EmployeeDeputationRequestModelArgumentsResolver
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

			EmployeeDeputationRequestModelImpl
				employeeDeputationRequestModelImpl =
					(EmployeeDeputationRequestModelImpl)baseModel;

			long columnBitmask =
				employeeDeputationRequestModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					employeeDeputationRequestModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						employeeDeputationRequestModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					employeeDeputationRequestModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			EmployeeDeputationRequestModelImpl
				employeeDeputationRequestModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						employeeDeputationRequestModelImpl.
							getColumnOriginalValue(columnName);
				}
				else {
					arguments[i] =
						employeeDeputationRequestModelImpl.getColumnValue(
							columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}