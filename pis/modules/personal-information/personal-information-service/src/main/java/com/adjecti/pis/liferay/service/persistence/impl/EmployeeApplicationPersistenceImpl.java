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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeApplicationException;
import com.adjecti.pis.liferay.model.EmployeeApplication;
import com.adjecti.pis.liferay.model.impl.EmployeeApplicationImpl;
import com.adjecti.pis.liferay.model.impl.EmployeeApplicationModelImpl;
import com.adjecti.pis.liferay.service.persistence.EmployeeApplicationPersistence;
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
 * The persistence implementation for the employee application service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EmployeeApplicationPersistence.class)
public class EmployeeApplicationPersistenceImpl
	extends BasePersistenceImpl<EmployeeApplication>
	implements EmployeeApplicationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EmployeeApplicationUtil</code> to access the employee application persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EmployeeApplicationImpl.class.getName();

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
	 * Returns all the employee applications where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee applications
	 */
	@Override
	public List<EmployeeApplication> findByEmployeeId(long employeeId) {
		return findByEmployeeId(
			employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee applications where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee applications
	 * @param end the upper bound of the range of employee applications (not inclusive)
	 * @return the range of matching employee applications
	 */
	@Override
	public List<EmployeeApplication> findByEmployeeId(
		long employeeId, int start, int end) {

		return findByEmployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee applications where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee applications
	 * @param end the upper bound of the range of employee applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee applications
	 */
	@Override
	public List<EmployeeApplication> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeApplication> orderByComparator) {

		return findByEmployeeId(
			employeeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee applications where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee applications
	 * @param end the upper bound of the range of employee applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee applications
	 */
	@Override
	public List<EmployeeApplication> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeApplication> orderByComparator,
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

		List<EmployeeApplication> list = null;

		if (useFinderCache) {
			list = (List<EmployeeApplication>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeApplication employeeApplication : list) {
					if (employeeId != employeeApplication.getEmployeeId()) {
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

			sb.append(_SQL_SELECT_EMPLOYEEAPPLICATION_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeApplicationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				list = (List<EmployeeApplication>)QueryUtil.list(
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
	 * Returns the first employee application in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee application
	 * @throws NoSuchEmployeeApplicationException if a matching employee application could not be found
	 */
	@Override
	public EmployeeApplication findByEmployeeId_First(
			long employeeId,
			OrderByComparator<EmployeeApplication> orderByComparator)
		throws NoSuchEmployeeApplicationException {

		EmployeeApplication employeeApplication = fetchByEmployeeId_First(
			employeeId, orderByComparator);

		if (employeeApplication != null) {
			return employeeApplication;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeeApplicationException(sb.toString());
	}

	/**
	 * Returns the first employee application in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee application, or <code>null</code> if a matching employee application could not be found
	 */
	@Override
	public EmployeeApplication fetchByEmployeeId_First(
		long employeeId,
		OrderByComparator<EmployeeApplication> orderByComparator) {

		List<EmployeeApplication> list = findByEmployeeId(
			employeeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee application in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee application
	 * @throws NoSuchEmployeeApplicationException if a matching employee application could not be found
	 */
	@Override
	public EmployeeApplication findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<EmployeeApplication> orderByComparator)
		throws NoSuchEmployeeApplicationException {

		EmployeeApplication employeeApplication = fetchByEmployeeId_Last(
			employeeId, orderByComparator);

		if (employeeApplication != null) {
			return employeeApplication;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeeApplicationException(sb.toString());
	}

	/**
	 * Returns the last employee application in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee application, or <code>null</code> if a matching employee application could not be found
	 */
	@Override
	public EmployeeApplication fetchByEmployeeId_Last(
		long employeeId,
		OrderByComparator<EmployeeApplication> orderByComparator) {

		int count = countByEmployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<EmployeeApplication> list = findByEmployeeId(
			employeeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee applications before and after the current employee application in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeApplicationId the primary key of the current employee application
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee application
	 * @throws NoSuchEmployeeApplicationException if a employee application with the primary key could not be found
	 */
	@Override
	public EmployeeApplication[] findByEmployeeId_PrevAndNext(
			long employeeApplicationId, long employeeId,
			OrderByComparator<EmployeeApplication> orderByComparator)
		throws NoSuchEmployeeApplicationException {

		EmployeeApplication employeeApplication = findByPrimaryKey(
			employeeApplicationId);

		Session session = null;

		try {
			session = openSession();

			EmployeeApplication[] array = new EmployeeApplicationImpl[3];

			array[0] = getByEmployeeId_PrevAndNext(
				session, employeeApplication, employeeId, orderByComparator,
				true);

			array[1] = employeeApplication;

			array[2] = getByEmployeeId_PrevAndNext(
				session, employeeApplication, employeeId, orderByComparator,
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

	protected EmployeeApplication getByEmployeeId_PrevAndNext(
		Session session, EmployeeApplication employeeApplication,
		long employeeId,
		OrderByComparator<EmployeeApplication> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEAPPLICATION_WHERE);

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
			sb.append(EmployeeApplicationModelImpl.ORDER_BY_JPQL);
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
						employeeApplication)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeApplication> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee applications where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeByEmployeeId(long employeeId) {
		for (EmployeeApplication employeeApplication :
				findByEmployeeId(
					employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeeApplication);
		}
	}

	/**
	 * Returns the number of employee applications where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee applications
	 */
	@Override
	public int countByEmployeeId(long employeeId) {
		FinderPath finderPath = _finderPathCountByEmployeeId;

		Object[] finderArgs = new Object[] {employeeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEAPPLICATION_WHERE);

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
		"employeeApplication.employeeId = ?";

	public EmployeeApplicationPersistenceImpl() {
		setModelClass(EmployeeApplication.class);

		setModelImplClass(EmployeeApplicationImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the employee application in the entity cache if it is enabled.
	 *
	 * @param employeeApplication the employee application
	 */
	@Override
	public void cacheResult(EmployeeApplication employeeApplication) {
		entityCache.putResult(
			EmployeeApplicationImpl.class, employeeApplication.getPrimaryKey(),
			employeeApplication);
	}

	/**
	 * Caches the employee applications in the entity cache if it is enabled.
	 *
	 * @param employeeApplications the employee applications
	 */
	@Override
	public void cacheResult(List<EmployeeApplication> employeeApplications) {
		for (EmployeeApplication employeeApplication : employeeApplications) {
			if (entityCache.getResult(
					EmployeeApplicationImpl.class,
					employeeApplication.getPrimaryKey()) == null) {

				cacheResult(employeeApplication);
			}
		}
	}

	/**
	 * Clears the cache for all employee applications.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmployeeApplicationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the employee application.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmployeeApplication employeeApplication) {
		entityCache.removeResult(
			EmployeeApplicationImpl.class, employeeApplication);
	}

	@Override
	public void clearCache(List<EmployeeApplication> employeeApplications) {
		for (EmployeeApplication employeeApplication : employeeApplications) {
			entityCache.removeResult(
				EmployeeApplicationImpl.class, employeeApplication);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EmployeeApplicationImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new employee application with the primary key. Does not add the employee application to the database.
	 *
	 * @param employeeApplicationId the primary key for the new employee application
	 * @return the new employee application
	 */
	@Override
	public EmployeeApplication create(long employeeApplicationId) {
		EmployeeApplication employeeApplication = new EmployeeApplicationImpl();

		employeeApplication.setNew(true);
		employeeApplication.setPrimaryKey(employeeApplicationId);

		employeeApplication.setCompanyId(CompanyThreadLocal.getCompanyId());

		return employeeApplication;
	}

	/**
	 * Removes the employee application with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeApplicationId the primary key of the employee application
	 * @return the employee application that was removed
	 * @throws NoSuchEmployeeApplicationException if a employee application with the primary key could not be found
	 */
	@Override
	public EmployeeApplication remove(long employeeApplicationId)
		throws NoSuchEmployeeApplicationException {

		return remove((Serializable)employeeApplicationId);
	}

	/**
	 * Removes the employee application with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the employee application
	 * @return the employee application that was removed
	 * @throws NoSuchEmployeeApplicationException if a employee application with the primary key could not be found
	 */
	@Override
	public EmployeeApplication remove(Serializable primaryKey)
		throws NoSuchEmployeeApplicationException {

		Session session = null;

		try {
			session = openSession();

			EmployeeApplication employeeApplication =
				(EmployeeApplication)session.get(
					EmployeeApplicationImpl.class, primaryKey);

			if (employeeApplication == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmployeeApplicationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(employeeApplication);
		}
		catch (NoSuchEmployeeApplicationException noSuchEntityException) {
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
	protected EmployeeApplication removeImpl(
		EmployeeApplication employeeApplication) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(employeeApplication)) {
				employeeApplication = (EmployeeApplication)session.get(
					EmployeeApplicationImpl.class,
					employeeApplication.getPrimaryKeyObj());
			}

			if (employeeApplication != null) {
				session.delete(employeeApplication);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (employeeApplication != null) {
			clearCache(employeeApplication);
		}

		return employeeApplication;
	}

	@Override
	public EmployeeApplication updateImpl(
		EmployeeApplication employeeApplication) {

		boolean isNew = employeeApplication.isNew();

		if (!(employeeApplication instanceof EmployeeApplicationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(employeeApplication.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					employeeApplication);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in employeeApplication proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EmployeeApplication implementation " +
					employeeApplication.getClass());
		}

		EmployeeApplicationModelImpl employeeApplicationModelImpl =
			(EmployeeApplicationModelImpl)employeeApplication;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (employeeApplication.getCreateDate() == null)) {
			if (serviceContext == null) {
				employeeApplication.setCreateDate(now);
			}
			else {
				employeeApplication.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!employeeApplicationModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				employeeApplication.setModifiedDate(now);
			}
			else {
				employeeApplication.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(employeeApplication);
			}
			else {
				employeeApplication = (EmployeeApplication)session.merge(
					employeeApplication);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EmployeeApplicationImpl.class, employeeApplicationModelImpl, false,
			true);

		if (isNew) {
			employeeApplication.setNew(false);
		}

		employeeApplication.resetOriginalValues();

		return employeeApplication;
	}

	/**
	 * Returns the employee application with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee application
	 * @return the employee application
	 * @throws NoSuchEmployeeApplicationException if a employee application with the primary key could not be found
	 */
	@Override
	public EmployeeApplication findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmployeeApplicationException {

		EmployeeApplication employeeApplication = fetchByPrimaryKey(primaryKey);

		if (employeeApplication == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmployeeApplicationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return employeeApplication;
	}

	/**
	 * Returns the employee application with the primary key or throws a <code>NoSuchEmployeeApplicationException</code> if it could not be found.
	 *
	 * @param employeeApplicationId the primary key of the employee application
	 * @return the employee application
	 * @throws NoSuchEmployeeApplicationException if a employee application with the primary key could not be found
	 */
	@Override
	public EmployeeApplication findByPrimaryKey(long employeeApplicationId)
		throws NoSuchEmployeeApplicationException {

		return findByPrimaryKey((Serializable)employeeApplicationId);
	}

	/**
	 * Returns the employee application with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeApplicationId the primary key of the employee application
	 * @return the employee application, or <code>null</code> if a employee application with the primary key could not be found
	 */
	@Override
	public EmployeeApplication fetchByPrimaryKey(long employeeApplicationId) {
		return fetchByPrimaryKey((Serializable)employeeApplicationId);
	}

	/**
	 * Returns all the employee applications.
	 *
	 * @return the employee applications
	 */
	@Override
	public List<EmployeeApplication> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee applications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee applications
	 * @param end the upper bound of the range of employee applications (not inclusive)
	 * @return the range of employee applications
	 */
	@Override
	public List<EmployeeApplication> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee applications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee applications
	 * @param end the upper bound of the range of employee applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee applications
	 */
	@Override
	public List<EmployeeApplication> findAll(
		int start, int end,
		OrderByComparator<EmployeeApplication> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee applications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee applications
	 * @param end the upper bound of the range of employee applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee applications
	 */
	@Override
	public List<EmployeeApplication> findAll(
		int start, int end,
		OrderByComparator<EmployeeApplication> orderByComparator,
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

		List<EmployeeApplication> list = null;

		if (useFinderCache) {
			list = (List<EmployeeApplication>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EMPLOYEEAPPLICATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLOYEEAPPLICATION;

				sql = sql.concat(EmployeeApplicationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EmployeeApplication>)QueryUtil.list(
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
	 * Removes all the employee applications from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EmployeeApplication employeeApplication : findAll()) {
			remove(employeeApplication);
		}
	}

	/**
	 * Returns the number of employee applications.
	 *
	 * @return the number of employee applications
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
					_SQL_COUNT_EMPLOYEEAPPLICATION);

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
		return "employeeApplicationId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EMPLOYEEAPPLICATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EmployeeApplicationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the employee application persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new EmployeeApplicationModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", EmployeeApplication.class.getName()));

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
		entityCache.removeCache(EmployeeApplicationImpl.class.getName());

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

	private static final String _SQL_SELECT_EMPLOYEEAPPLICATION =
		"SELECT employeeApplication FROM EmployeeApplication employeeApplication";

	private static final String _SQL_SELECT_EMPLOYEEAPPLICATION_WHERE =
		"SELECT employeeApplication FROM EmployeeApplication employeeApplication WHERE ";

	private static final String _SQL_COUNT_EMPLOYEEAPPLICATION =
		"SELECT COUNT(employeeApplication) FROM EmployeeApplication employeeApplication";

	private static final String _SQL_COUNT_EMPLOYEEAPPLICATION_WHERE =
		"SELECT COUNT(employeeApplication) FROM EmployeeApplication employeeApplication WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "employeeApplication.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EmployeeApplication exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EmployeeApplication exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EmployeeApplicationPersistenceImpl.class);

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

	private static class EmployeeApplicationModelArgumentsResolver
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

			EmployeeApplicationModelImpl employeeApplicationModelImpl =
				(EmployeeApplicationModelImpl)baseModel;

			long columnBitmask =
				employeeApplicationModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					employeeApplicationModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						employeeApplicationModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					employeeApplicationModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			EmployeeApplicationModelImpl employeeApplicationModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						employeeApplicationModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = employeeApplicationModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}