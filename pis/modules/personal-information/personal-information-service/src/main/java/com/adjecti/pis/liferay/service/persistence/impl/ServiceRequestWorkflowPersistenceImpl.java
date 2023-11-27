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

import com.adjecti.pis.liferay.exception.NoSuchServiceRequestWorkflowException;
import com.adjecti.pis.liferay.model.ServiceRequestWorkflow;
import com.adjecti.pis.liferay.model.impl.ServiceRequestWorkflowImpl;
import com.adjecti.pis.liferay.model.impl.ServiceRequestWorkflowModelImpl;
import com.adjecti.pis.liferay.service.persistence.ServiceRequestWorkflowPersistence;
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
 * The persistence implementation for the service request workflow service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ServiceRequestWorkflowPersistence.class)
public class ServiceRequestWorkflowPersistenceImpl
	extends BasePersistenceImpl<ServiceRequestWorkflow>
	implements ServiceRequestWorkflowPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ServiceRequestWorkflowUtil</code> to access the service request workflow persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ServiceRequestWorkflowImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByServiceRequestId;
	private FinderPath _finderPathWithoutPaginationFindByServiceRequestId;
	private FinderPath _finderPathCountByServiceRequestId;

	/**
	 * Returns all the service request workflows where serviceRequestId = &#63;.
	 *
	 * @param serviceRequestId the service request ID
	 * @return the matching service request workflows
	 */
	@Override
	public List<ServiceRequestWorkflow> findByServiceRequestId(
		long serviceRequestId) {

		return findByServiceRequestId(
			serviceRequestId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service request workflows where serviceRequestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param serviceRequestId the service request ID
	 * @param start the lower bound of the range of service request workflows
	 * @param end the upper bound of the range of service request workflows (not inclusive)
	 * @return the range of matching service request workflows
	 */
	@Override
	public List<ServiceRequestWorkflow> findByServiceRequestId(
		long serviceRequestId, int start, int end) {

		return findByServiceRequestId(serviceRequestId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the service request workflows where serviceRequestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param serviceRequestId the service request ID
	 * @param start the lower bound of the range of service request workflows
	 * @param end the upper bound of the range of service request workflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service request workflows
	 */
	@Override
	public List<ServiceRequestWorkflow> findByServiceRequestId(
		long serviceRequestId, int start, int end,
		OrderByComparator<ServiceRequestWorkflow> orderByComparator) {

		return findByServiceRequestId(
			serviceRequestId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the service request workflows where serviceRequestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param serviceRequestId the service request ID
	 * @param start the lower bound of the range of service request workflows
	 * @param end the upper bound of the range of service request workflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching service request workflows
	 */
	@Override
	public List<ServiceRequestWorkflow> findByServiceRequestId(
		long serviceRequestId, int start, int end,
		OrderByComparator<ServiceRequestWorkflow> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByServiceRequestId;
				finderArgs = new Object[] {serviceRequestId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByServiceRequestId;
			finderArgs = new Object[] {
				serviceRequestId, start, end, orderByComparator
			};
		}

		List<ServiceRequestWorkflow> list = null;

		if (useFinderCache) {
			list = (List<ServiceRequestWorkflow>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ServiceRequestWorkflow serviceRequestWorkflow : list) {
					if (serviceRequestId !=
							serviceRequestWorkflow.getServiceRequestId()) {

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

			sb.append(_SQL_SELECT_SERVICEREQUESTWORKFLOW_WHERE);

			sb.append(_FINDER_COLUMN_SERVICEREQUESTID_SERVICEREQUESTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ServiceRequestWorkflowModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(serviceRequestId);

				list = (List<ServiceRequestWorkflow>)QueryUtil.list(
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
	 * Returns the first service request workflow in the ordered set where serviceRequestId = &#63;.
	 *
	 * @param serviceRequestId the service request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request workflow
	 * @throws NoSuchServiceRequestWorkflowException if a matching service request workflow could not be found
	 */
	@Override
	public ServiceRequestWorkflow findByServiceRequestId_First(
			long serviceRequestId,
			OrderByComparator<ServiceRequestWorkflow> orderByComparator)
		throws NoSuchServiceRequestWorkflowException {

		ServiceRequestWorkflow serviceRequestWorkflow =
			fetchByServiceRequestId_First(serviceRequestId, orderByComparator);

		if (serviceRequestWorkflow != null) {
			return serviceRequestWorkflow;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("serviceRequestId=");
		sb.append(serviceRequestId);

		sb.append("}");

		throw new NoSuchServiceRequestWorkflowException(sb.toString());
	}

	/**
	 * Returns the first service request workflow in the ordered set where serviceRequestId = &#63;.
	 *
	 * @param serviceRequestId the service request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request workflow, or <code>null</code> if a matching service request workflow could not be found
	 */
	@Override
	public ServiceRequestWorkflow fetchByServiceRequestId_First(
		long serviceRequestId,
		OrderByComparator<ServiceRequestWorkflow> orderByComparator) {

		List<ServiceRequestWorkflow> list = findByServiceRequestId(
			serviceRequestId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last service request workflow in the ordered set where serviceRequestId = &#63;.
	 *
	 * @param serviceRequestId the service request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request workflow
	 * @throws NoSuchServiceRequestWorkflowException if a matching service request workflow could not be found
	 */
	@Override
	public ServiceRequestWorkflow findByServiceRequestId_Last(
			long serviceRequestId,
			OrderByComparator<ServiceRequestWorkflow> orderByComparator)
		throws NoSuchServiceRequestWorkflowException {

		ServiceRequestWorkflow serviceRequestWorkflow =
			fetchByServiceRequestId_Last(serviceRequestId, orderByComparator);

		if (serviceRequestWorkflow != null) {
			return serviceRequestWorkflow;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("serviceRequestId=");
		sb.append(serviceRequestId);

		sb.append("}");

		throw new NoSuchServiceRequestWorkflowException(sb.toString());
	}

	/**
	 * Returns the last service request workflow in the ordered set where serviceRequestId = &#63;.
	 *
	 * @param serviceRequestId the service request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request workflow, or <code>null</code> if a matching service request workflow could not be found
	 */
	@Override
	public ServiceRequestWorkflow fetchByServiceRequestId_Last(
		long serviceRequestId,
		OrderByComparator<ServiceRequestWorkflow> orderByComparator) {

		int count = countByServiceRequestId(serviceRequestId);

		if (count == 0) {
			return null;
		}

		List<ServiceRequestWorkflow> list = findByServiceRequestId(
			serviceRequestId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the service request workflows before and after the current service request workflow in the ordered set where serviceRequestId = &#63;.
	 *
	 * @param serviceRequestWorkflowId the primary key of the current service request workflow
	 * @param serviceRequestId the service request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service request workflow
	 * @throws NoSuchServiceRequestWorkflowException if a service request workflow with the primary key could not be found
	 */
	@Override
	public ServiceRequestWorkflow[] findByServiceRequestId_PrevAndNext(
			long serviceRequestWorkflowId, long serviceRequestId,
			OrderByComparator<ServiceRequestWorkflow> orderByComparator)
		throws NoSuchServiceRequestWorkflowException {

		ServiceRequestWorkflow serviceRequestWorkflow = findByPrimaryKey(
			serviceRequestWorkflowId);

		Session session = null;

		try {
			session = openSession();

			ServiceRequestWorkflow[] array = new ServiceRequestWorkflowImpl[3];

			array[0] = getByServiceRequestId_PrevAndNext(
				session, serviceRequestWorkflow, serviceRequestId,
				orderByComparator, true);

			array[1] = serviceRequestWorkflow;

			array[2] = getByServiceRequestId_PrevAndNext(
				session, serviceRequestWorkflow, serviceRequestId,
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

	protected ServiceRequestWorkflow getByServiceRequestId_PrevAndNext(
		Session session, ServiceRequestWorkflow serviceRequestWorkflow,
		long serviceRequestId,
		OrderByComparator<ServiceRequestWorkflow> orderByComparator,
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

		sb.append(_SQL_SELECT_SERVICEREQUESTWORKFLOW_WHERE);

		sb.append(_FINDER_COLUMN_SERVICEREQUESTID_SERVICEREQUESTID_2);

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
			sb.append(ServiceRequestWorkflowModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(serviceRequestId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						serviceRequestWorkflow)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ServiceRequestWorkflow> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the service request workflows where serviceRequestId = &#63; from the database.
	 *
	 * @param serviceRequestId the service request ID
	 */
	@Override
	public void removeByServiceRequestId(long serviceRequestId) {
		for (ServiceRequestWorkflow serviceRequestWorkflow :
				findByServiceRequestId(
					serviceRequestId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(serviceRequestWorkflow);
		}
	}

	/**
	 * Returns the number of service request workflows where serviceRequestId = &#63;.
	 *
	 * @param serviceRequestId the service request ID
	 * @return the number of matching service request workflows
	 */
	@Override
	public int countByServiceRequestId(long serviceRequestId) {
		FinderPath finderPath = _finderPathCountByServiceRequestId;

		Object[] finderArgs = new Object[] {serviceRequestId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SERVICEREQUESTWORKFLOW_WHERE);

			sb.append(_FINDER_COLUMN_SERVICEREQUESTID_SERVICEREQUESTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(serviceRequestId);

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
		_FINDER_COLUMN_SERVICEREQUESTID_SERVICEREQUESTID_2 =
			"serviceRequestWorkflow.serviceRequestId = ?";

	private FinderPath _finderPathWithPaginationFindByEmployeeId;
	private FinderPath _finderPathWithoutPaginationFindByEmployeeId;
	private FinderPath _finderPathCountByEmployeeId;

	/**
	 * Returns all the service request workflows where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching service request workflows
	 */
	@Override
	public List<ServiceRequestWorkflow> findByEmployeeId(long employeeId) {
		return findByEmployeeId(
			employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service request workflows where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of service request workflows
	 * @param end the upper bound of the range of service request workflows (not inclusive)
	 * @return the range of matching service request workflows
	 */
	@Override
	public List<ServiceRequestWorkflow> findByEmployeeId(
		long employeeId, int start, int end) {

		return findByEmployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the service request workflows where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of service request workflows
	 * @param end the upper bound of the range of service request workflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service request workflows
	 */
	@Override
	public List<ServiceRequestWorkflow> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<ServiceRequestWorkflow> orderByComparator) {

		return findByEmployeeId(
			employeeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the service request workflows where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of service request workflows
	 * @param end the upper bound of the range of service request workflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching service request workflows
	 */
	@Override
	public List<ServiceRequestWorkflow> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<ServiceRequestWorkflow> orderByComparator,
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

		List<ServiceRequestWorkflow> list = null;

		if (useFinderCache) {
			list = (List<ServiceRequestWorkflow>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ServiceRequestWorkflow serviceRequestWorkflow : list) {
					if (employeeId != serviceRequestWorkflow.getEmployeeId()) {
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

			sb.append(_SQL_SELECT_SERVICEREQUESTWORKFLOW_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ServiceRequestWorkflowModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				list = (List<ServiceRequestWorkflow>)QueryUtil.list(
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
	 * Returns the first service request workflow in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request workflow
	 * @throws NoSuchServiceRequestWorkflowException if a matching service request workflow could not be found
	 */
	@Override
	public ServiceRequestWorkflow findByEmployeeId_First(
			long employeeId,
			OrderByComparator<ServiceRequestWorkflow> orderByComparator)
		throws NoSuchServiceRequestWorkflowException {

		ServiceRequestWorkflow serviceRequestWorkflow = fetchByEmployeeId_First(
			employeeId, orderByComparator);

		if (serviceRequestWorkflow != null) {
			return serviceRequestWorkflow;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchServiceRequestWorkflowException(sb.toString());
	}

	/**
	 * Returns the first service request workflow in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request workflow, or <code>null</code> if a matching service request workflow could not be found
	 */
	@Override
	public ServiceRequestWorkflow fetchByEmployeeId_First(
		long employeeId,
		OrderByComparator<ServiceRequestWorkflow> orderByComparator) {

		List<ServiceRequestWorkflow> list = findByEmployeeId(
			employeeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last service request workflow in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request workflow
	 * @throws NoSuchServiceRequestWorkflowException if a matching service request workflow could not be found
	 */
	@Override
	public ServiceRequestWorkflow findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<ServiceRequestWorkflow> orderByComparator)
		throws NoSuchServiceRequestWorkflowException {

		ServiceRequestWorkflow serviceRequestWorkflow = fetchByEmployeeId_Last(
			employeeId, orderByComparator);

		if (serviceRequestWorkflow != null) {
			return serviceRequestWorkflow;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchServiceRequestWorkflowException(sb.toString());
	}

	/**
	 * Returns the last service request workflow in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request workflow, or <code>null</code> if a matching service request workflow could not be found
	 */
	@Override
	public ServiceRequestWorkflow fetchByEmployeeId_Last(
		long employeeId,
		OrderByComparator<ServiceRequestWorkflow> orderByComparator) {

		int count = countByEmployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<ServiceRequestWorkflow> list = findByEmployeeId(
			employeeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the service request workflows before and after the current service request workflow in the ordered set where employeeId = &#63;.
	 *
	 * @param serviceRequestWorkflowId the primary key of the current service request workflow
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service request workflow
	 * @throws NoSuchServiceRequestWorkflowException if a service request workflow with the primary key could not be found
	 */
	@Override
	public ServiceRequestWorkflow[] findByEmployeeId_PrevAndNext(
			long serviceRequestWorkflowId, long employeeId,
			OrderByComparator<ServiceRequestWorkflow> orderByComparator)
		throws NoSuchServiceRequestWorkflowException {

		ServiceRequestWorkflow serviceRequestWorkflow = findByPrimaryKey(
			serviceRequestWorkflowId);

		Session session = null;

		try {
			session = openSession();

			ServiceRequestWorkflow[] array = new ServiceRequestWorkflowImpl[3];

			array[0] = getByEmployeeId_PrevAndNext(
				session, serviceRequestWorkflow, employeeId, orderByComparator,
				true);

			array[1] = serviceRequestWorkflow;

			array[2] = getByEmployeeId_PrevAndNext(
				session, serviceRequestWorkflow, employeeId, orderByComparator,
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

	protected ServiceRequestWorkflow getByEmployeeId_PrevAndNext(
		Session session, ServiceRequestWorkflow serviceRequestWorkflow,
		long employeeId,
		OrderByComparator<ServiceRequestWorkflow> orderByComparator,
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

		sb.append(_SQL_SELECT_SERVICEREQUESTWORKFLOW_WHERE);

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
			sb.append(ServiceRequestWorkflowModelImpl.ORDER_BY_JPQL);
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
						serviceRequestWorkflow)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ServiceRequestWorkflow> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the service request workflows where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeByEmployeeId(long employeeId) {
		for (ServiceRequestWorkflow serviceRequestWorkflow :
				findByEmployeeId(
					employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(serviceRequestWorkflow);
		}
	}

	/**
	 * Returns the number of service request workflows where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching service request workflows
	 */
	@Override
	public int countByEmployeeId(long employeeId) {
		FinderPath finderPath = _finderPathCountByEmployeeId;

		Object[] finderArgs = new Object[] {employeeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SERVICEREQUESTWORKFLOW_WHERE);

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
		"serviceRequestWorkflow.employeeId = ?";

	private FinderPath _finderPathWithPaginationFindByEmployeeIdAndClassName;
	private FinderPath _finderPathWithoutPaginationFindByEmployeeIdAndClassName;
	private FinderPath _finderPathCountByEmployeeIdAndClassName;

	/**
	 * Returns all the service request workflows where employeeId = &#63; and className = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param className the class name
	 * @return the matching service request workflows
	 */
	@Override
	public List<ServiceRequestWorkflow> findByEmployeeIdAndClassName(
		long employeeId, String className) {

		return findByEmployeeIdAndClassName(
			employeeId, className, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service request workflows where employeeId = &#63; and className = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param className the class name
	 * @param start the lower bound of the range of service request workflows
	 * @param end the upper bound of the range of service request workflows (not inclusive)
	 * @return the range of matching service request workflows
	 */
	@Override
	public List<ServiceRequestWorkflow> findByEmployeeIdAndClassName(
		long employeeId, String className, int start, int end) {

		return findByEmployeeIdAndClassName(
			employeeId, className, start, end, null);
	}

	/**
	 * Returns an ordered range of all the service request workflows where employeeId = &#63; and className = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param className the class name
	 * @param start the lower bound of the range of service request workflows
	 * @param end the upper bound of the range of service request workflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service request workflows
	 */
	@Override
	public List<ServiceRequestWorkflow> findByEmployeeIdAndClassName(
		long employeeId, String className, int start, int end,
		OrderByComparator<ServiceRequestWorkflow> orderByComparator) {

		return findByEmployeeIdAndClassName(
			employeeId, className, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the service request workflows where employeeId = &#63; and className = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param className the class name
	 * @param start the lower bound of the range of service request workflows
	 * @param end the upper bound of the range of service request workflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching service request workflows
	 */
	@Override
	public List<ServiceRequestWorkflow> findByEmployeeIdAndClassName(
		long employeeId, String className, int start, int end,
		OrderByComparator<ServiceRequestWorkflow> orderByComparator,
		boolean useFinderCache) {

		className = Objects.toString(className, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByEmployeeIdAndClassName;
				finderArgs = new Object[] {employeeId, className};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByEmployeeIdAndClassName;
			finderArgs = new Object[] {
				employeeId, className, start, end, orderByComparator
			};
		}

		List<ServiceRequestWorkflow> list = null;

		if (useFinderCache) {
			list = (List<ServiceRequestWorkflow>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ServiceRequestWorkflow serviceRequestWorkflow : list) {
					if ((employeeId !=
							serviceRequestWorkflow.getEmployeeId()) ||
						!className.equals(
							serviceRequestWorkflow.getClassName())) {

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

			sb.append(_SQL_SELECT_SERVICEREQUESTWORKFLOW_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEIDANDCLASSNAME_EMPLOYEEID_2);

			boolean bindClassName = false;

			if (className.isEmpty()) {
				sb.append(_FINDER_COLUMN_EMPLOYEEIDANDCLASSNAME_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				sb.append(_FINDER_COLUMN_EMPLOYEEIDANDCLASSNAME_CLASSNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ServiceRequestWorkflowModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				if (bindClassName) {
					queryPos.add(className);
				}

				list = (List<ServiceRequestWorkflow>)QueryUtil.list(
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
	 * Returns the first service request workflow in the ordered set where employeeId = &#63; and className = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request workflow
	 * @throws NoSuchServiceRequestWorkflowException if a matching service request workflow could not be found
	 */
	@Override
	public ServiceRequestWorkflow findByEmployeeIdAndClassName_First(
			long employeeId, String className,
			OrderByComparator<ServiceRequestWorkflow> orderByComparator)
		throws NoSuchServiceRequestWorkflowException {

		ServiceRequestWorkflow serviceRequestWorkflow =
			fetchByEmployeeIdAndClassName_First(
				employeeId, className, orderByComparator);

		if (serviceRequestWorkflow != null) {
			return serviceRequestWorkflow;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append(", className=");
		sb.append(className);

		sb.append("}");

		throw new NoSuchServiceRequestWorkflowException(sb.toString());
	}

	/**
	 * Returns the first service request workflow in the ordered set where employeeId = &#63; and className = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request workflow, or <code>null</code> if a matching service request workflow could not be found
	 */
	@Override
	public ServiceRequestWorkflow fetchByEmployeeIdAndClassName_First(
		long employeeId, String className,
		OrderByComparator<ServiceRequestWorkflow> orderByComparator) {

		List<ServiceRequestWorkflow> list = findByEmployeeIdAndClassName(
			employeeId, className, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last service request workflow in the ordered set where employeeId = &#63; and className = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request workflow
	 * @throws NoSuchServiceRequestWorkflowException if a matching service request workflow could not be found
	 */
	@Override
	public ServiceRequestWorkflow findByEmployeeIdAndClassName_Last(
			long employeeId, String className,
			OrderByComparator<ServiceRequestWorkflow> orderByComparator)
		throws NoSuchServiceRequestWorkflowException {

		ServiceRequestWorkflow serviceRequestWorkflow =
			fetchByEmployeeIdAndClassName_Last(
				employeeId, className, orderByComparator);

		if (serviceRequestWorkflow != null) {
			return serviceRequestWorkflow;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append(", className=");
		sb.append(className);

		sb.append("}");

		throw new NoSuchServiceRequestWorkflowException(sb.toString());
	}

	/**
	 * Returns the last service request workflow in the ordered set where employeeId = &#63; and className = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request workflow, or <code>null</code> if a matching service request workflow could not be found
	 */
	@Override
	public ServiceRequestWorkflow fetchByEmployeeIdAndClassName_Last(
		long employeeId, String className,
		OrderByComparator<ServiceRequestWorkflow> orderByComparator) {

		int count = countByEmployeeIdAndClassName(employeeId, className);

		if (count == 0) {
			return null;
		}

		List<ServiceRequestWorkflow> list = findByEmployeeIdAndClassName(
			employeeId, className, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the service request workflows before and after the current service request workflow in the ordered set where employeeId = &#63; and className = &#63;.
	 *
	 * @param serviceRequestWorkflowId the primary key of the current service request workflow
	 * @param employeeId the employee ID
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service request workflow
	 * @throws NoSuchServiceRequestWorkflowException if a service request workflow with the primary key could not be found
	 */
	@Override
	public ServiceRequestWorkflow[] findByEmployeeIdAndClassName_PrevAndNext(
			long serviceRequestWorkflowId, long employeeId, String className,
			OrderByComparator<ServiceRequestWorkflow> orderByComparator)
		throws NoSuchServiceRequestWorkflowException {

		className = Objects.toString(className, "");

		ServiceRequestWorkflow serviceRequestWorkflow = findByPrimaryKey(
			serviceRequestWorkflowId);

		Session session = null;

		try {
			session = openSession();

			ServiceRequestWorkflow[] array = new ServiceRequestWorkflowImpl[3];

			array[0] = getByEmployeeIdAndClassName_PrevAndNext(
				session, serviceRequestWorkflow, employeeId, className,
				orderByComparator, true);

			array[1] = serviceRequestWorkflow;

			array[2] = getByEmployeeIdAndClassName_PrevAndNext(
				session, serviceRequestWorkflow, employeeId, className,
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

	protected ServiceRequestWorkflow getByEmployeeIdAndClassName_PrevAndNext(
		Session session, ServiceRequestWorkflow serviceRequestWorkflow,
		long employeeId, String className,
		OrderByComparator<ServiceRequestWorkflow> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_SERVICEREQUESTWORKFLOW_WHERE);

		sb.append(_FINDER_COLUMN_EMPLOYEEIDANDCLASSNAME_EMPLOYEEID_2);

		boolean bindClassName = false;

		if (className.isEmpty()) {
			sb.append(_FINDER_COLUMN_EMPLOYEEIDANDCLASSNAME_CLASSNAME_3);
		}
		else {
			bindClassName = true;

			sb.append(_FINDER_COLUMN_EMPLOYEEIDANDCLASSNAME_CLASSNAME_2);
		}

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
			sb.append(ServiceRequestWorkflowModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(employeeId);

		if (bindClassName) {
			queryPos.add(className);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						serviceRequestWorkflow)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ServiceRequestWorkflow> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the service request workflows where employeeId = &#63; and className = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param className the class name
	 */
	@Override
	public void removeByEmployeeIdAndClassName(
		long employeeId, String className) {

		for (ServiceRequestWorkflow serviceRequestWorkflow :
				findByEmployeeIdAndClassName(
					employeeId, className, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(serviceRequestWorkflow);
		}
	}

	/**
	 * Returns the number of service request workflows where employeeId = &#63; and className = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param className the class name
	 * @return the number of matching service request workflows
	 */
	@Override
	public int countByEmployeeIdAndClassName(
		long employeeId, String className) {

		className = Objects.toString(className, "");

		FinderPath finderPath = _finderPathCountByEmployeeIdAndClassName;

		Object[] finderArgs = new Object[] {employeeId, className};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SERVICEREQUESTWORKFLOW_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEIDANDCLASSNAME_EMPLOYEEID_2);

			boolean bindClassName = false;

			if (className.isEmpty()) {
				sb.append(_FINDER_COLUMN_EMPLOYEEIDANDCLASSNAME_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				sb.append(_FINDER_COLUMN_EMPLOYEEIDANDCLASSNAME_CLASSNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				if (bindClassName) {
					queryPos.add(className);
				}

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
		_FINDER_COLUMN_EMPLOYEEIDANDCLASSNAME_EMPLOYEEID_2 =
			"serviceRequestWorkflow.employeeId = ? AND ";

	private static final String
		_FINDER_COLUMN_EMPLOYEEIDANDCLASSNAME_CLASSNAME_2 =
			"serviceRequestWorkflow.className = ?";

	private static final String
		_FINDER_COLUMN_EMPLOYEEIDANDCLASSNAME_CLASSNAME_3 =
			"(serviceRequestWorkflow.className IS NULL OR serviceRequestWorkflow.className = '')";

	public ServiceRequestWorkflowPersistenceImpl() {
		setModelClass(ServiceRequestWorkflow.class);

		setModelImplClass(ServiceRequestWorkflowImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the service request workflow in the entity cache if it is enabled.
	 *
	 * @param serviceRequestWorkflow the service request workflow
	 */
	@Override
	public void cacheResult(ServiceRequestWorkflow serviceRequestWorkflow) {
		entityCache.putResult(
			ServiceRequestWorkflowImpl.class,
			serviceRequestWorkflow.getPrimaryKey(), serviceRequestWorkflow);
	}

	/**
	 * Caches the service request workflows in the entity cache if it is enabled.
	 *
	 * @param serviceRequestWorkflows the service request workflows
	 */
	@Override
	public void cacheResult(
		List<ServiceRequestWorkflow> serviceRequestWorkflows) {

		for (ServiceRequestWorkflow serviceRequestWorkflow :
				serviceRequestWorkflows) {

			if (entityCache.getResult(
					ServiceRequestWorkflowImpl.class,
					serviceRequestWorkflow.getPrimaryKey()) == null) {

				cacheResult(serviceRequestWorkflow);
			}
		}
	}

	/**
	 * Clears the cache for all service request workflows.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ServiceRequestWorkflowImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the service request workflow.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ServiceRequestWorkflow serviceRequestWorkflow) {
		entityCache.removeResult(
			ServiceRequestWorkflowImpl.class, serviceRequestWorkflow);
	}

	@Override
	public void clearCache(
		List<ServiceRequestWorkflow> serviceRequestWorkflows) {

		for (ServiceRequestWorkflow serviceRequestWorkflow :
				serviceRequestWorkflows) {

			entityCache.removeResult(
				ServiceRequestWorkflowImpl.class, serviceRequestWorkflow);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				ServiceRequestWorkflowImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new service request workflow with the primary key. Does not add the service request workflow to the database.
	 *
	 * @param serviceRequestWorkflowId the primary key for the new service request workflow
	 * @return the new service request workflow
	 */
	@Override
	public ServiceRequestWorkflow create(long serviceRequestWorkflowId) {
		ServiceRequestWorkflow serviceRequestWorkflow =
			new ServiceRequestWorkflowImpl();

		serviceRequestWorkflow.setNew(true);
		serviceRequestWorkflow.setPrimaryKey(serviceRequestWorkflowId);

		serviceRequestWorkflow.setCompanyId(CompanyThreadLocal.getCompanyId());

		return serviceRequestWorkflow;
	}

	/**
	 * Removes the service request workflow with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param serviceRequestWorkflowId the primary key of the service request workflow
	 * @return the service request workflow that was removed
	 * @throws NoSuchServiceRequestWorkflowException if a service request workflow with the primary key could not be found
	 */
	@Override
	public ServiceRequestWorkflow remove(long serviceRequestWorkflowId)
		throws NoSuchServiceRequestWorkflowException {

		return remove((Serializable)serviceRequestWorkflowId);
	}

	/**
	 * Removes the service request workflow with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the service request workflow
	 * @return the service request workflow that was removed
	 * @throws NoSuchServiceRequestWorkflowException if a service request workflow with the primary key could not be found
	 */
	@Override
	public ServiceRequestWorkflow remove(Serializable primaryKey)
		throws NoSuchServiceRequestWorkflowException {

		Session session = null;

		try {
			session = openSession();

			ServiceRequestWorkflow serviceRequestWorkflow =
				(ServiceRequestWorkflow)session.get(
					ServiceRequestWorkflowImpl.class, primaryKey);

			if (serviceRequestWorkflow == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchServiceRequestWorkflowException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(serviceRequestWorkflow);
		}
		catch (NoSuchServiceRequestWorkflowException noSuchEntityException) {
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
	protected ServiceRequestWorkflow removeImpl(
		ServiceRequestWorkflow serviceRequestWorkflow) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(serviceRequestWorkflow)) {
				serviceRequestWorkflow = (ServiceRequestWorkflow)session.get(
					ServiceRequestWorkflowImpl.class,
					serviceRequestWorkflow.getPrimaryKeyObj());
			}

			if (serviceRequestWorkflow != null) {
				session.delete(serviceRequestWorkflow);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (serviceRequestWorkflow != null) {
			clearCache(serviceRequestWorkflow);
		}

		return serviceRequestWorkflow;
	}

	@Override
	public ServiceRequestWorkflow updateImpl(
		ServiceRequestWorkflow serviceRequestWorkflow) {

		boolean isNew = serviceRequestWorkflow.isNew();

		if (!(serviceRequestWorkflow instanceof
				ServiceRequestWorkflowModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(serviceRequestWorkflow.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					serviceRequestWorkflow);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in serviceRequestWorkflow proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ServiceRequestWorkflow implementation " +
					serviceRequestWorkflow.getClass());
		}

		ServiceRequestWorkflowModelImpl serviceRequestWorkflowModelImpl =
			(ServiceRequestWorkflowModelImpl)serviceRequestWorkflow;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (serviceRequestWorkflow.getCreateDate() == null)) {
			if (serviceContext == null) {
				serviceRequestWorkflow.setCreateDate(now);
			}
			else {
				serviceRequestWorkflow.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!serviceRequestWorkflowModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				serviceRequestWorkflow.setModifiedDate(now);
			}
			else {
				serviceRequestWorkflow.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(serviceRequestWorkflow);
			}
			else {
				serviceRequestWorkflow = (ServiceRequestWorkflow)session.merge(
					serviceRequestWorkflow);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ServiceRequestWorkflowImpl.class, serviceRequestWorkflowModelImpl,
			false, true);

		if (isNew) {
			serviceRequestWorkflow.setNew(false);
		}

		serviceRequestWorkflow.resetOriginalValues();

		return serviceRequestWorkflow;
	}

	/**
	 * Returns the service request workflow with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the service request workflow
	 * @return the service request workflow
	 * @throws NoSuchServiceRequestWorkflowException if a service request workflow with the primary key could not be found
	 */
	@Override
	public ServiceRequestWorkflow findByPrimaryKey(Serializable primaryKey)
		throws NoSuchServiceRequestWorkflowException {

		ServiceRequestWorkflow serviceRequestWorkflow = fetchByPrimaryKey(
			primaryKey);

		if (serviceRequestWorkflow == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchServiceRequestWorkflowException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return serviceRequestWorkflow;
	}

	/**
	 * Returns the service request workflow with the primary key or throws a <code>NoSuchServiceRequestWorkflowException</code> if it could not be found.
	 *
	 * @param serviceRequestWorkflowId the primary key of the service request workflow
	 * @return the service request workflow
	 * @throws NoSuchServiceRequestWorkflowException if a service request workflow with the primary key could not be found
	 */
	@Override
	public ServiceRequestWorkflow findByPrimaryKey(
			long serviceRequestWorkflowId)
		throws NoSuchServiceRequestWorkflowException {

		return findByPrimaryKey((Serializable)serviceRequestWorkflowId);
	}

	/**
	 * Returns the service request workflow with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param serviceRequestWorkflowId the primary key of the service request workflow
	 * @return the service request workflow, or <code>null</code> if a service request workflow with the primary key could not be found
	 */
	@Override
	public ServiceRequestWorkflow fetchByPrimaryKey(
		long serviceRequestWorkflowId) {

		return fetchByPrimaryKey((Serializable)serviceRequestWorkflowId);
	}

	/**
	 * Returns all the service request workflows.
	 *
	 * @return the service request workflows
	 */
	@Override
	public List<ServiceRequestWorkflow> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service request workflows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of service request workflows
	 * @param end the upper bound of the range of service request workflows (not inclusive)
	 * @return the range of service request workflows
	 */
	@Override
	public List<ServiceRequestWorkflow> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the service request workflows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of service request workflows
	 * @param end the upper bound of the range of service request workflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of service request workflows
	 */
	@Override
	public List<ServiceRequestWorkflow> findAll(
		int start, int end,
		OrderByComparator<ServiceRequestWorkflow> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the service request workflows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of service request workflows
	 * @param end the upper bound of the range of service request workflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of service request workflows
	 */
	@Override
	public List<ServiceRequestWorkflow> findAll(
		int start, int end,
		OrderByComparator<ServiceRequestWorkflow> orderByComparator,
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

		List<ServiceRequestWorkflow> list = null;

		if (useFinderCache) {
			list = (List<ServiceRequestWorkflow>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SERVICEREQUESTWORKFLOW);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SERVICEREQUESTWORKFLOW;

				sql = sql.concat(ServiceRequestWorkflowModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ServiceRequestWorkflow>)QueryUtil.list(
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
	 * Removes all the service request workflows from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ServiceRequestWorkflow serviceRequestWorkflow : findAll()) {
			remove(serviceRequestWorkflow);
		}
	}

	/**
	 * Returns the number of service request workflows.
	 *
	 * @return the number of service request workflows
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
					_SQL_COUNT_SERVICEREQUESTWORKFLOW);

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
		return "serviceRequestWorkflowId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SERVICEREQUESTWORKFLOW;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ServiceRequestWorkflowModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the service request workflow persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new ServiceRequestWorkflowModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", ServiceRequestWorkflow.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByServiceRequestId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByServiceRequestId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"serviceRequestId"}, true);

		_finderPathWithoutPaginationFindByServiceRequestId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByServiceRequestId",
			new String[] {Long.class.getName()},
			new String[] {"serviceRequestId"}, true);

		_finderPathCountByServiceRequestId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByServiceRequestId", new String[] {Long.class.getName()},
			new String[] {"serviceRequestId"}, false);

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

		_finderPathWithPaginationFindByEmployeeIdAndClassName =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByEmployeeIdAndClassName",
				new String[] {
					Long.class.getName(), String.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {"employeeId", "className"}, true);

		_finderPathWithoutPaginationFindByEmployeeIdAndClassName =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByEmployeeIdAndClassName",
				new String[] {Long.class.getName(), String.class.getName()},
				new String[] {"employeeId", "className"}, true);

		_finderPathCountByEmployeeIdAndClassName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByEmployeeIdAndClassName",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"employeeId", "className"}, false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(ServiceRequestWorkflowImpl.class.getName());

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

	private static final String _SQL_SELECT_SERVICEREQUESTWORKFLOW =
		"SELECT serviceRequestWorkflow FROM ServiceRequestWorkflow serviceRequestWorkflow";

	private static final String _SQL_SELECT_SERVICEREQUESTWORKFLOW_WHERE =
		"SELECT serviceRequestWorkflow FROM ServiceRequestWorkflow serviceRequestWorkflow WHERE ";

	private static final String _SQL_COUNT_SERVICEREQUESTWORKFLOW =
		"SELECT COUNT(serviceRequestWorkflow) FROM ServiceRequestWorkflow serviceRequestWorkflow";

	private static final String _SQL_COUNT_SERVICEREQUESTWORKFLOW_WHERE =
		"SELECT COUNT(serviceRequestWorkflow) FROM ServiceRequestWorkflow serviceRequestWorkflow WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"serviceRequestWorkflow.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ServiceRequestWorkflow exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ServiceRequestWorkflow exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ServiceRequestWorkflowPersistenceImpl.class);

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

	private static class ServiceRequestWorkflowModelArgumentsResolver
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

			ServiceRequestWorkflowModelImpl serviceRequestWorkflowModelImpl =
				(ServiceRequestWorkflowModelImpl)baseModel;

			long columnBitmask =
				serviceRequestWorkflowModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					serviceRequestWorkflowModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						serviceRequestWorkflowModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					serviceRequestWorkflowModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			ServiceRequestWorkflowModelImpl serviceRequestWorkflowModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						serviceRequestWorkflowModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] =
						serviceRequestWorkflowModelImpl.getColumnValue(
							columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}