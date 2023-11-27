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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeJoiningException;
import com.adjecti.pis.liferay.model.EmployeeJoining;
import com.adjecti.pis.liferay.model.impl.EmployeeJoiningImpl;
import com.adjecti.pis.liferay.model.impl.EmployeeJoiningModelImpl;
import com.adjecti.pis.liferay.service.persistence.EmployeeJoiningPersistence;
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
 * The persistence implementation for the employee joining service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EmployeeJoiningPersistence.class)
public class EmployeeJoiningPersistenceImpl
	extends BasePersistenceImpl<EmployeeJoining>
	implements EmployeeJoiningPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EmployeeJoiningUtil</code> to access the employee joining persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EmployeeJoiningImpl.class.getName();

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
	 * Returns all the employee joinings where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee joinings
	 */
	@Override
	public List<EmployeeJoining> findByEmployeeId(long employeeId) {
		return findByEmployeeId(
			employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee joinings where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeJoiningModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee joinings
	 * @param end the upper bound of the range of employee joinings (not inclusive)
	 * @return the range of matching employee joinings
	 */
	@Override
	public List<EmployeeJoining> findByEmployeeId(
		long employeeId, int start, int end) {

		return findByEmployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee joinings where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeJoiningModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee joinings
	 * @param end the upper bound of the range of employee joinings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee joinings
	 */
	@Override
	public List<EmployeeJoining> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeJoining> orderByComparator) {

		return findByEmployeeId(
			employeeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee joinings where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeJoiningModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee joinings
	 * @param end the upper bound of the range of employee joinings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee joinings
	 */
	@Override
	public List<EmployeeJoining> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeJoining> orderByComparator,
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

		List<EmployeeJoining> list = null;

		if (useFinderCache) {
			list = (List<EmployeeJoining>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeJoining employeeJoining : list) {
					if (employeeId != employeeJoining.getEmployeeId()) {
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

			sb.append(_SQL_SELECT_EMPLOYEEJOINING_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeJoiningModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				list = (List<EmployeeJoining>)QueryUtil.list(
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
	 * Returns the first employee joining in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee joining
	 * @throws NoSuchEmployeeJoiningException if a matching employee joining could not be found
	 */
	@Override
	public EmployeeJoining findByEmployeeId_First(
			long employeeId,
			OrderByComparator<EmployeeJoining> orderByComparator)
		throws NoSuchEmployeeJoiningException {

		EmployeeJoining employeeJoining = fetchByEmployeeId_First(
			employeeId, orderByComparator);

		if (employeeJoining != null) {
			return employeeJoining;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeeJoiningException(sb.toString());
	}

	/**
	 * Returns the first employee joining in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee joining, or <code>null</code> if a matching employee joining could not be found
	 */
	@Override
	public EmployeeJoining fetchByEmployeeId_First(
		long employeeId, OrderByComparator<EmployeeJoining> orderByComparator) {

		List<EmployeeJoining> list = findByEmployeeId(
			employeeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee joining in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee joining
	 * @throws NoSuchEmployeeJoiningException if a matching employee joining could not be found
	 */
	@Override
	public EmployeeJoining findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<EmployeeJoining> orderByComparator)
		throws NoSuchEmployeeJoiningException {

		EmployeeJoining employeeJoining = fetchByEmployeeId_Last(
			employeeId, orderByComparator);

		if (employeeJoining != null) {
			return employeeJoining;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeeJoiningException(sb.toString());
	}

	/**
	 * Returns the last employee joining in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee joining, or <code>null</code> if a matching employee joining could not be found
	 */
	@Override
	public EmployeeJoining fetchByEmployeeId_Last(
		long employeeId, OrderByComparator<EmployeeJoining> orderByComparator) {

		int count = countByEmployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<EmployeeJoining> list = findByEmployeeId(
			employeeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee joinings before and after the current employee joining in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeJoiningId the primary key of the current employee joining
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee joining
	 * @throws NoSuchEmployeeJoiningException if a employee joining with the primary key could not be found
	 */
	@Override
	public EmployeeJoining[] findByEmployeeId_PrevAndNext(
			long employeeJoiningId, long employeeId,
			OrderByComparator<EmployeeJoining> orderByComparator)
		throws NoSuchEmployeeJoiningException {

		EmployeeJoining employeeJoining = findByPrimaryKey(employeeJoiningId);

		Session session = null;

		try {
			session = openSession();

			EmployeeJoining[] array = new EmployeeJoiningImpl[3];

			array[0] = getByEmployeeId_PrevAndNext(
				session, employeeJoining, employeeId, orderByComparator, true);

			array[1] = employeeJoining;

			array[2] = getByEmployeeId_PrevAndNext(
				session, employeeJoining, employeeId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EmployeeJoining getByEmployeeId_PrevAndNext(
		Session session, EmployeeJoining employeeJoining, long employeeId,
		OrderByComparator<EmployeeJoining> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEJOINING_WHERE);

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
			sb.append(EmployeeJoiningModelImpl.ORDER_BY_JPQL);
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
						employeeJoining)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeJoining> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee joinings where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeByEmployeeId(long employeeId) {
		for (EmployeeJoining employeeJoining :
				findByEmployeeId(
					employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeeJoining);
		}
	}

	/**
	 * Returns the number of employee joinings where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee joinings
	 */
	@Override
	public int countByEmployeeId(long employeeId) {
		FinderPath finderPath = _finderPathCountByEmployeeId;

		Object[] finderArgs = new Object[] {employeeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEJOINING_WHERE);

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
		"employeeJoining.employeeId = ?";

	private FinderPath _finderPathWithPaginationFindByOrganizationId;
	private FinderPath _finderPathWithoutPaginationFindByOrganizationId;
	private FinderPath _finderPathCountByOrganizationId;

	/**
	 * Returns all the employee joinings where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching employee joinings
	 */
	@Override
	public List<EmployeeJoining> findByOrganizationId(long organizationId) {
		return findByOrganizationId(
			organizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee joinings where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeJoiningModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee joinings
	 * @param end the upper bound of the range of employee joinings (not inclusive)
	 * @return the range of matching employee joinings
	 */
	@Override
	public List<EmployeeJoining> findByOrganizationId(
		long organizationId, int start, int end) {

		return findByOrganizationId(organizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee joinings where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeJoiningModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee joinings
	 * @param end the upper bound of the range of employee joinings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee joinings
	 */
	@Override
	public List<EmployeeJoining> findByOrganizationId(
		long organizationId, int start, int end,
		OrderByComparator<EmployeeJoining> orderByComparator) {

		return findByOrganizationId(
			organizationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee joinings where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeJoiningModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee joinings
	 * @param end the upper bound of the range of employee joinings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee joinings
	 */
	@Override
	public List<EmployeeJoining> findByOrganizationId(
		long organizationId, int start, int end,
		OrderByComparator<EmployeeJoining> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByOrganizationId;
				finderArgs = new Object[] {organizationId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByOrganizationId;
			finderArgs = new Object[] {
				organizationId, start, end, orderByComparator
			};
		}

		List<EmployeeJoining> list = null;

		if (useFinderCache) {
			list = (List<EmployeeJoining>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeJoining employeeJoining : list) {
					if (organizationId != employeeJoining.getOrganizationId()) {
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

			sb.append(_SQL_SELECT_EMPLOYEEJOINING_WHERE);

			sb.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeJoiningModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(organizationId);

				list = (List<EmployeeJoining>)QueryUtil.list(
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
	 * Returns the first employee joining in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee joining
	 * @throws NoSuchEmployeeJoiningException if a matching employee joining could not be found
	 */
	@Override
	public EmployeeJoining findByOrganizationId_First(
			long organizationId,
			OrderByComparator<EmployeeJoining> orderByComparator)
		throws NoSuchEmployeeJoiningException {

		EmployeeJoining employeeJoining = fetchByOrganizationId_First(
			organizationId, orderByComparator);

		if (employeeJoining != null) {
			return employeeJoining;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("organizationId=");
		sb.append(organizationId);

		sb.append("}");

		throw new NoSuchEmployeeJoiningException(sb.toString());
	}

	/**
	 * Returns the first employee joining in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee joining, or <code>null</code> if a matching employee joining could not be found
	 */
	@Override
	public EmployeeJoining fetchByOrganizationId_First(
		long organizationId,
		OrderByComparator<EmployeeJoining> orderByComparator) {

		List<EmployeeJoining> list = findByOrganizationId(
			organizationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee joining in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee joining
	 * @throws NoSuchEmployeeJoiningException if a matching employee joining could not be found
	 */
	@Override
	public EmployeeJoining findByOrganizationId_Last(
			long organizationId,
			OrderByComparator<EmployeeJoining> orderByComparator)
		throws NoSuchEmployeeJoiningException {

		EmployeeJoining employeeJoining = fetchByOrganizationId_Last(
			organizationId, orderByComparator);

		if (employeeJoining != null) {
			return employeeJoining;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("organizationId=");
		sb.append(organizationId);

		sb.append("}");

		throw new NoSuchEmployeeJoiningException(sb.toString());
	}

	/**
	 * Returns the last employee joining in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee joining, or <code>null</code> if a matching employee joining could not be found
	 */
	@Override
	public EmployeeJoining fetchByOrganizationId_Last(
		long organizationId,
		OrderByComparator<EmployeeJoining> orderByComparator) {

		int count = countByOrganizationId(organizationId);

		if (count == 0) {
			return null;
		}

		List<EmployeeJoining> list = findByOrganizationId(
			organizationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee joinings before and after the current employee joining in the ordered set where organizationId = &#63;.
	 *
	 * @param employeeJoiningId the primary key of the current employee joining
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee joining
	 * @throws NoSuchEmployeeJoiningException if a employee joining with the primary key could not be found
	 */
	@Override
	public EmployeeJoining[] findByOrganizationId_PrevAndNext(
			long employeeJoiningId, long organizationId,
			OrderByComparator<EmployeeJoining> orderByComparator)
		throws NoSuchEmployeeJoiningException {

		EmployeeJoining employeeJoining = findByPrimaryKey(employeeJoiningId);

		Session session = null;

		try {
			session = openSession();

			EmployeeJoining[] array = new EmployeeJoiningImpl[3];

			array[0] = getByOrganizationId_PrevAndNext(
				session, employeeJoining, organizationId, orderByComparator,
				true);

			array[1] = employeeJoining;

			array[2] = getByOrganizationId_PrevAndNext(
				session, employeeJoining, organizationId, orderByComparator,
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

	protected EmployeeJoining getByOrganizationId_PrevAndNext(
		Session session, EmployeeJoining employeeJoining, long organizationId,
		OrderByComparator<EmployeeJoining> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEJOINING_WHERE);

		sb.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

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
			sb.append(EmployeeJoiningModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(organizationId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						employeeJoining)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeJoining> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee joinings where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	@Override
	public void removeByOrganizationId(long organizationId) {
		for (EmployeeJoining employeeJoining :
				findByOrganizationId(
					organizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(employeeJoining);
		}
	}

	/**
	 * Returns the number of employee joinings where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching employee joinings
	 */
	@Override
	public int countByOrganizationId(long organizationId) {
		FinderPath finderPath = _finderPathCountByOrganizationId;

		Object[] finderArgs = new Object[] {organizationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEJOINING_WHERE);

			sb.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(organizationId);

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

	private static final String _FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2 =
		"employeeJoining.organizationId = ?";

	private FinderPath _finderPathWithPaginationFindByJoiningProcessId;
	private FinderPath _finderPathWithoutPaginationFindByJoiningProcessId;
	private FinderPath _finderPathCountByJoiningProcessId;

	/**
	 * Returns all the employee joinings where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @return the matching employee joinings
	 */
	@Override
	public List<EmployeeJoining> findByJoiningProcessId(long joiningProcessId) {
		return findByJoiningProcessId(
			joiningProcessId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee joinings where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeJoiningModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of employee joinings
	 * @param end the upper bound of the range of employee joinings (not inclusive)
	 * @return the range of matching employee joinings
	 */
	@Override
	public List<EmployeeJoining> findByJoiningProcessId(
		long joiningProcessId, int start, int end) {

		return findByJoiningProcessId(joiningProcessId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee joinings where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeJoiningModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of employee joinings
	 * @param end the upper bound of the range of employee joinings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee joinings
	 */
	@Override
	public List<EmployeeJoining> findByJoiningProcessId(
		long joiningProcessId, int start, int end,
		OrderByComparator<EmployeeJoining> orderByComparator) {

		return findByJoiningProcessId(
			joiningProcessId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee joinings where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeJoiningModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of employee joinings
	 * @param end the upper bound of the range of employee joinings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee joinings
	 */
	@Override
	public List<EmployeeJoining> findByJoiningProcessId(
		long joiningProcessId, int start, int end,
		OrderByComparator<EmployeeJoining> orderByComparator,
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

		List<EmployeeJoining> list = null;

		if (useFinderCache) {
			list = (List<EmployeeJoining>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeJoining employeeJoining : list) {
					if (joiningProcessId !=
							employeeJoining.getJoiningProcessId()) {

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

			sb.append(_SQL_SELECT_EMPLOYEEJOINING_WHERE);

			sb.append(_FINDER_COLUMN_JOININGPROCESSID_JOININGPROCESSID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeJoiningModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(joiningProcessId);

				list = (List<EmployeeJoining>)QueryUtil.list(
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
	 * Returns the first employee joining in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee joining
	 * @throws NoSuchEmployeeJoiningException if a matching employee joining could not be found
	 */
	@Override
	public EmployeeJoining findByJoiningProcessId_First(
			long joiningProcessId,
			OrderByComparator<EmployeeJoining> orderByComparator)
		throws NoSuchEmployeeJoiningException {

		EmployeeJoining employeeJoining = fetchByJoiningProcessId_First(
			joiningProcessId, orderByComparator);

		if (employeeJoining != null) {
			return employeeJoining;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("joiningProcessId=");
		sb.append(joiningProcessId);

		sb.append("}");

		throw new NoSuchEmployeeJoiningException(sb.toString());
	}

	/**
	 * Returns the first employee joining in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee joining, or <code>null</code> if a matching employee joining could not be found
	 */
	@Override
	public EmployeeJoining fetchByJoiningProcessId_First(
		long joiningProcessId,
		OrderByComparator<EmployeeJoining> orderByComparator) {

		List<EmployeeJoining> list = findByJoiningProcessId(
			joiningProcessId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee joining in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee joining
	 * @throws NoSuchEmployeeJoiningException if a matching employee joining could not be found
	 */
	@Override
	public EmployeeJoining findByJoiningProcessId_Last(
			long joiningProcessId,
			OrderByComparator<EmployeeJoining> orderByComparator)
		throws NoSuchEmployeeJoiningException {

		EmployeeJoining employeeJoining = fetchByJoiningProcessId_Last(
			joiningProcessId, orderByComparator);

		if (employeeJoining != null) {
			return employeeJoining;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("joiningProcessId=");
		sb.append(joiningProcessId);

		sb.append("}");

		throw new NoSuchEmployeeJoiningException(sb.toString());
	}

	/**
	 * Returns the last employee joining in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee joining, or <code>null</code> if a matching employee joining could not be found
	 */
	@Override
	public EmployeeJoining fetchByJoiningProcessId_Last(
		long joiningProcessId,
		OrderByComparator<EmployeeJoining> orderByComparator) {

		int count = countByJoiningProcessId(joiningProcessId);

		if (count == 0) {
			return null;
		}

		List<EmployeeJoining> list = findByJoiningProcessId(
			joiningProcessId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee joinings before and after the current employee joining in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param employeeJoiningId the primary key of the current employee joining
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee joining
	 * @throws NoSuchEmployeeJoiningException if a employee joining with the primary key could not be found
	 */
	@Override
	public EmployeeJoining[] findByJoiningProcessId_PrevAndNext(
			long employeeJoiningId, long joiningProcessId,
			OrderByComparator<EmployeeJoining> orderByComparator)
		throws NoSuchEmployeeJoiningException {

		EmployeeJoining employeeJoining = findByPrimaryKey(employeeJoiningId);

		Session session = null;

		try {
			session = openSession();

			EmployeeJoining[] array = new EmployeeJoiningImpl[3];

			array[0] = getByJoiningProcessId_PrevAndNext(
				session, employeeJoining, joiningProcessId, orderByComparator,
				true);

			array[1] = employeeJoining;

			array[2] = getByJoiningProcessId_PrevAndNext(
				session, employeeJoining, joiningProcessId, orderByComparator,
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

	protected EmployeeJoining getByJoiningProcessId_PrevAndNext(
		Session session, EmployeeJoining employeeJoining, long joiningProcessId,
		OrderByComparator<EmployeeJoining> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEJOINING_WHERE);

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
			sb.append(EmployeeJoiningModelImpl.ORDER_BY_JPQL);
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
						employeeJoining)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeJoining> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee joinings where joiningProcessId = &#63; from the database.
	 *
	 * @param joiningProcessId the joining process ID
	 */
	@Override
	public void removeByJoiningProcessId(long joiningProcessId) {
		for (EmployeeJoining employeeJoining :
				findByJoiningProcessId(
					joiningProcessId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(employeeJoining);
		}
	}

	/**
	 * Returns the number of employee joinings where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @return the number of matching employee joinings
	 */
	@Override
	public int countByJoiningProcessId(long joiningProcessId) {
		FinderPath finderPath = _finderPathCountByJoiningProcessId;

		Object[] finderArgs = new Object[] {joiningProcessId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEJOINING_WHERE);

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
			"employeeJoining.joiningProcessId = ?";

	private FinderPath _finderPathWithPaginationFindByGradeModeId;
	private FinderPath _finderPathWithoutPaginationFindByGradeModeId;
	private FinderPath _finderPathCountByGradeModeId;

	/**
	 * Returns all the employee joinings where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @return the matching employee joinings
	 */
	@Override
	public List<EmployeeJoining> findByGradeModeId(long gradeModeId) {
		return findByGradeModeId(
			gradeModeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee joinings where gradeModeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeJoiningModelImpl</code>.
	 * </p>
	 *
	 * @param gradeModeId the grade mode ID
	 * @param start the lower bound of the range of employee joinings
	 * @param end the upper bound of the range of employee joinings (not inclusive)
	 * @return the range of matching employee joinings
	 */
	@Override
	public List<EmployeeJoining> findByGradeModeId(
		long gradeModeId, int start, int end) {

		return findByGradeModeId(gradeModeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee joinings where gradeModeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeJoiningModelImpl</code>.
	 * </p>
	 *
	 * @param gradeModeId the grade mode ID
	 * @param start the lower bound of the range of employee joinings
	 * @param end the upper bound of the range of employee joinings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee joinings
	 */
	@Override
	public List<EmployeeJoining> findByGradeModeId(
		long gradeModeId, int start, int end,
		OrderByComparator<EmployeeJoining> orderByComparator) {

		return findByGradeModeId(
			gradeModeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee joinings where gradeModeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeJoiningModelImpl</code>.
	 * </p>
	 *
	 * @param gradeModeId the grade mode ID
	 * @param start the lower bound of the range of employee joinings
	 * @param end the upper bound of the range of employee joinings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee joinings
	 */
	@Override
	public List<EmployeeJoining> findByGradeModeId(
		long gradeModeId, int start, int end,
		OrderByComparator<EmployeeJoining> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGradeModeId;
				finderArgs = new Object[] {gradeModeId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGradeModeId;
			finderArgs = new Object[] {
				gradeModeId, start, end, orderByComparator
			};
		}

		List<EmployeeJoining> list = null;

		if (useFinderCache) {
			list = (List<EmployeeJoining>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeJoining employeeJoining : list) {
					if (gradeModeId != employeeJoining.getGradeModeId()) {
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

			sb.append(_SQL_SELECT_EMPLOYEEJOINING_WHERE);

			sb.append(_FINDER_COLUMN_GRADEMODEID_GRADEMODEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeJoiningModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(gradeModeId);

				list = (List<EmployeeJoining>)QueryUtil.list(
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
	 * Returns the first employee joining in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee joining
	 * @throws NoSuchEmployeeJoiningException if a matching employee joining could not be found
	 */
	@Override
	public EmployeeJoining findByGradeModeId_First(
			long gradeModeId,
			OrderByComparator<EmployeeJoining> orderByComparator)
		throws NoSuchEmployeeJoiningException {

		EmployeeJoining employeeJoining = fetchByGradeModeId_First(
			gradeModeId, orderByComparator);

		if (employeeJoining != null) {
			return employeeJoining;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("gradeModeId=");
		sb.append(gradeModeId);

		sb.append("}");

		throw new NoSuchEmployeeJoiningException(sb.toString());
	}

	/**
	 * Returns the first employee joining in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee joining, or <code>null</code> if a matching employee joining could not be found
	 */
	@Override
	public EmployeeJoining fetchByGradeModeId_First(
		long gradeModeId,
		OrderByComparator<EmployeeJoining> orderByComparator) {

		List<EmployeeJoining> list = findByGradeModeId(
			gradeModeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee joining in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee joining
	 * @throws NoSuchEmployeeJoiningException if a matching employee joining could not be found
	 */
	@Override
	public EmployeeJoining findByGradeModeId_Last(
			long gradeModeId,
			OrderByComparator<EmployeeJoining> orderByComparator)
		throws NoSuchEmployeeJoiningException {

		EmployeeJoining employeeJoining = fetchByGradeModeId_Last(
			gradeModeId, orderByComparator);

		if (employeeJoining != null) {
			return employeeJoining;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("gradeModeId=");
		sb.append(gradeModeId);

		sb.append("}");

		throw new NoSuchEmployeeJoiningException(sb.toString());
	}

	/**
	 * Returns the last employee joining in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee joining, or <code>null</code> if a matching employee joining could not be found
	 */
	@Override
	public EmployeeJoining fetchByGradeModeId_Last(
		long gradeModeId,
		OrderByComparator<EmployeeJoining> orderByComparator) {

		int count = countByGradeModeId(gradeModeId);

		if (count == 0) {
			return null;
		}

		List<EmployeeJoining> list = findByGradeModeId(
			gradeModeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee joinings before and after the current employee joining in the ordered set where gradeModeId = &#63;.
	 *
	 * @param employeeJoiningId the primary key of the current employee joining
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee joining
	 * @throws NoSuchEmployeeJoiningException if a employee joining with the primary key could not be found
	 */
	@Override
	public EmployeeJoining[] findByGradeModeId_PrevAndNext(
			long employeeJoiningId, long gradeModeId,
			OrderByComparator<EmployeeJoining> orderByComparator)
		throws NoSuchEmployeeJoiningException {

		EmployeeJoining employeeJoining = findByPrimaryKey(employeeJoiningId);

		Session session = null;

		try {
			session = openSession();

			EmployeeJoining[] array = new EmployeeJoiningImpl[3];

			array[0] = getByGradeModeId_PrevAndNext(
				session, employeeJoining, gradeModeId, orderByComparator, true);

			array[1] = employeeJoining;

			array[2] = getByGradeModeId_PrevAndNext(
				session, employeeJoining, gradeModeId, orderByComparator,
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

	protected EmployeeJoining getByGradeModeId_PrevAndNext(
		Session session, EmployeeJoining employeeJoining, long gradeModeId,
		OrderByComparator<EmployeeJoining> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEJOINING_WHERE);

		sb.append(_FINDER_COLUMN_GRADEMODEID_GRADEMODEID_2);

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
			sb.append(EmployeeJoiningModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(gradeModeId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						employeeJoining)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeJoining> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee joinings where gradeModeId = &#63; from the database.
	 *
	 * @param gradeModeId the grade mode ID
	 */
	@Override
	public void removeByGradeModeId(long gradeModeId) {
		for (EmployeeJoining employeeJoining :
				findByGradeModeId(
					gradeModeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeeJoining);
		}
	}

	/**
	 * Returns the number of employee joinings where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @return the number of matching employee joinings
	 */
	@Override
	public int countByGradeModeId(long gradeModeId) {
		FinderPath finderPath = _finderPathCountByGradeModeId;

		Object[] finderArgs = new Object[] {gradeModeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEJOINING_WHERE);

			sb.append(_FINDER_COLUMN_GRADEMODEID_GRADEMODEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(gradeModeId);

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

	private static final String _FINDER_COLUMN_GRADEMODEID_GRADEMODEID_2 =
		"employeeJoining.gradeModeId = ?";

	private FinderPath _finderPathWithPaginationFindBySubOrganizationId;
	private FinderPath _finderPathWithoutPaginationFindBySubOrganizationId;
	private FinderPath _finderPathCountBySubOrganizationId;

	/**
	 * Returns all the employee joinings where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @return the matching employee joinings
	 */
	@Override
	public List<EmployeeJoining> findBySubOrganizationId(
		long subOrganizationId) {

		return findBySubOrganizationId(
			subOrganizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee joinings where subOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeJoiningModelImpl</code>.
	 * </p>
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param start the lower bound of the range of employee joinings
	 * @param end the upper bound of the range of employee joinings (not inclusive)
	 * @return the range of matching employee joinings
	 */
	@Override
	public List<EmployeeJoining> findBySubOrganizationId(
		long subOrganizationId, int start, int end) {

		return findBySubOrganizationId(subOrganizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee joinings where subOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeJoiningModelImpl</code>.
	 * </p>
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param start the lower bound of the range of employee joinings
	 * @param end the upper bound of the range of employee joinings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee joinings
	 */
	@Override
	public List<EmployeeJoining> findBySubOrganizationId(
		long subOrganizationId, int start, int end,
		OrderByComparator<EmployeeJoining> orderByComparator) {

		return findBySubOrganizationId(
			subOrganizationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee joinings where subOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeJoiningModelImpl</code>.
	 * </p>
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param start the lower bound of the range of employee joinings
	 * @param end the upper bound of the range of employee joinings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee joinings
	 */
	@Override
	public List<EmployeeJoining> findBySubOrganizationId(
		long subOrganizationId, int start, int end,
		OrderByComparator<EmployeeJoining> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBySubOrganizationId;
				finderArgs = new Object[] {subOrganizationId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBySubOrganizationId;
			finderArgs = new Object[] {
				subOrganizationId, start, end, orderByComparator
			};
		}

		List<EmployeeJoining> list = null;

		if (useFinderCache) {
			list = (List<EmployeeJoining>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeJoining employeeJoining : list) {
					if (subOrganizationId !=
							employeeJoining.getSubOrganizationId()) {

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

			sb.append(_SQL_SELECT_EMPLOYEEJOINING_WHERE);

			sb.append(_FINDER_COLUMN_SUBORGANIZATIONID_SUBORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeJoiningModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(subOrganizationId);

				list = (List<EmployeeJoining>)QueryUtil.list(
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
	 * Returns the first employee joining in the ordered set where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee joining
	 * @throws NoSuchEmployeeJoiningException if a matching employee joining could not be found
	 */
	@Override
	public EmployeeJoining findBySubOrganizationId_First(
			long subOrganizationId,
			OrderByComparator<EmployeeJoining> orderByComparator)
		throws NoSuchEmployeeJoiningException {

		EmployeeJoining employeeJoining = fetchBySubOrganizationId_First(
			subOrganizationId, orderByComparator);

		if (employeeJoining != null) {
			return employeeJoining;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("subOrganizationId=");
		sb.append(subOrganizationId);

		sb.append("}");

		throw new NoSuchEmployeeJoiningException(sb.toString());
	}

	/**
	 * Returns the first employee joining in the ordered set where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee joining, or <code>null</code> if a matching employee joining could not be found
	 */
	@Override
	public EmployeeJoining fetchBySubOrganizationId_First(
		long subOrganizationId,
		OrderByComparator<EmployeeJoining> orderByComparator) {

		List<EmployeeJoining> list = findBySubOrganizationId(
			subOrganizationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee joining in the ordered set where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee joining
	 * @throws NoSuchEmployeeJoiningException if a matching employee joining could not be found
	 */
	@Override
	public EmployeeJoining findBySubOrganizationId_Last(
			long subOrganizationId,
			OrderByComparator<EmployeeJoining> orderByComparator)
		throws NoSuchEmployeeJoiningException {

		EmployeeJoining employeeJoining = fetchBySubOrganizationId_Last(
			subOrganizationId, orderByComparator);

		if (employeeJoining != null) {
			return employeeJoining;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("subOrganizationId=");
		sb.append(subOrganizationId);

		sb.append("}");

		throw new NoSuchEmployeeJoiningException(sb.toString());
	}

	/**
	 * Returns the last employee joining in the ordered set where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee joining, or <code>null</code> if a matching employee joining could not be found
	 */
	@Override
	public EmployeeJoining fetchBySubOrganizationId_Last(
		long subOrganizationId,
		OrderByComparator<EmployeeJoining> orderByComparator) {

		int count = countBySubOrganizationId(subOrganizationId);

		if (count == 0) {
			return null;
		}

		List<EmployeeJoining> list = findBySubOrganizationId(
			subOrganizationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee joinings before and after the current employee joining in the ordered set where subOrganizationId = &#63;.
	 *
	 * @param employeeJoiningId the primary key of the current employee joining
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee joining
	 * @throws NoSuchEmployeeJoiningException if a employee joining with the primary key could not be found
	 */
	@Override
	public EmployeeJoining[] findBySubOrganizationId_PrevAndNext(
			long employeeJoiningId, long subOrganizationId,
			OrderByComparator<EmployeeJoining> orderByComparator)
		throws NoSuchEmployeeJoiningException {

		EmployeeJoining employeeJoining = findByPrimaryKey(employeeJoiningId);

		Session session = null;

		try {
			session = openSession();

			EmployeeJoining[] array = new EmployeeJoiningImpl[3];

			array[0] = getBySubOrganizationId_PrevAndNext(
				session, employeeJoining, subOrganizationId, orderByComparator,
				true);

			array[1] = employeeJoining;

			array[2] = getBySubOrganizationId_PrevAndNext(
				session, employeeJoining, subOrganizationId, orderByComparator,
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

	protected EmployeeJoining getBySubOrganizationId_PrevAndNext(
		Session session, EmployeeJoining employeeJoining,
		long subOrganizationId,
		OrderByComparator<EmployeeJoining> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEJOINING_WHERE);

		sb.append(_FINDER_COLUMN_SUBORGANIZATIONID_SUBORGANIZATIONID_2);

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
			sb.append(EmployeeJoiningModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(subOrganizationId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						employeeJoining)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeJoining> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee joinings where subOrganizationId = &#63; from the database.
	 *
	 * @param subOrganizationId the sub organization ID
	 */
	@Override
	public void removeBySubOrganizationId(long subOrganizationId) {
		for (EmployeeJoining employeeJoining :
				findBySubOrganizationId(
					subOrganizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(employeeJoining);
		}
	}

	/**
	 * Returns the number of employee joinings where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @return the number of matching employee joinings
	 */
	@Override
	public int countBySubOrganizationId(long subOrganizationId) {
		FinderPath finderPath = _finderPathCountBySubOrganizationId;

		Object[] finderArgs = new Object[] {subOrganizationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEJOINING_WHERE);

			sb.append(_FINDER_COLUMN_SUBORGANIZATIONID_SUBORGANIZATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(subOrganizationId);

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
		_FINDER_COLUMN_SUBORGANIZATIONID_SUBORGANIZATIONID_2 =
			"employeeJoining.subOrganizationId = ?";

	public EmployeeJoiningPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("rank", "rank_");

		setDBColumnNames(dbColumnNames);

		setModelClass(EmployeeJoining.class);

		setModelImplClass(EmployeeJoiningImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the employee joining in the entity cache if it is enabled.
	 *
	 * @param employeeJoining the employee joining
	 */
	@Override
	public void cacheResult(EmployeeJoining employeeJoining) {
		entityCache.putResult(
			EmployeeJoiningImpl.class, employeeJoining.getPrimaryKey(),
			employeeJoining);
	}

	/**
	 * Caches the employee joinings in the entity cache if it is enabled.
	 *
	 * @param employeeJoinings the employee joinings
	 */
	@Override
	public void cacheResult(List<EmployeeJoining> employeeJoinings) {
		for (EmployeeJoining employeeJoining : employeeJoinings) {
			if (entityCache.getResult(
					EmployeeJoiningImpl.class,
					employeeJoining.getPrimaryKey()) == null) {

				cacheResult(employeeJoining);
			}
		}
	}

	/**
	 * Clears the cache for all employee joinings.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmployeeJoiningImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the employee joining.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmployeeJoining employeeJoining) {
		entityCache.removeResult(EmployeeJoiningImpl.class, employeeJoining);
	}

	@Override
	public void clearCache(List<EmployeeJoining> employeeJoinings) {
		for (EmployeeJoining employeeJoining : employeeJoinings) {
			entityCache.removeResult(
				EmployeeJoiningImpl.class, employeeJoining);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EmployeeJoiningImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new employee joining with the primary key. Does not add the employee joining to the database.
	 *
	 * @param employeeJoiningId the primary key for the new employee joining
	 * @return the new employee joining
	 */
	@Override
	public EmployeeJoining create(long employeeJoiningId) {
		EmployeeJoining employeeJoining = new EmployeeJoiningImpl();

		employeeJoining.setNew(true);
		employeeJoining.setPrimaryKey(employeeJoiningId);

		employeeJoining.setCompanyId(CompanyThreadLocal.getCompanyId());

		return employeeJoining;
	}

	/**
	 * Removes the employee joining with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeJoiningId the primary key of the employee joining
	 * @return the employee joining that was removed
	 * @throws NoSuchEmployeeJoiningException if a employee joining with the primary key could not be found
	 */
	@Override
	public EmployeeJoining remove(long employeeJoiningId)
		throws NoSuchEmployeeJoiningException {

		return remove((Serializable)employeeJoiningId);
	}

	/**
	 * Removes the employee joining with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the employee joining
	 * @return the employee joining that was removed
	 * @throws NoSuchEmployeeJoiningException if a employee joining with the primary key could not be found
	 */
	@Override
	public EmployeeJoining remove(Serializable primaryKey)
		throws NoSuchEmployeeJoiningException {

		Session session = null;

		try {
			session = openSession();

			EmployeeJoining employeeJoining = (EmployeeJoining)session.get(
				EmployeeJoiningImpl.class, primaryKey);

			if (employeeJoining == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmployeeJoiningException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(employeeJoining);
		}
		catch (NoSuchEmployeeJoiningException noSuchEntityException) {
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
	protected EmployeeJoining removeImpl(EmployeeJoining employeeJoining) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(employeeJoining)) {
				employeeJoining = (EmployeeJoining)session.get(
					EmployeeJoiningImpl.class,
					employeeJoining.getPrimaryKeyObj());
			}

			if (employeeJoining != null) {
				session.delete(employeeJoining);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (employeeJoining != null) {
			clearCache(employeeJoining);
		}

		return employeeJoining;
	}

	@Override
	public EmployeeJoining updateImpl(EmployeeJoining employeeJoining) {
		boolean isNew = employeeJoining.isNew();

		if (!(employeeJoining instanceof EmployeeJoiningModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(employeeJoining.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					employeeJoining);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in employeeJoining proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EmployeeJoining implementation " +
					employeeJoining.getClass());
		}

		EmployeeJoiningModelImpl employeeJoiningModelImpl =
			(EmployeeJoiningModelImpl)employeeJoining;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (employeeJoining.getCreateDate() == null)) {
			if (serviceContext == null) {
				employeeJoining.setCreateDate(now);
			}
			else {
				employeeJoining.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!employeeJoiningModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				employeeJoining.setModifiedDate(now);
			}
			else {
				employeeJoining.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(employeeJoining);
			}
			else {
				employeeJoining = (EmployeeJoining)session.merge(
					employeeJoining);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EmployeeJoiningImpl.class, employeeJoiningModelImpl, false, true);

		if (isNew) {
			employeeJoining.setNew(false);
		}

		employeeJoining.resetOriginalValues();

		return employeeJoining;
	}

	/**
	 * Returns the employee joining with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee joining
	 * @return the employee joining
	 * @throws NoSuchEmployeeJoiningException if a employee joining with the primary key could not be found
	 */
	@Override
	public EmployeeJoining findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmployeeJoiningException {

		EmployeeJoining employeeJoining = fetchByPrimaryKey(primaryKey);

		if (employeeJoining == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmployeeJoiningException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return employeeJoining;
	}

	/**
	 * Returns the employee joining with the primary key or throws a <code>NoSuchEmployeeJoiningException</code> if it could not be found.
	 *
	 * @param employeeJoiningId the primary key of the employee joining
	 * @return the employee joining
	 * @throws NoSuchEmployeeJoiningException if a employee joining with the primary key could not be found
	 */
	@Override
	public EmployeeJoining findByPrimaryKey(long employeeJoiningId)
		throws NoSuchEmployeeJoiningException {

		return findByPrimaryKey((Serializable)employeeJoiningId);
	}

	/**
	 * Returns the employee joining with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeJoiningId the primary key of the employee joining
	 * @return the employee joining, or <code>null</code> if a employee joining with the primary key could not be found
	 */
	@Override
	public EmployeeJoining fetchByPrimaryKey(long employeeJoiningId) {
		return fetchByPrimaryKey((Serializable)employeeJoiningId);
	}

	/**
	 * Returns all the employee joinings.
	 *
	 * @return the employee joinings
	 */
	@Override
	public List<EmployeeJoining> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee joinings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeJoiningModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee joinings
	 * @param end the upper bound of the range of employee joinings (not inclusive)
	 * @return the range of employee joinings
	 */
	@Override
	public List<EmployeeJoining> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee joinings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeJoiningModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee joinings
	 * @param end the upper bound of the range of employee joinings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee joinings
	 */
	@Override
	public List<EmployeeJoining> findAll(
		int start, int end,
		OrderByComparator<EmployeeJoining> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee joinings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeJoiningModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee joinings
	 * @param end the upper bound of the range of employee joinings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee joinings
	 */
	@Override
	public List<EmployeeJoining> findAll(
		int start, int end,
		OrderByComparator<EmployeeJoining> orderByComparator,
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

		List<EmployeeJoining> list = null;

		if (useFinderCache) {
			list = (List<EmployeeJoining>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EMPLOYEEJOINING);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLOYEEJOINING;

				sql = sql.concat(EmployeeJoiningModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EmployeeJoining>)QueryUtil.list(
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
	 * Removes all the employee joinings from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EmployeeJoining employeeJoining : findAll()) {
			remove(employeeJoining);
		}
	}

	/**
	 * Returns the number of employee joinings.
	 *
	 * @return the number of employee joinings
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_EMPLOYEEJOINING);

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
		return "employeeJoiningId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EMPLOYEEJOINING;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EmployeeJoiningModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the employee joining persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new EmployeeJoiningModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", EmployeeJoining.class.getName()));

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

		_finderPathWithPaginationFindByOrganizationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByOrganizationId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"organizationId"}, true);

		_finderPathWithoutPaginationFindByOrganizationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOrganizationId",
			new String[] {Long.class.getName()},
			new String[] {"organizationId"}, true);

		_finderPathCountByOrganizationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOrganizationId",
			new String[] {Long.class.getName()},
			new String[] {"organizationId"}, false);

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

		_finderPathWithPaginationFindByGradeModeId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGradeModeId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"gradeModeId"}, true);

		_finderPathWithoutPaginationFindByGradeModeId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGradeModeId",
			new String[] {Long.class.getName()}, new String[] {"gradeModeId"},
			true);

		_finderPathCountByGradeModeId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGradeModeId",
			new String[] {Long.class.getName()}, new String[] {"gradeModeId"},
			false);

		_finderPathWithPaginationFindBySubOrganizationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySubOrganizationId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"subOrganizationId"}, true);

		_finderPathWithoutPaginationFindBySubOrganizationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBySubOrganizationId", new String[] {Long.class.getName()},
			new String[] {"subOrganizationId"}, true);

		_finderPathCountBySubOrganizationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySubOrganizationId", new String[] {Long.class.getName()},
			new String[] {"subOrganizationId"}, false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(EmployeeJoiningImpl.class.getName());

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

	private static final String _SQL_SELECT_EMPLOYEEJOINING =
		"SELECT employeeJoining FROM EmployeeJoining employeeJoining";

	private static final String _SQL_SELECT_EMPLOYEEJOINING_WHERE =
		"SELECT employeeJoining FROM EmployeeJoining employeeJoining WHERE ";

	private static final String _SQL_COUNT_EMPLOYEEJOINING =
		"SELECT COUNT(employeeJoining) FROM EmployeeJoining employeeJoining";

	private static final String _SQL_COUNT_EMPLOYEEJOINING_WHERE =
		"SELECT COUNT(employeeJoining) FROM EmployeeJoining employeeJoining WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "employeeJoining.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EmployeeJoining exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EmployeeJoining exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EmployeeJoiningPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"rank"});

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

	private static class EmployeeJoiningModelArgumentsResolver
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

			EmployeeJoiningModelImpl employeeJoiningModelImpl =
				(EmployeeJoiningModelImpl)baseModel;

			long columnBitmask = employeeJoiningModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					employeeJoiningModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						employeeJoiningModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					employeeJoiningModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			EmployeeJoiningModelImpl employeeJoiningModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						employeeJoiningModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = employeeJoiningModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}