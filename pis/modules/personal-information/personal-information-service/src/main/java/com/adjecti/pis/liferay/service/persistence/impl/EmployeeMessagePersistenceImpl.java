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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeMessageException;
import com.adjecti.pis.liferay.model.EmployeeMessage;
import com.adjecti.pis.liferay.model.impl.EmployeeMessageImpl;
import com.adjecti.pis.liferay.model.impl.EmployeeMessageModelImpl;
import com.adjecti.pis.liferay.service.persistence.EmployeeMessagePersistence;
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
 * The persistence implementation for the employee message service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EmployeeMessagePersistence.class)
public class EmployeeMessagePersistenceImpl
	extends BasePersistenceImpl<EmployeeMessage>
	implements EmployeeMessagePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EmployeeMessageUtil</code> to access the employee message persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EmployeeMessageImpl.class.getName();

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
	 * Returns all the employee messages where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee messages
	 */
	@Override
	public List<EmployeeMessage> findByEmployeeId(long employeeId) {
		return findByEmployeeId(
			employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee messages where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeMessageModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee messages
	 * @param end the upper bound of the range of employee messages (not inclusive)
	 * @return the range of matching employee messages
	 */
	@Override
	public List<EmployeeMessage> findByEmployeeId(
		long employeeId, int start, int end) {

		return findByEmployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee messages where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeMessageModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee messages
	 * @param end the upper bound of the range of employee messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee messages
	 */
	@Override
	public List<EmployeeMessage> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeMessage> orderByComparator) {

		return findByEmployeeId(
			employeeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee messages where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeMessageModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee messages
	 * @param end the upper bound of the range of employee messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee messages
	 */
	@Override
	public List<EmployeeMessage> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeMessage> orderByComparator,
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

		List<EmployeeMessage> list = null;

		if (useFinderCache) {
			list = (List<EmployeeMessage>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeMessage employeeMessage : list) {
					if (employeeId != employeeMessage.getEmployeeId()) {
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

			sb.append(_SQL_SELECT_EMPLOYEEMESSAGE_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeMessageModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				list = (List<EmployeeMessage>)QueryUtil.list(
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
	 * Returns the first employee message in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee message
	 * @throws NoSuchEmployeeMessageException if a matching employee message could not be found
	 */
	@Override
	public EmployeeMessage findByEmployeeId_First(
			long employeeId,
			OrderByComparator<EmployeeMessage> orderByComparator)
		throws NoSuchEmployeeMessageException {

		EmployeeMessage employeeMessage = fetchByEmployeeId_First(
			employeeId, orderByComparator);

		if (employeeMessage != null) {
			return employeeMessage;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeeMessageException(sb.toString());
	}

	/**
	 * Returns the first employee message in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee message, or <code>null</code> if a matching employee message could not be found
	 */
	@Override
	public EmployeeMessage fetchByEmployeeId_First(
		long employeeId, OrderByComparator<EmployeeMessage> orderByComparator) {

		List<EmployeeMessage> list = findByEmployeeId(
			employeeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee message in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee message
	 * @throws NoSuchEmployeeMessageException if a matching employee message could not be found
	 */
	@Override
	public EmployeeMessage findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<EmployeeMessage> orderByComparator)
		throws NoSuchEmployeeMessageException {

		EmployeeMessage employeeMessage = fetchByEmployeeId_Last(
			employeeId, orderByComparator);

		if (employeeMessage != null) {
			return employeeMessage;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeeMessageException(sb.toString());
	}

	/**
	 * Returns the last employee message in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee message, or <code>null</code> if a matching employee message could not be found
	 */
	@Override
	public EmployeeMessage fetchByEmployeeId_Last(
		long employeeId, OrderByComparator<EmployeeMessage> orderByComparator) {

		int count = countByEmployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<EmployeeMessage> list = findByEmployeeId(
			employeeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee messages before and after the current employee message in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeMessageId the primary key of the current employee message
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee message
	 * @throws NoSuchEmployeeMessageException if a employee message with the primary key could not be found
	 */
	@Override
	public EmployeeMessage[] findByEmployeeId_PrevAndNext(
			long employeeMessageId, long employeeId,
			OrderByComparator<EmployeeMessage> orderByComparator)
		throws NoSuchEmployeeMessageException {

		EmployeeMessage employeeMessage = findByPrimaryKey(employeeMessageId);

		Session session = null;

		try {
			session = openSession();

			EmployeeMessage[] array = new EmployeeMessageImpl[3];

			array[0] = getByEmployeeId_PrevAndNext(
				session, employeeMessage, employeeId, orderByComparator, true);

			array[1] = employeeMessage;

			array[2] = getByEmployeeId_PrevAndNext(
				session, employeeMessage, employeeId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EmployeeMessage getByEmployeeId_PrevAndNext(
		Session session, EmployeeMessage employeeMessage, long employeeId,
		OrderByComparator<EmployeeMessage> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEMESSAGE_WHERE);

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
			sb.append(EmployeeMessageModelImpl.ORDER_BY_JPQL);
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
						employeeMessage)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeMessage> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee messages where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeByEmployeeId(long employeeId) {
		for (EmployeeMessage employeeMessage :
				findByEmployeeId(
					employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeeMessage);
		}
	}

	/**
	 * Returns the number of employee messages where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee messages
	 */
	@Override
	public int countByEmployeeId(long employeeId) {
		FinderPath finderPath = _finderPathCountByEmployeeId;

		Object[] finderArgs = new Object[] {employeeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEMESSAGE_WHERE);

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
		"employeeMessage.employeeId = ?";

	public EmployeeMessagePersistenceImpl() {
		setModelClass(EmployeeMessage.class);

		setModelImplClass(EmployeeMessageImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the employee message in the entity cache if it is enabled.
	 *
	 * @param employeeMessage the employee message
	 */
	@Override
	public void cacheResult(EmployeeMessage employeeMessage) {
		entityCache.putResult(
			EmployeeMessageImpl.class, employeeMessage.getPrimaryKey(),
			employeeMessage);
	}

	/**
	 * Caches the employee messages in the entity cache if it is enabled.
	 *
	 * @param employeeMessages the employee messages
	 */
	@Override
	public void cacheResult(List<EmployeeMessage> employeeMessages) {
		for (EmployeeMessage employeeMessage : employeeMessages) {
			if (entityCache.getResult(
					EmployeeMessageImpl.class,
					employeeMessage.getPrimaryKey()) == null) {

				cacheResult(employeeMessage);
			}
		}
	}

	/**
	 * Clears the cache for all employee messages.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmployeeMessageImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the employee message.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmployeeMessage employeeMessage) {
		entityCache.removeResult(EmployeeMessageImpl.class, employeeMessage);
	}

	@Override
	public void clearCache(List<EmployeeMessage> employeeMessages) {
		for (EmployeeMessage employeeMessage : employeeMessages) {
			entityCache.removeResult(
				EmployeeMessageImpl.class, employeeMessage);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EmployeeMessageImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new employee message with the primary key. Does not add the employee message to the database.
	 *
	 * @param employeeMessageId the primary key for the new employee message
	 * @return the new employee message
	 */
	@Override
	public EmployeeMessage create(long employeeMessageId) {
		EmployeeMessage employeeMessage = new EmployeeMessageImpl();

		employeeMessage.setNew(true);
		employeeMessage.setPrimaryKey(employeeMessageId);

		employeeMessage.setCompanyId(CompanyThreadLocal.getCompanyId());

		return employeeMessage;
	}

	/**
	 * Removes the employee message with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeMessageId the primary key of the employee message
	 * @return the employee message that was removed
	 * @throws NoSuchEmployeeMessageException if a employee message with the primary key could not be found
	 */
	@Override
	public EmployeeMessage remove(long employeeMessageId)
		throws NoSuchEmployeeMessageException {

		return remove((Serializable)employeeMessageId);
	}

	/**
	 * Removes the employee message with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the employee message
	 * @return the employee message that was removed
	 * @throws NoSuchEmployeeMessageException if a employee message with the primary key could not be found
	 */
	@Override
	public EmployeeMessage remove(Serializable primaryKey)
		throws NoSuchEmployeeMessageException {

		Session session = null;

		try {
			session = openSession();

			EmployeeMessage employeeMessage = (EmployeeMessage)session.get(
				EmployeeMessageImpl.class, primaryKey);

			if (employeeMessage == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmployeeMessageException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(employeeMessage);
		}
		catch (NoSuchEmployeeMessageException noSuchEntityException) {
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
	protected EmployeeMessage removeImpl(EmployeeMessage employeeMessage) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(employeeMessage)) {
				employeeMessage = (EmployeeMessage)session.get(
					EmployeeMessageImpl.class,
					employeeMessage.getPrimaryKeyObj());
			}

			if (employeeMessage != null) {
				session.delete(employeeMessage);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (employeeMessage != null) {
			clearCache(employeeMessage);
		}

		return employeeMessage;
	}

	@Override
	public EmployeeMessage updateImpl(EmployeeMessage employeeMessage) {
		boolean isNew = employeeMessage.isNew();

		if (!(employeeMessage instanceof EmployeeMessageModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(employeeMessage.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					employeeMessage);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in employeeMessage proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EmployeeMessage implementation " +
					employeeMessage.getClass());
		}

		EmployeeMessageModelImpl employeeMessageModelImpl =
			(EmployeeMessageModelImpl)employeeMessage;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (employeeMessage.getCreateDate() == null)) {
			if (serviceContext == null) {
				employeeMessage.setCreateDate(now);
			}
			else {
				employeeMessage.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!employeeMessageModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				employeeMessage.setModifiedDate(now);
			}
			else {
				employeeMessage.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(employeeMessage);
			}
			else {
				employeeMessage = (EmployeeMessage)session.merge(
					employeeMessage);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EmployeeMessageImpl.class, employeeMessageModelImpl, false, true);

		if (isNew) {
			employeeMessage.setNew(false);
		}

		employeeMessage.resetOriginalValues();

		return employeeMessage;
	}

	/**
	 * Returns the employee message with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee message
	 * @return the employee message
	 * @throws NoSuchEmployeeMessageException if a employee message with the primary key could not be found
	 */
	@Override
	public EmployeeMessage findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmployeeMessageException {

		EmployeeMessage employeeMessage = fetchByPrimaryKey(primaryKey);

		if (employeeMessage == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmployeeMessageException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return employeeMessage;
	}

	/**
	 * Returns the employee message with the primary key or throws a <code>NoSuchEmployeeMessageException</code> if it could not be found.
	 *
	 * @param employeeMessageId the primary key of the employee message
	 * @return the employee message
	 * @throws NoSuchEmployeeMessageException if a employee message with the primary key could not be found
	 */
	@Override
	public EmployeeMessage findByPrimaryKey(long employeeMessageId)
		throws NoSuchEmployeeMessageException {

		return findByPrimaryKey((Serializable)employeeMessageId);
	}

	/**
	 * Returns the employee message with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeMessageId the primary key of the employee message
	 * @return the employee message, or <code>null</code> if a employee message with the primary key could not be found
	 */
	@Override
	public EmployeeMessage fetchByPrimaryKey(long employeeMessageId) {
		return fetchByPrimaryKey((Serializable)employeeMessageId);
	}

	/**
	 * Returns all the employee messages.
	 *
	 * @return the employee messages
	 */
	@Override
	public List<EmployeeMessage> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeMessageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee messages
	 * @param end the upper bound of the range of employee messages (not inclusive)
	 * @return the range of employee messages
	 */
	@Override
	public List<EmployeeMessage> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeMessageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee messages
	 * @param end the upper bound of the range of employee messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee messages
	 */
	@Override
	public List<EmployeeMessage> findAll(
		int start, int end,
		OrderByComparator<EmployeeMessage> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeMessageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee messages
	 * @param end the upper bound of the range of employee messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee messages
	 */
	@Override
	public List<EmployeeMessage> findAll(
		int start, int end,
		OrderByComparator<EmployeeMessage> orderByComparator,
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

		List<EmployeeMessage> list = null;

		if (useFinderCache) {
			list = (List<EmployeeMessage>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EMPLOYEEMESSAGE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLOYEEMESSAGE;

				sql = sql.concat(EmployeeMessageModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EmployeeMessage>)QueryUtil.list(
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
	 * Removes all the employee messages from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EmployeeMessage employeeMessage : findAll()) {
			remove(employeeMessage);
		}
	}

	/**
	 * Returns the number of employee messages.
	 *
	 * @return the number of employee messages
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_EMPLOYEEMESSAGE);

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
		return "employeeMessageId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EMPLOYEEMESSAGE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EmployeeMessageModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the employee message persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new EmployeeMessageModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", EmployeeMessage.class.getName()));

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
		entityCache.removeCache(EmployeeMessageImpl.class.getName());

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

	private static final String _SQL_SELECT_EMPLOYEEMESSAGE =
		"SELECT employeeMessage FROM EmployeeMessage employeeMessage";

	private static final String _SQL_SELECT_EMPLOYEEMESSAGE_WHERE =
		"SELECT employeeMessage FROM EmployeeMessage employeeMessage WHERE ";

	private static final String _SQL_COUNT_EMPLOYEEMESSAGE =
		"SELECT COUNT(employeeMessage) FROM EmployeeMessage employeeMessage";

	private static final String _SQL_COUNT_EMPLOYEEMESSAGE_WHERE =
		"SELECT COUNT(employeeMessage) FROM EmployeeMessage employeeMessage WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "employeeMessage.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EmployeeMessage exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EmployeeMessage exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EmployeeMessagePersistenceImpl.class);

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

	private static class EmployeeMessageModelArgumentsResolver
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

			EmployeeMessageModelImpl employeeMessageModelImpl =
				(EmployeeMessageModelImpl)baseModel;

			long columnBitmask = employeeMessageModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					employeeMessageModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						employeeMessageModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					employeeMessageModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			EmployeeMessageModelImpl employeeMessageModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						employeeMessageModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = employeeMessageModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}