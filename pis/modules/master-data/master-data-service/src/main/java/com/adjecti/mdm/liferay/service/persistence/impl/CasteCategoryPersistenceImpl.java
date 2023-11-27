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

import com.adjecti.mdm.liferay.exception.NoSuchCasteCategoryException;
import com.adjecti.mdm.liferay.model.CasteCategory;
import com.adjecti.mdm.liferay.model.impl.CasteCategoryImpl;
import com.adjecti.mdm.liferay.model.impl.CasteCategoryModelImpl;
import com.adjecti.mdm.liferay.service.persistence.CasteCategoryPersistence;
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
 * The persistence implementation for the caste category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CasteCategoryPersistence.class)
public class CasteCategoryPersistenceImpl
	extends BasePersistenceImpl<CasteCategory>
	implements CasteCategoryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CasteCategoryUtil</code> to access the caste category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CasteCategoryImpl.class.getName();

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
	 * Returns all the caste categories where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching caste categories
	 */
	@Override
	public List<CasteCategory> findByName(String name) {
		return findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the caste categories where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasteCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of caste categories
	 * @param end the upper bound of the range of caste categories (not inclusive)
	 * @return the range of matching caste categories
	 */
	@Override
	public List<CasteCategory> findByName(String name, int start, int end) {
		return findByName(name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the caste categories where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasteCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of caste categories
	 * @param end the upper bound of the range of caste categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching caste categories
	 */
	@Override
	public List<CasteCategory> findByName(
		String name, int start, int end,
		OrderByComparator<CasteCategory> orderByComparator) {

		return findByName(name, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the caste categories where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasteCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of caste categories
	 * @param end the upper bound of the range of caste categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching caste categories
	 */
	@Override
	public List<CasteCategory> findByName(
		String name, int start, int end,
		OrderByComparator<CasteCategory> orderByComparator,
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

		List<CasteCategory> list = null;

		if (useFinderCache) {
			list = (List<CasteCategory>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CasteCategory casteCategory : list) {
					if (!name.equals(casteCategory.getName())) {
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

			sb.append(_SQL_SELECT_CASTECATEGORY_WHERE);

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
				sb.append(CasteCategoryModelImpl.ORDER_BY_JPQL);
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

				list = (List<CasteCategory>)QueryUtil.list(
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
	 * Returns the first caste category in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching caste category
	 * @throws NoSuchCasteCategoryException if a matching caste category could not be found
	 */
	@Override
	public CasteCategory findByName_First(
			String name, OrderByComparator<CasteCategory> orderByComparator)
		throws NoSuchCasteCategoryException {

		CasteCategory casteCategory = fetchByName_First(
			name, orderByComparator);

		if (casteCategory != null) {
			return casteCategory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchCasteCategoryException(sb.toString());
	}

	/**
	 * Returns the first caste category in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching caste category, or <code>null</code> if a matching caste category could not be found
	 */
	@Override
	public CasteCategory fetchByName_First(
		String name, OrderByComparator<CasteCategory> orderByComparator) {

		List<CasteCategory> list = findByName(name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last caste category in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching caste category
	 * @throws NoSuchCasteCategoryException if a matching caste category could not be found
	 */
	@Override
	public CasteCategory findByName_Last(
			String name, OrderByComparator<CasteCategory> orderByComparator)
		throws NoSuchCasteCategoryException {

		CasteCategory casteCategory = fetchByName_Last(name, orderByComparator);

		if (casteCategory != null) {
			return casteCategory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchCasteCategoryException(sb.toString());
	}

	/**
	 * Returns the last caste category in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching caste category, or <code>null</code> if a matching caste category could not be found
	 */
	@Override
	public CasteCategory fetchByName_Last(
		String name, OrderByComparator<CasteCategory> orderByComparator) {

		int count = countByName(name);

		if (count == 0) {
			return null;
		}

		List<CasteCategory> list = findByName(
			name, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the caste categories before and after the current caste category in the ordered set where name = &#63;.
	 *
	 * @param casteCategoryId the primary key of the current caste category
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next caste category
	 * @throws NoSuchCasteCategoryException if a caste category with the primary key could not be found
	 */
	@Override
	public CasteCategory[] findByName_PrevAndNext(
			long casteCategoryId, String name,
			OrderByComparator<CasteCategory> orderByComparator)
		throws NoSuchCasteCategoryException {

		name = Objects.toString(name, "");

		CasteCategory casteCategory = findByPrimaryKey(casteCategoryId);

		Session session = null;

		try {
			session = openSession();

			CasteCategory[] array = new CasteCategoryImpl[3];

			array[0] = getByName_PrevAndNext(
				session, casteCategory, name, orderByComparator, true);

			array[1] = casteCategory;

			array[2] = getByName_PrevAndNext(
				session, casteCategory, name, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CasteCategory getByName_PrevAndNext(
		Session session, CasteCategory casteCategory, String name,
		OrderByComparator<CasteCategory> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CASTECATEGORY_WHERE);

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
			sb.append(CasteCategoryModelImpl.ORDER_BY_JPQL);
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
						casteCategory)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CasteCategory> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the caste categories where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	@Override
	public void removeByName(String name) {
		for (CasteCategory casteCategory :
				findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(casteCategory);
		}
	}

	/**
	 * Returns the number of caste categories where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching caste categories
	 */
	@Override
	public int countByName(String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByName;

		Object[] finderArgs = new Object[] {name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CASTECATEGORY_WHERE);

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
		"lower(casteCategory.name) = ?";

	private static final String _FINDER_COLUMN_NAME_NAME_3 =
		"(casteCategory.name IS NULL OR casteCategory.name = '')";

	public CasteCategoryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("code", "code_");

		setDBColumnNames(dbColumnNames);

		setModelClass(CasteCategory.class);

		setModelImplClass(CasteCategoryImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the caste category in the entity cache if it is enabled.
	 *
	 * @param casteCategory the caste category
	 */
	@Override
	public void cacheResult(CasteCategory casteCategory) {
		entityCache.putResult(
			CasteCategoryImpl.class, casteCategory.getPrimaryKey(),
			casteCategory);
	}

	/**
	 * Caches the caste categories in the entity cache if it is enabled.
	 *
	 * @param casteCategories the caste categories
	 */
	@Override
	public void cacheResult(List<CasteCategory> casteCategories) {
		for (CasteCategory casteCategory : casteCategories) {
			if (entityCache.getResult(
					CasteCategoryImpl.class, casteCategory.getPrimaryKey()) ==
						null) {

				cacheResult(casteCategory);
			}
		}
	}

	/**
	 * Clears the cache for all caste categories.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CasteCategoryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the caste category.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CasteCategory casteCategory) {
		entityCache.removeResult(CasteCategoryImpl.class, casteCategory);
	}

	@Override
	public void clearCache(List<CasteCategory> casteCategories) {
		for (CasteCategory casteCategory : casteCategories) {
			entityCache.removeResult(CasteCategoryImpl.class, casteCategory);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CasteCategoryImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new caste category with the primary key. Does not add the caste category to the database.
	 *
	 * @param casteCategoryId the primary key for the new caste category
	 * @return the new caste category
	 */
	@Override
	public CasteCategory create(long casteCategoryId) {
		CasteCategory casteCategory = new CasteCategoryImpl();

		casteCategory.setNew(true);
		casteCategory.setPrimaryKey(casteCategoryId);

		casteCategory.setCompanyId(CompanyThreadLocal.getCompanyId());

		return casteCategory;
	}

	/**
	 * Removes the caste category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param casteCategoryId the primary key of the caste category
	 * @return the caste category that was removed
	 * @throws NoSuchCasteCategoryException if a caste category with the primary key could not be found
	 */
	@Override
	public CasteCategory remove(long casteCategoryId)
		throws NoSuchCasteCategoryException {

		return remove((Serializable)casteCategoryId);
	}

	/**
	 * Removes the caste category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the caste category
	 * @return the caste category that was removed
	 * @throws NoSuchCasteCategoryException if a caste category with the primary key could not be found
	 */
	@Override
	public CasteCategory remove(Serializable primaryKey)
		throws NoSuchCasteCategoryException {

		Session session = null;

		try {
			session = openSession();

			CasteCategory casteCategory = (CasteCategory)session.get(
				CasteCategoryImpl.class, primaryKey);

			if (casteCategory == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCasteCategoryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(casteCategory);
		}
		catch (NoSuchCasteCategoryException noSuchEntityException) {
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
	protected CasteCategory removeImpl(CasteCategory casteCategory) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(casteCategory)) {
				casteCategory = (CasteCategory)session.get(
					CasteCategoryImpl.class, casteCategory.getPrimaryKeyObj());
			}

			if (casteCategory != null) {
				session.delete(casteCategory);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (casteCategory != null) {
			clearCache(casteCategory);
		}

		return casteCategory;
	}

	@Override
	public CasteCategory updateImpl(CasteCategory casteCategory) {
		boolean isNew = casteCategory.isNew();

		if (!(casteCategory instanceof CasteCategoryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(casteCategory.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					casteCategory);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in casteCategory proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CasteCategory implementation " +
					casteCategory.getClass());
		}

		CasteCategoryModelImpl casteCategoryModelImpl =
			(CasteCategoryModelImpl)casteCategory;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (casteCategory.getCreateDate() == null)) {
			if (serviceContext == null) {
				casteCategory.setCreateDate(now);
			}
			else {
				casteCategory.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!casteCategoryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				casteCategory.setModifiedDate(now);
			}
			else {
				casteCategory.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(casteCategory);
			}
			else {
				casteCategory = (CasteCategory)session.merge(casteCategory);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			CasteCategoryImpl.class, casteCategoryModelImpl, false, true);

		if (isNew) {
			casteCategory.setNew(false);
		}

		casteCategory.resetOriginalValues();

		return casteCategory;
	}

	/**
	 * Returns the caste category with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the caste category
	 * @return the caste category
	 * @throws NoSuchCasteCategoryException if a caste category with the primary key could not be found
	 */
	@Override
	public CasteCategory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCasteCategoryException {

		CasteCategory casteCategory = fetchByPrimaryKey(primaryKey);

		if (casteCategory == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCasteCategoryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return casteCategory;
	}

	/**
	 * Returns the caste category with the primary key or throws a <code>NoSuchCasteCategoryException</code> if it could not be found.
	 *
	 * @param casteCategoryId the primary key of the caste category
	 * @return the caste category
	 * @throws NoSuchCasteCategoryException if a caste category with the primary key could not be found
	 */
	@Override
	public CasteCategory findByPrimaryKey(long casteCategoryId)
		throws NoSuchCasteCategoryException {

		return findByPrimaryKey((Serializable)casteCategoryId);
	}

	/**
	 * Returns the caste category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param casteCategoryId the primary key of the caste category
	 * @return the caste category, or <code>null</code> if a caste category with the primary key could not be found
	 */
	@Override
	public CasteCategory fetchByPrimaryKey(long casteCategoryId) {
		return fetchByPrimaryKey((Serializable)casteCategoryId);
	}

	/**
	 * Returns all the caste categories.
	 *
	 * @return the caste categories
	 */
	@Override
	public List<CasteCategory> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the caste categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasteCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of caste categories
	 * @param end the upper bound of the range of caste categories (not inclusive)
	 * @return the range of caste categories
	 */
	@Override
	public List<CasteCategory> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the caste categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasteCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of caste categories
	 * @param end the upper bound of the range of caste categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of caste categories
	 */
	@Override
	public List<CasteCategory> findAll(
		int start, int end,
		OrderByComparator<CasteCategory> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the caste categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasteCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of caste categories
	 * @param end the upper bound of the range of caste categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of caste categories
	 */
	@Override
	public List<CasteCategory> findAll(
		int start, int end, OrderByComparator<CasteCategory> orderByComparator,
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

		List<CasteCategory> list = null;

		if (useFinderCache) {
			list = (List<CasteCategory>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CASTECATEGORY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CASTECATEGORY;

				sql = sql.concat(CasteCategoryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CasteCategory>)QueryUtil.list(
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
	 * Removes all the caste categories from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CasteCategory casteCategory : findAll()) {
			remove(casteCategory);
		}
	}

	/**
	 * Returns the number of caste categories.
	 *
	 * @return the number of caste categories
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CASTECATEGORY);

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
		return "casteCategoryId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CASTECATEGORY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CasteCategoryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the caste category persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new CasteCategoryModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", CasteCategory.class.getName()));

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
		entityCache.removeCache(CasteCategoryImpl.class.getName());

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

	private static final String _SQL_SELECT_CASTECATEGORY =
		"SELECT casteCategory FROM CasteCategory casteCategory";

	private static final String _SQL_SELECT_CASTECATEGORY_WHERE =
		"SELECT casteCategory FROM CasteCategory casteCategory WHERE ";

	private static final String _SQL_COUNT_CASTECATEGORY =
		"SELECT COUNT(casteCategory) FROM CasteCategory casteCategory";

	private static final String _SQL_COUNT_CASTECATEGORY_WHERE =
		"SELECT COUNT(casteCategory) FROM CasteCategory casteCategory WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "casteCategory.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CasteCategory exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CasteCategory exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CasteCategoryPersistenceImpl.class);

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

	private static class CasteCategoryModelArgumentsResolver
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

			CasteCategoryModelImpl casteCategoryModelImpl =
				(CasteCategoryModelImpl)baseModel;

			long columnBitmask = casteCategoryModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(casteCategoryModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						casteCategoryModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(casteCategoryModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			CasteCategoryModelImpl casteCategoryModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						casteCategoryModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = casteCategoryModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}