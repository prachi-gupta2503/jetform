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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeVerificationException;
import com.adjecti.pis.liferay.model.EmployeeVerification;
import com.adjecti.pis.liferay.model.impl.EmployeeVerificationImpl;
import com.adjecti.pis.liferay.model.impl.EmployeeVerificationModelImpl;
import com.adjecti.pis.liferay.service.persistence.EmployeeVerificationPersistence;
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
 * The persistence implementation for the employee verification service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EmployeeVerificationPersistence.class)
public class EmployeeVerificationPersistenceImpl
	extends BasePersistenceImpl<EmployeeVerification>
	implements EmployeeVerificationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EmployeeVerificationUtil</code> to access the employee verification persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EmployeeVerificationImpl.class.getName();

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
	 * Returns all the employee verifications where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee verifications
	 */
	@Override
	public List<EmployeeVerification> findByEmployeeId(long employeeId) {
		return findByEmployeeId(
			employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee verifications where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeVerificationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee verifications
	 * @param end the upper bound of the range of employee verifications (not inclusive)
	 * @return the range of matching employee verifications
	 */
	@Override
	public List<EmployeeVerification> findByEmployeeId(
		long employeeId, int start, int end) {

		return findByEmployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee verifications where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeVerificationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee verifications
	 * @param end the upper bound of the range of employee verifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee verifications
	 */
	@Override
	public List<EmployeeVerification> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeVerification> orderByComparator) {

		return findByEmployeeId(
			employeeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee verifications where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeVerificationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee verifications
	 * @param end the upper bound of the range of employee verifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee verifications
	 */
	@Override
	public List<EmployeeVerification> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeVerification> orderByComparator,
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

		List<EmployeeVerification> list = null;

		if (useFinderCache) {
			list = (List<EmployeeVerification>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeVerification employeeVerification : list) {
					if (employeeId != employeeVerification.getEmployeeId()) {
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

			sb.append(_SQL_SELECT_EMPLOYEEVERIFICATION_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeVerificationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				list = (List<EmployeeVerification>)QueryUtil.list(
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
	 * Returns the first employee verification in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee verification
	 * @throws NoSuchEmployeeVerificationException if a matching employee verification could not be found
	 */
	@Override
	public EmployeeVerification findByEmployeeId_First(
			long employeeId,
			OrderByComparator<EmployeeVerification> orderByComparator)
		throws NoSuchEmployeeVerificationException {

		EmployeeVerification employeeVerification = fetchByEmployeeId_First(
			employeeId, orderByComparator);

		if (employeeVerification != null) {
			return employeeVerification;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeeVerificationException(sb.toString());
	}

	/**
	 * Returns the first employee verification in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee verification, or <code>null</code> if a matching employee verification could not be found
	 */
	@Override
	public EmployeeVerification fetchByEmployeeId_First(
		long employeeId,
		OrderByComparator<EmployeeVerification> orderByComparator) {

		List<EmployeeVerification> list = findByEmployeeId(
			employeeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee verification in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee verification
	 * @throws NoSuchEmployeeVerificationException if a matching employee verification could not be found
	 */
	@Override
	public EmployeeVerification findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<EmployeeVerification> orderByComparator)
		throws NoSuchEmployeeVerificationException {

		EmployeeVerification employeeVerification = fetchByEmployeeId_Last(
			employeeId, orderByComparator);

		if (employeeVerification != null) {
			return employeeVerification;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeeVerificationException(sb.toString());
	}

	/**
	 * Returns the last employee verification in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee verification, or <code>null</code> if a matching employee verification could not be found
	 */
	@Override
	public EmployeeVerification fetchByEmployeeId_Last(
		long employeeId,
		OrderByComparator<EmployeeVerification> orderByComparator) {

		int count = countByEmployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<EmployeeVerification> list = findByEmployeeId(
			employeeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee verifications before and after the current employee verification in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeVerificationId the primary key of the current employee verification
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee verification
	 * @throws NoSuchEmployeeVerificationException if a employee verification with the primary key could not be found
	 */
	@Override
	public EmployeeVerification[] findByEmployeeId_PrevAndNext(
			long employeeVerificationId, long employeeId,
			OrderByComparator<EmployeeVerification> orderByComparator)
		throws NoSuchEmployeeVerificationException {

		EmployeeVerification employeeVerification = findByPrimaryKey(
			employeeVerificationId);

		Session session = null;

		try {
			session = openSession();

			EmployeeVerification[] array = new EmployeeVerificationImpl[3];

			array[0] = getByEmployeeId_PrevAndNext(
				session, employeeVerification, employeeId, orderByComparator,
				true);

			array[1] = employeeVerification;

			array[2] = getByEmployeeId_PrevAndNext(
				session, employeeVerification, employeeId, orderByComparator,
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

	protected EmployeeVerification getByEmployeeId_PrevAndNext(
		Session session, EmployeeVerification employeeVerification,
		long employeeId,
		OrderByComparator<EmployeeVerification> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEVERIFICATION_WHERE);

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
			sb.append(EmployeeVerificationModelImpl.ORDER_BY_JPQL);
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
						employeeVerification)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeVerification> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee verifications where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeByEmployeeId(long employeeId) {
		for (EmployeeVerification employeeVerification :
				findByEmployeeId(
					employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeeVerification);
		}
	}

	/**
	 * Returns the number of employee verifications where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee verifications
	 */
	@Override
	public int countByEmployeeId(long employeeId) {
		FinderPath finderPath = _finderPathCountByEmployeeId;

		Object[] finderArgs = new Object[] {employeeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEVERIFICATION_WHERE);

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
		"employeeVerification.employeeId = ?";

	private FinderPath _finderPathWithPaginationFindByJoiningProcessId;
	private FinderPath _finderPathWithoutPaginationFindByJoiningProcessId;
	private FinderPath _finderPathCountByJoiningProcessId;

	/**
	 * Returns all the employee verifications where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @return the matching employee verifications
	 */
	@Override
	public List<EmployeeVerification> findByJoiningProcessId(
		long joiningProcessId) {

		return findByJoiningProcessId(
			joiningProcessId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee verifications where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeVerificationModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of employee verifications
	 * @param end the upper bound of the range of employee verifications (not inclusive)
	 * @return the range of matching employee verifications
	 */
	@Override
	public List<EmployeeVerification> findByJoiningProcessId(
		long joiningProcessId, int start, int end) {

		return findByJoiningProcessId(joiningProcessId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee verifications where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeVerificationModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of employee verifications
	 * @param end the upper bound of the range of employee verifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee verifications
	 */
	@Override
	public List<EmployeeVerification> findByJoiningProcessId(
		long joiningProcessId, int start, int end,
		OrderByComparator<EmployeeVerification> orderByComparator) {

		return findByJoiningProcessId(
			joiningProcessId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee verifications where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeVerificationModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of employee verifications
	 * @param end the upper bound of the range of employee verifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee verifications
	 */
	@Override
	public List<EmployeeVerification> findByJoiningProcessId(
		long joiningProcessId, int start, int end,
		OrderByComparator<EmployeeVerification> orderByComparator,
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

		List<EmployeeVerification> list = null;

		if (useFinderCache) {
			list = (List<EmployeeVerification>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeVerification employeeVerification : list) {
					if (joiningProcessId !=
							employeeVerification.getJoiningProcessId()) {

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

			sb.append(_SQL_SELECT_EMPLOYEEVERIFICATION_WHERE);

			sb.append(_FINDER_COLUMN_JOININGPROCESSID_JOININGPROCESSID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeVerificationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(joiningProcessId);

				list = (List<EmployeeVerification>)QueryUtil.list(
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
	 * Returns the first employee verification in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee verification
	 * @throws NoSuchEmployeeVerificationException if a matching employee verification could not be found
	 */
	@Override
	public EmployeeVerification findByJoiningProcessId_First(
			long joiningProcessId,
			OrderByComparator<EmployeeVerification> orderByComparator)
		throws NoSuchEmployeeVerificationException {

		EmployeeVerification employeeVerification =
			fetchByJoiningProcessId_First(joiningProcessId, orderByComparator);

		if (employeeVerification != null) {
			return employeeVerification;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("joiningProcessId=");
		sb.append(joiningProcessId);

		sb.append("}");

		throw new NoSuchEmployeeVerificationException(sb.toString());
	}

	/**
	 * Returns the first employee verification in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee verification, or <code>null</code> if a matching employee verification could not be found
	 */
	@Override
	public EmployeeVerification fetchByJoiningProcessId_First(
		long joiningProcessId,
		OrderByComparator<EmployeeVerification> orderByComparator) {

		List<EmployeeVerification> list = findByJoiningProcessId(
			joiningProcessId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee verification in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee verification
	 * @throws NoSuchEmployeeVerificationException if a matching employee verification could not be found
	 */
	@Override
	public EmployeeVerification findByJoiningProcessId_Last(
			long joiningProcessId,
			OrderByComparator<EmployeeVerification> orderByComparator)
		throws NoSuchEmployeeVerificationException {

		EmployeeVerification employeeVerification =
			fetchByJoiningProcessId_Last(joiningProcessId, orderByComparator);

		if (employeeVerification != null) {
			return employeeVerification;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("joiningProcessId=");
		sb.append(joiningProcessId);

		sb.append("}");

		throw new NoSuchEmployeeVerificationException(sb.toString());
	}

	/**
	 * Returns the last employee verification in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee verification, or <code>null</code> if a matching employee verification could not be found
	 */
	@Override
	public EmployeeVerification fetchByJoiningProcessId_Last(
		long joiningProcessId,
		OrderByComparator<EmployeeVerification> orderByComparator) {

		int count = countByJoiningProcessId(joiningProcessId);

		if (count == 0) {
			return null;
		}

		List<EmployeeVerification> list = findByJoiningProcessId(
			joiningProcessId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee verifications before and after the current employee verification in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param employeeVerificationId the primary key of the current employee verification
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee verification
	 * @throws NoSuchEmployeeVerificationException if a employee verification with the primary key could not be found
	 */
	@Override
	public EmployeeVerification[] findByJoiningProcessId_PrevAndNext(
			long employeeVerificationId, long joiningProcessId,
			OrderByComparator<EmployeeVerification> orderByComparator)
		throws NoSuchEmployeeVerificationException {

		EmployeeVerification employeeVerification = findByPrimaryKey(
			employeeVerificationId);

		Session session = null;

		try {
			session = openSession();

			EmployeeVerification[] array = new EmployeeVerificationImpl[3];

			array[0] = getByJoiningProcessId_PrevAndNext(
				session, employeeVerification, joiningProcessId,
				orderByComparator, true);

			array[1] = employeeVerification;

			array[2] = getByJoiningProcessId_PrevAndNext(
				session, employeeVerification, joiningProcessId,
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

	protected EmployeeVerification getByJoiningProcessId_PrevAndNext(
		Session session, EmployeeVerification employeeVerification,
		long joiningProcessId,
		OrderByComparator<EmployeeVerification> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEVERIFICATION_WHERE);

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
			sb.append(EmployeeVerificationModelImpl.ORDER_BY_JPQL);
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
						employeeVerification)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeVerification> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee verifications where joiningProcessId = &#63; from the database.
	 *
	 * @param joiningProcessId the joining process ID
	 */
	@Override
	public void removeByJoiningProcessId(long joiningProcessId) {
		for (EmployeeVerification employeeVerification :
				findByJoiningProcessId(
					joiningProcessId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(employeeVerification);
		}
	}

	/**
	 * Returns the number of employee verifications where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @return the number of matching employee verifications
	 */
	@Override
	public int countByJoiningProcessId(long joiningProcessId) {
		FinderPath finderPath = _finderPathCountByJoiningProcessId;

		Object[] finderArgs = new Object[] {joiningProcessId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEVERIFICATION_WHERE);

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
			"employeeVerification.joiningProcessId = ?";

	private FinderPath _finderPathWithPaginationFindByOrganizationId;
	private FinderPath _finderPathWithoutPaginationFindByOrganizationId;
	private FinderPath _finderPathCountByOrganizationId;

	/**
	 * Returns all the employee verifications where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching employee verifications
	 */
	@Override
	public List<EmployeeVerification> findByOrganizationId(
		long organizationId) {

		return findByOrganizationId(
			organizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee verifications where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeVerificationModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee verifications
	 * @param end the upper bound of the range of employee verifications (not inclusive)
	 * @return the range of matching employee verifications
	 */
	@Override
	public List<EmployeeVerification> findByOrganizationId(
		long organizationId, int start, int end) {

		return findByOrganizationId(organizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee verifications where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeVerificationModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee verifications
	 * @param end the upper bound of the range of employee verifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee verifications
	 */
	@Override
	public List<EmployeeVerification> findByOrganizationId(
		long organizationId, int start, int end,
		OrderByComparator<EmployeeVerification> orderByComparator) {

		return findByOrganizationId(
			organizationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee verifications where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeVerificationModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee verifications
	 * @param end the upper bound of the range of employee verifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee verifications
	 */
	@Override
	public List<EmployeeVerification> findByOrganizationId(
		long organizationId, int start, int end,
		OrderByComparator<EmployeeVerification> orderByComparator,
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

		List<EmployeeVerification> list = null;

		if (useFinderCache) {
			list = (List<EmployeeVerification>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeVerification employeeVerification : list) {
					if (organizationId !=
							employeeVerification.getOrganizationId()) {

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

			sb.append(_SQL_SELECT_EMPLOYEEVERIFICATION_WHERE);

			sb.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeVerificationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(organizationId);

				list = (List<EmployeeVerification>)QueryUtil.list(
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
	 * Returns the first employee verification in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee verification
	 * @throws NoSuchEmployeeVerificationException if a matching employee verification could not be found
	 */
	@Override
	public EmployeeVerification findByOrganizationId_First(
			long organizationId,
			OrderByComparator<EmployeeVerification> orderByComparator)
		throws NoSuchEmployeeVerificationException {

		EmployeeVerification employeeVerification = fetchByOrganizationId_First(
			organizationId, orderByComparator);

		if (employeeVerification != null) {
			return employeeVerification;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("organizationId=");
		sb.append(organizationId);

		sb.append("}");

		throw new NoSuchEmployeeVerificationException(sb.toString());
	}

	/**
	 * Returns the first employee verification in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee verification, or <code>null</code> if a matching employee verification could not be found
	 */
	@Override
	public EmployeeVerification fetchByOrganizationId_First(
		long organizationId,
		OrderByComparator<EmployeeVerification> orderByComparator) {

		List<EmployeeVerification> list = findByOrganizationId(
			organizationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee verification in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee verification
	 * @throws NoSuchEmployeeVerificationException if a matching employee verification could not be found
	 */
	@Override
	public EmployeeVerification findByOrganizationId_Last(
			long organizationId,
			OrderByComparator<EmployeeVerification> orderByComparator)
		throws NoSuchEmployeeVerificationException {

		EmployeeVerification employeeVerification = fetchByOrganizationId_Last(
			organizationId, orderByComparator);

		if (employeeVerification != null) {
			return employeeVerification;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("organizationId=");
		sb.append(organizationId);

		sb.append("}");

		throw new NoSuchEmployeeVerificationException(sb.toString());
	}

	/**
	 * Returns the last employee verification in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee verification, or <code>null</code> if a matching employee verification could not be found
	 */
	@Override
	public EmployeeVerification fetchByOrganizationId_Last(
		long organizationId,
		OrderByComparator<EmployeeVerification> orderByComparator) {

		int count = countByOrganizationId(organizationId);

		if (count == 0) {
			return null;
		}

		List<EmployeeVerification> list = findByOrganizationId(
			organizationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee verifications before and after the current employee verification in the ordered set where organizationId = &#63;.
	 *
	 * @param employeeVerificationId the primary key of the current employee verification
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee verification
	 * @throws NoSuchEmployeeVerificationException if a employee verification with the primary key could not be found
	 */
	@Override
	public EmployeeVerification[] findByOrganizationId_PrevAndNext(
			long employeeVerificationId, long organizationId,
			OrderByComparator<EmployeeVerification> orderByComparator)
		throws NoSuchEmployeeVerificationException {

		EmployeeVerification employeeVerification = findByPrimaryKey(
			employeeVerificationId);

		Session session = null;

		try {
			session = openSession();

			EmployeeVerification[] array = new EmployeeVerificationImpl[3];

			array[0] = getByOrganizationId_PrevAndNext(
				session, employeeVerification, organizationId,
				orderByComparator, true);

			array[1] = employeeVerification;

			array[2] = getByOrganizationId_PrevAndNext(
				session, employeeVerification, organizationId,
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

	protected EmployeeVerification getByOrganizationId_PrevAndNext(
		Session session, EmployeeVerification employeeVerification,
		long organizationId,
		OrderByComparator<EmployeeVerification> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEVERIFICATION_WHERE);

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
			sb.append(EmployeeVerificationModelImpl.ORDER_BY_JPQL);
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
						employeeVerification)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeVerification> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee verifications where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	@Override
	public void removeByOrganizationId(long organizationId) {
		for (EmployeeVerification employeeVerification :
				findByOrganizationId(
					organizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(employeeVerification);
		}
	}

	/**
	 * Returns the number of employee verifications where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching employee verifications
	 */
	@Override
	public int countByOrganizationId(long organizationId) {
		FinderPath finderPath = _finderPathCountByOrganizationId;

		Object[] finderArgs = new Object[] {organizationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEVERIFICATION_WHERE);

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
		"employeeVerification.organizationId = ?";

	public EmployeeVerificationPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(EmployeeVerification.class);

		setModelImplClass(EmployeeVerificationImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the employee verification in the entity cache if it is enabled.
	 *
	 * @param employeeVerification the employee verification
	 */
	@Override
	public void cacheResult(EmployeeVerification employeeVerification) {
		entityCache.putResult(
			EmployeeVerificationImpl.class,
			employeeVerification.getPrimaryKey(), employeeVerification);
	}

	/**
	 * Caches the employee verifications in the entity cache if it is enabled.
	 *
	 * @param employeeVerifications the employee verifications
	 */
	@Override
	public void cacheResult(List<EmployeeVerification> employeeVerifications) {
		for (EmployeeVerification employeeVerification :
				employeeVerifications) {

			if (entityCache.getResult(
					EmployeeVerificationImpl.class,
					employeeVerification.getPrimaryKey()) == null) {

				cacheResult(employeeVerification);
			}
		}
	}

	/**
	 * Clears the cache for all employee verifications.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmployeeVerificationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the employee verification.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmployeeVerification employeeVerification) {
		entityCache.removeResult(
			EmployeeVerificationImpl.class, employeeVerification);
	}

	@Override
	public void clearCache(List<EmployeeVerification> employeeVerifications) {
		for (EmployeeVerification employeeVerification :
				employeeVerifications) {

			entityCache.removeResult(
				EmployeeVerificationImpl.class, employeeVerification);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				EmployeeVerificationImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new employee verification with the primary key. Does not add the employee verification to the database.
	 *
	 * @param employeeVerificationId the primary key for the new employee verification
	 * @return the new employee verification
	 */
	@Override
	public EmployeeVerification create(long employeeVerificationId) {
		EmployeeVerification employeeVerification =
			new EmployeeVerificationImpl();

		employeeVerification.setNew(true);
		employeeVerification.setPrimaryKey(employeeVerificationId);

		employeeVerification.setCompanyId(CompanyThreadLocal.getCompanyId());

		return employeeVerification;
	}

	/**
	 * Removes the employee verification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeVerificationId the primary key of the employee verification
	 * @return the employee verification that was removed
	 * @throws NoSuchEmployeeVerificationException if a employee verification with the primary key could not be found
	 */
	@Override
	public EmployeeVerification remove(long employeeVerificationId)
		throws NoSuchEmployeeVerificationException {

		return remove((Serializable)employeeVerificationId);
	}

	/**
	 * Removes the employee verification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the employee verification
	 * @return the employee verification that was removed
	 * @throws NoSuchEmployeeVerificationException if a employee verification with the primary key could not be found
	 */
	@Override
	public EmployeeVerification remove(Serializable primaryKey)
		throws NoSuchEmployeeVerificationException {

		Session session = null;

		try {
			session = openSession();

			EmployeeVerification employeeVerification =
				(EmployeeVerification)session.get(
					EmployeeVerificationImpl.class, primaryKey);

			if (employeeVerification == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmployeeVerificationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(employeeVerification);
		}
		catch (NoSuchEmployeeVerificationException noSuchEntityException) {
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
	protected EmployeeVerification removeImpl(
		EmployeeVerification employeeVerification) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(employeeVerification)) {
				employeeVerification = (EmployeeVerification)session.get(
					EmployeeVerificationImpl.class,
					employeeVerification.getPrimaryKeyObj());
			}

			if (employeeVerification != null) {
				session.delete(employeeVerification);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (employeeVerification != null) {
			clearCache(employeeVerification);
		}

		return employeeVerification;
	}

	@Override
	public EmployeeVerification updateImpl(
		EmployeeVerification employeeVerification) {

		boolean isNew = employeeVerification.isNew();

		if (!(employeeVerification instanceof EmployeeVerificationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(employeeVerification.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					employeeVerification);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in employeeVerification proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EmployeeVerification implementation " +
					employeeVerification.getClass());
		}

		EmployeeVerificationModelImpl employeeVerificationModelImpl =
			(EmployeeVerificationModelImpl)employeeVerification;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (employeeVerification.getCreateDate() == null)) {
			if (serviceContext == null) {
				employeeVerification.setCreateDate(now);
			}
			else {
				employeeVerification.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!employeeVerificationModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				employeeVerification.setModifiedDate(now);
			}
			else {
				employeeVerification.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(employeeVerification);
			}
			else {
				employeeVerification = (EmployeeVerification)session.merge(
					employeeVerification);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EmployeeVerificationImpl.class, employeeVerificationModelImpl,
			false, true);

		if (isNew) {
			employeeVerification.setNew(false);
		}

		employeeVerification.resetOriginalValues();

		return employeeVerification;
	}

	/**
	 * Returns the employee verification with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee verification
	 * @return the employee verification
	 * @throws NoSuchEmployeeVerificationException if a employee verification with the primary key could not be found
	 */
	@Override
	public EmployeeVerification findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmployeeVerificationException {

		EmployeeVerification employeeVerification = fetchByPrimaryKey(
			primaryKey);

		if (employeeVerification == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmployeeVerificationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return employeeVerification;
	}

	/**
	 * Returns the employee verification with the primary key or throws a <code>NoSuchEmployeeVerificationException</code> if it could not be found.
	 *
	 * @param employeeVerificationId the primary key of the employee verification
	 * @return the employee verification
	 * @throws NoSuchEmployeeVerificationException if a employee verification with the primary key could not be found
	 */
	@Override
	public EmployeeVerification findByPrimaryKey(long employeeVerificationId)
		throws NoSuchEmployeeVerificationException {

		return findByPrimaryKey((Serializable)employeeVerificationId);
	}

	/**
	 * Returns the employee verification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeVerificationId the primary key of the employee verification
	 * @return the employee verification, or <code>null</code> if a employee verification with the primary key could not be found
	 */
	@Override
	public EmployeeVerification fetchByPrimaryKey(long employeeVerificationId) {
		return fetchByPrimaryKey((Serializable)employeeVerificationId);
	}

	/**
	 * Returns all the employee verifications.
	 *
	 * @return the employee verifications
	 */
	@Override
	public List<EmployeeVerification> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee verifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeVerificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee verifications
	 * @param end the upper bound of the range of employee verifications (not inclusive)
	 * @return the range of employee verifications
	 */
	@Override
	public List<EmployeeVerification> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee verifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeVerificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee verifications
	 * @param end the upper bound of the range of employee verifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee verifications
	 */
	@Override
	public List<EmployeeVerification> findAll(
		int start, int end,
		OrderByComparator<EmployeeVerification> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee verifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeVerificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee verifications
	 * @param end the upper bound of the range of employee verifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee verifications
	 */
	@Override
	public List<EmployeeVerification> findAll(
		int start, int end,
		OrderByComparator<EmployeeVerification> orderByComparator,
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

		List<EmployeeVerification> list = null;

		if (useFinderCache) {
			list = (List<EmployeeVerification>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EMPLOYEEVERIFICATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLOYEEVERIFICATION;

				sql = sql.concat(EmployeeVerificationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EmployeeVerification>)QueryUtil.list(
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
	 * Removes all the employee verifications from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EmployeeVerification employeeVerification : findAll()) {
			remove(employeeVerification);
		}
	}

	/**
	 * Returns the number of employee verifications.
	 *
	 * @return the number of employee verifications
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
					_SQL_COUNT_EMPLOYEEVERIFICATION);

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
		return "employeeVerificationId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EMPLOYEEVERIFICATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EmployeeVerificationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the employee verification persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new EmployeeVerificationModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", EmployeeVerification.class.getName()));

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
		entityCache.removeCache(EmployeeVerificationImpl.class.getName());

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

	private static final String _SQL_SELECT_EMPLOYEEVERIFICATION =
		"SELECT employeeVerification FROM EmployeeVerification employeeVerification";

	private static final String _SQL_SELECT_EMPLOYEEVERIFICATION_WHERE =
		"SELECT employeeVerification FROM EmployeeVerification employeeVerification WHERE ";

	private static final String _SQL_COUNT_EMPLOYEEVERIFICATION =
		"SELECT COUNT(employeeVerification) FROM EmployeeVerification employeeVerification";

	private static final String _SQL_COUNT_EMPLOYEEVERIFICATION_WHERE =
		"SELECT COUNT(employeeVerification) FROM EmployeeVerification employeeVerification WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"employeeVerification.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EmployeeVerification exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EmployeeVerification exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EmployeeVerificationPersistenceImpl.class);

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

	private static class EmployeeVerificationModelArgumentsResolver
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

			EmployeeVerificationModelImpl employeeVerificationModelImpl =
				(EmployeeVerificationModelImpl)baseModel;

			long columnBitmask =
				employeeVerificationModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					employeeVerificationModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						employeeVerificationModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					employeeVerificationModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			EmployeeVerificationModelImpl employeeVerificationModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						employeeVerificationModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = employeeVerificationModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}