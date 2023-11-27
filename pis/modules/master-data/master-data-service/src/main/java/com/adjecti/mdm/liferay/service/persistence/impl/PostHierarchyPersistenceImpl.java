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

import com.adjecti.mdm.liferay.exception.NoSuchPostHierarchyException;
import com.adjecti.mdm.liferay.model.PostHierarchy;
import com.adjecti.mdm.liferay.model.impl.PostHierarchyImpl;
import com.adjecti.mdm.liferay.model.impl.PostHierarchyModelImpl;
import com.adjecti.mdm.liferay.service.persistence.PostHierarchyPersistence;
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
 * The persistence implementation for the post hierarchy service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PostHierarchyPersistence.class)
public class PostHierarchyPersistenceImpl
	extends BasePersistenceImpl<PostHierarchy>
	implements PostHierarchyPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PostHierarchyUtil</code> to access the post hierarchy persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PostHierarchyImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public PostHierarchyPersistenceImpl() {
		setModelClass(PostHierarchy.class);

		setModelImplClass(PostHierarchyImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the post hierarchy in the entity cache if it is enabled.
	 *
	 * @param postHierarchy the post hierarchy
	 */
	@Override
	public void cacheResult(PostHierarchy postHierarchy) {
		entityCache.putResult(
			PostHierarchyImpl.class, postHierarchy.getPrimaryKey(),
			postHierarchy);
	}

	/**
	 * Caches the post hierarchies in the entity cache if it is enabled.
	 *
	 * @param postHierarchies the post hierarchies
	 */
	@Override
	public void cacheResult(List<PostHierarchy> postHierarchies) {
		for (PostHierarchy postHierarchy : postHierarchies) {
			if (entityCache.getResult(
					PostHierarchyImpl.class, postHierarchy.getPrimaryKey()) ==
						null) {

				cacheResult(postHierarchy);
			}
		}
	}

	/**
	 * Clears the cache for all post hierarchies.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PostHierarchyImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the post hierarchy.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PostHierarchy postHierarchy) {
		entityCache.removeResult(PostHierarchyImpl.class, postHierarchy);
	}

	@Override
	public void clearCache(List<PostHierarchy> postHierarchies) {
		for (PostHierarchy postHierarchy : postHierarchies) {
			entityCache.removeResult(PostHierarchyImpl.class, postHierarchy);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PostHierarchyImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new post hierarchy with the primary key. Does not add the post hierarchy to the database.
	 *
	 * @param postHierarchyId the primary key for the new post hierarchy
	 * @return the new post hierarchy
	 */
	@Override
	public PostHierarchy create(long postHierarchyId) {
		PostHierarchy postHierarchy = new PostHierarchyImpl();

		postHierarchy.setNew(true);
		postHierarchy.setPrimaryKey(postHierarchyId);

		postHierarchy.setCompanyId(CompanyThreadLocal.getCompanyId());

		return postHierarchy;
	}

	/**
	 * Removes the post hierarchy with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param postHierarchyId the primary key of the post hierarchy
	 * @return the post hierarchy that was removed
	 * @throws NoSuchPostHierarchyException if a post hierarchy with the primary key could not be found
	 */
	@Override
	public PostHierarchy remove(long postHierarchyId)
		throws NoSuchPostHierarchyException {

		return remove((Serializable)postHierarchyId);
	}

	/**
	 * Removes the post hierarchy with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the post hierarchy
	 * @return the post hierarchy that was removed
	 * @throws NoSuchPostHierarchyException if a post hierarchy with the primary key could not be found
	 */
	@Override
	public PostHierarchy remove(Serializable primaryKey)
		throws NoSuchPostHierarchyException {

		Session session = null;

		try {
			session = openSession();

			PostHierarchy postHierarchy = (PostHierarchy)session.get(
				PostHierarchyImpl.class, primaryKey);

			if (postHierarchy == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPostHierarchyException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(postHierarchy);
		}
		catch (NoSuchPostHierarchyException noSuchEntityException) {
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
	protected PostHierarchy removeImpl(PostHierarchy postHierarchy) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(postHierarchy)) {
				postHierarchy = (PostHierarchy)session.get(
					PostHierarchyImpl.class, postHierarchy.getPrimaryKeyObj());
			}

			if (postHierarchy != null) {
				session.delete(postHierarchy);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (postHierarchy != null) {
			clearCache(postHierarchy);
		}

		return postHierarchy;
	}

	@Override
	public PostHierarchy updateImpl(PostHierarchy postHierarchy) {
		boolean isNew = postHierarchy.isNew();

		if (!(postHierarchy instanceof PostHierarchyModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(postHierarchy.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					postHierarchy);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in postHierarchy proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PostHierarchy implementation " +
					postHierarchy.getClass());
		}

		PostHierarchyModelImpl postHierarchyModelImpl =
			(PostHierarchyModelImpl)postHierarchy;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (postHierarchy.getCreateDate() == null)) {
			if (serviceContext == null) {
				postHierarchy.setCreateDate(now);
			}
			else {
				postHierarchy.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!postHierarchyModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				postHierarchy.setModifiedDate(now);
			}
			else {
				postHierarchy.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(postHierarchy);
			}
			else {
				postHierarchy = (PostHierarchy)session.merge(postHierarchy);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PostHierarchyImpl.class, postHierarchy, false, true);

		if (isNew) {
			postHierarchy.setNew(false);
		}

		postHierarchy.resetOriginalValues();

		return postHierarchy;
	}

	/**
	 * Returns the post hierarchy with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the post hierarchy
	 * @return the post hierarchy
	 * @throws NoSuchPostHierarchyException if a post hierarchy with the primary key could not be found
	 */
	@Override
	public PostHierarchy findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPostHierarchyException {

		PostHierarchy postHierarchy = fetchByPrimaryKey(primaryKey);

		if (postHierarchy == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPostHierarchyException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return postHierarchy;
	}

	/**
	 * Returns the post hierarchy with the primary key or throws a <code>NoSuchPostHierarchyException</code> if it could not be found.
	 *
	 * @param postHierarchyId the primary key of the post hierarchy
	 * @return the post hierarchy
	 * @throws NoSuchPostHierarchyException if a post hierarchy with the primary key could not be found
	 */
	@Override
	public PostHierarchy findByPrimaryKey(long postHierarchyId)
		throws NoSuchPostHierarchyException {

		return findByPrimaryKey((Serializable)postHierarchyId);
	}

	/**
	 * Returns the post hierarchy with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param postHierarchyId the primary key of the post hierarchy
	 * @return the post hierarchy, or <code>null</code> if a post hierarchy with the primary key could not be found
	 */
	@Override
	public PostHierarchy fetchByPrimaryKey(long postHierarchyId) {
		return fetchByPrimaryKey((Serializable)postHierarchyId);
	}

	/**
	 * Returns all the post hierarchies.
	 *
	 * @return the post hierarchies
	 */
	@Override
	public List<PostHierarchy> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the post hierarchies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PostHierarchyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of post hierarchies
	 * @param end the upper bound of the range of post hierarchies (not inclusive)
	 * @return the range of post hierarchies
	 */
	@Override
	public List<PostHierarchy> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the post hierarchies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PostHierarchyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of post hierarchies
	 * @param end the upper bound of the range of post hierarchies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of post hierarchies
	 */
	@Override
	public List<PostHierarchy> findAll(
		int start, int end,
		OrderByComparator<PostHierarchy> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the post hierarchies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PostHierarchyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of post hierarchies
	 * @param end the upper bound of the range of post hierarchies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of post hierarchies
	 */
	@Override
	public List<PostHierarchy> findAll(
		int start, int end, OrderByComparator<PostHierarchy> orderByComparator,
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

		List<PostHierarchy> list = null;

		if (useFinderCache) {
			list = (List<PostHierarchy>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_POSTHIERARCHY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_POSTHIERARCHY;

				sql = sql.concat(PostHierarchyModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PostHierarchy>)QueryUtil.list(
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
	 * Removes all the post hierarchies from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PostHierarchy postHierarchy : findAll()) {
			remove(postHierarchy);
		}
	}

	/**
	 * Returns the number of post hierarchies.
	 *
	 * @return the number of post hierarchies
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_POSTHIERARCHY);

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
		return "postHierarchyId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_POSTHIERARCHY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PostHierarchyModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the post hierarchy persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new PostHierarchyModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", PostHierarchy.class.getName()));

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
		entityCache.removeCache(PostHierarchyImpl.class.getName());

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

	private static final String _SQL_SELECT_POSTHIERARCHY =
		"SELECT postHierarchy FROM PostHierarchy postHierarchy";

	private static final String _SQL_COUNT_POSTHIERARCHY =
		"SELECT COUNT(postHierarchy) FROM PostHierarchy postHierarchy";

	private static final String _ORDER_BY_ENTITY_ALIAS = "postHierarchy.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PostHierarchy exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		PostHierarchyPersistenceImpl.class);

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

	private static class PostHierarchyModelArgumentsResolver
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

			PostHierarchyModelImpl postHierarchyModelImpl =
				(PostHierarchyModelImpl)baseModel;

			long columnBitmask = postHierarchyModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(postHierarchyModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						postHierarchyModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(postHierarchyModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			PostHierarchyModelImpl postHierarchyModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						postHierarchyModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = postHierarchyModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}