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

import com.adjecti.pis.liferay.exception.NoSuchSampleProcessRequestException;
import com.adjecti.pis.liferay.model.SampleProcessRequest;
import com.adjecti.pis.liferay.model.impl.SampleProcessRequestImpl;
import com.adjecti.pis.liferay.model.impl.SampleProcessRequestModelImpl;
import com.adjecti.pis.liferay.service.persistence.SampleProcessRequestPersistence;
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
 * The persistence implementation for the sample process request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = SampleProcessRequestPersistence.class)
public class SampleProcessRequestPersistenceImpl
	extends BasePersistenceImpl<SampleProcessRequest>
	implements SampleProcessRequestPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SampleProcessRequestUtil</code> to access the sample process request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SampleProcessRequestImpl.class.getName();

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
	 * Returns all the sample process requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching sample process requests
	 */
	@Override
	public List<SampleProcessRequest> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sample process requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sample process requests
	 * @param end the upper bound of the range of sample process requests (not inclusive)
	 * @return the range of matching sample process requests
	 */
	@Override
	public List<SampleProcessRequest> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the sample process requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sample process requests
	 * @param end the upper bound of the range of sample process requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sample process requests
	 */
	@Override
	public List<SampleProcessRequest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SampleProcessRequest> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sample process requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sample process requests
	 * @param end the upper bound of the range of sample process requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sample process requests
	 */
	@Override
	public List<SampleProcessRequest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SampleProcessRequest> orderByComparator,
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

		List<SampleProcessRequest> list = null;

		if (useFinderCache) {
			list = (List<SampleProcessRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SampleProcessRequest sampleProcessRequest : list) {
					if (!uuid.equals(sampleProcessRequest.getUuid())) {
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

			sb.append(_SQL_SELECT_SAMPLEPROCESSREQUEST_WHERE);

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
				sb.append(SampleProcessRequestModelImpl.ORDER_BY_JPQL);
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

				list = (List<SampleProcessRequest>)QueryUtil.list(
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
	 * Returns the first sample process request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample process request
	 * @throws NoSuchSampleProcessRequestException if a matching sample process request could not be found
	 */
	@Override
	public SampleProcessRequest findByUuid_First(
			String uuid,
			OrderByComparator<SampleProcessRequest> orderByComparator)
		throws NoSuchSampleProcessRequestException {

		SampleProcessRequest sampleProcessRequest = fetchByUuid_First(
			uuid, orderByComparator);

		if (sampleProcessRequest != null) {
			return sampleProcessRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSampleProcessRequestException(sb.toString());
	}

	/**
	 * Returns the first sample process request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample process request, or <code>null</code> if a matching sample process request could not be found
	 */
	@Override
	public SampleProcessRequest fetchByUuid_First(
		String uuid,
		OrderByComparator<SampleProcessRequest> orderByComparator) {

		List<SampleProcessRequest> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sample process request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample process request
	 * @throws NoSuchSampleProcessRequestException if a matching sample process request could not be found
	 */
	@Override
	public SampleProcessRequest findByUuid_Last(
			String uuid,
			OrderByComparator<SampleProcessRequest> orderByComparator)
		throws NoSuchSampleProcessRequestException {

		SampleProcessRequest sampleProcessRequest = fetchByUuid_Last(
			uuid, orderByComparator);

		if (sampleProcessRequest != null) {
			return sampleProcessRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSampleProcessRequestException(sb.toString());
	}

	/**
	 * Returns the last sample process request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample process request, or <code>null</code> if a matching sample process request could not be found
	 */
	@Override
	public SampleProcessRequest fetchByUuid_Last(
		String uuid,
		OrderByComparator<SampleProcessRequest> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<SampleProcessRequest> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the sample process requests before and after the current sample process request in the ordered set where uuid = &#63;.
	 *
	 * @param sampleProcessRequestId the primary key of the current sample process request
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample process request
	 * @throws NoSuchSampleProcessRequestException if a sample process request with the primary key could not be found
	 */
	@Override
	public SampleProcessRequest[] findByUuid_PrevAndNext(
			long sampleProcessRequestId, String uuid,
			OrderByComparator<SampleProcessRequest> orderByComparator)
		throws NoSuchSampleProcessRequestException {

		uuid = Objects.toString(uuid, "");

		SampleProcessRequest sampleProcessRequest = findByPrimaryKey(
			sampleProcessRequestId);

		Session session = null;

		try {
			session = openSession();

			SampleProcessRequest[] array = new SampleProcessRequestImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, sampleProcessRequest, uuid, orderByComparator, true);

			array[1] = sampleProcessRequest;

			array[2] = getByUuid_PrevAndNext(
				session, sampleProcessRequest, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SampleProcessRequest getByUuid_PrevAndNext(
		Session session, SampleProcessRequest sampleProcessRequest, String uuid,
		OrderByComparator<SampleProcessRequest> orderByComparator,
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

		sb.append(_SQL_SELECT_SAMPLEPROCESSREQUEST_WHERE);

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
			sb.append(SampleProcessRequestModelImpl.ORDER_BY_JPQL);
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
						sampleProcessRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SampleProcessRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sample process requests where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (SampleProcessRequest sampleProcessRequest :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(sampleProcessRequest);
		}
	}

	/**
	 * Returns the number of sample process requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching sample process requests
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SAMPLEPROCESSREQUEST_WHERE);

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
		"sampleProcessRequest.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(sampleProcessRequest.uuid IS NULL OR sampleProcessRequest.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the sample process request where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSampleProcessRequestException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching sample process request
	 * @throws NoSuchSampleProcessRequestException if a matching sample process request could not be found
	 */
	@Override
	public SampleProcessRequest findByUUID_G(String uuid, long groupId)
		throws NoSuchSampleProcessRequestException {

		SampleProcessRequest sampleProcessRequest = fetchByUUID_G(
			uuid, groupId);

		if (sampleProcessRequest == null) {
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

			throw new NoSuchSampleProcessRequestException(sb.toString());
		}

		return sampleProcessRequest;
	}

	/**
	 * Returns the sample process request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching sample process request, or <code>null</code> if a matching sample process request could not be found
	 */
	@Override
	public SampleProcessRequest fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the sample process request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sample process request, or <code>null</code> if a matching sample process request could not be found
	 */
	@Override
	public SampleProcessRequest fetchByUUID_G(
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

		if (result instanceof SampleProcessRequest) {
			SampleProcessRequest sampleProcessRequest =
				(SampleProcessRequest)result;

			if (!Objects.equals(uuid, sampleProcessRequest.getUuid()) ||
				(groupId != sampleProcessRequest.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_SAMPLEPROCESSREQUEST_WHERE);

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

				List<SampleProcessRequest> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					SampleProcessRequest sampleProcessRequest = list.get(0);

					result = sampleProcessRequest;

					cacheResult(sampleProcessRequest);
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
			return (SampleProcessRequest)result;
		}
	}

	/**
	 * Removes the sample process request where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the sample process request that was removed
	 */
	@Override
	public SampleProcessRequest removeByUUID_G(String uuid, long groupId)
		throws NoSuchSampleProcessRequestException {

		SampleProcessRequest sampleProcessRequest = findByUUID_G(uuid, groupId);

		return remove(sampleProcessRequest);
	}

	/**
	 * Returns the number of sample process requests where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching sample process requests
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SAMPLEPROCESSREQUEST_WHERE);

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
		"sampleProcessRequest.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(sampleProcessRequest.uuid IS NULL OR sampleProcessRequest.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"sampleProcessRequest.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the sample process requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching sample process requests
	 */
	@Override
	public List<SampleProcessRequest> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sample process requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of sample process requests
	 * @param end the upper bound of the range of sample process requests (not inclusive)
	 * @return the range of matching sample process requests
	 */
	@Override
	public List<SampleProcessRequest> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the sample process requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of sample process requests
	 * @param end the upper bound of the range of sample process requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sample process requests
	 */
	@Override
	public List<SampleProcessRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SampleProcessRequest> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sample process requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of sample process requests
	 * @param end the upper bound of the range of sample process requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sample process requests
	 */
	@Override
	public List<SampleProcessRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SampleProcessRequest> orderByComparator,
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

		List<SampleProcessRequest> list = null;

		if (useFinderCache) {
			list = (List<SampleProcessRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SampleProcessRequest sampleProcessRequest : list) {
					if (!uuid.equals(sampleProcessRequest.getUuid()) ||
						(companyId != sampleProcessRequest.getCompanyId())) {

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

			sb.append(_SQL_SELECT_SAMPLEPROCESSREQUEST_WHERE);

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
				sb.append(SampleProcessRequestModelImpl.ORDER_BY_JPQL);
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

				list = (List<SampleProcessRequest>)QueryUtil.list(
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
	 * Returns the first sample process request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample process request
	 * @throws NoSuchSampleProcessRequestException if a matching sample process request could not be found
	 */
	@Override
	public SampleProcessRequest findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<SampleProcessRequest> orderByComparator)
		throws NoSuchSampleProcessRequestException {

		SampleProcessRequest sampleProcessRequest = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (sampleProcessRequest != null) {
			return sampleProcessRequest;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchSampleProcessRequestException(sb.toString());
	}

	/**
	 * Returns the first sample process request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample process request, or <code>null</code> if a matching sample process request could not be found
	 */
	@Override
	public SampleProcessRequest fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<SampleProcessRequest> orderByComparator) {

		List<SampleProcessRequest> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sample process request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample process request
	 * @throws NoSuchSampleProcessRequestException if a matching sample process request could not be found
	 */
	@Override
	public SampleProcessRequest findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<SampleProcessRequest> orderByComparator)
		throws NoSuchSampleProcessRequestException {

		SampleProcessRequest sampleProcessRequest = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (sampleProcessRequest != null) {
			return sampleProcessRequest;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchSampleProcessRequestException(sb.toString());
	}

	/**
	 * Returns the last sample process request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample process request, or <code>null</code> if a matching sample process request could not be found
	 */
	@Override
	public SampleProcessRequest fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<SampleProcessRequest> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<SampleProcessRequest> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the sample process requests before and after the current sample process request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param sampleProcessRequestId the primary key of the current sample process request
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample process request
	 * @throws NoSuchSampleProcessRequestException if a sample process request with the primary key could not be found
	 */
	@Override
	public SampleProcessRequest[] findByUuid_C_PrevAndNext(
			long sampleProcessRequestId, String uuid, long companyId,
			OrderByComparator<SampleProcessRequest> orderByComparator)
		throws NoSuchSampleProcessRequestException {

		uuid = Objects.toString(uuid, "");

		SampleProcessRequest sampleProcessRequest = findByPrimaryKey(
			sampleProcessRequestId);

		Session session = null;

		try {
			session = openSession();

			SampleProcessRequest[] array = new SampleProcessRequestImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, sampleProcessRequest, uuid, companyId,
				orderByComparator, true);

			array[1] = sampleProcessRequest;

			array[2] = getByUuid_C_PrevAndNext(
				session, sampleProcessRequest, uuid, companyId,
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

	protected SampleProcessRequest getByUuid_C_PrevAndNext(
		Session session, SampleProcessRequest sampleProcessRequest, String uuid,
		long companyId,
		OrderByComparator<SampleProcessRequest> orderByComparator,
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

		sb.append(_SQL_SELECT_SAMPLEPROCESSREQUEST_WHERE);

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
			sb.append(SampleProcessRequestModelImpl.ORDER_BY_JPQL);
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
						sampleProcessRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SampleProcessRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sample process requests where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (SampleProcessRequest sampleProcessRequest :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(sampleProcessRequest);
		}
	}

	/**
	 * Returns the number of sample process requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching sample process requests
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SAMPLEPROCESSREQUEST_WHERE);

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
		"sampleProcessRequest.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(sampleProcessRequest.uuid IS NULL OR sampleProcessRequest.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"sampleProcessRequest.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByReviewerUserId;
	private FinderPath _finderPathWithoutPaginationFindByReviewerUserId;
	private FinderPath _finderPathCountByReviewerUserId;

	/**
	 * Returns all the sample process requests where reviewerUserId = &#63;.
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @return the matching sample process requests
	 */
	@Override
	public List<SampleProcessRequest> findByReviewerUserId(
		long reviewerUserId) {

		return findByReviewerUserId(
			reviewerUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sample process requests where reviewerUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @param start the lower bound of the range of sample process requests
	 * @param end the upper bound of the range of sample process requests (not inclusive)
	 * @return the range of matching sample process requests
	 */
	@Override
	public List<SampleProcessRequest> findByReviewerUserId(
		long reviewerUserId, int start, int end) {

		return findByReviewerUserId(reviewerUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the sample process requests where reviewerUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @param start the lower bound of the range of sample process requests
	 * @param end the upper bound of the range of sample process requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sample process requests
	 */
	@Override
	public List<SampleProcessRequest> findByReviewerUserId(
		long reviewerUserId, int start, int end,
		OrderByComparator<SampleProcessRequest> orderByComparator) {

		return findByReviewerUserId(
			reviewerUserId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sample process requests where reviewerUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @param start the lower bound of the range of sample process requests
	 * @param end the upper bound of the range of sample process requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sample process requests
	 */
	@Override
	public List<SampleProcessRequest> findByReviewerUserId(
		long reviewerUserId, int start, int end,
		OrderByComparator<SampleProcessRequest> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByReviewerUserId;
				finderArgs = new Object[] {reviewerUserId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByReviewerUserId;
			finderArgs = new Object[] {
				reviewerUserId, start, end, orderByComparator
			};
		}

		List<SampleProcessRequest> list = null;

		if (useFinderCache) {
			list = (List<SampleProcessRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SampleProcessRequest sampleProcessRequest : list) {
					if (reviewerUserId !=
							sampleProcessRequest.getReviewerUserId()) {

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

			sb.append(_SQL_SELECT_SAMPLEPROCESSREQUEST_WHERE);

			sb.append(_FINDER_COLUMN_REVIEWERUSERID_REVIEWERUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SampleProcessRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(reviewerUserId);

				list = (List<SampleProcessRequest>)QueryUtil.list(
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
	 * Returns the first sample process request in the ordered set where reviewerUserId = &#63;.
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample process request
	 * @throws NoSuchSampleProcessRequestException if a matching sample process request could not be found
	 */
	@Override
	public SampleProcessRequest findByReviewerUserId_First(
			long reviewerUserId,
			OrderByComparator<SampleProcessRequest> orderByComparator)
		throws NoSuchSampleProcessRequestException {

		SampleProcessRequest sampleProcessRequest = fetchByReviewerUserId_First(
			reviewerUserId, orderByComparator);

		if (sampleProcessRequest != null) {
			return sampleProcessRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("reviewerUserId=");
		sb.append(reviewerUserId);

		sb.append("}");

		throw new NoSuchSampleProcessRequestException(sb.toString());
	}

	/**
	 * Returns the first sample process request in the ordered set where reviewerUserId = &#63;.
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample process request, or <code>null</code> if a matching sample process request could not be found
	 */
	@Override
	public SampleProcessRequest fetchByReviewerUserId_First(
		long reviewerUserId,
		OrderByComparator<SampleProcessRequest> orderByComparator) {

		List<SampleProcessRequest> list = findByReviewerUserId(
			reviewerUserId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sample process request in the ordered set where reviewerUserId = &#63;.
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample process request
	 * @throws NoSuchSampleProcessRequestException if a matching sample process request could not be found
	 */
	@Override
	public SampleProcessRequest findByReviewerUserId_Last(
			long reviewerUserId,
			OrderByComparator<SampleProcessRequest> orderByComparator)
		throws NoSuchSampleProcessRequestException {

		SampleProcessRequest sampleProcessRequest = fetchByReviewerUserId_Last(
			reviewerUserId, orderByComparator);

		if (sampleProcessRequest != null) {
			return sampleProcessRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("reviewerUserId=");
		sb.append(reviewerUserId);

		sb.append("}");

		throw new NoSuchSampleProcessRequestException(sb.toString());
	}

	/**
	 * Returns the last sample process request in the ordered set where reviewerUserId = &#63;.
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample process request, or <code>null</code> if a matching sample process request could not be found
	 */
	@Override
	public SampleProcessRequest fetchByReviewerUserId_Last(
		long reviewerUserId,
		OrderByComparator<SampleProcessRequest> orderByComparator) {

		int count = countByReviewerUserId(reviewerUserId);

		if (count == 0) {
			return null;
		}

		List<SampleProcessRequest> list = findByReviewerUserId(
			reviewerUserId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the sample process requests before and after the current sample process request in the ordered set where reviewerUserId = &#63;.
	 *
	 * @param sampleProcessRequestId the primary key of the current sample process request
	 * @param reviewerUserId the reviewer user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample process request
	 * @throws NoSuchSampleProcessRequestException if a sample process request with the primary key could not be found
	 */
	@Override
	public SampleProcessRequest[] findByReviewerUserId_PrevAndNext(
			long sampleProcessRequestId, long reviewerUserId,
			OrderByComparator<SampleProcessRequest> orderByComparator)
		throws NoSuchSampleProcessRequestException {

		SampleProcessRequest sampleProcessRequest = findByPrimaryKey(
			sampleProcessRequestId);

		Session session = null;

		try {
			session = openSession();

			SampleProcessRequest[] array = new SampleProcessRequestImpl[3];

			array[0] = getByReviewerUserId_PrevAndNext(
				session, sampleProcessRequest, reviewerUserId,
				orderByComparator, true);

			array[1] = sampleProcessRequest;

			array[2] = getByReviewerUserId_PrevAndNext(
				session, sampleProcessRequest, reviewerUserId,
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

	protected SampleProcessRequest getByReviewerUserId_PrevAndNext(
		Session session, SampleProcessRequest sampleProcessRequest,
		long reviewerUserId,
		OrderByComparator<SampleProcessRequest> orderByComparator,
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

		sb.append(_SQL_SELECT_SAMPLEPROCESSREQUEST_WHERE);

		sb.append(_FINDER_COLUMN_REVIEWERUSERID_REVIEWERUSERID_2);

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
			sb.append(SampleProcessRequestModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(reviewerUserId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						sampleProcessRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SampleProcessRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sample process requests where reviewerUserId = &#63; from the database.
	 *
	 * @param reviewerUserId the reviewer user ID
	 */
	@Override
	public void removeByReviewerUserId(long reviewerUserId) {
		for (SampleProcessRequest sampleProcessRequest :
				findByReviewerUserId(
					reviewerUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(sampleProcessRequest);
		}
	}

	/**
	 * Returns the number of sample process requests where reviewerUserId = &#63;.
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @return the number of matching sample process requests
	 */
	@Override
	public int countByReviewerUserId(long reviewerUserId) {
		FinderPath finderPath = _finderPathCountByReviewerUserId;

		Object[] finderArgs = new Object[] {reviewerUserId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SAMPLEPROCESSREQUEST_WHERE);

			sb.append(_FINDER_COLUMN_REVIEWERUSERID_REVIEWERUSERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(reviewerUserId);

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

	private static final String _FINDER_COLUMN_REVIEWERUSERID_REVIEWERUSERID_2 =
		"sampleProcessRequest.reviewerUserId = ?";

	private FinderPath _finderPathWithPaginationFindByApproverUserId;
	private FinderPath _finderPathWithoutPaginationFindByApproverUserId;
	private FinderPath _finderPathCountByApproverUserId;

	/**
	 * Returns all the sample process requests where approverUserId = &#63;.
	 *
	 * @param approverUserId the approver user ID
	 * @return the matching sample process requests
	 */
	@Override
	public List<SampleProcessRequest> findByApproverUserId(
		long approverUserId) {

		return findByApproverUserId(
			approverUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sample process requests where approverUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param approverUserId the approver user ID
	 * @param start the lower bound of the range of sample process requests
	 * @param end the upper bound of the range of sample process requests (not inclusive)
	 * @return the range of matching sample process requests
	 */
	@Override
	public List<SampleProcessRequest> findByApproverUserId(
		long approverUserId, int start, int end) {

		return findByApproverUserId(approverUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the sample process requests where approverUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param approverUserId the approver user ID
	 * @param start the lower bound of the range of sample process requests
	 * @param end the upper bound of the range of sample process requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sample process requests
	 */
	@Override
	public List<SampleProcessRequest> findByApproverUserId(
		long approverUserId, int start, int end,
		OrderByComparator<SampleProcessRequest> orderByComparator) {

		return findByApproverUserId(
			approverUserId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sample process requests where approverUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param approverUserId the approver user ID
	 * @param start the lower bound of the range of sample process requests
	 * @param end the upper bound of the range of sample process requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sample process requests
	 */
	@Override
	public List<SampleProcessRequest> findByApproverUserId(
		long approverUserId, int start, int end,
		OrderByComparator<SampleProcessRequest> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByApproverUserId;
				finderArgs = new Object[] {approverUserId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByApproverUserId;
			finderArgs = new Object[] {
				approverUserId, start, end, orderByComparator
			};
		}

		List<SampleProcessRequest> list = null;

		if (useFinderCache) {
			list = (List<SampleProcessRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SampleProcessRequest sampleProcessRequest : list) {
					if (approverUserId !=
							sampleProcessRequest.getApproverUserId()) {

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

			sb.append(_SQL_SELECT_SAMPLEPROCESSREQUEST_WHERE);

			sb.append(_FINDER_COLUMN_APPROVERUSERID_APPROVERUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SampleProcessRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(approverUserId);

				list = (List<SampleProcessRequest>)QueryUtil.list(
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
	 * Returns the first sample process request in the ordered set where approverUserId = &#63;.
	 *
	 * @param approverUserId the approver user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample process request
	 * @throws NoSuchSampleProcessRequestException if a matching sample process request could not be found
	 */
	@Override
	public SampleProcessRequest findByApproverUserId_First(
			long approverUserId,
			OrderByComparator<SampleProcessRequest> orderByComparator)
		throws NoSuchSampleProcessRequestException {

		SampleProcessRequest sampleProcessRequest = fetchByApproverUserId_First(
			approverUserId, orderByComparator);

		if (sampleProcessRequest != null) {
			return sampleProcessRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("approverUserId=");
		sb.append(approverUserId);

		sb.append("}");

		throw new NoSuchSampleProcessRequestException(sb.toString());
	}

	/**
	 * Returns the first sample process request in the ordered set where approverUserId = &#63;.
	 *
	 * @param approverUserId the approver user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample process request, or <code>null</code> if a matching sample process request could not be found
	 */
	@Override
	public SampleProcessRequest fetchByApproverUserId_First(
		long approverUserId,
		OrderByComparator<SampleProcessRequest> orderByComparator) {

		List<SampleProcessRequest> list = findByApproverUserId(
			approverUserId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sample process request in the ordered set where approverUserId = &#63;.
	 *
	 * @param approverUserId the approver user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample process request
	 * @throws NoSuchSampleProcessRequestException if a matching sample process request could not be found
	 */
	@Override
	public SampleProcessRequest findByApproverUserId_Last(
			long approverUserId,
			OrderByComparator<SampleProcessRequest> orderByComparator)
		throws NoSuchSampleProcessRequestException {

		SampleProcessRequest sampleProcessRequest = fetchByApproverUserId_Last(
			approverUserId, orderByComparator);

		if (sampleProcessRequest != null) {
			return sampleProcessRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("approverUserId=");
		sb.append(approverUserId);

		sb.append("}");

		throw new NoSuchSampleProcessRequestException(sb.toString());
	}

	/**
	 * Returns the last sample process request in the ordered set where approverUserId = &#63;.
	 *
	 * @param approverUserId the approver user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample process request, or <code>null</code> if a matching sample process request could not be found
	 */
	@Override
	public SampleProcessRequest fetchByApproverUserId_Last(
		long approverUserId,
		OrderByComparator<SampleProcessRequest> orderByComparator) {

		int count = countByApproverUserId(approverUserId);

		if (count == 0) {
			return null;
		}

		List<SampleProcessRequest> list = findByApproverUserId(
			approverUserId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the sample process requests before and after the current sample process request in the ordered set where approverUserId = &#63;.
	 *
	 * @param sampleProcessRequestId the primary key of the current sample process request
	 * @param approverUserId the approver user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample process request
	 * @throws NoSuchSampleProcessRequestException if a sample process request with the primary key could not be found
	 */
	@Override
	public SampleProcessRequest[] findByApproverUserId_PrevAndNext(
			long sampleProcessRequestId, long approverUserId,
			OrderByComparator<SampleProcessRequest> orderByComparator)
		throws NoSuchSampleProcessRequestException {

		SampleProcessRequest sampleProcessRequest = findByPrimaryKey(
			sampleProcessRequestId);

		Session session = null;

		try {
			session = openSession();

			SampleProcessRequest[] array = new SampleProcessRequestImpl[3];

			array[0] = getByApproverUserId_PrevAndNext(
				session, sampleProcessRequest, approverUserId,
				orderByComparator, true);

			array[1] = sampleProcessRequest;

			array[2] = getByApproverUserId_PrevAndNext(
				session, sampleProcessRequest, approverUserId,
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

	protected SampleProcessRequest getByApproverUserId_PrevAndNext(
		Session session, SampleProcessRequest sampleProcessRequest,
		long approverUserId,
		OrderByComparator<SampleProcessRequest> orderByComparator,
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

		sb.append(_SQL_SELECT_SAMPLEPROCESSREQUEST_WHERE);

		sb.append(_FINDER_COLUMN_APPROVERUSERID_APPROVERUSERID_2);

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
			sb.append(SampleProcessRequestModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(approverUserId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						sampleProcessRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SampleProcessRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sample process requests where approverUserId = &#63; from the database.
	 *
	 * @param approverUserId the approver user ID
	 */
	@Override
	public void removeByApproverUserId(long approverUserId) {
		for (SampleProcessRequest sampleProcessRequest :
				findByApproverUserId(
					approverUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(sampleProcessRequest);
		}
	}

	/**
	 * Returns the number of sample process requests where approverUserId = &#63;.
	 *
	 * @param approverUserId the approver user ID
	 * @return the number of matching sample process requests
	 */
	@Override
	public int countByApproverUserId(long approverUserId) {
		FinderPath finderPath = _finderPathCountByApproverUserId;

		Object[] finderArgs = new Object[] {approverUserId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SAMPLEPROCESSREQUEST_WHERE);

			sb.append(_FINDER_COLUMN_APPROVERUSERID_APPROVERUSERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(approverUserId);

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

	private static final String _FINDER_COLUMN_APPROVERUSERID_APPROVERUSERID_2 =
		"sampleProcessRequest.approverUserId = ?";

	public SampleProcessRequestPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(SampleProcessRequest.class);

		setModelImplClass(SampleProcessRequestImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the sample process request in the entity cache if it is enabled.
	 *
	 * @param sampleProcessRequest the sample process request
	 */
	@Override
	public void cacheResult(SampleProcessRequest sampleProcessRequest) {
		entityCache.putResult(
			SampleProcessRequestImpl.class,
			sampleProcessRequest.getPrimaryKey(), sampleProcessRequest);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				sampleProcessRequest.getUuid(),
				sampleProcessRequest.getGroupId()
			},
			sampleProcessRequest);
	}

	/**
	 * Caches the sample process requests in the entity cache if it is enabled.
	 *
	 * @param sampleProcessRequests the sample process requests
	 */
	@Override
	public void cacheResult(List<SampleProcessRequest> sampleProcessRequests) {
		for (SampleProcessRequest sampleProcessRequest :
				sampleProcessRequests) {

			if (entityCache.getResult(
					SampleProcessRequestImpl.class,
					sampleProcessRequest.getPrimaryKey()) == null) {

				cacheResult(sampleProcessRequest);
			}
		}
	}

	/**
	 * Clears the cache for all sample process requests.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SampleProcessRequestImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the sample process request.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SampleProcessRequest sampleProcessRequest) {
		entityCache.removeResult(
			SampleProcessRequestImpl.class, sampleProcessRequest);
	}

	@Override
	public void clearCache(List<SampleProcessRequest> sampleProcessRequests) {
		for (SampleProcessRequest sampleProcessRequest :
				sampleProcessRequests) {

			entityCache.removeResult(
				SampleProcessRequestImpl.class, sampleProcessRequest);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				SampleProcessRequestImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		SampleProcessRequestModelImpl sampleProcessRequestModelImpl) {

		Object[] args = new Object[] {
			sampleProcessRequestModelImpl.getUuid(),
			sampleProcessRequestModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, sampleProcessRequestModelImpl,
			false);
	}

	/**
	 * Creates a new sample process request with the primary key. Does not add the sample process request to the database.
	 *
	 * @param sampleProcessRequestId the primary key for the new sample process request
	 * @return the new sample process request
	 */
	@Override
	public SampleProcessRequest create(long sampleProcessRequestId) {
		SampleProcessRequest sampleProcessRequest =
			new SampleProcessRequestImpl();

		sampleProcessRequest.setNew(true);
		sampleProcessRequest.setPrimaryKey(sampleProcessRequestId);

		String uuid = PortalUUIDUtil.generate();

		sampleProcessRequest.setUuid(uuid);

		sampleProcessRequest.setCompanyId(CompanyThreadLocal.getCompanyId());

		return sampleProcessRequest;
	}

	/**
	 * Removes the sample process request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sampleProcessRequestId the primary key of the sample process request
	 * @return the sample process request that was removed
	 * @throws NoSuchSampleProcessRequestException if a sample process request with the primary key could not be found
	 */
	@Override
	public SampleProcessRequest remove(long sampleProcessRequestId)
		throws NoSuchSampleProcessRequestException {

		return remove((Serializable)sampleProcessRequestId);
	}

	/**
	 * Removes the sample process request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sample process request
	 * @return the sample process request that was removed
	 * @throws NoSuchSampleProcessRequestException if a sample process request with the primary key could not be found
	 */
	@Override
	public SampleProcessRequest remove(Serializable primaryKey)
		throws NoSuchSampleProcessRequestException {

		Session session = null;

		try {
			session = openSession();

			SampleProcessRequest sampleProcessRequest =
				(SampleProcessRequest)session.get(
					SampleProcessRequestImpl.class, primaryKey);

			if (sampleProcessRequest == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSampleProcessRequestException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(sampleProcessRequest);
		}
		catch (NoSuchSampleProcessRequestException noSuchEntityException) {
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
	protected SampleProcessRequest removeImpl(
		SampleProcessRequest sampleProcessRequest) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(sampleProcessRequest)) {
				sampleProcessRequest = (SampleProcessRequest)session.get(
					SampleProcessRequestImpl.class,
					sampleProcessRequest.getPrimaryKeyObj());
			}

			if (sampleProcessRequest != null) {
				session.delete(sampleProcessRequest);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (sampleProcessRequest != null) {
			clearCache(sampleProcessRequest);
		}

		return sampleProcessRequest;
	}

	@Override
	public SampleProcessRequest updateImpl(
		SampleProcessRequest sampleProcessRequest) {

		boolean isNew = sampleProcessRequest.isNew();

		if (!(sampleProcessRequest instanceof SampleProcessRequestModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(sampleProcessRequest.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					sampleProcessRequest);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in sampleProcessRequest proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SampleProcessRequest implementation " +
					sampleProcessRequest.getClass());
		}

		SampleProcessRequestModelImpl sampleProcessRequestModelImpl =
			(SampleProcessRequestModelImpl)sampleProcessRequest;

		if (Validator.isNull(sampleProcessRequest.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			sampleProcessRequest.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (sampleProcessRequest.getCreateDate() == null)) {
			if (serviceContext == null) {
				sampleProcessRequest.setCreateDate(now);
			}
			else {
				sampleProcessRequest.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!sampleProcessRequestModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				sampleProcessRequest.setModifiedDate(now);
			}
			else {
				sampleProcessRequest.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(sampleProcessRequest);
			}
			else {
				sampleProcessRequest = (SampleProcessRequest)session.merge(
					sampleProcessRequest);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			SampleProcessRequestImpl.class, sampleProcessRequestModelImpl,
			false, true);

		cacheUniqueFindersCache(sampleProcessRequestModelImpl);

		if (isNew) {
			sampleProcessRequest.setNew(false);
		}

		sampleProcessRequest.resetOriginalValues();

		return sampleProcessRequest;
	}

	/**
	 * Returns the sample process request with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sample process request
	 * @return the sample process request
	 * @throws NoSuchSampleProcessRequestException if a sample process request with the primary key could not be found
	 */
	@Override
	public SampleProcessRequest findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSampleProcessRequestException {

		SampleProcessRequest sampleProcessRequest = fetchByPrimaryKey(
			primaryKey);

		if (sampleProcessRequest == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSampleProcessRequestException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return sampleProcessRequest;
	}

	/**
	 * Returns the sample process request with the primary key or throws a <code>NoSuchSampleProcessRequestException</code> if it could not be found.
	 *
	 * @param sampleProcessRequestId the primary key of the sample process request
	 * @return the sample process request
	 * @throws NoSuchSampleProcessRequestException if a sample process request with the primary key could not be found
	 */
	@Override
	public SampleProcessRequest findByPrimaryKey(long sampleProcessRequestId)
		throws NoSuchSampleProcessRequestException {

		return findByPrimaryKey((Serializable)sampleProcessRequestId);
	}

	/**
	 * Returns the sample process request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sampleProcessRequestId the primary key of the sample process request
	 * @return the sample process request, or <code>null</code> if a sample process request with the primary key could not be found
	 */
	@Override
	public SampleProcessRequest fetchByPrimaryKey(long sampleProcessRequestId) {
		return fetchByPrimaryKey((Serializable)sampleProcessRequestId);
	}

	/**
	 * Returns all the sample process requests.
	 *
	 * @return the sample process requests
	 */
	@Override
	public List<SampleProcessRequest> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sample process requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sample process requests
	 * @param end the upper bound of the range of sample process requests (not inclusive)
	 * @return the range of sample process requests
	 */
	@Override
	public List<SampleProcessRequest> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the sample process requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sample process requests
	 * @param end the upper bound of the range of sample process requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sample process requests
	 */
	@Override
	public List<SampleProcessRequest> findAll(
		int start, int end,
		OrderByComparator<SampleProcessRequest> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sample process requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sample process requests
	 * @param end the upper bound of the range of sample process requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of sample process requests
	 */
	@Override
	public List<SampleProcessRequest> findAll(
		int start, int end,
		OrderByComparator<SampleProcessRequest> orderByComparator,
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

		List<SampleProcessRequest> list = null;

		if (useFinderCache) {
			list = (List<SampleProcessRequest>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SAMPLEPROCESSREQUEST);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SAMPLEPROCESSREQUEST;

				sql = sql.concat(SampleProcessRequestModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SampleProcessRequest>)QueryUtil.list(
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
	 * Removes all the sample process requests from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SampleProcessRequest sampleProcessRequest : findAll()) {
			remove(sampleProcessRequest);
		}
	}

	/**
	 * Returns the number of sample process requests.
	 *
	 * @return the number of sample process requests
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
					_SQL_COUNT_SAMPLEPROCESSREQUEST);

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
		return "sampleProcessRequestId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SAMPLEPROCESSREQUEST;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SampleProcessRequestModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the sample process request persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new SampleProcessRequestModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", SampleProcessRequest.class.getName()));

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

		_finderPathWithPaginationFindByReviewerUserId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByReviewerUserId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"reviewerUserId"}, true);

		_finderPathWithoutPaginationFindByReviewerUserId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByReviewerUserId",
			new String[] {Long.class.getName()},
			new String[] {"reviewerUserId"}, true);

		_finderPathCountByReviewerUserId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByReviewerUserId",
			new String[] {Long.class.getName()},
			new String[] {"reviewerUserId"}, false);

		_finderPathWithPaginationFindByApproverUserId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByApproverUserId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"approverUserId"}, true);

		_finderPathWithoutPaginationFindByApproverUserId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByApproverUserId",
			new String[] {Long.class.getName()},
			new String[] {"approverUserId"}, true);

		_finderPathCountByApproverUserId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByApproverUserId",
			new String[] {Long.class.getName()},
			new String[] {"approverUserId"}, false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(SampleProcessRequestImpl.class.getName());

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

	private static final String _SQL_SELECT_SAMPLEPROCESSREQUEST =
		"SELECT sampleProcessRequest FROM SampleProcessRequest sampleProcessRequest";

	private static final String _SQL_SELECT_SAMPLEPROCESSREQUEST_WHERE =
		"SELECT sampleProcessRequest FROM SampleProcessRequest sampleProcessRequest WHERE ";

	private static final String _SQL_COUNT_SAMPLEPROCESSREQUEST =
		"SELECT COUNT(sampleProcessRequest) FROM SampleProcessRequest sampleProcessRequest";

	private static final String _SQL_COUNT_SAMPLEPROCESSREQUEST_WHERE =
		"SELECT COUNT(sampleProcessRequest) FROM SampleProcessRequest sampleProcessRequest WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"sampleProcessRequest.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SampleProcessRequest exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No SampleProcessRequest exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SampleProcessRequestPersistenceImpl.class);

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

	private static class SampleProcessRequestModelArgumentsResolver
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

			SampleProcessRequestModelImpl sampleProcessRequestModelImpl =
				(SampleProcessRequestModelImpl)baseModel;

			long columnBitmask =
				sampleProcessRequestModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					sampleProcessRequestModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						sampleProcessRequestModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					sampleProcessRequestModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			SampleProcessRequestModelImpl sampleProcessRequestModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						sampleProcessRequestModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = sampleProcessRequestModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}