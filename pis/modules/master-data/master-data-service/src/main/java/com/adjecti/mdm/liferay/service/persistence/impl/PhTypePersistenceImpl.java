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

import com.adjecti.mdm.liferay.exception.NoSuchPhTypeException;
import com.adjecti.mdm.liferay.model.PhType;
import com.adjecti.mdm.liferay.model.impl.PhTypeImpl;
import com.adjecti.mdm.liferay.model.impl.PhTypeModelImpl;
import com.adjecti.mdm.liferay.service.persistence.PhTypePersistence;
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
 * The persistence implementation for the ph type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PhTypePersistence.class)
public class PhTypePersistenceImpl
	extends BasePersistenceImpl<PhType> implements PhTypePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PhTypeUtil</code> to access the ph type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PhTypeImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public PhTypePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("code", "code_");

		setDBColumnNames(dbColumnNames);

		setModelClass(PhType.class);

		setModelImplClass(PhTypeImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the ph type in the entity cache if it is enabled.
	 *
	 * @param phType the ph type
	 */
	@Override
	public void cacheResult(PhType phType) {
		entityCache.putResult(PhTypeImpl.class, phType.getPrimaryKey(), phType);
	}

	/**
	 * Caches the ph types in the entity cache if it is enabled.
	 *
	 * @param phTypes the ph types
	 */
	@Override
	public void cacheResult(List<PhType> phTypes) {
		for (PhType phType : phTypes) {
			if (entityCache.getResult(
					PhTypeImpl.class, phType.getPrimaryKey()) == null) {

				cacheResult(phType);
			}
		}
	}

	/**
	 * Clears the cache for all ph types.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PhTypeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ph type.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PhType phType) {
		entityCache.removeResult(PhTypeImpl.class, phType);
	}

	@Override
	public void clearCache(List<PhType> phTypes) {
		for (PhType phType : phTypes) {
			entityCache.removeResult(PhTypeImpl.class, phType);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PhTypeImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new ph type with the primary key. Does not add the ph type to the database.
	 *
	 * @param phTypeId the primary key for the new ph type
	 * @return the new ph type
	 */
	@Override
	public PhType create(long phTypeId) {
		PhType phType = new PhTypeImpl();

		phType.setNew(true);
		phType.setPrimaryKey(phTypeId);

		phType.setCompanyId(CompanyThreadLocal.getCompanyId());

		return phType;
	}

	/**
	 * Removes the ph type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param phTypeId the primary key of the ph type
	 * @return the ph type that was removed
	 * @throws NoSuchPhTypeException if a ph type with the primary key could not be found
	 */
	@Override
	public PhType remove(long phTypeId) throws NoSuchPhTypeException {
		return remove((Serializable)phTypeId);
	}

	/**
	 * Removes the ph type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ph type
	 * @return the ph type that was removed
	 * @throws NoSuchPhTypeException if a ph type with the primary key could not be found
	 */
	@Override
	public PhType remove(Serializable primaryKey) throws NoSuchPhTypeException {
		Session session = null;

		try {
			session = openSession();

			PhType phType = (PhType)session.get(PhTypeImpl.class, primaryKey);

			if (phType == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPhTypeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(phType);
		}
		catch (NoSuchPhTypeException noSuchEntityException) {
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
	protected PhType removeImpl(PhType phType) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(phType)) {
				phType = (PhType)session.get(
					PhTypeImpl.class, phType.getPrimaryKeyObj());
			}

			if (phType != null) {
				session.delete(phType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (phType != null) {
			clearCache(phType);
		}

		return phType;
	}

	@Override
	public PhType updateImpl(PhType phType) {
		boolean isNew = phType.isNew();

		if (!(phType instanceof PhTypeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(phType.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(phType);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in phType proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PhType implementation " +
					phType.getClass());
		}

		PhTypeModelImpl phTypeModelImpl = (PhTypeModelImpl)phType;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (phType.getCreateDate() == null)) {
			if (serviceContext == null) {
				phType.setCreateDate(now);
			}
			else {
				phType.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!phTypeModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				phType.setModifiedDate(now);
			}
			else {
				phType.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(phType);
			}
			else {
				phType = (PhType)session.merge(phType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(PhTypeImpl.class, phType, false, true);

		if (isNew) {
			phType.setNew(false);
		}

		phType.resetOriginalValues();

		return phType;
	}

	/**
	 * Returns the ph type with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ph type
	 * @return the ph type
	 * @throws NoSuchPhTypeException if a ph type with the primary key could not be found
	 */
	@Override
	public PhType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPhTypeException {

		PhType phType = fetchByPrimaryKey(primaryKey);

		if (phType == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPhTypeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return phType;
	}

	/**
	 * Returns the ph type with the primary key or throws a <code>NoSuchPhTypeException</code> if it could not be found.
	 *
	 * @param phTypeId the primary key of the ph type
	 * @return the ph type
	 * @throws NoSuchPhTypeException if a ph type with the primary key could not be found
	 */
	@Override
	public PhType findByPrimaryKey(long phTypeId) throws NoSuchPhTypeException {
		return findByPrimaryKey((Serializable)phTypeId);
	}

	/**
	 * Returns the ph type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param phTypeId the primary key of the ph type
	 * @return the ph type, or <code>null</code> if a ph type with the primary key could not be found
	 */
	@Override
	public PhType fetchByPrimaryKey(long phTypeId) {
		return fetchByPrimaryKey((Serializable)phTypeId);
	}

	/**
	 * Returns all the ph types.
	 *
	 * @return the ph types
	 */
	@Override
	public List<PhType> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ph types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ph types
	 * @param end the upper bound of the range of ph types (not inclusive)
	 * @return the range of ph types
	 */
	@Override
	public List<PhType> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ph types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ph types
	 * @param end the upper bound of the range of ph types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ph types
	 */
	@Override
	public List<PhType> findAll(
		int start, int end, OrderByComparator<PhType> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ph types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ph types
	 * @param end the upper bound of the range of ph types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ph types
	 */
	@Override
	public List<PhType> findAll(
		int start, int end, OrderByComparator<PhType> orderByComparator,
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

		List<PhType> list = null;

		if (useFinderCache) {
			list = (List<PhType>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PHTYPE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PHTYPE;

				sql = sql.concat(PhTypeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PhType>)QueryUtil.list(
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
	 * Removes all the ph types from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PhType phType : findAll()) {
			remove(phType);
		}
	}

	/**
	 * Returns the number of ph types.
	 *
	 * @return the number of ph types
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PHTYPE);

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
		return "phTypeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PHTYPE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PhTypeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the ph type persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new PhTypeModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", PhType.class.getName()));

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
		entityCache.removeCache(PhTypeImpl.class.getName());

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

	private static final String _SQL_SELECT_PHTYPE =
		"SELECT phType FROM PhType phType";

	private static final String _SQL_COUNT_PHTYPE =
		"SELECT COUNT(phType) FROM PhType phType";

	private static final String _ORDER_BY_ENTITY_ALIAS = "phType.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PhType exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		PhTypePersistenceImpl.class);

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

	private static class PhTypeModelArgumentsResolver
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

			PhTypeModelImpl phTypeModelImpl = (PhTypeModelImpl)baseModel;

			long columnBitmask = phTypeModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(phTypeModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |= phTypeModelImpl.getColumnBitmask(
						columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(phTypeModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			PhTypeModelImpl phTypeModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = phTypeModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = phTypeModelImpl.getColumnValue(columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}