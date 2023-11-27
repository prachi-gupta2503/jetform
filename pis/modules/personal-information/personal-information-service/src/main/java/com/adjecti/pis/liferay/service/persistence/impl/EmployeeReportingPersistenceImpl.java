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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeReportingException;
import com.adjecti.pis.liferay.model.EmployeeReporting;
import com.adjecti.pis.liferay.model.impl.EmployeeReportingImpl;
import com.adjecti.pis.liferay.model.impl.EmployeeReportingModelImpl;
import com.adjecti.pis.liferay.service.persistence.EmployeeReportingPersistence;
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

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
 * The persistence implementation for the employee reporting service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EmployeeReportingPersistence.class)
public class EmployeeReportingPersistenceImpl
	extends BasePersistenceImpl<EmployeeReporting>
	implements EmployeeReportingPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EmployeeReportingUtil</code> to access the employee reporting persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EmployeeReportingImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByEmployeeId;
	private FinderPath _finderPathWithoutPaginationFindByEmployeeId;
	private FinderPath _finderPathCountByEmployeeId;

	/**
	 * Returns all the employee reportings where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee reportings
	 */
	@Override
	public List<EmployeeReporting> findByEmployeeId(long employeeId) {
		return findByEmployeeId(
			employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee reportings where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeReportingModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee reportings
	 * @param end the upper bound of the range of employee reportings (not inclusive)
	 * @return the range of matching employee reportings
	 */
	@Override
	public List<EmployeeReporting> findByEmployeeId(
		long employeeId, int start, int end) {

		return findByEmployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee reportings where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeReportingModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee reportings
	 * @param end the upper bound of the range of employee reportings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee reportings
	 */
	@Override
	public List<EmployeeReporting> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeReporting> orderByComparator) {

		return findByEmployeeId(
			employeeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee reportings where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeReportingModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee reportings
	 * @param end the upper bound of the range of employee reportings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee reportings
	 */
	@Override
	public List<EmployeeReporting> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeReporting> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByEmployeeId;
				finderArgs = new Object[] {employeeId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByEmployeeId;
			finderArgs = new Object[] {
				employeeId, start, end, orderByComparator
			};
		}

		List<EmployeeReporting> list = null;

		if (useFinderCache) {
			list = (List<EmployeeReporting>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeReporting employeeReporting : list) {
					if (employeeId != employeeReporting.getEmployeeId()) {
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

			sb.append(_SQL_SELECT_EMPLOYEEREPORTING_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeReportingModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				list = (List<EmployeeReporting>)QueryUtil.list(
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
	 * Returns the first employee reporting in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee reporting
	 * @throws NoSuchEmployeeReportingException if a matching employee reporting could not be found
	 */
	@Override
	public EmployeeReporting findByEmployeeId_First(
			long employeeId,
			OrderByComparator<EmployeeReporting> orderByComparator)
		throws NoSuchEmployeeReportingException {

		EmployeeReporting employeeReporting = fetchByEmployeeId_First(
			employeeId, orderByComparator);

		if (employeeReporting != null) {
			return employeeReporting;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeeReportingException(sb.toString());
	}

	/**
	 * Returns the first employee reporting in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee reporting, or <code>null</code> if a matching employee reporting could not be found
	 */
	@Override
	public EmployeeReporting fetchByEmployeeId_First(
		long employeeId,
		OrderByComparator<EmployeeReporting> orderByComparator) {

		List<EmployeeReporting> list = findByEmployeeId(
			employeeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee reporting in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee reporting
	 * @throws NoSuchEmployeeReportingException if a matching employee reporting could not be found
	 */
	@Override
	public EmployeeReporting findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<EmployeeReporting> orderByComparator)
		throws NoSuchEmployeeReportingException {

		EmployeeReporting employeeReporting = fetchByEmployeeId_Last(
			employeeId, orderByComparator);

		if (employeeReporting != null) {
			return employeeReporting;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeeReportingException(sb.toString());
	}

	/**
	 * Returns the last employee reporting in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee reporting, or <code>null</code> if a matching employee reporting could not be found
	 */
	@Override
	public EmployeeReporting fetchByEmployeeId_Last(
		long employeeId,
		OrderByComparator<EmployeeReporting> orderByComparator) {

		int count = countByEmployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<EmployeeReporting> list = findByEmployeeId(
			employeeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee reportings before and after the current employee reporting in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeReportingId the primary key of the current employee reporting
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee reporting
	 * @throws NoSuchEmployeeReportingException if a employee reporting with the primary key could not be found
	 */
	@Override
	public EmployeeReporting[] findByEmployeeId_PrevAndNext(
			long employeeReportingId, long employeeId,
			OrderByComparator<EmployeeReporting> orderByComparator)
		throws NoSuchEmployeeReportingException {

		EmployeeReporting employeeReporting = findByPrimaryKey(
			employeeReportingId);

		Session session = null;

		try {
			session = openSession();

			EmployeeReporting[] array = new EmployeeReportingImpl[3];

			array[0] = getByEmployeeId_PrevAndNext(
				session, employeeReporting, employeeId, orderByComparator,
				true);

			array[1] = employeeReporting;

			array[2] = getByEmployeeId_PrevAndNext(
				session, employeeReporting, employeeId, orderByComparator,
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

	protected EmployeeReporting getByEmployeeId_PrevAndNext(
		Session session, EmployeeReporting employeeReporting, long employeeId,
		OrderByComparator<EmployeeReporting> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEREPORTING_WHERE);

		sb.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

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
			sb.append(EmployeeReportingModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(employeeId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						employeeReporting)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeReporting> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee reportings where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeByEmployeeId(long employeeId) {
		for (EmployeeReporting employeeReporting :
				findByEmployeeId(
					employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeeReporting);
		}
	}

	/**
	 * Returns the number of employee reportings where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee reportings
	 */
	@Override
	public int countByEmployeeId(long employeeId) {
		FinderPath finderPath = _finderPathCountByEmployeeId;

		Object[] finderArgs = new Object[] {employeeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEREPORTING_WHERE);

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
		"employeeReporting.employeeId = ?";

	private FinderPath _finderPathWithPaginationFindByReportingToId;
	private FinderPath _finderPathWithoutPaginationFindByReportingToId;
	private FinderPath _finderPathCountByReportingToId;

	/**
	 * Returns all the employee reportings where reportingToId = &#63;.
	 *
	 * @param reportingToId the reporting to ID
	 * @return the matching employee reportings
	 */
	@Override
	public List<EmployeeReporting> findByReportingToId(long reportingToId) {
		return findByReportingToId(
			reportingToId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee reportings where reportingToId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeReportingModelImpl</code>.
	 * </p>
	 *
	 * @param reportingToId the reporting to ID
	 * @param start the lower bound of the range of employee reportings
	 * @param end the upper bound of the range of employee reportings (not inclusive)
	 * @return the range of matching employee reportings
	 */
	@Override
	public List<EmployeeReporting> findByReportingToId(
		long reportingToId, int start, int end) {

		return findByReportingToId(reportingToId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee reportings where reportingToId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeReportingModelImpl</code>.
	 * </p>
	 *
	 * @param reportingToId the reporting to ID
	 * @param start the lower bound of the range of employee reportings
	 * @param end the upper bound of the range of employee reportings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee reportings
	 */
	@Override
	public List<EmployeeReporting> findByReportingToId(
		long reportingToId, int start, int end,
		OrderByComparator<EmployeeReporting> orderByComparator) {

		return findByReportingToId(
			reportingToId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee reportings where reportingToId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeReportingModelImpl</code>.
	 * </p>
	 *
	 * @param reportingToId the reporting to ID
	 * @param start the lower bound of the range of employee reportings
	 * @param end the upper bound of the range of employee reportings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee reportings
	 */
	@Override
	public List<EmployeeReporting> findByReportingToId(
		long reportingToId, int start, int end,
		OrderByComparator<EmployeeReporting> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByReportingToId;
				finderArgs = new Object[] {reportingToId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByReportingToId;
			finderArgs = new Object[] {
				reportingToId, start, end, orderByComparator
			};
		}

		List<EmployeeReporting> list = null;

		if (useFinderCache) {
			list = (List<EmployeeReporting>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeReporting employeeReporting : list) {
					if (reportingToId != employeeReporting.getReportingToId()) {
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

			sb.append(_SQL_SELECT_EMPLOYEEREPORTING_WHERE);

			sb.append(_FINDER_COLUMN_REPORTINGTOID_REPORTINGTOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeReportingModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(reportingToId);

				list = (List<EmployeeReporting>)QueryUtil.list(
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
	 * Returns the first employee reporting in the ordered set where reportingToId = &#63;.
	 *
	 * @param reportingToId the reporting to ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee reporting
	 * @throws NoSuchEmployeeReportingException if a matching employee reporting could not be found
	 */
	@Override
	public EmployeeReporting findByReportingToId_First(
			long reportingToId,
			OrderByComparator<EmployeeReporting> orderByComparator)
		throws NoSuchEmployeeReportingException {

		EmployeeReporting employeeReporting = fetchByReportingToId_First(
			reportingToId, orderByComparator);

		if (employeeReporting != null) {
			return employeeReporting;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("reportingToId=");
		sb.append(reportingToId);

		sb.append("}");

		throw new NoSuchEmployeeReportingException(sb.toString());
	}

	/**
	 * Returns the first employee reporting in the ordered set where reportingToId = &#63;.
	 *
	 * @param reportingToId the reporting to ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee reporting, or <code>null</code> if a matching employee reporting could not be found
	 */
	@Override
	public EmployeeReporting fetchByReportingToId_First(
		long reportingToId,
		OrderByComparator<EmployeeReporting> orderByComparator) {

		List<EmployeeReporting> list = findByReportingToId(
			reportingToId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee reporting in the ordered set where reportingToId = &#63;.
	 *
	 * @param reportingToId the reporting to ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee reporting
	 * @throws NoSuchEmployeeReportingException if a matching employee reporting could not be found
	 */
	@Override
	public EmployeeReporting findByReportingToId_Last(
			long reportingToId,
			OrderByComparator<EmployeeReporting> orderByComparator)
		throws NoSuchEmployeeReportingException {

		EmployeeReporting employeeReporting = fetchByReportingToId_Last(
			reportingToId, orderByComparator);

		if (employeeReporting != null) {
			return employeeReporting;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("reportingToId=");
		sb.append(reportingToId);

		sb.append("}");

		throw new NoSuchEmployeeReportingException(sb.toString());
	}

	/**
	 * Returns the last employee reporting in the ordered set where reportingToId = &#63;.
	 *
	 * @param reportingToId the reporting to ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee reporting, or <code>null</code> if a matching employee reporting could not be found
	 */
	@Override
	public EmployeeReporting fetchByReportingToId_Last(
		long reportingToId,
		OrderByComparator<EmployeeReporting> orderByComparator) {

		int count = countByReportingToId(reportingToId);

		if (count == 0) {
			return null;
		}

		List<EmployeeReporting> list = findByReportingToId(
			reportingToId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee reportings before and after the current employee reporting in the ordered set where reportingToId = &#63;.
	 *
	 * @param employeeReportingId the primary key of the current employee reporting
	 * @param reportingToId the reporting to ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee reporting
	 * @throws NoSuchEmployeeReportingException if a employee reporting with the primary key could not be found
	 */
	@Override
	public EmployeeReporting[] findByReportingToId_PrevAndNext(
			long employeeReportingId, long reportingToId,
			OrderByComparator<EmployeeReporting> orderByComparator)
		throws NoSuchEmployeeReportingException {

		EmployeeReporting employeeReporting = findByPrimaryKey(
			employeeReportingId);

		Session session = null;

		try {
			session = openSession();

			EmployeeReporting[] array = new EmployeeReportingImpl[3];

			array[0] = getByReportingToId_PrevAndNext(
				session, employeeReporting, reportingToId, orderByComparator,
				true);

			array[1] = employeeReporting;

			array[2] = getByReportingToId_PrevAndNext(
				session, employeeReporting, reportingToId, orderByComparator,
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

	protected EmployeeReporting getByReportingToId_PrevAndNext(
		Session session, EmployeeReporting employeeReporting,
		long reportingToId,
		OrderByComparator<EmployeeReporting> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEREPORTING_WHERE);

		sb.append(_FINDER_COLUMN_REPORTINGTOID_REPORTINGTOID_2);

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
			sb.append(EmployeeReportingModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(reportingToId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						employeeReporting)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeReporting> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee reportings where reportingToId = &#63; from the database.
	 *
	 * @param reportingToId the reporting to ID
	 */
	@Override
	public void removeByReportingToId(long reportingToId) {
		for (EmployeeReporting employeeReporting :
				findByReportingToId(
					reportingToId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(employeeReporting);
		}
	}

	/**
	 * Returns the number of employee reportings where reportingToId = &#63;.
	 *
	 * @param reportingToId the reporting to ID
	 * @return the number of matching employee reportings
	 */
	@Override
	public int countByReportingToId(long reportingToId) {
		FinderPath finderPath = _finderPathCountByReportingToId;

		Object[] finderArgs = new Object[] {reportingToId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEREPORTING_WHERE);

			sb.append(_FINDER_COLUMN_REPORTINGTOID_REPORTINGTOID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(reportingToId);

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

	private static final String _FINDER_COLUMN_REPORTINGTOID_REPORTINGTOID_2 =
		"employeeReporting.reportingToId = ?";

	public EmployeeReportingPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(EmployeeReporting.class);

		setModelImplClass(EmployeeReportingImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the employee reporting in the entity cache if it is enabled.
	 *
	 * @param employeeReporting the employee reporting
	 */
	@Override
	public void cacheResult(EmployeeReporting employeeReporting) {
		entityCache.putResult(
			EmployeeReportingImpl.class, employeeReporting.getPrimaryKey(),
			employeeReporting);
	}

	/**
	 * Caches the employee reportings in the entity cache if it is enabled.
	 *
	 * @param employeeReportings the employee reportings
	 */
	@Override
	public void cacheResult(List<EmployeeReporting> employeeReportings) {
		for (EmployeeReporting employeeReporting : employeeReportings) {
			if (entityCache.getResult(
					EmployeeReportingImpl.class,
					employeeReporting.getPrimaryKey()) == null) {

				cacheResult(employeeReporting);
			}
		}
	}

	/**
	 * Clears the cache for all employee reportings.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmployeeReportingImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the employee reporting.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmployeeReporting employeeReporting) {
		entityCache.removeResult(
			EmployeeReportingImpl.class, employeeReporting);
	}

	@Override
	public void clearCache(List<EmployeeReporting> employeeReportings) {
		for (EmployeeReporting employeeReporting : employeeReportings) {
			entityCache.removeResult(
				EmployeeReportingImpl.class, employeeReporting);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EmployeeReportingImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new employee reporting with the primary key. Does not add the employee reporting to the database.
	 *
	 * @param employeeReportingId the primary key for the new employee reporting
	 * @return the new employee reporting
	 */
	@Override
	public EmployeeReporting create(long employeeReportingId) {
		EmployeeReporting employeeReporting = new EmployeeReportingImpl();

		employeeReporting.setNew(true);
		employeeReporting.setPrimaryKey(employeeReportingId);

		employeeReporting.setCompanyId(CompanyThreadLocal.getCompanyId());

		return employeeReporting;
	}

	/**
	 * Removes the employee reporting with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeReportingId the primary key of the employee reporting
	 * @return the employee reporting that was removed
	 * @throws NoSuchEmployeeReportingException if a employee reporting with the primary key could not be found
	 */
	@Override
	public EmployeeReporting remove(long employeeReportingId)
		throws NoSuchEmployeeReportingException {

		return remove((Serializable)employeeReportingId);
	}

	/**
	 * Removes the employee reporting with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the employee reporting
	 * @return the employee reporting that was removed
	 * @throws NoSuchEmployeeReportingException if a employee reporting with the primary key could not be found
	 */
	@Override
	public EmployeeReporting remove(Serializable primaryKey)
		throws NoSuchEmployeeReportingException {

		Session session = null;

		try {
			session = openSession();

			EmployeeReporting employeeReporting =
				(EmployeeReporting)session.get(
					EmployeeReportingImpl.class, primaryKey);

			if (employeeReporting == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmployeeReportingException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(employeeReporting);
		}
		catch (NoSuchEmployeeReportingException noSuchEntityException) {
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
	protected EmployeeReporting removeImpl(
		EmployeeReporting employeeReporting) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(employeeReporting)) {
				employeeReporting = (EmployeeReporting)session.get(
					EmployeeReportingImpl.class,
					employeeReporting.getPrimaryKeyObj());
			}

			if (employeeReporting != null) {
				session.delete(employeeReporting);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (employeeReporting != null) {
			clearCache(employeeReporting);
		}

		return employeeReporting;
	}

	@Override
	public EmployeeReporting updateImpl(EmployeeReporting employeeReporting) {
		boolean isNew = employeeReporting.isNew();

		if (!(employeeReporting instanceof EmployeeReportingModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(employeeReporting.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					employeeReporting);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in employeeReporting proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EmployeeReporting implementation " +
					employeeReporting.getClass());
		}

		EmployeeReportingModelImpl employeeReportingModelImpl =
			(EmployeeReportingModelImpl)employeeReporting;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (employeeReporting.getCreateDate() == null)) {
			if (serviceContext == null) {
				employeeReporting.setCreateDate(now);
			}
			else {
				employeeReporting.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!employeeReportingModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				employeeReporting.setModifiedDate(now);
			}
			else {
				employeeReporting.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(employeeReporting);
			}
			else {
				employeeReporting = (EmployeeReporting)session.merge(
					employeeReporting);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EmployeeReportingImpl.class, employeeReportingModelImpl, false,
			true);

		if (isNew) {
			employeeReporting.setNew(false);
		}

		employeeReporting.resetOriginalValues();

		return employeeReporting;
	}

	/**
	 * Returns the employee reporting with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee reporting
	 * @return the employee reporting
	 * @throws NoSuchEmployeeReportingException if a employee reporting with the primary key could not be found
	 */
	@Override
	public EmployeeReporting findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmployeeReportingException {

		EmployeeReporting employeeReporting = fetchByPrimaryKey(primaryKey);

		if (employeeReporting == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmployeeReportingException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return employeeReporting;
	}

	/**
	 * Returns the employee reporting with the primary key or throws a <code>NoSuchEmployeeReportingException</code> if it could not be found.
	 *
	 * @param employeeReportingId the primary key of the employee reporting
	 * @return the employee reporting
	 * @throws NoSuchEmployeeReportingException if a employee reporting with the primary key could not be found
	 */
	@Override
	public EmployeeReporting findByPrimaryKey(long employeeReportingId)
		throws NoSuchEmployeeReportingException {

		return findByPrimaryKey((Serializable)employeeReportingId);
	}

	/**
	 * Returns the employee reporting with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeReportingId the primary key of the employee reporting
	 * @return the employee reporting, or <code>null</code> if a employee reporting with the primary key could not be found
	 */
	@Override
	public EmployeeReporting fetchByPrimaryKey(long employeeReportingId) {
		return fetchByPrimaryKey((Serializable)employeeReportingId);
	}

	/**
	 * Returns all the employee reportings.
	 *
	 * @return the employee reportings
	 */
	@Override
	public List<EmployeeReporting> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee reportings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeReportingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee reportings
	 * @param end the upper bound of the range of employee reportings (not inclusive)
	 * @return the range of employee reportings
	 */
	@Override
	public List<EmployeeReporting> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee reportings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeReportingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee reportings
	 * @param end the upper bound of the range of employee reportings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee reportings
	 */
	@Override
	public List<EmployeeReporting> findAll(
		int start, int end,
		OrderByComparator<EmployeeReporting> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee reportings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeReportingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee reportings
	 * @param end the upper bound of the range of employee reportings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee reportings
	 */
	@Override
	public List<EmployeeReporting> findAll(
		int start, int end,
		OrderByComparator<EmployeeReporting> orderByComparator,
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

		List<EmployeeReporting> list = null;

		if (useFinderCache) {
			list = (List<EmployeeReporting>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EMPLOYEEREPORTING);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLOYEEREPORTING;

				sql = sql.concat(EmployeeReportingModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EmployeeReporting>)QueryUtil.list(
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
	 * Removes all the employee reportings from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EmployeeReporting employeeReporting : findAll()) {
			remove(employeeReporting);
		}
	}

	/**
	 * Returns the number of employee reportings.
	 *
	 * @return the number of employee reportings
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_EMPLOYEEREPORTING);

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
		return "employeeReportingId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EMPLOYEEREPORTING;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EmployeeReportingModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the employee reporting persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new EmployeeReportingModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", EmployeeReporting.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByEmployeeId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEmployeeId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"employeeId"}, true);

		_finderPathWithoutPaginationFindByEmployeeId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEmployeeId",
			new String[] {Long.class.getName()}, new String[] {"employeeId"},
			true);

		_finderPathCountByEmployeeId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmployeeId",
			new String[] {Long.class.getName()}, new String[] {"employeeId"},
			false);

		_finderPathWithPaginationFindByReportingToId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByReportingToId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"reportingToId"}, true);

		_finderPathWithoutPaginationFindByReportingToId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByReportingToId",
			new String[] {Long.class.getName()}, new String[] {"reportingToId"},
			true);

		_finderPathCountByReportingToId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByReportingToId",
			new String[] {Long.class.getName()}, new String[] {"reportingToId"},
			false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(EmployeeReportingImpl.class.getName());

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

	private static final String _SQL_SELECT_EMPLOYEEREPORTING =
		"SELECT employeeReporting FROM EmployeeReporting employeeReporting";

	private static final String _SQL_SELECT_EMPLOYEEREPORTING_WHERE =
		"SELECT employeeReporting FROM EmployeeReporting employeeReporting WHERE ";

	private static final String _SQL_COUNT_EMPLOYEEREPORTING =
		"SELECT COUNT(employeeReporting) FROM EmployeeReporting employeeReporting";

	private static final String _SQL_COUNT_EMPLOYEEREPORTING_WHERE =
		"SELECT COUNT(employeeReporting) FROM EmployeeReporting employeeReporting WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "employeeReporting.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EmployeeReporting exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EmployeeReporting exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EmployeeReportingPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"active"});

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

	private static class EmployeeReportingModelArgumentsResolver
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

			EmployeeReportingModelImpl employeeReportingModelImpl =
				(EmployeeReportingModelImpl)baseModel;

			long columnBitmask = employeeReportingModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					employeeReportingModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						employeeReportingModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					employeeReportingModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			EmployeeReportingModelImpl employeeReportingModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						employeeReportingModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = employeeReportingModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}