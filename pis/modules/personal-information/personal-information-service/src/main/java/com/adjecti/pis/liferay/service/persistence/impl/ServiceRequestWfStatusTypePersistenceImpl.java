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

import com.adjecti.pis.liferay.exception.NoSuchServiceRequestWfStatusTypeException;
import com.adjecti.pis.liferay.model.ServiceRequestWfStatusType;
import com.adjecti.pis.liferay.model.impl.ServiceRequestWfStatusTypeImpl;
import com.adjecti.pis.liferay.model.impl.ServiceRequestWfStatusTypeModelImpl;
import com.adjecti.pis.liferay.service.persistence.ServiceRequestWfStatusTypePersistence;
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
 * The persistence implementation for the service request wf status type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ServiceRequestWfStatusTypePersistence.class)
public class ServiceRequestWfStatusTypePersistenceImpl
	extends BasePersistenceImpl<ServiceRequestWfStatusType>
	implements ServiceRequestWfStatusTypePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ServiceRequestWfStatusTypeUtil</code> to access the service request wf status type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ServiceRequestWfStatusTypeImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public ServiceRequestWfStatusTypePersistenceImpl() {
		setModelClass(ServiceRequestWfStatusType.class);

		setModelImplClass(ServiceRequestWfStatusTypeImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the service request wf status type in the entity cache if it is enabled.
	 *
	 * @param serviceRequestWfStatusType the service request wf status type
	 */
	@Override
	public void cacheResult(
		ServiceRequestWfStatusType serviceRequestWfStatusType) {

		entityCache.putResult(
			ServiceRequestWfStatusTypeImpl.class,
			serviceRequestWfStatusType.getPrimaryKey(),
			serviceRequestWfStatusType);
	}

	/**
	 * Caches the service request wf status types in the entity cache if it is enabled.
	 *
	 * @param serviceRequestWfStatusTypes the service request wf status types
	 */
	@Override
	public void cacheResult(
		List<ServiceRequestWfStatusType> serviceRequestWfStatusTypes) {

		for (ServiceRequestWfStatusType serviceRequestWfStatusType :
				serviceRequestWfStatusTypes) {

			if (entityCache.getResult(
					ServiceRequestWfStatusTypeImpl.class,
					serviceRequestWfStatusType.getPrimaryKey()) == null) {

				cacheResult(serviceRequestWfStatusType);
			}
		}
	}

	/**
	 * Clears the cache for all service request wf status types.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ServiceRequestWfStatusTypeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the service request wf status type.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		ServiceRequestWfStatusType serviceRequestWfStatusType) {

		entityCache.removeResult(
			ServiceRequestWfStatusTypeImpl.class, serviceRequestWfStatusType);
	}

	@Override
	public void clearCache(
		List<ServiceRequestWfStatusType> serviceRequestWfStatusTypes) {

		for (ServiceRequestWfStatusType serviceRequestWfStatusType :
				serviceRequestWfStatusTypes) {

			entityCache.removeResult(
				ServiceRequestWfStatusTypeImpl.class,
				serviceRequestWfStatusType);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				ServiceRequestWfStatusTypeImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new service request wf status type with the primary key. Does not add the service request wf status type to the database.
	 *
	 * @param serviceRequestWfStatusTypeId the primary key for the new service request wf status type
	 * @return the new service request wf status type
	 */
	@Override
	public ServiceRequestWfStatusType create(
		long serviceRequestWfStatusTypeId) {

		ServiceRequestWfStatusType serviceRequestWfStatusType =
			new ServiceRequestWfStatusTypeImpl();

		serviceRequestWfStatusType.setNew(true);
		serviceRequestWfStatusType.setPrimaryKey(serviceRequestWfStatusTypeId);

		serviceRequestWfStatusType.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return serviceRequestWfStatusType;
	}

	/**
	 * Removes the service request wf status type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param serviceRequestWfStatusTypeId the primary key of the service request wf status type
	 * @return the service request wf status type that was removed
	 * @throws NoSuchServiceRequestWfStatusTypeException if a service request wf status type with the primary key could not be found
	 */
	@Override
	public ServiceRequestWfStatusType remove(long serviceRequestWfStatusTypeId)
		throws NoSuchServiceRequestWfStatusTypeException {

		return remove((Serializable)serviceRequestWfStatusTypeId);
	}

	/**
	 * Removes the service request wf status type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the service request wf status type
	 * @return the service request wf status type that was removed
	 * @throws NoSuchServiceRequestWfStatusTypeException if a service request wf status type with the primary key could not be found
	 */
	@Override
	public ServiceRequestWfStatusType remove(Serializable primaryKey)
		throws NoSuchServiceRequestWfStatusTypeException {

		Session session = null;

		try {
			session = openSession();

			ServiceRequestWfStatusType serviceRequestWfStatusType =
				(ServiceRequestWfStatusType)session.get(
					ServiceRequestWfStatusTypeImpl.class, primaryKey);

			if (serviceRequestWfStatusType == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchServiceRequestWfStatusTypeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(serviceRequestWfStatusType);
		}
		catch (NoSuchServiceRequestWfStatusTypeException
					noSuchEntityException) {

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
	protected ServiceRequestWfStatusType removeImpl(
		ServiceRequestWfStatusType serviceRequestWfStatusType) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(serviceRequestWfStatusType)) {
				serviceRequestWfStatusType =
					(ServiceRequestWfStatusType)session.get(
						ServiceRequestWfStatusTypeImpl.class,
						serviceRequestWfStatusType.getPrimaryKeyObj());
			}

			if (serviceRequestWfStatusType != null) {
				session.delete(serviceRequestWfStatusType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (serviceRequestWfStatusType != null) {
			clearCache(serviceRequestWfStatusType);
		}

		return serviceRequestWfStatusType;
	}

	@Override
	public ServiceRequestWfStatusType updateImpl(
		ServiceRequestWfStatusType serviceRequestWfStatusType) {

		boolean isNew = serviceRequestWfStatusType.isNew();

		if (!(serviceRequestWfStatusType instanceof
				ServiceRequestWfStatusTypeModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(serviceRequestWfStatusType.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					serviceRequestWfStatusType);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in serviceRequestWfStatusType proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ServiceRequestWfStatusType implementation " +
					serviceRequestWfStatusType.getClass());
		}

		ServiceRequestWfStatusTypeModelImpl
			serviceRequestWfStatusTypeModelImpl =
				(ServiceRequestWfStatusTypeModelImpl)serviceRequestWfStatusType;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (serviceRequestWfStatusType.getCreateDate() == null)) {
			if (serviceContext == null) {
				serviceRequestWfStatusType.setCreateDate(now);
			}
			else {
				serviceRequestWfStatusType.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!serviceRequestWfStatusTypeModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				serviceRequestWfStatusType.setModifiedDate(now);
			}
			else {
				serviceRequestWfStatusType.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(serviceRequestWfStatusType);
			}
			else {
				serviceRequestWfStatusType =
					(ServiceRequestWfStatusType)session.merge(
						serviceRequestWfStatusType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ServiceRequestWfStatusTypeImpl.class, serviceRequestWfStatusType,
			false, true);

		if (isNew) {
			serviceRequestWfStatusType.setNew(false);
		}

		serviceRequestWfStatusType.resetOriginalValues();

		return serviceRequestWfStatusType;
	}

	/**
	 * Returns the service request wf status type with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the service request wf status type
	 * @return the service request wf status type
	 * @throws NoSuchServiceRequestWfStatusTypeException if a service request wf status type with the primary key could not be found
	 */
	@Override
	public ServiceRequestWfStatusType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchServiceRequestWfStatusTypeException {

		ServiceRequestWfStatusType serviceRequestWfStatusType =
			fetchByPrimaryKey(primaryKey);

		if (serviceRequestWfStatusType == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchServiceRequestWfStatusTypeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return serviceRequestWfStatusType;
	}

	/**
	 * Returns the service request wf status type with the primary key or throws a <code>NoSuchServiceRequestWfStatusTypeException</code> if it could not be found.
	 *
	 * @param serviceRequestWfStatusTypeId the primary key of the service request wf status type
	 * @return the service request wf status type
	 * @throws NoSuchServiceRequestWfStatusTypeException if a service request wf status type with the primary key could not be found
	 */
	@Override
	public ServiceRequestWfStatusType findByPrimaryKey(
			long serviceRequestWfStatusTypeId)
		throws NoSuchServiceRequestWfStatusTypeException {

		return findByPrimaryKey((Serializable)serviceRequestWfStatusTypeId);
	}

	/**
	 * Returns the service request wf status type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param serviceRequestWfStatusTypeId the primary key of the service request wf status type
	 * @return the service request wf status type, or <code>null</code> if a service request wf status type with the primary key could not be found
	 */
	@Override
	public ServiceRequestWfStatusType fetchByPrimaryKey(
		long serviceRequestWfStatusTypeId) {

		return fetchByPrimaryKey((Serializable)serviceRequestWfStatusTypeId);
	}

	/**
	 * Returns all the service request wf status types.
	 *
	 * @return the service request wf status types
	 */
	@Override
	public List<ServiceRequestWfStatusType> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service request wf status types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestWfStatusTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of service request wf status types
	 * @param end the upper bound of the range of service request wf status types (not inclusive)
	 * @return the range of service request wf status types
	 */
	@Override
	public List<ServiceRequestWfStatusType> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the service request wf status types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestWfStatusTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of service request wf status types
	 * @param end the upper bound of the range of service request wf status types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of service request wf status types
	 */
	@Override
	public List<ServiceRequestWfStatusType> findAll(
		int start, int end,
		OrderByComparator<ServiceRequestWfStatusType> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the service request wf status types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestWfStatusTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of service request wf status types
	 * @param end the upper bound of the range of service request wf status types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of service request wf status types
	 */
	@Override
	public List<ServiceRequestWfStatusType> findAll(
		int start, int end,
		OrderByComparator<ServiceRequestWfStatusType> orderByComparator,
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

		List<ServiceRequestWfStatusType> list = null;

		if (useFinderCache) {
			list = (List<ServiceRequestWfStatusType>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SERVICEREQUESTWFSTATUSTYPE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SERVICEREQUESTWFSTATUSTYPE;

				sql = sql.concat(
					ServiceRequestWfStatusTypeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ServiceRequestWfStatusType>)QueryUtil.list(
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
	 * Removes all the service request wf status types from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ServiceRequestWfStatusType serviceRequestWfStatusType :
				findAll()) {

			remove(serviceRequestWfStatusType);
		}
	}

	/**
	 * Returns the number of service request wf status types.
	 *
	 * @return the number of service request wf status types
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
					_SQL_COUNT_SERVICEREQUESTWFSTATUSTYPE);

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
		return "serviceRequestWfStatusTypeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SERVICEREQUESTWFSTATUSTYPE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ServiceRequestWfStatusTypeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the service request wf status type persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new ServiceRequestWfStatusTypeModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name",
				ServiceRequestWfStatusType.class.getName()));

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
		entityCache.removeCache(ServiceRequestWfStatusTypeImpl.class.getName());

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

	private static final String _SQL_SELECT_SERVICEREQUESTWFSTATUSTYPE =
		"SELECT serviceRequestWfStatusType FROM ServiceRequestWfStatusType serviceRequestWfStatusType";

	private static final String _SQL_COUNT_SERVICEREQUESTWFSTATUSTYPE =
		"SELECT COUNT(serviceRequestWfStatusType) FROM ServiceRequestWfStatusType serviceRequestWfStatusType";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"serviceRequestWfStatusType.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ServiceRequestWfStatusType exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		ServiceRequestWfStatusTypePersistenceImpl.class);

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

	private static class ServiceRequestWfStatusTypeModelArgumentsResolver
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

			ServiceRequestWfStatusTypeModelImpl
				serviceRequestWfStatusTypeModelImpl =
					(ServiceRequestWfStatusTypeModelImpl)baseModel;

			long columnBitmask =
				serviceRequestWfStatusTypeModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					serviceRequestWfStatusTypeModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						serviceRequestWfStatusTypeModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					serviceRequestWfStatusTypeModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			ServiceRequestWfStatusTypeModelImpl
				serviceRequestWfStatusTypeModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						serviceRequestWfStatusTypeModelImpl.
							getColumnOriginalValue(columnName);
				}
				else {
					arguments[i] =
						serviceRequestWfStatusTypeModelImpl.getColumnValue(
							columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}