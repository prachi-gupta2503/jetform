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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeDelegationException;
import com.adjecti.pis.liferay.model.EmployeeDelegation;
import com.adjecti.pis.liferay.model.impl.EmployeeDelegationImpl;
import com.adjecti.pis.liferay.model.impl.EmployeeDelegationModelImpl;
import com.adjecti.pis.liferay.service.persistence.EmployeeDelegationPersistence;
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
 * The persistence implementation for the employee delegation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EmployeeDelegationPersistence.class)
public class EmployeeDelegationPersistenceImpl
	extends BasePersistenceImpl<EmployeeDelegation>
	implements EmployeeDelegationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EmployeeDelegationUtil</code> to access the employee delegation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EmployeeDelegationImpl.class.getName();

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
	 * Returns all the employee delegations where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee delegations
	 */
	@Override
	public List<EmployeeDelegation> findByEmployeeId(long employeeId) {
		return findByEmployeeId(
			employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee delegations where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDelegationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee delegations
	 * @param end the upper bound of the range of employee delegations (not inclusive)
	 * @return the range of matching employee delegations
	 */
	@Override
	public List<EmployeeDelegation> findByEmployeeId(
		long employeeId, int start, int end) {

		return findByEmployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee delegations where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDelegationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee delegations
	 * @param end the upper bound of the range of employee delegations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee delegations
	 */
	@Override
	public List<EmployeeDelegation> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeDelegation> orderByComparator) {

		return findByEmployeeId(
			employeeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee delegations where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDelegationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee delegations
	 * @param end the upper bound of the range of employee delegations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee delegations
	 */
	@Override
	public List<EmployeeDelegation> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeDelegation> orderByComparator,
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

		List<EmployeeDelegation> list = null;

		if (useFinderCache) {
			list = (List<EmployeeDelegation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeDelegation employeeDelegation : list) {
					if (employeeId != employeeDelegation.getEmployeeId()) {
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

			sb.append(_SQL_SELECT_EMPLOYEEDELEGATION_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeDelegationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				list = (List<EmployeeDelegation>)QueryUtil.list(
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
	 * Returns the first employee delegation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee delegation
	 * @throws NoSuchEmployeeDelegationException if a matching employee delegation could not be found
	 */
	@Override
	public EmployeeDelegation findByEmployeeId_First(
			long employeeId,
			OrderByComparator<EmployeeDelegation> orderByComparator)
		throws NoSuchEmployeeDelegationException {

		EmployeeDelegation employeeDelegation = fetchByEmployeeId_First(
			employeeId, orderByComparator);

		if (employeeDelegation != null) {
			return employeeDelegation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeeDelegationException(sb.toString());
	}

	/**
	 * Returns the first employee delegation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee delegation, or <code>null</code> if a matching employee delegation could not be found
	 */
	@Override
	public EmployeeDelegation fetchByEmployeeId_First(
		long employeeId,
		OrderByComparator<EmployeeDelegation> orderByComparator) {

		List<EmployeeDelegation> list = findByEmployeeId(
			employeeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee delegation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee delegation
	 * @throws NoSuchEmployeeDelegationException if a matching employee delegation could not be found
	 */
	@Override
	public EmployeeDelegation findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<EmployeeDelegation> orderByComparator)
		throws NoSuchEmployeeDelegationException {

		EmployeeDelegation employeeDelegation = fetchByEmployeeId_Last(
			employeeId, orderByComparator);

		if (employeeDelegation != null) {
			return employeeDelegation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeeDelegationException(sb.toString());
	}

	/**
	 * Returns the last employee delegation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee delegation, or <code>null</code> if a matching employee delegation could not be found
	 */
	@Override
	public EmployeeDelegation fetchByEmployeeId_Last(
		long employeeId,
		OrderByComparator<EmployeeDelegation> orderByComparator) {

		int count = countByEmployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<EmployeeDelegation> list = findByEmployeeId(
			employeeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee delegations before and after the current employee delegation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeDelegationId the primary key of the current employee delegation
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee delegation
	 * @throws NoSuchEmployeeDelegationException if a employee delegation with the primary key could not be found
	 */
	@Override
	public EmployeeDelegation[] findByEmployeeId_PrevAndNext(
			long employeeDelegationId, long employeeId,
			OrderByComparator<EmployeeDelegation> orderByComparator)
		throws NoSuchEmployeeDelegationException {

		EmployeeDelegation employeeDelegation = findByPrimaryKey(
			employeeDelegationId);

		Session session = null;

		try {
			session = openSession();

			EmployeeDelegation[] array = new EmployeeDelegationImpl[3];

			array[0] = getByEmployeeId_PrevAndNext(
				session, employeeDelegation, employeeId, orderByComparator,
				true);

			array[1] = employeeDelegation;

			array[2] = getByEmployeeId_PrevAndNext(
				session, employeeDelegation, employeeId, orderByComparator,
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

	protected EmployeeDelegation getByEmployeeId_PrevAndNext(
		Session session, EmployeeDelegation employeeDelegation, long employeeId,
		OrderByComparator<EmployeeDelegation> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEDELEGATION_WHERE);

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
			sb.append(EmployeeDelegationModelImpl.ORDER_BY_JPQL);
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
						employeeDelegation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeDelegation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee delegations where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeByEmployeeId(long employeeId) {
		for (EmployeeDelegation employeeDelegation :
				findByEmployeeId(
					employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeeDelegation);
		}
	}

	/**
	 * Returns the number of employee delegations where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee delegations
	 */
	@Override
	public int countByEmployeeId(long employeeId) {
		FinderPath finderPath = _finderPathCountByEmployeeId;

		Object[] finderArgs = new Object[] {employeeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEDELEGATION_WHERE);

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
		"employeeDelegation.employeeId = ?";

	public EmployeeDelegationPersistenceImpl() {
		setModelClass(EmployeeDelegation.class);

		setModelImplClass(EmployeeDelegationImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the employee delegation in the entity cache if it is enabled.
	 *
	 * @param employeeDelegation the employee delegation
	 */
	@Override
	public void cacheResult(EmployeeDelegation employeeDelegation) {
		entityCache.putResult(
			EmployeeDelegationImpl.class, employeeDelegation.getPrimaryKey(),
			employeeDelegation);
	}

	/**
	 * Caches the employee delegations in the entity cache if it is enabled.
	 *
	 * @param employeeDelegations the employee delegations
	 */
	@Override
	public void cacheResult(List<EmployeeDelegation> employeeDelegations) {
		for (EmployeeDelegation employeeDelegation : employeeDelegations) {
			if (entityCache.getResult(
					EmployeeDelegationImpl.class,
					employeeDelegation.getPrimaryKey()) == null) {

				cacheResult(employeeDelegation);
			}
		}
	}

	/**
	 * Clears the cache for all employee delegations.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmployeeDelegationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the employee delegation.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmployeeDelegation employeeDelegation) {
		entityCache.removeResult(
			EmployeeDelegationImpl.class, employeeDelegation);
	}

	@Override
	public void clearCache(List<EmployeeDelegation> employeeDelegations) {
		for (EmployeeDelegation employeeDelegation : employeeDelegations) {
			entityCache.removeResult(
				EmployeeDelegationImpl.class, employeeDelegation);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EmployeeDelegationImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new employee delegation with the primary key. Does not add the employee delegation to the database.
	 *
	 * @param employeeDelegationId the primary key for the new employee delegation
	 * @return the new employee delegation
	 */
	@Override
	public EmployeeDelegation create(long employeeDelegationId) {
		EmployeeDelegation employeeDelegation = new EmployeeDelegationImpl();

		employeeDelegation.setNew(true);
		employeeDelegation.setPrimaryKey(employeeDelegationId);

		employeeDelegation.setCompanyId(CompanyThreadLocal.getCompanyId());

		return employeeDelegation;
	}

	/**
	 * Removes the employee delegation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeDelegationId the primary key of the employee delegation
	 * @return the employee delegation that was removed
	 * @throws NoSuchEmployeeDelegationException if a employee delegation with the primary key could not be found
	 */
	@Override
	public EmployeeDelegation remove(long employeeDelegationId)
		throws NoSuchEmployeeDelegationException {

		return remove((Serializable)employeeDelegationId);
	}

	/**
	 * Removes the employee delegation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the employee delegation
	 * @return the employee delegation that was removed
	 * @throws NoSuchEmployeeDelegationException if a employee delegation with the primary key could not be found
	 */
	@Override
	public EmployeeDelegation remove(Serializable primaryKey)
		throws NoSuchEmployeeDelegationException {

		Session session = null;

		try {
			session = openSession();

			EmployeeDelegation employeeDelegation =
				(EmployeeDelegation)session.get(
					EmployeeDelegationImpl.class, primaryKey);

			if (employeeDelegation == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmployeeDelegationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(employeeDelegation);
		}
		catch (NoSuchEmployeeDelegationException noSuchEntityException) {
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
	protected EmployeeDelegation removeImpl(
		EmployeeDelegation employeeDelegation) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(employeeDelegation)) {
				employeeDelegation = (EmployeeDelegation)session.get(
					EmployeeDelegationImpl.class,
					employeeDelegation.getPrimaryKeyObj());
			}

			if (employeeDelegation != null) {
				session.delete(employeeDelegation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (employeeDelegation != null) {
			clearCache(employeeDelegation);
		}

		return employeeDelegation;
	}

	@Override
	public EmployeeDelegation updateImpl(
		EmployeeDelegation employeeDelegation) {

		boolean isNew = employeeDelegation.isNew();

		if (!(employeeDelegation instanceof EmployeeDelegationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(employeeDelegation.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					employeeDelegation);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in employeeDelegation proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EmployeeDelegation implementation " +
					employeeDelegation.getClass());
		}

		EmployeeDelegationModelImpl employeeDelegationModelImpl =
			(EmployeeDelegationModelImpl)employeeDelegation;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (employeeDelegation.getCreateDate() == null)) {
			if (serviceContext == null) {
				employeeDelegation.setCreateDate(now);
			}
			else {
				employeeDelegation.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!employeeDelegationModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				employeeDelegation.setModifiedDate(now);
			}
			else {
				employeeDelegation.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(employeeDelegation);
			}
			else {
				employeeDelegation = (EmployeeDelegation)session.merge(
					employeeDelegation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EmployeeDelegationImpl.class, employeeDelegationModelImpl, false,
			true);

		if (isNew) {
			employeeDelegation.setNew(false);
		}

		employeeDelegation.resetOriginalValues();

		return employeeDelegation;
	}

	/**
	 * Returns the employee delegation with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee delegation
	 * @return the employee delegation
	 * @throws NoSuchEmployeeDelegationException if a employee delegation with the primary key could not be found
	 */
	@Override
	public EmployeeDelegation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmployeeDelegationException {

		EmployeeDelegation employeeDelegation = fetchByPrimaryKey(primaryKey);

		if (employeeDelegation == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmployeeDelegationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return employeeDelegation;
	}

	/**
	 * Returns the employee delegation with the primary key or throws a <code>NoSuchEmployeeDelegationException</code> if it could not be found.
	 *
	 * @param employeeDelegationId the primary key of the employee delegation
	 * @return the employee delegation
	 * @throws NoSuchEmployeeDelegationException if a employee delegation with the primary key could not be found
	 */
	@Override
	public EmployeeDelegation findByPrimaryKey(long employeeDelegationId)
		throws NoSuchEmployeeDelegationException {

		return findByPrimaryKey((Serializable)employeeDelegationId);
	}

	/**
	 * Returns the employee delegation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeDelegationId the primary key of the employee delegation
	 * @return the employee delegation, or <code>null</code> if a employee delegation with the primary key could not be found
	 */
	@Override
	public EmployeeDelegation fetchByPrimaryKey(long employeeDelegationId) {
		return fetchByPrimaryKey((Serializable)employeeDelegationId);
	}

	/**
	 * Returns all the employee delegations.
	 *
	 * @return the employee delegations
	 */
	@Override
	public List<EmployeeDelegation> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee delegations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDelegationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee delegations
	 * @param end the upper bound of the range of employee delegations (not inclusive)
	 * @return the range of employee delegations
	 */
	@Override
	public List<EmployeeDelegation> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee delegations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDelegationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee delegations
	 * @param end the upper bound of the range of employee delegations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee delegations
	 */
	@Override
	public List<EmployeeDelegation> findAll(
		int start, int end,
		OrderByComparator<EmployeeDelegation> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee delegations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDelegationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee delegations
	 * @param end the upper bound of the range of employee delegations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee delegations
	 */
	@Override
	public List<EmployeeDelegation> findAll(
		int start, int end,
		OrderByComparator<EmployeeDelegation> orderByComparator,
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

		List<EmployeeDelegation> list = null;

		if (useFinderCache) {
			list = (List<EmployeeDelegation>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EMPLOYEEDELEGATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLOYEEDELEGATION;

				sql = sql.concat(EmployeeDelegationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EmployeeDelegation>)QueryUtil.list(
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
	 * Removes all the employee delegations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EmployeeDelegation employeeDelegation : findAll()) {
			remove(employeeDelegation);
		}
	}

	/**
	 * Returns the number of employee delegations.
	 *
	 * @return the number of employee delegations
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
					_SQL_COUNT_EMPLOYEEDELEGATION);

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
		return "employeeDelegationId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EMPLOYEEDELEGATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EmployeeDelegationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the employee delegation persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new EmployeeDelegationModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", EmployeeDelegation.class.getName()));

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
		entityCache.removeCache(EmployeeDelegationImpl.class.getName());

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

	private static final String _SQL_SELECT_EMPLOYEEDELEGATION =
		"SELECT employeeDelegation FROM EmployeeDelegation employeeDelegation";

	private static final String _SQL_SELECT_EMPLOYEEDELEGATION_WHERE =
		"SELECT employeeDelegation FROM EmployeeDelegation employeeDelegation WHERE ";

	private static final String _SQL_COUNT_EMPLOYEEDELEGATION =
		"SELECT COUNT(employeeDelegation) FROM EmployeeDelegation employeeDelegation";

	private static final String _SQL_COUNT_EMPLOYEEDELEGATION_WHERE =
		"SELECT COUNT(employeeDelegation) FROM EmployeeDelegation employeeDelegation WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "employeeDelegation.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EmployeeDelegation exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EmployeeDelegation exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EmployeeDelegationPersistenceImpl.class);

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

	private static class EmployeeDelegationModelArgumentsResolver
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

			EmployeeDelegationModelImpl employeeDelegationModelImpl =
				(EmployeeDelegationModelImpl)baseModel;

			long columnBitmask = employeeDelegationModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					employeeDelegationModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						employeeDelegationModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					employeeDelegationModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			EmployeeDelegationModelImpl employeeDelegationModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						employeeDelegationModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = employeeDelegationModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}