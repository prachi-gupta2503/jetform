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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeGradeException;
import com.adjecti.pis.liferay.model.EmployeeGrade;
import com.adjecti.pis.liferay.model.impl.EmployeeGradeImpl;
import com.adjecti.pis.liferay.model.impl.EmployeeGradeModelImpl;
import com.adjecti.pis.liferay.service.persistence.EmployeeGradePersistence;
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
 * The persistence implementation for the employee grade service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EmployeeGradePersistence.class)
public class EmployeeGradePersistenceImpl
	extends BasePersistenceImpl<EmployeeGrade>
	implements EmployeeGradePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EmployeeGradeUtil</code> to access the employee grade persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EmployeeGradeImpl.class.getName();

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
	 * Returns all the employee grades where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @return the matching employee grades
	 */
	@Override
	public List<EmployeeGrade> findByGradeModeId(long gradeModeId) {
		return findByGradeModeId(
			gradeModeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee grades where gradeModeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeGradeModelImpl</code>.
	 * </p>
	 *
	 * @param gradeModeId the grade mode ID
	 * @param start the lower bound of the range of employee grades
	 * @param end the upper bound of the range of employee grades (not inclusive)
	 * @return the range of matching employee grades
	 */
	@Override
	public List<EmployeeGrade> findByGradeModeId(
		long gradeModeId, int start, int end) {

		return findByGradeModeId(gradeModeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee grades where gradeModeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeGradeModelImpl</code>.
	 * </p>
	 *
	 * @param gradeModeId the grade mode ID
	 * @param start the lower bound of the range of employee grades
	 * @param end the upper bound of the range of employee grades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee grades
	 */
	@Override
	public List<EmployeeGrade> findByGradeModeId(
		long gradeModeId, int start, int end,
		OrderByComparator<EmployeeGrade> orderByComparator) {

		return findByGradeModeId(
			gradeModeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee grades where gradeModeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeGradeModelImpl</code>.
	 * </p>
	 *
	 * @param gradeModeId the grade mode ID
	 * @param start the lower bound of the range of employee grades
	 * @param end the upper bound of the range of employee grades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee grades
	 */
	@Override
	public List<EmployeeGrade> findByGradeModeId(
		long gradeModeId, int start, int end,
		OrderByComparator<EmployeeGrade> orderByComparator,
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

		List<EmployeeGrade> list = null;

		if (useFinderCache) {
			list = (List<EmployeeGrade>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeGrade employeeGrade : list) {
					if (gradeModeId != employeeGrade.getGradeModeId()) {
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

			sb.append(_SQL_SELECT_EMPLOYEEGRADE_WHERE);

			sb.append(_FINDER_COLUMN_GRADEMODEID_GRADEMODEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeGradeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(gradeModeId);

				list = (List<EmployeeGrade>)QueryUtil.list(
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
	 * Returns the first employee grade in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee grade
	 * @throws NoSuchEmployeeGradeException if a matching employee grade could not be found
	 */
	@Override
	public EmployeeGrade findByGradeModeId_First(
			long gradeModeId,
			OrderByComparator<EmployeeGrade> orderByComparator)
		throws NoSuchEmployeeGradeException {

		EmployeeGrade employeeGrade = fetchByGradeModeId_First(
			gradeModeId, orderByComparator);

		if (employeeGrade != null) {
			return employeeGrade;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("gradeModeId=");
		sb.append(gradeModeId);

		sb.append("}");

		throw new NoSuchEmployeeGradeException(sb.toString());
	}

	/**
	 * Returns the first employee grade in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee grade, or <code>null</code> if a matching employee grade could not be found
	 */
	@Override
	public EmployeeGrade fetchByGradeModeId_First(
		long gradeModeId, OrderByComparator<EmployeeGrade> orderByComparator) {

		List<EmployeeGrade> list = findByGradeModeId(
			gradeModeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee grade in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee grade
	 * @throws NoSuchEmployeeGradeException if a matching employee grade could not be found
	 */
	@Override
	public EmployeeGrade findByGradeModeId_Last(
			long gradeModeId,
			OrderByComparator<EmployeeGrade> orderByComparator)
		throws NoSuchEmployeeGradeException {

		EmployeeGrade employeeGrade = fetchByGradeModeId_Last(
			gradeModeId, orderByComparator);

		if (employeeGrade != null) {
			return employeeGrade;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("gradeModeId=");
		sb.append(gradeModeId);

		sb.append("}");

		throw new NoSuchEmployeeGradeException(sb.toString());
	}

	/**
	 * Returns the last employee grade in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee grade, or <code>null</code> if a matching employee grade could not be found
	 */
	@Override
	public EmployeeGrade fetchByGradeModeId_Last(
		long gradeModeId, OrderByComparator<EmployeeGrade> orderByComparator) {

		int count = countByGradeModeId(gradeModeId);

		if (count == 0) {
			return null;
		}

		List<EmployeeGrade> list = findByGradeModeId(
			gradeModeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee grades before and after the current employee grade in the ordered set where gradeModeId = &#63;.
	 *
	 * @param employeeGradeId the primary key of the current employee grade
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee grade
	 * @throws NoSuchEmployeeGradeException if a employee grade with the primary key could not be found
	 */
	@Override
	public EmployeeGrade[] findByGradeModeId_PrevAndNext(
			long employeeGradeId, long gradeModeId,
			OrderByComparator<EmployeeGrade> orderByComparator)
		throws NoSuchEmployeeGradeException {

		EmployeeGrade employeeGrade = findByPrimaryKey(employeeGradeId);

		Session session = null;

		try {
			session = openSession();

			EmployeeGrade[] array = new EmployeeGradeImpl[3];

			array[0] = getByGradeModeId_PrevAndNext(
				session, employeeGrade, gradeModeId, orderByComparator, true);

			array[1] = employeeGrade;

			array[2] = getByGradeModeId_PrevAndNext(
				session, employeeGrade, gradeModeId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EmployeeGrade getByGradeModeId_PrevAndNext(
		Session session, EmployeeGrade employeeGrade, long gradeModeId,
		OrderByComparator<EmployeeGrade> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_EMPLOYEEGRADE_WHERE);

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
			sb.append(EmployeeGradeModelImpl.ORDER_BY_JPQL);
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
						employeeGrade)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeGrade> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee grades where gradeModeId = &#63; from the database.
	 *
	 * @param gradeModeId the grade mode ID
	 */
	@Override
	public void removeByGradeModeId(long gradeModeId) {
		for (EmployeeGrade employeeGrade :
				findByGradeModeId(
					gradeModeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeeGrade);
		}
	}

	/**
	 * Returns the number of employee grades where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @return the number of matching employee grades
	 */
	@Override
	public int countByGradeModeId(long gradeModeId) {
		FinderPath finderPath = _finderPathCountByGradeModeId;

		Object[] finderArgs = new Object[] {gradeModeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEGRADE_WHERE);

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
		"employeeGrade.gradeModeId = ?";

	private FinderPath _finderPathWithPaginationFindByEmployeeId;
	private FinderPath _finderPathWithoutPaginationFindByEmployeeId;
	private FinderPath _finderPathCountByEmployeeId;

	/**
	 * Returns all the employee grades where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee grades
	 */
	@Override
	public List<EmployeeGrade> findByEmployeeId(long employeeId) {
		return findByEmployeeId(
			employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee grades where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeGradeModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee grades
	 * @param end the upper bound of the range of employee grades (not inclusive)
	 * @return the range of matching employee grades
	 */
	@Override
	public List<EmployeeGrade> findByEmployeeId(
		long employeeId, int start, int end) {

		return findByEmployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee grades where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeGradeModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee grades
	 * @param end the upper bound of the range of employee grades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee grades
	 */
	@Override
	public List<EmployeeGrade> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeGrade> orderByComparator) {

		return findByEmployeeId(
			employeeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee grades where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeGradeModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee grades
	 * @param end the upper bound of the range of employee grades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee grades
	 */
	@Override
	public List<EmployeeGrade> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeGrade> orderByComparator,
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

		List<EmployeeGrade> list = null;

		if (useFinderCache) {
			list = (List<EmployeeGrade>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeGrade employeeGrade : list) {
					if (employeeId != employeeGrade.getEmployeeId()) {
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

			sb.append(_SQL_SELECT_EMPLOYEEGRADE_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeGradeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				list = (List<EmployeeGrade>)QueryUtil.list(
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
	 * Returns the first employee grade in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee grade
	 * @throws NoSuchEmployeeGradeException if a matching employee grade could not be found
	 */
	@Override
	public EmployeeGrade findByEmployeeId_First(
			long employeeId, OrderByComparator<EmployeeGrade> orderByComparator)
		throws NoSuchEmployeeGradeException {

		EmployeeGrade employeeGrade = fetchByEmployeeId_First(
			employeeId, orderByComparator);

		if (employeeGrade != null) {
			return employeeGrade;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeeGradeException(sb.toString());
	}

	/**
	 * Returns the first employee grade in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee grade, or <code>null</code> if a matching employee grade could not be found
	 */
	@Override
	public EmployeeGrade fetchByEmployeeId_First(
		long employeeId, OrderByComparator<EmployeeGrade> orderByComparator) {

		List<EmployeeGrade> list = findByEmployeeId(
			employeeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee grade in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee grade
	 * @throws NoSuchEmployeeGradeException if a matching employee grade could not be found
	 */
	@Override
	public EmployeeGrade findByEmployeeId_Last(
			long employeeId, OrderByComparator<EmployeeGrade> orderByComparator)
		throws NoSuchEmployeeGradeException {

		EmployeeGrade employeeGrade = fetchByEmployeeId_Last(
			employeeId, orderByComparator);

		if (employeeGrade != null) {
			return employeeGrade;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeeGradeException(sb.toString());
	}

	/**
	 * Returns the last employee grade in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee grade, or <code>null</code> if a matching employee grade could not be found
	 */
	@Override
	public EmployeeGrade fetchByEmployeeId_Last(
		long employeeId, OrderByComparator<EmployeeGrade> orderByComparator) {

		int count = countByEmployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<EmployeeGrade> list = findByEmployeeId(
			employeeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee grades before and after the current employee grade in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeGradeId the primary key of the current employee grade
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee grade
	 * @throws NoSuchEmployeeGradeException if a employee grade with the primary key could not be found
	 */
	@Override
	public EmployeeGrade[] findByEmployeeId_PrevAndNext(
			long employeeGradeId, long employeeId,
			OrderByComparator<EmployeeGrade> orderByComparator)
		throws NoSuchEmployeeGradeException {

		EmployeeGrade employeeGrade = findByPrimaryKey(employeeGradeId);

		Session session = null;

		try {
			session = openSession();

			EmployeeGrade[] array = new EmployeeGradeImpl[3];

			array[0] = getByEmployeeId_PrevAndNext(
				session, employeeGrade, employeeId, orderByComparator, true);

			array[1] = employeeGrade;

			array[2] = getByEmployeeId_PrevAndNext(
				session, employeeGrade, employeeId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EmployeeGrade getByEmployeeId_PrevAndNext(
		Session session, EmployeeGrade employeeGrade, long employeeId,
		OrderByComparator<EmployeeGrade> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_EMPLOYEEGRADE_WHERE);

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
			sb.append(EmployeeGradeModelImpl.ORDER_BY_JPQL);
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
						employeeGrade)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeGrade> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee grades where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeByEmployeeId(long employeeId) {
		for (EmployeeGrade employeeGrade :
				findByEmployeeId(
					employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeeGrade);
		}
	}

	/**
	 * Returns the number of employee grades where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee grades
	 */
	@Override
	public int countByEmployeeId(long employeeId) {
		FinderPath finderPath = _finderPathCountByEmployeeId;

		Object[] finderArgs = new Object[] {employeeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEGRADE_WHERE);

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
		"employeeGrade.employeeId = ?";

	public EmployeeGradePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(EmployeeGrade.class);

		setModelImplClass(EmployeeGradeImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the employee grade in the entity cache if it is enabled.
	 *
	 * @param employeeGrade the employee grade
	 */
	@Override
	public void cacheResult(EmployeeGrade employeeGrade) {
		entityCache.putResult(
			EmployeeGradeImpl.class, employeeGrade.getPrimaryKey(),
			employeeGrade);
	}

	/**
	 * Caches the employee grades in the entity cache if it is enabled.
	 *
	 * @param employeeGrades the employee grades
	 */
	@Override
	public void cacheResult(List<EmployeeGrade> employeeGrades) {
		for (EmployeeGrade employeeGrade : employeeGrades) {
			if (entityCache.getResult(
					EmployeeGradeImpl.class, employeeGrade.getPrimaryKey()) ==
						null) {

				cacheResult(employeeGrade);
			}
		}
	}

	/**
	 * Clears the cache for all employee grades.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmployeeGradeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the employee grade.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmployeeGrade employeeGrade) {
		entityCache.removeResult(EmployeeGradeImpl.class, employeeGrade);
	}

	@Override
	public void clearCache(List<EmployeeGrade> employeeGrades) {
		for (EmployeeGrade employeeGrade : employeeGrades) {
			entityCache.removeResult(EmployeeGradeImpl.class, employeeGrade);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EmployeeGradeImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new employee grade with the primary key. Does not add the employee grade to the database.
	 *
	 * @param employeeGradeId the primary key for the new employee grade
	 * @return the new employee grade
	 */
	@Override
	public EmployeeGrade create(long employeeGradeId) {
		EmployeeGrade employeeGrade = new EmployeeGradeImpl();

		employeeGrade.setNew(true);
		employeeGrade.setPrimaryKey(employeeGradeId);

		employeeGrade.setCompanyId(CompanyThreadLocal.getCompanyId());

		return employeeGrade;
	}

	/**
	 * Removes the employee grade with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeGradeId the primary key of the employee grade
	 * @return the employee grade that was removed
	 * @throws NoSuchEmployeeGradeException if a employee grade with the primary key could not be found
	 */
	@Override
	public EmployeeGrade remove(long employeeGradeId)
		throws NoSuchEmployeeGradeException {

		return remove((Serializable)employeeGradeId);
	}

	/**
	 * Removes the employee grade with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the employee grade
	 * @return the employee grade that was removed
	 * @throws NoSuchEmployeeGradeException if a employee grade with the primary key could not be found
	 */
	@Override
	public EmployeeGrade remove(Serializable primaryKey)
		throws NoSuchEmployeeGradeException {

		Session session = null;

		try {
			session = openSession();

			EmployeeGrade employeeGrade = (EmployeeGrade)session.get(
				EmployeeGradeImpl.class, primaryKey);

			if (employeeGrade == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmployeeGradeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(employeeGrade);
		}
		catch (NoSuchEmployeeGradeException noSuchEntityException) {
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
	protected EmployeeGrade removeImpl(EmployeeGrade employeeGrade) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(employeeGrade)) {
				employeeGrade = (EmployeeGrade)session.get(
					EmployeeGradeImpl.class, employeeGrade.getPrimaryKeyObj());
			}

			if (employeeGrade != null) {
				session.delete(employeeGrade);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (employeeGrade != null) {
			clearCache(employeeGrade);
		}

		return employeeGrade;
	}

	@Override
	public EmployeeGrade updateImpl(EmployeeGrade employeeGrade) {
		boolean isNew = employeeGrade.isNew();

		if (!(employeeGrade instanceof EmployeeGradeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(employeeGrade.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					employeeGrade);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in employeeGrade proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EmployeeGrade implementation " +
					employeeGrade.getClass());
		}

		EmployeeGradeModelImpl employeeGradeModelImpl =
			(EmployeeGradeModelImpl)employeeGrade;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (employeeGrade.getCreateDate() == null)) {
			if (serviceContext == null) {
				employeeGrade.setCreateDate(now);
			}
			else {
				employeeGrade.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!employeeGradeModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				employeeGrade.setModifiedDate(now);
			}
			else {
				employeeGrade.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(employeeGrade);
			}
			else {
				employeeGrade = (EmployeeGrade)session.merge(employeeGrade);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EmployeeGradeImpl.class, employeeGradeModelImpl, false, true);

		if (isNew) {
			employeeGrade.setNew(false);
		}

		employeeGrade.resetOriginalValues();

		return employeeGrade;
	}

	/**
	 * Returns the employee grade with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee grade
	 * @return the employee grade
	 * @throws NoSuchEmployeeGradeException if a employee grade with the primary key could not be found
	 */
	@Override
	public EmployeeGrade findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmployeeGradeException {

		EmployeeGrade employeeGrade = fetchByPrimaryKey(primaryKey);

		if (employeeGrade == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmployeeGradeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return employeeGrade;
	}

	/**
	 * Returns the employee grade with the primary key or throws a <code>NoSuchEmployeeGradeException</code> if it could not be found.
	 *
	 * @param employeeGradeId the primary key of the employee grade
	 * @return the employee grade
	 * @throws NoSuchEmployeeGradeException if a employee grade with the primary key could not be found
	 */
	@Override
	public EmployeeGrade findByPrimaryKey(long employeeGradeId)
		throws NoSuchEmployeeGradeException {

		return findByPrimaryKey((Serializable)employeeGradeId);
	}

	/**
	 * Returns the employee grade with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeGradeId the primary key of the employee grade
	 * @return the employee grade, or <code>null</code> if a employee grade with the primary key could not be found
	 */
	@Override
	public EmployeeGrade fetchByPrimaryKey(long employeeGradeId) {
		return fetchByPrimaryKey((Serializable)employeeGradeId);
	}

	/**
	 * Returns all the employee grades.
	 *
	 * @return the employee grades
	 */
	@Override
	public List<EmployeeGrade> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee grades.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeGradeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee grades
	 * @param end the upper bound of the range of employee grades (not inclusive)
	 * @return the range of employee grades
	 */
	@Override
	public List<EmployeeGrade> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee grades.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeGradeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee grades
	 * @param end the upper bound of the range of employee grades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee grades
	 */
	@Override
	public List<EmployeeGrade> findAll(
		int start, int end,
		OrderByComparator<EmployeeGrade> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee grades.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeGradeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee grades
	 * @param end the upper bound of the range of employee grades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee grades
	 */
	@Override
	public List<EmployeeGrade> findAll(
		int start, int end, OrderByComparator<EmployeeGrade> orderByComparator,
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

		List<EmployeeGrade> list = null;

		if (useFinderCache) {
			list = (List<EmployeeGrade>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EMPLOYEEGRADE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLOYEEGRADE;

				sql = sql.concat(EmployeeGradeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EmployeeGrade>)QueryUtil.list(
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
	 * Removes all the employee grades from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EmployeeGrade employeeGrade : findAll()) {
			remove(employeeGrade);
		}
	}

	/**
	 * Returns the number of employee grades.
	 *
	 * @return the number of employee grades
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_EMPLOYEEGRADE);

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
		return "employeeGradeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EMPLOYEEGRADE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EmployeeGradeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the employee grade persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new EmployeeGradeModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", EmployeeGrade.class.getName()));

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
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(EmployeeGradeImpl.class.getName());

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

	private static final String _SQL_SELECT_EMPLOYEEGRADE =
		"SELECT employeeGrade FROM EmployeeGrade employeeGrade";

	private static final String _SQL_SELECT_EMPLOYEEGRADE_WHERE =
		"SELECT employeeGrade FROM EmployeeGrade employeeGrade WHERE ";

	private static final String _SQL_COUNT_EMPLOYEEGRADE =
		"SELECT COUNT(employeeGrade) FROM EmployeeGrade employeeGrade";

	private static final String _SQL_COUNT_EMPLOYEEGRADE_WHERE =
		"SELECT COUNT(employeeGrade) FROM EmployeeGrade employeeGrade WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "employeeGrade.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EmployeeGrade exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EmployeeGrade exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EmployeeGradePersistenceImpl.class);

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

	private static class EmployeeGradeModelArgumentsResolver
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

			EmployeeGradeModelImpl employeeGradeModelImpl =
				(EmployeeGradeModelImpl)baseModel;

			long columnBitmask = employeeGradeModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(employeeGradeModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						employeeGradeModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(employeeGradeModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			EmployeeGradeModelImpl employeeGradeModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						employeeGradeModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = employeeGradeModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}