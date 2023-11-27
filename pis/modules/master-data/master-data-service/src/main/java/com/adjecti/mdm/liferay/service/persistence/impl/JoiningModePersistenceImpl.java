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

import com.adjecti.mdm.liferay.exception.NoSuchJoiningModeException;
import com.adjecti.mdm.liferay.model.JoiningMode;
import com.adjecti.mdm.liferay.model.impl.JoiningModeImpl;
import com.adjecti.mdm.liferay.model.impl.JoiningModeModelImpl;
import com.adjecti.mdm.liferay.service.persistence.JoiningModePersistence;
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
 * The persistence implementation for the joining mode service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = JoiningModePersistence.class)
public class JoiningModePersistenceImpl
	extends BasePersistenceImpl<JoiningMode> implements JoiningModePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>JoiningModeUtil</code> to access the joining mode persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		JoiningModeImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public JoiningModePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("code", "code_");

		setDBColumnNames(dbColumnNames);

		setModelClass(JoiningMode.class);

		setModelImplClass(JoiningModeImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the joining mode in the entity cache if it is enabled.
	 *
	 * @param joiningMode the joining mode
	 */
	@Override
	public void cacheResult(JoiningMode joiningMode) {
		entityCache.putResult(
			JoiningModeImpl.class, joiningMode.getPrimaryKey(), joiningMode);
	}

	/**
	 * Caches the joining modes in the entity cache if it is enabled.
	 *
	 * @param joiningModes the joining modes
	 */
	@Override
	public void cacheResult(List<JoiningMode> joiningModes) {
		for (JoiningMode joiningMode : joiningModes) {
			if (entityCache.getResult(
					JoiningModeImpl.class, joiningMode.getPrimaryKey()) ==
						null) {

				cacheResult(joiningMode);
			}
		}
	}

	/**
	 * Clears the cache for all joining modes.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(JoiningModeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the joining mode.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(JoiningMode joiningMode) {
		entityCache.removeResult(JoiningModeImpl.class, joiningMode);
	}

	@Override
	public void clearCache(List<JoiningMode> joiningModes) {
		for (JoiningMode joiningMode : joiningModes) {
			entityCache.removeResult(JoiningModeImpl.class, joiningMode);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(JoiningModeImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new joining mode with the primary key. Does not add the joining mode to the database.
	 *
	 * @param joiningModeId the primary key for the new joining mode
	 * @return the new joining mode
	 */
	@Override
	public JoiningMode create(long joiningModeId) {
		JoiningMode joiningMode = new JoiningModeImpl();

		joiningMode.setNew(true);
		joiningMode.setPrimaryKey(joiningModeId);

		joiningMode.setCompanyId(CompanyThreadLocal.getCompanyId());

		return joiningMode;
	}

	/**
	 * Removes the joining mode with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param joiningModeId the primary key of the joining mode
	 * @return the joining mode that was removed
	 * @throws NoSuchJoiningModeException if a joining mode with the primary key could not be found
	 */
	@Override
	public JoiningMode remove(long joiningModeId)
		throws NoSuchJoiningModeException {

		return remove((Serializable)joiningModeId);
	}

	/**
	 * Removes the joining mode with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the joining mode
	 * @return the joining mode that was removed
	 * @throws NoSuchJoiningModeException if a joining mode with the primary key could not be found
	 */
	@Override
	public JoiningMode remove(Serializable primaryKey)
		throws NoSuchJoiningModeException {

		Session session = null;

		try {
			session = openSession();

			JoiningMode joiningMode = (JoiningMode)session.get(
				JoiningModeImpl.class, primaryKey);

			if (joiningMode == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchJoiningModeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(joiningMode);
		}
		catch (NoSuchJoiningModeException noSuchEntityException) {
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
	protected JoiningMode removeImpl(JoiningMode joiningMode) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(joiningMode)) {
				joiningMode = (JoiningMode)session.get(
					JoiningModeImpl.class, joiningMode.getPrimaryKeyObj());
			}

			if (joiningMode != null) {
				session.delete(joiningMode);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (joiningMode != null) {
			clearCache(joiningMode);
		}

		return joiningMode;
	}

	@Override
	public JoiningMode updateImpl(JoiningMode joiningMode) {
		boolean isNew = joiningMode.isNew();

		if (!(joiningMode instanceof JoiningModeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(joiningMode.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(joiningMode);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in joiningMode proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom JoiningMode implementation " +
					joiningMode.getClass());
		}

		JoiningModeModelImpl joiningModeModelImpl =
			(JoiningModeModelImpl)joiningMode;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (joiningMode.getCreateDate() == null)) {
			if (serviceContext == null) {
				joiningMode.setCreateDate(now);
			}
			else {
				joiningMode.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!joiningModeModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				joiningMode.setModifiedDate(now);
			}
			else {
				joiningMode.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(joiningMode);
			}
			else {
				joiningMode = (JoiningMode)session.merge(joiningMode);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(JoiningModeImpl.class, joiningMode, false, true);

		if (isNew) {
			joiningMode.setNew(false);
		}

		joiningMode.resetOriginalValues();

		return joiningMode;
	}

	/**
	 * Returns the joining mode with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the joining mode
	 * @return the joining mode
	 * @throws NoSuchJoiningModeException if a joining mode with the primary key could not be found
	 */
	@Override
	public JoiningMode findByPrimaryKey(Serializable primaryKey)
		throws NoSuchJoiningModeException {

		JoiningMode joiningMode = fetchByPrimaryKey(primaryKey);

		if (joiningMode == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchJoiningModeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return joiningMode;
	}

	/**
	 * Returns the joining mode with the primary key or throws a <code>NoSuchJoiningModeException</code> if it could not be found.
	 *
	 * @param joiningModeId the primary key of the joining mode
	 * @return the joining mode
	 * @throws NoSuchJoiningModeException if a joining mode with the primary key could not be found
	 */
	@Override
	public JoiningMode findByPrimaryKey(long joiningModeId)
		throws NoSuchJoiningModeException {

		return findByPrimaryKey((Serializable)joiningModeId);
	}

	/**
	 * Returns the joining mode with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param joiningModeId the primary key of the joining mode
	 * @return the joining mode, or <code>null</code> if a joining mode with the primary key could not be found
	 */
	@Override
	public JoiningMode fetchByPrimaryKey(long joiningModeId) {
		return fetchByPrimaryKey((Serializable)joiningModeId);
	}

	/**
	 * Returns all the joining modes.
	 *
	 * @return the joining modes
	 */
	@Override
	public List<JoiningMode> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the joining modes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningModeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of joining modes
	 * @param end the upper bound of the range of joining modes (not inclusive)
	 * @return the range of joining modes
	 */
	@Override
	public List<JoiningMode> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the joining modes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningModeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of joining modes
	 * @param end the upper bound of the range of joining modes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of joining modes
	 */
	@Override
	public List<JoiningMode> findAll(
		int start, int end, OrderByComparator<JoiningMode> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the joining modes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningModeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of joining modes
	 * @param end the upper bound of the range of joining modes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of joining modes
	 */
	@Override
	public List<JoiningMode> findAll(
		int start, int end, OrderByComparator<JoiningMode> orderByComparator,
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

		List<JoiningMode> list = null;

		if (useFinderCache) {
			list = (List<JoiningMode>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_JOININGMODE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_JOININGMODE;

				sql = sql.concat(JoiningModeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<JoiningMode>)QueryUtil.list(
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
	 * Removes all the joining modes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (JoiningMode joiningMode : findAll()) {
			remove(joiningMode);
		}
	}

	/**
	 * Returns the number of joining modes.
	 *
	 * @return the number of joining modes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_JOININGMODE);

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
		return "joiningModeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_JOININGMODE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return JoiningModeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the joining mode persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new JoiningModeModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", JoiningMode.class.getName()));

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
		entityCache.removeCache(JoiningModeImpl.class.getName());

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

	private static final String _SQL_SELECT_JOININGMODE =
		"SELECT joiningMode FROM JoiningMode joiningMode";

	private static final String _SQL_COUNT_JOININGMODE =
		"SELECT COUNT(joiningMode) FROM JoiningMode joiningMode";

	private static final String _ORDER_BY_ENTITY_ALIAS = "joiningMode.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No JoiningMode exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		JoiningModePersistenceImpl.class);

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

	private static class JoiningModeModelArgumentsResolver
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

			JoiningModeModelImpl joiningModeModelImpl =
				(JoiningModeModelImpl)baseModel;

			long columnBitmask = joiningModeModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(joiningModeModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						joiningModeModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(joiningModeModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			JoiningModeModelImpl joiningModeModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = joiningModeModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = joiningModeModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}