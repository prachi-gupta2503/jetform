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

import com.adjecti.mdm.liferay.exception.NoSuchQualificationGradeException;
import com.adjecti.mdm.liferay.model.QualificationGrade;
import com.adjecti.mdm.liferay.model.impl.QualificationGradeImpl;
import com.adjecti.mdm.liferay.model.impl.QualificationGradeModelImpl;
import com.adjecti.mdm.liferay.service.persistence.QualificationGradePersistence;
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
 * The persistence implementation for the qualification grade service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = QualificationGradePersistence.class)
public class QualificationGradePersistenceImpl
	extends BasePersistenceImpl<QualificationGrade>
	implements QualificationGradePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>QualificationGradeUtil</code> to access the qualification grade persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		QualificationGradeImpl.class.getName();

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
	 * Returns all the qualification grades where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching qualification grades
	 */
	@Override
	public List<QualificationGrade> findByCode(String code) {
		return findByCode(code, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the qualification grades where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationGradeModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of qualification grades
	 * @param end the upper bound of the range of qualification grades (not inclusive)
	 * @return the range of matching qualification grades
	 */
	@Override
	public List<QualificationGrade> findByCode(
		String code, int start, int end) {

		return findByCode(code, start, end, null);
	}

	/**
	 * Returns an ordered range of all the qualification grades where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationGradeModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of qualification grades
	 * @param end the upper bound of the range of qualification grades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching qualification grades
	 */
	@Override
	public List<QualificationGrade> findByCode(
		String code, int start, int end,
		OrderByComparator<QualificationGrade> orderByComparator) {

		return findByCode(code, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the qualification grades where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationGradeModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of qualification grades
	 * @param end the upper bound of the range of qualification grades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching qualification grades
	 */
	@Override
	public List<QualificationGrade> findByCode(
		String code, int start, int end,
		OrderByComparator<QualificationGrade> orderByComparator,
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

		List<QualificationGrade> list = null;

		if (useFinderCache) {
			list = (List<QualificationGrade>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (QualificationGrade qualificationGrade : list) {
					if (!code.equals(qualificationGrade.getCode())) {
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

			sb.append(_SQL_SELECT_QUALIFICATIONGRADE_WHERE);

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
				sb.append(QualificationGradeModelImpl.ORDER_BY_JPQL);
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

				list = (List<QualificationGrade>)QueryUtil.list(
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
	 * Returns the first qualification grade in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching qualification grade
	 * @throws NoSuchQualificationGradeException if a matching qualification grade could not be found
	 */
	@Override
	public QualificationGrade findByCode_First(
			String code,
			OrderByComparator<QualificationGrade> orderByComparator)
		throws NoSuchQualificationGradeException {

		QualificationGrade qualificationGrade = fetchByCode_First(
			code, orderByComparator);

		if (qualificationGrade != null) {
			return qualificationGrade;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("code=");
		sb.append(code);

		sb.append("}");

		throw new NoSuchQualificationGradeException(sb.toString());
	}

	/**
	 * Returns the first qualification grade in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching qualification grade, or <code>null</code> if a matching qualification grade could not be found
	 */
	@Override
	public QualificationGrade fetchByCode_First(
		String code, OrderByComparator<QualificationGrade> orderByComparator) {

		List<QualificationGrade> list = findByCode(
			code, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last qualification grade in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching qualification grade
	 * @throws NoSuchQualificationGradeException if a matching qualification grade could not be found
	 */
	@Override
	public QualificationGrade findByCode_Last(
			String code,
			OrderByComparator<QualificationGrade> orderByComparator)
		throws NoSuchQualificationGradeException {

		QualificationGrade qualificationGrade = fetchByCode_Last(
			code, orderByComparator);

		if (qualificationGrade != null) {
			return qualificationGrade;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("code=");
		sb.append(code);

		sb.append("}");

		throw new NoSuchQualificationGradeException(sb.toString());
	}

	/**
	 * Returns the last qualification grade in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching qualification grade, or <code>null</code> if a matching qualification grade could not be found
	 */
	@Override
	public QualificationGrade fetchByCode_Last(
		String code, OrderByComparator<QualificationGrade> orderByComparator) {

		int count = countByCode(code);

		if (count == 0) {
			return null;
		}

		List<QualificationGrade> list = findByCode(
			code, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the qualification grades before and after the current qualification grade in the ordered set where code = &#63;.
	 *
	 * @param qualificationGradeId the primary key of the current qualification grade
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next qualification grade
	 * @throws NoSuchQualificationGradeException if a qualification grade with the primary key could not be found
	 */
	@Override
	public QualificationGrade[] findByCode_PrevAndNext(
			long qualificationGradeId, String code,
			OrderByComparator<QualificationGrade> orderByComparator)
		throws NoSuchQualificationGradeException {

		code = Objects.toString(code, "");

		QualificationGrade qualificationGrade = findByPrimaryKey(
			qualificationGradeId);

		Session session = null;

		try {
			session = openSession();

			QualificationGrade[] array = new QualificationGradeImpl[3];

			array[0] = getByCode_PrevAndNext(
				session, qualificationGrade, code, orderByComparator, true);

			array[1] = qualificationGrade;

			array[2] = getByCode_PrevAndNext(
				session, qualificationGrade, code, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected QualificationGrade getByCode_PrevAndNext(
		Session session, QualificationGrade qualificationGrade, String code,
		OrderByComparator<QualificationGrade> orderByComparator,
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

		sb.append(_SQL_SELECT_QUALIFICATIONGRADE_WHERE);

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
			sb.append(QualificationGradeModelImpl.ORDER_BY_JPQL);
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
						qualificationGrade)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<QualificationGrade> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the qualification grades where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	@Override
	public void removeByCode(String code) {
		for (QualificationGrade qualificationGrade :
				findByCode(code, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(qualificationGrade);
		}
	}

	/**
	 * Returns the number of qualification grades where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching qualification grades
	 */
	@Override
	public int countByCode(String code) {
		code = Objects.toString(code, "");

		FinderPath finderPath = _finderPathCountByCode;

		Object[] finderArgs = new Object[] {code};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_QUALIFICATIONGRADE_WHERE);

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
		"qualificationGrade.code = ?";

	private static final String _FINDER_COLUMN_CODE_CODE_3 =
		"(qualificationGrade.code IS NULL OR qualificationGrade.code = '')";

	private FinderPath _finderPathWithPaginationFindByName;
	private FinderPath _finderPathWithoutPaginationFindByName;
	private FinderPath _finderPathCountByName;

	/**
	 * Returns all the qualification grades where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching qualification grades
	 */
	@Override
	public List<QualificationGrade> findByName(String name) {
		return findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the qualification grades where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationGradeModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of qualification grades
	 * @param end the upper bound of the range of qualification grades (not inclusive)
	 * @return the range of matching qualification grades
	 */
	@Override
	public List<QualificationGrade> findByName(
		String name, int start, int end) {

		return findByName(name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the qualification grades where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationGradeModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of qualification grades
	 * @param end the upper bound of the range of qualification grades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching qualification grades
	 */
	@Override
	public List<QualificationGrade> findByName(
		String name, int start, int end,
		OrderByComparator<QualificationGrade> orderByComparator) {

		return findByName(name, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the qualification grades where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationGradeModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of qualification grades
	 * @param end the upper bound of the range of qualification grades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching qualification grades
	 */
	@Override
	public List<QualificationGrade> findByName(
		String name, int start, int end,
		OrderByComparator<QualificationGrade> orderByComparator,
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

		List<QualificationGrade> list = null;

		if (useFinderCache) {
			list = (List<QualificationGrade>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (QualificationGrade qualificationGrade : list) {
					if (!name.equals(qualificationGrade.getName())) {
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

			sb.append(_SQL_SELECT_QUALIFICATIONGRADE_WHERE);

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
				sb.append(QualificationGradeModelImpl.ORDER_BY_JPQL);
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

				list = (List<QualificationGrade>)QueryUtil.list(
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
	 * Returns the first qualification grade in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching qualification grade
	 * @throws NoSuchQualificationGradeException if a matching qualification grade could not be found
	 */
	@Override
	public QualificationGrade findByName_First(
			String name,
			OrderByComparator<QualificationGrade> orderByComparator)
		throws NoSuchQualificationGradeException {

		QualificationGrade qualificationGrade = fetchByName_First(
			name, orderByComparator);

		if (qualificationGrade != null) {
			return qualificationGrade;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchQualificationGradeException(sb.toString());
	}

	/**
	 * Returns the first qualification grade in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching qualification grade, or <code>null</code> if a matching qualification grade could not be found
	 */
	@Override
	public QualificationGrade fetchByName_First(
		String name, OrderByComparator<QualificationGrade> orderByComparator) {

		List<QualificationGrade> list = findByName(
			name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last qualification grade in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching qualification grade
	 * @throws NoSuchQualificationGradeException if a matching qualification grade could not be found
	 */
	@Override
	public QualificationGrade findByName_Last(
			String name,
			OrderByComparator<QualificationGrade> orderByComparator)
		throws NoSuchQualificationGradeException {

		QualificationGrade qualificationGrade = fetchByName_Last(
			name, orderByComparator);

		if (qualificationGrade != null) {
			return qualificationGrade;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchQualificationGradeException(sb.toString());
	}

	/**
	 * Returns the last qualification grade in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching qualification grade, or <code>null</code> if a matching qualification grade could not be found
	 */
	@Override
	public QualificationGrade fetchByName_Last(
		String name, OrderByComparator<QualificationGrade> orderByComparator) {

		int count = countByName(name);

		if (count == 0) {
			return null;
		}

		List<QualificationGrade> list = findByName(
			name, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the qualification grades before and after the current qualification grade in the ordered set where name = &#63;.
	 *
	 * @param qualificationGradeId the primary key of the current qualification grade
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next qualification grade
	 * @throws NoSuchQualificationGradeException if a qualification grade with the primary key could not be found
	 */
	@Override
	public QualificationGrade[] findByName_PrevAndNext(
			long qualificationGradeId, String name,
			OrderByComparator<QualificationGrade> orderByComparator)
		throws NoSuchQualificationGradeException {

		name = Objects.toString(name, "");

		QualificationGrade qualificationGrade = findByPrimaryKey(
			qualificationGradeId);

		Session session = null;

		try {
			session = openSession();

			QualificationGrade[] array = new QualificationGradeImpl[3];

			array[0] = getByName_PrevAndNext(
				session, qualificationGrade, name, orderByComparator, true);

			array[1] = qualificationGrade;

			array[2] = getByName_PrevAndNext(
				session, qualificationGrade, name, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected QualificationGrade getByName_PrevAndNext(
		Session session, QualificationGrade qualificationGrade, String name,
		OrderByComparator<QualificationGrade> orderByComparator,
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

		sb.append(_SQL_SELECT_QUALIFICATIONGRADE_WHERE);

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
			sb.append(QualificationGradeModelImpl.ORDER_BY_JPQL);
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
						qualificationGrade)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<QualificationGrade> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the qualification grades where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	@Override
	public void removeByName(String name) {
		for (QualificationGrade qualificationGrade :
				findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(qualificationGrade);
		}
	}

	/**
	 * Returns the number of qualification grades where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching qualification grades
	 */
	@Override
	public int countByName(String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByName;

		Object[] finderArgs = new Object[] {name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_QUALIFICATIONGRADE_WHERE);

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
		"lower(qualificationGrade.name) = ?";

	private static final String _FINDER_COLUMN_NAME_NAME_3 =
		"(qualificationGrade.name IS NULL OR qualificationGrade.name = '')";

	public QualificationGradePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("code", "code_");

		setDBColumnNames(dbColumnNames);

		setModelClass(QualificationGrade.class);

		setModelImplClass(QualificationGradeImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the qualification grade in the entity cache if it is enabled.
	 *
	 * @param qualificationGrade the qualification grade
	 */
	@Override
	public void cacheResult(QualificationGrade qualificationGrade) {
		entityCache.putResult(
			QualificationGradeImpl.class, qualificationGrade.getPrimaryKey(),
			qualificationGrade);
	}

	/**
	 * Caches the qualification grades in the entity cache if it is enabled.
	 *
	 * @param qualificationGrades the qualification grades
	 */
	@Override
	public void cacheResult(List<QualificationGrade> qualificationGrades) {
		for (QualificationGrade qualificationGrade : qualificationGrades) {
			if (entityCache.getResult(
					QualificationGradeImpl.class,
					qualificationGrade.getPrimaryKey()) == null) {

				cacheResult(qualificationGrade);
			}
		}
	}

	/**
	 * Clears the cache for all qualification grades.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(QualificationGradeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the qualification grade.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(QualificationGrade qualificationGrade) {
		entityCache.removeResult(
			QualificationGradeImpl.class, qualificationGrade);
	}

	@Override
	public void clearCache(List<QualificationGrade> qualificationGrades) {
		for (QualificationGrade qualificationGrade : qualificationGrades) {
			entityCache.removeResult(
				QualificationGradeImpl.class, qualificationGrade);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(QualificationGradeImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new qualification grade with the primary key. Does not add the qualification grade to the database.
	 *
	 * @param qualificationGradeId the primary key for the new qualification grade
	 * @return the new qualification grade
	 */
	@Override
	public QualificationGrade create(long qualificationGradeId) {
		QualificationGrade qualificationGrade = new QualificationGradeImpl();

		qualificationGrade.setNew(true);
		qualificationGrade.setPrimaryKey(qualificationGradeId);

		qualificationGrade.setCompanyId(CompanyThreadLocal.getCompanyId());

		return qualificationGrade;
	}

	/**
	 * Removes the qualification grade with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param qualificationGradeId the primary key of the qualification grade
	 * @return the qualification grade that was removed
	 * @throws NoSuchQualificationGradeException if a qualification grade with the primary key could not be found
	 */
	@Override
	public QualificationGrade remove(long qualificationGradeId)
		throws NoSuchQualificationGradeException {

		return remove((Serializable)qualificationGradeId);
	}

	/**
	 * Removes the qualification grade with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the qualification grade
	 * @return the qualification grade that was removed
	 * @throws NoSuchQualificationGradeException if a qualification grade with the primary key could not be found
	 */
	@Override
	public QualificationGrade remove(Serializable primaryKey)
		throws NoSuchQualificationGradeException {

		Session session = null;

		try {
			session = openSession();

			QualificationGrade qualificationGrade =
				(QualificationGrade)session.get(
					QualificationGradeImpl.class, primaryKey);

			if (qualificationGrade == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchQualificationGradeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(qualificationGrade);
		}
		catch (NoSuchQualificationGradeException noSuchEntityException) {
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
	protected QualificationGrade removeImpl(
		QualificationGrade qualificationGrade) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(qualificationGrade)) {
				qualificationGrade = (QualificationGrade)session.get(
					QualificationGradeImpl.class,
					qualificationGrade.getPrimaryKeyObj());
			}

			if (qualificationGrade != null) {
				session.delete(qualificationGrade);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (qualificationGrade != null) {
			clearCache(qualificationGrade);
		}

		return qualificationGrade;
	}

	@Override
	public QualificationGrade updateImpl(
		QualificationGrade qualificationGrade) {

		boolean isNew = qualificationGrade.isNew();

		if (!(qualificationGrade instanceof QualificationGradeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(qualificationGrade.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					qualificationGrade);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in qualificationGrade proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom QualificationGrade implementation " +
					qualificationGrade.getClass());
		}

		QualificationGradeModelImpl qualificationGradeModelImpl =
			(QualificationGradeModelImpl)qualificationGrade;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (qualificationGrade.getCreateDate() == null)) {
			if (serviceContext == null) {
				qualificationGrade.setCreateDate(now);
			}
			else {
				qualificationGrade.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!qualificationGradeModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				qualificationGrade.setModifiedDate(now);
			}
			else {
				qualificationGrade.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(qualificationGrade);
			}
			else {
				qualificationGrade = (QualificationGrade)session.merge(
					qualificationGrade);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			QualificationGradeImpl.class, qualificationGradeModelImpl, false,
			true);

		if (isNew) {
			qualificationGrade.setNew(false);
		}

		qualificationGrade.resetOriginalValues();

		return qualificationGrade;
	}

	/**
	 * Returns the qualification grade with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the qualification grade
	 * @return the qualification grade
	 * @throws NoSuchQualificationGradeException if a qualification grade with the primary key could not be found
	 */
	@Override
	public QualificationGrade findByPrimaryKey(Serializable primaryKey)
		throws NoSuchQualificationGradeException {

		QualificationGrade qualificationGrade = fetchByPrimaryKey(primaryKey);

		if (qualificationGrade == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchQualificationGradeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return qualificationGrade;
	}

	/**
	 * Returns the qualification grade with the primary key or throws a <code>NoSuchQualificationGradeException</code> if it could not be found.
	 *
	 * @param qualificationGradeId the primary key of the qualification grade
	 * @return the qualification grade
	 * @throws NoSuchQualificationGradeException if a qualification grade with the primary key could not be found
	 */
	@Override
	public QualificationGrade findByPrimaryKey(long qualificationGradeId)
		throws NoSuchQualificationGradeException {

		return findByPrimaryKey((Serializable)qualificationGradeId);
	}

	/**
	 * Returns the qualification grade with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param qualificationGradeId the primary key of the qualification grade
	 * @return the qualification grade, or <code>null</code> if a qualification grade with the primary key could not be found
	 */
	@Override
	public QualificationGrade fetchByPrimaryKey(long qualificationGradeId) {
		return fetchByPrimaryKey((Serializable)qualificationGradeId);
	}

	/**
	 * Returns all the qualification grades.
	 *
	 * @return the qualification grades
	 */
	@Override
	public List<QualificationGrade> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the qualification grades.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationGradeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of qualification grades
	 * @param end the upper bound of the range of qualification grades (not inclusive)
	 * @return the range of qualification grades
	 */
	@Override
	public List<QualificationGrade> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the qualification grades.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationGradeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of qualification grades
	 * @param end the upper bound of the range of qualification grades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of qualification grades
	 */
	@Override
	public List<QualificationGrade> findAll(
		int start, int end,
		OrderByComparator<QualificationGrade> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the qualification grades.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationGradeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of qualification grades
	 * @param end the upper bound of the range of qualification grades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of qualification grades
	 */
	@Override
	public List<QualificationGrade> findAll(
		int start, int end,
		OrderByComparator<QualificationGrade> orderByComparator,
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

		List<QualificationGrade> list = null;

		if (useFinderCache) {
			list = (List<QualificationGrade>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_QUALIFICATIONGRADE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_QUALIFICATIONGRADE;

				sql = sql.concat(QualificationGradeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<QualificationGrade>)QueryUtil.list(
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
	 * Removes all the qualification grades from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (QualificationGrade qualificationGrade : findAll()) {
			remove(qualificationGrade);
		}
	}

	/**
	 * Returns the number of qualification grades.
	 *
	 * @return the number of qualification grades
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
					_SQL_COUNT_QUALIFICATIONGRADE);

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
		return "qualificationGradeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_QUALIFICATIONGRADE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return QualificationGradeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the qualification grade persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new QualificationGradeModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", QualificationGrade.class.getName()));

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
		entityCache.removeCache(QualificationGradeImpl.class.getName());

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

	private static final String _SQL_SELECT_QUALIFICATIONGRADE =
		"SELECT qualificationGrade FROM QualificationGrade qualificationGrade";

	private static final String _SQL_SELECT_QUALIFICATIONGRADE_WHERE =
		"SELECT qualificationGrade FROM QualificationGrade qualificationGrade WHERE ";

	private static final String _SQL_COUNT_QUALIFICATIONGRADE =
		"SELECT COUNT(qualificationGrade) FROM QualificationGrade qualificationGrade";

	private static final String _SQL_COUNT_QUALIFICATIONGRADE_WHERE =
		"SELECT COUNT(qualificationGrade) FROM QualificationGrade qualificationGrade WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "qualificationGrade.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No QualificationGrade exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No QualificationGrade exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		QualificationGradePersistenceImpl.class);

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

	private static class QualificationGradeModelArgumentsResolver
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

			QualificationGradeModelImpl qualificationGradeModelImpl =
				(QualificationGradeModelImpl)baseModel;

			long columnBitmask = qualificationGradeModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					qualificationGradeModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						qualificationGradeModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					qualificationGradeModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			QualificationGradeModelImpl qualificationGradeModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						qualificationGradeModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = qualificationGradeModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}