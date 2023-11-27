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

import com.adjecti.mdm.liferay.exception.NoSuchDesignationClassException;
import com.adjecti.mdm.liferay.model.DesignationClass;
import com.adjecti.mdm.liferay.model.impl.DesignationClassImpl;
import com.adjecti.mdm.liferay.model.impl.DesignationClassModelImpl;
import com.adjecti.mdm.liferay.service.persistence.DesignationClassPersistence;
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
 * The persistence implementation for the designation class service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DesignationClassPersistence.class)
public class DesignationClassPersistenceImpl
	extends BasePersistenceImpl<DesignationClass>
	implements DesignationClassPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DesignationClassUtil</code> to access the designation class persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DesignationClassImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public DesignationClassPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("code", "code_");

		setDBColumnNames(dbColumnNames);

		setModelClass(DesignationClass.class);

		setModelImplClass(DesignationClassImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the designation class in the entity cache if it is enabled.
	 *
	 * @param designationClass the designation class
	 */
	@Override
	public void cacheResult(DesignationClass designationClass) {
		entityCache.putResult(
			DesignationClassImpl.class, designationClass.getPrimaryKey(),
			designationClass);
	}

	/**
	 * Caches the designation classes in the entity cache if it is enabled.
	 *
	 * @param designationClasses the designation classes
	 */
	@Override
	public void cacheResult(List<DesignationClass> designationClasses) {
		for (DesignationClass designationClass : designationClasses) {
			if (entityCache.getResult(
					DesignationClassImpl.class,
					designationClass.getPrimaryKey()) == null) {

				cacheResult(designationClass);
			}
		}
	}

	/**
	 * Clears the cache for all designation classes.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DesignationClassImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the designation class.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DesignationClass designationClass) {
		entityCache.removeResult(DesignationClassImpl.class, designationClass);
	}

	@Override
	public void clearCache(List<DesignationClass> designationClasses) {
		for (DesignationClass designationClass : designationClasses) {
			entityCache.removeResult(
				DesignationClassImpl.class, designationClass);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DesignationClassImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new designation class with the primary key. Does not add the designation class to the database.
	 *
	 * @param designationClassId the primary key for the new designation class
	 * @return the new designation class
	 */
	@Override
	public DesignationClass create(long designationClassId) {
		DesignationClass designationClass = new DesignationClassImpl();

		designationClass.setNew(true);
		designationClass.setPrimaryKey(designationClassId);

		designationClass.setCompanyId(CompanyThreadLocal.getCompanyId());

		return designationClass;
	}

	/**
	 * Removes the designation class with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param designationClassId the primary key of the designation class
	 * @return the designation class that was removed
	 * @throws NoSuchDesignationClassException if a designation class with the primary key could not be found
	 */
	@Override
	public DesignationClass remove(long designationClassId)
		throws NoSuchDesignationClassException {

		return remove((Serializable)designationClassId);
	}

	/**
	 * Removes the designation class with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the designation class
	 * @return the designation class that was removed
	 * @throws NoSuchDesignationClassException if a designation class with the primary key could not be found
	 */
	@Override
	public DesignationClass remove(Serializable primaryKey)
		throws NoSuchDesignationClassException {

		Session session = null;

		try {
			session = openSession();

			DesignationClass designationClass = (DesignationClass)session.get(
				DesignationClassImpl.class, primaryKey);

			if (designationClass == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDesignationClassException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(designationClass);
		}
		catch (NoSuchDesignationClassException noSuchEntityException) {
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
	protected DesignationClass removeImpl(DesignationClass designationClass) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(designationClass)) {
				designationClass = (DesignationClass)session.get(
					DesignationClassImpl.class,
					designationClass.getPrimaryKeyObj());
			}

			if (designationClass != null) {
				session.delete(designationClass);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (designationClass != null) {
			clearCache(designationClass);
		}

		return designationClass;
	}

	@Override
	public DesignationClass updateImpl(DesignationClass designationClass) {
		boolean isNew = designationClass.isNew();

		if (!(designationClass instanceof DesignationClassModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(designationClass.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					designationClass);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in designationClass proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DesignationClass implementation " +
					designationClass.getClass());
		}

		DesignationClassModelImpl designationClassModelImpl =
			(DesignationClassModelImpl)designationClass;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (designationClass.getCreateDate() == null)) {
			if (serviceContext == null) {
				designationClass.setCreateDate(now);
			}
			else {
				designationClass.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!designationClassModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				designationClass.setModifiedDate(now);
			}
			else {
				designationClass.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(designationClass);
			}
			else {
				designationClass = (DesignationClass)session.merge(
					designationClass);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DesignationClassImpl.class, designationClass, false, true);

		if (isNew) {
			designationClass.setNew(false);
		}

		designationClass.resetOriginalValues();

		return designationClass;
	}

	/**
	 * Returns the designation class with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the designation class
	 * @return the designation class
	 * @throws NoSuchDesignationClassException if a designation class with the primary key could not be found
	 */
	@Override
	public DesignationClass findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDesignationClassException {

		DesignationClass designationClass = fetchByPrimaryKey(primaryKey);

		if (designationClass == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDesignationClassException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return designationClass;
	}

	/**
	 * Returns the designation class with the primary key or throws a <code>NoSuchDesignationClassException</code> if it could not be found.
	 *
	 * @param designationClassId the primary key of the designation class
	 * @return the designation class
	 * @throws NoSuchDesignationClassException if a designation class with the primary key could not be found
	 */
	@Override
	public DesignationClass findByPrimaryKey(long designationClassId)
		throws NoSuchDesignationClassException {

		return findByPrimaryKey((Serializable)designationClassId);
	}

	/**
	 * Returns the designation class with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param designationClassId the primary key of the designation class
	 * @return the designation class, or <code>null</code> if a designation class with the primary key could not be found
	 */
	@Override
	public DesignationClass fetchByPrimaryKey(long designationClassId) {
		return fetchByPrimaryKey((Serializable)designationClassId);
	}

	/**
	 * Returns all the designation classes.
	 *
	 * @return the designation classes
	 */
	@Override
	public List<DesignationClass> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the designation classes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationClassModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation classes
	 * @param end the upper bound of the range of designation classes (not inclusive)
	 * @return the range of designation classes
	 */
	@Override
	public List<DesignationClass> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the designation classes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationClassModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation classes
	 * @param end the upper bound of the range of designation classes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of designation classes
	 */
	@Override
	public List<DesignationClass> findAll(
		int start, int end,
		OrderByComparator<DesignationClass> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the designation classes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationClassModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation classes
	 * @param end the upper bound of the range of designation classes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of designation classes
	 */
	@Override
	public List<DesignationClass> findAll(
		int start, int end,
		OrderByComparator<DesignationClass> orderByComparator,
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

		List<DesignationClass> list = null;

		if (useFinderCache) {
			list = (List<DesignationClass>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DESIGNATIONCLASS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DESIGNATIONCLASS;

				sql = sql.concat(DesignationClassModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DesignationClass>)QueryUtil.list(
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
	 * Removes all the designation classes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DesignationClass designationClass : findAll()) {
			remove(designationClass);
		}
	}

	/**
	 * Returns the number of designation classes.
	 *
	 * @return the number of designation classes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DESIGNATIONCLASS);

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
		return "designationClassId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DESIGNATIONCLASS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DesignationClassModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the designation class persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new DesignationClassModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", DesignationClass.class.getName()));

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
		entityCache.removeCache(DesignationClassImpl.class.getName());

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

	private static final String _SQL_SELECT_DESIGNATIONCLASS =
		"SELECT designationClass FROM DesignationClass designationClass";

	private static final String _SQL_COUNT_DESIGNATIONCLASS =
		"SELECT COUNT(designationClass) FROM DesignationClass designationClass";

	private static final String _ORDER_BY_ENTITY_ALIAS = "designationClass.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DesignationClass exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		DesignationClassPersistenceImpl.class);

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

	private static class DesignationClassModelArgumentsResolver
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

			DesignationClassModelImpl designationClassModelImpl =
				(DesignationClassModelImpl)baseModel;

			long columnBitmask = designationClassModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					designationClassModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						designationClassModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					designationClassModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			DesignationClassModelImpl designationClassModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						designationClassModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = designationClassModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}