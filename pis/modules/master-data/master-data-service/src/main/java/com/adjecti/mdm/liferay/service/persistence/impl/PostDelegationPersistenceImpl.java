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

import com.adjecti.mdm.liferay.exception.NoSuchPostDelegationException;
import com.adjecti.mdm.liferay.model.PostDelegation;
import com.adjecti.mdm.liferay.model.impl.PostDelegationImpl;
import com.adjecti.mdm.liferay.model.impl.PostDelegationModelImpl;
import com.adjecti.mdm.liferay.service.persistence.PostDelegationPersistence;
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
 * The persistence implementation for the post delegation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PostDelegationPersistence.class)
public class PostDelegationPersistenceImpl
	extends BasePersistenceImpl<PostDelegation>
	implements PostDelegationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PostDelegationUtil</code> to access the post delegation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PostDelegationImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public PostDelegationPersistenceImpl() {
		setModelClass(PostDelegation.class);

		setModelImplClass(PostDelegationImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the post delegation in the entity cache if it is enabled.
	 *
	 * @param postDelegation the post delegation
	 */
	@Override
	public void cacheResult(PostDelegation postDelegation) {
		entityCache.putResult(
			PostDelegationImpl.class, postDelegation.getPrimaryKey(),
			postDelegation);
	}

	/**
	 * Caches the post delegations in the entity cache if it is enabled.
	 *
	 * @param postDelegations the post delegations
	 */
	@Override
	public void cacheResult(List<PostDelegation> postDelegations) {
		for (PostDelegation postDelegation : postDelegations) {
			if (entityCache.getResult(
					PostDelegationImpl.class, postDelegation.getPrimaryKey()) ==
						null) {

				cacheResult(postDelegation);
			}
		}
	}

	/**
	 * Clears the cache for all post delegations.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PostDelegationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the post delegation.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PostDelegation postDelegation) {
		entityCache.removeResult(PostDelegationImpl.class, postDelegation);
	}

	@Override
	public void clearCache(List<PostDelegation> postDelegations) {
		for (PostDelegation postDelegation : postDelegations) {
			entityCache.removeResult(PostDelegationImpl.class, postDelegation);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PostDelegationImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new post delegation with the primary key. Does not add the post delegation to the database.
	 *
	 * @param postDelegationId the primary key for the new post delegation
	 * @return the new post delegation
	 */
	@Override
	public PostDelegation create(long postDelegationId) {
		PostDelegation postDelegation = new PostDelegationImpl();

		postDelegation.setNew(true);
		postDelegation.setPrimaryKey(postDelegationId);

		postDelegation.setCompanyId(CompanyThreadLocal.getCompanyId());

		return postDelegation;
	}

	/**
	 * Removes the post delegation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param postDelegationId the primary key of the post delegation
	 * @return the post delegation that was removed
	 * @throws NoSuchPostDelegationException if a post delegation with the primary key could not be found
	 */
	@Override
	public PostDelegation remove(long postDelegationId)
		throws NoSuchPostDelegationException {

		return remove((Serializable)postDelegationId);
	}

	/**
	 * Removes the post delegation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the post delegation
	 * @return the post delegation that was removed
	 * @throws NoSuchPostDelegationException if a post delegation with the primary key could not be found
	 */
	@Override
	public PostDelegation remove(Serializable primaryKey)
		throws NoSuchPostDelegationException {

		Session session = null;

		try {
			session = openSession();

			PostDelegation postDelegation = (PostDelegation)session.get(
				PostDelegationImpl.class, primaryKey);

			if (postDelegation == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPostDelegationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(postDelegation);
		}
		catch (NoSuchPostDelegationException noSuchEntityException) {
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
	protected PostDelegation removeImpl(PostDelegation postDelegation) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(postDelegation)) {
				postDelegation = (PostDelegation)session.get(
					PostDelegationImpl.class,
					postDelegation.getPrimaryKeyObj());
			}

			if (postDelegation != null) {
				session.delete(postDelegation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (postDelegation != null) {
			clearCache(postDelegation);
		}

		return postDelegation;
	}

	@Override
	public PostDelegation updateImpl(PostDelegation postDelegation) {
		boolean isNew = postDelegation.isNew();

		if (!(postDelegation instanceof PostDelegationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(postDelegation.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					postDelegation);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in postDelegation proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PostDelegation implementation " +
					postDelegation.getClass());
		}

		PostDelegationModelImpl postDelegationModelImpl =
			(PostDelegationModelImpl)postDelegation;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (postDelegation.getCreateDate() == null)) {
			if (serviceContext == null) {
				postDelegation.setCreateDate(now);
			}
			else {
				postDelegation.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!postDelegationModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				postDelegation.setModifiedDate(now);
			}
			else {
				postDelegation.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(postDelegation);
			}
			else {
				postDelegation = (PostDelegation)session.merge(postDelegation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PostDelegationImpl.class, postDelegation, false, true);

		if (isNew) {
			postDelegation.setNew(false);
		}

		postDelegation.resetOriginalValues();

		return postDelegation;
	}

	/**
	 * Returns the post delegation with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the post delegation
	 * @return the post delegation
	 * @throws NoSuchPostDelegationException if a post delegation with the primary key could not be found
	 */
	@Override
	public PostDelegation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPostDelegationException {

		PostDelegation postDelegation = fetchByPrimaryKey(primaryKey);

		if (postDelegation == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPostDelegationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return postDelegation;
	}

	/**
	 * Returns the post delegation with the primary key or throws a <code>NoSuchPostDelegationException</code> if it could not be found.
	 *
	 * @param postDelegationId the primary key of the post delegation
	 * @return the post delegation
	 * @throws NoSuchPostDelegationException if a post delegation with the primary key could not be found
	 */
	@Override
	public PostDelegation findByPrimaryKey(long postDelegationId)
		throws NoSuchPostDelegationException {

		return findByPrimaryKey((Serializable)postDelegationId);
	}

	/**
	 * Returns the post delegation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param postDelegationId the primary key of the post delegation
	 * @return the post delegation, or <code>null</code> if a post delegation with the primary key could not be found
	 */
	@Override
	public PostDelegation fetchByPrimaryKey(long postDelegationId) {
		return fetchByPrimaryKey((Serializable)postDelegationId);
	}

	/**
	 * Returns all the post delegations.
	 *
	 * @return the post delegations
	 */
	@Override
	public List<PostDelegation> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the post delegations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PostDelegationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of post delegations
	 * @param end the upper bound of the range of post delegations (not inclusive)
	 * @return the range of post delegations
	 */
	@Override
	public List<PostDelegation> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the post delegations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PostDelegationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of post delegations
	 * @param end the upper bound of the range of post delegations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of post delegations
	 */
	@Override
	public List<PostDelegation> findAll(
		int start, int end,
		OrderByComparator<PostDelegation> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the post delegations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PostDelegationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of post delegations
	 * @param end the upper bound of the range of post delegations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of post delegations
	 */
	@Override
	public List<PostDelegation> findAll(
		int start, int end, OrderByComparator<PostDelegation> orderByComparator,
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

		List<PostDelegation> list = null;

		if (useFinderCache) {
			list = (List<PostDelegation>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_POSTDELEGATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_POSTDELEGATION;

				sql = sql.concat(PostDelegationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PostDelegation>)QueryUtil.list(
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
	 * Removes all the post delegations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PostDelegation postDelegation : findAll()) {
			remove(postDelegation);
		}
	}

	/**
	 * Returns the number of post delegations.
	 *
	 * @return the number of post delegations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_POSTDELEGATION);

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
		return "postDelegationId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_POSTDELEGATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PostDelegationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the post delegation persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new PostDelegationModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", PostDelegation.class.getName()));

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
		entityCache.removeCache(PostDelegationImpl.class.getName());

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

	private static final String _SQL_SELECT_POSTDELEGATION =
		"SELECT postDelegation FROM PostDelegation postDelegation";

	private static final String _SQL_COUNT_POSTDELEGATION =
		"SELECT COUNT(postDelegation) FROM PostDelegation postDelegation";

	private static final String _ORDER_BY_ENTITY_ALIAS = "postDelegation.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PostDelegation exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		PostDelegationPersistenceImpl.class);

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

	private static class PostDelegationModelArgumentsResolver
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

			PostDelegationModelImpl postDelegationModelImpl =
				(PostDelegationModelImpl)baseModel;

			long columnBitmask = postDelegationModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					postDelegationModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						postDelegationModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					postDelegationModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			PostDelegationModelImpl postDelegationModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						postDelegationModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = postDelegationModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}