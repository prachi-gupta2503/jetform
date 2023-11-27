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

import com.adjecti.mdm.liferay.exception.NoSuchTimeFrequencyException;
import com.adjecti.mdm.liferay.model.TimeFrequency;
import com.adjecti.mdm.liferay.model.impl.TimeFrequencyImpl;
import com.adjecti.mdm.liferay.model.impl.TimeFrequencyModelImpl;
import com.adjecti.mdm.liferay.service.persistence.TimeFrequencyPersistence;
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
 * The persistence implementation for the time frequency service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = TimeFrequencyPersistence.class)
public class TimeFrequencyPersistenceImpl
	extends BasePersistenceImpl<TimeFrequency>
	implements TimeFrequencyPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TimeFrequencyUtil</code> to access the time frequency persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TimeFrequencyImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public TimeFrequencyPersistenceImpl() {
		setModelClass(TimeFrequency.class);

		setModelImplClass(TimeFrequencyImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the time frequency in the entity cache if it is enabled.
	 *
	 * @param timeFrequency the time frequency
	 */
	@Override
	public void cacheResult(TimeFrequency timeFrequency) {
		entityCache.putResult(
			TimeFrequencyImpl.class, timeFrequency.getPrimaryKey(),
			timeFrequency);
	}

	/**
	 * Caches the time frequencies in the entity cache if it is enabled.
	 *
	 * @param timeFrequencies the time frequencies
	 */
	@Override
	public void cacheResult(List<TimeFrequency> timeFrequencies) {
		for (TimeFrequency timeFrequency : timeFrequencies) {
			if (entityCache.getResult(
					TimeFrequencyImpl.class, timeFrequency.getPrimaryKey()) ==
						null) {

				cacheResult(timeFrequency);
			}
		}
	}

	/**
	 * Clears the cache for all time frequencies.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TimeFrequencyImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the time frequency.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TimeFrequency timeFrequency) {
		entityCache.removeResult(TimeFrequencyImpl.class, timeFrequency);
	}

	@Override
	public void clearCache(List<TimeFrequency> timeFrequencies) {
		for (TimeFrequency timeFrequency : timeFrequencies) {
			entityCache.removeResult(TimeFrequencyImpl.class, timeFrequency);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(TimeFrequencyImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new time frequency with the primary key. Does not add the time frequency to the database.
	 *
	 * @param timeFrequencyId the primary key for the new time frequency
	 * @return the new time frequency
	 */
	@Override
	public TimeFrequency create(long timeFrequencyId) {
		TimeFrequency timeFrequency = new TimeFrequencyImpl();

		timeFrequency.setNew(true);
		timeFrequency.setPrimaryKey(timeFrequencyId);

		timeFrequency.setCompanyId(CompanyThreadLocal.getCompanyId());

		return timeFrequency;
	}

	/**
	 * Removes the time frequency with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param timeFrequencyId the primary key of the time frequency
	 * @return the time frequency that was removed
	 * @throws NoSuchTimeFrequencyException if a time frequency with the primary key could not be found
	 */
	@Override
	public TimeFrequency remove(long timeFrequencyId)
		throws NoSuchTimeFrequencyException {

		return remove((Serializable)timeFrequencyId);
	}

	/**
	 * Removes the time frequency with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the time frequency
	 * @return the time frequency that was removed
	 * @throws NoSuchTimeFrequencyException if a time frequency with the primary key could not be found
	 */
	@Override
	public TimeFrequency remove(Serializable primaryKey)
		throws NoSuchTimeFrequencyException {

		Session session = null;

		try {
			session = openSession();

			TimeFrequency timeFrequency = (TimeFrequency)session.get(
				TimeFrequencyImpl.class, primaryKey);

			if (timeFrequency == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTimeFrequencyException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(timeFrequency);
		}
		catch (NoSuchTimeFrequencyException noSuchEntityException) {
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
	protected TimeFrequency removeImpl(TimeFrequency timeFrequency) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(timeFrequency)) {
				timeFrequency = (TimeFrequency)session.get(
					TimeFrequencyImpl.class, timeFrequency.getPrimaryKeyObj());
			}

			if (timeFrequency != null) {
				session.delete(timeFrequency);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (timeFrequency != null) {
			clearCache(timeFrequency);
		}

		return timeFrequency;
	}

	@Override
	public TimeFrequency updateImpl(TimeFrequency timeFrequency) {
		boolean isNew = timeFrequency.isNew();

		if (!(timeFrequency instanceof TimeFrequencyModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(timeFrequency.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					timeFrequency);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in timeFrequency proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TimeFrequency implementation " +
					timeFrequency.getClass());
		}

		TimeFrequencyModelImpl timeFrequencyModelImpl =
			(TimeFrequencyModelImpl)timeFrequency;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (timeFrequency.getCreateDate() == null)) {
			if (serviceContext == null) {
				timeFrequency.setCreateDate(now);
			}
			else {
				timeFrequency.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!timeFrequencyModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				timeFrequency.setModifiedDate(now);
			}
			else {
				timeFrequency.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(timeFrequency);
			}
			else {
				timeFrequency = (TimeFrequency)session.merge(timeFrequency);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			TimeFrequencyImpl.class, timeFrequency, false, true);

		if (isNew) {
			timeFrequency.setNew(false);
		}

		timeFrequency.resetOriginalValues();

		return timeFrequency;
	}

	/**
	 * Returns the time frequency with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the time frequency
	 * @return the time frequency
	 * @throws NoSuchTimeFrequencyException if a time frequency with the primary key could not be found
	 */
	@Override
	public TimeFrequency findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTimeFrequencyException {

		TimeFrequency timeFrequency = fetchByPrimaryKey(primaryKey);

		if (timeFrequency == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTimeFrequencyException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return timeFrequency;
	}

	/**
	 * Returns the time frequency with the primary key or throws a <code>NoSuchTimeFrequencyException</code> if it could not be found.
	 *
	 * @param timeFrequencyId the primary key of the time frequency
	 * @return the time frequency
	 * @throws NoSuchTimeFrequencyException if a time frequency with the primary key could not be found
	 */
	@Override
	public TimeFrequency findByPrimaryKey(long timeFrequencyId)
		throws NoSuchTimeFrequencyException {

		return findByPrimaryKey((Serializable)timeFrequencyId);
	}

	/**
	 * Returns the time frequency with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param timeFrequencyId the primary key of the time frequency
	 * @return the time frequency, or <code>null</code> if a time frequency with the primary key could not be found
	 */
	@Override
	public TimeFrequency fetchByPrimaryKey(long timeFrequencyId) {
		return fetchByPrimaryKey((Serializable)timeFrequencyId);
	}

	/**
	 * Returns all the time frequencies.
	 *
	 * @return the time frequencies
	 */
	@Override
	public List<TimeFrequency> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the time frequencies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TimeFrequencyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of time frequencies
	 * @param end the upper bound of the range of time frequencies (not inclusive)
	 * @return the range of time frequencies
	 */
	@Override
	public List<TimeFrequency> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the time frequencies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TimeFrequencyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of time frequencies
	 * @param end the upper bound of the range of time frequencies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of time frequencies
	 */
	@Override
	public List<TimeFrequency> findAll(
		int start, int end,
		OrderByComparator<TimeFrequency> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the time frequencies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TimeFrequencyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of time frequencies
	 * @param end the upper bound of the range of time frequencies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of time frequencies
	 */
	@Override
	public List<TimeFrequency> findAll(
		int start, int end, OrderByComparator<TimeFrequency> orderByComparator,
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

		List<TimeFrequency> list = null;

		if (useFinderCache) {
			list = (List<TimeFrequency>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TIMEFREQUENCY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TIMEFREQUENCY;

				sql = sql.concat(TimeFrequencyModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<TimeFrequency>)QueryUtil.list(
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
	 * Removes all the time frequencies from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TimeFrequency timeFrequency : findAll()) {
			remove(timeFrequency);
		}
	}

	/**
	 * Returns the number of time frequencies.
	 *
	 * @return the number of time frequencies
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_TIMEFREQUENCY);

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
		return "timeFrequencyId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TIMEFREQUENCY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TimeFrequencyModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the time frequency persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new TimeFrequencyModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", TimeFrequency.class.getName()));

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
		entityCache.removeCache(TimeFrequencyImpl.class.getName());

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

	private static final String _SQL_SELECT_TIMEFREQUENCY =
		"SELECT timeFrequency FROM TimeFrequency timeFrequency";

	private static final String _SQL_COUNT_TIMEFREQUENCY =
		"SELECT COUNT(timeFrequency) FROM TimeFrequency timeFrequency";

	private static final String _ORDER_BY_ENTITY_ALIAS = "timeFrequency.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TimeFrequency exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		TimeFrequencyPersistenceImpl.class);

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

	private static class TimeFrequencyModelArgumentsResolver
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

			TimeFrequencyModelImpl timeFrequencyModelImpl =
				(TimeFrequencyModelImpl)baseModel;

			long columnBitmask = timeFrequencyModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(timeFrequencyModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						timeFrequencyModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(timeFrequencyModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			TimeFrequencyModelImpl timeFrequencyModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						timeFrequencyModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = timeFrequencyModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}