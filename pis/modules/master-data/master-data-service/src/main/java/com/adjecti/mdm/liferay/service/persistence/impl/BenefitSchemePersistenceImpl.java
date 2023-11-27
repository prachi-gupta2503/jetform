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

import com.adjecti.mdm.liferay.exception.NoSuchBenefitSchemeException;
import com.adjecti.mdm.liferay.model.BenefitScheme;
import com.adjecti.mdm.liferay.model.impl.BenefitSchemeImpl;
import com.adjecti.mdm.liferay.model.impl.BenefitSchemeModelImpl;
import com.adjecti.mdm.liferay.service.persistence.BenefitSchemePersistence;
import com.adjecti.mdm.liferay.service.persistence.impl.constants.mdmPersistenceConstants;

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
import com.liferay.portal.kernel.util.SetUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
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
 * The persistence implementation for the benefit scheme service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = BenefitSchemePersistence.class)
public class BenefitSchemePersistenceImpl
	extends BasePersistenceImpl<BenefitScheme>
	implements BenefitSchemePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>BenefitSchemeUtil</code> to access the benefit scheme persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		BenefitSchemeImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public BenefitSchemePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");
		dbColumnNames.put("code", "code_");

		setDBColumnNames(dbColumnNames);

		setModelClass(BenefitScheme.class);

		setModelImplClass(BenefitSchemeImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the benefit scheme in the entity cache if it is enabled.
	 *
	 * @param benefitScheme the benefit scheme
	 */
	@Override
	public void cacheResult(BenefitScheme benefitScheme) {
		entityCache.putResult(
			BenefitSchemeImpl.class, benefitScheme.getPrimaryKey(),
			benefitScheme);
	}

	/**
	 * Caches the benefit schemes in the entity cache if it is enabled.
	 *
	 * @param benefitSchemes the benefit schemes
	 */
	@Override
	public void cacheResult(List<BenefitScheme> benefitSchemes) {
		for (BenefitScheme benefitScheme : benefitSchemes) {
			if (entityCache.getResult(
					BenefitSchemeImpl.class, benefitScheme.getPrimaryKey()) ==
						null) {

				cacheResult(benefitScheme);
			}
		}
	}

	/**
	 * Clears the cache for all benefit schemes.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BenefitSchemeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the benefit scheme.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BenefitScheme benefitScheme) {
		entityCache.removeResult(BenefitSchemeImpl.class, benefitScheme);
	}

	@Override
	public void clearCache(List<BenefitScheme> benefitSchemes) {
		for (BenefitScheme benefitScheme : benefitSchemes) {
			entityCache.removeResult(BenefitSchemeImpl.class, benefitScheme);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(BenefitSchemeImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new benefit scheme with the primary key. Does not add the benefit scheme to the database.
	 *
	 * @param benefitSchemeId the primary key for the new benefit scheme
	 * @return the new benefit scheme
	 */
	@Override
	public BenefitScheme create(long benefitSchemeId) {
		BenefitScheme benefitScheme = new BenefitSchemeImpl();

		benefitScheme.setNew(true);
		benefitScheme.setPrimaryKey(benefitSchemeId);

		benefitScheme.setCompanyId(CompanyThreadLocal.getCompanyId());

		return benefitScheme;
	}

	/**
	 * Removes the benefit scheme with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param benefitSchemeId the primary key of the benefit scheme
	 * @return the benefit scheme that was removed
	 * @throws NoSuchBenefitSchemeException if a benefit scheme with the primary key could not be found
	 */
	@Override
	public BenefitScheme remove(long benefitSchemeId)
		throws NoSuchBenefitSchemeException {

		return remove((Serializable)benefitSchemeId);
	}

	/**
	 * Removes the benefit scheme with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the benefit scheme
	 * @return the benefit scheme that was removed
	 * @throws NoSuchBenefitSchemeException if a benefit scheme with the primary key could not be found
	 */
	@Override
	public BenefitScheme remove(Serializable primaryKey)
		throws NoSuchBenefitSchemeException {

		Session session = null;

		try {
			session = openSession();

			BenefitScheme benefitScheme = (BenefitScheme)session.get(
				BenefitSchemeImpl.class, primaryKey);

			if (benefitScheme == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBenefitSchemeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(benefitScheme);
		}
		catch (NoSuchBenefitSchemeException noSuchEntityException) {
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
	protected BenefitScheme removeImpl(BenefitScheme benefitScheme) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(benefitScheme)) {
				benefitScheme = (BenefitScheme)session.get(
					BenefitSchemeImpl.class, benefitScheme.getPrimaryKeyObj());
			}

			if (benefitScheme != null) {
				session.delete(benefitScheme);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (benefitScheme != null) {
			clearCache(benefitScheme);
		}

		return benefitScheme;
	}

	@Override
	public BenefitScheme updateImpl(BenefitScheme benefitScheme) {
		boolean isNew = benefitScheme.isNew();

		if (!(benefitScheme instanceof BenefitSchemeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(benefitScheme.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					benefitScheme);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in benefitScheme proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom BenefitScheme implementation " +
					benefitScheme.getClass());
		}

		BenefitSchemeModelImpl benefitSchemeModelImpl =
			(BenefitSchemeModelImpl)benefitScheme;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (benefitScheme.getCreateDate() == null)) {
			if (serviceContext == null) {
				benefitScheme.setCreateDate(now);
			}
			else {
				benefitScheme.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!benefitSchemeModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				benefitScheme.setModifiedDate(now);
			}
			else {
				benefitScheme.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(benefitScheme);
			}
			else {
				benefitScheme = (BenefitScheme)session.merge(benefitScheme);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			BenefitSchemeImpl.class, benefitScheme, false, true);

		if (isNew) {
			benefitScheme.setNew(false);
		}

		benefitScheme.resetOriginalValues();

		return benefitScheme;
	}

	/**
	 * Returns the benefit scheme with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the benefit scheme
	 * @return the benefit scheme
	 * @throws NoSuchBenefitSchemeException if a benefit scheme with the primary key could not be found
	 */
	@Override
	public BenefitScheme findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBenefitSchemeException {

		BenefitScheme benefitScheme = fetchByPrimaryKey(primaryKey);

		if (benefitScheme == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBenefitSchemeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return benefitScheme;
	}

	/**
	 * Returns the benefit scheme with the primary key or throws a <code>NoSuchBenefitSchemeException</code> if it could not be found.
	 *
	 * @param benefitSchemeId the primary key of the benefit scheme
	 * @return the benefit scheme
	 * @throws NoSuchBenefitSchemeException if a benefit scheme with the primary key could not be found
	 */
	@Override
	public BenefitScheme findByPrimaryKey(long benefitSchemeId)
		throws NoSuchBenefitSchemeException {

		return findByPrimaryKey((Serializable)benefitSchemeId);
	}

	/**
	 * Returns the benefit scheme with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param benefitSchemeId the primary key of the benefit scheme
	 * @return the benefit scheme, or <code>null</code> if a benefit scheme with the primary key could not be found
	 */
	@Override
	public BenefitScheme fetchByPrimaryKey(long benefitSchemeId) {
		return fetchByPrimaryKey((Serializable)benefitSchemeId);
	}

	/**
	 * Returns all the benefit schemes.
	 *
	 * @return the benefit schemes
	 */
	@Override
	public List<BenefitScheme> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the benefit schemes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BenefitSchemeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of benefit schemes
	 * @param end the upper bound of the range of benefit schemes (not inclusive)
	 * @return the range of benefit schemes
	 */
	@Override
	public List<BenefitScheme> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the benefit schemes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BenefitSchemeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of benefit schemes
	 * @param end the upper bound of the range of benefit schemes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of benefit schemes
	 */
	@Override
	public List<BenefitScheme> findAll(
		int start, int end,
		OrderByComparator<BenefitScheme> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the benefit schemes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BenefitSchemeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of benefit schemes
	 * @param end the upper bound of the range of benefit schemes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of benefit schemes
	 */
	@Override
	public List<BenefitScheme> findAll(
		int start, int end, OrderByComparator<BenefitScheme> orderByComparator,
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

		List<BenefitScheme> list = null;

		if (useFinderCache) {
			list = (List<BenefitScheme>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_BENEFITSCHEME);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_BENEFITSCHEME;

				sql = sql.concat(BenefitSchemeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<BenefitScheme>)QueryUtil.list(
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
	 * Removes all the benefit schemes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (BenefitScheme benefitScheme : findAll()) {
			remove(benefitScheme);
		}
	}

	/**
	 * Returns the number of benefit schemes.
	 *
	 * @return the number of benefit schemes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_BENEFITSCHEME);

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
		return "benefitSchemeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_BENEFITSCHEME;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return BenefitSchemeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the benefit scheme persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new BenefitSchemeModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", BenefitScheme.class.getName()));

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
		entityCache.removeCache(BenefitSchemeImpl.class.getName());

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

	private static final String _SQL_SELECT_BENEFITSCHEME =
		"SELECT benefitScheme FROM BenefitScheme benefitScheme";

	private static final String _SQL_COUNT_BENEFITSCHEME =
		"SELECT COUNT(benefitScheme) FROM BenefitScheme benefitScheme";

	private static final String _ORDER_BY_ENTITY_ALIAS = "benefitScheme.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No BenefitScheme exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		BenefitSchemePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"active", "code"});

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

	private static class BenefitSchemeModelArgumentsResolver
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

			BenefitSchemeModelImpl benefitSchemeModelImpl =
				(BenefitSchemeModelImpl)baseModel;

			long columnBitmask = benefitSchemeModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(benefitSchemeModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						benefitSchemeModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(benefitSchemeModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			BenefitSchemeModelImpl benefitSchemeModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						benefitSchemeModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = benefitSchemeModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}