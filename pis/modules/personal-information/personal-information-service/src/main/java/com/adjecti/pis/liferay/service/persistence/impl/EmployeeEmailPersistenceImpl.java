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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeEmailException;
import com.adjecti.pis.liferay.model.EmployeeEmail;
import com.adjecti.pis.liferay.model.impl.EmployeeEmailImpl;
import com.adjecti.pis.liferay.model.impl.EmployeeEmailModelImpl;
import com.adjecti.pis.liferay.service.persistence.EmployeeEmailPersistence;
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
 * The persistence implementation for the employee email service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EmployeeEmailPersistence.class)
public class EmployeeEmailPersistenceImpl
	extends BasePersistenceImpl<EmployeeEmail>
	implements EmployeeEmailPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EmployeeEmailUtil</code> to access the employee email persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EmployeeEmailImpl.class.getName();

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
	 * Returns all the employee emails where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee emails
	 */
	@Override
	public List<EmployeeEmail> findByEmployeeId(long employeeId) {
		return findByEmployeeId(
			employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee emails where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeEmailModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee emails
	 * @param end the upper bound of the range of employee emails (not inclusive)
	 * @return the range of matching employee emails
	 */
	@Override
	public List<EmployeeEmail> findByEmployeeId(
		long employeeId, int start, int end) {

		return findByEmployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee emails where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeEmailModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee emails
	 * @param end the upper bound of the range of employee emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee emails
	 */
	@Override
	public List<EmployeeEmail> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeEmail> orderByComparator) {

		return findByEmployeeId(
			employeeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee emails where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeEmailModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee emails
	 * @param end the upper bound of the range of employee emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee emails
	 */
	@Override
	public List<EmployeeEmail> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeEmail> orderByComparator,
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

		List<EmployeeEmail> list = null;

		if (useFinderCache) {
			list = (List<EmployeeEmail>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeEmail employeeEmail : list) {
					if (employeeId != employeeEmail.getEmployeeId()) {
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

			sb.append(_SQL_SELECT_EMPLOYEEEMAIL_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeEmailModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				list = (List<EmployeeEmail>)QueryUtil.list(
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
	 * Returns the first employee email in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee email
	 * @throws NoSuchEmployeeEmailException if a matching employee email could not be found
	 */
	@Override
	public EmployeeEmail findByEmployeeId_First(
			long employeeId, OrderByComparator<EmployeeEmail> orderByComparator)
		throws NoSuchEmployeeEmailException {

		EmployeeEmail employeeEmail = fetchByEmployeeId_First(
			employeeId, orderByComparator);

		if (employeeEmail != null) {
			return employeeEmail;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeeEmailException(sb.toString());
	}

	/**
	 * Returns the first employee email in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee email, or <code>null</code> if a matching employee email could not be found
	 */
	@Override
	public EmployeeEmail fetchByEmployeeId_First(
		long employeeId, OrderByComparator<EmployeeEmail> orderByComparator) {

		List<EmployeeEmail> list = findByEmployeeId(
			employeeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee email in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee email
	 * @throws NoSuchEmployeeEmailException if a matching employee email could not be found
	 */
	@Override
	public EmployeeEmail findByEmployeeId_Last(
			long employeeId, OrderByComparator<EmployeeEmail> orderByComparator)
		throws NoSuchEmployeeEmailException {

		EmployeeEmail employeeEmail = fetchByEmployeeId_Last(
			employeeId, orderByComparator);

		if (employeeEmail != null) {
			return employeeEmail;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeeEmailException(sb.toString());
	}

	/**
	 * Returns the last employee email in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee email, or <code>null</code> if a matching employee email could not be found
	 */
	@Override
	public EmployeeEmail fetchByEmployeeId_Last(
		long employeeId, OrderByComparator<EmployeeEmail> orderByComparator) {

		int count = countByEmployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<EmployeeEmail> list = findByEmployeeId(
			employeeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee emails before and after the current employee email in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeEmailId the primary key of the current employee email
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee email
	 * @throws NoSuchEmployeeEmailException if a employee email with the primary key could not be found
	 */
	@Override
	public EmployeeEmail[] findByEmployeeId_PrevAndNext(
			long employeeEmailId, long employeeId,
			OrderByComparator<EmployeeEmail> orderByComparator)
		throws NoSuchEmployeeEmailException {

		EmployeeEmail employeeEmail = findByPrimaryKey(employeeEmailId);

		Session session = null;

		try {
			session = openSession();

			EmployeeEmail[] array = new EmployeeEmailImpl[3];

			array[0] = getByEmployeeId_PrevAndNext(
				session, employeeEmail, employeeId, orderByComparator, true);

			array[1] = employeeEmail;

			array[2] = getByEmployeeId_PrevAndNext(
				session, employeeEmail, employeeId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EmployeeEmail getByEmployeeId_PrevAndNext(
		Session session, EmployeeEmail employeeEmail, long employeeId,
		OrderByComparator<EmployeeEmail> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_EMPLOYEEEMAIL_WHERE);

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
			sb.append(EmployeeEmailModelImpl.ORDER_BY_JPQL);
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
						employeeEmail)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeEmail> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee emails where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeByEmployeeId(long employeeId) {
		for (EmployeeEmail employeeEmail :
				findByEmployeeId(
					employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeeEmail);
		}
	}

	/**
	 * Returns the number of employee emails where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee emails
	 */
	@Override
	public int countByEmployeeId(long employeeId) {
		FinderPath finderPath = _finderPathCountByEmployeeId;

		Object[] finderArgs = new Object[] {employeeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEEMAIL_WHERE);

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
		"employeeEmail.employeeId = ?";

	public EmployeeEmailPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(EmployeeEmail.class);

		setModelImplClass(EmployeeEmailImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the employee email in the entity cache if it is enabled.
	 *
	 * @param employeeEmail the employee email
	 */
	@Override
	public void cacheResult(EmployeeEmail employeeEmail) {
		entityCache.putResult(
			EmployeeEmailImpl.class, employeeEmail.getPrimaryKey(),
			employeeEmail);
	}

	/**
	 * Caches the employee emails in the entity cache if it is enabled.
	 *
	 * @param employeeEmails the employee emails
	 */
	@Override
	public void cacheResult(List<EmployeeEmail> employeeEmails) {
		for (EmployeeEmail employeeEmail : employeeEmails) {
			if (entityCache.getResult(
					EmployeeEmailImpl.class, employeeEmail.getPrimaryKey()) ==
						null) {

				cacheResult(employeeEmail);
			}
		}
	}

	/**
	 * Clears the cache for all employee emails.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmployeeEmailImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the employee email.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmployeeEmail employeeEmail) {
		entityCache.removeResult(EmployeeEmailImpl.class, employeeEmail);
	}

	@Override
	public void clearCache(List<EmployeeEmail> employeeEmails) {
		for (EmployeeEmail employeeEmail : employeeEmails) {
			entityCache.removeResult(EmployeeEmailImpl.class, employeeEmail);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EmployeeEmailImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new employee email with the primary key. Does not add the employee email to the database.
	 *
	 * @param employeeEmailId the primary key for the new employee email
	 * @return the new employee email
	 */
	@Override
	public EmployeeEmail create(long employeeEmailId) {
		EmployeeEmail employeeEmail = new EmployeeEmailImpl();

		employeeEmail.setNew(true);
		employeeEmail.setPrimaryKey(employeeEmailId);

		employeeEmail.setCompanyId(CompanyThreadLocal.getCompanyId());

		return employeeEmail;
	}

	/**
	 * Removes the employee email with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeEmailId the primary key of the employee email
	 * @return the employee email that was removed
	 * @throws NoSuchEmployeeEmailException if a employee email with the primary key could not be found
	 */
	@Override
	public EmployeeEmail remove(long employeeEmailId)
		throws NoSuchEmployeeEmailException {

		return remove((Serializable)employeeEmailId);
	}

	/**
	 * Removes the employee email with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the employee email
	 * @return the employee email that was removed
	 * @throws NoSuchEmployeeEmailException if a employee email with the primary key could not be found
	 */
	@Override
	public EmployeeEmail remove(Serializable primaryKey)
		throws NoSuchEmployeeEmailException {

		Session session = null;

		try {
			session = openSession();

			EmployeeEmail employeeEmail = (EmployeeEmail)session.get(
				EmployeeEmailImpl.class, primaryKey);

			if (employeeEmail == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmployeeEmailException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(employeeEmail);
		}
		catch (NoSuchEmployeeEmailException noSuchEntityException) {
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
	protected EmployeeEmail removeImpl(EmployeeEmail employeeEmail) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(employeeEmail)) {
				employeeEmail = (EmployeeEmail)session.get(
					EmployeeEmailImpl.class, employeeEmail.getPrimaryKeyObj());
			}

			if (employeeEmail != null) {
				session.delete(employeeEmail);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (employeeEmail != null) {
			clearCache(employeeEmail);
		}

		return employeeEmail;
	}

	@Override
	public EmployeeEmail updateImpl(EmployeeEmail employeeEmail) {
		boolean isNew = employeeEmail.isNew();

		if (!(employeeEmail instanceof EmployeeEmailModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(employeeEmail.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					employeeEmail);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in employeeEmail proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EmployeeEmail implementation " +
					employeeEmail.getClass());
		}

		EmployeeEmailModelImpl employeeEmailModelImpl =
			(EmployeeEmailModelImpl)employeeEmail;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (employeeEmail.getCreateDate() == null)) {
			if (serviceContext == null) {
				employeeEmail.setCreateDate(now);
			}
			else {
				employeeEmail.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!employeeEmailModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				employeeEmail.setModifiedDate(now);
			}
			else {
				employeeEmail.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(employeeEmail);
			}
			else {
				employeeEmail = (EmployeeEmail)session.merge(employeeEmail);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EmployeeEmailImpl.class, employeeEmailModelImpl, false, true);

		if (isNew) {
			employeeEmail.setNew(false);
		}

		employeeEmail.resetOriginalValues();

		return employeeEmail;
	}

	/**
	 * Returns the employee email with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee email
	 * @return the employee email
	 * @throws NoSuchEmployeeEmailException if a employee email with the primary key could not be found
	 */
	@Override
	public EmployeeEmail findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmployeeEmailException {

		EmployeeEmail employeeEmail = fetchByPrimaryKey(primaryKey);

		if (employeeEmail == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmployeeEmailException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return employeeEmail;
	}

	/**
	 * Returns the employee email with the primary key or throws a <code>NoSuchEmployeeEmailException</code> if it could not be found.
	 *
	 * @param employeeEmailId the primary key of the employee email
	 * @return the employee email
	 * @throws NoSuchEmployeeEmailException if a employee email with the primary key could not be found
	 */
	@Override
	public EmployeeEmail findByPrimaryKey(long employeeEmailId)
		throws NoSuchEmployeeEmailException {

		return findByPrimaryKey((Serializable)employeeEmailId);
	}

	/**
	 * Returns the employee email with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeEmailId the primary key of the employee email
	 * @return the employee email, or <code>null</code> if a employee email with the primary key could not be found
	 */
	@Override
	public EmployeeEmail fetchByPrimaryKey(long employeeEmailId) {
		return fetchByPrimaryKey((Serializable)employeeEmailId);
	}

	/**
	 * Returns all the employee emails.
	 *
	 * @return the employee emails
	 */
	@Override
	public List<EmployeeEmail> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee emails.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeEmailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee emails
	 * @param end the upper bound of the range of employee emails (not inclusive)
	 * @return the range of employee emails
	 */
	@Override
	public List<EmployeeEmail> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee emails.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeEmailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee emails
	 * @param end the upper bound of the range of employee emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee emails
	 */
	@Override
	public List<EmployeeEmail> findAll(
		int start, int end,
		OrderByComparator<EmployeeEmail> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee emails.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeEmailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee emails
	 * @param end the upper bound of the range of employee emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee emails
	 */
	@Override
	public List<EmployeeEmail> findAll(
		int start, int end, OrderByComparator<EmployeeEmail> orderByComparator,
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

		List<EmployeeEmail> list = null;

		if (useFinderCache) {
			list = (List<EmployeeEmail>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EMPLOYEEEMAIL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLOYEEEMAIL;

				sql = sql.concat(EmployeeEmailModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EmployeeEmail>)QueryUtil.list(
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
	 * Removes all the employee emails from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EmployeeEmail employeeEmail : findAll()) {
			remove(employeeEmail);
		}
	}

	/**
	 * Returns the number of employee emails.
	 *
	 * @return the number of employee emails
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_EMPLOYEEEMAIL);

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
		return "employeeEmailId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EMPLOYEEEMAIL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EmployeeEmailModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the employee email persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new EmployeeEmailModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", EmployeeEmail.class.getName()));

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
		entityCache.removeCache(EmployeeEmailImpl.class.getName());

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

	private static final String _SQL_SELECT_EMPLOYEEEMAIL =
		"SELECT employeeEmail FROM EmployeeEmail employeeEmail";

	private static final String _SQL_SELECT_EMPLOYEEEMAIL_WHERE =
		"SELECT employeeEmail FROM EmployeeEmail employeeEmail WHERE ";

	private static final String _SQL_COUNT_EMPLOYEEEMAIL =
		"SELECT COUNT(employeeEmail) FROM EmployeeEmail employeeEmail";

	private static final String _SQL_COUNT_EMPLOYEEEMAIL_WHERE =
		"SELECT COUNT(employeeEmail) FROM EmployeeEmail employeeEmail WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "employeeEmail.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EmployeeEmail exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EmployeeEmail exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EmployeeEmailPersistenceImpl.class);

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

	private static class EmployeeEmailModelArgumentsResolver
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

			EmployeeEmailModelImpl employeeEmailModelImpl =
				(EmployeeEmailModelImpl)baseModel;

			long columnBitmask = employeeEmailModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(employeeEmailModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						employeeEmailModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(employeeEmailModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			EmployeeEmailModelImpl employeeEmailModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						employeeEmailModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = employeeEmailModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}