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

import com.adjecti.pis.liferay.exception.NoSuchEmployeePromotionException;
import com.adjecti.pis.liferay.model.EmployeePromotion;
import com.adjecti.pis.liferay.model.impl.EmployeePromotionImpl;
import com.adjecti.pis.liferay.model.impl.EmployeePromotionModelImpl;
import com.adjecti.pis.liferay.service.persistence.EmployeePromotionPersistence;
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
 * The persistence implementation for the employee promotion service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EmployeePromotionPersistence.class)
public class EmployeePromotionPersistenceImpl
	extends BasePersistenceImpl<EmployeePromotion>
	implements EmployeePromotionPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EmployeePromotionUtil</code> to access the employee promotion persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EmployeePromotionImpl.class.getName();

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
	 * Returns all the employee promotions where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @return the matching employee promotions
	 */
	@Override
	public List<EmployeePromotion> findByGradeModeId(long gradeModeId) {
		return findByGradeModeId(
			gradeModeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee promotions where gradeModeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePromotionModelImpl</code>.
	 * </p>
	 *
	 * @param gradeModeId the grade mode ID
	 * @param start the lower bound of the range of employee promotions
	 * @param end the upper bound of the range of employee promotions (not inclusive)
	 * @return the range of matching employee promotions
	 */
	@Override
	public List<EmployeePromotion> findByGradeModeId(
		long gradeModeId, int start, int end) {

		return findByGradeModeId(gradeModeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee promotions where gradeModeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePromotionModelImpl</code>.
	 * </p>
	 *
	 * @param gradeModeId the grade mode ID
	 * @param start the lower bound of the range of employee promotions
	 * @param end the upper bound of the range of employee promotions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee promotions
	 */
	@Override
	public List<EmployeePromotion> findByGradeModeId(
		long gradeModeId, int start, int end,
		OrderByComparator<EmployeePromotion> orderByComparator) {

		return findByGradeModeId(
			gradeModeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee promotions where gradeModeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePromotionModelImpl</code>.
	 * </p>
	 *
	 * @param gradeModeId the grade mode ID
	 * @param start the lower bound of the range of employee promotions
	 * @param end the upper bound of the range of employee promotions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee promotions
	 */
	@Override
	public List<EmployeePromotion> findByGradeModeId(
		long gradeModeId, int start, int end,
		OrderByComparator<EmployeePromotion> orderByComparator,
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

		List<EmployeePromotion> list = null;

		if (useFinderCache) {
			list = (List<EmployeePromotion>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeePromotion employeePromotion : list) {
					if (gradeModeId != employeePromotion.getGradeModeId()) {
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

			sb.append(_SQL_SELECT_EMPLOYEEPROMOTION_WHERE);

			sb.append(_FINDER_COLUMN_GRADEMODEID_GRADEMODEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeePromotionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(gradeModeId);

				list = (List<EmployeePromotion>)QueryUtil.list(
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
	 * Returns the first employee promotion in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee promotion
	 * @throws NoSuchEmployeePromotionException if a matching employee promotion could not be found
	 */
	@Override
	public EmployeePromotion findByGradeModeId_First(
			long gradeModeId,
			OrderByComparator<EmployeePromotion> orderByComparator)
		throws NoSuchEmployeePromotionException {

		EmployeePromotion employeePromotion = fetchByGradeModeId_First(
			gradeModeId, orderByComparator);

		if (employeePromotion != null) {
			return employeePromotion;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("gradeModeId=");
		sb.append(gradeModeId);

		sb.append("}");

		throw new NoSuchEmployeePromotionException(sb.toString());
	}

	/**
	 * Returns the first employee promotion in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee promotion, or <code>null</code> if a matching employee promotion could not be found
	 */
	@Override
	public EmployeePromotion fetchByGradeModeId_First(
		long gradeModeId,
		OrderByComparator<EmployeePromotion> orderByComparator) {

		List<EmployeePromotion> list = findByGradeModeId(
			gradeModeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee promotion in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee promotion
	 * @throws NoSuchEmployeePromotionException if a matching employee promotion could not be found
	 */
	@Override
	public EmployeePromotion findByGradeModeId_Last(
			long gradeModeId,
			OrderByComparator<EmployeePromotion> orderByComparator)
		throws NoSuchEmployeePromotionException {

		EmployeePromotion employeePromotion = fetchByGradeModeId_Last(
			gradeModeId, orderByComparator);

		if (employeePromotion != null) {
			return employeePromotion;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("gradeModeId=");
		sb.append(gradeModeId);

		sb.append("}");

		throw new NoSuchEmployeePromotionException(sb.toString());
	}

	/**
	 * Returns the last employee promotion in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee promotion, or <code>null</code> if a matching employee promotion could not be found
	 */
	@Override
	public EmployeePromotion fetchByGradeModeId_Last(
		long gradeModeId,
		OrderByComparator<EmployeePromotion> orderByComparator) {

		int count = countByGradeModeId(gradeModeId);

		if (count == 0) {
			return null;
		}

		List<EmployeePromotion> list = findByGradeModeId(
			gradeModeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee promotions before and after the current employee promotion in the ordered set where gradeModeId = &#63;.
	 *
	 * @param employeePromotionId the primary key of the current employee promotion
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee promotion
	 * @throws NoSuchEmployeePromotionException if a employee promotion with the primary key could not be found
	 */
	@Override
	public EmployeePromotion[] findByGradeModeId_PrevAndNext(
			long employeePromotionId, long gradeModeId,
			OrderByComparator<EmployeePromotion> orderByComparator)
		throws NoSuchEmployeePromotionException {

		EmployeePromotion employeePromotion = findByPrimaryKey(
			employeePromotionId);

		Session session = null;

		try {
			session = openSession();

			EmployeePromotion[] array = new EmployeePromotionImpl[3];

			array[0] = getByGradeModeId_PrevAndNext(
				session, employeePromotion, gradeModeId, orderByComparator,
				true);

			array[1] = employeePromotion;

			array[2] = getByGradeModeId_PrevAndNext(
				session, employeePromotion, gradeModeId, orderByComparator,
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

	protected EmployeePromotion getByGradeModeId_PrevAndNext(
		Session session, EmployeePromotion employeePromotion, long gradeModeId,
		OrderByComparator<EmployeePromotion> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEPROMOTION_WHERE);

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
			sb.append(EmployeePromotionModelImpl.ORDER_BY_JPQL);
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
						employeePromotion)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeePromotion> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee promotions where gradeModeId = &#63; from the database.
	 *
	 * @param gradeModeId the grade mode ID
	 */
	@Override
	public void removeByGradeModeId(long gradeModeId) {
		for (EmployeePromotion employeePromotion :
				findByGradeModeId(
					gradeModeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeePromotion);
		}
	}

	/**
	 * Returns the number of employee promotions where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @return the number of matching employee promotions
	 */
	@Override
	public int countByGradeModeId(long gradeModeId) {
		FinderPath finderPath = _finderPathCountByGradeModeId;

		Object[] finderArgs = new Object[] {gradeModeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEPROMOTION_WHERE);

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
		"employeePromotion.gradeModeId = ?";

	private FinderPath _finderPathWithPaginationFindByEmployeeId;
	private FinderPath _finderPathWithoutPaginationFindByEmployeeId;
	private FinderPath _finderPathCountByEmployeeId;

	/**
	 * Returns all the employee promotions where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee promotions
	 */
	@Override
	public List<EmployeePromotion> findByEmployeeId(long employeeId) {
		return findByEmployeeId(
			employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee promotions where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePromotionModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee promotions
	 * @param end the upper bound of the range of employee promotions (not inclusive)
	 * @return the range of matching employee promotions
	 */
	@Override
	public List<EmployeePromotion> findByEmployeeId(
		long employeeId, int start, int end) {

		return findByEmployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee promotions where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePromotionModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee promotions
	 * @param end the upper bound of the range of employee promotions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee promotions
	 */
	@Override
	public List<EmployeePromotion> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeePromotion> orderByComparator) {

		return findByEmployeeId(
			employeeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee promotions where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePromotionModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee promotions
	 * @param end the upper bound of the range of employee promotions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee promotions
	 */
	@Override
	public List<EmployeePromotion> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeePromotion> orderByComparator,
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

		List<EmployeePromotion> list = null;

		if (useFinderCache) {
			list = (List<EmployeePromotion>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeePromotion employeePromotion : list) {
					if (employeeId != employeePromotion.getEmployeeId()) {
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

			sb.append(_SQL_SELECT_EMPLOYEEPROMOTION_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeePromotionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				list = (List<EmployeePromotion>)QueryUtil.list(
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
	 * Returns the first employee promotion in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee promotion
	 * @throws NoSuchEmployeePromotionException if a matching employee promotion could not be found
	 */
	@Override
	public EmployeePromotion findByEmployeeId_First(
			long employeeId,
			OrderByComparator<EmployeePromotion> orderByComparator)
		throws NoSuchEmployeePromotionException {

		EmployeePromotion employeePromotion = fetchByEmployeeId_First(
			employeeId, orderByComparator);

		if (employeePromotion != null) {
			return employeePromotion;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeePromotionException(sb.toString());
	}

	/**
	 * Returns the first employee promotion in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee promotion, or <code>null</code> if a matching employee promotion could not be found
	 */
	@Override
	public EmployeePromotion fetchByEmployeeId_First(
		long employeeId,
		OrderByComparator<EmployeePromotion> orderByComparator) {

		List<EmployeePromotion> list = findByEmployeeId(
			employeeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee promotion in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee promotion
	 * @throws NoSuchEmployeePromotionException if a matching employee promotion could not be found
	 */
	@Override
	public EmployeePromotion findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<EmployeePromotion> orderByComparator)
		throws NoSuchEmployeePromotionException {

		EmployeePromotion employeePromotion = fetchByEmployeeId_Last(
			employeeId, orderByComparator);

		if (employeePromotion != null) {
			return employeePromotion;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeePromotionException(sb.toString());
	}

	/**
	 * Returns the last employee promotion in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee promotion, or <code>null</code> if a matching employee promotion could not be found
	 */
	@Override
	public EmployeePromotion fetchByEmployeeId_Last(
		long employeeId,
		OrderByComparator<EmployeePromotion> orderByComparator) {

		int count = countByEmployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<EmployeePromotion> list = findByEmployeeId(
			employeeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee promotions before and after the current employee promotion in the ordered set where employeeId = &#63;.
	 *
	 * @param employeePromotionId the primary key of the current employee promotion
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee promotion
	 * @throws NoSuchEmployeePromotionException if a employee promotion with the primary key could not be found
	 */
	@Override
	public EmployeePromotion[] findByEmployeeId_PrevAndNext(
			long employeePromotionId, long employeeId,
			OrderByComparator<EmployeePromotion> orderByComparator)
		throws NoSuchEmployeePromotionException {

		EmployeePromotion employeePromotion = findByPrimaryKey(
			employeePromotionId);

		Session session = null;

		try {
			session = openSession();

			EmployeePromotion[] array = new EmployeePromotionImpl[3];

			array[0] = getByEmployeeId_PrevAndNext(
				session, employeePromotion, employeeId, orderByComparator,
				true);

			array[1] = employeePromotion;

			array[2] = getByEmployeeId_PrevAndNext(
				session, employeePromotion, employeeId, orderByComparator,
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

	protected EmployeePromotion getByEmployeeId_PrevAndNext(
		Session session, EmployeePromotion employeePromotion, long employeeId,
		OrderByComparator<EmployeePromotion> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEPROMOTION_WHERE);

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
			sb.append(EmployeePromotionModelImpl.ORDER_BY_JPQL);
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
						employeePromotion)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeePromotion> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee promotions where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeByEmployeeId(long employeeId) {
		for (EmployeePromotion employeePromotion :
				findByEmployeeId(
					employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeePromotion);
		}
	}

	/**
	 * Returns the number of employee promotions where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee promotions
	 */
	@Override
	public int countByEmployeeId(long employeeId) {
		FinderPath finderPath = _finderPathCountByEmployeeId;

		Object[] finderArgs = new Object[] {employeeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEPROMOTION_WHERE);

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
		"employeePromotion.employeeId = ?";

	private FinderPath _finderPathWithPaginationFindByOrganizationId;
	private FinderPath _finderPathWithoutPaginationFindByOrganizationId;
	private FinderPath _finderPathCountByOrganizationId;

	/**
	 * Returns all the employee promotions where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching employee promotions
	 */
	@Override
	public List<EmployeePromotion> findByOrganizationId(long organizationId) {
		return findByOrganizationId(
			organizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee promotions where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePromotionModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee promotions
	 * @param end the upper bound of the range of employee promotions (not inclusive)
	 * @return the range of matching employee promotions
	 */
	@Override
	public List<EmployeePromotion> findByOrganizationId(
		long organizationId, int start, int end) {

		return findByOrganizationId(organizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee promotions where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePromotionModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee promotions
	 * @param end the upper bound of the range of employee promotions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee promotions
	 */
	@Override
	public List<EmployeePromotion> findByOrganizationId(
		long organizationId, int start, int end,
		OrderByComparator<EmployeePromotion> orderByComparator) {

		return findByOrganizationId(
			organizationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee promotions where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePromotionModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee promotions
	 * @param end the upper bound of the range of employee promotions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee promotions
	 */
	@Override
	public List<EmployeePromotion> findByOrganizationId(
		long organizationId, int start, int end,
		OrderByComparator<EmployeePromotion> orderByComparator,
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

		List<EmployeePromotion> list = null;

		if (useFinderCache) {
			list = (List<EmployeePromotion>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeePromotion employeePromotion : list) {
					if (organizationId !=
							employeePromotion.getOrganizationId()) {

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

			sb.append(_SQL_SELECT_EMPLOYEEPROMOTION_WHERE);

			sb.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeePromotionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(organizationId);

				list = (List<EmployeePromotion>)QueryUtil.list(
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
	 * Returns the first employee promotion in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee promotion
	 * @throws NoSuchEmployeePromotionException if a matching employee promotion could not be found
	 */
	@Override
	public EmployeePromotion findByOrganizationId_First(
			long organizationId,
			OrderByComparator<EmployeePromotion> orderByComparator)
		throws NoSuchEmployeePromotionException {

		EmployeePromotion employeePromotion = fetchByOrganizationId_First(
			organizationId, orderByComparator);

		if (employeePromotion != null) {
			return employeePromotion;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("organizationId=");
		sb.append(organizationId);

		sb.append("}");

		throw new NoSuchEmployeePromotionException(sb.toString());
	}

	/**
	 * Returns the first employee promotion in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee promotion, or <code>null</code> if a matching employee promotion could not be found
	 */
	@Override
	public EmployeePromotion fetchByOrganizationId_First(
		long organizationId,
		OrderByComparator<EmployeePromotion> orderByComparator) {

		List<EmployeePromotion> list = findByOrganizationId(
			organizationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee promotion in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee promotion
	 * @throws NoSuchEmployeePromotionException if a matching employee promotion could not be found
	 */
	@Override
	public EmployeePromotion findByOrganizationId_Last(
			long organizationId,
			OrderByComparator<EmployeePromotion> orderByComparator)
		throws NoSuchEmployeePromotionException {

		EmployeePromotion employeePromotion = fetchByOrganizationId_Last(
			organizationId, orderByComparator);

		if (employeePromotion != null) {
			return employeePromotion;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("organizationId=");
		sb.append(organizationId);

		sb.append("}");

		throw new NoSuchEmployeePromotionException(sb.toString());
	}

	/**
	 * Returns the last employee promotion in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee promotion, or <code>null</code> if a matching employee promotion could not be found
	 */
	@Override
	public EmployeePromotion fetchByOrganizationId_Last(
		long organizationId,
		OrderByComparator<EmployeePromotion> orderByComparator) {

		int count = countByOrganizationId(organizationId);

		if (count == 0) {
			return null;
		}

		List<EmployeePromotion> list = findByOrganizationId(
			organizationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee promotions before and after the current employee promotion in the ordered set where organizationId = &#63;.
	 *
	 * @param employeePromotionId the primary key of the current employee promotion
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee promotion
	 * @throws NoSuchEmployeePromotionException if a employee promotion with the primary key could not be found
	 */
	@Override
	public EmployeePromotion[] findByOrganizationId_PrevAndNext(
			long employeePromotionId, long organizationId,
			OrderByComparator<EmployeePromotion> orderByComparator)
		throws NoSuchEmployeePromotionException {

		EmployeePromotion employeePromotion = findByPrimaryKey(
			employeePromotionId);

		Session session = null;

		try {
			session = openSession();

			EmployeePromotion[] array = new EmployeePromotionImpl[3];

			array[0] = getByOrganizationId_PrevAndNext(
				session, employeePromotion, organizationId, orderByComparator,
				true);

			array[1] = employeePromotion;

			array[2] = getByOrganizationId_PrevAndNext(
				session, employeePromotion, organizationId, orderByComparator,
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

	protected EmployeePromotion getByOrganizationId_PrevAndNext(
		Session session, EmployeePromotion employeePromotion,
		long organizationId,
		OrderByComparator<EmployeePromotion> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEPROMOTION_WHERE);

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
			sb.append(EmployeePromotionModelImpl.ORDER_BY_JPQL);
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
						employeePromotion)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeePromotion> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee promotions where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	@Override
	public void removeByOrganizationId(long organizationId) {
		for (EmployeePromotion employeePromotion :
				findByOrganizationId(
					organizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(employeePromotion);
		}
	}

	/**
	 * Returns the number of employee promotions where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching employee promotions
	 */
	@Override
	public int countByOrganizationId(long organizationId) {
		FinderPath finderPath = _finderPathCountByOrganizationId;

		Object[] finderArgs = new Object[] {organizationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEPROMOTION_WHERE);

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
		"employeePromotion.organizationId = ?";

	public EmployeePromotionPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(EmployeePromotion.class);

		setModelImplClass(EmployeePromotionImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the employee promotion in the entity cache if it is enabled.
	 *
	 * @param employeePromotion the employee promotion
	 */
	@Override
	public void cacheResult(EmployeePromotion employeePromotion) {
		entityCache.putResult(
			EmployeePromotionImpl.class, employeePromotion.getPrimaryKey(),
			employeePromotion);
	}

	/**
	 * Caches the employee promotions in the entity cache if it is enabled.
	 *
	 * @param employeePromotions the employee promotions
	 */
	@Override
	public void cacheResult(List<EmployeePromotion> employeePromotions) {
		for (EmployeePromotion employeePromotion : employeePromotions) {
			if (entityCache.getResult(
					EmployeePromotionImpl.class,
					employeePromotion.getPrimaryKey()) == null) {

				cacheResult(employeePromotion);
			}
		}
	}

	/**
	 * Clears the cache for all employee promotions.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmployeePromotionImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the employee promotion.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmployeePromotion employeePromotion) {
		entityCache.removeResult(
			EmployeePromotionImpl.class, employeePromotion);
	}

	@Override
	public void clearCache(List<EmployeePromotion> employeePromotions) {
		for (EmployeePromotion employeePromotion : employeePromotions) {
			entityCache.removeResult(
				EmployeePromotionImpl.class, employeePromotion);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EmployeePromotionImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new employee promotion with the primary key. Does not add the employee promotion to the database.
	 *
	 * @param employeePromotionId the primary key for the new employee promotion
	 * @return the new employee promotion
	 */
	@Override
	public EmployeePromotion create(long employeePromotionId) {
		EmployeePromotion employeePromotion = new EmployeePromotionImpl();

		employeePromotion.setNew(true);
		employeePromotion.setPrimaryKey(employeePromotionId);

		employeePromotion.setCompanyId(CompanyThreadLocal.getCompanyId());

		return employeePromotion;
	}

	/**
	 * Removes the employee promotion with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeePromotionId the primary key of the employee promotion
	 * @return the employee promotion that was removed
	 * @throws NoSuchEmployeePromotionException if a employee promotion with the primary key could not be found
	 */
	@Override
	public EmployeePromotion remove(long employeePromotionId)
		throws NoSuchEmployeePromotionException {

		return remove((Serializable)employeePromotionId);
	}

	/**
	 * Removes the employee promotion with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the employee promotion
	 * @return the employee promotion that was removed
	 * @throws NoSuchEmployeePromotionException if a employee promotion with the primary key could not be found
	 */
	@Override
	public EmployeePromotion remove(Serializable primaryKey)
		throws NoSuchEmployeePromotionException {

		Session session = null;

		try {
			session = openSession();

			EmployeePromotion employeePromotion =
				(EmployeePromotion)session.get(
					EmployeePromotionImpl.class, primaryKey);

			if (employeePromotion == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmployeePromotionException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(employeePromotion);
		}
		catch (NoSuchEmployeePromotionException noSuchEntityException) {
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
	protected EmployeePromotion removeImpl(
		EmployeePromotion employeePromotion) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(employeePromotion)) {
				employeePromotion = (EmployeePromotion)session.get(
					EmployeePromotionImpl.class,
					employeePromotion.getPrimaryKeyObj());
			}

			if (employeePromotion != null) {
				session.delete(employeePromotion);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (employeePromotion != null) {
			clearCache(employeePromotion);
		}

		return employeePromotion;
	}

	@Override
	public EmployeePromotion updateImpl(EmployeePromotion employeePromotion) {
		boolean isNew = employeePromotion.isNew();

		if (!(employeePromotion instanceof EmployeePromotionModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(employeePromotion.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					employeePromotion);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in employeePromotion proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EmployeePromotion implementation " +
					employeePromotion.getClass());
		}

		EmployeePromotionModelImpl employeePromotionModelImpl =
			(EmployeePromotionModelImpl)employeePromotion;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (employeePromotion.getCreateDate() == null)) {
			if (serviceContext == null) {
				employeePromotion.setCreateDate(now);
			}
			else {
				employeePromotion.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!employeePromotionModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				employeePromotion.setModifiedDate(now);
			}
			else {
				employeePromotion.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(employeePromotion);
			}
			else {
				employeePromotion = (EmployeePromotion)session.merge(
					employeePromotion);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EmployeePromotionImpl.class, employeePromotionModelImpl, false,
			true);

		if (isNew) {
			employeePromotion.setNew(false);
		}

		employeePromotion.resetOriginalValues();

		return employeePromotion;
	}

	/**
	 * Returns the employee promotion with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee promotion
	 * @return the employee promotion
	 * @throws NoSuchEmployeePromotionException if a employee promotion with the primary key could not be found
	 */
	@Override
	public EmployeePromotion findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmployeePromotionException {

		EmployeePromotion employeePromotion = fetchByPrimaryKey(primaryKey);

		if (employeePromotion == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmployeePromotionException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return employeePromotion;
	}

	/**
	 * Returns the employee promotion with the primary key or throws a <code>NoSuchEmployeePromotionException</code> if it could not be found.
	 *
	 * @param employeePromotionId the primary key of the employee promotion
	 * @return the employee promotion
	 * @throws NoSuchEmployeePromotionException if a employee promotion with the primary key could not be found
	 */
	@Override
	public EmployeePromotion findByPrimaryKey(long employeePromotionId)
		throws NoSuchEmployeePromotionException {

		return findByPrimaryKey((Serializable)employeePromotionId);
	}

	/**
	 * Returns the employee promotion with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeePromotionId the primary key of the employee promotion
	 * @return the employee promotion, or <code>null</code> if a employee promotion with the primary key could not be found
	 */
	@Override
	public EmployeePromotion fetchByPrimaryKey(long employeePromotionId) {
		return fetchByPrimaryKey((Serializable)employeePromotionId);
	}

	/**
	 * Returns all the employee promotions.
	 *
	 * @return the employee promotions
	 */
	@Override
	public List<EmployeePromotion> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee promotions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePromotionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee promotions
	 * @param end the upper bound of the range of employee promotions (not inclusive)
	 * @return the range of employee promotions
	 */
	@Override
	public List<EmployeePromotion> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee promotions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePromotionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee promotions
	 * @param end the upper bound of the range of employee promotions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee promotions
	 */
	@Override
	public List<EmployeePromotion> findAll(
		int start, int end,
		OrderByComparator<EmployeePromotion> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee promotions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePromotionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee promotions
	 * @param end the upper bound of the range of employee promotions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee promotions
	 */
	@Override
	public List<EmployeePromotion> findAll(
		int start, int end,
		OrderByComparator<EmployeePromotion> orderByComparator,
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

		List<EmployeePromotion> list = null;

		if (useFinderCache) {
			list = (List<EmployeePromotion>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EMPLOYEEPROMOTION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLOYEEPROMOTION;

				sql = sql.concat(EmployeePromotionModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EmployeePromotion>)QueryUtil.list(
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
	 * Removes all the employee promotions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EmployeePromotion employeePromotion : findAll()) {
			remove(employeePromotion);
		}
	}

	/**
	 * Returns the number of employee promotions.
	 *
	 * @return the number of employee promotions
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_EMPLOYEEPROMOTION);

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
		return "employeePromotionId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EMPLOYEEPROMOTION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EmployeePromotionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the employee promotion persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new EmployeePromotionModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", EmployeePromotion.class.getName()));

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
		entityCache.removeCache(EmployeePromotionImpl.class.getName());

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

	private static final String _SQL_SELECT_EMPLOYEEPROMOTION =
		"SELECT employeePromotion FROM EmployeePromotion employeePromotion";

	private static final String _SQL_SELECT_EMPLOYEEPROMOTION_WHERE =
		"SELECT employeePromotion FROM EmployeePromotion employeePromotion WHERE ";

	private static final String _SQL_COUNT_EMPLOYEEPROMOTION =
		"SELECT COUNT(employeePromotion) FROM EmployeePromotion employeePromotion";

	private static final String _SQL_COUNT_EMPLOYEEPROMOTION_WHERE =
		"SELECT COUNT(employeePromotion) FROM EmployeePromotion employeePromotion WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "employeePromotion.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EmployeePromotion exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EmployeePromotion exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EmployeePromotionPersistenceImpl.class);

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

	private static class EmployeePromotionModelArgumentsResolver
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

			EmployeePromotionModelImpl employeePromotionModelImpl =
				(EmployeePromotionModelImpl)baseModel;

			long columnBitmask = employeePromotionModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					employeePromotionModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						employeePromotionModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					employeePromotionModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			EmployeePromotionModelImpl employeePromotionModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						employeePromotionModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = employeePromotionModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}