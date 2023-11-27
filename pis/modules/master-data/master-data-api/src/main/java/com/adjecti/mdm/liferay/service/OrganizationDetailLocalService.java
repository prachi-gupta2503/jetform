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

package com.adjecti.mdm.liferay.service;

import com.adjecti.mdm.liferay.model.OrganizationDetail;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.OrganizationNameException;
import com.liferay.portal.kernel.exception.OrganizationParentException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
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
 * Provides the local service interface for OrganizationDetail. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see OrganizationDetailLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface OrganizationDetailLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.adjecti.mdm.liferay.service.impl.OrganizationDetailLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the organization detail local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link OrganizationDetailLocalServiceUtil} if injection and service tracking are not available.
	 */
	public Organization addOrganization(
			String code, String name, String description, String type,
			String parentCode, String parentType, boolean prefixParentName)
		throws OrganizationNameException, OrganizationParentException;

	public OrganizationDetail addOrganizationDetail(Organization org);

	public OrganizationDetail addOrganizationDetail(
		Organization org, String code, String longName, String parentCode,
		String unitType);

	/**
	 * Adds the organization detail to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OrganizationDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param organizationDetail the organization detail
	 * @return the organization detail that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public OrganizationDetail addOrganizationDetail(
		OrganizationDetail organizationDetail);

	public boolean beforeDeleteOrganizationDetail(
		Object entity, boolean logical);

	public boolean beforeUpdateOrganizationDetail(
		Object entity, Map<String, String[]> paramMap);

	public boolean codeIsAvailableOrNotBasedOnTypeAndUnitAndOrganizationCode(
		String type, long parentId, String fieldName, String fieldValue,
		long organizationId);

	/**
	 * Creates a new organization detail with the primary key. Does not add the organization detail to the database.
	 *
	 * @param organizationDetailId the primary key for the new organization detail
	 * @return the new organization detail
	 */
	@Transactional(enabled = false)
	public OrganizationDetail createOrganizationDetail(
		long organizationDetailId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	public boolean dataIsAvailbleOrNot(
		String fieldName, String fieldValue, String type, long organizationId);

	public boolean deleteeOrganizationDetail(long organizationDetailId);

	/**
	 * Deletes the organization detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OrganizationDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param organizationDetailId the primary key of the organization detail
	 * @return the organization detail that was removed
	 * @throws PortalException if a organization detail with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public OrganizationDetail deleteOrganizationDetail(
			long organizationDetailId)
		throws PortalException;

	public boolean deleteOrganizationDetail(Organization org);

	/**
	 * Deletes the organization detail from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OrganizationDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param organizationDetail the organization detail
	 * @return the organization detail that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public OrganizationDetail deleteOrganizationDetail(
		OrganizationDetail organizationDetail);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.OrganizationDetailModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.OrganizationDetailModelImpl</code>.
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

	public boolean existsOrganizationByParentIdAndName(
		long parentId, String name);

	public boolean existsOrganizationByParentIdCodeAndType(
		long parentId, String code, String type);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public OrganizationDetail fetchOrganizationDetail(
		long organizationDetailId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<OrganizationDetail> getByName(String shortName);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Organization getByOrganizationId(long organizationId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<OrganizationDetail> getByParentId(long parentId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<OrganizationDetail> getByParentIdAndType(
		long parentId, String type);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<OrganizationDetail> getByStateId(long stateId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<OrganizationDetail> getByUnitType(String unitType);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject getChildOrganizationHierarchy(long parentId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Organization> getChildOrganizations(long parentId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<OrganizationDetail> getDivisions();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Organization getOrganizationByParentIdAndName(
		long parentId, String name);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Organization getOrganizationByParentIdCodeAndType(
		long parentId, String code, String type);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Organization> getOrganizationByTypeAndCode(
		String code, String type);

	/**
	 * Returns the organization detail with the primary key.
	 *
	 * @param organizationDetailId the primary key of the organization detail
	 * @return the organization detail
	 * @throws PortalException if a organization detail with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public OrganizationDetail getOrganizationDetail(long organizationDetailId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public OrganizationDetail getOrganizationDetailByCode(String code);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public OrganizationDetail getOrganizationDetailByOrganizationCode(
		String code);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public OrganizationDetail getOrganizationDetailByOrganizationId(
		long organizationId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<OrganizationDetail>
		getOrganizationDetailByParentIdAndOrganizationCode(
			long parentId, String code);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<OrganizationDetail> getOrganizationDetailByParentIdAndShortName(
		long parentId, String shortName);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<OrganizationDetail> getOrganizationDetailByParentIdAndType(
		long parentId, String type);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<OrganizationDetail> getOrganizationDetailByType(String type);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<OrganizationDetail>
		getOrganizationDetailByTypeAndOrganizationCode(
			String type, String organizationCode);

	/**
	 * Returns a range of all the organization details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @return the range of organization details
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<OrganizationDetail> getOrganizationDetails(int start, int end);

	/**
	 * Returns the number of organization details.
	 *
	 * @return the number of organization details
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getOrganizationDetailsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject getOrganizationHierarchy();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Organization> getOrganizations();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Organization> getOrganizationsByParentIdAndType(
		long parentId, String type);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Organization> getOrganizationsByType(String type);

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

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public OrganizationDetail getSectionByUnitCodeAndSectionCode(
		String unitCode, String sectionCode);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<OrganizationDetail> getSections(long unitId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<OrganizationDetail> getSectionsByCode(String organizationCode);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<OrganizationDetail> getSectionsByUnitId(long unitId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getSectionsCount(long unitId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getSectionsCountByCode(String organizationCode);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTotalSectionsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<OrganizationDetail> getUnit(long divisionId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<OrganizationDetail> getUnits();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<OrganizationDetail> getUnitsByDivisionId(long divisionId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getUnitsCount();

	public Map<String, String> importOrganizationDetail(
		List<Map<String, String[]>> records);

	public Map<String, String> importOrganizationDetail_Old(
		List<Map<String, String[]>> records);

	public boolean removeOrganizationDetailByOrganizationId(
		long organizationDeatailId);

	public Organization saveOrganization(
			long organizationId, String code, String unitType, String name,
			String description, String type, long parentId,
			ServiceContext serviceContext, String comments)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<OrganizationDetail> searchOrganizationDetails(
		Map<String, String> searchFilter);

	public List<Organization> syncUnits();

	public OrganizationDetail updateOrganizationDetail(Organization org);

	public OrganizationDetail updateOrganizationDetail(
		Organization org, String code, String longName, String parentCode,
		String unitType, String orgStatus);

	/**
	 * Updates the organization detail in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OrganizationDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param organizationDetail the organization detail
	 * @return the organization detail that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public OrganizationDetail updateOrganizationDetail(
		OrganizationDetail organizationDetail);

	public Organization updateStatus(
		ThemeDisplay themeDisplay, String status, long organizationId);

}