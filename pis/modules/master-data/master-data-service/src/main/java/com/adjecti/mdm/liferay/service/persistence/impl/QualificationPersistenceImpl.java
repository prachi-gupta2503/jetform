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

import com.adjecti.mdm.liferay.exception.NoSuchQualificationException;
import com.adjecti.mdm.liferay.model.Qualification;
import com.adjecti.mdm.liferay.model.impl.QualificationImpl;
import com.adjecti.mdm.liferay.model.impl.QualificationModelImpl;
import com.adjecti.mdm.liferay.service.persistence.QualificationPersistence;
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
 * The persistence implementation for the qualification service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = QualificationPersistence.class)
public class QualificationPersistenceImpl
	extends BasePersistenceImpl<Qualification>
	implements QualificationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>QualificationUtil</code> to access the qualification persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		QualificationImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public QualificationPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("code", "code_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Qualification.class);

		setModelImplClass(QualificationImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the qualification in the entity cache if it is enabled.
	 *
	 * @param qualification the qualification
	 */
	@Override
	public void cacheResult(Qualification qualification) {
		entityCache.putResult(
			QualificationImpl.class, qualification.getPrimaryKey(),
			qualification);
	}

	/**
	 * Caches the qualifications in the entity cache if it is enabled.
	 *
	 * @param qualifications the qualifications
	 */
	@Override
	public void cacheResult(List<Qualification> qualifications) {
		for (Qualification qualification : qualifications) {
			if (entityCache.getResult(
					QualificationImpl.class, qualification.getPrimaryKey()) ==
						null) {

				cacheResult(qualification);
			}
		}
	}

	/**
	 * Clears the cache for all qualifications.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(QualificationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the qualification.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Qualification qualification) {
		entityCache.removeResult(QualificationImpl.class, qualification);
	}

	@Override
	public void clearCache(List<Qualification> qualifications) {
		for (Qualification qualification : qualifications) {
			entityCache.removeResult(QualificationImpl.class, qualification);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(QualificationImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new qualification with the primary key. Does not add the qualification to the database.
	 *
	 * @param qualificationId the primary key for the new qualification
	 * @return the new qualification
	 */
	@Override
	public Qualification create(long qualificationId) {
		Qualification qualification = new QualificationImpl();

		qualification.setNew(true);
		qualification.setPrimaryKey(qualificationId);

		qualification.setCompanyId(CompanyThreadLocal.getCompanyId());

		return qualification;
	}

	/**
	 * Removes the qualification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param qualificationId the primary key of the qualification
	 * @return the qualification that was removed
	 * @throws NoSuchQualificationException if a qualification with the primary key could not be found
	 */
	@Override
	public Qualification remove(long qualificationId)
		throws NoSuchQualificationException {

		return remove((Serializable)qualificationId);
	}

	/**
	 * Removes the qualification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the qualification
	 * @return the qualification that was removed
	 * @throws NoSuchQualificationException if a qualification with the primary key could not be found
	 */
	@Override
	public Qualification remove(Serializable primaryKey)
		throws NoSuchQualificationException {

		Session session = null;

		try {
			session = openSession();

			Qualification qualification = (Qualification)session.get(
				QualificationImpl.class, primaryKey);

			if (qualification == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchQualificationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(qualification);
		}
		catch (NoSuchQualificationException noSuchEntityException) {
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
	protected Qualification removeImpl(Qualification qualification) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(qualification)) {
				qualification = (Qualification)session.get(
					QualificationImpl.class, qualification.getPrimaryKeyObj());
			}

			if (qualification != null) {
				session.delete(qualification);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (qualification != null) {
			clearCache(qualification);
		}

		return qualification;
	}

	@Override
	public Qualification updateImpl(Qualification qualification) {
		boolean isNew = qualification.isNew();

		if (!(qualification instanceof QualificationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(qualification.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					qualification);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in qualification proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Qualification implementation " +
					qualification.getClass());
		}

		QualificationModelImpl qualificationModelImpl =
			(QualificationModelImpl)qualification;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (qualification.getCreateDate() == null)) {
			if (serviceContext == null) {
				qualification.setCreateDate(now);
			}
			else {
				qualification.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!qualificationModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				qualification.setModifiedDate(now);
			}
			else {
				qualification.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(qualification);
			}
			else {
				qualification = (Qualification)session.merge(qualification);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			QualificationImpl.class, qualification, false, true);

		if (isNew) {
			qualification.setNew(false);
		}

		qualification.resetOriginalValues();

		return qualification;
	}

	/**
	 * Returns the qualification with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the qualification
	 * @return the qualification
	 * @throws NoSuchQualificationException if a qualification with the primary key could not be found
	 */
	@Override
	public Qualification findByPrimaryKey(Serializable primaryKey)
		throws NoSuchQualificationException {

		Qualification qualification = fetchByPrimaryKey(primaryKey);

		if (qualification == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchQualificationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return qualification;
	}

	/**
	 * Returns the qualification with the primary key or throws a <code>NoSuchQualificationException</code> if it could not be found.
	 *
	 * @param qualificationId the primary key of the qualification
	 * @return the qualification
	 * @throws NoSuchQualificationException if a qualification with the primary key could not be found
	 */
	@Override
	public Qualification findByPrimaryKey(long qualificationId)
		throws NoSuchQualificationException {

		return findByPrimaryKey((Serializable)qualificationId);
	}

	/**
	 * Returns the qualification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param qualificationId the primary key of the qualification
	 * @return the qualification, or <code>null</code> if a qualification with the primary key could not be found
	 */
	@Override
	public Qualification fetchByPrimaryKey(long qualificationId) {
		return fetchByPrimaryKey((Serializable)qualificationId);
	}

	/**
	 * Returns all the qualifications.
	 *
	 * @return the qualifications
	 */
	@Override
	public List<Qualification> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the qualifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of qualifications
	 * @param end the upper bound of the range of qualifications (not inclusive)
	 * @return the range of qualifications
	 */
	@Override
	public List<Qualification> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the qualifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of qualifications
	 * @param end the upper bound of the range of qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of qualifications
	 */
	@Override
	public List<Qualification> findAll(
		int start, int end,
		OrderByComparator<Qualification> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the qualifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of qualifications
	 * @param end the upper bound of the range of qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of qualifications
	 */
	@Override
	public List<Qualification> findAll(
		int start, int end, OrderByComparator<Qualification> orderByComparator,
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

		List<Qualification> list = null;

		if (useFinderCache) {
			list = (List<Qualification>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_QUALIFICATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_QUALIFICATION;

				sql = sql.concat(QualificationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Qualification>)QueryUtil.list(
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
	 * Removes all the qualifications from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Qualification qualification : findAll()) {
			remove(qualification);
		}
	}

	/**
	 * Returns the number of qualifications.
	 *
	 * @return the number of qualifications
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_QUALIFICATION);

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
		return "qualificationId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_QUALIFICATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return QualificationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the qualification persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new QualificationModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", Qualification.class.getName()));

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
		entityCache.removeCache(QualificationImpl.class.getName());

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

	private static final String _SQL_SELECT_QUALIFICATION =
		"SELECT qualification FROM Qualification qualification";

	private static final String _SQL_COUNT_QUALIFICATION =
		"SELECT COUNT(qualification) FROM Qualification qualification";

	private static final String _ORDER_BY_ENTITY_ALIAS = "qualification.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Qualification exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		QualificationPersistenceImpl.class);

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

	private static class QualificationModelArgumentsResolver
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

			QualificationModelImpl qualificationModelImpl =
				(QualificationModelImpl)baseModel;

			long columnBitmask = qualificationModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(qualificationModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						qualificationModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(qualificationModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			QualificationModelImpl qualificationModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						qualificationModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = qualificationModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}