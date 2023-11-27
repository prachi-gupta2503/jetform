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

package net.ayudh.comnet.admin.service.persistence.impl;

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

import net.ayudh.comnet.admin.exception.NoSuchApplicationAccessException;
import net.ayudh.comnet.admin.model.ApplicationAccess;
import net.ayudh.comnet.admin.model.impl.ApplicationAccessImpl;
import net.ayudh.comnet.admin.model.impl.ApplicationAccessModelImpl;
import net.ayudh.comnet.admin.service.persistence.ApplicationAccessPersistence;
import net.ayudh.comnet.admin.service.persistence.impl.constants.comnetPersistenceConstants;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the application access service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ApplicationAccessPersistence.class)
public class ApplicationAccessPersistenceImpl
	extends BasePersistenceImpl<ApplicationAccess>
	implements ApplicationAccessPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ApplicationAccessUtil</code> to access the application access persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ApplicationAccessImpl.class.getName();

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
	 * Returns all the application accesses where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching application accesses
	 */
	@Override
	public List<ApplicationAccess> findByEmployeeId(long employeeId) {
		return findByEmployeeId(
			employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the application accesses where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApplicationAccessModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of application accesses
	 * @param end the upper bound of the range of application accesses (not inclusive)
	 * @return the range of matching application accesses
	 */
	@Override
	public List<ApplicationAccess> findByEmployeeId(
		long employeeId, int start, int end) {

		return findByEmployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the application accesses where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApplicationAccessModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of application accesses
	 * @param end the upper bound of the range of application accesses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching application accesses
	 */
	@Override
	public List<ApplicationAccess> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<ApplicationAccess> orderByComparator) {

		return findByEmployeeId(
			employeeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the application accesses where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApplicationAccessModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of application accesses
	 * @param end the upper bound of the range of application accesses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching application accesses
	 */
	@Override
	public List<ApplicationAccess> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<ApplicationAccess> orderByComparator,
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

		List<ApplicationAccess> list = null;

		if (useFinderCache) {
			list = (List<ApplicationAccess>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ApplicationAccess applicationAccess : list) {
					if (employeeId != applicationAccess.getEmployeeId()) {
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

			sb.append(_SQL_SELECT_APPLICATIONACCESS_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ApplicationAccessModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				list = (List<ApplicationAccess>)QueryUtil.list(
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
	 * Returns the first application access in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching application access
	 * @throws NoSuchApplicationAccessException if a matching application access could not be found
	 */
	@Override
	public ApplicationAccess findByEmployeeId_First(
			long employeeId,
			OrderByComparator<ApplicationAccess> orderByComparator)
		throws NoSuchApplicationAccessException {

		ApplicationAccess applicationAccess = fetchByEmployeeId_First(
			employeeId, orderByComparator);

		if (applicationAccess != null) {
			return applicationAccess;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchApplicationAccessException(sb.toString());
	}

	/**
	 * Returns the first application access in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching application access, or <code>null</code> if a matching application access could not be found
	 */
	@Override
	public ApplicationAccess fetchByEmployeeId_First(
		long employeeId,
		OrderByComparator<ApplicationAccess> orderByComparator) {

		List<ApplicationAccess> list = findByEmployeeId(
			employeeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last application access in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching application access
	 * @throws NoSuchApplicationAccessException if a matching application access could not be found
	 */
	@Override
	public ApplicationAccess findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<ApplicationAccess> orderByComparator)
		throws NoSuchApplicationAccessException {

		ApplicationAccess applicationAccess = fetchByEmployeeId_Last(
			employeeId, orderByComparator);

		if (applicationAccess != null) {
			return applicationAccess;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchApplicationAccessException(sb.toString());
	}

	/**
	 * Returns the last application access in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching application access, or <code>null</code> if a matching application access could not be found
	 */
	@Override
	public ApplicationAccess fetchByEmployeeId_Last(
		long employeeId,
		OrderByComparator<ApplicationAccess> orderByComparator) {

		int count = countByEmployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<ApplicationAccess> list = findByEmployeeId(
			employeeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the application accesses before and after the current application access in the ordered set where employeeId = &#63;.
	 *
	 * @param applicationAccessId the primary key of the current application access
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next application access
	 * @throws NoSuchApplicationAccessException if a application access with the primary key could not be found
	 */
	@Override
	public ApplicationAccess[] findByEmployeeId_PrevAndNext(
			long applicationAccessId, long employeeId,
			OrderByComparator<ApplicationAccess> orderByComparator)
		throws NoSuchApplicationAccessException {

		ApplicationAccess applicationAccess = findByPrimaryKey(
			applicationAccessId);

		Session session = null;

		try {
			session = openSession();

			ApplicationAccess[] array = new ApplicationAccessImpl[3];

			array[0] = getByEmployeeId_PrevAndNext(
				session, applicationAccess, employeeId, orderByComparator,
				true);

			array[1] = applicationAccess;

			array[2] = getByEmployeeId_PrevAndNext(
				session, applicationAccess, employeeId, orderByComparator,
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

	protected ApplicationAccess getByEmployeeId_PrevAndNext(
		Session session, ApplicationAccess applicationAccess, long employeeId,
		OrderByComparator<ApplicationAccess> orderByComparator,
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

		sb.append(_SQL_SELECT_APPLICATIONACCESS_WHERE);

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
			sb.append(ApplicationAccessModelImpl.ORDER_BY_JPQL);
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
						applicationAccess)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ApplicationAccess> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the application accesses where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeByEmployeeId(long employeeId) {
		for (ApplicationAccess applicationAccess :
				findByEmployeeId(
					employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(applicationAccess);
		}
	}

	/**
	 * Returns the number of application accesses where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching application accesses
	 */
	@Override
	public int countByEmployeeId(long employeeId) {
		FinderPath finderPath = _finderPathCountByEmployeeId;

		Object[] finderArgs = new Object[] {employeeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_APPLICATIONACCESS_WHERE);

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
		"applicationAccess.employeeId = ?";

	private FinderPath _finderPathWithPaginationFindByApplicationId;
	private FinderPath _finderPathWithoutPaginationFindByApplicationId;
	private FinderPath _finderPathCountByApplicationId;

	/**
	 * Returns all the application accesses where applicationId = &#63;.
	 *
	 * @param applicationId the application ID
	 * @return the matching application accesses
	 */
	@Override
	public List<ApplicationAccess> findByApplicationId(long applicationId) {
		return findByApplicationId(
			applicationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the application accesses where applicationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApplicationAccessModelImpl</code>.
	 * </p>
	 *
	 * @param applicationId the application ID
	 * @param start the lower bound of the range of application accesses
	 * @param end the upper bound of the range of application accesses (not inclusive)
	 * @return the range of matching application accesses
	 */
	@Override
	public List<ApplicationAccess> findByApplicationId(
		long applicationId, int start, int end) {

		return findByApplicationId(applicationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the application accesses where applicationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApplicationAccessModelImpl</code>.
	 * </p>
	 *
	 * @param applicationId the application ID
	 * @param start the lower bound of the range of application accesses
	 * @param end the upper bound of the range of application accesses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching application accesses
	 */
	@Override
	public List<ApplicationAccess> findByApplicationId(
		long applicationId, int start, int end,
		OrderByComparator<ApplicationAccess> orderByComparator) {

		return findByApplicationId(
			applicationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the application accesses where applicationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApplicationAccessModelImpl</code>.
	 * </p>
	 *
	 * @param applicationId the application ID
	 * @param start the lower bound of the range of application accesses
	 * @param end the upper bound of the range of application accesses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching application accesses
	 */
	@Override
	public List<ApplicationAccess> findByApplicationId(
		long applicationId, int start, int end,
		OrderByComparator<ApplicationAccess> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByApplicationId;
				finderArgs = new Object[] {applicationId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByApplicationId;
			finderArgs = new Object[] {
				applicationId, start, end, orderByComparator
			};
		}

		List<ApplicationAccess> list = null;

		if (useFinderCache) {
			list = (List<ApplicationAccess>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ApplicationAccess applicationAccess : list) {
					if (applicationId != applicationAccess.getApplicationId()) {
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

			sb.append(_SQL_SELECT_APPLICATIONACCESS_WHERE);

			sb.append(_FINDER_COLUMN_APPLICATIONID_APPLICATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ApplicationAccessModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(applicationId);

				list = (List<ApplicationAccess>)QueryUtil.list(
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
	 * Returns the first application access in the ordered set where applicationId = &#63;.
	 *
	 * @param applicationId the application ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching application access
	 * @throws NoSuchApplicationAccessException if a matching application access could not be found
	 */
	@Override
	public ApplicationAccess findByApplicationId_First(
			long applicationId,
			OrderByComparator<ApplicationAccess> orderByComparator)
		throws NoSuchApplicationAccessException {

		ApplicationAccess applicationAccess = fetchByApplicationId_First(
			applicationId, orderByComparator);

		if (applicationAccess != null) {
			return applicationAccess;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("applicationId=");
		sb.append(applicationId);

		sb.append("}");

		throw new NoSuchApplicationAccessException(sb.toString());
	}

	/**
	 * Returns the first application access in the ordered set where applicationId = &#63;.
	 *
	 * @param applicationId the application ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching application access, or <code>null</code> if a matching application access could not be found
	 */
	@Override
	public ApplicationAccess fetchByApplicationId_First(
		long applicationId,
		OrderByComparator<ApplicationAccess> orderByComparator) {

		List<ApplicationAccess> list = findByApplicationId(
			applicationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last application access in the ordered set where applicationId = &#63;.
	 *
	 * @param applicationId the application ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching application access
	 * @throws NoSuchApplicationAccessException if a matching application access could not be found
	 */
	@Override
	public ApplicationAccess findByApplicationId_Last(
			long applicationId,
			OrderByComparator<ApplicationAccess> orderByComparator)
		throws NoSuchApplicationAccessException {

		ApplicationAccess applicationAccess = fetchByApplicationId_Last(
			applicationId, orderByComparator);

		if (applicationAccess != null) {
			return applicationAccess;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("applicationId=");
		sb.append(applicationId);

		sb.append("}");

		throw new NoSuchApplicationAccessException(sb.toString());
	}

	/**
	 * Returns the last application access in the ordered set where applicationId = &#63;.
	 *
	 * @param applicationId the application ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching application access, or <code>null</code> if a matching application access could not be found
	 */
	@Override
	public ApplicationAccess fetchByApplicationId_Last(
		long applicationId,
		OrderByComparator<ApplicationAccess> orderByComparator) {

		int count = countByApplicationId(applicationId);

		if (count == 0) {
			return null;
		}

		List<ApplicationAccess> list = findByApplicationId(
			applicationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the application accesses before and after the current application access in the ordered set where applicationId = &#63;.
	 *
	 * @param applicationAccessId the primary key of the current application access
	 * @param applicationId the application ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next application access
	 * @throws NoSuchApplicationAccessException if a application access with the primary key could not be found
	 */
	@Override
	public ApplicationAccess[] findByApplicationId_PrevAndNext(
			long applicationAccessId, long applicationId,
			OrderByComparator<ApplicationAccess> orderByComparator)
		throws NoSuchApplicationAccessException {

		ApplicationAccess applicationAccess = findByPrimaryKey(
			applicationAccessId);

		Session session = null;

		try {
			session = openSession();

			ApplicationAccess[] array = new ApplicationAccessImpl[3];

			array[0] = getByApplicationId_PrevAndNext(
				session, applicationAccess, applicationId, orderByComparator,
				true);

			array[1] = applicationAccess;

			array[2] = getByApplicationId_PrevAndNext(
				session, applicationAccess, applicationId, orderByComparator,
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

	protected ApplicationAccess getByApplicationId_PrevAndNext(
		Session session, ApplicationAccess applicationAccess,
		long applicationId,
		OrderByComparator<ApplicationAccess> orderByComparator,
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

		sb.append(_SQL_SELECT_APPLICATIONACCESS_WHERE);

		sb.append(_FINDER_COLUMN_APPLICATIONID_APPLICATIONID_2);

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
			sb.append(ApplicationAccessModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(applicationId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						applicationAccess)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ApplicationAccess> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the application accesses where applicationId = &#63; from the database.
	 *
	 * @param applicationId the application ID
	 */
	@Override
	public void removeByApplicationId(long applicationId) {
		for (ApplicationAccess applicationAccess :
				findByApplicationId(
					applicationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(applicationAccess);
		}
	}

	/**
	 * Returns the number of application accesses where applicationId = &#63;.
	 *
	 * @param applicationId the application ID
	 * @return the number of matching application accesses
	 */
	@Override
	public int countByApplicationId(long applicationId) {
		FinderPath finderPath = _finderPathCountByApplicationId;

		Object[] finderArgs = new Object[] {applicationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_APPLICATIONACCESS_WHERE);

			sb.append(_FINDER_COLUMN_APPLICATIONID_APPLICATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(applicationId);

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

	private static final String _FINDER_COLUMN_APPLICATIONID_APPLICATIONID_2 =
		"applicationAccess.applicationId = ?";

	public ApplicationAccessPersistenceImpl() {
		setModelClass(ApplicationAccess.class);

		setModelImplClass(ApplicationAccessImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the application access in the entity cache if it is enabled.
	 *
	 * @param applicationAccess the application access
	 */
	@Override
	public void cacheResult(ApplicationAccess applicationAccess) {
		entityCache.putResult(
			ApplicationAccessImpl.class, applicationAccess.getPrimaryKey(),
			applicationAccess);
	}

	/**
	 * Caches the application accesses in the entity cache if it is enabled.
	 *
	 * @param applicationAccesses the application accesses
	 */
	@Override
	public void cacheResult(List<ApplicationAccess> applicationAccesses) {
		for (ApplicationAccess applicationAccess : applicationAccesses) {
			if (entityCache.getResult(
					ApplicationAccessImpl.class,
					applicationAccess.getPrimaryKey()) == null) {

				cacheResult(applicationAccess);
			}
		}
	}

	/**
	 * Clears the cache for all application accesses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ApplicationAccessImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the application access.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ApplicationAccess applicationAccess) {
		entityCache.removeResult(
			ApplicationAccessImpl.class, applicationAccess);
	}

	@Override
	public void clearCache(List<ApplicationAccess> applicationAccesses) {
		for (ApplicationAccess applicationAccess : applicationAccesses) {
			entityCache.removeResult(
				ApplicationAccessImpl.class, applicationAccess);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ApplicationAccessImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new application access with the primary key. Does not add the application access to the database.
	 *
	 * @param applicationAccessId the primary key for the new application access
	 * @return the new application access
	 */
	@Override
	public ApplicationAccess create(long applicationAccessId) {
		ApplicationAccess applicationAccess = new ApplicationAccessImpl();

		applicationAccess.setNew(true);
		applicationAccess.setPrimaryKey(applicationAccessId);

		applicationAccess.setCompanyId(CompanyThreadLocal.getCompanyId());

		return applicationAccess;
	}

	/**
	 * Removes the application access with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param applicationAccessId the primary key of the application access
	 * @return the application access that was removed
	 * @throws NoSuchApplicationAccessException if a application access with the primary key could not be found
	 */
	@Override
	public ApplicationAccess remove(long applicationAccessId)
		throws NoSuchApplicationAccessException {

		return remove((Serializable)applicationAccessId);
	}

	/**
	 * Removes the application access with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the application access
	 * @return the application access that was removed
	 * @throws NoSuchApplicationAccessException if a application access with the primary key could not be found
	 */
	@Override
	public ApplicationAccess remove(Serializable primaryKey)
		throws NoSuchApplicationAccessException {

		Session session = null;

		try {
			session = openSession();

			ApplicationAccess applicationAccess =
				(ApplicationAccess)session.get(
					ApplicationAccessImpl.class, primaryKey);

			if (applicationAccess == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchApplicationAccessException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(applicationAccess);
		}
		catch (NoSuchApplicationAccessException noSuchEntityException) {
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
	protected ApplicationAccess removeImpl(
		ApplicationAccess applicationAccess) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(applicationAccess)) {
				applicationAccess = (ApplicationAccess)session.get(
					ApplicationAccessImpl.class,
					applicationAccess.getPrimaryKeyObj());
			}

			if (applicationAccess != null) {
				session.delete(applicationAccess);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (applicationAccess != null) {
			clearCache(applicationAccess);
		}

		return applicationAccess;
	}

	@Override
	public ApplicationAccess updateImpl(ApplicationAccess applicationAccess) {
		boolean isNew = applicationAccess.isNew();

		if (!(applicationAccess instanceof ApplicationAccessModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(applicationAccess.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					applicationAccess);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in applicationAccess proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ApplicationAccess implementation " +
					applicationAccess.getClass());
		}

		ApplicationAccessModelImpl applicationAccessModelImpl =
			(ApplicationAccessModelImpl)applicationAccess;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (applicationAccess.getCreateDate() == null)) {
			if (serviceContext == null) {
				applicationAccess.setCreateDate(now);
			}
			else {
				applicationAccess.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!applicationAccessModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				applicationAccess.setModifiedDate(now);
			}
			else {
				applicationAccess.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(applicationAccess);
			}
			else {
				applicationAccess = (ApplicationAccess)session.merge(
					applicationAccess);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ApplicationAccessImpl.class, applicationAccessModelImpl, false,
			true);

		if (isNew) {
			applicationAccess.setNew(false);
		}

		applicationAccess.resetOriginalValues();

		return applicationAccess;
	}

	/**
	 * Returns the application access with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the application access
	 * @return the application access
	 * @throws NoSuchApplicationAccessException if a application access with the primary key could not be found
	 */
	@Override
	public ApplicationAccess findByPrimaryKey(Serializable primaryKey)
		throws NoSuchApplicationAccessException {

		ApplicationAccess applicationAccess = fetchByPrimaryKey(primaryKey);

		if (applicationAccess == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchApplicationAccessException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return applicationAccess;
	}

	/**
	 * Returns the application access with the primary key or throws a <code>NoSuchApplicationAccessException</code> if it could not be found.
	 *
	 * @param applicationAccessId the primary key of the application access
	 * @return the application access
	 * @throws NoSuchApplicationAccessException if a application access with the primary key could not be found
	 */
	@Override
	public ApplicationAccess findByPrimaryKey(long applicationAccessId)
		throws NoSuchApplicationAccessException {

		return findByPrimaryKey((Serializable)applicationAccessId);
	}

	/**
	 * Returns the application access with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param applicationAccessId the primary key of the application access
	 * @return the application access, or <code>null</code> if a application access with the primary key could not be found
	 */
	@Override
	public ApplicationAccess fetchByPrimaryKey(long applicationAccessId) {
		return fetchByPrimaryKey((Serializable)applicationAccessId);
	}

	/**
	 * Returns all the application accesses.
	 *
	 * @return the application accesses
	 */
	@Override
	public List<ApplicationAccess> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the application accesses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApplicationAccessModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of application accesses
	 * @param end the upper bound of the range of application accesses (not inclusive)
	 * @return the range of application accesses
	 */
	@Override
	public List<ApplicationAccess> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the application accesses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApplicationAccessModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of application accesses
	 * @param end the upper bound of the range of application accesses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of application accesses
	 */
	@Override
	public List<ApplicationAccess> findAll(
		int start, int end,
		OrderByComparator<ApplicationAccess> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the application accesses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApplicationAccessModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of application accesses
	 * @param end the upper bound of the range of application accesses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of application accesses
	 */
	@Override
	public List<ApplicationAccess> findAll(
		int start, int end,
		OrderByComparator<ApplicationAccess> orderByComparator,
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

		List<ApplicationAccess> list = null;

		if (useFinderCache) {
			list = (List<ApplicationAccess>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_APPLICATIONACCESS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_APPLICATIONACCESS;

				sql = sql.concat(ApplicationAccessModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ApplicationAccess>)QueryUtil.list(
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
	 * Removes all the application accesses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ApplicationAccess applicationAccess : findAll()) {
			remove(applicationAccess);
		}
	}

	/**
	 * Returns the number of application accesses.
	 *
	 * @return the number of application accesses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_APPLICATIONACCESS);

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
		return "applicationAccessId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_APPLICATIONACCESS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ApplicationAccessModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the application access persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new ApplicationAccessModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", ApplicationAccess.class.getName()));

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

		_finderPathWithPaginationFindByApplicationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByApplicationId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"applicationId"}, true);

		_finderPathWithoutPaginationFindByApplicationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByApplicationId",
			new String[] {Long.class.getName()}, new String[] {"applicationId"},
			true);

		_finderPathCountByApplicationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByApplicationId",
			new String[] {Long.class.getName()}, new String[] {"applicationId"},
			false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(ApplicationAccessImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	@Override
	@Reference(
		target = comnetPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = comnetPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = comnetPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_APPLICATIONACCESS =
		"SELECT applicationAccess FROM ApplicationAccess applicationAccess";

	private static final String _SQL_SELECT_APPLICATIONACCESS_WHERE =
		"SELECT applicationAccess FROM ApplicationAccess applicationAccess WHERE ";

	private static final String _SQL_COUNT_APPLICATIONACCESS =
		"SELECT COUNT(applicationAccess) FROM ApplicationAccess applicationAccess";

	private static final String _SQL_COUNT_APPLICATIONACCESS_WHERE =
		"SELECT COUNT(applicationAccess) FROM ApplicationAccess applicationAccess WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "applicationAccess.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ApplicationAccess exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ApplicationAccess exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ApplicationAccessPersistenceImpl.class);

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

	private static class ApplicationAccessModelArgumentsResolver
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

			ApplicationAccessModelImpl applicationAccessModelImpl =
				(ApplicationAccessModelImpl)baseModel;

			long columnBitmask = applicationAccessModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					applicationAccessModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						applicationAccessModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					applicationAccessModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			ApplicationAccessModelImpl applicationAccessModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						applicationAccessModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = applicationAccessModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}