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

import com.adjecti.mdm.liferay.exception.NoSuchDesignationScopeException;
import com.adjecti.mdm.liferay.model.DesignationScope;
import com.adjecti.mdm.liferay.model.impl.DesignationScopeImpl;
import com.adjecti.mdm.liferay.model.impl.DesignationScopeModelImpl;
import com.adjecti.mdm.liferay.service.persistence.DesignationScopePK;
import com.adjecti.mdm.liferay.service.persistence.DesignationScopePersistence;
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
 * The persistence implementation for the designation scope service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DesignationScopePersistence.class)
public class DesignationScopePersistenceImpl
	extends BasePersistenceImpl<DesignationScope>
	implements DesignationScopePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DesignationScopeUtil</code> to access the designation scope persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DesignationScopeImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByDesignationId;
	private FinderPath _finderPathWithoutPaginationFindByDesignationId;
	private FinderPath _finderPathCountByDesignationId;

	/**
	 * Returns all the designation scopes where designationId = &#63;.
	 *
	 * @param designationId the designation ID
	 * @return the matching designation scopes
	 */
	@Override
	public List<DesignationScope> findByDesignationId(long designationId) {
		return findByDesignationId(
			designationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the designation scopes where designationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationScopeModelImpl</code>.
	 * </p>
	 *
	 * @param designationId the designation ID
	 * @param start the lower bound of the range of designation scopes
	 * @param end the upper bound of the range of designation scopes (not inclusive)
	 * @return the range of matching designation scopes
	 */
	@Override
	public List<DesignationScope> findByDesignationId(
		long designationId, int start, int end) {

		return findByDesignationId(designationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the designation scopes where designationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationScopeModelImpl</code>.
	 * </p>
	 *
	 * @param designationId the designation ID
	 * @param start the lower bound of the range of designation scopes
	 * @param end the upper bound of the range of designation scopes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching designation scopes
	 */
	@Override
	public List<DesignationScope> findByDesignationId(
		long designationId, int start, int end,
		OrderByComparator<DesignationScope> orderByComparator) {

		return findByDesignationId(
			designationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the designation scopes where designationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationScopeModelImpl</code>.
	 * </p>
	 *
	 * @param designationId the designation ID
	 * @param start the lower bound of the range of designation scopes
	 * @param end the upper bound of the range of designation scopes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching designation scopes
	 */
	@Override
	public List<DesignationScope> findByDesignationId(
		long designationId, int start, int end,
		OrderByComparator<DesignationScope> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDesignationId;
				finderArgs = new Object[] {designationId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDesignationId;
			finderArgs = new Object[] {
				designationId, start, end, orderByComparator
			};
		}

		List<DesignationScope> list = null;

		if (useFinderCache) {
			list = (List<DesignationScope>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DesignationScope designationScope : list) {
					if (designationId != designationScope.getDesignationId()) {
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

			sb.append(_SQL_SELECT_DESIGNATIONSCOPE_WHERE);

			sb.append(_FINDER_COLUMN_DESIGNATIONID_DESIGNATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DesignationScopeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(designationId);

				list = (List<DesignationScope>)QueryUtil.list(
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
	 * Returns the first designation scope in the ordered set where designationId = &#63;.
	 *
	 * @param designationId the designation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation scope
	 * @throws NoSuchDesignationScopeException if a matching designation scope could not be found
	 */
	@Override
	public DesignationScope findByDesignationId_First(
			long designationId,
			OrderByComparator<DesignationScope> orderByComparator)
		throws NoSuchDesignationScopeException {

		DesignationScope designationScope = fetchByDesignationId_First(
			designationId, orderByComparator);

		if (designationScope != null) {
			return designationScope;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("designationId=");
		sb.append(designationId);

		sb.append("}");

		throw new NoSuchDesignationScopeException(sb.toString());
	}

	/**
	 * Returns the first designation scope in the ordered set where designationId = &#63;.
	 *
	 * @param designationId the designation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation scope, or <code>null</code> if a matching designation scope could not be found
	 */
	@Override
	public DesignationScope fetchByDesignationId_First(
		long designationId,
		OrderByComparator<DesignationScope> orderByComparator) {

		List<DesignationScope> list = findByDesignationId(
			designationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last designation scope in the ordered set where designationId = &#63;.
	 *
	 * @param designationId the designation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation scope
	 * @throws NoSuchDesignationScopeException if a matching designation scope could not be found
	 */
	@Override
	public DesignationScope findByDesignationId_Last(
			long designationId,
			OrderByComparator<DesignationScope> orderByComparator)
		throws NoSuchDesignationScopeException {

		DesignationScope designationScope = fetchByDesignationId_Last(
			designationId, orderByComparator);

		if (designationScope != null) {
			return designationScope;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("designationId=");
		sb.append(designationId);

		sb.append("}");

		throw new NoSuchDesignationScopeException(sb.toString());
	}

	/**
	 * Returns the last designation scope in the ordered set where designationId = &#63;.
	 *
	 * @param designationId the designation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation scope, or <code>null</code> if a matching designation scope could not be found
	 */
	@Override
	public DesignationScope fetchByDesignationId_Last(
		long designationId,
		OrderByComparator<DesignationScope> orderByComparator) {

		int count = countByDesignationId(designationId);

		if (count == 0) {
			return null;
		}

		List<DesignationScope> list = findByDesignationId(
			designationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the designation scopes before and after the current designation scope in the ordered set where designationId = &#63;.
	 *
	 * @param designationScopePK the primary key of the current designation scope
	 * @param designationId the designation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next designation scope
	 * @throws NoSuchDesignationScopeException if a designation scope with the primary key could not be found
	 */
	@Override
	public DesignationScope[] findByDesignationId_PrevAndNext(
			DesignationScopePK designationScopePK, long designationId,
			OrderByComparator<DesignationScope> orderByComparator)
		throws NoSuchDesignationScopeException {

		DesignationScope designationScope = findByPrimaryKey(
			designationScopePK);

		Session session = null;

		try {
			session = openSession();

			DesignationScope[] array = new DesignationScopeImpl[3];

			array[0] = getByDesignationId_PrevAndNext(
				session, designationScope, designationId, orderByComparator,
				true);

			array[1] = designationScope;

			array[2] = getByDesignationId_PrevAndNext(
				session, designationScope, designationId, orderByComparator,
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

	protected DesignationScope getByDesignationId_PrevAndNext(
		Session session, DesignationScope designationScope, long designationId,
		OrderByComparator<DesignationScope> orderByComparator,
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

		sb.append(_SQL_SELECT_DESIGNATIONSCOPE_WHERE);

		sb.append(_FINDER_COLUMN_DESIGNATIONID_DESIGNATIONID_2);

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
			sb.append(DesignationScopeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(designationId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						designationScope)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DesignationScope> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the designation scopes where designationId = &#63; from the database.
	 *
	 * @param designationId the designation ID
	 */
	@Override
	public void removeByDesignationId(long designationId) {
		for (DesignationScope designationScope :
				findByDesignationId(
					designationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(designationScope);
		}
	}

	/**
	 * Returns the number of designation scopes where designationId = &#63;.
	 *
	 * @param designationId the designation ID
	 * @return the number of matching designation scopes
	 */
	@Override
	public int countByDesignationId(long designationId) {
		FinderPath finderPath = _finderPathCountByDesignationId;

		Object[] finderArgs = new Object[] {designationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DESIGNATIONSCOPE_WHERE);

			sb.append(_FINDER_COLUMN_DESIGNATIONID_DESIGNATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(designationId);

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

	private static final String _FINDER_COLUMN_DESIGNATIONID_DESIGNATIONID_2 =
		"designationScope.id.designationId = ?";

	public DesignationScopePersistenceImpl() {
		setModelClass(DesignationScope.class);

		setModelImplClass(DesignationScopeImpl.class);
		setModelPKClass(DesignationScopePK.class);
	}

	/**
	 * Caches the designation scope in the entity cache if it is enabled.
	 *
	 * @param designationScope the designation scope
	 */
	@Override
	public void cacheResult(DesignationScope designationScope) {
		entityCache.putResult(
			DesignationScopeImpl.class, designationScope.getPrimaryKey(),
			designationScope);
	}

	/**
	 * Caches the designation scopes in the entity cache if it is enabled.
	 *
	 * @param designationScopes the designation scopes
	 */
	@Override
	public void cacheResult(List<DesignationScope> designationScopes) {
		for (DesignationScope designationScope : designationScopes) {
			if (entityCache.getResult(
					DesignationScopeImpl.class,
					designationScope.getPrimaryKey()) == null) {

				cacheResult(designationScope);
			}
		}
	}

	/**
	 * Clears the cache for all designation scopes.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DesignationScopeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the designation scope.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DesignationScope designationScope) {
		entityCache.removeResult(DesignationScopeImpl.class, designationScope);
	}

	@Override
	public void clearCache(List<DesignationScope> designationScopes) {
		for (DesignationScope designationScope : designationScopes) {
			entityCache.removeResult(
				DesignationScopeImpl.class, designationScope);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DesignationScopeImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new designation scope with the primary key. Does not add the designation scope to the database.
	 *
	 * @param designationScopePK the primary key for the new designation scope
	 * @return the new designation scope
	 */
	@Override
	public DesignationScope create(DesignationScopePK designationScopePK) {
		DesignationScope designationScope = new DesignationScopeImpl();

		designationScope.setNew(true);
		designationScope.setPrimaryKey(designationScopePK);

		designationScope.setCompanyId(CompanyThreadLocal.getCompanyId());

		return designationScope;
	}

	/**
	 * Removes the designation scope with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param designationScopePK the primary key of the designation scope
	 * @return the designation scope that was removed
	 * @throws NoSuchDesignationScopeException if a designation scope with the primary key could not be found
	 */
	@Override
	public DesignationScope remove(DesignationScopePK designationScopePK)
		throws NoSuchDesignationScopeException {

		return remove((Serializable)designationScopePK);
	}

	/**
	 * Removes the designation scope with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the designation scope
	 * @return the designation scope that was removed
	 * @throws NoSuchDesignationScopeException if a designation scope with the primary key could not be found
	 */
	@Override
	public DesignationScope remove(Serializable primaryKey)
		throws NoSuchDesignationScopeException {

		Session session = null;

		try {
			session = openSession();

			DesignationScope designationScope = (DesignationScope)session.get(
				DesignationScopeImpl.class, primaryKey);

			if (designationScope == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDesignationScopeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(designationScope);
		}
		catch (NoSuchDesignationScopeException noSuchEntityException) {
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
	protected DesignationScope removeImpl(DesignationScope designationScope) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(designationScope)) {
				designationScope = (DesignationScope)session.get(
					DesignationScopeImpl.class,
					designationScope.getPrimaryKeyObj());
			}

			if (designationScope != null) {
				session.delete(designationScope);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (designationScope != null) {
			clearCache(designationScope);
		}

		return designationScope;
	}

	@Override
	public DesignationScope updateImpl(DesignationScope designationScope) {
		boolean isNew = designationScope.isNew();

		if (!(designationScope instanceof DesignationScopeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(designationScope.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					designationScope);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in designationScope proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DesignationScope implementation " +
					designationScope.getClass());
		}

		DesignationScopeModelImpl designationScopeModelImpl =
			(DesignationScopeModelImpl)designationScope;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (designationScope.getCreateDate() == null)) {
			if (serviceContext == null) {
				designationScope.setCreateDate(now);
			}
			else {
				designationScope.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!designationScopeModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				designationScope.setModifiedDate(now);
			}
			else {
				designationScope.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(designationScope);
			}
			else {
				designationScope = (DesignationScope)session.merge(
					designationScope);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DesignationScopeImpl.class, designationScopeModelImpl, false, true);

		if (isNew) {
			designationScope.setNew(false);
		}

		designationScope.resetOriginalValues();

		return designationScope;
	}

	/**
	 * Returns the designation scope with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the designation scope
	 * @return the designation scope
	 * @throws NoSuchDesignationScopeException if a designation scope with the primary key could not be found
	 */
	@Override
	public DesignationScope findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDesignationScopeException {

		DesignationScope designationScope = fetchByPrimaryKey(primaryKey);

		if (designationScope == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDesignationScopeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return designationScope;
	}

	/**
	 * Returns the designation scope with the primary key or throws a <code>NoSuchDesignationScopeException</code> if it could not be found.
	 *
	 * @param designationScopePK the primary key of the designation scope
	 * @return the designation scope
	 * @throws NoSuchDesignationScopeException if a designation scope with the primary key could not be found
	 */
	@Override
	public DesignationScope findByPrimaryKey(
			DesignationScopePK designationScopePK)
		throws NoSuchDesignationScopeException {

		return findByPrimaryKey((Serializable)designationScopePK);
	}

	/**
	 * Returns the designation scope with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param designationScopePK the primary key of the designation scope
	 * @return the designation scope, or <code>null</code> if a designation scope with the primary key could not be found
	 */
	@Override
	public DesignationScope fetchByPrimaryKey(
		DesignationScopePK designationScopePK) {

		return fetchByPrimaryKey((Serializable)designationScopePK);
	}

	/**
	 * Returns all the designation scopes.
	 *
	 * @return the designation scopes
	 */
	@Override
	public List<DesignationScope> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the designation scopes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationScopeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation scopes
	 * @param end the upper bound of the range of designation scopes (not inclusive)
	 * @return the range of designation scopes
	 */
	@Override
	public List<DesignationScope> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the designation scopes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationScopeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation scopes
	 * @param end the upper bound of the range of designation scopes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of designation scopes
	 */
	@Override
	public List<DesignationScope> findAll(
		int start, int end,
		OrderByComparator<DesignationScope> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the designation scopes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationScopeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation scopes
	 * @param end the upper bound of the range of designation scopes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of designation scopes
	 */
	@Override
	public List<DesignationScope> findAll(
		int start, int end,
		OrderByComparator<DesignationScope> orderByComparator,
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

		List<DesignationScope> list = null;

		if (useFinderCache) {
			list = (List<DesignationScope>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DESIGNATIONSCOPE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DESIGNATIONSCOPE;

				sql = sql.concat(DesignationScopeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DesignationScope>)QueryUtil.list(
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
	 * Removes all the designation scopes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DesignationScope designationScope : findAll()) {
			remove(designationScope);
		}
	}

	/**
	 * Returns the number of designation scopes.
	 *
	 * @return the number of designation scopes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DESIGNATIONSCOPE);

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
	public Set<String> getCompoundPKColumnNames() {
		return _compoundPKColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "designationScopePK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DESIGNATIONSCOPE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DesignationScopeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the designation scope persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new DesignationScopeModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", DesignationScope.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByDesignationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDesignationId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"designationId"}, true);

		_finderPathWithoutPaginationFindByDesignationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDesignationId",
			new String[] {Long.class.getName()}, new String[] {"designationId"},
			true);

		_finderPathCountByDesignationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDesignationId",
			new String[] {Long.class.getName()}, new String[] {"designationId"},
			false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(DesignationScopeImpl.class.getName());

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

	private static final String _SQL_SELECT_DESIGNATIONSCOPE =
		"SELECT designationScope FROM DesignationScope designationScope";

	private static final String _SQL_SELECT_DESIGNATIONSCOPE_WHERE =
		"SELECT designationScope FROM DesignationScope designationScope WHERE ";

	private static final String _SQL_COUNT_DESIGNATIONSCOPE =
		"SELECT COUNT(designationScope) FROM DesignationScope designationScope";

	private static final String _SQL_COUNT_DESIGNATIONSCOPE_WHERE =
		"SELECT COUNT(designationScope) FROM DesignationScope designationScope WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "designationScope.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DesignationScope exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DesignationScope exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DesignationScopePersistenceImpl.class);

	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"designationScopeId", "designationId"});

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

	private static class DesignationScopeModelArgumentsResolver
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

			DesignationScopeModelImpl designationScopeModelImpl =
				(DesignationScopeModelImpl)baseModel;

			long columnBitmask = designationScopeModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					designationScopeModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						designationScopeModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					designationScopeModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			DesignationScopeModelImpl designationScopeModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						designationScopeModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = designationScopeModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}