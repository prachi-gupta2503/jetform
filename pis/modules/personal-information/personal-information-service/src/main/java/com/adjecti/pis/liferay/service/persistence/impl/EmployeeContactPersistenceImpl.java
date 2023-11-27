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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeContactException;
import com.adjecti.pis.liferay.model.EmployeeContact;
import com.adjecti.pis.liferay.model.impl.EmployeeContactImpl;
import com.adjecti.pis.liferay.model.impl.EmployeeContactModelImpl;
import com.adjecti.pis.liferay.service.persistence.EmployeeContactPersistence;
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
 * The persistence implementation for the employee contact service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EmployeeContactPersistence.class)
public class EmployeeContactPersistenceImpl
	extends BasePersistenceImpl<EmployeeContact>
	implements EmployeeContactPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EmployeeContactUtil</code> to access the employee contact persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EmployeeContactImpl.class.getName();

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
	 * Returns all the employee contacts where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee contacts
	 */
	@Override
	public List<EmployeeContact> findByEmployeeId(long employeeId) {
		return findByEmployeeId(
			employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee contacts where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeContactModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee contacts
	 * @param end the upper bound of the range of employee contacts (not inclusive)
	 * @return the range of matching employee contacts
	 */
	@Override
	public List<EmployeeContact> findByEmployeeId(
		long employeeId, int start, int end) {

		return findByEmployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee contacts where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeContactModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee contacts
	 * @param end the upper bound of the range of employee contacts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee contacts
	 */
	@Override
	public List<EmployeeContact> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeContact> orderByComparator) {

		return findByEmployeeId(
			employeeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee contacts where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeContactModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee contacts
	 * @param end the upper bound of the range of employee contacts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee contacts
	 */
	@Override
	public List<EmployeeContact> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeContact> orderByComparator,
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

		List<EmployeeContact> list = null;

		if (useFinderCache) {
			list = (List<EmployeeContact>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeContact employeeContact : list) {
					if (employeeId != employeeContact.getEmployeeId()) {
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

			sb.append(_SQL_SELECT_EMPLOYEECONTACT_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeContactModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				list = (List<EmployeeContact>)QueryUtil.list(
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
	 * Returns the first employee contact in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee contact
	 * @throws NoSuchEmployeeContactException if a matching employee contact could not be found
	 */
	@Override
	public EmployeeContact findByEmployeeId_First(
			long employeeId,
			OrderByComparator<EmployeeContact> orderByComparator)
		throws NoSuchEmployeeContactException {

		EmployeeContact employeeContact = fetchByEmployeeId_First(
			employeeId, orderByComparator);

		if (employeeContact != null) {
			return employeeContact;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeeContactException(sb.toString());
	}

	/**
	 * Returns the first employee contact in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee contact, or <code>null</code> if a matching employee contact could not be found
	 */
	@Override
	public EmployeeContact fetchByEmployeeId_First(
		long employeeId, OrderByComparator<EmployeeContact> orderByComparator) {

		List<EmployeeContact> list = findByEmployeeId(
			employeeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee contact in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee contact
	 * @throws NoSuchEmployeeContactException if a matching employee contact could not be found
	 */
	@Override
	public EmployeeContact findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<EmployeeContact> orderByComparator)
		throws NoSuchEmployeeContactException {

		EmployeeContact employeeContact = fetchByEmployeeId_Last(
			employeeId, orderByComparator);

		if (employeeContact != null) {
			return employeeContact;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeeContactException(sb.toString());
	}

	/**
	 * Returns the last employee contact in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee contact, or <code>null</code> if a matching employee contact could not be found
	 */
	@Override
	public EmployeeContact fetchByEmployeeId_Last(
		long employeeId, OrderByComparator<EmployeeContact> orderByComparator) {

		int count = countByEmployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<EmployeeContact> list = findByEmployeeId(
			employeeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee contacts before and after the current employee contact in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeContactId the primary key of the current employee contact
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee contact
	 * @throws NoSuchEmployeeContactException if a employee contact with the primary key could not be found
	 */
	@Override
	public EmployeeContact[] findByEmployeeId_PrevAndNext(
			long employeeContactId, long employeeId,
			OrderByComparator<EmployeeContact> orderByComparator)
		throws NoSuchEmployeeContactException {

		EmployeeContact employeeContact = findByPrimaryKey(employeeContactId);

		Session session = null;

		try {
			session = openSession();

			EmployeeContact[] array = new EmployeeContactImpl[3];

			array[0] = getByEmployeeId_PrevAndNext(
				session, employeeContact, employeeId, orderByComparator, true);

			array[1] = employeeContact;

			array[2] = getByEmployeeId_PrevAndNext(
				session, employeeContact, employeeId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EmployeeContact getByEmployeeId_PrevAndNext(
		Session session, EmployeeContact employeeContact, long employeeId,
		OrderByComparator<EmployeeContact> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEECONTACT_WHERE);

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
			sb.append(EmployeeContactModelImpl.ORDER_BY_JPQL);
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
						employeeContact)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeContact> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee contacts where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeByEmployeeId(long employeeId) {
		for (EmployeeContact employeeContact :
				findByEmployeeId(
					employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeeContact);
		}
	}

	/**
	 * Returns the number of employee contacts where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee contacts
	 */
	@Override
	public int countByEmployeeId(long employeeId) {
		FinderPath finderPath = _finderPathCountByEmployeeId;

		Object[] finderArgs = new Object[] {employeeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEECONTACT_WHERE);

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
		"employeeContact.employeeId = ?";

	public EmployeeContactPersistenceImpl() {
		setModelClass(EmployeeContact.class);

		setModelImplClass(EmployeeContactImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the employee contact in the entity cache if it is enabled.
	 *
	 * @param employeeContact the employee contact
	 */
	@Override
	public void cacheResult(EmployeeContact employeeContact) {
		entityCache.putResult(
			EmployeeContactImpl.class, employeeContact.getPrimaryKey(),
			employeeContact);
	}

	/**
	 * Caches the employee contacts in the entity cache if it is enabled.
	 *
	 * @param employeeContacts the employee contacts
	 */
	@Override
	public void cacheResult(List<EmployeeContact> employeeContacts) {
		for (EmployeeContact employeeContact : employeeContacts) {
			if (entityCache.getResult(
					EmployeeContactImpl.class,
					employeeContact.getPrimaryKey()) == null) {

				cacheResult(employeeContact);
			}
		}
	}

	/**
	 * Clears the cache for all employee contacts.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmployeeContactImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the employee contact.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmployeeContact employeeContact) {
		entityCache.removeResult(EmployeeContactImpl.class, employeeContact);
	}

	@Override
	public void clearCache(List<EmployeeContact> employeeContacts) {
		for (EmployeeContact employeeContact : employeeContacts) {
			entityCache.removeResult(
				EmployeeContactImpl.class, employeeContact);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EmployeeContactImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new employee contact with the primary key. Does not add the employee contact to the database.
	 *
	 * @param employeeContactId the primary key for the new employee contact
	 * @return the new employee contact
	 */
	@Override
	public EmployeeContact create(long employeeContactId) {
		EmployeeContact employeeContact = new EmployeeContactImpl();

		employeeContact.setNew(true);
		employeeContact.setPrimaryKey(employeeContactId);

		employeeContact.setCompanyId(CompanyThreadLocal.getCompanyId());

		return employeeContact;
	}

	/**
	 * Removes the employee contact with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeContactId the primary key of the employee contact
	 * @return the employee contact that was removed
	 * @throws NoSuchEmployeeContactException if a employee contact with the primary key could not be found
	 */
	@Override
	public EmployeeContact remove(long employeeContactId)
		throws NoSuchEmployeeContactException {

		return remove((Serializable)employeeContactId);
	}

	/**
	 * Removes the employee contact with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the employee contact
	 * @return the employee contact that was removed
	 * @throws NoSuchEmployeeContactException if a employee contact with the primary key could not be found
	 */
	@Override
	public EmployeeContact remove(Serializable primaryKey)
		throws NoSuchEmployeeContactException {

		Session session = null;

		try {
			session = openSession();

			EmployeeContact employeeContact = (EmployeeContact)session.get(
				EmployeeContactImpl.class, primaryKey);

			if (employeeContact == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmployeeContactException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(employeeContact);
		}
		catch (NoSuchEmployeeContactException noSuchEntityException) {
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
	protected EmployeeContact removeImpl(EmployeeContact employeeContact) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(employeeContact)) {
				employeeContact = (EmployeeContact)session.get(
					EmployeeContactImpl.class,
					employeeContact.getPrimaryKeyObj());
			}

			if (employeeContact != null) {
				session.delete(employeeContact);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (employeeContact != null) {
			clearCache(employeeContact);
		}

		return employeeContact;
	}

	@Override
	public EmployeeContact updateImpl(EmployeeContact employeeContact) {
		boolean isNew = employeeContact.isNew();

		if (!(employeeContact instanceof EmployeeContactModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(employeeContact.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					employeeContact);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in employeeContact proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EmployeeContact implementation " +
					employeeContact.getClass());
		}

		EmployeeContactModelImpl employeeContactModelImpl =
			(EmployeeContactModelImpl)employeeContact;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (employeeContact.getCreateDate() == null)) {
			if (serviceContext == null) {
				employeeContact.setCreateDate(now);
			}
			else {
				employeeContact.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!employeeContactModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				employeeContact.setModifiedDate(now);
			}
			else {
				employeeContact.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(employeeContact);
			}
			else {
				employeeContact = (EmployeeContact)session.merge(
					employeeContact);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EmployeeContactImpl.class, employeeContactModelImpl, false, true);

		if (isNew) {
			employeeContact.setNew(false);
		}

		employeeContact.resetOriginalValues();

		return employeeContact;
	}

	/**
	 * Returns the employee contact with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee contact
	 * @return the employee contact
	 * @throws NoSuchEmployeeContactException if a employee contact with the primary key could not be found
	 */
	@Override
	public EmployeeContact findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmployeeContactException {

		EmployeeContact employeeContact = fetchByPrimaryKey(primaryKey);

		if (employeeContact == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmployeeContactException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return employeeContact;
	}

	/**
	 * Returns the employee contact with the primary key or throws a <code>NoSuchEmployeeContactException</code> if it could not be found.
	 *
	 * @param employeeContactId the primary key of the employee contact
	 * @return the employee contact
	 * @throws NoSuchEmployeeContactException if a employee contact with the primary key could not be found
	 */
	@Override
	public EmployeeContact findByPrimaryKey(long employeeContactId)
		throws NoSuchEmployeeContactException {

		return findByPrimaryKey((Serializable)employeeContactId);
	}

	/**
	 * Returns the employee contact with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeContactId the primary key of the employee contact
	 * @return the employee contact, or <code>null</code> if a employee contact with the primary key could not be found
	 */
	@Override
	public EmployeeContact fetchByPrimaryKey(long employeeContactId) {
		return fetchByPrimaryKey((Serializable)employeeContactId);
	}

	/**
	 * Returns all the employee contacts.
	 *
	 * @return the employee contacts
	 */
	@Override
	public List<EmployeeContact> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee contacts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeContactModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee contacts
	 * @param end the upper bound of the range of employee contacts (not inclusive)
	 * @return the range of employee contacts
	 */
	@Override
	public List<EmployeeContact> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee contacts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeContactModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee contacts
	 * @param end the upper bound of the range of employee contacts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee contacts
	 */
	@Override
	public List<EmployeeContact> findAll(
		int start, int end,
		OrderByComparator<EmployeeContact> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee contacts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeContactModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee contacts
	 * @param end the upper bound of the range of employee contacts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee contacts
	 */
	@Override
	public List<EmployeeContact> findAll(
		int start, int end,
		OrderByComparator<EmployeeContact> orderByComparator,
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

		List<EmployeeContact> list = null;

		if (useFinderCache) {
			list = (List<EmployeeContact>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EMPLOYEECONTACT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLOYEECONTACT;

				sql = sql.concat(EmployeeContactModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EmployeeContact>)QueryUtil.list(
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
	 * Removes all the employee contacts from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EmployeeContact employeeContact : findAll()) {
			remove(employeeContact);
		}
	}

	/**
	 * Returns the number of employee contacts.
	 *
	 * @return the number of employee contacts
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_EMPLOYEECONTACT);

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
		return "employeeContactId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EMPLOYEECONTACT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EmployeeContactModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the employee contact persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new EmployeeContactModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", EmployeeContact.class.getName()));

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
		entityCache.removeCache(EmployeeContactImpl.class.getName());

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

	private static final String _SQL_SELECT_EMPLOYEECONTACT =
		"SELECT employeeContact FROM EmployeeContact employeeContact";

	private static final String _SQL_SELECT_EMPLOYEECONTACT_WHERE =
		"SELECT employeeContact FROM EmployeeContact employeeContact WHERE ";

	private static final String _SQL_COUNT_EMPLOYEECONTACT =
		"SELECT COUNT(employeeContact) FROM EmployeeContact employeeContact";

	private static final String _SQL_COUNT_EMPLOYEECONTACT_WHERE =
		"SELECT COUNT(employeeContact) FROM EmployeeContact employeeContact WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "employeeContact.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EmployeeContact exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EmployeeContact exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EmployeeContactPersistenceImpl.class);

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

	private static class EmployeeContactModelArgumentsResolver
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

			EmployeeContactModelImpl employeeContactModelImpl =
				(EmployeeContactModelImpl)baseModel;

			long columnBitmask = employeeContactModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					employeeContactModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						employeeContactModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					employeeContactModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			EmployeeContactModelImpl employeeContactModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						employeeContactModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = employeeContactModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}