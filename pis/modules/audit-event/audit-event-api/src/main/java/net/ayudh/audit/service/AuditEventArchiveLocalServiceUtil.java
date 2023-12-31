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

package net.ayudh.audit.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for AuditEventArchive. This utility wraps
 * <code>net.ayudh.audit.service.impl.AuditEventArchiveLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AuditEventArchiveLocalService
 * @generated
 */
public class AuditEventArchiveLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>net.ayudh.audit.service.impl.AuditEventArchiveLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the audit event archive to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AuditEventArchiveLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param auditEventArchive the audit event archive
	 * @return the audit event archive that was added
	 */
	public static net.ayudh.audit.model.AuditEventArchive addAuditEventArchive(
		net.ayudh.audit.model.AuditEventArchive auditEventArchive) {

		return getService().addAuditEventArchive(auditEventArchive);
	}

	/**
	 * Creates a new audit event archive with the primary key. Does not add the audit event archive to the database.
	 *
	 * @param auditEventArchiveId the primary key for the new audit event archive
	 * @return the new audit event archive
	 */
	public static net.ayudh.audit.model.AuditEventArchive
		createAuditEventArchive(long auditEventArchiveId) {

		return getService().createAuditEventArchive(auditEventArchiveId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			createPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the audit event archive from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AuditEventArchiveLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param auditEventArchive the audit event archive
	 * @return the audit event archive that was removed
	 */
	public static net.ayudh.audit.model.AuditEventArchive
		deleteAuditEventArchive(
			net.ayudh.audit.model.AuditEventArchive auditEventArchive) {

		return getService().deleteAuditEventArchive(auditEventArchive);
	}

	/**
	 * Deletes the audit event archive with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AuditEventArchiveLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param auditEventArchiveId the primary key of the audit event archive
	 * @return the audit event archive that was removed
	 * @throws PortalException if a audit event archive with the primary key could not be found
	 */
	public static net.ayudh.audit.model.AuditEventArchive
			deleteAuditEventArchive(long auditEventArchiveId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteAuditEventArchive(auditEventArchiveId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>net.ayudh.audit.model.impl.AuditEventArchiveModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>net.ayudh.audit.model.impl.AuditEventArchiveModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static net.ayudh.audit.model.AuditEventArchive
		fetchAuditEventArchive(long auditEventArchiveId) {

		return getService().fetchAuditEventArchive(auditEventArchiveId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the audit event archive with the primary key.
	 *
	 * @param auditEventArchiveId the primary key of the audit event archive
	 * @return the audit event archive
	 * @throws PortalException if a audit event archive with the primary key could not be found
	 */
	public static net.ayudh.audit.model.AuditEventArchive getAuditEventArchive(
			long auditEventArchiveId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getAuditEventArchive(auditEventArchiveId);
	}

	/**
	 * Returns a range of all the audit event archives.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>net.ayudh.audit.model.impl.AuditEventArchiveModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of audit event archives
	 * @param end the upper bound of the range of audit event archives (not inclusive)
	 * @return the range of audit event archives
	 */
	public static java.util.List<net.ayudh.audit.model.AuditEventArchive>
		getAuditEventArchives(int start, int end) {

		return getService().getAuditEventArchives(start, end);
	}

	/**
	 * Returns the number of audit event archives.
	 *
	 * @return the number of audit event archives
	 */
	public static int getAuditEventArchivesCount() {
		return getService().getAuditEventArchivesCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the audit event archive in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AuditEventArchiveLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param auditEventArchive the audit event archive
	 * @return the audit event archive that was updated
	 */
	public static net.ayudh.audit.model.AuditEventArchive
		updateAuditEventArchive(
			net.ayudh.audit.model.AuditEventArchive auditEventArchive) {

		return getService().updateAuditEventArchive(auditEventArchive);
	}

	public static AuditEventArchiveLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<AuditEventArchiveLocalService, AuditEventArchiveLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			AuditEventArchiveLocalService.class);

		ServiceTracker
			<AuditEventArchiveLocalService, AuditEventArchiveLocalService>
				serviceTracker =
					new ServiceTracker
						<AuditEventArchiveLocalService,
						 AuditEventArchiveLocalService>(
							 bundle.getBundleContext(),
							 AuditEventArchiveLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}