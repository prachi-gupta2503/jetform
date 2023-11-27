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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeAddressException;
import com.adjecti.pis.liferay.model.EmployeeAddress;
import com.adjecti.pis.liferay.model.impl.EmployeeAddressImpl;
import com.adjecti.pis.liferay.model.impl.EmployeeAddressModelImpl;
import com.adjecti.pis.liferay.service.persistence.EmployeeAddressPersistence;
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
 * The persistence implementation for the employee address service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EmployeeAddressPersistence.class)
public class EmployeeAddressPersistenceImpl
	extends BasePersistenceImpl<EmployeeAddress>
	implements EmployeeAddressPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EmployeeAddressUtil</code> to access the employee address persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EmployeeAddressImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByDistrictId;
	private FinderPath _finderPathWithoutPaginationFindByDistrictId;
	private FinderPath _finderPathCountByDistrictId;

	/**
	 * Returns all the employee addresses where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @return the matching employee addresses
	 */
	@Override
	public List<EmployeeAddress> findByDistrictId(long districtId) {
		return findByDistrictId(
			districtId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee addresses where districtId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeAddressModelImpl</code>.
	 * </p>
	 *
	 * @param districtId the district ID
	 * @param start the lower bound of the range of employee addresses
	 * @param end the upper bound of the range of employee addresses (not inclusive)
	 * @return the range of matching employee addresses
	 */
	@Override
	public List<EmployeeAddress> findByDistrictId(
		long districtId, int start, int end) {

		return findByDistrictId(districtId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee addresses where districtId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeAddressModelImpl</code>.
	 * </p>
	 *
	 * @param districtId the district ID
	 * @param start the lower bound of the range of employee addresses
	 * @param end the upper bound of the range of employee addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee addresses
	 */
	@Override
	public List<EmployeeAddress> findByDistrictId(
		long districtId, int start, int end,
		OrderByComparator<EmployeeAddress> orderByComparator) {

		return findByDistrictId(
			districtId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee addresses where districtId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeAddressModelImpl</code>.
	 * </p>
	 *
	 * @param districtId the district ID
	 * @param start the lower bound of the range of employee addresses
	 * @param end the upper bound of the range of employee addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee addresses
	 */
	@Override
	public List<EmployeeAddress> findByDistrictId(
		long districtId, int start, int end,
		OrderByComparator<EmployeeAddress> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDistrictId;
				finderArgs = new Object[] {districtId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDistrictId;
			finderArgs = new Object[] {
				districtId, start, end, orderByComparator
			};
		}

		List<EmployeeAddress> list = null;

		if (useFinderCache) {
			list = (List<EmployeeAddress>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeAddress employeeAddress : list) {
					if (districtId != employeeAddress.getDistrictId()) {
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

			sb.append(_SQL_SELECT_EMPLOYEEADDRESS_WHERE);

			sb.append(_FINDER_COLUMN_DISTRICTID_DISTRICTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeAddressModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(districtId);

				list = (List<EmployeeAddress>)QueryUtil.list(
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
	 * Returns the first employee address in the ordered set where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee address
	 * @throws NoSuchEmployeeAddressException if a matching employee address could not be found
	 */
	@Override
	public EmployeeAddress findByDistrictId_First(
			long districtId,
			OrderByComparator<EmployeeAddress> orderByComparator)
		throws NoSuchEmployeeAddressException {

		EmployeeAddress employeeAddress = fetchByDistrictId_First(
			districtId, orderByComparator);

		if (employeeAddress != null) {
			return employeeAddress;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("districtId=");
		sb.append(districtId);

		sb.append("}");

		throw new NoSuchEmployeeAddressException(sb.toString());
	}

	/**
	 * Returns the first employee address in the ordered set where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee address, or <code>null</code> if a matching employee address could not be found
	 */
	@Override
	public EmployeeAddress fetchByDistrictId_First(
		long districtId, OrderByComparator<EmployeeAddress> orderByComparator) {

		List<EmployeeAddress> list = findByDistrictId(
			districtId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee address in the ordered set where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee address
	 * @throws NoSuchEmployeeAddressException if a matching employee address could not be found
	 */
	@Override
	public EmployeeAddress findByDistrictId_Last(
			long districtId,
			OrderByComparator<EmployeeAddress> orderByComparator)
		throws NoSuchEmployeeAddressException {

		EmployeeAddress employeeAddress = fetchByDistrictId_Last(
			districtId, orderByComparator);

		if (employeeAddress != null) {
			return employeeAddress;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("districtId=");
		sb.append(districtId);

		sb.append("}");

		throw new NoSuchEmployeeAddressException(sb.toString());
	}

	/**
	 * Returns the last employee address in the ordered set where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee address, or <code>null</code> if a matching employee address could not be found
	 */
	@Override
	public EmployeeAddress fetchByDistrictId_Last(
		long districtId, OrderByComparator<EmployeeAddress> orderByComparator) {

		int count = countByDistrictId(districtId);

		if (count == 0) {
			return null;
		}

		List<EmployeeAddress> list = findByDistrictId(
			districtId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee addresses before and after the current employee address in the ordered set where districtId = &#63;.
	 *
	 * @param employeeAddressId the primary key of the current employee address
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee address
	 * @throws NoSuchEmployeeAddressException if a employee address with the primary key could not be found
	 */
	@Override
	public EmployeeAddress[] findByDistrictId_PrevAndNext(
			long employeeAddressId, long districtId,
			OrderByComparator<EmployeeAddress> orderByComparator)
		throws NoSuchEmployeeAddressException {

		EmployeeAddress employeeAddress = findByPrimaryKey(employeeAddressId);

		Session session = null;

		try {
			session = openSession();

			EmployeeAddress[] array = new EmployeeAddressImpl[3];

			array[0] = getByDistrictId_PrevAndNext(
				session, employeeAddress, districtId, orderByComparator, true);

			array[1] = employeeAddress;

			array[2] = getByDistrictId_PrevAndNext(
				session, employeeAddress, districtId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EmployeeAddress getByDistrictId_PrevAndNext(
		Session session, EmployeeAddress employeeAddress, long districtId,
		OrderByComparator<EmployeeAddress> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEADDRESS_WHERE);

		sb.append(_FINDER_COLUMN_DISTRICTID_DISTRICTID_2);

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
			sb.append(EmployeeAddressModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(districtId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						employeeAddress)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeAddress> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee addresses where districtId = &#63; from the database.
	 *
	 * @param districtId the district ID
	 */
	@Override
	public void removeByDistrictId(long districtId) {
		for (EmployeeAddress employeeAddress :
				findByDistrictId(
					districtId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeeAddress);
		}
	}

	/**
	 * Returns the number of employee addresses where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @return the number of matching employee addresses
	 */
	@Override
	public int countByDistrictId(long districtId) {
		FinderPath finderPath = _finderPathCountByDistrictId;

		Object[] finderArgs = new Object[] {districtId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEADDRESS_WHERE);

			sb.append(_FINDER_COLUMN_DISTRICTID_DISTRICTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(districtId);

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

	private static final String _FINDER_COLUMN_DISTRICTID_DISTRICTID_2 =
		"employeeAddress.districtId = ?";

	private FinderPath _finderPathWithPaginationFindByStateId;
	private FinderPath _finderPathWithoutPaginationFindByStateId;
	private FinderPath _finderPathCountByStateId;

	/**
	 * Returns all the employee addresses where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @return the matching employee addresses
	 */
	@Override
	public List<EmployeeAddress> findByStateId(long stateId) {
		return findByStateId(
			stateId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee addresses where stateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeAddressModelImpl</code>.
	 * </p>
	 *
	 * @param stateId the state ID
	 * @param start the lower bound of the range of employee addresses
	 * @param end the upper bound of the range of employee addresses (not inclusive)
	 * @return the range of matching employee addresses
	 */
	@Override
	public List<EmployeeAddress> findByStateId(
		long stateId, int start, int end) {

		return findByStateId(stateId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee addresses where stateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeAddressModelImpl</code>.
	 * </p>
	 *
	 * @param stateId the state ID
	 * @param start the lower bound of the range of employee addresses
	 * @param end the upper bound of the range of employee addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee addresses
	 */
	@Override
	public List<EmployeeAddress> findByStateId(
		long stateId, int start, int end,
		OrderByComparator<EmployeeAddress> orderByComparator) {

		return findByStateId(stateId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee addresses where stateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeAddressModelImpl</code>.
	 * </p>
	 *
	 * @param stateId the state ID
	 * @param start the lower bound of the range of employee addresses
	 * @param end the upper bound of the range of employee addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee addresses
	 */
	@Override
	public List<EmployeeAddress> findByStateId(
		long stateId, int start, int end,
		OrderByComparator<EmployeeAddress> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByStateId;
				finderArgs = new Object[] {stateId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByStateId;
			finderArgs = new Object[] {stateId, start, end, orderByComparator};
		}

		List<EmployeeAddress> list = null;

		if (useFinderCache) {
			list = (List<EmployeeAddress>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeAddress employeeAddress : list) {
					if (stateId != employeeAddress.getStateId()) {
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

			sb.append(_SQL_SELECT_EMPLOYEEADDRESS_WHERE);

			sb.append(_FINDER_COLUMN_STATEID_STATEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeAddressModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(stateId);

				list = (List<EmployeeAddress>)QueryUtil.list(
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
	 * Returns the first employee address in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee address
	 * @throws NoSuchEmployeeAddressException if a matching employee address could not be found
	 */
	@Override
	public EmployeeAddress findByStateId_First(
			long stateId, OrderByComparator<EmployeeAddress> orderByComparator)
		throws NoSuchEmployeeAddressException {

		EmployeeAddress employeeAddress = fetchByStateId_First(
			stateId, orderByComparator);

		if (employeeAddress != null) {
			return employeeAddress;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("stateId=");
		sb.append(stateId);

		sb.append("}");

		throw new NoSuchEmployeeAddressException(sb.toString());
	}

	/**
	 * Returns the first employee address in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee address, or <code>null</code> if a matching employee address could not be found
	 */
	@Override
	public EmployeeAddress fetchByStateId_First(
		long stateId, OrderByComparator<EmployeeAddress> orderByComparator) {

		List<EmployeeAddress> list = findByStateId(
			stateId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee address in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee address
	 * @throws NoSuchEmployeeAddressException if a matching employee address could not be found
	 */
	@Override
	public EmployeeAddress findByStateId_Last(
			long stateId, OrderByComparator<EmployeeAddress> orderByComparator)
		throws NoSuchEmployeeAddressException {

		EmployeeAddress employeeAddress = fetchByStateId_Last(
			stateId, orderByComparator);

		if (employeeAddress != null) {
			return employeeAddress;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("stateId=");
		sb.append(stateId);

		sb.append("}");

		throw new NoSuchEmployeeAddressException(sb.toString());
	}

	/**
	 * Returns the last employee address in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee address, or <code>null</code> if a matching employee address could not be found
	 */
	@Override
	public EmployeeAddress fetchByStateId_Last(
		long stateId, OrderByComparator<EmployeeAddress> orderByComparator) {

		int count = countByStateId(stateId);

		if (count == 0) {
			return null;
		}

		List<EmployeeAddress> list = findByStateId(
			stateId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee addresses before and after the current employee address in the ordered set where stateId = &#63;.
	 *
	 * @param employeeAddressId the primary key of the current employee address
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee address
	 * @throws NoSuchEmployeeAddressException if a employee address with the primary key could not be found
	 */
	@Override
	public EmployeeAddress[] findByStateId_PrevAndNext(
			long employeeAddressId, long stateId,
			OrderByComparator<EmployeeAddress> orderByComparator)
		throws NoSuchEmployeeAddressException {

		EmployeeAddress employeeAddress = findByPrimaryKey(employeeAddressId);

		Session session = null;

		try {
			session = openSession();

			EmployeeAddress[] array = new EmployeeAddressImpl[3];

			array[0] = getByStateId_PrevAndNext(
				session, employeeAddress, stateId, orderByComparator, true);

			array[1] = employeeAddress;

			array[2] = getByStateId_PrevAndNext(
				session, employeeAddress, stateId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EmployeeAddress getByStateId_PrevAndNext(
		Session session, EmployeeAddress employeeAddress, long stateId,
		OrderByComparator<EmployeeAddress> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEADDRESS_WHERE);

		sb.append(_FINDER_COLUMN_STATEID_STATEID_2);

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
			sb.append(EmployeeAddressModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(stateId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						employeeAddress)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeAddress> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee addresses where stateId = &#63; from the database.
	 *
	 * @param stateId the state ID
	 */
	@Override
	public void removeByStateId(long stateId) {
		for (EmployeeAddress employeeAddress :
				findByStateId(
					stateId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeeAddress);
		}
	}

	/**
	 * Returns the number of employee addresses where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @return the number of matching employee addresses
	 */
	@Override
	public int countByStateId(long stateId) {
		FinderPath finderPath = _finderPathCountByStateId;

		Object[] finderArgs = new Object[] {stateId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEADDRESS_WHERE);

			sb.append(_FINDER_COLUMN_STATEID_STATEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(stateId);

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

	private static final String _FINDER_COLUMN_STATEID_STATEID_2 =
		"employeeAddress.stateId = ?";

	private FinderPath _finderPathWithPaginationFindByAccomodationTypeId;
	private FinderPath _finderPathWithoutPaginationFindByAccomodationTypeId;
	private FinderPath _finderPathCountByAccomodationTypeId;

	/**
	 * Returns all the employee addresses where accomodationTypeId = &#63;.
	 *
	 * @param accomodationTypeId the accomodation type ID
	 * @return the matching employee addresses
	 */
	@Override
	public List<EmployeeAddress> findByAccomodationTypeId(
		long accomodationTypeId) {

		return findByAccomodationTypeId(
			accomodationTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee addresses where accomodationTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeAddressModelImpl</code>.
	 * </p>
	 *
	 * @param accomodationTypeId the accomodation type ID
	 * @param start the lower bound of the range of employee addresses
	 * @param end the upper bound of the range of employee addresses (not inclusive)
	 * @return the range of matching employee addresses
	 */
	@Override
	public List<EmployeeAddress> findByAccomodationTypeId(
		long accomodationTypeId, int start, int end) {

		return findByAccomodationTypeId(accomodationTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee addresses where accomodationTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeAddressModelImpl</code>.
	 * </p>
	 *
	 * @param accomodationTypeId the accomodation type ID
	 * @param start the lower bound of the range of employee addresses
	 * @param end the upper bound of the range of employee addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee addresses
	 */
	@Override
	public List<EmployeeAddress> findByAccomodationTypeId(
		long accomodationTypeId, int start, int end,
		OrderByComparator<EmployeeAddress> orderByComparator) {

		return findByAccomodationTypeId(
			accomodationTypeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee addresses where accomodationTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeAddressModelImpl</code>.
	 * </p>
	 *
	 * @param accomodationTypeId the accomodation type ID
	 * @param start the lower bound of the range of employee addresses
	 * @param end the upper bound of the range of employee addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee addresses
	 */
	@Override
	public List<EmployeeAddress> findByAccomodationTypeId(
		long accomodationTypeId, int start, int end,
		OrderByComparator<EmployeeAddress> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByAccomodationTypeId;
				finderArgs = new Object[] {accomodationTypeId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByAccomodationTypeId;
			finderArgs = new Object[] {
				accomodationTypeId, start, end, orderByComparator
			};
		}

		List<EmployeeAddress> list = null;

		if (useFinderCache) {
			list = (List<EmployeeAddress>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeAddress employeeAddress : list) {
					if (accomodationTypeId !=
							employeeAddress.getAccomodationTypeId()) {

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

			sb.append(_SQL_SELECT_EMPLOYEEADDRESS_WHERE);

			sb.append(_FINDER_COLUMN_ACCOMODATIONTYPEID_ACCOMODATIONTYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeAddressModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(accomodationTypeId);

				list = (List<EmployeeAddress>)QueryUtil.list(
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
	 * Returns the first employee address in the ordered set where accomodationTypeId = &#63;.
	 *
	 * @param accomodationTypeId the accomodation type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee address
	 * @throws NoSuchEmployeeAddressException if a matching employee address could not be found
	 */
	@Override
	public EmployeeAddress findByAccomodationTypeId_First(
			long accomodationTypeId,
			OrderByComparator<EmployeeAddress> orderByComparator)
		throws NoSuchEmployeeAddressException {

		EmployeeAddress employeeAddress = fetchByAccomodationTypeId_First(
			accomodationTypeId, orderByComparator);

		if (employeeAddress != null) {
			return employeeAddress;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("accomodationTypeId=");
		sb.append(accomodationTypeId);

		sb.append("}");

		throw new NoSuchEmployeeAddressException(sb.toString());
	}

	/**
	 * Returns the first employee address in the ordered set where accomodationTypeId = &#63;.
	 *
	 * @param accomodationTypeId the accomodation type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee address, or <code>null</code> if a matching employee address could not be found
	 */
	@Override
	public EmployeeAddress fetchByAccomodationTypeId_First(
		long accomodationTypeId,
		OrderByComparator<EmployeeAddress> orderByComparator) {

		List<EmployeeAddress> list = findByAccomodationTypeId(
			accomodationTypeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee address in the ordered set where accomodationTypeId = &#63;.
	 *
	 * @param accomodationTypeId the accomodation type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee address
	 * @throws NoSuchEmployeeAddressException if a matching employee address could not be found
	 */
	@Override
	public EmployeeAddress findByAccomodationTypeId_Last(
			long accomodationTypeId,
			OrderByComparator<EmployeeAddress> orderByComparator)
		throws NoSuchEmployeeAddressException {

		EmployeeAddress employeeAddress = fetchByAccomodationTypeId_Last(
			accomodationTypeId, orderByComparator);

		if (employeeAddress != null) {
			return employeeAddress;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("accomodationTypeId=");
		sb.append(accomodationTypeId);

		sb.append("}");

		throw new NoSuchEmployeeAddressException(sb.toString());
	}

	/**
	 * Returns the last employee address in the ordered set where accomodationTypeId = &#63;.
	 *
	 * @param accomodationTypeId the accomodation type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee address, or <code>null</code> if a matching employee address could not be found
	 */
	@Override
	public EmployeeAddress fetchByAccomodationTypeId_Last(
		long accomodationTypeId,
		OrderByComparator<EmployeeAddress> orderByComparator) {

		int count = countByAccomodationTypeId(accomodationTypeId);

		if (count == 0) {
			return null;
		}

		List<EmployeeAddress> list = findByAccomodationTypeId(
			accomodationTypeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee addresses before and after the current employee address in the ordered set where accomodationTypeId = &#63;.
	 *
	 * @param employeeAddressId the primary key of the current employee address
	 * @param accomodationTypeId the accomodation type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee address
	 * @throws NoSuchEmployeeAddressException if a employee address with the primary key could not be found
	 */
	@Override
	public EmployeeAddress[] findByAccomodationTypeId_PrevAndNext(
			long employeeAddressId, long accomodationTypeId,
			OrderByComparator<EmployeeAddress> orderByComparator)
		throws NoSuchEmployeeAddressException {

		EmployeeAddress employeeAddress = findByPrimaryKey(employeeAddressId);

		Session session = null;

		try {
			session = openSession();

			EmployeeAddress[] array = new EmployeeAddressImpl[3];

			array[0] = getByAccomodationTypeId_PrevAndNext(
				session, employeeAddress, accomodationTypeId, orderByComparator,
				true);

			array[1] = employeeAddress;

			array[2] = getByAccomodationTypeId_PrevAndNext(
				session, employeeAddress, accomodationTypeId, orderByComparator,
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

	protected EmployeeAddress getByAccomodationTypeId_PrevAndNext(
		Session session, EmployeeAddress employeeAddress,
		long accomodationTypeId,
		OrderByComparator<EmployeeAddress> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEADDRESS_WHERE);

		sb.append(_FINDER_COLUMN_ACCOMODATIONTYPEID_ACCOMODATIONTYPEID_2);

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
			sb.append(EmployeeAddressModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(accomodationTypeId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						employeeAddress)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeAddress> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee addresses where accomodationTypeId = &#63; from the database.
	 *
	 * @param accomodationTypeId the accomodation type ID
	 */
	@Override
	public void removeByAccomodationTypeId(long accomodationTypeId) {
		for (EmployeeAddress employeeAddress :
				findByAccomodationTypeId(
					accomodationTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(employeeAddress);
		}
	}

	/**
	 * Returns the number of employee addresses where accomodationTypeId = &#63;.
	 *
	 * @param accomodationTypeId the accomodation type ID
	 * @return the number of matching employee addresses
	 */
	@Override
	public int countByAccomodationTypeId(long accomodationTypeId) {
		FinderPath finderPath = _finderPathCountByAccomodationTypeId;

		Object[] finderArgs = new Object[] {accomodationTypeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEADDRESS_WHERE);

			sb.append(_FINDER_COLUMN_ACCOMODATIONTYPEID_ACCOMODATIONTYPEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(accomodationTypeId);

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
		_FINDER_COLUMN_ACCOMODATIONTYPEID_ACCOMODATIONTYPEID_2 =
			"employeeAddress.accomodationTypeId = ?";

	private FinderPath _finderPathWithPaginationFindByEmployeeId;
	private FinderPath _finderPathWithoutPaginationFindByEmployeeId;
	private FinderPath _finderPathCountByEmployeeId;

	/**
	 * Returns all the employee addresses where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee addresses
	 */
	@Override
	public List<EmployeeAddress> findByEmployeeId(long employeeId) {
		return findByEmployeeId(
			employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee addresses where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeAddressModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee addresses
	 * @param end the upper bound of the range of employee addresses (not inclusive)
	 * @return the range of matching employee addresses
	 */
	@Override
	public List<EmployeeAddress> findByEmployeeId(
		long employeeId, int start, int end) {

		return findByEmployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee addresses where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeAddressModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee addresses
	 * @param end the upper bound of the range of employee addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee addresses
	 */
	@Override
	public List<EmployeeAddress> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeAddress> orderByComparator) {

		return findByEmployeeId(
			employeeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee addresses where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeAddressModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee addresses
	 * @param end the upper bound of the range of employee addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee addresses
	 */
	@Override
	public List<EmployeeAddress> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeAddress> orderByComparator,
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

		List<EmployeeAddress> list = null;

		if (useFinderCache) {
			list = (List<EmployeeAddress>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeAddress employeeAddress : list) {
					if (employeeId != employeeAddress.getEmployeeId()) {
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

			sb.append(_SQL_SELECT_EMPLOYEEADDRESS_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeAddressModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				list = (List<EmployeeAddress>)QueryUtil.list(
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
	 * Returns the first employee address in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee address
	 * @throws NoSuchEmployeeAddressException if a matching employee address could not be found
	 */
	@Override
	public EmployeeAddress findByEmployeeId_First(
			long employeeId,
			OrderByComparator<EmployeeAddress> orderByComparator)
		throws NoSuchEmployeeAddressException {

		EmployeeAddress employeeAddress = fetchByEmployeeId_First(
			employeeId, orderByComparator);

		if (employeeAddress != null) {
			return employeeAddress;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeeAddressException(sb.toString());
	}

	/**
	 * Returns the first employee address in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee address, or <code>null</code> if a matching employee address could not be found
	 */
	@Override
	public EmployeeAddress fetchByEmployeeId_First(
		long employeeId, OrderByComparator<EmployeeAddress> orderByComparator) {

		List<EmployeeAddress> list = findByEmployeeId(
			employeeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee address in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee address
	 * @throws NoSuchEmployeeAddressException if a matching employee address could not be found
	 */
	@Override
	public EmployeeAddress findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<EmployeeAddress> orderByComparator)
		throws NoSuchEmployeeAddressException {

		EmployeeAddress employeeAddress = fetchByEmployeeId_Last(
			employeeId, orderByComparator);

		if (employeeAddress != null) {
			return employeeAddress;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeeAddressException(sb.toString());
	}

	/**
	 * Returns the last employee address in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee address, or <code>null</code> if a matching employee address could not be found
	 */
	@Override
	public EmployeeAddress fetchByEmployeeId_Last(
		long employeeId, OrderByComparator<EmployeeAddress> orderByComparator) {

		int count = countByEmployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<EmployeeAddress> list = findByEmployeeId(
			employeeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee addresses before and after the current employee address in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeAddressId the primary key of the current employee address
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee address
	 * @throws NoSuchEmployeeAddressException if a employee address with the primary key could not be found
	 */
	@Override
	public EmployeeAddress[] findByEmployeeId_PrevAndNext(
			long employeeAddressId, long employeeId,
			OrderByComparator<EmployeeAddress> orderByComparator)
		throws NoSuchEmployeeAddressException {

		EmployeeAddress employeeAddress = findByPrimaryKey(employeeAddressId);

		Session session = null;

		try {
			session = openSession();

			EmployeeAddress[] array = new EmployeeAddressImpl[3];

			array[0] = getByEmployeeId_PrevAndNext(
				session, employeeAddress, employeeId, orderByComparator, true);

			array[1] = employeeAddress;

			array[2] = getByEmployeeId_PrevAndNext(
				session, employeeAddress, employeeId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EmployeeAddress getByEmployeeId_PrevAndNext(
		Session session, EmployeeAddress employeeAddress, long employeeId,
		OrderByComparator<EmployeeAddress> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEADDRESS_WHERE);

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
			sb.append(EmployeeAddressModelImpl.ORDER_BY_JPQL);
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
						employeeAddress)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeAddress> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee addresses where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeByEmployeeId(long employeeId) {
		for (EmployeeAddress employeeAddress :
				findByEmployeeId(
					employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeeAddress);
		}
	}

	/**
	 * Returns the number of employee addresses where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee addresses
	 */
	@Override
	public int countByEmployeeId(long employeeId) {
		FinderPath finderPath = _finderPathCountByEmployeeId;

		Object[] finderArgs = new Object[] {employeeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEADDRESS_WHERE);

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
		"employeeAddress.employeeId = ?";

	public EmployeeAddressPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(EmployeeAddress.class);

		setModelImplClass(EmployeeAddressImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the employee address in the entity cache if it is enabled.
	 *
	 * @param employeeAddress the employee address
	 */
	@Override
	public void cacheResult(EmployeeAddress employeeAddress) {
		entityCache.putResult(
			EmployeeAddressImpl.class, employeeAddress.getPrimaryKey(),
			employeeAddress);
	}

	/**
	 * Caches the employee addresses in the entity cache if it is enabled.
	 *
	 * @param employeeAddresses the employee addresses
	 */
	@Override
	public void cacheResult(List<EmployeeAddress> employeeAddresses) {
		for (EmployeeAddress employeeAddress : employeeAddresses) {
			if (entityCache.getResult(
					EmployeeAddressImpl.class,
					employeeAddress.getPrimaryKey()) == null) {

				cacheResult(employeeAddress);
			}
		}
	}

	/**
	 * Clears the cache for all employee addresses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmployeeAddressImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the employee address.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmployeeAddress employeeAddress) {
		entityCache.removeResult(EmployeeAddressImpl.class, employeeAddress);
	}

	@Override
	public void clearCache(List<EmployeeAddress> employeeAddresses) {
		for (EmployeeAddress employeeAddress : employeeAddresses) {
			entityCache.removeResult(
				EmployeeAddressImpl.class, employeeAddress);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EmployeeAddressImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new employee address with the primary key. Does not add the employee address to the database.
	 *
	 * @param employeeAddressId the primary key for the new employee address
	 * @return the new employee address
	 */
	@Override
	public EmployeeAddress create(long employeeAddressId) {
		EmployeeAddress employeeAddress = new EmployeeAddressImpl();

		employeeAddress.setNew(true);
		employeeAddress.setPrimaryKey(employeeAddressId);

		employeeAddress.setCompanyId(CompanyThreadLocal.getCompanyId());

		return employeeAddress;
	}

	/**
	 * Removes the employee address with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeAddressId the primary key of the employee address
	 * @return the employee address that was removed
	 * @throws NoSuchEmployeeAddressException if a employee address with the primary key could not be found
	 */
	@Override
	public EmployeeAddress remove(long employeeAddressId)
		throws NoSuchEmployeeAddressException {

		return remove((Serializable)employeeAddressId);
	}

	/**
	 * Removes the employee address with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the employee address
	 * @return the employee address that was removed
	 * @throws NoSuchEmployeeAddressException if a employee address with the primary key could not be found
	 */
	@Override
	public EmployeeAddress remove(Serializable primaryKey)
		throws NoSuchEmployeeAddressException {

		Session session = null;

		try {
			session = openSession();

			EmployeeAddress employeeAddress = (EmployeeAddress)session.get(
				EmployeeAddressImpl.class, primaryKey);

			if (employeeAddress == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmployeeAddressException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(employeeAddress);
		}
		catch (NoSuchEmployeeAddressException noSuchEntityException) {
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
	protected EmployeeAddress removeImpl(EmployeeAddress employeeAddress) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(employeeAddress)) {
				employeeAddress = (EmployeeAddress)session.get(
					EmployeeAddressImpl.class,
					employeeAddress.getPrimaryKeyObj());
			}

			if (employeeAddress != null) {
				session.delete(employeeAddress);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (employeeAddress != null) {
			clearCache(employeeAddress);
		}

		return employeeAddress;
	}

	@Override
	public EmployeeAddress updateImpl(EmployeeAddress employeeAddress) {
		boolean isNew = employeeAddress.isNew();

		if (!(employeeAddress instanceof EmployeeAddressModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(employeeAddress.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					employeeAddress);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in employeeAddress proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EmployeeAddress implementation " +
					employeeAddress.getClass());
		}

		EmployeeAddressModelImpl employeeAddressModelImpl =
			(EmployeeAddressModelImpl)employeeAddress;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (employeeAddress.getCreateDate() == null)) {
			if (serviceContext == null) {
				employeeAddress.setCreateDate(now);
			}
			else {
				employeeAddress.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!employeeAddressModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				employeeAddress.setModifiedDate(now);
			}
			else {
				employeeAddress.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(employeeAddress);
			}
			else {
				employeeAddress = (EmployeeAddress)session.merge(
					employeeAddress);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EmployeeAddressImpl.class, employeeAddressModelImpl, false, true);

		if (isNew) {
			employeeAddress.setNew(false);
		}

		employeeAddress.resetOriginalValues();

		return employeeAddress;
	}

	/**
	 * Returns the employee address with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee address
	 * @return the employee address
	 * @throws NoSuchEmployeeAddressException if a employee address with the primary key could not be found
	 */
	@Override
	public EmployeeAddress findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmployeeAddressException {

		EmployeeAddress employeeAddress = fetchByPrimaryKey(primaryKey);

		if (employeeAddress == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmployeeAddressException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return employeeAddress;
	}

	/**
	 * Returns the employee address with the primary key or throws a <code>NoSuchEmployeeAddressException</code> if it could not be found.
	 *
	 * @param employeeAddressId the primary key of the employee address
	 * @return the employee address
	 * @throws NoSuchEmployeeAddressException if a employee address with the primary key could not be found
	 */
	@Override
	public EmployeeAddress findByPrimaryKey(long employeeAddressId)
		throws NoSuchEmployeeAddressException {

		return findByPrimaryKey((Serializable)employeeAddressId);
	}

	/**
	 * Returns the employee address with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeAddressId the primary key of the employee address
	 * @return the employee address, or <code>null</code> if a employee address with the primary key could not be found
	 */
	@Override
	public EmployeeAddress fetchByPrimaryKey(long employeeAddressId) {
		return fetchByPrimaryKey((Serializable)employeeAddressId);
	}

	/**
	 * Returns all the employee addresses.
	 *
	 * @return the employee addresses
	 */
	@Override
	public List<EmployeeAddress> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee addresses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeAddressModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee addresses
	 * @param end the upper bound of the range of employee addresses (not inclusive)
	 * @return the range of employee addresses
	 */
	@Override
	public List<EmployeeAddress> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee addresses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeAddressModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee addresses
	 * @param end the upper bound of the range of employee addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee addresses
	 */
	@Override
	public List<EmployeeAddress> findAll(
		int start, int end,
		OrderByComparator<EmployeeAddress> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee addresses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeAddressModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee addresses
	 * @param end the upper bound of the range of employee addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee addresses
	 */
	@Override
	public List<EmployeeAddress> findAll(
		int start, int end,
		OrderByComparator<EmployeeAddress> orderByComparator,
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

		List<EmployeeAddress> list = null;

		if (useFinderCache) {
			list = (List<EmployeeAddress>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EMPLOYEEADDRESS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLOYEEADDRESS;

				sql = sql.concat(EmployeeAddressModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EmployeeAddress>)QueryUtil.list(
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
	 * Removes all the employee addresses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EmployeeAddress employeeAddress : findAll()) {
			remove(employeeAddress);
		}
	}

	/**
	 * Returns the number of employee addresses.
	 *
	 * @return the number of employee addresses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_EMPLOYEEADDRESS);

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
		return "employeeAddressId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EMPLOYEEADDRESS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EmployeeAddressModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the employee address persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new EmployeeAddressModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", EmployeeAddress.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByDistrictId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDistrictId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"districtId"}, true);

		_finderPathWithoutPaginationFindByDistrictId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDistrictId",
			new String[] {Long.class.getName()}, new String[] {"districtId"},
			true);

		_finderPathCountByDistrictId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDistrictId",
			new String[] {Long.class.getName()}, new String[] {"districtId"},
			false);

		_finderPathWithPaginationFindByStateId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStateId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"stateId"}, true);

		_finderPathWithoutPaginationFindByStateId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStateId",
			new String[] {Long.class.getName()}, new String[] {"stateId"},
			true);

		_finderPathCountByStateId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStateId",
			new String[] {Long.class.getName()}, new String[] {"stateId"},
			false);

		_finderPathWithPaginationFindByAccomodationTypeId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAccomodationTypeId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"accomodationTypeId"}, true);

		_finderPathWithoutPaginationFindByAccomodationTypeId =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByAccomodationTypeId", new String[] {Long.class.getName()},
				new String[] {"accomodationTypeId"}, true);

		_finderPathCountByAccomodationTypeId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByAccomodationTypeId", new String[] {Long.class.getName()},
			new String[] {"accomodationTypeId"}, false);

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
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(EmployeeAddressImpl.class.getName());

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

	private static final String _SQL_SELECT_EMPLOYEEADDRESS =
		"SELECT employeeAddress FROM EmployeeAddress employeeAddress";

	private static final String _SQL_SELECT_EMPLOYEEADDRESS_WHERE =
		"SELECT employeeAddress FROM EmployeeAddress employeeAddress WHERE ";

	private static final String _SQL_COUNT_EMPLOYEEADDRESS =
		"SELECT COUNT(employeeAddress) FROM EmployeeAddress employeeAddress";

	private static final String _SQL_COUNT_EMPLOYEEADDRESS_WHERE =
		"SELECT COUNT(employeeAddress) FROM EmployeeAddress employeeAddress WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "employeeAddress.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EmployeeAddress exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EmployeeAddress exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EmployeeAddressPersistenceImpl.class);

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

	private static class EmployeeAddressModelArgumentsResolver
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

			EmployeeAddressModelImpl employeeAddressModelImpl =
				(EmployeeAddressModelImpl)baseModel;

			long columnBitmask = employeeAddressModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					employeeAddressModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						employeeAddressModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					employeeAddressModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			EmployeeAddressModelImpl employeeAddressModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						employeeAddressModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = employeeAddressModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}