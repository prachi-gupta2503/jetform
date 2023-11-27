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

import com.adjecti.pis.liferay.exception.NoSuchEmployeePayStructureException;
import com.adjecti.pis.liferay.model.EmployeePayStructure;
import com.adjecti.pis.liferay.model.impl.EmployeePayStructureImpl;
import com.adjecti.pis.liferay.model.impl.EmployeePayStructureModelImpl;
import com.adjecti.pis.liferay.service.persistence.EmployeePayStructurePersistence;
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
 * The persistence implementation for the employee pay structure service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EmployeePayStructurePersistence.class)
public class EmployeePayStructurePersistenceImpl
	extends BasePersistenceImpl<EmployeePayStructure>
	implements EmployeePayStructurePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EmployeePayStructureUtil</code> to access the employee pay structure persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EmployeePayStructureImpl.class.getName();

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
	 * Returns all the employee pay structures where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee pay structures
	 */
	@Override
	public List<EmployeePayStructure> findByEmployeeId(long employeeId) {
		return findByEmployeeId(
			employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee pay structures where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePayStructureModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee pay structures
	 * @param end the upper bound of the range of employee pay structures (not inclusive)
	 * @return the range of matching employee pay structures
	 */
	@Override
	public List<EmployeePayStructure> findByEmployeeId(
		long employeeId, int start, int end) {

		return findByEmployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee pay structures where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePayStructureModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee pay structures
	 * @param end the upper bound of the range of employee pay structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee pay structures
	 */
	@Override
	public List<EmployeePayStructure> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeePayStructure> orderByComparator) {

		return findByEmployeeId(
			employeeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee pay structures where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePayStructureModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee pay structures
	 * @param end the upper bound of the range of employee pay structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee pay structures
	 */
	@Override
	public List<EmployeePayStructure> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeePayStructure> orderByComparator,
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

		List<EmployeePayStructure> list = null;

		if (useFinderCache) {
			list = (List<EmployeePayStructure>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeePayStructure employeePayStructure : list) {
					if (employeeId != employeePayStructure.getEmployeeId()) {
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

			sb.append(_SQL_SELECT_EMPLOYEEPAYSTRUCTURE_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeePayStructureModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				list = (List<EmployeePayStructure>)QueryUtil.list(
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
	 * Returns the first employee pay structure in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee pay structure
	 * @throws NoSuchEmployeePayStructureException if a matching employee pay structure could not be found
	 */
	@Override
	public EmployeePayStructure findByEmployeeId_First(
			long employeeId,
			OrderByComparator<EmployeePayStructure> orderByComparator)
		throws NoSuchEmployeePayStructureException {

		EmployeePayStructure employeePayStructure = fetchByEmployeeId_First(
			employeeId, orderByComparator);

		if (employeePayStructure != null) {
			return employeePayStructure;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeePayStructureException(sb.toString());
	}

	/**
	 * Returns the first employee pay structure in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee pay structure, or <code>null</code> if a matching employee pay structure could not be found
	 */
	@Override
	public EmployeePayStructure fetchByEmployeeId_First(
		long employeeId,
		OrderByComparator<EmployeePayStructure> orderByComparator) {

		List<EmployeePayStructure> list = findByEmployeeId(
			employeeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee pay structure in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee pay structure
	 * @throws NoSuchEmployeePayStructureException if a matching employee pay structure could not be found
	 */
	@Override
	public EmployeePayStructure findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<EmployeePayStructure> orderByComparator)
		throws NoSuchEmployeePayStructureException {

		EmployeePayStructure employeePayStructure = fetchByEmployeeId_Last(
			employeeId, orderByComparator);

		if (employeePayStructure != null) {
			return employeePayStructure;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeePayStructureException(sb.toString());
	}

	/**
	 * Returns the last employee pay structure in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee pay structure, or <code>null</code> if a matching employee pay structure could not be found
	 */
	@Override
	public EmployeePayStructure fetchByEmployeeId_Last(
		long employeeId,
		OrderByComparator<EmployeePayStructure> orderByComparator) {

		int count = countByEmployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<EmployeePayStructure> list = findByEmployeeId(
			employeeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee pay structures before and after the current employee pay structure in the ordered set where employeeId = &#63;.
	 *
	 * @param employeePayStructureId the primary key of the current employee pay structure
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee pay structure
	 * @throws NoSuchEmployeePayStructureException if a employee pay structure with the primary key could not be found
	 */
	@Override
	public EmployeePayStructure[] findByEmployeeId_PrevAndNext(
			long employeePayStructureId, long employeeId,
			OrderByComparator<EmployeePayStructure> orderByComparator)
		throws NoSuchEmployeePayStructureException {

		EmployeePayStructure employeePayStructure = findByPrimaryKey(
			employeePayStructureId);

		Session session = null;

		try {
			session = openSession();

			EmployeePayStructure[] array = new EmployeePayStructureImpl[3];

			array[0] = getByEmployeeId_PrevAndNext(
				session, employeePayStructure, employeeId, orderByComparator,
				true);

			array[1] = employeePayStructure;

			array[2] = getByEmployeeId_PrevAndNext(
				session, employeePayStructure, employeeId, orderByComparator,
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

	protected EmployeePayStructure getByEmployeeId_PrevAndNext(
		Session session, EmployeePayStructure employeePayStructure,
		long employeeId,
		OrderByComparator<EmployeePayStructure> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEPAYSTRUCTURE_WHERE);

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
			sb.append(EmployeePayStructureModelImpl.ORDER_BY_JPQL);
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
						employeePayStructure)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeePayStructure> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee pay structures where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeByEmployeeId(long employeeId) {
		for (EmployeePayStructure employeePayStructure :
				findByEmployeeId(
					employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeePayStructure);
		}
	}

	/**
	 * Returns the number of employee pay structures where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee pay structures
	 */
	@Override
	public int countByEmployeeId(long employeeId) {
		FinderPath finderPath = _finderPathCountByEmployeeId;

		Object[] finderArgs = new Object[] {employeeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEPAYSTRUCTURE_WHERE);

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
		"employeePayStructure.employeeId = ?";

	public EmployeePayStructurePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(EmployeePayStructure.class);

		setModelImplClass(EmployeePayStructureImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the employee pay structure in the entity cache if it is enabled.
	 *
	 * @param employeePayStructure the employee pay structure
	 */
	@Override
	public void cacheResult(EmployeePayStructure employeePayStructure) {
		entityCache.putResult(
			EmployeePayStructureImpl.class,
			employeePayStructure.getPrimaryKey(), employeePayStructure);
	}

	/**
	 * Caches the employee pay structures in the entity cache if it is enabled.
	 *
	 * @param employeePayStructures the employee pay structures
	 */
	@Override
	public void cacheResult(List<EmployeePayStructure> employeePayStructures) {
		for (EmployeePayStructure employeePayStructure :
				employeePayStructures) {

			if (entityCache.getResult(
					EmployeePayStructureImpl.class,
					employeePayStructure.getPrimaryKey()) == null) {

				cacheResult(employeePayStructure);
			}
		}
	}

	/**
	 * Clears the cache for all employee pay structures.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmployeePayStructureImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the employee pay structure.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmployeePayStructure employeePayStructure) {
		entityCache.removeResult(
			EmployeePayStructureImpl.class, employeePayStructure);
	}

	@Override
	public void clearCache(List<EmployeePayStructure> employeePayStructures) {
		for (EmployeePayStructure employeePayStructure :
				employeePayStructures) {

			entityCache.removeResult(
				EmployeePayStructureImpl.class, employeePayStructure);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				EmployeePayStructureImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new employee pay structure with the primary key. Does not add the employee pay structure to the database.
	 *
	 * @param employeePayStructureId the primary key for the new employee pay structure
	 * @return the new employee pay structure
	 */
	@Override
	public EmployeePayStructure create(long employeePayStructureId) {
		EmployeePayStructure employeePayStructure =
			new EmployeePayStructureImpl();

		employeePayStructure.setNew(true);
		employeePayStructure.setPrimaryKey(employeePayStructureId);

		employeePayStructure.setCompanyId(CompanyThreadLocal.getCompanyId());

		return employeePayStructure;
	}

	/**
	 * Removes the employee pay structure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeePayStructureId the primary key of the employee pay structure
	 * @return the employee pay structure that was removed
	 * @throws NoSuchEmployeePayStructureException if a employee pay structure with the primary key could not be found
	 */
	@Override
	public EmployeePayStructure remove(long employeePayStructureId)
		throws NoSuchEmployeePayStructureException {

		return remove((Serializable)employeePayStructureId);
	}

	/**
	 * Removes the employee pay structure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the employee pay structure
	 * @return the employee pay structure that was removed
	 * @throws NoSuchEmployeePayStructureException if a employee pay structure with the primary key could not be found
	 */
	@Override
	public EmployeePayStructure remove(Serializable primaryKey)
		throws NoSuchEmployeePayStructureException {

		Session session = null;

		try {
			session = openSession();

			EmployeePayStructure employeePayStructure =
				(EmployeePayStructure)session.get(
					EmployeePayStructureImpl.class, primaryKey);

			if (employeePayStructure == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmployeePayStructureException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(employeePayStructure);
		}
		catch (NoSuchEmployeePayStructureException noSuchEntityException) {
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
	protected EmployeePayStructure removeImpl(
		EmployeePayStructure employeePayStructure) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(employeePayStructure)) {
				employeePayStructure = (EmployeePayStructure)session.get(
					EmployeePayStructureImpl.class,
					employeePayStructure.getPrimaryKeyObj());
			}

			if (employeePayStructure != null) {
				session.delete(employeePayStructure);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (employeePayStructure != null) {
			clearCache(employeePayStructure);
		}

		return employeePayStructure;
	}

	@Override
	public EmployeePayStructure updateImpl(
		EmployeePayStructure employeePayStructure) {

		boolean isNew = employeePayStructure.isNew();

		if (!(employeePayStructure instanceof EmployeePayStructureModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(employeePayStructure.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					employeePayStructure);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in employeePayStructure proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EmployeePayStructure implementation " +
					employeePayStructure.getClass());
		}

		EmployeePayStructureModelImpl employeePayStructureModelImpl =
			(EmployeePayStructureModelImpl)employeePayStructure;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (employeePayStructure.getCreateDate() == null)) {
			if (serviceContext == null) {
				employeePayStructure.setCreateDate(now);
			}
			else {
				employeePayStructure.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!employeePayStructureModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				employeePayStructure.setModifiedDate(now);
			}
			else {
				employeePayStructure.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(employeePayStructure);
			}
			else {
				employeePayStructure = (EmployeePayStructure)session.merge(
					employeePayStructure);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EmployeePayStructureImpl.class, employeePayStructureModelImpl,
			false, true);

		if (isNew) {
			employeePayStructure.setNew(false);
		}

		employeePayStructure.resetOriginalValues();

		return employeePayStructure;
	}

	/**
	 * Returns the employee pay structure with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee pay structure
	 * @return the employee pay structure
	 * @throws NoSuchEmployeePayStructureException if a employee pay structure with the primary key could not be found
	 */
	@Override
	public EmployeePayStructure findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmployeePayStructureException {

		EmployeePayStructure employeePayStructure = fetchByPrimaryKey(
			primaryKey);

		if (employeePayStructure == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmployeePayStructureException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return employeePayStructure;
	}

	/**
	 * Returns the employee pay structure with the primary key or throws a <code>NoSuchEmployeePayStructureException</code> if it could not be found.
	 *
	 * @param employeePayStructureId the primary key of the employee pay structure
	 * @return the employee pay structure
	 * @throws NoSuchEmployeePayStructureException if a employee pay structure with the primary key could not be found
	 */
	@Override
	public EmployeePayStructure findByPrimaryKey(long employeePayStructureId)
		throws NoSuchEmployeePayStructureException {

		return findByPrimaryKey((Serializable)employeePayStructureId);
	}

	/**
	 * Returns the employee pay structure with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeePayStructureId the primary key of the employee pay structure
	 * @return the employee pay structure, or <code>null</code> if a employee pay structure with the primary key could not be found
	 */
	@Override
	public EmployeePayStructure fetchByPrimaryKey(long employeePayStructureId) {
		return fetchByPrimaryKey((Serializable)employeePayStructureId);
	}

	/**
	 * Returns all the employee pay structures.
	 *
	 * @return the employee pay structures
	 */
	@Override
	public List<EmployeePayStructure> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee pay structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePayStructureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee pay structures
	 * @param end the upper bound of the range of employee pay structures (not inclusive)
	 * @return the range of employee pay structures
	 */
	@Override
	public List<EmployeePayStructure> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee pay structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePayStructureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee pay structures
	 * @param end the upper bound of the range of employee pay structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee pay structures
	 */
	@Override
	public List<EmployeePayStructure> findAll(
		int start, int end,
		OrderByComparator<EmployeePayStructure> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee pay structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePayStructureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee pay structures
	 * @param end the upper bound of the range of employee pay structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee pay structures
	 */
	@Override
	public List<EmployeePayStructure> findAll(
		int start, int end,
		OrderByComparator<EmployeePayStructure> orderByComparator,
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

		List<EmployeePayStructure> list = null;

		if (useFinderCache) {
			list = (List<EmployeePayStructure>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EMPLOYEEPAYSTRUCTURE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLOYEEPAYSTRUCTURE;

				sql = sql.concat(EmployeePayStructureModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EmployeePayStructure>)QueryUtil.list(
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
	 * Removes all the employee pay structures from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EmployeePayStructure employeePayStructure : findAll()) {
			remove(employeePayStructure);
		}
	}

	/**
	 * Returns the number of employee pay structures.
	 *
	 * @return the number of employee pay structures
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
					_SQL_COUNT_EMPLOYEEPAYSTRUCTURE);

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
		return "employeePayStructureId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EMPLOYEEPAYSTRUCTURE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EmployeePayStructureModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the employee pay structure persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new EmployeePayStructureModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", EmployeePayStructure.class.getName()));

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
		entityCache.removeCache(EmployeePayStructureImpl.class.getName());

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

	private static final String _SQL_SELECT_EMPLOYEEPAYSTRUCTURE =
		"SELECT employeePayStructure FROM EmployeePayStructure employeePayStructure";

	private static final String _SQL_SELECT_EMPLOYEEPAYSTRUCTURE_WHERE =
		"SELECT employeePayStructure FROM EmployeePayStructure employeePayStructure WHERE ";

	private static final String _SQL_COUNT_EMPLOYEEPAYSTRUCTURE =
		"SELECT COUNT(employeePayStructure) FROM EmployeePayStructure employeePayStructure";

	private static final String _SQL_COUNT_EMPLOYEEPAYSTRUCTURE_WHERE =
		"SELECT COUNT(employeePayStructure) FROM EmployeePayStructure employeePayStructure WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"employeePayStructure.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EmployeePayStructure exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EmployeePayStructure exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EmployeePayStructurePersistenceImpl.class);

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

	private static class EmployeePayStructureModelArgumentsResolver
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

			EmployeePayStructureModelImpl employeePayStructureModelImpl =
				(EmployeePayStructureModelImpl)baseModel;

			long columnBitmask =
				employeePayStructureModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					employeePayStructureModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						employeePayStructureModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					employeePayStructureModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			EmployeePayStructureModelImpl employeePayStructureModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						employeePayStructureModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = employeePayStructureModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}