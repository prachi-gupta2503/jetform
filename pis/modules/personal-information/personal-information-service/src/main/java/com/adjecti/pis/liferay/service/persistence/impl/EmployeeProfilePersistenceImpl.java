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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeProfileException;
import com.adjecti.pis.liferay.model.EmployeeProfile;
import com.adjecti.pis.liferay.model.impl.EmployeeProfileImpl;
import com.adjecti.pis.liferay.model.impl.EmployeeProfileModelImpl;
import com.adjecti.pis.liferay.service.persistence.EmployeeProfilePersistence;
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
 * The persistence implementation for the employee profile service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EmployeeProfilePersistence.class)
public class EmployeeProfilePersistenceImpl
	extends BasePersistenceImpl<EmployeeProfile>
	implements EmployeeProfilePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EmployeeProfileUtil</code> to access the employee profile persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EmployeeProfileImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public EmployeeProfilePersistenceImpl() {
		setModelClass(EmployeeProfile.class);

		setModelImplClass(EmployeeProfileImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the employee profile in the entity cache if it is enabled.
	 *
	 * @param employeeProfile the employee profile
	 */
	@Override
	public void cacheResult(EmployeeProfile employeeProfile) {
		entityCache.putResult(
			EmployeeProfileImpl.class, employeeProfile.getPrimaryKey(),
			employeeProfile);
	}

	/**
	 * Caches the employee profiles in the entity cache if it is enabled.
	 *
	 * @param employeeProfiles the employee profiles
	 */
	@Override
	public void cacheResult(List<EmployeeProfile> employeeProfiles) {
		for (EmployeeProfile employeeProfile : employeeProfiles) {
			if (entityCache.getResult(
					EmployeeProfileImpl.class,
					employeeProfile.getPrimaryKey()) == null) {

				cacheResult(employeeProfile);
			}
		}
	}

	/**
	 * Clears the cache for all employee profiles.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmployeeProfileImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the employee profile.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmployeeProfile employeeProfile) {
		entityCache.removeResult(EmployeeProfileImpl.class, employeeProfile);
	}

	@Override
	public void clearCache(List<EmployeeProfile> employeeProfiles) {
		for (EmployeeProfile employeeProfile : employeeProfiles) {
			entityCache.removeResult(
				EmployeeProfileImpl.class, employeeProfile);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EmployeeProfileImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new employee profile with the primary key. Does not add the employee profile to the database.
	 *
	 * @param employeeProfileId the primary key for the new employee profile
	 * @return the new employee profile
	 */
	@Override
	public EmployeeProfile create(long employeeProfileId) {
		EmployeeProfile employeeProfile = new EmployeeProfileImpl();

		employeeProfile.setNew(true);
		employeeProfile.setPrimaryKey(employeeProfileId);

		employeeProfile.setCompanyId(CompanyThreadLocal.getCompanyId());

		return employeeProfile;
	}

	/**
	 * Removes the employee profile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeProfileId the primary key of the employee profile
	 * @return the employee profile that was removed
	 * @throws NoSuchEmployeeProfileException if a employee profile with the primary key could not be found
	 */
	@Override
	public EmployeeProfile remove(long employeeProfileId)
		throws NoSuchEmployeeProfileException {

		return remove((Serializable)employeeProfileId);
	}

	/**
	 * Removes the employee profile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the employee profile
	 * @return the employee profile that was removed
	 * @throws NoSuchEmployeeProfileException if a employee profile with the primary key could not be found
	 */
	@Override
	public EmployeeProfile remove(Serializable primaryKey)
		throws NoSuchEmployeeProfileException {

		Session session = null;

		try {
			session = openSession();

			EmployeeProfile employeeProfile = (EmployeeProfile)session.get(
				EmployeeProfileImpl.class, primaryKey);

			if (employeeProfile == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmployeeProfileException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(employeeProfile);
		}
		catch (NoSuchEmployeeProfileException noSuchEntityException) {
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
	protected EmployeeProfile removeImpl(EmployeeProfile employeeProfile) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(employeeProfile)) {
				employeeProfile = (EmployeeProfile)session.get(
					EmployeeProfileImpl.class,
					employeeProfile.getPrimaryKeyObj());
			}

			if (employeeProfile != null) {
				session.delete(employeeProfile);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (employeeProfile != null) {
			clearCache(employeeProfile);
		}

		return employeeProfile;
	}

	@Override
	public EmployeeProfile updateImpl(EmployeeProfile employeeProfile) {
		boolean isNew = employeeProfile.isNew();

		if (!(employeeProfile instanceof EmployeeProfileModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(employeeProfile.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					employeeProfile);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in employeeProfile proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EmployeeProfile implementation " +
					employeeProfile.getClass());
		}

		EmployeeProfileModelImpl employeeProfileModelImpl =
			(EmployeeProfileModelImpl)employeeProfile;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (employeeProfile.getCreateDate() == null)) {
			if (serviceContext == null) {
				employeeProfile.setCreateDate(now);
			}
			else {
				employeeProfile.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!employeeProfileModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				employeeProfile.setModifiedDate(now);
			}
			else {
				employeeProfile.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(employeeProfile);
			}
			else {
				employeeProfile = (EmployeeProfile)session.merge(
					employeeProfile);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EmployeeProfileImpl.class, employeeProfile, false, true);

		if (isNew) {
			employeeProfile.setNew(false);
		}

		employeeProfile.resetOriginalValues();

		return employeeProfile;
	}

	/**
	 * Returns the employee profile with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee profile
	 * @return the employee profile
	 * @throws NoSuchEmployeeProfileException if a employee profile with the primary key could not be found
	 */
	@Override
	public EmployeeProfile findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmployeeProfileException {

		EmployeeProfile employeeProfile = fetchByPrimaryKey(primaryKey);

		if (employeeProfile == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmployeeProfileException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return employeeProfile;
	}

	/**
	 * Returns the employee profile with the primary key or throws a <code>NoSuchEmployeeProfileException</code> if it could not be found.
	 *
	 * @param employeeProfileId the primary key of the employee profile
	 * @return the employee profile
	 * @throws NoSuchEmployeeProfileException if a employee profile with the primary key could not be found
	 */
	@Override
	public EmployeeProfile findByPrimaryKey(long employeeProfileId)
		throws NoSuchEmployeeProfileException {

		return findByPrimaryKey((Serializable)employeeProfileId);
	}

	/**
	 * Returns the employee profile with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeProfileId the primary key of the employee profile
	 * @return the employee profile, or <code>null</code> if a employee profile with the primary key could not be found
	 */
	@Override
	public EmployeeProfile fetchByPrimaryKey(long employeeProfileId) {
		return fetchByPrimaryKey((Serializable)employeeProfileId);
	}

	/**
	 * Returns all the employee profiles.
	 *
	 * @return the employee profiles
	 */
	@Override
	public List<EmployeeProfile> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee profiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeProfileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee profiles
	 * @param end the upper bound of the range of employee profiles (not inclusive)
	 * @return the range of employee profiles
	 */
	@Override
	public List<EmployeeProfile> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee profiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeProfileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee profiles
	 * @param end the upper bound of the range of employee profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee profiles
	 */
	@Override
	public List<EmployeeProfile> findAll(
		int start, int end,
		OrderByComparator<EmployeeProfile> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee profiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeProfileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee profiles
	 * @param end the upper bound of the range of employee profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee profiles
	 */
	@Override
	public List<EmployeeProfile> findAll(
		int start, int end,
		OrderByComparator<EmployeeProfile> orderByComparator,
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

		List<EmployeeProfile> list = null;

		if (useFinderCache) {
			list = (List<EmployeeProfile>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EMPLOYEEPROFILE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLOYEEPROFILE;

				sql = sql.concat(EmployeeProfileModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EmployeeProfile>)QueryUtil.list(
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
	 * Removes all the employee profiles from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EmployeeProfile employeeProfile : findAll()) {
			remove(employeeProfile);
		}
	}

	/**
	 * Returns the number of employee profiles.
	 *
	 * @return the number of employee profiles
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_EMPLOYEEPROFILE);

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
		return "employeeProfileId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EMPLOYEEPROFILE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EmployeeProfileModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the employee profile persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new EmployeeProfileModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", EmployeeProfile.class.getName()));

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
		entityCache.removeCache(EmployeeProfileImpl.class.getName());

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

	private static final String _SQL_SELECT_EMPLOYEEPROFILE =
		"SELECT employeeProfile FROM EmployeeProfile employeeProfile";

	private static final String _SQL_COUNT_EMPLOYEEPROFILE =
		"SELECT COUNT(employeeProfile) FROM EmployeeProfile employeeProfile";

	private static final String _ORDER_BY_ENTITY_ALIAS = "employeeProfile.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EmployeeProfile exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		EmployeeProfilePersistenceImpl.class);

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

	private static class EmployeeProfileModelArgumentsResolver
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

			EmployeeProfileModelImpl employeeProfileModelImpl =
				(EmployeeProfileModelImpl)baseModel;

			long columnBitmask = employeeProfileModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					employeeProfileModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						employeeProfileModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					employeeProfileModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			EmployeeProfileModelImpl employeeProfileModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						employeeProfileModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = employeeProfileModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}