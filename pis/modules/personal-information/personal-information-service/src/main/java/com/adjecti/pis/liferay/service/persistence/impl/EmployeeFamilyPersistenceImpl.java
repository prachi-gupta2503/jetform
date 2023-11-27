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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeFamilyException;
import com.adjecti.pis.liferay.model.EmployeeFamily;
import com.adjecti.pis.liferay.model.impl.EmployeeFamilyImpl;
import com.adjecti.pis.liferay.model.impl.EmployeeFamilyModelImpl;
import com.adjecti.pis.liferay.service.persistence.EmployeeFamilyPersistence;
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

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
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
 * The persistence implementation for the employee family service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EmployeeFamilyPersistence.class)
public class EmployeeFamilyPersistenceImpl
	extends BasePersistenceImpl<EmployeeFamily>
	implements EmployeeFamilyPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EmployeeFamilyUtil</code> to access the employee family persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EmployeeFamilyImpl.class.getName();

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
	 * Returns all the employee families where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee families
	 */
	@Override
	public List<EmployeeFamily> findByEmployeeId(long employeeId) {
		return findByEmployeeId(
			employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee families where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeFamilyModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee families
	 * @param end the upper bound of the range of employee families (not inclusive)
	 * @return the range of matching employee families
	 */
	@Override
	public List<EmployeeFamily> findByEmployeeId(
		long employeeId, int start, int end) {

		return findByEmployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee families where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeFamilyModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee families
	 * @param end the upper bound of the range of employee families (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee families
	 */
	@Override
	public List<EmployeeFamily> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeFamily> orderByComparator) {

		return findByEmployeeId(
			employeeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee families where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeFamilyModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee families
	 * @param end the upper bound of the range of employee families (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee families
	 */
	@Override
	public List<EmployeeFamily> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeFamily> orderByComparator,
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

		List<EmployeeFamily> list = null;

		if (useFinderCache) {
			list = (List<EmployeeFamily>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeFamily employeeFamily : list) {
					if (employeeId != employeeFamily.getEmployeeId()) {
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

			sb.append(_SQL_SELECT_EMPLOYEEFAMILY_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeFamilyModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				list = (List<EmployeeFamily>)QueryUtil.list(
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
	 * Returns the first employee family in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee family
	 * @throws NoSuchEmployeeFamilyException if a matching employee family could not be found
	 */
	@Override
	public EmployeeFamily findByEmployeeId_First(
			long employeeId,
			OrderByComparator<EmployeeFamily> orderByComparator)
		throws NoSuchEmployeeFamilyException {

		EmployeeFamily employeeFamily = fetchByEmployeeId_First(
			employeeId, orderByComparator);

		if (employeeFamily != null) {
			return employeeFamily;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeeFamilyException(sb.toString());
	}

	/**
	 * Returns the first employee family in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee family, or <code>null</code> if a matching employee family could not be found
	 */
	@Override
	public EmployeeFamily fetchByEmployeeId_First(
		long employeeId, OrderByComparator<EmployeeFamily> orderByComparator) {

		List<EmployeeFamily> list = findByEmployeeId(
			employeeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee family in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee family
	 * @throws NoSuchEmployeeFamilyException if a matching employee family could not be found
	 */
	@Override
	public EmployeeFamily findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<EmployeeFamily> orderByComparator)
		throws NoSuchEmployeeFamilyException {

		EmployeeFamily employeeFamily = fetchByEmployeeId_Last(
			employeeId, orderByComparator);

		if (employeeFamily != null) {
			return employeeFamily;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeeFamilyException(sb.toString());
	}

	/**
	 * Returns the last employee family in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee family, or <code>null</code> if a matching employee family could not be found
	 */
	@Override
	public EmployeeFamily fetchByEmployeeId_Last(
		long employeeId, OrderByComparator<EmployeeFamily> orderByComparator) {

		int count = countByEmployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<EmployeeFamily> list = findByEmployeeId(
			employeeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee families before and after the current employee family in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeFamilyId the primary key of the current employee family
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee family
	 * @throws NoSuchEmployeeFamilyException if a employee family with the primary key could not be found
	 */
	@Override
	public EmployeeFamily[] findByEmployeeId_PrevAndNext(
			long employeeFamilyId, long employeeId,
			OrderByComparator<EmployeeFamily> orderByComparator)
		throws NoSuchEmployeeFamilyException {

		EmployeeFamily employeeFamily = findByPrimaryKey(employeeFamilyId);

		Session session = null;

		try {
			session = openSession();

			EmployeeFamily[] array = new EmployeeFamilyImpl[3];

			array[0] = getByEmployeeId_PrevAndNext(
				session, employeeFamily, employeeId, orderByComparator, true);

			array[1] = employeeFamily;

			array[2] = getByEmployeeId_PrevAndNext(
				session, employeeFamily, employeeId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EmployeeFamily getByEmployeeId_PrevAndNext(
		Session session, EmployeeFamily employeeFamily, long employeeId,
		OrderByComparator<EmployeeFamily> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_EMPLOYEEFAMILY_WHERE);

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
			sb.append(EmployeeFamilyModelImpl.ORDER_BY_JPQL);
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
						employeeFamily)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeFamily> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee families where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeByEmployeeId(long employeeId) {
		for (EmployeeFamily employeeFamily :
				findByEmployeeId(
					employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeeFamily);
		}
	}

	/**
	 * Returns the number of employee families where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee families
	 */
	@Override
	public int countByEmployeeId(long employeeId) {
		FinderPath finderPath = _finderPathCountByEmployeeId;

		Object[] finderArgs = new Object[] {employeeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEFAMILY_WHERE);

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
		"employeeFamily.employeeId = ?";

	private FinderPath _finderPathWithPaginationFindByRelationId;
	private FinderPath _finderPathWithoutPaginationFindByRelationId;
	private FinderPath _finderPathCountByRelationId;

	/**
	 * Returns all the employee families where relationId = &#63;.
	 *
	 * @param relationId the relation ID
	 * @return the matching employee families
	 */
	@Override
	public List<EmployeeFamily> findByRelationId(long relationId) {
		return findByRelationId(
			relationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee families where relationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeFamilyModelImpl</code>.
	 * </p>
	 *
	 * @param relationId the relation ID
	 * @param start the lower bound of the range of employee families
	 * @param end the upper bound of the range of employee families (not inclusive)
	 * @return the range of matching employee families
	 */
	@Override
	public List<EmployeeFamily> findByRelationId(
		long relationId, int start, int end) {

		return findByRelationId(relationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee families where relationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeFamilyModelImpl</code>.
	 * </p>
	 *
	 * @param relationId the relation ID
	 * @param start the lower bound of the range of employee families
	 * @param end the upper bound of the range of employee families (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee families
	 */
	@Override
	public List<EmployeeFamily> findByRelationId(
		long relationId, int start, int end,
		OrderByComparator<EmployeeFamily> orderByComparator) {

		return findByRelationId(
			relationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee families where relationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeFamilyModelImpl</code>.
	 * </p>
	 *
	 * @param relationId the relation ID
	 * @param start the lower bound of the range of employee families
	 * @param end the upper bound of the range of employee families (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee families
	 */
	@Override
	public List<EmployeeFamily> findByRelationId(
		long relationId, int start, int end,
		OrderByComparator<EmployeeFamily> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByRelationId;
				finderArgs = new Object[] {relationId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByRelationId;
			finderArgs = new Object[] {
				relationId, start, end, orderByComparator
			};
		}

		List<EmployeeFamily> list = null;

		if (useFinderCache) {
			list = (List<EmployeeFamily>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeFamily employeeFamily : list) {
					if (relationId != employeeFamily.getRelationId()) {
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

			sb.append(_SQL_SELECT_EMPLOYEEFAMILY_WHERE);

			sb.append(_FINDER_COLUMN_RELATIONID_RELATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeFamilyModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(relationId);

				list = (List<EmployeeFamily>)QueryUtil.list(
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
	 * Returns the first employee family in the ordered set where relationId = &#63;.
	 *
	 * @param relationId the relation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee family
	 * @throws NoSuchEmployeeFamilyException if a matching employee family could not be found
	 */
	@Override
	public EmployeeFamily findByRelationId_First(
			long relationId,
			OrderByComparator<EmployeeFamily> orderByComparator)
		throws NoSuchEmployeeFamilyException {

		EmployeeFamily employeeFamily = fetchByRelationId_First(
			relationId, orderByComparator);

		if (employeeFamily != null) {
			return employeeFamily;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("relationId=");
		sb.append(relationId);

		sb.append("}");

		throw new NoSuchEmployeeFamilyException(sb.toString());
	}

	/**
	 * Returns the first employee family in the ordered set where relationId = &#63;.
	 *
	 * @param relationId the relation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee family, or <code>null</code> if a matching employee family could not be found
	 */
	@Override
	public EmployeeFamily fetchByRelationId_First(
		long relationId, OrderByComparator<EmployeeFamily> orderByComparator) {

		List<EmployeeFamily> list = findByRelationId(
			relationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee family in the ordered set where relationId = &#63;.
	 *
	 * @param relationId the relation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee family
	 * @throws NoSuchEmployeeFamilyException if a matching employee family could not be found
	 */
	@Override
	public EmployeeFamily findByRelationId_Last(
			long relationId,
			OrderByComparator<EmployeeFamily> orderByComparator)
		throws NoSuchEmployeeFamilyException {

		EmployeeFamily employeeFamily = fetchByRelationId_Last(
			relationId, orderByComparator);

		if (employeeFamily != null) {
			return employeeFamily;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("relationId=");
		sb.append(relationId);

		sb.append("}");

		throw new NoSuchEmployeeFamilyException(sb.toString());
	}

	/**
	 * Returns the last employee family in the ordered set where relationId = &#63;.
	 *
	 * @param relationId the relation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee family, or <code>null</code> if a matching employee family could not be found
	 */
	@Override
	public EmployeeFamily fetchByRelationId_Last(
		long relationId, OrderByComparator<EmployeeFamily> orderByComparator) {

		int count = countByRelationId(relationId);

		if (count == 0) {
			return null;
		}

		List<EmployeeFamily> list = findByRelationId(
			relationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee families before and after the current employee family in the ordered set where relationId = &#63;.
	 *
	 * @param employeeFamilyId the primary key of the current employee family
	 * @param relationId the relation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee family
	 * @throws NoSuchEmployeeFamilyException if a employee family with the primary key could not be found
	 */
	@Override
	public EmployeeFamily[] findByRelationId_PrevAndNext(
			long employeeFamilyId, long relationId,
			OrderByComparator<EmployeeFamily> orderByComparator)
		throws NoSuchEmployeeFamilyException {

		EmployeeFamily employeeFamily = findByPrimaryKey(employeeFamilyId);

		Session session = null;

		try {
			session = openSession();

			EmployeeFamily[] array = new EmployeeFamilyImpl[3];

			array[0] = getByRelationId_PrevAndNext(
				session, employeeFamily, relationId, orderByComparator, true);

			array[1] = employeeFamily;

			array[2] = getByRelationId_PrevAndNext(
				session, employeeFamily, relationId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EmployeeFamily getByRelationId_PrevAndNext(
		Session session, EmployeeFamily employeeFamily, long relationId,
		OrderByComparator<EmployeeFamily> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_EMPLOYEEFAMILY_WHERE);

		sb.append(_FINDER_COLUMN_RELATIONID_RELATIONID_2);

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
			sb.append(EmployeeFamilyModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(relationId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						employeeFamily)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeFamily> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee families where relationId = &#63; from the database.
	 *
	 * @param relationId the relation ID
	 */
	@Override
	public void removeByRelationId(long relationId) {
		for (EmployeeFamily employeeFamily :
				findByRelationId(
					relationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeeFamily);
		}
	}

	/**
	 * Returns the number of employee families where relationId = &#63;.
	 *
	 * @param relationId the relation ID
	 * @return the number of matching employee families
	 */
	@Override
	public int countByRelationId(long relationId) {
		FinderPath finderPath = _finderPathCountByRelationId;

		Object[] finderArgs = new Object[] {relationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEFAMILY_WHERE);

			sb.append(_FINDER_COLUMN_RELATIONID_RELATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(relationId);

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

	private static final String _FINDER_COLUMN_RELATIONID_RELATIONID_2 =
		"employeeFamily.relationId = ?";

	private FinderPath _finderPathWithPaginationFindByOccupationId;
	private FinderPath _finderPathWithoutPaginationFindByOccupationId;
	private FinderPath _finderPathCountByOccupationId;

	/**
	 * Returns all the employee families where occupationId = &#63;.
	 *
	 * @param occupationId the occupation ID
	 * @return the matching employee families
	 */
	@Override
	public List<EmployeeFamily> findByOccupationId(long occupationId) {
		return findByOccupationId(
			occupationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee families where occupationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeFamilyModelImpl</code>.
	 * </p>
	 *
	 * @param occupationId the occupation ID
	 * @param start the lower bound of the range of employee families
	 * @param end the upper bound of the range of employee families (not inclusive)
	 * @return the range of matching employee families
	 */
	@Override
	public List<EmployeeFamily> findByOccupationId(
		long occupationId, int start, int end) {

		return findByOccupationId(occupationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee families where occupationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeFamilyModelImpl</code>.
	 * </p>
	 *
	 * @param occupationId the occupation ID
	 * @param start the lower bound of the range of employee families
	 * @param end the upper bound of the range of employee families (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee families
	 */
	@Override
	public List<EmployeeFamily> findByOccupationId(
		long occupationId, int start, int end,
		OrderByComparator<EmployeeFamily> orderByComparator) {

		return findByOccupationId(
			occupationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee families where occupationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeFamilyModelImpl</code>.
	 * </p>
	 *
	 * @param occupationId the occupation ID
	 * @param start the lower bound of the range of employee families
	 * @param end the upper bound of the range of employee families (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee families
	 */
	@Override
	public List<EmployeeFamily> findByOccupationId(
		long occupationId, int start, int end,
		OrderByComparator<EmployeeFamily> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByOccupationId;
				finderArgs = new Object[] {occupationId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByOccupationId;
			finderArgs = new Object[] {
				occupationId, start, end, orderByComparator
			};
		}

		List<EmployeeFamily> list = null;

		if (useFinderCache) {
			list = (List<EmployeeFamily>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeFamily employeeFamily : list) {
					if (occupationId != employeeFamily.getOccupationId()) {
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

			sb.append(_SQL_SELECT_EMPLOYEEFAMILY_WHERE);

			sb.append(_FINDER_COLUMN_OCCUPATIONID_OCCUPATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeFamilyModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(occupationId);

				list = (List<EmployeeFamily>)QueryUtil.list(
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
	 * Returns the first employee family in the ordered set where occupationId = &#63;.
	 *
	 * @param occupationId the occupation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee family
	 * @throws NoSuchEmployeeFamilyException if a matching employee family could not be found
	 */
	@Override
	public EmployeeFamily findByOccupationId_First(
			long occupationId,
			OrderByComparator<EmployeeFamily> orderByComparator)
		throws NoSuchEmployeeFamilyException {

		EmployeeFamily employeeFamily = fetchByOccupationId_First(
			occupationId, orderByComparator);

		if (employeeFamily != null) {
			return employeeFamily;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("occupationId=");
		sb.append(occupationId);

		sb.append("}");

		throw new NoSuchEmployeeFamilyException(sb.toString());
	}

	/**
	 * Returns the first employee family in the ordered set where occupationId = &#63;.
	 *
	 * @param occupationId the occupation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee family, or <code>null</code> if a matching employee family could not be found
	 */
	@Override
	public EmployeeFamily fetchByOccupationId_First(
		long occupationId,
		OrderByComparator<EmployeeFamily> orderByComparator) {

		List<EmployeeFamily> list = findByOccupationId(
			occupationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee family in the ordered set where occupationId = &#63;.
	 *
	 * @param occupationId the occupation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee family
	 * @throws NoSuchEmployeeFamilyException if a matching employee family could not be found
	 */
	@Override
	public EmployeeFamily findByOccupationId_Last(
			long occupationId,
			OrderByComparator<EmployeeFamily> orderByComparator)
		throws NoSuchEmployeeFamilyException {

		EmployeeFamily employeeFamily = fetchByOccupationId_Last(
			occupationId, orderByComparator);

		if (employeeFamily != null) {
			return employeeFamily;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("occupationId=");
		sb.append(occupationId);

		sb.append("}");

		throw new NoSuchEmployeeFamilyException(sb.toString());
	}

	/**
	 * Returns the last employee family in the ordered set where occupationId = &#63;.
	 *
	 * @param occupationId the occupation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee family, or <code>null</code> if a matching employee family could not be found
	 */
	@Override
	public EmployeeFamily fetchByOccupationId_Last(
		long occupationId,
		OrderByComparator<EmployeeFamily> orderByComparator) {

		int count = countByOccupationId(occupationId);

		if (count == 0) {
			return null;
		}

		List<EmployeeFamily> list = findByOccupationId(
			occupationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee families before and after the current employee family in the ordered set where occupationId = &#63;.
	 *
	 * @param employeeFamilyId the primary key of the current employee family
	 * @param occupationId the occupation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee family
	 * @throws NoSuchEmployeeFamilyException if a employee family with the primary key could not be found
	 */
	@Override
	public EmployeeFamily[] findByOccupationId_PrevAndNext(
			long employeeFamilyId, long occupationId,
			OrderByComparator<EmployeeFamily> orderByComparator)
		throws NoSuchEmployeeFamilyException {

		EmployeeFamily employeeFamily = findByPrimaryKey(employeeFamilyId);

		Session session = null;

		try {
			session = openSession();

			EmployeeFamily[] array = new EmployeeFamilyImpl[3];

			array[0] = getByOccupationId_PrevAndNext(
				session, employeeFamily, occupationId, orderByComparator, true);

			array[1] = employeeFamily;

			array[2] = getByOccupationId_PrevAndNext(
				session, employeeFamily, occupationId, orderByComparator,
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

	protected EmployeeFamily getByOccupationId_PrevAndNext(
		Session session, EmployeeFamily employeeFamily, long occupationId,
		OrderByComparator<EmployeeFamily> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_EMPLOYEEFAMILY_WHERE);

		sb.append(_FINDER_COLUMN_OCCUPATIONID_OCCUPATIONID_2);

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
			sb.append(EmployeeFamilyModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(occupationId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						employeeFamily)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeFamily> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee families where occupationId = &#63; from the database.
	 *
	 * @param occupationId the occupation ID
	 */
	@Override
	public void removeByOccupationId(long occupationId) {
		for (EmployeeFamily employeeFamily :
				findByOccupationId(
					occupationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeeFamily);
		}
	}

	/**
	 * Returns the number of employee families where occupationId = &#63;.
	 *
	 * @param occupationId the occupation ID
	 * @return the number of matching employee families
	 */
	@Override
	public int countByOccupationId(long occupationId) {
		FinderPath finderPath = _finderPathCountByOccupationId;

		Object[] finderArgs = new Object[] {occupationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEFAMILY_WHERE);

			sb.append(_FINDER_COLUMN_OCCUPATIONID_OCCUPATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(occupationId);

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

	private static final String _FINDER_COLUMN_OCCUPATIONID_OCCUPATIONID_2 =
		"employeeFamily.occupationId = ?";

	public EmployeeFamilyPersistenceImpl() {
		setModelClass(EmployeeFamily.class);

		setModelImplClass(EmployeeFamilyImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the employee family in the entity cache if it is enabled.
	 *
	 * @param employeeFamily the employee family
	 */
	@Override
	public void cacheResult(EmployeeFamily employeeFamily) {
		entityCache.putResult(
			EmployeeFamilyImpl.class, employeeFamily.getPrimaryKey(),
			employeeFamily);
	}

	/**
	 * Caches the employee families in the entity cache if it is enabled.
	 *
	 * @param employeeFamilies the employee families
	 */
	@Override
	public void cacheResult(List<EmployeeFamily> employeeFamilies) {
		for (EmployeeFamily employeeFamily : employeeFamilies) {
			if (entityCache.getResult(
					EmployeeFamilyImpl.class, employeeFamily.getPrimaryKey()) ==
						null) {

				cacheResult(employeeFamily);
			}
		}
	}

	/**
	 * Clears the cache for all employee families.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmployeeFamilyImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the employee family.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmployeeFamily employeeFamily) {
		entityCache.removeResult(EmployeeFamilyImpl.class, employeeFamily);
	}

	@Override
	public void clearCache(List<EmployeeFamily> employeeFamilies) {
		for (EmployeeFamily employeeFamily : employeeFamilies) {
			entityCache.removeResult(EmployeeFamilyImpl.class, employeeFamily);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EmployeeFamilyImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new employee family with the primary key. Does not add the employee family to the database.
	 *
	 * @param employeeFamilyId the primary key for the new employee family
	 * @return the new employee family
	 */
	@Override
	public EmployeeFamily create(long employeeFamilyId) {
		EmployeeFamily employeeFamily = new EmployeeFamilyImpl();

		employeeFamily.setNew(true);
		employeeFamily.setPrimaryKey(employeeFamilyId);

		employeeFamily.setCompanyId(CompanyThreadLocal.getCompanyId());

		return employeeFamily;
	}

	/**
	 * Removes the employee family with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeFamilyId the primary key of the employee family
	 * @return the employee family that was removed
	 * @throws NoSuchEmployeeFamilyException if a employee family with the primary key could not be found
	 */
	@Override
	public EmployeeFamily remove(long employeeFamilyId)
		throws NoSuchEmployeeFamilyException {

		return remove((Serializable)employeeFamilyId);
	}

	/**
	 * Removes the employee family with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the employee family
	 * @return the employee family that was removed
	 * @throws NoSuchEmployeeFamilyException if a employee family with the primary key could not be found
	 */
	@Override
	public EmployeeFamily remove(Serializable primaryKey)
		throws NoSuchEmployeeFamilyException {

		Session session = null;

		try {
			session = openSession();

			EmployeeFamily employeeFamily = (EmployeeFamily)session.get(
				EmployeeFamilyImpl.class, primaryKey);

			if (employeeFamily == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmployeeFamilyException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(employeeFamily);
		}
		catch (NoSuchEmployeeFamilyException noSuchEntityException) {
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
	protected EmployeeFamily removeImpl(EmployeeFamily employeeFamily) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(employeeFamily)) {
				employeeFamily = (EmployeeFamily)session.get(
					EmployeeFamilyImpl.class,
					employeeFamily.getPrimaryKeyObj());
			}

			if (employeeFamily != null) {
				session.delete(employeeFamily);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (employeeFamily != null) {
			clearCache(employeeFamily);
		}

		return employeeFamily;
	}

	@Override
	public EmployeeFamily updateImpl(EmployeeFamily employeeFamily) {
		boolean isNew = employeeFamily.isNew();

		if (!(employeeFamily instanceof EmployeeFamilyModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(employeeFamily.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					employeeFamily);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in employeeFamily proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EmployeeFamily implementation " +
					employeeFamily.getClass());
		}

		EmployeeFamilyModelImpl employeeFamilyModelImpl =
			(EmployeeFamilyModelImpl)employeeFamily;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (employeeFamily.getCreateDate() == null)) {
			if (serviceContext == null) {
				employeeFamily.setCreateDate(now);
			}
			else {
				employeeFamily.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!employeeFamilyModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				employeeFamily.setModifiedDate(now);
			}
			else {
				employeeFamily.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(employeeFamily);
			}
			else {
				employeeFamily = (EmployeeFamily)session.merge(employeeFamily);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EmployeeFamilyImpl.class, employeeFamilyModelImpl, false, true);

		if (isNew) {
			employeeFamily.setNew(false);
		}

		employeeFamily.resetOriginalValues();

		return employeeFamily;
	}

	/**
	 * Returns the employee family with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee family
	 * @return the employee family
	 * @throws NoSuchEmployeeFamilyException if a employee family with the primary key could not be found
	 */
	@Override
	public EmployeeFamily findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmployeeFamilyException {

		EmployeeFamily employeeFamily = fetchByPrimaryKey(primaryKey);

		if (employeeFamily == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmployeeFamilyException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return employeeFamily;
	}

	/**
	 * Returns the employee family with the primary key or throws a <code>NoSuchEmployeeFamilyException</code> if it could not be found.
	 *
	 * @param employeeFamilyId the primary key of the employee family
	 * @return the employee family
	 * @throws NoSuchEmployeeFamilyException if a employee family with the primary key could not be found
	 */
	@Override
	public EmployeeFamily findByPrimaryKey(long employeeFamilyId)
		throws NoSuchEmployeeFamilyException {

		return findByPrimaryKey((Serializable)employeeFamilyId);
	}

	/**
	 * Returns the employee family with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeFamilyId the primary key of the employee family
	 * @return the employee family, or <code>null</code> if a employee family with the primary key could not be found
	 */
	@Override
	public EmployeeFamily fetchByPrimaryKey(long employeeFamilyId) {
		return fetchByPrimaryKey((Serializable)employeeFamilyId);
	}

	/**
	 * Returns all the employee families.
	 *
	 * @return the employee families
	 */
	@Override
	public List<EmployeeFamily> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee families.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeFamilyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee families
	 * @param end the upper bound of the range of employee families (not inclusive)
	 * @return the range of employee families
	 */
	@Override
	public List<EmployeeFamily> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee families.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeFamilyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee families
	 * @param end the upper bound of the range of employee families (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee families
	 */
	@Override
	public List<EmployeeFamily> findAll(
		int start, int end,
		OrderByComparator<EmployeeFamily> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee families.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeFamilyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee families
	 * @param end the upper bound of the range of employee families (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee families
	 */
	@Override
	public List<EmployeeFamily> findAll(
		int start, int end, OrderByComparator<EmployeeFamily> orderByComparator,
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

		List<EmployeeFamily> list = null;

		if (useFinderCache) {
			list = (List<EmployeeFamily>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EMPLOYEEFAMILY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLOYEEFAMILY;

				sql = sql.concat(EmployeeFamilyModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EmployeeFamily>)QueryUtil.list(
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
	 * Removes all the employee families from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EmployeeFamily employeeFamily : findAll()) {
			remove(employeeFamily);
		}
	}

	/**
	 * Returns the number of employee families.
	 *
	 * @return the number of employee families
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_EMPLOYEEFAMILY);

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
		return "employeeFamilyId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EMPLOYEEFAMILY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EmployeeFamilyModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the employee family persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new EmployeeFamilyModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", EmployeeFamily.class.getName()));

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

		_finderPathWithPaginationFindByRelationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRelationId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"relationId"}, true);

		_finderPathWithoutPaginationFindByRelationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRelationId",
			new String[] {Long.class.getName()}, new String[] {"relationId"},
			true);

		_finderPathCountByRelationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRelationId",
			new String[] {Long.class.getName()}, new String[] {"relationId"},
			false);

		_finderPathWithPaginationFindByOccupationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByOccupationId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"occupationId"}, true);

		_finderPathWithoutPaginationFindByOccupationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOccupationId",
			new String[] {Long.class.getName()}, new String[] {"occupationId"},
			true);

		_finderPathCountByOccupationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOccupationId",
			new String[] {Long.class.getName()}, new String[] {"occupationId"},
			false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(EmployeeFamilyImpl.class.getName());

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

	private static final String _SQL_SELECT_EMPLOYEEFAMILY =
		"SELECT employeeFamily FROM EmployeeFamily employeeFamily";

	private static final String _SQL_SELECT_EMPLOYEEFAMILY_WHERE =
		"SELECT employeeFamily FROM EmployeeFamily employeeFamily WHERE ";

	private static final String _SQL_COUNT_EMPLOYEEFAMILY =
		"SELECT COUNT(employeeFamily) FROM EmployeeFamily employeeFamily";

	private static final String _SQL_COUNT_EMPLOYEEFAMILY_WHERE =
		"SELECT COUNT(employeeFamily) FROM EmployeeFamily employeeFamily WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "employeeFamily.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EmployeeFamily exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EmployeeFamily exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EmployeeFamilyPersistenceImpl.class);

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

	private static class EmployeeFamilyModelArgumentsResolver
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

			EmployeeFamilyModelImpl employeeFamilyModelImpl =
				(EmployeeFamilyModelImpl)baseModel;

			long columnBitmask = employeeFamilyModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					employeeFamilyModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						employeeFamilyModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					employeeFamilyModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			EmployeeFamilyModelImpl employeeFamilyModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						employeeFamilyModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = employeeFamilyModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}