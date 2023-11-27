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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeTrainingException;
import com.adjecti.pis.liferay.model.EmployeeTraining;
import com.adjecti.pis.liferay.model.impl.EmployeeTrainingImpl;
import com.adjecti.pis.liferay.model.impl.EmployeeTrainingModelImpl;
import com.adjecti.pis.liferay.service.persistence.EmployeeTrainingPersistence;
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
 * The persistence implementation for the employee training service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EmployeeTrainingPersistence.class)
public class EmployeeTrainingPersistenceImpl
	extends BasePersistenceImpl<EmployeeTraining>
	implements EmployeeTrainingPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EmployeeTrainingUtil</code> to access the employee training persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EmployeeTrainingImpl.class.getName();

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
	 * Returns all the employee trainings where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee trainings
	 */
	@Override
	public List<EmployeeTraining> findByEmployeeId(long employeeId) {
		return findByEmployeeId(
			employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee trainings where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTrainingModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee trainings
	 * @param end the upper bound of the range of employee trainings (not inclusive)
	 * @return the range of matching employee trainings
	 */
	@Override
	public List<EmployeeTraining> findByEmployeeId(
		long employeeId, int start, int end) {

		return findByEmployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee trainings where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTrainingModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee trainings
	 * @param end the upper bound of the range of employee trainings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee trainings
	 */
	@Override
	public List<EmployeeTraining> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeTraining> orderByComparator) {

		return findByEmployeeId(
			employeeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee trainings where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTrainingModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee trainings
	 * @param end the upper bound of the range of employee trainings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee trainings
	 */
	@Override
	public List<EmployeeTraining> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeTraining> orderByComparator,
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

		List<EmployeeTraining> list = null;

		if (useFinderCache) {
			list = (List<EmployeeTraining>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeTraining employeeTraining : list) {
					if (employeeId != employeeTraining.getEmployeeId()) {
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

			sb.append(_SQL_SELECT_EMPLOYEETRAINING_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeTrainingModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				list = (List<EmployeeTraining>)QueryUtil.list(
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
	 * Returns the first employee training in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee training
	 * @throws NoSuchEmployeeTrainingException if a matching employee training could not be found
	 */
	@Override
	public EmployeeTraining findByEmployeeId_First(
			long employeeId,
			OrderByComparator<EmployeeTraining> orderByComparator)
		throws NoSuchEmployeeTrainingException {

		EmployeeTraining employeeTraining = fetchByEmployeeId_First(
			employeeId, orderByComparator);

		if (employeeTraining != null) {
			return employeeTraining;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeeTrainingException(sb.toString());
	}

	/**
	 * Returns the first employee training in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee training, or <code>null</code> if a matching employee training could not be found
	 */
	@Override
	public EmployeeTraining fetchByEmployeeId_First(
		long employeeId,
		OrderByComparator<EmployeeTraining> orderByComparator) {

		List<EmployeeTraining> list = findByEmployeeId(
			employeeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee training in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee training
	 * @throws NoSuchEmployeeTrainingException if a matching employee training could not be found
	 */
	@Override
	public EmployeeTraining findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<EmployeeTraining> orderByComparator)
		throws NoSuchEmployeeTrainingException {

		EmployeeTraining employeeTraining = fetchByEmployeeId_Last(
			employeeId, orderByComparator);

		if (employeeTraining != null) {
			return employeeTraining;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeeTrainingException(sb.toString());
	}

	/**
	 * Returns the last employee training in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee training, or <code>null</code> if a matching employee training could not be found
	 */
	@Override
	public EmployeeTraining fetchByEmployeeId_Last(
		long employeeId,
		OrderByComparator<EmployeeTraining> orderByComparator) {

		int count = countByEmployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<EmployeeTraining> list = findByEmployeeId(
			employeeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee trainings before and after the current employee training in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeTrainingId the primary key of the current employee training
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee training
	 * @throws NoSuchEmployeeTrainingException if a employee training with the primary key could not be found
	 */
	@Override
	public EmployeeTraining[] findByEmployeeId_PrevAndNext(
			long employeeTrainingId, long employeeId,
			OrderByComparator<EmployeeTraining> orderByComparator)
		throws NoSuchEmployeeTrainingException {

		EmployeeTraining employeeTraining = findByPrimaryKey(
			employeeTrainingId);

		Session session = null;

		try {
			session = openSession();

			EmployeeTraining[] array = new EmployeeTrainingImpl[3];

			array[0] = getByEmployeeId_PrevAndNext(
				session, employeeTraining, employeeId, orderByComparator, true);

			array[1] = employeeTraining;

			array[2] = getByEmployeeId_PrevAndNext(
				session, employeeTraining, employeeId, orderByComparator,
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

	protected EmployeeTraining getByEmployeeId_PrevAndNext(
		Session session, EmployeeTraining employeeTraining, long employeeId,
		OrderByComparator<EmployeeTraining> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEETRAINING_WHERE);

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
			sb.append(EmployeeTrainingModelImpl.ORDER_BY_JPQL);
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
						employeeTraining)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeTraining> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee trainings where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeByEmployeeId(long employeeId) {
		for (EmployeeTraining employeeTraining :
				findByEmployeeId(
					employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeeTraining);
		}
	}

	/**
	 * Returns the number of employee trainings where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee trainings
	 */
	@Override
	public int countByEmployeeId(long employeeId) {
		FinderPath finderPath = _finderPathCountByEmployeeId;

		Object[] finderArgs = new Object[] {employeeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEETRAINING_WHERE);

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
		"employeeTraining.employeeId = ?";

	private FinderPath _finderPathWithPaginationFindByInstituteId;
	private FinderPath _finderPathWithoutPaginationFindByInstituteId;
	private FinderPath _finderPathCountByInstituteId;

	/**
	 * Returns all the employee trainings where instituteId = &#63;.
	 *
	 * @param instituteId the institute ID
	 * @return the matching employee trainings
	 */
	@Override
	public List<EmployeeTraining> findByInstituteId(long instituteId) {
		return findByInstituteId(
			instituteId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee trainings where instituteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTrainingModelImpl</code>.
	 * </p>
	 *
	 * @param instituteId the institute ID
	 * @param start the lower bound of the range of employee trainings
	 * @param end the upper bound of the range of employee trainings (not inclusive)
	 * @return the range of matching employee trainings
	 */
	@Override
	public List<EmployeeTraining> findByInstituteId(
		long instituteId, int start, int end) {

		return findByInstituteId(instituteId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee trainings where instituteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTrainingModelImpl</code>.
	 * </p>
	 *
	 * @param instituteId the institute ID
	 * @param start the lower bound of the range of employee trainings
	 * @param end the upper bound of the range of employee trainings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee trainings
	 */
	@Override
	public List<EmployeeTraining> findByInstituteId(
		long instituteId, int start, int end,
		OrderByComparator<EmployeeTraining> orderByComparator) {

		return findByInstituteId(
			instituteId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee trainings where instituteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTrainingModelImpl</code>.
	 * </p>
	 *
	 * @param instituteId the institute ID
	 * @param start the lower bound of the range of employee trainings
	 * @param end the upper bound of the range of employee trainings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee trainings
	 */
	@Override
	public List<EmployeeTraining> findByInstituteId(
		long instituteId, int start, int end,
		OrderByComparator<EmployeeTraining> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByInstituteId;
				finderArgs = new Object[] {instituteId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByInstituteId;
			finderArgs = new Object[] {
				instituteId, start, end, orderByComparator
			};
		}

		List<EmployeeTraining> list = null;

		if (useFinderCache) {
			list = (List<EmployeeTraining>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeTraining employeeTraining : list) {
					if (instituteId != employeeTraining.getInstituteId()) {
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

			sb.append(_SQL_SELECT_EMPLOYEETRAINING_WHERE);

			sb.append(_FINDER_COLUMN_INSTITUTEID_INSTITUTEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeTrainingModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(instituteId);

				list = (List<EmployeeTraining>)QueryUtil.list(
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
	 * Returns the first employee training in the ordered set where instituteId = &#63;.
	 *
	 * @param instituteId the institute ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee training
	 * @throws NoSuchEmployeeTrainingException if a matching employee training could not be found
	 */
	@Override
	public EmployeeTraining findByInstituteId_First(
			long instituteId,
			OrderByComparator<EmployeeTraining> orderByComparator)
		throws NoSuchEmployeeTrainingException {

		EmployeeTraining employeeTraining = fetchByInstituteId_First(
			instituteId, orderByComparator);

		if (employeeTraining != null) {
			return employeeTraining;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("instituteId=");
		sb.append(instituteId);

		sb.append("}");

		throw new NoSuchEmployeeTrainingException(sb.toString());
	}

	/**
	 * Returns the first employee training in the ordered set where instituteId = &#63;.
	 *
	 * @param instituteId the institute ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee training, or <code>null</code> if a matching employee training could not be found
	 */
	@Override
	public EmployeeTraining fetchByInstituteId_First(
		long instituteId,
		OrderByComparator<EmployeeTraining> orderByComparator) {

		List<EmployeeTraining> list = findByInstituteId(
			instituteId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee training in the ordered set where instituteId = &#63;.
	 *
	 * @param instituteId the institute ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee training
	 * @throws NoSuchEmployeeTrainingException if a matching employee training could not be found
	 */
	@Override
	public EmployeeTraining findByInstituteId_Last(
			long instituteId,
			OrderByComparator<EmployeeTraining> orderByComparator)
		throws NoSuchEmployeeTrainingException {

		EmployeeTraining employeeTraining = fetchByInstituteId_Last(
			instituteId, orderByComparator);

		if (employeeTraining != null) {
			return employeeTraining;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("instituteId=");
		sb.append(instituteId);

		sb.append("}");

		throw new NoSuchEmployeeTrainingException(sb.toString());
	}

	/**
	 * Returns the last employee training in the ordered set where instituteId = &#63;.
	 *
	 * @param instituteId the institute ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee training, or <code>null</code> if a matching employee training could not be found
	 */
	@Override
	public EmployeeTraining fetchByInstituteId_Last(
		long instituteId,
		OrderByComparator<EmployeeTraining> orderByComparator) {

		int count = countByInstituteId(instituteId);

		if (count == 0) {
			return null;
		}

		List<EmployeeTraining> list = findByInstituteId(
			instituteId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee trainings before and after the current employee training in the ordered set where instituteId = &#63;.
	 *
	 * @param employeeTrainingId the primary key of the current employee training
	 * @param instituteId the institute ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee training
	 * @throws NoSuchEmployeeTrainingException if a employee training with the primary key could not be found
	 */
	@Override
	public EmployeeTraining[] findByInstituteId_PrevAndNext(
			long employeeTrainingId, long instituteId,
			OrderByComparator<EmployeeTraining> orderByComparator)
		throws NoSuchEmployeeTrainingException {

		EmployeeTraining employeeTraining = findByPrimaryKey(
			employeeTrainingId);

		Session session = null;

		try {
			session = openSession();

			EmployeeTraining[] array = new EmployeeTrainingImpl[3];

			array[0] = getByInstituteId_PrevAndNext(
				session, employeeTraining, instituteId, orderByComparator,
				true);

			array[1] = employeeTraining;

			array[2] = getByInstituteId_PrevAndNext(
				session, employeeTraining, instituteId, orderByComparator,
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

	protected EmployeeTraining getByInstituteId_PrevAndNext(
		Session session, EmployeeTraining employeeTraining, long instituteId,
		OrderByComparator<EmployeeTraining> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEETRAINING_WHERE);

		sb.append(_FINDER_COLUMN_INSTITUTEID_INSTITUTEID_2);

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
			sb.append(EmployeeTrainingModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(instituteId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						employeeTraining)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeTraining> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee trainings where instituteId = &#63; from the database.
	 *
	 * @param instituteId the institute ID
	 */
	@Override
	public void removeByInstituteId(long instituteId) {
		for (EmployeeTraining employeeTraining :
				findByInstituteId(
					instituteId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeeTraining);
		}
	}

	/**
	 * Returns the number of employee trainings where instituteId = &#63;.
	 *
	 * @param instituteId the institute ID
	 * @return the number of matching employee trainings
	 */
	@Override
	public int countByInstituteId(long instituteId) {
		FinderPath finderPath = _finderPathCountByInstituteId;

		Object[] finderArgs = new Object[] {instituteId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEETRAINING_WHERE);

			sb.append(_FINDER_COLUMN_INSTITUTEID_INSTITUTEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(instituteId);

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

	private static final String _FINDER_COLUMN_INSTITUTEID_INSTITUTEID_2 =
		"employeeTraining.instituteId = ?";

	private FinderPath _finderPathWithPaginationFindByOrganizationId;
	private FinderPath _finderPathWithoutPaginationFindByOrganizationId;
	private FinderPath _finderPathCountByOrganizationId;

	/**
	 * Returns all the employee trainings where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching employee trainings
	 */
	@Override
	public List<EmployeeTraining> findByOrganizationId(long organizationId) {
		return findByOrganizationId(
			organizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee trainings where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTrainingModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee trainings
	 * @param end the upper bound of the range of employee trainings (not inclusive)
	 * @return the range of matching employee trainings
	 */
	@Override
	public List<EmployeeTraining> findByOrganizationId(
		long organizationId, int start, int end) {

		return findByOrganizationId(organizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee trainings where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTrainingModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee trainings
	 * @param end the upper bound of the range of employee trainings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee trainings
	 */
	@Override
	public List<EmployeeTraining> findByOrganizationId(
		long organizationId, int start, int end,
		OrderByComparator<EmployeeTraining> orderByComparator) {

		return findByOrganizationId(
			organizationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee trainings where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTrainingModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee trainings
	 * @param end the upper bound of the range of employee trainings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee trainings
	 */
	@Override
	public List<EmployeeTraining> findByOrganizationId(
		long organizationId, int start, int end,
		OrderByComparator<EmployeeTraining> orderByComparator,
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

		List<EmployeeTraining> list = null;

		if (useFinderCache) {
			list = (List<EmployeeTraining>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeTraining employeeTraining : list) {
					if (organizationId !=
							employeeTraining.getOrganizationId()) {

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

			sb.append(_SQL_SELECT_EMPLOYEETRAINING_WHERE);

			sb.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeTrainingModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(organizationId);

				list = (List<EmployeeTraining>)QueryUtil.list(
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
	 * Returns the first employee training in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee training
	 * @throws NoSuchEmployeeTrainingException if a matching employee training could not be found
	 */
	@Override
	public EmployeeTraining findByOrganizationId_First(
			long organizationId,
			OrderByComparator<EmployeeTraining> orderByComparator)
		throws NoSuchEmployeeTrainingException {

		EmployeeTraining employeeTraining = fetchByOrganizationId_First(
			organizationId, orderByComparator);

		if (employeeTraining != null) {
			return employeeTraining;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("organizationId=");
		sb.append(organizationId);

		sb.append("}");

		throw new NoSuchEmployeeTrainingException(sb.toString());
	}

	/**
	 * Returns the first employee training in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee training, or <code>null</code> if a matching employee training could not be found
	 */
	@Override
	public EmployeeTraining fetchByOrganizationId_First(
		long organizationId,
		OrderByComparator<EmployeeTraining> orderByComparator) {

		List<EmployeeTraining> list = findByOrganizationId(
			organizationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee training in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee training
	 * @throws NoSuchEmployeeTrainingException if a matching employee training could not be found
	 */
	@Override
	public EmployeeTraining findByOrganizationId_Last(
			long organizationId,
			OrderByComparator<EmployeeTraining> orderByComparator)
		throws NoSuchEmployeeTrainingException {

		EmployeeTraining employeeTraining = fetchByOrganizationId_Last(
			organizationId, orderByComparator);

		if (employeeTraining != null) {
			return employeeTraining;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("organizationId=");
		sb.append(organizationId);

		sb.append("}");

		throw new NoSuchEmployeeTrainingException(sb.toString());
	}

	/**
	 * Returns the last employee training in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee training, or <code>null</code> if a matching employee training could not be found
	 */
	@Override
	public EmployeeTraining fetchByOrganizationId_Last(
		long organizationId,
		OrderByComparator<EmployeeTraining> orderByComparator) {

		int count = countByOrganizationId(organizationId);

		if (count == 0) {
			return null;
		}

		List<EmployeeTraining> list = findByOrganizationId(
			organizationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee trainings before and after the current employee training in the ordered set where organizationId = &#63;.
	 *
	 * @param employeeTrainingId the primary key of the current employee training
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee training
	 * @throws NoSuchEmployeeTrainingException if a employee training with the primary key could not be found
	 */
	@Override
	public EmployeeTraining[] findByOrganizationId_PrevAndNext(
			long employeeTrainingId, long organizationId,
			OrderByComparator<EmployeeTraining> orderByComparator)
		throws NoSuchEmployeeTrainingException {

		EmployeeTraining employeeTraining = findByPrimaryKey(
			employeeTrainingId);

		Session session = null;

		try {
			session = openSession();

			EmployeeTraining[] array = new EmployeeTrainingImpl[3];

			array[0] = getByOrganizationId_PrevAndNext(
				session, employeeTraining, organizationId, orderByComparator,
				true);

			array[1] = employeeTraining;

			array[2] = getByOrganizationId_PrevAndNext(
				session, employeeTraining, organizationId, orderByComparator,
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

	protected EmployeeTraining getByOrganizationId_PrevAndNext(
		Session session, EmployeeTraining employeeTraining, long organizationId,
		OrderByComparator<EmployeeTraining> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEETRAINING_WHERE);

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
			sb.append(EmployeeTrainingModelImpl.ORDER_BY_JPQL);
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
						employeeTraining)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeTraining> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee trainings where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	@Override
	public void removeByOrganizationId(long organizationId) {
		for (EmployeeTraining employeeTraining :
				findByOrganizationId(
					organizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(employeeTraining);
		}
	}

	/**
	 * Returns the number of employee trainings where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching employee trainings
	 */
	@Override
	public int countByOrganizationId(long organizationId) {
		FinderPath finderPath = _finderPathCountByOrganizationId;

		Object[] finderArgs = new Object[] {organizationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEETRAINING_WHERE);

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
		"employeeTraining.organizationId = ?";

	public EmployeeTrainingPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(EmployeeTraining.class);

		setModelImplClass(EmployeeTrainingImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the employee training in the entity cache if it is enabled.
	 *
	 * @param employeeTraining the employee training
	 */
	@Override
	public void cacheResult(EmployeeTraining employeeTraining) {
		entityCache.putResult(
			EmployeeTrainingImpl.class, employeeTraining.getPrimaryKey(),
			employeeTraining);
	}

	/**
	 * Caches the employee trainings in the entity cache if it is enabled.
	 *
	 * @param employeeTrainings the employee trainings
	 */
	@Override
	public void cacheResult(List<EmployeeTraining> employeeTrainings) {
		for (EmployeeTraining employeeTraining : employeeTrainings) {
			if (entityCache.getResult(
					EmployeeTrainingImpl.class,
					employeeTraining.getPrimaryKey()) == null) {

				cacheResult(employeeTraining);
			}
		}
	}

	/**
	 * Clears the cache for all employee trainings.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmployeeTrainingImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the employee training.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmployeeTraining employeeTraining) {
		entityCache.removeResult(EmployeeTrainingImpl.class, employeeTraining);
	}

	@Override
	public void clearCache(List<EmployeeTraining> employeeTrainings) {
		for (EmployeeTraining employeeTraining : employeeTrainings) {
			entityCache.removeResult(
				EmployeeTrainingImpl.class, employeeTraining);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EmployeeTrainingImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new employee training with the primary key. Does not add the employee training to the database.
	 *
	 * @param employeeTrainingId the primary key for the new employee training
	 * @return the new employee training
	 */
	@Override
	public EmployeeTraining create(long employeeTrainingId) {
		EmployeeTraining employeeTraining = new EmployeeTrainingImpl();

		employeeTraining.setNew(true);
		employeeTraining.setPrimaryKey(employeeTrainingId);

		employeeTraining.setCompanyId(CompanyThreadLocal.getCompanyId());

		return employeeTraining;
	}

	/**
	 * Removes the employee training with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeTrainingId the primary key of the employee training
	 * @return the employee training that was removed
	 * @throws NoSuchEmployeeTrainingException if a employee training with the primary key could not be found
	 */
	@Override
	public EmployeeTraining remove(long employeeTrainingId)
		throws NoSuchEmployeeTrainingException {

		return remove((Serializable)employeeTrainingId);
	}

	/**
	 * Removes the employee training with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the employee training
	 * @return the employee training that was removed
	 * @throws NoSuchEmployeeTrainingException if a employee training with the primary key could not be found
	 */
	@Override
	public EmployeeTraining remove(Serializable primaryKey)
		throws NoSuchEmployeeTrainingException {

		Session session = null;

		try {
			session = openSession();

			EmployeeTraining employeeTraining = (EmployeeTraining)session.get(
				EmployeeTrainingImpl.class, primaryKey);

			if (employeeTraining == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmployeeTrainingException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(employeeTraining);
		}
		catch (NoSuchEmployeeTrainingException noSuchEntityException) {
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
	protected EmployeeTraining removeImpl(EmployeeTraining employeeTraining) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(employeeTraining)) {
				employeeTraining = (EmployeeTraining)session.get(
					EmployeeTrainingImpl.class,
					employeeTraining.getPrimaryKeyObj());
			}

			if (employeeTraining != null) {
				session.delete(employeeTraining);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (employeeTraining != null) {
			clearCache(employeeTraining);
		}

		return employeeTraining;
	}

	@Override
	public EmployeeTraining updateImpl(EmployeeTraining employeeTraining) {
		boolean isNew = employeeTraining.isNew();

		if (!(employeeTraining instanceof EmployeeTrainingModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(employeeTraining.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					employeeTraining);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in employeeTraining proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EmployeeTraining implementation " +
					employeeTraining.getClass());
		}

		EmployeeTrainingModelImpl employeeTrainingModelImpl =
			(EmployeeTrainingModelImpl)employeeTraining;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (employeeTraining.getCreateDate() == null)) {
			if (serviceContext == null) {
				employeeTraining.setCreateDate(now);
			}
			else {
				employeeTraining.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!employeeTrainingModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				employeeTraining.setModifiedDate(now);
			}
			else {
				employeeTraining.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(employeeTraining);
			}
			else {
				employeeTraining = (EmployeeTraining)session.merge(
					employeeTraining);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EmployeeTrainingImpl.class, employeeTrainingModelImpl, false, true);

		if (isNew) {
			employeeTraining.setNew(false);
		}

		employeeTraining.resetOriginalValues();

		return employeeTraining;
	}

	/**
	 * Returns the employee training with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee training
	 * @return the employee training
	 * @throws NoSuchEmployeeTrainingException if a employee training with the primary key could not be found
	 */
	@Override
	public EmployeeTraining findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmployeeTrainingException {

		EmployeeTraining employeeTraining = fetchByPrimaryKey(primaryKey);

		if (employeeTraining == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmployeeTrainingException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return employeeTraining;
	}

	/**
	 * Returns the employee training with the primary key or throws a <code>NoSuchEmployeeTrainingException</code> if it could not be found.
	 *
	 * @param employeeTrainingId the primary key of the employee training
	 * @return the employee training
	 * @throws NoSuchEmployeeTrainingException if a employee training with the primary key could not be found
	 */
	@Override
	public EmployeeTraining findByPrimaryKey(long employeeTrainingId)
		throws NoSuchEmployeeTrainingException {

		return findByPrimaryKey((Serializable)employeeTrainingId);
	}

	/**
	 * Returns the employee training with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeTrainingId the primary key of the employee training
	 * @return the employee training, or <code>null</code> if a employee training with the primary key could not be found
	 */
	@Override
	public EmployeeTraining fetchByPrimaryKey(long employeeTrainingId) {
		return fetchByPrimaryKey((Serializable)employeeTrainingId);
	}

	/**
	 * Returns all the employee trainings.
	 *
	 * @return the employee trainings
	 */
	@Override
	public List<EmployeeTraining> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee trainings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTrainingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee trainings
	 * @param end the upper bound of the range of employee trainings (not inclusive)
	 * @return the range of employee trainings
	 */
	@Override
	public List<EmployeeTraining> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee trainings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTrainingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee trainings
	 * @param end the upper bound of the range of employee trainings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee trainings
	 */
	@Override
	public List<EmployeeTraining> findAll(
		int start, int end,
		OrderByComparator<EmployeeTraining> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee trainings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTrainingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee trainings
	 * @param end the upper bound of the range of employee trainings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee trainings
	 */
	@Override
	public List<EmployeeTraining> findAll(
		int start, int end,
		OrderByComparator<EmployeeTraining> orderByComparator,
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

		List<EmployeeTraining> list = null;

		if (useFinderCache) {
			list = (List<EmployeeTraining>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EMPLOYEETRAINING);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLOYEETRAINING;

				sql = sql.concat(EmployeeTrainingModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EmployeeTraining>)QueryUtil.list(
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
	 * Removes all the employee trainings from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EmployeeTraining employeeTraining : findAll()) {
			remove(employeeTraining);
		}
	}

	/**
	 * Returns the number of employee trainings.
	 *
	 * @return the number of employee trainings
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_EMPLOYEETRAINING);

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
		return "employeeTrainingId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EMPLOYEETRAINING;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EmployeeTrainingModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the employee training persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new EmployeeTrainingModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", EmployeeTraining.class.getName()));

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

		_finderPathWithPaginationFindByInstituteId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByInstituteId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"instituteId"}, true);

		_finderPathWithoutPaginationFindByInstituteId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByInstituteId",
			new String[] {Long.class.getName()}, new String[] {"instituteId"},
			true);

		_finderPathCountByInstituteId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByInstituteId",
			new String[] {Long.class.getName()}, new String[] {"instituteId"},
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
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(EmployeeTrainingImpl.class.getName());

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

	private static final String _SQL_SELECT_EMPLOYEETRAINING =
		"SELECT employeeTraining FROM EmployeeTraining employeeTraining";

	private static final String _SQL_SELECT_EMPLOYEETRAINING_WHERE =
		"SELECT employeeTraining FROM EmployeeTraining employeeTraining WHERE ";

	private static final String _SQL_COUNT_EMPLOYEETRAINING =
		"SELECT COUNT(employeeTraining) FROM EmployeeTraining employeeTraining";

	private static final String _SQL_COUNT_EMPLOYEETRAINING_WHERE =
		"SELECT COUNT(employeeTraining) FROM EmployeeTraining employeeTraining WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "employeeTraining.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EmployeeTraining exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EmployeeTraining exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EmployeeTrainingPersistenceImpl.class);

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

	private static class EmployeeTrainingModelArgumentsResolver
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

			EmployeeTrainingModelImpl employeeTrainingModelImpl =
				(EmployeeTrainingModelImpl)baseModel;

			long columnBitmask = employeeTrainingModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					employeeTrainingModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						employeeTrainingModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					employeeTrainingModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			EmployeeTrainingModelImpl employeeTrainingModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						employeeTrainingModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = employeeTrainingModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}