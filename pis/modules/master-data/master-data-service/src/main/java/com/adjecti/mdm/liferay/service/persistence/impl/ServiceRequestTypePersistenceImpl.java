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

import com.adjecti.mdm.liferay.exception.NoSuchServiceRequestTypeException;
import com.adjecti.mdm.liferay.model.ServiceRequestType;
import com.adjecti.mdm.liferay.model.impl.ServiceRequestTypeImpl;
import com.adjecti.mdm.liferay.model.impl.ServiceRequestTypeModelImpl;
import com.adjecti.mdm.liferay.service.persistence.ServiceRequestTypePersistence;
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
 * The persistence implementation for the service request type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ServiceRequestTypePersistence.class)
public class ServiceRequestTypePersistenceImpl
	extends BasePersistenceImpl<ServiceRequestType>
	implements ServiceRequestTypePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ServiceRequestTypeUtil</code> to access the service request type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ServiceRequestTypeImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public ServiceRequestTypePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("code", "code_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ServiceRequestType.class);

		setModelImplClass(ServiceRequestTypeImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the service request type in the entity cache if it is enabled.
	 *
	 * @param serviceRequestType the service request type
	 */
	@Override
	public void cacheResult(ServiceRequestType serviceRequestType) {
		entityCache.putResult(
			ServiceRequestTypeImpl.class, serviceRequestType.getPrimaryKey(),
			serviceRequestType);
	}

	/**
	 * Caches the service request types in the entity cache if it is enabled.
	 *
	 * @param serviceRequestTypes the service request types
	 */
	@Override
	public void cacheResult(List<ServiceRequestType> serviceRequestTypes) {
		for (ServiceRequestType serviceRequestType : serviceRequestTypes) {
			if (entityCache.getResult(
					ServiceRequestTypeImpl.class,
					serviceRequestType.getPrimaryKey()) == null) {

				cacheResult(serviceRequestType);
			}
		}
	}

	/**
	 * Clears the cache for all service request types.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ServiceRequestTypeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the service request type.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ServiceRequestType serviceRequestType) {
		entityCache.removeResult(
			ServiceRequestTypeImpl.class, serviceRequestType);
	}

	@Override
	public void clearCache(List<ServiceRequestType> serviceRequestTypes) {
		for (ServiceRequestType serviceRequestType : serviceRequestTypes) {
			entityCache.removeResult(
				ServiceRequestTypeImpl.class, serviceRequestType);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ServiceRequestTypeImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new service request type with the primary key. Does not add the service request type to the database.
	 *
	 * @param serviceRequestTypeId the primary key for the new service request type
	 * @return the new service request type
	 */
	@Override
	public ServiceRequestType create(long serviceRequestTypeId) {
		ServiceRequestType serviceRequestType = new ServiceRequestTypeImpl();

		serviceRequestType.setNew(true);
		serviceRequestType.setPrimaryKey(serviceRequestTypeId);

		serviceRequestType.setCompanyId(CompanyThreadLocal.getCompanyId());

		return serviceRequestType;
	}

	/**
	 * Removes the service request type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param serviceRequestTypeId the primary key of the service request type
	 * @return the service request type that was removed
	 * @throws NoSuchServiceRequestTypeException if a service request type with the primary key could not be found
	 */
	@Override
	public ServiceRequestType remove(long serviceRequestTypeId)
		throws NoSuchServiceRequestTypeException {

		return remove((Serializable)serviceRequestTypeId);
	}

	/**
	 * Removes the service request type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the service request type
	 * @return the service request type that was removed
	 * @throws NoSuchServiceRequestTypeException if a service request type with the primary key could not be found
	 */
	@Override
	public ServiceRequestType remove(Serializable primaryKey)
		throws NoSuchServiceRequestTypeException {

		Session session = null;

		try {
			session = openSession();

			ServiceRequestType serviceRequestType =
				(ServiceRequestType)session.get(
					ServiceRequestTypeImpl.class, primaryKey);

			if (serviceRequestType == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchServiceRequestTypeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(serviceRequestType);
		}
		catch (NoSuchServiceRequestTypeException noSuchEntityException) {
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
	protected ServiceRequestType removeImpl(
		ServiceRequestType serviceRequestType) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(serviceRequestType)) {
				serviceRequestType = (ServiceRequestType)session.get(
					ServiceRequestTypeImpl.class,
					serviceRequestType.getPrimaryKeyObj());
			}

			if (serviceRequestType != null) {
				session.delete(serviceRequestType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (serviceRequestType != null) {
			clearCache(serviceRequestType);
		}

		return serviceRequestType;
	}

	@Override
	public ServiceRequestType updateImpl(
		ServiceRequestType serviceRequestType) {

		boolean isNew = serviceRequestType.isNew();

		if (!(serviceRequestType instanceof ServiceRequestTypeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(serviceRequestType.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					serviceRequestType);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in serviceRequestType proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ServiceRequestType implementation " +
					serviceRequestType.getClass());
		}

		ServiceRequestTypeModelImpl serviceRequestTypeModelImpl =
			(ServiceRequestTypeModelImpl)serviceRequestType;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (serviceRequestType.getCreateDate() == null)) {
			if (serviceContext == null) {
				serviceRequestType.setCreateDate(now);
			}
			else {
				serviceRequestType.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!serviceRequestTypeModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				serviceRequestType.setModifiedDate(now);
			}
			else {
				serviceRequestType.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(serviceRequestType);
			}
			else {
				serviceRequestType = (ServiceRequestType)session.merge(
					serviceRequestType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ServiceRequestTypeImpl.class, serviceRequestType, false, true);

		if (isNew) {
			serviceRequestType.setNew(false);
		}

		serviceRequestType.resetOriginalValues();

		return serviceRequestType;
	}

	/**
	 * Returns the service request type with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the service request type
	 * @return the service request type
	 * @throws NoSuchServiceRequestTypeException if a service request type with the primary key could not be found
	 */
	@Override
	public ServiceRequestType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchServiceRequestTypeException {

		ServiceRequestType serviceRequestType = fetchByPrimaryKey(primaryKey);

		if (serviceRequestType == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchServiceRequestTypeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return serviceRequestType;
	}

	/**
	 * Returns the service request type with the primary key or throws a <code>NoSuchServiceRequestTypeException</code> if it could not be found.
	 *
	 * @param serviceRequestTypeId the primary key of the service request type
	 * @return the service request type
	 * @throws NoSuchServiceRequestTypeException if a service request type with the primary key could not be found
	 */
	@Override
	public ServiceRequestType findByPrimaryKey(long serviceRequestTypeId)
		throws NoSuchServiceRequestTypeException {

		return findByPrimaryKey((Serializable)serviceRequestTypeId);
	}

	/**
	 * Returns the service request type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param serviceRequestTypeId the primary key of the service request type
	 * @return the service request type, or <code>null</code> if a service request type with the primary key could not be found
	 */
	@Override
	public ServiceRequestType fetchByPrimaryKey(long serviceRequestTypeId) {
		return fetchByPrimaryKey((Serializable)serviceRequestTypeId);
	}

	/**
	 * Returns all the service request types.
	 *
	 * @return the service request types
	 */
	@Override
	public List<ServiceRequestType> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service request types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of service request types
	 * @param end the upper bound of the range of service request types (not inclusive)
	 * @return the range of service request types
	 */
	@Override
	public List<ServiceRequestType> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the service request types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of service request types
	 * @param end the upper bound of the range of service request types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of service request types
	 */
	@Override
	public List<ServiceRequestType> findAll(
		int start, int end,
		OrderByComparator<ServiceRequestType> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the service request types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of service request types
	 * @param end the upper bound of the range of service request types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of service request types
	 */
	@Override
	public List<ServiceRequestType> findAll(
		int start, int end,
		OrderByComparator<ServiceRequestType> orderByComparator,
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

		List<ServiceRequestType> list = null;

		if (useFinderCache) {
			list = (List<ServiceRequestType>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SERVICEREQUESTTYPE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SERVICEREQUESTTYPE;

				sql = sql.concat(ServiceRequestTypeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ServiceRequestType>)QueryUtil.list(
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
	 * Removes all the service request types from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ServiceRequestType serviceRequestType : findAll()) {
			remove(serviceRequestType);
		}
	}

	/**
	 * Returns the number of service request types.
	 *
	 * @return the number of service request types
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
					_SQL_COUNT_SERVICEREQUESTTYPE);

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
		return "serviceRequestTypeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SERVICEREQUESTTYPE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ServiceRequestTypeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the service request type persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new ServiceRequestTypeModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", ServiceRequestType.class.getName()));

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
		entityCache.removeCache(ServiceRequestTypeImpl.class.getName());

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

	private static final String _SQL_SELECT_SERVICEREQUESTTYPE =
		"SELECT serviceRequestType FROM ServiceRequestType serviceRequestType";

	private static final String _SQL_COUNT_SERVICEREQUESTTYPE =
		"SELECT COUNT(serviceRequestType) FROM ServiceRequestType serviceRequestType";

	private static final String _ORDER_BY_ENTITY_ALIAS = "serviceRequestType.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ServiceRequestType exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		ServiceRequestTypePersistenceImpl.class);

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

	private static class ServiceRequestTypeModelArgumentsResolver
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

			ServiceRequestTypeModelImpl serviceRequestTypeModelImpl =
				(ServiceRequestTypeModelImpl)baseModel;

			long columnBitmask = serviceRequestTypeModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					serviceRequestTypeModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						serviceRequestTypeModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					serviceRequestTypeModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			ServiceRequestTypeModelImpl serviceRequestTypeModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						serviceRequestTypeModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = serviceRequestTypeModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}