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

import com.adjecti.pis.liferay.exception.NoSuchEmployeePromotionRequestException;
import com.adjecti.pis.liferay.model.EmployeePromotionRequest;
import com.adjecti.pis.liferay.model.impl.EmployeePromotionRequestImpl;
import com.adjecti.pis.liferay.model.impl.EmployeePromotionRequestModelImpl;
import com.adjecti.pis.liferay.service.persistence.EmployeePromotionRequestPersistence;
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
 * The persistence implementation for the employee promotion request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EmployeePromotionRequestPersistence.class)
public class EmployeePromotionRequestPersistenceImpl
	extends BasePersistenceImpl<EmployeePromotionRequest>
	implements EmployeePromotionRequestPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EmployeePromotionRequestUtil</code> to access the employee promotion request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EmployeePromotionRequestImpl.class.getName();

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
	 * Returns all the employee promotion requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching employee promotion requests
	 */
	@Override
	public List<EmployeePromotionRequest> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee promotion requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePromotionRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee promotion requests
	 * @param end the upper bound of the range of employee promotion requests (not inclusive)
	 * @return the range of matching employee promotion requests
	 */
	@Override
	public List<EmployeePromotionRequest> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee promotion requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePromotionRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee promotion requests
	 * @param end the upper bound of the range of employee promotion requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee promotion requests
	 */
	@Override
	public List<EmployeePromotionRequest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmployeePromotionRequest> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee promotion requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePromotionRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee promotion requests
	 * @param end the upper bound of the range of employee promotion requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee promotion requests
	 */
	@Override
	public List<EmployeePromotionRequest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmployeePromotionRequest> orderByComparator,
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

		List<EmployeePromotionRequest> list = null;

		if (useFinderCache) {
			list = (List<EmployeePromotionRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeePromotionRequest employeePromotionRequest : list) {
					if (!uuid.equals(employeePromotionRequest.getUuid())) {
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

			sb.append(_SQL_SELECT_EMPLOYEEPROMOTIONREQUEST_WHERE);

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
				sb.append(EmployeePromotionRequestModelImpl.ORDER_BY_JPQL);
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

				list = (List<EmployeePromotionRequest>)QueryUtil.list(
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
	 * Returns the first employee promotion request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee promotion request
	 * @throws NoSuchEmployeePromotionRequestException if a matching employee promotion request could not be found
	 */
	@Override
	public EmployeePromotionRequest findByUuid_First(
			String uuid,
			OrderByComparator<EmployeePromotionRequest> orderByComparator)
		throws NoSuchEmployeePromotionRequestException {

		EmployeePromotionRequest employeePromotionRequest = fetchByUuid_First(
			uuid, orderByComparator);

		if (employeePromotionRequest != null) {
			return employeePromotionRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchEmployeePromotionRequestException(sb.toString());
	}

	/**
	 * Returns the first employee promotion request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee promotion request, or <code>null</code> if a matching employee promotion request could not be found
	 */
	@Override
	public EmployeePromotionRequest fetchByUuid_First(
		String uuid,
		OrderByComparator<EmployeePromotionRequest> orderByComparator) {

		List<EmployeePromotionRequest> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee promotion request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee promotion request
	 * @throws NoSuchEmployeePromotionRequestException if a matching employee promotion request could not be found
	 */
	@Override
	public EmployeePromotionRequest findByUuid_Last(
			String uuid,
			OrderByComparator<EmployeePromotionRequest> orderByComparator)
		throws NoSuchEmployeePromotionRequestException {

		EmployeePromotionRequest employeePromotionRequest = fetchByUuid_Last(
			uuid, orderByComparator);

		if (employeePromotionRequest != null) {
			return employeePromotionRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchEmployeePromotionRequestException(sb.toString());
	}

	/**
	 * Returns the last employee promotion request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee promotion request, or <code>null</code> if a matching employee promotion request could not be found
	 */
	@Override
	public EmployeePromotionRequest fetchByUuid_Last(
		String uuid,
		OrderByComparator<EmployeePromotionRequest> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<EmployeePromotionRequest> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee promotion requests before and after the current employee promotion request in the ordered set where uuid = &#63;.
	 *
	 * @param employeePromotionRequestId the primary key of the current employee promotion request
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee promotion request
	 * @throws NoSuchEmployeePromotionRequestException if a employee promotion request with the primary key could not be found
	 */
	@Override
	public EmployeePromotionRequest[] findByUuid_PrevAndNext(
			long employeePromotionRequestId, String uuid,
			OrderByComparator<EmployeePromotionRequest> orderByComparator)
		throws NoSuchEmployeePromotionRequestException {

		uuid = Objects.toString(uuid, "");

		EmployeePromotionRequest employeePromotionRequest = findByPrimaryKey(
			employeePromotionRequestId);

		Session session = null;

		try {
			session = openSession();

			EmployeePromotionRequest[] array =
				new EmployeePromotionRequestImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, employeePromotionRequest, uuid, orderByComparator,
				true);

			array[1] = employeePromotionRequest;

			array[2] = getByUuid_PrevAndNext(
				session, employeePromotionRequest, uuid, orderByComparator,
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

	protected EmployeePromotionRequest getByUuid_PrevAndNext(
		Session session, EmployeePromotionRequest employeePromotionRequest,
		String uuid,
		OrderByComparator<EmployeePromotionRequest> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEPROMOTIONREQUEST_WHERE);

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
			sb.append(EmployeePromotionRequestModelImpl.ORDER_BY_JPQL);
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
						employeePromotionRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeePromotionRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee promotion requests where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (EmployeePromotionRequest employeePromotionRequest :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeePromotionRequest);
		}
	}

	/**
	 * Returns the number of employee promotion requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching employee promotion requests
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEPROMOTIONREQUEST_WHERE);

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
		"employeePromotionRequest.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(employeePromotionRequest.uuid IS NULL OR employeePromotionRequest.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the employee promotion request where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmployeePromotionRequestException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee promotion request
	 * @throws NoSuchEmployeePromotionRequestException if a matching employee promotion request could not be found
	 */
	@Override
	public EmployeePromotionRequest findByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeePromotionRequestException {

		EmployeePromotionRequest employeePromotionRequest = fetchByUUID_G(
			uuid, groupId);

		if (employeePromotionRequest == null) {
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

			throw new NoSuchEmployeePromotionRequestException(sb.toString());
		}

		return employeePromotionRequest;
	}

	/**
	 * Returns the employee promotion request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee promotion request, or <code>null</code> if a matching employee promotion request could not be found
	 */
	@Override
	public EmployeePromotionRequest fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the employee promotion request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee promotion request, or <code>null</code> if a matching employee promotion request could not be found
	 */
	@Override
	public EmployeePromotionRequest fetchByUUID_G(
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

		if (result instanceof EmployeePromotionRequest) {
			EmployeePromotionRequest employeePromotionRequest =
				(EmployeePromotionRequest)result;

			if (!Objects.equals(uuid, employeePromotionRequest.getUuid()) ||
				(groupId != employeePromotionRequest.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_EMPLOYEEPROMOTIONREQUEST_WHERE);

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

				List<EmployeePromotionRequest> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					EmployeePromotionRequest employeePromotionRequest =
						list.get(0);

					result = employeePromotionRequest;

					cacheResult(employeePromotionRequest);
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
			return (EmployeePromotionRequest)result;
		}
	}

	/**
	 * Removes the employee promotion request where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the employee promotion request that was removed
	 */
	@Override
	public EmployeePromotionRequest removeByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeePromotionRequestException {

		EmployeePromotionRequest employeePromotionRequest = findByUUID_G(
			uuid, groupId);

		return remove(employeePromotionRequest);
	}

	/**
	 * Returns the number of employee promotion requests where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching employee promotion requests
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_EMPLOYEEPROMOTIONREQUEST_WHERE);

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
		"employeePromotionRequest.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(employeePromotionRequest.uuid IS NULL OR employeePromotionRequest.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"employeePromotionRequest.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the employee promotion requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching employee promotion requests
	 */
	@Override
	public List<EmployeePromotionRequest> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee promotion requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePromotionRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee promotion requests
	 * @param end the upper bound of the range of employee promotion requests (not inclusive)
	 * @return the range of matching employee promotion requests
	 */
	@Override
	public List<EmployeePromotionRequest> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee promotion requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePromotionRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee promotion requests
	 * @param end the upper bound of the range of employee promotion requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee promotion requests
	 */
	@Override
	public List<EmployeePromotionRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeePromotionRequest> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee promotion requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePromotionRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee promotion requests
	 * @param end the upper bound of the range of employee promotion requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee promotion requests
	 */
	@Override
	public List<EmployeePromotionRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeePromotionRequest> orderByComparator,
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

		List<EmployeePromotionRequest> list = null;

		if (useFinderCache) {
			list = (List<EmployeePromotionRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeePromotionRequest employeePromotionRequest : list) {
					if (!uuid.equals(employeePromotionRequest.getUuid()) ||
						(companyId !=
							employeePromotionRequest.getCompanyId())) {

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

			sb.append(_SQL_SELECT_EMPLOYEEPROMOTIONREQUEST_WHERE);

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
				sb.append(EmployeePromotionRequestModelImpl.ORDER_BY_JPQL);
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

				list = (List<EmployeePromotionRequest>)QueryUtil.list(
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
	 * Returns the first employee promotion request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee promotion request
	 * @throws NoSuchEmployeePromotionRequestException if a matching employee promotion request could not be found
	 */
	@Override
	public EmployeePromotionRequest findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<EmployeePromotionRequest> orderByComparator)
		throws NoSuchEmployeePromotionRequestException {

		EmployeePromotionRequest employeePromotionRequest = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (employeePromotionRequest != null) {
			return employeePromotionRequest;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchEmployeePromotionRequestException(sb.toString());
	}

	/**
	 * Returns the first employee promotion request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee promotion request, or <code>null</code> if a matching employee promotion request could not be found
	 */
	@Override
	public EmployeePromotionRequest fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<EmployeePromotionRequest> orderByComparator) {

		List<EmployeePromotionRequest> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee promotion request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee promotion request
	 * @throws NoSuchEmployeePromotionRequestException if a matching employee promotion request could not be found
	 */
	@Override
	public EmployeePromotionRequest findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<EmployeePromotionRequest> orderByComparator)
		throws NoSuchEmployeePromotionRequestException {

		EmployeePromotionRequest employeePromotionRequest = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (employeePromotionRequest != null) {
			return employeePromotionRequest;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchEmployeePromotionRequestException(sb.toString());
	}

	/**
	 * Returns the last employee promotion request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee promotion request, or <code>null</code> if a matching employee promotion request could not be found
	 */
	@Override
	public EmployeePromotionRequest fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<EmployeePromotionRequest> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<EmployeePromotionRequest> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee promotion requests before and after the current employee promotion request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param employeePromotionRequestId the primary key of the current employee promotion request
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee promotion request
	 * @throws NoSuchEmployeePromotionRequestException if a employee promotion request with the primary key could not be found
	 */
	@Override
	public EmployeePromotionRequest[] findByUuid_C_PrevAndNext(
			long employeePromotionRequestId, String uuid, long companyId,
			OrderByComparator<EmployeePromotionRequest> orderByComparator)
		throws NoSuchEmployeePromotionRequestException {

		uuid = Objects.toString(uuid, "");

		EmployeePromotionRequest employeePromotionRequest = findByPrimaryKey(
			employeePromotionRequestId);

		Session session = null;

		try {
			session = openSession();

			EmployeePromotionRequest[] array =
				new EmployeePromotionRequestImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, employeePromotionRequest, uuid, companyId,
				orderByComparator, true);

			array[1] = employeePromotionRequest;

			array[2] = getByUuid_C_PrevAndNext(
				session, employeePromotionRequest, uuid, companyId,
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

	protected EmployeePromotionRequest getByUuid_C_PrevAndNext(
		Session session, EmployeePromotionRequest employeePromotionRequest,
		String uuid, long companyId,
		OrderByComparator<EmployeePromotionRequest> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEPROMOTIONREQUEST_WHERE);

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
			sb.append(EmployeePromotionRequestModelImpl.ORDER_BY_JPQL);
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
						employeePromotionRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeePromotionRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee promotion requests where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (EmployeePromotionRequest employeePromotionRequest :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(employeePromotionRequest);
		}
	}

	/**
	 * Returns the number of employee promotion requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching employee promotion requests
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_EMPLOYEEPROMOTIONREQUEST_WHERE);

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
		"employeePromotionRequest.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(employeePromotionRequest.uuid IS NULL OR employeePromotionRequest.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"employeePromotionRequest.companyId = ?";

	public EmployeePromotionRequestPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(EmployeePromotionRequest.class);

		setModelImplClass(EmployeePromotionRequestImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the employee promotion request in the entity cache if it is enabled.
	 *
	 * @param employeePromotionRequest the employee promotion request
	 */
	@Override
	public void cacheResult(EmployeePromotionRequest employeePromotionRequest) {
		entityCache.putResult(
			EmployeePromotionRequestImpl.class,
			employeePromotionRequest.getPrimaryKey(), employeePromotionRequest);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				employeePromotionRequest.getUuid(),
				employeePromotionRequest.getGroupId()
			},
			employeePromotionRequest);
	}

	/**
	 * Caches the employee promotion requests in the entity cache if it is enabled.
	 *
	 * @param employeePromotionRequests the employee promotion requests
	 */
	@Override
	public void cacheResult(
		List<EmployeePromotionRequest> employeePromotionRequests) {

		for (EmployeePromotionRequest employeePromotionRequest :
				employeePromotionRequests) {

			if (entityCache.getResult(
					EmployeePromotionRequestImpl.class,
					employeePromotionRequest.getPrimaryKey()) == null) {

				cacheResult(employeePromotionRequest);
			}
		}
	}

	/**
	 * Clears the cache for all employee promotion requests.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmployeePromotionRequestImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the employee promotion request.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmployeePromotionRequest employeePromotionRequest) {
		entityCache.removeResult(
			EmployeePromotionRequestImpl.class, employeePromotionRequest);
	}

	@Override
	public void clearCache(
		List<EmployeePromotionRequest> employeePromotionRequests) {

		for (EmployeePromotionRequest employeePromotionRequest :
				employeePromotionRequests) {

			entityCache.removeResult(
				EmployeePromotionRequestImpl.class, employeePromotionRequest);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				EmployeePromotionRequestImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		EmployeePromotionRequestModelImpl employeePromotionRequestModelImpl) {

		Object[] args = new Object[] {
			employeePromotionRequestModelImpl.getUuid(),
			employeePromotionRequestModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, employeePromotionRequestModelImpl,
			false);
	}

	/**
	 * Creates a new employee promotion request with the primary key. Does not add the employee promotion request to the database.
	 *
	 * @param employeePromotionRequestId the primary key for the new employee promotion request
	 * @return the new employee promotion request
	 */
	@Override
	public EmployeePromotionRequest create(long employeePromotionRequestId) {
		EmployeePromotionRequest employeePromotionRequest =
			new EmployeePromotionRequestImpl();

		employeePromotionRequest.setNew(true);
		employeePromotionRequest.setPrimaryKey(employeePromotionRequestId);

		String uuid = PortalUUIDUtil.generate();

		employeePromotionRequest.setUuid(uuid);

		employeePromotionRequest.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return employeePromotionRequest;
	}

	/**
	 * Removes the employee promotion request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeePromotionRequestId the primary key of the employee promotion request
	 * @return the employee promotion request that was removed
	 * @throws NoSuchEmployeePromotionRequestException if a employee promotion request with the primary key could not be found
	 */
	@Override
	public EmployeePromotionRequest remove(long employeePromotionRequestId)
		throws NoSuchEmployeePromotionRequestException {

		return remove((Serializable)employeePromotionRequestId);
	}

	/**
	 * Removes the employee promotion request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the employee promotion request
	 * @return the employee promotion request that was removed
	 * @throws NoSuchEmployeePromotionRequestException if a employee promotion request with the primary key could not be found
	 */
	@Override
	public EmployeePromotionRequest remove(Serializable primaryKey)
		throws NoSuchEmployeePromotionRequestException {

		Session session = null;

		try {
			session = openSession();

			EmployeePromotionRequest employeePromotionRequest =
				(EmployeePromotionRequest)session.get(
					EmployeePromotionRequestImpl.class, primaryKey);

			if (employeePromotionRequest == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmployeePromotionRequestException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(employeePromotionRequest);
		}
		catch (NoSuchEmployeePromotionRequestException noSuchEntityException) {
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
	protected EmployeePromotionRequest removeImpl(
		EmployeePromotionRequest employeePromotionRequest) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(employeePromotionRequest)) {
				employeePromotionRequest =
					(EmployeePromotionRequest)session.get(
						EmployeePromotionRequestImpl.class,
						employeePromotionRequest.getPrimaryKeyObj());
			}

			if (employeePromotionRequest != null) {
				session.delete(employeePromotionRequest);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (employeePromotionRequest != null) {
			clearCache(employeePromotionRequest);
		}

		return employeePromotionRequest;
	}

	@Override
	public EmployeePromotionRequest updateImpl(
		EmployeePromotionRequest employeePromotionRequest) {

		boolean isNew = employeePromotionRequest.isNew();

		if (!(employeePromotionRequest instanceof
				EmployeePromotionRequestModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(employeePromotionRequest.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					employeePromotionRequest);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in employeePromotionRequest proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EmployeePromotionRequest implementation " +
					employeePromotionRequest.getClass());
		}

		EmployeePromotionRequestModelImpl employeePromotionRequestModelImpl =
			(EmployeePromotionRequestModelImpl)employeePromotionRequest;

		if (Validator.isNull(employeePromotionRequest.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			employeePromotionRequest.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (employeePromotionRequest.getCreateDate() == null)) {
			if (serviceContext == null) {
				employeePromotionRequest.setCreateDate(now);
			}
			else {
				employeePromotionRequest.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!employeePromotionRequestModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				employeePromotionRequest.setModifiedDate(now);
			}
			else {
				employeePromotionRequest.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(employeePromotionRequest);
			}
			else {
				employeePromotionRequest =
					(EmployeePromotionRequest)session.merge(
						employeePromotionRequest);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EmployeePromotionRequestImpl.class,
			employeePromotionRequestModelImpl, false, true);

		cacheUniqueFindersCache(employeePromotionRequestModelImpl);

		if (isNew) {
			employeePromotionRequest.setNew(false);
		}

		employeePromotionRequest.resetOriginalValues();

		return employeePromotionRequest;
	}

	/**
	 * Returns the employee promotion request with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee promotion request
	 * @return the employee promotion request
	 * @throws NoSuchEmployeePromotionRequestException if a employee promotion request with the primary key could not be found
	 */
	@Override
	public EmployeePromotionRequest findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmployeePromotionRequestException {

		EmployeePromotionRequest employeePromotionRequest = fetchByPrimaryKey(
			primaryKey);

		if (employeePromotionRequest == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmployeePromotionRequestException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return employeePromotionRequest;
	}

	/**
	 * Returns the employee promotion request with the primary key or throws a <code>NoSuchEmployeePromotionRequestException</code> if it could not be found.
	 *
	 * @param employeePromotionRequestId the primary key of the employee promotion request
	 * @return the employee promotion request
	 * @throws NoSuchEmployeePromotionRequestException if a employee promotion request with the primary key could not be found
	 */
	@Override
	public EmployeePromotionRequest findByPrimaryKey(
			long employeePromotionRequestId)
		throws NoSuchEmployeePromotionRequestException {

		return findByPrimaryKey((Serializable)employeePromotionRequestId);
	}

	/**
	 * Returns the employee promotion request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeePromotionRequestId the primary key of the employee promotion request
	 * @return the employee promotion request, or <code>null</code> if a employee promotion request with the primary key could not be found
	 */
	@Override
	public EmployeePromotionRequest fetchByPrimaryKey(
		long employeePromotionRequestId) {

		return fetchByPrimaryKey((Serializable)employeePromotionRequestId);
	}

	/**
	 * Returns all the employee promotion requests.
	 *
	 * @return the employee promotion requests
	 */
	@Override
	public List<EmployeePromotionRequest> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee promotion requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePromotionRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee promotion requests
	 * @param end the upper bound of the range of employee promotion requests (not inclusive)
	 * @return the range of employee promotion requests
	 */
	@Override
	public List<EmployeePromotionRequest> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee promotion requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePromotionRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee promotion requests
	 * @param end the upper bound of the range of employee promotion requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee promotion requests
	 */
	@Override
	public List<EmployeePromotionRequest> findAll(
		int start, int end,
		OrderByComparator<EmployeePromotionRequest> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee promotion requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePromotionRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee promotion requests
	 * @param end the upper bound of the range of employee promotion requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee promotion requests
	 */
	@Override
	public List<EmployeePromotionRequest> findAll(
		int start, int end,
		OrderByComparator<EmployeePromotionRequest> orderByComparator,
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

		List<EmployeePromotionRequest> list = null;

		if (useFinderCache) {
			list = (List<EmployeePromotionRequest>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EMPLOYEEPROMOTIONREQUEST);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLOYEEPROMOTIONREQUEST;

				sql = sql.concat(
					EmployeePromotionRequestModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EmployeePromotionRequest>)QueryUtil.list(
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
	 * Removes all the employee promotion requests from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EmployeePromotionRequest employeePromotionRequest : findAll()) {
			remove(employeePromotionRequest);
		}
	}

	/**
	 * Returns the number of employee promotion requests.
	 *
	 * @return the number of employee promotion requests
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
					_SQL_COUNT_EMPLOYEEPROMOTIONREQUEST);

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
		return "employeePromotionRequestId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EMPLOYEEPROMOTIONREQUEST;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EmployeePromotionRequestModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the employee promotion request persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new EmployeePromotionRequestModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", EmployeePromotionRequest.class.getName()));

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
		entityCache.removeCache(EmployeePromotionRequestImpl.class.getName());

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

	private static final String _SQL_SELECT_EMPLOYEEPROMOTIONREQUEST =
		"SELECT employeePromotionRequest FROM EmployeePromotionRequest employeePromotionRequest";

	private static final String _SQL_SELECT_EMPLOYEEPROMOTIONREQUEST_WHERE =
		"SELECT employeePromotionRequest FROM EmployeePromotionRequest employeePromotionRequest WHERE ";

	private static final String _SQL_COUNT_EMPLOYEEPROMOTIONREQUEST =
		"SELECT COUNT(employeePromotionRequest) FROM EmployeePromotionRequest employeePromotionRequest";

	private static final String _SQL_COUNT_EMPLOYEEPROMOTIONREQUEST_WHERE =
		"SELECT COUNT(employeePromotionRequest) FROM EmployeePromotionRequest employeePromotionRequest WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"employeePromotionRequest.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EmployeePromotionRequest exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EmployeePromotionRequest exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EmployeePromotionRequestPersistenceImpl.class);

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

	private static class EmployeePromotionRequestModelArgumentsResolver
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

			EmployeePromotionRequestModelImpl
				employeePromotionRequestModelImpl =
					(EmployeePromotionRequestModelImpl)baseModel;

			long columnBitmask =
				employeePromotionRequestModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					employeePromotionRequestModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						employeePromotionRequestModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					employeePromotionRequestModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			EmployeePromotionRequestModelImpl employeePromotionRequestModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						employeePromotionRequestModelImpl.
							getColumnOriginalValue(columnName);
				}
				else {
					arguments[i] =
						employeePromotionRequestModelImpl.getColumnValue(
							columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}