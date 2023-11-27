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

import com.adjecti.mdm.liferay.exception.NoSuchAmountTypeException;
import com.adjecti.mdm.liferay.model.AmountType;
import com.adjecti.mdm.liferay.model.impl.AmountTypeImpl;
import com.adjecti.mdm.liferay.model.impl.AmountTypeModelImpl;
import com.adjecti.mdm.liferay.service.persistence.AmountTypePersistence;
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
 * The persistence implementation for the amount type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = AmountTypePersistence.class)
public class AmountTypePersistenceImpl
	extends BasePersistenceImpl<AmountType> implements AmountTypePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AmountTypeUtil</code> to access the amount type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AmountTypeImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public AmountTypePersistenceImpl() {
		setModelClass(AmountType.class);

		setModelImplClass(AmountTypeImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the amount type in the entity cache if it is enabled.
	 *
	 * @param amountType the amount type
	 */
	@Override
	public void cacheResult(AmountType amountType) {
		entityCache.putResult(
			AmountTypeImpl.class, amountType.getPrimaryKey(), amountType);
	}

	/**
	 * Caches the amount types in the entity cache if it is enabled.
	 *
	 * @param amountTypes the amount types
	 */
	@Override
	public void cacheResult(List<AmountType> amountTypes) {
		for (AmountType amountType : amountTypes) {
			if (entityCache.getResult(
					AmountTypeImpl.class, amountType.getPrimaryKey()) == null) {

				cacheResult(amountType);
			}
		}
	}

	/**
	 * Clears the cache for all amount types.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AmountTypeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the amount type.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AmountType amountType) {
		entityCache.removeResult(AmountTypeImpl.class, amountType);
	}

	@Override
	public void clearCache(List<AmountType> amountTypes) {
		for (AmountType amountType : amountTypes) {
			entityCache.removeResult(AmountTypeImpl.class, amountType);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AmountTypeImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new amount type with the primary key. Does not add the amount type to the database.
	 *
	 * @param amountTypeId the primary key for the new amount type
	 * @return the new amount type
	 */
	@Override
	public AmountType create(long amountTypeId) {
		AmountType amountType = new AmountTypeImpl();

		amountType.setNew(true);
		amountType.setPrimaryKey(amountTypeId);

		amountType.setCompanyId(CompanyThreadLocal.getCompanyId());

		return amountType;
	}

	/**
	 * Removes the amount type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param amountTypeId the primary key of the amount type
	 * @return the amount type that was removed
	 * @throws NoSuchAmountTypeException if a amount type with the primary key could not be found
	 */
	@Override
	public AmountType remove(long amountTypeId)
		throws NoSuchAmountTypeException {

		return remove((Serializable)amountTypeId);
	}

	/**
	 * Removes the amount type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the amount type
	 * @return the amount type that was removed
	 * @throws NoSuchAmountTypeException if a amount type with the primary key could not be found
	 */
	@Override
	public AmountType remove(Serializable primaryKey)
		throws NoSuchAmountTypeException {

		Session session = null;

		try {
			session = openSession();

			AmountType amountType = (AmountType)session.get(
				AmountTypeImpl.class, primaryKey);

			if (amountType == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAmountTypeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(amountType);
		}
		catch (NoSuchAmountTypeException noSuchEntityException) {
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
	protected AmountType removeImpl(AmountType amountType) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(amountType)) {
				amountType = (AmountType)session.get(
					AmountTypeImpl.class, amountType.getPrimaryKeyObj());
			}

			if (amountType != null) {
				session.delete(amountType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (amountType != null) {
			clearCache(amountType);
		}

		return amountType;
	}

	@Override
	public AmountType updateImpl(AmountType amountType) {
		boolean isNew = amountType.isNew();

		if (!(amountType instanceof AmountTypeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(amountType.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(amountType);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in amountType proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AmountType implementation " +
					amountType.getClass());
		}

		AmountTypeModelImpl amountTypeModelImpl =
			(AmountTypeModelImpl)amountType;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (amountType.getCreateDate() == null)) {
			if (serviceContext == null) {
				amountType.setCreateDate(now);
			}
			else {
				amountType.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!amountTypeModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				amountType.setModifiedDate(now);
			}
			else {
				amountType.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(amountType);
			}
			else {
				amountType = (AmountType)session.merge(amountType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(AmountTypeImpl.class, amountType, false, true);

		if (isNew) {
			amountType.setNew(false);
		}

		amountType.resetOriginalValues();

		return amountType;
	}

	/**
	 * Returns the amount type with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the amount type
	 * @return the amount type
	 * @throws NoSuchAmountTypeException if a amount type with the primary key could not be found
	 */
	@Override
	public AmountType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAmountTypeException {

		AmountType amountType = fetchByPrimaryKey(primaryKey);

		if (amountType == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAmountTypeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return amountType;
	}

	/**
	 * Returns the amount type with the primary key or throws a <code>NoSuchAmountTypeException</code> if it could not be found.
	 *
	 * @param amountTypeId the primary key of the amount type
	 * @return the amount type
	 * @throws NoSuchAmountTypeException if a amount type with the primary key could not be found
	 */
	@Override
	public AmountType findByPrimaryKey(long amountTypeId)
		throws NoSuchAmountTypeException {

		return findByPrimaryKey((Serializable)amountTypeId);
	}

	/**
	 * Returns the amount type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param amountTypeId the primary key of the amount type
	 * @return the amount type, or <code>null</code> if a amount type with the primary key could not be found
	 */
	@Override
	public AmountType fetchByPrimaryKey(long amountTypeId) {
		return fetchByPrimaryKey((Serializable)amountTypeId);
	}

	/**
	 * Returns all the amount types.
	 *
	 * @return the amount types
	 */
	@Override
	public List<AmountType> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the amount types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmountTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of amount types
	 * @param end the upper bound of the range of amount types (not inclusive)
	 * @return the range of amount types
	 */
	@Override
	public List<AmountType> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the amount types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmountTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of amount types
	 * @param end the upper bound of the range of amount types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of amount types
	 */
	@Override
	public List<AmountType> findAll(
		int start, int end, OrderByComparator<AmountType> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the amount types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmountTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of amount types
	 * @param end the upper bound of the range of amount types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of amount types
	 */
	@Override
	public List<AmountType> findAll(
		int start, int end, OrderByComparator<AmountType> orderByComparator,
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

		List<AmountType> list = null;

		if (useFinderCache) {
			list = (List<AmountType>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_AMOUNTTYPE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_AMOUNTTYPE;

				sql = sql.concat(AmountTypeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AmountType>)QueryUtil.list(
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
	 * Removes all the amount types from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AmountType amountType : findAll()) {
			remove(amountType);
		}
	}

	/**
	 * Returns the number of amount types.
	 *
	 * @return the number of amount types
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_AMOUNTTYPE);

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
		return "amountTypeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_AMOUNTTYPE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AmountTypeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the amount type persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new AmountTypeModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", AmountType.class.getName()));

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
		entityCache.removeCache(AmountTypeImpl.class.getName());

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

	private static final String _SQL_SELECT_AMOUNTTYPE =
		"SELECT amountType FROM AmountType amountType";

	private static final String _SQL_COUNT_AMOUNTTYPE =
		"SELECT COUNT(amountType) FROM AmountType amountType";

	private static final String _ORDER_BY_ENTITY_ALIAS = "amountType.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AmountType exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		AmountTypePersistenceImpl.class);

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

	private static class AmountTypeModelArgumentsResolver
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

			AmountTypeModelImpl amountTypeModelImpl =
				(AmountTypeModelImpl)baseModel;

			long columnBitmask = amountTypeModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(amountTypeModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						amountTypeModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(amountTypeModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			AmountTypeModelImpl amountTypeModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = amountTypeModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = amountTypeModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}