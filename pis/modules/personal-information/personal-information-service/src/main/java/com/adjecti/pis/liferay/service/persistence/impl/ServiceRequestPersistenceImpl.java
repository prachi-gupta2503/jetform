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

import com.adjecti.pis.liferay.exception.NoSuchServiceRequestException;
import com.adjecti.pis.liferay.model.ServiceRequest;
import com.adjecti.pis.liferay.model.impl.ServiceRequestImpl;
import com.adjecti.pis.liferay.model.impl.ServiceRequestModelImpl;
import com.adjecti.pis.liferay.service.persistence.ServiceRequestPersistence;
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
 * The persistence implementation for the service request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ServiceRequestPersistence.class)
public class ServiceRequestPersistenceImpl
	extends BasePersistenceImpl<ServiceRequest>
	implements ServiceRequestPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ServiceRequestUtil</code> to access the service request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ServiceRequestImpl.class.getName();

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
	 * Returns all the service requests where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching service requests
	 */
	@Override
	public List<ServiceRequest> findByEmployeeId(long employeeId) {
		return findByEmployeeId(
			employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service requests where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of service requests
	 * @param end the upper bound of the range of service requests (not inclusive)
	 * @return the range of matching service requests
	 */
	@Override
	public List<ServiceRequest> findByEmployeeId(
		long employeeId, int start, int end) {

		return findByEmployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the service requests where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of service requests
	 * @param end the upper bound of the range of service requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service requests
	 */
	@Override
	public List<ServiceRequest> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<ServiceRequest> orderByComparator) {

		return findByEmployeeId(
			employeeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the service requests where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of service requests
	 * @param end the upper bound of the range of service requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching service requests
	 */
	@Override
	public List<ServiceRequest> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<ServiceRequest> orderByComparator,
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

		List<ServiceRequest> list = null;

		if (useFinderCache) {
			list = (List<ServiceRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ServiceRequest serviceRequest : list) {
					if (employeeId != serviceRequest.getEmployeeId()) {
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

			sb.append(_SQL_SELECT_SERVICEREQUEST_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ServiceRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				list = (List<ServiceRequest>)QueryUtil.list(
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
	 * Returns the first service request in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request
	 * @throws NoSuchServiceRequestException if a matching service request could not be found
	 */
	@Override
	public ServiceRequest findByEmployeeId_First(
			long employeeId,
			OrderByComparator<ServiceRequest> orderByComparator)
		throws NoSuchServiceRequestException {

		ServiceRequest serviceRequest = fetchByEmployeeId_First(
			employeeId, orderByComparator);

		if (serviceRequest != null) {
			return serviceRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchServiceRequestException(sb.toString());
	}

	/**
	 * Returns the first service request in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request, or <code>null</code> if a matching service request could not be found
	 */
	@Override
	public ServiceRequest fetchByEmployeeId_First(
		long employeeId, OrderByComparator<ServiceRequest> orderByComparator) {

		List<ServiceRequest> list = findByEmployeeId(
			employeeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last service request in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request
	 * @throws NoSuchServiceRequestException if a matching service request could not be found
	 */
	@Override
	public ServiceRequest findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<ServiceRequest> orderByComparator)
		throws NoSuchServiceRequestException {

		ServiceRequest serviceRequest = fetchByEmployeeId_Last(
			employeeId, orderByComparator);

		if (serviceRequest != null) {
			return serviceRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchServiceRequestException(sb.toString());
	}

	/**
	 * Returns the last service request in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request, or <code>null</code> if a matching service request could not be found
	 */
	@Override
	public ServiceRequest fetchByEmployeeId_Last(
		long employeeId, OrderByComparator<ServiceRequest> orderByComparator) {

		int count = countByEmployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<ServiceRequest> list = findByEmployeeId(
			employeeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the service requests before and after the current service request in the ordered set where employeeId = &#63;.
	 *
	 * @param serviceRequestId the primary key of the current service request
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service request
	 * @throws NoSuchServiceRequestException if a service request with the primary key could not be found
	 */
	@Override
	public ServiceRequest[] findByEmployeeId_PrevAndNext(
			long serviceRequestId, long employeeId,
			OrderByComparator<ServiceRequest> orderByComparator)
		throws NoSuchServiceRequestException {

		ServiceRequest serviceRequest = findByPrimaryKey(serviceRequestId);

		Session session = null;

		try {
			session = openSession();

			ServiceRequest[] array = new ServiceRequestImpl[3];

			array[0] = getByEmployeeId_PrevAndNext(
				session, serviceRequest, employeeId, orderByComparator, true);

			array[1] = serviceRequest;

			array[2] = getByEmployeeId_PrevAndNext(
				session, serviceRequest, employeeId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ServiceRequest getByEmployeeId_PrevAndNext(
		Session session, ServiceRequest serviceRequest, long employeeId,
		OrderByComparator<ServiceRequest> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SERVICEREQUEST_WHERE);

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
			sb.append(ServiceRequestModelImpl.ORDER_BY_JPQL);
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
						serviceRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ServiceRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the service requests where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeByEmployeeId(long employeeId) {
		for (ServiceRequest serviceRequest :
				findByEmployeeId(
					employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(serviceRequest);
		}
	}

	/**
	 * Returns the number of service requests where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching service requests
	 */
	@Override
	public int countByEmployeeId(long employeeId) {
		FinderPath finderPath = _finderPathCountByEmployeeId;

		Object[] finderArgs = new Object[] {employeeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SERVICEREQUEST_WHERE);

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
		"serviceRequest.employeeId = ?";

	private FinderPath _finderPathWithPaginationFindByJoiningProcessId;
	private FinderPath _finderPathWithoutPaginationFindByJoiningProcessId;
	private FinderPath _finderPathCountByJoiningProcessId;

	/**
	 * Returns all the service requests where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @return the matching service requests
	 */
	@Override
	public List<ServiceRequest> findByJoiningProcessId(Long joiningProcessId) {
		return findByJoiningProcessId(
			joiningProcessId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service requests where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of service requests
	 * @param end the upper bound of the range of service requests (not inclusive)
	 * @return the range of matching service requests
	 */
	@Override
	public List<ServiceRequest> findByJoiningProcessId(
		Long joiningProcessId, int start, int end) {

		return findByJoiningProcessId(joiningProcessId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the service requests where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of service requests
	 * @param end the upper bound of the range of service requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service requests
	 */
	@Override
	public List<ServiceRequest> findByJoiningProcessId(
		Long joiningProcessId, int start, int end,
		OrderByComparator<ServiceRequest> orderByComparator) {

		return findByJoiningProcessId(
			joiningProcessId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the service requests where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of service requests
	 * @param end the upper bound of the range of service requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching service requests
	 */
	@Override
	public List<ServiceRequest> findByJoiningProcessId(
		Long joiningProcessId, int start, int end,
		OrderByComparator<ServiceRequest> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByJoiningProcessId;
				finderArgs = new Object[] {joiningProcessId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByJoiningProcessId;
			finderArgs = new Object[] {
				joiningProcessId, start, end, orderByComparator
			};
		}

		List<ServiceRequest> list = null;

		if (useFinderCache) {
			list = (List<ServiceRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ServiceRequest serviceRequest : list) {
					if (!Objects.equals(
							joiningProcessId,
							serviceRequest.getJoiningProcessId())) {

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

			sb.append(_SQL_SELECT_SERVICEREQUEST_WHERE);

			sb.append(_FINDER_COLUMN_JOININGPROCESSID_JOININGPROCESSID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ServiceRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(joiningProcessId.longValue());

				list = (List<ServiceRequest>)QueryUtil.list(
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
	 * Returns the first service request in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request
	 * @throws NoSuchServiceRequestException if a matching service request could not be found
	 */
	@Override
	public ServiceRequest findByJoiningProcessId_First(
			Long joiningProcessId,
			OrderByComparator<ServiceRequest> orderByComparator)
		throws NoSuchServiceRequestException {

		ServiceRequest serviceRequest = fetchByJoiningProcessId_First(
			joiningProcessId, orderByComparator);

		if (serviceRequest != null) {
			return serviceRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("joiningProcessId=");
		sb.append(joiningProcessId);

		sb.append("}");

		throw new NoSuchServiceRequestException(sb.toString());
	}

	/**
	 * Returns the first service request in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request, or <code>null</code> if a matching service request could not be found
	 */
	@Override
	public ServiceRequest fetchByJoiningProcessId_First(
		Long joiningProcessId,
		OrderByComparator<ServiceRequest> orderByComparator) {

		List<ServiceRequest> list = findByJoiningProcessId(
			joiningProcessId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last service request in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request
	 * @throws NoSuchServiceRequestException if a matching service request could not be found
	 */
	@Override
	public ServiceRequest findByJoiningProcessId_Last(
			Long joiningProcessId,
			OrderByComparator<ServiceRequest> orderByComparator)
		throws NoSuchServiceRequestException {

		ServiceRequest serviceRequest = fetchByJoiningProcessId_Last(
			joiningProcessId, orderByComparator);

		if (serviceRequest != null) {
			return serviceRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("joiningProcessId=");
		sb.append(joiningProcessId);

		sb.append("}");

		throw new NoSuchServiceRequestException(sb.toString());
	}

	/**
	 * Returns the last service request in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request, or <code>null</code> if a matching service request could not be found
	 */
	@Override
	public ServiceRequest fetchByJoiningProcessId_Last(
		Long joiningProcessId,
		OrderByComparator<ServiceRequest> orderByComparator) {

		int count = countByJoiningProcessId(joiningProcessId);

		if (count == 0) {
			return null;
		}

		List<ServiceRequest> list = findByJoiningProcessId(
			joiningProcessId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the service requests before and after the current service request in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param serviceRequestId the primary key of the current service request
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service request
	 * @throws NoSuchServiceRequestException if a service request with the primary key could not be found
	 */
	@Override
	public ServiceRequest[] findByJoiningProcessId_PrevAndNext(
			long serviceRequestId, Long joiningProcessId,
			OrderByComparator<ServiceRequest> orderByComparator)
		throws NoSuchServiceRequestException {

		ServiceRequest serviceRequest = findByPrimaryKey(serviceRequestId);

		Session session = null;

		try {
			session = openSession();

			ServiceRequest[] array = new ServiceRequestImpl[3];

			array[0] = getByJoiningProcessId_PrevAndNext(
				session, serviceRequest, joiningProcessId, orderByComparator,
				true);

			array[1] = serviceRequest;

			array[2] = getByJoiningProcessId_PrevAndNext(
				session, serviceRequest, joiningProcessId, orderByComparator,
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

	protected ServiceRequest getByJoiningProcessId_PrevAndNext(
		Session session, ServiceRequest serviceRequest, Long joiningProcessId,
		OrderByComparator<ServiceRequest> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SERVICEREQUEST_WHERE);

		sb.append(_FINDER_COLUMN_JOININGPROCESSID_JOININGPROCESSID_2);

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
			sb.append(ServiceRequestModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(joiningProcessId.longValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						serviceRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ServiceRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the service requests where joiningProcessId = &#63; from the database.
	 *
	 * @param joiningProcessId the joining process ID
	 */
	@Override
	public void removeByJoiningProcessId(Long joiningProcessId) {
		for (ServiceRequest serviceRequest :
				findByJoiningProcessId(
					joiningProcessId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(serviceRequest);
		}
	}

	/**
	 * Returns the number of service requests where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @return the number of matching service requests
	 */
	@Override
	public int countByJoiningProcessId(Long joiningProcessId) {
		FinderPath finderPath = _finderPathCountByJoiningProcessId;

		Object[] finderArgs = new Object[] {joiningProcessId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SERVICEREQUEST_WHERE);

			sb.append(_FINDER_COLUMN_JOININGPROCESSID_JOININGPROCESSID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(joiningProcessId.longValue());

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
		_FINDER_COLUMN_JOININGPROCESSID_JOININGPROCESSID_2 =
			"serviceRequest.joiningProcessId = ?";

	private FinderPath _finderPathWithPaginationFindByStatus;
	private FinderPath _finderPathWithoutPaginationFindByStatus;
	private FinderPath _finderPathCountByStatus;

	/**
	 * Returns all the service requests where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching service requests
	 */
	@Override
	public List<ServiceRequest> findByStatus(int status) {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service requests where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of service requests
	 * @param end the upper bound of the range of service requests (not inclusive)
	 * @return the range of matching service requests
	 */
	@Override
	public List<ServiceRequest> findByStatus(int status, int start, int end) {
		return findByStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the service requests where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of service requests
	 * @param end the upper bound of the range of service requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service requests
	 */
	@Override
	public List<ServiceRequest> findByStatus(
		int status, int start, int end,
		OrderByComparator<ServiceRequest> orderByComparator) {

		return findByStatus(status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the service requests where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of service requests
	 * @param end the upper bound of the range of service requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching service requests
	 */
	@Override
	public List<ServiceRequest> findByStatus(
		int status, int start, int end,
		OrderByComparator<ServiceRequest> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByStatus;
				finderArgs = new Object[] {status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByStatus;
			finderArgs = new Object[] {status, start, end, orderByComparator};
		}

		List<ServiceRequest> list = null;

		if (useFinderCache) {
			list = (List<ServiceRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ServiceRequest serviceRequest : list) {
					if (status != serviceRequest.getStatus()) {
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

			sb.append(_SQL_SELECT_SERVICEREQUEST_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ServiceRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

				list = (List<ServiceRequest>)QueryUtil.list(
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
	 * Returns the first service request in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request
	 * @throws NoSuchServiceRequestException if a matching service request could not be found
	 */
	@Override
	public ServiceRequest findByStatus_First(
			int status, OrderByComparator<ServiceRequest> orderByComparator)
		throws NoSuchServiceRequestException {

		ServiceRequest serviceRequest = fetchByStatus_First(
			status, orderByComparator);

		if (serviceRequest != null) {
			return serviceRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchServiceRequestException(sb.toString());
	}

	/**
	 * Returns the first service request in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request, or <code>null</code> if a matching service request could not be found
	 */
	@Override
	public ServiceRequest fetchByStatus_First(
		int status, OrderByComparator<ServiceRequest> orderByComparator) {

		List<ServiceRequest> list = findByStatus(
			status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last service request in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request
	 * @throws NoSuchServiceRequestException if a matching service request could not be found
	 */
	@Override
	public ServiceRequest findByStatus_Last(
			int status, OrderByComparator<ServiceRequest> orderByComparator)
		throws NoSuchServiceRequestException {

		ServiceRequest serviceRequest = fetchByStatus_Last(
			status, orderByComparator);

		if (serviceRequest != null) {
			return serviceRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchServiceRequestException(sb.toString());
	}

	/**
	 * Returns the last service request in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request, or <code>null</code> if a matching service request could not be found
	 */
	@Override
	public ServiceRequest fetchByStatus_Last(
		int status, OrderByComparator<ServiceRequest> orderByComparator) {

		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<ServiceRequest> list = findByStatus(
			status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the service requests before and after the current service request in the ordered set where status = &#63;.
	 *
	 * @param serviceRequestId the primary key of the current service request
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service request
	 * @throws NoSuchServiceRequestException if a service request with the primary key could not be found
	 */
	@Override
	public ServiceRequest[] findByStatus_PrevAndNext(
			long serviceRequestId, int status,
			OrderByComparator<ServiceRequest> orderByComparator)
		throws NoSuchServiceRequestException {

		ServiceRequest serviceRequest = findByPrimaryKey(serviceRequestId);

		Session session = null;

		try {
			session = openSession();

			ServiceRequest[] array = new ServiceRequestImpl[3];

			array[0] = getByStatus_PrevAndNext(
				session, serviceRequest, status, orderByComparator, true);

			array[1] = serviceRequest;

			array[2] = getByStatus_PrevAndNext(
				session, serviceRequest, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ServiceRequest getByStatus_PrevAndNext(
		Session session, ServiceRequest serviceRequest, int status,
		OrderByComparator<ServiceRequest> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SERVICEREQUEST_WHERE);

		sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

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
			sb.append(ServiceRequestModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						serviceRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ServiceRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the service requests where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	@Override
	public void removeByStatus(int status) {
		for (ServiceRequest serviceRequest :
				findByStatus(
					status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(serviceRequest);
		}
	}

	/**
	 * Returns the number of service requests where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching service requests
	 */
	@Override
	public int countByStatus(int status) {
		FinderPath finderPath = _finderPathCountByStatus;

		Object[] finderArgs = new Object[] {status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SERVICEREQUEST_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

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

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 =
		"serviceRequest.status = ?";

	private FinderPath _finderPathWithPaginationFindByStatusAndOrganization;
	private FinderPath _finderPathWithoutPaginationFindByStatusAndOrganization;
	private FinderPath _finderPathCountByStatusAndOrganization;

	/**
	 * Returns all the service requests where status = &#63; and organizationId = &#63;.
	 *
	 * @param status the status
	 * @param organizationId the organization ID
	 * @return the matching service requests
	 */
	@Override
	public List<ServiceRequest> findByStatusAndOrganization(
		int status, long organizationId) {

		return findByStatusAndOrganization(
			status, organizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service requests where status = &#63; and organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of service requests
	 * @param end the upper bound of the range of service requests (not inclusive)
	 * @return the range of matching service requests
	 */
	@Override
	public List<ServiceRequest> findByStatusAndOrganization(
		int status, long organizationId, int start, int end) {

		return findByStatusAndOrganization(
			status, organizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the service requests where status = &#63; and organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of service requests
	 * @param end the upper bound of the range of service requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service requests
	 */
	@Override
	public List<ServiceRequest> findByStatusAndOrganization(
		int status, long organizationId, int start, int end,
		OrderByComparator<ServiceRequest> orderByComparator) {

		return findByStatusAndOrganization(
			status, organizationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the service requests where status = &#63; and organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of service requests
	 * @param end the upper bound of the range of service requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching service requests
	 */
	@Override
	public List<ServiceRequest> findByStatusAndOrganization(
		int status, long organizationId, int start, int end,
		OrderByComparator<ServiceRequest> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByStatusAndOrganization;
				finderArgs = new Object[] {status, organizationId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByStatusAndOrganization;
			finderArgs = new Object[] {
				status, organizationId, start, end, orderByComparator
			};
		}

		List<ServiceRequest> list = null;

		if (useFinderCache) {
			list = (List<ServiceRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ServiceRequest serviceRequest : list) {
					if ((status != serviceRequest.getStatus()) ||
						(organizationId !=
							serviceRequest.getOrganizationId())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_SERVICEREQUEST_WHERE);

			sb.append(_FINDER_COLUMN_STATUSANDORGANIZATION_STATUS_2);

			sb.append(_FINDER_COLUMN_STATUSANDORGANIZATION_ORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ServiceRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

				queryPos.add(organizationId);

				list = (List<ServiceRequest>)QueryUtil.list(
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
	 * Returns the first service request in the ordered set where status = &#63; and organizationId = &#63;.
	 *
	 * @param status the status
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request
	 * @throws NoSuchServiceRequestException if a matching service request could not be found
	 */
	@Override
	public ServiceRequest findByStatusAndOrganization_First(
			int status, long organizationId,
			OrderByComparator<ServiceRequest> orderByComparator)
		throws NoSuchServiceRequestException {

		ServiceRequest serviceRequest = fetchByStatusAndOrganization_First(
			status, organizationId, orderByComparator);

		if (serviceRequest != null) {
			return serviceRequest;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append(", organizationId=");
		sb.append(organizationId);

		sb.append("}");

		throw new NoSuchServiceRequestException(sb.toString());
	}

	/**
	 * Returns the first service request in the ordered set where status = &#63; and organizationId = &#63;.
	 *
	 * @param status the status
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request, or <code>null</code> if a matching service request could not be found
	 */
	@Override
	public ServiceRequest fetchByStatusAndOrganization_First(
		int status, long organizationId,
		OrderByComparator<ServiceRequest> orderByComparator) {

		List<ServiceRequest> list = findByStatusAndOrganization(
			status, organizationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last service request in the ordered set where status = &#63; and organizationId = &#63;.
	 *
	 * @param status the status
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request
	 * @throws NoSuchServiceRequestException if a matching service request could not be found
	 */
	@Override
	public ServiceRequest findByStatusAndOrganization_Last(
			int status, long organizationId,
			OrderByComparator<ServiceRequest> orderByComparator)
		throws NoSuchServiceRequestException {

		ServiceRequest serviceRequest = fetchByStatusAndOrganization_Last(
			status, organizationId, orderByComparator);

		if (serviceRequest != null) {
			return serviceRequest;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append(", organizationId=");
		sb.append(organizationId);

		sb.append("}");

		throw new NoSuchServiceRequestException(sb.toString());
	}

	/**
	 * Returns the last service request in the ordered set where status = &#63; and organizationId = &#63;.
	 *
	 * @param status the status
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request, or <code>null</code> if a matching service request could not be found
	 */
	@Override
	public ServiceRequest fetchByStatusAndOrganization_Last(
		int status, long organizationId,
		OrderByComparator<ServiceRequest> orderByComparator) {

		int count = countByStatusAndOrganization(status, organizationId);

		if (count == 0) {
			return null;
		}

		List<ServiceRequest> list = findByStatusAndOrganization(
			status, organizationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the service requests before and after the current service request in the ordered set where status = &#63; and organizationId = &#63;.
	 *
	 * @param serviceRequestId the primary key of the current service request
	 * @param status the status
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service request
	 * @throws NoSuchServiceRequestException if a service request with the primary key could not be found
	 */
	@Override
	public ServiceRequest[] findByStatusAndOrganization_PrevAndNext(
			long serviceRequestId, int status, long organizationId,
			OrderByComparator<ServiceRequest> orderByComparator)
		throws NoSuchServiceRequestException {

		ServiceRequest serviceRequest = findByPrimaryKey(serviceRequestId);

		Session session = null;

		try {
			session = openSession();

			ServiceRequest[] array = new ServiceRequestImpl[3];

			array[0] = getByStatusAndOrganization_PrevAndNext(
				session, serviceRequest, status, organizationId,
				orderByComparator, true);

			array[1] = serviceRequest;

			array[2] = getByStatusAndOrganization_PrevAndNext(
				session, serviceRequest, status, organizationId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ServiceRequest getByStatusAndOrganization_PrevAndNext(
		Session session, ServiceRequest serviceRequest, int status,
		long organizationId,
		OrderByComparator<ServiceRequest> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_SERVICEREQUEST_WHERE);

		sb.append(_FINDER_COLUMN_STATUSANDORGANIZATION_STATUS_2);

		sb.append(_FINDER_COLUMN_STATUSANDORGANIZATION_ORGANIZATIONID_2);

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
			sb.append(ServiceRequestModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(status);

		queryPos.add(organizationId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						serviceRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ServiceRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the service requests where status = &#63; and organizationId = &#63; from the database.
	 *
	 * @param status the status
	 * @param organizationId the organization ID
	 */
	@Override
	public void removeByStatusAndOrganization(int status, long organizationId) {
		for (ServiceRequest serviceRequest :
				findByStatusAndOrganization(
					status, organizationId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(serviceRequest);
		}
	}

	/**
	 * Returns the number of service requests where status = &#63; and organizationId = &#63;.
	 *
	 * @param status the status
	 * @param organizationId the organization ID
	 * @return the number of matching service requests
	 */
	@Override
	public int countByStatusAndOrganization(int status, long organizationId) {
		FinderPath finderPath = _finderPathCountByStatusAndOrganization;

		Object[] finderArgs = new Object[] {status, organizationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SERVICEREQUEST_WHERE);

			sb.append(_FINDER_COLUMN_STATUSANDORGANIZATION_STATUS_2);

			sb.append(_FINDER_COLUMN_STATUSANDORGANIZATION_ORGANIZATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

				queryPos.add(organizationId);

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

	private static final String _FINDER_COLUMN_STATUSANDORGANIZATION_STATUS_2 =
		"serviceRequest.status = ? AND ";

	private static final String
		_FINDER_COLUMN_STATUSANDORGANIZATION_ORGANIZATIONID_2 =
			"serviceRequest.organizationId = ?";

	private FinderPath
		_finderPathWithPaginationFindByServiceRequestTypeIdAndDeleted;
	private FinderPath
		_finderPathWithoutPaginationFindByServiceRequestTypeIdAndDeleted;
	private FinderPath _finderPathCountByServiceRequestTypeIdAndDeleted;

	/**
	 * Returns all the service requests where serviceRequestTypeId = &#63; and deleted = &#63;.
	 *
	 * @param serviceRequestTypeId the service request type ID
	 * @param deleted the deleted
	 * @return the matching service requests
	 */
	@Override
	public List<ServiceRequest> findByServiceRequestTypeIdAndDeleted(
		long serviceRequestTypeId, boolean deleted) {

		return findByServiceRequestTypeIdAndDeleted(
			serviceRequestTypeId, deleted, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the service requests where serviceRequestTypeId = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param serviceRequestTypeId the service request type ID
	 * @param deleted the deleted
	 * @param start the lower bound of the range of service requests
	 * @param end the upper bound of the range of service requests (not inclusive)
	 * @return the range of matching service requests
	 */
	@Override
	public List<ServiceRequest> findByServiceRequestTypeIdAndDeleted(
		long serviceRequestTypeId, boolean deleted, int start, int end) {

		return findByServiceRequestTypeIdAndDeleted(
			serviceRequestTypeId, deleted, start, end, null);
	}

	/**
	 * Returns an ordered range of all the service requests where serviceRequestTypeId = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param serviceRequestTypeId the service request type ID
	 * @param deleted the deleted
	 * @param start the lower bound of the range of service requests
	 * @param end the upper bound of the range of service requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service requests
	 */
	@Override
	public List<ServiceRequest> findByServiceRequestTypeIdAndDeleted(
		long serviceRequestTypeId, boolean deleted, int start, int end,
		OrderByComparator<ServiceRequest> orderByComparator) {

		return findByServiceRequestTypeIdAndDeleted(
			serviceRequestTypeId, deleted, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the service requests where serviceRequestTypeId = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param serviceRequestTypeId the service request type ID
	 * @param deleted the deleted
	 * @param start the lower bound of the range of service requests
	 * @param end the upper bound of the range of service requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching service requests
	 */
	@Override
	public List<ServiceRequest> findByServiceRequestTypeIdAndDeleted(
		long serviceRequestTypeId, boolean deleted, int start, int end,
		OrderByComparator<ServiceRequest> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByServiceRequestTypeIdAndDeleted;
				finderArgs = new Object[] {serviceRequestTypeId, deleted};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByServiceRequestTypeIdAndDeleted;
			finderArgs = new Object[] {
				serviceRequestTypeId, deleted, start, end, orderByComparator
			};
		}

		List<ServiceRequest> list = null;

		if (useFinderCache) {
			list = (List<ServiceRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ServiceRequest serviceRequest : list) {
					if ((serviceRequestTypeId !=
							serviceRequest.getServiceRequestTypeId()) ||
						(deleted != serviceRequest.isDeleted())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_SERVICEREQUEST_WHERE);

			sb.append(
				_FINDER_COLUMN_SERVICEREQUESTTYPEIDANDDELETED_SERVICEREQUESTTYPEID_2);

			sb.append(_FINDER_COLUMN_SERVICEREQUESTTYPEIDANDDELETED_DELETED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ServiceRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(serviceRequestTypeId);

				queryPos.add(deleted);

				list = (List<ServiceRequest>)QueryUtil.list(
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
	 * Returns the first service request in the ordered set where serviceRequestTypeId = &#63; and deleted = &#63;.
	 *
	 * @param serviceRequestTypeId the service request type ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request
	 * @throws NoSuchServiceRequestException if a matching service request could not be found
	 */
	@Override
	public ServiceRequest findByServiceRequestTypeIdAndDeleted_First(
			long serviceRequestTypeId, boolean deleted,
			OrderByComparator<ServiceRequest> orderByComparator)
		throws NoSuchServiceRequestException {

		ServiceRequest serviceRequest =
			fetchByServiceRequestTypeIdAndDeleted_First(
				serviceRequestTypeId, deleted, orderByComparator);

		if (serviceRequest != null) {
			return serviceRequest;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("serviceRequestTypeId=");
		sb.append(serviceRequestTypeId);

		sb.append(", deleted=");
		sb.append(deleted);

		sb.append("}");

		throw new NoSuchServiceRequestException(sb.toString());
	}

	/**
	 * Returns the first service request in the ordered set where serviceRequestTypeId = &#63; and deleted = &#63;.
	 *
	 * @param serviceRequestTypeId the service request type ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request, or <code>null</code> if a matching service request could not be found
	 */
	@Override
	public ServiceRequest fetchByServiceRequestTypeIdAndDeleted_First(
		long serviceRequestTypeId, boolean deleted,
		OrderByComparator<ServiceRequest> orderByComparator) {

		List<ServiceRequest> list = findByServiceRequestTypeIdAndDeleted(
			serviceRequestTypeId, deleted, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last service request in the ordered set where serviceRequestTypeId = &#63; and deleted = &#63;.
	 *
	 * @param serviceRequestTypeId the service request type ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request
	 * @throws NoSuchServiceRequestException if a matching service request could not be found
	 */
	@Override
	public ServiceRequest findByServiceRequestTypeIdAndDeleted_Last(
			long serviceRequestTypeId, boolean deleted,
			OrderByComparator<ServiceRequest> orderByComparator)
		throws NoSuchServiceRequestException {

		ServiceRequest serviceRequest =
			fetchByServiceRequestTypeIdAndDeleted_Last(
				serviceRequestTypeId, deleted, orderByComparator);

		if (serviceRequest != null) {
			return serviceRequest;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("serviceRequestTypeId=");
		sb.append(serviceRequestTypeId);

		sb.append(", deleted=");
		sb.append(deleted);

		sb.append("}");

		throw new NoSuchServiceRequestException(sb.toString());
	}

	/**
	 * Returns the last service request in the ordered set where serviceRequestTypeId = &#63; and deleted = &#63;.
	 *
	 * @param serviceRequestTypeId the service request type ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request, or <code>null</code> if a matching service request could not be found
	 */
	@Override
	public ServiceRequest fetchByServiceRequestTypeIdAndDeleted_Last(
		long serviceRequestTypeId, boolean deleted,
		OrderByComparator<ServiceRequest> orderByComparator) {

		int count = countByServiceRequestTypeIdAndDeleted(
			serviceRequestTypeId, deleted);

		if (count == 0) {
			return null;
		}

		List<ServiceRequest> list = findByServiceRequestTypeIdAndDeleted(
			serviceRequestTypeId, deleted, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the service requests before and after the current service request in the ordered set where serviceRequestTypeId = &#63; and deleted = &#63;.
	 *
	 * @param serviceRequestId the primary key of the current service request
	 * @param serviceRequestTypeId the service request type ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service request
	 * @throws NoSuchServiceRequestException if a service request with the primary key could not be found
	 */
	@Override
	public ServiceRequest[] findByServiceRequestTypeIdAndDeleted_PrevAndNext(
			long serviceRequestId, long serviceRequestTypeId, boolean deleted,
			OrderByComparator<ServiceRequest> orderByComparator)
		throws NoSuchServiceRequestException {

		ServiceRequest serviceRequest = findByPrimaryKey(serviceRequestId);

		Session session = null;

		try {
			session = openSession();

			ServiceRequest[] array = new ServiceRequestImpl[3];

			array[0] = getByServiceRequestTypeIdAndDeleted_PrevAndNext(
				session, serviceRequest, serviceRequestTypeId, deleted,
				orderByComparator, true);

			array[1] = serviceRequest;

			array[2] = getByServiceRequestTypeIdAndDeleted_PrevAndNext(
				session, serviceRequest, serviceRequestTypeId, deleted,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ServiceRequest getByServiceRequestTypeIdAndDeleted_PrevAndNext(
		Session session, ServiceRequest serviceRequest,
		long serviceRequestTypeId, boolean deleted,
		OrderByComparator<ServiceRequest> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_SERVICEREQUEST_WHERE);

		sb.append(
			_FINDER_COLUMN_SERVICEREQUESTTYPEIDANDDELETED_SERVICEREQUESTTYPEID_2);

		sb.append(_FINDER_COLUMN_SERVICEREQUESTTYPEIDANDDELETED_DELETED_2);

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
			sb.append(ServiceRequestModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(serviceRequestTypeId);

		queryPos.add(deleted);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						serviceRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ServiceRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the service requests where serviceRequestTypeId = &#63; and deleted = &#63; from the database.
	 *
	 * @param serviceRequestTypeId the service request type ID
	 * @param deleted the deleted
	 */
	@Override
	public void removeByServiceRequestTypeIdAndDeleted(
		long serviceRequestTypeId, boolean deleted) {

		for (ServiceRequest serviceRequest :
				findByServiceRequestTypeIdAndDeleted(
					serviceRequestTypeId, deleted, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(serviceRequest);
		}
	}

	/**
	 * Returns the number of service requests where serviceRequestTypeId = &#63; and deleted = &#63;.
	 *
	 * @param serviceRequestTypeId the service request type ID
	 * @param deleted the deleted
	 * @return the number of matching service requests
	 */
	@Override
	public int countByServiceRequestTypeIdAndDeleted(
		long serviceRequestTypeId, boolean deleted) {

		FinderPath finderPath =
			_finderPathCountByServiceRequestTypeIdAndDeleted;

		Object[] finderArgs = new Object[] {serviceRequestTypeId, deleted};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SERVICEREQUEST_WHERE);

			sb.append(
				_FINDER_COLUMN_SERVICEREQUESTTYPEIDANDDELETED_SERVICEREQUESTTYPEID_2);

			sb.append(_FINDER_COLUMN_SERVICEREQUESTTYPEIDANDDELETED_DELETED_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(serviceRequestTypeId);

				queryPos.add(deleted);

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
		_FINDER_COLUMN_SERVICEREQUESTTYPEIDANDDELETED_SERVICEREQUESTTYPEID_2 =
			"serviceRequest.serviceRequestTypeId = ? AND ";

	private static final String
		_FINDER_COLUMN_SERVICEREQUESTTYPEIDANDDELETED_DELETED_2 =
			"serviceRequest.deleted = ?";

	public ServiceRequestPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");
		dbColumnNames.put("state", "state_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ServiceRequest.class);

		setModelImplClass(ServiceRequestImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the service request in the entity cache if it is enabled.
	 *
	 * @param serviceRequest the service request
	 */
	@Override
	public void cacheResult(ServiceRequest serviceRequest) {
		entityCache.putResult(
			ServiceRequestImpl.class, serviceRequest.getPrimaryKey(),
			serviceRequest);
	}

	/**
	 * Caches the service requests in the entity cache if it is enabled.
	 *
	 * @param serviceRequests the service requests
	 */
	@Override
	public void cacheResult(List<ServiceRequest> serviceRequests) {
		for (ServiceRequest serviceRequest : serviceRequests) {
			if (entityCache.getResult(
					ServiceRequestImpl.class, serviceRequest.getPrimaryKey()) ==
						null) {

				cacheResult(serviceRequest);
			}
		}
	}

	/**
	 * Clears the cache for all service requests.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ServiceRequestImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the service request.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ServiceRequest serviceRequest) {
		entityCache.removeResult(ServiceRequestImpl.class, serviceRequest);
	}

	@Override
	public void clearCache(List<ServiceRequest> serviceRequests) {
		for (ServiceRequest serviceRequest : serviceRequests) {
			entityCache.removeResult(ServiceRequestImpl.class, serviceRequest);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ServiceRequestImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new service request with the primary key. Does not add the service request to the database.
	 *
	 * @param serviceRequestId the primary key for the new service request
	 * @return the new service request
	 */
	@Override
	public ServiceRequest create(long serviceRequestId) {
		ServiceRequest serviceRequest = new ServiceRequestImpl();

		serviceRequest.setNew(true);
		serviceRequest.setPrimaryKey(serviceRequestId);

		serviceRequest.setCompanyId(CompanyThreadLocal.getCompanyId());

		return serviceRequest;
	}

	/**
	 * Removes the service request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param serviceRequestId the primary key of the service request
	 * @return the service request that was removed
	 * @throws NoSuchServiceRequestException if a service request with the primary key could not be found
	 */
	@Override
	public ServiceRequest remove(long serviceRequestId)
		throws NoSuchServiceRequestException {

		return remove((Serializable)serviceRequestId);
	}

	/**
	 * Removes the service request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the service request
	 * @return the service request that was removed
	 * @throws NoSuchServiceRequestException if a service request with the primary key could not be found
	 */
	@Override
	public ServiceRequest remove(Serializable primaryKey)
		throws NoSuchServiceRequestException {

		Session session = null;

		try {
			session = openSession();

			ServiceRequest serviceRequest = (ServiceRequest)session.get(
				ServiceRequestImpl.class, primaryKey);

			if (serviceRequest == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchServiceRequestException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(serviceRequest);
		}
		catch (NoSuchServiceRequestException noSuchEntityException) {
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
	protected ServiceRequest removeImpl(ServiceRequest serviceRequest) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(serviceRequest)) {
				serviceRequest = (ServiceRequest)session.get(
					ServiceRequestImpl.class,
					serviceRequest.getPrimaryKeyObj());
			}

			if (serviceRequest != null) {
				session.delete(serviceRequest);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (serviceRequest != null) {
			clearCache(serviceRequest);
		}

		return serviceRequest;
	}

	@Override
	public ServiceRequest updateImpl(ServiceRequest serviceRequest) {
		boolean isNew = serviceRequest.isNew();

		if (!(serviceRequest instanceof ServiceRequestModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(serviceRequest.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					serviceRequest);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in serviceRequest proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ServiceRequest implementation " +
					serviceRequest.getClass());
		}

		ServiceRequestModelImpl serviceRequestModelImpl =
			(ServiceRequestModelImpl)serviceRequest;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (serviceRequest.getCreateDate() == null)) {
			if (serviceContext == null) {
				serviceRequest.setCreateDate(now);
			}
			else {
				serviceRequest.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!serviceRequestModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				serviceRequest.setModifiedDate(now);
			}
			else {
				serviceRequest.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(serviceRequest);
			}
			else {
				serviceRequest = (ServiceRequest)session.merge(serviceRequest);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ServiceRequestImpl.class, serviceRequestModelImpl, false, true);

		if (isNew) {
			serviceRequest.setNew(false);
		}

		serviceRequest.resetOriginalValues();

		return serviceRequest;
	}

	/**
	 * Returns the service request with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the service request
	 * @return the service request
	 * @throws NoSuchServiceRequestException if a service request with the primary key could not be found
	 */
	@Override
	public ServiceRequest findByPrimaryKey(Serializable primaryKey)
		throws NoSuchServiceRequestException {

		ServiceRequest serviceRequest = fetchByPrimaryKey(primaryKey);

		if (serviceRequest == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchServiceRequestException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return serviceRequest;
	}

	/**
	 * Returns the service request with the primary key or throws a <code>NoSuchServiceRequestException</code> if it could not be found.
	 *
	 * @param serviceRequestId the primary key of the service request
	 * @return the service request
	 * @throws NoSuchServiceRequestException if a service request with the primary key could not be found
	 */
	@Override
	public ServiceRequest findByPrimaryKey(long serviceRequestId)
		throws NoSuchServiceRequestException {

		return findByPrimaryKey((Serializable)serviceRequestId);
	}

	/**
	 * Returns the service request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param serviceRequestId the primary key of the service request
	 * @return the service request, or <code>null</code> if a service request with the primary key could not be found
	 */
	@Override
	public ServiceRequest fetchByPrimaryKey(long serviceRequestId) {
		return fetchByPrimaryKey((Serializable)serviceRequestId);
	}

	/**
	 * Returns all the service requests.
	 *
	 * @return the service requests
	 */
	@Override
	public List<ServiceRequest> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of service requests
	 * @param end the upper bound of the range of service requests (not inclusive)
	 * @return the range of service requests
	 */
	@Override
	public List<ServiceRequest> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the service requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of service requests
	 * @param end the upper bound of the range of service requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of service requests
	 */
	@Override
	public List<ServiceRequest> findAll(
		int start, int end,
		OrderByComparator<ServiceRequest> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the service requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of service requests
	 * @param end the upper bound of the range of service requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of service requests
	 */
	@Override
	public List<ServiceRequest> findAll(
		int start, int end, OrderByComparator<ServiceRequest> orderByComparator,
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

		List<ServiceRequest> list = null;

		if (useFinderCache) {
			list = (List<ServiceRequest>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SERVICEREQUEST);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SERVICEREQUEST;

				sql = sql.concat(ServiceRequestModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ServiceRequest>)QueryUtil.list(
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
	 * Removes all the service requests from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ServiceRequest serviceRequest : findAll()) {
			remove(serviceRequest);
		}
	}

	/**
	 * Returns the number of service requests.
	 *
	 * @return the number of service requests
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SERVICEREQUEST);

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
		return "serviceRequestId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SERVICEREQUEST;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ServiceRequestModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the service request persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new ServiceRequestModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", ServiceRequest.class.getName()));

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

		_finderPathWithPaginationFindByJoiningProcessId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByJoiningProcessId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"joiningProcessId"}, true);

		_finderPathWithoutPaginationFindByJoiningProcessId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByJoiningProcessId",
			new String[] {Long.class.getName()},
			new String[] {"joiningProcessId"}, true);

		_finderPathCountByJoiningProcessId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByJoiningProcessId", new String[] {Long.class.getName()},
			new String[] {"joiningProcessId"}, false);

		_finderPathWithPaginationFindByStatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"status"}, true);

		_finderPathWithoutPaginationFindByStatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] {Integer.class.getName()}, new String[] {"status"},
			true);

		_finderPathCountByStatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] {Integer.class.getName()}, new String[] {"status"},
			false);

		_finderPathWithPaginationFindByStatusAndOrganization =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByStatusAndOrganization",
				new String[] {
					Integer.class.getName(), Long.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {"status", "organizationId"}, true);

		_finderPathWithoutPaginationFindByStatusAndOrganization =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByStatusAndOrganization",
				new String[] {Integer.class.getName(), Long.class.getName()},
				new String[] {"status", "organizationId"}, true);

		_finderPathCountByStatusAndOrganization = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByStatusAndOrganization",
			new String[] {Integer.class.getName(), Long.class.getName()},
			new String[] {"status", "organizationId"}, false);

		_finderPathWithPaginationFindByServiceRequestTypeIdAndDeleted =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByServiceRequestTypeIdAndDeleted",
				new String[] {
					Long.class.getName(), Boolean.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {"serviceRequestTypeId", "deleted"}, true);

		_finderPathWithoutPaginationFindByServiceRequestTypeIdAndDeleted =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByServiceRequestTypeIdAndDeleted",
				new String[] {Long.class.getName(), Boolean.class.getName()},
				new String[] {"serviceRequestTypeId", "deleted"}, true);

		_finderPathCountByServiceRequestTypeIdAndDeleted = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByServiceRequestTypeIdAndDeleted",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"serviceRequestTypeId", "deleted"}, false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(ServiceRequestImpl.class.getName());

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

	private static final String _SQL_SELECT_SERVICEREQUEST =
		"SELECT serviceRequest FROM ServiceRequest serviceRequest";

	private static final String _SQL_SELECT_SERVICEREQUEST_WHERE =
		"SELECT serviceRequest FROM ServiceRequest serviceRequest WHERE ";

	private static final String _SQL_COUNT_SERVICEREQUEST =
		"SELECT COUNT(serviceRequest) FROM ServiceRequest serviceRequest";

	private static final String _SQL_COUNT_SERVICEREQUEST_WHERE =
		"SELECT COUNT(serviceRequest) FROM ServiceRequest serviceRequest WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "serviceRequest.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ServiceRequest exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ServiceRequest exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ServiceRequestPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"active", "state"});

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

	private static class ServiceRequestModelArgumentsResolver
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

			ServiceRequestModelImpl serviceRequestModelImpl =
				(ServiceRequestModelImpl)baseModel;

			long columnBitmask = serviceRequestModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					serviceRequestModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						serviceRequestModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					serviceRequestModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			ServiceRequestModelImpl serviceRequestModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						serviceRequestModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = serviceRequestModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}