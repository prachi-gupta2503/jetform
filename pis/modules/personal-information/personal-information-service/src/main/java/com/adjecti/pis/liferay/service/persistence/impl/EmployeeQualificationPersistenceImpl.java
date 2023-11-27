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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeQualificationException;
import com.adjecti.pis.liferay.model.EmployeeQualification;
import com.adjecti.pis.liferay.model.impl.EmployeeQualificationImpl;
import com.adjecti.pis.liferay.model.impl.EmployeeQualificationModelImpl;
import com.adjecti.pis.liferay.service.persistence.EmployeeQualificationPersistence;
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
 * The persistence implementation for the employee qualification service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EmployeeQualificationPersistence.class)
public class EmployeeQualificationPersistenceImpl
	extends BasePersistenceImpl<EmployeeQualification>
	implements EmployeeQualificationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EmployeeQualificationUtil</code> to access the employee qualification persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EmployeeQualificationImpl.class.getName();

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
	 * Returns all the employee qualifications where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee qualifications
	 */
	@Override
	public List<EmployeeQualification> findByEmployeeId(long employeeId) {
		return findByEmployeeId(
			employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee qualifications where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee qualifications
	 * @param end the upper bound of the range of employee qualifications (not inclusive)
	 * @return the range of matching employee qualifications
	 */
	@Override
	public List<EmployeeQualification> findByEmployeeId(
		long employeeId, int start, int end) {

		return findByEmployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee qualifications where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee qualifications
	 * @param end the upper bound of the range of employee qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee qualifications
	 */
	@Override
	public List<EmployeeQualification> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeQualification> orderByComparator) {

		return findByEmployeeId(
			employeeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee qualifications where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee qualifications
	 * @param end the upper bound of the range of employee qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee qualifications
	 */
	@Override
	public List<EmployeeQualification> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeQualification> orderByComparator,
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

		List<EmployeeQualification> list = null;

		if (useFinderCache) {
			list = (List<EmployeeQualification>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeQualification employeeQualification : list) {
					if (employeeId != employeeQualification.getEmployeeId()) {
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

			sb.append(_SQL_SELECT_EMPLOYEEQUALIFICATION_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeQualificationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				list = (List<EmployeeQualification>)QueryUtil.list(
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
	 * Returns the first employee qualification in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee qualification
	 * @throws NoSuchEmployeeQualificationException if a matching employee qualification could not be found
	 */
	@Override
	public EmployeeQualification findByEmployeeId_First(
			long employeeId,
			OrderByComparator<EmployeeQualification> orderByComparator)
		throws NoSuchEmployeeQualificationException {

		EmployeeQualification employeeQualification = fetchByEmployeeId_First(
			employeeId, orderByComparator);

		if (employeeQualification != null) {
			return employeeQualification;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeeQualificationException(sb.toString());
	}

	/**
	 * Returns the first employee qualification in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee qualification, or <code>null</code> if a matching employee qualification could not be found
	 */
	@Override
	public EmployeeQualification fetchByEmployeeId_First(
		long employeeId,
		OrderByComparator<EmployeeQualification> orderByComparator) {

		List<EmployeeQualification> list = findByEmployeeId(
			employeeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee qualification in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee qualification
	 * @throws NoSuchEmployeeQualificationException if a matching employee qualification could not be found
	 */
	@Override
	public EmployeeQualification findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<EmployeeQualification> orderByComparator)
		throws NoSuchEmployeeQualificationException {

		EmployeeQualification employeeQualification = fetchByEmployeeId_Last(
			employeeId, orderByComparator);

		if (employeeQualification != null) {
			return employeeQualification;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeeQualificationException(sb.toString());
	}

	/**
	 * Returns the last employee qualification in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee qualification, or <code>null</code> if a matching employee qualification could not be found
	 */
	@Override
	public EmployeeQualification fetchByEmployeeId_Last(
		long employeeId,
		OrderByComparator<EmployeeQualification> orderByComparator) {

		int count = countByEmployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<EmployeeQualification> list = findByEmployeeId(
			employeeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee qualifications before and after the current employee qualification in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeQualificationId the primary key of the current employee qualification
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee qualification
	 * @throws NoSuchEmployeeQualificationException if a employee qualification with the primary key could not be found
	 */
	@Override
	public EmployeeQualification[] findByEmployeeId_PrevAndNext(
			long employeeQualificationId, long employeeId,
			OrderByComparator<EmployeeQualification> orderByComparator)
		throws NoSuchEmployeeQualificationException {

		EmployeeQualification employeeQualification = findByPrimaryKey(
			employeeQualificationId);

		Session session = null;

		try {
			session = openSession();

			EmployeeQualification[] array = new EmployeeQualificationImpl[3];

			array[0] = getByEmployeeId_PrevAndNext(
				session, employeeQualification, employeeId, orderByComparator,
				true);

			array[1] = employeeQualification;

			array[2] = getByEmployeeId_PrevAndNext(
				session, employeeQualification, employeeId, orderByComparator,
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

	protected EmployeeQualification getByEmployeeId_PrevAndNext(
		Session session, EmployeeQualification employeeQualification,
		long employeeId,
		OrderByComparator<EmployeeQualification> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEQUALIFICATION_WHERE);

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
			sb.append(EmployeeQualificationModelImpl.ORDER_BY_JPQL);
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
						employeeQualification)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeQualification> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee qualifications where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeByEmployeeId(long employeeId) {
		for (EmployeeQualification employeeQualification :
				findByEmployeeId(
					employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeeQualification);
		}
	}

	/**
	 * Returns the number of employee qualifications where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee qualifications
	 */
	@Override
	public int countByEmployeeId(long employeeId) {
		FinderPath finderPath = _finderPathCountByEmployeeId;

		Object[] finderArgs = new Object[] {employeeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEQUALIFICATION_WHERE);

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
		"employeeQualification.employeeId = ?";

	private FinderPath _finderPathWithPaginationFindByQualificationId;
	private FinderPath _finderPathWithoutPaginationFindByQualificationId;
	private FinderPath _finderPathCountByQualificationId;

	/**
	 * Returns all the employee qualifications where qualificationId = &#63;.
	 *
	 * @param qualificationId the qualification ID
	 * @return the matching employee qualifications
	 */
	@Override
	public List<EmployeeQualification> findByQualificationId(
		long qualificationId) {

		return findByQualificationId(
			qualificationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee qualifications where qualificationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param qualificationId the qualification ID
	 * @param start the lower bound of the range of employee qualifications
	 * @param end the upper bound of the range of employee qualifications (not inclusive)
	 * @return the range of matching employee qualifications
	 */
	@Override
	public List<EmployeeQualification> findByQualificationId(
		long qualificationId, int start, int end) {

		return findByQualificationId(qualificationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee qualifications where qualificationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param qualificationId the qualification ID
	 * @param start the lower bound of the range of employee qualifications
	 * @param end the upper bound of the range of employee qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee qualifications
	 */
	@Override
	public List<EmployeeQualification> findByQualificationId(
		long qualificationId, int start, int end,
		OrderByComparator<EmployeeQualification> orderByComparator) {

		return findByQualificationId(
			qualificationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee qualifications where qualificationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param qualificationId the qualification ID
	 * @param start the lower bound of the range of employee qualifications
	 * @param end the upper bound of the range of employee qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee qualifications
	 */
	@Override
	public List<EmployeeQualification> findByQualificationId(
		long qualificationId, int start, int end,
		OrderByComparator<EmployeeQualification> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByQualificationId;
				finderArgs = new Object[] {qualificationId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByQualificationId;
			finderArgs = new Object[] {
				qualificationId, start, end, orderByComparator
			};
		}

		List<EmployeeQualification> list = null;

		if (useFinderCache) {
			list = (List<EmployeeQualification>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeQualification employeeQualification : list) {
					if (qualificationId !=
							employeeQualification.getQualificationId()) {

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

			sb.append(_SQL_SELECT_EMPLOYEEQUALIFICATION_WHERE);

			sb.append(_FINDER_COLUMN_QUALIFICATIONID_QUALIFICATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeQualificationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(qualificationId);

				list = (List<EmployeeQualification>)QueryUtil.list(
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
	 * Returns the first employee qualification in the ordered set where qualificationId = &#63;.
	 *
	 * @param qualificationId the qualification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee qualification
	 * @throws NoSuchEmployeeQualificationException if a matching employee qualification could not be found
	 */
	@Override
	public EmployeeQualification findByQualificationId_First(
			long qualificationId,
			OrderByComparator<EmployeeQualification> orderByComparator)
		throws NoSuchEmployeeQualificationException {

		EmployeeQualification employeeQualification =
			fetchByQualificationId_First(qualificationId, orderByComparator);

		if (employeeQualification != null) {
			return employeeQualification;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("qualificationId=");
		sb.append(qualificationId);

		sb.append("}");

		throw new NoSuchEmployeeQualificationException(sb.toString());
	}

	/**
	 * Returns the first employee qualification in the ordered set where qualificationId = &#63;.
	 *
	 * @param qualificationId the qualification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee qualification, or <code>null</code> if a matching employee qualification could not be found
	 */
	@Override
	public EmployeeQualification fetchByQualificationId_First(
		long qualificationId,
		OrderByComparator<EmployeeQualification> orderByComparator) {

		List<EmployeeQualification> list = findByQualificationId(
			qualificationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee qualification in the ordered set where qualificationId = &#63;.
	 *
	 * @param qualificationId the qualification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee qualification
	 * @throws NoSuchEmployeeQualificationException if a matching employee qualification could not be found
	 */
	@Override
	public EmployeeQualification findByQualificationId_Last(
			long qualificationId,
			OrderByComparator<EmployeeQualification> orderByComparator)
		throws NoSuchEmployeeQualificationException {

		EmployeeQualification employeeQualification =
			fetchByQualificationId_Last(qualificationId, orderByComparator);

		if (employeeQualification != null) {
			return employeeQualification;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("qualificationId=");
		sb.append(qualificationId);

		sb.append("}");

		throw new NoSuchEmployeeQualificationException(sb.toString());
	}

	/**
	 * Returns the last employee qualification in the ordered set where qualificationId = &#63;.
	 *
	 * @param qualificationId the qualification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee qualification, or <code>null</code> if a matching employee qualification could not be found
	 */
	@Override
	public EmployeeQualification fetchByQualificationId_Last(
		long qualificationId,
		OrderByComparator<EmployeeQualification> orderByComparator) {

		int count = countByQualificationId(qualificationId);

		if (count == 0) {
			return null;
		}

		List<EmployeeQualification> list = findByQualificationId(
			qualificationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee qualifications before and after the current employee qualification in the ordered set where qualificationId = &#63;.
	 *
	 * @param employeeQualificationId the primary key of the current employee qualification
	 * @param qualificationId the qualification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee qualification
	 * @throws NoSuchEmployeeQualificationException if a employee qualification with the primary key could not be found
	 */
	@Override
	public EmployeeQualification[] findByQualificationId_PrevAndNext(
			long employeeQualificationId, long qualificationId,
			OrderByComparator<EmployeeQualification> orderByComparator)
		throws NoSuchEmployeeQualificationException {

		EmployeeQualification employeeQualification = findByPrimaryKey(
			employeeQualificationId);

		Session session = null;

		try {
			session = openSession();

			EmployeeQualification[] array = new EmployeeQualificationImpl[3];

			array[0] = getByQualificationId_PrevAndNext(
				session, employeeQualification, qualificationId,
				orderByComparator, true);

			array[1] = employeeQualification;

			array[2] = getByQualificationId_PrevAndNext(
				session, employeeQualification, qualificationId,
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

	protected EmployeeQualification getByQualificationId_PrevAndNext(
		Session session, EmployeeQualification employeeQualification,
		long qualificationId,
		OrderByComparator<EmployeeQualification> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEQUALIFICATION_WHERE);

		sb.append(_FINDER_COLUMN_QUALIFICATIONID_QUALIFICATIONID_2);

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
			sb.append(EmployeeQualificationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(qualificationId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						employeeQualification)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeQualification> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee qualifications where qualificationId = &#63; from the database.
	 *
	 * @param qualificationId the qualification ID
	 */
	@Override
	public void removeByQualificationId(long qualificationId) {
		for (EmployeeQualification employeeQualification :
				findByQualificationId(
					qualificationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(employeeQualification);
		}
	}

	/**
	 * Returns the number of employee qualifications where qualificationId = &#63;.
	 *
	 * @param qualificationId the qualification ID
	 * @return the number of matching employee qualifications
	 */
	@Override
	public int countByQualificationId(long qualificationId) {
		FinderPath finderPath = _finderPathCountByQualificationId;

		Object[] finderArgs = new Object[] {qualificationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEQUALIFICATION_WHERE);

			sb.append(_FINDER_COLUMN_QUALIFICATIONID_QUALIFICATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(qualificationId);

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
		_FINDER_COLUMN_QUALIFICATIONID_QUALIFICATIONID_2 =
			"employeeQualification.qualificationId = ?";

	private FinderPath _finderPathWithPaginationFindBySpecializationId;
	private FinderPath _finderPathWithoutPaginationFindBySpecializationId;
	private FinderPath _finderPathCountBySpecializationId;

	/**
	 * Returns all the employee qualifications where specializationId = &#63;.
	 *
	 * @param specializationId the specialization ID
	 * @return the matching employee qualifications
	 */
	@Override
	public List<EmployeeQualification> findBySpecializationId(
		long specializationId) {

		return findBySpecializationId(
			specializationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee qualifications where specializationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param specializationId the specialization ID
	 * @param start the lower bound of the range of employee qualifications
	 * @param end the upper bound of the range of employee qualifications (not inclusive)
	 * @return the range of matching employee qualifications
	 */
	@Override
	public List<EmployeeQualification> findBySpecializationId(
		long specializationId, int start, int end) {

		return findBySpecializationId(specializationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee qualifications where specializationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param specializationId the specialization ID
	 * @param start the lower bound of the range of employee qualifications
	 * @param end the upper bound of the range of employee qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee qualifications
	 */
	@Override
	public List<EmployeeQualification> findBySpecializationId(
		long specializationId, int start, int end,
		OrderByComparator<EmployeeQualification> orderByComparator) {

		return findBySpecializationId(
			specializationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee qualifications where specializationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param specializationId the specialization ID
	 * @param start the lower bound of the range of employee qualifications
	 * @param end the upper bound of the range of employee qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee qualifications
	 */
	@Override
	public List<EmployeeQualification> findBySpecializationId(
		long specializationId, int start, int end,
		OrderByComparator<EmployeeQualification> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBySpecializationId;
				finderArgs = new Object[] {specializationId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBySpecializationId;
			finderArgs = new Object[] {
				specializationId, start, end, orderByComparator
			};
		}

		List<EmployeeQualification> list = null;

		if (useFinderCache) {
			list = (List<EmployeeQualification>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeQualification employeeQualification : list) {
					if (specializationId !=
							employeeQualification.getSpecializationId()) {

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

			sb.append(_SQL_SELECT_EMPLOYEEQUALIFICATION_WHERE);

			sb.append(_FINDER_COLUMN_SPECIALIZATIONID_SPECIALIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeQualificationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(specializationId);

				list = (List<EmployeeQualification>)QueryUtil.list(
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
	 * Returns the first employee qualification in the ordered set where specializationId = &#63;.
	 *
	 * @param specializationId the specialization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee qualification
	 * @throws NoSuchEmployeeQualificationException if a matching employee qualification could not be found
	 */
	@Override
	public EmployeeQualification findBySpecializationId_First(
			long specializationId,
			OrderByComparator<EmployeeQualification> orderByComparator)
		throws NoSuchEmployeeQualificationException {

		EmployeeQualification employeeQualification =
			fetchBySpecializationId_First(specializationId, orderByComparator);

		if (employeeQualification != null) {
			return employeeQualification;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("specializationId=");
		sb.append(specializationId);

		sb.append("}");

		throw new NoSuchEmployeeQualificationException(sb.toString());
	}

	/**
	 * Returns the first employee qualification in the ordered set where specializationId = &#63;.
	 *
	 * @param specializationId the specialization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee qualification, or <code>null</code> if a matching employee qualification could not be found
	 */
	@Override
	public EmployeeQualification fetchBySpecializationId_First(
		long specializationId,
		OrderByComparator<EmployeeQualification> orderByComparator) {

		List<EmployeeQualification> list = findBySpecializationId(
			specializationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee qualification in the ordered set where specializationId = &#63;.
	 *
	 * @param specializationId the specialization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee qualification
	 * @throws NoSuchEmployeeQualificationException if a matching employee qualification could not be found
	 */
	@Override
	public EmployeeQualification findBySpecializationId_Last(
			long specializationId,
			OrderByComparator<EmployeeQualification> orderByComparator)
		throws NoSuchEmployeeQualificationException {

		EmployeeQualification employeeQualification =
			fetchBySpecializationId_Last(specializationId, orderByComparator);

		if (employeeQualification != null) {
			return employeeQualification;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("specializationId=");
		sb.append(specializationId);

		sb.append("}");

		throw new NoSuchEmployeeQualificationException(sb.toString());
	}

	/**
	 * Returns the last employee qualification in the ordered set where specializationId = &#63;.
	 *
	 * @param specializationId the specialization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee qualification, or <code>null</code> if a matching employee qualification could not be found
	 */
	@Override
	public EmployeeQualification fetchBySpecializationId_Last(
		long specializationId,
		OrderByComparator<EmployeeQualification> orderByComparator) {

		int count = countBySpecializationId(specializationId);

		if (count == 0) {
			return null;
		}

		List<EmployeeQualification> list = findBySpecializationId(
			specializationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee qualifications before and after the current employee qualification in the ordered set where specializationId = &#63;.
	 *
	 * @param employeeQualificationId the primary key of the current employee qualification
	 * @param specializationId the specialization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee qualification
	 * @throws NoSuchEmployeeQualificationException if a employee qualification with the primary key could not be found
	 */
	@Override
	public EmployeeQualification[] findBySpecializationId_PrevAndNext(
			long employeeQualificationId, long specializationId,
			OrderByComparator<EmployeeQualification> orderByComparator)
		throws NoSuchEmployeeQualificationException {

		EmployeeQualification employeeQualification = findByPrimaryKey(
			employeeQualificationId);

		Session session = null;

		try {
			session = openSession();

			EmployeeQualification[] array = new EmployeeQualificationImpl[3];

			array[0] = getBySpecializationId_PrevAndNext(
				session, employeeQualification, specializationId,
				orderByComparator, true);

			array[1] = employeeQualification;

			array[2] = getBySpecializationId_PrevAndNext(
				session, employeeQualification, specializationId,
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

	protected EmployeeQualification getBySpecializationId_PrevAndNext(
		Session session, EmployeeQualification employeeQualification,
		long specializationId,
		OrderByComparator<EmployeeQualification> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEQUALIFICATION_WHERE);

		sb.append(_FINDER_COLUMN_SPECIALIZATIONID_SPECIALIZATIONID_2);

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
			sb.append(EmployeeQualificationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(specializationId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						employeeQualification)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeQualification> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee qualifications where specializationId = &#63; from the database.
	 *
	 * @param specializationId the specialization ID
	 */
	@Override
	public void removeBySpecializationId(long specializationId) {
		for (EmployeeQualification employeeQualification :
				findBySpecializationId(
					specializationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(employeeQualification);
		}
	}

	/**
	 * Returns the number of employee qualifications where specializationId = &#63;.
	 *
	 * @param specializationId the specialization ID
	 * @return the number of matching employee qualifications
	 */
	@Override
	public int countBySpecializationId(long specializationId) {
		FinderPath finderPath = _finderPathCountBySpecializationId;

		Object[] finderArgs = new Object[] {specializationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEQUALIFICATION_WHERE);

			sb.append(_FINDER_COLUMN_SPECIALIZATIONID_SPECIALIZATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(specializationId);

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
		_FINDER_COLUMN_SPECIALIZATIONID_SPECIALIZATIONID_2 =
			"employeeQualification.specializationId = ?";

	private FinderPath _finderPathWithPaginationFindByJoiningProcessId;
	private FinderPath _finderPathWithoutPaginationFindByJoiningProcessId;
	private FinderPath _finderPathCountByJoiningProcessId;

	/**
	 * Returns all the employee qualifications where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @return the matching employee qualifications
	 */
	@Override
	public List<EmployeeQualification> findByJoiningProcessId(
		long joiningProcessId) {

		return findByJoiningProcessId(
			joiningProcessId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee qualifications where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of employee qualifications
	 * @param end the upper bound of the range of employee qualifications (not inclusive)
	 * @return the range of matching employee qualifications
	 */
	@Override
	public List<EmployeeQualification> findByJoiningProcessId(
		long joiningProcessId, int start, int end) {

		return findByJoiningProcessId(joiningProcessId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee qualifications where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of employee qualifications
	 * @param end the upper bound of the range of employee qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee qualifications
	 */
	@Override
	public List<EmployeeQualification> findByJoiningProcessId(
		long joiningProcessId, int start, int end,
		OrderByComparator<EmployeeQualification> orderByComparator) {

		return findByJoiningProcessId(
			joiningProcessId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee qualifications where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of employee qualifications
	 * @param end the upper bound of the range of employee qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee qualifications
	 */
	@Override
	public List<EmployeeQualification> findByJoiningProcessId(
		long joiningProcessId, int start, int end,
		OrderByComparator<EmployeeQualification> orderByComparator,
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

		List<EmployeeQualification> list = null;

		if (useFinderCache) {
			list = (List<EmployeeQualification>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeQualification employeeQualification : list) {
					if (joiningProcessId !=
							employeeQualification.getJoiningProcessId()) {

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

			sb.append(_SQL_SELECT_EMPLOYEEQUALIFICATION_WHERE);

			sb.append(_FINDER_COLUMN_JOININGPROCESSID_JOININGPROCESSID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeQualificationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(joiningProcessId);

				list = (List<EmployeeQualification>)QueryUtil.list(
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
	 * Returns the first employee qualification in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee qualification
	 * @throws NoSuchEmployeeQualificationException if a matching employee qualification could not be found
	 */
	@Override
	public EmployeeQualification findByJoiningProcessId_First(
			long joiningProcessId,
			OrderByComparator<EmployeeQualification> orderByComparator)
		throws NoSuchEmployeeQualificationException {

		EmployeeQualification employeeQualification =
			fetchByJoiningProcessId_First(joiningProcessId, orderByComparator);

		if (employeeQualification != null) {
			return employeeQualification;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("joiningProcessId=");
		sb.append(joiningProcessId);

		sb.append("}");

		throw new NoSuchEmployeeQualificationException(sb.toString());
	}

	/**
	 * Returns the first employee qualification in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee qualification, or <code>null</code> if a matching employee qualification could not be found
	 */
	@Override
	public EmployeeQualification fetchByJoiningProcessId_First(
		long joiningProcessId,
		OrderByComparator<EmployeeQualification> orderByComparator) {

		List<EmployeeQualification> list = findByJoiningProcessId(
			joiningProcessId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee qualification in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee qualification
	 * @throws NoSuchEmployeeQualificationException if a matching employee qualification could not be found
	 */
	@Override
	public EmployeeQualification findByJoiningProcessId_Last(
			long joiningProcessId,
			OrderByComparator<EmployeeQualification> orderByComparator)
		throws NoSuchEmployeeQualificationException {

		EmployeeQualification employeeQualification =
			fetchByJoiningProcessId_Last(joiningProcessId, orderByComparator);

		if (employeeQualification != null) {
			return employeeQualification;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("joiningProcessId=");
		sb.append(joiningProcessId);

		sb.append("}");

		throw new NoSuchEmployeeQualificationException(sb.toString());
	}

	/**
	 * Returns the last employee qualification in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee qualification, or <code>null</code> if a matching employee qualification could not be found
	 */
	@Override
	public EmployeeQualification fetchByJoiningProcessId_Last(
		long joiningProcessId,
		OrderByComparator<EmployeeQualification> orderByComparator) {

		int count = countByJoiningProcessId(joiningProcessId);

		if (count == 0) {
			return null;
		}

		List<EmployeeQualification> list = findByJoiningProcessId(
			joiningProcessId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee qualifications before and after the current employee qualification in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param employeeQualificationId the primary key of the current employee qualification
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee qualification
	 * @throws NoSuchEmployeeQualificationException if a employee qualification with the primary key could not be found
	 */
	@Override
	public EmployeeQualification[] findByJoiningProcessId_PrevAndNext(
			long employeeQualificationId, long joiningProcessId,
			OrderByComparator<EmployeeQualification> orderByComparator)
		throws NoSuchEmployeeQualificationException {

		EmployeeQualification employeeQualification = findByPrimaryKey(
			employeeQualificationId);

		Session session = null;

		try {
			session = openSession();

			EmployeeQualification[] array = new EmployeeQualificationImpl[3];

			array[0] = getByJoiningProcessId_PrevAndNext(
				session, employeeQualification, joiningProcessId,
				orderByComparator, true);

			array[1] = employeeQualification;

			array[2] = getByJoiningProcessId_PrevAndNext(
				session, employeeQualification, joiningProcessId,
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

	protected EmployeeQualification getByJoiningProcessId_PrevAndNext(
		Session session, EmployeeQualification employeeQualification,
		long joiningProcessId,
		OrderByComparator<EmployeeQualification> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEQUALIFICATION_WHERE);

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
			sb.append(EmployeeQualificationModelImpl.ORDER_BY_JPQL);
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
						employeeQualification)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeQualification> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee qualifications where joiningProcessId = &#63; from the database.
	 *
	 * @param joiningProcessId the joining process ID
	 */
	@Override
	public void removeByJoiningProcessId(long joiningProcessId) {
		for (EmployeeQualification employeeQualification :
				findByJoiningProcessId(
					joiningProcessId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(employeeQualification);
		}
	}

	/**
	 * Returns the number of employee qualifications where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @return the number of matching employee qualifications
	 */
	@Override
	public int countByJoiningProcessId(long joiningProcessId) {
		FinderPath finderPath = _finderPathCountByJoiningProcessId;

		Object[] finderArgs = new Object[] {joiningProcessId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEQUALIFICATION_WHERE);

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
			"employeeQualification.joiningProcessId = ?";

	private FinderPath _finderPathWithPaginationFindByQualificationLevelId;
	private FinderPath _finderPathWithoutPaginationFindByQualificationLevelId;
	private FinderPath _finderPathCountByQualificationLevelId;

	/**
	 * Returns all the employee qualifications where levelId = &#63;.
	 *
	 * @param levelId the level ID
	 * @return the matching employee qualifications
	 */
	@Override
	public List<EmployeeQualification> findByQualificationLevelId(
		long levelId) {

		return findByQualificationLevelId(
			levelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee qualifications where levelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param levelId the level ID
	 * @param start the lower bound of the range of employee qualifications
	 * @param end the upper bound of the range of employee qualifications (not inclusive)
	 * @return the range of matching employee qualifications
	 */
	@Override
	public List<EmployeeQualification> findByQualificationLevelId(
		long levelId, int start, int end) {

		return findByQualificationLevelId(levelId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee qualifications where levelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param levelId the level ID
	 * @param start the lower bound of the range of employee qualifications
	 * @param end the upper bound of the range of employee qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee qualifications
	 */
	@Override
	public List<EmployeeQualification> findByQualificationLevelId(
		long levelId, int start, int end,
		OrderByComparator<EmployeeQualification> orderByComparator) {

		return findByQualificationLevelId(
			levelId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee qualifications where levelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param levelId the level ID
	 * @param start the lower bound of the range of employee qualifications
	 * @param end the upper bound of the range of employee qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee qualifications
	 */
	@Override
	public List<EmployeeQualification> findByQualificationLevelId(
		long levelId, int start, int end,
		OrderByComparator<EmployeeQualification> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByQualificationLevelId;
				finderArgs = new Object[] {levelId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByQualificationLevelId;
			finderArgs = new Object[] {levelId, start, end, orderByComparator};
		}

		List<EmployeeQualification> list = null;

		if (useFinderCache) {
			list = (List<EmployeeQualification>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeQualification employeeQualification : list) {
					if (levelId != employeeQualification.getLevelId()) {
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

			sb.append(_SQL_SELECT_EMPLOYEEQUALIFICATION_WHERE);

			sb.append(_FINDER_COLUMN_QUALIFICATIONLEVELID_LEVELID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeQualificationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(levelId);

				list = (List<EmployeeQualification>)QueryUtil.list(
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
	 * Returns the first employee qualification in the ordered set where levelId = &#63;.
	 *
	 * @param levelId the level ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee qualification
	 * @throws NoSuchEmployeeQualificationException if a matching employee qualification could not be found
	 */
	@Override
	public EmployeeQualification findByQualificationLevelId_First(
			long levelId,
			OrderByComparator<EmployeeQualification> orderByComparator)
		throws NoSuchEmployeeQualificationException {

		EmployeeQualification employeeQualification =
			fetchByQualificationLevelId_First(levelId, orderByComparator);

		if (employeeQualification != null) {
			return employeeQualification;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("levelId=");
		sb.append(levelId);

		sb.append("}");

		throw new NoSuchEmployeeQualificationException(sb.toString());
	}

	/**
	 * Returns the first employee qualification in the ordered set where levelId = &#63;.
	 *
	 * @param levelId the level ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee qualification, or <code>null</code> if a matching employee qualification could not be found
	 */
	@Override
	public EmployeeQualification fetchByQualificationLevelId_First(
		long levelId,
		OrderByComparator<EmployeeQualification> orderByComparator) {

		List<EmployeeQualification> list = findByQualificationLevelId(
			levelId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee qualification in the ordered set where levelId = &#63;.
	 *
	 * @param levelId the level ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee qualification
	 * @throws NoSuchEmployeeQualificationException if a matching employee qualification could not be found
	 */
	@Override
	public EmployeeQualification findByQualificationLevelId_Last(
			long levelId,
			OrderByComparator<EmployeeQualification> orderByComparator)
		throws NoSuchEmployeeQualificationException {

		EmployeeQualification employeeQualification =
			fetchByQualificationLevelId_Last(levelId, orderByComparator);

		if (employeeQualification != null) {
			return employeeQualification;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("levelId=");
		sb.append(levelId);

		sb.append("}");

		throw new NoSuchEmployeeQualificationException(sb.toString());
	}

	/**
	 * Returns the last employee qualification in the ordered set where levelId = &#63;.
	 *
	 * @param levelId the level ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee qualification, or <code>null</code> if a matching employee qualification could not be found
	 */
	@Override
	public EmployeeQualification fetchByQualificationLevelId_Last(
		long levelId,
		OrderByComparator<EmployeeQualification> orderByComparator) {

		int count = countByQualificationLevelId(levelId);

		if (count == 0) {
			return null;
		}

		List<EmployeeQualification> list = findByQualificationLevelId(
			levelId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee qualifications before and after the current employee qualification in the ordered set where levelId = &#63;.
	 *
	 * @param employeeQualificationId the primary key of the current employee qualification
	 * @param levelId the level ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee qualification
	 * @throws NoSuchEmployeeQualificationException if a employee qualification with the primary key could not be found
	 */
	@Override
	public EmployeeQualification[] findByQualificationLevelId_PrevAndNext(
			long employeeQualificationId, long levelId,
			OrderByComparator<EmployeeQualification> orderByComparator)
		throws NoSuchEmployeeQualificationException {

		EmployeeQualification employeeQualification = findByPrimaryKey(
			employeeQualificationId);

		Session session = null;

		try {
			session = openSession();

			EmployeeQualification[] array = new EmployeeQualificationImpl[3];

			array[0] = getByQualificationLevelId_PrevAndNext(
				session, employeeQualification, levelId, orderByComparator,
				true);

			array[1] = employeeQualification;

			array[2] = getByQualificationLevelId_PrevAndNext(
				session, employeeQualification, levelId, orderByComparator,
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

	protected EmployeeQualification getByQualificationLevelId_PrevAndNext(
		Session session, EmployeeQualification employeeQualification,
		long levelId,
		OrderByComparator<EmployeeQualification> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEQUALIFICATION_WHERE);

		sb.append(_FINDER_COLUMN_QUALIFICATIONLEVELID_LEVELID_2);

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
			sb.append(EmployeeQualificationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(levelId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						employeeQualification)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeQualification> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee qualifications where levelId = &#63; from the database.
	 *
	 * @param levelId the level ID
	 */
	@Override
	public void removeByQualificationLevelId(long levelId) {
		for (EmployeeQualification employeeQualification :
				findByQualificationLevelId(
					levelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeeQualification);
		}
	}

	/**
	 * Returns the number of employee qualifications where levelId = &#63;.
	 *
	 * @param levelId the level ID
	 * @return the number of matching employee qualifications
	 */
	@Override
	public int countByQualificationLevelId(long levelId) {
		FinderPath finderPath = _finderPathCountByQualificationLevelId;

		Object[] finderArgs = new Object[] {levelId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEQUALIFICATION_WHERE);

			sb.append(_FINDER_COLUMN_QUALIFICATIONLEVELID_LEVELID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(levelId);

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

	private static final String _FINDER_COLUMN_QUALIFICATIONLEVELID_LEVELID_2 =
		"employeeQualification.levelId = ?";

	public EmployeeQualificationPersistenceImpl() {
		setModelClass(EmployeeQualification.class);

		setModelImplClass(EmployeeQualificationImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the employee qualification in the entity cache if it is enabled.
	 *
	 * @param employeeQualification the employee qualification
	 */
	@Override
	public void cacheResult(EmployeeQualification employeeQualification) {
		entityCache.putResult(
			EmployeeQualificationImpl.class,
			employeeQualification.getPrimaryKey(), employeeQualification);
	}

	/**
	 * Caches the employee qualifications in the entity cache if it is enabled.
	 *
	 * @param employeeQualifications the employee qualifications
	 */
	@Override
	public void cacheResult(
		List<EmployeeQualification> employeeQualifications) {

		for (EmployeeQualification employeeQualification :
				employeeQualifications) {

			if (entityCache.getResult(
					EmployeeQualificationImpl.class,
					employeeQualification.getPrimaryKey()) == null) {

				cacheResult(employeeQualification);
			}
		}
	}

	/**
	 * Clears the cache for all employee qualifications.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmployeeQualificationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the employee qualification.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmployeeQualification employeeQualification) {
		entityCache.removeResult(
			EmployeeQualificationImpl.class, employeeQualification);
	}

	@Override
	public void clearCache(List<EmployeeQualification> employeeQualifications) {
		for (EmployeeQualification employeeQualification :
				employeeQualifications) {

			entityCache.removeResult(
				EmployeeQualificationImpl.class, employeeQualification);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				EmployeeQualificationImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new employee qualification with the primary key. Does not add the employee qualification to the database.
	 *
	 * @param employeeQualificationId the primary key for the new employee qualification
	 * @return the new employee qualification
	 */
	@Override
	public EmployeeQualification create(long employeeQualificationId) {
		EmployeeQualification employeeQualification =
			new EmployeeQualificationImpl();

		employeeQualification.setNew(true);
		employeeQualification.setPrimaryKey(employeeQualificationId);

		employeeQualification.setCompanyId(CompanyThreadLocal.getCompanyId());

		return employeeQualification;
	}

	/**
	 * Removes the employee qualification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeQualificationId the primary key of the employee qualification
	 * @return the employee qualification that was removed
	 * @throws NoSuchEmployeeQualificationException if a employee qualification with the primary key could not be found
	 */
	@Override
	public EmployeeQualification remove(long employeeQualificationId)
		throws NoSuchEmployeeQualificationException {

		return remove((Serializable)employeeQualificationId);
	}

	/**
	 * Removes the employee qualification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the employee qualification
	 * @return the employee qualification that was removed
	 * @throws NoSuchEmployeeQualificationException if a employee qualification with the primary key could not be found
	 */
	@Override
	public EmployeeQualification remove(Serializable primaryKey)
		throws NoSuchEmployeeQualificationException {

		Session session = null;

		try {
			session = openSession();

			EmployeeQualification employeeQualification =
				(EmployeeQualification)session.get(
					EmployeeQualificationImpl.class, primaryKey);

			if (employeeQualification == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmployeeQualificationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(employeeQualification);
		}
		catch (NoSuchEmployeeQualificationException noSuchEntityException) {
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
	protected EmployeeQualification removeImpl(
		EmployeeQualification employeeQualification) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(employeeQualification)) {
				employeeQualification = (EmployeeQualification)session.get(
					EmployeeQualificationImpl.class,
					employeeQualification.getPrimaryKeyObj());
			}

			if (employeeQualification != null) {
				session.delete(employeeQualification);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (employeeQualification != null) {
			clearCache(employeeQualification);
		}

		return employeeQualification;
	}

	@Override
	public EmployeeQualification updateImpl(
		EmployeeQualification employeeQualification) {

		boolean isNew = employeeQualification.isNew();

		if (!(employeeQualification instanceof
				EmployeeQualificationModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(employeeQualification.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					employeeQualification);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in employeeQualification proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EmployeeQualification implementation " +
					employeeQualification.getClass());
		}

		EmployeeQualificationModelImpl employeeQualificationModelImpl =
			(EmployeeQualificationModelImpl)employeeQualification;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (employeeQualification.getCreateDate() == null)) {
			if (serviceContext == null) {
				employeeQualification.setCreateDate(now);
			}
			else {
				employeeQualification.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!employeeQualificationModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				employeeQualification.setModifiedDate(now);
			}
			else {
				employeeQualification.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(employeeQualification);
			}
			else {
				employeeQualification = (EmployeeQualification)session.merge(
					employeeQualification);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EmployeeQualificationImpl.class, employeeQualificationModelImpl,
			false, true);

		if (isNew) {
			employeeQualification.setNew(false);
		}

		employeeQualification.resetOriginalValues();

		return employeeQualification;
	}

	/**
	 * Returns the employee qualification with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee qualification
	 * @return the employee qualification
	 * @throws NoSuchEmployeeQualificationException if a employee qualification with the primary key could not be found
	 */
	@Override
	public EmployeeQualification findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmployeeQualificationException {

		EmployeeQualification employeeQualification = fetchByPrimaryKey(
			primaryKey);

		if (employeeQualification == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmployeeQualificationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return employeeQualification;
	}

	/**
	 * Returns the employee qualification with the primary key or throws a <code>NoSuchEmployeeQualificationException</code> if it could not be found.
	 *
	 * @param employeeQualificationId the primary key of the employee qualification
	 * @return the employee qualification
	 * @throws NoSuchEmployeeQualificationException if a employee qualification with the primary key could not be found
	 */
	@Override
	public EmployeeQualification findByPrimaryKey(long employeeQualificationId)
		throws NoSuchEmployeeQualificationException {

		return findByPrimaryKey((Serializable)employeeQualificationId);
	}

	/**
	 * Returns the employee qualification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeQualificationId the primary key of the employee qualification
	 * @return the employee qualification, or <code>null</code> if a employee qualification with the primary key could not be found
	 */
	@Override
	public EmployeeQualification fetchByPrimaryKey(
		long employeeQualificationId) {

		return fetchByPrimaryKey((Serializable)employeeQualificationId);
	}

	/**
	 * Returns all the employee qualifications.
	 *
	 * @return the employee qualifications
	 */
	@Override
	public List<EmployeeQualification> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee qualifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee qualifications
	 * @param end the upper bound of the range of employee qualifications (not inclusive)
	 * @return the range of employee qualifications
	 */
	@Override
	public List<EmployeeQualification> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee qualifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee qualifications
	 * @param end the upper bound of the range of employee qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee qualifications
	 */
	@Override
	public List<EmployeeQualification> findAll(
		int start, int end,
		OrderByComparator<EmployeeQualification> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee qualifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee qualifications
	 * @param end the upper bound of the range of employee qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee qualifications
	 */
	@Override
	public List<EmployeeQualification> findAll(
		int start, int end,
		OrderByComparator<EmployeeQualification> orderByComparator,
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

		List<EmployeeQualification> list = null;

		if (useFinderCache) {
			list = (List<EmployeeQualification>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EMPLOYEEQUALIFICATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLOYEEQUALIFICATION;

				sql = sql.concat(EmployeeQualificationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EmployeeQualification>)QueryUtil.list(
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
	 * Removes all the employee qualifications from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EmployeeQualification employeeQualification : findAll()) {
			remove(employeeQualification);
		}
	}

	/**
	 * Returns the number of employee qualifications.
	 *
	 * @return the number of employee qualifications
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
					_SQL_COUNT_EMPLOYEEQUALIFICATION);

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
		return "employeeQualificationId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EMPLOYEEQUALIFICATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EmployeeQualificationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the employee qualification persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new EmployeeQualificationModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", EmployeeQualification.class.getName()));

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

		_finderPathWithPaginationFindByQualificationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByQualificationId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"qualificationId"}, true);

		_finderPathWithoutPaginationFindByQualificationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByQualificationId",
			new String[] {Long.class.getName()},
			new String[] {"qualificationId"}, true);

		_finderPathCountByQualificationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByQualificationId",
			new String[] {Long.class.getName()},
			new String[] {"qualificationId"}, false);

		_finderPathWithPaginationFindBySpecializationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySpecializationId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"specializationId"}, true);

		_finderPathWithoutPaginationFindBySpecializationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySpecializationId",
			new String[] {Long.class.getName()},
			new String[] {"specializationId"}, true);

		_finderPathCountBySpecializationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySpecializationId", new String[] {Long.class.getName()},
			new String[] {"specializationId"}, false);

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

		_finderPathWithPaginationFindByQualificationLevelId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByQualificationLevelId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"levelId"}, true);

		_finderPathWithoutPaginationFindByQualificationLevelId =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByQualificationLevelId",
				new String[] {Long.class.getName()}, new String[] {"levelId"},
				true);

		_finderPathCountByQualificationLevelId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByQualificationLevelId", new String[] {Long.class.getName()},
			new String[] {"levelId"}, false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(EmployeeQualificationImpl.class.getName());

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

	private static final String _SQL_SELECT_EMPLOYEEQUALIFICATION =
		"SELECT employeeQualification FROM EmployeeQualification employeeQualification";

	private static final String _SQL_SELECT_EMPLOYEEQUALIFICATION_WHERE =
		"SELECT employeeQualification FROM EmployeeQualification employeeQualification WHERE ";

	private static final String _SQL_COUNT_EMPLOYEEQUALIFICATION =
		"SELECT COUNT(employeeQualification) FROM EmployeeQualification employeeQualification";

	private static final String _SQL_COUNT_EMPLOYEEQUALIFICATION_WHERE =
		"SELECT COUNT(employeeQualification) FROM EmployeeQualification employeeQualification WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"employeeQualification.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EmployeeQualification exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EmployeeQualification exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EmployeeQualificationPersistenceImpl.class);

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

	private static class EmployeeQualificationModelArgumentsResolver
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

			EmployeeQualificationModelImpl employeeQualificationModelImpl =
				(EmployeeQualificationModelImpl)baseModel;

			long columnBitmask =
				employeeQualificationModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					employeeQualificationModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						employeeQualificationModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					employeeQualificationModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			EmployeeQualificationModelImpl employeeQualificationModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						employeeQualificationModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] =
						employeeQualificationModelImpl.getColumnValue(
							columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}