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

import com.adjecti.mdm.liferay.exception.NoSuchSubjectOfTrainingException;
import com.adjecti.mdm.liferay.model.SubjectOfTraining;
import com.adjecti.mdm.liferay.model.impl.SubjectOfTrainingImpl;
import com.adjecti.mdm.liferay.model.impl.SubjectOfTrainingModelImpl;
import com.adjecti.mdm.liferay.service.persistence.SubjectOfTrainingPersistence;
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
 * The persistence implementation for the subject of training service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = SubjectOfTrainingPersistence.class)
public class SubjectOfTrainingPersistenceImpl
	extends BasePersistenceImpl<SubjectOfTraining>
	implements SubjectOfTrainingPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SubjectOfTrainingUtil</code> to access the subject of training persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SubjectOfTrainingImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public SubjectOfTrainingPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("code", "code_");

		setDBColumnNames(dbColumnNames);

		setModelClass(SubjectOfTraining.class);

		setModelImplClass(SubjectOfTrainingImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the subject of training in the entity cache if it is enabled.
	 *
	 * @param subjectOfTraining the subject of training
	 */
	@Override
	public void cacheResult(SubjectOfTraining subjectOfTraining) {
		entityCache.putResult(
			SubjectOfTrainingImpl.class, subjectOfTraining.getPrimaryKey(),
			subjectOfTraining);
	}

	/**
	 * Caches the subject of trainings in the entity cache if it is enabled.
	 *
	 * @param subjectOfTrainings the subject of trainings
	 */
	@Override
	public void cacheResult(List<SubjectOfTraining> subjectOfTrainings) {
		for (SubjectOfTraining subjectOfTraining : subjectOfTrainings) {
			if (entityCache.getResult(
					SubjectOfTrainingImpl.class,
					subjectOfTraining.getPrimaryKey()) == null) {

				cacheResult(subjectOfTraining);
			}
		}
	}

	/**
	 * Clears the cache for all subject of trainings.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SubjectOfTrainingImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the subject of training.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SubjectOfTraining subjectOfTraining) {
		entityCache.removeResult(
			SubjectOfTrainingImpl.class, subjectOfTraining);
	}

	@Override
	public void clearCache(List<SubjectOfTraining> subjectOfTrainings) {
		for (SubjectOfTraining subjectOfTraining : subjectOfTrainings) {
			entityCache.removeResult(
				SubjectOfTrainingImpl.class, subjectOfTraining);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SubjectOfTrainingImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new subject of training with the primary key. Does not add the subject of training to the database.
	 *
	 * @param subjectOfTrainingId the primary key for the new subject of training
	 * @return the new subject of training
	 */
	@Override
	public SubjectOfTraining create(long subjectOfTrainingId) {
		SubjectOfTraining subjectOfTraining = new SubjectOfTrainingImpl();

		subjectOfTraining.setNew(true);
		subjectOfTraining.setPrimaryKey(subjectOfTrainingId);

		subjectOfTraining.setCompanyId(CompanyThreadLocal.getCompanyId());

		return subjectOfTraining;
	}

	/**
	 * Removes the subject of training with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param subjectOfTrainingId the primary key of the subject of training
	 * @return the subject of training that was removed
	 * @throws NoSuchSubjectOfTrainingException if a subject of training with the primary key could not be found
	 */
	@Override
	public SubjectOfTraining remove(long subjectOfTrainingId)
		throws NoSuchSubjectOfTrainingException {

		return remove((Serializable)subjectOfTrainingId);
	}

	/**
	 * Removes the subject of training with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the subject of training
	 * @return the subject of training that was removed
	 * @throws NoSuchSubjectOfTrainingException if a subject of training with the primary key could not be found
	 */
	@Override
	public SubjectOfTraining remove(Serializable primaryKey)
		throws NoSuchSubjectOfTrainingException {

		Session session = null;

		try {
			session = openSession();

			SubjectOfTraining subjectOfTraining =
				(SubjectOfTraining)session.get(
					SubjectOfTrainingImpl.class, primaryKey);

			if (subjectOfTraining == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSubjectOfTrainingException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(subjectOfTraining);
		}
		catch (NoSuchSubjectOfTrainingException noSuchEntityException) {
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
	protected SubjectOfTraining removeImpl(
		SubjectOfTraining subjectOfTraining) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(subjectOfTraining)) {
				subjectOfTraining = (SubjectOfTraining)session.get(
					SubjectOfTrainingImpl.class,
					subjectOfTraining.getPrimaryKeyObj());
			}

			if (subjectOfTraining != null) {
				session.delete(subjectOfTraining);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (subjectOfTraining != null) {
			clearCache(subjectOfTraining);
		}

		return subjectOfTraining;
	}

	@Override
	public SubjectOfTraining updateImpl(SubjectOfTraining subjectOfTraining) {
		boolean isNew = subjectOfTraining.isNew();

		if (!(subjectOfTraining instanceof SubjectOfTrainingModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(subjectOfTraining.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					subjectOfTraining);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in subjectOfTraining proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SubjectOfTraining implementation " +
					subjectOfTraining.getClass());
		}

		SubjectOfTrainingModelImpl subjectOfTrainingModelImpl =
			(SubjectOfTrainingModelImpl)subjectOfTraining;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (subjectOfTraining.getCreateDate() == null)) {
			if (serviceContext == null) {
				subjectOfTraining.setCreateDate(now);
			}
			else {
				subjectOfTraining.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!subjectOfTrainingModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				subjectOfTraining.setModifiedDate(now);
			}
			else {
				subjectOfTraining.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(subjectOfTraining);
			}
			else {
				subjectOfTraining = (SubjectOfTraining)session.merge(
					subjectOfTraining);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			SubjectOfTrainingImpl.class, subjectOfTraining, false, true);

		if (isNew) {
			subjectOfTraining.setNew(false);
		}

		subjectOfTraining.resetOriginalValues();

		return subjectOfTraining;
	}

	/**
	 * Returns the subject of training with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the subject of training
	 * @return the subject of training
	 * @throws NoSuchSubjectOfTrainingException if a subject of training with the primary key could not be found
	 */
	@Override
	public SubjectOfTraining findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSubjectOfTrainingException {

		SubjectOfTraining subjectOfTraining = fetchByPrimaryKey(primaryKey);

		if (subjectOfTraining == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSubjectOfTrainingException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return subjectOfTraining;
	}

	/**
	 * Returns the subject of training with the primary key or throws a <code>NoSuchSubjectOfTrainingException</code> if it could not be found.
	 *
	 * @param subjectOfTrainingId the primary key of the subject of training
	 * @return the subject of training
	 * @throws NoSuchSubjectOfTrainingException if a subject of training with the primary key could not be found
	 */
	@Override
	public SubjectOfTraining findByPrimaryKey(long subjectOfTrainingId)
		throws NoSuchSubjectOfTrainingException {

		return findByPrimaryKey((Serializable)subjectOfTrainingId);
	}

	/**
	 * Returns the subject of training with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param subjectOfTrainingId the primary key of the subject of training
	 * @return the subject of training, or <code>null</code> if a subject of training with the primary key could not be found
	 */
	@Override
	public SubjectOfTraining fetchByPrimaryKey(long subjectOfTrainingId) {
		return fetchByPrimaryKey((Serializable)subjectOfTrainingId);
	}

	/**
	 * Returns all the subject of trainings.
	 *
	 * @return the subject of trainings
	 */
	@Override
	public List<SubjectOfTraining> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the subject of trainings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubjectOfTrainingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of subject of trainings
	 * @param end the upper bound of the range of subject of trainings (not inclusive)
	 * @return the range of subject of trainings
	 */
	@Override
	public List<SubjectOfTraining> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the subject of trainings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubjectOfTrainingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of subject of trainings
	 * @param end the upper bound of the range of subject of trainings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of subject of trainings
	 */
	@Override
	public List<SubjectOfTraining> findAll(
		int start, int end,
		OrderByComparator<SubjectOfTraining> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the subject of trainings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubjectOfTrainingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of subject of trainings
	 * @param end the upper bound of the range of subject of trainings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of subject of trainings
	 */
	@Override
	public List<SubjectOfTraining> findAll(
		int start, int end,
		OrderByComparator<SubjectOfTraining> orderByComparator,
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

		List<SubjectOfTraining> list = null;

		if (useFinderCache) {
			list = (List<SubjectOfTraining>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SUBJECTOFTRAINING);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SUBJECTOFTRAINING;

				sql = sql.concat(SubjectOfTrainingModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SubjectOfTraining>)QueryUtil.list(
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
	 * Removes all the subject of trainings from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SubjectOfTraining subjectOfTraining : findAll()) {
			remove(subjectOfTraining);
		}
	}

	/**
	 * Returns the number of subject of trainings.
	 *
	 * @return the number of subject of trainings
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SUBJECTOFTRAINING);

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
		return "subjectOfTrainingId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SUBJECTOFTRAINING;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SubjectOfTrainingModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the subject of training persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new SubjectOfTrainingModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", SubjectOfTraining.class.getName()));

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
		entityCache.removeCache(SubjectOfTrainingImpl.class.getName());

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

	private static final String _SQL_SELECT_SUBJECTOFTRAINING =
		"SELECT subjectOfTraining FROM SubjectOfTraining subjectOfTraining";

	private static final String _SQL_COUNT_SUBJECTOFTRAINING =
		"SELECT COUNT(subjectOfTraining) FROM SubjectOfTraining subjectOfTraining";

	private static final String _ORDER_BY_ENTITY_ALIAS = "subjectOfTraining.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SubjectOfTraining exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		SubjectOfTrainingPersistenceImpl.class);

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

	private static class SubjectOfTrainingModelArgumentsResolver
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

			SubjectOfTrainingModelImpl subjectOfTrainingModelImpl =
				(SubjectOfTrainingModelImpl)baseModel;

			long columnBitmask = subjectOfTrainingModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					subjectOfTrainingModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						subjectOfTrainingModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					subjectOfTrainingModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			SubjectOfTrainingModelImpl subjectOfTrainingModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						subjectOfTrainingModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = subjectOfTrainingModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}