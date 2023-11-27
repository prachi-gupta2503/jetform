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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeWorkAreaException;
import com.adjecti.pis.liferay.model.EmployeeWorkArea;
import com.adjecti.pis.liferay.model.impl.EmployeeWorkAreaImpl;
import com.adjecti.pis.liferay.model.impl.EmployeeWorkAreaModelImpl;
import com.adjecti.pis.liferay.service.persistence.EmployeeWorkAreaPersistence;
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
 * The persistence implementation for the employee work area service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EmployeeWorkAreaPersistence.class)
public class EmployeeWorkAreaPersistenceImpl
	extends BasePersistenceImpl<EmployeeWorkArea>
	implements EmployeeWorkAreaPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EmployeeWorkAreaUtil</code> to access the employee work area persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EmployeeWorkAreaImpl.class.getName();

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
	 * Returns all the employee work areas where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee work areas
	 */
	@Override
	public List<EmployeeWorkArea> findByEmployeeId(long employeeId) {
		return findByEmployeeId(
			employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee work areas where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeWorkAreaModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee work areas
	 * @param end the upper bound of the range of employee work areas (not inclusive)
	 * @return the range of matching employee work areas
	 */
	@Override
	public List<EmployeeWorkArea> findByEmployeeId(
		long employeeId, int start, int end) {

		return findByEmployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee work areas where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeWorkAreaModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee work areas
	 * @param end the upper bound of the range of employee work areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee work areas
	 */
	@Override
	public List<EmployeeWorkArea> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeWorkArea> orderByComparator) {

		return findByEmployeeId(
			employeeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee work areas where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeWorkAreaModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee work areas
	 * @param end the upper bound of the range of employee work areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee work areas
	 */
	@Override
	public List<EmployeeWorkArea> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeWorkArea> orderByComparator,
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

		List<EmployeeWorkArea> list = null;

		if (useFinderCache) {
			list = (List<EmployeeWorkArea>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeWorkArea employeeWorkArea : list) {
					if (employeeId != employeeWorkArea.getEmployeeId()) {
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

			sb.append(_SQL_SELECT_EMPLOYEEWORKAREA_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeWorkAreaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				list = (List<EmployeeWorkArea>)QueryUtil.list(
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
	 * Returns the first employee work area in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee work area
	 * @throws NoSuchEmployeeWorkAreaException if a matching employee work area could not be found
	 */
	@Override
	public EmployeeWorkArea findByEmployeeId_First(
			long employeeId,
			OrderByComparator<EmployeeWorkArea> orderByComparator)
		throws NoSuchEmployeeWorkAreaException {

		EmployeeWorkArea employeeWorkArea = fetchByEmployeeId_First(
			employeeId, orderByComparator);

		if (employeeWorkArea != null) {
			return employeeWorkArea;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeeWorkAreaException(sb.toString());
	}

	/**
	 * Returns the first employee work area in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee work area, or <code>null</code> if a matching employee work area could not be found
	 */
	@Override
	public EmployeeWorkArea fetchByEmployeeId_First(
		long employeeId,
		OrderByComparator<EmployeeWorkArea> orderByComparator) {

		List<EmployeeWorkArea> list = findByEmployeeId(
			employeeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee work area in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee work area
	 * @throws NoSuchEmployeeWorkAreaException if a matching employee work area could not be found
	 */
	@Override
	public EmployeeWorkArea findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<EmployeeWorkArea> orderByComparator)
		throws NoSuchEmployeeWorkAreaException {

		EmployeeWorkArea employeeWorkArea = fetchByEmployeeId_Last(
			employeeId, orderByComparator);

		if (employeeWorkArea != null) {
			return employeeWorkArea;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeeWorkAreaException(sb.toString());
	}

	/**
	 * Returns the last employee work area in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee work area, or <code>null</code> if a matching employee work area could not be found
	 */
	@Override
	public EmployeeWorkArea fetchByEmployeeId_Last(
		long employeeId,
		OrderByComparator<EmployeeWorkArea> orderByComparator) {

		int count = countByEmployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<EmployeeWorkArea> list = findByEmployeeId(
			employeeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee work areas before and after the current employee work area in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeWorkAreaId the primary key of the current employee work area
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee work area
	 * @throws NoSuchEmployeeWorkAreaException if a employee work area with the primary key could not be found
	 */
	@Override
	public EmployeeWorkArea[] findByEmployeeId_PrevAndNext(
			long employeeWorkAreaId, long employeeId,
			OrderByComparator<EmployeeWorkArea> orderByComparator)
		throws NoSuchEmployeeWorkAreaException {

		EmployeeWorkArea employeeWorkArea = findByPrimaryKey(
			employeeWorkAreaId);

		Session session = null;

		try {
			session = openSession();

			EmployeeWorkArea[] array = new EmployeeWorkAreaImpl[3];

			array[0] = getByEmployeeId_PrevAndNext(
				session, employeeWorkArea, employeeId, orderByComparator, true);

			array[1] = employeeWorkArea;

			array[2] = getByEmployeeId_PrevAndNext(
				session, employeeWorkArea, employeeId, orderByComparator,
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

	protected EmployeeWorkArea getByEmployeeId_PrevAndNext(
		Session session, EmployeeWorkArea employeeWorkArea, long employeeId,
		OrderByComparator<EmployeeWorkArea> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEWORKAREA_WHERE);

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
			sb.append(EmployeeWorkAreaModelImpl.ORDER_BY_JPQL);
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
						employeeWorkArea)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeWorkArea> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee work areas where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeByEmployeeId(long employeeId) {
		for (EmployeeWorkArea employeeWorkArea :
				findByEmployeeId(
					employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeeWorkArea);
		}
	}

	/**
	 * Returns the number of employee work areas where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee work areas
	 */
	@Override
	public int countByEmployeeId(long employeeId) {
		FinderPath finderPath = _finderPathCountByEmployeeId;

		Object[] finderArgs = new Object[] {employeeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEWORKAREA_WHERE);

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
		"employeeWorkArea.employeeId = ?";

	private FinderPath _finderPathWithPaginationFindByWorkAreaMajorId;
	private FinderPath _finderPathWithoutPaginationFindByWorkAreaMajorId;
	private FinderPath _finderPathCountByWorkAreaMajorId;

	/**
	 * Returns all the employee work areas where workAreaMajorId = &#63;.
	 *
	 * @param workAreaMajorId the work area major ID
	 * @return the matching employee work areas
	 */
	@Override
	public List<EmployeeWorkArea> findByWorkAreaMajorId(long workAreaMajorId) {
		return findByWorkAreaMajorId(
			workAreaMajorId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee work areas where workAreaMajorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeWorkAreaModelImpl</code>.
	 * </p>
	 *
	 * @param workAreaMajorId the work area major ID
	 * @param start the lower bound of the range of employee work areas
	 * @param end the upper bound of the range of employee work areas (not inclusive)
	 * @return the range of matching employee work areas
	 */
	@Override
	public List<EmployeeWorkArea> findByWorkAreaMajorId(
		long workAreaMajorId, int start, int end) {

		return findByWorkAreaMajorId(workAreaMajorId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee work areas where workAreaMajorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeWorkAreaModelImpl</code>.
	 * </p>
	 *
	 * @param workAreaMajorId the work area major ID
	 * @param start the lower bound of the range of employee work areas
	 * @param end the upper bound of the range of employee work areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee work areas
	 */
	@Override
	public List<EmployeeWorkArea> findByWorkAreaMajorId(
		long workAreaMajorId, int start, int end,
		OrderByComparator<EmployeeWorkArea> orderByComparator) {

		return findByWorkAreaMajorId(
			workAreaMajorId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee work areas where workAreaMajorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeWorkAreaModelImpl</code>.
	 * </p>
	 *
	 * @param workAreaMajorId the work area major ID
	 * @param start the lower bound of the range of employee work areas
	 * @param end the upper bound of the range of employee work areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee work areas
	 */
	@Override
	public List<EmployeeWorkArea> findByWorkAreaMajorId(
		long workAreaMajorId, int start, int end,
		OrderByComparator<EmployeeWorkArea> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByWorkAreaMajorId;
				finderArgs = new Object[] {workAreaMajorId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByWorkAreaMajorId;
			finderArgs = new Object[] {
				workAreaMajorId, start, end, orderByComparator
			};
		}

		List<EmployeeWorkArea> list = null;

		if (useFinderCache) {
			list = (List<EmployeeWorkArea>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeWorkArea employeeWorkArea : list) {
					if (workAreaMajorId !=
							employeeWorkArea.getWorkAreaMajorId()) {

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

			sb.append(_SQL_SELECT_EMPLOYEEWORKAREA_WHERE);

			sb.append(_FINDER_COLUMN_WORKAREAMAJORID_WORKAREAMAJORID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeWorkAreaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(workAreaMajorId);

				list = (List<EmployeeWorkArea>)QueryUtil.list(
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
	 * Returns the first employee work area in the ordered set where workAreaMajorId = &#63;.
	 *
	 * @param workAreaMajorId the work area major ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee work area
	 * @throws NoSuchEmployeeWorkAreaException if a matching employee work area could not be found
	 */
	@Override
	public EmployeeWorkArea findByWorkAreaMajorId_First(
			long workAreaMajorId,
			OrderByComparator<EmployeeWorkArea> orderByComparator)
		throws NoSuchEmployeeWorkAreaException {

		EmployeeWorkArea employeeWorkArea = fetchByWorkAreaMajorId_First(
			workAreaMajorId, orderByComparator);

		if (employeeWorkArea != null) {
			return employeeWorkArea;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("workAreaMajorId=");
		sb.append(workAreaMajorId);

		sb.append("}");

		throw new NoSuchEmployeeWorkAreaException(sb.toString());
	}

	/**
	 * Returns the first employee work area in the ordered set where workAreaMajorId = &#63;.
	 *
	 * @param workAreaMajorId the work area major ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee work area, or <code>null</code> if a matching employee work area could not be found
	 */
	@Override
	public EmployeeWorkArea fetchByWorkAreaMajorId_First(
		long workAreaMajorId,
		OrderByComparator<EmployeeWorkArea> orderByComparator) {

		List<EmployeeWorkArea> list = findByWorkAreaMajorId(
			workAreaMajorId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee work area in the ordered set where workAreaMajorId = &#63;.
	 *
	 * @param workAreaMajorId the work area major ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee work area
	 * @throws NoSuchEmployeeWorkAreaException if a matching employee work area could not be found
	 */
	@Override
	public EmployeeWorkArea findByWorkAreaMajorId_Last(
			long workAreaMajorId,
			OrderByComparator<EmployeeWorkArea> orderByComparator)
		throws NoSuchEmployeeWorkAreaException {

		EmployeeWorkArea employeeWorkArea = fetchByWorkAreaMajorId_Last(
			workAreaMajorId, orderByComparator);

		if (employeeWorkArea != null) {
			return employeeWorkArea;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("workAreaMajorId=");
		sb.append(workAreaMajorId);

		sb.append("}");

		throw new NoSuchEmployeeWorkAreaException(sb.toString());
	}

	/**
	 * Returns the last employee work area in the ordered set where workAreaMajorId = &#63;.
	 *
	 * @param workAreaMajorId the work area major ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee work area, or <code>null</code> if a matching employee work area could not be found
	 */
	@Override
	public EmployeeWorkArea fetchByWorkAreaMajorId_Last(
		long workAreaMajorId,
		OrderByComparator<EmployeeWorkArea> orderByComparator) {

		int count = countByWorkAreaMajorId(workAreaMajorId);

		if (count == 0) {
			return null;
		}

		List<EmployeeWorkArea> list = findByWorkAreaMajorId(
			workAreaMajorId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee work areas before and after the current employee work area in the ordered set where workAreaMajorId = &#63;.
	 *
	 * @param employeeWorkAreaId the primary key of the current employee work area
	 * @param workAreaMajorId the work area major ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee work area
	 * @throws NoSuchEmployeeWorkAreaException if a employee work area with the primary key could not be found
	 */
	@Override
	public EmployeeWorkArea[] findByWorkAreaMajorId_PrevAndNext(
			long employeeWorkAreaId, long workAreaMajorId,
			OrderByComparator<EmployeeWorkArea> orderByComparator)
		throws NoSuchEmployeeWorkAreaException {

		EmployeeWorkArea employeeWorkArea = findByPrimaryKey(
			employeeWorkAreaId);

		Session session = null;

		try {
			session = openSession();

			EmployeeWorkArea[] array = new EmployeeWorkAreaImpl[3];

			array[0] = getByWorkAreaMajorId_PrevAndNext(
				session, employeeWorkArea, workAreaMajorId, orderByComparator,
				true);

			array[1] = employeeWorkArea;

			array[2] = getByWorkAreaMajorId_PrevAndNext(
				session, employeeWorkArea, workAreaMajorId, orderByComparator,
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

	protected EmployeeWorkArea getByWorkAreaMajorId_PrevAndNext(
		Session session, EmployeeWorkArea employeeWorkArea,
		long workAreaMajorId,
		OrderByComparator<EmployeeWorkArea> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEWORKAREA_WHERE);

		sb.append(_FINDER_COLUMN_WORKAREAMAJORID_WORKAREAMAJORID_2);

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
			sb.append(EmployeeWorkAreaModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(workAreaMajorId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						employeeWorkArea)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeWorkArea> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee work areas where workAreaMajorId = &#63; from the database.
	 *
	 * @param workAreaMajorId the work area major ID
	 */
	@Override
	public void removeByWorkAreaMajorId(long workAreaMajorId) {
		for (EmployeeWorkArea employeeWorkArea :
				findByWorkAreaMajorId(
					workAreaMajorId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(employeeWorkArea);
		}
	}

	/**
	 * Returns the number of employee work areas where workAreaMajorId = &#63;.
	 *
	 * @param workAreaMajorId the work area major ID
	 * @return the number of matching employee work areas
	 */
	@Override
	public int countByWorkAreaMajorId(long workAreaMajorId) {
		FinderPath finderPath = _finderPathCountByWorkAreaMajorId;

		Object[] finderArgs = new Object[] {workAreaMajorId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEWORKAREA_WHERE);

			sb.append(_FINDER_COLUMN_WORKAREAMAJORID_WORKAREAMAJORID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(workAreaMajorId);

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
		_FINDER_COLUMN_WORKAREAMAJORID_WORKAREAMAJORID_2 =
			"employeeWorkArea.workAreaMajorId = ?";

	public EmployeeWorkAreaPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(EmployeeWorkArea.class);

		setModelImplClass(EmployeeWorkAreaImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the employee work area in the entity cache if it is enabled.
	 *
	 * @param employeeWorkArea the employee work area
	 */
	@Override
	public void cacheResult(EmployeeWorkArea employeeWorkArea) {
		entityCache.putResult(
			EmployeeWorkAreaImpl.class, employeeWorkArea.getPrimaryKey(),
			employeeWorkArea);
	}

	/**
	 * Caches the employee work areas in the entity cache if it is enabled.
	 *
	 * @param employeeWorkAreas the employee work areas
	 */
	@Override
	public void cacheResult(List<EmployeeWorkArea> employeeWorkAreas) {
		for (EmployeeWorkArea employeeWorkArea : employeeWorkAreas) {
			if (entityCache.getResult(
					EmployeeWorkAreaImpl.class,
					employeeWorkArea.getPrimaryKey()) == null) {

				cacheResult(employeeWorkArea);
			}
		}
	}

	/**
	 * Clears the cache for all employee work areas.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmployeeWorkAreaImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the employee work area.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmployeeWorkArea employeeWorkArea) {
		entityCache.removeResult(EmployeeWorkAreaImpl.class, employeeWorkArea);
	}

	@Override
	public void clearCache(List<EmployeeWorkArea> employeeWorkAreas) {
		for (EmployeeWorkArea employeeWorkArea : employeeWorkAreas) {
			entityCache.removeResult(
				EmployeeWorkAreaImpl.class, employeeWorkArea);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EmployeeWorkAreaImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new employee work area with the primary key. Does not add the employee work area to the database.
	 *
	 * @param employeeWorkAreaId the primary key for the new employee work area
	 * @return the new employee work area
	 */
	@Override
	public EmployeeWorkArea create(long employeeWorkAreaId) {
		EmployeeWorkArea employeeWorkArea = new EmployeeWorkAreaImpl();

		employeeWorkArea.setNew(true);
		employeeWorkArea.setPrimaryKey(employeeWorkAreaId);

		employeeWorkArea.setCompanyId(CompanyThreadLocal.getCompanyId());

		return employeeWorkArea;
	}

	/**
	 * Removes the employee work area with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeWorkAreaId the primary key of the employee work area
	 * @return the employee work area that was removed
	 * @throws NoSuchEmployeeWorkAreaException if a employee work area with the primary key could not be found
	 */
	@Override
	public EmployeeWorkArea remove(long employeeWorkAreaId)
		throws NoSuchEmployeeWorkAreaException {

		return remove((Serializable)employeeWorkAreaId);
	}

	/**
	 * Removes the employee work area with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the employee work area
	 * @return the employee work area that was removed
	 * @throws NoSuchEmployeeWorkAreaException if a employee work area with the primary key could not be found
	 */
	@Override
	public EmployeeWorkArea remove(Serializable primaryKey)
		throws NoSuchEmployeeWorkAreaException {

		Session session = null;

		try {
			session = openSession();

			EmployeeWorkArea employeeWorkArea = (EmployeeWorkArea)session.get(
				EmployeeWorkAreaImpl.class, primaryKey);

			if (employeeWorkArea == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmployeeWorkAreaException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(employeeWorkArea);
		}
		catch (NoSuchEmployeeWorkAreaException noSuchEntityException) {
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
	protected EmployeeWorkArea removeImpl(EmployeeWorkArea employeeWorkArea) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(employeeWorkArea)) {
				employeeWorkArea = (EmployeeWorkArea)session.get(
					EmployeeWorkAreaImpl.class,
					employeeWorkArea.getPrimaryKeyObj());
			}

			if (employeeWorkArea != null) {
				session.delete(employeeWorkArea);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (employeeWorkArea != null) {
			clearCache(employeeWorkArea);
		}

		return employeeWorkArea;
	}

	@Override
	public EmployeeWorkArea updateImpl(EmployeeWorkArea employeeWorkArea) {
		boolean isNew = employeeWorkArea.isNew();

		if (!(employeeWorkArea instanceof EmployeeWorkAreaModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(employeeWorkArea.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					employeeWorkArea);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in employeeWorkArea proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EmployeeWorkArea implementation " +
					employeeWorkArea.getClass());
		}

		EmployeeWorkAreaModelImpl employeeWorkAreaModelImpl =
			(EmployeeWorkAreaModelImpl)employeeWorkArea;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (employeeWorkArea.getCreateDate() == null)) {
			if (serviceContext == null) {
				employeeWorkArea.setCreateDate(now);
			}
			else {
				employeeWorkArea.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!employeeWorkAreaModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				employeeWorkArea.setModifiedDate(now);
			}
			else {
				employeeWorkArea.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(employeeWorkArea);
			}
			else {
				employeeWorkArea = (EmployeeWorkArea)session.merge(
					employeeWorkArea);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EmployeeWorkAreaImpl.class, employeeWorkAreaModelImpl, false, true);

		if (isNew) {
			employeeWorkArea.setNew(false);
		}

		employeeWorkArea.resetOriginalValues();

		return employeeWorkArea;
	}

	/**
	 * Returns the employee work area with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee work area
	 * @return the employee work area
	 * @throws NoSuchEmployeeWorkAreaException if a employee work area with the primary key could not be found
	 */
	@Override
	public EmployeeWorkArea findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmployeeWorkAreaException {

		EmployeeWorkArea employeeWorkArea = fetchByPrimaryKey(primaryKey);

		if (employeeWorkArea == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmployeeWorkAreaException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return employeeWorkArea;
	}

	/**
	 * Returns the employee work area with the primary key or throws a <code>NoSuchEmployeeWorkAreaException</code> if it could not be found.
	 *
	 * @param employeeWorkAreaId the primary key of the employee work area
	 * @return the employee work area
	 * @throws NoSuchEmployeeWorkAreaException if a employee work area with the primary key could not be found
	 */
	@Override
	public EmployeeWorkArea findByPrimaryKey(long employeeWorkAreaId)
		throws NoSuchEmployeeWorkAreaException {

		return findByPrimaryKey((Serializable)employeeWorkAreaId);
	}

	/**
	 * Returns the employee work area with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeWorkAreaId the primary key of the employee work area
	 * @return the employee work area, or <code>null</code> if a employee work area with the primary key could not be found
	 */
	@Override
	public EmployeeWorkArea fetchByPrimaryKey(long employeeWorkAreaId) {
		return fetchByPrimaryKey((Serializable)employeeWorkAreaId);
	}

	/**
	 * Returns all the employee work areas.
	 *
	 * @return the employee work areas
	 */
	@Override
	public List<EmployeeWorkArea> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee work areas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeWorkAreaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee work areas
	 * @param end the upper bound of the range of employee work areas (not inclusive)
	 * @return the range of employee work areas
	 */
	@Override
	public List<EmployeeWorkArea> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee work areas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeWorkAreaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee work areas
	 * @param end the upper bound of the range of employee work areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee work areas
	 */
	@Override
	public List<EmployeeWorkArea> findAll(
		int start, int end,
		OrderByComparator<EmployeeWorkArea> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee work areas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeWorkAreaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee work areas
	 * @param end the upper bound of the range of employee work areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee work areas
	 */
	@Override
	public List<EmployeeWorkArea> findAll(
		int start, int end,
		OrderByComparator<EmployeeWorkArea> orderByComparator,
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

		List<EmployeeWorkArea> list = null;

		if (useFinderCache) {
			list = (List<EmployeeWorkArea>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EMPLOYEEWORKAREA);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLOYEEWORKAREA;

				sql = sql.concat(EmployeeWorkAreaModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EmployeeWorkArea>)QueryUtil.list(
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
	 * Removes all the employee work areas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EmployeeWorkArea employeeWorkArea : findAll()) {
			remove(employeeWorkArea);
		}
	}

	/**
	 * Returns the number of employee work areas.
	 *
	 * @return the number of employee work areas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_EMPLOYEEWORKAREA);

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
		return "employeeWorkAreaId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EMPLOYEEWORKAREA;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EmployeeWorkAreaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the employee work area persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new EmployeeWorkAreaModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", EmployeeWorkArea.class.getName()));

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

		_finderPathWithPaginationFindByWorkAreaMajorId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByWorkAreaMajorId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"workAreaMajorId"}, true);

		_finderPathWithoutPaginationFindByWorkAreaMajorId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByWorkAreaMajorId",
			new String[] {Long.class.getName()},
			new String[] {"workAreaMajorId"}, true);

		_finderPathCountByWorkAreaMajorId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByWorkAreaMajorId",
			new String[] {Long.class.getName()},
			new String[] {"workAreaMajorId"}, false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(EmployeeWorkAreaImpl.class.getName());

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

	private static final String _SQL_SELECT_EMPLOYEEWORKAREA =
		"SELECT employeeWorkArea FROM EmployeeWorkArea employeeWorkArea";

	private static final String _SQL_SELECT_EMPLOYEEWORKAREA_WHERE =
		"SELECT employeeWorkArea FROM EmployeeWorkArea employeeWorkArea WHERE ";

	private static final String _SQL_COUNT_EMPLOYEEWORKAREA =
		"SELECT COUNT(employeeWorkArea) FROM EmployeeWorkArea employeeWorkArea";

	private static final String _SQL_COUNT_EMPLOYEEWORKAREA_WHERE =
		"SELECT COUNT(employeeWorkArea) FROM EmployeeWorkArea employeeWorkArea WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "employeeWorkArea.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EmployeeWorkArea exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EmployeeWorkArea exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EmployeeWorkAreaPersistenceImpl.class);

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

	private static class EmployeeWorkAreaModelArgumentsResolver
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

			EmployeeWorkAreaModelImpl employeeWorkAreaModelImpl =
				(EmployeeWorkAreaModelImpl)baseModel;

			long columnBitmask = employeeWorkAreaModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					employeeWorkAreaModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						employeeWorkAreaModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					employeeWorkAreaModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			EmployeeWorkAreaModelImpl employeeWorkAreaModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						employeeWorkAreaModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = employeeWorkAreaModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}