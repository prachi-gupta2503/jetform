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

package com.adjecti.pis.liferay.service;

import com.adjecti.pis.liferay.model.EmployeeOrganization;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for EmployeeOrganization. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeOrganizationLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface EmployeeOrganizationLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.adjecti.pis.liferay.service.impl.EmployeeOrganizationLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the employee organization local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link EmployeeOrganizationLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the employee organization to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeOrganizationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeOrganization the employee organization
	 * @return the employee organization that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public EmployeeOrganization addEmployeeOrganization(
		EmployeeOrganization employeeOrganization);

	public boolean beforeDeleteEmployeeOrganization(
			EmployeeOrganization entity, boolean logical)
		throws PortalException;

	public boolean beforeDeleteEmployeeOrganization(
			Object entity, boolean logical)
		throws PortalException;

	public boolean beforeUpdateEmployeeOrganization(
			EmployeeOrganization entity, Map<String, String[]> fieldValues)
		throws PortalException;

	public boolean beforeUpdateEmployeeOrganization(
			Object entity, Map<String, String[]> fieldValues)
		throws PortalException;

	/**
	 * Creates a new employee organization with the primary key. Does not add the employee organization to the database.
	 *
	 * @param employeeOrganizationId the primary key for the new employee organization
	 * @return the new employee organization
	 */
	@Transactional(enabled = false)
	public EmployeeOrganization createEmployeeOrganization(
		long employeeOrganizationId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Deletes the employee organization from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeOrganizationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeOrganization the employee organization
	 * @return the employee organization that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public EmployeeOrganization deleteEmployeeOrganization(
		EmployeeOrganization employeeOrganization);

	/**
	 * Deletes the employee organization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeOrganizationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeOrganizationId the primary key of the employee organization
	 * @return the employee organization that was removed
	 * @throws PortalException if a employee organization with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public EmployeeOrganization deleteEmployeeOrganization(
			long employeeOrganizationId)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	public boolean existsEmployeeOrganization(
		long employeeId, long organizationId);

	public boolean existsEmployeeSubOrganization(
		long employeeId, long subOrganizationId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public EmployeeOrganization fetchEmployeeOrganization(
		long employeeOrganizationId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<EmployeeOrganization> getByEmployeeIdAndOrganizationId(
		long employeeId, long organizationId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<EmployeeOrganization> getByEmployeeIdAndSubOrganizationId(
		long employeeId, long subOrganizationId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<EmployeeOrganization> getByOrganizationId(long organizationId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<EmployeeOrganization> getBySubOrganizationIdAndActive(
		long subOrganizationId, boolean active);

	/**
	 * Returns the employee organization with the primary key.
	 *
	 * @param employeeOrganizationId the primary key of the employee organization
	 * @return the employee organization
	 * @throws PortalException if a employee organization with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public EmployeeOrganization getEmployeeOrganization(
			long employeeOrganizationId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getEmployeeOrganizationCountByEmployeeIdAndOrganizationId(
		long employeeId, long organizationId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getEmployeeOrganizationCountByEmployeeIdAndSubOrganizationId(
		long employeeId, long subOrganizationId);

	/**
	 * Returns a range of all the employee organizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @return the range of employee organizations
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<EmployeeOrganization> getEmployeeOrganizations(
		int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<EmployeeOrganization> getEmployeeOrganizationsByEmployeeId(
		long employeeId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<EmployeeOrganization> getEmployeeOrganizationsByPersonalNo(
		String personalNo);

	/**
	 * Returns the number of employee organizations.
	 *
	 * @return the number of employee organizations
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getEmployeeOrganizationsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Organization> getNonAssignedOrganizationsOfEmployee(
		long parentId, String type, long employeeId);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	public Map<String, String> importEmployeeOrganization(
		List<Map<String, String[]>> records);

	/**
	 * Updates the employee organization in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeOrganizationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeOrganization the employee organization
	 * @return the employee organization that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public EmployeeOrganization updateEmployeeOrganization(
		EmployeeOrganization employeeOrganization);

	public String updateOrganization(
		ThemeDisplay themeDisplay, String status, long organizationId);

}