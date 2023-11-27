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

import com.adjecti.mdm.liferay.exception.NoSuchOrganizationStationException;
import com.adjecti.mdm.liferay.model.OrganizationStation;
import com.adjecti.mdm.liferay.model.impl.OrganizationStationImpl;
import com.adjecti.mdm.liferay.model.impl.OrganizationStationModelImpl;
import com.adjecti.mdm.liferay.service.persistence.OrganizationStationPersistence;
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
 * The persistence implementation for the organization station service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = OrganizationStationPersistence.class)
public class OrganizationStationPersistenceImpl
	extends BasePersistenceImpl<OrganizationStation>
	implements OrganizationStationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>OrganizationStationUtil</code> to access the organization station persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		OrganizationStationImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByName;
	private FinderPath _finderPathWithoutPaginationFindByName;
	private FinderPath _finderPathCountByName;

	/**
	 * Returns all the organization stations where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching organization stations
	 */
	@Override
	public List<OrganizationStation> findByName(String name) {
		return findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the organization stations where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationStationModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of organization stations
	 * @param end the upper bound of the range of organization stations (not inclusive)
	 * @return the range of matching organization stations
	 */
	@Override
	public List<OrganizationStation> findByName(
		String name, int start, int end) {

		return findByName(name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the organization stations where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationStationModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of organization stations
	 * @param end the upper bound of the range of organization stations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization stations
	 */
	@Override
	public List<OrganizationStation> findByName(
		String name, int start, int end,
		OrderByComparator<OrganizationStation> orderByComparator) {

		return findByName(name, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the organization stations where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationStationModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of organization stations
	 * @param end the upper bound of the range of organization stations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization stations
	 */
	@Override
	public List<OrganizationStation> findByName(
		String name, int start, int end,
		OrderByComparator<OrganizationStation> orderByComparator,
		boolean useFinderCache) {

		name = Objects.toString(name, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByName;
				finderArgs = new Object[] {name};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByName;
			finderArgs = new Object[] {name, start, end, orderByComparator};
		}

		List<OrganizationStation> list = null;

		if (useFinderCache) {
			list = (List<OrganizationStation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (OrganizationStation organizationStation : list) {
					if (!name.equals(organizationStation.getName())) {
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

			sb.append(_SQL_SELECT_ORGANIZATIONSTATION_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(OrganizationStationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
				}

				list = (List<OrganizationStation>)QueryUtil.list(
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
	 * Returns the first organization station in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization station
	 * @throws NoSuchOrganizationStationException if a matching organization station could not be found
	 */
	@Override
	public OrganizationStation findByName_First(
			String name,
			OrderByComparator<OrganizationStation> orderByComparator)
		throws NoSuchOrganizationStationException {

		OrganizationStation organizationStation = fetchByName_First(
			name, orderByComparator);

		if (organizationStation != null) {
			return organizationStation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchOrganizationStationException(sb.toString());
	}

	/**
	 * Returns the first organization station in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization station, or <code>null</code> if a matching organization station could not be found
	 */
	@Override
	public OrganizationStation fetchByName_First(
		String name, OrderByComparator<OrganizationStation> orderByComparator) {

		List<OrganizationStation> list = findByName(
			name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last organization station in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization station
	 * @throws NoSuchOrganizationStationException if a matching organization station could not be found
	 */
	@Override
	public OrganizationStation findByName_Last(
			String name,
			OrderByComparator<OrganizationStation> orderByComparator)
		throws NoSuchOrganizationStationException {

		OrganizationStation organizationStation = fetchByName_Last(
			name, orderByComparator);

		if (organizationStation != null) {
			return organizationStation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchOrganizationStationException(sb.toString());
	}

	/**
	 * Returns the last organization station in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization station, or <code>null</code> if a matching organization station could not be found
	 */
	@Override
	public OrganizationStation fetchByName_Last(
		String name, OrderByComparator<OrganizationStation> orderByComparator) {

		int count = countByName(name);

		if (count == 0) {
			return null;
		}

		List<OrganizationStation> list = findByName(
			name, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the organization stations before and after the current organization station in the ordered set where name = &#63;.
	 *
	 * @param organizationStationId the primary key of the current organization station
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization station
	 * @throws NoSuchOrganizationStationException if a organization station with the primary key could not be found
	 */
	@Override
	public OrganizationStation[] findByName_PrevAndNext(
			long organizationStationId, String name,
			OrderByComparator<OrganizationStation> orderByComparator)
		throws NoSuchOrganizationStationException {

		name = Objects.toString(name, "");

		OrganizationStation organizationStation = findByPrimaryKey(
			organizationStationId);

		Session session = null;

		try {
			session = openSession();

			OrganizationStation[] array = new OrganizationStationImpl[3];

			array[0] = getByName_PrevAndNext(
				session, organizationStation, name, orderByComparator, true);

			array[1] = organizationStation;

			array[2] = getByName_PrevAndNext(
				session, organizationStation, name, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected OrganizationStation getByName_PrevAndNext(
		Session session, OrganizationStation organizationStation, String name,
		OrderByComparator<OrganizationStation> orderByComparator,
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

		sb.append(_SQL_SELECT_ORGANIZATIONSTATION_WHERE);

		boolean bindName = false;

		if (name.isEmpty()) {
			sb.append(_FINDER_COLUMN_NAME_NAME_3);
		}
		else {
			bindName = true;

			sb.append(_FINDER_COLUMN_NAME_NAME_2);
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
			sb.append(OrganizationStationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindName) {
			queryPos.add(name);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						organizationStation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<OrganizationStation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the organization stations where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	@Override
	public void removeByName(String name) {
		for (OrganizationStation organizationStation :
				findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(organizationStation);
		}
	}

	/**
	 * Returns the number of organization stations where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching organization stations
	 */
	@Override
	public int countByName(String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByName;

		Object[] finderArgs = new Object[] {name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ORGANIZATIONSTATION_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
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

	private static final String _FINDER_COLUMN_NAME_NAME_2 =
		"organizationStation.name = ?";

	private static final String _FINDER_COLUMN_NAME_NAME_3 =
		"(organizationStation.name IS NULL OR organizationStation.name = '')";

	public OrganizationStationPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("code", "code_");

		setDBColumnNames(dbColumnNames);

		setModelClass(OrganizationStation.class);

		setModelImplClass(OrganizationStationImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the organization station in the entity cache if it is enabled.
	 *
	 * @param organizationStation the organization station
	 */
	@Override
	public void cacheResult(OrganizationStation organizationStation) {
		entityCache.putResult(
			OrganizationStationImpl.class, organizationStation.getPrimaryKey(),
			organizationStation);
	}

	/**
	 * Caches the organization stations in the entity cache if it is enabled.
	 *
	 * @param organizationStations the organization stations
	 */
	@Override
	public void cacheResult(List<OrganizationStation> organizationStations) {
		for (OrganizationStation organizationStation : organizationStations) {
			if (entityCache.getResult(
					OrganizationStationImpl.class,
					organizationStation.getPrimaryKey()) == null) {

				cacheResult(organizationStation);
			}
		}
	}

	/**
	 * Clears the cache for all organization stations.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(OrganizationStationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the organization station.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(OrganizationStation organizationStation) {
		entityCache.removeResult(
			OrganizationStationImpl.class, organizationStation);
	}

	@Override
	public void clearCache(List<OrganizationStation> organizationStations) {
		for (OrganizationStation organizationStation : organizationStations) {
			entityCache.removeResult(
				OrganizationStationImpl.class, organizationStation);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(OrganizationStationImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new organization station with the primary key. Does not add the organization station to the database.
	 *
	 * @param organizationStationId the primary key for the new organization station
	 * @return the new organization station
	 */
	@Override
	public OrganizationStation create(long organizationStationId) {
		OrganizationStation organizationStation = new OrganizationStationImpl();

		organizationStation.setNew(true);
		organizationStation.setPrimaryKey(organizationStationId);

		organizationStation.setCompanyId(CompanyThreadLocal.getCompanyId());

		return organizationStation;
	}

	/**
	 * Removes the organization station with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param organizationStationId the primary key of the organization station
	 * @return the organization station that was removed
	 * @throws NoSuchOrganizationStationException if a organization station with the primary key could not be found
	 */
	@Override
	public OrganizationStation remove(long organizationStationId)
		throws NoSuchOrganizationStationException {

		return remove((Serializable)organizationStationId);
	}

	/**
	 * Removes the organization station with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the organization station
	 * @return the organization station that was removed
	 * @throws NoSuchOrganizationStationException if a organization station with the primary key could not be found
	 */
	@Override
	public OrganizationStation remove(Serializable primaryKey)
		throws NoSuchOrganizationStationException {

		Session session = null;

		try {
			session = openSession();

			OrganizationStation organizationStation =
				(OrganizationStation)session.get(
					OrganizationStationImpl.class, primaryKey);

			if (organizationStation == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOrganizationStationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(organizationStation);
		}
		catch (NoSuchOrganizationStationException noSuchEntityException) {
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
	protected OrganizationStation removeImpl(
		OrganizationStation organizationStation) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(organizationStation)) {
				organizationStation = (OrganizationStation)session.get(
					OrganizationStationImpl.class,
					organizationStation.getPrimaryKeyObj());
			}

			if (organizationStation != null) {
				session.delete(organizationStation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (organizationStation != null) {
			clearCache(organizationStation);
		}

		return organizationStation;
	}

	@Override
	public OrganizationStation updateImpl(
		OrganizationStation organizationStation) {

		boolean isNew = organizationStation.isNew();

		if (!(organizationStation instanceof OrganizationStationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(organizationStation.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					organizationStation);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in organizationStation proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom OrganizationStation implementation " +
					organizationStation.getClass());
		}

		OrganizationStationModelImpl organizationStationModelImpl =
			(OrganizationStationModelImpl)organizationStation;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (organizationStation.getCreateDate() == null)) {
			if (serviceContext == null) {
				organizationStation.setCreateDate(now);
			}
			else {
				organizationStation.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!organizationStationModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				organizationStation.setModifiedDate(now);
			}
			else {
				organizationStation.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(organizationStation);
			}
			else {
				organizationStation = (OrganizationStation)session.merge(
					organizationStation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			OrganizationStationImpl.class, organizationStationModelImpl, false,
			true);

		if (isNew) {
			organizationStation.setNew(false);
		}

		organizationStation.resetOriginalValues();

		return organizationStation;
	}

	/**
	 * Returns the organization station with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the organization station
	 * @return the organization station
	 * @throws NoSuchOrganizationStationException if a organization station with the primary key could not be found
	 */
	@Override
	public OrganizationStation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOrganizationStationException {

		OrganizationStation organizationStation = fetchByPrimaryKey(primaryKey);

		if (organizationStation == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOrganizationStationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return organizationStation;
	}

	/**
	 * Returns the organization station with the primary key or throws a <code>NoSuchOrganizationStationException</code> if it could not be found.
	 *
	 * @param organizationStationId the primary key of the organization station
	 * @return the organization station
	 * @throws NoSuchOrganizationStationException if a organization station with the primary key could not be found
	 */
	@Override
	public OrganizationStation findByPrimaryKey(long organizationStationId)
		throws NoSuchOrganizationStationException {

		return findByPrimaryKey((Serializable)organizationStationId);
	}

	/**
	 * Returns the organization station with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param organizationStationId the primary key of the organization station
	 * @return the organization station, or <code>null</code> if a organization station with the primary key could not be found
	 */
	@Override
	public OrganizationStation fetchByPrimaryKey(long organizationStationId) {
		return fetchByPrimaryKey((Serializable)organizationStationId);
	}

	/**
	 * Returns all the organization stations.
	 *
	 * @return the organization stations
	 */
	@Override
	public List<OrganizationStation> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the organization stations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationStationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of organization stations
	 * @param end the upper bound of the range of organization stations (not inclusive)
	 * @return the range of organization stations
	 */
	@Override
	public List<OrganizationStation> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the organization stations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationStationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of organization stations
	 * @param end the upper bound of the range of organization stations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of organization stations
	 */
	@Override
	public List<OrganizationStation> findAll(
		int start, int end,
		OrderByComparator<OrganizationStation> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the organization stations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationStationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of organization stations
	 * @param end the upper bound of the range of organization stations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of organization stations
	 */
	@Override
	public List<OrganizationStation> findAll(
		int start, int end,
		OrderByComparator<OrganizationStation> orderByComparator,
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

		List<OrganizationStation> list = null;

		if (useFinderCache) {
			list = (List<OrganizationStation>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ORGANIZATIONSTATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ORGANIZATIONSTATION;

				sql = sql.concat(OrganizationStationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<OrganizationStation>)QueryUtil.list(
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
	 * Removes all the organization stations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (OrganizationStation organizationStation : findAll()) {
			remove(organizationStation);
		}
	}

	/**
	 * Returns the number of organization stations.
	 *
	 * @return the number of organization stations
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
					_SQL_COUNT_ORGANIZATIONSTATION);

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
		return "organizationStationId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ORGANIZATIONSTATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return OrganizationStationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the organization station persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new OrganizationStationModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", OrganizationStation.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"name"}, true);

		_finderPathWithoutPaginationFindByName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByName",
			new String[] {String.class.getName()}, new String[] {"name"}, true);

		_finderPathCountByName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] {String.class.getName()}, new String[] {"name"},
			false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(OrganizationStationImpl.class.getName());

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

	private static final String _SQL_SELECT_ORGANIZATIONSTATION =
		"SELECT organizationStation FROM OrganizationStation organizationStation";

	private static final String _SQL_SELECT_ORGANIZATIONSTATION_WHERE =
		"SELECT organizationStation FROM OrganizationStation organizationStation WHERE ";

	private static final String _SQL_COUNT_ORGANIZATIONSTATION =
		"SELECT COUNT(organizationStation) FROM OrganizationStation organizationStation";

	private static final String _SQL_COUNT_ORGANIZATIONSTATION_WHERE =
		"SELECT COUNT(organizationStation) FROM OrganizationStation organizationStation WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "organizationStation.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No OrganizationStation exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No OrganizationStation exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		OrganizationStationPersistenceImpl.class);

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

	private static class OrganizationStationModelArgumentsResolver
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

			OrganizationStationModelImpl organizationStationModelImpl =
				(OrganizationStationModelImpl)baseModel;

			long columnBitmask =
				organizationStationModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					organizationStationModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						organizationStationModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					organizationStationModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			OrganizationStationModelImpl organizationStationModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						organizationStationModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = organizationStationModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}