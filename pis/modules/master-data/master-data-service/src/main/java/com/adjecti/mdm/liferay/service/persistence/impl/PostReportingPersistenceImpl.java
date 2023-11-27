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

import com.adjecti.mdm.liferay.exception.NoSuchPostReportingException;
import com.adjecti.mdm.liferay.model.PostReporting;
import com.adjecti.mdm.liferay.model.impl.PostReportingImpl;
import com.adjecti.mdm.liferay.model.impl.PostReportingModelImpl;
import com.adjecti.mdm.liferay.service.persistence.PostReportingPersistence;
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
 * The persistence implementation for the post reporting service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PostReportingPersistence.class)
public class PostReportingPersistenceImpl
	extends BasePersistenceImpl<PostReporting>
	implements PostReportingPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PostReportingUtil</code> to access the post reporting persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PostReportingImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public PostReportingPersistenceImpl() {
		setModelClass(PostReporting.class);

		setModelImplClass(PostReportingImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the post reporting in the entity cache if it is enabled.
	 *
	 * @param postReporting the post reporting
	 */
	@Override
	public void cacheResult(PostReporting postReporting) {
		entityCache.putResult(
			PostReportingImpl.class, postReporting.getPrimaryKey(),
			postReporting);
	}

	/**
	 * Caches the post reportings in the entity cache if it is enabled.
	 *
	 * @param postReportings the post reportings
	 */
	@Override
	public void cacheResult(List<PostReporting> postReportings) {
		for (PostReporting postReporting : postReportings) {
			if (entityCache.getResult(
					PostReportingImpl.class, postReporting.getPrimaryKey()) ==
						null) {

				cacheResult(postReporting);
			}
		}
	}

	/**
	 * Clears the cache for all post reportings.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PostReportingImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the post reporting.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PostReporting postReporting) {
		entityCache.removeResult(PostReportingImpl.class, postReporting);
	}

	@Override
	public void clearCache(List<PostReporting> postReportings) {
		for (PostReporting postReporting : postReportings) {
			entityCache.removeResult(PostReportingImpl.class, postReporting);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PostReportingImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new post reporting with the primary key. Does not add the post reporting to the database.
	 *
	 * @param postReportingId the primary key for the new post reporting
	 * @return the new post reporting
	 */
	@Override
	public PostReporting create(long postReportingId) {
		PostReporting postReporting = new PostReportingImpl();

		postReporting.setNew(true);
		postReporting.setPrimaryKey(postReportingId);

		postReporting.setCompanyId(CompanyThreadLocal.getCompanyId());

		return postReporting;
	}

	/**
	 * Removes the post reporting with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param postReportingId the primary key of the post reporting
	 * @return the post reporting that was removed
	 * @throws NoSuchPostReportingException if a post reporting with the primary key could not be found
	 */
	@Override
	public PostReporting remove(long postReportingId)
		throws NoSuchPostReportingException {

		return remove((Serializable)postReportingId);
	}

	/**
	 * Removes the post reporting with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the post reporting
	 * @return the post reporting that was removed
	 * @throws NoSuchPostReportingException if a post reporting with the primary key could not be found
	 */
	@Override
	public PostReporting remove(Serializable primaryKey)
		throws NoSuchPostReportingException {

		Session session = null;

		try {
			session = openSession();

			PostReporting postReporting = (PostReporting)session.get(
				PostReportingImpl.class, primaryKey);

			if (postReporting == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPostReportingException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(postReporting);
		}
		catch (NoSuchPostReportingException noSuchEntityException) {
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
	protected PostReporting removeImpl(PostReporting postReporting) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(postReporting)) {
				postReporting = (PostReporting)session.get(
					PostReportingImpl.class, postReporting.getPrimaryKeyObj());
			}

			if (postReporting != null) {
				session.delete(postReporting);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (postReporting != null) {
			clearCache(postReporting);
		}

		return postReporting;
	}

	@Override
	public PostReporting updateImpl(PostReporting postReporting) {
		boolean isNew = postReporting.isNew();

		if (!(postReporting instanceof PostReportingModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(postReporting.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					postReporting);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in postReporting proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PostReporting implementation " +
					postReporting.getClass());
		}

		PostReportingModelImpl postReportingModelImpl =
			(PostReportingModelImpl)postReporting;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (postReporting.getCreateDate() == null)) {
			if (serviceContext == null) {
				postReporting.setCreateDate(now);
			}
			else {
				postReporting.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!postReportingModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				postReporting.setModifiedDate(now);
			}
			else {
				postReporting.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(postReporting);
			}
			else {
				postReporting = (PostReporting)session.merge(postReporting);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PostReportingImpl.class, postReporting, false, true);

		if (isNew) {
			postReporting.setNew(false);
		}

		postReporting.resetOriginalValues();

		return postReporting;
	}

	/**
	 * Returns the post reporting with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the post reporting
	 * @return the post reporting
	 * @throws NoSuchPostReportingException if a post reporting with the primary key could not be found
	 */
	@Override
	public PostReporting findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPostReportingException {

		PostReporting postReporting = fetchByPrimaryKey(primaryKey);

		if (postReporting == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPostReportingException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return postReporting;
	}

	/**
	 * Returns the post reporting with the primary key or throws a <code>NoSuchPostReportingException</code> if it could not be found.
	 *
	 * @param postReportingId the primary key of the post reporting
	 * @return the post reporting
	 * @throws NoSuchPostReportingException if a post reporting with the primary key could not be found
	 */
	@Override
	public PostReporting findByPrimaryKey(long postReportingId)
		throws NoSuchPostReportingException {

		return findByPrimaryKey((Serializable)postReportingId);
	}

	/**
	 * Returns the post reporting with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param postReportingId the primary key of the post reporting
	 * @return the post reporting, or <code>null</code> if a post reporting with the primary key could not be found
	 */
	@Override
	public PostReporting fetchByPrimaryKey(long postReportingId) {
		return fetchByPrimaryKey((Serializable)postReportingId);
	}

	/**
	 * Returns all the post reportings.
	 *
	 * @return the post reportings
	 */
	@Override
	public List<PostReporting> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the post reportings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PostReportingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of post reportings
	 * @param end the upper bound of the range of post reportings (not inclusive)
	 * @return the range of post reportings
	 */
	@Override
	public List<PostReporting> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the post reportings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PostReportingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of post reportings
	 * @param end the upper bound of the range of post reportings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of post reportings
	 */
	@Override
	public List<PostReporting> findAll(
		int start, int end,
		OrderByComparator<PostReporting> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the post reportings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PostReportingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of post reportings
	 * @param end the upper bound of the range of post reportings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of post reportings
	 */
	@Override
	public List<PostReporting> findAll(
		int start, int end, OrderByComparator<PostReporting> orderByComparator,
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

		List<PostReporting> list = null;

		if (useFinderCache) {
			list = (List<PostReporting>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_POSTREPORTING);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_POSTREPORTING;

				sql = sql.concat(PostReportingModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PostReporting>)QueryUtil.list(
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
	 * Removes all the post reportings from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PostReporting postReporting : findAll()) {
			remove(postReporting);
		}
	}

	/**
	 * Returns the number of post reportings.
	 *
	 * @return the number of post reportings
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_POSTREPORTING);

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
		return "postReportingId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_POSTREPORTING;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PostReportingModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the post reporting persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new PostReportingModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", PostReporting.class.getName()));

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
		entityCache.removeCache(PostReportingImpl.class.getName());

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

	private static final String _SQL_SELECT_POSTREPORTING =
		"SELECT postReporting FROM PostReporting postReporting";

	private static final String _SQL_COUNT_POSTREPORTING =
		"SELECT COUNT(postReporting) FROM PostReporting postReporting";

	private static final String _ORDER_BY_ENTITY_ALIAS = "postReporting.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PostReporting exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		PostReportingPersistenceImpl.class);

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

	private static class PostReportingModelArgumentsResolver
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

			PostReportingModelImpl postReportingModelImpl =
				(PostReportingModelImpl)baseModel;

			long columnBitmask = postReportingModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(postReportingModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						postReportingModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(postReportingModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			PostReportingModelImpl postReportingModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						postReportingModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = postReportingModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}