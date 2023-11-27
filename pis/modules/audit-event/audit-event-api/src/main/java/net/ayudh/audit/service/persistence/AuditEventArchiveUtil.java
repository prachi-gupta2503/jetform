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

package net.ayudh.audit.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import net.ayudh.audit.model.AuditEventArchive;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the audit event archive service. This utility wraps <code>net.ayudh.audit.service.persistence.impl.AuditEventArchivePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AuditEventArchivePersistence
 * @generated
 */
public class AuditEventArchiveUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(AuditEventArchive auditEventArchive) {
		getPersistence().clearCache(auditEventArchive);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, AuditEventArchive> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AuditEventArchive> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AuditEventArchive> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AuditEventArchive> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AuditEventArchive> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AuditEventArchive update(
		AuditEventArchive auditEventArchive) {

		return getPersistence().update(auditEventArchive);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AuditEventArchive update(
		AuditEventArchive auditEventArchive, ServiceContext serviceContext) {

		return getPersistence().update(auditEventArchive, serviceContext);
	}

	/**
	 * Caches the audit event archive in the entity cache if it is enabled.
	 *
	 * @param auditEventArchive the audit event archive
	 */
	public static void cacheResult(AuditEventArchive auditEventArchive) {
		getPersistence().cacheResult(auditEventArchive);
	}

	/**
	 * Caches the audit event archives in the entity cache if it is enabled.
	 *
	 * @param auditEventArchives the audit event archives
	 */
	public static void cacheResult(List<AuditEventArchive> auditEventArchives) {
		getPersistence().cacheResult(auditEventArchives);
	}

	/**
	 * Creates a new audit event archive with the primary key. Does not add the audit event archive to the database.
	 *
	 * @param auditEventArchiveId the primary key for the new audit event archive
	 * @return the new audit event archive
	 */
	public static AuditEventArchive create(long auditEventArchiveId) {
		return getPersistence().create(auditEventArchiveId);
	}

	/**
	 * Removes the audit event archive with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param auditEventArchiveId the primary key of the audit event archive
	 * @return the audit event archive that was removed
	 * @throws NoSuchAuditEventArchiveException if a audit event archive with the primary key could not be found
	 */
	public static AuditEventArchive remove(long auditEventArchiveId)
		throws net.ayudh.audit.exception.NoSuchAuditEventArchiveException {

		return getPersistence().remove(auditEventArchiveId);
	}

	public static AuditEventArchive updateImpl(
		AuditEventArchive auditEventArchive) {

		return getPersistence().updateImpl(auditEventArchive);
	}

	/**
	 * Returns the audit event archive with the primary key or throws a <code>NoSuchAuditEventArchiveException</code> if it could not be found.
	 *
	 * @param auditEventArchiveId the primary key of the audit event archive
	 * @return the audit event archive
	 * @throws NoSuchAuditEventArchiveException if a audit event archive with the primary key could not be found
	 */
	public static AuditEventArchive findByPrimaryKey(long auditEventArchiveId)
		throws net.ayudh.audit.exception.NoSuchAuditEventArchiveException {

		return getPersistence().findByPrimaryKey(auditEventArchiveId);
	}

	/**
	 * Returns the audit event archive with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param auditEventArchiveId the primary key of the audit event archive
	 * @return the audit event archive, or <code>null</code> if a audit event archive with the primary key could not be found
	 */
	public static AuditEventArchive fetchByPrimaryKey(
		long auditEventArchiveId) {

		return getPersistence().fetchByPrimaryKey(auditEventArchiveId);
	}

	/**
	 * Returns all the audit event archives.
	 *
	 * @return the audit event archives
	 */
	public static List<AuditEventArchive> findAll() {
		return getPersistence().findAll();
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
	public static List<AuditEventArchive> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<AuditEventArchive> findAll(
		int start, int end,
		OrderByComparator<AuditEventArchive> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<AuditEventArchive> findAll(
		int start, int end,
		OrderByComparator<AuditEventArchive> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the audit event archives from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of audit event archives.
	 *
	 * @return the number of audit event archives
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AuditEventArchivePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<AuditEventArchivePersistence, AuditEventArchivePersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			AuditEventArchivePersistence.class);

		ServiceTracker
			<AuditEventArchivePersistence, AuditEventArchivePersistence>
				serviceTracker =
					new ServiceTracker
						<AuditEventArchivePersistence,
						 AuditEventArchivePersistence>(
							 bundle.getBundleContext(),
							 AuditEventArchivePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}