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

import com.adjecti.mdm.liferay.exception.NoSuchDesignationException;
import com.adjecti.mdm.liferay.model.Designation;
import com.adjecti.mdm.liferay.model.impl.DesignationImpl;
import com.adjecti.mdm.liferay.model.impl.DesignationModelImpl;
import com.adjecti.mdm.liferay.service.persistence.DesignationPersistence;
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

import java.util.Collections;
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
 * The persistence implementation for the designation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DesignationPersistence.class)
public class DesignationPersistenceImpl
	extends BasePersistenceImpl<Designation> implements DesignationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DesignationUtil</code> to access the designation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DesignationImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByCode;
	private FinderPath _finderPathCountByCode;

	/**
	 * Returns the designation where code = &#63; or throws a <code>NoSuchDesignationException</code> if it could not be found.
	 *
	 * @param code the code
	 * @return the matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	@Override
	public Designation findByCode(String code)
		throws NoSuchDesignationException {

		Designation designation = fetchByCode(code);

		if (designation == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("code=");
			sb.append(code);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDesignationException(sb.toString());
		}

		return designation;
	}

	/**
	 * Returns the designation where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @return the matching designation, or <code>null</code> if a matching designation could not be found
	 */
	@Override
	public Designation fetchByCode(String code) {
		return fetchByCode(code, true);
	}

	/**
	 * Returns the designation where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching designation, or <code>null</code> if a matching designation could not be found
	 */
	@Override
	public Designation fetchByCode(String code, boolean useFinderCache) {
		code = Objects.toString(code, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {code};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByCode, finderArgs, this);
		}

		if (result instanceof Designation) {
			Designation designation = (Designation)result;

			if (!Objects.equals(code, designation.getCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DESIGNATION_WHERE);

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

				List<Designation> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByCode, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {code};
							}

							_log.warn(
								"DesignationPersistenceImpl.fetchByCode(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Designation designation = list.get(0);

					result = designation;

					cacheResult(designation);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Designation)result;
		}
	}

	/**
	 * Removes the designation where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the designation that was removed
	 */
	@Override
	public Designation removeByCode(String code)
		throws NoSuchDesignationException {

		Designation designation = findByCode(code);

		return remove(designation);
	}

	/**
	 * Returns the number of designations where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching designations
	 */
	@Override
	public int countByCode(String code) {
		code = Objects.toString(code, "");

		FinderPath finderPath = _finderPathCountByCode;

		Object[] finderArgs = new Object[] {code};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DESIGNATION_WHERE);

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
		"designation.code = ?";

	private static final String _FINDER_COLUMN_CODE_CODE_3 =
		"(designation.code IS NULL OR designation.code = '')";

	private FinderPath _finderPathWithPaginationFindByName;
	private FinderPath _finderPathWithoutPaginationFindByName;
	private FinderPath _finderPathCountByName;

	/**
	 * Returns all the designations where name_En = &#63;.
	 *
	 * @param name_En the name_ en
	 * @return the matching designations
	 */
	@Override
	public List<Designation> findByName(String name_En) {
		return findByName(name_En, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the designations where name_En = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param name_En the name_ en
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @return the range of matching designations
	 */
	@Override
	public List<Designation> findByName(String name_En, int start, int end) {
		return findByName(name_En, start, end, null);
	}

	/**
	 * Returns an ordered range of all the designations where name_En = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param name_En the name_ en
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching designations
	 */
	@Override
	public List<Designation> findByName(
		String name_En, int start, int end,
		OrderByComparator<Designation> orderByComparator) {

		return findByName(name_En, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the designations where name_En = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param name_En the name_ en
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching designations
	 */
	@Override
	public List<Designation> findByName(
		String name_En, int start, int end,
		OrderByComparator<Designation> orderByComparator,
		boolean useFinderCache) {

		name_En = Objects.toString(name_En, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByName;
				finderArgs = new Object[] {name_En};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByName;
			finderArgs = new Object[] {name_En, start, end, orderByComparator};
		}

		List<Designation> list = null;

		if (useFinderCache) {
			list = (List<Designation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Designation designation : list) {
					if (!name_En.equals(designation.getName_En())) {
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

			sb.append(_SQL_SELECT_DESIGNATION_WHERE);

			boolean bindName_En = false;

			if (name_En.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_NAME_EN_3);
			}
			else {
				bindName_En = true;

				sb.append(_FINDER_COLUMN_NAME_NAME_EN_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DesignationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName_En) {
					queryPos.add(StringUtil.toLowerCase(name_En));
				}

				list = (List<Designation>)QueryUtil.list(
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
	 * Returns the first designation in the ordered set where name_En = &#63;.
	 *
	 * @param name_En the name_ en
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	@Override
	public Designation findByName_First(
			String name_En, OrderByComparator<Designation> orderByComparator)
		throws NoSuchDesignationException {

		Designation designation = fetchByName_First(name_En, orderByComparator);

		if (designation != null) {
			return designation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name_En=");
		sb.append(name_En);

		sb.append("}");

		throw new NoSuchDesignationException(sb.toString());
	}

	/**
	 * Returns the first designation in the ordered set where name_En = &#63;.
	 *
	 * @param name_En the name_ en
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation, or <code>null</code> if a matching designation could not be found
	 */
	@Override
	public Designation fetchByName_First(
		String name_En, OrderByComparator<Designation> orderByComparator) {

		List<Designation> list = findByName(name_En, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last designation in the ordered set where name_En = &#63;.
	 *
	 * @param name_En the name_ en
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	@Override
	public Designation findByName_Last(
			String name_En, OrderByComparator<Designation> orderByComparator)
		throws NoSuchDesignationException {

		Designation designation = fetchByName_Last(name_En, orderByComparator);

		if (designation != null) {
			return designation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name_En=");
		sb.append(name_En);

		sb.append("}");

		throw new NoSuchDesignationException(sb.toString());
	}

	/**
	 * Returns the last designation in the ordered set where name_En = &#63;.
	 *
	 * @param name_En the name_ en
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation, or <code>null</code> if a matching designation could not be found
	 */
	@Override
	public Designation fetchByName_Last(
		String name_En, OrderByComparator<Designation> orderByComparator) {

		int count = countByName(name_En);

		if (count == 0) {
			return null;
		}

		List<Designation> list = findByName(
			name_En, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the designations before and after the current designation in the ordered set where name_En = &#63;.
	 *
	 * @param designationId the primary key of the current designation
	 * @param name_En the name_ en
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next designation
	 * @throws NoSuchDesignationException if a designation with the primary key could not be found
	 */
	@Override
	public Designation[] findByName_PrevAndNext(
			long designationId, String name_En,
			OrderByComparator<Designation> orderByComparator)
		throws NoSuchDesignationException {

		name_En = Objects.toString(name_En, "");

		Designation designation = findByPrimaryKey(designationId);

		Session session = null;

		try {
			session = openSession();

			Designation[] array = new DesignationImpl[3];

			array[0] = getByName_PrevAndNext(
				session, designation, name_En, orderByComparator, true);

			array[1] = designation;

			array[2] = getByName_PrevAndNext(
				session, designation, name_En, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Designation getByName_PrevAndNext(
		Session session, Designation designation, String name_En,
		OrderByComparator<Designation> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DESIGNATION_WHERE);

		boolean bindName_En = false;

		if (name_En.isEmpty()) {
			sb.append(_FINDER_COLUMN_NAME_NAME_EN_3);
		}
		else {
			bindName_En = true;

			sb.append(_FINDER_COLUMN_NAME_NAME_EN_2);
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
			sb.append(DesignationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindName_En) {
			queryPos.add(StringUtil.toLowerCase(name_En));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(designation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Designation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the designations where name_En = &#63; from the database.
	 *
	 * @param name_En the name_ en
	 */
	@Override
	public void removeByName(String name_En) {
		for (Designation designation :
				findByName(
					name_En, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(designation);
		}
	}

	/**
	 * Returns the number of designations where name_En = &#63;.
	 *
	 * @param name_En the name_ en
	 * @return the number of matching designations
	 */
	@Override
	public int countByName(String name_En) {
		name_En = Objects.toString(name_En, "");

		FinderPath finderPath = _finderPathCountByName;

		Object[] finderArgs = new Object[] {name_En};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DESIGNATION_WHERE);

			boolean bindName_En = false;

			if (name_En.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_NAME_EN_3);
			}
			else {
				bindName_En = true;

				sb.append(_FINDER_COLUMN_NAME_NAME_EN_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName_En) {
					queryPos.add(StringUtil.toLowerCase(name_En));
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

	private static final String _FINDER_COLUMN_NAME_NAME_EN_2 =
		"lower(designation.name_En) = ?";

	private static final String _FINDER_COLUMN_NAME_NAME_EN_3 =
		"(designation.name_En IS NULL OR designation.name_En = '')";

	private FinderPath _finderPathWithPaginationFindByGradeId;
	private FinderPath _finderPathWithoutPaginationFindByGradeId;
	private FinderPath _finderPathCountByGradeId;

	/**
	 * Returns all the designations where gradeId = &#63; and deleted = &#63;.
	 *
	 * @param gradeId the grade ID
	 * @param deleted the deleted
	 * @return the matching designations
	 */
	@Override
	public List<Designation> findByGradeId(long gradeId, boolean deleted) {
		return findByGradeId(
			gradeId, deleted, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the designations where gradeId = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param gradeId the grade ID
	 * @param deleted the deleted
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @return the range of matching designations
	 */
	@Override
	public List<Designation> findByGradeId(
		long gradeId, boolean deleted, int start, int end) {

		return findByGradeId(gradeId, deleted, start, end, null);
	}

	/**
	 * Returns an ordered range of all the designations where gradeId = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param gradeId the grade ID
	 * @param deleted the deleted
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching designations
	 */
	@Override
	public List<Designation> findByGradeId(
		long gradeId, boolean deleted, int start, int end,
		OrderByComparator<Designation> orderByComparator) {

		return findByGradeId(
			gradeId, deleted, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the designations where gradeId = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param gradeId the grade ID
	 * @param deleted the deleted
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching designations
	 */
	@Override
	public List<Designation> findByGradeId(
		long gradeId, boolean deleted, int start, int end,
		OrderByComparator<Designation> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGradeId;
				finderArgs = new Object[] {gradeId, deleted};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGradeId;
			finderArgs = new Object[] {
				gradeId, deleted, start, end, orderByComparator
			};
		}

		List<Designation> list = null;

		if (useFinderCache) {
			list = (List<Designation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Designation designation : list) {
					if ((gradeId != designation.getGradeId()) ||
						(deleted != designation.isDeleted())) {

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

			sb.append(_SQL_SELECT_DESIGNATION_WHERE);

			sb.append(_FINDER_COLUMN_GRADEID_GRADEID_2);

			sb.append(_FINDER_COLUMN_GRADEID_DELETED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DesignationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(gradeId);

				queryPos.add(deleted);

				list = (List<Designation>)QueryUtil.list(
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
	 * Returns the first designation in the ordered set where gradeId = &#63; and deleted = &#63;.
	 *
	 * @param gradeId the grade ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	@Override
	public Designation findByGradeId_First(
			long gradeId, boolean deleted,
			OrderByComparator<Designation> orderByComparator)
		throws NoSuchDesignationException {

		Designation designation = fetchByGradeId_First(
			gradeId, deleted, orderByComparator);

		if (designation != null) {
			return designation;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("gradeId=");
		sb.append(gradeId);

		sb.append(", deleted=");
		sb.append(deleted);

		sb.append("}");

		throw new NoSuchDesignationException(sb.toString());
	}

	/**
	 * Returns the first designation in the ordered set where gradeId = &#63; and deleted = &#63;.
	 *
	 * @param gradeId the grade ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation, or <code>null</code> if a matching designation could not be found
	 */
	@Override
	public Designation fetchByGradeId_First(
		long gradeId, boolean deleted,
		OrderByComparator<Designation> orderByComparator) {

		List<Designation> list = findByGradeId(
			gradeId, deleted, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last designation in the ordered set where gradeId = &#63; and deleted = &#63;.
	 *
	 * @param gradeId the grade ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	@Override
	public Designation findByGradeId_Last(
			long gradeId, boolean deleted,
			OrderByComparator<Designation> orderByComparator)
		throws NoSuchDesignationException {

		Designation designation = fetchByGradeId_Last(
			gradeId, deleted, orderByComparator);

		if (designation != null) {
			return designation;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("gradeId=");
		sb.append(gradeId);

		sb.append(", deleted=");
		sb.append(deleted);

		sb.append("}");

		throw new NoSuchDesignationException(sb.toString());
	}

	/**
	 * Returns the last designation in the ordered set where gradeId = &#63; and deleted = &#63;.
	 *
	 * @param gradeId the grade ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation, or <code>null</code> if a matching designation could not be found
	 */
	@Override
	public Designation fetchByGradeId_Last(
		long gradeId, boolean deleted,
		OrderByComparator<Designation> orderByComparator) {

		int count = countByGradeId(gradeId, deleted);

		if (count == 0) {
			return null;
		}

		List<Designation> list = findByGradeId(
			gradeId, deleted, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the designations before and after the current designation in the ordered set where gradeId = &#63; and deleted = &#63;.
	 *
	 * @param designationId the primary key of the current designation
	 * @param gradeId the grade ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next designation
	 * @throws NoSuchDesignationException if a designation with the primary key could not be found
	 */
	@Override
	public Designation[] findByGradeId_PrevAndNext(
			long designationId, long gradeId, boolean deleted,
			OrderByComparator<Designation> orderByComparator)
		throws NoSuchDesignationException {

		Designation designation = findByPrimaryKey(designationId);

		Session session = null;

		try {
			session = openSession();

			Designation[] array = new DesignationImpl[3];

			array[0] = getByGradeId_PrevAndNext(
				session, designation, gradeId, deleted, orderByComparator,
				true);

			array[1] = designation;

			array[2] = getByGradeId_PrevAndNext(
				session, designation, gradeId, deleted, orderByComparator,
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

	protected Designation getByGradeId_PrevAndNext(
		Session session, Designation designation, long gradeId, boolean deleted,
		OrderByComparator<Designation> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_DESIGNATION_WHERE);

		sb.append(_FINDER_COLUMN_GRADEID_GRADEID_2);

		sb.append(_FINDER_COLUMN_GRADEID_DELETED_2);

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
			sb.append(DesignationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(gradeId);

		queryPos.add(deleted);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(designation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Designation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the designations where gradeId = &#63; and deleted = &#63; from the database.
	 *
	 * @param gradeId the grade ID
	 * @param deleted the deleted
	 */
	@Override
	public void removeByGradeId(long gradeId, boolean deleted) {
		for (Designation designation :
				findByGradeId(
					gradeId, deleted, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(designation);
		}
	}

	/**
	 * Returns the number of designations where gradeId = &#63; and deleted = &#63;.
	 *
	 * @param gradeId the grade ID
	 * @param deleted the deleted
	 * @return the number of matching designations
	 */
	@Override
	public int countByGradeId(long gradeId, boolean deleted) {
		FinderPath finderPath = _finderPathCountByGradeId;

		Object[] finderArgs = new Object[] {gradeId, deleted};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DESIGNATION_WHERE);

			sb.append(_FINDER_COLUMN_GRADEID_GRADEID_2);

			sb.append(_FINDER_COLUMN_GRADEID_DELETED_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(gradeId);

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

	private static final String _FINDER_COLUMN_GRADEID_GRADEID_2 =
		"designation.gradeId = ? AND ";

	private static final String _FINDER_COLUMN_GRADEID_DELETED_2 =
		"designation.deleted = ?";

	private FinderPath _finderPathWithPaginationFindByDesignationClassId;
	private FinderPath _finderPathWithoutPaginationFindByDesignationClassId;
	private FinderPath _finderPathCountByDesignationClassId;

	/**
	 * Returns all the designations where designationClassId = &#63;.
	 *
	 * @param designationClassId the designation class ID
	 * @return the matching designations
	 */
	@Override
	public List<Designation> findByDesignationClassId(long designationClassId) {
		return findByDesignationClassId(
			designationClassId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the designations where designationClassId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param designationClassId the designation class ID
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @return the range of matching designations
	 */
	@Override
	public List<Designation> findByDesignationClassId(
		long designationClassId, int start, int end) {

		return findByDesignationClassId(designationClassId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the designations where designationClassId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param designationClassId the designation class ID
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching designations
	 */
	@Override
	public List<Designation> findByDesignationClassId(
		long designationClassId, int start, int end,
		OrderByComparator<Designation> orderByComparator) {

		return findByDesignationClassId(
			designationClassId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the designations where designationClassId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param designationClassId the designation class ID
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching designations
	 */
	@Override
	public List<Designation> findByDesignationClassId(
		long designationClassId, int start, int end,
		OrderByComparator<Designation> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByDesignationClassId;
				finderArgs = new Object[] {designationClassId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDesignationClassId;
			finderArgs = new Object[] {
				designationClassId, start, end, orderByComparator
			};
		}

		List<Designation> list = null;

		if (useFinderCache) {
			list = (List<Designation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Designation designation : list) {
					if (designationClassId !=
							designation.getDesignationClassId()) {

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

			sb.append(_SQL_SELECT_DESIGNATION_WHERE);

			sb.append(_FINDER_COLUMN_DESIGNATIONCLASSID_DESIGNATIONCLASSID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DesignationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(designationClassId);

				list = (List<Designation>)QueryUtil.list(
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
	 * Returns the first designation in the ordered set where designationClassId = &#63;.
	 *
	 * @param designationClassId the designation class ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	@Override
	public Designation findByDesignationClassId_First(
			long designationClassId,
			OrderByComparator<Designation> orderByComparator)
		throws NoSuchDesignationException {

		Designation designation = fetchByDesignationClassId_First(
			designationClassId, orderByComparator);

		if (designation != null) {
			return designation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("designationClassId=");
		sb.append(designationClassId);

		sb.append("}");

		throw new NoSuchDesignationException(sb.toString());
	}

	/**
	 * Returns the first designation in the ordered set where designationClassId = &#63;.
	 *
	 * @param designationClassId the designation class ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation, or <code>null</code> if a matching designation could not be found
	 */
	@Override
	public Designation fetchByDesignationClassId_First(
		long designationClassId,
		OrderByComparator<Designation> orderByComparator) {

		List<Designation> list = findByDesignationClassId(
			designationClassId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last designation in the ordered set where designationClassId = &#63;.
	 *
	 * @param designationClassId the designation class ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	@Override
	public Designation findByDesignationClassId_Last(
			long designationClassId,
			OrderByComparator<Designation> orderByComparator)
		throws NoSuchDesignationException {

		Designation designation = fetchByDesignationClassId_Last(
			designationClassId, orderByComparator);

		if (designation != null) {
			return designation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("designationClassId=");
		sb.append(designationClassId);

		sb.append("}");

		throw new NoSuchDesignationException(sb.toString());
	}

	/**
	 * Returns the last designation in the ordered set where designationClassId = &#63;.
	 *
	 * @param designationClassId the designation class ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation, or <code>null</code> if a matching designation could not be found
	 */
	@Override
	public Designation fetchByDesignationClassId_Last(
		long designationClassId,
		OrderByComparator<Designation> orderByComparator) {

		int count = countByDesignationClassId(designationClassId);

		if (count == 0) {
			return null;
		}

		List<Designation> list = findByDesignationClassId(
			designationClassId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the designations before and after the current designation in the ordered set where designationClassId = &#63;.
	 *
	 * @param designationId the primary key of the current designation
	 * @param designationClassId the designation class ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next designation
	 * @throws NoSuchDesignationException if a designation with the primary key could not be found
	 */
	@Override
	public Designation[] findByDesignationClassId_PrevAndNext(
			long designationId, long designationClassId,
			OrderByComparator<Designation> orderByComparator)
		throws NoSuchDesignationException {

		Designation designation = findByPrimaryKey(designationId);

		Session session = null;

		try {
			session = openSession();

			Designation[] array = new DesignationImpl[3];

			array[0] = getByDesignationClassId_PrevAndNext(
				session, designation, designationClassId, orderByComparator,
				true);

			array[1] = designation;

			array[2] = getByDesignationClassId_PrevAndNext(
				session, designation, designationClassId, orderByComparator,
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

	protected Designation getByDesignationClassId_PrevAndNext(
		Session session, Designation designation, long designationClassId,
		OrderByComparator<Designation> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DESIGNATION_WHERE);

		sb.append(_FINDER_COLUMN_DESIGNATIONCLASSID_DESIGNATIONCLASSID_2);

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
			sb.append(DesignationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(designationClassId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(designation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Designation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the designations where designationClassId = &#63; from the database.
	 *
	 * @param designationClassId the designation class ID
	 */
	@Override
	public void removeByDesignationClassId(long designationClassId) {
		for (Designation designation :
				findByDesignationClassId(
					designationClassId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(designation);
		}
	}

	/**
	 * Returns the number of designations where designationClassId = &#63;.
	 *
	 * @param designationClassId the designation class ID
	 * @return the number of matching designations
	 */
	@Override
	public int countByDesignationClassId(long designationClassId) {
		FinderPath finderPath = _finderPathCountByDesignationClassId;

		Object[] finderArgs = new Object[] {designationClassId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DESIGNATION_WHERE);

			sb.append(_FINDER_COLUMN_DESIGNATIONCLASSID_DESIGNATIONCLASSID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(designationClassId);

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
		_FINDER_COLUMN_DESIGNATIONCLASSID_DESIGNATIONCLASSID_2 =
			"designation.designationClassId = ?";

	private FinderPath _finderPathWithPaginationFindByDesignationGroupId;
	private FinderPath _finderPathWithoutPaginationFindByDesignationGroupId;
	private FinderPath _finderPathCountByDesignationGroupId;

	/**
	 * Returns all the designations where designationGroupId = &#63;.
	 *
	 * @param designationGroupId the designation group ID
	 * @return the matching designations
	 */
	@Override
	public List<Designation> findByDesignationGroupId(long designationGroupId) {
		return findByDesignationGroupId(
			designationGroupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the designations where designationGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param designationGroupId the designation group ID
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @return the range of matching designations
	 */
	@Override
	public List<Designation> findByDesignationGroupId(
		long designationGroupId, int start, int end) {

		return findByDesignationGroupId(designationGroupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the designations where designationGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param designationGroupId the designation group ID
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching designations
	 */
	@Override
	public List<Designation> findByDesignationGroupId(
		long designationGroupId, int start, int end,
		OrderByComparator<Designation> orderByComparator) {

		return findByDesignationGroupId(
			designationGroupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the designations where designationGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param designationGroupId the designation group ID
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching designations
	 */
	@Override
	public List<Designation> findByDesignationGroupId(
		long designationGroupId, int start, int end,
		OrderByComparator<Designation> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByDesignationGroupId;
				finderArgs = new Object[] {designationGroupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDesignationGroupId;
			finderArgs = new Object[] {
				designationGroupId, start, end, orderByComparator
			};
		}

		List<Designation> list = null;

		if (useFinderCache) {
			list = (List<Designation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Designation designation : list) {
					if (designationGroupId !=
							designation.getDesignationGroupId()) {

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

			sb.append(_SQL_SELECT_DESIGNATION_WHERE);

			sb.append(_FINDER_COLUMN_DESIGNATIONGROUPID_DESIGNATIONGROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DesignationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(designationGroupId);

				list = (List<Designation>)QueryUtil.list(
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
	 * Returns the first designation in the ordered set where designationGroupId = &#63;.
	 *
	 * @param designationGroupId the designation group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	@Override
	public Designation findByDesignationGroupId_First(
			long designationGroupId,
			OrderByComparator<Designation> orderByComparator)
		throws NoSuchDesignationException {

		Designation designation = fetchByDesignationGroupId_First(
			designationGroupId, orderByComparator);

		if (designation != null) {
			return designation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("designationGroupId=");
		sb.append(designationGroupId);

		sb.append("}");

		throw new NoSuchDesignationException(sb.toString());
	}

	/**
	 * Returns the first designation in the ordered set where designationGroupId = &#63;.
	 *
	 * @param designationGroupId the designation group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation, or <code>null</code> if a matching designation could not be found
	 */
	@Override
	public Designation fetchByDesignationGroupId_First(
		long designationGroupId,
		OrderByComparator<Designation> orderByComparator) {

		List<Designation> list = findByDesignationGroupId(
			designationGroupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last designation in the ordered set where designationGroupId = &#63;.
	 *
	 * @param designationGroupId the designation group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	@Override
	public Designation findByDesignationGroupId_Last(
			long designationGroupId,
			OrderByComparator<Designation> orderByComparator)
		throws NoSuchDesignationException {

		Designation designation = fetchByDesignationGroupId_Last(
			designationGroupId, orderByComparator);

		if (designation != null) {
			return designation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("designationGroupId=");
		sb.append(designationGroupId);

		sb.append("}");

		throw new NoSuchDesignationException(sb.toString());
	}

	/**
	 * Returns the last designation in the ordered set where designationGroupId = &#63;.
	 *
	 * @param designationGroupId the designation group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation, or <code>null</code> if a matching designation could not be found
	 */
	@Override
	public Designation fetchByDesignationGroupId_Last(
		long designationGroupId,
		OrderByComparator<Designation> orderByComparator) {

		int count = countByDesignationGroupId(designationGroupId);

		if (count == 0) {
			return null;
		}

		List<Designation> list = findByDesignationGroupId(
			designationGroupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the designations before and after the current designation in the ordered set where designationGroupId = &#63;.
	 *
	 * @param designationId the primary key of the current designation
	 * @param designationGroupId the designation group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next designation
	 * @throws NoSuchDesignationException if a designation with the primary key could not be found
	 */
	@Override
	public Designation[] findByDesignationGroupId_PrevAndNext(
			long designationId, long designationGroupId,
			OrderByComparator<Designation> orderByComparator)
		throws NoSuchDesignationException {

		Designation designation = findByPrimaryKey(designationId);

		Session session = null;

		try {
			session = openSession();

			Designation[] array = new DesignationImpl[3];

			array[0] = getByDesignationGroupId_PrevAndNext(
				session, designation, designationGroupId, orderByComparator,
				true);

			array[1] = designation;

			array[2] = getByDesignationGroupId_PrevAndNext(
				session, designation, designationGroupId, orderByComparator,
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

	protected Designation getByDesignationGroupId_PrevAndNext(
		Session session, Designation designation, long designationGroupId,
		OrderByComparator<Designation> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DESIGNATION_WHERE);

		sb.append(_FINDER_COLUMN_DESIGNATIONGROUPID_DESIGNATIONGROUPID_2);

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
			sb.append(DesignationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(designationGroupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(designation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Designation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the designations where designationGroupId = &#63; from the database.
	 *
	 * @param designationGroupId the designation group ID
	 */
	@Override
	public void removeByDesignationGroupId(long designationGroupId) {
		for (Designation designation :
				findByDesignationGroupId(
					designationGroupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(designation);
		}
	}

	/**
	 * Returns the number of designations where designationGroupId = &#63;.
	 *
	 * @param designationGroupId the designation group ID
	 * @return the number of matching designations
	 */
	@Override
	public int countByDesignationGroupId(long designationGroupId) {
		FinderPath finderPath = _finderPathCountByDesignationGroupId;

		Object[] finderArgs = new Object[] {designationGroupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DESIGNATION_WHERE);

			sb.append(_FINDER_COLUMN_DESIGNATIONGROUPID_DESIGNATIONGROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(designationGroupId);

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
		_FINDER_COLUMN_DESIGNATIONGROUPID_DESIGNATIONGROUPID_2 =
			"designation.designationGroupId = ?";

	private FinderPath
		_finderPathWithPaginationFindByDesignationGroupIdAndDeleted;
	private FinderPath
		_finderPathWithoutPaginationFindByDesignationGroupIdAndDeleted;
	private FinderPath _finderPathCountByDesignationGroupIdAndDeleted;

	/**
	 * Returns all the designations where designationGroupId = &#63; and deleted = &#63;.
	 *
	 * @param designationGroupId the designation group ID
	 * @param deleted the deleted
	 * @return the matching designations
	 */
	@Override
	public List<Designation> findByDesignationGroupIdAndDeleted(
		long designationGroupId, boolean deleted) {

		return findByDesignationGroupIdAndDeleted(
			designationGroupId, deleted, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the designations where designationGroupId = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param designationGroupId the designation group ID
	 * @param deleted the deleted
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @return the range of matching designations
	 */
	@Override
	public List<Designation> findByDesignationGroupIdAndDeleted(
		long designationGroupId, boolean deleted, int start, int end) {

		return findByDesignationGroupIdAndDeleted(
			designationGroupId, deleted, start, end, null);
	}

	/**
	 * Returns an ordered range of all the designations where designationGroupId = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param designationGroupId the designation group ID
	 * @param deleted the deleted
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching designations
	 */
	@Override
	public List<Designation> findByDesignationGroupIdAndDeleted(
		long designationGroupId, boolean deleted, int start, int end,
		OrderByComparator<Designation> orderByComparator) {

		return findByDesignationGroupIdAndDeleted(
			designationGroupId, deleted, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the designations where designationGroupId = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param designationGroupId the designation group ID
	 * @param deleted the deleted
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching designations
	 */
	@Override
	public List<Designation> findByDesignationGroupIdAndDeleted(
		long designationGroupId, boolean deleted, int start, int end,
		OrderByComparator<Designation> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByDesignationGroupIdAndDeleted;
				finderArgs = new Object[] {designationGroupId, deleted};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByDesignationGroupIdAndDeleted;
			finderArgs = new Object[] {
				designationGroupId, deleted, start, end, orderByComparator
			};
		}

		List<Designation> list = null;

		if (useFinderCache) {
			list = (List<Designation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Designation designation : list) {
					if ((designationGroupId !=
							designation.getDesignationGroupId()) ||
						(deleted != designation.isDeleted())) {

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

			sb.append(_SQL_SELECT_DESIGNATION_WHERE);

			sb.append(
				_FINDER_COLUMN_DESIGNATIONGROUPIDANDDELETED_DESIGNATIONGROUPID_2);

			sb.append(_FINDER_COLUMN_DESIGNATIONGROUPIDANDDELETED_DELETED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DesignationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(designationGroupId);

				queryPos.add(deleted);

				list = (List<Designation>)QueryUtil.list(
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
	 * Returns the first designation in the ordered set where designationGroupId = &#63; and deleted = &#63;.
	 *
	 * @param designationGroupId the designation group ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	@Override
	public Designation findByDesignationGroupIdAndDeleted_First(
			long designationGroupId, boolean deleted,
			OrderByComparator<Designation> orderByComparator)
		throws NoSuchDesignationException {

		Designation designation = fetchByDesignationGroupIdAndDeleted_First(
			designationGroupId, deleted, orderByComparator);

		if (designation != null) {
			return designation;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("designationGroupId=");
		sb.append(designationGroupId);

		sb.append(", deleted=");
		sb.append(deleted);

		sb.append("}");

		throw new NoSuchDesignationException(sb.toString());
	}

	/**
	 * Returns the first designation in the ordered set where designationGroupId = &#63; and deleted = &#63;.
	 *
	 * @param designationGroupId the designation group ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation, or <code>null</code> if a matching designation could not be found
	 */
	@Override
	public Designation fetchByDesignationGroupIdAndDeleted_First(
		long designationGroupId, boolean deleted,
		OrderByComparator<Designation> orderByComparator) {

		List<Designation> list = findByDesignationGroupIdAndDeleted(
			designationGroupId, deleted, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last designation in the ordered set where designationGroupId = &#63; and deleted = &#63;.
	 *
	 * @param designationGroupId the designation group ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	@Override
	public Designation findByDesignationGroupIdAndDeleted_Last(
			long designationGroupId, boolean deleted,
			OrderByComparator<Designation> orderByComparator)
		throws NoSuchDesignationException {

		Designation designation = fetchByDesignationGroupIdAndDeleted_Last(
			designationGroupId, deleted, orderByComparator);

		if (designation != null) {
			return designation;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("designationGroupId=");
		sb.append(designationGroupId);

		sb.append(", deleted=");
		sb.append(deleted);

		sb.append("}");

		throw new NoSuchDesignationException(sb.toString());
	}

	/**
	 * Returns the last designation in the ordered set where designationGroupId = &#63; and deleted = &#63;.
	 *
	 * @param designationGroupId the designation group ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation, or <code>null</code> if a matching designation could not be found
	 */
	@Override
	public Designation fetchByDesignationGroupIdAndDeleted_Last(
		long designationGroupId, boolean deleted,
		OrderByComparator<Designation> orderByComparator) {

		int count = countByDesignationGroupIdAndDeleted(
			designationGroupId, deleted);

		if (count == 0) {
			return null;
		}

		List<Designation> list = findByDesignationGroupIdAndDeleted(
			designationGroupId, deleted, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the designations before and after the current designation in the ordered set where designationGroupId = &#63; and deleted = &#63;.
	 *
	 * @param designationId the primary key of the current designation
	 * @param designationGroupId the designation group ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next designation
	 * @throws NoSuchDesignationException if a designation with the primary key could not be found
	 */
	@Override
	public Designation[] findByDesignationGroupIdAndDeleted_PrevAndNext(
			long designationId, long designationGroupId, boolean deleted,
			OrderByComparator<Designation> orderByComparator)
		throws NoSuchDesignationException {

		Designation designation = findByPrimaryKey(designationId);

		Session session = null;

		try {
			session = openSession();

			Designation[] array = new DesignationImpl[3];

			array[0] = getByDesignationGroupIdAndDeleted_PrevAndNext(
				session, designation, designationGroupId, deleted,
				orderByComparator, true);

			array[1] = designation;

			array[2] = getByDesignationGroupIdAndDeleted_PrevAndNext(
				session, designation, designationGroupId, deleted,
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

	protected Designation getByDesignationGroupIdAndDeleted_PrevAndNext(
		Session session, Designation designation, long designationGroupId,
		boolean deleted, OrderByComparator<Designation> orderByComparator,
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

		sb.append(_SQL_SELECT_DESIGNATION_WHERE);

		sb.append(
			_FINDER_COLUMN_DESIGNATIONGROUPIDANDDELETED_DESIGNATIONGROUPID_2);

		sb.append(_FINDER_COLUMN_DESIGNATIONGROUPIDANDDELETED_DELETED_2);

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
			sb.append(DesignationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(designationGroupId);

		queryPos.add(deleted);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(designation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Designation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the designations where designationGroupId = &#63; and deleted = &#63; from the database.
	 *
	 * @param designationGroupId the designation group ID
	 * @param deleted the deleted
	 */
	@Override
	public void removeByDesignationGroupIdAndDeleted(
		long designationGroupId, boolean deleted) {

		for (Designation designation :
				findByDesignationGroupIdAndDeleted(
					designationGroupId, deleted, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(designation);
		}
	}

	/**
	 * Returns the number of designations where designationGroupId = &#63; and deleted = &#63;.
	 *
	 * @param designationGroupId the designation group ID
	 * @param deleted the deleted
	 * @return the number of matching designations
	 */
	@Override
	public int countByDesignationGroupIdAndDeleted(
		long designationGroupId, boolean deleted) {

		FinderPath finderPath = _finderPathCountByDesignationGroupIdAndDeleted;

		Object[] finderArgs = new Object[] {designationGroupId, deleted};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DESIGNATION_WHERE);

			sb.append(
				_FINDER_COLUMN_DESIGNATIONGROUPIDANDDELETED_DESIGNATIONGROUPID_2);

			sb.append(_FINDER_COLUMN_DESIGNATIONGROUPIDANDDELETED_DELETED_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(designationGroupId);

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
		_FINDER_COLUMN_DESIGNATIONGROUPIDANDDELETED_DESIGNATIONGROUPID_2 =
			"designation.designationGroupId = ? AND ";

	private static final String
		_FINDER_COLUMN_DESIGNATIONGROUPIDANDDELETED_DELETED_2 =
			"designation.deleted = ?";

	private FinderPath _finderPathWithPaginationFindByStatus;
	private FinderPath _finderPathWithoutPaginationFindByStatus;
	private FinderPath _finderPathCountByStatus;

	/**
	 * Returns all the designations where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching designations
	 */
	@Override
	public List<Designation> findByStatus(int status) {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the designations where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @return the range of matching designations
	 */
	@Override
	public List<Designation> findByStatus(int status, int start, int end) {
		return findByStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the designations where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching designations
	 */
	@Override
	public List<Designation> findByStatus(
		int status, int start, int end,
		OrderByComparator<Designation> orderByComparator) {

		return findByStatus(status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the designations where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching designations
	 */
	@Override
	public List<Designation> findByStatus(
		int status, int start, int end,
		OrderByComparator<Designation> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByStatus;
				finderArgs = new Object[] {status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByStatus;
			finderArgs = new Object[] {status, start, end, orderByComparator};
		}

		List<Designation> list = null;

		if (useFinderCache) {
			list = (List<Designation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Designation designation : list) {
					if (status != designation.getStatus()) {
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

			sb.append(_SQL_SELECT_DESIGNATION_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DesignationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

				list = (List<Designation>)QueryUtil.list(
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
	 * Returns the first designation in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	@Override
	public Designation findByStatus_First(
			int status, OrderByComparator<Designation> orderByComparator)
		throws NoSuchDesignationException {

		Designation designation = fetchByStatus_First(
			status, orderByComparator);

		if (designation != null) {
			return designation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchDesignationException(sb.toString());
	}

	/**
	 * Returns the first designation in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation, or <code>null</code> if a matching designation could not be found
	 */
	@Override
	public Designation fetchByStatus_First(
		int status, OrderByComparator<Designation> orderByComparator) {

		List<Designation> list = findByStatus(status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last designation in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	@Override
	public Designation findByStatus_Last(
			int status, OrderByComparator<Designation> orderByComparator)
		throws NoSuchDesignationException {

		Designation designation = fetchByStatus_Last(status, orderByComparator);

		if (designation != null) {
			return designation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchDesignationException(sb.toString());
	}

	/**
	 * Returns the last designation in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation, or <code>null</code> if a matching designation could not be found
	 */
	@Override
	public Designation fetchByStatus_Last(
		int status, OrderByComparator<Designation> orderByComparator) {

		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<Designation> list = findByStatus(
			status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the designations before and after the current designation in the ordered set where status = &#63;.
	 *
	 * @param designationId the primary key of the current designation
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next designation
	 * @throws NoSuchDesignationException if a designation with the primary key could not be found
	 */
	@Override
	public Designation[] findByStatus_PrevAndNext(
			long designationId, int status,
			OrderByComparator<Designation> orderByComparator)
		throws NoSuchDesignationException {

		Designation designation = findByPrimaryKey(designationId);

		Session session = null;

		try {
			session = openSession();

			Designation[] array = new DesignationImpl[3];

			array[0] = getByStatus_PrevAndNext(
				session, designation, status, orderByComparator, true);

			array[1] = designation;

			array[2] = getByStatus_PrevAndNext(
				session, designation, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Designation getByStatus_PrevAndNext(
		Session session, Designation designation, int status,
		OrderByComparator<Designation> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DESIGNATION_WHERE);

		sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

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
			sb.append(DesignationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(designation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Designation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the designations where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	@Override
	public void removeByStatus(int status) {
		for (Designation designation :
				findByStatus(
					status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(designation);
		}
	}

	/**
	 * Returns the number of designations where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching designations
	 */
	@Override
	public int countByStatus(int status) {
		FinderPath finderPath = _finderPathCountByStatus;

		Object[] finderArgs = new Object[] {status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DESIGNATION_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

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

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 =
		"designation.status = ?";

	private FinderPath _finderPathWithPaginationFindByDesignationGroup;
	private FinderPath _finderPathWithoutPaginationFindByDesignationGroup;
	private FinderPath _finderPathCountByDesignationGroup;

	/**
	 * Returns all the designations where designationGroup = &#63; and status = &#63;.
	 *
	 * @param designationGroup the designation group
	 * @param status the status
	 * @return the matching designations
	 */
	@Override
	public List<Designation> findByDesignationGroup(
		String designationGroup, int status) {

		return findByDesignationGroup(
			designationGroup, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the designations where designationGroup = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param designationGroup the designation group
	 * @param status the status
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @return the range of matching designations
	 */
	@Override
	public List<Designation> findByDesignationGroup(
		String designationGroup, int status, int start, int end) {

		return findByDesignationGroup(
			designationGroup, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the designations where designationGroup = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param designationGroup the designation group
	 * @param status the status
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching designations
	 */
	@Override
	public List<Designation> findByDesignationGroup(
		String designationGroup, int status, int start, int end,
		OrderByComparator<Designation> orderByComparator) {

		return findByDesignationGroup(
			designationGroup, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the designations where designationGroup = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param designationGroup the designation group
	 * @param status the status
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching designations
	 */
	@Override
	public List<Designation> findByDesignationGroup(
		String designationGroup, int status, int start, int end,
		OrderByComparator<Designation> orderByComparator,
		boolean useFinderCache) {

		designationGroup = Objects.toString(designationGroup, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDesignationGroup;
				finderArgs = new Object[] {designationGroup, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDesignationGroup;
			finderArgs = new Object[] {
				designationGroup, status, start, end, orderByComparator
			};
		}

		List<Designation> list = null;

		if (useFinderCache) {
			list = (List<Designation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Designation designation : list) {
					if (!designationGroup.equals(
							designation.getDesignationGroup()) ||
						(status != designation.getStatus())) {

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

			sb.append(_SQL_SELECT_DESIGNATION_WHERE);

			boolean bindDesignationGroup = false;

			if (designationGroup.isEmpty()) {
				sb.append(_FINDER_COLUMN_DESIGNATIONGROUP_DESIGNATIONGROUP_3);
			}
			else {
				bindDesignationGroup = true;

				sb.append(_FINDER_COLUMN_DESIGNATIONGROUP_DESIGNATIONGROUP_2);
			}

			sb.append(_FINDER_COLUMN_DESIGNATIONGROUP_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DesignationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDesignationGroup) {
					queryPos.add(designationGroup);
				}

				queryPos.add(status);

				list = (List<Designation>)QueryUtil.list(
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
	 * Returns the first designation in the ordered set where designationGroup = &#63; and status = &#63;.
	 *
	 * @param designationGroup the designation group
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	@Override
	public Designation findByDesignationGroup_First(
			String designationGroup, int status,
			OrderByComparator<Designation> orderByComparator)
		throws NoSuchDesignationException {

		Designation designation = fetchByDesignationGroup_First(
			designationGroup, status, orderByComparator);

		if (designation != null) {
			return designation;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("designationGroup=");
		sb.append(designationGroup);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchDesignationException(sb.toString());
	}

	/**
	 * Returns the first designation in the ordered set where designationGroup = &#63; and status = &#63;.
	 *
	 * @param designationGroup the designation group
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation, or <code>null</code> if a matching designation could not be found
	 */
	@Override
	public Designation fetchByDesignationGroup_First(
		String designationGroup, int status,
		OrderByComparator<Designation> orderByComparator) {

		List<Designation> list = findByDesignationGroup(
			designationGroup, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last designation in the ordered set where designationGroup = &#63; and status = &#63;.
	 *
	 * @param designationGroup the designation group
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	@Override
	public Designation findByDesignationGroup_Last(
			String designationGroup, int status,
			OrderByComparator<Designation> orderByComparator)
		throws NoSuchDesignationException {

		Designation designation = fetchByDesignationGroup_Last(
			designationGroup, status, orderByComparator);

		if (designation != null) {
			return designation;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("designationGroup=");
		sb.append(designationGroup);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchDesignationException(sb.toString());
	}

	/**
	 * Returns the last designation in the ordered set where designationGroup = &#63; and status = &#63;.
	 *
	 * @param designationGroup the designation group
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation, or <code>null</code> if a matching designation could not be found
	 */
	@Override
	public Designation fetchByDesignationGroup_Last(
		String designationGroup, int status,
		OrderByComparator<Designation> orderByComparator) {

		int count = countByDesignationGroup(designationGroup, status);

		if (count == 0) {
			return null;
		}

		List<Designation> list = findByDesignationGroup(
			designationGroup, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the designations before and after the current designation in the ordered set where designationGroup = &#63; and status = &#63;.
	 *
	 * @param designationId the primary key of the current designation
	 * @param designationGroup the designation group
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next designation
	 * @throws NoSuchDesignationException if a designation with the primary key could not be found
	 */
	@Override
	public Designation[] findByDesignationGroup_PrevAndNext(
			long designationId, String designationGroup, int status,
			OrderByComparator<Designation> orderByComparator)
		throws NoSuchDesignationException {

		designationGroup = Objects.toString(designationGroup, "");

		Designation designation = findByPrimaryKey(designationId);

		Session session = null;

		try {
			session = openSession();

			Designation[] array = new DesignationImpl[3];

			array[0] = getByDesignationGroup_PrevAndNext(
				session, designation, designationGroup, status,
				orderByComparator, true);

			array[1] = designation;

			array[2] = getByDesignationGroup_PrevAndNext(
				session, designation, designationGroup, status,
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

	protected Designation getByDesignationGroup_PrevAndNext(
		Session session, Designation designation, String designationGroup,
		int status, OrderByComparator<Designation> orderByComparator,
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

		sb.append(_SQL_SELECT_DESIGNATION_WHERE);

		boolean bindDesignationGroup = false;

		if (designationGroup.isEmpty()) {
			sb.append(_FINDER_COLUMN_DESIGNATIONGROUP_DESIGNATIONGROUP_3);
		}
		else {
			bindDesignationGroup = true;

			sb.append(_FINDER_COLUMN_DESIGNATIONGROUP_DESIGNATIONGROUP_2);
		}

		sb.append(_FINDER_COLUMN_DESIGNATIONGROUP_STATUS_2);

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
			sb.append(DesignationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindDesignationGroup) {
			queryPos.add(designationGroup);
		}

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(designation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Designation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the designations where designationGroup = &#63; and status = &#63; from the database.
	 *
	 * @param designationGroup the designation group
	 * @param status the status
	 */
	@Override
	public void removeByDesignationGroup(String designationGroup, int status) {
		for (Designation designation :
				findByDesignationGroup(
					designationGroup, status, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(designation);
		}
	}

	/**
	 * Returns the number of designations where designationGroup = &#63; and status = &#63;.
	 *
	 * @param designationGroup the designation group
	 * @param status the status
	 * @return the number of matching designations
	 */
	@Override
	public int countByDesignationGroup(String designationGroup, int status) {
		designationGroup = Objects.toString(designationGroup, "");

		FinderPath finderPath = _finderPathCountByDesignationGroup;

		Object[] finderArgs = new Object[] {designationGroup, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DESIGNATION_WHERE);

			boolean bindDesignationGroup = false;

			if (designationGroup.isEmpty()) {
				sb.append(_FINDER_COLUMN_DESIGNATIONGROUP_DESIGNATIONGROUP_3);
			}
			else {
				bindDesignationGroup = true;

				sb.append(_FINDER_COLUMN_DESIGNATIONGROUP_DESIGNATIONGROUP_2);
			}

			sb.append(_FINDER_COLUMN_DESIGNATIONGROUP_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDesignationGroup) {
					queryPos.add(designationGroup);
				}

				queryPos.add(status);

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
		_FINDER_COLUMN_DESIGNATIONGROUP_DESIGNATIONGROUP_2 =
			"designation.designationGroup = ? AND ";

	private static final String
		_FINDER_COLUMN_DESIGNATIONGROUP_DESIGNATIONGROUP_3 =
			"(designation.designationGroup IS NULL OR designation.designationGroup = '') AND ";

	private static final String _FINDER_COLUMN_DESIGNATIONGROUP_STATUS_2 =
		"designation.status = ?";

	public DesignationPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("code", "code_");
		dbColumnNames.put("rank", "rank_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Designation.class);

		setModelImplClass(DesignationImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the designation in the entity cache if it is enabled.
	 *
	 * @param designation the designation
	 */
	@Override
	public void cacheResult(Designation designation) {
		entityCache.putResult(
			DesignationImpl.class, designation.getPrimaryKey(), designation);

		finderCache.putResult(
			_finderPathFetchByCode, new Object[] {designation.getCode()},
			designation);
	}

	/**
	 * Caches the designations in the entity cache if it is enabled.
	 *
	 * @param designations the designations
	 */
	@Override
	public void cacheResult(List<Designation> designations) {
		for (Designation designation : designations) {
			if (entityCache.getResult(
					DesignationImpl.class, designation.getPrimaryKey()) ==
						null) {

				cacheResult(designation);
			}
		}
	}

	/**
	 * Clears the cache for all designations.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DesignationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the designation.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Designation designation) {
		entityCache.removeResult(DesignationImpl.class, designation);
	}

	@Override
	public void clearCache(List<Designation> designations) {
		for (Designation designation : designations) {
			entityCache.removeResult(DesignationImpl.class, designation);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DesignationImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DesignationModelImpl designationModelImpl) {

		Object[] args = new Object[] {designationModelImpl.getCode()};

		finderCache.putResult(
			_finderPathCountByCode, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByCode, args, designationModelImpl, false);
	}

	/**
	 * Creates a new designation with the primary key. Does not add the designation to the database.
	 *
	 * @param designationId the primary key for the new designation
	 * @return the new designation
	 */
	@Override
	public Designation create(long designationId) {
		Designation designation = new DesignationImpl();

		designation.setNew(true);
		designation.setPrimaryKey(designationId);

		designation.setCompanyId(CompanyThreadLocal.getCompanyId());

		return designation;
	}

	/**
	 * Removes the designation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param designationId the primary key of the designation
	 * @return the designation that was removed
	 * @throws NoSuchDesignationException if a designation with the primary key could not be found
	 */
	@Override
	public Designation remove(long designationId)
		throws NoSuchDesignationException {

		return remove((Serializable)designationId);
	}

	/**
	 * Removes the designation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the designation
	 * @return the designation that was removed
	 * @throws NoSuchDesignationException if a designation with the primary key could not be found
	 */
	@Override
	public Designation remove(Serializable primaryKey)
		throws NoSuchDesignationException {

		Session session = null;

		try {
			session = openSession();

			Designation designation = (Designation)session.get(
				DesignationImpl.class, primaryKey);

			if (designation == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDesignationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(designation);
		}
		catch (NoSuchDesignationException noSuchEntityException) {
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
	protected Designation removeImpl(Designation designation) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(designation)) {
				designation = (Designation)session.get(
					DesignationImpl.class, designation.getPrimaryKeyObj());
			}

			if (designation != null) {
				session.delete(designation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (designation != null) {
			clearCache(designation);
		}

		return designation;
	}

	@Override
	public Designation updateImpl(Designation designation) {
		boolean isNew = designation.isNew();

		if (!(designation instanceof DesignationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(designation.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(designation);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in designation proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Designation implementation " +
					designation.getClass());
		}

		DesignationModelImpl designationModelImpl =
			(DesignationModelImpl)designation;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (designation.getCreateDate() == null)) {
			if (serviceContext == null) {
				designation.setCreateDate(now);
			}
			else {
				designation.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!designationModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				designation.setModifiedDate(now);
			}
			else {
				designation.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(designation);
			}
			else {
				designation = (Designation)session.merge(designation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DesignationImpl.class, designationModelImpl, false, true);

		cacheUniqueFindersCache(designationModelImpl);

		if (isNew) {
			designation.setNew(false);
		}

		designation.resetOriginalValues();

		return designation;
	}

	/**
	 * Returns the designation with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the designation
	 * @return the designation
	 * @throws NoSuchDesignationException if a designation with the primary key could not be found
	 */
	@Override
	public Designation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDesignationException {

		Designation designation = fetchByPrimaryKey(primaryKey);

		if (designation == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDesignationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return designation;
	}

	/**
	 * Returns the designation with the primary key or throws a <code>NoSuchDesignationException</code> if it could not be found.
	 *
	 * @param designationId the primary key of the designation
	 * @return the designation
	 * @throws NoSuchDesignationException if a designation with the primary key could not be found
	 */
	@Override
	public Designation findByPrimaryKey(long designationId)
		throws NoSuchDesignationException {

		return findByPrimaryKey((Serializable)designationId);
	}

	/**
	 * Returns the designation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param designationId the primary key of the designation
	 * @return the designation, or <code>null</code> if a designation with the primary key could not be found
	 */
	@Override
	public Designation fetchByPrimaryKey(long designationId) {
		return fetchByPrimaryKey((Serializable)designationId);
	}

	/**
	 * Returns all the designations.
	 *
	 * @return the designations
	 */
	@Override
	public List<Designation> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the designations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @return the range of designations
	 */
	@Override
	public List<Designation> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the designations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of designations
	 */
	@Override
	public List<Designation> findAll(
		int start, int end, OrderByComparator<Designation> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the designations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of designations
	 */
	@Override
	public List<Designation> findAll(
		int start, int end, OrderByComparator<Designation> orderByComparator,
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

		List<Designation> list = null;

		if (useFinderCache) {
			list = (List<Designation>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DESIGNATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DESIGNATION;

				sql = sql.concat(DesignationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Designation>)QueryUtil.list(
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
	 * Removes all the designations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Designation designation : findAll()) {
			remove(designation);
		}
	}

	/**
	 * Returns the number of designations.
	 *
	 * @return the number of designations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DESIGNATION);

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
		return "designationId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DESIGNATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DesignationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the designation persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new DesignationModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", Designation.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathFetchByCode = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByCode",
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
			new String[] {"name_En"}, true);

		_finderPathWithoutPaginationFindByName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByName",
			new String[] {String.class.getName()}, new String[] {"name_En"},
			true);

		_finderPathCountByName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] {String.class.getName()}, new String[] {"name_En"},
			false);

		_finderPathWithPaginationFindByGradeId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGradeId",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"gradeId", "deleted"}, true);

		_finderPathWithoutPaginationFindByGradeId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGradeId",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"gradeId", "deleted"}, true);

		_finderPathCountByGradeId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGradeId",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"gradeId", "deleted"}, false);

		_finderPathWithPaginationFindByDesignationClassId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDesignationClassId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"designationClassId"}, true);

		_finderPathWithoutPaginationFindByDesignationClassId =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByDesignationClassId", new String[] {Long.class.getName()},
				new String[] {"designationClassId"}, true);

		_finderPathCountByDesignationClassId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDesignationClassId", new String[] {Long.class.getName()},
			new String[] {"designationClassId"}, false);

		_finderPathWithPaginationFindByDesignationGroupId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDesignationGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"designationGroupId"}, true);

		_finderPathWithoutPaginationFindByDesignationGroupId =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByDesignationGroupId", new String[] {Long.class.getName()},
				new String[] {"designationGroupId"}, true);

		_finderPathCountByDesignationGroupId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDesignationGroupId", new String[] {Long.class.getName()},
			new String[] {"designationGroupId"}, false);

		_finderPathWithPaginationFindByDesignationGroupIdAndDeleted =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByDesignationGroupIdAndDeleted",
				new String[] {
					Long.class.getName(), Boolean.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {"designationGroupId", "deleted"}, true);

		_finderPathWithoutPaginationFindByDesignationGroupIdAndDeleted =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByDesignationGroupIdAndDeleted",
				new String[] {Long.class.getName(), Boolean.class.getName()},
				new String[] {"designationGroupId", "deleted"}, true);

		_finderPathCountByDesignationGroupIdAndDeleted = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDesignationGroupIdAndDeleted",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"designationGroupId", "deleted"}, false);

		_finderPathWithPaginationFindByStatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"status"}, true);

		_finderPathWithoutPaginationFindByStatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] {Integer.class.getName()}, new String[] {"status"},
			true);

		_finderPathCountByStatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] {Integer.class.getName()}, new String[] {"status"},
			false);

		_finderPathWithPaginationFindByDesignationGroup = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDesignationGroup",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"designationGroup", "status"}, true);

		_finderPathWithoutPaginationFindByDesignationGroup = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDesignationGroup",
			new String[] {String.class.getName(), Integer.class.getName()},
			new String[] {"designationGroup", "status"}, true);

		_finderPathCountByDesignationGroup = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDesignationGroup",
			new String[] {String.class.getName(), Integer.class.getName()},
			new String[] {"designationGroup", "status"}, false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(DesignationImpl.class.getName());

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

	private static final String _SQL_SELECT_DESIGNATION =
		"SELECT designation FROM Designation designation";

	private static final String _SQL_SELECT_DESIGNATION_WHERE =
		"SELECT designation FROM Designation designation WHERE ";

	private static final String _SQL_COUNT_DESIGNATION =
		"SELECT COUNT(designation) FROM Designation designation";

	private static final String _SQL_COUNT_DESIGNATION_WHERE =
		"SELECT COUNT(designation) FROM Designation designation WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "designation.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Designation exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Designation exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DesignationPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"code", "rank"});

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

	private static class DesignationModelArgumentsResolver
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

			DesignationModelImpl designationModelImpl =
				(DesignationModelImpl)baseModel;

			long columnBitmask = designationModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(designationModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						designationModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(designationModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			DesignationModelImpl designationModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = designationModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = designationModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}