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

package com.adjecti.mdm.liferay.service.persistence.impl;

import com.adjecti.mdm.liferay.exception.NoSuchCadreDesignationException;
import com.adjecti.mdm.liferay.model.CadreDesignation;
import com.adjecti.mdm.liferay.model.impl.CadreDesignationImpl;
import com.adjecti.mdm.liferay.model.impl.CadreDesignationModelImpl;
import com.adjecti.mdm.liferay.service.persistence.CadreDesignationPersistence;
import com.adjecti.mdm.liferay.service.persistence.impl.constants.mdmPersistenceConstants;

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
 * The persistence implementation for the cadre designation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CadreDesignationPersistence.class)
public class CadreDesignationPersistenceImpl
	extends BasePersistenceImpl<CadreDesignation>
	implements CadreDesignationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CadreDesignationUtil</code> to access the cadre designation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CadreDesignationImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByCadreId;
	private FinderPath _finderPathWithoutPaginationFindByCadreId;
	private FinderPath _finderPathCountByCadreId;

	/**
	 * Returns all the cadre designations where cadreId = &#63;.
	 *
	 * @param cadreId the cadre ID
	 * @return the matching cadre designations
	 */
	@Override
	public List<CadreDesignation> findByCadreId(long cadreId) {
		return findByCadreId(
			cadreId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cadre designations where cadreId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CadreDesignationModelImpl</code>.
	 * </p>
	 *
	 * @param cadreId the cadre ID
	 * @param start the lower bound of the range of cadre designations
	 * @param end the upper bound of the range of cadre designations (not inclusive)
	 * @return the range of matching cadre designations
	 */
	@Override
	public List<CadreDesignation> findByCadreId(
		long cadreId, int start, int end) {

		return findByCadreId(cadreId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cadre designations where cadreId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CadreDesignationModelImpl</code>.
	 * </p>
	 *
	 * @param cadreId the cadre ID
	 * @param start the lower bound of the range of cadre designations
	 * @param end the upper bound of the range of cadre designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cadre designations
	 */
	@Override
	public List<CadreDesignation> findByCadreId(
		long cadreId, int start, int end,
		OrderByComparator<CadreDesignation> orderByComparator) {

		return findByCadreId(cadreId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cadre designations where cadreId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CadreDesignationModelImpl</code>.
	 * </p>
	 *
	 * @param cadreId the cadre ID
	 * @param start the lower bound of the range of cadre designations
	 * @param end the upper bound of the range of cadre designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cadre designations
	 */
	@Override
	public List<CadreDesignation> findByCadreId(
		long cadreId, int start, int end,
		OrderByComparator<CadreDesignation> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCadreId;
				finderArgs = new Object[] {cadreId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCadreId;
			finderArgs = new Object[] {cadreId, start, end, orderByComparator};
		}

		List<CadreDesignation> list = null;

		if (useFinderCache) {
			list = (List<CadreDesignation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CadreDesignation cadreDesignation : list) {
					if (cadreId != cadreDesignation.getCadreId()) {
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

			sb.append(_SQL_SELECT_CADREDESIGNATION_WHERE);

			sb.append(_FINDER_COLUMN_CADREID_CADREID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CadreDesignationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(cadreId);

				list = (List<CadreDesignation>)QueryUtil.list(
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
	 * Returns the first cadre designation in the ordered set where cadreId = &#63;.
	 *
	 * @param cadreId the cadre ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cadre designation
	 * @throws NoSuchCadreDesignationException if a matching cadre designation could not be found
	 */
	@Override
	public CadreDesignation findByCadreId_First(
			long cadreId, OrderByComparator<CadreDesignation> orderByComparator)
		throws NoSuchCadreDesignationException {

		CadreDesignation cadreDesignation = fetchByCadreId_First(
			cadreId, orderByComparator);

		if (cadreDesignation != null) {
			return cadreDesignation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("cadreId=");
		sb.append(cadreId);

		sb.append("}");

		throw new NoSuchCadreDesignationException(sb.toString());
	}

	/**
	 * Returns the first cadre designation in the ordered set where cadreId = &#63;.
	 *
	 * @param cadreId the cadre ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cadre designation, or <code>null</code> if a matching cadre designation could not be found
	 */
	@Override
	public CadreDesignation fetchByCadreId_First(
		long cadreId, OrderByComparator<CadreDesignation> orderByComparator) {

		List<CadreDesignation> list = findByCadreId(
			cadreId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cadre designation in the ordered set where cadreId = &#63;.
	 *
	 * @param cadreId the cadre ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cadre designation
	 * @throws NoSuchCadreDesignationException if a matching cadre designation could not be found
	 */
	@Override
	public CadreDesignation findByCadreId_Last(
			long cadreId, OrderByComparator<CadreDesignation> orderByComparator)
		throws NoSuchCadreDesignationException {

		CadreDesignation cadreDesignation = fetchByCadreId_Last(
			cadreId, orderByComparator);

		if (cadreDesignation != null) {
			return cadreDesignation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("cadreId=");
		sb.append(cadreId);

		sb.append("}");

		throw new NoSuchCadreDesignationException(sb.toString());
	}

	/**
	 * Returns the last cadre designation in the ordered set where cadreId = &#63;.
	 *
	 * @param cadreId the cadre ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cadre designation, or <code>null</code> if a matching cadre designation could not be found
	 */
	@Override
	public CadreDesignation fetchByCadreId_Last(
		long cadreId, OrderByComparator<CadreDesignation> orderByComparator) {

		int count = countByCadreId(cadreId);

		if (count == 0) {
			return null;
		}

		List<CadreDesignation> list = findByCadreId(
			cadreId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cadre designations before and after the current cadre designation in the ordered set where cadreId = &#63;.
	 *
	 * @param cadreDesignationId the primary key of the current cadre designation
	 * @param cadreId the cadre ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cadre designation
	 * @throws NoSuchCadreDesignationException if a cadre designation with the primary key could not be found
	 */
	@Override
	public CadreDesignation[] findByCadreId_PrevAndNext(
			long cadreDesignationId, long cadreId,
			OrderByComparator<CadreDesignation> orderByComparator)
		throws NoSuchCadreDesignationException {

		CadreDesignation cadreDesignation = findByPrimaryKey(
			cadreDesignationId);

		Session session = null;

		try {
			session = openSession();

			CadreDesignation[] array = new CadreDesignationImpl[3];

			array[0] = getByCadreId_PrevAndNext(
				session, cadreDesignation, cadreId, orderByComparator, true);

			array[1] = cadreDesignation;

			array[2] = getByCadreId_PrevAndNext(
				session, cadreDesignation, cadreId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CadreDesignation getByCadreId_PrevAndNext(
		Session session, CadreDesignation cadreDesignation, long cadreId,
		OrderByComparator<CadreDesignation> orderByComparator,
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

		sb.append(_SQL_SELECT_CADREDESIGNATION_WHERE);

		sb.append(_FINDER_COLUMN_CADREID_CADREID_2);

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
			sb.append(CadreDesignationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(cadreId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						cadreDesignation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CadreDesignation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cadre designations where cadreId = &#63; from the database.
	 *
	 * @param cadreId the cadre ID
	 */
	@Override
	public void removeByCadreId(long cadreId) {
		for (CadreDesignation cadreDesignation :
				findByCadreId(
					cadreId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(cadreDesignation);
		}
	}

	/**
	 * Returns the number of cadre designations where cadreId = &#63;.
	 *
	 * @param cadreId the cadre ID
	 * @return the number of matching cadre designations
	 */
	@Override
	public int countByCadreId(long cadreId) {
		FinderPath finderPath = _finderPathCountByCadreId;

		Object[] finderArgs = new Object[] {cadreId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CADREDESIGNATION_WHERE);

			sb.append(_FINDER_COLUMN_CADREID_CADREID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(cadreId);

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

	private static final String _FINDER_COLUMN_CADREID_CADREID_2 =
		"cadreDesignation.cadreId = ?";

	private FinderPath _finderPathWithPaginationFindByDesignationId;
	private FinderPath _finderPathWithoutPaginationFindByDesignationId;
	private FinderPath _finderPathCountByDesignationId;

	/**
	 * Returns all the cadre designations where designationId = &#63;.
	 *
	 * @param designationId the designation ID
	 * @return the matching cadre designations
	 */
	@Override
	public List<CadreDesignation> findByDesignationId(long designationId) {
		return findByDesignationId(
			designationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cadre designations where designationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CadreDesignationModelImpl</code>.
	 * </p>
	 *
	 * @param designationId the designation ID
	 * @param start the lower bound of the range of cadre designations
	 * @param end the upper bound of the range of cadre designations (not inclusive)
	 * @return the range of matching cadre designations
	 */
	@Override
	public List<CadreDesignation> findByDesignationId(
		long designationId, int start, int end) {

		return findByDesignationId(designationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cadre designations where designationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CadreDesignationModelImpl</code>.
	 * </p>
	 *
	 * @param designationId the designation ID
	 * @param start the lower bound of the range of cadre designations
	 * @param end the upper bound of the range of cadre designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cadre designations
	 */
	@Override
	public List<CadreDesignation> findByDesignationId(
		long designationId, int start, int end,
		OrderByComparator<CadreDesignation> orderByComparator) {

		return findByDesignationId(
			designationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cadre designations where designationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CadreDesignationModelImpl</code>.
	 * </p>
	 *
	 * @param designationId the designation ID
	 * @param start the lower bound of the range of cadre designations
	 * @param end the upper bound of the range of cadre designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cadre designations
	 */
	@Override
	public List<CadreDesignation> findByDesignationId(
		long designationId, int start, int end,
		OrderByComparator<CadreDesignation> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDesignationId;
				finderArgs = new Object[] {designationId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDesignationId;
			finderArgs = new Object[] {
				designationId, start, end, orderByComparator
			};
		}

		List<CadreDesignation> list = null;

		if (useFinderCache) {
			list = (List<CadreDesignation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CadreDesignation cadreDesignation : list) {
					if (designationId != cadreDesignation.getDesignationId()) {
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

			sb.append(_SQL_SELECT_CADREDESIGNATION_WHERE);

			sb.append(_FINDER_COLUMN_DESIGNATIONID_DESIGNATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CadreDesignationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(designationId);

				list = (List<CadreDesignation>)QueryUtil.list(
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
	 * Returns the first cadre designation in the ordered set where designationId = &#63;.
	 *
	 * @param designationId the designation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cadre designation
	 * @throws NoSuchCadreDesignationException if a matching cadre designation could not be found
	 */
	@Override
	public CadreDesignation findByDesignationId_First(
			long designationId,
			OrderByComparator<CadreDesignation> orderByComparator)
		throws NoSuchCadreDesignationException {

		CadreDesignation cadreDesignation = fetchByDesignationId_First(
			designationId, orderByComparator);

		if (cadreDesignation != null) {
			return cadreDesignation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("designationId=");
		sb.append(designationId);

		sb.append("}");

		throw new NoSuchCadreDesignationException(sb.toString());
	}

	/**
	 * Returns the first cadre designation in the ordered set where designationId = &#63;.
	 *
	 * @param designationId the designation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cadre designation, or <code>null</code> if a matching cadre designation could not be found
	 */
	@Override
	public CadreDesignation fetchByDesignationId_First(
		long designationId,
		OrderByComparator<CadreDesignation> orderByComparator) {

		List<CadreDesignation> list = findByDesignationId(
			designationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cadre designation in the ordered set where designationId = &#63;.
	 *
	 * @param designationId the designation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cadre designation
	 * @throws NoSuchCadreDesignationException if a matching cadre designation could not be found
	 */
	@Override
	public CadreDesignation findByDesignationId_Last(
			long designationId,
			OrderByComparator<CadreDesignation> orderByComparator)
		throws NoSuchCadreDesignationException {

		CadreDesignation cadreDesignation = fetchByDesignationId_Last(
			designationId, orderByComparator);

		if (cadreDesignation != null) {
			return cadreDesignation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("designationId=");
		sb.append(designationId);

		sb.append("}");

		throw new NoSuchCadreDesignationException(sb.toString());
	}

	/**
	 * Returns the last cadre designation in the ordered set where designationId = &#63;.
	 *
	 * @param designationId the designation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cadre designation, or <code>null</code> if a matching cadre designation could not be found
	 */
	@Override
	public CadreDesignation fetchByDesignationId_Last(
		long designationId,
		OrderByComparator<CadreDesignation> orderByComparator) {

		int count = countByDesignationId(designationId);

		if (count == 0) {
			return null;
		}

		List<CadreDesignation> list = findByDesignationId(
			designationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cadre designations before and after the current cadre designation in the ordered set where designationId = &#63;.
	 *
	 * @param cadreDesignationId the primary key of the current cadre designation
	 * @param designationId the designation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cadre designation
	 * @throws NoSuchCadreDesignationException if a cadre designation with the primary key could not be found
	 */
	@Override
	public CadreDesignation[] findByDesignationId_PrevAndNext(
			long cadreDesignationId, long designationId,
			OrderByComparator<CadreDesignation> orderByComparator)
		throws NoSuchCadreDesignationException {

		CadreDesignation cadreDesignation = findByPrimaryKey(
			cadreDesignationId);

		Session session = null;

		try {
			session = openSession();

			CadreDesignation[] array = new CadreDesignationImpl[3];

			array[0] = getByDesignationId_PrevAndNext(
				session, cadreDesignation, designationId, orderByComparator,
				true);

			array[1] = cadreDesignation;

			array[2] = getByDesignationId_PrevAndNext(
				session, cadreDesignation, designationId, orderByComparator,
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

	protected CadreDesignation getByDesignationId_PrevAndNext(
		Session session, CadreDesignation cadreDesignation, long designationId,
		OrderByComparator<CadreDesignation> orderByComparator,
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

		sb.append(_SQL_SELECT_CADREDESIGNATION_WHERE);

		sb.append(_FINDER_COLUMN_DESIGNATIONID_DESIGNATIONID_2);

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
			sb.append(CadreDesignationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(designationId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						cadreDesignation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CadreDesignation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cadre designations where designationId = &#63; from the database.
	 *
	 * @param designationId the designation ID
	 */
	@Override
	public void removeByDesignationId(long designationId) {
		for (CadreDesignation cadreDesignation :
				findByDesignationId(
					designationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(cadreDesignation);
		}
	}

	/**
	 * Returns the number of cadre designations where designationId = &#63;.
	 *
	 * @param designationId the designation ID
	 * @return the number of matching cadre designations
	 */
	@Override
	public int countByDesignationId(long designationId) {
		FinderPath finderPath = _finderPathCountByDesignationId;

		Object[] finderArgs = new Object[] {designationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CADREDESIGNATION_WHERE);

			sb.append(_FINDER_COLUMN_DESIGNATIONID_DESIGNATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(designationId);

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

	private static final String _FINDER_COLUMN_DESIGNATIONID_DESIGNATIONID_2 =
		"cadreDesignation.designationId = ?";

	public CadreDesignationPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("rank", "rank_");

		setDBColumnNames(dbColumnNames);

		setModelClass(CadreDesignation.class);

		setModelImplClass(CadreDesignationImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the cadre designation in the entity cache if it is enabled.
	 *
	 * @param cadreDesignation the cadre designation
	 */
	@Override
	public void cacheResult(CadreDesignation cadreDesignation) {
		entityCache.putResult(
			CadreDesignationImpl.class, cadreDesignation.getPrimaryKey(),
			cadreDesignation);
	}

	/**
	 * Caches the cadre designations in the entity cache if it is enabled.
	 *
	 * @param cadreDesignations the cadre designations
	 */
	@Override
	public void cacheResult(List<CadreDesignation> cadreDesignations) {
		for (CadreDesignation cadreDesignation : cadreDesignations) {
			if (entityCache.getResult(
					CadreDesignationImpl.class,
					cadreDesignation.getPrimaryKey()) == null) {

				cacheResult(cadreDesignation);
			}
		}
	}

	/**
	 * Clears the cache for all cadre designations.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CadreDesignationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cadre designation.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CadreDesignation cadreDesignation) {
		entityCache.removeResult(CadreDesignationImpl.class, cadreDesignation);
	}

	@Override
	public void clearCache(List<CadreDesignation> cadreDesignations) {
		for (CadreDesignation cadreDesignation : cadreDesignations) {
			entityCache.removeResult(
				CadreDesignationImpl.class, cadreDesignation);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CadreDesignationImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new cadre designation with the primary key. Does not add the cadre designation to the database.
	 *
	 * @param cadreDesignationId the primary key for the new cadre designation
	 * @return the new cadre designation
	 */
	@Override
	public CadreDesignation create(long cadreDesignationId) {
		CadreDesignation cadreDesignation = new CadreDesignationImpl();

		cadreDesignation.setNew(true);
		cadreDesignation.setPrimaryKey(cadreDesignationId);

		cadreDesignation.setCompanyId(CompanyThreadLocal.getCompanyId());

		return cadreDesignation;
	}

	/**
	 * Removes the cadre designation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cadreDesignationId the primary key of the cadre designation
	 * @return the cadre designation that was removed
	 * @throws NoSuchCadreDesignationException if a cadre designation with the primary key could not be found
	 */
	@Override
	public CadreDesignation remove(long cadreDesignationId)
		throws NoSuchCadreDesignationException {

		return remove((Serializable)cadreDesignationId);
	}

	/**
	 * Removes the cadre designation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cadre designation
	 * @return the cadre designation that was removed
	 * @throws NoSuchCadreDesignationException if a cadre designation with the primary key could not be found
	 */
	@Override
	public CadreDesignation remove(Serializable primaryKey)
		throws NoSuchCadreDesignationException {

		Session session = null;

		try {
			session = openSession();

			CadreDesignation cadreDesignation = (CadreDesignation)session.get(
				CadreDesignationImpl.class, primaryKey);

			if (cadreDesignation == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCadreDesignationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(cadreDesignation);
		}
		catch (NoSuchCadreDesignationException noSuchEntityException) {
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
	protected CadreDesignation removeImpl(CadreDesignation cadreDesignation) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(cadreDesignation)) {
				cadreDesignation = (CadreDesignation)session.get(
					CadreDesignationImpl.class,
					cadreDesignation.getPrimaryKeyObj());
			}

			if (cadreDesignation != null) {
				session.delete(cadreDesignation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (cadreDesignation != null) {
			clearCache(cadreDesignation);
		}

		return cadreDesignation;
	}

	@Override
	public CadreDesignation updateImpl(CadreDesignation cadreDesignation) {
		boolean isNew = cadreDesignation.isNew();

		if (!(cadreDesignation instanceof CadreDesignationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(cadreDesignation.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					cadreDesignation);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in cadreDesignation proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CadreDesignation implementation " +
					cadreDesignation.getClass());
		}

		CadreDesignationModelImpl cadreDesignationModelImpl =
			(CadreDesignationModelImpl)cadreDesignation;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (cadreDesignation.getCreateDate() == null)) {
			if (serviceContext == null) {
				cadreDesignation.setCreateDate(now);
			}
			else {
				cadreDesignation.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!cadreDesignationModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				cadreDesignation.setModifiedDate(now);
			}
			else {
				cadreDesignation.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(cadreDesignation);
			}
			else {
				cadreDesignation = (CadreDesignation)session.merge(
					cadreDesignation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			CadreDesignationImpl.class, cadreDesignationModelImpl, false, true);

		if (isNew) {
			cadreDesignation.setNew(false);
		}

		cadreDesignation.resetOriginalValues();

		return cadreDesignation;
	}

	/**
	 * Returns the cadre designation with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cadre designation
	 * @return the cadre designation
	 * @throws NoSuchCadreDesignationException if a cadre designation with the primary key could not be found
	 */
	@Override
	public CadreDesignation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCadreDesignationException {

		CadreDesignation cadreDesignation = fetchByPrimaryKey(primaryKey);

		if (cadreDesignation == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCadreDesignationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return cadreDesignation;
	}

	/**
	 * Returns the cadre designation with the primary key or throws a <code>NoSuchCadreDesignationException</code> if it could not be found.
	 *
	 * @param cadreDesignationId the primary key of the cadre designation
	 * @return the cadre designation
	 * @throws NoSuchCadreDesignationException if a cadre designation with the primary key could not be found
	 */
	@Override
	public CadreDesignation findByPrimaryKey(long cadreDesignationId)
		throws NoSuchCadreDesignationException {

		return findByPrimaryKey((Serializable)cadreDesignationId);
	}

	/**
	 * Returns the cadre designation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cadreDesignationId the primary key of the cadre designation
	 * @return the cadre designation, or <code>null</code> if a cadre designation with the primary key could not be found
	 */
	@Override
	public CadreDesignation fetchByPrimaryKey(long cadreDesignationId) {
		return fetchByPrimaryKey((Serializable)cadreDesignationId);
	}

	/**
	 * Returns all the cadre designations.
	 *
	 * @return the cadre designations
	 */
	@Override
	public List<CadreDesignation> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cadre designations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CadreDesignationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cadre designations
	 * @param end the upper bound of the range of cadre designations (not inclusive)
	 * @return the range of cadre designations
	 */
	@Override
	public List<CadreDesignation> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the cadre designations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CadreDesignationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cadre designations
	 * @param end the upper bound of the range of cadre designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cadre designations
	 */
	@Override
	public List<CadreDesignation> findAll(
		int start, int end,
		OrderByComparator<CadreDesignation> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cadre designations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CadreDesignationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cadre designations
	 * @param end the upper bound of the range of cadre designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cadre designations
	 */
	@Override
	public List<CadreDesignation> findAll(
		int start, int end,
		OrderByComparator<CadreDesignation> orderByComparator,
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

		List<CadreDesignation> list = null;

		if (useFinderCache) {
			list = (List<CadreDesignation>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CADREDESIGNATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CADREDESIGNATION;

				sql = sql.concat(CadreDesignationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CadreDesignation>)QueryUtil.list(
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
	 * Removes all the cadre designations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CadreDesignation cadreDesignation : findAll()) {
			remove(cadreDesignation);
		}
	}

	/**
	 * Returns the number of cadre designations.
	 *
	 * @return the number of cadre designations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CADREDESIGNATION);

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
		return "cadreDesignationId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CADREDESIGNATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CadreDesignationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the cadre designation persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new CadreDesignationModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", CadreDesignation.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByCadreId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCadreId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"cadreId"}, true);

		_finderPathWithoutPaginationFindByCadreId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCadreId",
			new String[] {Long.class.getName()}, new String[] {"cadreId"},
			true);

		_finderPathCountByCadreId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCadreId",
			new String[] {Long.class.getName()}, new String[] {"cadreId"},
			false);

		_finderPathWithPaginationFindByDesignationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDesignationId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"designationId"}, true);

		_finderPathWithoutPaginationFindByDesignationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDesignationId",
			new String[] {Long.class.getName()}, new String[] {"designationId"},
			true);

		_finderPathCountByDesignationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDesignationId",
			new String[] {Long.class.getName()}, new String[] {"designationId"},
			false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(CadreDesignationImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	@Override
	@Reference(
		target = mdmPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = mdmPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = mdmPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_CADREDESIGNATION =
		"SELECT cadreDesignation FROM CadreDesignation cadreDesignation";

	private static final String _SQL_SELECT_CADREDESIGNATION_WHERE =
		"SELECT cadreDesignation FROM CadreDesignation cadreDesignation WHERE ";

	private static final String _SQL_COUNT_CADREDESIGNATION =
		"SELECT COUNT(cadreDesignation) FROM CadreDesignation cadreDesignation";

	private static final String _SQL_COUNT_CADREDESIGNATION_WHERE =
		"SELECT COUNT(cadreDesignation) FROM CadreDesignation cadreDesignation WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "cadreDesignation.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CadreDesignation exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CadreDesignation exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CadreDesignationPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"rank"});

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

	private static class CadreDesignationModelArgumentsResolver
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

			CadreDesignationModelImpl cadreDesignationModelImpl =
				(CadreDesignationModelImpl)baseModel;

			long columnBitmask = cadreDesignationModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					cadreDesignationModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						cadreDesignationModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					cadreDesignationModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			CadreDesignationModelImpl cadreDesignationModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						cadreDesignationModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = cadreDesignationModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}