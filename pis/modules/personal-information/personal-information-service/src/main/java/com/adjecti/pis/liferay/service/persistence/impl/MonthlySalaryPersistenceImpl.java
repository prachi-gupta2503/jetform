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

import com.adjecti.pis.liferay.exception.NoSuchMonthlySalaryException;
import com.adjecti.pis.liferay.model.MonthlySalary;
import com.adjecti.pis.liferay.model.impl.MonthlySalaryImpl;
import com.adjecti.pis.liferay.model.impl.MonthlySalaryModelImpl;
import com.adjecti.pis.liferay.service.persistence.MonthlySalaryPersistence;
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
 * The persistence implementation for the monthly salary service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = MonthlySalaryPersistence.class)
public class MonthlySalaryPersistenceImpl
	extends BasePersistenceImpl<MonthlySalary>
	implements MonthlySalaryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>MonthlySalaryUtil</code> to access the monthly salary persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		MonthlySalaryImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public MonthlySalaryPersistenceImpl() {
		setModelClass(MonthlySalary.class);

		setModelImplClass(MonthlySalaryImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the monthly salary in the entity cache if it is enabled.
	 *
	 * @param monthlySalary the monthly salary
	 */
	@Override
	public void cacheResult(MonthlySalary monthlySalary) {
		entityCache.putResult(
			MonthlySalaryImpl.class, monthlySalary.getPrimaryKey(),
			monthlySalary);
	}

	/**
	 * Caches the monthly salaries in the entity cache if it is enabled.
	 *
	 * @param monthlySalaries the monthly salaries
	 */
	@Override
	public void cacheResult(List<MonthlySalary> monthlySalaries) {
		for (MonthlySalary monthlySalary : monthlySalaries) {
			if (entityCache.getResult(
					MonthlySalaryImpl.class, monthlySalary.getPrimaryKey()) ==
						null) {

				cacheResult(monthlySalary);
			}
		}
	}

	/**
	 * Clears the cache for all monthly salaries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MonthlySalaryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the monthly salary.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MonthlySalary monthlySalary) {
		entityCache.removeResult(MonthlySalaryImpl.class, monthlySalary);
	}

	@Override
	public void clearCache(List<MonthlySalary> monthlySalaries) {
		for (MonthlySalary monthlySalary : monthlySalaries) {
			entityCache.removeResult(MonthlySalaryImpl.class, monthlySalary);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(MonthlySalaryImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new monthly salary with the primary key. Does not add the monthly salary to the database.
	 *
	 * @param monthlySalaryId the primary key for the new monthly salary
	 * @return the new monthly salary
	 */
	@Override
	public MonthlySalary create(long monthlySalaryId) {
		MonthlySalary monthlySalary = new MonthlySalaryImpl();

		monthlySalary.setNew(true);
		monthlySalary.setPrimaryKey(monthlySalaryId);

		monthlySalary.setCompanyId(CompanyThreadLocal.getCompanyId());

		return monthlySalary;
	}

	/**
	 * Removes the monthly salary with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param monthlySalaryId the primary key of the monthly salary
	 * @return the monthly salary that was removed
	 * @throws NoSuchMonthlySalaryException if a monthly salary with the primary key could not be found
	 */
	@Override
	public MonthlySalary remove(long monthlySalaryId)
		throws NoSuchMonthlySalaryException {

		return remove((Serializable)monthlySalaryId);
	}

	/**
	 * Removes the monthly salary with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the monthly salary
	 * @return the monthly salary that was removed
	 * @throws NoSuchMonthlySalaryException if a monthly salary with the primary key could not be found
	 */
	@Override
	public MonthlySalary remove(Serializable primaryKey)
		throws NoSuchMonthlySalaryException {

		Session session = null;

		try {
			session = openSession();

			MonthlySalary monthlySalary = (MonthlySalary)session.get(
				MonthlySalaryImpl.class, primaryKey);

			if (monthlySalary == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMonthlySalaryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(monthlySalary);
		}
		catch (NoSuchMonthlySalaryException noSuchEntityException) {
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
	protected MonthlySalary removeImpl(MonthlySalary monthlySalary) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(monthlySalary)) {
				monthlySalary = (MonthlySalary)session.get(
					MonthlySalaryImpl.class, monthlySalary.getPrimaryKeyObj());
			}

			if (monthlySalary != null) {
				session.delete(monthlySalary);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (monthlySalary != null) {
			clearCache(monthlySalary);
		}

		return monthlySalary;
	}

	@Override
	public MonthlySalary updateImpl(MonthlySalary monthlySalary) {
		boolean isNew = monthlySalary.isNew();

		if (!(monthlySalary instanceof MonthlySalaryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(monthlySalary.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					monthlySalary);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in monthlySalary proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom MonthlySalary implementation " +
					monthlySalary.getClass());
		}

		MonthlySalaryModelImpl monthlySalaryModelImpl =
			(MonthlySalaryModelImpl)monthlySalary;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (monthlySalary.getCreateDate() == null)) {
			if (serviceContext == null) {
				monthlySalary.setCreateDate(now);
			}
			else {
				monthlySalary.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!monthlySalaryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				monthlySalary.setModifiedDate(now);
			}
			else {
				monthlySalary.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(monthlySalary);
			}
			else {
				monthlySalary = (MonthlySalary)session.merge(monthlySalary);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			MonthlySalaryImpl.class, monthlySalary, false, true);

		if (isNew) {
			monthlySalary.setNew(false);
		}

		monthlySalary.resetOriginalValues();

		return monthlySalary;
	}

	/**
	 * Returns the monthly salary with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the monthly salary
	 * @return the monthly salary
	 * @throws NoSuchMonthlySalaryException if a monthly salary with the primary key could not be found
	 */
	@Override
	public MonthlySalary findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMonthlySalaryException {

		MonthlySalary monthlySalary = fetchByPrimaryKey(primaryKey);

		if (monthlySalary == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMonthlySalaryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return monthlySalary;
	}

	/**
	 * Returns the monthly salary with the primary key or throws a <code>NoSuchMonthlySalaryException</code> if it could not be found.
	 *
	 * @param monthlySalaryId the primary key of the monthly salary
	 * @return the monthly salary
	 * @throws NoSuchMonthlySalaryException if a monthly salary with the primary key could not be found
	 */
	@Override
	public MonthlySalary findByPrimaryKey(long monthlySalaryId)
		throws NoSuchMonthlySalaryException {

		return findByPrimaryKey((Serializable)monthlySalaryId);
	}

	/**
	 * Returns the monthly salary with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param monthlySalaryId the primary key of the monthly salary
	 * @return the monthly salary, or <code>null</code> if a monthly salary with the primary key could not be found
	 */
	@Override
	public MonthlySalary fetchByPrimaryKey(long monthlySalaryId) {
		return fetchByPrimaryKey((Serializable)monthlySalaryId);
	}

	/**
	 * Returns all the monthly salaries.
	 *
	 * @return the monthly salaries
	 */
	@Override
	public List<MonthlySalary> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the monthly salaries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MonthlySalaryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of monthly salaries
	 * @param end the upper bound of the range of monthly salaries (not inclusive)
	 * @return the range of monthly salaries
	 */
	@Override
	public List<MonthlySalary> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the monthly salaries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MonthlySalaryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of monthly salaries
	 * @param end the upper bound of the range of monthly salaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of monthly salaries
	 */
	@Override
	public List<MonthlySalary> findAll(
		int start, int end,
		OrderByComparator<MonthlySalary> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the monthly salaries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MonthlySalaryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of monthly salaries
	 * @param end the upper bound of the range of monthly salaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of monthly salaries
	 */
	@Override
	public List<MonthlySalary> findAll(
		int start, int end, OrderByComparator<MonthlySalary> orderByComparator,
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

		List<MonthlySalary> list = null;

		if (useFinderCache) {
			list = (List<MonthlySalary>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_MONTHLYSALARY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_MONTHLYSALARY;

				sql = sql.concat(MonthlySalaryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<MonthlySalary>)QueryUtil.list(
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
	 * Removes all the monthly salaries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (MonthlySalary monthlySalary : findAll()) {
			remove(monthlySalary);
		}
	}

	/**
	 * Returns the number of monthly salaries.
	 *
	 * @return the number of monthly salaries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_MONTHLYSALARY);

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
		return "monthlySalaryId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_MONTHLYSALARY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return MonthlySalaryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the monthly salary persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new MonthlySalaryModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", MonthlySalary.class.getName()));

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
		entityCache.removeCache(MonthlySalaryImpl.class.getName());

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

	private static final String _SQL_SELECT_MONTHLYSALARY =
		"SELECT monthlySalary FROM MonthlySalary monthlySalary";

	private static final String _SQL_COUNT_MONTHLYSALARY =
		"SELECT COUNT(monthlySalary) FROM MonthlySalary monthlySalary";

	private static final String _ORDER_BY_ENTITY_ALIAS = "monthlySalary.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No MonthlySalary exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		MonthlySalaryPersistenceImpl.class);

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

	private static class MonthlySalaryModelArgumentsResolver
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

			MonthlySalaryModelImpl monthlySalaryModelImpl =
				(MonthlySalaryModelImpl)baseModel;

			long columnBitmask = monthlySalaryModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(monthlySalaryModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						monthlySalaryModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(monthlySalaryModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			MonthlySalaryModelImpl monthlySalaryModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						monthlySalaryModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = monthlySalaryModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}