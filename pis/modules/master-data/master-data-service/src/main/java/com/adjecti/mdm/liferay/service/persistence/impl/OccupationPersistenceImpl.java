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

import com.adjecti.mdm.liferay.exception.NoSuchOccupationException;
import com.adjecti.mdm.liferay.model.Occupation;
import com.adjecti.mdm.liferay.model.impl.OccupationImpl;
import com.adjecti.mdm.liferay.model.impl.OccupationModelImpl;
import com.adjecti.mdm.liferay.service.persistence.OccupationPersistence;
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
 * The persistence implementation for the occupation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = OccupationPersistence.class)
public class OccupationPersistenceImpl
	extends BasePersistenceImpl<Occupation> implements OccupationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>OccupationUtil</code> to access the occupation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		OccupationImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public OccupationPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("code", "code_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Occupation.class);

		setModelImplClass(OccupationImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the occupation in the entity cache if it is enabled.
	 *
	 * @param occupation the occupation
	 */
	@Override
	public void cacheResult(Occupation occupation) {
		entityCache.putResult(
			OccupationImpl.class, occupation.getPrimaryKey(), occupation);
	}

	/**
	 * Caches the occupations in the entity cache if it is enabled.
	 *
	 * @param occupations the occupations
	 */
	@Override
	public void cacheResult(List<Occupation> occupations) {
		for (Occupation occupation : occupations) {
			if (entityCache.getResult(
					OccupationImpl.class, occupation.getPrimaryKey()) == null) {

				cacheResult(occupation);
			}
		}
	}

	/**
	 * Clears the cache for all occupations.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(OccupationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the occupation.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Occupation occupation) {
		entityCache.removeResult(OccupationImpl.class, occupation);
	}

	@Override
	public void clearCache(List<Occupation> occupations) {
		for (Occupation occupation : occupations) {
			entityCache.removeResult(OccupationImpl.class, occupation);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(OccupationImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new occupation with the primary key. Does not add the occupation to the database.
	 *
	 * @param occupationId the primary key for the new occupation
	 * @return the new occupation
	 */
	@Override
	public Occupation create(long occupationId) {
		Occupation occupation = new OccupationImpl();

		occupation.setNew(true);
		occupation.setPrimaryKey(occupationId);

		occupation.setCompanyId(CompanyThreadLocal.getCompanyId());

		return occupation;
	}

	/**
	 * Removes the occupation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param occupationId the primary key of the occupation
	 * @return the occupation that was removed
	 * @throws NoSuchOccupationException if a occupation with the primary key could not be found
	 */
	@Override
	public Occupation remove(long occupationId)
		throws NoSuchOccupationException {

		return remove((Serializable)occupationId);
	}

	/**
	 * Removes the occupation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the occupation
	 * @return the occupation that was removed
	 * @throws NoSuchOccupationException if a occupation with the primary key could not be found
	 */
	@Override
	public Occupation remove(Serializable primaryKey)
		throws NoSuchOccupationException {

		Session session = null;

		try {
			session = openSession();

			Occupation occupation = (Occupation)session.get(
				OccupationImpl.class, primaryKey);

			if (occupation == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOccupationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(occupation);
		}
		catch (NoSuchOccupationException noSuchEntityException) {
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
	protected Occupation removeImpl(Occupation occupation) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(occupation)) {
				occupation = (Occupation)session.get(
					OccupationImpl.class, occupation.getPrimaryKeyObj());
			}

			if (occupation != null) {
				session.delete(occupation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (occupation != null) {
			clearCache(occupation);
		}

		return occupation;
	}

	@Override
	public Occupation updateImpl(Occupation occupation) {
		boolean isNew = occupation.isNew();

		if (!(occupation instanceof OccupationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(occupation.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(occupation);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in occupation proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Occupation implementation " +
					occupation.getClass());
		}

		OccupationModelImpl occupationModelImpl =
			(OccupationModelImpl)occupation;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (occupation.getCreateDate() == null)) {
			if (serviceContext == null) {
				occupation.setCreateDate(now);
			}
			else {
				occupation.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!occupationModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				occupation.setModifiedDate(now);
			}
			else {
				occupation.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(occupation);
			}
			else {
				occupation = (Occupation)session.merge(occupation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(OccupationImpl.class, occupation, false, true);

		if (isNew) {
			occupation.setNew(false);
		}

		occupation.resetOriginalValues();

		return occupation;
	}

	/**
	 * Returns the occupation with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the occupation
	 * @return the occupation
	 * @throws NoSuchOccupationException if a occupation with the primary key could not be found
	 */
	@Override
	public Occupation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOccupationException {

		Occupation occupation = fetchByPrimaryKey(primaryKey);

		if (occupation == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOccupationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return occupation;
	}

	/**
	 * Returns the occupation with the primary key or throws a <code>NoSuchOccupationException</code> if it could not be found.
	 *
	 * @param occupationId the primary key of the occupation
	 * @return the occupation
	 * @throws NoSuchOccupationException if a occupation with the primary key could not be found
	 */
	@Override
	public Occupation findByPrimaryKey(long occupationId)
		throws NoSuchOccupationException {

		return findByPrimaryKey((Serializable)occupationId);
	}

	/**
	 * Returns the occupation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param occupationId the primary key of the occupation
	 * @return the occupation, or <code>null</code> if a occupation with the primary key could not be found
	 */
	@Override
	public Occupation fetchByPrimaryKey(long occupationId) {
		return fetchByPrimaryKey((Serializable)occupationId);
	}

	/**
	 * Returns all the occupations.
	 *
	 * @return the occupations
	 */
	@Override
	public List<Occupation> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the occupations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OccupationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of occupations
	 * @param end the upper bound of the range of occupations (not inclusive)
	 * @return the range of occupations
	 */
	@Override
	public List<Occupation> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the occupations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OccupationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of occupations
	 * @param end the upper bound of the range of occupations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of occupations
	 */
	@Override
	public List<Occupation> findAll(
		int start, int end, OrderByComparator<Occupation> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the occupations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OccupationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of occupations
	 * @param end the upper bound of the range of occupations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of occupations
	 */
	@Override
	public List<Occupation> findAll(
		int start, int end, OrderByComparator<Occupation> orderByComparator,
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

		List<Occupation> list = null;

		if (useFinderCache) {
			list = (List<Occupation>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_OCCUPATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_OCCUPATION;

				sql = sql.concat(OccupationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Occupation>)QueryUtil.list(
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
	 * Removes all the occupations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Occupation occupation : findAll()) {
			remove(occupation);
		}
	}

	/**
	 * Returns the number of occupations.
	 *
	 * @return the number of occupations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_OCCUPATION);

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
		return "occupationId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_OCCUPATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return OccupationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the occupation persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new OccupationModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", Occupation.class.getName()));

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
		entityCache.removeCache(OccupationImpl.class.getName());

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

	private static final String _SQL_SELECT_OCCUPATION =
		"SELECT occupation FROM Occupation occupation";

	private static final String _SQL_COUNT_OCCUPATION =
		"SELECT COUNT(occupation) FROM Occupation occupation";

	private static final String _ORDER_BY_ENTITY_ALIAS = "occupation.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Occupation exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		OccupationPersistenceImpl.class);

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

	private static class OccupationModelArgumentsResolver
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

			OccupationModelImpl occupationModelImpl =
				(OccupationModelImpl)baseModel;

			long columnBitmask = occupationModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(occupationModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						occupationModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(occupationModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			OccupationModelImpl occupationModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = occupationModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = occupationModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}