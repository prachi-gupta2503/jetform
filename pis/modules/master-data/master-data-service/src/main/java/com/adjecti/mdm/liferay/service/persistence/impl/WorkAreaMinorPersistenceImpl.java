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

import com.adjecti.mdm.liferay.exception.NoSuchWorkAreaMinorException;
import com.adjecti.mdm.liferay.model.WorkAreaMinor;
import com.adjecti.mdm.liferay.model.impl.WorkAreaMinorImpl;
import com.adjecti.mdm.liferay.model.impl.WorkAreaMinorModelImpl;
import com.adjecti.mdm.liferay.service.persistence.WorkAreaMinorPersistence;
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
 * The persistence implementation for the work area minor service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = WorkAreaMinorPersistence.class)
public class WorkAreaMinorPersistenceImpl
	extends BasePersistenceImpl<WorkAreaMinor>
	implements WorkAreaMinorPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>WorkAreaMinorUtil</code> to access the work area minor persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		WorkAreaMinorImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByWorkAreaMajorIdAndDeleted;
	private FinderPath
		_finderPathWithoutPaginationFindByWorkAreaMajorIdAndDeleted;
	private FinderPath _finderPathCountByWorkAreaMajorIdAndDeleted;

	/**
	 * Returns all the work area minors where workAreaMajorId = &#63; and deleted = &#63;.
	 *
	 * @param workAreaMajorId the work area major ID
	 * @param deleted the deleted
	 * @return the matching work area minors
	 */
	@Override
	public List<WorkAreaMinor> findByWorkAreaMajorIdAndDeleted(
		long workAreaMajorId, boolean deleted) {

		return findByWorkAreaMajorIdAndDeleted(
			workAreaMajorId, deleted, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the work area minors where workAreaMajorId = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaMinorModelImpl</code>.
	 * </p>
	 *
	 * @param workAreaMajorId the work area major ID
	 * @param deleted the deleted
	 * @param start the lower bound of the range of work area minors
	 * @param end the upper bound of the range of work area minors (not inclusive)
	 * @return the range of matching work area minors
	 */
	@Override
	public List<WorkAreaMinor> findByWorkAreaMajorIdAndDeleted(
		long workAreaMajorId, boolean deleted, int start, int end) {

		return findByWorkAreaMajorIdAndDeleted(
			workAreaMajorId, deleted, start, end, null);
	}

	/**
	 * Returns an ordered range of all the work area minors where workAreaMajorId = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaMinorModelImpl</code>.
	 * </p>
	 *
	 * @param workAreaMajorId the work area major ID
	 * @param deleted the deleted
	 * @param start the lower bound of the range of work area minors
	 * @param end the upper bound of the range of work area minors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work area minors
	 */
	@Override
	public List<WorkAreaMinor> findByWorkAreaMajorIdAndDeleted(
		long workAreaMajorId, boolean deleted, int start, int end,
		OrderByComparator<WorkAreaMinor> orderByComparator) {

		return findByWorkAreaMajorIdAndDeleted(
			workAreaMajorId, deleted, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the work area minors where workAreaMajorId = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaMinorModelImpl</code>.
	 * </p>
	 *
	 * @param workAreaMajorId the work area major ID
	 * @param deleted the deleted
	 * @param start the lower bound of the range of work area minors
	 * @param end the upper bound of the range of work area minors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work area minors
	 */
	@Override
	public List<WorkAreaMinor> findByWorkAreaMajorIdAndDeleted(
		long workAreaMajorId, boolean deleted, int start, int end,
		OrderByComparator<WorkAreaMinor> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByWorkAreaMajorIdAndDeleted;
				finderArgs = new Object[] {workAreaMajorId, deleted};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByWorkAreaMajorIdAndDeleted;
			finderArgs = new Object[] {
				workAreaMajorId, deleted, start, end, orderByComparator
			};
		}

		List<WorkAreaMinor> list = null;

		if (useFinderCache) {
			list = (List<WorkAreaMinor>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WorkAreaMinor workAreaMinor : list) {
					if ((workAreaMajorId !=
							workAreaMinor.getWorkAreaMajorId()) ||
						(deleted != workAreaMinor.isDeleted())) {

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

			sb.append(_SQL_SELECT_WORKAREAMINOR_WHERE);

			sb.append(
				_FINDER_COLUMN_WORKAREAMAJORIDANDDELETED_WORKAREAMAJORID_2);

			sb.append(_FINDER_COLUMN_WORKAREAMAJORIDANDDELETED_DELETED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(WorkAreaMinorModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(workAreaMajorId);

				queryPos.add(deleted);

				list = (List<WorkAreaMinor>)QueryUtil.list(
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
	 * Returns the first work area minor in the ordered set where workAreaMajorId = &#63; and deleted = &#63;.
	 *
	 * @param workAreaMajorId the work area major ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work area minor
	 * @throws NoSuchWorkAreaMinorException if a matching work area minor could not be found
	 */
	@Override
	public WorkAreaMinor findByWorkAreaMajorIdAndDeleted_First(
			long workAreaMajorId, boolean deleted,
			OrderByComparator<WorkAreaMinor> orderByComparator)
		throws NoSuchWorkAreaMinorException {

		WorkAreaMinor workAreaMinor = fetchByWorkAreaMajorIdAndDeleted_First(
			workAreaMajorId, deleted, orderByComparator);

		if (workAreaMinor != null) {
			return workAreaMinor;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("workAreaMajorId=");
		sb.append(workAreaMajorId);

		sb.append(", deleted=");
		sb.append(deleted);

		sb.append("}");

		throw new NoSuchWorkAreaMinorException(sb.toString());
	}

	/**
	 * Returns the first work area minor in the ordered set where workAreaMajorId = &#63; and deleted = &#63;.
	 *
	 * @param workAreaMajorId the work area major ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work area minor, or <code>null</code> if a matching work area minor could not be found
	 */
	@Override
	public WorkAreaMinor fetchByWorkAreaMajorIdAndDeleted_First(
		long workAreaMajorId, boolean deleted,
		OrderByComparator<WorkAreaMinor> orderByComparator) {

		List<WorkAreaMinor> list = findByWorkAreaMajorIdAndDeleted(
			workAreaMajorId, deleted, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last work area minor in the ordered set where workAreaMajorId = &#63; and deleted = &#63;.
	 *
	 * @param workAreaMajorId the work area major ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work area minor
	 * @throws NoSuchWorkAreaMinorException if a matching work area minor could not be found
	 */
	@Override
	public WorkAreaMinor findByWorkAreaMajorIdAndDeleted_Last(
			long workAreaMajorId, boolean deleted,
			OrderByComparator<WorkAreaMinor> orderByComparator)
		throws NoSuchWorkAreaMinorException {

		WorkAreaMinor workAreaMinor = fetchByWorkAreaMajorIdAndDeleted_Last(
			workAreaMajorId, deleted, orderByComparator);

		if (workAreaMinor != null) {
			return workAreaMinor;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("workAreaMajorId=");
		sb.append(workAreaMajorId);

		sb.append(", deleted=");
		sb.append(deleted);

		sb.append("}");

		throw new NoSuchWorkAreaMinorException(sb.toString());
	}

	/**
	 * Returns the last work area minor in the ordered set where workAreaMajorId = &#63; and deleted = &#63;.
	 *
	 * @param workAreaMajorId the work area major ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work area minor, or <code>null</code> if a matching work area minor could not be found
	 */
	@Override
	public WorkAreaMinor fetchByWorkAreaMajorIdAndDeleted_Last(
		long workAreaMajorId, boolean deleted,
		OrderByComparator<WorkAreaMinor> orderByComparator) {

		int count = countByWorkAreaMajorIdAndDeleted(workAreaMajorId, deleted);

		if (count == 0) {
			return null;
		}

		List<WorkAreaMinor> list = findByWorkAreaMajorIdAndDeleted(
			workAreaMajorId, deleted, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the work area minors before and after the current work area minor in the ordered set where workAreaMajorId = &#63; and deleted = &#63;.
	 *
	 * @param workAreaMinorId the primary key of the current work area minor
	 * @param workAreaMajorId the work area major ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work area minor
	 * @throws NoSuchWorkAreaMinorException if a work area minor with the primary key could not be found
	 */
	@Override
	public WorkAreaMinor[] findByWorkAreaMajorIdAndDeleted_PrevAndNext(
			long workAreaMinorId, long workAreaMajorId, boolean deleted,
			OrderByComparator<WorkAreaMinor> orderByComparator)
		throws NoSuchWorkAreaMinorException {

		WorkAreaMinor workAreaMinor = findByPrimaryKey(workAreaMinorId);

		Session session = null;

		try {
			session = openSession();

			WorkAreaMinor[] array = new WorkAreaMinorImpl[3];

			array[0] = getByWorkAreaMajorIdAndDeleted_PrevAndNext(
				session, workAreaMinor, workAreaMajorId, deleted,
				orderByComparator, true);

			array[1] = workAreaMinor;

			array[2] = getByWorkAreaMajorIdAndDeleted_PrevAndNext(
				session, workAreaMinor, workAreaMajorId, deleted,
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

	protected WorkAreaMinor getByWorkAreaMajorIdAndDeleted_PrevAndNext(
		Session session, WorkAreaMinor workAreaMinor, long workAreaMajorId,
		boolean deleted, OrderByComparator<WorkAreaMinor> orderByComparator,
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

		sb.append(_SQL_SELECT_WORKAREAMINOR_WHERE);

		sb.append(_FINDER_COLUMN_WORKAREAMAJORIDANDDELETED_WORKAREAMAJORID_2);

		sb.append(_FINDER_COLUMN_WORKAREAMAJORIDANDDELETED_DELETED_2);

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
			sb.append(WorkAreaMinorModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(workAreaMajorId);

		queryPos.add(deleted);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						workAreaMinor)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<WorkAreaMinor> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the work area minors where workAreaMajorId = &#63; and deleted = &#63; from the database.
	 *
	 * @param workAreaMajorId the work area major ID
	 * @param deleted the deleted
	 */
	@Override
	public void removeByWorkAreaMajorIdAndDeleted(
		long workAreaMajorId, boolean deleted) {

		for (WorkAreaMinor workAreaMinor :
				findByWorkAreaMajorIdAndDeleted(
					workAreaMajorId, deleted, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(workAreaMinor);
		}
	}

	/**
	 * Returns the number of work area minors where workAreaMajorId = &#63; and deleted = &#63;.
	 *
	 * @param workAreaMajorId the work area major ID
	 * @param deleted the deleted
	 * @return the number of matching work area minors
	 */
	@Override
	public int countByWorkAreaMajorIdAndDeleted(
		long workAreaMajorId, boolean deleted) {

		FinderPath finderPath = _finderPathCountByWorkAreaMajorIdAndDeleted;

		Object[] finderArgs = new Object[] {workAreaMajorId, deleted};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_WORKAREAMINOR_WHERE);

			sb.append(
				_FINDER_COLUMN_WORKAREAMAJORIDANDDELETED_WORKAREAMAJORID_2);

			sb.append(_FINDER_COLUMN_WORKAREAMAJORIDANDDELETED_DELETED_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(workAreaMajorId);

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
		_FINDER_COLUMN_WORKAREAMAJORIDANDDELETED_WORKAREAMAJORID_2 =
			"workAreaMinor.workAreaMajorId = ? AND ";

	private static final String
		_FINDER_COLUMN_WORKAREAMAJORIDANDDELETED_DELETED_2 =
			"workAreaMinor.deleted = ?";

	public WorkAreaMinorPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("code", "code_");

		setDBColumnNames(dbColumnNames);

		setModelClass(WorkAreaMinor.class);

		setModelImplClass(WorkAreaMinorImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the work area minor in the entity cache if it is enabled.
	 *
	 * @param workAreaMinor the work area minor
	 */
	@Override
	public void cacheResult(WorkAreaMinor workAreaMinor) {
		entityCache.putResult(
			WorkAreaMinorImpl.class, workAreaMinor.getPrimaryKey(),
			workAreaMinor);
	}

	/**
	 * Caches the work area minors in the entity cache if it is enabled.
	 *
	 * @param workAreaMinors the work area minors
	 */
	@Override
	public void cacheResult(List<WorkAreaMinor> workAreaMinors) {
		for (WorkAreaMinor workAreaMinor : workAreaMinors) {
			if (entityCache.getResult(
					WorkAreaMinorImpl.class, workAreaMinor.getPrimaryKey()) ==
						null) {

				cacheResult(workAreaMinor);
			}
		}
	}

	/**
	 * Clears the cache for all work area minors.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(WorkAreaMinorImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the work area minor.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WorkAreaMinor workAreaMinor) {
		entityCache.removeResult(WorkAreaMinorImpl.class, workAreaMinor);
	}

	@Override
	public void clearCache(List<WorkAreaMinor> workAreaMinors) {
		for (WorkAreaMinor workAreaMinor : workAreaMinors) {
			entityCache.removeResult(WorkAreaMinorImpl.class, workAreaMinor);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(WorkAreaMinorImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new work area minor with the primary key. Does not add the work area minor to the database.
	 *
	 * @param workAreaMinorId the primary key for the new work area minor
	 * @return the new work area minor
	 */
	@Override
	public WorkAreaMinor create(long workAreaMinorId) {
		WorkAreaMinor workAreaMinor = new WorkAreaMinorImpl();

		workAreaMinor.setNew(true);
		workAreaMinor.setPrimaryKey(workAreaMinorId);

		workAreaMinor.setCompanyId(CompanyThreadLocal.getCompanyId());

		return workAreaMinor;
	}

	/**
	 * Removes the work area minor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workAreaMinorId the primary key of the work area minor
	 * @return the work area minor that was removed
	 * @throws NoSuchWorkAreaMinorException if a work area minor with the primary key could not be found
	 */
	@Override
	public WorkAreaMinor remove(long workAreaMinorId)
		throws NoSuchWorkAreaMinorException {

		return remove((Serializable)workAreaMinorId);
	}

	/**
	 * Removes the work area minor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the work area minor
	 * @return the work area minor that was removed
	 * @throws NoSuchWorkAreaMinorException if a work area minor with the primary key could not be found
	 */
	@Override
	public WorkAreaMinor remove(Serializable primaryKey)
		throws NoSuchWorkAreaMinorException {

		Session session = null;

		try {
			session = openSession();

			WorkAreaMinor workAreaMinor = (WorkAreaMinor)session.get(
				WorkAreaMinorImpl.class, primaryKey);

			if (workAreaMinor == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWorkAreaMinorException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(workAreaMinor);
		}
		catch (NoSuchWorkAreaMinorException noSuchEntityException) {
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
	protected WorkAreaMinor removeImpl(WorkAreaMinor workAreaMinor) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(workAreaMinor)) {
				workAreaMinor = (WorkAreaMinor)session.get(
					WorkAreaMinorImpl.class, workAreaMinor.getPrimaryKeyObj());
			}

			if (workAreaMinor != null) {
				session.delete(workAreaMinor);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (workAreaMinor != null) {
			clearCache(workAreaMinor);
		}

		return workAreaMinor;
	}

	@Override
	public WorkAreaMinor updateImpl(WorkAreaMinor workAreaMinor) {
		boolean isNew = workAreaMinor.isNew();

		if (!(workAreaMinor instanceof WorkAreaMinorModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(workAreaMinor.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					workAreaMinor);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in workAreaMinor proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom WorkAreaMinor implementation " +
					workAreaMinor.getClass());
		}

		WorkAreaMinorModelImpl workAreaMinorModelImpl =
			(WorkAreaMinorModelImpl)workAreaMinor;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (workAreaMinor.getCreateDate() == null)) {
			if (serviceContext == null) {
				workAreaMinor.setCreateDate(now);
			}
			else {
				workAreaMinor.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!workAreaMinorModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				workAreaMinor.setModifiedDate(now);
			}
			else {
				workAreaMinor.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(workAreaMinor);
			}
			else {
				workAreaMinor = (WorkAreaMinor)session.merge(workAreaMinor);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			WorkAreaMinorImpl.class, workAreaMinorModelImpl, false, true);

		if (isNew) {
			workAreaMinor.setNew(false);
		}

		workAreaMinor.resetOriginalValues();

		return workAreaMinor;
	}

	/**
	 * Returns the work area minor with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the work area minor
	 * @return the work area minor
	 * @throws NoSuchWorkAreaMinorException if a work area minor with the primary key could not be found
	 */
	@Override
	public WorkAreaMinor findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWorkAreaMinorException {

		WorkAreaMinor workAreaMinor = fetchByPrimaryKey(primaryKey);

		if (workAreaMinor == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWorkAreaMinorException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return workAreaMinor;
	}

	/**
	 * Returns the work area minor with the primary key or throws a <code>NoSuchWorkAreaMinorException</code> if it could not be found.
	 *
	 * @param workAreaMinorId the primary key of the work area minor
	 * @return the work area minor
	 * @throws NoSuchWorkAreaMinorException if a work area minor with the primary key could not be found
	 */
	@Override
	public WorkAreaMinor findByPrimaryKey(long workAreaMinorId)
		throws NoSuchWorkAreaMinorException {

		return findByPrimaryKey((Serializable)workAreaMinorId);
	}

	/**
	 * Returns the work area minor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workAreaMinorId the primary key of the work area minor
	 * @return the work area minor, or <code>null</code> if a work area minor with the primary key could not be found
	 */
	@Override
	public WorkAreaMinor fetchByPrimaryKey(long workAreaMinorId) {
		return fetchByPrimaryKey((Serializable)workAreaMinorId);
	}

	/**
	 * Returns all the work area minors.
	 *
	 * @return the work area minors
	 */
	@Override
	public List<WorkAreaMinor> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the work area minors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaMinorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work area minors
	 * @param end the upper bound of the range of work area minors (not inclusive)
	 * @return the range of work area minors
	 */
	@Override
	public List<WorkAreaMinor> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the work area minors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaMinorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work area minors
	 * @param end the upper bound of the range of work area minors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of work area minors
	 */
	@Override
	public List<WorkAreaMinor> findAll(
		int start, int end,
		OrderByComparator<WorkAreaMinor> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the work area minors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaMinorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work area minors
	 * @param end the upper bound of the range of work area minors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of work area minors
	 */
	@Override
	public List<WorkAreaMinor> findAll(
		int start, int end, OrderByComparator<WorkAreaMinor> orderByComparator,
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

		List<WorkAreaMinor> list = null;

		if (useFinderCache) {
			list = (List<WorkAreaMinor>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_WORKAREAMINOR);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_WORKAREAMINOR;

				sql = sql.concat(WorkAreaMinorModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<WorkAreaMinor>)QueryUtil.list(
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
	 * Removes all the work area minors from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (WorkAreaMinor workAreaMinor : findAll()) {
			remove(workAreaMinor);
		}
	}

	/**
	 * Returns the number of work area minors.
	 *
	 * @return the number of work area minors
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_WORKAREAMINOR);

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
		return "workAreaMinorId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_WORKAREAMINOR;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return WorkAreaMinorModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the work area minor persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new WorkAreaMinorModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", WorkAreaMinor.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByWorkAreaMajorIdAndDeleted =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByWorkAreaMajorIdAndDeleted",
				new String[] {
					Long.class.getName(), Boolean.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {"workAreaMajorId", "deleted"}, true);

		_finderPathWithoutPaginationFindByWorkAreaMajorIdAndDeleted =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByWorkAreaMajorIdAndDeleted",
				new String[] {Long.class.getName(), Boolean.class.getName()},
				new String[] {"workAreaMajorId", "deleted"}, true);

		_finderPathCountByWorkAreaMajorIdAndDeleted = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByWorkAreaMajorIdAndDeleted",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"workAreaMajorId", "deleted"}, false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(WorkAreaMinorImpl.class.getName());

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

	private static final String _SQL_SELECT_WORKAREAMINOR =
		"SELECT workAreaMinor FROM WorkAreaMinor workAreaMinor";

	private static final String _SQL_SELECT_WORKAREAMINOR_WHERE =
		"SELECT workAreaMinor FROM WorkAreaMinor workAreaMinor WHERE ";

	private static final String _SQL_COUNT_WORKAREAMINOR =
		"SELECT COUNT(workAreaMinor) FROM WorkAreaMinor workAreaMinor";

	private static final String _SQL_COUNT_WORKAREAMINOR_WHERE =
		"SELECT COUNT(workAreaMinor) FROM WorkAreaMinor workAreaMinor WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "workAreaMinor.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No WorkAreaMinor exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No WorkAreaMinor exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		WorkAreaMinorPersistenceImpl.class);

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

	private static class WorkAreaMinorModelArgumentsResolver
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

			WorkAreaMinorModelImpl workAreaMinorModelImpl =
				(WorkAreaMinorModelImpl)baseModel;

			long columnBitmask = workAreaMinorModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(workAreaMinorModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						workAreaMinorModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(workAreaMinorModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			WorkAreaMinorModelImpl workAreaMinorModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						workAreaMinorModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = workAreaMinorModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}