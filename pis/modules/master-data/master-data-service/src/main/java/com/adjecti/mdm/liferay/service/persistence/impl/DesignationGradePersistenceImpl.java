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

import com.adjecti.mdm.liferay.exception.NoSuchDesignationGradeException;
import com.adjecti.mdm.liferay.model.DesignationGrade;
import com.adjecti.mdm.liferay.model.impl.DesignationGradeImpl;
import com.adjecti.mdm.liferay.model.impl.DesignationGradeModelImpl;
import com.adjecti.mdm.liferay.service.persistence.DesignationGradePersistence;
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
 * The persistence implementation for the designation grade service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DesignationGradePersistence.class)
public class DesignationGradePersistenceImpl
	extends BasePersistenceImpl<DesignationGrade>
	implements DesignationGradePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DesignationGradeUtil</code> to access the designation grade persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DesignationGradeImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public DesignationGradePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("code", "code_");

		setDBColumnNames(dbColumnNames);

		setModelClass(DesignationGrade.class);

		setModelImplClass(DesignationGradeImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the designation grade in the entity cache if it is enabled.
	 *
	 * @param designationGrade the designation grade
	 */
	@Override
	public void cacheResult(DesignationGrade designationGrade) {
		entityCache.putResult(
			DesignationGradeImpl.class, designationGrade.getPrimaryKey(),
			designationGrade);
	}

	/**
	 * Caches the designation grades in the entity cache if it is enabled.
	 *
	 * @param designationGrades the designation grades
	 */
	@Override
	public void cacheResult(List<DesignationGrade> designationGrades) {
		for (DesignationGrade designationGrade : designationGrades) {
			if (entityCache.getResult(
					DesignationGradeImpl.class,
					designationGrade.getPrimaryKey()) == null) {

				cacheResult(designationGrade);
			}
		}
	}

	/**
	 * Clears the cache for all designation grades.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DesignationGradeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the designation grade.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DesignationGrade designationGrade) {
		entityCache.removeResult(DesignationGradeImpl.class, designationGrade);
	}

	@Override
	public void clearCache(List<DesignationGrade> designationGrades) {
		for (DesignationGrade designationGrade : designationGrades) {
			entityCache.removeResult(
				DesignationGradeImpl.class, designationGrade);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DesignationGradeImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new designation grade with the primary key. Does not add the designation grade to the database.
	 *
	 * @param designationGradeId the primary key for the new designation grade
	 * @return the new designation grade
	 */
	@Override
	public DesignationGrade create(long designationGradeId) {
		DesignationGrade designationGrade = new DesignationGradeImpl();

		designationGrade.setNew(true);
		designationGrade.setPrimaryKey(designationGradeId);

		designationGrade.setCompanyId(CompanyThreadLocal.getCompanyId());

		return designationGrade;
	}

	/**
	 * Removes the designation grade with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param designationGradeId the primary key of the designation grade
	 * @return the designation grade that was removed
	 * @throws NoSuchDesignationGradeException if a designation grade with the primary key could not be found
	 */
	@Override
	public DesignationGrade remove(long designationGradeId)
		throws NoSuchDesignationGradeException {

		return remove((Serializable)designationGradeId);
	}

	/**
	 * Removes the designation grade with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the designation grade
	 * @return the designation grade that was removed
	 * @throws NoSuchDesignationGradeException if a designation grade with the primary key could not be found
	 */
	@Override
	public DesignationGrade remove(Serializable primaryKey)
		throws NoSuchDesignationGradeException {

		Session session = null;

		try {
			session = openSession();

			DesignationGrade designationGrade = (DesignationGrade)session.get(
				DesignationGradeImpl.class, primaryKey);

			if (designationGrade == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDesignationGradeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(designationGrade);
		}
		catch (NoSuchDesignationGradeException noSuchEntityException) {
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
	protected DesignationGrade removeImpl(DesignationGrade designationGrade) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(designationGrade)) {
				designationGrade = (DesignationGrade)session.get(
					DesignationGradeImpl.class,
					designationGrade.getPrimaryKeyObj());
			}

			if (designationGrade != null) {
				session.delete(designationGrade);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (designationGrade != null) {
			clearCache(designationGrade);
		}

		return designationGrade;
	}

	@Override
	public DesignationGrade updateImpl(DesignationGrade designationGrade) {
		boolean isNew = designationGrade.isNew();

		if (!(designationGrade instanceof DesignationGradeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(designationGrade.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					designationGrade);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in designationGrade proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DesignationGrade implementation " +
					designationGrade.getClass());
		}

		DesignationGradeModelImpl designationGradeModelImpl =
			(DesignationGradeModelImpl)designationGrade;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (designationGrade.getCreateDate() == null)) {
			if (serviceContext == null) {
				designationGrade.setCreateDate(now);
			}
			else {
				designationGrade.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!designationGradeModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				designationGrade.setModifiedDate(now);
			}
			else {
				designationGrade.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(designationGrade);
			}
			else {
				designationGrade = (DesignationGrade)session.merge(
					designationGrade);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DesignationGradeImpl.class, designationGrade, false, true);

		if (isNew) {
			designationGrade.setNew(false);
		}

		designationGrade.resetOriginalValues();

		return designationGrade;
	}

	/**
	 * Returns the designation grade with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the designation grade
	 * @return the designation grade
	 * @throws NoSuchDesignationGradeException if a designation grade with the primary key could not be found
	 */
	@Override
	public DesignationGrade findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDesignationGradeException {

		DesignationGrade designationGrade = fetchByPrimaryKey(primaryKey);

		if (designationGrade == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDesignationGradeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return designationGrade;
	}

	/**
	 * Returns the designation grade with the primary key or throws a <code>NoSuchDesignationGradeException</code> if it could not be found.
	 *
	 * @param designationGradeId the primary key of the designation grade
	 * @return the designation grade
	 * @throws NoSuchDesignationGradeException if a designation grade with the primary key could not be found
	 */
	@Override
	public DesignationGrade findByPrimaryKey(long designationGradeId)
		throws NoSuchDesignationGradeException {

		return findByPrimaryKey((Serializable)designationGradeId);
	}

	/**
	 * Returns the designation grade with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param designationGradeId the primary key of the designation grade
	 * @return the designation grade, or <code>null</code> if a designation grade with the primary key could not be found
	 */
	@Override
	public DesignationGrade fetchByPrimaryKey(long designationGradeId) {
		return fetchByPrimaryKey((Serializable)designationGradeId);
	}

	/**
	 * Returns all the designation grades.
	 *
	 * @return the designation grades
	 */
	@Override
	public List<DesignationGrade> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the designation grades.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationGradeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation grades
	 * @param end the upper bound of the range of designation grades (not inclusive)
	 * @return the range of designation grades
	 */
	@Override
	public List<DesignationGrade> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the designation grades.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationGradeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation grades
	 * @param end the upper bound of the range of designation grades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of designation grades
	 */
	@Override
	public List<DesignationGrade> findAll(
		int start, int end,
		OrderByComparator<DesignationGrade> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the designation grades.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationGradeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation grades
	 * @param end the upper bound of the range of designation grades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of designation grades
	 */
	@Override
	public List<DesignationGrade> findAll(
		int start, int end,
		OrderByComparator<DesignationGrade> orderByComparator,
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

		List<DesignationGrade> list = null;

		if (useFinderCache) {
			list = (List<DesignationGrade>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DESIGNATIONGRADE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DESIGNATIONGRADE;

				sql = sql.concat(DesignationGradeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DesignationGrade>)QueryUtil.list(
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
	 * Removes all the designation grades from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DesignationGrade designationGrade : findAll()) {
			remove(designationGrade);
		}
	}

	/**
	 * Returns the number of designation grades.
	 *
	 * @return the number of designation grades
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DESIGNATIONGRADE);

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
		return "designationGradeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DESIGNATIONGRADE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DesignationGradeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the designation grade persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new DesignationGradeModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", DesignationGrade.class.getName()));

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
		entityCache.removeCache(DesignationGradeImpl.class.getName());

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

	private static final String _SQL_SELECT_DESIGNATIONGRADE =
		"SELECT designationGrade FROM DesignationGrade designationGrade";

	private static final String _SQL_COUNT_DESIGNATIONGRADE =
		"SELECT COUNT(designationGrade) FROM DesignationGrade designationGrade";

	private static final String _ORDER_BY_ENTITY_ALIAS = "designationGrade.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DesignationGrade exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		DesignationGradePersistenceImpl.class);

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

	private static class DesignationGradeModelArgumentsResolver
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

			DesignationGradeModelImpl designationGradeModelImpl =
				(DesignationGradeModelImpl)baseModel;

			long columnBitmask = designationGradeModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					designationGradeModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						designationGradeModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					designationGradeModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			DesignationGradeModelImpl designationGradeModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						designationGradeModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = designationGradeModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}