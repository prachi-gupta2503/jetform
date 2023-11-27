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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeWorkstationException;
import com.adjecti.pis.liferay.model.EmployeeWorkstation;
import com.adjecti.pis.liferay.model.impl.EmployeeWorkstationImpl;
import com.adjecti.pis.liferay.model.impl.EmployeeWorkstationModelImpl;
import com.adjecti.pis.liferay.service.persistence.EmployeeWorkstationPersistence;
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
 * The persistence implementation for the employee workstation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EmployeeWorkstationPersistence.class)
public class EmployeeWorkstationPersistenceImpl
	extends BasePersistenceImpl<EmployeeWorkstation>
	implements EmployeeWorkstationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EmployeeWorkstationUtil</code> to access the employee workstation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EmployeeWorkstationImpl.class.getName();

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
	 * Returns all the employee workstations where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee workstations
	 */
	@Override
	public List<EmployeeWorkstation> findByEmployeeId(long employeeId) {
		return findByEmployeeId(
			employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee workstations where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeWorkstationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee workstations
	 * @param end the upper bound of the range of employee workstations (not inclusive)
	 * @return the range of matching employee workstations
	 */
	@Override
	public List<EmployeeWorkstation> findByEmployeeId(
		long employeeId, int start, int end) {

		return findByEmployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee workstations where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeWorkstationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee workstations
	 * @param end the upper bound of the range of employee workstations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee workstations
	 */
	@Override
	public List<EmployeeWorkstation> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeWorkstation> orderByComparator) {

		return findByEmployeeId(
			employeeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee workstations where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeWorkstationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee workstations
	 * @param end the upper bound of the range of employee workstations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee workstations
	 */
	@Override
	public List<EmployeeWorkstation> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeWorkstation> orderByComparator,
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

		List<EmployeeWorkstation> list = null;

		if (useFinderCache) {
			list = (List<EmployeeWorkstation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeWorkstation employeeWorkstation : list) {
					if (employeeId != employeeWorkstation.getEmployeeId()) {
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

			sb.append(_SQL_SELECT_EMPLOYEEWORKSTATION_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeWorkstationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				list = (List<EmployeeWorkstation>)QueryUtil.list(
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
	 * Returns the first employee workstation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee workstation
	 * @throws NoSuchEmployeeWorkstationException if a matching employee workstation could not be found
	 */
	@Override
	public EmployeeWorkstation findByEmployeeId_First(
			long employeeId,
			OrderByComparator<EmployeeWorkstation> orderByComparator)
		throws NoSuchEmployeeWorkstationException {

		EmployeeWorkstation employeeWorkstation = fetchByEmployeeId_First(
			employeeId, orderByComparator);

		if (employeeWorkstation != null) {
			return employeeWorkstation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeeWorkstationException(sb.toString());
	}

	/**
	 * Returns the first employee workstation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee workstation, or <code>null</code> if a matching employee workstation could not be found
	 */
	@Override
	public EmployeeWorkstation fetchByEmployeeId_First(
		long employeeId,
		OrderByComparator<EmployeeWorkstation> orderByComparator) {

		List<EmployeeWorkstation> list = findByEmployeeId(
			employeeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee workstation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee workstation
	 * @throws NoSuchEmployeeWorkstationException if a matching employee workstation could not be found
	 */
	@Override
	public EmployeeWorkstation findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<EmployeeWorkstation> orderByComparator)
		throws NoSuchEmployeeWorkstationException {

		EmployeeWorkstation employeeWorkstation = fetchByEmployeeId_Last(
			employeeId, orderByComparator);

		if (employeeWorkstation != null) {
			return employeeWorkstation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeeWorkstationException(sb.toString());
	}

	/**
	 * Returns the last employee workstation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee workstation, or <code>null</code> if a matching employee workstation could not be found
	 */
	@Override
	public EmployeeWorkstation fetchByEmployeeId_Last(
		long employeeId,
		OrderByComparator<EmployeeWorkstation> orderByComparator) {

		int count = countByEmployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<EmployeeWorkstation> list = findByEmployeeId(
			employeeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee workstations before and after the current employee workstation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeWorkstationId the primary key of the current employee workstation
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee workstation
	 * @throws NoSuchEmployeeWorkstationException if a employee workstation with the primary key could not be found
	 */
	@Override
	public EmployeeWorkstation[] findByEmployeeId_PrevAndNext(
			long employeeWorkstationId, long employeeId,
			OrderByComparator<EmployeeWorkstation> orderByComparator)
		throws NoSuchEmployeeWorkstationException {

		EmployeeWorkstation employeeWorkstation = findByPrimaryKey(
			employeeWorkstationId);

		Session session = null;

		try {
			session = openSession();

			EmployeeWorkstation[] array = new EmployeeWorkstationImpl[3];

			array[0] = getByEmployeeId_PrevAndNext(
				session, employeeWorkstation, employeeId, orderByComparator,
				true);

			array[1] = employeeWorkstation;

			array[2] = getByEmployeeId_PrevAndNext(
				session, employeeWorkstation, employeeId, orderByComparator,
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

	protected EmployeeWorkstation getByEmployeeId_PrevAndNext(
		Session session, EmployeeWorkstation employeeWorkstation,
		long employeeId,
		OrderByComparator<EmployeeWorkstation> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEWORKSTATION_WHERE);

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
			sb.append(EmployeeWorkstationModelImpl.ORDER_BY_JPQL);
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
						employeeWorkstation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeWorkstation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee workstations where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeByEmployeeId(long employeeId) {
		for (EmployeeWorkstation employeeWorkstation :
				findByEmployeeId(
					employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeeWorkstation);
		}
	}

	/**
	 * Returns the number of employee workstations where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee workstations
	 */
	@Override
	public int countByEmployeeId(long employeeId) {
		FinderPath finderPath = _finderPathCountByEmployeeId;

		Object[] finderArgs = new Object[] {employeeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEWORKSTATION_WHERE);

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
		"employeeWorkstation.employeeId = ?";

	public EmployeeWorkstationPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(EmployeeWorkstation.class);

		setModelImplClass(EmployeeWorkstationImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the employee workstation in the entity cache if it is enabled.
	 *
	 * @param employeeWorkstation the employee workstation
	 */
	@Override
	public void cacheResult(EmployeeWorkstation employeeWorkstation) {
		entityCache.putResult(
			EmployeeWorkstationImpl.class, employeeWorkstation.getPrimaryKey(),
			employeeWorkstation);
	}

	/**
	 * Caches the employee workstations in the entity cache if it is enabled.
	 *
	 * @param employeeWorkstations the employee workstations
	 */
	@Override
	public void cacheResult(List<EmployeeWorkstation> employeeWorkstations) {
		for (EmployeeWorkstation employeeWorkstation : employeeWorkstations) {
			if (entityCache.getResult(
					EmployeeWorkstationImpl.class,
					employeeWorkstation.getPrimaryKey()) == null) {

				cacheResult(employeeWorkstation);
			}
		}
	}

	/**
	 * Clears the cache for all employee workstations.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmployeeWorkstationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the employee workstation.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmployeeWorkstation employeeWorkstation) {
		entityCache.removeResult(
			EmployeeWorkstationImpl.class, employeeWorkstation);
	}

	@Override
	public void clearCache(List<EmployeeWorkstation> employeeWorkstations) {
		for (EmployeeWorkstation employeeWorkstation : employeeWorkstations) {
			entityCache.removeResult(
				EmployeeWorkstationImpl.class, employeeWorkstation);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EmployeeWorkstationImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new employee workstation with the primary key. Does not add the employee workstation to the database.
	 *
	 * @param employeeWorkstationId the primary key for the new employee workstation
	 * @return the new employee workstation
	 */
	@Override
	public EmployeeWorkstation create(long employeeWorkstationId) {
		EmployeeWorkstation employeeWorkstation = new EmployeeWorkstationImpl();

		employeeWorkstation.setNew(true);
		employeeWorkstation.setPrimaryKey(employeeWorkstationId);

		employeeWorkstation.setCompanyId(CompanyThreadLocal.getCompanyId());

		return employeeWorkstation;
	}

	/**
	 * Removes the employee workstation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeWorkstationId the primary key of the employee workstation
	 * @return the employee workstation that was removed
	 * @throws NoSuchEmployeeWorkstationException if a employee workstation with the primary key could not be found
	 */
	@Override
	public EmployeeWorkstation remove(long employeeWorkstationId)
		throws NoSuchEmployeeWorkstationException {

		return remove((Serializable)employeeWorkstationId);
	}

	/**
	 * Removes the employee workstation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the employee workstation
	 * @return the employee workstation that was removed
	 * @throws NoSuchEmployeeWorkstationException if a employee workstation with the primary key could not be found
	 */
	@Override
	public EmployeeWorkstation remove(Serializable primaryKey)
		throws NoSuchEmployeeWorkstationException {

		Session session = null;

		try {
			session = openSession();

			EmployeeWorkstation employeeWorkstation =
				(EmployeeWorkstation)session.get(
					EmployeeWorkstationImpl.class, primaryKey);

			if (employeeWorkstation == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmployeeWorkstationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(employeeWorkstation);
		}
		catch (NoSuchEmployeeWorkstationException noSuchEntityException) {
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
	protected EmployeeWorkstation removeImpl(
		EmployeeWorkstation employeeWorkstation) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(employeeWorkstation)) {
				employeeWorkstation = (EmployeeWorkstation)session.get(
					EmployeeWorkstationImpl.class,
					employeeWorkstation.getPrimaryKeyObj());
			}

			if (employeeWorkstation != null) {
				session.delete(employeeWorkstation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (employeeWorkstation != null) {
			clearCache(employeeWorkstation);
		}

		return employeeWorkstation;
	}

	@Override
	public EmployeeWorkstation updateImpl(
		EmployeeWorkstation employeeWorkstation) {

		boolean isNew = employeeWorkstation.isNew();

		if (!(employeeWorkstation instanceof EmployeeWorkstationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(employeeWorkstation.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					employeeWorkstation);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in employeeWorkstation proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EmployeeWorkstation implementation " +
					employeeWorkstation.getClass());
		}

		EmployeeWorkstationModelImpl employeeWorkstationModelImpl =
			(EmployeeWorkstationModelImpl)employeeWorkstation;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (employeeWorkstation.getCreateDate() == null)) {
			if (serviceContext == null) {
				employeeWorkstation.setCreateDate(now);
			}
			else {
				employeeWorkstation.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!employeeWorkstationModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				employeeWorkstation.setModifiedDate(now);
			}
			else {
				employeeWorkstation.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(employeeWorkstation);
			}
			else {
				employeeWorkstation = (EmployeeWorkstation)session.merge(
					employeeWorkstation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EmployeeWorkstationImpl.class, employeeWorkstationModelImpl, false,
			true);

		if (isNew) {
			employeeWorkstation.setNew(false);
		}

		employeeWorkstation.resetOriginalValues();

		return employeeWorkstation;
	}

	/**
	 * Returns the employee workstation with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee workstation
	 * @return the employee workstation
	 * @throws NoSuchEmployeeWorkstationException if a employee workstation with the primary key could not be found
	 */
	@Override
	public EmployeeWorkstation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmployeeWorkstationException {

		EmployeeWorkstation employeeWorkstation = fetchByPrimaryKey(primaryKey);

		if (employeeWorkstation == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmployeeWorkstationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return employeeWorkstation;
	}

	/**
	 * Returns the employee workstation with the primary key or throws a <code>NoSuchEmployeeWorkstationException</code> if it could not be found.
	 *
	 * @param employeeWorkstationId the primary key of the employee workstation
	 * @return the employee workstation
	 * @throws NoSuchEmployeeWorkstationException if a employee workstation with the primary key could not be found
	 */
	@Override
	public EmployeeWorkstation findByPrimaryKey(long employeeWorkstationId)
		throws NoSuchEmployeeWorkstationException {

		return findByPrimaryKey((Serializable)employeeWorkstationId);
	}

	/**
	 * Returns the employee workstation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeWorkstationId the primary key of the employee workstation
	 * @return the employee workstation, or <code>null</code> if a employee workstation with the primary key could not be found
	 */
	@Override
	public EmployeeWorkstation fetchByPrimaryKey(long employeeWorkstationId) {
		return fetchByPrimaryKey((Serializable)employeeWorkstationId);
	}

	/**
	 * Returns all the employee workstations.
	 *
	 * @return the employee workstations
	 */
	@Override
	public List<EmployeeWorkstation> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee workstations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeWorkstationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee workstations
	 * @param end the upper bound of the range of employee workstations (not inclusive)
	 * @return the range of employee workstations
	 */
	@Override
	public List<EmployeeWorkstation> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee workstations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeWorkstationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee workstations
	 * @param end the upper bound of the range of employee workstations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee workstations
	 */
	@Override
	public List<EmployeeWorkstation> findAll(
		int start, int end,
		OrderByComparator<EmployeeWorkstation> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee workstations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeWorkstationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee workstations
	 * @param end the upper bound of the range of employee workstations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee workstations
	 */
	@Override
	public List<EmployeeWorkstation> findAll(
		int start, int end,
		OrderByComparator<EmployeeWorkstation> orderByComparator,
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

		List<EmployeeWorkstation> list = null;

		if (useFinderCache) {
			list = (List<EmployeeWorkstation>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EMPLOYEEWORKSTATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLOYEEWORKSTATION;

				sql = sql.concat(EmployeeWorkstationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EmployeeWorkstation>)QueryUtil.list(
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
	 * Removes all the employee workstations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EmployeeWorkstation employeeWorkstation : findAll()) {
			remove(employeeWorkstation);
		}
	}

	/**
	 * Returns the number of employee workstations.
	 *
	 * @return the number of employee workstations
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
					_SQL_COUNT_EMPLOYEEWORKSTATION);

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
		return "employeeWorkstationId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EMPLOYEEWORKSTATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EmployeeWorkstationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the employee workstation persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new EmployeeWorkstationModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", EmployeeWorkstation.class.getName()));

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
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(EmployeeWorkstationImpl.class.getName());

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

	private static final String _SQL_SELECT_EMPLOYEEWORKSTATION =
		"SELECT employeeWorkstation FROM EmployeeWorkstation employeeWorkstation";

	private static final String _SQL_SELECT_EMPLOYEEWORKSTATION_WHERE =
		"SELECT employeeWorkstation FROM EmployeeWorkstation employeeWorkstation WHERE ";

	private static final String _SQL_COUNT_EMPLOYEEWORKSTATION =
		"SELECT COUNT(employeeWorkstation) FROM EmployeeWorkstation employeeWorkstation";

	private static final String _SQL_COUNT_EMPLOYEEWORKSTATION_WHERE =
		"SELECT COUNT(employeeWorkstation) FROM EmployeeWorkstation employeeWorkstation WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "employeeWorkstation.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EmployeeWorkstation exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EmployeeWorkstation exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EmployeeWorkstationPersistenceImpl.class);

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

	private static class EmployeeWorkstationModelArgumentsResolver
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

			EmployeeWorkstationModelImpl employeeWorkstationModelImpl =
				(EmployeeWorkstationModelImpl)baseModel;

			long columnBitmask =
				employeeWorkstationModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					employeeWorkstationModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						employeeWorkstationModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					employeeWorkstationModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			EmployeeWorkstationModelImpl employeeWorkstationModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						employeeWorkstationModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = employeeWorkstationModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}