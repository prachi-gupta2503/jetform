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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeBiodataException;
import com.adjecti.pis.liferay.model.EmployeeBiodata;
import com.adjecti.pis.liferay.model.impl.EmployeeBiodataImpl;
import com.adjecti.pis.liferay.model.impl.EmployeeBiodataModelImpl;
import com.adjecti.pis.liferay.service.persistence.EmployeeBiodataPersistence;
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
 * The persistence implementation for the employee biodata service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EmployeeBiodataPersistence.class)
public class EmployeeBiodataPersistenceImpl
	extends BasePersistenceImpl<EmployeeBiodata>
	implements EmployeeBiodataPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EmployeeBiodataUtil</code> to access the employee biodata persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EmployeeBiodataImpl.class.getName();

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
	 * Returns all the employee biodatas where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee biodatas
	 */
	@Override
	public List<EmployeeBiodata> findByEmployeeId(long employeeId) {
		return findByEmployeeId(
			employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee biodatas where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeBiodataModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee biodatas
	 * @param end the upper bound of the range of employee biodatas (not inclusive)
	 * @return the range of matching employee biodatas
	 */
	@Override
	public List<EmployeeBiodata> findByEmployeeId(
		long employeeId, int start, int end) {

		return findByEmployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee biodatas where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeBiodataModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee biodatas
	 * @param end the upper bound of the range of employee biodatas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee biodatas
	 */
	@Override
	public List<EmployeeBiodata> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeBiodata> orderByComparator) {

		return findByEmployeeId(
			employeeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee biodatas where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeBiodataModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee biodatas
	 * @param end the upper bound of the range of employee biodatas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee biodatas
	 */
	@Override
	public List<EmployeeBiodata> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeBiodata> orderByComparator,
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

		List<EmployeeBiodata> list = null;

		if (useFinderCache) {
			list = (List<EmployeeBiodata>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeBiodata employeeBiodata : list) {
					if (employeeId != employeeBiodata.getEmployeeId()) {
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

			sb.append(_SQL_SELECT_EMPLOYEEBIODATA_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeBiodataModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				list = (List<EmployeeBiodata>)QueryUtil.list(
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
	 * Returns the first employee biodata in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee biodata
	 * @throws NoSuchEmployeeBiodataException if a matching employee biodata could not be found
	 */
	@Override
	public EmployeeBiodata findByEmployeeId_First(
			long employeeId,
			OrderByComparator<EmployeeBiodata> orderByComparator)
		throws NoSuchEmployeeBiodataException {

		EmployeeBiodata employeeBiodata = fetchByEmployeeId_First(
			employeeId, orderByComparator);

		if (employeeBiodata != null) {
			return employeeBiodata;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeeBiodataException(sb.toString());
	}

	/**
	 * Returns the first employee biodata in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee biodata, or <code>null</code> if a matching employee biodata could not be found
	 */
	@Override
	public EmployeeBiodata fetchByEmployeeId_First(
		long employeeId, OrderByComparator<EmployeeBiodata> orderByComparator) {

		List<EmployeeBiodata> list = findByEmployeeId(
			employeeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee biodata in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee biodata
	 * @throws NoSuchEmployeeBiodataException if a matching employee biodata could not be found
	 */
	@Override
	public EmployeeBiodata findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<EmployeeBiodata> orderByComparator)
		throws NoSuchEmployeeBiodataException {

		EmployeeBiodata employeeBiodata = fetchByEmployeeId_Last(
			employeeId, orderByComparator);

		if (employeeBiodata != null) {
			return employeeBiodata;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeeBiodataException(sb.toString());
	}

	/**
	 * Returns the last employee biodata in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee biodata, or <code>null</code> if a matching employee biodata could not be found
	 */
	@Override
	public EmployeeBiodata fetchByEmployeeId_Last(
		long employeeId, OrderByComparator<EmployeeBiodata> orderByComparator) {

		int count = countByEmployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<EmployeeBiodata> list = findByEmployeeId(
			employeeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee biodatas before and after the current employee biodata in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeBiodataId the primary key of the current employee biodata
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee biodata
	 * @throws NoSuchEmployeeBiodataException if a employee biodata with the primary key could not be found
	 */
	@Override
	public EmployeeBiodata[] findByEmployeeId_PrevAndNext(
			long employeeBiodataId, long employeeId,
			OrderByComparator<EmployeeBiodata> orderByComparator)
		throws NoSuchEmployeeBiodataException {

		EmployeeBiodata employeeBiodata = findByPrimaryKey(employeeBiodataId);

		Session session = null;

		try {
			session = openSession();

			EmployeeBiodata[] array = new EmployeeBiodataImpl[3];

			array[0] = getByEmployeeId_PrevAndNext(
				session, employeeBiodata, employeeId, orderByComparator, true);

			array[1] = employeeBiodata;

			array[2] = getByEmployeeId_PrevAndNext(
				session, employeeBiodata, employeeId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EmployeeBiodata getByEmployeeId_PrevAndNext(
		Session session, EmployeeBiodata employeeBiodata, long employeeId,
		OrderByComparator<EmployeeBiodata> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEBIODATA_WHERE);

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
			sb.append(EmployeeBiodataModelImpl.ORDER_BY_JPQL);
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
						employeeBiodata)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeBiodata> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee biodatas where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeByEmployeeId(long employeeId) {
		for (EmployeeBiodata employeeBiodata :
				findByEmployeeId(
					employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeeBiodata);
		}
	}

	/**
	 * Returns the number of employee biodatas where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee biodatas
	 */
	@Override
	public int countByEmployeeId(long employeeId) {
		FinderPath finderPath = _finderPathCountByEmployeeId;

		Object[] finderArgs = new Object[] {employeeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEBIODATA_WHERE);

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
		"employeeBiodata.employeeId = ?";

	public EmployeeBiodataPersistenceImpl() {
		setModelClass(EmployeeBiodata.class);

		setModelImplClass(EmployeeBiodataImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the employee biodata in the entity cache if it is enabled.
	 *
	 * @param employeeBiodata the employee biodata
	 */
	@Override
	public void cacheResult(EmployeeBiodata employeeBiodata) {
		entityCache.putResult(
			EmployeeBiodataImpl.class, employeeBiodata.getPrimaryKey(),
			employeeBiodata);
	}

	/**
	 * Caches the employee biodatas in the entity cache if it is enabled.
	 *
	 * @param employeeBiodatas the employee biodatas
	 */
	@Override
	public void cacheResult(List<EmployeeBiodata> employeeBiodatas) {
		for (EmployeeBiodata employeeBiodata : employeeBiodatas) {
			if (entityCache.getResult(
					EmployeeBiodataImpl.class,
					employeeBiodata.getPrimaryKey()) == null) {

				cacheResult(employeeBiodata);
			}
		}
	}

	/**
	 * Clears the cache for all employee biodatas.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmployeeBiodataImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the employee biodata.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmployeeBiodata employeeBiodata) {
		entityCache.removeResult(EmployeeBiodataImpl.class, employeeBiodata);
	}

	@Override
	public void clearCache(List<EmployeeBiodata> employeeBiodatas) {
		for (EmployeeBiodata employeeBiodata : employeeBiodatas) {
			entityCache.removeResult(
				EmployeeBiodataImpl.class, employeeBiodata);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EmployeeBiodataImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new employee biodata with the primary key. Does not add the employee biodata to the database.
	 *
	 * @param employeeBiodataId the primary key for the new employee biodata
	 * @return the new employee biodata
	 */
	@Override
	public EmployeeBiodata create(long employeeBiodataId) {
		EmployeeBiodata employeeBiodata = new EmployeeBiodataImpl();

		employeeBiodata.setNew(true);
		employeeBiodata.setPrimaryKey(employeeBiodataId);

		employeeBiodata.setCompanyId(CompanyThreadLocal.getCompanyId());

		return employeeBiodata;
	}

	/**
	 * Removes the employee biodata with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeBiodataId the primary key of the employee biodata
	 * @return the employee biodata that was removed
	 * @throws NoSuchEmployeeBiodataException if a employee biodata with the primary key could not be found
	 */
	@Override
	public EmployeeBiodata remove(long employeeBiodataId)
		throws NoSuchEmployeeBiodataException {

		return remove((Serializable)employeeBiodataId);
	}

	/**
	 * Removes the employee biodata with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the employee biodata
	 * @return the employee biodata that was removed
	 * @throws NoSuchEmployeeBiodataException if a employee biodata with the primary key could not be found
	 */
	@Override
	public EmployeeBiodata remove(Serializable primaryKey)
		throws NoSuchEmployeeBiodataException {

		Session session = null;

		try {
			session = openSession();

			EmployeeBiodata employeeBiodata = (EmployeeBiodata)session.get(
				EmployeeBiodataImpl.class, primaryKey);

			if (employeeBiodata == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmployeeBiodataException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(employeeBiodata);
		}
		catch (NoSuchEmployeeBiodataException noSuchEntityException) {
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
	protected EmployeeBiodata removeImpl(EmployeeBiodata employeeBiodata) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(employeeBiodata)) {
				employeeBiodata = (EmployeeBiodata)session.get(
					EmployeeBiodataImpl.class,
					employeeBiodata.getPrimaryKeyObj());
			}

			if (employeeBiodata != null) {
				session.delete(employeeBiodata);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (employeeBiodata != null) {
			clearCache(employeeBiodata);
		}

		return employeeBiodata;
	}

	@Override
	public EmployeeBiodata updateImpl(EmployeeBiodata employeeBiodata) {
		boolean isNew = employeeBiodata.isNew();

		if (!(employeeBiodata instanceof EmployeeBiodataModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(employeeBiodata.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					employeeBiodata);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in employeeBiodata proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EmployeeBiodata implementation " +
					employeeBiodata.getClass());
		}

		EmployeeBiodataModelImpl employeeBiodataModelImpl =
			(EmployeeBiodataModelImpl)employeeBiodata;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (employeeBiodata.getCreateDate() == null)) {
			if (serviceContext == null) {
				employeeBiodata.setCreateDate(now);
			}
			else {
				employeeBiodata.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!employeeBiodataModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				employeeBiodata.setModifiedDate(now);
			}
			else {
				employeeBiodata.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(employeeBiodata);
			}
			else {
				employeeBiodata = (EmployeeBiodata)session.merge(
					employeeBiodata);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EmployeeBiodataImpl.class, employeeBiodataModelImpl, false, true);

		if (isNew) {
			employeeBiodata.setNew(false);
		}

		employeeBiodata.resetOriginalValues();

		return employeeBiodata;
	}

	/**
	 * Returns the employee biodata with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee biodata
	 * @return the employee biodata
	 * @throws NoSuchEmployeeBiodataException if a employee biodata with the primary key could not be found
	 */
	@Override
	public EmployeeBiodata findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmployeeBiodataException {

		EmployeeBiodata employeeBiodata = fetchByPrimaryKey(primaryKey);

		if (employeeBiodata == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmployeeBiodataException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return employeeBiodata;
	}

	/**
	 * Returns the employee biodata with the primary key or throws a <code>NoSuchEmployeeBiodataException</code> if it could not be found.
	 *
	 * @param employeeBiodataId the primary key of the employee biodata
	 * @return the employee biodata
	 * @throws NoSuchEmployeeBiodataException if a employee biodata with the primary key could not be found
	 */
	@Override
	public EmployeeBiodata findByPrimaryKey(long employeeBiodataId)
		throws NoSuchEmployeeBiodataException {

		return findByPrimaryKey((Serializable)employeeBiodataId);
	}

	/**
	 * Returns the employee biodata with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeBiodataId the primary key of the employee biodata
	 * @return the employee biodata, or <code>null</code> if a employee biodata with the primary key could not be found
	 */
	@Override
	public EmployeeBiodata fetchByPrimaryKey(long employeeBiodataId) {
		return fetchByPrimaryKey((Serializable)employeeBiodataId);
	}

	/**
	 * Returns all the employee biodatas.
	 *
	 * @return the employee biodatas
	 */
	@Override
	public List<EmployeeBiodata> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee biodatas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeBiodataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee biodatas
	 * @param end the upper bound of the range of employee biodatas (not inclusive)
	 * @return the range of employee biodatas
	 */
	@Override
	public List<EmployeeBiodata> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee biodatas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeBiodataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee biodatas
	 * @param end the upper bound of the range of employee biodatas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee biodatas
	 */
	@Override
	public List<EmployeeBiodata> findAll(
		int start, int end,
		OrderByComparator<EmployeeBiodata> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee biodatas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeBiodataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee biodatas
	 * @param end the upper bound of the range of employee biodatas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee biodatas
	 */
	@Override
	public List<EmployeeBiodata> findAll(
		int start, int end,
		OrderByComparator<EmployeeBiodata> orderByComparator,
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

		List<EmployeeBiodata> list = null;

		if (useFinderCache) {
			list = (List<EmployeeBiodata>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EMPLOYEEBIODATA);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLOYEEBIODATA;

				sql = sql.concat(EmployeeBiodataModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EmployeeBiodata>)QueryUtil.list(
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
	 * Removes all the employee biodatas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EmployeeBiodata employeeBiodata : findAll()) {
			remove(employeeBiodata);
		}
	}

	/**
	 * Returns the number of employee biodatas.
	 *
	 * @return the number of employee biodatas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_EMPLOYEEBIODATA);

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
		return "employeeBiodataId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EMPLOYEEBIODATA;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EmployeeBiodataModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the employee biodata persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new EmployeeBiodataModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", EmployeeBiodata.class.getName()));

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
		entityCache.removeCache(EmployeeBiodataImpl.class.getName());

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

	private static final String _SQL_SELECT_EMPLOYEEBIODATA =
		"SELECT employeeBiodata FROM EmployeeBiodata employeeBiodata";

	private static final String _SQL_SELECT_EMPLOYEEBIODATA_WHERE =
		"SELECT employeeBiodata FROM EmployeeBiodata employeeBiodata WHERE ";

	private static final String _SQL_COUNT_EMPLOYEEBIODATA =
		"SELECT COUNT(employeeBiodata) FROM EmployeeBiodata employeeBiodata";

	private static final String _SQL_COUNT_EMPLOYEEBIODATA_WHERE =
		"SELECT COUNT(employeeBiodata) FROM EmployeeBiodata employeeBiodata WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "employeeBiodata.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EmployeeBiodata exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EmployeeBiodata exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EmployeeBiodataPersistenceImpl.class);

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

	private static class EmployeeBiodataModelArgumentsResolver
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

			EmployeeBiodataModelImpl employeeBiodataModelImpl =
				(EmployeeBiodataModelImpl)baseModel;

			long columnBitmask = employeeBiodataModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					employeeBiodataModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						employeeBiodataModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					employeeBiodataModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			EmployeeBiodataModelImpl employeeBiodataModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						employeeBiodataModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = employeeBiodataModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}