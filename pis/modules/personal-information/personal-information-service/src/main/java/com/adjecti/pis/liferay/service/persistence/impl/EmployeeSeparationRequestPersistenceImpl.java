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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeSeparationRequestException;
import com.adjecti.pis.liferay.model.EmployeeSeparationRequest;
import com.adjecti.pis.liferay.model.impl.EmployeeSeparationRequestImpl;
import com.adjecti.pis.liferay.model.impl.EmployeeSeparationRequestModelImpl;
import com.adjecti.pis.liferay.service.persistence.EmployeeSeparationRequestPersistence;
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
 * The persistence implementation for the employee separation request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EmployeeSeparationRequestPersistence.class)
public class EmployeeSeparationRequestPersistenceImpl
	extends BasePersistenceImpl<EmployeeSeparationRequest>
	implements EmployeeSeparationRequestPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EmployeeSeparationRequestUtil</code> to access the employee separation request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EmployeeSeparationRequestImpl.class.getName();

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
	 * Returns all the employee separation requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching employee separation requests
	 */
	@Override
	public List<EmployeeSeparationRequest> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee separation requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeSeparationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee separation requests
	 * @param end the upper bound of the range of employee separation requests (not inclusive)
	 * @return the range of matching employee separation requests
	 */
	@Override
	public List<EmployeeSeparationRequest> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee separation requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeSeparationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee separation requests
	 * @param end the upper bound of the range of employee separation requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee separation requests
	 */
	@Override
	public List<EmployeeSeparationRequest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmployeeSeparationRequest> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee separation requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeSeparationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee separation requests
	 * @param end the upper bound of the range of employee separation requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee separation requests
	 */
	@Override
	public List<EmployeeSeparationRequest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmployeeSeparationRequest> orderByComparator,
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

		List<EmployeeSeparationRequest> list = null;

		if (useFinderCache) {
			list = (List<EmployeeSeparationRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeSeparationRequest employeeSeparationRequest :
						list) {

					if (!uuid.equals(employeeSeparationRequest.getUuid())) {
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

			sb.append(_SQL_SELECT_EMPLOYEESEPARATIONREQUEST_WHERE);

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
				sb.append(EmployeeSeparationRequestModelImpl.ORDER_BY_JPQL);
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

				list = (List<EmployeeSeparationRequest>)QueryUtil.list(
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
	 * Returns the first employee separation request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee separation request
	 * @throws NoSuchEmployeeSeparationRequestException if a matching employee separation request could not be found
	 */
	@Override
	public EmployeeSeparationRequest findByUuid_First(
			String uuid,
			OrderByComparator<EmployeeSeparationRequest> orderByComparator)
		throws NoSuchEmployeeSeparationRequestException {

		EmployeeSeparationRequest employeeSeparationRequest = fetchByUuid_First(
			uuid, orderByComparator);

		if (employeeSeparationRequest != null) {
			return employeeSeparationRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchEmployeeSeparationRequestException(sb.toString());
	}

	/**
	 * Returns the first employee separation request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee separation request, or <code>null</code> if a matching employee separation request could not be found
	 */
	@Override
	public EmployeeSeparationRequest fetchByUuid_First(
		String uuid,
		OrderByComparator<EmployeeSeparationRequest> orderByComparator) {

		List<EmployeeSeparationRequest> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee separation request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee separation request
	 * @throws NoSuchEmployeeSeparationRequestException if a matching employee separation request could not be found
	 */
	@Override
	public EmployeeSeparationRequest findByUuid_Last(
			String uuid,
			OrderByComparator<EmployeeSeparationRequest> orderByComparator)
		throws NoSuchEmployeeSeparationRequestException {

		EmployeeSeparationRequest employeeSeparationRequest = fetchByUuid_Last(
			uuid, orderByComparator);

		if (employeeSeparationRequest != null) {
			return employeeSeparationRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchEmployeeSeparationRequestException(sb.toString());
	}

	/**
	 * Returns the last employee separation request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee separation request, or <code>null</code> if a matching employee separation request could not be found
	 */
	@Override
	public EmployeeSeparationRequest fetchByUuid_Last(
		String uuid,
		OrderByComparator<EmployeeSeparationRequest> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<EmployeeSeparationRequest> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee separation requests before and after the current employee separation request in the ordered set where uuid = &#63;.
	 *
	 * @param employeeSeparationRequestId the primary key of the current employee separation request
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee separation request
	 * @throws NoSuchEmployeeSeparationRequestException if a employee separation request with the primary key could not be found
	 */
	@Override
	public EmployeeSeparationRequest[] findByUuid_PrevAndNext(
			long employeeSeparationRequestId, String uuid,
			OrderByComparator<EmployeeSeparationRequest> orderByComparator)
		throws NoSuchEmployeeSeparationRequestException {

		uuid = Objects.toString(uuid, "");

		EmployeeSeparationRequest employeeSeparationRequest = findByPrimaryKey(
			employeeSeparationRequestId);

		Session session = null;

		try {
			session = openSession();

			EmployeeSeparationRequest[] array =
				new EmployeeSeparationRequestImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, employeeSeparationRequest, uuid, orderByComparator,
				true);

			array[1] = employeeSeparationRequest;

			array[2] = getByUuid_PrevAndNext(
				session, employeeSeparationRequest, uuid, orderByComparator,
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

	protected EmployeeSeparationRequest getByUuid_PrevAndNext(
		Session session, EmployeeSeparationRequest employeeSeparationRequest,
		String uuid,
		OrderByComparator<EmployeeSeparationRequest> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEESEPARATIONREQUEST_WHERE);

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
			sb.append(EmployeeSeparationRequestModelImpl.ORDER_BY_JPQL);
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
						employeeSeparationRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeSeparationRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee separation requests where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (EmployeeSeparationRequest employeeSeparationRequest :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeeSeparationRequest);
		}
	}

	/**
	 * Returns the number of employee separation requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching employee separation requests
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEESEPARATIONREQUEST_WHERE);

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
		"employeeSeparationRequest.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(employeeSeparationRequest.uuid IS NULL OR employeeSeparationRequest.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the employee separation request where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmployeeSeparationRequestException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee separation request
	 * @throws NoSuchEmployeeSeparationRequestException if a matching employee separation request could not be found
	 */
	@Override
	public EmployeeSeparationRequest findByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeSeparationRequestException {

		EmployeeSeparationRequest employeeSeparationRequest = fetchByUUID_G(
			uuid, groupId);

		if (employeeSeparationRequest == null) {
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

			throw new NoSuchEmployeeSeparationRequestException(sb.toString());
		}

		return employeeSeparationRequest;
	}

	/**
	 * Returns the employee separation request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee separation request, or <code>null</code> if a matching employee separation request could not be found
	 */
	@Override
	public EmployeeSeparationRequest fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the employee separation request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee separation request, or <code>null</code> if a matching employee separation request could not be found
	 */
	@Override
	public EmployeeSeparationRequest fetchByUUID_G(
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

		if (result instanceof EmployeeSeparationRequest) {
			EmployeeSeparationRequest employeeSeparationRequest =
				(EmployeeSeparationRequest)result;

			if (!Objects.equals(uuid, employeeSeparationRequest.getUuid()) ||
				(groupId != employeeSeparationRequest.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_EMPLOYEESEPARATIONREQUEST_WHERE);

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

				List<EmployeeSeparationRequest> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					EmployeeSeparationRequest employeeSeparationRequest =
						list.get(0);

					result = employeeSeparationRequest;

					cacheResult(employeeSeparationRequest);
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
			return (EmployeeSeparationRequest)result;
		}
	}

	/**
	 * Removes the employee separation request where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the employee separation request that was removed
	 */
	@Override
	public EmployeeSeparationRequest removeByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeSeparationRequestException {

		EmployeeSeparationRequest employeeSeparationRequest = findByUUID_G(
			uuid, groupId);

		return remove(employeeSeparationRequest);
	}

	/**
	 * Returns the number of employee separation requests where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching employee separation requests
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_EMPLOYEESEPARATIONREQUEST_WHERE);

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
		"employeeSeparationRequest.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(employeeSeparationRequest.uuid IS NULL OR employeeSeparationRequest.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"employeeSeparationRequest.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the employee separation requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching employee separation requests
	 */
	@Override
	public List<EmployeeSeparationRequest> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee separation requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeSeparationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee separation requests
	 * @param end the upper bound of the range of employee separation requests (not inclusive)
	 * @return the range of matching employee separation requests
	 */
	@Override
	public List<EmployeeSeparationRequest> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee separation requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeSeparationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee separation requests
	 * @param end the upper bound of the range of employee separation requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee separation requests
	 */
	@Override
	public List<EmployeeSeparationRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeeSeparationRequest> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee separation requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeSeparationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee separation requests
	 * @param end the upper bound of the range of employee separation requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee separation requests
	 */
	@Override
	public List<EmployeeSeparationRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeeSeparationRequest> orderByComparator,
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

		List<EmployeeSeparationRequest> list = null;

		if (useFinderCache) {
			list = (List<EmployeeSeparationRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeSeparationRequest employeeSeparationRequest :
						list) {

					if (!uuid.equals(employeeSeparationRequest.getUuid()) ||
						(companyId !=
							employeeSeparationRequest.getCompanyId())) {

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

			sb.append(_SQL_SELECT_EMPLOYEESEPARATIONREQUEST_WHERE);

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
				sb.append(EmployeeSeparationRequestModelImpl.ORDER_BY_JPQL);
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

				list = (List<EmployeeSeparationRequest>)QueryUtil.list(
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
	 * Returns the first employee separation request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee separation request
	 * @throws NoSuchEmployeeSeparationRequestException if a matching employee separation request could not be found
	 */
	@Override
	public EmployeeSeparationRequest findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<EmployeeSeparationRequest> orderByComparator)
		throws NoSuchEmployeeSeparationRequestException {

		EmployeeSeparationRequest employeeSeparationRequest =
			fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (employeeSeparationRequest != null) {
			return employeeSeparationRequest;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchEmployeeSeparationRequestException(sb.toString());
	}

	/**
	 * Returns the first employee separation request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee separation request, or <code>null</code> if a matching employee separation request could not be found
	 */
	@Override
	public EmployeeSeparationRequest fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<EmployeeSeparationRequest> orderByComparator) {

		List<EmployeeSeparationRequest> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee separation request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee separation request
	 * @throws NoSuchEmployeeSeparationRequestException if a matching employee separation request could not be found
	 */
	@Override
	public EmployeeSeparationRequest findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<EmployeeSeparationRequest> orderByComparator)
		throws NoSuchEmployeeSeparationRequestException {

		EmployeeSeparationRequest employeeSeparationRequest =
			fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (employeeSeparationRequest != null) {
			return employeeSeparationRequest;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchEmployeeSeparationRequestException(sb.toString());
	}

	/**
	 * Returns the last employee separation request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee separation request, or <code>null</code> if a matching employee separation request could not be found
	 */
	@Override
	public EmployeeSeparationRequest fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<EmployeeSeparationRequest> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<EmployeeSeparationRequest> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee separation requests before and after the current employee separation request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param employeeSeparationRequestId the primary key of the current employee separation request
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee separation request
	 * @throws NoSuchEmployeeSeparationRequestException if a employee separation request with the primary key could not be found
	 */
	@Override
	public EmployeeSeparationRequest[] findByUuid_C_PrevAndNext(
			long employeeSeparationRequestId, String uuid, long companyId,
			OrderByComparator<EmployeeSeparationRequest> orderByComparator)
		throws NoSuchEmployeeSeparationRequestException {

		uuid = Objects.toString(uuid, "");

		EmployeeSeparationRequest employeeSeparationRequest = findByPrimaryKey(
			employeeSeparationRequestId);

		Session session = null;

		try {
			session = openSession();

			EmployeeSeparationRequest[] array =
				new EmployeeSeparationRequestImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, employeeSeparationRequest, uuid, companyId,
				orderByComparator, true);

			array[1] = employeeSeparationRequest;

			array[2] = getByUuid_C_PrevAndNext(
				session, employeeSeparationRequest, uuid, companyId,
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

	protected EmployeeSeparationRequest getByUuid_C_PrevAndNext(
		Session session, EmployeeSeparationRequest employeeSeparationRequest,
		String uuid, long companyId,
		OrderByComparator<EmployeeSeparationRequest> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEESEPARATIONREQUEST_WHERE);

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
			sb.append(EmployeeSeparationRequestModelImpl.ORDER_BY_JPQL);
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
						employeeSeparationRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeSeparationRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee separation requests where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (EmployeeSeparationRequest employeeSeparationRequest :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(employeeSeparationRequest);
		}
	}

	/**
	 * Returns the number of employee separation requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching employee separation requests
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_EMPLOYEESEPARATIONREQUEST_WHERE);

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
		"employeeSeparationRequest.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(employeeSeparationRequest.uuid IS NULL OR employeeSeparationRequest.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"employeeSeparationRequest.companyId = ?";

	public EmployeeSeparationRequestPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(EmployeeSeparationRequest.class);

		setModelImplClass(EmployeeSeparationRequestImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the employee separation request in the entity cache if it is enabled.
	 *
	 * @param employeeSeparationRequest the employee separation request
	 */
	@Override
	public void cacheResult(
		EmployeeSeparationRequest employeeSeparationRequest) {

		entityCache.putResult(
			EmployeeSeparationRequestImpl.class,
			employeeSeparationRequest.getPrimaryKey(),
			employeeSeparationRequest);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				employeeSeparationRequest.getUuid(),
				employeeSeparationRequest.getGroupId()
			},
			employeeSeparationRequest);
	}

	/**
	 * Caches the employee separation requests in the entity cache if it is enabled.
	 *
	 * @param employeeSeparationRequests the employee separation requests
	 */
	@Override
	public void cacheResult(
		List<EmployeeSeparationRequest> employeeSeparationRequests) {

		for (EmployeeSeparationRequest employeeSeparationRequest :
				employeeSeparationRequests) {

			if (entityCache.getResult(
					EmployeeSeparationRequestImpl.class,
					employeeSeparationRequest.getPrimaryKey()) == null) {

				cacheResult(employeeSeparationRequest);
			}
		}
	}

	/**
	 * Clears the cache for all employee separation requests.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmployeeSeparationRequestImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the employee separation request.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		EmployeeSeparationRequest employeeSeparationRequest) {

		entityCache.removeResult(
			EmployeeSeparationRequestImpl.class, employeeSeparationRequest);
	}

	@Override
	public void clearCache(
		List<EmployeeSeparationRequest> employeeSeparationRequests) {

		for (EmployeeSeparationRequest employeeSeparationRequest :
				employeeSeparationRequests) {

			entityCache.removeResult(
				EmployeeSeparationRequestImpl.class, employeeSeparationRequest);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				EmployeeSeparationRequestImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		EmployeeSeparationRequestModelImpl employeeSeparationRequestModelImpl) {

		Object[] args = new Object[] {
			employeeSeparationRequestModelImpl.getUuid(),
			employeeSeparationRequestModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, employeeSeparationRequestModelImpl,
			false);
	}

	/**
	 * Creates a new employee separation request with the primary key. Does not add the employee separation request to the database.
	 *
	 * @param employeeSeparationRequestId the primary key for the new employee separation request
	 * @return the new employee separation request
	 */
	@Override
	public EmployeeSeparationRequest create(long employeeSeparationRequestId) {
		EmployeeSeparationRequest employeeSeparationRequest =
			new EmployeeSeparationRequestImpl();

		employeeSeparationRequest.setNew(true);
		employeeSeparationRequest.setPrimaryKey(employeeSeparationRequestId);

		String uuid = PortalUUIDUtil.generate();

		employeeSeparationRequest.setUuid(uuid);

		employeeSeparationRequest.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return employeeSeparationRequest;
	}

	/**
	 * Removes the employee separation request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeSeparationRequestId the primary key of the employee separation request
	 * @return the employee separation request that was removed
	 * @throws NoSuchEmployeeSeparationRequestException if a employee separation request with the primary key could not be found
	 */
	@Override
	public EmployeeSeparationRequest remove(long employeeSeparationRequestId)
		throws NoSuchEmployeeSeparationRequestException {

		return remove((Serializable)employeeSeparationRequestId);
	}

	/**
	 * Removes the employee separation request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the employee separation request
	 * @return the employee separation request that was removed
	 * @throws NoSuchEmployeeSeparationRequestException if a employee separation request with the primary key could not be found
	 */
	@Override
	public EmployeeSeparationRequest remove(Serializable primaryKey)
		throws NoSuchEmployeeSeparationRequestException {

		Session session = null;

		try {
			session = openSession();

			EmployeeSeparationRequest employeeSeparationRequest =
				(EmployeeSeparationRequest)session.get(
					EmployeeSeparationRequestImpl.class, primaryKey);

			if (employeeSeparationRequest == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmployeeSeparationRequestException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(employeeSeparationRequest);
		}
		catch (NoSuchEmployeeSeparationRequestException noSuchEntityException) {
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
	protected EmployeeSeparationRequest removeImpl(
		EmployeeSeparationRequest employeeSeparationRequest) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(employeeSeparationRequest)) {
				employeeSeparationRequest =
					(EmployeeSeparationRequest)session.get(
						EmployeeSeparationRequestImpl.class,
						employeeSeparationRequest.getPrimaryKeyObj());
			}

			if (employeeSeparationRequest != null) {
				session.delete(employeeSeparationRequest);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (employeeSeparationRequest != null) {
			clearCache(employeeSeparationRequest);
		}

		return employeeSeparationRequest;
	}

	@Override
	public EmployeeSeparationRequest updateImpl(
		EmployeeSeparationRequest employeeSeparationRequest) {

		boolean isNew = employeeSeparationRequest.isNew();

		if (!(employeeSeparationRequest instanceof
				EmployeeSeparationRequestModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(employeeSeparationRequest.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					employeeSeparationRequest);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in employeeSeparationRequest proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EmployeeSeparationRequest implementation " +
					employeeSeparationRequest.getClass());
		}

		EmployeeSeparationRequestModelImpl employeeSeparationRequestModelImpl =
			(EmployeeSeparationRequestModelImpl)employeeSeparationRequest;

		if (Validator.isNull(employeeSeparationRequest.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			employeeSeparationRequest.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (employeeSeparationRequest.getCreateDate() == null)) {
			if (serviceContext == null) {
				employeeSeparationRequest.setCreateDate(now);
			}
			else {
				employeeSeparationRequest.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!employeeSeparationRequestModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				employeeSeparationRequest.setModifiedDate(now);
			}
			else {
				employeeSeparationRequest.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(employeeSeparationRequest);
			}
			else {
				employeeSeparationRequest =
					(EmployeeSeparationRequest)session.merge(
						employeeSeparationRequest);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EmployeeSeparationRequestImpl.class,
			employeeSeparationRequestModelImpl, false, true);

		cacheUniqueFindersCache(employeeSeparationRequestModelImpl);

		if (isNew) {
			employeeSeparationRequest.setNew(false);
		}

		employeeSeparationRequest.resetOriginalValues();

		return employeeSeparationRequest;
	}

	/**
	 * Returns the employee separation request with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee separation request
	 * @return the employee separation request
	 * @throws NoSuchEmployeeSeparationRequestException if a employee separation request with the primary key could not be found
	 */
	@Override
	public EmployeeSeparationRequest findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmployeeSeparationRequestException {

		EmployeeSeparationRequest employeeSeparationRequest = fetchByPrimaryKey(
			primaryKey);

		if (employeeSeparationRequest == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmployeeSeparationRequestException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return employeeSeparationRequest;
	}

	/**
	 * Returns the employee separation request with the primary key or throws a <code>NoSuchEmployeeSeparationRequestException</code> if it could not be found.
	 *
	 * @param employeeSeparationRequestId the primary key of the employee separation request
	 * @return the employee separation request
	 * @throws NoSuchEmployeeSeparationRequestException if a employee separation request with the primary key could not be found
	 */
	@Override
	public EmployeeSeparationRequest findByPrimaryKey(
			long employeeSeparationRequestId)
		throws NoSuchEmployeeSeparationRequestException {

		return findByPrimaryKey((Serializable)employeeSeparationRequestId);
	}

	/**
	 * Returns the employee separation request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeSeparationRequestId the primary key of the employee separation request
	 * @return the employee separation request, or <code>null</code> if a employee separation request with the primary key could not be found
	 */
	@Override
	public EmployeeSeparationRequest fetchByPrimaryKey(
		long employeeSeparationRequestId) {

		return fetchByPrimaryKey((Serializable)employeeSeparationRequestId);
	}

	/**
	 * Returns all the employee separation requests.
	 *
	 * @return the employee separation requests
	 */
	@Override
	public List<EmployeeSeparationRequest> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee separation requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeSeparationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee separation requests
	 * @param end the upper bound of the range of employee separation requests (not inclusive)
	 * @return the range of employee separation requests
	 */
	@Override
	public List<EmployeeSeparationRequest> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee separation requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeSeparationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee separation requests
	 * @param end the upper bound of the range of employee separation requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee separation requests
	 */
	@Override
	public List<EmployeeSeparationRequest> findAll(
		int start, int end,
		OrderByComparator<EmployeeSeparationRequest> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee separation requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeSeparationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee separation requests
	 * @param end the upper bound of the range of employee separation requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee separation requests
	 */
	@Override
	public List<EmployeeSeparationRequest> findAll(
		int start, int end,
		OrderByComparator<EmployeeSeparationRequest> orderByComparator,
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

		List<EmployeeSeparationRequest> list = null;

		if (useFinderCache) {
			list = (List<EmployeeSeparationRequest>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EMPLOYEESEPARATIONREQUEST);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLOYEESEPARATIONREQUEST;

				sql = sql.concat(
					EmployeeSeparationRequestModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EmployeeSeparationRequest>)QueryUtil.list(
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
	 * Removes all the employee separation requests from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EmployeeSeparationRequest employeeSeparationRequest : findAll()) {
			remove(employeeSeparationRequest);
		}
	}

	/**
	 * Returns the number of employee separation requests.
	 *
	 * @return the number of employee separation requests
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
					_SQL_COUNT_EMPLOYEESEPARATIONREQUEST);

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
		return "employeeSeparationRequestId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EMPLOYEESEPARATIONREQUEST;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EmployeeSeparationRequestModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the employee separation request persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new EmployeeSeparationRequestModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", EmployeeSeparationRequest.class.getName()));

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
		entityCache.removeCache(EmployeeSeparationRequestImpl.class.getName());

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

	private static final String _SQL_SELECT_EMPLOYEESEPARATIONREQUEST =
		"SELECT employeeSeparationRequest FROM EmployeeSeparationRequest employeeSeparationRequest";

	private static final String _SQL_SELECT_EMPLOYEESEPARATIONREQUEST_WHERE =
		"SELECT employeeSeparationRequest FROM EmployeeSeparationRequest employeeSeparationRequest WHERE ";

	private static final String _SQL_COUNT_EMPLOYEESEPARATIONREQUEST =
		"SELECT COUNT(employeeSeparationRequest) FROM EmployeeSeparationRequest employeeSeparationRequest";

	private static final String _SQL_COUNT_EMPLOYEESEPARATIONREQUEST_WHERE =
		"SELECT COUNT(employeeSeparationRequest) FROM EmployeeSeparationRequest employeeSeparationRequest WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"employeeSeparationRequest.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EmployeeSeparationRequest exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EmployeeSeparationRequest exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EmployeeSeparationRequestPersistenceImpl.class);

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

	private static class EmployeeSeparationRequestModelArgumentsResolver
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

			EmployeeSeparationRequestModelImpl
				employeeSeparationRequestModelImpl =
					(EmployeeSeparationRequestModelImpl)baseModel;

			long columnBitmask =
				employeeSeparationRequestModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					employeeSeparationRequestModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						employeeSeparationRequestModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					employeeSeparationRequestModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			EmployeeSeparationRequestModelImpl
				employeeSeparationRequestModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						employeeSeparationRequestModelImpl.
							getColumnOriginalValue(columnName);
				}
				else {
					arguments[i] =
						employeeSeparationRequestModelImpl.getColumnValue(
							columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}