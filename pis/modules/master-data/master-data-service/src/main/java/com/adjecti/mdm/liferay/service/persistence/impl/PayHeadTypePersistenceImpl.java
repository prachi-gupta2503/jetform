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

import com.adjecti.mdm.liferay.exception.NoSuchPayHeadTypeException;
import com.adjecti.mdm.liferay.model.PayHeadType;
import com.adjecti.mdm.liferay.model.impl.PayHeadTypeImpl;
import com.adjecti.mdm.liferay.model.impl.PayHeadTypeModelImpl;
import com.adjecti.mdm.liferay.service.persistence.PayHeadTypePersistence;
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
 * The persistence implementation for the pay head type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PayHeadTypePersistence.class)
public class PayHeadTypePersistenceImpl
	extends BasePersistenceImpl<PayHeadType> implements PayHeadTypePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PayHeadTypeUtil</code> to access the pay head type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PayHeadTypeImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public PayHeadTypePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");
		dbColumnNames.put("code", "code_");

		setDBColumnNames(dbColumnNames);

		setModelClass(PayHeadType.class);

		setModelImplClass(PayHeadTypeImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the pay head type in the entity cache if it is enabled.
	 *
	 * @param payHeadType the pay head type
	 */
	@Override
	public void cacheResult(PayHeadType payHeadType) {
		entityCache.putResult(
			PayHeadTypeImpl.class, payHeadType.getPrimaryKey(), payHeadType);
	}

	/**
	 * Caches the pay head types in the entity cache if it is enabled.
	 *
	 * @param payHeadTypes the pay head types
	 */
	@Override
	public void cacheResult(List<PayHeadType> payHeadTypes) {
		for (PayHeadType payHeadType : payHeadTypes) {
			if (entityCache.getResult(
					PayHeadTypeImpl.class, payHeadType.getPrimaryKey()) ==
						null) {

				cacheResult(payHeadType);
			}
		}
	}

	/**
	 * Clears the cache for all pay head types.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PayHeadTypeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the pay head type.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PayHeadType payHeadType) {
		entityCache.removeResult(PayHeadTypeImpl.class, payHeadType);
	}

	@Override
	public void clearCache(List<PayHeadType> payHeadTypes) {
		for (PayHeadType payHeadType : payHeadTypes) {
			entityCache.removeResult(PayHeadTypeImpl.class, payHeadType);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PayHeadTypeImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new pay head type with the primary key. Does not add the pay head type to the database.
	 *
	 * @param payHeadTypeId the primary key for the new pay head type
	 * @return the new pay head type
	 */
	@Override
	public PayHeadType create(long payHeadTypeId) {
		PayHeadType payHeadType = new PayHeadTypeImpl();

		payHeadType.setNew(true);
		payHeadType.setPrimaryKey(payHeadTypeId);

		payHeadType.setCompanyId(CompanyThreadLocal.getCompanyId());

		return payHeadType;
	}

	/**
	 * Removes the pay head type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param payHeadTypeId the primary key of the pay head type
	 * @return the pay head type that was removed
	 * @throws NoSuchPayHeadTypeException if a pay head type with the primary key could not be found
	 */
	@Override
	public PayHeadType remove(long payHeadTypeId)
		throws NoSuchPayHeadTypeException {

		return remove((Serializable)payHeadTypeId);
	}

	/**
	 * Removes the pay head type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the pay head type
	 * @return the pay head type that was removed
	 * @throws NoSuchPayHeadTypeException if a pay head type with the primary key could not be found
	 */
	@Override
	public PayHeadType remove(Serializable primaryKey)
		throws NoSuchPayHeadTypeException {

		Session session = null;

		try {
			session = openSession();

			PayHeadType payHeadType = (PayHeadType)session.get(
				PayHeadTypeImpl.class, primaryKey);

			if (payHeadType == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPayHeadTypeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(payHeadType);
		}
		catch (NoSuchPayHeadTypeException noSuchEntityException) {
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
	protected PayHeadType removeImpl(PayHeadType payHeadType) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(payHeadType)) {
				payHeadType = (PayHeadType)session.get(
					PayHeadTypeImpl.class, payHeadType.getPrimaryKeyObj());
			}

			if (payHeadType != null) {
				session.delete(payHeadType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (payHeadType != null) {
			clearCache(payHeadType);
		}

		return payHeadType;
	}

	@Override
	public PayHeadType updateImpl(PayHeadType payHeadType) {
		boolean isNew = payHeadType.isNew();

		if (!(payHeadType instanceof PayHeadTypeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(payHeadType.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(payHeadType);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in payHeadType proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PayHeadType implementation " +
					payHeadType.getClass());
		}

		PayHeadTypeModelImpl payHeadTypeModelImpl =
			(PayHeadTypeModelImpl)payHeadType;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (payHeadType.getCreateDate() == null)) {
			if (serviceContext == null) {
				payHeadType.setCreateDate(now);
			}
			else {
				payHeadType.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!payHeadTypeModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				payHeadType.setModifiedDate(now);
			}
			else {
				payHeadType.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(payHeadType);
			}
			else {
				payHeadType = (PayHeadType)session.merge(payHeadType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(PayHeadTypeImpl.class, payHeadType, false, true);

		if (isNew) {
			payHeadType.setNew(false);
		}

		payHeadType.resetOriginalValues();

		return payHeadType;
	}

	/**
	 * Returns the pay head type with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the pay head type
	 * @return the pay head type
	 * @throws NoSuchPayHeadTypeException if a pay head type with the primary key could not be found
	 */
	@Override
	public PayHeadType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPayHeadTypeException {

		PayHeadType payHeadType = fetchByPrimaryKey(primaryKey);

		if (payHeadType == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPayHeadTypeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return payHeadType;
	}

	/**
	 * Returns the pay head type with the primary key or throws a <code>NoSuchPayHeadTypeException</code> if it could not be found.
	 *
	 * @param payHeadTypeId the primary key of the pay head type
	 * @return the pay head type
	 * @throws NoSuchPayHeadTypeException if a pay head type with the primary key could not be found
	 */
	@Override
	public PayHeadType findByPrimaryKey(long payHeadTypeId)
		throws NoSuchPayHeadTypeException {

		return findByPrimaryKey((Serializable)payHeadTypeId);
	}

	/**
	 * Returns the pay head type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param payHeadTypeId the primary key of the pay head type
	 * @return the pay head type, or <code>null</code> if a pay head type with the primary key could not be found
	 */
	@Override
	public PayHeadType fetchByPrimaryKey(long payHeadTypeId) {
		return fetchByPrimaryKey((Serializable)payHeadTypeId);
	}

	/**
	 * Returns all the pay head types.
	 *
	 * @return the pay head types
	 */
	@Override
	public List<PayHeadType> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pay head types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PayHeadTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay head types
	 * @param end the upper bound of the range of pay head types (not inclusive)
	 * @return the range of pay head types
	 */
	@Override
	public List<PayHeadType> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the pay head types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PayHeadTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay head types
	 * @param end the upper bound of the range of pay head types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pay head types
	 */
	@Override
	public List<PayHeadType> findAll(
		int start, int end, OrderByComparator<PayHeadType> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pay head types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PayHeadTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay head types
	 * @param end the upper bound of the range of pay head types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of pay head types
	 */
	@Override
	public List<PayHeadType> findAll(
		int start, int end, OrderByComparator<PayHeadType> orderByComparator,
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

		List<PayHeadType> list = null;

		if (useFinderCache) {
			list = (List<PayHeadType>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PAYHEADTYPE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PAYHEADTYPE;

				sql = sql.concat(PayHeadTypeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PayHeadType>)QueryUtil.list(
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
	 * Removes all the pay head types from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PayHeadType payHeadType : findAll()) {
			remove(payHeadType);
		}
	}

	/**
	 * Returns the number of pay head types.
	 *
	 * @return the number of pay head types
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PAYHEADTYPE);

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
		return "payHeadTypeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PAYHEADTYPE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PayHeadTypeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the pay head type persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new PayHeadTypeModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", PayHeadType.class.getName()));

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
		entityCache.removeCache(PayHeadTypeImpl.class.getName());

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

	private static final String _SQL_SELECT_PAYHEADTYPE =
		"SELECT payHeadType FROM PayHeadType payHeadType";

	private static final String _SQL_COUNT_PAYHEADTYPE =
		"SELECT COUNT(payHeadType) FROM PayHeadType payHeadType";

	private static final String _ORDER_BY_ENTITY_ALIAS = "payHeadType.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PayHeadType exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		PayHeadTypePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"active", "code"});

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

	private static class PayHeadTypeModelArgumentsResolver
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

			PayHeadTypeModelImpl payHeadTypeModelImpl =
				(PayHeadTypeModelImpl)baseModel;

			long columnBitmask = payHeadTypeModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(payHeadTypeModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						payHeadTypeModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(payHeadTypeModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			PayHeadTypeModelImpl payHeadTypeModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = payHeadTypeModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = payHeadTypeModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}