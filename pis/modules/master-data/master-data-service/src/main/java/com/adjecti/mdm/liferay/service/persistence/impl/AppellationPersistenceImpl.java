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

import com.adjecti.mdm.liferay.exception.NoSuchAppellationException;
import com.adjecti.mdm.liferay.model.Appellation;
import com.adjecti.mdm.liferay.model.impl.AppellationImpl;
import com.adjecti.mdm.liferay.model.impl.AppellationModelImpl;
import com.adjecti.mdm.liferay.service.persistence.AppellationPersistence;
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
 * The persistence implementation for the appellation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = AppellationPersistence.class)
public class AppellationPersistenceImpl
	extends BasePersistenceImpl<Appellation> implements AppellationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AppellationUtil</code> to access the appellation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AppellationImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public AppellationPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("code", "code_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Appellation.class);

		setModelImplClass(AppellationImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the appellation in the entity cache if it is enabled.
	 *
	 * @param appellation the appellation
	 */
	@Override
	public void cacheResult(Appellation appellation) {
		entityCache.putResult(
			AppellationImpl.class, appellation.getPrimaryKey(), appellation);
	}

	/**
	 * Caches the appellations in the entity cache if it is enabled.
	 *
	 * @param appellations the appellations
	 */
	@Override
	public void cacheResult(List<Appellation> appellations) {
		for (Appellation appellation : appellations) {
			if (entityCache.getResult(
					AppellationImpl.class, appellation.getPrimaryKey()) ==
						null) {

				cacheResult(appellation);
			}
		}
	}

	/**
	 * Clears the cache for all appellations.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AppellationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the appellation.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Appellation appellation) {
		entityCache.removeResult(AppellationImpl.class, appellation);
	}

	@Override
	public void clearCache(List<Appellation> appellations) {
		for (Appellation appellation : appellations) {
			entityCache.removeResult(AppellationImpl.class, appellation);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AppellationImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new appellation with the primary key. Does not add the appellation to the database.
	 *
	 * @param appellationId the primary key for the new appellation
	 * @return the new appellation
	 */
	@Override
	public Appellation create(long appellationId) {
		Appellation appellation = new AppellationImpl();

		appellation.setNew(true);
		appellation.setPrimaryKey(appellationId);

		appellation.setCompanyId(CompanyThreadLocal.getCompanyId());

		return appellation;
	}

	/**
	 * Removes the appellation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appellationId the primary key of the appellation
	 * @return the appellation that was removed
	 * @throws NoSuchAppellationException if a appellation with the primary key could not be found
	 */
	@Override
	public Appellation remove(long appellationId)
		throws NoSuchAppellationException {

		return remove((Serializable)appellationId);
	}

	/**
	 * Removes the appellation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the appellation
	 * @return the appellation that was removed
	 * @throws NoSuchAppellationException if a appellation with the primary key could not be found
	 */
	@Override
	public Appellation remove(Serializable primaryKey)
		throws NoSuchAppellationException {

		Session session = null;

		try {
			session = openSession();

			Appellation appellation = (Appellation)session.get(
				AppellationImpl.class, primaryKey);

			if (appellation == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAppellationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(appellation);
		}
		catch (NoSuchAppellationException noSuchEntityException) {
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
	protected Appellation removeImpl(Appellation appellation) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(appellation)) {
				appellation = (Appellation)session.get(
					AppellationImpl.class, appellation.getPrimaryKeyObj());
			}

			if (appellation != null) {
				session.delete(appellation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (appellation != null) {
			clearCache(appellation);
		}

		return appellation;
	}

	@Override
	public Appellation updateImpl(Appellation appellation) {
		boolean isNew = appellation.isNew();

		if (!(appellation instanceof AppellationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(appellation.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(appellation);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in appellation proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Appellation implementation " +
					appellation.getClass());
		}

		AppellationModelImpl appellationModelImpl =
			(AppellationModelImpl)appellation;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (appellation.getCreateDate() == null)) {
			if (serviceContext == null) {
				appellation.setCreateDate(now);
			}
			else {
				appellation.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!appellationModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				appellation.setModifiedDate(now);
			}
			else {
				appellation.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(appellation);
			}
			else {
				appellation = (Appellation)session.merge(appellation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(AppellationImpl.class, appellation, false, true);

		if (isNew) {
			appellation.setNew(false);
		}

		appellation.resetOriginalValues();

		return appellation;
	}

	/**
	 * Returns the appellation with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the appellation
	 * @return the appellation
	 * @throws NoSuchAppellationException if a appellation with the primary key could not be found
	 */
	@Override
	public Appellation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAppellationException {

		Appellation appellation = fetchByPrimaryKey(primaryKey);

		if (appellation == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAppellationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return appellation;
	}

	/**
	 * Returns the appellation with the primary key or throws a <code>NoSuchAppellationException</code> if it could not be found.
	 *
	 * @param appellationId the primary key of the appellation
	 * @return the appellation
	 * @throws NoSuchAppellationException if a appellation with the primary key could not be found
	 */
	@Override
	public Appellation findByPrimaryKey(long appellationId)
		throws NoSuchAppellationException {

		return findByPrimaryKey((Serializable)appellationId);
	}

	/**
	 * Returns the appellation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param appellationId the primary key of the appellation
	 * @return the appellation, or <code>null</code> if a appellation with the primary key could not be found
	 */
	@Override
	public Appellation fetchByPrimaryKey(long appellationId) {
		return fetchByPrimaryKey((Serializable)appellationId);
	}

	/**
	 * Returns all the appellations.
	 *
	 * @return the appellations
	 */
	@Override
	public List<Appellation> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the appellations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppellationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appellations
	 * @param end the upper bound of the range of appellations (not inclusive)
	 * @return the range of appellations
	 */
	@Override
	public List<Appellation> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the appellations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppellationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appellations
	 * @param end the upper bound of the range of appellations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of appellations
	 */
	@Override
	public List<Appellation> findAll(
		int start, int end, OrderByComparator<Appellation> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the appellations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppellationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appellations
	 * @param end the upper bound of the range of appellations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of appellations
	 */
	@Override
	public List<Appellation> findAll(
		int start, int end, OrderByComparator<Appellation> orderByComparator,
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

		List<Appellation> list = null;

		if (useFinderCache) {
			list = (List<Appellation>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_APPELLATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_APPELLATION;

				sql = sql.concat(AppellationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Appellation>)QueryUtil.list(
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
	 * Removes all the appellations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Appellation appellation : findAll()) {
			remove(appellation);
		}
	}

	/**
	 * Returns the number of appellations.
	 *
	 * @return the number of appellations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_APPELLATION);

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
		return "appellationId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_APPELLATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AppellationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the appellation persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new AppellationModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", Appellation.class.getName()));

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
		entityCache.removeCache(AppellationImpl.class.getName());

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

	private static final String _SQL_SELECT_APPELLATION =
		"SELECT appellation FROM Appellation appellation";

	private static final String _SQL_COUNT_APPELLATION =
		"SELECT COUNT(appellation) FROM Appellation appellation";

	private static final String _ORDER_BY_ENTITY_ALIAS = "appellation.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Appellation exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		AppellationPersistenceImpl.class);

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

	private static class AppellationModelArgumentsResolver
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

			AppellationModelImpl appellationModelImpl =
				(AppellationModelImpl)baseModel;

			long columnBitmask = appellationModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(appellationModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						appellationModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(appellationModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			AppellationModelImpl appellationModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = appellationModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = appellationModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}