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

import com.adjecti.mdm.liferay.exception.NoSuchPayHeadException;
import com.adjecti.mdm.liferay.model.PayHead;
import com.adjecti.mdm.liferay.model.impl.PayHeadImpl;
import com.adjecti.mdm.liferay.model.impl.PayHeadModelImpl;
import com.adjecti.mdm.liferay.service.persistence.PayHeadPersistence;
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
 * The persistence implementation for the pay head service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PayHeadPersistence.class)
public class PayHeadPersistenceImpl
	extends BasePersistenceImpl<PayHead> implements PayHeadPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PayHeadUtil</code> to access the pay head persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PayHeadImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public PayHeadPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");
		dbColumnNames.put("code", "code_");

		setDBColumnNames(dbColumnNames);

		setModelClass(PayHead.class);

		setModelImplClass(PayHeadImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the pay head in the entity cache if it is enabled.
	 *
	 * @param payHead the pay head
	 */
	@Override
	public void cacheResult(PayHead payHead) {
		entityCache.putResult(
			PayHeadImpl.class, payHead.getPrimaryKey(), payHead);
	}

	/**
	 * Caches the pay heads in the entity cache if it is enabled.
	 *
	 * @param payHeads the pay heads
	 */
	@Override
	public void cacheResult(List<PayHead> payHeads) {
		for (PayHead payHead : payHeads) {
			if (entityCache.getResult(
					PayHeadImpl.class, payHead.getPrimaryKey()) == null) {

				cacheResult(payHead);
			}
		}
	}

	/**
	 * Clears the cache for all pay heads.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PayHeadImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the pay head.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PayHead payHead) {
		entityCache.removeResult(PayHeadImpl.class, payHead);
	}

	@Override
	public void clearCache(List<PayHead> payHeads) {
		for (PayHead payHead : payHeads) {
			entityCache.removeResult(PayHeadImpl.class, payHead);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PayHeadImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new pay head with the primary key. Does not add the pay head to the database.
	 *
	 * @param payHeadId the primary key for the new pay head
	 * @return the new pay head
	 */
	@Override
	public PayHead create(long payHeadId) {
		PayHead payHead = new PayHeadImpl();

		payHead.setNew(true);
		payHead.setPrimaryKey(payHeadId);

		payHead.setCompanyId(CompanyThreadLocal.getCompanyId());

		return payHead;
	}

	/**
	 * Removes the pay head with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param payHeadId the primary key of the pay head
	 * @return the pay head that was removed
	 * @throws NoSuchPayHeadException if a pay head with the primary key could not be found
	 */
	@Override
	public PayHead remove(long payHeadId) throws NoSuchPayHeadException {
		return remove((Serializable)payHeadId);
	}

	/**
	 * Removes the pay head with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the pay head
	 * @return the pay head that was removed
	 * @throws NoSuchPayHeadException if a pay head with the primary key could not be found
	 */
	@Override
	public PayHead remove(Serializable primaryKey)
		throws NoSuchPayHeadException {

		Session session = null;

		try {
			session = openSession();

			PayHead payHead = (PayHead)session.get(
				PayHeadImpl.class, primaryKey);

			if (payHead == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPayHeadException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(payHead);
		}
		catch (NoSuchPayHeadException noSuchEntityException) {
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
	protected PayHead removeImpl(PayHead payHead) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(payHead)) {
				payHead = (PayHead)session.get(
					PayHeadImpl.class, payHead.getPrimaryKeyObj());
			}

			if (payHead != null) {
				session.delete(payHead);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (payHead != null) {
			clearCache(payHead);
		}

		return payHead;
	}

	@Override
	public PayHead updateImpl(PayHead payHead) {
		boolean isNew = payHead.isNew();

		if (!(payHead instanceof PayHeadModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(payHead.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(payHead);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in payHead proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PayHead implementation " +
					payHead.getClass());
		}

		PayHeadModelImpl payHeadModelImpl = (PayHeadModelImpl)payHead;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (payHead.getCreateDate() == null)) {
			if (serviceContext == null) {
				payHead.setCreateDate(now);
			}
			else {
				payHead.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!payHeadModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				payHead.setModifiedDate(now);
			}
			else {
				payHead.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(payHead);
			}
			else {
				payHead = (PayHead)session.merge(payHead);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(PayHeadImpl.class, payHead, false, true);

		if (isNew) {
			payHead.setNew(false);
		}

		payHead.resetOriginalValues();

		return payHead;
	}

	/**
	 * Returns the pay head with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the pay head
	 * @return the pay head
	 * @throws NoSuchPayHeadException if a pay head with the primary key could not be found
	 */
	@Override
	public PayHead findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPayHeadException {

		PayHead payHead = fetchByPrimaryKey(primaryKey);

		if (payHead == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPayHeadException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return payHead;
	}

	/**
	 * Returns the pay head with the primary key or throws a <code>NoSuchPayHeadException</code> if it could not be found.
	 *
	 * @param payHeadId the primary key of the pay head
	 * @return the pay head
	 * @throws NoSuchPayHeadException if a pay head with the primary key could not be found
	 */
	@Override
	public PayHead findByPrimaryKey(long payHeadId)
		throws NoSuchPayHeadException {

		return findByPrimaryKey((Serializable)payHeadId);
	}

	/**
	 * Returns the pay head with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param payHeadId the primary key of the pay head
	 * @return the pay head, or <code>null</code> if a pay head with the primary key could not be found
	 */
	@Override
	public PayHead fetchByPrimaryKey(long payHeadId) {
		return fetchByPrimaryKey((Serializable)payHeadId);
	}

	/**
	 * Returns all the pay heads.
	 *
	 * @return the pay heads
	 */
	@Override
	public List<PayHead> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pay heads.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PayHeadModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay heads
	 * @param end the upper bound of the range of pay heads (not inclusive)
	 * @return the range of pay heads
	 */
	@Override
	public List<PayHead> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the pay heads.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PayHeadModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay heads
	 * @param end the upper bound of the range of pay heads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pay heads
	 */
	@Override
	public List<PayHead> findAll(
		int start, int end, OrderByComparator<PayHead> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pay heads.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PayHeadModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay heads
	 * @param end the upper bound of the range of pay heads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of pay heads
	 */
	@Override
	public List<PayHead> findAll(
		int start, int end, OrderByComparator<PayHead> orderByComparator,
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

		List<PayHead> list = null;

		if (useFinderCache) {
			list = (List<PayHead>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PAYHEAD);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PAYHEAD;

				sql = sql.concat(PayHeadModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PayHead>)QueryUtil.list(
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
	 * Removes all the pay heads from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PayHead payHead : findAll()) {
			remove(payHead);
		}
	}

	/**
	 * Returns the number of pay heads.
	 *
	 * @return the number of pay heads
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PAYHEAD);

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
		return "payHeadId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PAYHEAD;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PayHeadModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the pay head persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new PayHeadModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", PayHead.class.getName()));

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
		entityCache.removeCache(PayHeadImpl.class.getName());

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

	private static final String _SQL_SELECT_PAYHEAD =
		"SELECT payHead FROM PayHead payHead";

	private static final String _SQL_COUNT_PAYHEAD =
		"SELECT COUNT(payHead) FROM PayHead payHead";

	private static final String _ORDER_BY_ENTITY_ALIAS = "payHead.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PayHead exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		PayHeadPersistenceImpl.class);

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

	private static class PayHeadModelArgumentsResolver
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

			PayHeadModelImpl payHeadModelImpl = (PayHeadModelImpl)baseModel;

			long columnBitmask = payHeadModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(payHeadModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						payHeadModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(payHeadModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			PayHeadModelImpl payHeadModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = payHeadModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = payHeadModelImpl.getColumnValue(columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}