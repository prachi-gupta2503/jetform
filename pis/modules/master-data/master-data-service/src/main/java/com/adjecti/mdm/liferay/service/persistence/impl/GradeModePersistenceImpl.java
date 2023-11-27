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

import com.adjecti.mdm.liferay.exception.NoSuchGradeModeException;
import com.adjecti.mdm.liferay.model.GradeMode;
import com.adjecti.mdm.liferay.model.impl.GradeModeImpl;
import com.adjecti.mdm.liferay.model.impl.GradeModeModelImpl;
import com.adjecti.mdm.liferay.service.persistence.GradeModePersistence;
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
 * The persistence implementation for the grade mode service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = GradeModePersistence.class)
public class GradeModePersistenceImpl
	extends BasePersistenceImpl<GradeMode> implements GradeModePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>GradeModeUtil</code> to access the grade mode persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		GradeModeImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public GradeModePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("code", "code_");

		setDBColumnNames(dbColumnNames);

		setModelClass(GradeMode.class);

		setModelImplClass(GradeModeImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the grade mode in the entity cache if it is enabled.
	 *
	 * @param gradeMode the grade mode
	 */
	@Override
	public void cacheResult(GradeMode gradeMode) {
		entityCache.putResult(
			GradeModeImpl.class, gradeMode.getPrimaryKey(), gradeMode);
	}

	/**
	 * Caches the grade modes in the entity cache if it is enabled.
	 *
	 * @param gradeModes the grade modes
	 */
	@Override
	public void cacheResult(List<GradeMode> gradeModes) {
		for (GradeMode gradeMode : gradeModes) {
			if (entityCache.getResult(
					GradeModeImpl.class, gradeMode.getPrimaryKey()) == null) {

				cacheResult(gradeMode);
			}
		}
	}

	/**
	 * Clears the cache for all grade modes.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(GradeModeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the grade mode.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GradeMode gradeMode) {
		entityCache.removeResult(GradeModeImpl.class, gradeMode);
	}

	@Override
	public void clearCache(List<GradeMode> gradeModes) {
		for (GradeMode gradeMode : gradeModes) {
			entityCache.removeResult(GradeModeImpl.class, gradeMode);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(GradeModeImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new grade mode with the primary key. Does not add the grade mode to the database.
	 *
	 * @param gradeModeId the primary key for the new grade mode
	 * @return the new grade mode
	 */
	@Override
	public GradeMode create(long gradeModeId) {
		GradeMode gradeMode = new GradeModeImpl();

		gradeMode.setNew(true);
		gradeMode.setPrimaryKey(gradeModeId);

		gradeMode.setCompanyId(CompanyThreadLocal.getCompanyId());

		return gradeMode;
	}

	/**
	 * Removes the grade mode with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param gradeModeId the primary key of the grade mode
	 * @return the grade mode that was removed
	 * @throws NoSuchGradeModeException if a grade mode with the primary key could not be found
	 */
	@Override
	public GradeMode remove(long gradeModeId) throws NoSuchGradeModeException {
		return remove((Serializable)gradeModeId);
	}

	/**
	 * Removes the grade mode with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the grade mode
	 * @return the grade mode that was removed
	 * @throws NoSuchGradeModeException if a grade mode with the primary key could not be found
	 */
	@Override
	public GradeMode remove(Serializable primaryKey)
		throws NoSuchGradeModeException {

		Session session = null;

		try {
			session = openSession();

			GradeMode gradeMode = (GradeMode)session.get(
				GradeModeImpl.class, primaryKey);

			if (gradeMode == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGradeModeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(gradeMode);
		}
		catch (NoSuchGradeModeException noSuchEntityException) {
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
	protected GradeMode removeImpl(GradeMode gradeMode) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(gradeMode)) {
				gradeMode = (GradeMode)session.get(
					GradeModeImpl.class, gradeMode.getPrimaryKeyObj());
			}

			if (gradeMode != null) {
				session.delete(gradeMode);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (gradeMode != null) {
			clearCache(gradeMode);
		}

		return gradeMode;
	}

	@Override
	public GradeMode updateImpl(GradeMode gradeMode) {
		boolean isNew = gradeMode.isNew();

		if (!(gradeMode instanceof GradeModeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(gradeMode.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(gradeMode);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in gradeMode proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom GradeMode implementation " +
					gradeMode.getClass());
		}

		GradeModeModelImpl gradeModeModelImpl = (GradeModeModelImpl)gradeMode;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (gradeMode.getCreateDate() == null)) {
			if (serviceContext == null) {
				gradeMode.setCreateDate(now);
			}
			else {
				gradeMode.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!gradeModeModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				gradeMode.setModifiedDate(now);
			}
			else {
				gradeMode.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(gradeMode);
			}
			else {
				gradeMode = (GradeMode)session.merge(gradeMode);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(GradeModeImpl.class, gradeMode, false, true);

		if (isNew) {
			gradeMode.setNew(false);
		}

		gradeMode.resetOriginalValues();

		return gradeMode;
	}

	/**
	 * Returns the grade mode with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the grade mode
	 * @return the grade mode
	 * @throws NoSuchGradeModeException if a grade mode with the primary key could not be found
	 */
	@Override
	public GradeMode findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGradeModeException {

		GradeMode gradeMode = fetchByPrimaryKey(primaryKey);

		if (gradeMode == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGradeModeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return gradeMode;
	}

	/**
	 * Returns the grade mode with the primary key or throws a <code>NoSuchGradeModeException</code> if it could not be found.
	 *
	 * @param gradeModeId the primary key of the grade mode
	 * @return the grade mode
	 * @throws NoSuchGradeModeException if a grade mode with the primary key could not be found
	 */
	@Override
	public GradeMode findByPrimaryKey(long gradeModeId)
		throws NoSuchGradeModeException {

		return findByPrimaryKey((Serializable)gradeModeId);
	}

	/**
	 * Returns the grade mode with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param gradeModeId the primary key of the grade mode
	 * @return the grade mode, or <code>null</code> if a grade mode with the primary key could not be found
	 */
	@Override
	public GradeMode fetchByPrimaryKey(long gradeModeId) {
		return fetchByPrimaryKey((Serializable)gradeModeId);
	}

	/**
	 * Returns all the grade modes.
	 *
	 * @return the grade modes
	 */
	@Override
	public List<GradeMode> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the grade modes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GradeModeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of grade modes
	 * @param end the upper bound of the range of grade modes (not inclusive)
	 * @return the range of grade modes
	 */
	@Override
	public List<GradeMode> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the grade modes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GradeModeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of grade modes
	 * @param end the upper bound of the range of grade modes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of grade modes
	 */
	@Override
	public List<GradeMode> findAll(
		int start, int end, OrderByComparator<GradeMode> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the grade modes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GradeModeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of grade modes
	 * @param end the upper bound of the range of grade modes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of grade modes
	 */
	@Override
	public List<GradeMode> findAll(
		int start, int end, OrderByComparator<GradeMode> orderByComparator,
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

		List<GradeMode> list = null;

		if (useFinderCache) {
			list = (List<GradeMode>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_GRADEMODE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_GRADEMODE;

				sql = sql.concat(GradeModeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<GradeMode>)QueryUtil.list(
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
	 * Removes all the grade modes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (GradeMode gradeMode : findAll()) {
			remove(gradeMode);
		}
	}

	/**
	 * Returns the number of grade modes.
	 *
	 * @return the number of grade modes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_GRADEMODE);

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
		return "gradeModeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_GRADEMODE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return GradeModeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the grade mode persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new GradeModeModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", GradeMode.class.getName()));

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
		entityCache.removeCache(GradeModeImpl.class.getName());

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

	private static final String _SQL_SELECT_GRADEMODE =
		"SELECT gradeMode FROM GradeMode gradeMode";

	private static final String _SQL_COUNT_GRADEMODE =
		"SELECT COUNT(gradeMode) FROM GradeMode gradeMode";

	private static final String _ORDER_BY_ENTITY_ALIAS = "gradeMode.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No GradeMode exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		GradeModePersistenceImpl.class);

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

	private static class GradeModeModelArgumentsResolver
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

			GradeModeModelImpl gradeModeModelImpl =
				(GradeModeModelImpl)baseModel;

			long columnBitmask = gradeModeModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(gradeModeModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						gradeModeModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(gradeModeModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			GradeModeModelImpl gradeModeModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = gradeModeModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = gradeModeModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}