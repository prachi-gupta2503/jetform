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

import com.adjecti.mdm.liferay.exception.NoSuchQualificationSubjectException;
import com.adjecti.mdm.liferay.model.QualificationSubject;
import com.adjecti.mdm.liferay.model.impl.QualificationSubjectImpl;
import com.adjecti.mdm.liferay.model.impl.QualificationSubjectModelImpl;
import com.adjecti.mdm.liferay.service.persistence.QualificationSubjectPersistence;
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
 * The persistence implementation for the qualification subject service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = QualificationSubjectPersistence.class)
public class QualificationSubjectPersistenceImpl
	extends BasePersistenceImpl<QualificationSubject>
	implements QualificationSubjectPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>QualificationSubjectUtil</code> to access the qualification subject persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		QualificationSubjectImpl.class.getName();

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
	 * Returns all the qualification subjects where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching qualification subjects
	 */
	@Override
	public List<QualificationSubject> findByCode(String code) {
		return findByCode(code, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the qualification subjects where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of qualification subjects
	 * @param end the upper bound of the range of qualification subjects (not inclusive)
	 * @return the range of matching qualification subjects
	 */
	@Override
	public List<QualificationSubject> findByCode(
		String code, int start, int end) {

		return findByCode(code, start, end, null);
	}

	/**
	 * Returns an ordered range of all the qualification subjects where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of qualification subjects
	 * @param end the upper bound of the range of qualification subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching qualification subjects
	 */
	@Override
	public List<QualificationSubject> findByCode(
		String code, int start, int end,
		OrderByComparator<QualificationSubject> orderByComparator) {

		return findByCode(code, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the qualification subjects where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of qualification subjects
	 * @param end the upper bound of the range of qualification subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching qualification subjects
	 */
	@Override
	public List<QualificationSubject> findByCode(
		String code, int start, int end,
		OrderByComparator<QualificationSubject> orderByComparator,
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

		List<QualificationSubject> list = null;

		if (useFinderCache) {
			list = (List<QualificationSubject>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (QualificationSubject qualificationSubject : list) {
					if (!code.equals(qualificationSubject.getCode())) {
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

			sb.append(_SQL_SELECT_QUALIFICATIONSUBJECT_WHERE);

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
				sb.append(QualificationSubjectModelImpl.ORDER_BY_JPQL);
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

				list = (List<QualificationSubject>)QueryUtil.list(
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
	 * Returns the first qualification subject in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching qualification subject
	 * @throws NoSuchQualificationSubjectException if a matching qualification subject could not be found
	 */
	@Override
	public QualificationSubject findByCode_First(
			String code,
			OrderByComparator<QualificationSubject> orderByComparator)
		throws NoSuchQualificationSubjectException {

		QualificationSubject qualificationSubject = fetchByCode_First(
			code, orderByComparator);

		if (qualificationSubject != null) {
			return qualificationSubject;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("code=");
		sb.append(code);

		sb.append("}");

		throw new NoSuchQualificationSubjectException(sb.toString());
	}

	/**
	 * Returns the first qualification subject in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching qualification subject, or <code>null</code> if a matching qualification subject could not be found
	 */
	@Override
	public QualificationSubject fetchByCode_First(
		String code,
		OrderByComparator<QualificationSubject> orderByComparator) {

		List<QualificationSubject> list = findByCode(
			code, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last qualification subject in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching qualification subject
	 * @throws NoSuchQualificationSubjectException if a matching qualification subject could not be found
	 */
	@Override
	public QualificationSubject findByCode_Last(
			String code,
			OrderByComparator<QualificationSubject> orderByComparator)
		throws NoSuchQualificationSubjectException {

		QualificationSubject qualificationSubject = fetchByCode_Last(
			code, orderByComparator);

		if (qualificationSubject != null) {
			return qualificationSubject;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("code=");
		sb.append(code);

		sb.append("}");

		throw new NoSuchQualificationSubjectException(sb.toString());
	}

	/**
	 * Returns the last qualification subject in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching qualification subject, or <code>null</code> if a matching qualification subject could not be found
	 */
	@Override
	public QualificationSubject fetchByCode_Last(
		String code,
		OrderByComparator<QualificationSubject> orderByComparator) {

		int count = countByCode(code);

		if (count == 0) {
			return null;
		}

		List<QualificationSubject> list = findByCode(
			code, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the qualification subjects before and after the current qualification subject in the ordered set where code = &#63;.
	 *
	 * @param qualificationSubjectId the primary key of the current qualification subject
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next qualification subject
	 * @throws NoSuchQualificationSubjectException if a qualification subject with the primary key could not be found
	 */
	@Override
	public QualificationSubject[] findByCode_PrevAndNext(
			long qualificationSubjectId, String code,
			OrderByComparator<QualificationSubject> orderByComparator)
		throws NoSuchQualificationSubjectException {

		code = Objects.toString(code, "");

		QualificationSubject qualificationSubject = findByPrimaryKey(
			qualificationSubjectId);

		Session session = null;

		try {
			session = openSession();

			QualificationSubject[] array = new QualificationSubjectImpl[3];

			array[0] = getByCode_PrevAndNext(
				session, qualificationSubject, code, orderByComparator, true);

			array[1] = qualificationSubject;

			array[2] = getByCode_PrevAndNext(
				session, qualificationSubject, code, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected QualificationSubject getByCode_PrevAndNext(
		Session session, QualificationSubject qualificationSubject, String code,
		OrderByComparator<QualificationSubject> orderByComparator,
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

		sb.append(_SQL_SELECT_QUALIFICATIONSUBJECT_WHERE);

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
			sb.append(QualificationSubjectModelImpl.ORDER_BY_JPQL);
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
						qualificationSubject)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<QualificationSubject> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the qualification subjects where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	@Override
	public void removeByCode(String code) {
		for (QualificationSubject qualificationSubject :
				findByCode(code, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(qualificationSubject);
		}
	}

	/**
	 * Returns the number of qualification subjects where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching qualification subjects
	 */
	@Override
	public int countByCode(String code) {
		code = Objects.toString(code, "");

		FinderPath finderPath = _finderPathCountByCode;

		Object[] finderArgs = new Object[] {code};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_QUALIFICATIONSUBJECT_WHERE);

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
		"qualificationSubject.code = ?";

	private static final String _FINDER_COLUMN_CODE_CODE_3 =
		"(qualificationSubject.code IS NULL OR qualificationSubject.code = '')";

	private FinderPath _finderPathWithPaginationFindByName;
	private FinderPath _finderPathWithoutPaginationFindByName;
	private FinderPath _finderPathCountByName;

	/**
	 * Returns all the qualification subjects where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching qualification subjects
	 */
	@Override
	public List<QualificationSubject> findByName(String name) {
		return findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the qualification subjects where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of qualification subjects
	 * @param end the upper bound of the range of qualification subjects (not inclusive)
	 * @return the range of matching qualification subjects
	 */
	@Override
	public List<QualificationSubject> findByName(
		String name, int start, int end) {

		return findByName(name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the qualification subjects where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of qualification subjects
	 * @param end the upper bound of the range of qualification subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching qualification subjects
	 */
	@Override
	public List<QualificationSubject> findByName(
		String name, int start, int end,
		OrderByComparator<QualificationSubject> orderByComparator) {

		return findByName(name, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the qualification subjects where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of qualification subjects
	 * @param end the upper bound of the range of qualification subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching qualification subjects
	 */
	@Override
	public List<QualificationSubject> findByName(
		String name, int start, int end,
		OrderByComparator<QualificationSubject> orderByComparator,
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

		List<QualificationSubject> list = null;

		if (useFinderCache) {
			list = (List<QualificationSubject>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (QualificationSubject qualificationSubject : list) {
					if (!name.equals(qualificationSubject.getName())) {
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

			sb.append(_SQL_SELECT_QUALIFICATIONSUBJECT_WHERE);

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
				sb.append(QualificationSubjectModelImpl.ORDER_BY_JPQL);
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

				list = (List<QualificationSubject>)QueryUtil.list(
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
	 * Returns the first qualification subject in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching qualification subject
	 * @throws NoSuchQualificationSubjectException if a matching qualification subject could not be found
	 */
	@Override
	public QualificationSubject findByName_First(
			String name,
			OrderByComparator<QualificationSubject> orderByComparator)
		throws NoSuchQualificationSubjectException {

		QualificationSubject qualificationSubject = fetchByName_First(
			name, orderByComparator);

		if (qualificationSubject != null) {
			return qualificationSubject;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchQualificationSubjectException(sb.toString());
	}

	/**
	 * Returns the first qualification subject in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching qualification subject, or <code>null</code> if a matching qualification subject could not be found
	 */
	@Override
	public QualificationSubject fetchByName_First(
		String name,
		OrderByComparator<QualificationSubject> orderByComparator) {

		List<QualificationSubject> list = findByName(
			name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last qualification subject in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching qualification subject
	 * @throws NoSuchQualificationSubjectException if a matching qualification subject could not be found
	 */
	@Override
	public QualificationSubject findByName_Last(
			String name,
			OrderByComparator<QualificationSubject> orderByComparator)
		throws NoSuchQualificationSubjectException {

		QualificationSubject qualificationSubject = fetchByName_Last(
			name, orderByComparator);

		if (qualificationSubject != null) {
			return qualificationSubject;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchQualificationSubjectException(sb.toString());
	}

	/**
	 * Returns the last qualification subject in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching qualification subject, or <code>null</code> if a matching qualification subject could not be found
	 */
	@Override
	public QualificationSubject fetchByName_Last(
		String name,
		OrderByComparator<QualificationSubject> orderByComparator) {

		int count = countByName(name);

		if (count == 0) {
			return null;
		}

		List<QualificationSubject> list = findByName(
			name, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the qualification subjects before and after the current qualification subject in the ordered set where name = &#63;.
	 *
	 * @param qualificationSubjectId the primary key of the current qualification subject
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next qualification subject
	 * @throws NoSuchQualificationSubjectException if a qualification subject with the primary key could not be found
	 */
	@Override
	public QualificationSubject[] findByName_PrevAndNext(
			long qualificationSubjectId, String name,
			OrderByComparator<QualificationSubject> orderByComparator)
		throws NoSuchQualificationSubjectException {

		name = Objects.toString(name, "");

		QualificationSubject qualificationSubject = findByPrimaryKey(
			qualificationSubjectId);

		Session session = null;

		try {
			session = openSession();

			QualificationSubject[] array = new QualificationSubjectImpl[3];

			array[0] = getByName_PrevAndNext(
				session, qualificationSubject, name, orderByComparator, true);

			array[1] = qualificationSubject;

			array[2] = getByName_PrevAndNext(
				session, qualificationSubject, name, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected QualificationSubject getByName_PrevAndNext(
		Session session, QualificationSubject qualificationSubject, String name,
		OrderByComparator<QualificationSubject> orderByComparator,
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

		sb.append(_SQL_SELECT_QUALIFICATIONSUBJECT_WHERE);

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
			sb.append(QualificationSubjectModelImpl.ORDER_BY_JPQL);
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
						qualificationSubject)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<QualificationSubject> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the qualification subjects where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	@Override
	public void removeByName(String name) {
		for (QualificationSubject qualificationSubject :
				findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(qualificationSubject);
		}
	}

	/**
	 * Returns the number of qualification subjects where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching qualification subjects
	 */
	@Override
	public int countByName(String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByName;

		Object[] finderArgs = new Object[] {name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_QUALIFICATIONSUBJECT_WHERE);

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
		"qualificationSubject.name = ?";

	private static final String _FINDER_COLUMN_NAME_NAME_3 =
		"(qualificationSubject.name IS NULL OR qualificationSubject.name = '')";

	public QualificationSubjectPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("code", "code_");

		setDBColumnNames(dbColumnNames);

		setModelClass(QualificationSubject.class);

		setModelImplClass(QualificationSubjectImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the qualification subject in the entity cache if it is enabled.
	 *
	 * @param qualificationSubject the qualification subject
	 */
	@Override
	public void cacheResult(QualificationSubject qualificationSubject) {
		entityCache.putResult(
			QualificationSubjectImpl.class,
			qualificationSubject.getPrimaryKey(), qualificationSubject);
	}

	/**
	 * Caches the qualification subjects in the entity cache if it is enabled.
	 *
	 * @param qualificationSubjects the qualification subjects
	 */
	@Override
	public void cacheResult(List<QualificationSubject> qualificationSubjects) {
		for (QualificationSubject qualificationSubject :
				qualificationSubjects) {

			if (entityCache.getResult(
					QualificationSubjectImpl.class,
					qualificationSubject.getPrimaryKey()) == null) {

				cacheResult(qualificationSubject);
			}
		}
	}

	/**
	 * Clears the cache for all qualification subjects.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(QualificationSubjectImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the qualification subject.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(QualificationSubject qualificationSubject) {
		entityCache.removeResult(
			QualificationSubjectImpl.class, qualificationSubject);
	}

	@Override
	public void clearCache(List<QualificationSubject> qualificationSubjects) {
		for (QualificationSubject qualificationSubject :
				qualificationSubjects) {

			entityCache.removeResult(
				QualificationSubjectImpl.class, qualificationSubject);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				QualificationSubjectImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new qualification subject with the primary key. Does not add the qualification subject to the database.
	 *
	 * @param qualificationSubjectId the primary key for the new qualification subject
	 * @return the new qualification subject
	 */
	@Override
	public QualificationSubject create(long qualificationSubjectId) {
		QualificationSubject qualificationSubject =
			new QualificationSubjectImpl();

		qualificationSubject.setNew(true);
		qualificationSubject.setPrimaryKey(qualificationSubjectId);

		qualificationSubject.setCompanyId(CompanyThreadLocal.getCompanyId());

		return qualificationSubject;
	}

	/**
	 * Removes the qualification subject with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param qualificationSubjectId the primary key of the qualification subject
	 * @return the qualification subject that was removed
	 * @throws NoSuchQualificationSubjectException if a qualification subject with the primary key could not be found
	 */
	@Override
	public QualificationSubject remove(long qualificationSubjectId)
		throws NoSuchQualificationSubjectException {

		return remove((Serializable)qualificationSubjectId);
	}

	/**
	 * Removes the qualification subject with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the qualification subject
	 * @return the qualification subject that was removed
	 * @throws NoSuchQualificationSubjectException if a qualification subject with the primary key could not be found
	 */
	@Override
	public QualificationSubject remove(Serializable primaryKey)
		throws NoSuchQualificationSubjectException {

		Session session = null;

		try {
			session = openSession();

			QualificationSubject qualificationSubject =
				(QualificationSubject)session.get(
					QualificationSubjectImpl.class, primaryKey);

			if (qualificationSubject == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchQualificationSubjectException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(qualificationSubject);
		}
		catch (NoSuchQualificationSubjectException noSuchEntityException) {
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
	protected QualificationSubject removeImpl(
		QualificationSubject qualificationSubject) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(qualificationSubject)) {
				qualificationSubject = (QualificationSubject)session.get(
					QualificationSubjectImpl.class,
					qualificationSubject.getPrimaryKeyObj());
			}

			if (qualificationSubject != null) {
				session.delete(qualificationSubject);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (qualificationSubject != null) {
			clearCache(qualificationSubject);
		}

		return qualificationSubject;
	}

	@Override
	public QualificationSubject updateImpl(
		QualificationSubject qualificationSubject) {

		boolean isNew = qualificationSubject.isNew();

		if (!(qualificationSubject instanceof QualificationSubjectModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(qualificationSubject.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					qualificationSubject);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in qualificationSubject proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom QualificationSubject implementation " +
					qualificationSubject.getClass());
		}

		QualificationSubjectModelImpl qualificationSubjectModelImpl =
			(QualificationSubjectModelImpl)qualificationSubject;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (qualificationSubject.getCreateDate() == null)) {
			if (serviceContext == null) {
				qualificationSubject.setCreateDate(now);
			}
			else {
				qualificationSubject.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!qualificationSubjectModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				qualificationSubject.setModifiedDate(now);
			}
			else {
				qualificationSubject.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(qualificationSubject);
			}
			else {
				qualificationSubject = (QualificationSubject)session.merge(
					qualificationSubject);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			QualificationSubjectImpl.class, qualificationSubjectModelImpl,
			false, true);

		if (isNew) {
			qualificationSubject.setNew(false);
		}

		qualificationSubject.resetOriginalValues();

		return qualificationSubject;
	}

	/**
	 * Returns the qualification subject with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the qualification subject
	 * @return the qualification subject
	 * @throws NoSuchQualificationSubjectException if a qualification subject with the primary key could not be found
	 */
	@Override
	public QualificationSubject findByPrimaryKey(Serializable primaryKey)
		throws NoSuchQualificationSubjectException {

		QualificationSubject qualificationSubject = fetchByPrimaryKey(
			primaryKey);

		if (qualificationSubject == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchQualificationSubjectException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return qualificationSubject;
	}

	/**
	 * Returns the qualification subject with the primary key or throws a <code>NoSuchQualificationSubjectException</code> if it could not be found.
	 *
	 * @param qualificationSubjectId the primary key of the qualification subject
	 * @return the qualification subject
	 * @throws NoSuchQualificationSubjectException if a qualification subject with the primary key could not be found
	 */
	@Override
	public QualificationSubject findByPrimaryKey(long qualificationSubjectId)
		throws NoSuchQualificationSubjectException {

		return findByPrimaryKey((Serializable)qualificationSubjectId);
	}

	/**
	 * Returns the qualification subject with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param qualificationSubjectId the primary key of the qualification subject
	 * @return the qualification subject, or <code>null</code> if a qualification subject with the primary key could not be found
	 */
	@Override
	public QualificationSubject fetchByPrimaryKey(long qualificationSubjectId) {
		return fetchByPrimaryKey((Serializable)qualificationSubjectId);
	}

	/**
	 * Returns all the qualification subjects.
	 *
	 * @return the qualification subjects
	 */
	@Override
	public List<QualificationSubject> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the qualification subjects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of qualification subjects
	 * @param end the upper bound of the range of qualification subjects (not inclusive)
	 * @return the range of qualification subjects
	 */
	@Override
	public List<QualificationSubject> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the qualification subjects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of qualification subjects
	 * @param end the upper bound of the range of qualification subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of qualification subjects
	 */
	@Override
	public List<QualificationSubject> findAll(
		int start, int end,
		OrderByComparator<QualificationSubject> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the qualification subjects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of qualification subjects
	 * @param end the upper bound of the range of qualification subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of qualification subjects
	 */
	@Override
	public List<QualificationSubject> findAll(
		int start, int end,
		OrderByComparator<QualificationSubject> orderByComparator,
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

		List<QualificationSubject> list = null;

		if (useFinderCache) {
			list = (List<QualificationSubject>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_QUALIFICATIONSUBJECT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_QUALIFICATIONSUBJECT;

				sql = sql.concat(QualificationSubjectModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<QualificationSubject>)QueryUtil.list(
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
	 * Removes all the qualification subjects from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (QualificationSubject qualificationSubject : findAll()) {
			remove(qualificationSubject);
		}
	}

	/**
	 * Returns the number of qualification subjects.
	 *
	 * @return the number of qualification subjects
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
					_SQL_COUNT_QUALIFICATIONSUBJECT);

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
		return "qualificationSubjectId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_QUALIFICATIONSUBJECT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return QualificationSubjectModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the qualification subject persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new QualificationSubjectModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", QualificationSubject.class.getName()));

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
		entityCache.removeCache(QualificationSubjectImpl.class.getName());

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

	private static final String _SQL_SELECT_QUALIFICATIONSUBJECT =
		"SELECT qualificationSubject FROM QualificationSubject qualificationSubject";

	private static final String _SQL_SELECT_QUALIFICATIONSUBJECT_WHERE =
		"SELECT qualificationSubject FROM QualificationSubject qualificationSubject WHERE ";

	private static final String _SQL_COUNT_QUALIFICATIONSUBJECT =
		"SELECT COUNT(qualificationSubject) FROM QualificationSubject qualificationSubject";

	private static final String _SQL_COUNT_QUALIFICATIONSUBJECT_WHERE =
		"SELECT COUNT(qualificationSubject) FROM QualificationSubject qualificationSubject WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"qualificationSubject.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No QualificationSubject exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No QualificationSubject exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		QualificationSubjectPersistenceImpl.class);

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

	private static class QualificationSubjectModelArgumentsResolver
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

			QualificationSubjectModelImpl qualificationSubjectModelImpl =
				(QualificationSubjectModelImpl)baseModel;

			long columnBitmask =
				qualificationSubjectModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					qualificationSubjectModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						qualificationSubjectModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					qualificationSubjectModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			QualificationSubjectModelImpl qualificationSubjectModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						qualificationSubjectModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = qualificationSubjectModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}