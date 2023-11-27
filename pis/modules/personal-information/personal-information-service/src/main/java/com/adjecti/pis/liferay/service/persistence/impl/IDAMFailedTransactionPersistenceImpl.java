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

import com.adjecti.pis.liferay.exception.NoSuchIDAMFailedTransactionException;
import com.adjecti.pis.liferay.model.IDAMFailedTransaction;
import com.adjecti.pis.liferay.model.impl.IDAMFailedTransactionImpl;
import com.adjecti.pis.liferay.model.impl.IDAMFailedTransactionModelImpl;
import com.adjecti.pis.liferay.service.persistence.IDAMFailedTransactionPersistence;
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
 * The persistence implementation for the idam failed transaction service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = IDAMFailedTransactionPersistence.class)
public class IDAMFailedTransactionPersistenceImpl
	extends BasePersistenceImpl<IDAMFailedTransaction>
	implements IDAMFailedTransactionPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>IDAMFailedTransactionUtil</code> to access the idam failed transaction persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		IDAMFailedTransactionImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public IDAMFailedTransactionPersistenceImpl() {
		setModelClass(IDAMFailedTransaction.class);

		setModelImplClass(IDAMFailedTransactionImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the idam failed transaction in the entity cache if it is enabled.
	 *
	 * @param idamFailedTransaction the idam failed transaction
	 */
	@Override
	public void cacheResult(IDAMFailedTransaction idamFailedTransaction) {
		entityCache.putResult(
			IDAMFailedTransactionImpl.class,
			idamFailedTransaction.getPrimaryKey(), idamFailedTransaction);
	}

	/**
	 * Caches the idam failed transactions in the entity cache if it is enabled.
	 *
	 * @param idamFailedTransactions the idam failed transactions
	 */
	@Override
	public void cacheResult(
		List<IDAMFailedTransaction> idamFailedTransactions) {

		for (IDAMFailedTransaction idamFailedTransaction :
				idamFailedTransactions) {

			if (entityCache.getResult(
					IDAMFailedTransactionImpl.class,
					idamFailedTransaction.getPrimaryKey()) == null) {

				cacheResult(idamFailedTransaction);
			}
		}
	}

	/**
	 * Clears the cache for all idam failed transactions.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(IDAMFailedTransactionImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the idam failed transaction.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(IDAMFailedTransaction idamFailedTransaction) {
		entityCache.removeResult(
			IDAMFailedTransactionImpl.class, idamFailedTransaction);
	}

	@Override
	public void clearCache(List<IDAMFailedTransaction> idamFailedTransactions) {
		for (IDAMFailedTransaction idamFailedTransaction :
				idamFailedTransactions) {

			entityCache.removeResult(
				IDAMFailedTransactionImpl.class, idamFailedTransaction);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				IDAMFailedTransactionImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new idam failed transaction with the primary key. Does not add the idam failed transaction to the database.
	 *
	 * @param idamFailedTransactionId the primary key for the new idam failed transaction
	 * @return the new idam failed transaction
	 */
	@Override
	public IDAMFailedTransaction create(long idamFailedTransactionId) {
		IDAMFailedTransaction idamFailedTransaction =
			new IDAMFailedTransactionImpl();

		idamFailedTransaction.setNew(true);
		idamFailedTransaction.setPrimaryKey(idamFailedTransactionId);

		idamFailedTransaction.setCompanyId(CompanyThreadLocal.getCompanyId());

		return idamFailedTransaction;
	}

	/**
	 * Removes the idam failed transaction with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param idamFailedTransactionId the primary key of the idam failed transaction
	 * @return the idam failed transaction that was removed
	 * @throws NoSuchIDAMFailedTransactionException if a idam failed transaction with the primary key could not be found
	 */
	@Override
	public IDAMFailedTransaction remove(long idamFailedTransactionId)
		throws NoSuchIDAMFailedTransactionException {

		return remove((Serializable)idamFailedTransactionId);
	}

	/**
	 * Removes the idam failed transaction with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the idam failed transaction
	 * @return the idam failed transaction that was removed
	 * @throws NoSuchIDAMFailedTransactionException if a idam failed transaction with the primary key could not be found
	 */
	@Override
	public IDAMFailedTransaction remove(Serializable primaryKey)
		throws NoSuchIDAMFailedTransactionException {

		Session session = null;

		try {
			session = openSession();

			IDAMFailedTransaction idamFailedTransaction =
				(IDAMFailedTransaction)session.get(
					IDAMFailedTransactionImpl.class, primaryKey);

			if (idamFailedTransaction == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchIDAMFailedTransactionException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(idamFailedTransaction);
		}
		catch (NoSuchIDAMFailedTransactionException noSuchEntityException) {
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
	protected IDAMFailedTransaction removeImpl(
		IDAMFailedTransaction idamFailedTransaction) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(idamFailedTransaction)) {
				idamFailedTransaction = (IDAMFailedTransaction)session.get(
					IDAMFailedTransactionImpl.class,
					idamFailedTransaction.getPrimaryKeyObj());
			}

			if (idamFailedTransaction != null) {
				session.delete(idamFailedTransaction);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (idamFailedTransaction != null) {
			clearCache(idamFailedTransaction);
		}

		return idamFailedTransaction;
	}

	@Override
	public IDAMFailedTransaction updateImpl(
		IDAMFailedTransaction idamFailedTransaction) {

		boolean isNew = idamFailedTransaction.isNew();

		if (!(idamFailedTransaction instanceof
				IDAMFailedTransactionModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(idamFailedTransaction.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					idamFailedTransaction);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in idamFailedTransaction proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom IDAMFailedTransaction implementation " +
					idamFailedTransaction.getClass());
		}

		IDAMFailedTransactionModelImpl idamFailedTransactionModelImpl =
			(IDAMFailedTransactionModelImpl)idamFailedTransaction;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (idamFailedTransaction.getCreateDate() == null)) {
			if (serviceContext == null) {
				idamFailedTransaction.setCreateDate(now);
			}
			else {
				idamFailedTransaction.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!idamFailedTransactionModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				idamFailedTransaction.setModifiedDate(now);
			}
			else {
				idamFailedTransaction.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(idamFailedTransaction);
			}
			else {
				idamFailedTransaction = (IDAMFailedTransaction)session.merge(
					idamFailedTransaction);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			IDAMFailedTransactionImpl.class, idamFailedTransaction, false,
			true);

		if (isNew) {
			idamFailedTransaction.setNew(false);
		}

		idamFailedTransaction.resetOriginalValues();

		return idamFailedTransaction;
	}

	/**
	 * Returns the idam failed transaction with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the idam failed transaction
	 * @return the idam failed transaction
	 * @throws NoSuchIDAMFailedTransactionException if a idam failed transaction with the primary key could not be found
	 */
	@Override
	public IDAMFailedTransaction findByPrimaryKey(Serializable primaryKey)
		throws NoSuchIDAMFailedTransactionException {

		IDAMFailedTransaction idamFailedTransaction = fetchByPrimaryKey(
			primaryKey);

		if (idamFailedTransaction == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchIDAMFailedTransactionException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return idamFailedTransaction;
	}

	/**
	 * Returns the idam failed transaction with the primary key or throws a <code>NoSuchIDAMFailedTransactionException</code> if it could not be found.
	 *
	 * @param idamFailedTransactionId the primary key of the idam failed transaction
	 * @return the idam failed transaction
	 * @throws NoSuchIDAMFailedTransactionException if a idam failed transaction with the primary key could not be found
	 */
	@Override
	public IDAMFailedTransaction findByPrimaryKey(long idamFailedTransactionId)
		throws NoSuchIDAMFailedTransactionException {

		return findByPrimaryKey((Serializable)idamFailedTransactionId);
	}

	/**
	 * Returns the idam failed transaction with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param idamFailedTransactionId the primary key of the idam failed transaction
	 * @return the idam failed transaction, or <code>null</code> if a idam failed transaction with the primary key could not be found
	 */
	@Override
	public IDAMFailedTransaction fetchByPrimaryKey(
		long idamFailedTransactionId) {

		return fetchByPrimaryKey((Serializable)idamFailedTransactionId);
	}

	/**
	 * Returns all the idam failed transactions.
	 *
	 * @return the idam failed transactions
	 */
	@Override
	public List<IDAMFailedTransaction> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the idam failed transactions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IDAMFailedTransactionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of idam failed transactions
	 * @param end the upper bound of the range of idam failed transactions (not inclusive)
	 * @return the range of idam failed transactions
	 */
	@Override
	public List<IDAMFailedTransaction> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the idam failed transactions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IDAMFailedTransactionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of idam failed transactions
	 * @param end the upper bound of the range of idam failed transactions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of idam failed transactions
	 */
	@Override
	public List<IDAMFailedTransaction> findAll(
		int start, int end,
		OrderByComparator<IDAMFailedTransaction> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the idam failed transactions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IDAMFailedTransactionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of idam failed transactions
	 * @param end the upper bound of the range of idam failed transactions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of idam failed transactions
	 */
	@Override
	public List<IDAMFailedTransaction> findAll(
		int start, int end,
		OrderByComparator<IDAMFailedTransaction> orderByComparator,
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

		List<IDAMFailedTransaction> list = null;

		if (useFinderCache) {
			list = (List<IDAMFailedTransaction>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_IDAMFAILEDTRANSACTION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_IDAMFAILEDTRANSACTION;

				sql = sql.concat(IDAMFailedTransactionModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<IDAMFailedTransaction>)QueryUtil.list(
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
	 * Removes all the idam failed transactions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (IDAMFailedTransaction idamFailedTransaction : findAll()) {
			remove(idamFailedTransaction);
		}
	}

	/**
	 * Returns the number of idam failed transactions.
	 *
	 * @return the number of idam failed transactions
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
					_SQL_COUNT_IDAMFAILEDTRANSACTION);

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
		return "idamFailedTransactionId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_IDAMFAILEDTRANSACTION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return IDAMFailedTransactionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the idam failed transaction persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new IDAMFailedTransactionModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", IDAMFailedTransaction.class.getName()));

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
		entityCache.removeCache(IDAMFailedTransactionImpl.class.getName());

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

	private static final String _SQL_SELECT_IDAMFAILEDTRANSACTION =
		"SELECT idamFailedTransaction FROM IDAMFailedTransaction idamFailedTransaction";

	private static final String _SQL_COUNT_IDAMFAILEDTRANSACTION =
		"SELECT COUNT(idamFailedTransaction) FROM IDAMFailedTransaction idamFailedTransaction";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"idamFailedTransaction.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No IDAMFailedTransaction exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		IDAMFailedTransactionPersistenceImpl.class);

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

	private static class IDAMFailedTransactionModelArgumentsResolver
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

			IDAMFailedTransactionModelImpl idamFailedTransactionModelImpl =
				(IDAMFailedTransactionModelImpl)baseModel;

			long columnBitmask =
				idamFailedTransactionModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					idamFailedTransactionModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						idamFailedTransactionModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					idamFailedTransactionModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			IDAMFailedTransactionModelImpl idamFailedTransactionModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						idamFailedTransactionModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] =
						idamFailedTransactionModelImpl.getColumnValue(
							columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}