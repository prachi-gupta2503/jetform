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

import com.adjecti.mdm.liferay.exception.NoSuchDesignationModeException;
import com.adjecti.mdm.liferay.model.DesignationMode;
import com.adjecti.mdm.liferay.model.impl.DesignationModeImpl;
import com.adjecti.mdm.liferay.model.impl.DesignationModeModelImpl;
import com.adjecti.mdm.liferay.service.persistence.DesignationModePersistence;
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
 * The persistence implementation for the designation mode service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DesignationModePersistence.class)
public class DesignationModePersistenceImpl
	extends BasePersistenceImpl<DesignationMode>
	implements DesignationModePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DesignationModeUtil</code> to access the designation mode persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DesignationModeImpl.class.getName();

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
	 * Returns all the designation modes where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching designation modes
	 */
	@Override
	public List<DesignationMode> findByCode(String code) {
		return findByCode(code, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the designation modes where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModeModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of designation modes
	 * @param end the upper bound of the range of designation modes (not inclusive)
	 * @return the range of matching designation modes
	 */
	@Override
	public List<DesignationMode> findByCode(String code, int start, int end) {
		return findByCode(code, start, end, null);
	}

	/**
	 * Returns an ordered range of all the designation modes where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModeModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of designation modes
	 * @param end the upper bound of the range of designation modes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching designation modes
	 */
	@Override
	public List<DesignationMode> findByCode(
		String code, int start, int end,
		OrderByComparator<DesignationMode> orderByComparator) {

		return findByCode(code, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the designation modes where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModeModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of designation modes
	 * @param end the upper bound of the range of designation modes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching designation modes
	 */
	@Override
	public List<DesignationMode> findByCode(
		String code, int start, int end,
		OrderByComparator<DesignationMode> orderByComparator,
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

		List<DesignationMode> list = null;

		if (useFinderCache) {
			list = (List<DesignationMode>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DesignationMode designationMode : list) {
					if (!code.equals(designationMode.getCode())) {
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

			sb.append(_SQL_SELECT_DESIGNATIONMODE_WHERE);

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
				sb.append(DesignationModeModelImpl.ORDER_BY_JPQL);
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

				list = (List<DesignationMode>)QueryUtil.list(
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
	 * Returns the first designation mode in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation mode
	 * @throws NoSuchDesignationModeException if a matching designation mode could not be found
	 */
	@Override
	public DesignationMode findByCode_First(
			String code, OrderByComparator<DesignationMode> orderByComparator)
		throws NoSuchDesignationModeException {

		DesignationMode designationMode = fetchByCode_First(
			code, orderByComparator);

		if (designationMode != null) {
			return designationMode;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("code=");
		sb.append(code);

		sb.append("}");

		throw new NoSuchDesignationModeException(sb.toString());
	}

	/**
	 * Returns the first designation mode in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation mode, or <code>null</code> if a matching designation mode could not be found
	 */
	@Override
	public DesignationMode fetchByCode_First(
		String code, OrderByComparator<DesignationMode> orderByComparator) {

		List<DesignationMode> list = findByCode(code, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last designation mode in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation mode
	 * @throws NoSuchDesignationModeException if a matching designation mode could not be found
	 */
	@Override
	public DesignationMode findByCode_Last(
			String code, OrderByComparator<DesignationMode> orderByComparator)
		throws NoSuchDesignationModeException {

		DesignationMode designationMode = fetchByCode_Last(
			code, orderByComparator);

		if (designationMode != null) {
			return designationMode;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("code=");
		sb.append(code);

		sb.append("}");

		throw new NoSuchDesignationModeException(sb.toString());
	}

	/**
	 * Returns the last designation mode in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation mode, or <code>null</code> if a matching designation mode could not be found
	 */
	@Override
	public DesignationMode fetchByCode_Last(
		String code, OrderByComparator<DesignationMode> orderByComparator) {

		int count = countByCode(code);

		if (count == 0) {
			return null;
		}

		List<DesignationMode> list = findByCode(
			code, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the designation modes before and after the current designation mode in the ordered set where code = &#63;.
	 *
	 * @param designationModeId the primary key of the current designation mode
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next designation mode
	 * @throws NoSuchDesignationModeException if a designation mode with the primary key could not be found
	 */
	@Override
	public DesignationMode[] findByCode_PrevAndNext(
			long designationModeId, String code,
			OrderByComparator<DesignationMode> orderByComparator)
		throws NoSuchDesignationModeException {

		code = Objects.toString(code, "");

		DesignationMode designationMode = findByPrimaryKey(designationModeId);

		Session session = null;

		try {
			session = openSession();

			DesignationMode[] array = new DesignationModeImpl[3];

			array[0] = getByCode_PrevAndNext(
				session, designationMode, code, orderByComparator, true);

			array[1] = designationMode;

			array[2] = getByCode_PrevAndNext(
				session, designationMode, code, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DesignationMode getByCode_PrevAndNext(
		Session session, DesignationMode designationMode, String code,
		OrderByComparator<DesignationMode> orderByComparator,
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

		sb.append(_SQL_SELECT_DESIGNATIONMODE_WHERE);

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
			sb.append(DesignationModeModelImpl.ORDER_BY_JPQL);
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
						designationMode)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DesignationMode> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the designation modes where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	@Override
	public void removeByCode(String code) {
		for (DesignationMode designationMode :
				findByCode(code, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(designationMode);
		}
	}

	/**
	 * Returns the number of designation modes where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching designation modes
	 */
	@Override
	public int countByCode(String code) {
		code = Objects.toString(code, "");

		FinderPath finderPath = _finderPathCountByCode;

		Object[] finderArgs = new Object[] {code};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DESIGNATIONMODE_WHERE);

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
		"designationMode.code = ?";

	private static final String _FINDER_COLUMN_CODE_CODE_3 =
		"(designationMode.code IS NULL OR designationMode.code = '')";

	private FinderPath _finderPathWithPaginationFindByName;
	private FinderPath _finderPathWithoutPaginationFindByName;
	private FinderPath _finderPathCountByName;

	/**
	 * Returns all the designation modes where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching designation modes
	 */
	@Override
	public List<DesignationMode> findByName(String name) {
		return findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the designation modes where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModeModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of designation modes
	 * @param end the upper bound of the range of designation modes (not inclusive)
	 * @return the range of matching designation modes
	 */
	@Override
	public List<DesignationMode> findByName(String name, int start, int end) {
		return findByName(name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the designation modes where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModeModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of designation modes
	 * @param end the upper bound of the range of designation modes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching designation modes
	 */
	@Override
	public List<DesignationMode> findByName(
		String name, int start, int end,
		OrderByComparator<DesignationMode> orderByComparator) {

		return findByName(name, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the designation modes where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModeModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of designation modes
	 * @param end the upper bound of the range of designation modes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching designation modes
	 */
	@Override
	public List<DesignationMode> findByName(
		String name, int start, int end,
		OrderByComparator<DesignationMode> orderByComparator,
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

		List<DesignationMode> list = null;

		if (useFinderCache) {
			list = (List<DesignationMode>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DesignationMode designationMode : list) {
					if (!name.equals(designationMode.getName())) {
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

			sb.append(_SQL_SELECT_DESIGNATIONMODE_WHERE);

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
				sb.append(DesignationModeModelImpl.ORDER_BY_JPQL);
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

				list = (List<DesignationMode>)QueryUtil.list(
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
	 * Returns the first designation mode in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation mode
	 * @throws NoSuchDesignationModeException if a matching designation mode could not be found
	 */
	@Override
	public DesignationMode findByName_First(
			String name, OrderByComparator<DesignationMode> orderByComparator)
		throws NoSuchDesignationModeException {

		DesignationMode designationMode = fetchByName_First(
			name, orderByComparator);

		if (designationMode != null) {
			return designationMode;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchDesignationModeException(sb.toString());
	}

	/**
	 * Returns the first designation mode in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation mode, or <code>null</code> if a matching designation mode could not be found
	 */
	@Override
	public DesignationMode fetchByName_First(
		String name, OrderByComparator<DesignationMode> orderByComparator) {

		List<DesignationMode> list = findByName(name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last designation mode in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation mode
	 * @throws NoSuchDesignationModeException if a matching designation mode could not be found
	 */
	@Override
	public DesignationMode findByName_Last(
			String name, OrderByComparator<DesignationMode> orderByComparator)
		throws NoSuchDesignationModeException {

		DesignationMode designationMode = fetchByName_Last(
			name, orderByComparator);

		if (designationMode != null) {
			return designationMode;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchDesignationModeException(sb.toString());
	}

	/**
	 * Returns the last designation mode in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation mode, or <code>null</code> if a matching designation mode could not be found
	 */
	@Override
	public DesignationMode fetchByName_Last(
		String name, OrderByComparator<DesignationMode> orderByComparator) {

		int count = countByName(name);

		if (count == 0) {
			return null;
		}

		List<DesignationMode> list = findByName(
			name, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the designation modes before and after the current designation mode in the ordered set where name = &#63;.
	 *
	 * @param designationModeId the primary key of the current designation mode
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next designation mode
	 * @throws NoSuchDesignationModeException if a designation mode with the primary key could not be found
	 */
	@Override
	public DesignationMode[] findByName_PrevAndNext(
			long designationModeId, String name,
			OrderByComparator<DesignationMode> orderByComparator)
		throws NoSuchDesignationModeException {

		name = Objects.toString(name, "");

		DesignationMode designationMode = findByPrimaryKey(designationModeId);

		Session session = null;

		try {
			session = openSession();

			DesignationMode[] array = new DesignationModeImpl[3];

			array[0] = getByName_PrevAndNext(
				session, designationMode, name, orderByComparator, true);

			array[1] = designationMode;

			array[2] = getByName_PrevAndNext(
				session, designationMode, name, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DesignationMode getByName_PrevAndNext(
		Session session, DesignationMode designationMode, String name,
		OrderByComparator<DesignationMode> orderByComparator,
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

		sb.append(_SQL_SELECT_DESIGNATIONMODE_WHERE);

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
			sb.append(DesignationModeModelImpl.ORDER_BY_JPQL);
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
						designationMode)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DesignationMode> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the designation modes where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	@Override
	public void removeByName(String name) {
		for (DesignationMode designationMode :
				findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(designationMode);
		}
	}

	/**
	 * Returns the number of designation modes where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching designation modes
	 */
	@Override
	public int countByName(String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByName;

		Object[] finderArgs = new Object[] {name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DESIGNATIONMODE_WHERE);

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
		"lower(designationMode.name) = ?";

	private static final String _FINDER_COLUMN_NAME_NAME_3 =
		"(designationMode.name IS NULL OR designationMode.name = '')";

	public DesignationModePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("code", "code_");

		setDBColumnNames(dbColumnNames);

		setModelClass(DesignationMode.class);

		setModelImplClass(DesignationModeImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the designation mode in the entity cache if it is enabled.
	 *
	 * @param designationMode the designation mode
	 */
	@Override
	public void cacheResult(DesignationMode designationMode) {
		entityCache.putResult(
			DesignationModeImpl.class, designationMode.getPrimaryKey(),
			designationMode);
	}

	/**
	 * Caches the designation modes in the entity cache if it is enabled.
	 *
	 * @param designationModes the designation modes
	 */
	@Override
	public void cacheResult(List<DesignationMode> designationModes) {
		for (DesignationMode designationMode : designationModes) {
			if (entityCache.getResult(
					DesignationModeImpl.class,
					designationMode.getPrimaryKey()) == null) {

				cacheResult(designationMode);
			}
		}
	}

	/**
	 * Clears the cache for all designation modes.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DesignationModeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the designation mode.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DesignationMode designationMode) {
		entityCache.removeResult(DesignationModeImpl.class, designationMode);
	}

	@Override
	public void clearCache(List<DesignationMode> designationModes) {
		for (DesignationMode designationMode : designationModes) {
			entityCache.removeResult(
				DesignationModeImpl.class, designationMode);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DesignationModeImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new designation mode with the primary key. Does not add the designation mode to the database.
	 *
	 * @param designationModeId the primary key for the new designation mode
	 * @return the new designation mode
	 */
	@Override
	public DesignationMode create(long designationModeId) {
		DesignationMode designationMode = new DesignationModeImpl();

		designationMode.setNew(true);
		designationMode.setPrimaryKey(designationModeId);

		designationMode.setCompanyId(CompanyThreadLocal.getCompanyId());

		return designationMode;
	}

	/**
	 * Removes the designation mode with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param designationModeId the primary key of the designation mode
	 * @return the designation mode that was removed
	 * @throws NoSuchDesignationModeException if a designation mode with the primary key could not be found
	 */
	@Override
	public DesignationMode remove(long designationModeId)
		throws NoSuchDesignationModeException {

		return remove((Serializable)designationModeId);
	}

	/**
	 * Removes the designation mode with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the designation mode
	 * @return the designation mode that was removed
	 * @throws NoSuchDesignationModeException if a designation mode with the primary key could not be found
	 */
	@Override
	public DesignationMode remove(Serializable primaryKey)
		throws NoSuchDesignationModeException {

		Session session = null;

		try {
			session = openSession();

			DesignationMode designationMode = (DesignationMode)session.get(
				DesignationModeImpl.class, primaryKey);

			if (designationMode == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDesignationModeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(designationMode);
		}
		catch (NoSuchDesignationModeException noSuchEntityException) {
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
	protected DesignationMode removeImpl(DesignationMode designationMode) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(designationMode)) {
				designationMode = (DesignationMode)session.get(
					DesignationModeImpl.class,
					designationMode.getPrimaryKeyObj());
			}

			if (designationMode != null) {
				session.delete(designationMode);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (designationMode != null) {
			clearCache(designationMode);
		}

		return designationMode;
	}

	@Override
	public DesignationMode updateImpl(DesignationMode designationMode) {
		boolean isNew = designationMode.isNew();

		if (!(designationMode instanceof DesignationModeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(designationMode.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					designationMode);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in designationMode proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DesignationMode implementation " +
					designationMode.getClass());
		}

		DesignationModeModelImpl designationModeModelImpl =
			(DesignationModeModelImpl)designationMode;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (designationMode.getCreateDate() == null)) {
			if (serviceContext == null) {
				designationMode.setCreateDate(now);
			}
			else {
				designationMode.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!designationModeModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				designationMode.setModifiedDate(now);
			}
			else {
				designationMode.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(designationMode);
			}
			else {
				designationMode = (DesignationMode)session.merge(
					designationMode);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DesignationModeImpl.class, designationModeModelImpl, false, true);

		if (isNew) {
			designationMode.setNew(false);
		}

		designationMode.resetOriginalValues();

		return designationMode;
	}

	/**
	 * Returns the designation mode with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the designation mode
	 * @return the designation mode
	 * @throws NoSuchDesignationModeException if a designation mode with the primary key could not be found
	 */
	@Override
	public DesignationMode findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDesignationModeException {

		DesignationMode designationMode = fetchByPrimaryKey(primaryKey);

		if (designationMode == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDesignationModeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return designationMode;
	}

	/**
	 * Returns the designation mode with the primary key or throws a <code>NoSuchDesignationModeException</code> if it could not be found.
	 *
	 * @param designationModeId the primary key of the designation mode
	 * @return the designation mode
	 * @throws NoSuchDesignationModeException if a designation mode with the primary key could not be found
	 */
	@Override
	public DesignationMode findByPrimaryKey(long designationModeId)
		throws NoSuchDesignationModeException {

		return findByPrimaryKey((Serializable)designationModeId);
	}

	/**
	 * Returns the designation mode with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param designationModeId the primary key of the designation mode
	 * @return the designation mode, or <code>null</code> if a designation mode with the primary key could not be found
	 */
	@Override
	public DesignationMode fetchByPrimaryKey(long designationModeId) {
		return fetchByPrimaryKey((Serializable)designationModeId);
	}

	/**
	 * Returns all the designation modes.
	 *
	 * @return the designation modes
	 */
	@Override
	public List<DesignationMode> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the designation modes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation modes
	 * @param end the upper bound of the range of designation modes (not inclusive)
	 * @return the range of designation modes
	 */
	@Override
	public List<DesignationMode> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the designation modes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation modes
	 * @param end the upper bound of the range of designation modes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of designation modes
	 */
	@Override
	public List<DesignationMode> findAll(
		int start, int end,
		OrderByComparator<DesignationMode> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the designation modes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation modes
	 * @param end the upper bound of the range of designation modes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of designation modes
	 */
	@Override
	public List<DesignationMode> findAll(
		int start, int end,
		OrderByComparator<DesignationMode> orderByComparator,
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

		List<DesignationMode> list = null;

		if (useFinderCache) {
			list = (List<DesignationMode>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DESIGNATIONMODE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DESIGNATIONMODE;

				sql = sql.concat(DesignationModeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DesignationMode>)QueryUtil.list(
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
	 * Removes all the designation modes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DesignationMode designationMode : findAll()) {
			remove(designationMode);
		}
	}

	/**
	 * Returns the number of designation modes.
	 *
	 * @return the number of designation modes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DESIGNATIONMODE);

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
		return "designationModeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DESIGNATIONMODE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DesignationModeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the designation mode persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new DesignationModeModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", DesignationMode.class.getName()));

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
		entityCache.removeCache(DesignationModeImpl.class.getName());

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

	private static final String _SQL_SELECT_DESIGNATIONMODE =
		"SELECT designationMode FROM DesignationMode designationMode";

	private static final String _SQL_SELECT_DESIGNATIONMODE_WHERE =
		"SELECT designationMode FROM DesignationMode designationMode WHERE ";

	private static final String _SQL_COUNT_DESIGNATIONMODE =
		"SELECT COUNT(designationMode) FROM DesignationMode designationMode";

	private static final String _SQL_COUNT_DESIGNATIONMODE_WHERE =
		"SELECT COUNT(designationMode) FROM DesignationMode designationMode WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "designationMode.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DesignationMode exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DesignationMode exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DesignationModePersistenceImpl.class);

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

	private static class DesignationModeModelArgumentsResolver
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

			DesignationModeModelImpl designationModeModelImpl =
				(DesignationModeModelImpl)baseModel;

			long columnBitmask = designationModeModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					designationModeModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						designationModeModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					designationModeModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			DesignationModeModelImpl designationModeModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						designationModeModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = designationModeModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}