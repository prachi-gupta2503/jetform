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

import com.adjecti.mdm.liferay.exception.NoSuchWorkAreaMajorException;
import com.adjecti.mdm.liferay.model.WorkAreaMajor;
import com.adjecti.mdm.liferay.model.impl.WorkAreaMajorImpl;
import com.adjecti.mdm.liferay.model.impl.WorkAreaMajorModelImpl;
import com.adjecti.mdm.liferay.service.persistence.WorkAreaMajorPersistence;
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
import com.liferay.portal.kernel.util.StringUtil;

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
 * The persistence implementation for the work area major service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = WorkAreaMajorPersistence.class)
public class WorkAreaMajorPersistenceImpl
	extends BasePersistenceImpl<WorkAreaMajor>
	implements WorkAreaMajorPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>WorkAreaMajorUtil</code> to access the work area major persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		WorkAreaMajorImpl.class.getName();

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
	 * Returns all the work area majors where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching work area majors
	 */
	@Override
	public List<WorkAreaMajor> findByCode(String code) {
		return findByCode(code, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the work area majors where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaMajorModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of work area majors
	 * @param end the upper bound of the range of work area majors (not inclusive)
	 * @return the range of matching work area majors
	 */
	@Override
	public List<WorkAreaMajor> findByCode(String code, int start, int end) {
		return findByCode(code, start, end, null);
	}

	/**
	 * Returns an ordered range of all the work area majors where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaMajorModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of work area majors
	 * @param end the upper bound of the range of work area majors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work area majors
	 */
	@Override
	public List<WorkAreaMajor> findByCode(
		String code, int start, int end,
		OrderByComparator<WorkAreaMajor> orderByComparator) {

		return findByCode(code, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the work area majors where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaMajorModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of work area majors
	 * @param end the upper bound of the range of work area majors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work area majors
	 */
	@Override
	public List<WorkAreaMajor> findByCode(
		String code, int start, int end,
		OrderByComparator<WorkAreaMajor> orderByComparator,
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

		List<WorkAreaMajor> list = null;

		if (useFinderCache) {
			list = (List<WorkAreaMajor>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WorkAreaMajor workAreaMajor : list) {
					if (!code.equals(workAreaMajor.getCode())) {
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

			sb.append(_SQL_SELECT_WORKAREAMAJOR_WHERE);

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
				sb.append(WorkAreaMajorModelImpl.ORDER_BY_JPQL);
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

				list = (List<WorkAreaMajor>)QueryUtil.list(
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
	 * Returns the first work area major in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work area major
	 * @throws NoSuchWorkAreaMajorException if a matching work area major could not be found
	 */
	@Override
	public WorkAreaMajor findByCode_First(
			String code, OrderByComparator<WorkAreaMajor> orderByComparator)
		throws NoSuchWorkAreaMajorException {

		WorkAreaMajor workAreaMajor = fetchByCode_First(
			code, orderByComparator);

		if (workAreaMajor != null) {
			return workAreaMajor;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("code=");
		sb.append(code);

		sb.append("}");

		throw new NoSuchWorkAreaMajorException(sb.toString());
	}

	/**
	 * Returns the first work area major in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work area major, or <code>null</code> if a matching work area major could not be found
	 */
	@Override
	public WorkAreaMajor fetchByCode_First(
		String code, OrderByComparator<WorkAreaMajor> orderByComparator) {

		List<WorkAreaMajor> list = findByCode(code, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last work area major in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work area major
	 * @throws NoSuchWorkAreaMajorException if a matching work area major could not be found
	 */
	@Override
	public WorkAreaMajor findByCode_Last(
			String code, OrderByComparator<WorkAreaMajor> orderByComparator)
		throws NoSuchWorkAreaMajorException {

		WorkAreaMajor workAreaMajor = fetchByCode_Last(code, orderByComparator);

		if (workAreaMajor != null) {
			return workAreaMajor;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("code=");
		sb.append(code);

		sb.append("}");

		throw new NoSuchWorkAreaMajorException(sb.toString());
	}

	/**
	 * Returns the last work area major in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work area major, or <code>null</code> if a matching work area major could not be found
	 */
	@Override
	public WorkAreaMajor fetchByCode_Last(
		String code, OrderByComparator<WorkAreaMajor> orderByComparator) {

		int count = countByCode(code);

		if (count == 0) {
			return null;
		}

		List<WorkAreaMajor> list = findByCode(
			code, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the work area majors before and after the current work area major in the ordered set where code = &#63;.
	 *
	 * @param workAreaMajorId the primary key of the current work area major
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work area major
	 * @throws NoSuchWorkAreaMajorException if a work area major with the primary key could not be found
	 */
	@Override
	public WorkAreaMajor[] findByCode_PrevAndNext(
			long workAreaMajorId, String code,
			OrderByComparator<WorkAreaMajor> orderByComparator)
		throws NoSuchWorkAreaMajorException {

		code = Objects.toString(code, "");

		WorkAreaMajor workAreaMajor = findByPrimaryKey(workAreaMajorId);

		Session session = null;

		try {
			session = openSession();

			WorkAreaMajor[] array = new WorkAreaMajorImpl[3];

			array[0] = getByCode_PrevAndNext(
				session, workAreaMajor, code, orderByComparator, true);

			array[1] = workAreaMajor;

			array[2] = getByCode_PrevAndNext(
				session, workAreaMajor, code, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected WorkAreaMajor getByCode_PrevAndNext(
		Session session, WorkAreaMajor workAreaMajor, String code,
		OrderByComparator<WorkAreaMajor> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_WORKAREAMAJOR_WHERE);

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
			sb.append(WorkAreaMajorModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						workAreaMajor)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<WorkAreaMajor> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the work area majors where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	@Override
	public void removeByCode(String code) {
		for (WorkAreaMajor workAreaMajor :
				findByCode(code, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(workAreaMajor);
		}
	}

	/**
	 * Returns the number of work area majors where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching work area majors
	 */
	@Override
	public int countByCode(String code) {
		code = Objects.toString(code, "");

		FinderPath finderPath = _finderPathCountByCode;

		Object[] finderArgs = new Object[] {code};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_WORKAREAMAJOR_WHERE);

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
		"workAreaMajor.code = ?";

	private static final String _FINDER_COLUMN_CODE_CODE_3 =
		"(workAreaMajor.code IS NULL OR workAreaMajor.code = '')";

	private FinderPath _finderPathWithPaginationFindByName;
	private FinderPath _finderPathWithoutPaginationFindByName;
	private FinderPath _finderPathCountByName;

	/**
	 * Returns all the work area majors where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching work area majors
	 */
	@Override
	public List<WorkAreaMajor> findByName(String name) {
		return findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the work area majors where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaMajorModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of work area majors
	 * @param end the upper bound of the range of work area majors (not inclusive)
	 * @return the range of matching work area majors
	 */
	@Override
	public List<WorkAreaMajor> findByName(String name, int start, int end) {
		return findByName(name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the work area majors where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaMajorModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of work area majors
	 * @param end the upper bound of the range of work area majors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work area majors
	 */
	@Override
	public List<WorkAreaMajor> findByName(
		String name, int start, int end,
		OrderByComparator<WorkAreaMajor> orderByComparator) {

		return findByName(name, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the work area majors where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaMajorModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of work area majors
	 * @param end the upper bound of the range of work area majors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work area majors
	 */
	@Override
	public List<WorkAreaMajor> findByName(
		String name, int start, int end,
		OrderByComparator<WorkAreaMajor> orderByComparator,
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

		List<WorkAreaMajor> list = null;

		if (useFinderCache) {
			list = (List<WorkAreaMajor>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WorkAreaMajor workAreaMajor : list) {
					if (!name.equals(workAreaMajor.getName())) {
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

			sb.append(_SQL_SELECT_WORKAREAMAJOR_WHERE);

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
				sb.append(WorkAreaMajorModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(StringUtil.toLowerCase(name));
				}

				list = (List<WorkAreaMajor>)QueryUtil.list(
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
	 * Returns the first work area major in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work area major
	 * @throws NoSuchWorkAreaMajorException if a matching work area major could not be found
	 */
	@Override
	public WorkAreaMajor findByName_First(
			String name, OrderByComparator<WorkAreaMajor> orderByComparator)
		throws NoSuchWorkAreaMajorException {

		WorkAreaMajor workAreaMajor = fetchByName_First(
			name, orderByComparator);

		if (workAreaMajor != null) {
			return workAreaMajor;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchWorkAreaMajorException(sb.toString());
	}

	/**
	 * Returns the first work area major in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work area major, or <code>null</code> if a matching work area major could not be found
	 */
	@Override
	public WorkAreaMajor fetchByName_First(
		String name, OrderByComparator<WorkAreaMajor> orderByComparator) {

		List<WorkAreaMajor> list = findByName(name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last work area major in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work area major
	 * @throws NoSuchWorkAreaMajorException if a matching work area major could not be found
	 */
	@Override
	public WorkAreaMajor findByName_Last(
			String name, OrderByComparator<WorkAreaMajor> orderByComparator)
		throws NoSuchWorkAreaMajorException {

		WorkAreaMajor workAreaMajor = fetchByName_Last(name, orderByComparator);

		if (workAreaMajor != null) {
			return workAreaMajor;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchWorkAreaMajorException(sb.toString());
	}

	/**
	 * Returns the last work area major in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work area major, or <code>null</code> if a matching work area major could not be found
	 */
	@Override
	public WorkAreaMajor fetchByName_Last(
		String name, OrderByComparator<WorkAreaMajor> orderByComparator) {

		int count = countByName(name);

		if (count == 0) {
			return null;
		}

		List<WorkAreaMajor> list = findByName(
			name, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the work area majors before and after the current work area major in the ordered set where name = &#63;.
	 *
	 * @param workAreaMajorId the primary key of the current work area major
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work area major
	 * @throws NoSuchWorkAreaMajorException if a work area major with the primary key could not be found
	 */
	@Override
	public WorkAreaMajor[] findByName_PrevAndNext(
			long workAreaMajorId, String name,
			OrderByComparator<WorkAreaMajor> orderByComparator)
		throws NoSuchWorkAreaMajorException {

		name = Objects.toString(name, "");

		WorkAreaMajor workAreaMajor = findByPrimaryKey(workAreaMajorId);

		Session session = null;

		try {
			session = openSession();

			WorkAreaMajor[] array = new WorkAreaMajorImpl[3];

			array[0] = getByName_PrevAndNext(
				session, workAreaMajor, name, orderByComparator, true);

			array[1] = workAreaMajor;

			array[2] = getByName_PrevAndNext(
				session, workAreaMajor, name, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected WorkAreaMajor getByName_PrevAndNext(
		Session session, WorkAreaMajor workAreaMajor, String name,
		OrderByComparator<WorkAreaMajor> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_WORKAREAMAJOR_WHERE);

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
			sb.append(WorkAreaMajorModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindName) {
			queryPos.add(StringUtil.toLowerCase(name));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						workAreaMajor)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<WorkAreaMajor> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the work area majors where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	@Override
	public void removeByName(String name) {
		for (WorkAreaMajor workAreaMajor :
				findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(workAreaMajor);
		}
	}

	/**
	 * Returns the number of work area majors where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching work area majors
	 */
	@Override
	public int countByName(String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByName;

		Object[] finderArgs = new Object[] {name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_WORKAREAMAJOR_WHERE);

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
					queryPos.add(StringUtil.toLowerCase(name));
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
		"lower(workAreaMajor.name) = ?";

	private static final String _FINDER_COLUMN_NAME_NAME_3 =
		"(workAreaMajor.name IS NULL OR workAreaMajor.name = '')";

	private FinderPath _finderPathWithPaginationFindByParentWorkAreaId;
	private FinderPath _finderPathWithoutPaginationFindByParentWorkAreaId;
	private FinderPath _finderPathCountByParentWorkAreaId;

	/**
	 * Returns all the work area majors where parentWorkAreaId = &#63;.
	 *
	 * @param parentWorkAreaId the parent work area ID
	 * @return the matching work area majors
	 */
	@Override
	public List<WorkAreaMajor> findByParentWorkAreaId(long parentWorkAreaId) {
		return findByParentWorkAreaId(
			parentWorkAreaId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the work area majors where parentWorkAreaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaMajorModelImpl</code>.
	 * </p>
	 *
	 * @param parentWorkAreaId the parent work area ID
	 * @param start the lower bound of the range of work area majors
	 * @param end the upper bound of the range of work area majors (not inclusive)
	 * @return the range of matching work area majors
	 */
	@Override
	public List<WorkAreaMajor> findByParentWorkAreaId(
		long parentWorkAreaId, int start, int end) {

		return findByParentWorkAreaId(parentWorkAreaId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the work area majors where parentWorkAreaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaMajorModelImpl</code>.
	 * </p>
	 *
	 * @param parentWorkAreaId the parent work area ID
	 * @param start the lower bound of the range of work area majors
	 * @param end the upper bound of the range of work area majors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work area majors
	 */
	@Override
	public List<WorkAreaMajor> findByParentWorkAreaId(
		long parentWorkAreaId, int start, int end,
		OrderByComparator<WorkAreaMajor> orderByComparator) {

		return findByParentWorkAreaId(
			parentWorkAreaId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the work area majors where parentWorkAreaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaMajorModelImpl</code>.
	 * </p>
	 *
	 * @param parentWorkAreaId the parent work area ID
	 * @param start the lower bound of the range of work area majors
	 * @param end the upper bound of the range of work area majors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work area majors
	 */
	@Override
	public List<WorkAreaMajor> findByParentWorkAreaId(
		long parentWorkAreaId, int start, int end,
		OrderByComparator<WorkAreaMajor> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByParentWorkAreaId;
				finderArgs = new Object[] {parentWorkAreaId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByParentWorkAreaId;
			finderArgs = new Object[] {
				parentWorkAreaId, start, end, orderByComparator
			};
		}

		List<WorkAreaMajor> list = null;

		if (useFinderCache) {
			list = (List<WorkAreaMajor>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WorkAreaMajor workAreaMajor : list) {
					if (parentWorkAreaId !=
							workAreaMajor.getParentWorkAreaId()) {

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

			sb.append(_SQL_SELECT_WORKAREAMAJOR_WHERE);

			sb.append(_FINDER_COLUMN_PARENTWORKAREAID_PARENTWORKAREAID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(WorkAreaMajorModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(parentWorkAreaId);

				list = (List<WorkAreaMajor>)QueryUtil.list(
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
	 * Returns the first work area major in the ordered set where parentWorkAreaId = &#63;.
	 *
	 * @param parentWorkAreaId the parent work area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work area major
	 * @throws NoSuchWorkAreaMajorException if a matching work area major could not be found
	 */
	@Override
	public WorkAreaMajor findByParentWorkAreaId_First(
			long parentWorkAreaId,
			OrderByComparator<WorkAreaMajor> orderByComparator)
		throws NoSuchWorkAreaMajorException {

		WorkAreaMajor workAreaMajor = fetchByParentWorkAreaId_First(
			parentWorkAreaId, orderByComparator);

		if (workAreaMajor != null) {
			return workAreaMajor;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("parentWorkAreaId=");
		sb.append(parentWorkAreaId);

		sb.append("}");

		throw new NoSuchWorkAreaMajorException(sb.toString());
	}

	/**
	 * Returns the first work area major in the ordered set where parentWorkAreaId = &#63;.
	 *
	 * @param parentWorkAreaId the parent work area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work area major, or <code>null</code> if a matching work area major could not be found
	 */
	@Override
	public WorkAreaMajor fetchByParentWorkAreaId_First(
		long parentWorkAreaId,
		OrderByComparator<WorkAreaMajor> orderByComparator) {

		List<WorkAreaMajor> list = findByParentWorkAreaId(
			parentWorkAreaId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last work area major in the ordered set where parentWorkAreaId = &#63;.
	 *
	 * @param parentWorkAreaId the parent work area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work area major
	 * @throws NoSuchWorkAreaMajorException if a matching work area major could not be found
	 */
	@Override
	public WorkAreaMajor findByParentWorkAreaId_Last(
			long parentWorkAreaId,
			OrderByComparator<WorkAreaMajor> orderByComparator)
		throws NoSuchWorkAreaMajorException {

		WorkAreaMajor workAreaMajor = fetchByParentWorkAreaId_Last(
			parentWorkAreaId, orderByComparator);

		if (workAreaMajor != null) {
			return workAreaMajor;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("parentWorkAreaId=");
		sb.append(parentWorkAreaId);

		sb.append("}");

		throw new NoSuchWorkAreaMajorException(sb.toString());
	}

	/**
	 * Returns the last work area major in the ordered set where parentWorkAreaId = &#63;.
	 *
	 * @param parentWorkAreaId the parent work area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work area major, or <code>null</code> if a matching work area major could not be found
	 */
	@Override
	public WorkAreaMajor fetchByParentWorkAreaId_Last(
		long parentWorkAreaId,
		OrderByComparator<WorkAreaMajor> orderByComparator) {

		int count = countByParentWorkAreaId(parentWorkAreaId);

		if (count == 0) {
			return null;
		}

		List<WorkAreaMajor> list = findByParentWorkAreaId(
			parentWorkAreaId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the work area majors before and after the current work area major in the ordered set where parentWorkAreaId = &#63;.
	 *
	 * @param workAreaMajorId the primary key of the current work area major
	 * @param parentWorkAreaId the parent work area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work area major
	 * @throws NoSuchWorkAreaMajorException if a work area major with the primary key could not be found
	 */
	@Override
	public WorkAreaMajor[] findByParentWorkAreaId_PrevAndNext(
			long workAreaMajorId, long parentWorkAreaId,
			OrderByComparator<WorkAreaMajor> orderByComparator)
		throws NoSuchWorkAreaMajorException {

		WorkAreaMajor workAreaMajor = findByPrimaryKey(workAreaMajorId);

		Session session = null;

		try {
			session = openSession();

			WorkAreaMajor[] array = new WorkAreaMajorImpl[3];

			array[0] = getByParentWorkAreaId_PrevAndNext(
				session, workAreaMajor, parentWorkAreaId, orderByComparator,
				true);

			array[1] = workAreaMajor;

			array[2] = getByParentWorkAreaId_PrevAndNext(
				session, workAreaMajor, parentWorkAreaId, orderByComparator,
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

	protected WorkAreaMajor getByParentWorkAreaId_PrevAndNext(
		Session session, WorkAreaMajor workAreaMajor, long parentWorkAreaId,
		OrderByComparator<WorkAreaMajor> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_WORKAREAMAJOR_WHERE);

		sb.append(_FINDER_COLUMN_PARENTWORKAREAID_PARENTWORKAREAID_2);

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
			sb.append(WorkAreaMajorModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(parentWorkAreaId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						workAreaMajor)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<WorkAreaMajor> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the work area majors where parentWorkAreaId = &#63; from the database.
	 *
	 * @param parentWorkAreaId the parent work area ID
	 */
	@Override
	public void removeByParentWorkAreaId(long parentWorkAreaId) {
		for (WorkAreaMajor workAreaMajor :
				findByParentWorkAreaId(
					parentWorkAreaId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(workAreaMajor);
		}
	}

	/**
	 * Returns the number of work area majors where parentWorkAreaId = &#63;.
	 *
	 * @param parentWorkAreaId the parent work area ID
	 * @return the number of matching work area majors
	 */
	@Override
	public int countByParentWorkAreaId(long parentWorkAreaId) {
		FinderPath finderPath = _finderPathCountByParentWorkAreaId;

		Object[] finderArgs = new Object[] {parentWorkAreaId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_WORKAREAMAJOR_WHERE);

			sb.append(_FINDER_COLUMN_PARENTWORKAREAID_PARENTWORKAREAID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(parentWorkAreaId);

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
		_FINDER_COLUMN_PARENTWORKAREAID_PARENTWORKAREAID_2 =
			"workAreaMajor.parentWorkAreaId = ?";

	public WorkAreaMajorPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("code", "code_");

		setDBColumnNames(dbColumnNames);

		setModelClass(WorkAreaMajor.class);

		setModelImplClass(WorkAreaMajorImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the work area major in the entity cache if it is enabled.
	 *
	 * @param workAreaMajor the work area major
	 */
	@Override
	public void cacheResult(WorkAreaMajor workAreaMajor) {
		entityCache.putResult(
			WorkAreaMajorImpl.class, workAreaMajor.getPrimaryKey(),
			workAreaMajor);
	}

	/**
	 * Caches the work area majors in the entity cache if it is enabled.
	 *
	 * @param workAreaMajors the work area majors
	 */
	@Override
	public void cacheResult(List<WorkAreaMajor> workAreaMajors) {
		for (WorkAreaMajor workAreaMajor : workAreaMajors) {
			if (entityCache.getResult(
					WorkAreaMajorImpl.class, workAreaMajor.getPrimaryKey()) ==
						null) {

				cacheResult(workAreaMajor);
			}
		}
	}

	/**
	 * Clears the cache for all work area majors.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(WorkAreaMajorImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the work area major.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WorkAreaMajor workAreaMajor) {
		entityCache.removeResult(WorkAreaMajorImpl.class, workAreaMajor);
	}

	@Override
	public void clearCache(List<WorkAreaMajor> workAreaMajors) {
		for (WorkAreaMajor workAreaMajor : workAreaMajors) {
			entityCache.removeResult(WorkAreaMajorImpl.class, workAreaMajor);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(WorkAreaMajorImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new work area major with the primary key. Does not add the work area major to the database.
	 *
	 * @param workAreaMajorId the primary key for the new work area major
	 * @return the new work area major
	 */
	@Override
	public WorkAreaMajor create(long workAreaMajorId) {
		WorkAreaMajor workAreaMajor = new WorkAreaMajorImpl();

		workAreaMajor.setNew(true);
		workAreaMajor.setPrimaryKey(workAreaMajorId);

		workAreaMajor.setCompanyId(CompanyThreadLocal.getCompanyId());

		return workAreaMajor;
	}

	/**
	 * Removes the work area major with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workAreaMajorId the primary key of the work area major
	 * @return the work area major that was removed
	 * @throws NoSuchWorkAreaMajorException if a work area major with the primary key could not be found
	 */
	@Override
	public WorkAreaMajor remove(long workAreaMajorId)
		throws NoSuchWorkAreaMajorException {

		return remove((Serializable)workAreaMajorId);
	}

	/**
	 * Removes the work area major with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the work area major
	 * @return the work area major that was removed
	 * @throws NoSuchWorkAreaMajorException if a work area major with the primary key could not be found
	 */
	@Override
	public WorkAreaMajor remove(Serializable primaryKey)
		throws NoSuchWorkAreaMajorException {

		Session session = null;

		try {
			session = openSession();

			WorkAreaMajor workAreaMajor = (WorkAreaMajor)session.get(
				WorkAreaMajorImpl.class, primaryKey);

			if (workAreaMajor == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWorkAreaMajorException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(workAreaMajor);
		}
		catch (NoSuchWorkAreaMajorException noSuchEntityException) {
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
	protected WorkAreaMajor removeImpl(WorkAreaMajor workAreaMajor) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(workAreaMajor)) {
				workAreaMajor = (WorkAreaMajor)session.get(
					WorkAreaMajorImpl.class, workAreaMajor.getPrimaryKeyObj());
			}

			if (workAreaMajor != null) {
				session.delete(workAreaMajor);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (workAreaMajor != null) {
			clearCache(workAreaMajor);
		}

		return workAreaMajor;
	}

	@Override
	public WorkAreaMajor updateImpl(WorkAreaMajor workAreaMajor) {
		boolean isNew = workAreaMajor.isNew();

		if (!(workAreaMajor instanceof WorkAreaMajorModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(workAreaMajor.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					workAreaMajor);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in workAreaMajor proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom WorkAreaMajor implementation " +
					workAreaMajor.getClass());
		}

		WorkAreaMajorModelImpl workAreaMajorModelImpl =
			(WorkAreaMajorModelImpl)workAreaMajor;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (workAreaMajor.getCreateDate() == null)) {
			if (serviceContext == null) {
				workAreaMajor.setCreateDate(now);
			}
			else {
				workAreaMajor.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!workAreaMajorModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				workAreaMajor.setModifiedDate(now);
			}
			else {
				workAreaMajor.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(workAreaMajor);
			}
			else {
				workAreaMajor = (WorkAreaMajor)session.merge(workAreaMajor);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			WorkAreaMajorImpl.class, workAreaMajorModelImpl, false, true);

		if (isNew) {
			workAreaMajor.setNew(false);
		}

		workAreaMajor.resetOriginalValues();

		return workAreaMajor;
	}

	/**
	 * Returns the work area major with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the work area major
	 * @return the work area major
	 * @throws NoSuchWorkAreaMajorException if a work area major with the primary key could not be found
	 */
	@Override
	public WorkAreaMajor findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWorkAreaMajorException {

		WorkAreaMajor workAreaMajor = fetchByPrimaryKey(primaryKey);

		if (workAreaMajor == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWorkAreaMajorException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return workAreaMajor;
	}

	/**
	 * Returns the work area major with the primary key or throws a <code>NoSuchWorkAreaMajorException</code> if it could not be found.
	 *
	 * @param workAreaMajorId the primary key of the work area major
	 * @return the work area major
	 * @throws NoSuchWorkAreaMajorException if a work area major with the primary key could not be found
	 */
	@Override
	public WorkAreaMajor findByPrimaryKey(long workAreaMajorId)
		throws NoSuchWorkAreaMajorException {

		return findByPrimaryKey((Serializable)workAreaMajorId);
	}

	/**
	 * Returns the work area major with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workAreaMajorId the primary key of the work area major
	 * @return the work area major, or <code>null</code> if a work area major with the primary key could not be found
	 */
	@Override
	public WorkAreaMajor fetchByPrimaryKey(long workAreaMajorId) {
		return fetchByPrimaryKey((Serializable)workAreaMajorId);
	}

	/**
	 * Returns all the work area majors.
	 *
	 * @return the work area majors
	 */
	@Override
	public List<WorkAreaMajor> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the work area majors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaMajorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work area majors
	 * @param end the upper bound of the range of work area majors (not inclusive)
	 * @return the range of work area majors
	 */
	@Override
	public List<WorkAreaMajor> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the work area majors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaMajorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work area majors
	 * @param end the upper bound of the range of work area majors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of work area majors
	 */
	@Override
	public List<WorkAreaMajor> findAll(
		int start, int end,
		OrderByComparator<WorkAreaMajor> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the work area majors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaMajorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work area majors
	 * @param end the upper bound of the range of work area majors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of work area majors
	 */
	@Override
	public List<WorkAreaMajor> findAll(
		int start, int end, OrderByComparator<WorkAreaMajor> orderByComparator,
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

		List<WorkAreaMajor> list = null;

		if (useFinderCache) {
			list = (List<WorkAreaMajor>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_WORKAREAMAJOR);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_WORKAREAMAJOR;

				sql = sql.concat(WorkAreaMajorModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<WorkAreaMajor>)QueryUtil.list(
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
	 * Removes all the work area majors from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (WorkAreaMajor workAreaMajor : findAll()) {
			remove(workAreaMajor);
		}
	}

	/**
	 * Returns the number of work area majors.
	 *
	 * @return the number of work area majors
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_WORKAREAMAJOR);

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
		return "workAreaMajorId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_WORKAREAMAJOR;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return WorkAreaMajorModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the work area major persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new WorkAreaMajorModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", WorkAreaMajor.class.getName()));

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

		_finderPathWithPaginationFindByParentWorkAreaId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByParentWorkAreaId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"parentWorkAreaId"}, true);

		_finderPathWithoutPaginationFindByParentWorkAreaId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByParentWorkAreaId",
			new String[] {Long.class.getName()},
			new String[] {"parentWorkAreaId"}, true);

		_finderPathCountByParentWorkAreaId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByParentWorkAreaId", new String[] {Long.class.getName()},
			new String[] {"parentWorkAreaId"}, false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(WorkAreaMajorImpl.class.getName());

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

	private static final String _SQL_SELECT_WORKAREAMAJOR =
		"SELECT workAreaMajor FROM WorkAreaMajor workAreaMajor";

	private static final String _SQL_SELECT_WORKAREAMAJOR_WHERE =
		"SELECT workAreaMajor FROM WorkAreaMajor workAreaMajor WHERE ";

	private static final String _SQL_COUNT_WORKAREAMAJOR =
		"SELECT COUNT(workAreaMajor) FROM WorkAreaMajor workAreaMajor";

	private static final String _SQL_COUNT_WORKAREAMAJOR_WHERE =
		"SELECT COUNT(workAreaMajor) FROM WorkAreaMajor workAreaMajor WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "workAreaMajor.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No WorkAreaMajor exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No WorkAreaMajor exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		WorkAreaMajorPersistenceImpl.class);

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

	private static class WorkAreaMajorModelArgumentsResolver
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

			WorkAreaMajorModelImpl workAreaMajorModelImpl =
				(WorkAreaMajorModelImpl)baseModel;

			long columnBitmask = workAreaMajorModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(workAreaMajorModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						workAreaMajorModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(workAreaMajorModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			WorkAreaMajorModelImpl workAreaMajorModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						workAreaMajorModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = workAreaMajorModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}