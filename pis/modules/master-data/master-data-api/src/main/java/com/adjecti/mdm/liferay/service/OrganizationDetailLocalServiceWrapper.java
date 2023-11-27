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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link OrganizationDetailLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see OrganizationDetailLocalService
 * @generated
 */
public class OrganizationDetailLocalServiceWrapper
	implements OrganizationDetailLocalService,
			   ServiceWrapper<OrganizationDetailLocalService> {

	public OrganizationDetailLocalServiceWrapper(
		OrganizationDetailLocalService organizationDetailLocalService) {

		_organizationDetailLocalService = organizationDetailLocalService;
	}

	@Override
	public com.liferay.portal.kernel.model.Organization addOrganization(
			String code, String name, String description, String type,
			String parentCode, String parentType, boolean prefixParentName)
		throws com.liferay.portal.kernel.exception.OrganizationNameException,
			   com.liferay.portal.kernel.exception.OrganizationParentException {

		return _organizationDetailLocalService.addOrganization(
			code, name, description, type, parentCode, parentType,
			prefixParentName);
	}

	@Override
	public com.adjecti.mdm.liferay.model.OrganizationDetail
		addOrganizationDetail(
			com.liferay.portal.kernel.model.Organization org) {

		return _organizationDetailLocalService.addOrganizationDetail(org);
	}

	@Override
	public com.adjecti.mdm.liferay.model.OrganizationDetail
		addOrganizationDetail(
			com.liferay.portal.kernel.model.Organization org, String code,
			String longName, String parentCode, String unitType) {

		return _organizationDetailLocalService.addOrganizationDetail(
			org, code, longName, parentCode, unitType);
	}

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
	@Override
	public com.adjecti.mdm.liferay.model.OrganizationDetail
		addOrganizationDetail(
			com.adjecti.mdm.liferay.model.OrganizationDetail
				organizationDetail) {

		return _organizationDetailLocalService.addOrganizationDetail(
			organizationDetail);
	}

	@Override
	public boolean beforeDeleteOrganizationDetail(
		Object entity, boolean logical) {

		return _organizationDetailLocalService.beforeDeleteOrganizationDetail(
			entity, logical);
	}

	@Override
	public boolean beforeUpdateOrganizationDetail(
		Object entity, java.util.Map<String, String[]> paramMap) {

		return _organizationDetailLocalService.beforeUpdateOrganizationDetail(
			entity, paramMap);
	}

	@Override
	public boolean codeIsAvailableOrNotBasedOnTypeAndUnitAndOrganizationCode(
		String type, long parentId, String fieldName, String fieldValue,
		long organizationId) {

		return _organizationDetailLocalService.
			codeIsAvailableOrNotBasedOnTypeAndUnitAndOrganizationCode(
				type, parentId, fieldName, fieldValue, organizationId);
	}

	/**
	 * Creates a new organization detail with the primary key. Does not add the organization detail to the database.
	 *
	 * @param organizationDetailId the primary key for the new organization detail
	 * @return the new organization detail
	 */
	@Override
	public com.adjecti.mdm.liferay.model.OrganizationDetail
		createOrganizationDetail(long organizationDetailId) {

		return _organizationDetailLocalService.createOrganizationDetail(
			organizationDetailId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _organizationDetailLocalService.createPersistedModel(
			primaryKeyObj);
	}

	@Override
	public boolean dataIsAvailbleOrNot(
		String fieldName, String fieldValue, String type, long organizationId) {

		return _organizationDetailLocalService.dataIsAvailbleOrNot(
			fieldName, fieldValue, type, organizationId);
	}

	@Override
	public boolean deleteeOrganizationDetail(long organizationDetailId) {
		return _organizationDetailLocalService.deleteeOrganizationDetail(
			organizationDetailId);
	}

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
	@Override
	public com.adjecti.mdm.liferay.model.OrganizationDetail
			deleteOrganizationDetail(long organizationDetailId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _organizationDetailLocalService.deleteOrganizationDetail(
			organizationDetailId);
	}

	@Override
	public boolean deleteOrganizationDetail(
		com.liferay.portal.kernel.model.Organization org) {

		return _organizationDetailLocalService.deleteOrganizationDetail(org);
	}

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
	@Override
	public com.adjecti.mdm.liferay.model.OrganizationDetail
		deleteOrganizationDetail(
			com.adjecti.mdm.liferay.model.OrganizationDetail
				organizationDetail) {

		return _organizationDetailLocalService.deleteOrganizationDetail(
			organizationDetail);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _organizationDetailLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _organizationDetailLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _organizationDetailLocalService.dynamicQuery(dynamicQuery);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _organizationDetailLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _organizationDetailLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _organizationDetailLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _organizationDetailLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public boolean existsOrganizationByParentIdAndName(
		long parentId, String name) {

		return _organizationDetailLocalService.
			existsOrganizationByParentIdAndName(parentId, name);
	}

	@Override
	public boolean existsOrganizationByParentIdCodeAndType(
		long parentId, String code, String type) {

		return _organizationDetailLocalService.
			existsOrganizationByParentIdCodeAndType(parentId, code, type);
	}

	@Override
	public com.adjecti.mdm.liferay.model.OrganizationDetail
		fetchOrganizationDetail(long organizationDetailId) {

		return _organizationDetailLocalService.fetchOrganizationDetail(
			organizationDetailId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _organizationDetailLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.OrganizationDetail>
		getByName(String shortName) {

		return _organizationDetailLocalService.getByName(shortName);
	}

	@Override
	public com.liferay.portal.kernel.model.Organization getByOrganizationId(
		long organizationId) {

		return _organizationDetailLocalService.getByOrganizationId(
			organizationId);
	}

	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.OrganizationDetail>
		getByParentId(long parentId) {

		return _organizationDetailLocalService.getByParentId(parentId);
	}

	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.OrganizationDetail>
		getByParentIdAndType(long parentId, String type) {

		return _organizationDetailLocalService.getByParentIdAndType(
			parentId, type);
	}

	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.OrganizationDetail>
		getByStateId(long stateId) {

		return _organizationDetailLocalService.getByStateId(stateId);
	}

	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.OrganizationDetail>
		getByUnitType(String unitType) {

		return _organizationDetailLocalService.getByUnitType(unitType);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject
		getChildOrganizationHierarchy(long parentId) {

		return _organizationDetailLocalService.getChildOrganizationHierarchy(
			parentId);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.model.Organization>
		getChildOrganizations(long parentId) {

		return _organizationDetailLocalService.getChildOrganizations(parentId);
	}

	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.OrganizationDetail>
		getDivisions() {

		return _organizationDetailLocalService.getDivisions();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _organizationDetailLocalService.
			getIndexableActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.model.Organization
		getOrganizationByParentIdAndName(long parentId, String name) {

		return _organizationDetailLocalService.getOrganizationByParentIdAndName(
			parentId, name);
	}

	@Override
	public com.liferay.portal.kernel.model.Organization
		getOrganizationByParentIdCodeAndType(
			long parentId, String code, String type) {

		return _organizationDetailLocalService.
			getOrganizationByParentIdCodeAndType(parentId, code, type);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.model.Organization>
		getOrganizationByTypeAndCode(String code, String type) {

		return _organizationDetailLocalService.getOrganizationByTypeAndCode(
			code, type);
	}

	/**
	 * Returns the organization detail with the primary key.
	 *
	 * @param organizationDetailId the primary key of the organization detail
	 * @return the organization detail
	 * @throws PortalException if a organization detail with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.OrganizationDetail
			getOrganizationDetail(long organizationDetailId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _organizationDetailLocalService.getOrganizationDetail(
			organizationDetailId);
	}

	@Override
	public com.adjecti.mdm.liferay.model.OrganizationDetail
		getOrganizationDetailByCode(String code) {

		return _organizationDetailLocalService.getOrganizationDetailByCode(
			code);
	}

	@Override
	public com.adjecti.mdm.liferay.model.OrganizationDetail
		getOrganizationDetailByOrganizationCode(String code) {

		return _organizationDetailLocalService.
			getOrganizationDetailByOrganizationCode(code);
	}

	@Override
	public com.adjecti.mdm.liferay.model.OrganizationDetail
		getOrganizationDetailByOrganizationId(long organizationId) {

		return _organizationDetailLocalService.
			getOrganizationDetailByOrganizationId(organizationId);
	}

	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.OrganizationDetail>
		getOrganizationDetailByParentIdAndOrganizationCode(
			long parentId, String code) {

		return _organizationDetailLocalService.
			getOrganizationDetailByParentIdAndOrganizationCode(parentId, code);
	}

	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.OrganizationDetail>
		getOrganizationDetailByParentIdAndShortName(
			long parentId, String shortName) {

		return _organizationDetailLocalService.
			getOrganizationDetailByParentIdAndShortName(parentId, shortName);
	}

	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.OrganizationDetail>
		getOrganizationDetailByParentIdAndType(long parentId, String type) {

		return _organizationDetailLocalService.
			getOrganizationDetailByParentIdAndType(parentId, type);
	}

	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.OrganizationDetail>
		getOrganizationDetailByType(String type) {

		return _organizationDetailLocalService.getOrganizationDetailByType(
			type);
	}

	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.OrganizationDetail>
		getOrganizationDetailByTypeAndOrganizationCode(
			String type, String organizationCode) {

		return _organizationDetailLocalService.
			getOrganizationDetailByTypeAndOrganizationCode(
				type, organizationCode);
	}

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
	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.OrganizationDetail>
		getOrganizationDetails(int start, int end) {

		return _organizationDetailLocalService.getOrganizationDetails(
			start, end);
	}

	/**
	 * Returns the number of organization details.
	 *
	 * @return the number of organization details
	 */
	@Override
	public int getOrganizationDetailsCount() {
		return _organizationDetailLocalService.getOrganizationDetailsCount();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject
		getOrganizationHierarchy() {

		return _organizationDetailLocalService.getOrganizationHierarchy();
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.model.Organization>
		getOrganizations() {

		return _organizationDetailLocalService.getOrganizations();
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.model.Organization>
		getOrganizationsByParentIdAndType(long parentId, String type) {

		return _organizationDetailLocalService.
			getOrganizationsByParentIdAndType(parentId, type);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.model.Organization>
		getOrganizationsByType(String type) {

		return _organizationDetailLocalService.getOrganizationsByType(type);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _organizationDetailLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _organizationDetailLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.adjecti.mdm.liferay.model.OrganizationDetail
		getSectionByUnitCodeAndSectionCode(
			String unitCode, String sectionCode) {

		return _organizationDetailLocalService.
			getSectionByUnitCodeAndSectionCode(unitCode, sectionCode);
	}

	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.OrganizationDetail>
		getSections(long unitId) {

		return _organizationDetailLocalService.getSections(unitId);
	}

	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.OrganizationDetail>
		getSectionsByCode(String organizationCode) {

		return _organizationDetailLocalService.getSectionsByCode(
			organizationCode);
	}

	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.OrganizationDetail>
		getSectionsByUnitId(long unitId) {

		return _organizationDetailLocalService.getSectionsByUnitId(unitId);
	}

	@Override
	public int getSectionsCount(long unitId) {
		return _organizationDetailLocalService.getSectionsCount(unitId);
	}

	@Override
	public int getSectionsCountByCode(String organizationCode) {
		return _organizationDetailLocalService.getSectionsCountByCode(
			organizationCode);
	}

	@Override
	public int getTotalSectionsCount() {
		return _organizationDetailLocalService.getTotalSectionsCount();
	}

	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.OrganizationDetail>
		getUnit(long divisionId) {

		return _organizationDetailLocalService.getUnit(divisionId);
	}

	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.OrganizationDetail>
		getUnits() {

		return _organizationDetailLocalService.getUnits();
	}

	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.OrganizationDetail>
		getUnitsByDivisionId(long divisionId) {

		return _organizationDetailLocalService.getUnitsByDivisionId(divisionId);
	}

	@Override
	public int getUnitsCount() {
		return _organizationDetailLocalService.getUnitsCount();
	}

	@Override
	public java.util.Map<String, String> importOrganizationDetail(
		java.util.List<java.util.Map<String, String[]>> records) {

		return _organizationDetailLocalService.importOrganizationDetail(
			records);
	}

	@Override
	public java.util.Map<String, String> importOrganizationDetail_Old(
		java.util.List<java.util.Map<String, String[]>> records) {

		return _organizationDetailLocalService.importOrganizationDetail_Old(
			records);
	}

	@Override
	public boolean removeOrganizationDetailByOrganizationId(
		long organizationDeatailId) {

		return _organizationDetailLocalService.
			removeOrganizationDetailByOrganizationId(organizationDeatailId);
	}

	@Override
	public com.liferay.portal.kernel.model.Organization saveOrganization(
			long organizationId, String code, String unitType, String name,
			String description, String type, long parentId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			String comments)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _organizationDetailLocalService.saveOrganization(
			organizationId, code, unitType, name, description, type, parentId,
			serviceContext, comments);
	}

	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.OrganizationDetail>
		searchOrganizationDetails(java.util.Map<String, String> searchFilter) {

		return _organizationDetailLocalService.searchOrganizationDetails(
			searchFilter);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.model.Organization>
		syncUnits() {

		return _organizationDetailLocalService.syncUnits();
	}

	@Override
	public com.adjecti.mdm.liferay.model.OrganizationDetail
		updateOrganizationDetail(
			com.liferay.portal.kernel.model.Organization org) {

		return _organizationDetailLocalService.updateOrganizationDetail(org);
	}

	@Override
	public com.adjecti.mdm.liferay.model.OrganizationDetail
		updateOrganizationDetail(
			com.liferay.portal.kernel.model.Organization org, String code,
			String longName, String parentCode, String unitType,
			String orgStatus) {

		return _organizationDetailLocalService.updateOrganizationDetail(
			org, code, longName, parentCode, unitType, orgStatus);
	}

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
	@Override
	public com.adjecti.mdm.liferay.model.OrganizationDetail
		updateOrganizationDetail(
			com.adjecti.mdm.liferay.model.OrganizationDetail
				organizationDetail) {

		return _organizationDetailLocalService.updateOrganizationDetail(
			organizationDetail);
	}

	@Override
	public com.liferay.portal.kernel.model.Organization updateStatus(
		com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay,
		String status, long organizationId) {

		return _organizationDetailLocalService.updateStatus(
			themeDisplay, status, organizationId);
	}

	@Override
	public OrganizationDetailLocalService getWrappedService() {
		return _organizationDetailLocalService;
	}

	@Override
	public void setWrappedService(
		OrganizationDetailLocalService organizationDetailLocalService) {

		_organizationDetailLocalService = organizationDetailLocalService;
	}

	private OrganizationDetailLocalService _organizationDetailLocalService;

}