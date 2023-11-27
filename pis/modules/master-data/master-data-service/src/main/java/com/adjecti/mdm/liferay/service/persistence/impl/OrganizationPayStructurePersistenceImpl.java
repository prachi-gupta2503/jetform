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

import com.adjecti.mdm.liferay.exception.NoSuchOrganizationPayStructureException;
import com.adjecti.mdm.liferay.model.OrganizationPayStructure;
import com.adjecti.mdm.liferay.model.impl.OrganizationPayStructureImpl;
import com.adjecti.mdm.liferay.model.impl.OrganizationPayStructureModelImpl;
import com.adjecti.mdm.liferay.service.persistence.OrganizationPayStructurePersistence;
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
 * The persistence implementation for the organization pay structure service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = OrganizationPayStructurePersistence.class)
public class OrganizationPayStructurePersistenceImpl
	extends BasePersistenceImpl<OrganizationPayStructure>
	implements OrganizationPayStructurePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>OrganizationPayStructureUtil</code> to access the organization pay structure persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		OrganizationPayStructureImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public OrganizationPayStructurePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(OrganizationPayStructure.class);

		setModelImplClass(OrganizationPayStructureImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the organization pay structure in the entity cache if it is enabled.
	 *
	 * @param organizationPayStructure the organization pay structure
	 */
	@Override
	public void cacheResult(OrganizationPayStructure organizationPayStructure) {
		entityCache.putResult(
			OrganizationPayStructureImpl.class,
			organizationPayStructure.getPrimaryKey(), organizationPayStructure);
	}

	/**
	 * Caches the organization pay structures in the entity cache if it is enabled.
	 *
	 * @param organizationPayStructures the organization pay structures
	 */
	@Override
	public void cacheResult(
		List<OrganizationPayStructure> organizationPayStructures) {

		for (OrganizationPayStructure organizationPayStructure :
				organizationPayStructures) {

			if (entityCache.getResult(
					OrganizationPayStructureImpl.class,
					organizationPayStructure.getPrimaryKey()) == null) {

				cacheResult(organizationPayStructure);
			}
		}
	}

	/**
	 * Clears the cache for all organization pay structures.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(OrganizationPayStructureImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the organization pay structure.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(OrganizationPayStructure organizationPayStructure) {
		entityCache.removeResult(
			OrganizationPayStructureImpl.class, organizationPayStructure);
	}

	@Override
	public void clearCache(
		List<OrganizationPayStructure> organizationPayStructures) {

		for (OrganizationPayStructure organizationPayStructure :
				organizationPayStructures) {

			entityCache.removeResult(
				OrganizationPayStructureImpl.class, organizationPayStructure);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				OrganizationPayStructureImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new organization pay structure with the primary key. Does not add the organization pay structure to the database.
	 *
	 * @param organizationPayStructureId the primary key for the new organization pay structure
	 * @return the new organization pay structure
	 */
	@Override
	public OrganizationPayStructure create(long organizationPayStructureId) {
		OrganizationPayStructure organizationPayStructure =
			new OrganizationPayStructureImpl();

		organizationPayStructure.setNew(true);
		organizationPayStructure.setPrimaryKey(organizationPayStructureId);

		organizationPayStructure.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return organizationPayStructure;
	}

	/**
	 * Removes the organization pay structure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param organizationPayStructureId the primary key of the organization pay structure
	 * @return the organization pay structure that was removed
	 * @throws NoSuchOrganizationPayStructureException if a organization pay structure with the primary key could not be found
	 */
	@Override
	public OrganizationPayStructure remove(long organizationPayStructureId)
		throws NoSuchOrganizationPayStructureException {

		return remove((Serializable)organizationPayStructureId);
	}

	/**
	 * Removes the organization pay structure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the organization pay structure
	 * @return the organization pay structure that was removed
	 * @throws NoSuchOrganizationPayStructureException if a organization pay structure with the primary key could not be found
	 */
	@Override
	public OrganizationPayStructure remove(Serializable primaryKey)
		throws NoSuchOrganizationPayStructureException {

		Session session = null;

		try {
			session = openSession();

			OrganizationPayStructure organizationPayStructure =
				(OrganizationPayStructure)session.get(
					OrganizationPayStructureImpl.class, primaryKey);

			if (organizationPayStructure == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOrganizationPayStructureException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(organizationPayStructure);
		}
		catch (NoSuchOrganizationPayStructureException noSuchEntityException) {
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
	protected OrganizationPayStructure removeImpl(
		OrganizationPayStructure organizationPayStructure) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(organizationPayStructure)) {
				organizationPayStructure =
					(OrganizationPayStructure)session.get(
						OrganizationPayStructureImpl.class,
						organizationPayStructure.getPrimaryKeyObj());
			}

			if (organizationPayStructure != null) {
				session.delete(organizationPayStructure);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (organizationPayStructure != null) {
			clearCache(organizationPayStructure);
		}

		return organizationPayStructure;
	}

	@Override
	public OrganizationPayStructure updateImpl(
		OrganizationPayStructure organizationPayStructure) {

		boolean isNew = organizationPayStructure.isNew();

		if (!(organizationPayStructure instanceof
				OrganizationPayStructureModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(organizationPayStructure.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					organizationPayStructure);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in organizationPayStructure proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom OrganizationPayStructure implementation " +
					organizationPayStructure.getClass());
		}

		OrganizationPayStructureModelImpl organizationPayStructureModelImpl =
			(OrganizationPayStructureModelImpl)organizationPayStructure;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (organizationPayStructure.getCreateDate() == null)) {
			if (serviceContext == null) {
				organizationPayStructure.setCreateDate(now);
			}
			else {
				organizationPayStructure.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!organizationPayStructureModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				organizationPayStructure.setModifiedDate(now);
			}
			else {
				organizationPayStructure.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(organizationPayStructure);
			}
			else {
				organizationPayStructure =
					(OrganizationPayStructure)session.merge(
						organizationPayStructure);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			OrganizationPayStructureImpl.class, organizationPayStructure, false,
			true);

		if (isNew) {
			organizationPayStructure.setNew(false);
		}

		organizationPayStructure.resetOriginalValues();

		return organizationPayStructure;
	}

	/**
	 * Returns the organization pay structure with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the organization pay structure
	 * @return the organization pay structure
	 * @throws NoSuchOrganizationPayStructureException if a organization pay structure with the primary key could not be found
	 */
	@Override
	public OrganizationPayStructure findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOrganizationPayStructureException {

		OrganizationPayStructure organizationPayStructure = fetchByPrimaryKey(
			primaryKey);

		if (organizationPayStructure == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOrganizationPayStructureException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return organizationPayStructure;
	}

	/**
	 * Returns the organization pay structure with the primary key or throws a <code>NoSuchOrganizationPayStructureException</code> if it could not be found.
	 *
	 * @param organizationPayStructureId the primary key of the organization pay structure
	 * @return the organization pay structure
	 * @throws NoSuchOrganizationPayStructureException if a organization pay structure with the primary key could not be found
	 */
	@Override
	public OrganizationPayStructure findByPrimaryKey(
			long organizationPayStructureId)
		throws NoSuchOrganizationPayStructureException {

		return findByPrimaryKey((Serializable)organizationPayStructureId);
	}

	/**
	 * Returns the organization pay structure with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param organizationPayStructureId the primary key of the organization pay structure
	 * @return the organization pay structure, or <code>null</code> if a organization pay structure with the primary key could not be found
	 */
	@Override
	public OrganizationPayStructure fetchByPrimaryKey(
		long organizationPayStructureId) {

		return fetchByPrimaryKey((Serializable)organizationPayStructureId);
	}

	/**
	 * Returns all the organization pay structures.
	 *
	 * @return the organization pay structures
	 */
	@Override
	public List<OrganizationPayStructure> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the organization pay structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationPayStructureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of organization pay structures
	 * @param end the upper bound of the range of organization pay structures (not inclusive)
	 * @return the range of organization pay structures
	 */
	@Override
	public List<OrganizationPayStructure> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the organization pay structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationPayStructureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of organization pay structures
	 * @param end the upper bound of the range of organization pay structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of organization pay structures
	 */
	@Override
	public List<OrganizationPayStructure> findAll(
		int start, int end,
		OrderByComparator<OrganizationPayStructure> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the organization pay structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationPayStructureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of organization pay structures
	 * @param end the upper bound of the range of organization pay structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of organization pay structures
	 */
	@Override
	public List<OrganizationPayStructure> findAll(
		int start, int end,
		OrderByComparator<OrganizationPayStructure> orderByComparator,
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

		List<OrganizationPayStructure> list = null;

		if (useFinderCache) {
			list = (List<OrganizationPayStructure>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ORGANIZATIONPAYSTRUCTURE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ORGANIZATIONPAYSTRUCTURE;

				sql = sql.concat(
					OrganizationPayStructureModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<OrganizationPayStructure>)QueryUtil.list(
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
	 * Removes all the organization pay structures from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (OrganizationPayStructure organizationPayStructure : findAll()) {
			remove(organizationPayStructure);
		}
	}

	/**
	 * Returns the number of organization pay structures.
	 *
	 * @return the number of organization pay structures
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
					_SQL_COUNT_ORGANIZATIONPAYSTRUCTURE);

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
		return "organizationPayStructureId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ORGANIZATIONPAYSTRUCTURE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return OrganizationPayStructureModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the organization pay structure persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new OrganizationPayStructureModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", OrganizationPayStructure.class.getName()));

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
		entityCache.removeCache(OrganizationPayStructureImpl.class.getName());

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

	private static final String _SQL_SELECT_ORGANIZATIONPAYSTRUCTURE =
		"SELECT organizationPayStructure FROM OrganizationPayStructure organizationPayStructure";

	private static final String _SQL_COUNT_ORGANIZATIONPAYSTRUCTURE =
		"SELECT COUNT(organizationPayStructure) FROM OrganizationPayStructure organizationPayStructure";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"organizationPayStructure.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No OrganizationPayStructure exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		OrganizationPayStructurePersistenceImpl.class);

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

	private static class OrganizationPayStructureModelArgumentsResolver
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

			OrganizationPayStructureModelImpl
				organizationPayStructureModelImpl =
					(OrganizationPayStructureModelImpl)baseModel;

			long columnBitmask =
				organizationPayStructureModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					organizationPayStructureModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						organizationPayStructureModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					organizationPayStructureModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			OrganizationPayStructureModelImpl organizationPayStructureModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						organizationPayStructureModelImpl.
							getColumnOriginalValue(columnName);
				}
				else {
					arguments[i] =
						organizationPayStructureModelImpl.getColumnValue(
							columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}