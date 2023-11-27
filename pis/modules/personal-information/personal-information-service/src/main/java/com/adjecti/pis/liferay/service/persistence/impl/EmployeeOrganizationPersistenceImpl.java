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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeOrganizationException;
import com.adjecti.pis.liferay.model.EmployeeOrganization;
import com.adjecti.pis.liferay.model.impl.EmployeeOrganizationImpl;
import com.adjecti.pis.liferay.model.impl.EmployeeOrganizationModelImpl;
import com.adjecti.pis.liferay.service.persistence.EmployeeOrganizationPersistence;
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
 * The persistence implementation for the employee organization service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EmployeeOrganizationPersistence.class)
public class EmployeeOrganizationPersistenceImpl
	extends BasePersistenceImpl<EmployeeOrganization>
	implements EmployeeOrganizationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EmployeeOrganizationUtil</code> to access the employee organization persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EmployeeOrganizationImpl.class.getName();

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
	 * Returns all the employee organizations where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee organizations
	 */
	@Override
	public List<EmployeeOrganization> findByEmployeeId(long employeeId) {
		return findByEmployeeId(
			employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee organizations where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @return the range of matching employee organizations
	 */
	@Override
	public List<EmployeeOrganization> findByEmployeeId(
		long employeeId, int start, int end) {

		return findByEmployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee organizations where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee organizations
	 */
	@Override
	public List<EmployeeOrganization> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeOrganization> orderByComparator) {

		return findByEmployeeId(
			employeeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee organizations where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee organizations
	 */
	@Override
	public List<EmployeeOrganization> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeOrganization> orderByComparator,
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

		List<EmployeeOrganization> list = null;

		if (useFinderCache) {
			list = (List<EmployeeOrganization>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeOrganization employeeOrganization : list) {
					if (employeeId != employeeOrganization.getEmployeeId()) {
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

			sb.append(_SQL_SELECT_EMPLOYEEORGANIZATION_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeOrganizationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				list = (List<EmployeeOrganization>)QueryUtil.list(
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
	 * Returns the first employee organization in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee organization
	 * @throws NoSuchEmployeeOrganizationException if a matching employee organization could not be found
	 */
	@Override
	public EmployeeOrganization findByEmployeeId_First(
			long employeeId,
			OrderByComparator<EmployeeOrganization> orderByComparator)
		throws NoSuchEmployeeOrganizationException {

		EmployeeOrganization employeeOrganization = fetchByEmployeeId_First(
			employeeId, orderByComparator);

		if (employeeOrganization != null) {
			return employeeOrganization;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeeOrganizationException(sb.toString());
	}

	/**
	 * Returns the first employee organization in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee organization, or <code>null</code> if a matching employee organization could not be found
	 */
	@Override
	public EmployeeOrganization fetchByEmployeeId_First(
		long employeeId,
		OrderByComparator<EmployeeOrganization> orderByComparator) {

		List<EmployeeOrganization> list = findByEmployeeId(
			employeeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee organization in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee organization
	 * @throws NoSuchEmployeeOrganizationException if a matching employee organization could not be found
	 */
	@Override
	public EmployeeOrganization findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<EmployeeOrganization> orderByComparator)
		throws NoSuchEmployeeOrganizationException {

		EmployeeOrganization employeeOrganization = fetchByEmployeeId_Last(
			employeeId, orderByComparator);

		if (employeeOrganization != null) {
			return employeeOrganization;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeeOrganizationException(sb.toString());
	}

	/**
	 * Returns the last employee organization in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee organization, or <code>null</code> if a matching employee organization could not be found
	 */
	@Override
	public EmployeeOrganization fetchByEmployeeId_Last(
		long employeeId,
		OrderByComparator<EmployeeOrganization> orderByComparator) {

		int count = countByEmployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<EmployeeOrganization> list = findByEmployeeId(
			employeeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee organizations before and after the current employee organization in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeOrganizationId the primary key of the current employee organization
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee organization
	 * @throws NoSuchEmployeeOrganizationException if a employee organization with the primary key could not be found
	 */
	@Override
	public EmployeeOrganization[] findByEmployeeId_PrevAndNext(
			long employeeOrganizationId, long employeeId,
			OrderByComparator<EmployeeOrganization> orderByComparator)
		throws NoSuchEmployeeOrganizationException {

		EmployeeOrganization employeeOrganization = findByPrimaryKey(
			employeeOrganizationId);

		Session session = null;

		try {
			session = openSession();

			EmployeeOrganization[] array = new EmployeeOrganizationImpl[3];

			array[0] = getByEmployeeId_PrevAndNext(
				session, employeeOrganization, employeeId, orderByComparator,
				true);

			array[1] = employeeOrganization;

			array[2] = getByEmployeeId_PrevAndNext(
				session, employeeOrganization, employeeId, orderByComparator,
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

	protected EmployeeOrganization getByEmployeeId_PrevAndNext(
		Session session, EmployeeOrganization employeeOrganization,
		long employeeId,
		OrderByComparator<EmployeeOrganization> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEORGANIZATION_WHERE);

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
			sb.append(EmployeeOrganizationModelImpl.ORDER_BY_JPQL);
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
						employeeOrganization)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeOrganization> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee organizations where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeByEmployeeId(long employeeId) {
		for (EmployeeOrganization employeeOrganization :
				findByEmployeeId(
					employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeeOrganization);
		}
	}

	/**
	 * Returns the number of employee organizations where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee organizations
	 */
	@Override
	public int countByEmployeeId(long employeeId) {
		FinderPath finderPath = _finderPathCountByEmployeeId;

		Object[] finderArgs = new Object[] {employeeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEORGANIZATION_WHERE);

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
		"employeeOrganization.employeeId = ?";

	private FinderPath _finderPathWithPaginationFindByPersonalNo;
	private FinderPath _finderPathWithoutPaginationFindByPersonalNo;
	private FinderPath _finderPathCountByPersonalNo;

	/**
	 * Returns all the employee organizations where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @return the matching employee organizations
	 */
	@Override
	public List<EmployeeOrganization> findByPersonalNo(String personalNo) {
		return findByPersonalNo(
			personalNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee organizations where personalNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param personalNo the personal no
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @return the range of matching employee organizations
	 */
	@Override
	public List<EmployeeOrganization> findByPersonalNo(
		String personalNo, int start, int end) {

		return findByPersonalNo(personalNo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee organizations where personalNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param personalNo the personal no
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee organizations
	 */
	@Override
	public List<EmployeeOrganization> findByPersonalNo(
		String personalNo, int start, int end,
		OrderByComparator<EmployeeOrganization> orderByComparator) {

		return findByPersonalNo(
			personalNo, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee organizations where personalNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param personalNo the personal no
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee organizations
	 */
	@Override
	public List<EmployeeOrganization> findByPersonalNo(
		String personalNo, int start, int end,
		OrderByComparator<EmployeeOrganization> orderByComparator,
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

		List<EmployeeOrganization> list = null;

		if (useFinderCache) {
			list = (List<EmployeeOrganization>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeOrganization employeeOrganization : list) {
					if (!personalNo.equals(
							employeeOrganization.getPersonalNo())) {

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

			sb.append(_SQL_SELECT_EMPLOYEEORGANIZATION_WHERE);

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
				sb.append(EmployeeOrganizationModelImpl.ORDER_BY_JPQL);
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

				list = (List<EmployeeOrganization>)QueryUtil.list(
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
	 * Returns the first employee organization in the ordered set where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee organization
	 * @throws NoSuchEmployeeOrganizationException if a matching employee organization could not be found
	 */
	@Override
	public EmployeeOrganization findByPersonalNo_First(
			String personalNo,
			OrderByComparator<EmployeeOrganization> orderByComparator)
		throws NoSuchEmployeeOrganizationException {

		EmployeeOrganization employeeOrganization = fetchByPersonalNo_First(
			personalNo, orderByComparator);

		if (employeeOrganization != null) {
			return employeeOrganization;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("personalNo=");
		sb.append(personalNo);

		sb.append("}");

		throw new NoSuchEmployeeOrganizationException(sb.toString());
	}

	/**
	 * Returns the first employee organization in the ordered set where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee organization, or <code>null</code> if a matching employee organization could not be found
	 */
	@Override
	public EmployeeOrganization fetchByPersonalNo_First(
		String personalNo,
		OrderByComparator<EmployeeOrganization> orderByComparator) {

		List<EmployeeOrganization> list = findByPersonalNo(
			personalNo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee organization in the ordered set where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee organization
	 * @throws NoSuchEmployeeOrganizationException if a matching employee organization could not be found
	 */
	@Override
	public EmployeeOrganization findByPersonalNo_Last(
			String personalNo,
			OrderByComparator<EmployeeOrganization> orderByComparator)
		throws NoSuchEmployeeOrganizationException {

		EmployeeOrganization employeeOrganization = fetchByPersonalNo_Last(
			personalNo, orderByComparator);

		if (employeeOrganization != null) {
			return employeeOrganization;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("personalNo=");
		sb.append(personalNo);

		sb.append("}");

		throw new NoSuchEmployeeOrganizationException(sb.toString());
	}

	/**
	 * Returns the last employee organization in the ordered set where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee organization, or <code>null</code> if a matching employee organization could not be found
	 */
	@Override
	public EmployeeOrganization fetchByPersonalNo_Last(
		String personalNo,
		OrderByComparator<EmployeeOrganization> orderByComparator) {

		int count = countByPersonalNo(personalNo);

		if (count == 0) {
			return null;
		}

		List<EmployeeOrganization> list = findByPersonalNo(
			personalNo, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee organizations before and after the current employee organization in the ordered set where personalNo = &#63;.
	 *
	 * @param employeeOrganizationId the primary key of the current employee organization
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee organization
	 * @throws NoSuchEmployeeOrganizationException if a employee organization with the primary key could not be found
	 */
	@Override
	public EmployeeOrganization[] findByPersonalNo_PrevAndNext(
			long employeeOrganizationId, String personalNo,
			OrderByComparator<EmployeeOrganization> orderByComparator)
		throws NoSuchEmployeeOrganizationException {

		personalNo = Objects.toString(personalNo, "");

		EmployeeOrganization employeeOrganization = findByPrimaryKey(
			employeeOrganizationId);

		Session session = null;

		try {
			session = openSession();

			EmployeeOrganization[] array = new EmployeeOrganizationImpl[3];

			array[0] = getByPersonalNo_PrevAndNext(
				session, employeeOrganization, personalNo, orderByComparator,
				true);

			array[1] = employeeOrganization;

			array[2] = getByPersonalNo_PrevAndNext(
				session, employeeOrganization, personalNo, orderByComparator,
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

	protected EmployeeOrganization getByPersonalNo_PrevAndNext(
		Session session, EmployeeOrganization employeeOrganization,
		String personalNo,
		OrderByComparator<EmployeeOrganization> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEORGANIZATION_WHERE);

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
			sb.append(EmployeeOrganizationModelImpl.ORDER_BY_JPQL);
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
						employeeOrganization)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeOrganization> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee organizations where personalNo = &#63; from the database.
	 *
	 * @param personalNo the personal no
	 */
	@Override
	public void removeByPersonalNo(String personalNo) {
		for (EmployeeOrganization employeeOrganization :
				findByPersonalNo(
					personalNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeeOrganization);
		}
	}

	/**
	 * Returns the number of employee organizations where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @return the number of matching employee organizations
	 */
	@Override
	public int countByPersonalNo(String personalNo) {
		personalNo = Objects.toString(personalNo, "");

		FinderPath finderPath = _finderPathCountByPersonalNo;

		Object[] finderArgs = new Object[] {personalNo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEORGANIZATION_WHERE);

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
		"employeeOrganization.personalNo = ?";

	private static final String _FINDER_COLUMN_PERSONALNO_PERSONALNO_3 =
		"(employeeOrganization.personalNo IS NULL OR employeeOrganization.personalNo = '')";

	private FinderPath _finderPathWithPaginationFindByOrganizationId;
	private FinderPath _finderPathWithoutPaginationFindByOrganizationId;
	private FinderPath _finderPathCountByOrganizationId;

	/**
	 * Returns all the employee organizations where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching employee organizations
	 */
	@Override
	public List<EmployeeOrganization> findByOrganizationId(
		long organizationId) {

		return findByOrganizationId(
			organizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee organizations where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @return the range of matching employee organizations
	 */
	@Override
	public List<EmployeeOrganization> findByOrganizationId(
		long organizationId, int start, int end) {

		return findByOrganizationId(organizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee organizations where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee organizations
	 */
	@Override
	public List<EmployeeOrganization> findByOrganizationId(
		long organizationId, int start, int end,
		OrderByComparator<EmployeeOrganization> orderByComparator) {

		return findByOrganizationId(
			organizationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee organizations where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee organizations
	 */
	@Override
	public List<EmployeeOrganization> findByOrganizationId(
		long organizationId, int start, int end,
		OrderByComparator<EmployeeOrganization> orderByComparator,
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

		List<EmployeeOrganization> list = null;

		if (useFinderCache) {
			list = (List<EmployeeOrganization>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeOrganization employeeOrganization : list) {
					if (organizationId !=
							employeeOrganization.getOrganizationId()) {

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

			sb.append(_SQL_SELECT_EMPLOYEEORGANIZATION_WHERE);

			sb.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeOrganizationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(organizationId);

				list = (List<EmployeeOrganization>)QueryUtil.list(
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
	 * Returns the first employee organization in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee organization
	 * @throws NoSuchEmployeeOrganizationException if a matching employee organization could not be found
	 */
	@Override
	public EmployeeOrganization findByOrganizationId_First(
			long organizationId,
			OrderByComparator<EmployeeOrganization> orderByComparator)
		throws NoSuchEmployeeOrganizationException {

		EmployeeOrganization employeeOrganization = fetchByOrganizationId_First(
			organizationId, orderByComparator);

		if (employeeOrganization != null) {
			return employeeOrganization;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("organizationId=");
		sb.append(organizationId);

		sb.append("}");

		throw new NoSuchEmployeeOrganizationException(sb.toString());
	}

	/**
	 * Returns the first employee organization in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee organization, or <code>null</code> if a matching employee organization could not be found
	 */
	@Override
	public EmployeeOrganization fetchByOrganizationId_First(
		long organizationId,
		OrderByComparator<EmployeeOrganization> orderByComparator) {

		List<EmployeeOrganization> list = findByOrganizationId(
			organizationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee organization in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee organization
	 * @throws NoSuchEmployeeOrganizationException if a matching employee organization could not be found
	 */
	@Override
	public EmployeeOrganization findByOrganizationId_Last(
			long organizationId,
			OrderByComparator<EmployeeOrganization> orderByComparator)
		throws NoSuchEmployeeOrganizationException {

		EmployeeOrganization employeeOrganization = fetchByOrganizationId_Last(
			organizationId, orderByComparator);

		if (employeeOrganization != null) {
			return employeeOrganization;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("organizationId=");
		sb.append(organizationId);

		sb.append("}");

		throw new NoSuchEmployeeOrganizationException(sb.toString());
	}

	/**
	 * Returns the last employee organization in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee organization, or <code>null</code> if a matching employee organization could not be found
	 */
	@Override
	public EmployeeOrganization fetchByOrganizationId_Last(
		long organizationId,
		OrderByComparator<EmployeeOrganization> orderByComparator) {

		int count = countByOrganizationId(organizationId);

		if (count == 0) {
			return null;
		}

		List<EmployeeOrganization> list = findByOrganizationId(
			organizationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee organizations before and after the current employee organization in the ordered set where organizationId = &#63;.
	 *
	 * @param employeeOrganizationId the primary key of the current employee organization
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee organization
	 * @throws NoSuchEmployeeOrganizationException if a employee organization with the primary key could not be found
	 */
	@Override
	public EmployeeOrganization[] findByOrganizationId_PrevAndNext(
			long employeeOrganizationId, long organizationId,
			OrderByComparator<EmployeeOrganization> orderByComparator)
		throws NoSuchEmployeeOrganizationException {

		EmployeeOrganization employeeOrganization = findByPrimaryKey(
			employeeOrganizationId);

		Session session = null;

		try {
			session = openSession();

			EmployeeOrganization[] array = new EmployeeOrganizationImpl[3];

			array[0] = getByOrganizationId_PrevAndNext(
				session, employeeOrganization, organizationId,
				orderByComparator, true);

			array[1] = employeeOrganization;

			array[2] = getByOrganizationId_PrevAndNext(
				session, employeeOrganization, organizationId,
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

	protected EmployeeOrganization getByOrganizationId_PrevAndNext(
		Session session, EmployeeOrganization employeeOrganization,
		long organizationId,
		OrderByComparator<EmployeeOrganization> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEORGANIZATION_WHERE);

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
			sb.append(EmployeeOrganizationModelImpl.ORDER_BY_JPQL);
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
						employeeOrganization)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeOrganization> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee organizations where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	@Override
	public void removeByOrganizationId(long organizationId) {
		for (EmployeeOrganization employeeOrganization :
				findByOrganizationId(
					organizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(employeeOrganization);
		}
	}

	/**
	 * Returns the number of employee organizations where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching employee organizations
	 */
	@Override
	public int countByOrganizationId(long organizationId) {
		FinderPath finderPath = _finderPathCountByOrganizationId;

		Object[] finderArgs = new Object[] {organizationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEORGANIZATION_WHERE);

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
		"employeeOrganization.organizationId = ?";

	private FinderPath
		_finderPathWithPaginationFindByEmployeeIdAndOrganizationId;
	private FinderPath
		_finderPathWithoutPaginationFindByEmployeeIdAndOrganizationId;
	private FinderPath _finderPathCountByEmployeeIdAndOrganizationId;

	/**
	 * Returns all the employee organizations where employeeId = &#63; and organizationId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param organizationId the organization ID
	 * @return the matching employee organizations
	 */
	@Override
	public List<EmployeeOrganization> findByEmployeeIdAndOrganizationId(
		long employeeId, long organizationId) {

		return findByEmployeeIdAndOrganizationId(
			employeeId, organizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the employee organizations where employeeId = &#63; and organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @return the range of matching employee organizations
	 */
	@Override
	public List<EmployeeOrganization> findByEmployeeIdAndOrganizationId(
		long employeeId, long organizationId, int start, int end) {

		return findByEmployeeIdAndOrganizationId(
			employeeId, organizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee organizations where employeeId = &#63; and organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee organizations
	 */
	@Override
	public List<EmployeeOrganization> findByEmployeeIdAndOrganizationId(
		long employeeId, long organizationId, int start, int end,
		OrderByComparator<EmployeeOrganization> orderByComparator) {

		return findByEmployeeIdAndOrganizationId(
			employeeId, organizationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee organizations where employeeId = &#63; and organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee organizations
	 */
	@Override
	public List<EmployeeOrganization> findByEmployeeIdAndOrganizationId(
		long employeeId, long organizationId, int start, int end,
		OrderByComparator<EmployeeOrganization> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByEmployeeIdAndOrganizationId;
				finderArgs = new Object[] {employeeId, organizationId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByEmployeeIdAndOrganizationId;
			finderArgs = new Object[] {
				employeeId, organizationId, start, end, orderByComparator
			};
		}

		List<EmployeeOrganization> list = null;

		if (useFinderCache) {
			list = (List<EmployeeOrganization>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeOrganization employeeOrganization : list) {
					if ((employeeId != employeeOrganization.getEmployeeId()) ||
						(organizationId !=
							employeeOrganization.getOrganizationId())) {

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

			sb.append(_SQL_SELECT_EMPLOYEEORGANIZATION_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEIDANDORGANIZATIONID_EMPLOYEEID_2);

			sb.append(
				_FINDER_COLUMN_EMPLOYEEIDANDORGANIZATIONID_ORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeOrganizationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				queryPos.add(organizationId);

				list = (List<EmployeeOrganization>)QueryUtil.list(
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
	 * Returns the first employee organization in the ordered set where employeeId = &#63; and organizationId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee organization
	 * @throws NoSuchEmployeeOrganizationException if a matching employee organization could not be found
	 */
	@Override
	public EmployeeOrganization findByEmployeeIdAndOrganizationId_First(
			long employeeId, long organizationId,
			OrderByComparator<EmployeeOrganization> orderByComparator)
		throws NoSuchEmployeeOrganizationException {

		EmployeeOrganization employeeOrganization =
			fetchByEmployeeIdAndOrganizationId_First(
				employeeId, organizationId, orderByComparator);

		if (employeeOrganization != null) {
			return employeeOrganization;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append(", organizationId=");
		sb.append(organizationId);

		sb.append("}");

		throw new NoSuchEmployeeOrganizationException(sb.toString());
	}

	/**
	 * Returns the first employee organization in the ordered set where employeeId = &#63; and organizationId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee organization, or <code>null</code> if a matching employee organization could not be found
	 */
	@Override
	public EmployeeOrganization fetchByEmployeeIdAndOrganizationId_First(
		long employeeId, long organizationId,
		OrderByComparator<EmployeeOrganization> orderByComparator) {

		List<EmployeeOrganization> list = findByEmployeeIdAndOrganizationId(
			employeeId, organizationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee organization in the ordered set where employeeId = &#63; and organizationId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee organization
	 * @throws NoSuchEmployeeOrganizationException if a matching employee organization could not be found
	 */
	@Override
	public EmployeeOrganization findByEmployeeIdAndOrganizationId_Last(
			long employeeId, long organizationId,
			OrderByComparator<EmployeeOrganization> orderByComparator)
		throws NoSuchEmployeeOrganizationException {

		EmployeeOrganization employeeOrganization =
			fetchByEmployeeIdAndOrganizationId_Last(
				employeeId, organizationId, orderByComparator);

		if (employeeOrganization != null) {
			return employeeOrganization;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append(", organizationId=");
		sb.append(organizationId);

		sb.append("}");

		throw new NoSuchEmployeeOrganizationException(sb.toString());
	}

	/**
	 * Returns the last employee organization in the ordered set where employeeId = &#63; and organizationId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee organization, or <code>null</code> if a matching employee organization could not be found
	 */
	@Override
	public EmployeeOrganization fetchByEmployeeIdAndOrganizationId_Last(
		long employeeId, long organizationId,
		OrderByComparator<EmployeeOrganization> orderByComparator) {

		int count = countByEmployeeIdAndOrganizationId(
			employeeId, organizationId);

		if (count == 0) {
			return null;
		}

		List<EmployeeOrganization> list = findByEmployeeIdAndOrganizationId(
			employeeId, organizationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee organizations before and after the current employee organization in the ordered set where employeeId = &#63; and organizationId = &#63;.
	 *
	 * @param employeeOrganizationId the primary key of the current employee organization
	 * @param employeeId the employee ID
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee organization
	 * @throws NoSuchEmployeeOrganizationException if a employee organization with the primary key could not be found
	 */
	@Override
	public EmployeeOrganization[] findByEmployeeIdAndOrganizationId_PrevAndNext(
			long employeeOrganizationId, long employeeId, long organizationId,
			OrderByComparator<EmployeeOrganization> orderByComparator)
		throws NoSuchEmployeeOrganizationException {

		EmployeeOrganization employeeOrganization = findByPrimaryKey(
			employeeOrganizationId);

		Session session = null;

		try {
			session = openSession();

			EmployeeOrganization[] array = new EmployeeOrganizationImpl[3];

			array[0] = getByEmployeeIdAndOrganizationId_PrevAndNext(
				session, employeeOrganization, employeeId, organizationId,
				orderByComparator, true);

			array[1] = employeeOrganization;

			array[2] = getByEmployeeIdAndOrganizationId_PrevAndNext(
				session, employeeOrganization, employeeId, organizationId,
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

	protected EmployeeOrganization getByEmployeeIdAndOrganizationId_PrevAndNext(
		Session session, EmployeeOrganization employeeOrganization,
		long employeeId, long organizationId,
		OrderByComparator<EmployeeOrganization> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEORGANIZATION_WHERE);

		sb.append(_FINDER_COLUMN_EMPLOYEEIDANDORGANIZATIONID_EMPLOYEEID_2);

		sb.append(_FINDER_COLUMN_EMPLOYEEIDANDORGANIZATIONID_ORGANIZATIONID_2);

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
			sb.append(EmployeeOrganizationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(employeeId);

		queryPos.add(organizationId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						employeeOrganization)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeOrganization> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee organizations where employeeId = &#63; and organizationId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param organizationId the organization ID
	 */
	@Override
	public void removeByEmployeeIdAndOrganizationId(
		long employeeId, long organizationId) {

		for (EmployeeOrganization employeeOrganization :
				findByEmployeeIdAndOrganizationId(
					employeeId, organizationId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(employeeOrganization);
		}
	}

	/**
	 * Returns the number of employee organizations where employeeId = &#63; and organizationId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param organizationId the organization ID
	 * @return the number of matching employee organizations
	 */
	@Override
	public int countByEmployeeIdAndOrganizationId(
		long employeeId, long organizationId) {

		FinderPath finderPath = _finderPathCountByEmployeeIdAndOrganizationId;

		Object[] finderArgs = new Object[] {employeeId, organizationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_EMPLOYEEORGANIZATION_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEIDANDORGANIZATIONID_EMPLOYEEID_2);

			sb.append(
				_FINDER_COLUMN_EMPLOYEEIDANDORGANIZATIONID_ORGANIZATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

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

	private static final String
		_FINDER_COLUMN_EMPLOYEEIDANDORGANIZATIONID_EMPLOYEEID_2 =
			"employeeOrganization.employeeId = ? AND ";

	private static final String
		_FINDER_COLUMN_EMPLOYEEIDANDORGANIZATIONID_ORGANIZATIONID_2 =
			"employeeOrganization.organizationId = ?";

	private FinderPath
		_finderPathWithPaginationFindByEmployeeIdAndSubOrganizationId;
	private FinderPath
		_finderPathWithoutPaginationFindByEmployeeIdAndSubOrganizationId;
	private FinderPath _finderPathCountByEmployeeIdAndSubOrganizationId;

	/**
	 * Returns all the employee organizations where employeeId = &#63; and subOrganizationId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param subOrganizationId the sub organization ID
	 * @return the matching employee organizations
	 */
	@Override
	public List<EmployeeOrganization> findByEmployeeIdAndSubOrganizationId(
		long employeeId, long subOrganizationId) {

		return findByEmployeeIdAndSubOrganizationId(
			employeeId, subOrganizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the employee organizations where employeeId = &#63; and subOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param subOrganizationId the sub organization ID
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @return the range of matching employee organizations
	 */
	@Override
	public List<EmployeeOrganization> findByEmployeeIdAndSubOrganizationId(
		long employeeId, long subOrganizationId, int start, int end) {

		return findByEmployeeIdAndSubOrganizationId(
			employeeId, subOrganizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee organizations where employeeId = &#63; and subOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param subOrganizationId the sub organization ID
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee organizations
	 */
	@Override
	public List<EmployeeOrganization> findByEmployeeIdAndSubOrganizationId(
		long employeeId, long subOrganizationId, int start, int end,
		OrderByComparator<EmployeeOrganization> orderByComparator) {

		return findByEmployeeIdAndSubOrganizationId(
			employeeId, subOrganizationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee organizations where employeeId = &#63; and subOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param subOrganizationId the sub organization ID
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee organizations
	 */
	@Override
	public List<EmployeeOrganization> findByEmployeeIdAndSubOrganizationId(
		long employeeId, long subOrganizationId, int start, int end,
		OrderByComparator<EmployeeOrganization> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByEmployeeIdAndSubOrganizationId;
				finderArgs = new Object[] {employeeId, subOrganizationId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByEmployeeIdAndSubOrganizationId;
			finderArgs = new Object[] {
				employeeId, subOrganizationId, start, end, orderByComparator
			};
		}

		List<EmployeeOrganization> list = null;

		if (useFinderCache) {
			list = (List<EmployeeOrganization>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeOrganization employeeOrganization : list) {
					if ((employeeId != employeeOrganization.getEmployeeId()) ||
						(subOrganizationId !=
							employeeOrganization.getSubOrganizationId())) {

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

			sb.append(_SQL_SELECT_EMPLOYEEORGANIZATION_WHERE);

			sb.append(
				_FINDER_COLUMN_EMPLOYEEIDANDSUBORGANIZATIONID_EMPLOYEEID_2);

			sb.append(
				_FINDER_COLUMN_EMPLOYEEIDANDSUBORGANIZATIONID_SUBORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeOrganizationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				queryPos.add(subOrganizationId);

				list = (List<EmployeeOrganization>)QueryUtil.list(
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
	 * Returns the first employee organization in the ordered set where employeeId = &#63; and subOrganizationId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee organization
	 * @throws NoSuchEmployeeOrganizationException if a matching employee organization could not be found
	 */
	@Override
	public EmployeeOrganization findByEmployeeIdAndSubOrganizationId_First(
			long employeeId, long subOrganizationId,
			OrderByComparator<EmployeeOrganization> orderByComparator)
		throws NoSuchEmployeeOrganizationException {

		EmployeeOrganization employeeOrganization =
			fetchByEmployeeIdAndSubOrganizationId_First(
				employeeId, subOrganizationId, orderByComparator);

		if (employeeOrganization != null) {
			return employeeOrganization;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append(", subOrganizationId=");
		sb.append(subOrganizationId);

		sb.append("}");

		throw new NoSuchEmployeeOrganizationException(sb.toString());
	}

	/**
	 * Returns the first employee organization in the ordered set where employeeId = &#63; and subOrganizationId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee organization, or <code>null</code> if a matching employee organization could not be found
	 */
	@Override
	public EmployeeOrganization fetchByEmployeeIdAndSubOrganizationId_First(
		long employeeId, long subOrganizationId,
		OrderByComparator<EmployeeOrganization> orderByComparator) {

		List<EmployeeOrganization> list = findByEmployeeIdAndSubOrganizationId(
			employeeId, subOrganizationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee organization in the ordered set where employeeId = &#63; and subOrganizationId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee organization
	 * @throws NoSuchEmployeeOrganizationException if a matching employee organization could not be found
	 */
	@Override
	public EmployeeOrganization findByEmployeeIdAndSubOrganizationId_Last(
			long employeeId, long subOrganizationId,
			OrderByComparator<EmployeeOrganization> orderByComparator)
		throws NoSuchEmployeeOrganizationException {

		EmployeeOrganization employeeOrganization =
			fetchByEmployeeIdAndSubOrganizationId_Last(
				employeeId, subOrganizationId, orderByComparator);

		if (employeeOrganization != null) {
			return employeeOrganization;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append(", subOrganizationId=");
		sb.append(subOrganizationId);

		sb.append("}");

		throw new NoSuchEmployeeOrganizationException(sb.toString());
	}

	/**
	 * Returns the last employee organization in the ordered set where employeeId = &#63; and subOrganizationId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee organization, or <code>null</code> if a matching employee organization could not be found
	 */
	@Override
	public EmployeeOrganization fetchByEmployeeIdAndSubOrganizationId_Last(
		long employeeId, long subOrganizationId,
		OrderByComparator<EmployeeOrganization> orderByComparator) {

		int count = countByEmployeeIdAndSubOrganizationId(
			employeeId, subOrganizationId);

		if (count == 0) {
			return null;
		}

		List<EmployeeOrganization> list = findByEmployeeIdAndSubOrganizationId(
			employeeId, subOrganizationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee organizations before and after the current employee organization in the ordered set where employeeId = &#63; and subOrganizationId = &#63;.
	 *
	 * @param employeeOrganizationId the primary key of the current employee organization
	 * @param employeeId the employee ID
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee organization
	 * @throws NoSuchEmployeeOrganizationException if a employee organization with the primary key could not be found
	 */
	@Override
	public EmployeeOrganization[]
			findByEmployeeIdAndSubOrganizationId_PrevAndNext(
				long employeeOrganizationId, long employeeId,
				long subOrganizationId,
				OrderByComparator<EmployeeOrganization> orderByComparator)
		throws NoSuchEmployeeOrganizationException {

		EmployeeOrganization employeeOrganization = findByPrimaryKey(
			employeeOrganizationId);

		Session session = null;

		try {
			session = openSession();

			EmployeeOrganization[] array = new EmployeeOrganizationImpl[3];

			array[0] = getByEmployeeIdAndSubOrganizationId_PrevAndNext(
				session, employeeOrganization, employeeId, subOrganizationId,
				orderByComparator, true);

			array[1] = employeeOrganization;

			array[2] = getByEmployeeIdAndSubOrganizationId_PrevAndNext(
				session, employeeOrganization, employeeId, subOrganizationId,
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

	protected EmployeeOrganization
		getByEmployeeIdAndSubOrganizationId_PrevAndNext(
			Session session, EmployeeOrganization employeeOrganization,
			long employeeId, long subOrganizationId,
			OrderByComparator<EmployeeOrganization> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEORGANIZATION_WHERE);

		sb.append(_FINDER_COLUMN_EMPLOYEEIDANDSUBORGANIZATIONID_EMPLOYEEID_2);

		sb.append(
			_FINDER_COLUMN_EMPLOYEEIDANDSUBORGANIZATIONID_SUBORGANIZATIONID_2);

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
			sb.append(EmployeeOrganizationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(employeeId);

		queryPos.add(subOrganizationId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						employeeOrganization)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeOrganization> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee organizations where employeeId = &#63; and subOrganizationId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param subOrganizationId the sub organization ID
	 */
	@Override
	public void removeByEmployeeIdAndSubOrganizationId(
		long employeeId, long subOrganizationId) {

		for (EmployeeOrganization employeeOrganization :
				findByEmployeeIdAndSubOrganizationId(
					employeeId, subOrganizationId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(employeeOrganization);
		}
	}

	/**
	 * Returns the number of employee organizations where employeeId = &#63; and subOrganizationId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param subOrganizationId the sub organization ID
	 * @return the number of matching employee organizations
	 */
	@Override
	public int countByEmployeeIdAndSubOrganizationId(
		long employeeId, long subOrganizationId) {

		FinderPath finderPath =
			_finderPathCountByEmployeeIdAndSubOrganizationId;

		Object[] finderArgs = new Object[] {employeeId, subOrganizationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_EMPLOYEEORGANIZATION_WHERE);

			sb.append(
				_FINDER_COLUMN_EMPLOYEEIDANDSUBORGANIZATIONID_EMPLOYEEID_2);

			sb.append(
				_FINDER_COLUMN_EMPLOYEEIDANDSUBORGANIZATIONID_SUBORGANIZATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

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
		_FINDER_COLUMN_EMPLOYEEIDANDSUBORGANIZATIONID_EMPLOYEEID_2 =
			"employeeOrganization.employeeId = ? AND ";

	private static final String
		_FINDER_COLUMN_EMPLOYEEIDANDSUBORGANIZATIONID_SUBORGANIZATIONID_2 =
			"employeeOrganization.subOrganizationId = ?";

	private FinderPath
		_finderPathWithPaginationFindBySubOrganizationIdAndActive;
	private FinderPath
		_finderPathWithoutPaginationFindBySubOrganizationIdAndActive;
	private FinderPath _finderPathCountBySubOrganizationIdAndActive;

	/**
	 * Returns all the employee organizations where subOrganizationId = &#63; and active = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param active the active
	 * @return the matching employee organizations
	 */
	@Override
	public List<EmployeeOrganization> findBySubOrganizationIdAndActive(
		long subOrganizationId, boolean active) {

		return findBySubOrganizationIdAndActive(
			subOrganizationId, active, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the employee organizations where subOrganizationId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param active the active
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @return the range of matching employee organizations
	 */
	@Override
	public List<EmployeeOrganization> findBySubOrganizationIdAndActive(
		long subOrganizationId, boolean active, int start, int end) {

		return findBySubOrganizationIdAndActive(
			subOrganizationId, active, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee organizations where subOrganizationId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param active the active
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee organizations
	 */
	@Override
	public List<EmployeeOrganization> findBySubOrganizationIdAndActive(
		long subOrganizationId, boolean active, int start, int end,
		OrderByComparator<EmployeeOrganization> orderByComparator) {

		return findBySubOrganizationIdAndActive(
			subOrganizationId, active, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee organizations where subOrganizationId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param active the active
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee organizations
	 */
	@Override
	public List<EmployeeOrganization> findBySubOrganizationIdAndActive(
		long subOrganizationId, boolean active, int start, int end,
		OrderByComparator<EmployeeOrganization> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBySubOrganizationIdAndActive;
				finderArgs = new Object[] {subOrganizationId, active};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindBySubOrganizationIdAndActive;
			finderArgs = new Object[] {
				subOrganizationId, active, start, end, orderByComparator
			};
		}

		List<EmployeeOrganization> list = null;

		if (useFinderCache) {
			list = (List<EmployeeOrganization>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeOrganization employeeOrganization : list) {
					if ((subOrganizationId !=
							employeeOrganization.getSubOrganizationId()) ||
						(active != employeeOrganization.isActive())) {

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

			sb.append(_SQL_SELECT_EMPLOYEEORGANIZATION_WHERE);

			sb.append(
				_FINDER_COLUMN_SUBORGANIZATIONIDANDACTIVE_SUBORGANIZATIONID_2);

			sb.append(_FINDER_COLUMN_SUBORGANIZATIONIDANDACTIVE_ACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeOrganizationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(subOrganizationId);

				queryPos.add(active);

				list = (List<EmployeeOrganization>)QueryUtil.list(
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
	 * Returns the first employee organization in the ordered set where subOrganizationId = &#63; and active = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee organization
	 * @throws NoSuchEmployeeOrganizationException if a matching employee organization could not be found
	 */
	@Override
	public EmployeeOrganization findBySubOrganizationIdAndActive_First(
			long subOrganizationId, boolean active,
			OrderByComparator<EmployeeOrganization> orderByComparator)
		throws NoSuchEmployeeOrganizationException {

		EmployeeOrganization employeeOrganization =
			fetchBySubOrganizationIdAndActive_First(
				subOrganizationId, active, orderByComparator);

		if (employeeOrganization != null) {
			return employeeOrganization;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("subOrganizationId=");
		sb.append(subOrganizationId);

		sb.append(", active=");
		sb.append(active);

		sb.append("}");

		throw new NoSuchEmployeeOrganizationException(sb.toString());
	}

	/**
	 * Returns the first employee organization in the ordered set where subOrganizationId = &#63; and active = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee organization, or <code>null</code> if a matching employee organization could not be found
	 */
	@Override
	public EmployeeOrganization fetchBySubOrganizationIdAndActive_First(
		long subOrganizationId, boolean active,
		OrderByComparator<EmployeeOrganization> orderByComparator) {

		List<EmployeeOrganization> list = findBySubOrganizationIdAndActive(
			subOrganizationId, active, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee organization in the ordered set where subOrganizationId = &#63; and active = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee organization
	 * @throws NoSuchEmployeeOrganizationException if a matching employee organization could not be found
	 */
	@Override
	public EmployeeOrganization findBySubOrganizationIdAndActive_Last(
			long subOrganizationId, boolean active,
			OrderByComparator<EmployeeOrganization> orderByComparator)
		throws NoSuchEmployeeOrganizationException {

		EmployeeOrganization employeeOrganization =
			fetchBySubOrganizationIdAndActive_Last(
				subOrganizationId, active, orderByComparator);

		if (employeeOrganization != null) {
			return employeeOrganization;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("subOrganizationId=");
		sb.append(subOrganizationId);

		sb.append(", active=");
		sb.append(active);

		sb.append("}");

		throw new NoSuchEmployeeOrganizationException(sb.toString());
	}

	/**
	 * Returns the last employee organization in the ordered set where subOrganizationId = &#63; and active = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee organization, or <code>null</code> if a matching employee organization could not be found
	 */
	@Override
	public EmployeeOrganization fetchBySubOrganizationIdAndActive_Last(
		long subOrganizationId, boolean active,
		OrderByComparator<EmployeeOrganization> orderByComparator) {

		int count = countBySubOrganizationIdAndActive(
			subOrganizationId, active);

		if (count == 0) {
			return null;
		}

		List<EmployeeOrganization> list = findBySubOrganizationIdAndActive(
			subOrganizationId, active, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee organizations before and after the current employee organization in the ordered set where subOrganizationId = &#63; and active = &#63;.
	 *
	 * @param employeeOrganizationId the primary key of the current employee organization
	 * @param subOrganizationId the sub organization ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee organization
	 * @throws NoSuchEmployeeOrganizationException if a employee organization with the primary key could not be found
	 */
	@Override
	public EmployeeOrganization[] findBySubOrganizationIdAndActive_PrevAndNext(
			long employeeOrganizationId, long subOrganizationId, boolean active,
			OrderByComparator<EmployeeOrganization> orderByComparator)
		throws NoSuchEmployeeOrganizationException {

		EmployeeOrganization employeeOrganization = findByPrimaryKey(
			employeeOrganizationId);

		Session session = null;

		try {
			session = openSession();

			EmployeeOrganization[] array = new EmployeeOrganizationImpl[3];

			array[0] = getBySubOrganizationIdAndActive_PrevAndNext(
				session, employeeOrganization, subOrganizationId, active,
				orderByComparator, true);

			array[1] = employeeOrganization;

			array[2] = getBySubOrganizationIdAndActive_PrevAndNext(
				session, employeeOrganization, subOrganizationId, active,
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

	protected EmployeeOrganization getBySubOrganizationIdAndActive_PrevAndNext(
		Session session, EmployeeOrganization employeeOrganization,
		long subOrganizationId, boolean active,
		OrderByComparator<EmployeeOrganization> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEORGANIZATION_WHERE);

		sb.append(
			_FINDER_COLUMN_SUBORGANIZATIONIDANDACTIVE_SUBORGANIZATIONID_2);

		sb.append(_FINDER_COLUMN_SUBORGANIZATIONIDANDACTIVE_ACTIVE_2);

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
			sb.append(EmployeeOrganizationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(subOrganizationId);

		queryPos.add(active);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						employeeOrganization)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeOrganization> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee organizations where subOrganizationId = &#63; and active = &#63; from the database.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param active the active
	 */
	@Override
	public void removeBySubOrganizationIdAndActive(
		long subOrganizationId, boolean active) {

		for (EmployeeOrganization employeeOrganization :
				findBySubOrganizationIdAndActive(
					subOrganizationId, active, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(employeeOrganization);
		}
	}

	/**
	 * Returns the number of employee organizations where subOrganizationId = &#63; and active = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param active the active
	 * @return the number of matching employee organizations
	 */
	@Override
	public int countBySubOrganizationIdAndActive(
		long subOrganizationId, boolean active) {

		FinderPath finderPath = _finderPathCountBySubOrganizationIdAndActive;

		Object[] finderArgs = new Object[] {subOrganizationId, active};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_EMPLOYEEORGANIZATION_WHERE);

			sb.append(
				_FINDER_COLUMN_SUBORGANIZATIONIDANDACTIVE_SUBORGANIZATIONID_2);

			sb.append(_FINDER_COLUMN_SUBORGANIZATIONIDANDACTIVE_ACTIVE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(subOrganizationId);

				queryPos.add(active);

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
		_FINDER_COLUMN_SUBORGANIZATIONIDANDACTIVE_SUBORGANIZATIONID_2 =
			"employeeOrganization.subOrganizationId = ? AND ";

	private static final String
		_FINDER_COLUMN_SUBORGANIZATIONIDANDACTIVE_ACTIVE_2 =
			"employeeOrganization.active = ?";

	private FinderPath _finderPathWithPaginationFindByOrganizationCode;
	private FinderPath _finderPathWithoutPaginationFindByOrganizationCode;
	private FinderPath _finderPathCountByOrganizationCode;

	/**
	 * Returns all the employee organizations where organizationCode = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @return the matching employee organizations
	 */
	@Override
	public List<EmployeeOrganization> findByOrganizationCode(
		String organizationCode) {

		return findByOrganizationCode(
			organizationCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee organizations where organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @return the range of matching employee organizations
	 */
	@Override
	public List<EmployeeOrganization> findByOrganizationCode(
		String organizationCode, int start, int end) {

		return findByOrganizationCode(organizationCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee organizations where organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee organizations
	 */
	@Override
	public List<EmployeeOrganization> findByOrganizationCode(
		String organizationCode, int start, int end,
		OrderByComparator<EmployeeOrganization> orderByComparator) {

		return findByOrganizationCode(
			organizationCode, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee organizations where organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee organizations
	 */
	@Override
	public List<EmployeeOrganization> findByOrganizationCode(
		String organizationCode, int start, int end,
		OrderByComparator<EmployeeOrganization> orderByComparator,
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

		List<EmployeeOrganization> list = null;

		if (useFinderCache) {
			list = (List<EmployeeOrganization>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeOrganization employeeOrganization : list) {
					if (!organizationCode.equals(
							employeeOrganization.getOrganizationCode())) {

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

			sb.append(_SQL_SELECT_EMPLOYEEORGANIZATION_WHERE);

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
				sb.append(EmployeeOrganizationModelImpl.ORDER_BY_JPQL);
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

				list = (List<EmployeeOrganization>)QueryUtil.list(
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
	 * Returns the first employee organization in the ordered set where organizationCode = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee organization
	 * @throws NoSuchEmployeeOrganizationException if a matching employee organization could not be found
	 */
	@Override
	public EmployeeOrganization findByOrganizationCode_First(
			String organizationCode,
			OrderByComparator<EmployeeOrganization> orderByComparator)
		throws NoSuchEmployeeOrganizationException {

		EmployeeOrganization employeeOrganization =
			fetchByOrganizationCode_First(organizationCode, orderByComparator);

		if (employeeOrganization != null) {
			return employeeOrganization;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("organizationCode=");
		sb.append(organizationCode);

		sb.append("}");

		throw new NoSuchEmployeeOrganizationException(sb.toString());
	}

	/**
	 * Returns the first employee organization in the ordered set where organizationCode = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee organization, or <code>null</code> if a matching employee organization could not be found
	 */
	@Override
	public EmployeeOrganization fetchByOrganizationCode_First(
		String organizationCode,
		OrderByComparator<EmployeeOrganization> orderByComparator) {

		List<EmployeeOrganization> list = findByOrganizationCode(
			organizationCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee organization in the ordered set where organizationCode = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee organization
	 * @throws NoSuchEmployeeOrganizationException if a matching employee organization could not be found
	 */
	@Override
	public EmployeeOrganization findByOrganizationCode_Last(
			String organizationCode,
			OrderByComparator<EmployeeOrganization> orderByComparator)
		throws NoSuchEmployeeOrganizationException {

		EmployeeOrganization employeeOrganization =
			fetchByOrganizationCode_Last(organizationCode, orderByComparator);

		if (employeeOrganization != null) {
			return employeeOrganization;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("organizationCode=");
		sb.append(organizationCode);

		sb.append("}");

		throw new NoSuchEmployeeOrganizationException(sb.toString());
	}

	/**
	 * Returns the last employee organization in the ordered set where organizationCode = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee organization, or <code>null</code> if a matching employee organization could not be found
	 */
	@Override
	public EmployeeOrganization fetchByOrganizationCode_Last(
		String organizationCode,
		OrderByComparator<EmployeeOrganization> orderByComparator) {

		int count = countByOrganizationCode(organizationCode);

		if (count == 0) {
			return null;
		}

		List<EmployeeOrganization> list = findByOrganizationCode(
			organizationCode, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee organizations before and after the current employee organization in the ordered set where organizationCode = &#63;.
	 *
	 * @param employeeOrganizationId the primary key of the current employee organization
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee organization
	 * @throws NoSuchEmployeeOrganizationException if a employee organization with the primary key could not be found
	 */
	@Override
	public EmployeeOrganization[] findByOrganizationCode_PrevAndNext(
			long employeeOrganizationId, String organizationCode,
			OrderByComparator<EmployeeOrganization> orderByComparator)
		throws NoSuchEmployeeOrganizationException {

		organizationCode = Objects.toString(organizationCode, "");

		EmployeeOrganization employeeOrganization = findByPrimaryKey(
			employeeOrganizationId);

		Session session = null;

		try {
			session = openSession();

			EmployeeOrganization[] array = new EmployeeOrganizationImpl[3];

			array[0] = getByOrganizationCode_PrevAndNext(
				session, employeeOrganization, organizationCode,
				orderByComparator, true);

			array[1] = employeeOrganization;

			array[2] = getByOrganizationCode_PrevAndNext(
				session, employeeOrganization, organizationCode,
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

	protected EmployeeOrganization getByOrganizationCode_PrevAndNext(
		Session session, EmployeeOrganization employeeOrganization,
		String organizationCode,
		OrderByComparator<EmployeeOrganization> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEORGANIZATION_WHERE);

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
			sb.append(EmployeeOrganizationModelImpl.ORDER_BY_JPQL);
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
						employeeOrganization)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeOrganization> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee organizations where organizationCode = &#63; from the database.
	 *
	 * @param organizationCode the organization code
	 */
	@Override
	public void removeByOrganizationCode(String organizationCode) {
		for (EmployeeOrganization employeeOrganization :
				findByOrganizationCode(
					organizationCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(employeeOrganization);
		}
	}

	/**
	 * Returns the number of employee organizations where organizationCode = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @return the number of matching employee organizations
	 */
	@Override
	public int countByOrganizationCode(String organizationCode) {
		organizationCode = Objects.toString(organizationCode, "");

		FinderPath finderPath = _finderPathCountByOrganizationCode;

		Object[] finderArgs = new Object[] {organizationCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEORGANIZATION_WHERE);

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
			"employeeOrganization.organizationCode = ?";

	private static final String
		_FINDER_COLUMN_ORGANIZATIONCODE_ORGANIZATIONCODE_3 =
			"(employeeOrganization.organizationCode IS NULL OR employeeOrganization.organizationCode = '')";

	private FinderPath _finderPathWithPaginationFindBySubOrganizationId;
	private FinderPath _finderPathWithoutPaginationFindBySubOrganizationId;
	private FinderPath _finderPathCountBySubOrganizationId;

	/**
	 * Returns all the employee organizations where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @return the matching employee organizations
	 */
	@Override
	public List<EmployeeOrganization> findBySubOrganizationId(
		long subOrganizationId) {

		return findBySubOrganizationId(
			subOrganizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee organizations where subOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @return the range of matching employee organizations
	 */
	@Override
	public List<EmployeeOrganization> findBySubOrganizationId(
		long subOrganizationId, int start, int end) {

		return findBySubOrganizationId(subOrganizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee organizations where subOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee organizations
	 */
	@Override
	public List<EmployeeOrganization> findBySubOrganizationId(
		long subOrganizationId, int start, int end,
		OrderByComparator<EmployeeOrganization> orderByComparator) {

		return findBySubOrganizationId(
			subOrganizationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee organizations where subOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee organizations
	 */
	@Override
	public List<EmployeeOrganization> findBySubOrganizationId(
		long subOrganizationId, int start, int end,
		OrderByComparator<EmployeeOrganization> orderByComparator,
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

		List<EmployeeOrganization> list = null;

		if (useFinderCache) {
			list = (List<EmployeeOrganization>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeOrganization employeeOrganization : list) {
					if (subOrganizationId !=
							employeeOrganization.getSubOrganizationId()) {

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

			sb.append(_SQL_SELECT_EMPLOYEEORGANIZATION_WHERE);

			sb.append(_FINDER_COLUMN_SUBORGANIZATIONID_SUBORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeOrganizationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(subOrganizationId);

				list = (List<EmployeeOrganization>)QueryUtil.list(
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
	 * Returns the first employee organization in the ordered set where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee organization
	 * @throws NoSuchEmployeeOrganizationException if a matching employee organization could not be found
	 */
	@Override
	public EmployeeOrganization findBySubOrganizationId_First(
			long subOrganizationId,
			OrderByComparator<EmployeeOrganization> orderByComparator)
		throws NoSuchEmployeeOrganizationException {

		EmployeeOrganization employeeOrganization =
			fetchBySubOrganizationId_First(
				subOrganizationId, orderByComparator);

		if (employeeOrganization != null) {
			return employeeOrganization;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("subOrganizationId=");
		sb.append(subOrganizationId);

		sb.append("}");

		throw new NoSuchEmployeeOrganizationException(sb.toString());
	}

	/**
	 * Returns the first employee organization in the ordered set where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee organization, or <code>null</code> if a matching employee organization could not be found
	 */
	@Override
	public EmployeeOrganization fetchBySubOrganizationId_First(
		long subOrganizationId,
		OrderByComparator<EmployeeOrganization> orderByComparator) {

		List<EmployeeOrganization> list = findBySubOrganizationId(
			subOrganizationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee organization in the ordered set where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee organization
	 * @throws NoSuchEmployeeOrganizationException if a matching employee organization could not be found
	 */
	@Override
	public EmployeeOrganization findBySubOrganizationId_Last(
			long subOrganizationId,
			OrderByComparator<EmployeeOrganization> orderByComparator)
		throws NoSuchEmployeeOrganizationException {

		EmployeeOrganization employeeOrganization =
			fetchBySubOrganizationId_Last(subOrganizationId, orderByComparator);

		if (employeeOrganization != null) {
			return employeeOrganization;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("subOrganizationId=");
		sb.append(subOrganizationId);

		sb.append("}");

		throw new NoSuchEmployeeOrganizationException(sb.toString());
	}

	/**
	 * Returns the last employee organization in the ordered set where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee organization, or <code>null</code> if a matching employee organization could not be found
	 */
	@Override
	public EmployeeOrganization fetchBySubOrganizationId_Last(
		long subOrganizationId,
		OrderByComparator<EmployeeOrganization> orderByComparator) {

		int count = countBySubOrganizationId(subOrganizationId);

		if (count == 0) {
			return null;
		}

		List<EmployeeOrganization> list = findBySubOrganizationId(
			subOrganizationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee organizations before and after the current employee organization in the ordered set where subOrganizationId = &#63;.
	 *
	 * @param employeeOrganizationId the primary key of the current employee organization
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee organization
	 * @throws NoSuchEmployeeOrganizationException if a employee organization with the primary key could not be found
	 */
	@Override
	public EmployeeOrganization[] findBySubOrganizationId_PrevAndNext(
			long employeeOrganizationId, long subOrganizationId,
			OrderByComparator<EmployeeOrganization> orderByComparator)
		throws NoSuchEmployeeOrganizationException {

		EmployeeOrganization employeeOrganization = findByPrimaryKey(
			employeeOrganizationId);

		Session session = null;

		try {
			session = openSession();

			EmployeeOrganization[] array = new EmployeeOrganizationImpl[3];

			array[0] = getBySubOrganizationId_PrevAndNext(
				session, employeeOrganization, subOrganizationId,
				orderByComparator, true);

			array[1] = employeeOrganization;

			array[2] = getBySubOrganizationId_PrevAndNext(
				session, employeeOrganization, subOrganizationId,
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

	protected EmployeeOrganization getBySubOrganizationId_PrevAndNext(
		Session session, EmployeeOrganization employeeOrganization,
		long subOrganizationId,
		OrderByComparator<EmployeeOrganization> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEORGANIZATION_WHERE);

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
			sb.append(EmployeeOrganizationModelImpl.ORDER_BY_JPQL);
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
						employeeOrganization)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeOrganization> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee organizations where subOrganizationId = &#63; from the database.
	 *
	 * @param subOrganizationId the sub organization ID
	 */
	@Override
	public void removeBySubOrganizationId(long subOrganizationId) {
		for (EmployeeOrganization employeeOrganization :
				findBySubOrganizationId(
					subOrganizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(employeeOrganization);
		}
	}

	/**
	 * Returns the number of employee organizations where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @return the number of matching employee organizations
	 */
	@Override
	public int countBySubOrganizationId(long subOrganizationId) {
		FinderPath finderPath = _finderPathCountBySubOrganizationId;

		Object[] finderArgs = new Object[] {subOrganizationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEORGANIZATION_WHERE);

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
			"employeeOrganization.subOrganizationId = ?";

	private FinderPath _finderPathWithPaginationFindBySubOrganizationCode;
	private FinderPath _finderPathWithoutPaginationFindBySubOrganizationCode;
	private FinderPath _finderPathCountBySubOrganizationCode;

	/**
	 * Returns all the employee organizations where subOrganizationCode = &#63;.
	 *
	 * @param subOrganizationCode the sub organization code
	 * @return the matching employee organizations
	 */
	@Override
	public List<EmployeeOrganization> findBySubOrganizationCode(
		String subOrganizationCode) {

		return findBySubOrganizationCode(
			subOrganizationCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee organizations where subOrganizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param subOrganizationCode the sub organization code
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @return the range of matching employee organizations
	 */
	@Override
	public List<EmployeeOrganization> findBySubOrganizationCode(
		String subOrganizationCode, int start, int end) {

		return findBySubOrganizationCode(subOrganizationCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee organizations where subOrganizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param subOrganizationCode the sub organization code
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee organizations
	 */
	@Override
	public List<EmployeeOrganization> findBySubOrganizationCode(
		String subOrganizationCode, int start, int end,
		OrderByComparator<EmployeeOrganization> orderByComparator) {

		return findBySubOrganizationCode(
			subOrganizationCode, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee organizations where subOrganizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param subOrganizationCode the sub organization code
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee organizations
	 */
	@Override
	public List<EmployeeOrganization> findBySubOrganizationCode(
		String subOrganizationCode, int start, int end,
		OrderByComparator<EmployeeOrganization> orderByComparator,
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

		List<EmployeeOrganization> list = null;

		if (useFinderCache) {
			list = (List<EmployeeOrganization>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeOrganization employeeOrganization : list) {
					if (!subOrganizationCode.equals(
							employeeOrganization.getSubOrganizationCode())) {

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

			sb.append(_SQL_SELECT_EMPLOYEEORGANIZATION_WHERE);

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
				sb.append(EmployeeOrganizationModelImpl.ORDER_BY_JPQL);
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

				list = (List<EmployeeOrganization>)QueryUtil.list(
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
	 * Returns the first employee organization in the ordered set where subOrganizationCode = &#63;.
	 *
	 * @param subOrganizationCode the sub organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee organization
	 * @throws NoSuchEmployeeOrganizationException if a matching employee organization could not be found
	 */
	@Override
	public EmployeeOrganization findBySubOrganizationCode_First(
			String subOrganizationCode,
			OrderByComparator<EmployeeOrganization> orderByComparator)
		throws NoSuchEmployeeOrganizationException {

		EmployeeOrganization employeeOrganization =
			fetchBySubOrganizationCode_First(
				subOrganizationCode, orderByComparator);

		if (employeeOrganization != null) {
			return employeeOrganization;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("subOrganizationCode=");
		sb.append(subOrganizationCode);

		sb.append("}");

		throw new NoSuchEmployeeOrganizationException(sb.toString());
	}

	/**
	 * Returns the first employee organization in the ordered set where subOrganizationCode = &#63;.
	 *
	 * @param subOrganizationCode the sub organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee organization, or <code>null</code> if a matching employee organization could not be found
	 */
	@Override
	public EmployeeOrganization fetchBySubOrganizationCode_First(
		String subOrganizationCode,
		OrderByComparator<EmployeeOrganization> orderByComparator) {

		List<EmployeeOrganization> list = findBySubOrganizationCode(
			subOrganizationCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee organization in the ordered set where subOrganizationCode = &#63;.
	 *
	 * @param subOrganizationCode the sub organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee organization
	 * @throws NoSuchEmployeeOrganizationException if a matching employee organization could not be found
	 */
	@Override
	public EmployeeOrganization findBySubOrganizationCode_Last(
			String subOrganizationCode,
			OrderByComparator<EmployeeOrganization> orderByComparator)
		throws NoSuchEmployeeOrganizationException {

		EmployeeOrganization employeeOrganization =
			fetchBySubOrganizationCode_Last(
				subOrganizationCode, orderByComparator);

		if (employeeOrganization != null) {
			return employeeOrganization;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("subOrganizationCode=");
		sb.append(subOrganizationCode);

		sb.append("}");

		throw new NoSuchEmployeeOrganizationException(sb.toString());
	}

	/**
	 * Returns the last employee organization in the ordered set where subOrganizationCode = &#63;.
	 *
	 * @param subOrganizationCode the sub organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee organization, or <code>null</code> if a matching employee organization could not be found
	 */
	@Override
	public EmployeeOrganization fetchBySubOrganizationCode_Last(
		String subOrganizationCode,
		OrderByComparator<EmployeeOrganization> orderByComparator) {

		int count = countBySubOrganizationCode(subOrganizationCode);

		if (count == 0) {
			return null;
		}

		List<EmployeeOrganization> list = findBySubOrganizationCode(
			subOrganizationCode, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee organizations before and after the current employee organization in the ordered set where subOrganizationCode = &#63;.
	 *
	 * @param employeeOrganizationId the primary key of the current employee organization
	 * @param subOrganizationCode the sub organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee organization
	 * @throws NoSuchEmployeeOrganizationException if a employee organization with the primary key could not be found
	 */
	@Override
	public EmployeeOrganization[] findBySubOrganizationCode_PrevAndNext(
			long employeeOrganizationId, String subOrganizationCode,
			OrderByComparator<EmployeeOrganization> orderByComparator)
		throws NoSuchEmployeeOrganizationException {

		subOrganizationCode = Objects.toString(subOrganizationCode, "");

		EmployeeOrganization employeeOrganization = findByPrimaryKey(
			employeeOrganizationId);

		Session session = null;

		try {
			session = openSession();

			EmployeeOrganization[] array = new EmployeeOrganizationImpl[3];

			array[0] = getBySubOrganizationCode_PrevAndNext(
				session, employeeOrganization, subOrganizationCode,
				orderByComparator, true);

			array[1] = employeeOrganization;

			array[2] = getBySubOrganizationCode_PrevAndNext(
				session, employeeOrganization, subOrganizationCode,
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

	protected EmployeeOrganization getBySubOrganizationCode_PrevAndNext(
		Session session, EmployeeOrganization employeeOrganization,
		String subOrganizationCode,
		OrderByComparator<EmployeeOrganization> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEORGANIZATION_WHERE);

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
			sb.append(EmployeeOrganizationModelImpl.ORDER_BY_JPQL);
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
						employeeOrganization)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeOrganization> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee organizations where subOrganizationCode = &#63; from the database.
	 *
	 * @param subOrganizationCode the sub organization code
	 */
	@Override
	public void removeBySubOrganizationCode(String subOrganizationCode) {
		for (EmployeeOrganization employeeOrganization :
				findBySubOrganizationCode(
					subOrganizationCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(employeeOrganization);
		}
	}

	/**
	 * Returns the number of employee organizations where subOrganizationCode = &#63;.
	 *
	 * @param subOrganizationCode the sub organization code
	 * @return the number of matching employee organizations
	 */
	@Override
	public int countBySubOrganizationCode(String subOrganizationCode) {
		subOrganizationCode = Objects.toString(subOrganizationCode, "");

		FinderPath finderPath = _finderPathCountBySubOrganizationCode;

		Object[] finderArgs = new Object[] {subOrganizationCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEORGANIZATION_WHERE);

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
			"employeeOrganization.subOrganizationCode = ?";

	private static final String
		_FINDER_COLUMN_SUBORGANIZATIONCODE_SUBORGANIZATIONCODE_3 =
			"(employeeOrganization.subOrganizationCode IS NULL OR employeeOrganization.subOrganizationCode = '')";

	public EmployeeOrganizationPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(EmployeeOrganization.class);

		setModelImplClass(EmployeeOrganizationImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the employee organization in the entity cache if it is enabled.
	 *
	 * @param employeeOrganization the employee organization
	 */
	@Override
	public void cacheResult(EmployeeOrganization employeeOrganization) {
		entityCache.putResult(
			EmployeeOrganizationImpl.class,
			employeeOrganization.getPrimaryKey(), employeeOrganization);
	}

	/**
	 * Caches the employee organizations in the entity cache if it is enabled.
	 *
	 * @param employeeOrganizations the employee organizations
	 */
	@Override
	public void cacheResult(List<EmployeeOrganization> employeeOrganizations) {
		for (EmployeeOrganization employeeOrganization :
				employeeOrganizations) {

			if (entityCache.getResult(
					EmployeeOrganizationImpl.class,
					employeeOrganization.getPrimaryKey()) == null) {

				cacheResult(employeeOrganization);
			}
		}
	}

	/**
	 * Clears the cache for all employee organizations.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmployeeOrganizationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the employee organization.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmployeeOrganization employeeOrganization) {
		entityCache.removeResult(
			EmployeeOrganizationImpl.class, employeeOrganization);
	}

	@Override
	public void clearCache(List<EmployeeOrganization> employeeOrganizations) {
		for (EmployeeOrganization employeeOrganization :
				employeeOrganizations) {

			entityCache.removeResult(
				EmployeeOrganizationImpl.class, employeeOrganization);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				EmployeeOrganizationImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new employee organization with the primary key. Does not add the employee organization to the database.
	 *
	 * @param employeeOrganizationId the primary key for the new employee organization
	 * @return the new employee organization
	 */
	@Override
	public EmployeeOrganization create(long employeeOrganizationId) {
		EmployeeOrganization employeeOrganization =
			new EmployeeOrganizationImpl();

		employeeOrganization.setNew(true);
		employeeOrganization.setPrimaryKey(employeeOrganizationId);

		employeeOrganization.setCompanyId(CompanyThreadLocal.getCompanyId());

		return employeeOrganization;
	}

	/**
	 * Removes the employee organization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeOrganizationId the primary key of the employee organization
	 * @return the employee organization that was removed
	 * @throws NoSuchEmployeeOrganizationException if a employee organization with the primary key could not be found
	 */
	@Override
	public EmployeeOrganization remove(long employeeOrganizationId)
		throws NoSuchEmployeeOrganizationException {

		return remove((Serializable)employeeOrganizationId);
	}

	/**
	 * Removes the employee organization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the employee organization
	 * @return the employee organization that was removed
	 * @throws NoSuchEmployeeOrganizationException if a employee organization with the primary key could not be found
	 */
	@Override
	public EmployeeOrganization remove(Serializable primaryKey)
		throws NoSuchEmployeeOrganizationException {

		Session session = null;

		try {
			session = openSession();

			EmployeeOrganization employeeOrganization =
				(EmployeeOrganization)session.get(
					EmployeeOrganizationImpl.class, primaryKey);

			if (employeeOrganization == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmployeeOrganizationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(employeeOrganization);
		}
		catch (NoSuchEmployeeOrganizationException noSuchEntityException) {
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
	protected EmployeeOrganization removeImpl(
		EmployeeOrganization employeeOrganization) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(employeeOrganization)) {
				employeeOrganization = (EmployeeOrganization)session.get(
					EmployeeOrganizationImpl.class,
					employeeOrganization.getPrimaryKeyObj());
			}

			if (employeeOrganization != null) {
				session.delete(employeeOrganization);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (employeeOrganization != null) {
			clearCache(employeeOrganization);
		}

		return employeeOrganization;
	}

	@Override
	public EmployeeOrganization updateImpl(
		EmployeeOrganization employeeOrganization) {

		boolean isNew = employeeOrganization.isNew();

		if (!(employeeOrganization instanceof EmployeeOrganizationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(employeeOrganization.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					employeeOrganization);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in employeeOrganization proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EmployeeOrganization implementation " +
					employeeOrganization.getClass());
		}

		EmployeeOrganizationModelImpl employeeOrganizationModelImpl =
			(EmployeeOrganizationModelImpl)employeeOrganization;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (employeeOrganization.getCreateDate() == null)) {
			if (serviceContext == null) {
				employeeOrganization.setCreateDate(now);
			}
			else {
				employeeOrganization.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!employeeOrganizationModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				employeeOrganization.setModifiedDate(now);
			}
			else {
				employeeOrganization.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(employeeOrganization);
			}
			else {
				employeeOrganization = (EmployeeOrganization)session.merge(
					employeeOrganization);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EmployeeOrganizationImpl.class, employeeOrganizationModelImpl,
			false, true);

		if (isNew) {
			employeeOrganization.setNew(false);
		}

		employeeOrganization.resetOriginalValues();

		return employeeOrganization;
	}

	/**
	 * Returns the employee organization with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee organization
	 * @return the employee organization
	 * @throws NoSuchEmployeeOrganizationException if a employee organization with the primary key could not be found
	 */
	@Override
	public EmployeeOrganization findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmployeeOrganizationException {

		EmployeeOrganization employeeOrganization = fetchByPrimaryKey(
			primaryKey);

		if (employeeOrganization == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmployeeOrganizationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return employeeOrganization;
	}

	/**
	 * Returns the employee organization with the primary key or throws a <code>NoSuchEmployeeOrganizationException</code> if it could not be found.
	 *
	 * @param employeeOrganizationId the primary key of the employee organization
	 * @return the employee organization
	 * @throws NoSuchEmployeeOrganizationException if a employee organization with the primary key could not be found
	 */
	@Override
	public EmployeeOrganization findByPrimaryKey(long employeeOrganizationId)
		throws NoSuchEmployeeOrganizationException {

		return findByPrimaryKey((Serializable)employeeOrganizationId);
	}

	/**
	 * Returns the employee organization with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeOrganizationId the primary key of the employee organization
	 * @return the employee organization, or <code>null</code> if a employee organization with the primary key could not be found
	 */
	@Override
	public EmployeeOrganization fetchByPrimaryKey(long employeeOrganizationId) {
		return fetchByPrimaryKey((Serializable)employeeOrganizationId);
	}

	/**
	 * Returns all the employee organizations.
	 *
	 * @return the employee organizations
	 */
	@Override
	public List<EmployeeOrganization> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee organizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @return the range of employee organizations
	 */
	@Override
	public List<EmployeeOrganization> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee organizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee organizations
	 */
	@Override
	public List<EmployeeOrganization> findAll(
		int start, int end,
		OrderByComparator<EmployeeOrganization> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee organizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee organizations
	 */
	@Override
	public List<EmployeeOrganization> findAll(
		int start, int end,
		OrderByComparator<EmployeeOrganization> orderByComparator,
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

		List<EmployeeOrganization> list = null;

		if (useFinderCache) {
			list = (List<EmployeeOrganization>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EMPLOYEEORGANIZATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLOYEEORGANIZATION;

				sql = sql.concat(EmployeeOrganizationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EmployeeOrganization>)QueryUtil.list(
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
	 * Removes all the employee organizations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EmployeeOrganization employeeOrganization : findAll()) {
			remove(employeeOrganization);
		}
	}

	/**
	 * Returns the number of employee organizations.
	 *
	 * @return the number of employee organizations
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
					_SQL_COUNT_EMPLOYEEORGANIZATION);

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
		return "employeeOrganizationId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EMPLOYEEORGANIZATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EmployeeOrganizationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the employee organization persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new EmployeeOrganizationModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", EmployeeOrganization.class.getName()));

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

		_finderPathWithPaginationFindByEmployeeIdAndOrganizationId =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByEmployeeIdAndOrganizationId",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {"employeeId", "organizationId"}, true);

		_finderPathWithoutPaginationFindByEmployeeIdAndOrganizationId =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByEmployeeIdAndOrganizationId",
				new String[] {Long.class.getName(), Long.class.getName()},
				new String[] {"employeeId", "organizationId"}, true);

		_finderPathCountByEmployeeIdAndOrganizationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByEmployeeIdAndOrganizationId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"employeeId", "organizationId"}, false);

		_finderPathWithPaginationFindByEmployeeIdAndSubOrganizationId =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByEmployeeIdAndSubOrganizationId",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {"employeeId", "subOrganizationId"}, true);

		_finderPathWithoutPaginationFindByEmployeeIdAndSubOrganizationId =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByEmployeeIdAndSubOrganizationId",
				new String[] {Long.class.getName(), Long.class.getName()},
				new String[] {"employeeId", "subOrganizationId"}, true);

		_finderPathCountByEmployeeIdAndSubOrganizationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByEmployeeIdAndSubOrganizationId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"employeeId", "subOrganizationId"}, false);

		_finderPathWithPaginationFindBySubOrganizationIdAndActive =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findBySubOrganizationIdAndActive",
				new String[] {
					Long.class.getName(), Boolean.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {"subOrganizationId", "active_"}, true);

		_finderPathWithoutPaginationFindBySubOrganizationIdAndActive =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findBySubOrganizationIdAndActive",
				new String[] {Long.class.getName(), Boolean.class.getName()},
				new String[] {"subOrganizationId", "active_"}, true);

		_finderPathCountBySubOrganizationIdAndActive = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySubOrganizationIdAndActive",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"subOrganizationId", "active_"}, false);

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
		entityCache.removeCache(EmployeeOrganizationImpl.class.getName());

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

	private static final String _SQL_SELECT_EMPLOYEEORGANIZATION =
		"SELECT employeeOrganization FROM EmployeeOrganization employeeOrganization";

	private static final String _SQL_SELECT_EMPLOYEEORGANIZATION_WHERE =
		"SELECT employeeOrganization FROM EmployeeOrganization employeeOrganization WHERE ";

	private static final String _SQL_COUNT_EMPLOYEEORGANIZATION =
		"SELECT COUNT(employeeOrganization) FROM EmployeeOrganization employeeOrganization";

	private static final String _SQL_COUNT_EMPLOYEEORGANIZATION_WHERE =
		"SELECT COUNT(employeeOrganization) FROM EmployeeOrganization employeeOrganization WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"employeeOrganization.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EmployeeOrganization exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EmployeeOrganization exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EmployeeOrganizationPersistenceImpl.class);

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

	private static class EmployeeOrganizationModelArgumentsResolver
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

			EmployeeOrganizationModelImpl employeeOrganizationModelImpl =
				(EmployeeOrganizationModelImpl)baseModel;

			long columnBitmask =
				employeeOrganizationModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					employeeOrganizationModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						employeeOrganizationModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					employeeOrganizationModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			EmployeeOrganizationModelImpl employeeOrganizationModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						employeeOrganizationModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = employeeOrganizationModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}