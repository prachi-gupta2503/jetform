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

import com.adjecti.pis.liferay.exception.NoSuchJoiningProcessRequestException;
import com.adjecti.pis.liferay.model.JoiningProcessRequest;
import com.adjecti.pis.liferay.model.impl.JoiningProcessRequestImpl;
import com.adjecti.pis.liferay.model.impl.JoiningProcessRequestModelImpl;
import com.adjecti.pis.liferay.service.persistence.JoiningProcessRequestPersistence;
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
 * The persistence implementation for the joining process request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = JoiningProcessRequestPersistence.class)
public class JoiningProcessRequestPersistenceImpl
	extends BasePersistenceImpl<JoiningProcessRequest>
	implements JoiningProcessRequestPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>JoiningProcessRequestUtil</code> to access the joining process request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		JoiningProcessRequestImpl.class.getName();

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
	 * Returns all the joining process requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching joining process requests
	 */
	@Override
	public List<JoiningProcessRequest> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the joining process requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of joining process requests
	 * @param end the upper bound of the range of joining process requests (not inclusive)
	 * @return the range of matching joining process requests
	 */
	@Override
	public List<JoiningProcessRequest> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the joining process requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of joining process requests
	 * @param end the upper bound of the range of joining process requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching joining process requests
	 */
	@Override
	public List<JoiningProcessRequest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<JoiningProcessRequest> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the joining process requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of joining process requests
	 * @param end the upper bound of the range of joining process requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching joining process requests
	 */
	@Override
	public List<JoiningProcessRequest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<JoiningProcessRequest> orderByComparator,
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

		List<JoiningProcessRequest> list = null;

		if (useFinderCache) {
			list = (List<JoiningProcessRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (JoiningProcessRequest joiningProcessRequest : list) {
					if (!uuid.equals(joiningProcessRequest.getUuid())) {
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

			sb.append(_SQL_SELECT_JOININGPROCESSREQUEST_WHERE);

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
				sb.append(JoiningProcessRequestModelImpl.ORDER_BY_JPQL);
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

				list = (List<JoiningProcessRequest>)QueryUtil.list(
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
	 * Returns the first joining process request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching joining process request
	 * @throws NoSuchJoiningProcessRequestException if a matching joining process request could not be found
	 */
	@Override
	public JoiningProcessRequest findByUuid_First(
			String uuid,
			OrderByComparator<JoiningProcessRequest> orderByComparator)
		throws NoSuchJoiningProcessRequestException {

		JoiningProcessRequest joiningProcessRequest = fetchByUuid_First(
			uuid, orderByComparator);

		if (joiningProcessRequest != null) {
			return joiningProcessRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchJoiningProcessRequestException(sb.toString());
	}

	/**
	 * Returns the first joining process request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching joining process request, or <code>null</code> if a matching joining process request could not be found
	 */
	@Override
	public JoiningProcessRequest fetchByUuid_First(
		String uuid,
		OrderByComparator<JoiningProcessRequest> orderByComparator) {

		List<JoiningProcessRequest> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last joining process request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching joining process request
	 * @throws NoSuchJoiningProcessRequestException if a matching joining process request could not be found
	 */
	@Override
	public JoiningProcessRequest findByUuid_Last(
			String uuid,
			OrderByComparator<JoiningProcessRequest> orderByComparator)
		throws NoSuchJoiningProcessRequestException {

		JoiningProcessRequest joiningProcessRequest = fetchByUuid_Last(
			uuid, orderByComparator);

		if (joiningProcessRequest != null) {
			return joiningProcessRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchJoiningProcessRequestException(sb.toString());
	}

	/**
	 * Returns the last joining process request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching joining process request, or <code>null</code> if a matching joining process request could not be found
	 */
	@Override
	public JoiningProcessRequest fetchByUuid_Last(
		String uuid,
		OrderByComparator<JoiningProcessRequest> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<JoiningProcessRequest> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the joining process requests before and after the current joining process request in the ordered set where uuid = &#63;.
	 *
	 * @param joiningProcessRequestId the primary key of the current joining process request
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next joining process request
	 * @throws NoSuchJoiningProcessRequestException if a joining process request with the primary key could not be found
	 */
	@Override
	public JoiningProcessRequest[] findByUuid_PrevAndNext(
			long joiningProcessRequestId, String uuid,
			OrderByComparator<JoiningProcessRequest> orderByComparator)
		throws NoSuchJoiningProcessRequestException {

		uuid = Objects.toString(uuid, "");

		JoiningProcessRequest joiningProcessRequest = findByPrimaryKey(
			joiningProcessRequestId);

		Session session = null;

		try {
			session = openSession();

			JoiningProcessRequest[] array = new JoiningProcessRequestImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, joiningProcessRequest, uuid, orderByComparator, true);

			array[1] = joiningProcessRequest;

			array[2] = getByUuid_PrevAndNext(
				session, joiningProcessRequest, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected JoiningProcessRequest getByUuid_PrevAndNext(
		Session session, JoiningProcessRequest joiningProcessRequest,
		String uuid, OrderByComparator<JoiningProcessRequest> orderByComparator,
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

		sb.append(_SQL_SELECT_JOININGPROCESSREQUEST_WHERE);

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
			sb.append(JoiningProcessRequestModelImpl.ORDER_BY_JPQL);
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
						joiningProcessRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<JoiningProcessRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the joining process requests where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (JoiningProcessRequest joiningProcessRequest :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(joiningProcessRequest);
		}
	}

	/**
	 * Returns the number of joining process requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching joining process requests
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_JOININGPROCESSREQUEST_WHERE);

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
		"joiningProcessRequest.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(joiningProcessRequest.uuid IS NULL OR joiningProcessRequest.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the joining process request where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchJoiningProcessRequestException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching joining process request
	 * @throws NoSuchJoiningProcessRequestException if a matching joining process request could not be found
	 */
	@Override
	public JoiningProcessRequest findByUUID_G(String uuid, long groupId)
		throws NoSuchJoiningProcessRequestException {

		JoiningProcessRequest joiningProcessRequest = fetchByUUID_G(
			uuid, groupId);

		if (joiningProcessRequest == null) {
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

			throw new NoSuchJoiningProcessRequestException(sb.toString());
		}

		return joiningProcessRequest;
	}

	/**
	 * Returns the joining process request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching joining process request, or <code>null</code> if a matching joining process request could not be found
	 */
	@Override
	public JoiningProcessRequest fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the joining process request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching joining process request, or <code>null</code> if a matching joining process request could not be found
	 */
	@Override
	public JoiningProcessRequest fetchByUUID_G(
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

		if (result instanceof JoiningProcessRequest) {
			JoiningProcessRequest joiningProcessRequest =
				(JoiningProcessRequest)result;

			if (!Objects.equals(uuid, joiningProcessRequest.getUuid()) ||
				(groupId != joiningProcessRequest.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_JOININGPROCESSREQUEST_WHERE);

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

				List<JoiningProcessRequest> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					JoiningProcessRequest joiningProcessRequest = list.get(0);

					result = joiningProcessRequest;

					cacheResult(joiningProcessRequest);
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
			return (JoiningProcessRequest)result;
		}
	}

	/**
	 * Removes the joining process request where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the joining process request that was removed
	 */
	@Override
	public JoiningProcessRequest removeByUUID_G(String uuid, long groupId)
		throws NoSuchJoiningProcessRequestException {

		JoiningProcessRequest joiningProcessRequest = findByUUID_G(
			uuid, groupId);

		return remove(joiningProcessRequest);
	}

	/**
	 * Returns the number of joining process requests where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching joining process requests
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_JOININGPROCESSREQUEST_WHERE);

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
		"joiningProcessRequest.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(joiningProcessRequest.uuid IS NULL OR joiningProcessRequest.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"joiningProcessRequest.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the joining process requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching joining process requests
	 */
	@Override
	public List<JoiningProcessRequest> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the joining process requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of joining process requests
	 * @param end the upper bound of the range of joining process requests (not inclusive)
	 * @return the range of matching joining process requests
	 */
	@Override
	public List<JoiningProcessRequest> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the joining process requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of joining process requests
	 * @param end the upper bound of the range of joining process requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching joining process requests
	 */
	@Override
	public List<JoiningProcessRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<JoiningProcessRequest> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the joining process requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of joining process requests
	 * @param end the upper bound of the range of joining process requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching joining process requests
	 */
	@Override
	public List<JoiningProcessRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<JoiningProcessRequest> orderByComparator,
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

		List<JoiningProcessRequest> list = null;

		if (useFinderCache) {
			list = (List<JoiningProcessRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (JoiningProcessRequest joiningProcessRequest : list) {
					if (!uuid.equals(joiningProcessRequest.getUuid()) ||
						(companyId != joiningProcessRequest.getCompanyId())) {

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

			sb.append(_SQL_SELECT_JOININGPROCESSREQUEST_WHERE);

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
				sb.append(JoiningProcessRequestModelImpl.ORDER_BY_JPQL);
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

				list = (List<JoiningProcessRequest>)QueryUtil.list(
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
	 * Returns the first joining process request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching joining process request
	 * @throws NoSuchJoiningProcessRequestException if a matching joining process request could not be found
	 */
	@Override
	public JoiningProcessRequest findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<JoiningProcessRequest> orderByComparator)
		throws NoSuchJoiningProcessRequestException {

		JoiningProcessRequest joiningProcessRequest = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (joiningProcessRequest != null) {
			return joiningProcessRequest;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchJoiningProcessRequestException(sb.toString());
	}

	/**
	 * Returns the first joining process request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching joining process request, or <code>null</code> if a matching joining process request could not be found
	 */
	@Override
	public JoiningProcessRequest fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<JoiningProcessRequest> orderByComparator) {

		List<JoiningProcessRequest> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last joining process request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching joining process request
	 * @throws NoSuchJoiningProcessRequestException if a matching joining process request could not be found
	 */
	@Override
	public JoiningProcessRequest findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<JoiningProcessRequest> orderByComparator)
		throws NoSuchJoiningProcessRequestException {

		JoiningProcessRequest joiningProcessRequest = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (joiningProcessRequest != null) {
			return joiningProcessRequest;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchJoiningProcessRequestException(sb.toString());
	}

	/**
	 * Returns the last joining process request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching joining process request, or <code>null</code> if a matching joining process request could not be found
	 */
	@Override
	public JoiningProcessRequest fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<JoiningProcessRequest> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<JoiningProcessRequest> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the joining process requests before and after the current joining process request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param joiningProcessRequestId the primary key of the current joining process request
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next joining process request
	 * @throws NoSuchJoiningProcessRequestException if a joining process request with the primary key could not be found
	 */
	@Override
	public JoiningProcessRequest[] findByUuid_C_PrevAndNext(
			long joiningProcessRequestId, String uuid, long companyId,
			OrderByComparator<JoiningProcessRequest> orderByComparator)
		throws NoSuchJoiningProcessRequestException {

		uuid = Objects.toString(uuid, "");

		JoiningProcessRequest joiningProcessRequest = findByPrimaryKey(
			joiningProcessRequestId);

		Session session = null;

		try {
			session = openSession();

			JoiningProcessRequest[] array = new JoiningProcessRequestImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, joiningProcessRequest, uuid, companyId,
				orderByComparator, true);

			array[1] = joiningProcessRequest;

			array[2] = getByUuid_C_PrevAndNext(
				session, joiningProcessRequest, uuid, companyId,
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

	protected JoiningProcessRequest getByUuid_C_PrevAndNext(
		Session session, JoiningProcessRequest joiningProcessRequest,
		String uuid, long companyId,
		OrderByComparator<JoiningProcessRequest> orderByComparator,
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

		sb.append(_SQL_SELECT_JOININGPROCESSREQUEST_WHERE);

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
			sb.append(JoiningProcessRequestModelImpl.ORDER_BY_JPQL);
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
						joiningProcessRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<JoiningProcessRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the joining process requests where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (JoiningProcessRequest joiningProcessRequest :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(joiningProcessRequest);
		}
	}

	/**
	 * Returns the number of joining process requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching joining process requests
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_JOININGPROCESSREQUEST_WHERE);

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
		"joiningProcessRequest.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(joiningProcessRequest.uuid IS NULL OR joiningProcessRequest.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"joiningProcessRequest.companyId = ?";

	public JoiningProcessRequestPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(JoiningProcessRequest.class);

		setModelImplClass(JoiningProcessRequestImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the joining process request in the entity cache if it is enabled.
	 *
	 * @param joiningProcessRequest the joining process request
	 */
	@Override
	public void cacheResult(JoiningProcessRequest joiningProcessRequest) {
		entityCache.putResult(
			JoiningProcessRequestImpl.class,
			joiningProcessRequest.getPrimaryKey(), joiningProcessRequest);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				joiningProcessRequest.getUuid(),
				joiningProcessRequest.getGroupId()
			},
			joiningProcessRequest);
	}

	/**
	 * Caches the joining process requests in the entity cache if it is enabled.
	 *
	 * @param joiningProcessRequests the joining process requests
	 */
	@Override
	public void cacheResult(
		List<JoiningProcessRequest> joiningProcessRequests) {

		for (JoiningProcessRequest joiningProcessRequest :
				joiningProcessRequests) {

			if (entityCache.getResult(
					JoiningProcessRequestImpl.class,
					joiningProcessRequest.getPrimaryKey()) == null) {

				cacheResult(joiningProcessRequest);
			}
		}
	}

	/**
	 * Clears the cache for all joining process requests.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(JoiningProcessRequestImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the joining process request.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(JoiningProcessRequest joiningProcessRequest) {
		entityCache.removeResult(
			JoiningProcessRequestImpl.class, joiningProcessRequest);
	}

	@Override
	public void clearCache(List<JoiningProcessRequest> joiningProcessRequests) {
		for (JoiningProcessRequest joiningProcessRequest :
				joiningProcessRequests) {

			entityCache.removeResult(
				JoiningProcessRequestImpl.class, joiningProcessRequest);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				JoiningProcessRequestImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		JoiningProcessRequestModelImpl joiningProcessRequestModelImpl) {

		Object[] args = new Object[] {
			joiningProcessRequestModelImpl.getUuid(),
			joiningProcessRequestModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, joiningProcessRequestModelImpl,
			false);
	}

	/**
	 * Creates a new joining process request with the primary key. Does not add the joining process request to the database.
	 *
	 * @param joiningProcessRequestId the primary key for the new joining process request
	 * @return the new joining process request
	 */
	@Override
	public JoiningProcessRequest create(long joiningProcessRequestId) {
		JoiningProcessRequest joiningProcessRequest =
			new JoiningProcessRequestImpl();

		joiningProcessRequest.setNew(true);
		joiningProcessRequest.setPrimaryKey(joiningProcessRequestId);

		String uuid = PortalUUIDUtil.generate();

		joiningProcessRequest.setUuid(uuid);

		joiningProcessRequest.setCompanyId(CompanyThreadLocal.getCompanyId());

		return joiningProcessRequest;
	}

	/**
	 * Removes the joining process request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param joiningProcessRequestId the primary key of the joining process request
	 * @return the joining process request that was removed
	 * @throws NoSuchJoiningProcessRequestException if a joining process request with the primary key could not be found
	 */
	@Override
	public JoiningProcessRequest remove(long joiningProcessRequestId)
		throws NoSuchJoiningProcessRequestException {

		return remove((Serializable)joiningProcessRequestId);
	}

	/**
	 * Removes the joining process request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the joining process request
	 * @return the joining process request that was removed
	 * @throws NoSuchJoiningProcessRequestException if a joining process request with the primary key could not be found
	 */
	@Override
	public JoiningProcessRequest remove(Serializable primaryKey)
		throws NoSuchJoiningProcessRequestException {

		Session session = null;

		try {
			session = openSession();

			JoiningProcessRequest joiningProcessRequest =
				(JoiningProcessRequest)session.get(
					JoiningProcessRequestImpl.class, primaryKey);

			if (joiningProcessRequest == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchJoiningProcessRequestException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(joiningProcessRequest);
		}
		catch (NoSuchJoiningProcessRequestException noSuchEntityException) {
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
	protected JoiningProcessRequest removeImpl(
		JoiningProcessRequest joiningProcessRequest) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(joiningProcessRequest)) {
				joiningProcessRequest = (JoiningProcessRequest)session.get(
					JoiningProcessRequestImpl.class,
					joiningProcessRequest.getPrimaryKeyObj());
			}

			if (joiningProcessRequest != null) {
				session.delete(joiningProcessRequest);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (joiningProcessRequest != null) {
			clearCache(joiningProcessRequest);
		}

		return joiningProcessRequest;
	}

	@Override
	public JoiningProcessRequest updateImpl(
		JoiningProcessRequest joiningProcessRequest) {

		boolean isNew = joiningProcessRequest.isNew();

		if (!(joiningProcessRequest instanceof
				JoiningProcessRequestModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(joiningProcessRequest.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					joiningProcessRequest);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in joiningProcessRequest proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom JoiningProcessRequest implementation " +
					joiningProcessRequest.getClass());
		}

		JoiningProcessRequestModelImpl joiningProcessRequestModelImpl =
			(JoiningProcessRequestModelImpl)joiningProcessRequest;

		if (Validator.isNull(joiningProcessRequest.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			joiningProcessRequest.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (joiningProcessRequest.getCreateDate() == null)) {
			if (serviceContext == null) {
				joiningProcessRequest.setCreateDate(now);
			}
			else {
				joiningProcessRequest.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!joiningProcessRequestModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				joiningProcessRequest.setModifiedDate(now);
			}
			else {
				joiningProcessRequest.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(joiningProcessRequest);
			}
			else {
				joiningProcessRequest = (JoiningProcessRequest)session.merge(
					joiningProcessRequest);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			JoiningProcessRequestImpl.class, joiningProcessRequestModelImpl,
			false, true);

		cacheUniqueFindersCache(joiningProcessRequestModelImpl);

		if (isNew) {
			joiningProcessRequest.setNew(false);
		}

		joiningProcessRequest.resetOriginalValues();

		return joiningProcessRequest;
	}

	/**
	 * Returns the joining process request with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the joining process request
	 * @return the joining process request
	 * @throws NoSuchJoiningProcessRequestException if a joining process request with the primary key could not be found
	 */
	@Override
	public JoiningProcessRequest findByPrimaryKey(Serializable primaryKey)
		throws NoSuchJoiningProcessRequestException {

		JoiningProcessRequest joiningProcessRequest = fetchByPrimaryKey(
			primaryKey);

		if (joiningProcessRequest == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchJoiningProcessRequestException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return joiningProcessRequest;
	}

	/**
	 * Returns the joining process request with the primary key or throws a <code>NoSuchJoiningProcessRequestException</code> if it could not be found.
	 *
	 * @param joiningProcessRequestId the primary key of the joining process request
	 * @return the joining process request
	 * @throws NoSuchJoiningProcessRequestException if a joining process request with the primary key could not be found
	 */
	@Override
	public JoiningProcessRequest findByPrimaryKey(long joiningProcessRequestId)
		throws NoSuchJoiningProcessRequestException {

		return findByPrimaryKey((Serializable)joiningProcessRequestId);
	}

	/**
	 * Returns the joining process request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param joiningProcessRequestId the primary key of the joining process request
	 * @return the joining process request, or <code>null</code> if a joining process request with the primary key could not be found
	 */
	@Override
	public JoiningProcessRequest fetchByPrimaryKey(
		long joiningProcessRequestId) {

		return fetchByPrimaryKey((Serializable)joiningProcessRequestId);
	}

	/**
	 * Returns all the joining process requests.
	 *
	 * @return the joining process requests
	 */
	@Override
	public List<JoiningProcessRequest> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the joining process requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of joining process requests
	 * @param end the upper bound of the range of joining process requests (not inclusive)
	 * @return the range of joining process requests
	 */
	@Override
	public List<JoiningProcessRequest> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the joining process requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of joining process requests
	 * @param end the upper bound of the range of joining process requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of joining process requests
	 */
	@Override
	public List<JoiningProcessRequest> findAll(
		int start, int end,
		OrderByComparator<JoiningProcessRequest> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the joining process requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of joining process requests
	 * @param end the upper bound of the range of joining process requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of joining process requests
	 */
	@Override
	public List<JoiningProcessRequest> findAll(
		int start, int end,
		OrderByComparator<JoiningProcessRequest> orderByComparator,
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

		List<JoiningProcessRequest> list = null;

		if (useFinderCache) {
			list = (List<JoiningProcessRequest>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_JOININGPROCESSREQUEST);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_JOININGPROCESSREQUEST;

				sql = sql.concat(JoiningProcessRequestModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<JoiningProcessRequest>)QueryUtil.list(
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
	 * Removes all the joining process requests from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (JoiningProcessRequest joiningProcessRequest : findAll()) {
			remove(joiningProcessRequest);
		}
	}

	/**
	 * Returns the number of joining process requests.
	 *
	 * @return the number of joining process requests
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
					_SQL_COUNT_JOININGPROCESSREQUEST);

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
		return "joiningProcessRequestId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_JOININGPROCESSREQUEST;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return JoiningProcessRequestModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the joining process request persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new JoiningProcessRequestModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", JoiningProcessRequest.class.getName()));

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
		entityCache.removeCache(JoiningProcessRequestImpl.class.getName());

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

	private static final String _SQL_SELECT_JOININGPROCESSREQUEST =
		"SELECT joiningProcessRequest FROM JoiningProcessRequest joiningProcessRequest";

	private static final String _SQL_SELECT_JOININGPROCESSREQUEST_WHERE =
		"SELECT joiningProcessRequest FROM JoiningProcessRequest joiningProcessRequest WHERE ";

	private static final String _SQL_COUNT_JOININGPROCESSREQUEST =
		"SELECT COUNT(joiningProcessRequest) FROM JoiningProcessRequest joiningProcessRequest";

	private static final String _SQL_COUNT_JOININGPROCESSREQUEST_WHERE =
		"SELECT COUNT(joiningProcessRequest) FROM JoiningProcessRequest joiningProcessRequest WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"joiningProcessRequest.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No JoiningProcessRequest exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No JoiningProcessRequest exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		JoiningProcessRequestPersistenceImpl.class);

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

	private static class JoiningProcessRequestModelArgumentsResolver
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

			JoiningProcessRequestModelImpl joiningProcessRequestModelImpl =
				(JoiningProcessRequestModelImpl)baseModel;

			long columnBitmask =
				joiningProcessRequestModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					joiningProcessRequestModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						joiningProcessRequestModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					joiningProcessRequestModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			JoiningProcessRequestModelImpl joiningProcessRequestModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						joiningProcessRequestModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] =
						joiningProcessRequestModelImpl.getColumnValue(
							columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}