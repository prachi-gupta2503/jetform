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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeDscException;
import com.adjecti.pis.liferay.model.EmployeeDsc;
import com.adjecti.pis.liferay.model.impl.EmployeeDscImpl;
import com.adjecti.pis.liferay.model.impl.EmployeeDscModelImpl;
import com.adjecti.pis.liferay.service.persistence.EmployeeDscPersistence;
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
 * The persistence implementation for the employee dsc service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EmployeeDscPersistence.class)
public class EmployeeDscPersistenceImpl
	extends BasePersistenceImpl<EmployeeDsc> implements EmployeeDscPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EmployeeDscUtil</code> to access the employee dsc persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EmployeeDscImpl.class.getName();

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
	 * Returns all the employee dscs where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee dscs
	 */
	@Override
	public List<EmployeeDsc> findByEmployeeId(long employeeId) {
		return findByEmployeeId(
			employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee dscs where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDscModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee dscs
	 * @param end the upper bound of the range of employee dscs (not inclusive)
	 * @return the range of matching employee dscs
	 */
	@Override
	public List<EmployeeDsc> findByEmployeeId(
		long employeeId, int start, int end) {

		return findByEmployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee dscs where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDscModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee dscs
	 * @param end the upper bound of the range of employee dscs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee dscs
	 */
	@Override
	public List<EmployeeDsc> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeDsc> orderByComparator) {

		return findByEmployeeId(
			employeeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee dscs where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDscModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee dscs
	 * @param end the upper bound of the range of employee dscs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee dscs
	 */
	@Override
	public List<EmployeeDsc> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeDsc> orderByComparator,
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

		List<EmployeeDsc> list = null;

		if (useFinderCache) {
			list = (List<EmployeeDsc>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeDsc employeeDsc : list) {
					if (employeeId != employeeDsc.getEmployeeId()) {
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

			sb.append(_SQL_SELECT_EMPLOYEEDSC_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeDscModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				list = (List<EmployeeDsc>)QueryUtil.list(
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
	 * Returns the first employee dsc in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee dsc
	 * @throws NoSuchEmployeeDscException if a matching employee dsc could not be found
	 */
	@Override
	public EmployeeDsc findByEmployeeId_First(
			long employeeId, OrderByComparator<EmployeeDsc> orderByComparator)
		throws NoSuchEmployeeDscException {

		EmployeeDsc employeeDsc = fetchByEmployeeId_First(
			employeeId, orderByComparator);

		if (employeeDsc != null) {
			return employeeDsc;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeeDscException(sb.toString());
	}

	/**
	 * Returns the first employee dsc in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee dsc, or <code>null</code> if a matching employee dsc could not be found
	 */
	@Override
	public EmployeeDsc fetchByEmployeeId_First(
		long employeeId, OrderByComparator<EmployeeDsc> orderByComparator) {

		List<EmployeeDsc> list = findByEmployeeId(
			employeeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee dsc in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee dsc
	 * @throws NoSuchEmployeeDscException if a matching employee dsc could not be found
	 */
	@Override
	public EmployeeDsc findByEmployeeId_Last(
			long employeeId, OrderByComparator<EmployeeDsc> orderByComparator)
		throws NoSuchEmployeeDscException {

		EmployeeDsc employeeDsc = fetchByEmployeeId_Last(
			employeeId, orderByComparator);

		if (employeeDsc != null) {
			return employeeDsc;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeeDscException(sb.toString());
	}

	/**
	 * Returns the last employee dsc in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee dsc, or <code>null</code> if a matching employee dsc could not be found
	 */
	@Override
	public EmployeeDsc fetchByEmployeeId_Last(
		long employeeId, OrderByComparator<EmployeeDsc> orderByComparator) {

		int count = countByEmployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<EmployeeDsc> list = findByEmployeeId(
			employeeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee dscs before and after the current employee dsc in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeDscId the primary key of the current employee dsc
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee dsc
	 * @throws NoSuchEmployeeDscException if a employee dsc with the primary key could not be found
	 */
	@Override
	public EmployeeDsc[] findByEmployeeId_PrevAndNext(
			long employeeDscId, long employeeId,
			OrderByComparator<EmployeeDsc> orderByComparator)
		throws NoSuchEmployeeDscException {

		EmployeeDsc employeeDsc = findByPrimaryKey(employeeDscId);

		Session session = null;

		try {
			session = openSession();

			EmployeeDsc[] array = new EmployeeDscImpl[3];

			array[0] = getByEmployeeId_PrevAndNext(
				session, employeeDsc, employeeId, orderByComparator, true);

			array[1] = employeeDsc;

			array[2] = getByEmployeeId_PrevAndNext(
				session, employeeDsc, employeeId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EmployeeDsc getByEmployeeId_PrevAndNext(
		Session session, EmployeeDsc employeeDsc, long employeeId,
		OrderByComparator<EmployeeDsc> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_EMPLOYEEDSC_WHERE);

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
			sb.append(EmployeeDscModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(employeeId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(employeeDsc)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeDsc> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee dscs where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeByEmployeeId(long employeeId) {
		for (EmployeeDsc employeeDsc :
				findByEmployeeId(
					employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeeDsc);
		}
	}

	/**
	 * Returns the number of employee dscs where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee dscs
	 */
	@Override
	public int countByEmployeeId(long employeeId) {
		FinderPath finderPath = _finderPathCountByEmployeeId;

		Object[] finderArgs = new Object[] {employeeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEDSC_WHERE);

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
		"employeeDsc.employeeId = ?";

	private FinderPath _finderPathWithPaginationFindByCid;
	private FinderPath _finderPathWithoutPaginationFindByCid;
	private FinderPath _finderPathCountByCid;

	/**
	 * Returns all the employee dscs where cid = &#63;.
	 *
	 * @param cid the cid
	 * @return the matching employee dscs
	 */
	@Override
	public List<EmployeeDsc> findByCid(String cid) {
		return findByCid(cid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee dscs where cid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDscModelImpl</code>.
	 * </p>
	 *
	 * @param cid the cid
	 * @param start the lower bound of the range of employee dscs
	 * @param end the upper bound of the range of employee dscs (not inclusive)
	 * @return the range of matching employee dscs
	 */
	@Override
	public List<EmployeeDsc> findByCid(String cid, int start, int end) {
		return findByCid(cid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee dscs where cid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDscModelImpl</code>.
	 * </p>
	 *
	 * @param cid the cid
	 * @param start the lower bound of the range of employee dscs
	 * @param end the upper bound of the range of employee dscs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee dscs
	 */
	@Override
	public List<EmployeeDsc> findByCid(
		String cid, int start, int end,
		OrderByComparator<EmployeeDsc> orderByComparator) {

		return findByCid(cid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee dscs where cid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDscModelImpl</code>.
	 * </p>
	 *
	 * @param cid the cid
	 * @param start the lower bound of the range of employee dscs
	 * @param end the upper bound of the range of employee dscs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee dscs
	 */
	@Override
	public List<EmployeeDsc> findByCid(
		String cid, int start, int end,
		OrderByComparator<EmployeeDsc> orderByComparator,
		boolean useFinderCache) {

		cid = Objects.toString(cid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCid;
				finderArgs = new Object[] {cid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCid;
			finderArgs = new Object[] {cid, start, end, orderByComparator};
		}

		List<EmployeeDsc> list = null;

		if (useFinderCache) {
			list = (List<EmployeeDsc>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeDsc employeeDsc : list) {
					if (!cid.equals(employeeDsc.getCid())) {
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

			sb.append(_SQL_SELECT_EMPLOYEEDSC_WHERE);

			boolean bindCid = false;

			if (cid.isEmpty()) {
				sb.append(_FINDER_COLUMN_CID_CID_3);
			}
			else {
				bindCid = true;

				sb.append(_FINDER_COLUMN_CID_CID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeDscModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCid) {
					queryPos.add(cid);
				}

				list = (List<EmployeeDsc>)QueryUtil.list(
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
	 * Returns the first employee dsc in the ordered set where cid = &#63;.
	 *
	 * @param cid the cid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee dsc
	 * @throws NoSuchEmployeeDscException if a matching employee dsc could not be found
	 */
	@Override
	public EmployeeDsc findByCid_First(
			String cid, OrderByComparator<EmployeeDsc> orderByComparator)
		throws NoSuchEmployeeDscException {

		EmployeeDsc employeeDsc = fetchByCid_First(cid, orderByComparator);

		if (employeeDsc != null) {
			return employeeDsc;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("cid=");
		sb.append(cid);

		sb.append("}");

		throw new NoSuchEmployeeDscException(sb.toString());
	}

	/**
	 * Returns the first employee dsc in the ordered set where cid = &#63;.
	 *
	 * @param cid the cid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee dsc, or <code>null</code> if a matching employee dsc could not be found
	 */
	@Override
	public EmployeeDsc fetchByCid_First(
		String cid, OrderByComparator<EmployeeDsc> orderByComparator) {

		List<EmployeeDsc> list = findByCid(cid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee dsc in the ordered set where cid = &#63;.
	 *
	 * @param cid the cid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee dsc
	 * @throws NoSuchEmployeeDscException if a matching employee dsc could not be found
	 */
	@Override
	public EmployeeDsc findByCid_Last(
			String cid, OrderByComparator<EmployeeDsc> orderByComparator)
		throws NoSuchEmployeeDscException {

		EmployeeDsc employeeDsc = fetchByCid_Last(cid, orderByComparator);

		if (employeeDsc != null) {
			return employeeDsc;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("cid=");
		sb.append(cid);

		sb.append("}");

		throw new NoSuchEmployeeDscException(sb.toString());
	}

	/**
	 * Returns the last employee dsc in the ordered set where cid = &#63;.
	 *
	 * @param cid the cid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee dsc, or <code>null</code> if a matching employee dsc could not be found
	 */
	@Override
	public EmployeeDsc fetchByCid_Last(
		String cid, OrderByComparator<EmployeeDsc> orderByComparator) {

		int count = countByCid(cid);

		if (count == 0) {
			return null;
		}

		List<EmployeeDsc> list = findByCid(
			cid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee dscs before and after the current employee dsc in the ordered set where cid = &#63;.
	 *
	 * @param employeeDscId the primary key of the current employee dsc
	 * @param cid the cid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee dsc
	 * @throws NoSuchEmployeeDscException if a employee dsc with the primary key could not be found
	 */
	@Override
	public EmployeeDsc[] findByCid_PrevAndNext(
			long employeeDscId, String cid,
			OrderByComparator<EmployeeDsc> orderByComparator)
		throws NoSuchEmployeeDscException {

		cid = Objects.toString(cid, "");

		EmployeeDsc employeeDsc = findByPrimaryKey(employeeDscId);

		Session session = null;

		try {
			session = openSession();

			EmployeeDsc[] array = new EmployeeDscImpl[3];

			array[0] = getByCid_PrevAndNext(
				session, employeeDsc, cid, orderByComparator, true);

			array[1] = employeeDsc;

			array[2] = getByCid_PrevAndNext(
				session, employeeDsc, cid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EmployeeDsc getByCid_PrevAndNext(
		Session session, EmployeeDsc employeeDsc, String cid,
		OrderByComparator<EmployeeDsc> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_EMPLOYEEDSC_WHERE);

		boolean bindCid = false;

		if (cid.isEmpty()) {
			sb.append(_FINDER_COLUMN_CID_CID_3);
		}
		else {
			bindCid = true;

			sb.append(_FINDER_COLUMN_CID_CID_2);
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
			sb.append(EmployeeDscModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindCid) {
			queryPos.add(cid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(employeeDsc)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeDsc> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee dscs where cid = &#63; from the database.
	 *
	 * @param cid the cid
	 */
	@Override
	public void removeByCid(String cid) {
		for (EmployeeDsc employeeDsc :
				findByCid(cid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeeDsc);
		}
	}

	/**
	 * Returns the number of employee dscs where cid = &#63;.
	 *
	 * @param cid the cid
	 * @return the number of matching employee dscs
	 */
	@Override
	public int countByCid(String cid) {
		cid = Objects.toString(cid, "");

		FinderPath finderPath = _finderPathCountByCid;

		Object[] finderArgs = new Object[] {cid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEDSC_WHERE);

			boolean bindCid = false;

			if (cid.isEmpty()) {
				sb.append(_FINDER_COLUMN_CID_CID_3);
			}
			else {
				bindCid = true;

				sb.append(_FINDER_COLUMN_CID_CID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCid) {
					queryPos.add(cid);
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

	private static final String _FINDER_COLUMN_CID_CID_2 =
		"employeeDsc.cid = ?";

	private static final String _FINDER_COLUMN_CID_CID_3 =
		"(employeeDsc.cid IS NULL OR employeeDsc.cid = '')";

	public EmployeeDscPersistenceImpl() {
		setModelClass(EmployeeDsc.class);

		setModelImplClass(EmployeeDscImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the employee dsc in the entity cache if it is enabled.
	 *
	 * @param employeeDsc the employee dsc
	 */
	@Override
	public void cacheResult(EmployeeDsc employeeDsc) {
		entityCache.putResult(
			EmployeeDscImpl.class, employeeDsc.getPrimaryKey(), employeeDsc);
	}

	/**
	 * Caches the employee dscs in the entity cache if it is enabled.
	 *
	 * @param employeeDscs the employee dscs
	 */
	@Override
	public void cacheResult(List<EmployeeDsc> employeeDscs) {
		for (EmployeeDsc employeeDsc : employeeDscs) {
			if (entityCache.getResult(
					EmployeeDscImpl.class, employeeDsc.getPrimaryKey()) ==
						null) {

				cacheResult(employeeDsc);
			}
		}
	}

	/**
	 * Clears the cache for all employee dscs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmployeeDscImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the employee dsc.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmployeeDsc employeeDsc) {
		entityCache.removeResult(EmployeeDscImpl.class, employeeDsc);
	}

	@Override
	public void clearCache(List<EmployeeDsc> employeeDscs) {
		for (EmployeeDsc employeeDsc : employeeDscs) {
			entityCache.removeResult(EmployeeDscImpl.class, employeeDsc);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EmployeeDscImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new employee dsc with the primary key. Does not add the employee dsc to the database.
	 *
	 * @param employeeDscId the primary key for the new employee dsc
	 * @return the new employee dsc
	 */
	@Override
	public EmployeeDsc create(long employeeDscId) {
		EmployeeDsc employeeDsc = new EmployeeDscImpl();

		employeeDsc.setNew(true);
		employeeDsc.setPrimaryKey(employeeDscId);

		employeeDsc.setCompanyId(CompanyThreadLocal.getCompanyId());

		return employeeDsc;
	}

	/**
	 * Removes the employee dsc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeDscId the primary key of the employee dsc
	 * @return the employee dsc that was removed
	 * @throws NoSuchEmployeeDscException if a employee dsc with the primary key could not be found
	 */
	@Override
	public EmployeeDsc remove(long employeeDscId)
		throws NoSuchEmployeeDscException {

		return remove((Serializable)employeeDscId);
	}

	/**
	 * Removes the employee dsc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the employee dsc
	 * @return the employee dsc that was removed
	 * @throws NoSuchEmployeeDscException if a employee dsc with the primary key could not be found
	 */
	@Override
	public EmployeeDsc remove(Serializable primaryKey)
		throws NoSuchEmployeeDscException {

		Session session = null;

		try {
			session = openSession();

			EmployeeDsc employeeDsc = (EmployeeDsc)session.get(
				EmployeeDscImpl.class, primaryKey);

			if (employeeDsc == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmployeeDscException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(employeeDsc);
		}
		catch (NoSuchEmployeeDscException noSuchEntityException) {
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
	protected EmployeeDsc removeImpl(EmployeeDsc employeeDsc) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(employeeDsc)) {
				employeeDsc = (EmployeeDsc)session.get(
					EmployeeDscImpl.class, employeeDsc.getPrimaryKeyObj());
			}

			if (employeeDsc != null) {
				session.delete(employeeDsc);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (employeeDsc != null) {
			clearCache(employeeDsc);
		}

		return employeeDsc;
	}

	@Override
	public EmployeeDsc updateImpl(EmployeeDsc employeeDsc) {
		boolean isNew = employeeDsc.isNew();

		if (!(employeeDsc instanceof EmployeeDscModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(employeeDsc.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(employeeDsc);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in employeeDsc proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EmployeeDsc implementation " +
					employeeDsc.getClass());
		}

		EmployeeDscModelImpl employeeDscModelImpl =
			(EmployeeDscModelImpl)employeeDsc;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (employeeDsc.getCreateDate() == null)) {
			if (serviceContext == null) {
				employeeDsc.setCreateDate(now);
			}
			else {
				employeeDsc.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!employeeDscModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				employeeDsc.setModifiedDate(now);
			}
			else {
				employeeDsc.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(employeeDsc);
			}
			else {
				employeeDsc = (EmployeeDsc)session.merge(employeeDsc);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EmployeeDscImpl.class, employeeDscModelImpl, false, true);

		if (isNew) {
			employeeDsc.setNew(false);
		}

		employeeDsc.resetOriginalValues();

		return employeeDsc;
	}

	/**
	 * Returns the employee dsc with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee dsc
	 * @return the employee dsc
	 * @throws NoSuchEmployeeDscException if a employee dsc with the primary key could not be found
	 */
	@Override
	public EmployeeDsc findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmployeeDscException {

		EmployeeDsc employeeDsc = fetchByPrimaryKey(primaryKey);

		if (employeeDsc == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmployeeDscException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return employeeDsc;
	}

	/**
	 * Returns the employee dsc with the primary key or throws a <code>NoSuchEmployeeDscException</code> if it could not be found.
	 *
	 * @param employeeDscId the primary key of the employee dsc
	 * @return the employee dsc
	 * @throws NoSuchEmployeeDscException if a employee dsc with the primary key could not be found
	 */
	@Override
	public EmployeeDsc findByPrimaryKey(long employeeDscId)
		throws NoSuchEmployeeDscException {

		return findByPrimaryKey((Serializable)employeeDscId);
	}

	/**
	 * Returns the employee dsc with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeDscId the primary key of the employee dsc
	 * @return the employee dsc, or <code>null</code> if a employee dsc with the primary key could not be found
	 */
	@Override
	public EmployeeDsc fetchByPrimaryKey(long employeeDscId) {
		return fetchByPrimaryKey((Serializable)employeeDscId);
	}

	/**
	 * Returns all the employee dscs.
	 *
	 * @return the employee dscs
	 */
	@Override
	public List<EmployeeDsc> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee dscs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDscModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee dscs
	 * @param end the upper bound of the range of employee dscs (not inclusive)
	 * @return the range of employee dscs
	 */
	@Override
	public List<EmployeeDsc> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee dscs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDscModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee dscs
	 * @param end the upper bound of the range of employee dscs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee dscs
	 */
	@Override
	public List<EmployeeDsc> findAll(
		int start, int end, OrderByComparator<EmployeeDsc> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee dscs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDscModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee dscs
	 * @param end the upper bound of the range of employee dscs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee dscs
	 */
	@Override
	public List<EmployeeDsc> findAll(
		int start, int end, OrderByComparator<EmployeeDsc> orderByComparator,
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

		List<EmployeeDsc> list = null;

		if (useFinderCache) {
			list = (List<EmployeeDsc>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EMPLOYEEDSC);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLOYEEDSC;

				sql = sql.concat(EmployeeDscModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EmployeeDsc>)QueryUtil.list(
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
	 * Removes all the employee dscs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EmployeeDsc employeeDsc : findAll()) {
			remove(employeeDsc);
		}
	}

	/**
	 * Returns the number of employee dscs.
	 *
	 * @return the number of employee dscs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_EMPLOYEEDSC);

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
		return "employeeDscId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EMPLOYEEDSC;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EmployeeDscModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the employee dsc persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new EmployeeDscModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", EmployeeDsc.class.getName()));

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

		_finderPathWithPaginationFindByCid = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"cid"}, true);

		_finderPathWithoutPaginationFindByCid = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCid",
			new String[] {String.class.getName()}, new String[] {"cid"}, true);

		_finderPathCountByCid = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCid",
			new String[] {String.class.getName()}, new String[] {"cid"}, false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(EmployeeDscImpl.class.getName());

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

	private static final String _SQL_SELECT_EMPLOYEEDSC =
		"SELECT employeeDsc FROM EmployeeDsc employeeDsc";

	private static final String _SQL_SELECT_EMPLOYEEDSC_WHERE =
		"SELECT employeeDsc FROM EmployeeDsc employeeDsc WHERE ";

	private static final String _SQL_COUNT_EMPLOYEEDSC =
		"SELECT COUNT(employeeDsc) FROM EmployeeDsc employeeDsc";

	private static final String _SQL_COUNT_EMPLOYEEDSC_WHERE =
		"SELECT COUNT(employeeDsc) FROM EmployeeDsc employeeDsc WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "employeeDsc.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EmployeeDsc exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EmployeeDsc exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EmployeeDscPersistenceImpl.class);

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

	private static class EmployeeDscModelArgumentsResolver
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

			EmployeeDscModelImpl employeeDscModelImpl =
				(EmployeeDscModelImpl)baseModel;

			long columnBitmask = employeeDscModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(employeeDscModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						employeeDscModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(employeeDscModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			EmployeeDscModelImpl employeeDscModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = employeeDscModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = employeeDscModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}