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

import com.adjecti.mdm.liferay.exception.NoSuchPayStructureException;
import com.adjecti.mdm.liferay.model.PayStructure;
import com.adjecti.mdm.liferay.model.impl.PayStructureImpl;
import com.adjecti.mdm.liferay.model.impl.PayStructureModelImpl;
import com.adjecti.mdm.liferay.service.persistence.PayStructurePersistence;
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
 * The persistence implementation for the pay structure service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PayStructurePersistence.class)
public class PayStructurePersistenceImpl
	extends BasePersistenceImpl<PayStructure>
	implements PayStructurePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PayStructureUtil</code> to access the pay structure persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PayStructureImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public PayStructurePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");
		dbColumnNames.put("currency", "currency_");

		setDBColumnNames(dbColumnNames);

		setModelClass(PayStructure.class);

		setModelImplClass(PayStructureImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the pay structure in the entity cache if it is enabled.
	 *
	 * @param payStructure the pay structure
	 */
	@Override
	public void cacheResult(PayStructure payStructure) {
		entityCache.putResult(
			PayStructureImpl.class, payStructure.getPrimaryKey(), payStructure);
	}

	/**
	 * Caches the pay structures in the entity cache if it is enabled.
	 *
	 * @param payStructures the pay structures
	 */
	@Override
	public void cacheResult(List<PayStructure> payStructures) {
		for (PayStructure payStructure : payStructures) {
			if (entityCache.getResult(
					PayStructureImpl.class, payStructure.getPrimaryKey()) ==
						null) {

				cacheResult(payStructure);
			}
		}
	}

	/**
	 * Clears the cache for all pay structures.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PayStructureImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the pay structure.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PayStructure payStructure) {
		entityCache.removeResult(PayStructureImpl.class, payStructure);
	}

	@Override
	public void clearCache(List<PayStructure> payStructures) {
		for (PayStructure payStructure : payStructures) {
			entityCache.removeResult(PayStructureImpl.class, payStructure);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PayStructureImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new pay structure with the primary key. Does not add the pay structure to the database.
	 *
	 * @param payStructureId the primary key for the new pay structure
	 * @return the new pay structure
	 */
	@Override
	public PayStructure create(long payStructureId) {
		PayStructure payStructure = new PayStructureImpl();

		payStructure.setNew(true);
		payStructure.setPrimaryKey(payStructureId);

		payStructure.setCompanyId(CompanyThreadLocal.getCompanyId());

		return payStructure;
	}

	/**
	 * Removes the pay structure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param payStructureId the primary key of the pay structure
	 * @return the pay structure that was removed
	 * @throws NoSuchPayStructureException if a pay structure with the primary key could not be found
	 */
	@Override
	public PayStructure remove(long payStructureId)
		throws NoSuchPayStructureException {

		return remove((Serializable)payStructureId);
	}

	/**
	 * Removes the pay structure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the pay structure
	 * @return the pay structure that was removed
	 * @throws NoSuchPayStructureException if a pay structure with the primary key could not be found
	 */
	@Override
	public PayStructure remove(Serializable primaryKey)
		throws NoSuchPayStructureException {

		Session session = null;

		try {
			session = openSession();

			PayStructure payStructure = (PayStructure)session.get(
				PayStructureImpl.class, primaryKey);

			if (payStructure == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPayStructureException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(payStructure);
		}
		catch (NoSuchPayStructureException noSuchEntityException) {
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
	protected PayStructure removeImpl(PayStructure payStructure) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(payStructure)) {
				payStructure = (PayStructure)session.get(
					PayStructureImpl.class, payStructure.getPrimaryKeyObj());
			}

			if (payStructure != null) {
				session.delete(payStructure);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (payStructure != null) {
			clearCache(payStructure);
		}

		return payStructure;
	}

	@Override
	public PayStructure updateImpl(PayStructure payStructure) {
		boolean isNew = payStructure.isNew();

		if (!(payStructure instanceof PayStructureModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(payStructure.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					payStructure);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in payStructure proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PayStructure implementation " +
					payStructure.getClass());
		}

		PayStructureModelImpl payStructureModelImpl =
			(PayStructureModelImpl)payStructure;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (payStructure.getCreateDate() == null)) {
			if (serviceContext == null) {
				payStructure.setCreateDate(now);
			}
			else {
				payStructure.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!payStructureModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				payStructure.setModifiedDate(now);
			}
			else {
				payStructure.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(payStructure);
			}
			else {
				payStructure = (PayStructure)session.merge(payStructure);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PayStructureImpl.class, payStructure, false, true);

		if (isNew) {
			payStructure.setNew(false);
		}

		payStructure.resetOriginalValues();

		return payStructure;
	}

	/**
	 * Returns the pay structure with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the pay structure
	 * @return the pay structure
	 * @throws NoSuchPayStructureException if a pay structure with the primary key could not be found
	 */
	@Override
	public PayStructure findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPayStructureException {

		PayStructure payStructure = fetchByPrimaryKey(primaryKey);

		if (payStructure == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPayStructureException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return payStructure;
	}

	/**
	 * Returns the pay structure with the primary key or throws a <code>NoSuchPayStructureException</code> if it could not be found.
	 *
	 * @param payStructureId the primary key of the pay structure
	 * @return the pay structure
	 * @throws NoSuchPayStructureException if a pay structure with the primary key could not be found
	 */
	@Override
	public PayStructure findByPrimaryKey(long payStructureId)
		throws NoSuchPayStructureException {

		return findByPrimaryKey((Serializable)payStructureId);
	}

	/**
	 * Returns the pay structure with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param payStructureId the primary key of the pay structure
	 * @return the pay structure, or <code>null</code> if a pay structure with the primary key could not be found
	 */
	@Override
	public PayStructure fetchByPrimaryKey(long payStructureId) {
		return fetchByPrimaryKey((Serializable)payStructureId);
	}

	/**
	 * Returns all the pay structures.
	 *
	 * @return the pay structures
	 */
	@Override
	public List<PayStructure> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pay structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PayStructureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay structures
	 * @param end the upper bound of the range of pay structures (not inclusive)
	 * @return the range of pay structures
	 */
	@Override
	public List<PayStructure> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the pay structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PayStructureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay structures
	 * @param end the upper bound of the range of pay structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pay structures
	 */
	@Override
	public List<PayStructure> findAll(
		int start, int end, OrderByComparator<PayStructure> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pay structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PayStructureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay structures
	 * @param end the upper bound of the range of pay structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of pay structures
	 */
	@Override
	public List<PayStructure> findAll(
		int start, int end, OrderByComparator<PayStructure> orderByComparator,
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

		List<PayStructure> list = null;

		if (useFinderCache) {
			list = (List<PayStructure>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PAYSTRUCTURE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PAYSTRUCTURE;

				sql = sql.concat(PayStructureModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PayStructure>)QueryUtil.list(
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
	 * Removes all the pay structures from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PayStructure payStructure : findAll()) {
			remove(payStructure);
		}
	}

	/**
	 * Returns the number of pay structures.
	 *
	 * @return the number of pay structures
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PAYSTRUCTURE);

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
		return "payStructureId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PAYSTRUCTURE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PayStructureModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the pay structure persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new PayStructureModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", PayStructure.class.getName()));

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
		entityCache.removeCache(PayStructureImpl.class.getName());

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

	private static final String _SQL_SELECT_PAYSTRUCTURE =
		"SELECT payStructure FROM PayStructure payStructure";

	private static final String _SQL_COUNT_PAYSTRUCTURE =
		"SELECT COUNT(payStructure) FROM PayStructure payStructure";

	private static final String _ORDER_BY_ENTITY_ALIAS = "payStructure.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PayStructure exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		PayStructurePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"active", "currency"});

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

	private static class PayStructureModelArgumentsResolver
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

			PayStructureModelImpl payStructureModelImpl =
				(PayStructureModelImpl)baseModel;

			long columnBitmask = payStructureModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(payStructureModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						payStructureModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(payStructureModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			PayStructureModelImpl payStructureModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = payStructureModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = payStructureModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}