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

import com.adjecti.mdm.liferay.exception.NoSuchWorkStationException;
import com.adjecti.mdm.liferay.model.WorkStation;
import com.adjecti.mdm.liferay.model.impl.WorkStationImpl;
import com.adjecti.mdm.liferay.model.impl.WorkStationModelImpl;
import com.adjecti.mdm.liferay.service.persistence.WorkStationPersistence;
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
 * The persistence implementation for the work station service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = WorkStationPersistence.class)
public class WorkStationPersistenceImpl
	extends BasePersistenceImpl<WorkStation> implements WorkStationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>WorkStationUtil</code> to access the work station persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		WorkStationImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByCode;
	private FinderPath _finderPathWithoutPaginationFindByCode;
	private FinderPath _finderPathCountByCode;

	/**
	 * Returns all the work stations where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching work stations
	 */
	@Override
	public List<WorkStation> findByCode(String code) {
		return findByCode(code, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the work stations where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkStationModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of work stations
	 * @param end the upper bound of the range of work stations (not inclusive)
	 * @return the range of matching work stations
	 */
	@Override
	public List<WorkStation> findByCode(String code, int start, int end) {
		return findByCode(code, start, end, null);
	}

	/**
	 * Returns an ordered range of all the work stations where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkStationModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of work stations
	 * @param end the upper bound of the range of work stations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work stations
	 */
	@Override
	public List<WorkStation> findByCode(
		String code, int start, int end,
		OrderByComparator<WorkStation> orderByComparator) {

		return findByCode(code, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the work stations where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkStationModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of work stations
	 * @param end the upper bound of the range of work stations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work stations
	 */
	@Override
	public List<WorkStation> findByCode(
		String code, int start, int end,
		OrderByComparator<WorkStation> orderByComparator,
		boolean useFinderCache) {

		code = Objects.toString(code, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCode;
				finderArgs = new Object[] {code};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCode;
			finderArgs = new Object[] {code, start, end, orderByComparator};
		}

		List<WorkStation> list = null;

		if (useFinderCache) {
			list = (List<WorkStation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WorkStation workStation : list) {
					if (!code.equals(workStation.getCode())) {
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

			sb.append(_SQL_SELECT_WORKSTATION_WHERE);

			boolean bindCode = false;

			if (code.isEmpty()) {
				sb.append(_FINDER_COLUMN_CODE_CODE_3);
			}
			else {
				bindCode = true;

				sb.append(_FINDER_COLUMN_CODE_CODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(WorkStationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCode) {
					queryPos.add(code);
				}

				list = (List<WorkStation>)QueryUtil.list(
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
	 * Returns the first work station in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work station
	 * @throws NoSuchWorkStationException if a matching work station could not be found
	 */
	@Override
	public WorkStation findByCode_First(
			String code, OrderByComparator<WorkStation> orderByComparator)
		throws NoSuchWorkStationException {

		WorkStation workStation = fetchByCode_First(code, orderByComparator);

		if (workStation != null) {
			return workStation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("code=");
		sb.append(code);

		sb.append("}");

		throw new NoSuchWorkStationException(sb.toString());
	}

	/**
	 * Returns the first work station in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work station, or <code>null</code> if a matching work station could not be found
	 */
	@Override
	public WorkStation fetchByCode_First(
		String code, OrderByComparator<WorkStation> orderByComparator) {

		List<WorkStation> list = findByCode(code, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last work station in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work station
	 * @throws NoSuchWorkStationException if a matching work station could not be found
	 */
	@Override
	public WorkStation findByCode_Last(
			String code, OrderByComparator<WorkStation> orderByComparator)
		throws NoSuchWorkStationException {

		WorkStation workStation = fetchByCode_Last(code, orderByComparator);

		if (workStation != null) {
			return workStation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("code=");
		sb.append(code);

		sb.append("}");

		throw new NoSuchWorkStationException(sb.toString());
	}

	/**
	 * Returns the last work station in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work station, or <code>null</code> if a matching work station could not be found
	 */
	@Override
	public WorkStation fetchByCode_Last(
		String code, OrderByComparator<WorkStation> orderByComparator) {

		int count = countByCode(code);

		if (count == 0) {
			return null;
		}

		List<WorkStation> list = findByCode(
			code, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the work stations before and after the current work station in the ordered set where code = &#63;.
	 *
	 * @param workStationId the primary key of the current work station
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work station
	 * @throws NoSuchWorkStationException if a work station with the primary key could not be found
	 */
	@Override
	public WorkStation[] findByCode_PrevAndNext(
			long workStationId, String code,
			OrderByComparator<WorkStation> orderByComparator)
		throws NoSuchWorkStationException {

		code = Objects.toString(code, "");

		WorkStation workStation = findByPrimaryKey(workStationId);

		Session session = null;

		try {
			session = openSession();

			WorkStation[] array = new WorkStationImpl[3];

			array[0] = getByCode_PrevAndNext(
				session, workStation, code, orderByComparator, true);

			array[1] = workStation;

			array[2] = getByCode_PrevAndNext(
				session, workStation, code, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected WorkStation getByCode_PrevAndNext(
		Session session, WorkStation workStation, String code,
		OrderByComparator<WorkStation> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_WORKSTATION_WHERE);

		boolean bindCode = false;

		if (code.isEmpty()) {
			sb.append(_FINDER_COLUMN_CODE_CODE_3);
		}
		else {
			bindCode = true;

			sb.append(_FINDER_COLUMN_CODE_CODE_2);
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
			sb.append(WorkStationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindCode) {
			queryPos.add(code);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(workStation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<WorkStation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the work stations where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	@Override
	public void removeByCode(String code) {
		for (WorkStation workStation :
				findByCode(code, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(workStation);
		}
	}

	/**
	 * Returns the number of work stations where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching work stations
	 */
	@Override
	public int countByCode(String code) {
		code = Objects.toString(code, "");

		FinderPath finderPath = _finderPathCountByCode;

		Object[] finderArgs = new Object[] {code};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_WORKSTATION_WHERE);

			boolean bindCode = false;

			if (code.isEmpty()) {
				sb.append(_FINDER_COLUMN_CODE_CODE_3);
			}
			else {
				bindCode = true;

				sb.append(_FINDER_COLUMN_CODE_CODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCode) {
					queryPos.add(code);
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

	private static final String _FINDER_COLUMN_CODE_CODE_2 =
		"workStation.code = ?";

	private static final String _FINDER_COLUMN_CODE_CODE_3 =
		"(workStation.code IS NULL OR workStation.code = '')";

	private FinderPath _finderPathWithPaginationFindByDeskNo;
	private FinderPath _finderPathWithoutPaginationFindByDeskNo;
	private FinderPath _finderPathCountByDeskNo;

	/**
	 * Returns all the work stations where deskNo = &#63;.
	 *
	 * @param deskNo the desk no
	 * @return the matching work stations
	 */
	@Override
	public List<WorkStation> findByDeskNo(String deskNo) {
		return findByDeskNo(deskNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the work stations where deskNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkStationModelImpl</code>.
	 * </p>
	 *
	 * @param deskNo the desk no
	 * @param start the lower bound of the range of work stations
	 * @param end the upper bound of the range of work stations (not inclusive)
	 * @return the range of matching work stations
	 */
	@Override
	public List<WorkStation> findByDeskNo(String deskNo, int start, int end) {
		return findByDeskNo(deskNo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the work stations where deskNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkStationModelImpl</code>.
	 * </p>
	 *
	 * @param deskNo the desk no
	 * @param start the lower bound of the range of work stations
	 * @param end the upper bound of the range of work stations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work stations
	 */
	@Override
	public List<WorkStation> findByDeskNo(
		String deskNo, int start, int end,
		OrderByComparator<WorkStation> orderByComparator) {

		return findByDeskNo(deskNo, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the work stations where deskNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkStationModelImpl</code>.
	 * </p>
	 *
	 * @param deskNo the desk no
	 * @param start the lower bound of the range of work stations
	 * @param end the upper bound of the range of work stations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work stations
	 */
	@Override
	public List<WorkStation> findByDeskNo(
		String deskNo, int start, int end,
		OrderByComparator<WorkStation> orderByComparator,
		boolean useFinderCache) {

		deskNo = Objects.toString(deskNo, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDeskNo;
				finderArgs = new Object[] {deskNo};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDeskNo;
			finderArgs = new Object[] {deskNo, start, end, orderByComparator};
		}

		List<WorkStation> list = null;

		if (useFinderCache) {
			list = (List<WorkStation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WorkStation workStation : list) {
					if (!deskNo.equals(workStation.getDeskNo())) {
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

			sb.append(_SQL_SELECT_WORKSTATION_WHERE);

			boolean bindDeskNo = false;

			if (deskNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_DESKNO_DESKNO_3);
			}
			else {
				bindDeskNo = true;

				sb.append(_FINDER_COLUMN_DESKNO_DESKNO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(WorkStationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDeskNo) {
					queryPos.add(deskNo);
				}

				list = (List<WorkStation>)QueryUtil.list(
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
	 * Returns the first work station in the ordered set where deskNo = &#63;.
	 *
	 * @param deskNo the desk no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work station
	 * @throws NoSuchWorkStationException if a matching work station could not be found
	 */
	@Override
	public WorkStation findByDeskNo_First(
			String deskNo, OrderByComparator<WorkStation> orderByComparator)
		throws NoSuchWorkStationException {

		WorkStation workStation = fetchByDeskNo_First(
			deskNo, orderByComparator);

		if (workStation != null) {
			return workStation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("deskNo=");
		sb.append(deskNo);

		sb.append("}");

		throw new NoSuchWorkStationException(sb.toString());
	}

	/**
	 * Returns the first work station in the ordered set where deskNo = &#63;.
	 *
	 * @param deskNo the desk no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work station, or <code>null</code> if a matching work station could not be found
	 */
	@Override
	public WorkStation fetchByDeskNo_First(
		String deskNo, OrderByComparator<WorkStation> orderByComparator) {

		List<WorkStation> list = findByDeskNo(deskNo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last work station in the ordered set where deskNo = &#63;.
	 *
	 * @param deskNo the desk no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work station
	 * @throws NoSuchWorkStationException if a matching work station could not be found
	 */
	@Override
	public WorkStation findByDeskNo_Last(
			String deskNo, OrderByComparator<WorkStation> orderByComparator)
		throws NoSuchWorkStationException {

		WorkStation workStation = fetchByDeskNo_Last(deskNo, orderByComparator);

		if (workStation != null) {
			return workStation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("deskNo=");
		sb.append(deskNo);

		sb.append("}");

		throw new NoSuchWorkStationException(sb.toString());
	}

	/**
	 * Returns the last work station in the ordered set where deskNo = &#63;.
	 *
	 * @param deskNo the desk no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work station, or <code>null</code> if a matching work station could not be found
	 */
	@Override
	public WorkStation fetchByDeskNo_Last(
		String deskNo, OrderByComparator<WorkStation> orderByComparator) {

		int count = countByDeskNo(deskNo);

		if (count == 0) {
			return null;
		}

		List<WorkStation> list = findByDeskNo(
			deskNo, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the work stations before and after the current work station in the ordered set where deskNo = &#63;.
	 *
	 * @param workStationId the primary key of the current work station
	 * @param deskNo the desk no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work station
	 * @throws NoSuchWorkStationException if a work station with the primary key could not be found
	 */
	@Override
	public WorkStation[] findByDeskNo_PrevAndNext(
			long workStationId, String deskNo,
			OrderByComparator<WorkStation> orderByComparator)
		throws NoSuchWorkStationException {

		deskNo = Objects.toString(deskNo, "");

		WorkStation workStation = findByPrimaryKey(workStationId);

		Session session = null;

		try {
			session = openSession();

			WorkStation[] array = new WorkStationImpl[3];

			array[0] = getByDeskNo_PrevAndNext(
				session, workStation, deskNo, orderByComparator, true);

			array[1] = workStation;

			array[2] = getByDeskNo_PrevAndNext(
				session, workStation, deskNo, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected WorkStation getByDeskNo_PrevAndNext(
		Session session, WorkStation workStation, String deskNo,
		OrderByComparator<WorkStation> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_WORKSTATION_WHERE);

		boolean bindDeskNo = false;

		if (deskNo.isEmpty()) {
			sb.append(_FINDER_COLUMN_DESKNO_DESKNO_3);
		}
		else {
			bindDeskNo = true;

			sb.append(_FINDER_COLUMN_DESKNO_DESKNO_2);
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
			sb.append(WorkStationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindDeskNo) {
			queryPos.add(deskNo);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(workStation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<WorkStation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the work stations where deskNo = &#63; from the database.
	 *
	 * @param deskNo the desk no
	 */
	@Override
	public void removeByDeskNo(String deskNo) {
		for (WorkStation workStation :
				findByDeskNo(
					deskNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(workStation);
		}
	}

	/**
	 * Returns the number of work stations where deskNo = &#63;.
	 *
	 * @param deskNo the desk no
	 * @return the number of matching work stations
	 */
	@Override
	public int countByDeskNo(String deskNo) {
		deskNo = Objects.toString(deskNo, "");

		FinderPath finderPath = _finderPathCountByDeskNo;

		Object[] finderArgs = new Object[] {deskNo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_WORKSTATION_WHERE);

			boolean bindDeskNo = false;

			if (deskNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_DESKNO_DESKNO_3);
			}
			else {
				bindDeskNo = true;

				sb.append(_FINDER_COLUMN_DESKNO_DESKNO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDeskNo) {
					queryPos.add(deskNo);
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

	private static final String _FINDER_COLUMN_DESKNO_DESKNO_2 =
		"workStation.deskNo = ?";

	private static final String _FINDER_COLUMN_DESKNO_DESKNO_3 =
		"(workStation.deskNo IS NULL OR workStation.deskNo = '')";

	public WorkStationPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("code", "code_");

		setDBColumnNames(dbColumnNames);

		setModelClass(WorkStation.class);

		setModelImplClass(WorkStationImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the work station in the entity cache if it is enabled.
	 *
	 * @param workStation the work station
	 */
	@Override
	public void cacheResult(WorkStation workStation) {
		entityCache.putResult(
			WorkStationImpl.class, workStation.getPrimaryKey(), workStation);
	}

	/**
	 * Caches the work stations in the entity cache if it is enabled.
	 *
	 * @param workStations the work stations
	 */
	@Override
	public void cacheResult(List<WorkStation> workStations) {
		for (WorkStation workStation : workStations) {
			if (entityCache.getResult(
					WorkStationImpl.class, workStation.getPrimaryKey()) ==
						null) {

				cacheResult(workStation);
			}
		}
	}

	/**
	 * Clears the cache for all work stations.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(WorkStationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the work station.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WorkStation workStation) {
		entityCache.removeResult(WorkStationImpl.class, workStation);
	}

	@Override
	public void clearCache(List<WorkStation> workStations) {
		for (WorkStation workStation : workStations) {
			entityCache.removeResult(WorkStationImpl.class, workStation);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(WorkStationImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new work station with the primary key. Does not add the work station to the database.
	 *
	 * @param workStationId the primary key for the new work station
	 * @return the new work station
	 */
	@Override
	public WorkStation create(long workStationId) {
		WorkStation workStation = new WorkStationImpl();

		workStation.setNew(true);
		workStation.setPrimaryKey(workStationId);

		workStation.setCompanyId(CompanyThreadLocal.getCompanyId());

		return workStation;
	}

	/**
	 * Removes the work station with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workStationId the primary key of the work station
	 * @return the work station that was removed
	 * @throws NoSuchWorkStationException if a work station with the primary key could not be found
	 */
	@Override
	public WorkStation remove(long workStationId)
		throws NoSuchWorkStationException {

		return remove((Serializable)workStationId);
	}

	/**
	 * Removes the work station with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the work station
	 * @return the work station that was removed
	 * @throws NoSuchWorkStationException if a work station with the primary key could not be found
	 */
	@Override
	public WorkStation remove(Serializable primaryKey)
		throws NoSuchWorkStationException {

		Session session = null;

		try {
			session = openSession();

			WorkStation workStation = (WorkStation)session.get(
				WorkStationImpl.class, primaryKey);

			if (workStation == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWorkStationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(workStation);
		}
		catch (NoSuchWorkStationException noSuchEntityException) {
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
	protected WorkStation removeImpl(WorkStation workStation) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(workStation)) {
				workStation = (WorkStation)session.get(
					WorkStationImpl.class, workStation.getPrimaryKeyObj());
			}

			if (workStation != null) {
				session.delete(workStation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (workStation != null) {
			clearCache(workStation);
		}

		return workStation;
	}

	@Override
	public WorkStation updateImpl(WorkStation workStation) {
		boolean isNew = workStation.isNew();

		if (!(workStation instanceof WorkStationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(workStation.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(workStation);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in workStation proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom WorkStation implementation " +
					workStation.getClass());
		}

		WorkStationModelImpl workStationModelImpl =
			(WorkStationModelImpl)workStation;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (workStation.getCreateDate() == null)) {
			if (serviceContext == null) {
				workStation.setCreateDate(now);
			}
			else {
				workStation.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!workStationModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				workStation.setModifiedDate(now);
			}
			else {
				workStation.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(workStation);
			}
			else {
				workStation = (WorkStation)session.merge(workStation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			WorkStationImpl.class, workStationModelImpl, false, true);

		if (isNew) {
			workStation.setNew(false);
		}

		workStation.resetOriginalValues();

		return workStation;
	}

	/**
	 * Returns the work station with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the work station
	 * @return the work station
	 * @throws NoSuchWorkStationException if a work station with the primary key could not be found
	 */
	@Override
	public WorkStation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWorkStationException {

		WorkStation workStation = fetchByPrimaryKey(primaryKey);

		if (workStation == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWorkStationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return workStation;
	}

	/**
	 * Returns the work station with the primary key or throws a <code>NoSuchWorkStationException</code> if it could not be found.
	 *
	 * @param workStationId the primary key of the work station
	 * @return the work station
	 * @throws NoSuchWorkStationException if a work station with the primary key could not be found
	 */
	@Override
	public WorkStation findByPrimaryKey(long workStationId)
		throws NoSuchWorkStationException {

		return findByPrimaryKey((Serializable)workStationId);
	}

	/**
	 * Returns the work station with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workStationId the primary key of the work station
	 * @return the work station, or <code>null</code> if a work station with the primary key could not be found
	 */
	@Override
	public WorkStation fetchByPrimaryKey(long workStationId) {
		return fetchByPrimaryKey((Serializable)workStationId);
	}

	/**
	 * Returns all the work stations.
	 *
	 * @return the work stations
	 */
	@Override
	public List<WorkStation> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the work stations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkStationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work stations
	 * @param end the upper bound of the range of work stations (not inclusive)
	 * @return the range of work stations
	 */
	@Override
	public List<WorkStation> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the work stations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkStationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work stations
	 * @param end the upper bound of the range of work stations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of work stations
	 */
	@Override
	public List<WorkStation> findAll(
		int start, int end, OrderByComparator<WorkStation> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the work stations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkStationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work stations
	 * @param end the upper bound of the range of work stations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of work stations
	 */
	@Override
	public List<WorkStation> findAll(
		int start, int end, OrderByComparator<WorkStation> orderByComparator,
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

		List<WorkStation> list = null;

		if (useFinderCache) {
			list = (List<WorkStation>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_WORKSTATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_WORKSTATION;

				sql = sql.concat(WorkStationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<WorkStation>)QueryUtil.list(
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
	 * Removes all the work stations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (WorkStation workStation : findAll()) {
			remove(workStation);
		}
	}

	/**
	 * Returns the number of work stations.
	 *
	 * @return the number of work stations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_WORKSTATION);

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
		return "workStationId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_WORKSTATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return WorkStationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the work station persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new WorkStationModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", WorkStation.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCode",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"code_"}, true);

		_finderPathWithoutPaginationFindByCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCode",
			new String[] {String.class.getName()}, new String[] {"code_"},
			true);

		_finderPathCountByCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCode",
			new String[] {String.class.getName()}, new String[] {"code_"},
			false);

		_finderPathWithPaginationFindByDeskNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDeskNo",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"deskNo"}, true);

		_finderPathWithoutPaginationFindByDeskNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDeskNo",
			new String[] {String.class.getName()}, new String[] {"deskNo"},
			true);

		_finderPathCountByDeskNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDeskNo",
			new String[] {String.class.getName()}, new String[] {"deskNo"},
			false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(WorkStationImpl.class.getName());

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

	private static final String _SQL_SELECT_WORKSTATION =
		"SELECT workStation FROM WorkStation workStation";

	private static final String _SQL_SELECT_WORKSTATION_WHERE =
		"SELECT workStation FROM WorkStation workStation WHERE ";

	private static final String _SQL_COUNT_WORKSTATION =
		"SELECT COUNT(workStation) FROM WorkStation workStation";

	private static final String _SQL_COUNT_WORKSTATION_WHERE =
		"SELECT COUNT(workStation) FROM WorkStation workStation WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "workStation.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No WorkStation exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No WorkStation exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		WorkStationPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"code"});

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

	private static class WorkStationModelArgumentsResolver
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

			WorkStationModelImpl workStationModelImpl =
				(WorkStationModelImpl)baseModel;

			long columnBitmask = workStationModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(workStationModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						workStationModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(workStationModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			WorkStationModelImpl workStationModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = workStationModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = workStationModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}