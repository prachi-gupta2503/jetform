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

import com.adjecti.mdm.liferay.exception.NoSuchPayComponentException;
import com.adjecti.mdm.liferay.model.PayComponent;
import com.adjecti.mdm.liferay.model.impl.PayComponentImpl;
import com.adjecti.mdm.liferay.model.impl.PayComponentModelImpl;
import com.adjecti.mdm.liferay.service.persistence.PayComponentPersistence;
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
 * The persistence implementation for the pay component service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PayComponentPersistence.class)
public class PayComponentPersistenceImpl
	extends BasePersistenceImpl<PayComponent>
	implements PayComponentPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PayComponentUtil</code> to access the pay component persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PayComponentImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public PayComponentPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(PayComponent.class);

		setModelImplClass(PayComponentImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the pay component in the entity cache if it is enabled.
	 *
	 * @param payComponent the pay component
	 */
	@Override
	public void cacheResult(PayComponent payComponent) {
		entityCache.putResult(
			PayComponentImpl.class, payComponent.getPrimaryKey(), payComponent);
	}

	/**
	 * Caches the pay components in the entity cache if it is enabled.
	 *
	 * @param payComponents the pay components
	 */
	@Override
	public void cacheResult(List<PayComponent> payComponents) {
		for (PayComponent payComponent : payComponents) {
			if (entityCache.getResult(
					PayComponentImpl.class, payComponent.getPrimaryKey()) ==
						null) {

				cacheResult(payComponent);
			}
		}
	}

	/**
	 * Clears the cache for all pay components.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PayComponentImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the pay component.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PayComponent payComponent) {
		entityCache.removeResult(PayComponentImpl.class, payComponent);
	}

	@Override
	public void clearCache(List<PayComponent> payComponents) {
		for (PayComponent payComponent : payComponents) {
			entityCache.removeResult(PayComponentImpl.class, payComponent);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PayComponentImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new pay component with the primary key. Does not add the pay component to the database.
	 *
	 * @param payComponentId the primary key for the new pay component
	 * @return the new pay component
	 */
	@Override
	public PayComponent create(long payComponentId) {
		PayComponent payComponent = new PayComponentImpl();

		payComponent.setNew(true);
		payComponent.setPrimaryKey(payComponentId);

		payComponent.setCompanyId(CompanyThreadLocal.getCompanyId());

		return payComponent;
	}

	/**
	 * Removes the pay component with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param payComponentId the primary key of the pay component
	 * @return the pay component that was removed
	 * @throws NoSuchPayComponentException if a pay component with the primary key could not be found
	 */
	@Override
	public PayComponent remove(long payComponentId)
		throws NoSuchPayComponentException {

		return remove((Serializable)payComponentId);
	}

	/**
	 * Removes the pay component with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the pay component
	 * @return the pay component that was removed
	 * @throws NoSuchPayComponentException if a pay component with the primary key could not be found
	 */
	@Override
	public PayComponent remove(Serializable primaryKey)
		throws NoSuchPayComponentException {

		Session session = null;

		try {
			session = openSession();

			PayComponent payComponent = (PayComponent)session.get(
				PayComponentImpl.class, primaryKey);

			if (payComponent == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPayComponentException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(payComponent);
		}
		catch (NoSuchPayComponentException noSuchEntityException) {
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
	protected PayComponent removeImpl(PayComponent payComponent) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(payComponent)) {
				payComponent = (PayComponent)session.get(
					PayComponentImpl.class, payComponent.getPrimaryKeyObj());
			}

			if (payComponent != null) {
				session.delete(payComponent);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (payComponent != null) {
			clearCache(payComponent);
		}

		return payComponent;
	}

	@Override
	public PayComponent updateImpl(PayComponent payComponent) {
		boolean isNew = payComponent.isNew();

		if (!(payComponent instanceof PayComponentModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(payComponent.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					payComponent);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in payComponent proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PayComponent implementation " +
					payComponent.getClass());
		}

		PayComponentModelImpl payComponentModelImpl =
			(PayComponentModelImpl)payComponent;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (payComponent.getCreateDate() == null)) {
			if (serviceContext == null) {
				payComponent.setCreateDate(now);
			}
			else {
				payComponent.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!payComponentModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				payComponent.setModifiedDate(now);
			}
			else {
				payComponent.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(payComponent);
			}
			else {
				payComponent = (PayComponent)session.merge(payComponent);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PayComponentImpl.class, payComponent, false, true);

		if (isNew) {
			payComponent.setNew(false);
		}

		payComponent.resetOriginalValues();

		return payComponent;
	}

	/**
	 * Returns the pay component with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the pay component
	 * @return the pay component
	 * @throws NoSuchPayComponentException if a pay component with the primary key could not be found
	 */
	@Override
	public PayComponent findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPayComponentException {

		PayComponent payComponent = fetchByPrimaryKey(primaryKey);

		if (payComponent == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPayComponentException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return payComponent;
	}

	/**
	 * Returns the pay component with the primary key or throws a <code>NoSuchPayComponentException</code> if it could not be found.
	 *
	 * @param payComponentId the primary key of the pay component
	 * @return the pay component
	 * @throws NoSuchPayComponentException if a pay component with the primary key could not be found
	 */
	@Override
	public PayComponent findByPrimaryKey(long payComponentId)
		throws NoSuchPayComponentException {

		return findByPrimaryKey((Serializable)payComponentId);
	}

	/**
	 * Returns the pay component with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param payComponentId the primary key of the pay component
	 * @return the pay component, or <code>null</code> if a pay component with the primary key could not be found
	 */
	@Override
	public PayComponent fetchByPrimaryKey(long payComponentId) {
		return fetchByPrimaryKey((Serializable)payComponentId);
	}

	/**
	 * Returns all the pay components.
	 *
	 * @return the pay components
	 */
	@Override
	public List<PayComponent> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pay components.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PayComponentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay components
	 * @param end the upper bound of the range of pay components (not inclusive)
	 * @return the range of pay components
	 */
	@Override
	public List<PayComponent> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the pay components.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PayComponentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay components
	 * @param end the upper bound of the range of pay components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pay components
	 */
	@Override
	public List<PayComponent> findAll(
		int start, int end, OrderByComparator<PayComponent> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pay components.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PayComponentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay components
	 * @param end the upper bound of the range of pay components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of pay components
	 */
	@Override
	public List<PayComponent> findAll(
		int start, int end, OrderByComparator<PayComponent> orderByComparator,
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

		List<PayComponent> list = null;

		if (useFinderCache) {
			list = (List<PayComponent>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PAYCOMPONENT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PAYCOMPONENT;

				sql = sql.concat(PayComponentModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PayComponent>)QueryUtil.list(
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
	 * Removes all the pay components from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PayComponent payComponent : findAll()) {
			remove(payComponent);
		}
	}

	/**
	 * Returns the number of pay components.
	 *
	 * @return the number of pay components
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PAYCOMPONENT);

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
		return "payComponentId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PAYCOMPONENT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PayComponentModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the pay component persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new PayComponentModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", PayComponent.class.getName()));

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
		entityCache.removeCache(PayComponentImpl.class.getName());

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

	private static final String _SQL_SELECT_PAYCOMPONENT =
		"SELECT payComponent FROM PayComponent payComponent";

	private static final String _SQL_COUNT_PAYCOMPONENT =
		"SELECT COUNT(payComponent) FROM PayComponent payComponent";

	private static final String _ORDER_BY_ENTITY_ALIAS = "payComponent.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PayComponent exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		PayComponentPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"active"});

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

	private static class PayComponentModelArgumentsResolver
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

			PayComponentModelImpl payComponentModelImpl =
				(PayComponentModelImpl)baseModel;

			long columnBitmask = payComponentModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(payComponentModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						payComponentModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(payComponentModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			PayComponentModelImpl payComponentModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = payComponentModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = payComponentModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}