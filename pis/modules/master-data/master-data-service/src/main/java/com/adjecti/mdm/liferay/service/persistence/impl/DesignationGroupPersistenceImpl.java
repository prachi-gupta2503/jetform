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

import com.adjecti.mdm.liferay.exception.NoSuchDesignationGroupException;
import com.adjecti.mdm.liferay.model.DesignationGroup;
import com.adjecti.mdm.liferay.model.impl.DesignationGroupImpl;
import com.adjecti.mdm.liferay.model.impl.DesignationGroupModelImpl;
import com.adjecti.mdm.liferay.service.persistence.DesignationGroupPersistence;
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
 * The persistence implementation for the designation group service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DesignationGroupPersistence.class)
public class DesignationGroupPersistenceImpl
	extends BasePersistenceImpl<DesignationGroup>
	implements DesignationGroupPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DesignationGroupUtil</code> to access the designation group persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DesignationGroupImpl.class.getName();

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
	 * Returns the designation group where code = &#63; or throws a <code>NoSuchDesignationGroupException</code> if it could not be found.
	 *
	 * @param code the code
	 * @return the matching designation group
	 * @throws NoSuchDesignationGroupException if a matching designation group could not be found
	 */
	@Override
	public DesignationGroup findByCode(String code)
		throws NoSuchDesignationGroupException {

		DesignationGroup designationGroup = fetchByCode(code);

		if (designationGroup == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("code=");
			sb.append(code);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDesignationGroupException(sb.toString());
		}

		return designationGroup;
	}

	/**
	 * Returns the designation group where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @return the matching designation group, or <code>null</code> if a matching designation group could not be found
	 */
	@Override
	public DesignationGroup fetchByCode(String code) {
		return fetchByCode(code, true);
	}

	/**
	 * Returns the designation group where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching designation group, or <code>null</code> if a matching designation group could not be found
	 */
	@Override
	public DesignationGroup fetchByCode(String code, boolean useFinderCache) {
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

		if (result instanceof DesignationGroup) {
			DesignationGroup designationGroup = (DesignationGroup)result;

			if (!Objects.equals(code, designationGroup.getCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DESIGNATIONGROUP_WHERE);

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

				List<DesignationGroup> list = query.list();

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
								"DesignationGroupPersistenceImpl.fetchByCode(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DesignationGroup designationGroup = list.get(0);

					result = designationGroup;

					cacheResult(designationGroup);
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
			return (DesignationGroup)result;
		}
	}

	/**
	 * Removes the designation group where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the designation group that was removed
	 */
	@Override
	public DesignationGroup removeByCode(String code)
		throws NoSuchDesignationGroupException {

		DesignationGroup designationGroup = findByCode(code);

		return remove(designationGroup);
	}

	/**
	 * Returns the number of designation groups where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching designation groups
	 */
	@Override
	public int countByCode(String code) {
		code = Objects.toString(code, "");

		FinderPath finderPath = _finderPathCountByCode;

		Object[] finderArgs = new Object[] {code};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DESIGNATIONGROUP_WHERE);

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
		"designationGroup.code = ?";

	private static final String _FINDER_COLUMN_CODE_CODE_3 =
		"(designationGroup.code IS NULL OR designationGroup.code = '')";

	public DesignationGroupPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("code", "code_");

		setDBColumnNames(dbColumnNames);

		setModelClass(DesignationGroup.class);

		setModelImplClass(DesignationGroupImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the designation group in the entity cache if it is enabled.
	 *
	 * @param designationGroup the designation group
	 */
	@Override
	public void cacheResult(DesignationGroup designationGroup) {
		entityCache.putResult(
			DesignationGroupImpl.class, designationGroup.getPrimaryKey(),
			designationGroup);

		finderCache.putResult(
			_finderPathFetchByCode, new Object[] {designationGroup.getCode()},
			designationGroup);
	}

	/**
	 * Caches the designation groups in the entity cache if it is enabled.
	 *
	 * @param designationGroups the designation groups
	 */
	@Override
	public void cacheResult(List<DesignationGroup> designationGroups) {
		for (DesignationGroup designationGroup : designationGroups) {
			if (entityCache.getResult(
					DesignationGroupImpl.class,
					designationGroup.getPrimaryKey()) == null) {

				cacheResult(designationGroup);
			}
		}
	}

	/**
	 * Clears the cache for all designation groups.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DesignationGroupImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the designation group.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DesignationGroup designationGroup) {
		entityCache.removeResult(DesignationGroupImpl.class, designationGroup);
	}

	@Override
	public void clearCache(List<DesignationGroup> designationGroups) {
		for (DesignationGroup designationGroup : designationGroups) {
			entityCache.removeResult(
				DesignationGroupImpl.class, designationGroup);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DesignationGroupImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DesignationGroupModelImpl designationGroupModelImpl) {

		Object[] args = new Object[] {designationGroupModelImpl.getCode()};

		finderCache.putResult(
			_finderPathCountByCode, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByCode, args, designationGroupModelImpl, false);
	}

	/**
	 * Creates a new designation group with the primary key. Does not add the designation group to the database.
	 *
	 * @param designationGroupId the primary key for the new designation group
	 * @return the new designation group
	 */
	@Override
	public DesignationGroup create(long designationGroupId) {
		DesignationGroup designationGroup = new DesignationGroupImpl();

		designationGroup.setNew(true);
		designationGroup.setPrimaryKey(designationGroupId);

		designationGroup.setCompanyId(CompanyThreadLocal.getCompanyId());

		return designationGroup;
	}

	/**
	 * Removes the designation group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param designationGroupId the primary key of the designation group
	 * @return the designation group that was removed
	 * @throws NoSuchDesignationGroupException if a designation group with the primary key could not be found
	 */
	@Override
	public DesignationGroup remove(long designationGroupId)
		throws NoSuchDesignationGroupException {

		return remove((Serializable)designationGroupId);
	}

	/**
	 * Removes the designation group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the designation group
	 * @return the designation group that was removed
	 * @throws NoSuchDesignationGroupException if a designation group with the primary key could not be found
	 */
	@Override
	public DesignationGroup remove(Serializable primaryKey)
		throws NoSuchDesignationGroupException {

		Session session = null;

		try {
			session = openSession();

			DesignationGroup designationGroup = (DesignationGroup)session.get(
				DesignationGroupImpl.class, primaryKey);

			if (designationGroup == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDesignationGroupException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(designationGroup);
		}
		catch (NoSuchDesignationGroupException noSuchEntityException) {
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
	protected DesignationGroup removeImpl(DesignationGroup designationGroup) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(designationGroup)) {
				designationGroup = (DesignationGroup)session.get(
					DesignationGroupImpl.class,
					designationGroup.getPrimaryKeyObj());
			}

			if (designationGroup != null) {
				session.delete(designationGroup);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (designationGroup != null) {
			clearCache(designationGroup);
		}

		return designationGroup;
	}

	@Override
	public DesignationGroup updateImpl(DesignationGroup designationGroup) {
		boolean isNew = designationGroup.isNew();

		if (!(designationGroup instanceof DesignationGroupModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(designationGroup.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					designationGroup);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in designationGroup proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DesignationGroup implementation " +
					designationGroup.getClass());
		}

		DesignationGroupModelImpl designationGroupModelImpl =
			(DesignationGroupModelImpl)designationGroup;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (designationGroup.getCreateDate() == null)) {
			if (serviceContext == null) {
				designationGroup.setCreateDate(now);
			}
			else {
				designationGroup.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!designationGroupModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				designationGroup.setModifiedDate(now);
			}
			else {
				designationGroup.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(designationGroup);
			}
			else {
				designationGroup = (DesignationGroup)session.merge(
					designationGroup);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DesignationGroupImpl.class, designationGroupModelImpl, false, true);

		cacheUniqueFindersCache(designationGroupModelImpl);

		if (isNew) {
			designationGroup.setNew(false);
		}

		designationGroup.resetOriginalValues();

		return designationGroup;
	}

	/**
	 * Returns the designation group with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the designation group
	 * @return the designation group
	 * @throws NoSuchDesignationGroupException if a designation group with the primary key could not be found
	 */
	@Override
	public DesignationGroup findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDesignationGroupException {

		DesignationGroup designationGroup = fetchByPrimaryKey(primaryKey);

		if (designationGroup == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDesignationGroupException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return designationGroup;
	}

	/**
	 * Returns the designation group with the primary key or throws a <code>NoSuchDesignationGroupException</code> if it could not be found.
	 *
	 * @param designationGroupId the primary key of the designation group
	 * @return the designation group
	 * @throws NoSuchDesignationGroupException if a designation group with the primary key could not be found
	 */
	@Override
	public DesignationGroup findByPrimaryKey(long designationGroupId)
		throws NoSuchDesignationGroupException {

		return findByPrimaryKey((Serializable)designationGroupId);
	}

	/**
	 * Returns the designation group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param designationGroupId the primary key of the designation group
	 * @return the designation group, or <code>null</code> if a designation group with the primary key could not be found
	 */
	@Override
	public DesignationGroup fetchByPrimaryKey(long designationGroupId) {
		return fetchByPrimaryKey((Serializable)designationGroupId);
	}

	/**
	 * Returns all the designation groups.
	 *
	 * @return the designation groups
	 */
	@Override
	public List<DesignationGroup> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the designation groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation groups
	 * @param end the upper bound of the range of designation groups (not inclusive)
	 * @return the range of designation groups
	 */
	@Override
	public List<DesignationGroup> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the designation groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation groups
	 * @param end the upper bound of the range of designation groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of designation groups
	 */
	@Override
	public List<DesignationGroup> findAll(
		int start, int end,
		OrderByComparator<DesignationGroup> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the designation groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation groups
	 * @param end the upper bound of the range of designation groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of designation groups
	 */
	@Override
	public List<DesignationGroup> findAll(
		int start, int end,
		OrderByComparator<DesignationGroup> orderByComparator,
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

		List<DesignationGroup> list = null;

		if (useFinderCache) {
			list = (List<DesignationGroup>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DESIGNATIONGROUP);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DESIGNATIONGROUP;

				sql = sql.concat(DesignationGroupModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DesignationGroup>)QueryUtil.list(
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
	 * Removes all the designation groups from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DesignationGroup designationGroup : findAll()) {
			remove(designationGroup);
		}
	}

	/**
	 * Returns the number of designation groups.
	 *
	 * @return the number of designation groups
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DESIGNATIONGROUP);

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
		return "designationGroupId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DESIGNATIONGROUP;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DesignationGroupModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the designation group persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new DesignationGroupModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", DesignationGroup.class.getName()));

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
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(DesignationGroupImpl.class.getName());

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

	private static final String _SQL_SELECT_DESIGNATIONGROUP =
		"SELECT designationGroup FROM DesignationGroup designationGroup";

	private static final String _SQL_SELECT_DESIGNATIONGROUP_WHERE =
		"SELECT designationGroup FROM DesignationGroup designationGroup WHERE ";

	private static final String _SQL_COUNT_DESIGNATIONGROUP =
		"SELECT COUNT(designationGroup) FROM DesignationGroup designationGroup";

	private static final String _SQL_COUNT_DESIGNATIONGROUP_WHERE =
		"SELECT COUNT(designationGroup) FROM DesignationGroup designationGroup WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "designationGroup.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DesignationGroup exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DesignationGroup exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DesignationGroupPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "code"});

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

	private static class DesignationGroupModelArgumentsResolver
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

			DesignationGroupModelImpl designationGroupModelImpl =
				(DesignationGroupModelImpl)baseModel;

			long columnBitmask = designationGroupModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					designationGroupModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						designationGroupModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					designationGroupModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			DesignationGroupModelImpl designationGroupModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						designationGroupModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = designationGroupModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}