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

import com.adjecti.mdm.liferay.exception.NoSuchSubjectOfQualificationException;
import com.adjecti.mdm.liferay.model.SubjectOfQualification;
import com.adjecti.mdm.liferay.model.impl.SubjectOfQualificationImpl;
import com.adjecti.mdm.liferay.model.impl.SubjectOfQualificationModelImpl;
import com.adjecti.mdm.liferay.service.persistence.SubjectOfQualificationPersistence;
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
 * The persistence implementation for the subject of qualification service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = SubjectOfQualificationPersistence.class)
public class SubjectOfQualificationPersistenceImpl
	extends BasePersistenceImpl<SubjectOfQualification>
	implements SubjectOfQualificationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SubjectOfQualificationUtil</code> to access the subject of qualification persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SubjectOfQualificationImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public SubjectOfQualificationPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("code", "code_");

		setDBColumnNames(dbColumnNames);

		setModelClass(SubjectOfQualification.class);

		setModelImplClass(SubjectOfQualificationImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the subject of qualification in the entity cache if it is enabled.
	 *
	 * @param subjectOfQualification the subject of qualification
	 */
	@Override
	public void cacheResult(SubjectOfQualification subjectOfQualification) {
		entityCache.putResult(
			SubjectOfQualificationImpl.class,
			subjectOfQualification.getPrimaryKey(), subjectOfQualification);
	}

	/**
	 * Caches the subject of qualifications in the entity cache if it is enabled.
	 *
	 * @param subjectOfQualifications the subject of qualifications
	 */
	@Override
	public void cacheResult(
		List<SubjectOfQualification> subjectOfQualifications) {

		for (SubjectOfQualification subjectOfQualification :
				subjectOfQualifications) {

			if (entityCache.getResult(
					SubjectOfQualificationImpl.class,
					subjectOfQualification.getPrimaryKey()) == null) {

				cacheResult(subjectOfQualification);
			}
		}
	}

	/**
	 * Clears the cache for all subject of qualifications.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SubjectOfQualificationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the subject of qualification.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SubjectOfQualification subjectOfQualification) {
		entityCache.removeResult(
			SubjectOfQualificationImpl.class, subjectOfQualification);
	}

	@Override
	public void clearCache(
		List<SubjectOfQualification> subjectOfQualifications) {

		for (SubjectOfQualification subjectOfQualification :
				subjectOfQualifications) {

			entityCache.removeResult(
				SubjectOfQualificationImpl.class, subjectOfQualification);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				SubjectOfQualificationImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new subject of qualification with the primary key. Does not add the subject of qualification to the database.
	 *
	 * @param subjectOfQualificationId the primary key for the new subject of qualification
	 * @return the new subject of qualification
	 */
	@Override
	public SubjectOfQualification create(long subjectOfQualificationId) {
		SubjectOfQualification subjectOfQualification =
			new SubjectOfQualificationImpl();

		subjectOfQualification.setNew(true);
		subjectOfQualification.setPrimaryKey(subjectOfQualificationId);

		subjectOfQualification.setCompanyId(CompanyThreadLocal.getCompanyId());

		return subjectOfQualification;
	}

	/**
	 * Removes the subject of qualification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param subjectOfQualificationId the primary key of the subject of qualification
	 * @return the subject of qualification that was removed
	 * @throws NoSuchSubjectOfQualificationException if a subject of qualification with the primary key could not be found
	 */
	@Override
	public SubjectOfQualification remove(long subjectOfQualificationId)
		throws NoSuchSubjectOfQualificationException {

		return remove((Serializable)subjectOfQualificationId);
	}

	/**
	 * Removes the subject of qualification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the subject of qualification
	 * @return the subject of qualification that was removed
	 * @throws NoSuchSubjectOfQualificationException if a subject of qualification with the primary key could not be found
	 */
	@Override
	public SubjectOfQualification remove(Serializable primaryKey)
		throws NoSuchSubjectOfQualificationException {

		Session session = null;

		try {
			session = openSession();

			SubjectOfQualification subjectOfQualification =
				(SubjectOfQualification)session.get(
					SubjectOfQualificationImpl.class, primaryKey);

			if (subjectOfQualification == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSubjectOfQualificationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(subjectOfQualification);
		}
		catch (NoSuchSubjectOfQualificationException noSuchEntityException) {
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
	protected SubjectOfQualification removeImpl(
		SubjectOfQualification subjectOfQualification) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(subjectOfQualification)) {
				subjectOfQualification = (SubjectOfQualification)session.get(
					SubjectOfQualificationImpl.class,
					subjectOfQualification.getPrimaryKeyObj());
			}

			if (subjectOfQualification != null) {
				session.delete(subjectOfQualification);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (subjectOfQualification != null) {
			clearCache(subjectOfQualification);
		}

		return subjectOfQualification;
	}

	@Override
	public SubjectOfQualification updateImpl(
		SubjectOfQualification subjectOfQualification) {

		boolean isNew = subjectOfQualification.isNew();

		if (!(subjectOfQualification instanceof
				SubjectOfQualificationModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(subjectOfQualification.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					subjectOfQualification);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in subjectOfQualification proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SubjectOfQualification implementation " +
					subjectOfQualification.getClass());
		}

		SubjectOfQualificationModelImpl subjectOfQualificationModelImpl =
			(SubjectOfQualificationModelImpl)subjectOfQualification;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (subjectOfQualification.getCreateDate() == null)) {
			if (serviceContext == null) {
				subjectOfQualification.setCreateDate(now);
			}
			else {
				subjectOfQualification.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!subjectOfQualificationModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				subjectOfQualification.setModifiedDate(now);
			}
			else {
				subjectOfQualification.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(subjectOfQualification);
			}
			else {
				subjectOfQualification = (SubjectOfQualification)session.merge(
					subjectOfQualification);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			SubjectOfQualificationImpl.class, subjectOfQualification, false,
			true);

		if (isNew) {
			subjectOfQualification.setNew(false);
		}

		subjectOfQualification.resetOriginalValues();

		return subjectOfQualification;
	}

	/**
	 * Returns the subject of qualification with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the subject of qualification
	 * @return the subject of qualification
	 * @throws NoSuchSubjectOfQualificationException if a subject of qualification with the primary key could not be found
	 */
	@Override
	public SubjectOfQualification findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSubjectOfQualificationException {

		SubjectOfQualification subjectOfQualification = fetchByPrimaryKey(
			primaryKey);

		if (subjectOfQualification == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSubjectOfQualificationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return subjectOfQualification;
	}

	/**
	 * Returns the subject of qualification with the primary key or throws a <code>NoSuchSubjectOfQualificationException</code> if it could not be found.
	 *
	 * @param subjectOfQualificationId the primary key of the subject of qualification
	 * @return the subject of qualification
	 * @throws NoSuchSubjectOfQualificationException if a subject of qualification with the primary key could not be found
	 */
	@Override
	public SubjectOfQualification findByPrimaryKey(
			long subjectOfQualificationId)
		throws NoSuchSubjectOfQualificationException {

		return findByPrimaryKey((Serializable)subjectOfQualificationId);
	}

	/**
	 * Returns the subject of qualification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param subjectOfQualificationId the primary key of the subject of qualification
	 * @return the subject of qualification, or <code>null</code> if a subject of qualification with the primary key could not be found
	 */
	@Override
	public SubjectOfQualification fetchByPrimaryKey(
		long subjectOfQualificationId) {

		return fetchByPrimaryKey((Serializable)subjectOfQualificationId);
	}

	/**
	 * Returns all the subject of qualifications.
	 *
	 * @return the subject of qualifications
	 */
	@Override
	public List<SubjectOfQualification> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the subject of qualifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubjectOfQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of subject of qualifications
	 * @param end the upper bound of the range of subject of qualifications (not inclusive)
	 * @return the range of subject of qualifications
	 */
	@Override
	public List<SubjectOfQualification> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the subject of qualifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubjectOfQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of subject of qualifications
	 * @param end the upper bound of the range of subject of qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of subject of qualifications
	 */
	@Override
	public List<SubjectOfQualification> findAll(
		int start, int end,
		OrderByComparator<SubjectOfQualification> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the subject of qualifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubjectOfQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of subject of qualifications
	 * @param end the upper bound of the range of subject of qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of subject of qualifications
	 */
	@Override
	public List<SubjectOfQualification> findAll(
		int start, int end,
		OrderByComparator<SubjectOfQualification> orderByComparator,
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

		List<SubjectOfQualification> list = null;

		if (useFinderCache) {
			list = (List<SubjectOfQualification>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SUBJECTOFQUALIFICATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SUBJECTOFQUALIFICATION;

				sql = sql.concat(SubjectOfQualificationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SubjectOfQualification>)QueryUtil.list(
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
	 * Removes all the subject of qualifications from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SubjectOfQualification subjectOfQualification : findAll()) {
			remove(subjectOfQualification);
		}
	}

	/**
	 * Returns the number of subject of qualifications.
	 *
	 * @return the number of subject of qualifications
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
					_SQL_COUNT_SUBJECTOFQUALIFICATION);

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
		return "subjectOfQualificationId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SUBJECTOFQUALIFICATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SubjectOfQualificationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the subject of qualification persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new SubjectOfQualificationModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", SubjectOfQualification.class.getName()));

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
		entityCache.removeCache(SubjectOfQualificationImpl.class.getName());

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

	private static final String _SQL_SELECT_SUBJECTOFQUALIFICATION =
		"SELECT subjectOfQualification FROM SubjectOfQualification subjectOfQualification";

	private static final String _SQL_COUNT_SUBJECTOFQUALIFICATION =
		"SELECT COUNT(subjectOfQualification) FROM SubjectOfQualification subjectOfQualification";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"subjectOfQualification.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SubjectOfQualification exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		SubjectOfQualificationPersistenceImpl.class);

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

	private static class SubjectOfQualificationModelArgumentsResolver
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

			SubjectOfQualificationModelImpl subjectOfQualificationModelImpl =
				(SubjectOfQualificationModelImpl)baseModel;

			long columnBitmask =
				subjectOfQualificationModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					subjectOfQualificationModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						subjectOfQualificationModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					subjectOfQualificationModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			SubjectOfQualificationModelImpl subjectOfQualificationModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						subjectOfQualificationModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] =
						subjectOfQualificationModelImpl.getColumnValue(
							columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}