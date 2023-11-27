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

import com.adjecti.mdm.liferay.exception.NoSuchQualificationLevelException;
import com.adjecti.mdm.liferay.model.QualificationLevel;
import com.adjecti.mdm.liferay.model.impl.QualificationLevelImpl;
import com.adjecti.mdm.liferay.model.impl.QualificationLevelModelImpl;
import com.adjecti.mdm.liferay.service.persistence.QualificationLevelPersistence;
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
 * The persistence implementation for the qualification level service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = QualificationLevelPersistence.class)
public class QualificationLevelPersistenceImpl
	extends BasePersistenceImpl<QualificationLevel>
	implements QualificationLevelPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>QualificationLevelUtil</code> to access the qualification level persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		QualificationLevelImpl.class.getName();

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
	 * Returns all the qualification levels where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching qualification levels
	 */
	@Override
	public List<QualificationLevel> findByCode(String code) {
		return findByCode(code, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the qualification levels where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationLevelModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of qualification levels
	 * @param end the upper bound of the range of qualification levels (not inclusive)
	 * @return the range of matching qualification levels
	 */
	@Override
	public List<QualificationLevel> findByCode(
		String code, int start, int end) {

		return findByCode(code, start, end, null);
	}

	/**
	 * Returns an ordered range of all the qualification levels where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationLevelModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of qualification levels
	 * @param end the upper bound of the range of qualification levels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching qualification levels
	 */
	@Override
	public List<QualificationLevel> findByCode(
		String code, int start, int end,
		OrderByComparator<QualificationLevel> orderByComparator) {

		return findByCode(code, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the qualification levels where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationLevelModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of qualification levels
	 * @param end the upper bound of the range of qualification levels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching qualification levels
	 */
	@Override
	public List<QualificationLevel> findByCode(
		String code, int start, int end,
		OrderByComparator<QualificationLevel> orderByComparator,
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

		List<QualificationLevel> list = null;

		if (useFinderCache) {
			list = (List<QualificationLevel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (QualificationLevel qualificationLevel : list) {
					if (!code.equals(qualificationLevel.getCode())) {
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

			sb.append(_SQL_SELECT_QUALIFICATIONLEVEL_WHERE);

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
				sb.append(QualificationLevelModelImpl.ORDER_BY_JPQL);
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

				list = (List<QualificationLevel>)QueryUtil.list(
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
	 * Returns the first qualification level in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching qualification level
	 * @throws NoSuchQualificationLevelException if a matching qualification level could not be found
	 */
	@Override
	public QualificationLevel findByCode_First(
			String code,
			OrderByComparator<QualificationLevel> orderByComparator)
		throws NoSuchQualificationLevelException {

		QualificationLevel qualificationLevel = fetchByCode_First(
			code, orderByComparator);

		if (qualificationLevel != null) {
			return qualificationLevel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("code=");
		sb.append(code);

		sb.append("}");

		throw new NoSuchQualificationLevelException(sb.toString());
	}

	/**
	 * Returns the first qualification level in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching qualification level, or <code>null</code> if a matching qualification level could not be found
	 */
	@Override
	public QualificationLevel fetchByCode_First(
		String code, OrderByComparator<QualificationLevel> orderByComparator) {

		List<QualificationLevel> list = findByCode(
			code, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last qualification level in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching qualification level
	 * @throws NoSuchQualificationLevelException if a matching qualification level could not be found
	 */
	@Override
	public QualificationLevel findByCode_Last(
			String code,
			OrderByComparator<QualificationLevel> orderByComparator)
		throws NoSuchQualificationLevelException {

		QualificationLevel qualificationLevel = fetchByCode_Last(
			code, orderByComparator);

		if (qualificationLevel != null) {
			return qualificationLevel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("code=");
		sb.append(code);

		sb.append("}");

		throw new NoSuchQualificationLevelException(sb.toString());
	}

	/**
	 * Returns the last qualification level in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching qualification level, or <code>null</code> if a matching qualification level could not be found
	 */
	@Override
	public QualificationLevel fetchByCode_Last(
		String code, OrderByComparator<QualificationLevel> orderByComparator) {

		int count = countByCode(code);

		if (count == 0) {
			return null;
		}

		List<QualificationLevel> list = findByCode(
			code, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the qualification levels before and after the current qualification level in the ordered set where code = &#63;.
	 *
	 * @param qualificationLevelId the primary key of the current qualification level
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next qualification level
	 * @throws NoSuchQualificationLevelException if a qualification level with the primary key could not be found
	 */
	@Override
	public QualificationLevel[] findByCode_PrevAndNext(
			long qualificationLevelId, String code,
			OrderByComparator<QualificationLevel> orderByComparator)
		throws NoSuchQualificationLevelException {

		code = Objects.toString(code, "");

		QualificationLevel qualificationLevel = findByPrimaryKey(
			qualificationLevelId);

		Session session = null;

		try {
			session = openSession();

			QualificationLevel[] array = new QualificationLevelImpl[3];

			array[0] = getByCode_PrevAndNext(
				session, qualificationLevel, code, orderByComparator, true);

			array[1] = qualificationLevel;

			array[2] = getByCode_PrevAndNext(
				session, qualificationLevel, code, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected QualificationLevel getByCode_PrevAndNext(
		Session session, QualificationLevel qualificationLevel, String code,
		OrderByComparator<QualificationLevel> orderByComparator,
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

		sb.append(_SQL_SELECT_QUALIFICATIONLEVEL_WHERE);

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
			sb.append(QualificationLevelModelImpl.ORDER_BY_JPQL);
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
						qualificationLevel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<QualificationLevel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the qualification levels where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	@Override
	public void removeByCode(String code) {
		for (QualificationLevel qualificationLevel :
				findByCode(code, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(qualificationLevel);
		}
	}

	/**
	 * Returns the number of qualification levels where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching qualification levels
	 */
	@Override
	public int countByCode(String code) {
		code = Objects.toString(code, "");

		FinderPath finderPath = _finderPathCountByCode;

		Object[] finderArgs = new Object[] {code};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_QUALIFICATIONLEVEL_WHERE);

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
		"qualificationLevel.code = ?";

	private static final String _FINDER_COLUMN_CODE_CODE_3 =
		"(qualificationLevel.code IS NULL OR qualificationLevel.code = '')";

	private FinderPath _finderPathWithPaginationFindByName;
	private FinderPath _finderPathWithoutPaginationFindByName;
	private FinderPath _finderPathCountByName;

	/**
	 * Returns all the qualification levels where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching qualification levels
	 */
	@Override
	public List<QualificationLevel> findByName(String name) {
		return findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the qualification levels where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationLevelModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of qualification levels
	 * @param end the upper bound of the range of qualification levels (not inclusive)
	 * @return the range of matching qualification levels
	 */
	@Override
	public List<QualificationLevel> findByName(
		String name, int start, int end) {

		return findByName(name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the qualification levels where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationLevelModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of qualification levels
	 * @param end the upper bound of the range of qualification levels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching qualification levels
	 */
	@Override
	public List<QualificationLevel> findByName(
		String name, int start, int end,
		OrderByComparator<QualificationLevel> orderByComparator) {

		return findByName(name, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the qualification levels where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationLevelModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of qualification levels
	 * @param end the upper bound of the range of qualification levels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching qualification levels
	 */
	@Override
	public List<QualificationLevel> findByName(
		String name, int start, int end,
		OrderByComparator<QualificationLevel> orderByComparator,
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

		List<QualificationLevel> list = null;

		if (useFinderCache) {
			list = (List<QualificationLevel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (QualificationLevel qualificationLevel : list) {
					if (!name.equals(qualificationLevel.getName())) {
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

			sb.append(_SQL_SELECT_QUALIFICATIONLEVEL_WHERE);

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
				sb.append(QualificationLevelModelImpl.ORDER_BY_JPQL);
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

				list = (List<QualificationLevel>)QueryUtil.list(
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
	 * Returns the first qualification level in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching qualification level
	 * @throws NoSuchQualificationLevelException if a matching qualification level could not be found
	 */
	@Override
	public QualificationLevel findByName_First(
			String name,
			OrderByComparator<QualificationLevel> orderByComparator)
		throws NoSuchQualificationLevelException {

		QualificationLevel qualificationLevel = fetchByName_First(
			name, orderByComparator);

		if (qualificationLevel != null) {
			return qualificationLevel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchQualificationLevelException(sb.toString());
	}

	/**
	 * Returns the first qualification level in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching qualification level, or <code>null</code> if a matching qualification level could not be found
	 */
	@Override
	public QualificationLevel fetchByName_First(
		String name, OrderByComparator<QualificationLevel> orderByComparator) {

		List<QualificationLevel> list = findByName(
			name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last qualification level in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching qualification level
	 * @throws NoSuchQualificationLevelException if a matching qualification level could not be found
	 */
	@Override
	public QualificationLevel findByName_Last(
			String name,
			OrderByComparator<QualificationLevel> orderByComparator)
		throws NoSuchQualificationLevelException {

		QualificationLevel qualificationLevel = fetchByName_Last(
			name, orderByComparator);

		if (qualificationLevel != null) {
			return qualificationLevel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchQualificationLevelException(sb.toString());
	}

	/**
	 * Returns the last qualification level in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching qualification level, or <code>null</code> if a matching qualification level could not be found
	 */
	@Override
	public QualificationLevel fetchByName_Last(
		String name, OrderByComparator<QualificationLevel> orderByComparator) {

		int count = countByName(name);

		if (count == 0) {
			return null;
		}

		List<QualificationLevel> list = findByName(
			name, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the qualification levels before and after the current qualification level in the ordered set where name = &#63;.
	 *
	 * @param qualificationLevelId the primary key of the current qualification level
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next qualification level
	 * @throws NoSuchQualificationLevelException if a qualification level with the primary key could not be found
	 */
	@Override
	public QualificationLevel[] findByName_PrevAndNext(
			long qualificationLevelId, String name,
			OrderByComparator<QualificationLevel> orderByComparator)
		throws NoSuchQualificationLevelException {

		name = Objects.toString(name, "");

		QualificationLevel qualificationLevel = findByPrimaryKey(
			qualificationLevelId);

		Session session = null;

		try {
			session = openSession();

			QualificationLevel[] array = new QualificationLevelImpl[3];

			array[0] = getByName_PrevAndNext(
				session, qualificationLevel, name, orderByComparator, true);

			array[1] = qualificationLevel;

			array[2] = getByName_PrevAndNext(
				session, qualificationLevel, name, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected QualificationLevel getByName_PrevAndNext(
		Session session, QualificationLevel qualificationLevel, String name,
		OrderByComparator<QualificationLevel> orderByComparator,
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

		sb.append(_SQL_SELECT_QUALIFICATIONLEVEL_WHERE);

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
			sb.append(QualificationLevelModelImpl.ORDER_BY_JPQL);
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
						qualificationLevel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<QualificationLevel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the qualification levels where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	@Override
	public void removeByName(String name) {
		for (QualificationLevel qualificationLevel :
				findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(qualificationLevel);
		}
	}

	/**
	 * Returns the number of qualification levels where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching qualification levels
	 */
	@Override
	public int countByName(String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByName;

		Object[] finderArgs = new Object[] {name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_QUALIFICATIONLEVEL_WHERE);

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
		"lower(qualificationLevel.name) = ?";

	private static final String _FINDER_COLUMN_NAME_NAME_3 =
		"(qualificationLevel.name IS NULL OR qualificationLevel.name = '')";

	public QualificationLevelPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("code", "code_");

		setDBColumnNames(dbColumnNames);

		setModelClass(QualificationLevel.class);

		setModelImplClass(QualificationLevelImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the qualification level in the entity cache if it is enabled.
	 *
	 * @param qualificationLevel the qualification level
	 */
	@Override
	public void cacheResult(QualificationLevel qualificationLevel) {
		entityCache.putResult(
			QualificationLevelImpl.class, qualificationLevel.getPrimaryKey(),
			qualificationLevel);
	}

	/**
	 * Caches the qualification levels in the entity cache if it is enabled.
	 *
	 * @param qualificationLevels the qualification levels
	 */
	@Override
	public void cacheResult(List<QualificationLevel> qualificationLevels) {
		for (QualificationLevel qualificationLevel : qualificationLevels) {
			if (entityCache.getResult(
					QualificationLevelImpl.class,
					qualificationLevel.getPrimaryKey()) == null) {

				cacheResult(qualificationLevel);
			}
		}
	}

	/**
	 * Clears the cache for all qualification levels.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(QualificationLevelImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the qualification level.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(QualificationLevel qualificationLevel) {
		entityCache.removeResult(
			QualificationLevelImpl.class, qualificationLevel);
	}

	@Override
	public void clearCache(List<QualificationLevel> qualificationLevels) {
		for (QualificationLevel qualificationLevel : qualificationLevels) {
			entityCache.removeResult(
				QualificationLevelImpl.class, qualificationLevel);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(QualificationLevelImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new qualification level with the primary key. Does not add the qualification level to the database.
	 *
	 * @param qualificationLevelId the primary key for the new qualification level
	 * @return the new qualification level
	 */
	@Override
	public QualificationLevel create(long qualificationLevelId) {
		QualificationLevel qualificationLevel = new QualificationLevelImpl();

		qualificationLevel.setNew(true);
		qualificationLevel.setPrimaryKey(qualificationLevelId);

		qualificationLevel.setCompanyId(CompanyThreadLocal.getCompanyId());

		return qualificationLevel;
	}

	/**
	 * Removes the qualification level with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param qualificationLevelId the primary key of the qualification level
	 * @return the qualification level that was removed
	 * @throws NoSuchQualificationLevelException if a qualification level with the primary key could not be found
	 */
	@Override
	public QualificationLevel remove(long qualificationLevelId)
		throws NoSuchQualificationLevelException {

		return remove((Serializable)qualificationLevelId);
	}

	/**
	 * Removes the qualification level with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the qualification level
	 * @return the qualification level that was removed
	 * @throws NoSuchQualificationLevelException if a qualification level with the primary key could not be found
	 */
	@Override
	public QualificationLevel remove(Serializable primaryKey)
		throws NoSuchQualificationLevelException {

		Session session = null;

		try {
			session = openSession();

			QualificationLevel qualificationLevel =
				(QualificationLevel)session.get(
					QualificationLevelImpl.class, primaryKey);

			if (qualificationLevel == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchQualificationLevelException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(qualificationLevel);
		}
		catch (NoSuchQualificationLevelException noSuchEntityException) {
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
	protected QualificationLevel removeImpl(
		QualificationLevel qualificationLevel) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(qualificationLevel)) {
				qualificationLevel = (QualificationLevel)session.get(
					QualificationLevelImpl.class,
					qualificationLevel.getPrimaryKeyObj());
			}

			if (qualificationLevel != null) {
				session.delete(qualificationLevel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (qualificationLevel != null) {
			clearCache(qualificationLevel);
		}

		return qualificationLevel;
	}

	@Override
	public QualificationLevel updateImpl(
		QualificationLevel qualificationLevel) {

		boolean isNew = qualificationLevel.isNew();

		if (!(qualificationLevel instanceof QualificationLevelModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(qualificationLevel.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					qualificationLevel);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in qualificationLevel proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom QualificationLevel implementation " +
					qualificationLevel.getClass());
		}

		QualificationLevelModelImpl qualificationLevelModelImpl =
			(QualificationLevelModelImpl)qualificationLevel;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (qualificationLevel.getCreateDate() == null)) {
			if (serviceContext == null) {
				qualificationLevel.setCreateDate(now);
			}
			else {
				qualificationLevel.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!qualificationLevelModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				qualificationLevel.setModifiedDate(now);
			}
			else {
				qualificationLevel.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(qualificationLevel);
			}
			else {
				qualificationLevel = (QualificationLevel)session.merge(
					qualificationLevel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			QualificationLevelImpl.class, qualificationLevelModelImpl, false,
			true);

		if (isNew) {
			qualificationLevel.setNew(false);
		}

		qualificationLevel.resetOriginalValues();

		return qualificationLevel;
	}

	/**
	 * Returns the qualification level with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the qualification level
	 * @return the qualification level
	 * @throws NoSuchQualificationLevelException if a qualification level with the primary key could not be found
	 */
	@Override
	public QualificationLevel findByPrimaryKey(Serializable primaryKey)
		throws NoSuchQualificationLevelException {

		QualificationLevel qualificationLevel = fetchByPrimaryKey(primaryKey);

		if (qualificationLevel == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchQualificationLevelException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return qualificationLevel;
	}

	/**
	 * Returns the qualification level with the primary key or throws a <code>NoSuchQualificationLevelException</code> if it could not be found.
	 *
	 * @param qualificationLevelId the primary key of the qualification level
	 * @return the qualification level
	 * @throws NoSuchQualificationLevelException if a qualification level with the primary key could not be found
	 */
	@Override
	public QualificationLevel findByPrimaryKey(long qualificationLevelId)
		throws NoSuchQualificationLevelException {

		return findByPrimaryKey((Serializable)qualificationLevelId);
	}

	/**
	 * Returns the qualification level with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param qualificationLevelId the primary key of the qualification level
	 * @return the qualification level, or <code>null</code> if a qualification level with the primary key could not be found
	 */
	@Override
	public QualificationLevel fetchByPrimaryKey(long qualificationLevelId) {
		return fetchByPrimaryKey((Serializable)qualificationLevelId);
	}

	/**
	 * Returns all the qualification levels.
	 *
	 * @return the qualification levels
	 */
	@Override
	public List<QualificationLevel> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the qualification levels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationLevelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of qualification levels
	 * @param end the upper bound of the range of qualification levels (not inclusive)
	 * @return the range of qualification levels
	 */
	@Override
	public List<QualificationLevel> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the qualification levels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationLevelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of qualification levels
	 * @param end the upper bound of the range of qualification levels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of qualification levels
	 */
	@Override
	public List<QualificationLevel> findAll(
		int start, int end,
		OrderByComparator<QualificationLevel> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the qualification levels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationLevelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of qualification levels
	 * @param end the upper bound of the range of qualification levels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of qualification levels
	 */
	@Override
	public List<QualificationLevel> findAll(
		int start, int end,
		OrderByComparator<QualificationLevel> orderByComparator,
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

		List<QualificationLevel> list = null;

		if (useFinderCache) {
			list = (List<QualificationLevel>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_QUALIFICATIONLEVEL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_QUALIFICATIONLEVEL;

				sql = sql.concat(QualificationLevelModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<QualificationLevel>)QueryUtil.list(
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
	 * Removes all the qualification levels from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (QualificationLevel qualificationLevel : findAll()) {
			remove(qualificationLevel);
		}
	}

	/**
	 * Returns the number of qualification levels.
	 *
	 * @return the number of qualification levels
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
					_SQL_COUNT_QUALIFICATIONLEVEL);

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
		return "qualificationLevelId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_QUALIFICATIONLEVEL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return QualificationLevelModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the qualification level persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new QualificationLevelModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", QualificationLevel.class.getName()));

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
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(QualificationLevelImpl.class.getName());

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

	private static final String _SQL_SELECT_QUALIFICATIONLEVEL =
		"SELECT qualificationLevel FROM QualificationLevel qualificationLevel";

	private static final String _SQL_SELECT_QUALIFICATIONLEVEL_WHERE =
		"SELECT qualificationLevel FROM QualificationLevel qualificationLevel WHERE ";

	private static final String _SQL_COUNT_QUALIFICATIONLEVEL =
		"SELECT COUNT(qualificationLevel) FROM QualificationLevel qualificationLevel";

	private static final String _SQL_COUNT_QUALIFICATIONLEVEL_WHERE =
		"SELECT COUNT(qualificationLevel) FROM QualificationLevel qualificationLevel WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "qualificationLevel.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No QualificationLevel exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No QualificationLevel exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		QualificationLevelPersistenceImpl.class);

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

	private static class QualificationLevelModelArgumentsResolver
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

			QualificationLevelModelImpl qualificationLevelModelImpl =
				(QualificationLevelModelImpl)baseModel;

			long columnBitmask = qualificationLevelModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					qualificationLevelModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						qualificationLevelModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					qualificationLevelModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			QualificationLevelModelImpl qualificationLevelModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						qualificationLevelModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = qualificationLevelModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}