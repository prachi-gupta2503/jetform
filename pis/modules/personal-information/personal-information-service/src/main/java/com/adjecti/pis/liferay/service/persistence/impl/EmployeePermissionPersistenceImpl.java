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

import com.adjecti.pis.liferay.exception.NoSuchEmployeePermissionException;
import com.adjecti.pis.liferay.model.EmployeePermission;
import com.adjecti.pis.liferay.model.impl.EmployeePermissionImpl;
import com.adjecti.pis.liferay.model.impl.EmployeePermissionModelImpl;
import com.adjecti.pis.liferay.service.persistence.EmployeePermissionPersistence;
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
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
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
 * The persistence implementation for the employee permission service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EmployeePermissionPersistence.class)
public class EmployeePermissionPersistenceImpl
	extends BasePersistenceImpl<EmployeePermission>
	implements EmployeePermissionPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EmployeePermissionUtil</code> to access the employee permission persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EmployeePermissionImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByEmployeeId;
	private FinderPath _finderPathCountByEmployeeId;

	/**
	 * Returns the employee permission where employeeId = &#63; or throws a <code>NoSuchEmployeePermissionException</code> if it could not be found.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee permission
	 * @throws NoSuchEmployeePermissionException if a matching employee permission could not be found
	 */
	@Override
	public EmployeePermission findByEmployeeId(long employeeId)
		throws NoSuchEmployeePermissionException {

		EmployeePermission employeePermission = fetchByEmployeeId(employeeId);

		if (employeePermission == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("employeeId=");
			sb.append(employeeId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchEmployeePermissionException(sb.toString());
		}

		return employeePermission;
	}

	/**
	 * Returns the employee permission where employeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee permission, or <code>null</code> if a matching employee permission could not be found
	 */
	@Override
	public EmployeePermission fetchByEmployeeId(long employeeId) {
		return fetchByEmployeeId(employeeId, true);
	}

	/**
	 * Returns the employee permission where employeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee permission, or <code>null</code> if a matching employee permission could not be found
	 */
	@Override
	public EmployeePermission fetchByEmployeeId(
		long employeeId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {employeeId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByEmployeeId, finderArgs, this);
		}

		if (result instanceof EmployeePermission) {
			EmployeePermission employeePermission = (EmployeePermission)result;

			if (employeeId != employeePermission.getEmployeeId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_EMPLOYEEPERMISSION_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				List<EmployeePermission> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByEmployeeId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {employeeId};
							}

							_log.warn(
								"EmployeePermissionPersistenceImpl.fetchByEmployeeId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					EmployeePermission employeePermission = list.get(0);

					result = employeePermission;

					cacheResult(employeePermission);
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
			return (EmployeePermission)result;
		}
	}

	/**
	 * Removes the employee permission where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @return the employee permission that was removed
	 */
	@Override
	public EmployeePermission removeByEmployeeId(long employeeId)
		throws NoSuchEmployeePermissionException {

		EmployeePermission employeePermission = findByEmployeeId(employeeId);

		return remove(employeePermission);
	}

	/**
	 * Returns the number of employee permissions where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee permissions
	 */
	@Override
	public int countByEmployeeId(long employeeId) {
		FinderPath finderPath = _finderPathCountByEmployeeId;

		Object[] finderArgs = new Object[] {employeeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEPERMISSION_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

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

	private static final String _FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2 =
		"employeePermission.employeeId = ?";

	private FinderPath _finderPathWithPaginationFindByJoiningProcessId;
	private FinderPath _finderPathWithoutPaginationFindByJoiningProcessId;
	private FinderPath _finderPathCountByJoiningProcessId;

	/**
	 * Returns all the employee permissions where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @return the matching employee permissions
	 */
	@Override
	public List<EmployeePermission> findByJoiningProcessId(
		long joiningProcessId) {

		return findByJoiningProcessId(
			joiningProcessId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee permissions where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePermissionModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of employee permissions
	 * @param end the upper bound of the range of employee permissions (not inclusive)
	 * @return the range of matching employee permissions
	 */
	@Override
	public List<EmployeePermission> findByJoiningProcessId(
		long joiningProcessId, int start, int end) {

		return findByJoiningProcessId(joiningProcessId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee permissions where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePermissionModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of employee permissions
	 * @param end the upper bound of the range of employee permissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee permissions
	 */
	@Override
	public List<EmployeePermission> findByJoiningProcessId(
		long joiningProcessId, int start, int end,
		OrderByComparator<EmployeePermission> orderByComparator) {

		return findByJoiningProcessId(
			joiningProcessId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee permissions where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePermissionModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of employee permissions
	 * @param end the upper bound of the range of employee permissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee permissions
	 */
	@Override
	public List<EmployeePermission> findByJoiningProcessId(
		long joiningProcessId, int start, int end,
		OrderByComparator<EmployeePermission> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByJoiningProcessId;
				finderArgs = new Object[] {joiningProcessId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByJoiningProcessId;
			finderArgs = new Object[] {
				joiningProcessId, start, end, orderByComparator
			};
		}

		List<EmployeePermission> list = null;

		if (useFinderCache) {
			list = (List<EmployeePermission>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeePermission employeePermission : list) {
					if (joiningProcessId !=
							employeePermission.getJoiningProcessId()) {

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

			sb.append(_SQL_SELECT_EMPLOYEEPERMISSION_WHERE);

			sb.append(_FINDER_COLUMN_JOININGPROCESSID_JOININGPROCESSID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeePermissionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(joiningProcessId);

				list = (List<EmployeePermission>)QueryUtil.list(
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
	 * Returns the first employee permission in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee permission
	 * @throws NoSuchEmployeePermissionException if a matching employee permission could not be found
	 */
	@Override
	public EmployeePermission findByJoiningProcessId_First(
			long joiningProcessId,
			OrderByComparator<EmployeePermission> orderByComparator)
		throws NoSuchEmployeePermissionException {

		EmployeePermission employeePermission = fetchByJoiningProcessId_First(
			joiningProcessId, orderByComparator);

		if (employeePermission != null) {
			return employeePermission;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("joiningProcessId=");
		sb.append(joiningProcessId);

		sb.append("}");

		throw new NoSuchEmployeePermissionException(sb.toString());
	}

	/**
	 * Returns the first employee permission in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee permission, or <code>null</code> if a matching employee permission could not be found
	 */
	@Override
	public EmployeePermission fetchByJoiningProcessId_First(
		long joiningProcessId,
		OrderByComparator<EmployeePermission> orderByComparator) {

		List<EmployeePermission> list = findByJoiningProcessId(
			joiningProcessId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee permission in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee permission
	 * @throws NoSuchEmployeePermissionException if a matching employee permission could not be found
	 */
	@Override
	public EmployeePermission findByJoiningProcessId_Last(
			long joiningProcessId,
			OrderByComparator<EmployeePermission> orderByComparator)
		throws NoSuchEmployeePermissionException {

		EmployeePermission employeePermission = fetchByJoiningProcessId_Last(
			joiningProcessId, orderByComparator);

		if (employeePermission != null) {
			return employeePermission;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("joiningProcessId=");
		sb.append(joiningProcessId);

		sb.append("}");

		throw new NoSuchEmployeePermissionException(sb.toString());
	}

	/**
	 * Returns the last employee permission in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee permission, or <code>null</code> if a matching employee permission could not be found
	 */
	@Override
	public EmployeePermission fetchByJoiningProcessId_Last(
		long joiningProcessId,
		OrderByComparator<EmployeePermission> orderByComparator) {

		int count = countByJoiningProcessId(joiningProcessId);

		if (count == 0) {
			return null;
		}

		List<EmployeePermission> list = findByJoiningProcessId(
			joiningProcessId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee permissions before and after the current employee permission in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param employeePermissionId the primary key of the current employee permission
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee permission
	 * @throws NoSuchEmployeePermissionException if a employee permission with the primary key could not be found
	 */
	@Override
	public EmployeePermission[] findByJoiningProcessId_PrevAndNext(
			long employeePermissionId, long joiningProcessId,
			OrderByComparator<EmployeePermission> orderByComparator)
		throws NoSuchEmployeePermissionException {

		EmployeePermission employeePermission = findByPrimaryKey(
			employeePermissionId);

		Session session = null;

		try {
			session = openSession();

			EmployeePermission[] array = new EmployeePermissionImpl[3];

			array[0] = getByJoiningProcessId_PrevAndNext(
				session, employeePermission, joiningProcessId,
				orderByComparator, true);

			array[1] = employeePermission;

			array[2] = getByJoiningProcessId_PrevAndNext(
				session, employeePermission, joiningProcessId,
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

	protected EmployeePermission getByJoiningProcessId_PrevAndNext(
		Session session, EmployeePermission employeePermission,
		long joiningProcessId,
		OrderByComparator<EmployeePermission> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEPERMISSION_WHERE);

		sb.append(_FINDER_COLUMN_JOININGPROCESSID_JOININGPROCESSID_2);

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
			sb.append(EmployeePermissionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(joiningProcessId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						employeePermission)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeePermission> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee permissions where joiningProcessId = &#63; from the database.
	 *
	 * @param joiningProcessId the joining process ID
	 */
	@Override
	public void removeByJoiningProcessId(long joiningProcessId) {
		for (EmployeePermission employeePermission :
				findByJoiningProcessId(
					joiningProcessId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(employeePermission);
		}
	}

	/**
	 * Returns the number of employee permissions where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @return the number of matching employee permissions
	 */
	@Override
	public int countByJoiningProcessId(long joiningProcessId) {
		FinderPath finderPath = _finderPathCountByJoiningProcessId;

		Object[] finderArgs = new Object[] {joiningProcessId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEPERMISSION_WHERE);

			sb.append(_FINDER_COLUMN_JOININGPROCESSID_JOININGPROCESSID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(joiningProcessId);

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
		_FINDER_COLUMN_JOININGPROCESSID_JOININGPROCESSID_2 =
			"employeePermission.joiningProcessId = ?";

	private FinderPath _finderPathFetchBySingleUserOnboardingId;
	private FinderPath _finderPathCountBySingleUserOnboardingId;

	/**
	 * Returns the employee permission where singleUserOnboardingId = &#63; or throws a <code>NoSuchEmployeePermissionException</code> if it could not be found.
	 *
	 * @param singleUserOnboardingId the single user onboarding ID
	 * @return the matching employee permission
	 * @throws NoSuchEmployeePermissionException if a matching employee permission could not be found
	 */
	@Override
	public EmployeePermission findBySingleUserOnboardingId(
			long singleUserOnboardingId)
		throws NoSuchEmployeePermissionException {

		EmployeePermission employeePermission = fetchBySingleUserOnboardingId(
			singleUserOnboardingId);

		if (employeePermission == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("singleUserOnboardingId=");
			sb.append(singleUserOnboardingId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchEmployeePermissionException(sb.toString());
		}

		return employeePermission;
	}

	/**
	 * Returns the employee permission where singleUserOnboardingId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param singleUserOnboardingId the single user onboarding ID
	 * @return the matching employee permission, or <code>null</code> if a matching employee permission could not be found
	 */
	@Override
	public EmployeePermission fetchBySingleUserOnboardingId(
		long singleUserOnboardingId) {

		return fetchBySingleUserOnboardingId(singleUserOnboardingId, true);
	}

	/**
	 * Returns the employee permission where singleUserOnboardingId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param singleUserOnboardingId the single user onboarding ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee permission, or <code>null</code> if a matching employee permission could not be found
	 */
	@Override
	public EmployeePermission fetchBySingleUserOnboardingId(
		long singleUserOnboardingId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {singleUserOnboardingId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBySingleUserOnboardingId, finderArgs, this);
		}

		if (result instanceof EmployeePermission) {
			EmployeePermission employeePermission = (EmployeePermission)result;

			if (singleUserOnboardingId !=
					employeePermission.getSingleUserOnboardingId()) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_EMPLOYEEPERMISSION_WHERE);

			sb.append(
				_FINDER_COLUMN_SINGLEUSERONBOARDINGID_SINGLEUSERONBOARDINGID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(singleUserOnboardingId);

				List<EmployeePermission> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBySingleUserOnboardingId,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									singleUserOnboardingId
								};
							}

							_log.warn(
								"EmployeePermissionPersistenceImpl.fetchBySingleUserOnboardingId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					EmployeePermission employeePermission = list.get(0);

					result = employeePermission;

					cacheResult(employeePermission);
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
			return (EmployeePermission)result;
		}
	}

	/**
	 * Removes the employee permission where singleUserOnboardingId = &#63; from the database.
	 *
	 * @param singleUserOnboardingId the single user onboarding ID
	 * @return the employee permission that was removed
	 */
	@Override
	public EmployeePermission removeBySingleUserOnboardingId(
			long singleUserOnboardingId)
		throws NoSuchEmployeePermissionException {

		EmployeePermission employeePermission = findBySingleUserOnboardingId(
			singleUserOnboardingId);

		return remove(employeePermission);
	}

	/**
	 * Returns the number of employee permissions where singleUserOnboardingId = &#63;.
	 *
	 * @param singleUserOnboardingId the single user onboarding ID
	 * @return the number of matching employee permissions
	 */
	@Override
	public int countBySingleUserOnboardingId(long singleUserOnboardingId) {
		FinderPath finderPath = _finderPathCountBySingleUserOnboardingId;

		Object[] finderArgs = new Object[] {singleUserOnboardingId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEPERMISSION_WHERE);

			sb.append(
				_FINDER_COLUMN_SINGLEUSERONBOARDINGID_SINGLEUSERONBOARDINGID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(singleUserOnboardingId);

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
		_FINDER_COLUMN_SINGLEUSERONBOARDINGID_SINGLEUSERONBOARDINGID_2 =
			"employeePermission.singleUserOnboardingId = ?";

	private FinderPath _finderPathFetchByRegistrationRequestId;
	private FinderPath _finderPathCountByRegistrationRequestId;

	/**
	 * Returns the employee permission where registrationRequestId = &#63; or throws a <code>NoSuchEmployeePermissionException</code> if it could not be found.
	 *
	 * @param registrationRequestId the registration request ID
	 * @return the matching employee permission
	 * @throws NoSuchEmployeePermissionException if a matching employee permission could not be found
	 */
	@Override
	public EmployeePermission findByRegistrationRequestId(
			long registrationRequestId)
		throws NoSuchEmployeePermissionException {

		EmployeePermission employeePermission = fetchByRegistrationRequestId(
			registrationRequestId);

		if (employeePermission == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("registrationRequestId=");
			sb.append(registrationRequestId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchEmployeePermissionException(sb.toString());
		}

		return employeePermission;
	}

	/**
	 * Returns the employee permission where registrationRequestId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param registrationRequestId the registration request ID
	 * @return the matching employee permission, or <code>null</code> if a matching employee permission could not be found
	 */
	@Override
	public EmployeePermission fetchByRegistrationRequestId(
		long registrationRequestId) {

		return fetchByRegistrationRequestId(registrationRequestId, true);
	}

	/**
	 * Returns the employee permission where registrationRequestId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param registrationRequestId the registration request ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee permission, or <code>null</code> if a matching employee permission could not be found
	 */
	@Override
	public EmployeePermission fetchByRegistrationRequestId(
		long registrationRequestId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {registrationRequestId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByRegistrationRequestId, finderArgs, this);
		}

		if (result instanceof EmployeePermission) {
			EmployeePermission employeePermission = (EmployeePermission)result;

			if (registrationRequestId !=
					employeePermission.getRegistrationRequestId()) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_EMPLOYEEPERMISSION_WHERE);

			sb.append(
				_FINDER_COLUMN_REGISTRATIONREQUESTID_REGISTRATIONREQUESTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(registrationRequestId);

				List<EmployeePermission> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByRegistrationRequestId, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									registrationRequestId
								};
							}

							_log.warn(
								"EmployeePermissionPersistenceImpl.fetchByRegistrationRequestId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					EmployeePermission employeePermission = list.get(0);

					result = employeePermission;

					cacheResult(employeePermission);
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
			return (EmployeePermission)result;
		}
	}

	/**
	 * Removes the employee permission where registrationRequestId = &#63; from the database.
	 *
	 * @param registrationRequestId the registration request ID
	 * @return the employee permission that was removed
	 */
	@Override
	public EmployeePermission removeByRegistrationRequestId(
			long registrationRequestId)
		throws NoSuchEmployeePermissionException {

		EmployeePermission employeePermission = findByRegistrationRequestId(
			registrationRequestId);

		return remove(employeePermission);
	}

	/**
	 * Returns the number of employee permissions where registrationRequestId = &#63;.
	 *
	 * @param registrationRequestId the registration request ID
	 * @return the number of matching employee permissions
	 */
	@Override
	public int countByRegistrationRequestId(long registrationRequestId) {
		FinderPath finderPath = _finderPathCountByRegistrationRequestId;

		Object[] finderArgs = new Object[] {registrationRequestId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEPERMISSION_WHERE);

			sb.append(
				_FINDER_COLUMN_REGISTRATIONREQUESTID_REGISTRATIONREQUESTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(registrationRequestId);

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
		_FINDER_COLUMN_REGISTRATIONREQUESTID_REGISTRATIONREQUESTID_2 =
			"employeePermission.registrationRequestId = ?";

	private FinderPath _finderPathWithPaginationFindByFormClassName;
	private FinderPath _finderPathWithoutPaginationFindByFormClassName;
	private FinderPath _finderPathCountByFormClassName;

	/**
	 * Returns all the employee permissions where form = &#63;.
	 *
	 * @param form the form
	 * @return the matching employee permissions
	 */
	@Override
	public List<EmployeePermission> findByFormClassName(String form) {
		return findByFormClassName(
			form, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee permissions where form = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePermissionModelImpl</code>.
	 * </p>
	 *
	 * @param form the form
	 * @param start the lower bound of the range of employee permissions
	 * @param end the upper bound of the range of employee permissions (not inclusive)
	 * @return the range of matching employee permissions
	 */
	@Override
	public List<EmployeePermission> findByFormClassName(
		String form, int start, int end) {

		return findByFormClassName(form, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee permissions where form = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePermissionModelImpl</code>.
	 * </p>
	 *
	 * @param form the form
	 * @param start the lower bound of the range of employee permissions
	 * @param end the upper bound of the range of employee permissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee permissions
	 */
	@Override
	public List<EmployeePermission> findByFormClassName(
		String form, int start, int end,
		OrderByComparator<EmployeePermission> orderByComparator) {

		return findByFormClassName(form, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee permissions where form = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePermissionModelImpl</code>.
	 * </p>
	 *
	 * @param form the form
	 * @param start the lower bound of the range of employee permissions
	 * @param end the upper bound of the range of employee permissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee permissions
	 */
	@Override
	public List<EmployeePermission> findByFormClassName(
		String form, int start, int end,
		OrderByComparator<EmployeePermission> orderByComparator,
		boolean useFinderCache) {

		form = Objects.toString(form, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByFormClassName;
				finderArgs = new Object[] {form};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByFormClassName;
			finderArgs = new Object[] {form, start, end, orderByComparator};
		}

		List<EmployeePermission> list = null;

		if (useFinderCache) {
			list = (List<EmployeePermission>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeePermission employeePermission : list) {
					if (!form.equals(employeePermission.getForm())) {
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

			sb.append(_SQL_SELECT_EMPLOYEEPERMISSION_WHERE);

			boolean bindForm = false;

			if (form.isEmpty()) {
				sb.append(_FINDER_COLUMN_FORMCLASSNAME_FORM_3);
			}
			else {
				bindForm = true;

				sb.append(_FINDER_COLUMN_FORMCLASSNAME_FORM_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeePermissionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindForm) {
					queryPos.add(form);
				}

				list = (List<EmployeePermission>)QueryUtil.list(
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
	 * Returns the first employee permission in the ordered set where form = &#63;.
	 *
	 * @param form the form
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee permission
	 * @throws NoSuchEmployeePermissionException if a matching employee permission could not be found
	 */
	@Override
	public EmployeePermission findByFormClassName_First(
			String form,
			OrderByComparator<EmployeePermission> orderByComparator)
		throws NoSuchEmployeePermissionException {

		EmployeePermission employeePermission = fetchByFormClassName_First(
			form, orderByComparator);

		if (employeePermission != null) {
			return employeePermission;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("form=");
		sb.append(form);

		sb.append("}");

		throw new NoSuchEmployeePermissionException(sb.toString());
	}

	/**
	 * Returns the first employee permission in the ordered set where form = &#63;.
	 *
	 * @param form the form
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee permission, or <code>null</code> if a matching employee permission could not be found
	 */
	@Override
	public EmployeePermission fetchByFormClassName_First(
		String form, OrderByComparator<EmployeePermission> orderByComparator) {

		List<EmployeePermission> list = findByFormClassName(
			form, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee permission in the ordered set where form = &#63;.
	 *
	 * @param form the form
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee permission
	 * @throws NoSuchEmployeePermissionException if a matching employee permission could not be found
	 */
	@Override
	public EmployeePermission findByFormClassName_Last(
			String form,
			OrderByComparator<EmployeePermission> orderByComparator)
		throws NoSuchEmployeePermissionException {

		EmployeePermission employeePermission = fetchByFormClassName_Last(
			form, orderByComparator);

		if (employeePermission != null) {
			return employeePermission;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("form=");
		sb.append(form);

		sb.append("}");

		throw new NoSuchEmployeePermissionException(sb.toString());
	}

	/**
	 * Returns the last employee permission in the ordered set where form = &#63;.
	 *
	 * @param form the form
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee permission, or <code>null</code> if a matching employee permission could not be found
	 */
	@Override
	public EmployeePermission fetchByFormClassName_Last(
		String form, OrderByComparator<EmployeePermission> orderByComparator) {

		int count = countByFormClassName(form);

		if (count == 0) {
			return null;
		}

		List<EmployeePermission> list = findByFormClassName(
			form, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee permissions before and after the current employee permission in the ordered set where form = &#63;.
	 *
	 * @param employeePermissionId the primary key of the current employee permission
	 * @param form the form
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee permission
	 * @throws NoSuchEmployeePermissionException if a employee permission with the primary key could not be found
	 */
	@Override
	public EmployeePermission[] findByFormClassName_PrevAndNext(
			long employeePermissionId, String form,
			OrderByComparator<EmployeePermission> orderByComparator)
		throws NoSuchEmployeePermissionException {

		form = Objects.toString(form, "");

		EmployeePermission employeePermission = findByPrimaryKey(
			employeePermissionId);

		Session session = null;

		try {
			session = openSession();

			EmployeePermission[] array = new EmployeePermissionImpl[3];

			array[0] = getByFormClassName_PrevAndNext(
				session, employeePermission, form, orderByComparator, true);

			array[1] = employeePermission;

			array[2] = getByFormClassName_PrevAndNext(
				session, employeePermission, form, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EmployeePermission getByFormClassName_PrevAndNext(
		Session session, EmployeePermission employeePermission, String form,
		OrderByComparator<EmployeePermission> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEPERMISSION_WHERE);

		boolean bindForm = false;

		if (form.isEmpty()) {
			sb.append(_FINDER_COLUMN_FORMCLASSNAME_FORM_3);
		}
		else {
			bindForm = true;

			sb.append(_FINDER_COLUMN_FORMCLASSNAME_FORM_2);
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
			sb.append(EmployeePermissionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindForm) {
			queryPos.add(form);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						employeePermission)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeePermission> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee permissions where form = &#63; from the database.
	 *
	 * @param form the form
	 */
	@Override
	public void removeByFormClassName(String form) {
		for (EmployeePermission employeePermission :
				findByFormClassName(
					form, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeePermission);
		}
	}

	/**
	 * Returns the number of employee permissions where form = &#63;.
	 *
	 * @param form the form
	 * @return the number of matching employee permissions
	 */
	@Override
	public int countByFormClassName(String form) {
		form = Objects.toString(form, "");

		FinderPath finderPath = _finderPathCountByFormClassName;

		Object[] finderArgs = new Object[] {form};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEPERMISSION_WHERE);

			boolean bindForm = false;

			if (form.isEmpty()) {
				sb.append(_FINDER_COLUMN_FORMCLASSNAME_FORM_3);
			}
			else {
				bindForm = true;

				sb.append(_FINDER_COLUMN_FORMCLASSNAME_FORM_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindForm) {
					queryPos.add(form);
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

	private static final String _FINDER_COLUMN_FORMCLASSNAME_FORM_2 =
		"employeePermission.form = ?";

	private static final String _FINDER_COLUMN_FORMCLASSNAME_FORM_3 =
		"(employeePermission.form IS NULL OR employeePermission.form = '')";

	public EmployeePermissionPersistenceImpl() {
		setModelClass(EmployeePermission.class);

		setModelImplClass(EmployeePermissionImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the employee permission in the entity cache if it is enabled.
	 *
	 * @param employeePermission the employee permission
	 */
	@Override
	public void cacheResult(EmployeePermission employeePermission) {
		entityCache.putResult(
			EmployeePermissionImpl.class, employeePermission.getPrimaryKey(),
			employeePermission);

		finderCache.putResult(
			_finderPathFetchByEmployeeId,
			new Object[] {employeePermission.getEmployeeId()},
			employeePermission);

		finderCache.putResult(
			_finderPathFetchBySingleUserOnboardingId,
			new Object[] {employeePermission.getSingleUserOnboardingId()},
			employeePermission);

		finderCache.putResult(
			_finderPathFetchByRegistrationRequestId,
			new Object[] {employeePermission.getRegistrationRequestId()},
			employeePermission);
	}

	/**
	 * Caches the employee permissions in the entity cache if it is enabled.
	 *
	 * @param employeePermissions the employee permissions
	 */
	@Override
	public void cacheResult(List<EmployeePermission> employeePermissions) {
		for (EmployeePermission employeePermission : employeePermissions) {
			if (entityCache.getResult(
					EmployeePermissionImpl.class,
					employeePermission.getPrimaryKey()) == null) {

				cacheResult(employeePermission);
			}
		}
	}

	/**
	 * Clears the cache for all employee permissions.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmployeePermissionImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the employee permission.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmployeePermission employeePermission) {
		entityCache.removeResult(
			EmployeePermissionImpl.class, employeePermission);
	}

	@Override
	public void clearCache(List<EmployeePermission> employeePermissions) {
		for (EmployeePermission employeePermission : employeePermissions) {
			entityCache.removeResult(
				EmployeePermissionImpl.class, employeePermission);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EmployeePermissionImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		EmployeePermissionModelImpl employeePermissionModelImpl) {

		Object[] args = new Object[] {
			employeePermissionModelImpl.getEmployeeId()
		};

		finderCache.putResult(
			_finderPathCountByEmployeeId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByEmployeeId, args, employeePermissionModelImpl,
			false);

		args = new Object[] {
			employeePermissionModelImpl.getSingleUserOnboardingId()
		};

		finderCache.putResult(
			_finderPathCountBySingleUserOnboardingId, args, Long.valueOf(1),
			false);
		finderCache.putResult(
			_finderPathFetchBySingleUserOnboardingId, args,
			employeePermissionModelImpl, false);

		args = new Object[] {
			employeePermissionModelImpl.getRegistrationRequestId()
		};

		finderCache.putResult(
			_finderPathCountByRegistrationRequestId, args, Long.valueOf(1),
			false);
		finderCache.putResult(
			_finderPathFetchByRegistrationRequestId, args,
			employeePermissionModelImpl, false);
	}

	/**
	 * Creates a new employee permission with the primary key. Does not add the employee permission to the database.
	 *
	 * @param employeePermissionId the primary key for the new employee permission
	 * @return the new employee permission
	 */
	@Override
	public EmployeePermission create(long employeePermissionId) {
		EmployeePermission employeePermission = new EmployeePermissionImpl();

		employeePermission.setNew(true);
		employeePermission.setPrimaryKey(employeePermissionId);

		employeePermission.setCompanyId(CompanyThreadLocal.getCompanyId());

		return employeePermission;
	}

	/**
	 * Removes the employee permission with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeePermissionId the primary key of the employee permission
	 * @return the employee permission that was removed
	 * @throws NoSuchEmployeePermissionException if a employee permission with the primary key could not be found
	 */
	@Override
	public EmployeePermission remove(long employeePermissionId)
		throws NoSuchEmployeePermissionException {

		return remove((Serializable)employeePermissionId);
	}

	/**
	 * Removes the employee permission with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the employee permission
	 * @return the employee permission that was removed
	 * @throws NoSuchEmployeePermissionException if a employee permission with the primary key could not be found
	 */
	@Override
	public EmployeePermission remove(Serializable primaryKey)
		throws NoSuchEmployeePermissionException {

		Session session = null;

		try {
			session = openSession();

			EmployeePermission employeePermission =
				(EmployeePermission)session.get(
					EmployeePermissionImpl.class, primaryKey);

			if (employeePermission == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmployeePermissionException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(employeePermission);
		}
		catch (NoSuchEmployeePermissionException noSuchEntityException) {
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
	protected EmployeePermission removeImpl(
		EmployeePermission employeePermission) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(employeePermission)) {
				employeePermission = (EmployeePermission)session.get(
					EmployeePermissionImpl.class,
					employeePermission.getPrimaryKeyObj());
			}

			if (employeePermission != null) {
				session.delete(employeePermission);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (employeePermission != null) {
			clearCache(employeePermission);
		}

		return employeePermission;
	}

	@Override
	public EmployeePermission updateImpl(
		EmployeePermission employeePermission) {

		boolean isNew = employeePermission.isNew();

		if (!(employeePermission instanceof EmployeePermissionModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(employeePermission.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					employeePermission);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in employeePermission proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EmployeePermission implementation " +
					employeePermission.getClass());
		}

		EmployeePermissionModelImpl employeePermissionModelImpl =
			(EmployeePermissionModelImpl)employeePermission;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (employeePermission.getCreateDate() == null)) {
			if (serviceContext == null) {
				employeePermission.setCreateDate(now);
			}
			else {
				employeePermission.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!employeePermissionModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				employeePermission.setModifiedDate(now);
			}
			else {
				employeePermission.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(employeePermission);
			}
			else {
				employeePermission = (EmployeePermission)session.merge(
					employeePermission);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EmployeePermissionImpl.class, employeePermissionModelImpl, false,
			true);

		cacheUniqueFindersCache(employeePermissionModelImpl);

		if (isNew) {
			employeePermission.setNew(false);
		}

		employeePermission.resetOriginalValues();

		return employeePermission;
	}

	/**
	 * Returns the employee permission with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee permission
	 * @return the employee permission
	 * @throws NoSuchEmployeePermissionException if a employee permission with the primary key could not be found
	 */
	@Override
	public EmployeePermission findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmployeePermissionException {

		EmployeePermission employeePermission = fetchByPrimaryKey(primaryKey);

		if (employeePermission == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmployeePermissionException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return employeePermission;
	}

	/**
	 * Returns the employee permission with the primary key or throws a <code>NoSuchEmployeePermissionException</code> if it could not be found.
	 *
	 * @param employeePermissionId the primary key of the employee permission
	 * @return the employee permission
	 * @throws NoSuchEmployeePermissionException if a employee permission with the primary key could not be found
	 */
	@Override
	public EmployeePermission findByPrimaryKey(long employeePermissionId)
		throws NoSuchEmployeePermissionException {

		return findByPrimaryKey((Serializable)employeePermissionId);
	}

	/**
	 * Returns the employee permission with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeePermissionId the primary key of the employee permission
	 * @return the employee permission, or <code>null</code> if a employee permission with the primary key could not be found
	 */
	@Override
	public EmployeePermission fetchByPrimaryKey(long employeePermissionId) {
		return fetchByPrimaryKey((Serializable)employeePermissionId);
	}

	/**
	 * Returns all the employee permissions.
	 *
	 * @return the employee permissions
	 */
	@Override
	public List<EmployeePermission> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee permissions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePermissionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee permissions
	 * @param end the upper bound of the range of employee permissions (not inclusive)
	 * @return the range of employee permissions
	 */
	@Override
	public List<EmployeePermission> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee permissions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePermissionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee permissions
	 * @param end the upper bound of the range of employee permissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee permissions
	 */
	@Override
	public List<EmployeePermission> findAll(
		int start, int end,
		OrderByComparator<EmployeePermission> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee permissions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePermissionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee permissions
	 * @param end the upper bound of the range of employee permissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee permissions
	 */
	@Override
	public List<EmployeePermission> findAll(
		int start, int end,
		OrderByComparator<EmployeePermission> orderByComparator,
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

		List<EmployeePermission> list = null;

		if (useFinderCache) {
			list = (List<EmployeePermission>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EMPLOYEEPERMISSION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLOYEEPERMISSION;

				sql = sql.concat(EmployeePermissionModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EmployeePermission>)QueryUtil.list(
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
	 * Removes all the employee permissions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EmployeePermission employeePermission : findAll()) {
			remove(employeePermission);
		}
	}

	/**
	 * Returns the number of employee permissions.
	 *
	 * @return the number of employee permissions
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
					_SQL_COUNT_EMPLOYEEPERMISSION);

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
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "employeePermissionId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EMPLOYEEPERMISSION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EmployeePermissionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the employee permission persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new EmployeePermissionModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", EmployeePermission.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathFetchByEmployeeId = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByEmployeeId",
			new String[] {Long.class.getName()}, new String[] {"employeeId"},
			true);

		_finderPathCountByEmployeeId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmployeeId",
			new String[] {Long.class.getName()}, new String[] {"employeeId"},
			false);

		_finderPathWithPaginationFindByJoiningProcessId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByJoiningProcessId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"joiningProcessId"}, true);

		_finderPathWithoutPaginationFindByJoiningProcessId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByJoiningProcessId",
			new String[] {Long.class.getName()},
			new String[] {"joiningProcessId"}, true);

		_finderPathCountByJoiningProcessId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByJoiningProcessId", new String[] {Long.class.getName()},
			new String[] {"joiningProcessId"}, false);

		_finderPathFetchBySingleUserOnboardingId = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBySingleUserOnboardingId",
			new String[] {Long.class.getName()},
			new String[] {"singleUserOnboardingId"}, true);

		_finderPathCountBySingleUserOnboardingId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySingleUserOnboardingId",
			new String[] {Long.class.getName()},
			new String[] {"singleUserOnboardingId"}, false);

		_finderPathFetchByRegistrationRequestId = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByRegistrationRequestId",
			new String[] {Long.class.getName()},
			new String[] {"registrationRequestId"}, true);

		_finderPathCountByRegistrationRequestId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByRegistrationRequestId", new String[] {Long.class.getName()},
			new String[] {"registrationRequestId"}, false);

		_finderPathWithPaginationFindByFormClassName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFormClassName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"form"}, true);

		_finderPathWithoutPaginationFindByFormClassName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFormClassName",
			new String[] {String.class.getName()}, new String[] {"form"}, true);

		_finderPathCountByFormClassName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFormClassName",
			new String[] {String.class.getName()}, new String[] {"form"},
			false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(EmployeePermissionImpl.class.getName());

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

	private static final String _SQL_SELECT_EMPLOYEEPERMISSION =
		"SELECT employeePermission FROM EmployeePermission employeePermission";

	private static final String _SQL_SELECT_EMPLOYEEPERMISSION_WHERE =
		"SELECT employeePermission FROM EmployeePermission employeePermission WHERE ";

	private static final String _SQL_COUNT_EMPLOYEEPERMISSION =
		"SELECT COUNT(employeePermission) FROM EmployeePermission employeePermission";

	private static final String _SQL_COUNT_EMPLOYEEPERMISSION_WHERE =
		"SELECT COUNT(employeePermission) FROM EmployeePermission employeePermission WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "employeePermission.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EmployeePermission exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EmployeePermission exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EmployeePermissionPersistenceImpl.class);

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

	private static class EmployeePermissionModelArgumentsResolver
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

			EmployeePermissionModelImpl employeePermissionModelImpl =
				(EmployeePermissionModelImpl)baseModel;

			long columnBitmask = employeePermissionModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					employeePermissionModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						employeePermissionModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					employeePermissionModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			EmployeePermissionModelImpl employeePermissionModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						employeePermissionModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = employeePermissionModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}