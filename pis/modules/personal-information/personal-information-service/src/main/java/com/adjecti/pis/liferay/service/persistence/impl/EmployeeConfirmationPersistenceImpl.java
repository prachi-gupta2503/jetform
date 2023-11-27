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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeConfirmationException;
import com.adjecti.pis.liferay.model.EmployeeConfirmation;
import com.adjecti.pis.liferay.model.impl.EmployeeConfirmationImpl;
import com.adjecti.pis.liferay.model.impl.EmployeeConfirmationModelImpl;
import com.adjecti.pis.liferay.service.persistence.EmployeeConfirmationPersistence;
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
 * The persistence implementation for the employee confirmation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EmployeeConfirmationPersistence.class)
public class EmployeeConfirmationPersistenceImpl
	extends BasePersistenceImpl<EmployeeConfirmation>
	implements EmployeeConfirmationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EmployeeConfirmationUtil</code> to access the employee confirmation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EmployeeConfirmationImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByGradeModeId;
	private FinderPath _finderPathWithoutPaginationFindByGradeModeId;
	private FinderPath _finderPathCountByGradeModeId;

	/**
	 * Returns all the employee confirmations where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @return the matching employee confirmations
	 */
	@Override
	public List<EmployeeConfirmation> findByGradeModeId(long gradeModeId) {
		return findByGradeModeId(
			gradeModeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee confirmations where gradeModeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeConfirmationModelImpl</code>.
	 * </p>
	 *
	 * @param gradeModeId the grade mode ID
	 * @param start the lower bound of the range of employee confirmations
	 * @param end the upper bound of the range of employee confirmations (not inclusive)
	 * @return the range of matching employee confirmations
	 */
	@Override
	public List<EmployeeConfirmation> findByGradeModeId(
		long gradeModeId, int start, int end) {

		return findByGradeModeId(gradeModeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee confirmations where gradeModeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeConfirmationModelImpl</code>.
	 * </p>
	 *
	 * @param gradeModeId the grade mode ID
	 * @param start the lower bound of the range of employee confirmations
	 * @param end the upper bound of the range of employee confirmations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee confirmations
	 */
	@Override
	public List<EmployeeConfirmation> findByGradeModeId(
		long gradeModeId, int start, int end,
		OrderByComparator<EmployeeConfirmation> orderByComparator) {

		return findByGradeModeId(
			gradeModeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee confirmations where gradeModeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeConfirmationModelImpl</code>.
	 * </p>
	 *
	 * @param gradeModeId the grade mode ID
	 * @param start the lower bound of the range of employee confirmations
	 * @param end the upper bound of the range of employee confirmations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee confirmations
	 */
	@Override
	public List<EmployeeConfirmation> findByGradeModeId(
		long gradeModeId, int start, int end,
		OrderByComparator<EmployeeConfirmation> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGradeModeId;
				finderArgs = new Object[] {gradeModeId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGradeModeId;
			finderArgs = new Object[] {
				gradeModeId, start, end, orderByComparator
			};
		}

		List<EmployeeConfirmation> list = null;

		if (useFinderCache) {
			list = (List<EmployeeConfirmation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeConfirmation employeeConfirmation : list) {
					if (gradeModeId != employeeConfirmation.getGradeModeId()) {
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

			sb.append(_SQL_SELECT_EMPLOYEECONFIRMATION_WHERE);

			sb.append(_FINDER_COLUMN_GRADEMODEID_GRADEMODEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeConfirmationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(gradeModeId);

				list = (List<EmployeeConfirmation>)QueryUtil.list(
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
	 * Returns the first employee confirmation in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee confirmation
	 * @throws NoSuchEmployeeConfirmationException if a matching employee confirmation could not be found
	 */
	@Override
	public EmployeeConfirmation findByGradeModeId_First(
			long gradeModeId,
			OrderByComparator<EmployeeConfirmation> orderByComparator)
		throws NoSuchEmployeeConfirmationException {

		EmployeeConfirmation employeeConfirmation = fetchByGradeModeId_First(
			gradeModeId, orderByComparator);

		if (employeeConfirmation != null) {
			return employeeConfirmation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("gradeModeId=");
		sb.append(gradeModeId);

		sb.append("}");

		throw new NoSuchEmployeeConfirmationException(sb.toString());
	}

	/**
	 * Returns the first employee confirmation in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee confirmation, or <code>null</code> if a matching employee confirmation could not be found
	 */
	@Override
	public EmployeeConfirmation fetchByGradeModeId_First(
		long gradeModeId,
		OrderByComparator<EmployeeConfirmation> orderByComparator) {

		List<EmployeeConfirmation> list = findByGradeModeId(
			gradeModeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee confirmation in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee confirmation
	 * @throws NoSuchEmployeeConfirmationException if a matching employee confirmation could not be found
	 */
	@Override
	public EmployeeConfirmation findByGradeModeId_Last(
			long gradeModeId,
			OrderByComparator<EmployeeConfirmation> orderByComparator)
		throws NoSuchEmployeeConfirmationException {

		EmployeeConfirmation employeeConfirmation = fetchByGradeModeId_Last(
			gradeModeId, orderByComparator);

		if (employeeConfirmation != null) {
			return employeeConfirmation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("gradeModeId=");
		sb.append(gradeModeId);

		sb.append("}");

		throw new NoSuchEmployeeConfirmationException(sb.toString());
	}

	/**
	 * Returns the last employee confirmation in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee confirmation, or <code>null</code> if a matching employee confirmation could not be found
	 */
	@Override
	public EmployeeConfirmation fetchByGradeModeId_Last(
		long gradeModeId,
		OrderByComparator<EmployeeConfirmation> orderByComparator) {

		int count = countByGradeModeId(gradeModeId);

		if (count == 0) {
			return null;
		}

		List<EmployeeConfirmation> list = findByGradeModeId(
			gradeModeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee confirmations before and after the current employee confirmation in the ordered set where gradeModeId = &#63;.
	 *
	 * @param employeeConfirmationId the primary key of the current employee confirmation
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee confirmation
	 * @throws NoSuchEmployeeConfirmationException if a employee confirmation with the primary key could not be found
	 */
	@Override
	public EmployeeConfirmation[] findByGradeModeId_PrevAndNext(
			long employeeConfirmationId, long gradeModeId,
			OrderByComparator<EmployeeConfirmation> orderByComparator)
		throws NoSuchEmployeeConfirmationException {

		EmployeeConfirmation employeeConfirmation = findByPrimaryKey(
			employeeConfirmationId);

		Session session = null;

		try {
			session = openSession();

			EmployeeConfirmation[] array = new EmployeeConfirmationImpl[3];

			array[0] = getByGradeModeId_PrevAndNext(
				session, employeeConfirmation, gradeModeId, orderByComparator,
				true);

			array[1] = employeeConfirmation;

			array[2] = getByGradeModeId_PrevAndNext(
				session, employeeConfirmation, gradeModeId, orderByComparator,
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

	protected EmployeeConfirmation getByGradeModeId_PrevAndNext(
		Session session, EmployeeConfirmation employeeConfirmation,
		long gradeModeId,
		OrderByComparator<EmployeeConfirmation> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEECONFIRMATION_WHERE);

		sb.append(_FINDER_COLUMN_GRADEMODEID_GRADEMODEID_2);

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
			sb.append(EmployeeConfirmationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(gradeModeId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						employeeConfirmation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeConfirmation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee confirmations where gradeModeId = &#63; from the database.
	 *
	 * @param gradeModeId the grade mode ID
	 */
	@Override
	public void removeByGradeModeId(long gradeModeId) {
		for (EmployeeConfirmation employeeConfirmation :
				findByGradeModeId(
					gradeModeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeeConfirmation);
		}
	}

	/**
	 * Returns the number of employee confirmations where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @return the number of matching employee confirmations
	 */
	@Override
	public int countByGradeModeId(long gradeModeId) {
		FinderPath finderPath = _finderPathCountByGradeModeId;

		Object[] finderArgs = new Object[] {gradeModeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEECONFIRMATION_WHERE);

			sb.append(_FINDER_COLUMN_GRADEMODEID_GRADEMODEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(gradeModeId);

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

	private static final String _FINDER_COLUMN_GRADEMODEID_GRADEMODEID_2 =
		"employeeConfirmation.gradeModeId = ?";

	private FinderPath _finderPathWithPaginationFindByEmployeeId;
	private FinderPath _finderPathWithoutPaginationFindByEmployeeId;
	private FinderPath _finderPathCountByEmployeeId;

	/**
	 * Returns all the employee confirmations where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee confirmations
	 */
	@Override
	public List<EmployeeConfirmation> findByEmployeeId(long employeeId) {
		return findByEmployeeId(
			employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee confirmations where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeConfirmationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee confirmations
	 * @param end the upper bound of the range of employee confirmations (not inclusive)
	 * @return the range of matching employee confirmations
	 */
	@Override
	public List<EmployeeConfirmation> findByEmployeeId(
		long employeeId, int start, int end) {

		return findByEmployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee confirmations where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeConfirmationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee confirmations
	 * @param end the upper bound of the range of employee confirmations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee confirmations
	 */
	@Override
	public List<EmployeeConfirmation> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeConfirmation> orderByComparator) {

		return findByEmployeeId(
			employeeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee confirmations where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeConfirmationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee confirmations
	 * @param end the upper bound of the range of employee confirmations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee confirmations
	 */
	@Override
	public List<EmployeeConfirmation> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeConfirmation> orderByComparator,
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

		List<EmployeeConfirmation> list = null;

		if (useFinderCache) {
			list = (List<EmployeeConfirmation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeConfirmation employeeConfirmation : list) {
					if (employeeId != employeeConfirmation.getEmployeeId()) {
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

			sb.append(_SQL_SELECT_EMPLOYEECONFIRMATION_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeConfirmationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				list = (List<EmployeeConfirmation>)QueryUtil.list(
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
	 * Returns the first employee confirmation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee confirmation
	 * @throws NoSuchEmployeeConfirmationException if a matching employee confirmation could not be found
	 */
	@Override
	public EmployeeConfirmation findByEmployeeId_First(
			long employeeId,
			OrderByComparator<EmployeeConfirmation> orderByComparator)
		throws NoSuchEmployeeConfirmationException {

		EmployeeConfirmation employeeConfirmation = fetchByEmployeeId_First(
			employeeId, orderByComparator);

		if (employeeConfirmation != null) {
			return employeeConfirmation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeeConfirmationException(sb.toString());
	}

	/**
	 * Returns the first employee confirmation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee confirmation, or <code>null</code> if a matching employee confirmation could not be found
	 */
	@Override
	public EmployeeConfirmation fetchByEmployeeId_First(
		long employeeId,
		OrderByComparator<EmployeeConfirmation> orderByComparator) {

		List<EmployeeConfirmation> list = findByEmployeeId(
			employeeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee confirmation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee confirmation
	 * @throws NoSuchEmployeeConfirmationException if a matching employee confirmation could not be found
	 */
	@Override
	public EmployeeConfirmation findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<EmployeeConfirmation> orderByComparator)
		throws NoSuchEmployeeConfirmationException {

		EmployeeConfirmation employeeConfirmation = fetchByEmployeeId_Last(
			employeeId, orderByComparator);

		if (employeeConfirmation != null) {
			return employeeConfirmation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeeConfirmationException(sb.toString());
	}

	/**
	 * Returns the last employee confirmation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee confirmation, or <code>null</code> if a matching employee confirmation could not be found
	 */
	@Override
	public EmployeeConfirmation fetchByEmployeeId_Last(
		long employeeId,
		OrderByComparator<EmployeeConfirmation> orderByComparator) {

		int count = countByEmployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<EmployeeConfirmation> list = findByEmployeeId(
			employeeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee confirmations before and after the current employee confirmation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeConfirmationId the primary key of the current employee confirmation
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee confirmation
	 * @throws NoSuchEmployeeConfirmationException if a employee confirmation with the primary key could not be found
	 */
	@Override
	public EmployeeConfirmation[] findByEmployeeId_PrevAndNext(
			long employeeConfirmationId, long employeeId,
			OrderByComparator<EmployeeConfirmation> orderByComparator)
		throws NoSuchEmployeeConfirmationException {

		EmployeeConfirmation employeeConfirmation = findByPrimaryKey(
			employeeConfirmationId);

		Session session = null;

		try {
			session = openSession();

			EmployeeConfirmation[] array = new EmployeeConfirmationImpl[3];

			array[0] = getByEmployeeId_PrevAndNext(
				session, employeeConfirmation, employeeId, orderByComparator,
				true);

			array[1] = employeeConfirmation;

			array[2] = getByEmployeeId_PrevAndNext(
				session, employeeConfirmation, employeeId, orderByComparator,
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

	protected EmployeeConfirmation getByEmployeeId_PrevAndNext(
		Session session, EmployeeConfirmation employeeConfirmation,
		long employeeId,
		OrderByComparator<EmployeeConfirmation> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEECONFIRMATION_WHERE);

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
			sb.append(EmployeeConfirmationModelImpl.ORDER_BY_JPQL);
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
						employeeConfirmation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeConfirmation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee confirmations where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeByEmployeeId(long employeeId) {
		for (EmployeeConfirmation employeeConfirmation :
				findByEmployeeId(
					employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeeConfirmation);
		}
	}

	/**
	 * Returns the number of employee confirmations where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee confirmations
	 */
	@Override
	public int countByEmployeeId(long employeeId) {
		FinderPath finderPath = _finderPathCountByEmployeeId;

		Object[] finderArgs = new Object[] {employeeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEECONFIRMATION_WHERE);

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
		"employeeConfirmation.employeeId = ?";

	private FinderPath _finderPathWithPaginationFindByOrganizationId;
	private FinderPath _finderPathWithoutPaginationFindByOrganizationId;
	private FinderPath _finderPathCountByOrganizationId;

	/**
	 * Returns all the employee confirmations where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching employee confirmations
	 */
	@Override
	public List<EmployeeConfirmation> findByOrganizationId(
		long organizationId) {

		return findByOrganizationId(
			organizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee confirmations where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeConfirmationModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee confirmations
	 * @param end the upper bound of the range of employee confirmations (not inclusive)
	 * @return the range of matching employee confirmations
	 */
	@Override
	public List<EmployeeConfirmation> findByOrganizationId(
		long organizationId, int start, int end) {

		return findByOrganizationId(organizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee confirmations where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeConfirmationModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee confirmations
	 * @param end the upper bound of the range of employee confirmations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee confirmations
	 */
	@Override
	public List<EmployeeConfirmation> findByOrganizationId(
		long organizationId, int start, int end,
		OrderByComparator<EmployeeConfirmation> orderByComparator) {

		return findByOrganizationId(
			organizationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee confirmations where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeConfirmationModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee confirmations
	 * @param end the upper bound of the range of employee confirmations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee confirmations
	 */
	@Override
	public List<EmployeeConfirmation> findByOrganizationId(
		long organizationId, int start, int end,
		OrderByComparator<EmployeeConfirmation> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByOrganizationId;
				finderArgs = new Object[] {organizationId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByOrganizationId;
			finderArgs = new Object[] {
				organizationId, start, end, orderByComparator
			};
		}

		List<EmployeeConfirmation> list = null;

		if (useFinderCache) {
			list = (List<EmployeeConfirmation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeConfirmation employeeConfirmation : list) {
					if (organizationId !=
							employeeConfirmation.getOrganizationId()) {

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

			sb.append(_SQL_SELECT_EMPLOYEECONFIRMATION_WHERE);

			sb.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeConfirmationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(organizationId);

				list = (List<EmployeeConfirmation>)QueryUtil.list(
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
	 * Returns the first employee confirmation in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee confirmation
	 * @throws NoSuchEmployeeConfirmationException if a matching employee confirmation could not be found
	 */
	@Override
	public EmployeeConfirmation findByOrganizationId_First(
			long organizationId,
			OrderByComparator<EmployeeConfirmation> orderByComparator)
		throws NoSuchEmployeeConfirmationException {

		EmployeeConfirmation employeeConfirmation = fetchByOrganizationId_First(
			organizationId, orderByComparator);

		if (employeeConfirmation != null) {
			return employeeConfirmation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("organizationId=");
		sb.append(organizationId);

		sb.append("}");

		throw new NoSuchEmployeeConfirmationException(sb.toString());
	}

	/**
	 * Returns the first employee confirmation in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee confirmation, or <code>null</code> if a matching employee confirmation could not be found
	 */
	@Override
	public EmployeeConfirmation fetchByOrganizationId_First(
		long organizationId,
		OrderByComparator<EmployeeConfirmation> orderByComparator) {

		List<EmployeeConfirmation> list = findByOrganizationId(
			organizationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee confirmation in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee confirmation
	 * @throws NoSuchEmployeeConfirmationException if a matching employee confirmation could not be found
	 */
	@Override
	public EmployeeConfirmation findByOrganizationId_Last(
			long organizationId,
			OrderByComparator<EmployeeConfirmation> orderByComparator)
		throws NoSuchEmployeeConfirmationException {

		EmployeeConfirmation employeeConfirmation = fetchByOrganizationId_Last(
			organizationId, orderByComparator);

		if (employeeConfirmation != null) {
			return employeeConfirmation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("organizationId=");
		sb.append(organizationId);

		sb.append("}");

		throw new NoSuchEmployeeConfirmationException(sb.toString());
	}

	/**
	 * Returns the last employee confirmation in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee confirmation, or <code>null</code> if a matching employee confirmation could not be found
	 */
	@Override
	public EmployeeConfirmation fetchByOrganizationId_Last(
		long organizationId,
		OrderByComparator<EmployeeConfirmation> orderByComparator) {

		int count = countByOrganizationId(organizationId);

		if (count == 0) {
			return null;
		}

		List<EmployeeConfirmation> list = findByOrganizationId(
			organizationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee confirmations before and after the current employee confirmation in the ordered set where organizationId = &#63;.
	 *
	 * @param employeeConfirmationId the primary key of the current employee confirmation
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee confirmation
	 * @throws NoSuchEmployeeConfirmationException if a employee confirmation with the primary key could not be found
	 */
	@Override
	public EmployeeConfirmation[] findByOrganizationId_PrevAndNext(
			long employeeConfirmationId, long organizationId,
			OrderByComparator<EmployeeConfirmation> orderByComparator)
		throws NoSuchEmployeeConfirmationException {

		EmployeeConfirmation employeeConfirmation = findByPrimaryKey(
			employeeConfirmationId);

		Session session = null;

		try {
			session = openSession();

			EmployeeConfirmation[] array = new EmployeeConfirmationImpl[3];

			array[0] = getByOrganizationId_PrevAndNext(
				session, employeeConfirmation, organizationId,
				orderByComparator, true);

			array[1] = employeeConfirmation;

			array[2] = getByOrganizationId_PrevAndNext(
				session, employeeConfirmation, organizationId,
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

	protected EmployeeConfirmation getByOrganizationId_PrevAndNext(
		Session session, EmployeeConfirmation employeeConfirmation,
		long organizationId,
		OrderByComparator<EmployeeConfirmation> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEECONFIRMATION_WHERE);

		sb.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

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
			sb.append(EmployeeConfirmationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(organizationId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						employeeConfirmation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeConfirmation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee confirmations where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	@Override
	public void removeByOrganizationId(long organizationId) {
		for (EmployeeConfirmation employeeConfirmation :
				findByOrganizationId(
					organizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(employeeConfirmation);
		}
	}

	/**
	 * Returns the number of employee confirmations where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching employee confirmations
	 */
	@Override
	public int countByOrganizationId(long organizationId) {
		FinderPath finderPath = _finderPathCountByOrganizationId;

		Object[] finderArgs = new Object[] {organizationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEECONFIRMATION_WHERE);

			sb.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

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

	private static final String _FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2 =
		"employeeConfirmation.organizationId = ?";

	public EmployeeConfirmationPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(EmployeeConfirmation.class);

		setModelImplClass(EmployeeConfirmationImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the employee confirmation in the entity cache if it is enabled.
	 *
	 * @param employeeConfirmation the employee confirmation
	 */
	@Override
	public void cacheResult(EmployeeConfirmation employeeConfirmation) {
		entityCache.putResult(
			EmployeeConfirmationImpl.class,
			employeeConfirmation.getPrimaryKey(), employeeConfirmation);
	}

	/**
	 * Caches the employee confirmations in the entity cache if it is enabled.
	 *
	 * @param employeeConfirmations the employee confirmations
	 */
	@Override
	public void cacheResult(List<EmployeeConfirmation> employeeConfirmations) {
		for (EmployeeConfirmation employeeConfirmation :
				employeeConfirmations) {

			if (entityCache.getResult(
					EmployeeConfirmationImpl.class,
					employeeConfirmation.getPrimaryKey()) == null) {

				cacheResult(employeeConfirmation);
			}
		}
	}

	/**
	 * Clears the cache for all employee confirmations.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmployeeConfirmationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the employee confirmation.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmployeeConfirmation employeeConfirmation) {
		entityCache.removeResult(
			EmployeeConfirmationImpl.class, employeeConfirmation);
	}

	@Override
	public void clearCache(List<EmployeeConfirmation> employeeConfirmations) {
		for (EmployeeConfirmation employeeConfirmation :
				employeeConfirmations) {

			entityCache.removeResult(
				EmployeeConfirmationImpl.class, employeeConfirmation);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				EmployeeConfirmationImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new employee confirmation with the primary key. Does not add the employee confirmation to the database.
	 *
	 * @param employeeConfirmationId the primary key for the new employee confirmation
	 * @return the new employee confirmation
	 */
	@Override
	public EmployeeConfirmation create(long employeeConfirmationId) {
		EmployeeConfirmation employeeConfirmation =
			new EmployeeConfirmationImpl();

		employeeConfirmation.setNew(true);
		employeeConfirmation.setPrimaryKey(employeeConfirmationId);

		employeeConfirmation.setCompanyId(CompanyThreadLocal.getCompanyId());

		return employeeConfirmation;
	}

	/**
	 * Removes the employee confirmation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeConfirmationId the primary key of the employee confirmation
	 * @return the employee confirmation that was removed
	 * @throws NoSuchEmployeeConfirmationException if a employee confirmation with the primary key could not be found
	 */
	@Override
	public EmployeeConfirmation remove(long employeeConfirmationId)
		throws NoSuchEmployeeConfirmationException {

		return remove((Serializable)employeeConfirmationId);
	}

	/**
	 * Removes the employee confirmation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the employee confirmation
	 * @return the employee confirmation that was removed
	 * @throws NoSuchEmployeeConfirmationException if a employee confirmation with the primary key could not be found
	 */
	@Override
	public EmployeeConfirmation remove(Serializable primaryKey)
		throws NoSuchEmployeeConfirmationException {

		Session session = null;

		try {
			session = openSession();

			EmployeeConfirmation employeeConfirmation =
				(EmployeeConfirmation)session.get(
					EmployeeConfirmationImpl.class, primaryKey);

			if (employeeConfirmation == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmployeeConfirmationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(employeeConfirmation);
		}
		catch (NoSuchEmployeeConfirmationException noSuchEntityException) {
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
	protected EmployeeConfirmation removeImpl(
		EmployeeConfirmation employeeConfirmation) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(employeeConfirmation)) {
				employeeConfirmation = (EmployeeConfirmation)session.get(
					EmployeeConfirmationImpl.class,
					employeeConfirmation.getPrimaryKeyObj());
			}

			if (employeeConfirmation != null) {
				session.delete(employeeConfirmation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (employeeConfirmation != null) {
			clearCache(employeeConfirmation);
		}

		return employeeConfirmation;
	}

	@Override
	public EmployeeConfirmation updateImpl(
		EmployeeConfirmation employeeConfirmation) {

		boolean isNew = employeeConfirmation.isNew();

		if (!(employeeConfirmation instanceof EmployeeConfirmationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(employeeConfirmation.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					employeeConfirmation);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in employeeConfirmation proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EmployeeConfirmation implementation " +
					employeeConfirmation.getClass());
		}

		EmployeeConfirmationModelImpl employeeConfirmationModelImpl =
			(EmployeeConfirmationModelImpl)employeeConfirmation;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (employeeConfirmation.getCreateDate() == null)) {
			if (serviceContext == null) {
				employeeConfirmation.setCreateDate(now);
			}
			else {
				employeeConfirmation.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!employeeConfirmationModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				employeeConfirmation.setModifiedDate(now);
			}
			else {
				employeeConfirmation.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(employeeConfirmation);
			}
			else {
				employeeConfirmation = (EmployeeConfirmation)session.merge(
					employeeConfirmation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EmployeeConfirmationImpl.class, employeeConfirmationModelImpl,
			false, true);

		if (isNew) {
			employeeConfirmation.setNew(false);
		}

		employeeConfirmation.resetOriginalValues();

		return employeeConfirmation;
	}

	/**
	 * Returns the employee confirmation with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee confirmation
	 * @return the employee confirmation
	 * @throws NoSuchEmployeeConfirmationException if a employee confirmation with the primary key could not be found
	 */
	@Override
	public EmployeeConfirmation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmployeeConfirmationException {

		EmployeeConfirmation employeeConfirmation = fetchByPrimaryKey(
			primaryKey);

		if (employeeConfirmation == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmployeeConfirmationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return employeeConfirmation;
	}

	/**
	 * Returns the employee confirmation with the primary key or throws a <code>NoSuchEmployeeConfirmationException</code> if it could not be found.
	 *
	 * @param employeeConfirmationId the primary key of the employee confirmation
	 * @return the employee confirmation
	 * @throws NoSuchEmployeeConfirmationException if a employee confirmation with the primary key could not be found
	 */
	@Override
	public EmployeeConfirmation findByPrimaryKey(long employeeConfirmationId)
		throws NoSuchEmployeeConfirmationException {

		return findByPrimaryKey((Serializable)employeeConfirmationId);
	}

	/**
	 * Returns the employee confirmation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeConfirmationId the primary key of the employee confirmation
	 * @return the employee confirmation, or <code>null</code> if a employee confirmation with the primary key could not be found
	 */
	@Override
	public EmployeeConfirmation fetchByPrimaryKey(long employeeConfirmationId) {
		return fetchByPrimaryKey((Serializable)employeeConfirmationId);
	}

	/**
	 * Returns all the employee confirmations.
	 *
	 * @return the employee confirmations
	 */
	@Override
	public List<EmployeeConfirmation> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee confirmations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeConfirmationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee confirmations
	 * @param end the upper bound of the range of employee confirmations (not inclusive)
	 * @return the range of employee confirmations
	 */
	@Override
	public List<EmployeeConfirmation> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee confirmations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeConfirmationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee confirmations
	 * @param end the upper bound of the range of employee confirmations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee confirmations
	 */
	@Override
	public List<EmployeeConfirmation> findAll(
		int start, int end,
		OrderByComparator<EmployeeConfirmation> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee confirmations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeConfirmationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee confirmations
	 * @param end the upper bound of the range of employee confirmations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee confirmations
	 */
	@Override
	public List<EmployeeConfirmation> findAll(
		int start, int end,
		OrderByComparator<EmployeeConfirmation> orderByComparator,
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

		List<EmployeeConfirmation> list = null;

		if (useFinderCache) {
			list = (List<EmployeeConfirmation>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EMPLOYEECONFIRMATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLOYEECONFIRMATION;

				sql = sql.concat(EmployeeConfirmationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EmployeeConfirmation>)QueryUtil.list(
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
	 * Removes all the employee confirmations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EmployeeConfirmation employeeConfirmation : findAll()) {
			remove(employeeConfirmation);
		}
	}

	/**
	 * Returns the number of employee confirmations.
	 *
	 * @return the number of employee confirmations
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
					_SQL_COUNT_EMPLOYEECONFIRMATION);

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
		return "employeeConfirmationId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EMPLOYEECONFIRMATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EmployeeConfirmationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the employee confirmation persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new EmployeeConfirmationModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", EmployeeConfirmation.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByGradeModeId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGradeModeId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"gradeModeId"}, true);

		_finderPathWithoutPaginationFindByGradeModeId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGradeModeId",
			new String[] {Long.class.getName()}, new String[] {"gradeModeId"},
			true);

		_finderPathCountByGradeModeId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGradeModeId",
			new String[] {Long.class.getName()}, new String[] {"gradeModeId"},
			false);

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

		_finderPathWithPaginationFindByOrganizationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByOrganizationId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"organizationId"}, true);

		_finderPathWithoutPaginationFindByOrganizationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOrganizationId",
			new String[] {Long.class.getName()},
			new String[] {"organizationId"}, true);

		_finderPathCountByOrganizationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOrganizationId",
			new String[] {Long.class.getName()},
			new String[] {"organizationId"}, false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(EmployeeConfirmationImpl.class.getName());

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

	private static final String _SQL_SELECT_EMPLOYEECONFIRMATION =
		"SELECT employeeConfirmation FROM EmployeeConfirmation employeeConfirmation";

	private static final String _SQL_SELECT_EMPLOYEECONFIRMATION_WHERE =
		"SELECT employeeConfirmation FROM EmployeeConfirmation employeeConfirmation WHERE ";

	private static final String _SQL_COUNT_EMPLOYEECONFIRMATION =
		"SELECT COUNT(employeeConfirmation) FROM EmployeeConfirmation employeeConfirmation";

	private static final String _SQL_COUNT_EMPLOYEECONFIRMATION_WHERE =
		"SELECT COUNT(employeeConfirmation) FROM EmployeeConfirmation employeeConfirmation WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"employeeConfirmation.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EmployeeConfirmation exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EmployeeConfirmation exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EmployeeConfirmationPersistenceImpl.class);

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

	private static class EmployeeConfirmationModelArgumentsResolver
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

			EmployeeConfirmationModelImpl employeeConfirmationModelImpl =
				(EmployeeConfirmationModelImpl)baseModel;

			long columnBitmask =
				employeeConfirmationModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					employeeConfirmationModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						employeeConfirmationModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					employeeConfirmationModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			EmployeeConfirmationModelImpl employeeConfirmationModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						employeeConfirmationModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = employeeConfirmationModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}