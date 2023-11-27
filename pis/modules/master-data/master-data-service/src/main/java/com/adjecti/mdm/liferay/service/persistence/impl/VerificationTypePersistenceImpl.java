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

import com.adjecti.mdm.liferay.exception.NoSuchVerificationTypeException;
import com.adjecti.mdm.liferay.model.VerificationType;
import com.adjecti.mdm.liferay.model.impl.VerificationTypeImpl;
import com.adjecti.mdm.liferay.model.impl.VerificationTypeModelImpl;
import com.adjecti.mdm.liferay.service.persistence.VerificationTypePersistence;
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
 * The persistence implementation for the verification type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = VerificationTypePersistence.class)
public class VerificationTypePersistenceImpl
	extends BasePersistenceImpl<VerificationType>
	implements VerificationTypePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>VerificationTypeUtil</code> to access the verification type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		VerificationTypeImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public VerificationTypePersistenceImpl() {
		setModelClass(VerificationType.class);

		setModelImplClass(VerificationTypeImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the verification type in the entity cache if it is enabled.
	 *
	 * @param verificationType the verification type
	 */
	@Override
	public void cacheResult(VerificationType verificationType) {
		entityCache.putResult(
			VerificationTypeImpl.class, verificationType.getPrimaryKey(),
			verificationType);
	}

	/**
	 * Caches the verification types in the entity cache if it is enabled.
	 *
	 * @param verificationTypes the verification types
	 */
	@Override
	public void cacheResult(List<VerificationType> verificationTypes) {
		for (VerificationType verificationType : verificationTypes) {
			if (entityCache.getResult(
					VerificationTypeImpl.class,
					verificationType.getPrimaryKey()) == null) {

				cacheResult(verificationType);
			}
		}
	}

	/**
	 * Clears the cache for all verification types.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(VerificationTypeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the verification type.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VerificationType verificationType) {
		entityCache.removeResult(VerificationTypeImpl.class, verificationType);
	}

	@Override
	public void clearCache(List<VerificationType> verificationTypes) {
		for (VerificationType verificationType : verificationTypes) {
			entityCache.removeResult(
				VerificationTypeImpl.class, verificationType);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(VerificationTypeImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new verification type with the primary key. Does not add the verification type to the database.
	 *
	 * @param verificationTypeId the primary key for the new verification type
	 * @return the new verification type
	 */
	@Override
	public VerificationType create(long verificationTypeId) {
		VerificationType verificationType = new VerificationTypeImpl();

		verificationType.setNew(true);
		verificationType.setPrimaryKey(verificationTypeId);

		verificationType.setCompanyId(CompanyThreadLocal.getCompanyId());

		return verificationType;
	}

	/**
	 * Removes the verification type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param verificationTypeId the primary key of the verification type
	 * @return the verification type that was removed
	 * @throws NoSuchVerificationTypeException if a verification type with the primary key could not be found
	 */
	@Override
	public VerificationType remove(long verificationTypeId)
		throws NoSuchVerificationTypeException {

		return remove((Serializable)verificationTypeId);
	}

	/**
	 * Removes the verification type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the verification type
	 * @return the verification type that was removed
	 * @throws NoSuchVerificationTypeException if a verification type with the primary key could not be found
	 */
	@Override
	public VerificationType remove(Serializable primaryKey)
		throws NoSuchVerificationTypeException {

		Session session = null;

		try {
			session = openSession();

			VerificationType verificationType = (VerificationType)session.get(
				VerificationTypeImpl.class, primaryKey);

			if (verificationType == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVerificationTypeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(verificationType);
		}
		catch (NoSuchVerificationTypeException noSuchEntityException) {
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
	protected VerificationType removeImpl(VerificationType verificationType) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(verificationType)) {
				verificationType = (VerificationType)session.get(
					VerificationTypeImpl.class,
					verificationType.getPrimaryKeyObj());
			}

			if (verificationType != null) {
				session.delete(verificationType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (verificationType != null) {
			clearCache(verificationType);
		}

		return verificationType;
	}

	@Override
	public VerificationType updateImpl(VerificationType verificationType) {
		boolean isNew = verificationType.isNew();

		if (!(verificationType instanceof VerificationTypeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(verificationType.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					verificationType);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in verificationType proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom VerificationType implementation " +
					verificationType.getClass());
		}

		VerificationTypeModelImpl verificationTypeModelImpl =
			(VerificationTypeModelImpl)verificationType;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (verificationType.getCreateDate() == null)) {
			if (serviceContext == null) {
				verificationType.setCreateDate(now);
			}
			else {
				verificationType.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!verificationTypeModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				verificationType.setModifiedDate(now);
			}
			else {
				verificationType.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(verificationType);
			}
			else {
				verificationType = (VerificationType)session.merge(
					verificationType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			VerificationTypeImpl.class, verificationType, false, true);

		if (isNew) {
			verificationType.setNew(false);
		}

		verificationType.resetOriginalValues();

		return verificationType;
	}

	/**
	 * Returns the verification type with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the verification type
	 * @return the verification type
	 * @throws NoSuchVerificationTypeException if a verification type with the primary key could not be found
	 */
	@Override
	public VerificationType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVerificationTypeException {

		VerificationType verificationType = fetchByPrimaryKey(primaryKey);

		if (verificationType == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVerificationTypeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return verificationType;
	}

	/**
	 * Returns the verification type with the primary key or throws a <code>NoSuchVerificationTypeException</code> if it could not be found.
	 *
	 * @param verificationTypeId the primary key of the verification type
	 * @return the verification type
	 * @throws NoSuchVerificationTypeException if a verification type with the primary key could not be found
	 */
	@Override
	public VerificationType findByPrimaryKey(long verificationTypeId)
		throws NoSuchVerificationTypeException {

		return findByPrimaryKey((Serializable)verificationTypeId);
	}

	/**
	 * Returns the verification type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param verificationTypeId the primary key of the verification type
	 * @return the verification type, or <code>null</code> if a verification type with the primary key could not be found
	 */
	@Override
	public VerificationType fetchByPrimaryKey(long verificationTypeId) {
		return fetchByPrimaryKey((Serializable)verificationTypeId);
	}

	/**
	 * Returns all the verification types.
	 *
	 * @return the verification types
	 */
	@Override
	public List<VerificationType> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the verification types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerificationTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of verification types
	 * @param end the upper bound of the range of verification types (not inclusive)
	 * @return the range of verification types
	 */
	@Override
	public List<VerificationType> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the verification types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerificationTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of verification types
	 * @param end the upper bound of the range of verification types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of verification types
	 */
	@Override
	public List<VerificationType> findAll(
		int start, int end,
		OrderByComparator<VerificationType> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the verification types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerificationTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of verification types
	 * @param end the upper bound of the range of verification types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of verification types
	 */
	@Override
	public List<VerificationType> findAll(
		int start, int end,
		OrderByComparator<VerificationType> orderByComparator,
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

		List<VerificationType> list = null;

		if (useFinderCache) {
			list = (List<VerificationType>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_VERIFICATIONTYPE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_VERIFICATIONTYPE;

				sql = sql.concat(VerificationTypeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<VerificationType>)QueryUtil.list(
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
	 * Removes all the verification types from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (VerificationType verificationType : findAll()) {
			remove(verificationType);
		}
	}

	/**
	 * Returns the number of verification types.
	 *
	 * @return the number of verification types
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_VERIFICATIONTYPE);

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
		return "verificationTypeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_VERIFICATIONTYPE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return VerificationTypeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the verification type persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new VerificationTypeModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", VerificationType.class.getName()));

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
		entityCache.removeCache(VerificationTypeImpl.class.getName());

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

	private static final String _SQL_SELECT_VERIFICATIONTYPE =
		"SELECT verificationType FROM VerificationType verificationType";

	private static final String _SQL_COUNT_VERIFICATIONTYPE =
		"SELECT COUNT(verificationType) FROM VerificationType verificationType";

	private static final String _ORDER_BY_ENTITY_ALIAS = "verificationType.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No VerificationType exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		VerificationTypePersistenceImpl.class);

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

	private static class VerificationTypeModelArgumentsResolver
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

			VerificationTypeModelImpl verificationTypeModelImpl =
				(VerificationTypeModelImpl)baseModel;

			long columnBitmask = verificationTypeModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					verificationTypeModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						verificationTypeModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					verificationTypeModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			VerificationTypeModelImpl verificationTypeModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						verificationTypeModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = verificationTypeModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}