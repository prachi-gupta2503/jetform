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

import com.adjecti.pis.liferay.exception.NoSuchEmployeePastExperienceException;
import com.adjecti.pis.liferay.model.EmployeePastExperience;
import com.adjecti.pis.liferay.model.impl.EmployeePastExperienceImpl;
import com.adjecti.pis.liferay.model.impl.EmployeePastExperienceModelImpl;
import com.adjecti.pis.liferay.service.persistence.EmployeePastExperiencePersistence;
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
 * The persistence implementation for the employee past experience service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EmployeePastExperiencePersistence.class)
public class EmployeePastExperiencePersistenceImpl
	extends BasePersistenceImpl<EmployeePastExperience>
	implements EmployeePastExperiencePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EmployeePastExperienceUtil</code> to access the employee past experience persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EmployeePastExperienceImpl.class.getName();

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
	 * Returns all the employee past experiences where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee past experiences
	 */
	@Override
	public List<EmployeePastExperience> findByEmployeeId(long employeeId) {
		return findByEmployeeId(
			employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee past experiences where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePastExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee past experiences
	 * @param end the upper bound of the range of employee past experiences (not inclusive)
	 * @return the range of matching employee past experiences
	 */
	@Override
	public List<EmployeePastExperience> findByEmployeeId(
		long employeeId, int start, int end) {

		return findByEmployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee past experiences where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePastExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee past experiences
	 * @param end the upper bound of the range of employee past experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee past experiences
	 */
	@Override
	public List<EmployeePastExperience> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeePastExperience> orderByComparator) {

		return findByEmployeeId(
			employeeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee past experiences where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePastExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee past experiences
	 * @param end the upper bound of the range of employee past experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee past experiences
	 */
	@Override
	public List<EmployeePastExperience> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeePastExperience> orderByComparator,
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

		List<EmployeePastExperience> list = null;

		if (useFinderCache) {
			list = (List<EmployeePastExperience>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeePastExperience employeePastExperience : list) {
					if (employeeId != employeePastExperience.getEmployeeId()) {
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

			sb.append(_SQL_SELECT_EMPLOYEEPASTEXPERIENCE_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeePastExperienceModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				list = (List<EmployeePastExperience>)QueryUtil.list(
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
	 * Returns the first employee past experience in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee past experience
	 * @throws NoSuchEmployeePastExperienceException if a matching employee past experience could not be found
	 */
	@Override
	public EmployeePastExperience findByEmployeeId_First(
			long employeeId,
			OrderByComparator<EmployeePastExperience> orderByComparator)
		throws NoSuchEmployeePastExperienceException {

		EmployeePastExperience employeePastExperience = fetchByEmployeeId_First(
			employeeId, orderByComparator);

		if (employeePastExperience != null) {
			return employeePastExperience;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeePastExperienceException(sb.toString());
	}

	/**
	 * Returns the first employee past experience in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee past experience, or <code>null</code> if a matching employee past experience could not be found
	 */
	@Override
	public EmployeePastExperience fetchByEmployeeId_First(
		long employeeId,
		OrderByComparator<EmployeePastExperience> orderByComparator) {

		List<EmployeePastExperience> list = findByEmployeeId(
			employeeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee past experience in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee past experience
	 * @throws NoSuchEmployeePastExperienceException if a matching employee past experience could not be found
	 */
	@Override
	public EmployeePastExperience findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<EmployeePastExperience> orderByComparator)
		throws NoSuchEmployeePastExperienceException {

		EmployeePastExperience employeePastExperience = fetchByEmployeeId_Last(
			employeeId, orderByComparator);

		if (employeePastExperience != null) {
			return employeePastExperience;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeePastExperienceException(sb.toString());
	}

	/**
	 * Returns the last employee past experience in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee past experience, or <code>null</code> if a matching employee past experience could not be found
	 */
	@Override
	public EmployeePastExperience fetchByEmployeeId_Last(
		long employeeId,
		OrderByComparator<EmployeePastExperience> orderByComparator) {

		int count = countByEmployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<EmployeePastExperience> list = findByEmployeeId(
			employeeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee past experiences before and after the current employee past experience in the ordered set where employeeId = &#63;.
	 *
	 * @param employeePastExperienceId the primary key of the current employee past experience
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee past experience
	 * @throws NoSuchEmployeePastExperienceException if a employee past experience with the primary key could not be found
	 */
	@Override
	public EmployeePastExperience[] findByEmployeeId_PrevAndNext(
			long employeePastExperienceId, long employeeId,
			OrderByComparator<EmployeePastExperience> orderByComparator)
		throws NoSuchEmployeePastExperienceException {

		EmployeePastExperience employeePastExperience = findByPrimaryKey(
			employeePastExperienceId);

		Session session = null;

		try {
			session = openSession();

			EmployeePastExperience[] array = new EmployeePastExperienceImpl[3];

			array[0] = getByEmployeeId_PrevAndNext(
				session, employeePastExperience, employeeId, orderByComparator,
				true);

			array[1] = employeePastExperience;

			array[2] = getByEmployeeId_PrevAndNext(
				session, employeePastExperience, employeeId, orderByComparator,
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

	protected EmployeePastExperience getByEmployeeId_PrevAndNext(
		Session session, EmployeePastExperience employeePastExperience,
		long employeeId,
		OrderByComparator<EmployeePastExperience> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEPASTEXPERIENCE_WHERE);

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
			sb.append(EmployeePastExperienceModelImpl.ORDER_BY_JPQL);
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
						employeePastExperience)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeePastExperience> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee past experiences where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeByEmployeeId(long employeeId) {
		for (EmployeePastExperience employeePastExperience :
				findByEmployeeId(
					employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeePastExperience);
		}
	}

	/**
	 * Returns the number of employee past experiences where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee past experiences
	 */
	@Override
	public int countByEmployeeId(long employeeId) {
		FinderPath finderPath = _finderPathCountByEmployeeId;

		Object[] finderArgs = new Object[] {employeeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEPASTEXPERIENCE_WHERE);

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
		"employeePastExperience.employeeId = ?";

	private FinderPath _finderPathWithPaginationFindByJoiningProcessId;
	private FinderPath _finderPathWithoutPaginationFindByJoiningProcessId;
	private FinderPath _finderPathCountByJoiningProcessId;

	/**
	 * Returns all the employee past experiences where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @return the matching employee past experiences
	 */
	@Override
	public List<EmployeePastExperience> findByJoiningProcessId(
		long joiningProcessId) {

		return findByJoiningProcessId(
			joiningProcessId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee past experiences where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePastExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of employee past experiences
	 * @param end the upper bound of the range of employee past experiences (not inclusive)
	 * @return the range of matching employee past experiences
	 */
	@Override
	public List<EmployeePastExperience> findByJoiningProcessId(
		long joiningProcessId, int start, int end) {

		return findByJoiningProcessId(joiningProcessId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee past experiences where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePastExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of employee past experiences
	 * @param end the upper bound of the range of employee past experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee past experiences
	 */
	@Override
	public List<EmployeePastExperience> findByJoiningProcessId(
		long joiningProcessId, int start, int end,
		OrderByComparator<EmployeePastExperience> orderByComparator) {

		return findByJoiningProcessId(
			joiningProcessId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee past experiences where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePastExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of employee past experiences
	 * @param end the upper bound of the range of employee past experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee past experiences
	 */
	@Override
	public List<EmployeePastExperience> findByJoiningProcessId(
		long joiningProcessId, int start, int end,
		OrderByComparator<EmployeePastExperience> orderByComparator,
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

		List<EmployeePastExperience> list = null;

		if (useFinderCache) {
			list = (List<EmployeePastExperience>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeePastExperience employeePastExperience : list) {
					if (joiningProcessId !=
							employeePastExperience.getJoiningProcessId()) {

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

			sb.append(_SQL_SELECT_EMPLOYEEPASTEXPERIENCE_WHERE);

			sb.append(_FINDER_COLUMN_JOININGPROCESSID_JOININGPROCESSID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeePastExperienceModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(joiningProcessId);

				list = (List<EmployeePastExperience>)QueryUtil.list(
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
	 * Returns the first employee past experience in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee past experience
	 * @throws NoSuchEmployeePastExperienceException if a matching employee past experience could not be found
	 */
	@Override
	public EmployeePastExperience findByJoiningProcessId_First(
			long joiningProcessId,
			OrderByComparator<EmployeePastExperience> orderByComparator)
		throws NoSuchEmployeePastExperienceException {

		EmployeePastExperience employeePastExperience =
			fetchByJoiningProcessId_First(joiningProcessId, orderByComparator);

		if (employeePastExperience != null) {
			return employeePastExperience;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("joiningProcessId=");
		sb.append(joiningProcessId);

		sb.append("}");

		throw new NoSuchEmployeePastExperienceException(sb.toString());
	}

	/**
	 * Returns the first employee past experience in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee past experience, or <code>null</code> if a matching employee past experience could not be found
	 */
	@Override
	public EmployeePastExperience fetchByJoiningProcessId_First(
		long joiningProcessId,
		OrderByComparator<EmployeePastExperience> orderByComparator) {

		List<EmployeePastExperience> list = findByJoiningProcessId(
			joiningProcessId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee past experience in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee past experience
	 * @throws NoSuchEmployeePastExperienceException if a matching employee past experience could not be found
	 */
	@Override
	public EmployeePastExperience findByJoiningProcessId_Last(
			long joiningProcessId,
			OrderByComparator<EmployeePastExperience> orderByComparator)
		throws NoSuchEmployeePastExperienceException {

		EmployeePastExperience employeePastExperience =
			fetchByJoiningProcessId_Last(joiningProcessId, orderByComparator);

		if (employeePastExperience != null) {
			return employeePastExperience;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("joiningProcessId=");
		sb.append(joiningProcessId);

		sb.append("}");

		throw new NoSuchEmployeePastExperienceException(sb.toString());
	}

	/**
	 * Returns the last employee past experience in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee past experience, or <code>null</code> if a matching employee past experience could not be found
	 */
	@Override
	public EmployeePastExperience fetchByJoiningProcessId_Last(
		long joiningProcessId,
		OrderByComparator<EmployeePastExperience> orderByComparator) {

		int count = countByJoiningProcessId(joiningProcessId);

		if (count == 0) {
			return null;
		}

		List<EmployeePastExperience> list = findByJoiningProcessId(
			joiningProcessId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee past experiences before and after the current employee past experience in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param employeePastExperienceId the primary key of the current employee past experience
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee past experience
	 * @throws NoSuchEmployeePastExperienceException if a employee past experience with the primary key could not be found
	 */
	@Override
	public EmployeePastExperience[] findByJoiningProcessId_PrevAndNext(
			long employeePastExperienceId, long joiningProcessId,
			OrderByComparator<EmployeePastExperience> orderByComparator)
		throws NoSuchEmployeePastExperienceException {

		EmployeePastExperience employeePastExperience = findByPrimaryKey(
			employeePastExperienceId);

		Session session = null;

		try {
			session = openSession();

			EmployeePastExperience[] array = new EmployeePastExperienceImpl[3];

			array[0] = getByJoiningProcessId_PrevAndNext(
				session, employeePastExperience, joiningProcessId,
				orderByComparator, true);

			array[1] = employeePastExperience;

			array[2] = getByJoiningProcessId_PrevAndNext(
				session, employeePastExperience, joiningProcessId,
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

	protected EmployeePastExperience getByJoiningProcessId_PrevAndNext(
		Session session, EmployeePastExperience employeePastExperience,
		long joiningProcessId,
		OrderByComparator<EmployeePastExperience> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEPASTEXPERIENCE_WHERE);

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
			sb.append(EmployeePastExperienceModelImpl.ORDER_BY_JPQL);
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
						employeePastExperience)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeePastExperience> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee past experiences where joiningProcessId = &#63; from the database.
	 *
	 * @param joiningProcessId the joining process ID
	 */
	@Override
	public void removeByJoiningProcessId(long joiningProcessId) {
		for (EmployeePastExperience employeePastExperience :
				findByJoiningProcessId(
					joiningProcessId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(employeePastExperience);
		}
	}

	/**
	 * Returns the number of employee past experiences where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @return the number of matching employee past experiences
	 */
	@Override
	public int countByJoiningProcessId(long joiningProcessId) {
		FinderPath finderPath = _finderPathCountByJoiningProcessId;

		Object[] finderArgs = new Object[] {joiningProcessId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEPASTEXPERIENCE_WHERE);

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
			"employeePastExperience.joiningProcessId = ?";

	private FinderPath _finderPathWithPaginationFindByWorkAreaId;
	private FinderPath _finderPathWithoutPaginationFindByWorkAreaId;
	private FinderPath _finderPathCountByWorkAreaId;

	/**
	 * Returns all the employee past experiences where workAreaId = &#63;.
	 *
	 * @param workAreaId the work area ID
	 * @return the matching employee past experiences
	 */
	@Override
	public List<EmployeePastExperience> findByWorkAreaId(long workAreaId) {
		return findByWorkAreaId(
			workAreaId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee past experiences where workAreaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePastExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param workAreaId the work area ID
	 * @param start the lower bound of the range of employee past experiences
	 * @param end the upper bound of the range of employee past experiences (not inclusive)
	 * @return the range of matching employee past experiences
	 */
	@Override
	public List<EmployeePastExperience> findByWorkAreaId(
		long workAreaId, int start, int end) {

		return findByWorkAreaId(workAreaId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee past experiences where workAreaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePastExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param workAreaId the work area ID
	 * @param start the lower bound of the range of employee past experiences
	 * @param end the upper bound of the range of employee past experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee past experiences
	 */
	@Override
	public List<EmployeePastExperience> findByWorkAreaId(
		long workAreaId, int start, int end,
		OrderByComparator<EmployeePastExperience> orderByComparator) {

		return findByWorkAreaId(
			workAreaId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee past experiences where workAreaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePastExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param workAreaId the work area ID
	 * @param start the lower bound of the range of employee past experiences
	 * @param end the upper bound of the range of employee past experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee past experiences
	 */
	@Override
	public List<EmployeePastExperience> findByWorkAreaId(
		long workAreaId, int start, int end,
		OrderByComparator<EmployeePastExperience> orderByComparator,
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

		List<EmployeePastExperience> list = null;

		if (useFinderCache) {
			list = (List<EmployeePastExperience>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeePastExperience employeePastExperience : list) {
					if (workAreaId != employeePastExperience.getWorkAreaId()) {
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

			sb.append(_SQL_SELECT_EMPLOYEEPASTEXPERIENCE_WHERE);

			sb.append(_FINDER_COLUMN_WORKAREAID_WORKAREAID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeePastExperienceModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(workAreaId);

				list = (List<EmployeePastExperience>)QueryUtil.list(
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
	 * Returns the first employee past experience in the ordered set where workAreaId = &#63;.
	 *
	 * @param workAreaId the work area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee past experience
	 * @throws NoSuchEmployeePastExperienceException if a matching employee past experience could not be found
	 */
	@Override
	public EmployeePastExperience findByWorkAreaId_First(
			long workAreaId,
			OrderByComparator<EmployeePastExperience> orderByComparator)
		throws NoSuchEmployeePastExperienceException {

		EmployeePastExperience employeePastExperience = fetchByWorkAreaId_First(
			workAreaId, orderByComparator);

		if (employeePastExperience != null) {
			return employeePastExperience;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("workAreaId=");
		sb.append(workAreaId);

		sb.append("}");

		throw new NoSuchEmployeePastExperienceException(sb.toString());
	}

	/**
	 * Returns the first employee past experience in the ordered set where workAreaId = &#63;.
	 *
	 * @param workAreaId the work area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee past experience, or <code>null</code> if a matching employee past experience could not be found
	 */
	@Override
	public EmployeePastExperience fetchByWorkAreaId_First(
		long workAreaId,
		OrderByComparator<EmployeePastExperience> orderByComparator) {

		List<EmployeePastExperience> list = findByWorkAreaId(
			workAreaId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee past experience in the ordered set where workAreaId = &#63;.
	 *
	 * @param workAreaId the work area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee past experience
	 * @throws NoSuchEmployeePastExperienceException if a matching employee past experience could not be found
	 */
	@Override
	public EmployeePastExperience findByWorkAreaId_Last(
			long workAreaId,
			OrderByComparator<EmployeePastExperience> orderByComparator)
		throws NoSuchEmployeePastExperienceException {

		EmployeePastExperience employeePastExperience = fetchByWorkAreaId_Last(
			workAreaId, orderByComparator);

		if (employeePastExperience != null) {
			return employeePastExperience;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("workAreaId=");
		sb.append(workAreaId);

		sb.append("}");

		throw new NoSuchEmployeePastExperienceException(sb.toString());
	}

	/**
	 * Returns the last employee past experience in the ordered set where workAreaId = &#63;.
	 *
	 * @param workAreaId the work area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee past experience, or <code>null</code> if a matching employee past experience could not be found
	 */
	@Override
	public EmployeePastExperience fetchByWorkAreaId_Last(
		long workAreaId,
		OrderByComparator<EmployeePastExperience> orderByComparator) {

		int count = countByWorkAreaId(workAreaId);

		if (count == 0) {
			return null;
		}

		List<EmployeePastExperience> list = findByWorkAreaId(
			workAreaId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee past experiences before and after the current employee past experience in the ordered set where workAreaId = &#63;.
	 *
	 * @param employeePastExperienceId the primary key of the current employee past experience
	 * @param workAreaId the work area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee past experience
	 * @throws NoSuchEmployeePastExperienceException if a employee past experience with the primary key could not be found
	 */
	@Override
	public EmployeePastExperience[] findByWorkAreaId_PrevAndNext(
			long employeePastExperienceId, long workAreaId,
			OrderByComparator<EmployeePastExperience> orderByComparator)
		throws NoSuchEmployeePastExperienceException {

		EmployeePastExperience employeePastExperience = findByPrimaryKey(
			employeePastExperienceId);

		Session session = null;

		try {
			session = openSession();

			EmployeePastExperience[] array = new EmployeePastExperienceImpl[3];

			array[0] = getByWorkAreaId_PrevAndNext(
				session, employeePastExperience, workAreaId, orderByComparator,
				true);

			array[1] = employeePastExperience;

			array[2] = getByWorkAreaId_PrevAndNext(
				session, employeePastExperience, workAreaId, orderByComparator,
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

	protected EmployeePastExperience getByWorkAreaId_PrevAndNext(
		Session session, EmployeePastExperience employeePastExperience,
		long workAreaId,
		OrderByComparator<EmployeePastExperience> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEPASTEXPERIENCE_WHERE);

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
			sb.append(EmployeePastExperienceModelImpl.ORDER_BY_JPQL);
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
						employeePastExperience)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeePastExperience> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee past experiences where workAreaId = &#63; from the database.
	 *
	 * @param workAreaId the work area ID
	 */
	@Override
	public void removeByWorkAreaId(long workAreaId) {
		for (EmployeePastExperience employeePastExperience :
				findByWorkAreaId(
					workAreaId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeePastExperience);
		}
	}

	/**
	 * Returns the number of employee past experiences where workAreaId = &#63;.
	 *
	 * @param workAreaId the work area ID
	 * @return the number of matching employee past experiences
	 */
	@Override
	public int countByWorkAreaId(long workAreaId) {
		FinderPath finderPath = _finderPathCountByWorkAreaId;

		Object[] finderArgs = new Object[] {workAreaId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEPASTEXPERIENCE_WHERE);

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
		"employeePastExperience.workAreaId = ?";

	public EmployeePastExperiencePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(EmployeePastExperience.class);

		setModelImplClass(EmployeePastExperienceImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the employee past experience in the entity cache if it is enabled.
	 *
	 * @param employeePastExperience the employee past experience
	 */
	@Override
	public void cacheResult(EmployeePastExperience employeePastExperience) {
		entityCache.putResult(
			EmployeePastExperienceImpl.class,
			employeePastExperience.getPrimaryKey(), employeePastExperience);
	}

	/**
	 * Caches the employee past experiences in the entity cache if it is enabled.
	 *
	 * @param employeePastExperiences the employee past experiences
	 */
	@Override
	public void cacheResult(
		List<EmployeePastExperience> employeePastExperiences) {

		for (EmployeePastExperience employeePastExperience :
				employeePastExperiences) {

			if (entityCache.getResult(
					EmployeePastExperienceImpl.class,
					employeePastExperience.getPrimaryKey()) == null) {

				cacheResult(employeePastExperience);
			}
		}
	}

	/**
	 * Clears the cache for all employee past experiences.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmployeePastExperienceImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the employee past experience.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmployeePastExperience employeePastExperience) {
		entityCache.removeResult(
			EmployeePastExperienceImpl.class, employeePastExperience);
	}

	@Override
	public void clearCache(
		List<EmployeePastExperience> employeePastExperiences) {

		for (EmployeePastExperience employeePastExperience :
				employeePastExperiences) {

			entityCache.removeResult(
				EmployeePastExperienceImpl.class, employeePastExperience);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				EmployeePastExperienceImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new employee past experience with the primary key. Does not add the employee past experience to the database.
	 *
	 * @param employeePastExperienceId the primary key for the new employee past experience
	 * @return the new employee past experience
	 */
	@Override
	public EmployeePastExperience create(long employeePastExperienceId) {
		EmployeePastExperience employeePastExperience =
			new EmployeePastExperienceImpl();

		employeePastExperience.setNew(true);
		employeePastExperience.setPrimaryKey(employeePastExperienceId);

		employeePastExperience.setCompanyId(CompanyThreadLocal.getCompanyId());

		return employeePastExperience;
	}

	/**
	 * Removes the employee past experience with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeePastExperienceId the primary key of the employee past experience
	 * @return the employee past experience that was removed
	 * @throws NoSuchEmployeePastExperienceException if a employee past experience with the primary key could not be found
	 */
	@Override
	public EmployeePastExperience remove(long employeePastExperienceId)
		throws NoSuchEmployeePastExperienceException {

		return remove((Serializable)employeePastExperienceId);
	}

	/**
	 * Removes the employee past experience with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the employee past experience
	 * @return the employee past experience that was removed
	 * @throws NoSuchEmployeePastExperienceException if a employee past experience with the primary key could not be found
	 */
	@Override
	public EmployeePastExperience remove(Serializable primaryKey)
		throws NoSuchEmployeePastExperienceException {

		Session session = null;

		try {
			session = openSession();

			EmployeePastExperience employeePastExperience =
				(EmployeePastExperience)session.get(
					EmployeePastExperienceImpl.class, primaryKey);

			if (employeePastExperience == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmployeePastExperienceException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(employeePastExperience);
		}
		catch (NoSuchEmployeePastExperienceException noSuchEntityException) {
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
	protected EmployeePastExperience removeImpl(
		EmployeePastExperience employeePastExperience) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(employeePastExperience)) {
				employeePastExperience = (EmployeePastExperience)session.get(
					EmployeePastExperienceImpl.class,
					employeePastExperience.getPrimaryKeyObj());
			}

			if (employeePastExperience != null) {
				session.delete(employeePastExperience);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (employeePastExperience != null) {
			clearCache(employeePastExperience);
		}

		return employeePastExperience;
	}

	@Override
	public EmployeePastExperience updateImpl(
		EmployeePastExperience employeePastExperience) {

		boolean isNew = employeePastExperience.isNew();

		if (!(employeePastExperience instanceof
				EmployeePastExperienceModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(employeePastExperience.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					employeePastExperience);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in employeePastExperience proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EmployeePastExperience implementation " +
					employeePastExperience.getClass());
		}

		EmployeePastExperienceModelImpl employeePastExperienceModelImpl =
			(EmployeePastExperienceModelImpl)employeePastExperience;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (employeePastExperience.getCreateDate() == null)) {
			if (serviceContext == null) {
				employeePastExperience.setCreateDate(now);
			}
			else {
				employeePastExperience.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!employeePastExperienceModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				employeePastExperience.setModifiedDate(now);
			}
			else {
				employeePastExperience.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(employeePastExperience);
			}
			else {
				employeePastExperience = (EmployeePastExperience)session.merge(
					employeePastExperience);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EmployeePastExperienceImpl.class, employeePastExperienceModelImpl,
			false, true);

		if (isNew) {
			employeePastExperience.setNew(false);
		}

		employeePastExperience.resetOriginalValues();

		return employeePastExperience;
	}

	/**
	 * Returns the employee past experience with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee past experience
	 * @return the employee past experience
	 * @throws NoSuchEmployeePastExperienceException if a employee past experience with the primary key could not be found
	 */
	@Override
	public EmployeePastExperience findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmployeePastExperienceException {

		EmployeePastExperience employeePastExperience = fetchByPrimaryKey(
			primaryKey);

		if (employeePastExperience == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmployeePastExperienceException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return employeePastExperience;
	}

	/**
	 * Returns the employee past experience with the primary key or throws a <code>NoSuchEmployeePastExperienceException</code> if it could not be found.
	 *
	 * @param employeePastExperienceId the primary key of the employee past experience
	 * @return the employee past experience
	 * @throws NoSuchEmployeePastExperienceException if a employee past experience with the primary key could not be found
	 */
	@Override
	public EmployeePastExperience findByPrimaryKey(
			long employeePastExperienceId)
		throws NoSuchEmployeePastExperienceException {

		return findByPrimaryKey((Serializable)employeePastExperienceId);
	}

	/**
	 * Returns the employee past experience with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeePastExperienceId the primary key of the employee past experience
	 * @return the employee past experience, or <code>null</code> if a employee past experience with the primary key could not be found
	 */
	@Override
	public EmployeePastExperience fetchByPrimaryKey(
		long employeePastExperienceId) {

		return fetchByPrimaryKey((Serializable)employeePastExperienceId);
	}

	/**
	 * Returns all the employee past experiences.
	 *
	 * @return the employee past experiences
	 */
	@Override
	public List<EmployeePastExperience> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee past experiences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePastExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee past experiences
	 * @param end the upper bound of the range of employee past experiences (not inclusive)
	 * @return the range of employee past experiences
	 */
	@Override
	public List<EmployeePastExperience> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee past experiences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePastExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee past experiences
	 * @param end the upper bound of the range of employee past experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee past experiences
	 */
	@Override
	public List<EmployeePastExperience> findAll(
		int start, int end,
		OrderByComparator<EmployeePastExperience> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee past experiences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePastExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee past experiences
	 * @param end the upper bound of the range of employee past experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee past experiences
	 */
	@Override
	public List<EmployeePastExperience> findAll(
		int start, int end,
		OrderByComparator<EmployeePastExperience> orderByComparator,
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

		List<EmployeePastExperience> list = null;

		if (useFinderCache) {
			list = (List<EmployeePastExperience>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EMPLOYEEPASTEXPERIENCE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLOYEEPASTEXPERIENCE;

				sql = sql.concat(EmployeePastExperienceModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EmployeePastExperience>)QueryUtil.list(
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
	 * Removes all the employee past experiences from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EmployeePastExperience employeePastExperience : findAll()) {
			remove(employeePastExperience);
		}
	}

	/**
	 * Returns the number of employee past experiences.
	 *
	 * @return the number of employee past experiences
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
					_SQL_COUNT_EMPLOYEEPASTEXPERIENCE);

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
		return "employeePastExperienceId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EMPLOYEEPASTEXPERIENCE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EmployeePastExperienceModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the employee past experience persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new EmployeePastExperienceModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", EmployeePastExperience.class.getName()));

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
		entityCache.removeCache(EmployeePastExperienceImpl.class.getName());

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

	private static final String _SQL_SELECT_EMPLOYEEPASTEXPERIENCE =
		"SELECT employeePastExperience FROM EmployeePastExperience employeePastExperience";

	private static final String _SQL_SELECT_EMPLOYEEPASTEXPERIENCE_WHERE =
		"SELECT employeePastExperience FROM EmployeePastExperience employeePastExperience WHERE ";

	private static final String _SQL_COUNT_EMPLOYEEPASTEXPERIENCE =
		"SELECT COUNT(employeePastExperience) FROM EmployeePastExperience employeePastExperience";

	private static final String _SQL_COUNT_EMPLOYEEPASTEXPERIENCE_WHERE =
		"SELECT COUNT(employeePastExperience) FROM EmployeePastExperience employeePastExperience WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"employeePastExperience.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EmployeePastExperience exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EmployeePastExperience exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EmployeePastExperiencePersistenceImpl.class);

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

	private static class EmployeePastExperienceModelArgumentsResolver
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

			EmployeePastExperienceModelImpl employeePastExperienceModelImpl =
				(EmployeePastExperienceModelImpl)baseModel;

			long columnBitmask =
				employeePastExperienceModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					employeePastExperienceModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						employeePastExperienceModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					employeePastExperienceModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			EmployeePastExperienceModelImpl employeePastExperienceModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						employeePastExperienceModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] =
						employeePastExperienceModelImpl.getColumnValue(
							columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}