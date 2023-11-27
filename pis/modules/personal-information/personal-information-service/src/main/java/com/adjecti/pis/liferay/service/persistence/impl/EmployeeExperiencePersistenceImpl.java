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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeExperienceException;
import com.adjecti.pis.liferay.model.EmployeeExperience;
import com.adjecti.pis.liferay.model.impl.EmployeeExperienceImpl;
import com.adjecti.pis.liferay.model.impl.EmployeeExperienceModelImpl;
import com.adjecti.pis.liferay.service.persistence.EmployeeExperiencePersistence;
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
 * The persistence implementation for the employee experience service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EmployeeExperiencePersistence.class)
public class EmployeeExperiencePersistenceImpl
	extends BasePersistenceImpl<EmployeeExperience>
	implements EmployeeExperiencePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EmployeeExperienceUtil</code> to access the employee experience persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EmployeeExperienceImpl.class.getName();

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
	 * Returns all the employee experiences where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee experiences
	 */
	@Override
	public List<EmployeeExperience> findByEmployeeId(long employeeId) {
		return findByEmployeeId(
			employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee experiences where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @return the range of matching employee experiences
	 */
	@Override
	public List<EmployeeExperience> findByEmployeeId(
		long employeeId, int start, int end) {

		return findByEmployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee experiences where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee experiences
	 */
	@Override
	public List<EmployeeExperience> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeExperience> orderByComparator) {

		return findByEmployeeId(
			employeeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee experiences where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee experiences
	 */
	@Override
	public List<EmployeeExperience> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeExperience> orderByComparator,
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

		List<EmployeeExperience> list = null;

		if (useFinderCache) {
			list = (List<EmployeeExperience>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeExperience employeeExperience : list) {
					if (employeeId != employeeExperience.getEmployeeId()) {
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

			sb.append(_SQL_SELECT_EMPLOYEEEXPERIENCE_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeExperienceModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				list = (List<EmployeeExperience>)QueryUtil.list(
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
	 * Returns the first employee experience in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee experience
	 * @throws NoSuchEmployeeExperienceException if a matching employee experience could not be found
	 */
	@Override
	public EmployeeExperience findByEmployeeId_First(
			long employeeId,
			OrderByComparator<EmployeeExperience> orderByComparator)
		throws NoSuchEmployeeExperienceException {

		EmployeeExperience employeeExperience = fetchByEmployeeId_First(
			employeeId, orderByComparator);

		if (employeeExperience != null) {
			return employeeExperience;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeeExperienceException(sb.toString());
	}

	/**
	 * Returns the first employee experience in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee experience, or <code>null</code> if a matching employee experience could not be found
	 */
	@Override
	public EmployeeExperience fetchByEmployeeId_First(
		long employeeId,
		OrderByComparator<EmployeeExperience> orderByComparator) {

		List<EmployeeExperience> list = findByEmployeeId(
			employeeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee experience in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee experience
	 * @throws NoSuchEmployeeExperienceException if a matching employee experience could not be found
	 */
	@Override
	public EmployeeExperience findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<EmployeeExperience> orderByComparator)
		throws NoSuchEmployeeExperienceException {

		EmployeeExperience employeeExperience = fetchByEmployeeId_Last(
			employeeId, orderByComparator);

		if (employeeExperience != null) {
			return employeeExperience;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeeExperienceException(sb.toString());
	}

	/**
	 * Returns the last employee experience in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee experience, or <code>null</code> if a matching employee experience could not be found
	 */
	@Override
	public EmployeeExperience fetchByEmployeeId_Last(
		long employeeId,
		OrderByComparator<EmployeeExperience> orderByComparator) {

		int count = countByEmployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<EmployeeExperience> list = findByEmployeeId(
			employeeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee experiences before and after the current employee experience in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeExperienceId the primary key of the current employee experience
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee experience
	 * @throws NoSuchEmployeeExperienceException if a employee experience with the primary key could not be found
	 */
	@Override
	public EmployeeExperience[] findByEmployeeId_PrevAndNext(
			long employeeExperienceId, long employeeId,
			OrderByComparator<EmployeeExperience> orderByComparator)
		throws NoSuchEmployeeExperienceException {

		EmployeeExperience employeeExperience = findByPrimaryKey(
			employeeExperienceId);

		Session session = null;

		try {
			session = openSession();

			EmployeeExperience[] array = new EmployeeExperienceImpl[3];

			array[0] = getByEmployeeId_PrevAndNext(
				session, employeeExperience, employeeId, orderByComparator,
				true);

			array[1] = employeeExperience;

			array[2] = getByEmployeeId_PrevAndNext(
				session, employeeExperience, employeeId, orderByComparator,
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

	protected EmployeeExperience getByEmployeeId_PrevAndNext(
		Session session, EmployeeExperience employeeExperience, long employeeId,
		OrderByComparator<EmployeeExperience> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEEXPERIENCE_WHERE);

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
			sb.append(EmployeeExperienceModelImpl.ORDER_BY_JPQL);
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
						employeeExperience)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeExperience> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee experiences where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeByEmployeeId(long employeeId) {
		for (EmployeeExperience employeeExperience :
				findByEmployeeId(
					employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeeExperience);
		}
	}

	/**
	 * Returns the number of employee experiences where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee experiences
	 */
	@Override
	public int countByEmployeeId(long employeeId) {
		FinderPath finderPath = _finderPathCountByEmployeeId;

		Object[] finderArgs = new Object[] {employeeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEEXPERIENCE_WHERE);

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
		"employeeExperience.employeeId = ?";

	private FinderPath _finderPathWithPaginationFindByOrganizationId;
	private FinderPath _finderPathWithoutPaginationFindByOrganizationId;
	private FinderPath _finderPathCountByOrganizationId;

	/**
	 * Returns all the employee experiences where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching employee experiences
	 */
	@Override
	public List<EmployeeExperience> findByOrganizationId(long organizationId) {
		return findByOrganizationId(
			organizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee experiences where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @return the range of matching employee experiences
	 */
	@Override
	public List<EmployeeExperience> findByOrganizationId(
		long organizationId, int start, int end) {

		return findByOrganizationId(organizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee experiences where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee experiences
	 */
	@Override
	public List<EmployeeExperience> findByOrganizationId(
		long organizationId, int start, int end,
		OrderByComparator<EmployeeExperience> orderByComparator) {

		return findByOrganizationId(
			organizationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee experiences where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee experiences
	 */
	@Override
	public List<EmployeeExperience> findByOrganizationId(
		long organizationId, int start, int end,
		OrderByComparator<EmployeeExperience> orderByComparator,
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

		List<EmployeeExperience> list = null;

		if (useFinderCache) {
			list = (List<EmployeeExperience>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeExperience employeeExperience : list) {
					if (organizationId !=
							employeeExperience.getOrganizationId()) {

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

			sb.append(_SQL_SELECT_EMPLOYEEEXPERIENCE_WHERE);

			sb.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeExperienceModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(organizationId);

				list = (List<EmployeeExperience>)QueryUtil.list(
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
	 * Returns the first employee experience in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee experience
	 * @throws NoSuchEmployeeExperienceException if a matching employee experience could not be found
	 */
	@Override
	public EmployeeExperience findByOrganizationId_First(
			long organizationId,
			OrderByComparator<EmployeeExperience> orderByComparator)
		throws NoSuchEmployeeExperienceException {

		EmployeeExperience employeeExperience = fetchByOrganizationId_First(
			organizationId, orderByComparator);

		if (employeeExperience != null) {
			return employeeExperience;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("organizationId=");
		sb.append(organizationId);

		sb.append("}");

		throw new NoSuchEmployeeExperienceException(sb.toString());
	}

	/**
	 * Returns the first employee experience in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee experience, or <code>null</code> if a matching employee experience could not be found
	 */
	@Override
	public EmployeeExperience fetchByOrganizationId_First(
		long organizationId,
		OrderByComparator<EmployeeExperience> orderByComparator) {

		List<EmployeeExperience> list = findByOrganizationId(
			organizationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee experience in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee experience
	 * @throws NoSuchEmployeeExperienceException if a matching employee experience could not be found
	 */
	@Override
	public EmployeeExperience findByOrganizationId_Last(
			long organizationId,
			OrderByComparator<EmployeeExperience> orderByComparator)
		throws NoSuchEmployeeExperienceException {

		EmployeeExperience employeeExperience = fetchByOrganizationId_Last(
			organizationId, orderByComparator);

		if (employeeExperience != null) {
			return employeeExperience;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("organizationId=");
		sb.append(organizationId);

		sb.append("}");

		throw new NoSuchEmployeeExperienceException(sb.toString());
	}

	/**
	 * Returns the last employee experience in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee experience, or <code>null</code> if a matching employee experience could not be found
	 */
	@Override
	public EmployeeExperience fetchByOrganizationId_Last(
		long organizationId,
		OrderByComparator<EmployeeExperience> orderByComparator) {

		int count = countByOrganizationId(organizationId);

		if (count == 0) {
			return null;
		}

		List<EmployeeExperience> list = findByOrganizationId(
			organizationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee experiences before and after the current employee experience in the ordered set where organizationId = &#63;.
	 *
	 * @param employeeExperienceId the primary key of the current employee experience
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee experience
	 * @throws NoSuchEmployeeExperienceException if a employee experience with the primary key could not be found
	 */
	@Override
	public EmployeeExperience[] findByOrganizationId_PrevAndNext(
			long employeeExperienceId, long organizationId,
			OrderByComparator<EmployeeExperience> orderByComparator)
		throws NoSuchEmployeeExperienceException {

		EmployeeExperience employeeExperience = findByPrimaryKey(
			employeeExperienceId);

		Session session = null;

		try {
			session = openSession();

			EmployeeExperience[] array = new EmployeeExperienceImpl[3];

			array[0] = getByOrganizationId_PrevAndNext(
				session, employeeExperience, organizationId, orderByComparator,
				true);

			array[1] = employeeExperience;

			array[2] = getByOrganizationId_PrevAndNext(
				session, employeeExperience, organizationId, orderByComparator,
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

	protected EmployeeExperience getByOrganizationId_PrevAndNext(
		Session session, EmployeeExperience employeeExperience,
		long organizationId,
		OrderByComparator<EmployeeExperience> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEEXPERIENCE_WHERE);

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
			sb.append(EmployeeExperienceModelImpl.ORDER_BY_JPQL);
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
						employeeExperience)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeExperience> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee experiences where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	@Override
	public void removeByOrganizationId(long organizationId) {
		for (EmployeeExperience employeeExperience :
				findByOrganizationId(
					organizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(employeeExperience);
		}
	}

	/**
	 * Returns the number of employee experiences where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching employee experiences
	 */
	@Override
	public int countByOrganizationId(long organizationId) {
		FinderPath finderPath = _finderPathCountByOrganizationId;

		Object[] finderArgs = new Object[] {organizationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEEXPERIENCE_WHERE);

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
		"employeeExperience.organizationId = ?";

	private FinderPath _finderPathWithPaginationFindByWorkAreaMinorId;
	private FinderPath _finderPathWithoutPaginationFindByWorkAreaMinorId;
	private FinderPath _finderPathCountByWorkAreaMinorId;

	/**
	 * Returns all the employee experiences where workAreaMinorId = &#63;.
	 *
	 * @param workAreaMinorId the work area minor ID
	 * @return the matching employee experiences
	 */
	@Override
	public List<EmployeeExperience> findByWorkAreaMinorId(
		long workAreaMinorId) {

		return findByWorkAreaMinorId(
			workAreaMinorId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee experiences where workAreaMinorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param workAreaMinorId the work area minor ID
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @return the range of matching employee experiences
	 */
	@Override
	public List<EmployeeExperience> findByWorkAreaMinorId(
		long workAreaMinorId, int start, int end) {

		return findByWorkAreaMinorId(workAreaMinorId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee experiences where workAreaMinorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param workAreaMinorId the work area minor ID
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee experiences
	 */
	@Override
	public List<EmployeeExperience> findByWorkAreaMinorId(
		long workAreaMinorId, int start, int end,
		OrderByComparator<EmployeeExperience> orderByComparator) {

		return findByWorkAreaMinorId(
			workAreaMinorId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee experiences where workAreaMinorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param workAreaMinorId the work area minor ID
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee experiences
	 */
	@Override
	public List<EmployeeExperience> findByWorkAreaMinorId(
		long workAreaMinorId, int start, int end,
		OrderByComparator<EmployeeExperience> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByWorkAreaMinorId;
				finderArgs = new Object[] {workAreaMinorId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByWorkAreaMinorId;
			finderArgs = new Object[] {
				workAreaMinorId, start, end, orderByComparator
			};
		}

		List<EmployeeExperience> list = null;

		if (useFinderCache) {
			list = (List<EmployeeExperience>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeExperience employeeExperience : list) {
					if (workAreaMinorId !=
							employeeExperience.getWorkAreaMinorId()) {

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

			sb.append(_SQL_SELECT_EMPLOYEEEXPERIENCE_WHERE);

			sb.append(_FINDER_COLUMN_WORKAREAMINORID_WORKAREAMINORID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeExperienceModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(workAreaMinorId);

				list = (List<EmployeeExperience>)QueryUtil.list(
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
	 * Returns the first employee experience in the ordered set where workAreaMinorId = &#63;.
	 *
	 * @param workAreaMinorId the work area minor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee experience
	 * @throws NoSuchEmployeeExperienceException if a matching employee experience could not be found
	 */
	@Override
	public EmployeeExperience findByWorkAreaMinorId_First(
			long workAreaMinorId,
			OrderByComparator<EmployeeExperience> orderByComparator)
		throws NoSuchEmployeeExperienceException {

		EmployeeExperience employeeExperience = fetchByWorkAreaMinorId_First(
			workAreaMinorId, orderByComparator);

		if (employeeExperience != null) {
			return employeeExperience;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("workAreaMinorId=");
		sb.append(workAreaMinorId);

		sb.append("}");

		throw new NoSuchEmployeeExperienceException(sb.toString());
	}

	/**
	 * Returns the first employee experience in the ordered set where workAreaMinorId = &#63;.
	 *
	 * @param workAreaMinorId the work area minor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee experience, or <code>null</code> if a matching employee experience could not be found
	 */
	@Override
	public EmployeeExperience fetchByWorkAreaMinorId_First(
		long workAreaMinorId,
		OrderByComparator<EmployeeExperience> orderByComparator) {

		List<EmployeeExperience> list = findByWorkAreaMinorId(
			workAreaMinorId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee experience in the ordered set where workAreaMinorId = &#63;.
	 *
	 * @param workAreaMinorId the work area minor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee experience
	 * @throws NoSuchEmployeeExperienceException if a matching employee experience could not be found
	 */
	@Override
	public EmployeeExperience findByWorkAreaMinorId_Last(
			long workAreaMinorId,
			OrderByComparator<EmployeeExperience> orderByComparator)
		throws NoSuchEmployeeExperienceException {

		EmployeeExperience employeeExperience = fetchByWorkAreaMinorId_Last(
			workAreaMinorId, orderByComparator);

		if (employeeExperience != null) {
			return employeeExperience;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("workAreaMinorId=");
		sb.append(workAreaMinorId);

		sb.append("}");

		throw new NoSuchEmployeeExperienceException(sb.toString());
	}

	/**
	 * Returns the last employee experience in the ordered set where workAreaMinorId = &#63;.
	 *
	 * @param workAreaMinorId the work area minor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee experience, or <code>null</code> if a matching employee experience could not be found
	 */
	@Override
	public EmployeeExperience fetchByWorkAreaMinorId_Last(
		long workAreaMinorId,
		OrderByComparator<EmployeeExperience> orderByComparator) {

		int count = countByWorkAreaMinorId(workAreaMinorId);

		if (count == 0) {
			return null;
		}

		List<EmployeeExperience> list = findByWorkAreaMinorId(
			workAreaMinorId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee experiences before and after the current employee experience in the ordered set where workAreaMinorId = &#63;.
	 *
	 * @param employeeExperienceId the primary key of the current employee experience
	 * @param workAreaMinorId the work area minor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee experience
	 * @throws NoSuchEmployeeExperienceException if a employee experience with the primary key could not be found
	 */
	@Override
	public EmployeeExperience[] findByWorkAreaMinorId_PrevAndNext(
			long employeeExperienceId, long workAreaMinorId,
			OrderByComparator<EmployeeExperience> orderByComparator)
		throws NoSuchEmployeeExperienceException {

		EmployeeExperience employeeExperience = findByPrimaryKey(
			employeeExperienceId);

		Session session = null;

		try {
			session = openSession();

			EmployeeExperience[] array = new EmployeeExperienceImpl[3];

			array[0] = getByWorkAreaMinorId_PrevAndNext(
				session, employeeExperience, workAreaMinorId, orderByComparator,
				true);

			array[1] = employeeExperience;

			array[2] = getByWorkAreaMinorId_PrevAndNext(
				session, employeeExperience, workAreaMinorId, orderByComparator,
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

	protected EmployeeExperience getByWorkAreaMinorId_PrevAndNext(
		Session session, EmployeeExperience employeeExperience,
		long workAreaMinorId,
		OrderByComparator<EmployeeExperience> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEEXPERIENCE_WHERE);

		sb.append(_FINDER_COLUMN_WORKAREAMINORID_WORKAREAMINORID_2);

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
			sb.append(EmployeeExperienceModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(workAreaMinorId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						employeeExperience)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeExperience> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee experiences where workAreaMinorId = &#63; from the database.
	 *
	 * @param workAreaMinorId the work area minor ID
	 */
	@Override
	public void removeByWorkAreaMinorId(long workAreaMinorId) {
		for (EmployeeExperience employeeExperience :
				findByWorkAreaMinorId(
					workAreaMinorId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(employeeExperience);
		}
	}

	/**
	 * Returns the number of employee experiences where workAreaMinorId = &#63;.
	 *
	 * @param workAreaMinorId the work area minor ID
	 * @return the number of matching employee experiences
	 */
	@Override
	public int countByWorkAreaMinorId(long workAreaMinorId) {
		FinderPath finderPath = _finderPathCountByWorkAreaMinorId;

		Object[] finderArgs = new Object[] {workAreaMinorId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEEXPERIENCE_WHERE);

			sb.append(_FINDER_COLUMN_WORKAREAMINORID_WORKAREAMINORID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(workAreaMinorId);

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
		_FINDER_COLUMN_WORKAREAMINORID_WORKAREAMINORID_2 =
			"employeeExperience.workAreaMinorId = ?";

	private FinderPath _finderPathWithPaginationFindByWorkAreaId;
	private FinderPath _finderPathWithoutPaginationFindByWorkAreaId;
	private FinderPath _finderPathCountByWorkAreaId;

	/**
	 * Returns all the employee experiences where workAreaId = &#63;.
	 *
	 * @param workAreaId the work area ID
	 * @return the matching employee experiences
	 */
	@Override
	public List<EmployeeExperience> findByWorkAreaId(long workAreaId) {
		return findByWorkAreaId(
			workAreaId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee experiences where workAreaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param workAreaId the work area ID
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @return the range of matching employee experiences
	 */
	@Override
	public List<EmployeeExperience> findByWorkAreaId(
		long workAreaId, int start, int end) {

		return findByWorkAreaId(workAreaId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee experiences where workAreaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param workAreaId the work area ID
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee experiences
	 */
	@Override
	public List<EmployeeExperience> findByWorkAreaId(
		long workAreaId, int start, int end,
		OrderByComparator<EmployeeExperience> orderByComparator) {

		return findByWorkAreaId(
			workAreaId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee experiences where workAreaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param workAreaId the work area ID
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee experiences
	 */
	@Override
	public List<EmployeeExperience> findByWorkAreaId(
		long workAreaId, int start, int end,
		OrderByComparator<EmployeeExperience> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByWorkAreaId;
				finderArgs = new Object[] {workAreaId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByWorkAreaId;
			finderArgs = new Object[] {
				workAreaId, start, end, orderByComparator
			};
		}

		List<EmployeeExperience> list = null;

		if (useFinderCache) {
			list = (List<EmployeeExperience>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeExperience employeeExperience : list) {
					if (workAreaId != employeeExperience.getWorkAreaId()) {
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

			sb.append(_SQL_SELECT_EMPLOYEEEXPERIENCE_WHERE);

			sb.append(_FINDER_COLUMN_WORKAREAID_WORKAREAID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeExperienceModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(workAreaId);

				list = (List<EmployeeExperience>)QueryUtil.list(
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
	 * Returns the first employee experience in the ordered set where workAreaId = &#63;.
	 *
	 * @param workAreaId the work area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee experience
	 * @throws NoSuchEmployeeExperienceException if a matching employee experience could not be found
	 */
	@Override
	public EmployeeExperience findByWorkAreaId_First(
			long workAreaId,
			OrderByComparator<EmployeeExperience> orderByComparator)
		throws NoSuchEmployeeExperienceException {

		EmployeeExperience employeeExperience = fetchByWorkAreaId_First(
			workAreaId, orderByComparator);

		if (employeeExperience != null) {
			return employeeExperience;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("workAreaId=");
		sb.append(workAreaId);

		sb.append("}");

		throw new NoSuchEmployeeExperienceException(sb.toString());
	}

	/**
	 * Returns the first employee experience in the ordered set where workAreaId = &#63;.
	 *
	 * @param workAreaId the work area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee experience, or <code>null</code> if a matching employee experience could not be found
	 */
	@Override
	public EmployeeExperience fetchByWorkAreaId_First(
		long workAreaId,
		OrderByComparator<EmployeeExperience> orderByComparator) {

		List<EmployeeExperience> list = findByWorkAreaId(
			workAreaId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee experience in the ordered set where workAreaId = &#63;.
	 *
	 * @param workAreaId the work area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee experience
	 * @throws NoSuchEmployeeExperienceException if a matching employee experience could not be found
	 */
	@Override
	public EmployeeExperience findByWorkAreaId_Last(
			long workAreaId,
			OrderByComparator<EmployeeExperience> orderByComparator)
		throws NoSuchEmployeeExperienceException {

		EmployeeExperience employeeExperience = fetchByWorkAreaId_Last(
			workAreaId, orderByComparator);

		if (employeeExperience != null) {
			return employeeExperience;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("workAreaId=");
		sb.append(workAreaId);

		sb.append("}");

		throw new NoSuchEmployeeExperienceException(sb.toString());
	}

	/**
	 * Returns the last employee experience in the ordered set where workAreaId = &#63;.
	 *
	 * @param workAreaId the work area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee experience, or <code>null</code> if a matching employee experience could not be found
	 */
	@Override
	public EmployeeExperience fetchByWorkAreaId_Last(
		long workAreaId,
		OrderByComparator<EmployeeExperience> orderByComparator) {

		int count = countByWorkAreaId(workAreaId);

		if (count == 0) {
			return null;
		}

		List<EmployeeExperience> list = findByWorkAreaId(
			workAreaId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee experiences before and after the current employee experience in the ordered set where workAreaId = &#63;.
	 *
	 * @param employeeExperienceId the primary key of the current employee experience
	 * @param workAreaId the work area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee experience
	 * @throws NoSuchEmployeeExperienceException if a employee experience with the primary key could not be found
	 */
	@Override
	public EmployeeExperience[] findByWorkAreaId_PrevAndNext(
			long employeeExperienceId, long workAreaId,
			OrderByComparator<EmployeeExperience> orderByComparator)
		throws NoSuchEmployeeExperienceException {

		EmployeeExperience employeeExperience = findByPrimaryKey(
			employeeExperienceId);

		Session session = null;

		try {
			session = openSession();

			EmployeeExperience[] array = new EmployeeExperienceImpl[3];

			array[0] = getByWorkAreaId_PrevAndNext(
				session, employeeExperience, workAreaId, orderByComparator,
				true);

			array[1] = employeeExperience;

			array[2] = getByWorkAreaId_PrevAndNext(
				session, employeeExperience, workAreaId, orderByComparator,
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

	protected EmployeeExperience getByWorkAreaId_PrevAndNext(
		Session session, EmployeeExperience employeeExperience, long workAreaId,
		OrderByComparator<EmployeeExperience> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEEXPERIENCE_WHERE);

		sb.append(_FINDER_COLUMN_WORKAREAID_WORKAREAID_2);

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
			sb.append(EmployeeExperienceModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(workAreaId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						employeeExperience)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeExperience> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee experiences where workAreaId = &#63; from the database.
	 *
	 * @param workAreaId the work area ID
	 */
	@Override
	public void removeByWorkAreaId(long workAreaId) {
		for (EmployeeExperience employeeExperience :
				findByWorkAreaId(
					workAreaId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeeExperience);
		}
	}

	/**
	 * Returns the number of employee experiences where workAreaId = &#63;.
	 *
	 * @param workAreaId the work area ID
	 * @return the number of matching employee experiences
	 */
	@Override
	public int countByWorkAreaId(long workAreaId) {
		FinderPath finderPath = _finderPathCountByWorkAreaId;

		Object[] finderArgs = new Object[] {workAreaId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEEXPERIENCE_WHERE);

			sb.append(_FINDER_COLUMN_WORKAREAID_WORKAREAID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(workAreaId);

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

	private static final String _FINDER_COLUMN_WORKAREAID_WORKAREAID_2 =
		"employeeExperience.workAreaId = ?";

	public EmployeeExperiencePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(EmployeeExperience.class);

		setModelImplClass(EmployeeExperienceImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the employee experience in the entity cache if it is enabled.
	 *
	 * @param employeeExperience the employee experience
	 */
	@Override
	public void cacheResult(EmployeeExperience employeeExperience) {
		entityCache.putResult(
			EmployeeExperienceImpl.class, employeeExperience.getPrimaryKey(),
			employeeExperience);
	}

	/**
	 * Caches the employee experiences in the entity cache if it is enabled.
	 *
	 * @param employeeExperiences the employee experiences
	 */
	@Override
	public void cacheResult(List<EmployeeExperience> employeeExperiences) {
		for (EmployeeExperience employeeExperience : employeeExperiences) {
			if (entityCache.getResult(
					EmployeeExperienceImpl.class,
					employeeExperience.getPrimaryKey()) == null) {

				cacheResult(employeeExperience);
			}
		}
	}

	/**
	 * Clears the cache for all employee experiences.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmployeeExperienceImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the employee experience.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmployeeExperience employeeExperience) {
		entityCache.removeResult(
			EmployeeExperienceImpl.class, employeeExperience);
	}

	@Override
	public void clearCache(List<EmployeeExperience> employeeExperiences) {
		for (EmployeeExperience employeeExperience : employeeExperiences) {
			entityCache.removeResult(
				EmployeeExperienceImpl.class, employeeExperience);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EmployeeExperienceImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new employee experience with the primary key. Does not add the employee experience to the database.
	 *
	 * @param employeeExperienceId the primary key for the new employee experience
	 * @return the new employee experience
	 */
	@Override
	public EmployeeExperience create(long employeeExperienceId) {
		EmployeeExperience employeeExperience = new EmployeeExperienceImpl();

		employeeExperience.setNew(true);
		employeeExperience.setPrimaryKey(employeeExperienceId);

		employeeExperience.setCompanyId(CompanyThreadLocal.getCompanyId());

		return employeeExperience;
	}

	/**
	 * Removes the employee experience with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeExperienceId the primary key of the employee experience
	 * @return the employee experience that was removed
	 * @throws NoSuchEmployeeExperienceException if a employee experience with the primary key could not be found
	 */
	@Override
	public EmployeeExperience remove(long employeeExperienceId)
		throws NoSuchEmployeeExperienceException {

		return remove((Serializable)employeeExperienceId);
	}

	/**
	 * Removes the employee experience with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the employee experience
	 * @return the employee experience that was removed
	 * @throws NoSuchEmployeeExperienceException if a employee experience with the primary key could not be found
	 */
	@Override
	public EmployeeExperience remove(Serializable primaryKey)
		throws NoSuchEmployeeExperienceException {

		Session session = null;

		try {
			session = openSession();

			EmployeeExperience employeeExperience =
				(EmployeeExperience)session.get(
					EmployeeExperienceImpl.class, primaryKey);

			if (employeeExperience == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmployeeExperienceException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(employeeExperience);
		}
		catch (NoSuchEmployeeExperienceException noSuchEntityException) {
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
	protected EmployeeExperience removeImpl(
		EmployeeExperience employeeExperience) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(employeeExperience)) {
				employeeExperience = (EmployeeExperience)session.get(
					EmployeeExperienceImpl.class,
					employeeExperience.getPrimaryKeyObj());
			}

			if (employeeExperience != null) {
				session.delete(employeeExperience);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (employeeExperience != null) {
			clearCache(employeeExperience);
		}

		return employeeExperience;
	}

	@Override
	public EmployeeExperience updateImpl(
		EmployeeExperience employeeExperience) {

		boolean isNew = employeeExperience.isNew();

		if (!(employeeExperience instanceof EmployeeExperienceModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(employeeExperience.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					employeeExperience);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in employeeExperience proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EmployeeExperience implementation " +
					employeeExperience.getClass());
		}

		EmployeeExperienceModelImpl employeeExperienceModelImpl =
			(EmployeeExperienceModelImpl)employeeExperience;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (employeeExperience.getCreateDate() == null)) {
			if (serviceContext == null) {
				employeeExperience.setCreateDate(now);
			}
			else {
				employeeExperience.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!employeeExperienceModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				employeeExperience.setModifiedDate(now);
			}
			else {
				employeeExperience.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(employeeExperience);
			}
			else {
				employeeExperience = (EmployeeExperience)session.merge(
					employeeExperience);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EmployeeExperienceImpl.class, employeeExperienceModelImpl, false,
			true);

		if (isNew) {
			employeeExperience.setNew(false);
		}

		employeeExperience.resetOriginalValues();

		return employeeExperience;
	}

	/**
	 * Returns the employee experience with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee experience
	 * @return the employee experience
	 * @throws NoSuchEmployeeExperienceException if a employee experience with the primary key could not be found
	 */
	@Override
	public EmployeeExperience findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmployeeExperienceException {

		EmployeeExperience employeeExperience = fetchByPrimaryKey(primaryKey);

		if (employeeExperience == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmployeeExperienceException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return employeeExperience;
	}

	/**
	 * Returns the employee experience with the primary key or throws a <code>NoSuchEmployeeExperienceException</code> if it could not be found.
	 *
	 * @param employeeExperienceId the primary key of the employee experience
	 * @return the employee experience
	 * @throws NoSuchEmployeeExperienceException if a employee experience with the primary key could not be found
	 */
	@Override
	public EmployeeExperience findByPrimaryKey(long employeeExperienceId)
		throws NoSuchEmployeeExperienceException {

		return findByPrimaryKey((Serializable)employeeExperienceId);
	}

	/**
	 * Returns the employee experience with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeExperienceId the primary key of the employee experience
	 * @return the employee experience, or <code>null</code> if a employee experience with the primary key could not be found
	 */
	@Override
	public EmployeeExperience fetchByPrimaryKey(long employeeExperienceId) {
		return fetchByPrimaryKey((Serializable)employeeExperienceId);
	}

	/**
	 * Returns all the employee experiences.
	 *
	 * @return the employee experiences
	 */
	@Override
	public List<EmployeeExperience> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee experiences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @return the range of employee experiences
	 */
	@Override
	public List<EmployeeExperience> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee experiences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee experiences
	 */
	@Override
	public List<EmployeeExperience> findAll(
		int start, int end,
		OrderByComparator<EmployeeExperience> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee experiences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee experiences
	 */
	@Override
	public List<EmployeeExperience> findAll(
		int start, int end,
		OrderByComparator<EmployeeExperience> orderByComparator,
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

		List<EmployeeExperience> list = null;

		if (useFinderCache) {
			list = (List<EmployeeExperience>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EMPLOYEEEXPERIENCE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLOYEEEXPERIENCE;

				sql = sql.concat(EmployeeExperienceModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EmployeeExperience>)QueryUtil.list(
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
	 * Removes all the employee experiences from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EmployeeExperience employeeExperience : findAll()) {
			remove(employeeExperience);
		}
	}

	/**
	 * Returns the number of employee experiences.
	 *
	 * @return the number of employee experiences
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
					_SQL_COUNT_EMPLOYEEEXPERIENCE);

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
		return "employeeExperienceId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EMPLOYEEEXPERIENCE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EmployeeExperienceModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the employee experience persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new EmployeeExperienceModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", EmployeeExperience.class.getName()));

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

		_finderPathWithPaginationFindByWorkAreaMinorId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByWorkAreaMinorId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"workAreaMinorId"}, true);

		_finderPathWithoutPaginationFindByWorkAreaMinorId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByWorkAreaMinorId",
			new String[] {Long.class.getName()},
			new String[] {"workAreaMinorId"}, true);

		_finderPathCountByWorkAreaMinorId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByWorkAreaMinorId",
			new String[] {Long.class.getName()},
			new String[] {"workAreaMinorId"}, false);

		_finderPathWithPaginationFindByWorkAreaId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByWorkAreaId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"workAreaId"}, true);

		_finderPathWithoutPaginationFindByWorkAreaId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByWorkAreaId",
			new String[] {Long.class.getName()}, new String[] {"workAreaId"},
			true);

		_finderPathCountByWorkAreaId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByWorkAreaId",
			new String[] {Long.class.getName()}, new String[] {"workAreaId"},
			false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(EmployeeExperienceImpl.class.getName());

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

	private static final String _SQL_SELECT_EMPLOYEEEXPERIENCE =
		"SELECT employeeExperience FROM EmployeeExperience employeeExperience";

	private static final String _SQL_SELECT_EMPLOYEEEXPERIENCE_WHERE =
		"SELECT employeeExperience FROM EmployeeExperience employeeExperience WHERE ";

	private static final String _SQL_COUNT_EMPLOYEEEXPERIENCE =
		"SELECT COUNT(employeeExperience) FROM EmployeeExperience employeeExperience";

	private static final String _SQL_COUNT_EMPLOYEEEXPERIENCE_WHERE =
		"SELECT COUNT(employeeExperience) FROM EmployeeExperience employeeExperience WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "employeeExperience.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EmployeeExperience exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EmployeeExperience exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EmployeeExperiencePersistenceImpl.class);

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

	private static class EmployeeExperienceModelArgumentsResolver
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

			EmployeeExperienceModelImpl employeeExperienceModelImpl =
				(EmployeeExperienceModelImpl)baseModel;

			long columnBitmask = employeeExperienceModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					employeeExperienceModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						employeeExperienceModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					employeeExperienceModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			EmployeeExperienceModelImpl employeeExperienceModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						employeeExperienceModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = employeeExperienceModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}