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

package com.adjecti.jetform.liferay.service.persistence.impl;

import com.adjecti.jetform.liferay.exception.NoSuchImportMasterEntityException;
import com.adjecti.jetform.liferay.model.ImportMasterEntity;
import com.adjecti.jetform.liferay.model.impl.ImportMasterEntityImpl;
import com.adjecti.jetform.liferay.model.impl.ImportMasterEntityModelImpl;
import com.adjecti.jetform.liferay.service.persistence.ImportMasterEntityPersistence;
import com.adjecti.jetform.liferay.service.persistence.impl.constants.jetformPersistenceConstants;

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
 * The persistence implementation for the import master entity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ImportMasterEntityPersistence.class)
public class ImportMasterEntityPersistenceImpl
	extends BasePersistenceImpl<ImportMasterEntity>
	implements ImportMasterEntityPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ImportMasterEntityUtil</code> to access the import master entity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ImportMasterEntityImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public ImportMasterEntityPersistenceImpl() {
		setModelClass(ImportMasterEntity.class);

		setModelImplClass(ImportMasterEntityImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the import master entity in the entity cache if it is enabled.
	 *
	 * @param importMasterEntity the import master entity
	 */
	@Override
	public void cacheResult(ImportMasterEntity importMasterEntity) {
		entityCache.putResult(
			ImportMasterEntityImpl.class, importMasterEntity.getPrimaryKey(),
			importMasterEntity);
	}

	/**
	 * Caches the import master entities in the entity cache if it is enabled.
	 *
	 * @param importMasterEntities the import master entities
	 */
	@Override
	public void cacheResult(List<ImportMasterEntity> importMasterEntities) {
		for (ImportMasterEntity importMasterEntity : importMasterEntities) {
			if (entityCache.getResult(
					ImportMasterEntityImpl.class,
					importMasterEntity.getPrimaryKey()) == null) {

				cacheResult(importMasterEntity);
			}
		}
	}

	/**
	 * Clears the cache for all import master entities.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ImportMasterEntityImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the import master entity.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ImportMasterEntity importMasterEntity) {
		entityCache.removeResult(
			ImportMasterEntityImpl.class, importMasterEntity);
	}

	@Override
	public void clearCache(List<ImportMasterEntity> importMasterEntities) {
		for (ImportMasterEntity importMasterEntity : importMasterEntities) {
			entityCache.removeResult(
				ImportMasterEntityImpl.class, importMasterEntity);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ImportMasterEntityImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new import master entity with the primary key. Does not add the import master entity to the database.
	 *
	 * @param importMasterEntityId the primary key for the new import master entity
	 * @return the new import master entity
	 */
	@Override
	public ImportMasterEntity create(long importMasterEntityId) {
		ImportMasterEntity importMasterEntity = new ImportMasterEntityImpl();

		importMasterEntity.setNew(true);
		importMasterEntity.setPrimaryKey(importMasterEntityId);

		importMasterEntity.setCompanyId(CompanyThreadLocal.getCompanyId());

		return importMasterEntity;
	}

	/**
	 * Removes the import master entity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param importMasterEntityId the primary key of the import master entity
	 * @return the import master entity that was removed
	 * @throws NoSuchImportMasterEntityException if a import master entity with the primary key could not be found
	 */
	@Override
	public ImportMasterEntity remove(long importMasterEntityId)
		throws NoSuchImportMasterEntityException {

		return remove((Serializable)importMasterEntityId);
	}

	/**
	 * Removes the import master entity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the import master entity
	 * @return the import master entity that was removed
	 * @throws NoSuchImportMasterEntityException if a import master entity with the primary key could not be found
	 */
	@Override
	public ImportMasterEntity remove(Serializable primaryKey)
		throws NoSuchImportMasterEntityException {

		Session session = null;

		try {
			session = openSession();

			ImportMasterEntity importMasterEntity =
				(ImportMasterEntity)session.get(
					ImportMasterEntityImpl.class, primaryKey);

			if (importMasterEntity == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchImportMasterEntityException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(importMasterEntity);
		}
		catch (NoSuchImportMasterEntityException noSuchEntityException) {
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
	protected ImportMasterEntity removeImpl(
		ImportMasterEntity importMasterEntity) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(importMasterEntity)) {
				importMasterEntity = (ImportMasterEntity)session.get(
					ImportMasterEntityImpl.class,
					importMasterEntity.getPrimaryKeyObj());
			}

			if (importMasterEntity != null) {
				session.delete(importMasterEntity);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (importMasterEntity != null) {
			clearCache(importMasterEntity);
		}

		return importMasterEntity;
	}

	@Override
	public ImportMasterEntity updateImpl(
		ImportMasterEntity importMasterEntity) {

		boolean isNew = importMasterEntity.isNew();

		if (!(importMasterEntity instanceof ImportMasterEntityModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(importMasterEntity.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					importMasterEntity);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in importMasterEntity proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ImportMasterEntity implementation " +
					importMasterEntity.getClass());
		}

		ImportMasterEntityModelImpl importMasterEntityModelImpl =
			(ImportMasterEntityModelImpl)importMasterEntity;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (importMasterEntity.getCreateDate() == null)) {
			if (serviceContext == null) {
				importMasterEntity.setCreateDate(now);
			}
			else {
				importMasterEntity.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!importMasterEntityModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				importMasterEntity.setModifiedDate(now);
			}
			else {
				importMasterEntity.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(importMasterEntity);
			}
			else {
				importMasterEntity = (ImportMasterEntity)session.merge(
					importMasterEntity);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ImportMasterEntityImpl.class, importMasterEntity, false, true);

		if (isNew) {
			importMasterEntity.setNew(false);
		}

		importMasterEntity.resetOriginalValues();

		return importMasterEntity;
	}

	/**
	 * Returns the import master entity with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the import master entity
	 * @return the import master entity
	 * @throws NoSuchImportMasterEntityException if a import master entity with the primary key could not be found
	 */
	@Override
	public ImportMasterEntity findByPrimaryKey(Serializable primaryKey)
		throws NoSuchImportMasterEntityException {

		ImportMasterEntity importMasterEntity = fetchByPrimaryKey(primaryKey);

		if (importMasterEntity == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchImportMasterEntityException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return importMasterEntity;
	}

	/**
	 * Returns the import master entity with the primary key or throws a <code>NoSuchImportMasterEntityException</code> if it could not be found.
	 *
	 * @param importMasterEntityId the primary key of the import master entity
	 * @return the import master entity
	 * @throws NoSuchImportMasterEntityException if a import master entity with the primary key could not be found
	 */
	@Override
	public ImportMasterEntity findByPrimaryKey(long importMasterEntityId)
		throws NoSuchImportMasterEntityException {

		return findByPrimaryKey((Serializable)importMasterEntityId);
	}

	/**
	 * Returns the import master entity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param importMasterEntityId the primary key of the import master entity
	 * @return the import master entity, or <code>null</code> if a import master entity with the primary key could not be found
	 */
	@Override
	public ImportMasterEntity fetchByPrimaryKey(long importMasterEntityId) {
		return fetchByPrimaryKey((Serializable)importMasterEntityId);
	}

	/**
	 * Returns all the import master entities.
	 *
	 * @return the import master entities
	 */
	@Override
	public List<ImportMasterEntity> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the import master entities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImportMasterEntityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of import master entities
	 * @param end the upper bound of the range of import master entities (not inclusive)
	 * @return the range of import master entities
	 */
	@Override
	public List<ImportMasterEntity> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the import master entities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImportMasterEntityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of import master entities
	 * @param end the upper bound of the range of import master entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of import master entities
	 */
	@Override
	public List<ImportMasterEntity> findAll(
		int start, int end,
		OrderByComparator<ImportMasterEntity> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the import master entities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImportMasterEntityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of import master entities
	 * @param end the upper bound of the range of import master entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of import master entities
	 */
	@Override
	public List<ImportMasterEntity> findAll(
		int start, int end,
		OrderByComparator<ImportMasterEntity> orderByComparator,
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

		List<ImportMasterEntity> list = null;

		if (useFinderCache) {
			list = (List<ImportMasterEntity>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_IMPORTMASTERENTITY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_IMPORTMASTERENTITY;

				sql = sql.concat(ImportMasterEntityModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ImportMasterEntity>)QueryUtil.list(
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
	 * Removes all the import master entities from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ImportMasterEntity importMasterEntity : findAll()) {
			remove(importMasterEntity);
		}
	}

	/**
	 * Returns the number of import master entities.
	 *
	 * @return the number of import master entities
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
					_SQL_COUNT_IMPORTMASTERENTITY);

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
		return "importMasterEntityId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_IMPORTMASTERENTITY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ImportMasterEntityModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the import master entity persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new ImportMasterEntityModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", ImportMasterEntity.class.getName()));

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
		entityCache.removeCache(ImportMasterEntityImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	@Override
	@Reference(
		target = jetformPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = jetformPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = jetformPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_IMPORTMASTERENTITY =
		"SELECT importMasterEntity FROM ImportMasterEntity importMasterEntity";

	private static final String _SQL_COUNT_IMPORTMASTERENTITY =
		"SELECT COUNT(importMasterEntity) FROM ImportMasterEntity importMasterEntity";

	private static final String _ORDER_BY_ENTITY_ALIAS = "importMasterEntity.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ImportMasterEntity exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		ImportMasterEntityPersistenceImpl.class);

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

	private static class ImportMasterEntityModelArgumentsResolver
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

			ImportMasterEntityModelImpl importMasterEntityModelImpl =
				(ImportMasterEntityModelImpl)baseModel;

			long columnBitmask = importMasterEntityModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					importMasterEntityModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						importMasterEntityModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					importMasterEntityModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			ImportMasterEntityModelImpl importMasterEntityModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						importMasterEntityModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = importMasterEntityModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}