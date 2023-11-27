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

package net.ayudh.audit.service.persistence.impl;

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
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import net.ayudh.audit.exception.NoSuchAuditEventArchiveException;
import net.ayudh.audit.model.AuditEventArchive;
import net.ayudh.audit.model.impl.AuditEventArchiveImpl;
import net.ayudh.audit.model.impl.AuditEventArchiveModelImpl;
import net.ayudh.audit.service.persistence.AuditEventArchivePersistence;
import net.ayudh.audit.service.persistence.impl.constants.auditPersistenceConstants;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the audit event archive service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = AuditEventArchivePersistence.class)
public class AuditEventArchivePersistenceImpl
	extends BasePersistenceImpl<AuditEventArchive>
	implements AuditEventArchivePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AuditEventArchiveUtil</code> to access the audit event archive persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AuditEventArchiveImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public AuditEventArchivePersistenceImpl() {
		setModelClass(AuditEventArchive.class);

		setModelImplClass(AuditEventArchiveImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the audit event archive in the entity cache if it is enabled.
	 *
	 * @param auditEventArchive the audit event archive
	 */
	@Override
	public void cacheResult(AuditEventArchive auditEventArchive) {
		entityCache.putResult(
			AuditEventArchiveImpl.class, auditEventArchive.getPrimaryKey(),
			auditEventArchive);
	}

	/**
	 * Caches the audit event archives in the entity cache if it is enabled.
	 *
	 * @param auditEventArchives the audit event archives
	 */
	@Override
	public void cacheResult(List<AuditEventArchive> auditEventArchives) {
		for (AuditEventArchive auditEventArchive : auditEventArchives) {
			if (entityCache.getResult(
					AuditEventArchiveImpl.class,
					auditEventArchive.getPrimaryKey()) == null) {

				cacheResult(auditEventArchive);
			}
		}
	}

	/**
	 * Clears the cache for all audit event archives.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AuditEventArchiveImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the audit event archive.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AuditEventArchive auditEventArchive) {
		entityCache.removeResult(
			AuditEventArchiveImpl.class, auditEventArchive);
	}

	@Override
	public void clearCache(List<AuditEventArchive> auditEventArchives) {
		for (AuditEventArchive auditEventArchive : auditEventArchives) {
			entityCache.removeResult(
				AuditEventArchiveImpl.class, auditEventArchive);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AuditEventArchiveImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new audit event archive with the primary key. Does not add the audit event archive to the database.
	 *
	 * @param auditEventArchiveId the primary key for the new audit event archive
	 * @return the new audit event archive
	 */
	@Override
	public AuditEventArchive create(long auditEventArchiveId) {
		AuditEventArchive auditEventArchive = new AuditEventArchiveImpl();

		auditEventArchive.setNew(true);
		auditEventArchive.setPrimaryKey(auditEventArchiveId);

		auditEventArchive.setCompanyId(CompanyThreadLocal.getCompanyId());

		return auditEventArchive;
	}

	/**
	 * Removes the audit event archive with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param auditEventArchiveId the primary key of the audit event archive
	 * @return the audit event archive that was removed
	 * @throws NoSuchAuditEventArchiveException if a audit event archive with the primary key could not be found
	 */
	@Override
	public AuditEventArchive remove(long auditEventArchiveId)
		throws NoSuchAuditEventArchiveException {

		return remove((Serializable)auditEventArchiveId);
	}

	/**
	 * Removes the audit event archive with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the audit event archive
	 * @return the audit event archive that was removed
	 * @throws NoSuchAuditEventArchiveException if a audit event archive with the primary key could not be found
	 */
	@Override
	public AuditEventArchive remove(Serializable primaryKey)
		throws NoSuchAuditEventArchiveException {

		Session session = null;

		try {
			session = openSession();

			AuditEventArchive auditEventArchive =
				(AuditEventArchive)session.get(
					AuditEventArchiveImpl.class, primaryKey);

			if (auditEventArchive == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAuditEventArchiveException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(auditEventArchive);
		}
		catch (NoSuchAuditEventArchiveException noSuchEntityException) {
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
	protected AuditEventArchive removeImpl(
		AuditEventArchive auditEventArchive) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(auditEventArchive)) {
				auditEventArchive = (AuditEventArchive)session.get(
					AuditEventArchiveImpl.class,
					auditEventArchive.getPrimaryKeyObj());
			}

			if (auditEventArchive != null) {
				session.delete(auditEventArchive);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (auditEventArchive != null) {
			clearCache(auditEventArchive);
		}

		return auditEventArchive;
	}

	@Override
	public AuditEventArchive updateImpl(AuditEventArchive auditEventArchive) {
		boolean isNew = auditEventArchive.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(auditEventArchive);
			}
			else {
				auditEventArchive = (AuditEventArchive)session.merge(
					auditEventArchive);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AuditEventArchiveImpl.class, auditEventArchive, false, true);

		if (isNew) {
			auditEventArchive.setNew(false);
		}

		auditEventArchive.resetOriginalValues();

		return auditEventArchive;
	}

	/**
	 * Returns the audit event archive with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the audit event archive
	 * @return the audit event archive
	 * @throws NoSuchAuditEventArchiveException if a audit event archive with the primary key could not be found
	 */
	@Override
	public AuditEventArchive findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAuditEventArchiveException {

		AuditEventArchive auditEventArchive = fetchByPrimaryKey(primaryKey);

		if (auditEventArchive == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAuditEventArchiveException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return auditEventArchive;
	}

	/**
	 * Returns the audit event archive with the primary key or throws a <code>NoSuchAuditEventArchiveException</code> if it could not be found.
	 *
	 * @param auditEventArchiveId the primary key of the audit event archive
	 * @return the audit event archive
	 * @throws NoSuchAuditEventArchiveException if a audit event archive with the primary key could not be found
	 */
	@Override
	public AuditEventArchive findByPrimaryKey(long auditEventArchiveId)
		throws NoSuchAuditEventArchiveException {

		return findByPrimaryKey((Serializable)auditEventArchiveId);
	}

	/**
	 * Returns the audit event archive with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param auditEventArchiveId the primary key of the audit event archive
	 * @return the audit event archive, or <code>null</code> if a audit event archive with the primary key could not be found
	 */
	@Override
	public AuditEventArchive fetchByPrimaryKey(long auditEventArchiveId) {
		return fetchByPrimaryKey((Serializable)auditEventArchiveId);
	}

	/**
	 * Returns all the audit event archives.
	 *
	 * @return the audit event archives
	 */
	@Override
	public List<AuditEventArchive> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the audit event archives.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditEventArchiveModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of audit event archives
	 * @param end the upper bound of the range of audit event archives (not inclusive)
	 * @return the range of audit event archives
	 */
	@Override
	public List<AuditEventArchive> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the audit event archives.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditEventArchiveModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of audit event archives
	 * @param end the upper bound of the range of audit event archives (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of audit event archives
	 */
	@Override
	public List<AuditEventArchive> findAll(
		int start, int end,
		OrderByComparator<AuditEventArchive> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the audit event archives.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditEventArchiveModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of audit event archives
	 * @param end the upper bound of the range of audit event archives (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of audit event archives
	 */
	@Override
	public List<AuditEventArchive> findAll(
		int start, int end,
		OrderByComparator<AuditEventArchive> orderByComparator,
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

		List<AuditEventArchive> list = null;

		if (useFinderCache) {
			list = (List<AuditEventArchive>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_AUDITEVENTARCHIVE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_AUDITEVENTARCHIVE;

				sql = sql.concat(AuditEventArchiveModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AuditEventArchive>)QueryUtil.list(
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
	 * Removes all the audit event archives from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AuditEventArchive auditEventArchive : findAll()) {
			remove(auditEventArchive);
		}
	}

	/**
	 * Returns the number of audit event archives.
	 *
	 * @return the number of audit event archives
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_AUDITEVENTARCHIVE);

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
		return "auditEventArchiveId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_AUDITEVENTARCHIVE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AuditEventArchiveModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the audit event archive persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new AuditEventArchiveModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", AuditEventArchive.class.getName()));

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
		entityCache.removeCache(AuditEventArchiveImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	@Override
	@Reference(
		target = auditPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = auditPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = auditPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_AUDITEVENTARCHIVE =
		"SELECT auditEventArchive FROM AuditEventArchive auditEventArchive";

	private static final String _SQL_COUNT_AUDITEVENTARCHIVE =
		"SELECT COUNT(auditEventArchive) FROM AuditEventArchive auditEventArchive";

	private static final String _ORDER_BY_ENTITY_ALIAS = "auditEventArchive.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AuditEventArchive exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		AuditEventArchivePersistenceImpl.class);

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

	private static class AuditEventArchiveModelArgumentsResolver
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

			AuditEventArchiveModelImpl auditEventArchiveModelImpl =
				(AuditEventArchiveModelImpl)baseModel;

			long columnBitmask = auditEventArchiveModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					auditEventArchiveModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						auditEventArchiveModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					auditEventArchiveModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			AuditEventArchiveModelImpl auditEventArchiveModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						auditEventArchiveModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = auditEventArchiveModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}