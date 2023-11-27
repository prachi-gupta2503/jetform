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

import com.adjecti.mdm.liferay.exception.NoSuchDeputationTypeException;
import com.adjecti.mdm.liferay.model.DeputationType;
import com.adjecti.mdm.liferay.model.impl.DeputationTypeImpl;
import com.adjecti.mdm.liferay.model.impl.DeputationTypeModelImpl;
import com.adjecti.mdm.liferay.service.persistence.DeputationTypePersistence;
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
 * The persistence implementation for the deputation type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DeputationTypePersistence.class)
public class DeputationTypePersistenceImpl
	extends BasePersistenceImpl<DeputationType>
	implements DeputationTypePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DeputationTypeUtil</code> to access the deputation type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DeputationTypeImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public DeputationTypePersistenceImpl() {
		setModelClass(DeputationType.class);

		setModelImplClass(DeputationTypeImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the deputation type in the entity cache if it is enabled.
	 *
	 * @param deputationType the deputation type
	 */
	@Override
	public void cacheResult(DeputationType deputationType) {
		entityCache.putResult(
			DeputationTypeImpl.class, deputationType.getPrimaryKey(),
			deputationType);
	}

	/**
	 * Caches the deputation types in the entity cache if it is enabled.
	 *
	 * @param deputationTypes the deputation types
	 */
	@Override
	public void cacheResult(List<DeputationType> deputationTypes) {
		for (DeputationType deputationType : deputationTypes) {
			if (entityCache.getResult(
					DeputationTypeImpl.class, deputationType.getPrimaryKey()) ==
						null) {

				cacheResult(deputationType);
			}
		}
	}

	/**
	 * Clears the cache for all deputation types.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DeputationTypeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the deputation type.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DeputationType deputationType) {
		entityCache.removeResult(DeputationTypeImpl.class, deputationType);
	}

	@Override
	public void clearCache(List<DeputationType> deputationTypes) {
		for (DeputationType deputationType : deputationTypes) {
			entityCache.removeResult(DeputationTypeImpl.class, deputationType);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DeputationTypeImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new deputation type with the primary key. Does not add the deputation type to the database.
	 *
	 * @param deputationTypeId the primary key for the new deputation type
	 * @return the new deputation type
	 */
	@Override
	public DeputationType create(long deputationTypeId) {
		DeputationType deputationType = new DeputationTypeImpl();

		deputationType.setNew(true);
		deputationType.setPrimaryKey(deputationTypeId);

		deputationType.setCompanyId(CompanyThreadLocal.getCompanyId());

		return deputationType;
	}

	/**
	 * Removes the deputation type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param deputationTypeId the primary key of the deputation type
	 * @return the deputation type that was removed
	 * @throws NoSuchDeputationTypeException if a deputation type with the primary key could not be found
	 */
	@Override
	public DeputationType remove(long deputationTypeId)
		throws NoSuchDeputationTypeException {

		return remove((Serializable)deputationTypeId);
	}

	/**
	 * Removes the deputation type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the deputation type
	 * @return the deputation type that was removed
	 * @throws NoSuchDeputationTypeException if a deputation type with the primary key could not be found
	 */
	@Override
	public DeputationType remove(Serializable primaryKey)
		throws NoSuchDeputationTypeException {

		Session session = null;

		try {
			session = openSession();

			DeputationType deputationType = (DeputationType)session.get(
				DeputationTypeImpl.class, primaryKey);

			if (deputationType == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDeputationTypeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(deputationType);
		}
		catch (NoSuchDeputationTypeException noSuchEntityException) {
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
	protected DeputationType removeImpl(DeputationType deputationType) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(deputationType)) {
				deputationType = (DeputationType)session.get(
					DeputationTypeImpl.class,
					deputationType.getPrimaryKeyObj());
			}

			if (deputationType != null) {
				session.delete(deputationType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (deputationType != null) {
			clearCache(deputationType);
		}

		return deputationType;
	}

	@Override
	public DeputationType updateImpl(DeputationType deputationType) {
		boolean isNew = deputationType.isNew();

		if (!(deputationType instanceof DeputationTypeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(deputationType.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					deputationType);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in deputationType proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DeputationType implementation " +
					deputationType.getClass());
		}

		DeputationTypeModelImpl deputationTypeModelImpl =
			(DeputationTypeModelImpl)deputationType;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (deputationType.getCreateDate() == null)) {
			if (serviceContext == null) {
				deputationType.setCreateDate(now);
			}
			else {
				deputationType.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!deputationTypeModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				deputationType.setModifiedDate(now);
			}
			else {
				deputationType.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(deputationType);
			}
			else {
				deputationType = (DeputationType)session.merge(deputationType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DeputationTypeImpl.class, deputationType, false, true);

		if (isNew) {
			deputationType.setNew(false);
		}

		deputationType.resetOriginalValues();

		return deputationType;
	}

	/**
	 * Returns the deputation type with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the deputation type
	 * @return the deputation type
	 * @throws NoSuchDeputationTypeException if a deputation type with the primary key could not be found
	 */
	@Override
	public DeputationType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDeputationTypeException {

		DeputationType deputationType = fetchByPrimaryKey(primaryKey);

		if (deputationType == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDeputationTypeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return deputationType;
	}

	/**
	 * Returns the deputation type with the primary key or throws a <code>NoSuchDeputationTypeException</code> if it could not be found.
	 *
	 * @param deputationTypeId the primary key of the deputation type
	 * @return the deputation type
	 * @throws NoSuchDeputationTypeException if a deputation type with the primary key could not be found
	 */
	@Override
	public DeputationType findByPrimaryKey(long deputationTypeId)
		throws NoSuchDeputationTypeException {

		return findByPrimaryKey((Serializable)deputationTypeId);
	}

	/**
	 * Returns the deputation type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param deputationTypeId the primary key of the deputation type
	 * @return the deputation type, or <code>null</code> if a deputation type with the primary key could not be found
	 */
	@Override
	public DeputationType fetchByPrimaryKey(long deputationTypeId) {
		return fetchByPrimaryKey((Serializable)deputationTypeId);
	}

	/**
	 * Returns all the deputation types.
	 *
	 * @return the deputation types
	 */
	@Override
	public List<DeputationType> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the deputation types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeputationTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of deputation types
	 * @param end the upper bound of the range of deputation types (not inclusive)
	 * @return the range of deputation types
	 */
	@Override
	public List<DeputationType> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the deputation types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeputationTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of deputation types
	 * @param end the upper bound of the range of deputation types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of deputation types
	 */
	@Override
	public List<DeputationType> findAll(
		int start, int end,
		OrderByComparator<DeputationType> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the deputation types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeputationTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of deputation types
	 * @param end the upper bound of the range of deputation types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of deputation types
	 */
	@Override
	public List<DeputationType> findAll(
		int start, int end, OrderByComparator<DeputationType> orderByComparator,
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

		List<DeputationType> list = null;

		if (useFinderCache) {
			list = (List<DeputationType>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DEPUTATIONTYPE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DEPUTATIONTYPE;

				sql = sql.concat(DeputationTypeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DeputationType>)QueryUtil.list(
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
	 * Removes all the deputation types from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DeputationType deputationType : findAll()) {
			remove(deputationType);
		}
	}

	/**
	 * Returns the number of deputation types.
	 *
	 * @return the number of deputation types
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DEPUTATIONTYPE);

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
		return "deputationTypeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DEPUTATIONTYPE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DeputationTypeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the deputation type persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new DeputationTypeModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", DeputationType.class.getName()));

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
		entityCache.removeCache(DeputationTypeImpl.class.getName());

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

	private static final String _SQL_SELECT_DEPUTATIONTYPE =
		"SELECT deputationType FROM DeputationType deputationType";

	private static final String _SQL_COUNT_DEPUTATIONTYPE =
		"SELECT COUNT(deputationType) FROM DeputationType deputationType";

	private static final String _ORDER_BY_ENTITY_ALIAS = "deputationType.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DeputationType exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		DeputationTypePersistenceImpl.class);

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

	private static class DeputationTypeModelArgumentsResolver
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

			DeputationTypeModelImpl deputationTypeModelImpl =
				(DeputationTypeModelImpl)baseModel;

			long columnBitmask = deputationTypeModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					deputationTypeModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						deputationTypeModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					deputationTypeModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			DeputationTypeModelImpl deputationTypeModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						deputationTypeModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = deputationTypeModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}