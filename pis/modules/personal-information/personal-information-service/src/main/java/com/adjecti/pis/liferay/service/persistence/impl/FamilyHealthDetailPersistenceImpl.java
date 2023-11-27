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

import com.adjecti.pis.liferay.exception.NoSuchFamilyHealthDetailException;
import com.adjecti.pis.liferay.model.FamilyHealthDetail;
import com.adjecti.pis.liferay.model.impl.FamilyHealthDetailImpl;
import com.adjecti.pis.liferay.model.impl.FamilyHealthDetailModelImpl;
import com.adjecti.pis.liferay.service.persistence.FamilyHealthDetailPersistence;
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
 * The persistence implementation for the family health detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = FamilyHealthDetailPersistence.class)
public class FamilyHealthDetailPersistenceImpl
	extends BasePersistenceImpl<FamilyHealthDetail>
	implements FamilyHealthDetailPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FamilyHealthDetailUtil</code> to access the family health detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FamilyHealthDetailImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public FamilyHealthDetailPersistenceImpl() {
		setModelClass(FamilyHealthDetail.class);

		setModelImplClass(FamilyHealthDetailImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the family health detail in the entity cache if it is enabled.
	 *
	 * @param familyHealthDetail the family health detail
	 */
	@Override
	public void cacheResult(FamilyHealthDetail familyHealthDetail) {
		entityCache.putResult(
			FamilyHealthDetailImpl.class, familyHealthDetail.getPrimaryKey(),
			familyHealthDetail);
	}

	/**
	 * Caches the family health details in the entity cache if it is enabled.
	 *
	 * @param familyHealthDetails the family health details
	 */
	@Override
	public void cacheResult(List<FamilyHealthDetail> familyHealthDetails) {
		for (FamilyHealthDetail familyHealthDetail : familyHealthDetails) {
			if (entityCache.getResult(
					FamilyHealthDetailImpl.class,
					familyHealthDetail.getPrimaryKey()) == null) {

				cacheResult(familyHealthDetail);
			}
		}
	}

	/**
	 * Clears the cache for all family health details.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FamilyHealthDetailImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the family health detail.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FamilyHealthDetail familyHealthDetail) {
		entityCache.removeResult(
			FamilyHealthDetailImpl.class, familyHealthDetail);
	}

	@Override
	public void clearCache(List<FamilyHealthDetail> familyHealthDetails) {
		for (FamilyHealthDetail familyHealthDetail : familyHealthDetails) {
			entityCache.removeResult(
				FamilyHealthDetailImpl.class, familyHealthDetail);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(FamilyHealthDetailImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new family health detail with the primary key. Does not add the family health detail to the database.
	 *
	 * @param familyHealthDetailId the primary key for the new family health detail
	 * @return the new family health detail
	 */
	@Override
	public FamilyHealthDetail create(long familyHealthDetailId) {
		FamilyHealthDetail familyHealthDetail = new FamilyHealthDetailImpl();

		familyHealthDetail.setNew(true);
		familyHealthDetail.setPrimaryKey(familyHealthDetailId);

		familyHealthDetail.setCompanyId(CompanyThreadLocal.getCompanyId());

		return familyHealthDetail;
	}

	/**
	 * Removes the family health detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param familyHealthDetailId the primary key of the family health detail
	 * @return the family health detail that was removed
	 * @throws NoSuchFamilyHealthDetailException if a family health detail with the primary key could not be found
	 */
	@Override
	public FamilyHealthDetail remove(long familyHealthDetailId)
		throws NoSuchFamilyHealthDetailException {

		return remove((Serializable)familyHealthDetailId);
	}

	/**
	 * Removes the family health detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the family health detail
	 * @return the family health detail that was removed
	 * @throws NoSuchFamilyHealthDetailException if a family health detail with the primary key could not be found
	 */
	@Override
	public FamilyHealthDetail remove(Serializable primaryKey)
		throws NoSuchFamilyHealthDetailException {

		Session session = null;

		try {
			session = openSession();

			FamilyHealthDetail familyHealthDetail =
				(FamilyHealthDetail)session.get(
					FamilyHealthDetailImpl.class, primaryKey);

			if (familyHealthDetail == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFamilyHealthDetailException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(familyHealthDetail);
		}
		catch (NoSuchFamilyHealthDetailException noSuchEntityException) {
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
	protected FamilyHealthDetail removeImpl(
		FamilyHealthDetail familyHealthDetail) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(familyHealthDetail)) {
				familyHealthDetail = (FamilyHealthDetail)session.get(
					FamilyHealthDetailImpl.class,
					familyHealthDetail.getPrimaryKeyObj());
			}

			if (familyHealthDetail != null) {
				session.delete(familyHealthDetail);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (familyHealthDetail != null) {
			clearCache(familyHealthDetail);
		}

		return familyHealthDetail;
	}

	@Override
	public FamilyHealthDetail updateImpl(
		FamilyHealthDetail familyHealthDetail) {

		boolean isNew = familyHealthDetail.isNew();

		if (!(familyHealthDetail instanceof FamilyHealthDetailModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(familyHealthDetail.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					familyHealthDetail);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in familyHealthDetail proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom FamilyHealthDetail implementation " +
					familyHealthDetail.getClass());
		}

		FamilyHealthDetailModelImpl familyHealthDetailModelImpl =
			(FamilyHealthDetailModelImpl)familyHealthDetail;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (familyHealthDetail.getCreateDate() == null)) {
			if (serviceContext == null) {
				familyHealthDetail.setCreateDate(now);
			}
			else {
				familyHealthDetail.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!familyHealthDetailModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				familyHealthDetail.setModifiedDate(now);
			}
			else {
				familyHealthDetail.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(familyHealthDetail);
			}
			else {
				familyHealthDetail = (FamilyHealthDetail)session.merge(
					familyHealthDetail);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			FamilyHealthDetailImpl.class, familyHealthDetail, false, true);

		if (isNew) {
			familyHealthDetail.setNew(false);
		}

		familyHealthDetail.resetOriginalValues();

		return familyHealthDetail;
	}

	/**
	 * Returns the family health detail with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the family health detail
	 * @return the family health detail
	 * @throws NoSuchFamilyHealthDetailException if a family health detail with the primary key could not be found
	 */
	@Override
	public FamilyHealthDetail findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFamilyHealthDetailException {

		FamilyHealthDetail familyHealthDetail = fetchByPrimaryKey(primaryKey);

		if (familyHealthDetail == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFamilyHealthDetailException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return familyHealthDetail;
	}

	/**
	 * Returns the family health detail with the primary key or throws a <code>NoSuchFamilyHealthDetailException</code> if it could not be found.
	 *
	 * @param familyHealthDetailId the primary key of the family health detail
	 * @return the family health detail
	 * @throws NoSuchFamilyHealthDetailException if a family health detail with the primary key could not be found
	 */
	@Override
	public FamilyHealthDetail findByPrimaryKey(long familyHealthDetailId)
		throws NoSuchFamilyHealthDetailException {

		return findByPrimaryKey((Serializable)familyHealthDetailId);
	}

	/**
	 * Returns the family health detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param familyHealthDetailId the primary key of the family health detail
	 * @return the family health detail, or <code>null</code> if a family health detail with the primary key could not be found
	 */
	@Override
	public FamilyHealthDetail fetchByPrimaryKey(long familyHealthDetailId) {
		return fetchByPrimaryKey((Serializable)familyHealthDetailId);
	}

	/**
	 * Returns all the family health details.
	 *
	 * @return the family health details
	 */
	@Override
	public List<FamilyHealthDetail> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the family health details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FamilyHealthDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of family health details
	 * @param end the upper bound of the range of family health details (not inclusive)
	 * @return the range of family health details
	 */
	@Override
	public List<FamilyHealthDetail> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the family health details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FamilyHealthDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of family health details
	 * @param end the upper bound of the range of family health details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of family health details
	 */
	@Override
	public List<FamilyHealthDetail> findAll(
		int start, int end,
		OrderByComparator<FamilyHealthDetail> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the family health details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FamilyHealthDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of family health details
	 * @param end the upper bound of the range of family health details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of family health details
	 */
	@Override
	public List<FamilyHealthDetail> findAll(
		int start, int end,
		OrderByComparator<FamilyHealthDetail> orderByComparator,
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

		List<FamilyHealthDetail> list = null;

		if (useFinderCache) {
			list = (List<FamilyHealthDetail>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_FAMILYHEALTHDETAIL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_FAMILYHEALTHDETAIL;

				sql = sql.concat(FamilyHealthDetailModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<FamilyHealthDetail>)QueryUtil.list(
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
	 * Removes all the family health details from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (FamilyHealthDetail familyHealthDetail : findAll()) {
			remove(familyHealthDetail);
		}
	}

	/**
	 * Returns the number of family health details.
	 *
	 * @return the number of family health details
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
					_SQL_COUNT_FAMILYHEALTHDETAIL);

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
		return "familyHealthDetailId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_FAMILYHEALTHDETAIL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FamilyHealthDetailModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the family health detail persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new FamilyHealthDetailModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", FamilyHealthDetail.class.getName()));

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
		entityCache.removeCache(FamilyHealthDetailImpl.class.getName());

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

	private static final String _SQL_SELECT_FAMILYHEALTHDETAIL =
		"SELECT familyHealthDetail FROM FamilyHealthDetail familyHealthDetail";

	private static final String _SQL_COUNT_FAMILYHEALTHDETAIL =
		"SELECT COUNT(familyHealthDetail) FROM FamilyHealthDetail familyHealthDetail";

	private static final String _ORDER_BY_ENTITY_ALIAS = "familyHealthDetail.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No FamilyHealthDetail exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		FamilyHealthDetailPersistenceImpl.class);

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

	private static class FamilyHealthDetailModelArgumentsResolver
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

			FamilyHealthDetailModelImpl familyHealthDetailModelImpl =
				(FamilyHealthDetailModelImpl)baseModel;

			long columnBitmask = familyHealthDetailModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					familyHealthDetailModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						familyHealthDetailModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					familyHealthDetailModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			FamilyHealthDetailModelImpl familyHealthDetailModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						familyHealthDetailModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = familyHealthDetailModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}