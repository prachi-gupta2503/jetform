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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for OrganizationDetail. This utility wraps
 * <code>com.adjecti.mdm.liferay.service.impl.OrganizationDetailLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see OrganizationDetailLocalService
 * @generated
 */
public class OrganizationDetailLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.adjecti.mdm.liferay.service.impl.OrganizationDetailLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.model.Organization addOrganization(
			String code, String name, String description, String type,
			String parentCode, String parentType, boolean prefixParentName)
		throws com.liferay.portal.kernel.exception.OrganizationNameException,
			   com.liferay.portal.kernel.exception.OrganizationParentException {

		return getService().addOrganization(
			code, name, description, type, parentCode, parentType,
			prefixParentName);
	}

	public static com.adjecti.mdm.liferay.model.OrganizationDetail
		addOrganizationDetail(
			com.liferay.portal.kernel.model.Organization org) {

		return getService().addOrganizationDetail(org);
	}

	public static com.adjecti.mdm.liferay.model.OrganizationDetail
		addOrganizationDetail(
			com.liferay.portal.kernel.model.Organization org, String code,
			String longName, String parentCode, String unitType) {

		return getService().addOrganizationDetail(
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
	public static com.adjecti.mdm.liferay.model.OrganizationDetail
		addOrganizationDetail(
			com.adjecti.mdm.liferay.model.OrganizationDetail
				organizationDetail) {

		return getService().addOrganizationDetail(organizationDetail);
	}

	public static boolean beforeDeleteOrganizationDetail(
		Object entity, boolean logical) {

		return getService().beforeDeleteOrganizationDetail(entity, logical);
	}

	public static boolean beforeUpdateOrganizationDetail(
		Object entity, java.util.Map<String, String[]> paramMap) {

		return getService().beforeUpdateOrganizationDetail(entity, paramMap);
	}

	public static boolean
		codeIsAvailableOrNotBasedOnTypeAndUnitAndOrganizationCode(
			String type, long parentId, String fieldName, String fieldValue,
			long organizationId) {

		return getService().
			codeIsAvailableOrNotBasedOnTypeAndUnitAndOrganizationCode(
				type, parentId, fieldName, fieldValue, organizationId);
	}

	/**
	 * Creates a new organization detail with the primary key. Does not add the organization detail to the database.
	 *
	 * @param organizationDetailId the primary key for the new organization detail
	 * @return the new organization detail
	 */
	public static com.adjecti.mdm.liferay.model.OrganizationDetail
		createOrganizationDetail(long organizationDetailId) {

		return getService().createOrganizationDetail(organizationDetailId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			createPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	public static boolean dataIsAvailbleOrNot(
		String fieldName, String fieldValue, String type, long organizationId) {

		return getService().dataIsAvailbleOrNot(
			fieldName, fieldValue, type, organizationId);
	}

	public static boolean deleteeOrganizationDetail(long organizationDetailId) {
		return getService().deleteeOrganizationDetail(organizationDetailId);
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
	public static com.adjecti.mdm.liferay.model.OrganizationDetail
			deleteOrganizationDetail(long organizationDetailId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteOrganizationDetail(organizationDetailId);
	}

	public static boolean deleteOrganizationDetail(
		com.liferay.portal.kernel.model.Organization org) {

		return getService().deleteOrganizationDetail(org);
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
	public static com.adjecti.mdm.liferay.model.OrganizationDetail
		deleteOrganizationDetail(
			com.adjecti.mdm.liferay.model.OrganizationDetail
				organizationDetail) {

		return getService().deleteOrganizationDetail(organizationDetail);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.OrganizationDetailModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.OrganizationDetailModelImpl</code>.
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

	public static boolean existsOrganizationByParentIdAndName(
		long parentId, String name) {

		return getService().existsOrganizationByParentIdAndName(parentId, name);
	}

	public static boolean existsOrganizationByParentIdCodeAndType(
		long parentId, String code, String type) {

		return getService().existsOrganizationByParentIdCodeAndType(
			parentId, code, type);
	}

	public static com.adjecti.mdm.liferay.model.OrganizationDetail
		fetchOrganizationDetail(long organizationDetailId) {

		return getService().fetchOrganizationDetail(organizationDetailId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List
		<com.adjecti.mdm.liferay.model.OrganizationDetail> getByName(
			String shortName) {

		return getService().getByName(shortName);
	}

	public static com.liferay.portal.kernel.model.Organization
		getByOrganizationId(long organizationId) {

		return getService().getByOrganizationId(organizationId);
	}

	public static java.util.List
		<com.adjecti.mdm.liferay.model.OrganizationDetail> getByParentId(
			long parentId) {

		return getService().getByParentId(parentId);
	}

	public static java.util.List
		<com.adjecti.mdm.liferay.model.OrganizationDetail> getByParentIdAndType(
			long parentId, String type) {

		return getService().getByParentIdAndType(parentId, type);
	}

	public static java.util.List
		<com.adjecti.mdm.liferay.model.OrganizationDetail> getByStateId(
			long stateId) {

		return getService().getByStateId(stateId);
	}

	public static java.util.List
		<com.adjecti.mdm.liferay.model.OrganizationDetail> getByUnitType(
			String unitType) {

		return getService().getByUnitType(unitType);
	}

	public static com.liferay.portal.kernel.json.JSONObject
		getChildOrganizationHierarchy(long parentId) {

		return getService().getChildOrganizationHierarchy(parentId);
	}

	public static java.util.List<com.liferay.portal.kernel.model.Organization>
		getChildOrganizations(long parentId) {

		return getService().getChildOrganizations(parentId);
	}

	public static java.util.List
		<com.adjecti.mdm.liferay.model.OrganizationDetail> getDivisions() {

		return getService().getDivisions();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.model.Organization
		getOrganizationByParentIdAndName(long parentId, String name) {

		return getService().getOrganizationByParentIdAndName(parentId, name);
	}

	public static com.liferay.portal.kernel.model.Organization
		getOrganizationByParentIdCodeAndType(
			long parentId, String code, String type) {

		return getService().getOrganizationByParentIdCodeAndType(
			parentId, code, type);
	}

	public static java.util.List<com.liferay.portal.kernel.model.Organization>
		getOrganizationByTypeAndCode(String code, String type) {

		return getService().getOrganizationByTypeAndCode(code, type);
	}

	/**
	 * Returns the organization detail with the primary key.
	 *
	 * @param organizationDetailId the primary key of the organization detail
	 * @return the organization detail
	 * @throws PortalException if a organization detail with the primary key could not be found
	 */
	public static com.adjecti.mdm.liferay.model.OrganizationDetail
			getOrganizationDetail(long organizationDetailId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getOrganizationDetail(organizationDetailId);
	}

	public static com.adjecti.mdm.liferay.model.OrganizationDetail
		getOrganizationDetailByCode(String code) {

		return getService().getOrganizationDetailByCode(code);
	}

	public static com.adjecti.mdm.liferay.model.OrganizationDetail
		getOrganizationDetailByOrganizationCode(String code) {

		return getService().getOrganizationDetailByOrganizationCode(code);
	}

	public static com.adjecti.mdm.liferay.model.OrganizationDetail
		getOrganizationDetailByOrganizationId(long organizationId) {

		return getService().getOrganizationDetailByOrganizationId(
			organizationId);
	}

	public static java.util.List
		<com.adjecti.mdm.liferay.model.OrganizationDetail>
			getOrganizationDetailByParentIdAndOrganizationCode(
				long parentId, String code) {

		return getService().getOrganizationDetailByParentIdAndOrganizationCode(
			parentId, code);
	}

	public static java.util.List
		<com.adjecti.mdm.liferay.model.OrganizationDetail>
			getOrganizationDetailByParentIdAndShortName(
				long parentId, String shortName) {

		return getService().getOrganizationDetailByParentIdAndShortName(
			parentId, shortName);
	}

	public static java.util.List
		<com.adjecti.mdm.liferay.model.OrganizationDetail>
			getOrganizationDetailByParentIdAndType(long parentId, String type) {

		return getService().getOrganizationDetailByParentIdAndType(
			parentId, type);
	}

	public static java.util.List
		<com.adjecti.mdm.liferay.model.OrganizationDetail>
			getOrganizationDetailByType(String type) {

		return getService().getOrganizationDetailByType(type);
	}

	public static java.util.List
		<com.adjecti.mdm.liferay.model.OrganizationDetail>
			getOrganizationDetailByTypeAndOrganizationCode(
				String type, String organizationCode) {

		return getService().getOrganizationDetailByTypeAndOrganizationCode(
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
	public static java.util.List
		<com.adjecti.mdm.liferay.model.OrganizationDetail>
			getOrganizationDetails(int start, int end) {

		return getService().getOrganizationDetails(start, end);
	}

	/**
	 * Returns the number of organization details.
	 *
	 * @return the number of organization details
	 */
	public static int getOrganizationDetailsCount() {
		return getService().getOrganizationDetailsCount();
	}

	public static com.liferay.portal.kernel.json.JSONObject
		getOrganizationHierarchy() {

		return getService().getOrganizationHierarchy();
	}

	public static java.util.List<com.liferay.portal.kernel.model.Organization>
		getOrganizations() {

		return getService().getOrganizations();
	}

	public static java.util.List<com.liferay.portal.kernel.model.Organization>
		getOrganizationsByParentIdAndType(long parentId, String type) {

		return getService().getOrganizationsByParentIdAndType(parentId, type);
	}

	public static java.util.List<com.liferay.portal.kernel.model.Organization>
		getOrganizationsByType(String type) {

		return getService().getOrganizationsByType(type);
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

	public static com.adjecti.mdm.liferay.model.OrganizationDetail
		getSectionByUnitCodeAndSectionCode(
			String unitCode, String sectionCode) {

		return getService().getSectionByUnitCodeAndSectionCode(
			unitCode, sectionCode);
	}

	public static java.util.List
		<com.adjecti.mdm.liferay.model.OrganizationDetail> getSections(
			long unitId) {

		return getService().getSections(unitId);
	}

	public static java.util.List
		<com.adjecti.mdm.liferay.model.OrganizationDetail> getSectionsByCode(
			String organizationCode) {

		return getService().getSectionsByCode(organizationCode);
	}

	public static java.util.List
		<com.adjecti.mdm.liferay.model.OrganizationDetail> getSectionsByUnitId(
			long unitId) {

		return getService().getSectionsByUnitId(unitId);
	}

	public static int getSectionsCount(long unitId) {
		return getService().getSectionsCount(unitId);
	}

	public static int getSectionsCountByCode(String organizationCode) {
		return getService().getSectionsCountByCode(organizationCode);
	}

	public static int getTotalSectionsCount() {
		return getService().getTotalSectionsCount();
	}

	public static java.util.List
		<com.adjecti.mdm.liferay.model.OrganizationDetail> getUnit(
			long divisionId) {

		return getService().getUnit(divisionId);
	}

	public static java.util.List
		<com.adjecti.mdm.liferay.model.OrganizationDetail> getUnits() {

		return getService().getUnits();
	}

	public static java.util.List
		<com.adjecti.mdm.liferay.model.OrganizationDetail> getUnitsByDivisionId(
			long divisionId) {

		return getService().getUnitsByDivisionId(divisionId);
	}

	public static int getUnitsCount() {
		return getService().getUnitsCount();
	}

	public static java.util.Map<String, String> importOrganizationDetail(
		java.util.List<java.util.Map<String, String[]>> records) {

		return getService().importOrganizationDetail(records);
	}

	public static java.util.Map<String, String> importOrganizationDetail_Old(
		java.util.List<java.util.Map<String, String[]>> records) {

		return getService().importOrganizationDetail_Old(records);
	}

	public static boolean removeOrganizationDetailByOrganizationId(
		long organizationDeatailId) {

		return getService().removeOrganizationDetailByOrganizationId(
			organizationDeatailId);
	}

	public static com.liferay.portal.kernel.model.Organization saveOrganization(
			long organizationId, String code, String unitType, String name,
			String description, String type, long parentId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			String comments)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().saveOrganization(
			organizationId, code, unitType, name, description, type, parentId,
			serviceContext, comments);
	}

	public static java.util.List
		<com.adjecti.mdm.liferay.model.OrganizationDetail>
			searchOrganizationDetails(
				java.util.Map<String, String> searchFilter) {

		return getService().searchOrganizationDetails(searchFilter);
	}

	public static java.util.List<com.liferay.portal.kernel.model.Organization>
		syncUnits() {

		return getService().syncUnits();
	}

	public static com.adjecti.mdm.liferay.model.OrganizationDetail
		updateOrganizationDetail(
			com.liferay.portal.kernel.model.Organization org) {

		return getService().updateOrganizationDetail(org);
	}

	public static com.adjecti.mdm.liferay.model.OrganizationDetail
		updateOrganizationDetail(
			com.liferay.portal.kernel.model.Organization org, String code,
			String longName, String parentCode, String unitType,
			String orgStatus) {

		return getService().updateOrganizationDetail(
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
	public static com.adjecti.mdm.liferay.model.OrganizationDetail
		updateOrganizationDetail(
			com.adjecti.mdm.liferay.model.OrganizationDetail
				organizationDetail) {

		return getService().updateOrganizationDetail(organizationDetail);
	}

	public static com.liferay.portal.kernel.model.Organization updateStatus(
		com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay,
		String status, long organizationId) {

		return getService().updateStatus(themeDisplay, status, organizationId);
	}

	public static OrganizationDetailLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<OrganizationDetailLocalService, OrganizationDetailLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			OrganizationDetailLocalService.class);

		ServiceTracker
			<OrganizationDetailLocalService, OrganizationDetailLocalService>
				serviceTracker =
					new ServiceTracker
						<OrganizationDetailLocalService,
						 OrganizationDetailLocalService>(
							 bundle.getBundleContext(),
							 OrganizationDetailLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}