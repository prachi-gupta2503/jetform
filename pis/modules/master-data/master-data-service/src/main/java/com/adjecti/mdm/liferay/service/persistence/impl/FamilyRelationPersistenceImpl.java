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

import com.adjecti.mdm.liferay.exception.NoSuchFamilyRelationException;
import com.adjecti.mdm.liferay.model.FamilyRelation;
import com.adjecti.mdm.liferay.model.impl.FamilyRelationImpl;
import com.adjecti.mdm.liferay.model.impl.FamilyRelationModelImpl;
import com.adjecti.mdm.liferay.service.persistence.FamilyRelationPersistence;
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
 * The persistence implementation for the family relation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = FamilyRelationPersistence.class)
public class FamilyRelationPersistenceImpl
	extends BasePersistenceImpl<FamilyRelation>
	implements FamilyRelationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FamilyRelationUtil</code> to access the family relation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FamilyRelationImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public FamilyRelationPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("code", "code_");

		setDBColumnNames(dbColumnNames);

		setModelClass(FamilyRelation.class);

		setModelImplClass(FamilyRelationImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the family relation in the entity cache if it is enabled.
	 *
	 * @param familyRelation the family relation
	 */
	@Override
	public void cacheResult(FamilyRelation familyRelation) {
		entityCache.putResult(
			FamilyRelationImpl.class, familyRelation.getPrimaryKey(),
			familyRelation);
	}

	/**
	 * Caches the family relations in the entity cache if it is enabled.
	 *
	 * @param familyRelations the family relations
	 */
	@Override
	public void cacheResult(List<FamilyRelation> familyRelations) {
		for (FamilyRelation familyRelation : familyRelations) {
			if (entityCache.getResult(
					FamilyRelationImpl.class, familyRelation.getPrimaryKey()) ==
						null) {

				cacheResult(familyRelation);
			}
		}
	}

	/**
	 * Clears the cache for all family relations.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FamilyRelationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the family relation.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FamilyRelation familyRelation) {
		entityCache.removeResult(FamilyRelationImpl.class, familyRelation);
	}

	@Override
	public void clearCache(List<FamilyRelation> familyRelations) {
		for (FamilyRelation familyRelation : familyRelations) {
			entityCache.removeResult(FamilyRelationImpl.class, familyRelation);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(FamilyRelationImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new family relation with the primary key. Does not add the family relation to the database.
	 *
	 * @param familyRelationId the primary key for the new family relation
	 * @return the new family relation
	 */
	@Override
	public FamilyRelation create(long familyRelationId) {
		FamilyRelation familyRelation = new FamilyRelationImpl();

		familyRelation.setNew(true);
		familyRelation.setPrimaryKey(familyRelationId);

		familyRelation.setCompanyId(CompanyThreadLocal.getCompanyId());

		return familyRelation;
	}

	/**
	 * Removes the family relation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param familyRelationId the primary key of the family relation
	 * @return the family relation that was removed
	 * @throws NoSuchFamilyRelationException if a family relation with the primary key could not be found
	 */
	@Override
	public FamilyRelation remove(long familyRelationId)
		throws NoSuchFamilyRelationException {

		return remove((Serializable)familyRelationId);
	}

	/**
	 * Removes the family relation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the family relation
	 * @return the family relation that was removed
	 * @throws NoSuchFamilyRelationException if a family relation with the primary key could not be found
	 */
	@Override
	public FamilyRelation remove(Serializable primaryKey)
		throws NoSuchFamilyRelationException {

		Session session = null;

		try {
			session = openSession();

			FamilyRelation familyRelation = (FamilyRelation)session.get(
				FamilyRelationImpl.class, primaryKey);

			if (familyRelation == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFamilyRelationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(familyRelation);
		}
		catch (NoSuchFamilyRelationException noSuchEntityException) {
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
	protected FamilyRelation removeImpl(FamilyRelation familyRelation) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(familyRelation)) {
				familyRelation = (FamilyRelation)session.get(
					FamilyRelationImpl.class,
					familyRelation.getPrimaryKeyObj());
			}

			if (familyRelation != null) {
				session.delete(familyRelation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (familyRelation != null) {
			clearCache(familyRelation);
		}

		return familyRelation;
	}

	@Override
	public FamilyRelation updateImpl(FamilyRelation familyRelation) {
		boolean isNew = familyRelation.isNew();

		if (!(familyRelation instanceof FamilyRelationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(familyRelation.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					familyRelation);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in familyRelation proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom FamilyRelation implementation " +
					familyRelation.getClass());
		}

		FamilyRelationModelImpl familyRelationModelImpl =
			(FamilyRelationModelImpl)familyRelation;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (familyRelation.getCreateDate() == null)) {
			if (serviceContext == null) {
				familyRelation.setCreateDate(now);
			}
			else {
				familyRelation.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!familyRelationModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				familyRelation.setModifiedDate(now);
			}
			else {
				familyRelation.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(familyRelation);
			}
			else {
				familyRelation = (FamilyRelation)session.merge(familyRelation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			FamilyRelationImpl.class, familyRelation, false, true);

		if (isNew) {
			familyRelation.setNew(false);
		}

		familyRelation.resetOriginalValues();

		return familyRelation;
	}

	/**
	 * Returns the family relation with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the family relation
	 * @return the family relation
	 * @throws NoSuchFamilyRelationException if a family relation with the primary key could not be found
	 */
	@Override
	public FamilyRelation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFamilyRelationException {

		FamilyRelation familyRelation = fetchByPrimaryKey(primaryKey);

		if (familyRelation == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFamilyRelationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return familyRelation;
	}

	/**
	 * Returns the family relation with the primary key or throws a <code>NoSuchFamilyRelationException</code> if it could not be found.
	 *
	 * @param familyRelationId the primary key of the family relation
	 * @return the family relation
	 * @throws NoSuchFamilyRelationException if a family relation with the primary key could not be found
	 */
	@Override
	public FamilyRelation findByPrimaryKey(long familyRelationId)
		throws NoSuchFamilyRelationException {

		return findByPrimaryKey((Serializable)familyRelationId);
	}

	/**
	 * Returns the family relation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param familyRelationId the primary key of the family relation
	 * @return the family relation, or <code>null</code> if a family relation with the primary key could not be found
	 */
	@Override
	public FamilyRelation fetchByPrimaryKey(long familyRelationId) {
		return fetchByPrimaryKey((Serializable)familyRelationId);
	}

	/**
	 * Returns all the family relations.
	 *
	 * @return the family relations
	 */
	@Override
	public List<FamilyRelation> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the family relations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FamilyRelationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of family relations
	 * @param end the upper bound of the range of family relations (not inclusive)
	 * @return the range of family relations
	 */
	@Override
	public List<FamilyRelation> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the family relations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FamilyRelationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of family relations
	 * @param end the upper bound of the range of family relations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of family relations
	 */
	@Override
	public List<FamilyRelation> findAll(
		int start, int end,
		OrderByComparator<FamilyRelation> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the family relations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FamilyRelationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of family relations
	 * @param end the upper bound of the range of family relations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of family relations
	 */
	@Override
	public List<FamilyRelation> findAll(
		int start, int end, OrderByComparator<FamilyRelation> orderByComparator,
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

		List<FamilyRelation> list = null;

		if (useFinderCache) {
			list = (List<FamilyRelation>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_FAMILYRELATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_FAMILYRELATION;

				sql = sql.concat(FamilyRelationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<FamilyRelation>)QueryUtil.list(
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
	 * Removes all the family relations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (FamilyRelation familyRelation : findAll()) {
			remove(familyRelation);
		}
	}

	/**
	 * Returns the number of family relations.
	 *
	 * @return the number of family relations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_FAMILYRELATION);

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
		return "familyRelationId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_FAMILYRELATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FamilyRelationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the family relation persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new FamilyRelationModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", FamilyRelation.class.getName()));

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
		entityCache.removeCache(FamilyRelationImpl.class.getName());

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

	private static final String _SQL_SELECT_FAMILYRELATION =
		"SELECT familyRelation FROM FamilyRelation familyRelation";

	private static final String _SQL_COUNT_FAMILYRELATION =
		"SELECT COUNT(familyRelation) FROM FamilyRelation familyRelation";

	private static final String _ORDER_BY_ENTITY_ALIAS = "familyRelation.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No FamilyRelation exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		FamilyRelationPersistenceImpl.class);

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

	private static class FamilyRelationModelArgumentsResolver
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

			FamilyRelationModelImpl familyRelationModelImpl =
				(FamilyRelationModelImpl)baseModel;

			long columnBitmask = familyRelationModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					familyRelationModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						familyRelationModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					familyRelationModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			FamilyRelationModelImpl familyRelationModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						familyRelationModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = familyRelationModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}