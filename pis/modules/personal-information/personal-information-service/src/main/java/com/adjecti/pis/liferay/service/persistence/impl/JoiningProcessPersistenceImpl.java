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

import com.adjecti.pis.liferay.exception.NoSuchJoiningProcessException;
import com.adjecti.pis.liferay.model.JoiningProcess;
import com.adjecti.pis.liferay.model.impl.JoiningProcessImpl;
import com.adjecti.pis.liferay.model.impl.JoiningProcessModelImpl;
import com.adjecti.pis.liferay.service.persistence.JoiningProcessPersistence;
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
 * The persistence implementation for the joining process service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = JoiningProcessPersistence.class)
public class JoiningProcessPersistenceImpl
	extends BasePersistenceImpl<JoiningProcess>
	implements JoiningProcessPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>JoiningProcessUtil</code> to access the joining process persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		JoiningProcessImpl.class.getName();

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
	 * Returns all the joining processes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching joining processes
	 */
	@Override
	public List<JoiningProcess> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the joining processes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of joining processes
	 * @param end the upper bound of the range of joining processes (not inclusive)
	 * @return the range of matching joining processes
	 */
	@Override
	public List<JoiningProcess> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the joining processes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of joining processes
	 * @param end the upper bound of the range of joining processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching joining processes
	 */
	@Override
	public List<JoiningProcess> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<JoiningProcess> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the joining processes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of joining processes
	 * @param end the upper bound of the range of joining processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching joining processes
	 */
	@Override
	public List<JoiningProcess> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<JoiningProcess> orderByComparator,
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

		List<JoiningProcess> list = null;

		if (useFinderCache) {
			list = (List<JoiningProcess>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (JoiningProcess joiningProcess : list) {
					if (!uuid.equals(joiningProcess.getUuid())) {
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

			sb.append(_SQL_SELECT_JOININGPROCESS_WHERE);

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
				sb.append(JoiningProcessModelImpl.ORDER_BY_JPQL);
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

				list = (List<JoiningProcess>)QueryUtil.list(
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
	 * Returns the first joining process in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching joining process
	 * @throws NoSuchJoiningProcessException if a matching joining process could not be found
	 */
	@Override
	public JoiningProcess findByUuid_First(
			String uuid, OrderByComparator<JoiningProcess> orderByComparator)
		throws NoSuchJoiningProcessException {

		JoiningProcess joiningProcess = fetchByUuid_First(
			uuid, orderByComparator);

		if (joiningProcess != null) {
			return joiningProcess;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchJoiningProcessException(sb.toString());
	}

	/**
	 * Returns the first joining process in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching joining process, or <code>null</code> if a matching joining process could not be found
	 */
	@Override
	public JoiningProcess fetchByUuid_First(
		String uuid, OrderByComparator<JoiningProcess> orderByComparator) {

		List<JoiningProcess> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last joining process in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching joining process
	 * @throws NoSuchJoiningProcessException if a matching joining process could not be found
	 */
	@Override
	public JoiningProcess findByUuid_Last(
			String uuid, OrderByComparator<JoiningProcess> orderByComparator)
		throws NoSuchJoiningProcessException {

		JoiningProcess joiningProcess = fetchByUuid_Last(
			uuid, orderByComparator);

		if (joiningProcess != null) {
			return joiningProcess;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchJoiningProcessException(sb.toString());
	}

	/**
	 * Returns the last joining process in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching joining process, or <code>null</code> if a matching joining process could not be found
	 */
	@Override
	public JoiningProcess fetchByUuid_Last(
		String uuid, OrderByComparator<JoiningProcess> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<JoiningProcess> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the joining processes before and after the current joining process in the ordered set where uuid = &#63;.
	 *
	 * @param joiningProcessId the primary key of the current joining process
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next joining process
	 * @throws NoSuchJoiningProcessException if a joining process with the primary key could not be found
	 */
	@Override
	public JoiningProcess[] findByUuid_PrevAndNext(
			long joiningProcessId, String uuid,
			OrderByComparator<JoiningProcess> orderByComparator)
		throws NoSuchJoiningProcessException {

		uuid = Objects.toString(uuid, "");

		JoiningProcess joiningProcess = findByPrimaryKey(joiningProcessId);

		Session session = null;

		try {
			session = openSession();

			JoiningProcess[] array = new JoiningProcessImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, joiningProcess, uuid, orderByComparator, true);

			array[1] = joiningProcess;

			array[2] = getByUuid_PrevAndNext(
				session, joiningProcess, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected JoiningProcess getByUuid_PrevAndNext(
		Session session, JoiningProcess joiningProcess, String uuid,
		OrderByComparator<JoiningProcess> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_JOININGPROCESS_WHERE);

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
			sb.append(JoiningProcessModelImpl.ORDER_BY_JPQL);
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
						joiningProcess)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<JoiningProcess> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the joining processes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (JoiningProcess joiningProcess :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(joiningProcess);
		}
	}

	/**
	 * Returns the number of joining processes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching joining processes
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_JOININGPROCESS_WHERE);

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
		"joiningProcess.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(joiningProcess.uuid IS NULL OR joiningProcess.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the joining process where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchJoiningProcessException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching joining process
	 * @throws NoSuchJoiningProcessException if a matching joining process could not be found
	 */
	@Override
	public JoiningProcess findByUUID_G(String uuid, long groupId)
		throws NoSuchJoiningProcessException {

		JoiningProcess joiningProcess = fetchByUUID_G(uuid, groupId);

		if (joiningProcess == null) {
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

			throw new NoSuchJoiningProcessException(sb.toString());
		}

		return joiningProcess;
	}

	/**
	 * Returns the joining process where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching joining process, or <code>null</code> if a matching joining process could not be found
	 */
	@Override
	public JoiningProcess fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the joining process where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching joining process, or <code>null</code> if a matching joining process could not be found
	 */
	@Override
	public JoiningProcess fetchByUUID_G(
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

		if (result instanceof JoiningProcess) {
			JoiningProcess joiningProcess = (JoiningProcess)result;

			if (!Objects.equals(uuid, joiningProcess.getUuid()) ||
				(groupId != joiningProcess.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_JOININGPROCESS_WHERE);

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

				List<JoiningProcess> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					JoiningProcess joiningProcess = list.get(0);

					result = joiningProcess;

					cacheResult(joiningProcess);
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
			return (JoiningProcess)result;
		}
	}

	/**
	 * Removes the joining process where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the joining process that was removed
	 */
	@Override
	public JoiningProcess removeByUUID_G(String uuid, long groupId)
		throws NoSuchJoiningProcessException {

		JoiningProcess joiningProcess = findByUUID_G(uuid, groupId);

		return remove(joiningProcess);
	}

	/**
	 * Returns the number of joining processes where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching joining processes
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_JOININGPROCESS_WHERE);

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
		"joiningProcess.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(joiningProcess.uuid IS NULL OR joiningProcess.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"joiningProcess.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the joining processes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching joining processes
	 */
	@Override
	public List<JoiningProcess> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the joining processes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of joining processes
	 * @param end the upper bound of the range of joining processes (not inclusive)
	 * @return the range of matching joining processes
	 */
	@Override
	public List<JoiningProcess> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the joining processes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of joining processes
	 * @param end the upper bound of the range of joining processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching joining processes
	 */
	@Override
	public List<JoiningProcess> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<JoiningProcess> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the joining processes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of joining processes
	 * @param end the upper bound of the range of joining processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching joining processes
	 */
	@Override
	public List<JoiningProcess> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<JoiningProcess> orderByComparator,
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

		List<JoiningProcess> list = null;

		if (useFinderCache) {
			list = (List<JoiningProcess>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (JoiningProcess joiningProcess : list) {
					if (!uuid.equals(joiningProcess.getUuid()) ||
						(companyId != joiningProcess.getCompanyId())) {

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

			sb.append(_SQL_SELECT_JOININGPROCESS_WHERE);

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
				sb.append(JoiningProcessModelImpl.ORDER_BY_JPQL);
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

				list = (List<JoiningProcess>)QueryUtil.list(
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
	 * Returns the first joining process in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching joining process
	 * @throws NoSuchJoiningProcessException if a matching joining process could not be found
	 */
	@Override
	public JoiningProcess findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<JoiningProcess> orderByComparator)
		throws NoSuchJoiningProcessException {

		JoiningProcess joiningProcess = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (joiningProcess != null) {
			return joiningProcess;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchJoiningProcessException(sb.toString());
	}

	/**
	 * Returns the first joining process in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching joining process, or <code>null</code> if a matching joining process could not be found
	 */
	@Override
	public JoiningProcess fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<JoiningProcess> orderByComparator) {

		List<JoiningProcess> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last joining process in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching joining process
	 * @throws NoSuchJoiningProcessException if a matching joining process could not be found
	 */
	@Override
	public JoiningProcess findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<JoiningProcess> orderByComparator)
		throws NoSuchJoiningProcessException {

		JoiningProcess joiningProcess = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (joiningProcess != null) {
			return joiningProcess;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchJoiningProcessException(sb.toString());
	}

	/**
	 * Returns the last joining process in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching joining process, or <code>null</code> if a matching joining process could not be found
	 */
	@Override
	public JoiningProcess fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<JoiningProcess> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<JoiningProcess> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the joining processes before and after the current joining process in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param joiningProcessId the primary key of the current joining process
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next joining process
	 * @throws NoSuchJoiningProcessException if a joining process with the primary key could not be found
	 */
	@Override
	public JoiningProcess[] findByUuid_C_PrevAndNext(
			long joiningProcessId, String uuid, long companyId,
			OrderByComparator<JoiningProcess> orderByComparator)
		throws NoSuchJoiningProcessException {

		uuid = Objects.toString(uuid, "");

		JoiningProcess joiningProcess = findByPrimaryKey(joiningProcessId);

		Session session = null;

		try {
			session = openSession();

			JoiningProcess[] array = new JoiningProcessImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, joiningProcess, uuid, companyId, orderByComparator,
				true);

			array[1] = joiningProcess;

			array[2] = getByUuid_C_PrevAndNext(
				session, joiningProcess, uuid, companyId, orderByComparator,
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

	protected JoiningProcess getByUuid_C_PrevAndNext(
		Session session, JoiningProcess joiningProcess, String uuid,
		long companyId, OrderByComparator<JoiningProcess> orderByComparator,
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

		sb.append(_SQL_SELECT_JOININGPROCESS_WHERE);

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
			sb.append(JoiningProcessModelImpl.ORDER_BY_JPQL);
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
						joiningProcess)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<JoiningProcess> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the joining processes where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (JoiningProcess joiningProcess :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(joiningProcess);
		}
	}

	/**
	 * Returns the number of joining processes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching joining processes
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_JOININGPROCESS_WHERE);

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
		"joiningProcess.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(joiningProcess.uuid IS NULL OR joiningProcess.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"joiningProcess.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByReviewerUserId;
	private FinderPath _finderPathWithoutPaginationFindByReviewerUserId;
	private FinderPath _finderPathCountByReviewerUserId;

	/**
	 * Returns all the joining processes where reviewerUserId = &#63;.
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @return the matching joining processes
	 */
	@Override
	public List<JoiningProcess> findByReviewerUserId(long reviewerUserId) {
		return findByReviewerUserId(
			reviewerUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the joining processes where reviewerUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessModelImpl</code>.
	 * </p>
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @param start the lower bound of the range of joining processes
	 * @param end the upper bound of the range of joining processes (not inclusive)
	 * @return the range of matching joining processes
	 */
	@Override
	public List<JoiningProcess> findByReviewerUserId(
		long reviewerUserId, int start, int end) {

		return findByReviewerUserId(reviewerUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the joining processes where reviewerUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessModelImpl</code>.
	 * </p>
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @param start the lower bound of the range of joining processes
	 * @param end the upper bound of the range of joining processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching joining processes
	 */
	@Override
	public List<JoiningProcess> findByReviewerUserId(
		long reviewerUserId, int start, int end,
		OrderByComparator<JoiningProcess> orderByComparator) {

		return findByReviewerUserId(
			reviewerUserId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the joining processes where reviewerUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessModelImpl</code>.
	 * </p>
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @param start the lower bound of the range of joining processes
	 * @param end the upper bound of the range of joining processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching joining processes
	 */
	@Override
	public List<JoiningProcess> findByReviewerUserId(
		long reviewerUserId, int start, int end,
		OrderByComparator<JoiningProcess> orderByComparator,
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

		List<JoiningProcess> list = null;

		if (useFinderCache) {
			list = (List<JoiningProcess>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (JoiningProcess joiningProcess : list) {
					if (reviewerUserId != joiningProcess.getReviewerUserId()) {
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

			sb.append(_SQL_SELECT_JOININGPROCESS_WHERE);

			sb.append(_FINDER_COLUMN_REVIEWERUSERID_REVIEWERUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(JoiningProcessModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(reviewerUserId);

				list = (List<JoiningProcess>)QueryUtil.list(
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
	 * Returns the first joining process in the ordered set where reviewerUserId = &#63;.
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching joining process
	 * @throws NoSuchJoiningProcessException if a matching joining process could not be found
	 */
	@Override
	public JoiningProcess findByReviewerUserId_First(
			long reviewerUserId,
			OrderByComparator<JoiningProcess> orderByComparator)
		throws NoSuchJoiningProcessException {

		JoiningProcess joiningProcess = fetchByReviewerUserId_First(
			reviewerUserId, orderByComparator);

		if (joiningProcess != null) {
			return joiningProcess;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("reviewerUserId=");
		sb.append(reviewerUserId);

		sb.append("}");

		throw new NoSuchJoiningProcessException(sb.toString());
	}

	/**
	 * Returns the first joining process in the ordered set where reviewerUserId = &#63;.
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching joining process, or <code>null</code> if a matching joining process could not be found
	 */
	@Override
	public JoiningProcess fetchByReviewerUserId_First(
		long reviewerUserId,
		OrderByComparator<JoiningProcess> orderByComparator) {

		List<JoiningProcess> list = findByReviewerUserId(
			reviewerUserId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last joining process in the ordered set where reviewerUserId = &#63;.
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching joining process
	 * @throws NoSuchJoiningProcessException if a matching joining process could not be found
	 */
	@Override
	public JoiningProcess findByReviewerUserId_Last(
			long reviewerUserId,
			OrderByComparator<JoiningProcess> orderByComparator)
		throws NoSuchJoiningProcessException {

		JoiningProcess joiningProcess = fetchByReviewerUserId_Last(
			reviewerUserId, orderByComparator);

		if (joiningProcess != null) {
			return joiningProcess;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("reviewerUserId=");
		sb.append(reviewerUserId);

		sb.append("}");

		throw new NoSuchJoiningProcessException(sb.toString());
	}

	/**
	 * Returns the last joining process in the ordered set where reviewerUserId = &#63;.
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching joining process, or <code>null</code> if a matching joining process could not be found
	 */
	@Override
	public JoiningProcess fetchByReviewerUserId_Last(
		long reviewerUserId,
		OrderByComparator<JoiningProcess> orderByComparator) {

		int count = countByReviewerUserId(reviewerUserId);

		if (count == 0) {
			return null;
		}

		List<JoiningProcess> list = findByReviewerUserId(
			reviewerUserId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the joining processes before and after the current joining process in the ordered set where reviewerUserId = &#63;.
	 *
	 * @param joiningProcessId the primary key of the current joining process
	 * @param reviewerUserId the reviewer user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next joining process
	 * @throws NoSuchJoiningProcessException if a joining process with the primary key could not be found
	 */
	@Override
	public JoiningProcess[] findByReviewerUserId_PrevAndNext(
			long joiningProcessId, long reviewerUserId,
			OrderByComparator<JoiningProcess> orderByComparator)
		throws NoSuchJoiningProcessException {

		JoiningProcess joiningProcess = findByPrimaryKey(joiningProcessId);

		Session session = null;

		try {
			session = openSession();

			JoiningProcess[] array = new JoiningProcessImpl[3];

			array[0] = getByReviewerUserId_PrevAndNext(
				session, joiningProcess, reviewerUserId, orderByComparator,
				true);

			array[1] = joiningProcess;

			array[2] = getByReviewerUserId_PrevAndNext(
				session, joiningProcess, reviewerUserId, orderByComparator,
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

	protected JoiningProcess getByReviewerUserId_PrevAndNext(
		Session session, JoiningProcess joiningProcess, long reviewerUserId,
		OrderByComparator<JoiningProcess> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_JOININGPROCESS_WHERE);

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
			sb.append(JoiningProcessModelImpl.ORDER_BY_JPQL);
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
						joiningProcess)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<JoiningProcess> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the joining processes where reviewerUserId = &#63; from the database.
	 *
	 * @param reviewerUserId the reviewer user ID
	 */
	@Override
	public void removeByReviewerUserId(long reviewerUserId) {
		for (JoiningProcess joiningProcess :
				findByReviewerUserId(
					reviewerUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(joiningProcess);
		}
	}

	/**
	 * Returns the number of joining processes where reviewerUserId = &#63;.
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @return the number of matching joining processes
	 */
	@Override
	public int countByReviewerUserId(long reviewerUserId) {
		FinderPath finderPath = _finderPathCountByReviewerUserId;

		Object[] finderArgs = new Object[] {reviewerUserId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_JOININGPROCESS_WHERE);

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
		"joiningProcess.reviewerUserId = ?";

	private FinderPath _finderPathWithPaginationFindByUnitId;
	private FinderPath _finderPathWithoutPaginationFindByUnitId;
	private FinderPath _finderPathCountByUnitId;

	/**
	 * Returns all the joining processes where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @return the matching joining processes
	 */
	@Override
	public List<JoiningProcess> findByUnitId(long unitId) {
		return findByUnitId(unitId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the joining processes where unitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param start the lower bound of the range of joining processes
	 * @param end the upper bound of the range of joining processes (not inclusive)
	 * @return the range of matching joining processes
	 */
	@Override
	public List<JoiningProcess> findByUnitId(long unitId, int start, int end) {
		return findByUnitId(unitId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the joining processes where unitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param start the lower bound of the range of joining processes
	 * @param end the upper bound of the range of joining processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching joining processes
	 */
	@Override
	public List<JoiningProcess> findByUnitId(
		long unitId, int start, int end,
		OrderByComparator<JoiningProcess> orderByComparator) {

		return findByUnitId(unitId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the joining processes where unitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param start the lower bound of the range of joining processes
	 * @param end the upper bound of the range of joining processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching joining processes
	 */
	@Override
	public List<JoiningProcess> findByUnitId(
		long unitId, int start, int end,
		OrderByComparator<JoiningProcess> orderByComparator,
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

		List<JoiningProcess> list = null;

		if (useFinderCache) {
			list = (List<JoiningProcess>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (JoiningProcess joiningProcess : list) {
					if (unitId != joiningProcess.getUnitId()) {
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

			sb.append(_SQL_SELECT_JOININGPROCESS_WHERE);

			sb.append(_FINDER_COLUMN_UNITID_UNITID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(JoiningProcessModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(unitId);

				list = (List<JoiningProcess>)QueryUtil.list(
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
	 * Returns the first joining process in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching joining process
	 * @throws NoSuchJoiningProcessException if a matching joining process could not be found
	 */
	@Override
	public JoiningProcess findByUnitId_First(
			long unitId, OrderByComparator<JoiningProcess> orderByComparator)
		throws NoSuchJoiningProcessException {

		JoiningProcess joiningProcess = fetchByUnitId_First(
			unitId, orderByComparator);

		if (joiningProcess != null) {
			return joiningProcess;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("unitId=");
		sb.append(unitId);

		sb.append("}");

		throw new NoSuchJoiningProcessException(sb.toString());
	}

	/**
	 * Returns the first joining process in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching joining process, or <code>null</code> if a matching joining process could not be found
	 */
	@Override
	public JoiningProcess fetchByUnitId_First(
		long unitId, OrderByComparator<JoiningProcess> orderByComparator) {

		List<JoiningProcess> list = findByUnitId(
			unitId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last joining process in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching joining process
	 * @throws NoSuchJoiningProcessException if a matching joining process could not be found
	 */
	@Override
	public JoiningProcess findByUnitId_Last(
			long unitId, OrderByComparator<JoiningProcess> orderByComparator)
		throws NoSuchJoiningProcessException {

		JoiningProcess joiningProcess = fetchByUnitId_Last(
			unitId, orderByComparator);

		if (joiningProcess != null) {
			return joiningProcess;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("unitId=");
		sb.append(unitId);

		sb.append("}");

		throw new NoSuchJoiningProcessException(sb.toString());
	}

	/**
	 * Returns the last joining process in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching joining process, or <code>null</code> if a matching joining process could not be found
	 */
	@Override
	public JoiningProcess fetchByUnitId_Last(
		long unitId, OrderByComparator<JoiningProcess> orderByComparator) {

		int count = countByUnitId(unitId);

		if (count == 0) {
			return null;
		}

		List<JoiningProcess> list = findByUnitId(
			unitId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the joining processes before and after the current joining process in the ordered set where unitId = &#63;.
	 *
	 * @param joiningProcessId the primary key of the current joining process
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next joining process
	 * @throws NoSuchJoiningProcessException if a joining process with the primary key could not be found
	 */
	@Override
	public JoiningProcess[] findByUnitId_PrevAndNext(
			long joiningProcessId, long unitId,
			OrderByComparator<JoiningProcess> orderByComparator)
		throws NoSuchJoiningProcessException {

		JoiningProcess joiningProcess = findByPrimaryKey(joiningProcessId);

		Session session = null;

		try {
			session = openSession();

			JoiningProcess[] array = new JoiningProcessImpl[3];

			array[0] = getByUnitId_PrevAndNext(
				session, joiningProcess, unitId, orderByComparator, true);

			array[1] = joiningProcess;

			array[2] = getByUnitId_PrevAndNext(
				session, joiningProcess, unitId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected JoiningProcess getByUnitId_PrevAndNext(
		Session session, JoiningProcess joiningProcess, long unitId,
		OrderByComparator<JoiningProcess> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_JOININGPROCESS_WHERE);

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
			sb.append(JoiningProcessModelImpl.ORDER_BY_JPQL);
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
						joiningProcess)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<JoiningProcess> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the joining processes where unitId = &#63; from the database.
	 *
	 * @param unitId the unit ID
	 */
	@Override
	public void removeByUnitId(long unitId) {
		for (JoiningProcess joiningProcess :
				findByUnitId(
					unitId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(joiningProcess);
		}
	}

	/**
	 * Returns the number of joining processes where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @return the number of matching joining processes
	 */
	@Override
	public int countByUnitId(long unitId) {
		FinderPath finderPath = _finderPathCountByUnitId;

		Object[] finderArgs = new Object[] {unitId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_JOININGPROCESS_WHERE);

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
		"joiningProcess.unitId = ?";

	private FinderPath _finderPathWithPaginationFindByApproverUserId;
	private FinderPath _finderPathWithoutPaginationFindByApproverUserId;
	private FinderPath _finderPathCountByApproverUserId;

	/**
	 * Returns all the joining processes where approverUserId = &#63;.
	 *
	 * @param approverUserId the approver user ID
	 * @return the matching joining processes
	 */
	@Override
	public List<JoiningProcess> findByApproverUserId(long approverUserId) {
		return findByApproverUserId(
			approverUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the joining processes where approverUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessModelImpl</code>.
	 * </p>
	 *
	 * @param approverUserId the approver user ID
	 * @param start the lower bound of the range of joining processes
	 * @param end the upper bound of the range of joining processes (not inclusive)
	 * @return the range of matching joining processes
	 */
	@Override
	public List<JoiningProcess> findByApproverUserId(
		long approverUserId, int start, int end) {

		return findByApproverUserId(approverUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the joining processes where approverUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessModelImpl</code>.
	 * </p>
	 *
	 * @param approverUserId the approver user ID
	 * @param start the lower bound of the range of joining processes
	 * @param end the upper bound of the range of joining processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching joining processes
	 */
	@Override
	public List<JoiningProcess> findByApproverUserId(
		long approverUserId, int start, int end,
		OrderByComparator<JoiningProcess> orderByComparator) {

		return findByApproverUserId(
			approverUserId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the joining processes where approverUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessModelImpl</code>.
	 * </p>
	 *
	 * @param approverUserId the approver user ID
	 * @param start the lower bound of the range of joining processes
	 * @param end the upper bound of the range of joining processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching joining processes
	 */
	@Override
	public List<JoiningProcess> findByApproverUserId(
		long approverUserId, int start, int end,
		OrderByComparator<JoiningProcess> orderByComparator,
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

		List<JoiningProcess> list = null;

		if (useFinderCache) {
			list = (List<JoiningProcess>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (JoiningProcess joiningProcess : list) {
					if (approverUserId != joiningProcess.getApproverUserId()) {
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

			sb.append(_SQL_SELECT_JOININGPROCESS_WHERE);

			sb.append(_FINDER_COLUMN_APPROVERUSERID_APPROVERUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(JoiningProcessModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(approverUserId);

				list = (List<JoiningProcess>)QueryUtil.list(
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
	 * Returns the first joining process in the ordered set where approverUserId = &#63;.
	 *
	 * @param approverUserId the approver user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching joining process
	 * @throws NoSuchJoiningProcessException if a matching joining process could not be found
	 */
	@Override
	public JoiningProcess findByApproverUserId_First(
			long approverUserId,
			OrderByComparator<JoiningProcess> orderByComparator)
		throws NoSuchJoiningProcessException {

		JoiningProcess joiningProcess = fetchByApproverUserId_First(
			approverUserId, orderByComparator);

		if (joiningProcess != null) {
			return joiningProcess;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("approverUserId=");
		sb.append(approverUserId);

		sb.append("}");

		throw new NoSuchJoiningProcessException(sb.toString());
	}

	/**
	 * Returns the first joining process in the ordered set where approverUserId = &#63;.
	 *
	 * @param approverUserId the approver user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching joining process, or <code>null</code> if a matching joining process could not be found
	 */
	@Override
	public JoiningProcess fetchByApproverUserId_First(
		long approverUserId,
		OrderByComparator<JoiningProcess> orderByComparator) {

		List<JoiningProcess> list = findByApproverUserId(
			approverUserId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last joining process in the ordered set where approverUserId = &#63;.
	 *
	 * @param approverUserId the approver user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching joining process
	 * @throws NoSuchJoiningProcessException if a matching joining process could not be found
	 */
	@Override
	public JoiningProcess findByApproverUserId_Last(
			long approverUserId,
			OrderByComparator<JoiningProcess> orderByComparator)
		throws NoSuchJoiningProcessException {

		JoiningProcess joiningProcess = fetchByApproverUserId_Last(
			approverUserId, orderByComparator);

		if (joiningProcess != null) {
			return joiningProcess;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("approverUserId=");
		sb.append(approverUserId);

		sb.append("}");

		throw new NoSuchJoiningProcessException(sb.toString());
	}

	/**
	 * Returns the last joining process in the ordered set where approverUserId = &#63;.
	 *
	 * @param approverUserId the approver user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching joining process, or <code>null</code> if a matching joining process could not be found
	 */
	@Override
	public JoiningProcess fetchByApproverUserId_Last(
		long approverUserId,
		OrderByComparator<JoiningProcess> orderByComparator) {

		int count = countByApproverUserId(approverUserId);

		if (count == 0) {
			return null;
		}

		List<JoiningProcess> list = findByApproverUserId(
			approverUserId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the joining processes before and after the current joining process in the ordered set where approverUserId = &#63;.
	 *
	 * @param joiningProcessId the primary key of the current joining process
	 * @param approverUserId the approver user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next joining process
	 * @throws NoSuchJoiningProcessException if a joining process with the primary key could not be found
	 */
	@Override
	public JoiningProcess[] findByApproverUserId_PrevAndNext(
			long joiningProcessId, long approverUserId,
			OrderByComparator<JoiningProcess> orderByComparator)
		throws NoSuchJoiningProcessException {

		JoiningProcess joiningProcess = findByPrimaryKey(joiningProcessId);

		Session session = null;

		try {
			session = openSession();

			JoiningProcess[] array = new JoiningProcessImpl[3];

			array[0] = getByApproverUserId_PrevAndNext(
				session, joiningProcess, approverUserId, orderByComparator,
				true);

			array[1] = joiningProcess;

			array[2] = getByApproverUserId_PrevAndNext(
				session, joiningProcess, approverUserId, orderByComparator,
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

	protected JoiningProcess getByApproverUserId_PrevAndNext(
		Session session, JoiningProcess joiningProcess, long approverUserId,
		OrderByComparator<JoiningProcess> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_JOININGPROCESS_WHERE);

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
			sb.append(JoiningProcessModelImpl.ORDER_BY_JPQL);
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
						joiningProcess)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<JoiningProcess> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the joining processes where approverUserId = &#63; from the database.
	 *
	 * @param approverUserId the approver user ID
	 */
	@Override
	public void removeByApproverUserId(long approverUserId) {
		for (JoiningProcess joiningProcess :
				findByApproverUserId(
					approverUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(joiningProcess);
		}
	}

	/**
	 * Returns the number of joining processes where approverUserId = &#63;.
	 *
	 * @param approverUserId the approver user ID
	 * @return the number of matching joining processes
	 */
	@Override
	public int countByApproverUserId(long approverUserId) {
		FinderPath finderPath = _finderPathCountByApproverUserId;

		Object[] finderArgs = new Object[] {approverUserId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_JOININGPROCESS_WHERE);

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
		"joiningProcess.approverUserId = ?";

	public JoiningProcessPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(JoiningProcess.class);

		setModelImplClass(JoiningProcessImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the joining process in the entity cache if it is enabled.
	 *
	 * @param joiningProcess the joining process
	 */
	@Override
	public void cacheResult(JoiningProcess joiningProcess) {
		entityCache.putResult(
			JoiningProcessImpl.class, joiningProcess.getPrimaryKey(),
			joiningProcess);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				joiningProcess.getUuid(), joiningProcess.getGroupId()
			},
			joiningProcess);
	}

	/**
	 * Caches the joining processes in the entity cache if it is enabled.
	 *
	 * @param joiningProcesses the joining processes
	 */
	@Override
	public void cacheResult(List<JoiningProcess> joiningProcesses) {
		for (JoiningProcess joiningProcess : joiningProcesses) {
			if (entityCache.getResult(
					JoiningProcessImpl.class, joiningProcess.getPrimaryKey()) ==
						null) {

				cacheResult(joiningProcess);
			}
		}
	}

	/**
	 * Clears the cache for all joining processes.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(JoiningProcessImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the joining process.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(JoiningProcess joiningProcess) {
		entityCache.removeResult(JoiningProcessImpl.class, joiningProcess);
	}

	@Override
	public void clearCache(List<JoiningProcess> joiningProcesses) {
		for (JoiningProcess joiningProcess : joiningProcesses) {
			entityCache.removeResult(JoiningProcessImpl.class, joiningProcess);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(JoiningProcessImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		JoiningProcessModelImpl joiningProcessModelImpl) {

		Object[] args = new Object[] {
			joiningProcessModelImpl.getUuid(),
			joiningProcessModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, joiningProcessModelImpl, false);
	}

	/**
	 * Creates a new joining process with the primary key. Does not add the joining process to the database.
	 *
	 * @param joiningProcessId the primary key for the new joining process
	 * @return the new joining process
	 */
	@Override
	public JoiningProcess create(long joiningProcessId) {
		JoiningProcess joiningProcess = new JoiningProcessImpl();

		joiningProcess.setNew(true);
		joiningProcess.setPrimaryKey(joiningProcessId);

		String uuid = PortalUUIDUtil.generate();

		joiningProcess.setUuid(uuid);

		joiningProcess.setCompanyId(CompanyThreadLocal.getCompanyId());

		return joiningProcess;
	}

	/**
	 * Removes the joining process with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param joiningProcessId the primary key of the joining process
	 * @return the joining process that was removed
	 * @throws NoSuchJoiningProcessException if a joining process with the primary key could not be found
	 */
	@Override
	public JoiningProcess remove(long joiningProcessId)
		throws NoSuchJoiningProcessException {

		return remove((Serializable)joiningProcessId);
	}

	/**
	 * Removes the joining process with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the joining process
	 * @return the joining process that was removed
	 * @throws NoSuchJoiningProcessException if a joining process with the primary key could not be found
	 */
	@Override
	public JoiningProcess remove(Serializable primaryKey)
		throws NoSuchJoiningProcessException {

		Session session = null;

		try {
			session = openSession();

			JoiningProcess joiningProcess = (JoiningProcess)session.get(
				JoiningProcessImpl.class, primaryKey);

			if (joiningProcess == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchJoiningProcessException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(joiningProcess);
		}
		catch (NoSuchJoiningProcessException noSuchEntityException) {
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
	protected JoiningProcess removeImpl(JoiningProcess joiningProcess) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(joiningProcess)) {
				joiningProcess = (JoiningProcess)session.get(
					JoiningProcessImpl.class,
					joiningProcess.getPrimaryKeyObj());
			}

			if (joiningProcess != null) {
				session.delete(joiningProcess);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (joiningProcess != null) {
			clearCache(joiningProcess);
		}

		return joiningProcess;
	}

	@Override
	public JoiningProcess updateImpl(JoiningProcess joiningProcess) {
		boolean isNew = joiningProcess.isNew();

		if (!(joiningProcess instanceof JoiningProcessModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(joiningProcess.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					joiningProcess);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in joiningProcess proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom JoiningProcess implementation " +
					joiningProcess.getClass());
		}

		JoiningProcessModelImpl joiningProcessModelImpl =
			(JoiningProcessModelImpl)joiningProcess;

		if (Validator.isNull(joiningProcess.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			joiningProcess.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (joiningProcess.getCreateDate() == null)) {
			if (serviceContext == null) {
				joiningProcess.setCreateDate(now);
			}
			else {
				joiningProcess.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!joiningProcessModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				joiningProcess.setModifiedDate(now);
			}
			else {
				joiningProcess.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(joiningProcess);
			}
			else {
				joiningProcess = (JoiningProcess)session.merge(joiningProcess);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			JoiningProcessImpl.class, joiningProcessModelImpl, false, true);

		cacheUniqueFindersCache(joiningProcessModelImpl);

		if (isNew) {
			joiningProcess.setNew(false);
		}

		joiningProcess.resetOriginalValues();

		return joiningProcess;
	}

	/**
	 * Returns the joining process with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the joining process
	 * @return the joining process
	 * @throws NoSuchJoiningProcessException if a joining process with the primary key could not be found
	 */
	@Override
	public JoiningProcess findByPrimaryKey(Serializable primaryKey)
		throws NoSuchJoiningProcessException {

		JoiningProcess joiningProcess = fetchByPrimaryKey(primaryKey);

		if (joiningProcess == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchJoiningProcessException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return joiningProcess;
	}

	/**
	 * Returns the joining process with the primary key or throws a <code>NoSuchJoiningProcessException</code> if it could not be found.
	 *
	 * @param joiningProcessId the primary key of the joining process
	 * @return the joining process
	 * @throws NoSuchJoiningProcessException if a joining process with the primary key could not be found
	 */
	@Override
	public JoiningProcess findByPrimaryKey(long joiningProcessId)
		throws NoSuchJoiningProcessException {

		return findByPrimaryKey((Serializable)joiningProcessId);
	}

	/**
	 * Returns the joining process with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param joiningProcessId the primary key of the joining process
	 * @return the joining process, or <code>null</code> if a joining process with the primary key could not be found
	 */
	@Override
	public JoiningProcess fetchByPrimaryKey(long joiningProcessId) {
		return fetchByPrimaryKey((Serializable)joiningProcessId);
	}

	/**
	 * Returns all the joining processes.
	 *
	 * @return the joining processes
	 */
	@Override
	public List<JoiningProcess> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the joining processes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of joining processes
	 * @param end the upper bound of the range of joining processes (not inclusive)
	 * @return the range of joining processes
	 */
	@Override
	public List<JoiningProcess> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the joining processes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of joining processes
	 * @param end the upper bound of the range of joining processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of joining processes
	 */
	@Override
	public List<JoiningProcess> findAll(
		int start, int end,
		OrderByComparator<JoiningProcess> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the joining processes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of joining processes
	 * @param end the upper bound of the range of joining processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of joining processes
	 */
	@Override
	public List<JoiningProcess> findAll(
		int start, int end, OrderByComparator<JoiningProcess> orderByComparator,
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

		List<JoiningProcess> list = null;

		if (useFinderCache) {
			list = (List<JoiningProcess>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_JOININGPROCESS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_JOININGPROCESS;

				sql = sql.concat(JoiningProcessModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<JoiningProcess>)QueryUtil.list(
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
	 * Removes all the joining processes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (JoiningProcess joiningProcess : findAll()) {
			remove(joiningProcess);
		}
	}

	/**
	 * Returns the number of joining processes.
	 *
	 * @return the number of joining processes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_JOININGPROCESS);

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
		return "joiningProcessId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_JOININGPROCESS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return JoiningProcessModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the joining process persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new JoiningProcessModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", JoiningProcess.class.getName()));

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
		entityCache.removeCache(JoiningProcessImpl.class.getName());

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

	private static final String _SQL_SELECT_JOININGPROCESS =
		"SELECT joiningProcess FROM JoiningProcess joiningProcess";

	private static final String _SQL_SELECT_JOININGPROCESS_WHERE =
		"SELECT joiningProcess FROM JoiningProcess joiningProcess WHERE ";

	private static final String _SQL_COUNT_JOININGPROCESS =
		"SELECT COUNT(joiningProcess) FROM JoiningProcess joiningProcess";

	private static final String _SQL_COUNT_JOININGPROCESS_WHERE =
		"SELECT COUNT(joiningProcess) FROM JoiningProcess joiningProcess WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "joiningProcess.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No JoiningProcess exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No JoiningProcess exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		JoiningProcessPersistenceImpl.class);

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

	private static class JoiningProcessModelArgumentsResolver
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

			JoiningProcessModelImpl joiningProcessModelImpl =
				(JoiningProcessModelImpl)baseModel;

			long columnBitmask = joiningProcessModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					joiningProcessModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						joiningProcessModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					joiningProcessModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			JoiningProcessModelImpl joiningProcessModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						joiningProcessModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = joiningProcessModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}