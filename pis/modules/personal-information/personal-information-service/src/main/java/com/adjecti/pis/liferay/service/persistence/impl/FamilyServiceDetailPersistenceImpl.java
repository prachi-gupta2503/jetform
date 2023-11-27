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

import com.adjecti.pis.liferay.exception.NoSuchFamilyServiceDetailException;
import com.adjecti.pis.liferay.model.FamilyServiceDetail;
import com.adjecti.pis.liferay.model.impl.FamilyServiceDetailImpl;
import com.adjecti.pis.liferay.model.impl.FamilyServiceDetailModelImpl;
import com.adjecti.pis.liferay.service.persistence.FamilyServiceDetailPersistence;
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
 * The persistence implementation for the family service detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = FamilyServiceDetailPersistence.class)
public class FamilyServiceDetailPersistenceImpl
	extends BasePersistenceImpl<FamilyServiceDetail>
	implements FamilyServiceDetailPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FamilyServiceDetailUtil</code> to access the family service detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FamilyServiceDetailImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public FamilyServiceDetailPersistenceImpl() {
		setModelClass(FamilyServiceDetail.class);

		setModelImplClass(FamilyServiceDetailImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the family service detail in the entity cache if it is enabled.
	 *
	 * @param familyServiceDetail the family service detail
	 */
	@Override
	public void cacheResult(FamilyServiceDetail familyServiceDetail) {
		entityCache.putResult(
			FamilyServiceDetailImpl.class, familyServiceDetail.getPrimaryKey(),
			familyServiceDetail);
	}

	/**
	 * Caches the family service details in the entity cache if it is enabled.
	 *
	 * @param familyServiceDetails the family service details
	 */
	@Override
	public void cacheResult(List<FamilyServiceDetail> familyServiceDetails) {
		for (FamilyServiceDetail familyServiceDetail : familyServiceDetails) {
			if (entityCache.getResult(
					FamilyServiceDetailImpl.class,
					familyServiceDetail.getPrimaryKey()) == null) {

				cacheResult(familyServiceDetail);
			}
		}
	}

	/**
	 * Clears the cache for all family service details.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FamilyServiceDetailImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the family service detail.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FamilyServiceDetail familyServiceDetail) {
		entityCache.removeResult(
			FamilyServiceDetailImpl.class, familyServiceDetail);
	}

	@Override
	public void clearCache(List<FamilyServiceDetail> familyServiceDetails) {
		for (FamilyServiceDetail familyServiceDetail : familyServiceDetails) {
			entityCache.removeResult(
				FamilyServiceDetailImpl.class, familyServiceDetail);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(FamilyServiceDetailImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new family service detail with the primary key. Does not add the family service detail to the database.
	 *
	 * @param familyServiceDetailId the primary key for the new family service detail
	 * @return the new family service detail
	 */
	@Override
	public FamilyServiceDetail create(long familyServiceDetailId) {
		FamilyServiceDetail familyServiceDetail = new FamilyServiceDetailImpl();

		familyServiceDetail.setNew(true);
		familyServiceDetail.setPrimaryKey(familyServiceDetailId);

		familyServiceDetail.setCompanyId(CompanyThreadLocal.getCompanyId());

		return familyServiceDetail;
	}

	/**
	 * Removes the family service detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param familyServiceDetailId the primary key of the family service detail
	 * @return the family service detail that was removed
	 * @throws NoSuchFamilyServiceDetailException if a family service detail with the primary key could not be found
	 */
	@Override
	public FamilyServiceDetail remove(long familyServiceDetailId)
		throws NoSuchFamilyServiceDetailException {

		return remove((Serializable)familyServiceDetailId);
	}

	/**
	 * Removes the family service detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the family service detail
	 * @return the family service detail that was removed
	 * @throws NoSuchFamilyServiceDetailException if a family service detail with the primary key could not be found
	 */
	@Override
	public FamilyServiceDetail remove(Serializable primaryKey)
		throws NoSuchFamilyServiceDetailException {

		Session session = null;

		try {
			session = openSession();

			FamilyServiceDetail familyServiceDetail =
				(FamilyServiceDetail)session.get(
					FamilyServiceDetailImpl.class, primaryKey);

			if (familyServiceDetail == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFamilyServiceDetailException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(familyServiceDetail);
		}
		catch (NoSuchFamilyServiceDetailException noSuchEntityException) {
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
	protected FamilyServiceDetail removeImpl(
		FamilyServiceDetail familyServiceDetail) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(familyServiceDetail)) {
				familyServiceDetail = (FamilyServiceDetail)session.get(
					FamilyServiceDetailImpl.class,
					familyServiceDetail.getPrimaryKeyObj());
			}

			if (familyServiceDetail != null) {
				session.delete(familyServiceDetail);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (familyServiceDetail != null) {
			clearCache(familyServiceDetail);
		}

		return familyServiceDetail;
	}

	@Override
	public FamilyServiceDetail updateImpl(
		FamilyServiceDetail familyServiceDetail) {

		boolean isNew = familyServiceDetail.isNew();

		if (!(familyServiceDetail instanceof FamilyServiceDetailModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(familyServiceDetail.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					familyServiceDetail);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in familyServiceDetail proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom FamilyServiceDetail implementation " +
					familyServiceDetail.getClass());
		}

		FamilyServiceDetailModelImpl familyServiceDetailModelImpl =
			(FamilyServiceDetailModelImpl)familyServiceDetail;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (familyServiceDetail.getCreateDate() == null)) {
			if (serviceContext == null) {
				familyServiceDetail.setCreateDate(now);
			}
			else {
				familyServiceDetail.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!familyServiceDetailModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				familyServiceDetail.setModifiedDate(now);
			}
			else {
				familyServiceDetail.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(familyServiceDetail);
			}
			else {
				familyServiceDetail = (FamilyServiceDetail)session.merge(
					familyServiceDetail);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			FamilyServiceDetailImpl.class, familyServiceDetail, false, true);

		if (isNew) {
			familyServiceDetail.setNew(false);
		}

		familyServiceDetail.resetOriginalValues();

		return familyServiceDetail;
	}

	/**
	 * Returns the family service detail with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the family service detail
	 * @return the family service detail
	 * @throws NoSuchFamilyServiceDetailException if a family service detail with the primary key could not be found
	 */
	@Override
	public FamilyServiceDetail findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFamilyServiceDetailException {

		FamilyServiceDetail familyServiceDetail = fetchByPrimaryKey(primaryKey);

		if (familyServiceDetail == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFamilyServiceDetailException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return familyServiceDetail;
	}

	/**
	 * Returns the family service detail with the primary key or throws a <code>NoSuchFamilyServiceDetailException</code> if it could not be found.
	 *
	 * @param familyServiceDetailId the primary key of the family service detail
	 * @return the family service detail
	 * @throws NoSuchFamilyServiceDetailException if a family service detail with the primary key could not be found
	 */
	@Override
	public FamilyServiceDetail findByPrimaryKey(long familyServiceDetailId)
		throws NoSuchFamilyServiceDetailException {

		return findByPrimaryKey((Serializable)familyServiceDetailId);
	}

	/**
	 * Returns the family service detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param familyServiceDetailId the primary key of the family service detail
	 * @return the family service detail, or <code>null</code> if a family service detail with the primary key could not be found
	 */
	@Override
	public FamilyServiceDetail fetchByPrimaryKey(long familyServiceDetailId) {
		return fetchByPrimaryKey((Serializable)familyServiceDetailId);
	}

	/**
	 * Returns all the family service details.
	 *
	 * @return the family service details
	 */
	@Override
	public List<FamilyServiceDetail> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the family service details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FamilyServiceDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of family service details
	 * @param end the upper bound of the range of family service details (not inclusive)
	 * @return the range of family service details
	 */
	@Override
	public List<FamilyServiceDetail> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the family service details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FamilyServiceDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of family service details
	 * @param end the upper bound of the range of family service details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of family service details
	 */
	@Override
	public List<FamilyServiceDetail> findAll(
		int start, int end,
		OrderByComparator<FamilyServiceDetail> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the family service details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FamilyServiceDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of family service details
	 * @param end the upper bound of the range of family service details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of family service details
	 */
	@Override
	public List<FamilyServiceDetail> findAll(
		int start, int end,
		OrderByComparator<FamilyServiceDetail> orderByComparator,
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

		List<FamilyServiceDetail> list = null;

		if (useFinderCache) {
			list = (List<FamilyServiceDetail>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_FAMILYSERVICEDETAIL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_FAMILYSERVICEDETAIL;

				sql = sql.concat(FamilyServiceDetailModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<FamilyServiceDetail>)QueryUtil.list(
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
	 * Removes all the family service details from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (FamilyServiceDetail familyServiceDetail : findAll()) {
			remove(familyServiceDetail);
		}
	}

	/**
	 * Returns the number of family service details.
	 *
	 * @return the number of family service details
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
					_SQL_COUNT_FAMILYSERVICEDETAIL);

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
		return "familyServiceDetailId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_FAMILYSERVICEDETAIL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FamilyServiceDetailModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the family service detail persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new FamilyServiceDetailModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", FamilyServiceDetail.class.getName()));

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
		entityCache.removeCache(FamilyServiceDetailImpl.class.getName());

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

	private static final String _SQL_SELECT_FAMILYSERVICEDETAIL =
		"SELECT familyServiceDetail FROM FamilyServiceDetail familyServiceDetail";

	private static final String _SQL_COUNT_FAMILYSERVICEDETAIL =
		"SELECT COUNT(familyServiceDetail) FROM FamilyServiceDetail familyServiceDetail";

	private static final String _ORDER_BY_ENTITY_ALIAS = "familyServiceDetail.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No FamilyServiceDetail exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		FamilyServiceDetailPersistenceImpl.class);

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

	private static class FamilyServiceDetailModelArgumentsResolver
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

			FamilyServiceDetailModelImpl familyServiceDetailModelImpl =
				(FamilyServiceDetailModelImpl)baseModel;

			long columnBitmask =
				familyServiceDetailModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					familyServiceDetailModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						familyServiceDetailModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					familyServiceDetailModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			FamilyServiceDetailModelImpl familyServiceDetailModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						familyServiceDetailModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = familyServiceDetailModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}