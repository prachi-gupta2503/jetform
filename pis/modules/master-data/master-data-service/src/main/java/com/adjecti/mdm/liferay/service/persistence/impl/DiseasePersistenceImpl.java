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

import com.adjecti.mdm.liferay.exception.NoSuchDiseaseException;
import com.adjecti.mdm.liferay.model.Disease;
import com.adjecti.mdm.liferay.model.impl.DiseaseImpl;
import com.adjecti.mdm.liferay.model.impl.DiseaseModelImpl;
import com.adjecti.mdm.liferay.service.persistence.DiseasePersistence;
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
 * The persistence implementation for the disease service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DiseasePersistence.class)
public class DiseasePersistenceImpl
	extends BasePersistenceImpl<Disease> implements DiseasePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DiseaseUtil</code> to access the disease persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DiseaseImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public DiseasePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("code", "code_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Disease.class);

		setModelImplClass(DiseaseImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the disease in the entity cache if it is enabled.
	 *
	 * @param disease the disease
	 */
	@Override
	public void cacheResult(Disease disease) {
		entityCache.putResult(
			DiseaseImpl.class, disease.getPrimaryKey(), disease);
	}

	/**
	 * Caches the diseases in the entity cache if it is enabled.
	 *
	 * @param diseases the diseases
	 */
	@Override
	public void cacheResult(List<Disease> diseases) {
		for (Disease disease : diseases) {
			if (entityCache.getResult(
					DiseaseImpl.class, disease.getPrimaryKey()) == null) {

				cacheResult(disease);
			}
		}
	}

	/**
	 * Clears the cache for all diseases.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DiseaseImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the disease.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Disease disease) {
		entityCache.removeResult(DiseaseImpl.class, disease);
	}

	@Override
	public void clearCache(List<Disease> diseases) {
		for (Disease disease : diseases) {
			entityCache.removeResult(DiseaseImpl.class, disease);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DiseaseImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new disease with the primary key. Does not add the disease to the database.
	 *
	 * @param diseaseId the primary key for the new disease
	 * @return the new disease
	 */
	@Override
	public Disease create(long diseaseId) {
		Disease disease = new DiseaseImpl();

		disease.setNew(true);
		disease.setPrimaryKey(diseaseId);

		disease.setCompanyId(CompanyThreadLocal.getCompanyId());

		return disease;
	}

	/**
	 * Removes the disease with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param diseaseId the primary key of the disease
	 * @return the disease that was removed
	 * @throws NoSuchDiseaseException if a disease with the primary key could not be found
	 */
	@Override
	public Disease remove(long diseaseId) throws NoSuchDiseaseException {
		return remove((Serializable)diseaseId);
	}

	/**
	 * Removes the disease with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the disease
	 * @return the disease that was removed
	 * @throws NoSuchDiseaseException if a disease with the primary key could not be found
	 */
	@Override
	public Disease remove(Serializable primaryKey)
		throws NoSuchDiseaseException {

		Session session = null;

		try {
			session = openSession();

			Disease disease = (Disease)session.get(
				DiseaseImpl.class, primaryKey);

			if (disease == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDiseaseException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(disease);
		}
		catch (NoSuchDiseaseException noSuchEntityException) {
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
	protected Disease removeImpl(Disease disease) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(disease)) {
				disease = (Disease)session.get(
					DiseaseImpl.class, disease.getPrimaryKeyObj());
			}

			if (disease != null) {
				session.delete(disease);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (disease != null) {
			clearCache(disease);
		}

		return disease;
	}

	@Override
	public Disease updateImpl(Disease disease) {
		boolean isNew = disease.isNew();

		if (!(disease instanceof DiseaseModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(disease.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(disease);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in disease proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Disease implementation " +
					disease.getClass());
		}

		DiseaseModelImpl diseaseModelImpl = (DiseaseModelImpl)disease;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (disease.getCreateDate() == null)) {
			if (serviceContext == null) {
				disease.setCreateDate(now);
			}
			else {
				disease.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!diseaseModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				disease.setModifiedDate(now);
			}
			else {
				disease.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(disease);
			}
			else {
				disease = (Disease)session.merge(disease);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(DiseaseImpl.class, disease, false, true);

		if (isNew) {
			disease.setNew(false);
		}

		disease.resetOriginalValues();

		return disease;
	}

	/**
	 * Returns the disease with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the disease
	 * @return the disease
	 * @throws NoSuchDiseaseException if a disease with the primary key could not be found
	 */
	@Override
	public Disease findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDiseaseException {

		Disease disease = fetchByPrimaryKey(primaryKey);

		if (disease == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDiseaseException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return disease;
	}

	/**
	 * Returns the disease with the primary key or throws a <code>NoSuchDiseaseException</code> if it could not be found.
	 *
	 * @param diseaseId the primary key of the disease
	 * @return the disease
	 * @throws NoSuchDiseaseException if a disease with the primary key could not be found
	 */
	@Override
	public Disease findByPrimaryKey(long diseaseId)
		throws NoSuchDiseaseException {

		return findByPrimaryKey((Serializable)diseaseId);
	}

	/**
	 * Returns the disease with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param diseaseId the primary key of the disease
	 * @return the disease, or <code>null</code> if a disease with the primary key could not be found
	 */
	@Override
	public Disease fetchByPrimaryKey(long diseaseId) {
		return fetchByPrimaryKey((Serializable)diseaseId);
	}

	/**
	 * Returns all the diseases.
	 *
	 * @return the diseases
	 */
	@Override
	public List<Disease> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the diseases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DiseaseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of diseases
	 * @param end the upper bound of the range of diseases (not inclusive)
	 * @return the range of diseases
	 */
	@Override
	public List<Disease> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the diseases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DiseaseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of diseases
	 * @param end the upper bound of the range of diseases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of diseases
	 */
	@Override
	public List<Disease> findAll(
		int start, int end, OrderByComparator<Disease> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the diseases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DiseaseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of diseases
	 * @param end the upper bound of the range of diseases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of diseases
	 */
	@Override
	public List<Disease> findAll(
		int start, int end, OrderByComparator<Disease> orderByComparator,
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

		List<Disease> list = null;

		if (useFinderCache) {
			list = (List<Disease>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DISEASE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DISEASE;

				sql = sql.concat(DiseaseModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Disease>)QueryUtil.list(
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
	 * Removes all the diseases from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Disease disease : findAll()) {
			remove(disease);
		}
	}

	/**
	 * Returns the number of diseases.
	 *
	 * @return the number of diseases
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DISEASE);

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
		return "diseaseId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DISEASE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DiseaseModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the disease persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new DiseaseModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", Disease.class.getName()));

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
		entityCache.removeCache(DiseaseImpl.class.getName());

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

	private static final String _SQL_SELECT_DISEASE =
		"SELECT disease FROM Disease disease";

	private static final String _SQL_COUNT_DISEASE =
		"SELECT COUNT(disease) FROM Disease disease";

	private static final String _ORDER_BY_ENTITY_ALIAS = "disease.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Disease exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		DiseasePersistenceImpl.class);

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

	private static class DiseaseModelArgumentsResolver
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

			DiseaseModelImpl diseaseModelImpl = (DiseaseModelImpl)baseModel;

			long columnBitmask = diseaseModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(diseaseModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						diseaseModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(diseaseModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			DiseaseModelImpl diseaseModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = diseaseModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = diseaseModelImpl.getColumnValue(columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}