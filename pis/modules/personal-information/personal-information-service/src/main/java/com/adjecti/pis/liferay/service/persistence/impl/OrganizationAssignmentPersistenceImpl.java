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

import com.adjecti.pis.liferay.exception.NoSuchOrganizationAssignmentException;
import com.adjecti.pis.liferay.model.OrganizationAssignment;
import com.adjecti.pis.liferay.model.impl.OrganizationAssignmentImpl;
import com.adjecti.pis.liferay.model.impl.OrganizationAssignmentModelImpl;
import com.adjecti.pis.liferay.service.persistence.OrganizationAssignmentPersistence;
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
 * The persistence implementation for the organization assignment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = OrganizationAssignmentPersistence.class)
public class OrganizationAssignmentPersistenceImpl
	extends BasePersistenceImpl<OrganizationAssignment>
	implements OrganizationAssignmentPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>OrganizationAssignmentUtil</code> to access the organization assignment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		OrganizationAssignmentImpl.class.getName();

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
	 * Returns all the organization assignments where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching organization assignments
	 */
	@Override
	public List<OrganizationAssignment> findByEmployeeId(long employeeId) {
		return findByEmployeeId(
			employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the organization assignments where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of organization assignments
	 * @param end the upper bound of the range of organization assignments (not inclusive)
	 * @return the range of matching organization assignments
	 */
	@Override
	public List<OrganizationAssignment> findByEmployeeId(
		long employeeId, int start, int end) {

		return findByEmployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the organization assignments where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of organization assignments
	 * @param end the upper bound of the range of organization assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization assignments
	 */
	@Override
	public List<OrganizationAssignment> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<OrganizationAssignment> orderByComparator) {

		return findByEmployeeId(
			employeeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the organization assignments where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of organization assignments
	 * @param end the upper bound of the range of organization assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization assignments
	 */
	@Override
	public List<OrganizationAssignment> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<OrganizationAssignment> orderByComparator,
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

		List<OrganizationAssignment> list = null;

		if (useFinderCache) {
			list = (List<OrganizationAssignment>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (OrganizationAssignment organizationAssignment : list) {
					if (employeeId != organizationAssignment.getEmployeeId()) {
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

			sb.append(_SQL_SELECT_ORGANIZATIONASSIGNMENT_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(OrganizationAssignmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				list = (List<OrganizationAssignment>)QueryUtil.list(
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
	 * Returns the first organization assignment in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a matching organization assignment could not be found
	 */
	@Override
	public OrganizationAssignment findByEmployeeId_First(
			long employeeId,
			OrderByComparator<OrganizationAssignment> orderByComparator)
		throws NoSuchOrganizationAssignmentException {

		OrganizationAssignment organizationAssignment = fetchByEmployeeId_First(
			employeeId, orderByComparator);

		if (organizationAssignment != null) {
			return organizationAssignment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchOrganizationAssignmentException(sb.toString());
	}

	/**
	 * Returns the first organization assignment in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization assignment, or <code>null</code> if a matching organization assignment could not be found
	 */
	@Override
	public OrganizationAssignment fetchByEmployeeId_First(
		long employeeId,
		OrderByComparator<OrganizationAssignment> orderByComparator) {

		List<OrganizationAssignment> list = findByEmployeeId(
			employeeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last organization assignment in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a matching organization assignment could not be found
	 */
	@Override
	public OrganizationAssignment findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<OrganizationAssignment> orderByComparator)
		throws NoSuchOrganizationAssignmentException {

		OrganizationAssignment organizationAssignment = fetchByEmployeeId_Last(
			employeeId, orderByComparator);

		if (organizationAssignment != null) {
			return organizationAssignment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchOrganizationAssignmentException(sb.toString());
	}

	/**
	 * Returns the last organization assignment in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization assignment, or <code>null</code> if a matching organization assignment could not be found
	 */
	@Override
	public OrganizationAssignment fetchByEmployeeId_Last(
		long employeeId,
		OrderByComparator<OrganizationAssignment> orderByComparator) {

		int count = countByEmployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<OrganizationAssignment> list = findByEmployeeId(
			employeeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the organization assignments before and after the current organization assignment in the ordered set where employeeId = &#63;.
	 *
	 * @param organizationAssignmentId the primary key of the current organization assignment
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a organization assignment with the primary key could not be found
	 */
	@Override
	public OrganizationAssignment[] findByEmployeeId_PrevAndNext(
			long organizationAssignmentId, long employeeId,
			OrderByComparator<OrganizationAssignment> orderByComparator)
		throws NoSuchOrganizationAssignmentException {

		OrganizationAssignment organizationAssignment = findByPrimaryKey(
			organizationAssignmentId);

		Session session = null;

		try {
			session = openSession();

			OrganizationAssignment[] array = new OrganizationAssignmentImpl[3];

			array[0] = getByEmployeeId_PrevAndNext(
				session, organizationAssignment, employeeId, orderByComparator,
				true);

			array[1] = organizationAssignment;

			array[2] = getByEmployeeId_PrevAndNext(
				session, organizationAssignment, employeeId, orderByComparator,
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

	protected OrganizationAssignment getByEmployeeId_PrevAndNext(
		Session session, OrganizationAssignment organizationAssignment,
		long employeeId,
		OrderByComparator<OrganizationAssignment> orderByComparator,
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

		sb.append(_SQL_SELECT_ORGANIZATIONASSIGNMENT_WHERE);

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
			sb.append(OrganizationAssignmentModelImpl.ORDER_BY_JPQL);
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
						organizationAssignment)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<OrganizationAssignment> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the organization assignments where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeByEmployeeId(long employeeId) {
		for (OrganizationAssignment organizationAssignment :
				findByEmployeeId(
					employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(organizationAssignment);
		}
	}

	/**
	 * Returns the number of organization assignments where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching organization assignments
	 */
	@Override
	public int countByEmployeeId(long employeeId) {
		FinderPath finderPath = _finderPathCountByEmployeeId;

		Object[] finderArgs = new Object[] {employeeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ORGANIZATIONASSIGNMENT_WHERE);

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
		"organizationAssignment.employeeId = ?";

	private FinderPath _finderPathWithPaginationFindByPersonalNo;
	private FinderPath _finderPathWithoutPaginationFindByPersonalNo;
	private FinderPath _finderPathCountByPersonalNo;

	/**
	 * Returns all the organization assignments where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @return the matching organization assignments
	 */
	@Override
	public List<OrganizationAssignment> findByPersonalNo(String personalNo) {
		return findByPersonalNo(
			personalNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the organization assignments where personalNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param personalNo the personal no
	 * @param start the lower bound of the range of organization assignments
	 * @param end the upper bound of the range of organization assignments (not inclusive)
	 * @return the range of matching organization assignments
	 */
	@Override
	public List<OrganizationAssignment> findByPersonalNo(
		String personalNo, int start, int end) {

		return findByPersonalNo(personalNo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the organization assignments where personalNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param personalNo the personal no
	 * @param start the lower bound of the range of organization assignments
	 * @param end the upper bound of the range of organization assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization assignments
	 */
	@Override
	public List<OrganizationAssignment> findByPersonalNo(
		String personalNo, int start, int end,
		OrderByComparator<OrganizationAssignment> orderByComparator) {

		return findByPersonalNo(
			personalNo, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the organization assignments where personalNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param personalNo the personal no
	 * @param start the lower bound of the range of organization assignments
	 * @param end the upper bound of the range of organization assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization assignments
	 */
	@Override
	public List<OrganizationAssignment> findByPersonalNo(
		String personalNo, int start, int end,
		OrderByComparator<OrganizationAssignment> orderByComparator,
		boolean useFinderCache) {

		personalNo = Objects.toString(personalNo, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByPersonalNo;
				finderArgs = new Object[] {personalNo};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByPersonalNo;
			finderArgs = new Object[] {
				personalNo, start, end, orderByComparator
			};
		}

		List<OrganizationAssignment> list = null;

		if (useFinderCache) {
			list = (List<OrganizationAssignment>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (OrganizationAssignment organizationAssignment : list) {
					if (!personalNo.equals(
							organizationAssignment.getPersonalNo())) {

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

			sb.append(_SQL_SELECT_ORGANIZATIONASSIGNMENT_WHERE);

			boolean bindPersonalNo = false;

			if (personalNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_PERSONALNO_PERSONALNO_3);
			}
			else {
				bindPersonalNo = true;

				sb.append(_FINDER_COLUMN_PERSONALNO_PERSONALNO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(OrganizationAssignmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPersonalNo) {
					queryPos.add(personalNo);
				}

				list = (List<OrganizationAssignment>)QueryUtil.list(
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
	 * Returns the first organization assignment in the ordered set where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a matching organization assignment could not be found
	 */
	@Override
	public OrganizationAssignment findByPersonalNo_First(
			String personalNo,
			OrderByComparator<OrganizationAssignment> orderByComparator)
		throws NoSuchOrganizationAssignmentException {

		OrganizationAssignment organizationAssignment = fetchByPersonalNo_First(
			personalNo, orderByComparator);

		if (organizationAssignment != null) {
			return organizationAssignment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("personalNo=");
		sb.append(personalNo);

		sb.append("}");

		throw new NoSuchOrganizationAssignmentException(sb.toString());
	}

	/**
	 * Returns the first organization assignment in the ordered set where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization assignment, or <code>null</code> if a matching organization assignment could not be found
	 */
	@Override
	public OrganizationAssignment fetchByPersonalNo_First(
		String personalNo,
		OrderByComparator<OrganizationAssignment> orderByComparator) {

		List<OrganizationAssignment> list = findByPersonalNo(
			personalNo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last organization assignment in the ordered set where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a matching organization assignment could not be found
	 */
	@Override
	public OrganizationAssignment findByPersonalNo_Last(
			String personalNo,
			OrderByComparator<OrganizationAssignment> orderByComparator)
		throws NoSuchOrganizationAssignmentException {

		OrganizationAssignment organizationAssignment = fetchByPersonalNo_Last(
			personalNo, orderByComparator);

		if (organizationAssignment != null) {
			return organizationAssignment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("personalNo=");
		sb.append(personalNo);

		sb.append("}");

		throw new NoSuchOrganizationAssignmentException(sb.toString());
	}

	/**
	 * Returns the last organization assignment in the ordered set where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization assignment, or <code>null</code> if a matching organization assignment could not be found
	 */
	@Override
	public OrganizationAssignment fetchByPersonalNo_Last(
		String personalNo,
		OrderByComparator<OrganizationAssignment> orderByComparator) {

		int count = countByPersonalNo(personalNo);

		if (count == 0) {
			return null;
		}

		List<OrganizationAssignment> list = findByPersonalNo(
			personalNo, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the organization assignments before and after the current organization assignment in the ordered set where personalNo = &#63;.
	 *
	 * @param organizationAssignmentId the primary key of the current organization assignment
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a organization assignment with the primary key could not be found
	 */
	@Override
	public OrganizationAssignment[] findByPersonalNo_PrevAndNext(
			long organizationAssignmentId, String personalNo,
			OrderByComparator<OrganizationAssignment> orderByComparator)
		throws NoSuchOrganizationAssignmentException {

		personalNo = Objects.toString(personalNo, "");

		OrganizationAssignment organizationAssignment = findByPrimaryKey(
			organizationAssignmentId);

		Session session = null;

		try {
			session = openSession();

			OrganizationAssignment[] array = new OrganizationAssignmentImpl[3];

			array[0] = getByPersonalNo_PrevAndNext(
				session, organizationAssignment, personalNo, orderByComparator,
				true);

			array[1] = organizationAssignment;

			array[2] = getByPersonalNo_PrevAndNext(
				session, organizationAssignment, personalNo, orderByComparator,
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

	protected OrganizationAssignment getByPersonalNo_PrevAndNext(
		Session session, OrganizationAssignment organizationAssignment,
		String personalNo,
		OrderByComparator<OrganizationAssignment> orderByComparator,
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

		sb.append(_SQL_SELECT_ORGANIZATIONASSIGNMENT_WHERE);

		boolean bindPersonalNo = false;

		if (personalNo.isEmpty()) {
			sb.append(_FINDER_COLUMN_PERSONALNO_PERSONALNO_3);
		}
		else {
			bindPersonalNo = true;

			sb.append(_FINDER_COLUMN_PERSONALNO_PERSONALNO_2);
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
			sb.append(OrganizationAssignmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindPersonalNo) {
			queryPos.add(personalNo);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						organizationAssignment)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<OrganizationAssignment> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the organization assignments where personalNo = &#63; from the database.
	 *
	 * @param personalNo the personal no
	 */
	@Override
	public void removeByPersonalNo(String personalNo) {
		for (OrganizationAssignment organizationAssignment :
				findByPersonalNo(
					personalNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(organizationAssignment);
		}
	}

	/**
	 * Returns the number of organization assignments where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @return the number of matching organization assignments
	 */
	@Override
	public int countByPersonalNo(String personalNo) {
		personalNo = Objects.toString(personalNo, "");

		FinderPath finderPath = _finderPathCountByPersonalNo;

		Object[] finderArgs = new Object[] {personalNo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ORGANIZATIONASSIGNMENT_WHERE);

			boolean bindPersonalNo = false;

			if (personalNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_PERSONALNO_PERSONALNO_3);
			}
			else {
				bindPersonalNo = true;

				sb.append(_FINDER_COLUMN_PERSONALNO_PERSONALNO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPersonalNo) {
					queryPos.add(personalNo);
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

	private static final String _FINDER_COLUMN_PERSONALNO_PERSONALNO_2 =
		"organizationAssignment.personalNo = ?";

	private static final String _FINDER_COLUMN_PERSONALNO_PERSONALNO_3 =
		"(organizationAssignment.personalNo IS NULL OR organizationAssignment.personalNo = '')";

	private FinderPath _finderPathWithPaginationFindByOrganizationId;
	private FinderPath _finderPathWithoutPaginationFindByOrganizationId;
	private FinderPath _finderPathCountByOrganizationId;

	/**
	 * Returns all the organization assignments where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching organization assignments
	 */
	@Override
	public List<OrganizationAssignment> findByOrganizationId(
		long organizationId) {

		return findByOrganizationId(
			organizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the organization assignments where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of organization assignments
	 * @param end the upper bound of the range of organization assignments (not inclusive)
	 * @return the range of matching organization assignments
	 */
	@Override
	public List<OrganizationAssignment> findByOrganizationId(
		long organizationId, int start, int end) {

		return findByOrganizationId(organizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the organization assignments where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of organization assignments
	 * @param end the upper bound of the range of organization assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization assignments
	 */
	@Override
	public List<OrganizationAssignment> findByOrganizationId(
		long organizationId, int start, int end,
		OrderByComparator<OrganizationAssignment> orderByComparator) {

		return findByOrganizationId(
			organizationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the organization assignments where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of organization assignments
	 * @param end the upper bound of the range of organization assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization assignments
	 */
	@Override
	public List<OrganizationAssignment> findByOrganizationId(
		long organizationId, int start, int end,
		OrderByComparator<OrganizationAssignment> orderByComparator,
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

		List<OrganizationAssignment> list = null;

		if (useFinderCache) {
			list = (List<OrganizationAssignment>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (OrganizationAssignment organizationAssignment : list) {
					if (organizationId !=
							organizationAssignment.getOrganizationId()) {

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

			sb.append(_SQL_SELECT_ORGANIZATIONASSIGNMENT_WHERE);

			sb.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(OrganizationAssignmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(organizationId);

				list = (List<OrganizationAssignment>)QueryUtil.list(
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
	 * Returns the first organization assignment in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a matching organization assignment could not be found
	 */
	@Override
	public OrganizationAssignment findByOrganizationId_First(
			long organizationId,
			OrderByComparator<OrganizationAssignment> orderByComparator)
		throws NoSuchOrganizationAssignmentException {

		OrganizationAssignment organizationAssignment =
			fetchByOrganizationId_First(organizationId, orderByComparator);

		if (organizationAssignment != null) {
			return organizationAssignment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("organizationId=");
		sb.append(organizationId);

		sb.append("}");

		throw new NoSuchOrganizationAssignmentException(sb.toString());
	}

	/**
	 * Returns the first organization assignment in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization assignment, or <code>null</code> if a matching organization assignment could not be found
	 */
	@Override
	public OrganizationAssignment fetchByOrganizationId_First(
		long organizationId,
		OrderByComparator<OrganizationAssignment> orderByComparator) {

		List<OrganizationAssignment> list = findByOrganizationId(
			organizationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last organization assignment in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a matching organization assignment could not be found
	 */
	@Override
	public OrganizationAssignment findByOrganizationId_Last(
			long organizationId,
			OrderByComparator<OrganizationAssignment> orderByComparator)
		throws NoSuchOrganizationAssignmentException {

		OrganizationAssignment organizationAssignment =
			fetchByOrganizationId_Last(organizationId, orderByComparator);

		if (organizationAssignment != null) {
			return organizationAssignment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("organizationId=");
		sb.append(organizationId);

		sb.append("}");

		throw new NoSuchOrganizationAssignmentException(sb.toString());
	}

	/**
	 * Returns the last organization assignment in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization assignment, or <code>null</code> if a matching organization assignment could not be found
	 */
	@Override
	public OrganizationAssignment fetchByOrganizationId_Last(
		long organizationId,
		OrderByComparator<OrganizationAssignment> orderByComparator) {

		int count = countByOrganizationId(organizationId);

		if (count == 0) {
			return null;
		}

		List<OrganizationAssignment> list = findByOrganizationId(
			organizationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the organization assignments before and after the current organization assignment in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationAssignmentId the primary key of the current organization assignment
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a organization assignment with the primary key could not be found
	 */
	@Override
	public OrganizationAssignment[] findByOrganizationId_PrevAndNext(
			long organizationAssignmentId, long organizationId,
			OrderByComparator<OrganizationAssignment> orderByComparator)
		throws NoSuchOrganizationAssignmentException {

		OrganizationAssignment organizationAssignment = findByPrimaryKey(
			organizationAssignmentId);

		Session session = null;

		try {
			session = openSession();

			OrganizationAssignment[] array = new OrganizationAssignmentImpl[3];

			array[0] = getByOrganizationId_PrevAndNext(
				session, organizationAssignment, organizationId,
				orderByComparator, true);

			array[1] = organizationAssignment;

			array[2] = getByOrganizationId_PrevAndNext(
				session, organizationAssignment, organizationId,
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

	protected OrganizationAssignment getByOrganizationId_PrevAndNext(
		Session session, OrganizationAssignment organizationAssignment,
		long organizationId,
		OrderByComparator<OrganizationAssignment> orderByComparator,
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

		sb.append(_SQL_SELECT_ORGANIZATIONASSIGNMENT_WHERE);

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
			sb.append(OrganizationAssignmentModelImpl.ORDER_BY_JPQL);
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
						organizationAssignment)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<OrganizationAssignment> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the organization assignments where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	@Override
	public void removeByOrganizationId(long organizationId) {
		for (OrganizationAssignment organizationAssignment :
				findByOrganizationId(
					organizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(organizationAssignment);
		}
	}

	/**
	 * Returns the number of organization assignments where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching organization assignments
	 */
	@Override
	public int countByOrganizationId(long organizationId) {
		FinderPath finderPath = _finderPathCountByOrganizationId;

		Object[] finderArgs = new Object[] {organizationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ORGANIZATIONASSIGNMENT_WHERE);

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
		"organizationAssignment.organizationId = ?";

	private FinderPath _finderPathWithPaginationFindByOrganizationCode;
	private FinderPath _finderPathWithoutPaginationFindByOrganizationCode;
	private FinderPath _finderPathCountByOrganizationCode;

	/**
	 * Returns all the organization assignments where organizationCode = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @return the matching organization assignments
	 */
	@Override
	public List<OrganizationAssignment> findByOrganizationCode(
		String organizationCode) {

		return findByOrganizationCode(
			organizationCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the organization assignments where organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of organization assignments
	 * @param end the upper bound of the range of organization assignments (not inclusive)
	 * @return the range of matching organization assignments
	 */
	@Override
	public List<OrganizationAssignment> findByOrganizationCode(
		String organizationCode, int start, int end) {

		return findByOrganizationCode(organizationCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the organization assignments where organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of organization assignments
	 * @param end the upper bound of the range of organization assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization assignments
	 */
	@Override
	public List<OrganizationAssignment> findByOrganizationCode(
		String organizationCode, int start, int end,
		OrderByComparator<OrganizationAssignment> orderByComparator) {

		return findByOrganizationCode(
			organizationCode, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the organization assignments where organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of organization assignments
	 * @param end the upper bound of the range of organization assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization assignments
	 */
	@Override
	public List<OrganizationAssignment> findByOrganizationCode(
		String organizationCode, int start, int end,
		OrderByComparator<OrganizationAssignment> orderByComparator,
		boolean useFinderCache) {

		organizationCode = Objects.toString(organizationCode, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByOrganizationCode;
				finderArgs = new Object[] {organizationCode};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByOrganizationCode;
			finderArgs = new Object[] {
				organizationCode, start, end, orderByComparator
			};
		}

		List<OrganizationAssignment> list = null;

		if (useFinderCache) {
			list = (List<OrganizationAssignment>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (OrganizationAssignment organizationAssignment : list) {
					if (!organizationCode.equals(
							organizationAssignment.getOrganizationCode())) {

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

			sb.append(_SQL_SELECT_ORGANIZATIONASSIGNMENT_WHERE);

			boolean bindOrganizationCode = false;

			if (organizationCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_ORGANIZATIONCODE_ORGANIZATIONCODE_3);
			}
			else {
				bindOrganizationCode = true;

				sb.append(_FINDER_COLUMN_ORGANIZATIONCODE_ORGANIZATIONCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(OrganizationAssignmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindOrganizationCode) {
					queryPos.add(organizationCode);
				}

				list = (List<OrganizationAssignment>)QueryUtil.list(
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
	 * Returns the first organization assignment in the ordered set where organizationCode = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a matching organization assignment could not be found
	 */
	@Override
	public OrganizationAssignment findByOrganizationCode_First(
			String organizationCode,
			OrderByComparator<OrganizationAssignment> orderByComparator)
		throws NoSuchOrganizationAssignmentException {

		OrganizationAssignment organizationAssignment =
			fetchByOrganizationCode_First(organizationCode, orderByComparator);

		if (organizationAssignment != null) {
			return organizationAssignment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("organizationCode=");
		sb.append(organizationCode);

		sb.append("}");

		throw new NoSuchOrganizationAssignmentException(sb.toString());
	}

	/**
	 * Returns the first organization assignment in the ordered set where organizationCode = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization assignment, or <code>null</code> if a matching organization assignment could not be found
	 */
	@Override
	public OrganizationAssignment fetchByOrganizationCode_First(
		String organizationCode,
		OrderByComparator<OrganizationAssignment> orderByComparator) {

		List<OrganizationAssignment> list = findByOrganizationCode(
			organizationCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last organization assignment in the ordered set where organizationCode = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a matching organization assignment could not be found
	 */
	@Override
	public OrganizationAssignment findByOrganizationCode_Last(
			String organizationCode,
			OrderByComparator<OrganizationAssignment> orderByComparator)
		throws NoSuchOrganizationAssignmentException {

		OrganizationAssignment organizationAssignment =
			fetchByOrganizationCode_Last(organizationCode, orderByComparator);

		if (organizationAssignment != null) {
			return organizationAssignment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("organizationCode=");
		sb.append(organizationCode);

		sb.append("}");

		throw new NoSuchOrganizationAssignmentException(sb.toString());
	}

	/**
	 * Returns the last organization assignment in the ordered set where organizationCode = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization assignment, or <code>null</code> if a matching organization assignment could not be found
	 */
	@Override
	public OrganizationAssignment fetchByOrganizationCode_Last(
		String organizationCode,
		OrderByComparator<OrganizationAssignment> orderByComparator) {

		int count = countByOrganizationCode(organizationCode);

		if (count == 0) {
			return null;
		}

		List<OrganizationAssignment> list = findByOrganizationCode(
			organizationCode, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the organization assignments before and after the current organization assignment in the ordered set where organizationCode = &#63;.
	 *
	 * @param organizationAssignmentId the primary key of the current organization assignment
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a organization assignment with the primary key could not be found
	 */
	@Override
	public OrganizationAssignment[] findByOrganizationCode_PrevAndNext(
			long organizationAssignmentId, String organizationCode,
			OrderByComparator<OrganizationAssignment> orderByComparator)
		throws NoSuchOrganizationAssignmentException {

		organizationCode = Objects.toString(organizationCode, "");

		OrganizationAssignment organizationAssignment = findByPrimaryKey(
			organizationAssignmentId);

		Session session = null;

		try {
			session = openSession();

			OrganizationAssignment[] array = new OrganizationAssignmentImpl[3];

			array[0] = getByOrganizationCode_PrevAndNext(
				session, organizationAssignment, organizationCode,
				orderByComparator, true);

			array[1] = organizationAssignment;

			array[2] = getByOrganizationCode_PrevAndNext(
				session, organizationAssignment, organizationCode,
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

	protected OrganizationAssignment getByOrganizationCode_PrevAndNext(
		Session session, OrganizationAssignment organizationAssignment,
		String organizationCode,
		OrderByComparator<OrganizationAssignment> orderByComparator,
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

		sb.append(_SQL_SELECT_ORGANIZATIONASSIGNMENT_WHERE);

		boolean bindOrganizationCode = false;

		if (organizationCode.isEmpty()) {
			sb.append(_FINDER_COLUMN_ORGANIZATIONCODE_ORGANIZATIONCODE_3);
		}
		else {
			bindOrganizationCode = true;

			sb.append(_FINDER_COLUMN_ORGANIZATIONCODE_ORGANIZATIONCODE_2);
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
			sb.append(OrganizationAssignmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindOrganizationCode) {
			queryPos.add(organizationCode);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						organizationAssignment)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<OrganizationAssignment> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the organization assignments where organizationCode = &#63; from the database.
	 *
	 * @param organizationCode the organization code
	 */
	@Override
	public void removeByOrganizationCode(String organizationCode) {
		for (OrganizationAssignment organizationAssignment :
				findByOrganizationCode(
					organizationCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(organizationAssignment);
		}
	}

	/**
	 * Returns the number of organization assignments where organizationCode = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @return the number of matching organization assignments
	 */
	@Override
	public int countByOrganizationCode(String organizationCode) {
		organizationCode = Objects.toString(organizationCode, "");

		FinderPath finderPath = _finderPathCountByOrganizationCode;

		Object[] finderArgs = new Object[] {organizationCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ORGANIZATIONASSIGNMENT_WHERE);

			boolean bindOrganizationCode = false;

			if (organizationCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_ORGANIZATIONCODE_ORGANIZATIONCODE_3);
			}
			else {
				bindOrganizationCode = true;

				sb.append(_FINDER_COLUMN_ORGANIZATIONCODE_ORGANIZATIONCODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindOrganizationCode) {
					queryPos.add(organizationCode);
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

	private static final String
		_FINDER_COLUMN_ORGANIZATIONCODE_ORGANIZATIONCODE_2 =
			"organizationAssignment.organizationCode = ?";

	private static final String
		_FINDER_COLUMN_ORGANIZATIONCODE_ORGANIZATIONCODE_3 =
			"(organizationAssignment.organizationCode IS NULL OR organizationAssignment.organizationCode = '')";

	private FinderPath _finderPathWithPaginationFindBySubOrganizationId;
	private FinderPath _finderPathWithoutPaginationFindBySubOrganizationId;
	private FinderPath _finderPathCountBySubOrganizationId;

	/**
	 * Returns all the organization assignments where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @return the matching organization assignments
	 */
	@Override
	public List<OrganizationAssignment> findBySubOrganizationId(
		long subOrganizationId) {

		return findBySubOrganizationId(
			subOrganizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the organization assignments where subOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param start the lower bound of the range of organization assignments
	 * @param end the upper bound of the range of organization assignments (not inclusive)
	 * @return the range of matching organization assignments
	 */
	@Override
	public List<OrganizationAssignment> findBySubOrganizationId(
		long subOrganizationId, int start, int end) {

		return findBySubOrganizationId(subOrganizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the organization assignments where subOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param start the lower bound of the range of organization assignments
	 * @param end the upper bound of the range of organization assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization assignments
	 */
	@Override
	public List<OrganizationAssignment> findBySubOrganizationId(
		long subOrganizationId, int start, int end,
		OrderByComparator<OrganizationAssignment> orderByComparator) {

		return findBySubOrganizationId(
			subOrganizationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the organization assignments where subOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param start the lower bound of the range of organization assignments
	 * @param end the upper bound of the range of organization assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization assignments
	 */
	@Override
	public List<OrganizationAssignment> findBySubOrganizationId(
		long subOrganizationId, int start, int end,
		OrderByComparator<OrganizationAssignment> orderByComparator,
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

		List<OrganizationAssignment> list = null;

		if (useFinderCache) {
			list = (List<OrganizationAssignment>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (OrganizationAssignment organizationAssignment : list) {
					if (subOrganizationId !=
							organizationAssignment.getSubOrganizationId()) {

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

			sb.append(_SQL_SELECT_ORGANIZATIONASSIGNMENT_WHERE);

			sb.append(_FINDER_COLUMN_SUBORGANIZATIONID_SUBORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(OrganizationAssignmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(subOrganizationId);

				list = (List<OrganizationAssignment>)QueryUtil.list(
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
	 * Returns the first organization assignment in the ordered set where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a matching organization assignment could not be found
	 */
	@Override
	public OrganizationAssignment findBySubOrganizationId_First(
			long subOrganizationId,
			OrderByComparator<OrganizationAssignment> orderByComparator)
		throws NoSuchOrganizationAssignmentException {

		OrganizationAssignment organizationAssignment =
			fetchBySubOrganizationId_First(
				subOrganizationId, orderByComparator);

		if (organizationAssignment != null) {
			return organizationAssignment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("subOrganizationId=");
		sb.append(subOrganizationId);

		sb.append("}");

		throw new NoSuchOrganizationAssignmentException(sb.toString());
	}

	/**
	 * Returns the first organization assignment in the ordered set where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization assignment, or <code>null</code> if a matching organization assignment could not be found
	 */
	@Override
	public OrganizationAssignment fetchBySubOrganizationId_First(
		long subOrganizationId,
		OrderByComparator<OrganizationAssignment> orderByComparator) {

		List<OrganizationAssignment> list = findBySubOrganizationId(
			subOrganizationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last organization assignment in the ordered set where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a matching organization assignment could not be found
	 */
	@Override
	public OrganizationAssignment findBySubOrganizationId_Last(
			long subOrganizationId,
			OrderByComparator<OrganizationAssignment> orderByComparator)
		throws NoSuchOrganizationAssignmentException {

		OrganizationAssignment organizationAssignment =
			fetchBySubOrganizationId_Last(subOrganizationId, orderByComparator);

		if (organizationAssignment != null) {
			return organizationAssignment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("subOrganizationId=");
		sb.append(subOrganizationId);

		sb.append("}");

		throw new NoSuchOrganizationAssignmentException(sb.toString());
	}

	/**
	 * Returns the last organization assignment in the ordered set where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization assignment, or <code>null</code> if a matching organization assignment could not be found
	 */
	@Override
	public OrganizationAssignment fetchBySubOrganizationId_Last(
		long subOrganizationId,
		OrderByComparator<OrganizationAssignment> orderByComparator) {

		int count = countBySubOrganizationId(subOrganizationId);

		if (count == 0) {
			return null;
		}

		List<OrganizationAssignment> list = findBySubOrganizationId(
			subOrganizationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the organization assignments before and after the current organization assignment in the ordered set where subOrganizationId = &#63;.
	 *
	 * @param organizationAssignmentId the primary key of the current organization assignment
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a organization assignment with the primary key could not be found
	 */
	@Override
	public OrganizationAssignment[] findBySubOrganizationId_PrevAndNext(
			long organizationAssignmentId, long subOrganizationId,
			OrderByComparator<OrganizationAssignment> orderByComparator)
		throws NoSuchOrganizationAssignmentException {

		OrganizationAssignment organizationAssignment = findByPrimaryKey(
			organizationAssignmentId);

		Session session = null;

		try {
			session = openSession();

			OrganizationAssignment[] array = new OrganizationAssignmentImpl[3];

			array[0] = getBySubOrganizationId_PrevAndNext(
				session, organizationAssignment, subOrganizationId,
				orderByComparator, true);

			array[1] = organizationAssignment;

			array[2] = getBySubOrganizationId_PrevAndNext(
				session, organizationAssignment, subOrganizationId,
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

	protected OrganizationAssignment getBySubOrganizationId_PrevAndNext(
		Session session, OrganizationAssignment organizationAssignment,
		long subOrganizationId,
		OrderByComparator<OrganizationAssignment> orderByComparator,
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

		sb.append(_SQL_SELECT_ORGANIZATIONASSIGNMENT_WHERE);

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
			sb.append(OrganizationAssignmentModelImpl.ORDER_BY_JPQL);
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
						organizationAssignment)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<OrganizationAssignment> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the organization assignments where subOrganizationId = &#63; from the database.
	 *
	 * @param subOrganizationId the sub organization ID
	 */
	@Override
	public void removeBySubOrganizationId(long subOrganizationId) {
		for (OrganizationAssignment organizationAssignment :
				findBySubOrganizationId(
					subOrganizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(organizationAssignment);
		}
	}

	/**
	 * Returns the number of organization assignments where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @return the number of matching organization assignments
	 */
	@Override
	public int countBySubOrganizationId(long subOrganizationId) {
		FinderPath finderPath = _finderPathCountBySubOrganizationId;

		Object[] finderArgs = new Object[] {subOrganizationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ORGANIZATIONASSIGNMENT_WHERE);

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
			"organizationAssignment.subOrganizationId = ?";

	private FinderPath _finderPathWithPaginationFindBySubOrganizationCode;
	private FinderPath _finderPathWithoutPaginationFindBySubOrganizationCode;
	private FinderPath _finderPathCountBySubOrganizationCode;

	/**
	 * Returns all the organization assignments where subOrganizationCode = &#63;.
	 *
	 * @param subOrganizationCode the sub organization code
	 * @return the matching organization assignments
	 */
	@Override
	public List<OrganizationAssignment> findBySubOrganizationCode(
		String subOrganizationCode) {

		return findBySubOrganizationCode(
			subOrganizationCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the organization assignments where subOrganizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param subOrganizationCode the sub organization code
	 * @param start the lower bound of the range of organization assignments
	 * @param end the upper bound of the range of organization assignments (not inclusive)
	 * @return the range of matching organization assignments
	 */
	@Override
	public List<OrganizationAssignment> findBySubOrganizationCode(
		String subOrganizationCode, int start, int end) {

		return findBySubOrganizationCode(subOrganizationCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the organization assignments where subOrganizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param subOrganizationCode the sub organization code
	 * @param start the lower bound of the range of organization assignments
	 * @param end the upper bound of the range of organization assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization assignments
	 */
	@Override
	public List<OrganizationAssignment> findBySubOrganizationCode(
		String subOrganizationCode, int start, int end,
		OrderByComparator<OrganizationAssignment> orderByComparator) {

		return findBySubOrganizationCode(
			subOrganizationCode, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the organization assignments where subOrganizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param subOrganizationCode the sub organization code
	 * @param start the lower bound of the range of organization assignments
	 * @param end the upper bound of the range of organization assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization assignments
	 */
	@Override
	public List<OrganizationAssignment> findBySubOrganizationCode(
		String subOrganizationCode, int start, int end,
		OrderByComparator<OrganizationAssignment> orderByComparator,
		boolean useFinderCache) {

		subOrganizationCode = Objects.toString(subOrganizationCode, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBySubOrganizationCode;
				finderArgs = new Object[] {subOrganizationCode};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBySubOrganizationCode;
			finderArgs = new Object[] {
				subOrganizationCode, start, end, orderByComparator
			};
		}

		List<OrganizationAssignment> list = null;

		if (useFinderCache) {
			list = (List<OrganizationAssignment>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (OrganizationAssignment organizationAssignment : list) {
					if (!subOrganizationCode.equals(
							organizationAssignment.getSubOrganizationCode())) {

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

			sb.append(_SQL_SELECT_ORGANIZATIONASSIGNMENT_WHERE);

			boolean bindSubOrganizationCode = false;

			if (subOrganizationCode.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_SUBORGANIZATIONCODE_SUBORGANIZATIONCODE_3);
			}
			else {
				bindSubOrganizationCode = true;

				sb.append(
					_FINDER_COLUMN_SUBORGANIZATIONCODE_SUBORGANIZATIONCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(OrganizationAssignmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindSubOrganizationCode) {
					queryPos.add(subOrganizationCode);
				}

				list = (List<OrganizationAssignment>)QueryUtil.list(
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
	 * Returns the first organization assignment in the ordered set where subOrganizationCode = &#63;.
	 *
	 * @param subOrganizationCode the sub organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a matching organization assignment could not be found
	 */
	@Override
	public OrganizationAssignment findBySubOrganizationCode_First(
			String subOrganizationCode,
			OrderByComparator<OrganizationAssignment> orderByComparator)
		throws NoSuchOrganizationAssignmentException {

		OrganizationAssignment organizationAssignment =
			fetchBySubOrganizationCode_First(
				subOrganizationCode, orderByComparator);

		if (organizationAssignment != null) {
			return organizationAssignment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("subOrganizationCode=");
		sb.append(subOrganizationCode);

		sb.append("}");

		throw new NoSuchOrganizationAssignmentException(sb.toString());
	}

	/**
	 * Returns the first organization assignment in the ordered set where subOrganizationCode = &#63;.
	 *
	 * @param subOrganizationCode the sub organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization assignment, or <code>null</code> if a matching organization assignment could not be found
	 */
	@Override
	public OrganizationAssignment fetchBySubOrganizationCode_First(
		String subOrganizationCode,
		OrderByComparator<OrganizationAssignment> orderByComparator) {

		List<OrganizationAssignment> list = findBySubOrganizationCode(
			subOrganizationCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last organization assignment in the ordered set where subOrganizationCode = &#63;.
	 *
	 * @param subOrganizationCode the sub organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a matching organization assignment could not be found
	 */
	@Override
	public OrganizationAssignment findBySubOrganizationCode_Last(
			String subOrganizationCode,
			OrderByComparator<OrganizationAssignment> orderByComparator)
		throws NoSuchOrganizationAssignmentException {

		OrganizationAssignment organizationAssignment =
			fetchBySubOrganizationCode_Last(
				subOrganizationCode, orderByComparator);

		if (organizationAssignment != null) {
			return organizationAssignment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("subOrganizationCode=");
		sb.append(subOrganizationCode);

		sb.append("}");

		throw new NoSuchOrganizationAssignmentException(sb.toString());
	}

	/**
	 * Returns the last organization assignment in the ordered set where subOrganizationCode = &#63;.
	 *
	 * @param subOrganizationCode the sub organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization assignment, or <code>null</code> if a matching organization assignment could not be found
	 */
	@Override
	public OrganizationAssignment fetchBySubOrganizationCode_Last(
		String subOrganizationCode,
		OrderByComparator<OrganizationAssignment> orderByComparator) {

		int count = countBySubOrganizationCode(subOrganizationCode);

		if (count == 0) {
			return null;
		}

		List<OrganizationAssignment> list = findBySubOrganizationCode(
			subOrganizationCode, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the organization assignments before and after the current organization assignment in the ordered set where subOrganizationCode = &#63;.
	 *
	 * @param organizationAssignmentId the primary key of the current organization assignment
	 * @param subOrganizationCode the sub organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a organization assignment with the primary key could not be found
	 */
	@Override
	public OrganizationAssignment[] findBySubOrganizationCode_PrevAndNext(
			long organizationAssignmentId, String subOrganizationCode,
			OrderByComparator<OrganizationAssignment> orderByComparator)
		throws NoSuchOrganizationAssignmentException {

		subOrganizationCode = Objects.toString(subOrganizationCode, "");

		OrganizationAssignment organizationAssignment = findByPrimaryKey(
			organizationAssignmentId);

		Session session = null;

		try {
			session = openSession();

			OrganizationAssignment[] array = new OrganizationAssignmentImpl[3];

			array[0] = getBySubOrganizationCode_PrevAndNext(
				session, organizationAssignment, subOrganizationCode,
				orderByComparator, true);

			array[1] = organizationAssignment;

			array[2] = getBySubOrganizationCode_PrevAndNext(
				session, organizationAssignment, subOrganizationCode,
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

	protected OrganizationAssignment getBySubOrganizationCode_PrevAndNext(
		Session session, OrganizationAssignment organizationAssignment,
		String subOrganizationCode,
		OrderByComparator<OrganizationAssignment> orderByComparator,
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

		sb.append(_SQL_SELECT_ORGANIZATIONASSIGNMENT_WHERE);

		boolean bindSubOrganizationCode = false;

		if (subOrganizationCode.isEmpty()) {
			sb.append(_FINDER_COLUMN_SUBORGANIZATIONCODE_SUBORGANIZATIONCODE_3);
		}
		else {
			bindSubOrganizationCode = true;

			sb.append(_FINDER_COLUMN_SUBORGANIZATIONCODE_SUBORGANIZATIONCODE_2);
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
			sb.append(OrganizationAssignmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindSubOrganizationCode) {
			queryPos.add(subOrganizationCode);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						organizationAssignment)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<OrganizationAssignment> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the organization assignments where subOrganizationCode = &#63; from the database.
	 *
	 * @param subOrganizationCode the sub organization code
	 */
	@Override
	public void removeBySubOrganizationCode(String subOrganizationCode) {
		for (OrganizationAssignment organizationAssignment :
				findBySubOrganizationCode(
					subOrganizationCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(organizationAssignment);
		}
	}

	/**
	 * Returns the number of organization assignments where subOrganizationCode = &#63;.
	 *
	 * @param subOrganizationCode the sub organization code
	 * @return the number of matching organization assignments
	 */
	@Override
	public int countBySubOrganizationCode(String subOrganizationCode) {
		subOrganizationCode = Objects.toString(subOrganizationCode, "");

		FinderPath finderPath = _finderPathCountBySubOrganizationCode;

		Object[] finderArgs = new Object[] {subOrganizationCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ORGANIZATIONASSIGNMENT_WHERE);

			boolean bindSubOrganizationCode = false;

			if (subOrganizationCode.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_SUBORGANIZATIONCODE_SUBORGANIZATIONCODE_3);
			}
			else {
				bindSubOrganizationCode = true;

				sb.append(
					_FINDER_COLUMN_SUBORGANIZATIONCODE_SUBORGANIZATIONCODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindSubOrganizationCode) {
					queryPos.add(subOrganizationCode);
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

	private static final String
		_FINDER_COLUMN_SUBORGANIZATIONCODE_SUBORGANIZATIONCODE_2 =
			"organizationAssignment.subOrganizationCode = ?";

	private static final String
		_FINDER_COLUMN_SUBORGANIZATIONCODE_SUBORGANIZATIONCODE_3 =
			"(organizationAssignment.subOrganizationCode IS NULL OR organizationAssignment.subOrganizationCode = '')";

	public OrganizationAssignmentPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(OrganizationAssignment.class);

		setModelImplClass(OrganizationAssignmentImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the organization assignment in the entity cache if it is enabled.
	 *
	 * @param organizationAssignment the organization assignment
	 */
	@Override
	public void cacheResult(OrganizationAssignment organizationAssignment) {
		entityCache.putResult(
			OrganizationAssignmentImpl.class,
			organizationAssignment.getPrimaryKey(), organizationAssignment);
	}

	/**
	 * Caches the organization assignments in the entity cache if it is enabled.
	 *
	 * @param organizationAssignments the organization assignments
	 */
	@Override
	public void cacheResult(
		List<OrganizationAssignment> organizationAssignments) {

		for (OrganizationAssignment organizationAssignment :
				organizationAssignments) {

			if (entityCache.getResult(
					OrganizationAssignmentImpl.class,
					organizationAssignment.getPrimaryKey()) == null) {

				cacheResult(organizationAssignment);
			}
		}
	}

	/**
	 * Clears the cache for all organization assignments.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(OrganizationAssignmentImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the organization assignment.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(OrganizationAssignment organizationAssignment) {
		entityCache.removeResult(
			OrganizationAssignmentImpl.class, organizationAssignment);
	}

	@Override
	public void clearCache(
		List<OrganizationAssignment> organizationAssignments) {

		for (OrganizationAssignment organizationAssignment :
				organizationAssignments) {

			entityCache.removeResult(
				OrganizationAssignmentImpl.class, organizationAssignment);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				OrganizationAssignmentImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new organization assignment with the primary key. Does not add the organization assignment to the database.
	 *
	 * @param organizationAssignmentId the primary key for the new organization assignment
	 * @return the new organization assignment
	 */
	@Override
	public OrganizationAssignment create(long organizationAssignmentId) {
		OrganizationAssignment organizationAssignment =
			new OrganizationAssignmentImpl();

		organizationAssignment.setNew(true);
		organizationAssignment.setPrimaryKey(organizationAssignmentId);

		organizationAssignment.setCompanyId(CompanyThreadLocal.getCompanyId());

		return organizationAssignment;
	}

	/**
	 * Removes the organization assignment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param organizationAssignmentId the primary key of the organization assignment
	 * @return the organization assignment that was removed
	 * @throws NoSuchOrganizationAssignmentException if a organization assignment with the primary key could not be found
	 */
	@Override
	public OrganizationAssignment remove(long organizationAssignmentId)
		throws NoSuchOrganizationAssignmentException {

		return remove((Serializable)organizationAssignmentId);
	}

	/**
	 * Removes the organization assignment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the organization assignment
	 * @return the organization assignment that was removed
	 * @throws NoSuchOrganizationAssignmentException if a organization assignment with the primary key could not be found
	 */
	@Override
	public OrganizationAssignment remove(Serializable primaryKey)
		throws NoSuchOrganizationAssignmentException {

		Session session = null;

		try {
			session = openSession();

			OrganizationAssignment organizationAssignment =
				(OrganizationAssignment)session.get(
					OrganizationAssignmentImpl.class, primaryKey);

			if (organizationAssignment == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOrganizationAssignmentException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(organizationAssignment);
		}
		catch (NoSuchOrganizationAssignmentException noSuchEntityException) {
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
	protected OrganizationAssignment removeImpl(
		OrganizationAssignment organizationAssignment) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(organizationAssignment)) {
				organizationAssignment = (OrganizationAssignment)session.get(
					OrganizationAssignmentImpl.class,
					organizationAssignment.getPrimaryKeyObj());
			}

			if (organizationAssignment != null) {
				session.delete(organizationAssignment);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (organizationAssignment != null) {
			clearCache(organizationAssignment);
		}

		return organizationAssignment;
	}

	@Override
	public OrganizationAssignment updateImpl(
		OrganizationAssignment organizationAssignment) {

		boolean isNew = organizationAssignment.isNew();

		if (!(organizationAssignment instanceof
				OrganizationAssignmentModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(organizationAssignment.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					organizationAssignment);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in organizationAssignment proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom OrganizationAssignment implementation " +
					organizationAssignment.getClass());
		}

		OrganizationAssignmentModelImpl organizationAssignmentModelImpl =
			(OrganizationAssignmentModelImpl)organizationAssignment;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (organizationAssignment.getCreateDate() == null)) {
			if (serviceContext == null) {
				organizationAssignment.setCreateDate(now);
			}
			else {
				organizationAssignment.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!organizationAssignmentModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				organizationAssignment.setModifiedDate(now);
			}
			else {
				organizationAssignment.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(organizationAssignment);
			}
			else {
				organizationAssignment = (OrganizationAssignment)session.merge(
					organizationAssignment);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			OrganizationAssignmentImpl.class, organizationAssignmentModelImpl,
			false, true);

		if (isNew) {
			organizationAssignment.setNew(false);
		}

		organizationAssignment.resetOriginalValues();

		return organizationAssignment;
	}

	/**
	 * Returns the organization assignment with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the organization assignment
	 * @return the organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a organization assignment with the primary key could not be found
	 */
	@Override
	public OrganizationAssignment findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOrganizationAssignmentException {

		OrganizationAssignment organizationAssignment = fetchByPrimaryKey(
			primaryKey);

		if (organizationAssignment == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOrganizationAssignmentException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return organizationAssignment;
	}

	/**
	 * Returns the organization assignment with the primary key or throws a <code>NoSuchOrganizationAssignmentException</code> if it could not be found.
	 *
	 * @param organizationAssignmentId the primary key of the organization assignment
	 * @return the organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a organization assignment with the primary key could not be found
	 */
	@Override
	public OrganizationAssignment findByPrimaryKey(
			long organizationAssignmentId)
		throws NoSuchOrganizationAssignmentException {

		return findByPrimaryKey((Serializable)organizationAssignmentId);
	}

	/**
	 * Returns the organization assignment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param organizationAssignmentId the primary key of the organization assignment
	 * @return the organization assignment, or <code>null</code> if a organization assignment with the primary key could not be found
	 */
	@Override
	public OrganizationAssignment fetchByPrimaryKey(
		long organizationAssignmentId) {

		return fetchByPrimaryKey((Serializable)organizationAssignmentId);
	}

	/**
	 * Returns all the organization assignments.
	 *
	 * @return the organization assignments
	 */
	@Override
	public List<OrganizationAssignment> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the organization assignments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of organization assignments
	 * @param end the upper bound of the range of organization assignments (not inclusive)
	 * @return the range of organization assignments
	 */
	@Override
	public List<OrganizationAssignment> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the organization assignments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of organization assignments
	 * @param end the upper bound of the range of organization assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of organization assignments
	 */
	@Override
	public List<OrganizationAssignment> findAll(
		int start, int end,
		OrderByComparator<OrganizationAssignment> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the organization assignments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of organization assignments
	 * @param end the upper bound of the range of organization assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of organization assignments
	 */
	@Override
	public List<OrganizationAssignment> findAll(
		int start, int end,
		OrderByComparator<OrganizationAssignment> orderByComparator,
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

		List<OrganizationAssignment> list = null;

		if (useFinderCache) {
			list = (List<OrganizationAssignment>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ORGANIZATIONASSIGNMENT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ORGANIZATIONASSIGNMENT;

				sql = sql.concat(OrganizationAssignmentModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<OrganizationAssignment>)QueryUtil.list(
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
	 * Removes all the organization assignments from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (OrganizationAssignment organizationAssignment : findAll()) {
			remove(organizationAssignment);
		}
	}

	/**
	 * Returns the number of organization assignments.
	 *
	 * @return the number of organization assignments
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
					_SQL_COUNT_ORGANIZATIONASSIGNMENT);

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
		return "organizationAssignmentId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ORGANIZATIONASSIGNMENT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return OrganizationAssignmentModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the organization assignment persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new OrganizationAssignmentModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", OrganizationAssignment.class.getName()));

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

		_finderPathWithPaginationFindByPersonalNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPersonalNo",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"personalNo"}, true);

		_finderPathWithoutPaginationFindByPersonalNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPersonalNo",
			new String[] {String.class.getName()}, new String[] {"personalNo"},
			true);

		_finderPathCountByPersonalNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPersonalNo",
			new String[] {String.class.getName()}, new String[] {"personalNo"},
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

		_finderPathWithPaginationFindByOrganizationCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByOrganizationCode",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"organizationCode"}, true);

		_finderPathWithoutPaginationFindByOrganizationCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOrganizationCode",
			new String[] {String.class.getName()},
			new String[] {"organizationCode"}, true);

		_finderPathCountByOrganizationCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByOrganizationCode", new String[] {String.class.getName()},
			new String[] {"organizationCode"}, false);

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

		_finderPathWithPaginationFindBySubOrganizationCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySubOrganizationCode",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"subOrganizationCode"}, true);

		_finderPathWithoutPaginationFindBySubOrganizationCode =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findBySubOrganizationCode",
				new String[] {String.class.getName()},
				new String[] {"subOrganizationCode"}, true);

		_finderPathCountBySubOrganizationCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySubOrganizationCode", new String[] {String.class.getName()},
			new String[] {"subOrganizationCode"}, false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(OrganizationAssignmentImpl.class.getName());

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

	private static final String _SQL_SELECT_ORGANIZATIONASSIGNMENT =
		"SELECT organizationAssignment FROM OrganizationAssignment organizationAssignment";

	private static final String _SQL_SELECT_ORGANIZATIONASSIGNMENT_WHERE =
		"SELECT organizationAssignment FROM OrganizationAssignment organizationAssignment WHERE ";

	private static final String _SQL_COUNT_ORGANIZATIONASSIGNMENT =
		"SELECT COUNT(organizationAssignment) FROM OrganizationAssignment organizationAssignment";

	private static final String _SQL_COUNT_ORGANIZATIONASSIGNMENT_WHERE =
		"SELECT COUNT(organizationAssignment) FROM OrganizationAssignment organizationAssignment WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"organizationAssignment.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No OrganizationAssignment exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No OrganizationAssignment exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		OrganizationAssignmentPersistenceImpl.class);

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

	private static class OrganizationAssignmentModelArgumentsResolver
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

			OrganizationAssignmentModelImpl organizationAssignmentModelImpl =
				(OrganizationAssignmentModelImpl)baseModel;

			long columnBitmask =
				organizationAssignmentModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					organizationAssignmentModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						organizationAssignmentModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					organizationAssignmentModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			OrganizationAssignmentModelImpl organizationAssignmentModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						organizationAssignmentModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] =
						organizationAssignmentModelImpl.getColumnValue(
							columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}