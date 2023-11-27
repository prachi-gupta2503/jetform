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

package com.adjecti.pis.liferay.service.persistence.impl;

import com.adjecti.pis.liferay.exception.NoSuchFamilyBenefitSchemeException;
import com.adjecti.pis.liferay.model.FamilyBenefitScheme;
import com.adjecti.pis.liferay.model.impl.FamilyBenefitSchemeImpl;
import com.adjecti.pis.liferay.model.impl.FamilyBenefitSchemeModelImpl;
import com.adjecti.pis.liferay.service.persistence.FamilyBenefitSchemePersistence;
import com.adjecti.pis.liferay.service.persistence.impl.constants.pisPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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
 * The persistence implementation for the family benefit scheme service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = FamilyBenefitSchemePersistence.class)
public class FamilyBenefitSchemePersistenceImpl
	extends BasePersistenceImpl<FamilyBenefitScheme>
	implements FamilyBenefitSchemePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FamilyBenefitSchemeUtil</code> to access the family benefit scheme persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FamilyBenefitSchemeImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public FamilyBenefitSchemePersistenceImpl() {
		setModelClass(FamilyBenefitScheme.class);

		setModelImplClass(FamilyBenefitSchemeImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the family benefit scheme in the entity cache if it is enabled.
	 *
	 * @param familyBenefitScheme the family benefit scheme
	 */
	@Override
	public void cacheResult(FamilyBenefitScheme familyBenefitScheme) {
		entityCache.putResult(
			FamilyBenefitSchemeImpl.class, familyBenefitScheme.getPrimaryKey(),
			familyBenefitScheme);
	}

	/**
	 * Caches the family benefit schemes in the entity cache if it is enabled.
	 *
	 * @param familyBenefitSchemes the family benefit schemes
	 */
	@Override
	public void cacheResult(List<FamilyBenefitScheme> familyBenefitSchemes) {
		for (FamilyBenefitScheme familyBenefitScheme : familyBenefitSchemes) {
			if (entityCache.getResult(
					FamilyBenefitSchemeImpl.class,
					familyBenefitScheme.getPrimaryKey()) == null) {

				cacheResult(familyBenefitScheme);
			}
		}
	}

	/**
	 * Clears the cache for all family benefit schemes.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FamilyBenefitSchemeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the family benefit scheme.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FamilyBenefitScheme familyBenefitScheme) {
		entityCache.removeResult(
			FamilyBenefitSchemeImpl.class, familyBenefitScheme);
	}

	@Override
	public void clearCache(List<FamilyBenefitScheme> familyBenefitSchemes) {
		for (FamilyBenefitScheme familyBenefitScheme : familyBenefitSchemes) {
			entityCache.removeResult(
				FamilyBenefitSchemeImpl.class, familyBenefitScheme);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(FamilyBenefitSchemeImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new family benefit scheme with the primary key. Does not add the family benefit scheme to the database.
	 *
	 * @param familyBenefitSchemeId the primary key for the new family benefit scheme
	 * @return the new family benefit scheme
	 */
	@Override
	public FamilyBenefitScheme create(long familyBenefitSchemeId) {
		FamilyBenefitScheme familyBenefitScheme = new FamilyBenefitSchemeImpl();

		familyBenefitScheme.setNew(true);
		familyBenefitScheme.setPrimaryKey(familyBenefitSchemeId);

		familyBenefitScheme.setCompanyId(CompanyThreadLocal.getCompanyId());

		return familyBenefitScheme;
	}

	/**
	 * Removes the family benefit scheme with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param familyBenefitSchemeId the primary key of the family benefit scheme
	 * @return the family benefit scheme that was removed
	 * @throws NoSuchFamilyBenefitSchemeException if a family benefit scheme with the primary key could not be found
	 */
	@Override
	public FamilyBenefitScheme remove(long familyBenefitSchemeId)
		throws NoSuchFamilyBenefitSchemeException {

		return remove((Serializable)familyBenefitSchemeId);
	}

	/**
	 * Removes the family benefit scheme with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the family benefit scheme
	 * @return the family benefit scheme that was removed
	 * @throws NoSuchFamilyBenefitSchemeException if a family benefit scheme with the primary key could not be found
	 */
	@Override
	public FamilyBenefitScheme remove(Serializable primaryKey)
		throws NoSuchFamilyBenefitSchemeException {

		Session session = null;

		try {
			session = openSession();

			FamilyBenefitScheme familyBenefitScheme =
				(FamilyBenefitScheme)session.get(
					FamilyBenefitSchemeImpl.class, primaryKey);

			if (familyBenefitScheme == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFamilyBenefitSchemeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(familyBenefitScheme);
		}
		catch (NoSuchFamilyBenefitSchemeException noSuchEntityException) {
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
	protected FamilyBenefitScheme removeImpl(
		FamilyBenefitScheme familyBenefitScheme) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(familyBenefitScheme)) {
				familyBenefitScheme = (FamilyBenefitScheme)session.get(
					FamilyBenefitSchemeImpl.class,
					familyBenefitScheme.getPrimaryKeyObj());
			}

			if (familyBenefitScheme != null) {
				session.delete(familyBenefitScheme);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (familyBenefitScheme != null) {
			clearCache(familyBenefitScheme);
		}

		return familyBenefitScheme;
	}

	@Override
	public FamilyBenefitScheme updateImpl(
		FamilyBenefitScheme familyBenefitScheme) {

		boolean isNew = familyBenefitScheme.isNew();

		if (!(familyBenefitScheme instanceof FamilyBenefitSchemeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(familyBenefitScheme.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					familyBenefitScheme);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in familyBenefitScheme proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom FamilyBenefitScheme implementation " +
					familyBenefitScheme.getClass());
		}

		FamilyBenefitSchemeModelImpl familyBenefitSchemeModelImpl =
			(FamilyBenefitSchemeModelImpl)familyBenefitScheme;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (familyBenefitScheme.getCreateDate() == null)) {
			if (serviceContext == null) {
				familyBenefitScheme.setCreateDate(now);
			}
			else {
				familyBenefitScheme.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!familyBenefitSchemeModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				familyBenefitScheme.setModifiedDate(now);
			}
			else {
				familyBenefitScheme.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(familyBenefitScheme);
			}
			else {
				familyBenefitScheme = (FamilyBenefitScheme)session.merge(
					familyBenefitScheme);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			FamilyBenefitSchemeImpl.class, familyBenefitScheme, false, true);

		if (isNew) {
			familyBenefitScheme.setNew(false);
		}

		familyBenefitScheme.resetOriginalValues();

		return familyBenefitScheme;
	}

	/**
	 * Returns the family benefit scheme with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the family benefit scheme
	 * @return the family benefit scheme
	 * @throws NoSuchFamilyBenefitSchemeException if a family benefit scheme with the primary key could not be found
	 */
	@Override
	public FamilyBenefitScheme findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFamilyBenefitSchemeException {

		FamilyBenefitScheme familyBenefitScheme = fetchByPrimaryKey(primaryKey);

		if (familyBenefitScheme == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFamilyBenefitSchemeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return familyBenefitScheme;
	}

	/**
	 * Returns the family benefit scheme with the primary key or throws a <code>NoSuchFamilyBenefitSchemeException</code> if it could not be found.
	 *
	 * @param familyBenefitSchemeId the primary key of the family benefit scheme
	 * @return the family benefit scheme
	 * @throws NoSuchFamilyBenefitSchemeException if a family benefit scheme with the primary key could not be found
	 */
	@Override
	public FamilyBenefitScheme findByPrimaryKey(long familyBenefitSchemeId)
		throws NoSuchFamilyBenefitSchemeException {

		return findByPrimaryKey((Serializable)familyBenefitSchemeId);
	}

	/**
	 * Returns the family benefit scheme with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param familyBenefitSchemeId the primary key of the family benefit scheme
	 * @return the family benefit scheme, or <code>null</code> if a family benefit scheme with the primary key could not be found
	 */
	@Override
	public FamilyBenefitScheme fetchByPrimaryKey(long familyBenefitSchemeId) {
		return fetchByPrimaryKey((Serializable)familyBenefitSchemeId);
	}

	/**
	 * Returns all the family benefit schemes.
	 *
	 * @return the family benefit schemes
	 */
	@Override
	public List<FamilyBenefitScheme> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the family benefit schemes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FamilyBenefitSchemeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of family benefit schemes
	 * @param end the upper bound of the range of family benefit schemes (not inclusive)
	 * @return the range of family benefit schemes
	 */
	@Override
	public List<FamilyBenefitScheme> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the family benefit schemes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FamilyBenefitSchemeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of family benefit schemes
	 * @param end the upper bound of the range of family benefit schemes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of family benefit schemes
	 */
	@Override
	public List<FamilyBenefitScheme> findAll(
		int start, int end,
		OrderByComparator<FamilyBenefitScheme> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the family benefit schemes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FamilyBenefitSchemeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of family benefit schemes
	 * @param end the upper bound of the range of family benefit schemes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of family benefit schemes
	 */
	@Override
	public List<FamilyBenefitScheme> findAll(
		int start, int end,
		OrderByComparator<FamilyBenefitScheme> orderByComparator,
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

		List<FamilyBenefitScheme> list = null;

		if (useFinderCache) {
			list = (List<FamilyBenefitScheme>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_FAMILYBENEFITSCHEME);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_FAMILYBENEFITSCHEME;

				sql = sql.concat(FamilyBenefitSchemeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<FamilyBenefitScheme>)QueryUtil.list(
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
	 * Removes all the family benefit schemes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (FamilyBenefitScheme familyBenefitScheme : findAll()) {
			remove(familyBenefitScheme);
		}
	}

	/**
	 * Returns the number of family benefit schemes.
	 *
	 * @return the number of family benefit schemes
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
					_SQL_COUNT_FAMILYBENEFITSCHEME);

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
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "familyBenefitSchemeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_FAMILYBENEFITSCHEME;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FamilyBenefitSchemeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the family benefit scheme persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new FamilyBenefitSchemeModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", FamilyBenefitScheme.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(FamilyBenefitSchemeImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	@Override
	@Reference(
		target = pisPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = pisPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = pisPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_FAMILYBENEFITSCHEME =
		"SELECT familyBenefitScheme FROM FamilyBenefitScheme familyBenefitScheme";

	private static final String _SQL_COUNT_FAMILYBENEFITSCHEME =
		"SELECT COUNT(familyBenefitScheme) FROM FamilyBenefitScheme familyBenefitScheme";

	private static final String _ORDER_BY_ENTITY_ALIAS = "familyBenefitScheme.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No FamilyBenefitScheme exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		FamilyBenefitSchemePersistenceImpl.class);

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

	private static class FamilyBenefitSchemeModelArgumentsResolver
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

			FamilyBenefitSchemeModelImpl familyBenefitSchemeModelImpl =
				(FamilyBenefitSchemeModelImpl)baseModel;

			long columnBitmask =
				familyBenefitSchemeModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					familyBenefitSchemeModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						familyBenefitSchemeModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					familyBenefitSchemeModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			FamilyBenefitSchemeModelImpl familyBenefitSchemeModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						familyBenefitSchemeModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = familyBenefitSchemeModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}