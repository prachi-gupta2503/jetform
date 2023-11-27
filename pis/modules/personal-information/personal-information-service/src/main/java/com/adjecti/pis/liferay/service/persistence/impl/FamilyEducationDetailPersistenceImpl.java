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

import com.adjecti.pis.liferay.exception.NoSuchFamilyEducationDetailException;
import com.adjecti.pis.liferay.model.FamilyEducationDetail;
import com.adjecti.pis.liferay.model.impl.FamilyEducationDetailImpl;
import com.adjecti.pis.liferay.model.impl.FamilyEducationDetailModelImpl;
import com.adjecti.pis.liferay.service.persistence.FamilyEducationDetailPersistence;
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
 * The persistence implementation for the family education detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = FamilyEducationDetailPersistence.class)
public class FamilyEducationDetailPersistenceImpl
	extends BasePersistenceImpl<FamilyEducationDetail>
	implements FamilyEducationDetailPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FamilyEducationDetailUtil</code> to access the family education detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FamilyEducationDetailImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public FamilyEducationDetailPersistenceImpl() {
		setModelClass(FamilyEducationDetail.class);

		setModelImplClass(FamilyEducationDetailImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the family education detail in the entity cache if it is enabled.
	 *
	 * @param familyEducationDetail the family education detail
	 */
	@Override
	public void cacheResult(FamilyEducationDetail familyEducationDetail) {
		entityCache.putResult(
			FamilyEducationDetailImpl.class,
			familyEducationDetail.getPrimaryKey(), familyEducationDetail);
	}

	/**
	 * Caches the family education details in the entity cache if it is enabled.
	 *
	 * @param familyEducationDetails the family education details
	 */
	@Override
	public void cacheResult(
		List<FamilyEducationDetail> familyEducationDetails) {

		for (FamilyEducationDetail familyEducationDetail :
				familyEducationDetails) {

			if (entityCache.getResult(
					FamilyEducationDetailImpl.class,
					familyEducationDetail.getPrimaryKey()) == null) {

				cacheResult(familyEducationDetail);
			}
		}
	}

	/**
	 * Clears the cache for all family education details.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FamilyEducationDetailImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the family education detail.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FamilyEducationDetail familyEducationDetail) {
		entityCache.removeResult(
			FamilyEducationDetailImpl.class, familyEducationDetail);
	}

	@Override
	public void clearCache(List<FamilyEducationDetail> familyEducationDetails) {
		for (FamilyEducationDetail familyEducationDetail :
				familyEducationDetails) {

			entityCache.removeResult(
				FamilyEducationDetailImpl.class, familyEducationDetail);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				FamilyEducationDetailImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new family education detail with the primary key. Does not add the family education detail to the database.
	 *
	 * @param familyEducationDetailId the primary key for the new family education detail
	 * @return the new family education detail
	 */
	@Override
	public FamilyEducationDetail create(long familyEducationDetailId) {
		FamilyEducationDetail familyEducationDetail =
			new FamilyEducationDetailImpl();

		familyEducationDetail.setNew(true);
		familyEducationDetail.setPrimaryKey(familyEducationDetailId);

		familyEducationDetail.setCompanyId(CompanyThreadLocal.getCompanyId());

		return familyEducationDetail;
	}

	/**
	 * Removes the family education detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param familyEducationDetailId the primary key of the family education detail
	 * @return the family education detail that was removed
	 * @throws NoSuchFamilyEducationDetailException if a family education detail with the primary key could not be found
	 */
	@Override
	public FamilyEducationDetail remove(long familyEducationDetailId)
		throws NoSuchFamilyEducationDetailException {

		return remove((Serializable)familyEducationDetailId);
	}

	/**
	 * Removes the family education detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the family education detail
	 * @return the family education detail that was removed
	 * @throws NoSuchFamilyEducationDetailException if a family education detail with the primary key could not be found
	 */
	@Override
	public FamilyEducationDetail remove(Serializable primaryKey)
		throws NoSuchFamilyEducationDetailException {

		Session session = null;

		try {
			session = openSession();

			FamilyEducationDetail familyEducationDetail =
				(FamilyEducationDetail)session.get(
					FamilyEducationDetailImpl.class, primaryKey);

			if (familyEducationDetail == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFamilyEducationDetailException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(familyEducationDetail);
		}
		catch (NoSuchFamilyEducationDetailException noSuchEntityException) {
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
	protected FamilyEducationDetail removeImpl(
		FamilyEducationDetail familyEducationDetail) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(familyEducationDetail)) {
				familyEducationDetail = (FamilyEducationDetail)session.get(
					FamilyEducationDetailImpl.class,
					familyEducationDetail.getPrimaryKeyObj());
			}

			if (familyEducationDetail != null) {
				session.delete(familyEducationDetail);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (familyEducationDetail != null) {
			clearCache(familyEducationDetail);
		}

		return familyEducationDetail;
	}

	@Override
	public FamilyEducationDetail updateImpl(
		FamilyEducationDetail familyEducationDetail) {

		boolean isNew = familyEducationDetail.isNew();

		if (!(familyEducationDetail instanceof
				FamilyEducationDetailModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(familyEducationDetail.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					familyEducationDetail);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in familyEducationDetail proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom FamilyEducationDetail implementation " +
					familyEducationDetail.getClass());
		}

		FamilyEducationDetailModelImpl familyEducationDetailModelImpl =
			(FamilyEducationDetailModelImpl)familyEducationDetail;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (familyEducationDetail.getCreateDate() == null)) {
			if (serviceContext == null) {
				familyEducationDetail.setCreateDate(now);
			}
			else {
				familyEducationDetail.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!familyEducationDetailModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				familyEducationDetail.setModifiedDate(now);
			}
			else {
				familyEducationDetail.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(familyEducationDetail);
			}
			else {
				familyEducationDetail = (FamilyEducationDetail)session.merge(
					familyEducationDetail);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			FamilyEducationDetailImpl.class, familyEducationDetail, false,
			true);

		if (isNew) {
			familyEducationDetail.setNew(false);
		}

		familyEducationDetail.resetOriginalValues();

		return familyEducationDetail;
	}

	/**
	 * Returns the family education detail with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the family education detail
	 * @return the family education detail
	 * @throws NoSuchFamilyEducationDetailException if a family education detail with the primary key could not be found
	 */
	@Override
	public FamilyEducationDetail findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFamilyEducationDetailException {

		FamilyEducationDetail familyEducationDetail = fetchByPrimaryKey(
			primaryKey);

		if (familyEducationDetail == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFamilyEducationDetailException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return familyEducationDetail;
	}

	/**
	 * Returns the family education detail with the primary key or throws a <code>NoSuchFamilyEducationDetailException</code> if it could not be found.
	 *
	 * @param familyEducationDetailId the primary key of the family education detail
	 * @return the family education detail
	 * @throws NoSuchFamilyEducationDetailException if a family education detail with the primary key could not be found
	 */
	@Override
	public FamilyEducationDetail findByPrimaryKey(long familyEducationDetailId)
		throws NoSuchFamilyEducationDetailException {

		return findByPrimaryKey((Serializable)familyEducationDetailId);
	}

	/**
	 * Returns the family education detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param familyEducationDetailId the primary key of the family education detail
	 * @return the family education detail, or <code>null</code> if a family education detail with the primary key could not be found
	 */
	@Override
	public FamilyEducationDetail fetchByPrimaryKey(
		long familyEducationDetailId) {

		return fetchByPrimaryKey((Serializable)familyEducationDetailId);
	}

	/**
	 * Returns all the family education details.
	 *
	 * @return the family education details
	 */
	@Override
	public List<FamilyEducationDetail> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the family education details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FamilyEducationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of family education details
	 * @param end the upper bound of the range of family education details (not inclusive)
	 * @return the range of family education details
	 */
	@Override
	public List<FamilyEducationDetail> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the family education details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FamilyEducationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of family education details
	 * @param end the upper bound of the range of family education details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of family education details
	 */
	@Override
	public List<FamilyEducationDetail> findAll(
		int start, int end,
		OrderByComparator<FamilyEducationDetail> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the family education details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FamilyEducationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of family education details
	 * @param end the upper bound of the range of family education details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of family education details
	 */
	@Override
	public List<FamilyEducationDetail> findAll(
		int start, int end,
		OrderByComparator<FamilyEducationDetail> orderByComparator,
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

		List<FamilyEducationDetail> list = null;

		if (useFinderCache) {
			list = (List<FamilyEducationDetail>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_FAMILYEDUCATIONDETAIL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_FAMILYEDUCATIONDETAIL;

				sql = sql.concat(FamilyEducationDetailModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<FamilyEducationDetail>)QueryUtil.list(
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
	 * Removes all the family education details from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (FamilyEducationDetail familyEducationDetail : findAll()) {
			remove(familyEducationDetail);
		}
	}

	/**
	 * Returns the number of family education details.
	 *
	 * @return the number of family education details
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
					_SQL_COUNT_FAMILYEDUCATIONDETAIL);

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
		return "familyEducationDetailId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_FAMILYEDUCATIONDETAIL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FamilyEducationDetailModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the family education detail persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new FamilyEducationDetailModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", FamilyEducationDetail.class.getName()));

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
		entityCache.removeCache(FamilyEducationDetailImpl.class.getName());

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

	private static final String _SQL_SELECT_FAMILYEDUCATIONDETAIL =
		"SELECT familyEducationDetail FROM FamilyEducationDetail familyEducationDetail";

	private static final String _SQL_COUNT_FAMILYEDUCATIONDETAIL =
		"SELECT COUNT(familyEducationDetail) FROM FamilyEducationDetail familyEducationDetail";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"familyEducationDetail.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No FamilyEducationDetail exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		FamilyEducationDetailPersistenceImpl.class);

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

	private static class FamilyEducationDetailModelArgumentsResolver
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

			FamilyEducationDetailModelImpl familyEducationDetailModelImpl =
				(FamilyEducationDetailModelImpl)baseModel;

			long columnBitmask =
				familyEducationDetailModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					familyEducationDetailModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						familyEducationDetailModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					familyEducationDetailModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			FamilyEducationDetailModelImpl familyEducationDetailModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						familyEducationDetailModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] =
						familyEducationDetailModelImpl.getColumnValue(
							columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}