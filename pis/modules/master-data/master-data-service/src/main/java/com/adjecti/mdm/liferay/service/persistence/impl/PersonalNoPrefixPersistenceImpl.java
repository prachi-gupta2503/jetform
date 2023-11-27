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

import com.adjecti.mdm.liferay.exception.NoSuchPersonalNoPrefixException;
import com.adjecti.mdm.liferay.model.PersonalNoPrefix;
import com.adjecti.mdm.liferay.model.impl.PersonalNoPrefixImpl;
import com.adjecti.mdm.liferay.model.impl.PersonalNoPrefixModelImpl;
import com.adjecti.mdm.liferay.service.persistence.PersonalNoPrefixPersistence;
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
 * The persistence implementation for the personal no prefix service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PersonalNoPrefixPersistence.class)
public class PersonalNoPrefixPersistenceImpl
	extends BasePersistenceImpl<PersonalNoPrefix>
	implements PersonalNoPrefixPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PersonalNoPrefixUtil</code> to access the personal no prefix persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PersonalNoPrefixImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public PersonalNoPrefixPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(PersonalNoPrefix.class);

		setModelImplClass(PersonalNoPrefixImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the personal no prefix in the entity cache if it is enabled.
	 *
	 * @param personalNoPrefix the personal no prefix
	 */
	@Override
	public void cacheResult(PersonalNoPrefix personalNoPrefix) {
		entityCache.putResult(
			PersonalNoPrefixImpl.class, personalNoPrefix.getPrimaryKey(),
			personalNoPrefix);
	}

	/**
	 * Caches the personal no prefixes in the entity cache if it is enabled.
	 *
	 * @param personalNoPrefixes the personal no prefixes
	 */
	@Override
	public void cacheResult(List<PersonalNoPrefix> personalNoPrefixes) {
		for (PersonalNoPrefix personalNoPrefix : personalNoPrefixes) {
			if (entityCache.getResult(
					PersonalNoPrefixImpl.class,
					personalNoPrefix.getPrimaryKey()) == null) {

				cacheResult(personalNoPrefix);
			}
		}
	}

	/**
	 * Clears the cache for all personal no prefixes.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PersonalNoPrefixImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the personal no prefix.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PersonalNoPrefix personalNoPrefix) {
		entityCache.removeResult(PersonalNoPrefixImpl.class, personalNoPrefix);
	}

	@Override
	public void clearCache(List<PersonalNoPrefix> personalNoPrefixes) {
		for (PersonalNoPrefix personalNoPrefix : personalNoPrefixes) {
			entityCache.removeResult(
				PersonalNoPrefixImpl.class, personalNoPrefix);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PersonalNoPrefixImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new personal no prefix with the primary key. Does not add the personal no prefix to the database.
	 *
	 * @param personalNoPrefixId the primary key for the new personal no prefix
	 * @return the new personal no prefix
	 */
	@Override
	public PersonalNoPrefix create(long personalNoPrefixId) {
		PersonalNoPrefix personalNoPrefix = new PersonalNoPrefixImpl();

		personalNoPrefix.setNew(true);
		personalNoPrefix.setPrimaryKey(personalNoPrefixId);

		personalNoPrefix.setCompanyId(CompanyThreadLocal.getCompanyId());

		return personalNoPrefix;
	}

	/**
	 * Removes the personal no prefix with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param personalNoPrefixId the primary key of the personal no prefix
	 * @return the personal no prefix that was removed
	 * @throws NoSuchPersonalNoPrefixException if a personal no prefix with the primary key could not be found
	 */
	@Override
	public PersonalNoPrefix remove(long personalNoPrefixId)
		throws NoSuchPersonalNoPrefixException {

		return remove((Serializable)personalNoPrefixId);
	}

	/**
	 * Removes the personal no prefix with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the personal no prefix
	 * @return the personal no prefix that was removed
	 * @throws NoSuchPersonalNoPrefixException if a personal no prefix with the primary key could not be found
	 */
	@Override
	public PersonalNoPrefix remove(Serializable primaryKey)
		throws NoSuchPersonalNoPrefixException {

		Session session = null;

		try {
			session = openSession();

			PersonalNoPrefix personalNoPrefix = (PersonalNoPrefix)session.get(
				PersonalNoPrefixImpl.class, primaryKey);

			if (personalNoPrefix == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPersonalNoPrefixException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(personalNoPrefix);
		}
		catch (NoSuchPersonalNoPrefixException noSuchEntityException) {
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
	protected PersonalNoPrefix removeImpl(PersonalNoPrefix personalNoPrefix) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(personalNoPrefix)) {
				personalNoPrefix = (PersonalNoPrefix)session.get(
					PersonalNoPrefixImpl.class,
					personalNoPrefix.getPrimaryKeyObj());
			}

			if (personalNoPrefix != null) {
				session.delete(personalNoPrefix);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (personalNoPrefix != null) {
			clearCache(personalNoPrefix);
		}

		return personalNoPrefix;
	}

	@Override
	public PersonalNoPrefix updateImpl(PersonalNoPrefix personalNoPrefix) {
		boolean isNew = personalNoPrefix.isNew();

		if (!(personalNoPrefix instanceof PersonalNoPrefixModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(personalNoPrefix.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					personalNoPrefix);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in personalNoPrefix proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PersonalNoPrefix implementation " +
					personalNoPrefix.getClass());
		}

		PersonalNoPrefixModelImpl personalNoPrefixModelImpl =
			(PersonalNoPrefixModelImpl)personalNoPrefix;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (personalNoPrefix.getCreateDate() == null)) {
			if (serviceContext == null) {
				personalNoPrefix.setCreateDate(now);
			}
			else {
				personalNoPrefix.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!personalNoPrefixModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				personalNoPrefix.setModifiedDate(now);
			}
			else {
				personalNoPrefix.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(personalNoPrefix);
			}
			else {
				personalNoPrefix = (PersonalNoPrefix)session.merge(
					personalNoPrefix);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PersonalNoPrefixImpl.class, personalNoPrefix, false, true);

		if (isNew) {
			personalNoPrefix.setNew(false);
		}

		personalNoPrefix.resetOriginalValues();

		return personalNoPrefix;
	}

	/**
	 * Returns the personal no prefix with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the personal no prefix
	 * @return the personal no prefix
	 * @throws NoSuchPersonalNoPrefixException if a personal no prefix with the primary key could not be found
	 */
	@Override
	public PersonalNoPrefix findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPersonalNoPrefixException {

		PersonalNoPrefix personalNoPrefix = fetchByPrimaryKey(primaryKey);

		if (personalNoPrefix == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPersonalNoPrefixException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return personalNoPrefix;
	}

	/**
	 * Returns the personal no prefix with the primary key or throws a <code>NoSuchPersonalNoPrefixException</code> if it could not be found.
	 *
	 * @param personalNoPrefixId the primary key of the personal no prefix
	 * @return the personal no prefix
	 * @throws NoSuchPersonalNoPrefixException if a personal no prefix with the primary key could not be found
	 */
	@Override
	public PersonalNoPrefix findByPrimaryKey(long personalNoPrefixId)
		throws NoSuchPersonalNoPrefixException {

		return findByPrimaryKey((Serializable)personalNoPrefixId);
	}

	/**
	 * Returns the personal no prefix with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param personalNoPrefixId the primary key of the personal no prefix
	 * @return the personal no prefix, or <code>null</code> if a personal no prefix with the primary key could not be found
	 */
	@Override
	public PersonalNoPrefix fetchByPrimaryKey(long personalNoPrefixId) {
		return fetchByPrimaryKey((Serializable)personalNoPrefixId);
	}

	/**
	 * Returns all the personal no prefixes.
	 *
	 * @return the personal no prefixes
	 */
	@Override
	public List<PersonalNoPrefix> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the personal no prefixes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonalNoPrefixModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of personal no prefixes
	 * @param end the upper bound of the range of personal no prefixes (not inclusive)
	 * @return the range of personal no prefixes
	 */
	@Override
	public List<PersonalNoPrefix> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the personal no prefixes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonalNoPrefixModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of personal no prefixes
	 * @param end the upper bound of the range of personal no prefixes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of personal no prefixes
	 */
	@Override
	public List<PersonalNoPrefix> findAll(
		int start, int end,
		OrderByComparator<PersonalNoPrefix> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the personal no prefixes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonalNoPrefixModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of personal no prefixes
	 * @param end the upper bound of the range of personal no prefixes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of personal no prefixes
	 */
	@Override
	public List<PersonalNoPrefix> findAll(
		int start, int end,
		OrderByComparator<PersonalNoPrefix> orderByComparator,
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

		List<PersonalNoPrefix> list = null;

		if (useFinderCache) {
			list = (List<PersonalNoPrefix>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PERSONALNOPREFIX);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PERSONALNOPREFIX;

				sql = sql.concat(PersonalNoPrefixModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PersonalNoPrefix>)QueryUtil.list(
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
	 * Removes all the personal no prefixes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PersonalNoPrefix personalNoPrefix : findAll()) {
			remove(personalNoPrefix);
		}
	}

	/**
	 * Returns the number of personal no prefixes.
	 *
	 * @return the number of personal no prefixes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PERSONALNOPREFIX);

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
		return "personalNoPrefixId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PERSONALNOPREFIX;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PersonalNoPrefixModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the personal no prefix persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new PersonalNoPrefixModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", PersonalNoPrefix.class.getName()));

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
		entityCache.removeCache(PersonalNoPrefixImpl.class.getName());

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

	private static final String _SQL_SELECT_PERSONALNOPREFIX =
		"SELECT personalNoPrefix FROM PersonalNoPrefix personalNoPrefix";

	private static final String _SQL_COUNT_PERSONALNOPREFIX =
		"SELECT COUNT(personalNoPrefix) FROM PersonalNoPrefix personalNoPrefix";

	private static final String _ORDER_BY_ENTITY_ALIAS = "personalNoPrefix.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PersonalNoPrefix exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		PersonalNoPrefixPersistenceImpl.class);

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

	private static class PersonalNoPrefixModelArgumentsResolver
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

			PersonalNoPrefixModelImpl personalNoPrefixModelImpl =
				(PersonalNoPrefixModelImpl)baseModel;

			long columnBitmask = personalNoPrefixModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					personalNoPrefixModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						personalNoPrefixModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					personalNoPrefixModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			PersonalNoPrefixModelImpl personalNoPrefixModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						personalNoPrefixModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = personalNoPrefixModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}