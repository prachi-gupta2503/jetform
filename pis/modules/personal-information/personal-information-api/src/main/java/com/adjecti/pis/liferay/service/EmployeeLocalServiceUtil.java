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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Employee. This utility wraps
 * <code>com.adjecti.pis.liferay.service.impl.EmployeeLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeLocalService
 * @generated
 */
public class EmployeeLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.adjecti.pis.liferay.service.impl.EmployeeLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the employee to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employee the employee
	 * @return the employee that was added
	 */
	public static com.adjecti.pis.liferay.model.Employee addEmployee(
		com.adjecti.pis.liferay.model.Employee employee) {

		return getService().addEmployee(employee);
	}

	public static long addEmployee(long peopleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addEmployee(peopleId);
	}

	public static boolean beforeUpdateEmployee(
		Object entity, java.util.Map<String, String[]> fieldValues) {

		return getService().beforeUpdateEmployee(entity, fieldValues);
	}

	/**
	 * Creates a new employee with the primary key. Does not add the employee to the database.
	 *
	 * @param employeeId the primary key for the new employee
	 * @return the new employee
	 */
	public static com.adjecti.pis.liferay.model.Employee createEmployee(
		long employeeId) {

		return getService().createEmployee(employeeId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			createPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	public static void deleteAllData()
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().deleteAllData();
	}

	public static void deleteByEmployeeId(long employeeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().deleteByEmployeeId(employeeId);
	}

	/**
	 * Deletes the employee from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employee the employee
	 * @return the employee that was removed
	 */
	public static com.adjecti.pis.liferay.model.Employee deleteEmployee(
		com.adjecti.pis.liferay.model.Employee employee) {

		return getService().deleteEmployee(employee);
	}

	/**
	 * Deletes the employee with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeId the primary key of the employee
	 * @return the employee that was removed
	 * @throws PortalException if a employee with the primary key could not be found
	 */
	public static com.adjecti.pis.liferay.model.Employee deleteEmployee(
			long employeeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteEmployee(employeeId);
	}

	public static void deleteEmployee(long employeeId, boolean cascade)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().deleteEmployee(employeeId, cascade);
	}

	public static void deleteEmployeeAssociations(
			com.adjecti.pis.liferay.model.Employee employee)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().deleteEmployeeAssociations(employee);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeModelImpl</code>.
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

	public static com.liferay.portal.kernel.json.JSONObject entityToJson(
			com.adjecti.pis.liferay.model.Employee employee)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().entityToJson(employee);
	}

	public static com.liferay.portal.kernel.json.JSONArray entityToJsonArray(
			java.util.List<com.adjecti.pis.liferay.model.Employee> employeeList,
			long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().entityToJsonArray(employeeList, userId);
	}

	public static com.adjecti.pis.liferay.model.Employee fetchEmployee(
		long employeeId) {

		return getService().fetchEmployee(employeeId);
	}

	/**
	 * Returns the employee matching the UUID and group.
	 *
	 * @param uuid the employee's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static com.adjecti.pis.liferay.model.Employee
		fetchEmployeeByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchEmployeeByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.json.JSONArray getByDateOfBirth(
			String designationGroupName)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getByDateOfBirth(designationGroupName);
	}

	public static com.liferay.portal.kernel.json.JSONArray getByGradeName(
			String gradeName)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getByGradeName(gradeName);
	}

	public static com.liferay.portal.kernel.json.JSONArray getByRetirementMonth(
			int year, int month, long organizationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getByRetirementMonth(year, month, organizationId);
	}

	public static java.util.List<com.adjecti.pis.liferay.model.Employee>
		getBySubOrganizationId(long subOrganizationId) {

		return getService().getBySubOrganizationId(subOrganizationId);
	}

	public static com.liferay.portal.kernel.json.JSONArray getByTradeName(
			String tradeName)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getByTradeName(tradeName);
	}

	/**
	 * Returns the employee with the primary key.
	 *
	 * @param employeeId the primary key of the employee
	 * @return the employee
	 * @throws PortalException if a employee with the primary key could not be found
	 */
	public static com.adjecti.pis.liferay.model.Employee getEmployee(
			long employeeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getEmployee(employeeId);
	}

	public static java.util.List<com.adjecti.pis.liferay.model.Employee>
		getEmployeeByCadreId(long cadreId) {

		return getService().getEmployeeByCadreId(cadreId);
	}

	public static java.util.List<com.adjecti.pis.liferay.model.Employee>
		getEmployeeByDesignationGroupId(long designationGroupId) {

		return getService().getEmployeeByDesignationGroupId(designationGroupId);
	}

	public static java.util.List<com.adjecti.pis.liferay.model.Employee>
		getEmployeeByDesignationId(long designationId) {

		return getService().getEmployeeByDesignationId(designationId);
	}

	public static com.adjecti.pis.liferay.model.Employee getEmployeeByEmailId(
			String emailId)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getService().getEmployeeByEmailId(emailId);
	}

	public static com.adjecti.pis.liferay.model.Employee
			getEmployeeByEmployeeId(long employeeId)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getService().getEmployeeByEmployeeId(employeeId);
	}

	public static java.util.List<com.adjecti.pis.liferay.model.Employee>
		getEmployeeByGradeId(long gradeId) {

		return getService().getEmployeeByGradeId(gradeId);
	}

	public static com.adjecti.pis.liferay.model.Employee getEmployeeByLoginId(
		String loginId) {

		return getService().getEmployeeByLoginId(loginId);
	}

	public static java.util.List<com.adjecti.pis.liferay.model.Employee>
		getEmployeeByorgAndTradeAndGradeAndDesignationAndGroupId(
			long unitId, long groupId, long tradeId, long gradeId,
			long designationId) {

		return getService().
			getEmployeeByorgAndTradeAndGradeAndDesignationAndGroupId(
				unitId, groupId, tradeId, gradeId, designationId);
	}

	public static java.util.List<com.adjecti.pis.liferay.model.Employee>
		getEmployeeByOrganizationId(long organizationId) {

		return getService().getEmployeeByOrganizationId(organizationId);
	}

	public static com.adjecti.pis.liferay.model.Employee
			getEmployeeByPersonalNo(String personalNo)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getService().getEmployeeByPersonalNo(personalNo);
	}

	public static com.liferay.portal.kernel.json.JSONArray
			getEmployeeBySearchFilter(
				long organizationId, long tradeId, long gradeId,
				long designationId, long designationGroup, long cadreId,
				String keywords)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getEmployeeBySearchFilter(
			organizationId, tradeId, gradeId, designationId, designationGroup,
			cadreId, keywords);
	}

	public static java.util.List<com.adjecti.pis.liferay.model.Employee>
		getEmployeeByTradeId(long tradeId) {

		return getService().getEmployeeByTradeId(tradeId);
	}

	/**
	 * Returns the employee matching the UUID and group.
	 *
	 * @param uuid the employee's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee
	 * @throws PortalException if a matching employee could not be found
	 */
	public static com.adjecti.pis.liferay.model.Employee
			getEmployeeByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getEmployeeByUuidAndGroupId(uuid, groupId);
	}

	public static int getEmployeeCountByCadreId(long cadreId) {
		return getService().getEmployeeCountByCadreId(cadreId);
	}

	public static int getEmployeeCountByDesignationGroupId(
		long designationGroupId) {

		return getService().getEmployeeCountByDesignationGroupId(
			designationGroupId);
	}

	public static int getEmployeeCountByDesignationId(long designationId) {
		return getService().getEmployeeCountByDesignationId(designationId);
	}

	public static int getEmployeeCountByGradeId(long gradeId) {
		return getService().getEmployeeCountByGradeId(gradeId);
	}

	public static int getEmployeeCountByTradeId(long tradeId) {
		return getService().getEmployeeCountByTradeId(tradeId);
	}

	public static String getEmployeeGroupCode(long employeeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getEmployeeGroupCode(employeeId);
	}

	public static com.liferay.portal.kernel.json.JSONArray getEmployeeList()
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getEmployeeList();
	}

	public static com.liferay.portal.kernel.json.JSONArray getEmployeeList(
			java.util.Map<String, String[]> parameters)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getEmployeeList(parameters);
	}

	public static com.liferay.portal.kernel.json.JSONArray getEmployees()
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getEmployees();
	}

	/**
	 * Returns a range of all the employees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of employees
	 */
	public static java.util.List<com.adjecti.pis.liferay.model.Employee>
		getEmployees(int start, int end) {

		return getService().getEmployees(start, end);
	}

	public static com.liferay.portal.kernel.json.JSONArray getEmployees(
			java.util.Map<String, String> parameters)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getEmployees(parameters);
	}

	public static com.liferay.portal.kernel.json.JSONArray
			getEmployeesByKeywords(
				long organizationId, long tradeId, long gradeId,
				long designationId, long designationGroupId, String keywords)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getEmployeesByKeywords(
			organizationId, tradeId, gradeId, designationId, designationGroupId,
			keywords);
	}

	public static java.util.List<com.adjecti.pis.liferay.model.Employee>
		getEmployeesByOrganizationIdAndPersonalNo(
			long organizationId, String personalNo) {

		return getService().getEmployeesByOrganizationIdAndPersonalNo(
			organizationId, personalNo);
	}

	public static java.util.List<com.adjecti.pis.liferay.model.Employee>
		getEmployeesBySubOrganizationId(long subOrganizationId) {

		return getService().getEmployeesBySubOrganizationId(subOrganizationId);
	}

	/**
	 * Returns all the employees matching the UUID and company.
	 *
	 * @param uuid the UUID of the employees
	 * @param companyId the primary key of the company
	 * @return the matching employees, or an empty list if no matches were found
	 */
	public static java.util.List<com.adjecti.pis.liferay.model.Employee>
		getEmployeesByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getEmployeesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of employees matching the UUID and company.
	 *
	 * @param uuid the UUID of the employees
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching employees, or an empty list if no matches were found
	 */
	public static java.util.List<com.adjecti.pis.liferay.model.Employee>
		getEmployeesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.adjecti.pis.liferay.model.Employee> orderByComparator) {

		return getService().getEmployeesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of employees.
	 *
	 * @return the number of employees
	 */
	public static int getEmployeesCount() {
		return getService().getEmployeesCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static java.util.List<com.adjecti.pis.liferay.model.Employee>
		getGradeModeByGradeModeId(long gradeModeId) {

		return getService().getGradeModeByGradeModeId(gradeModeId);
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

	public static java.util.List<com.liferay.portal.kernel.model.Organization>
		getUserUnit() {

		return getService().getUserUnit();
	}

	public static void initEmployeesList() {
		getService().initEmployeesList();
	}

	public static boolean isApprover(long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().isApprover(userId);
	}

	public static boolean isCreater(long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().isCreater(userId);
	}

	public static boolean isUnique(
		long employeeId, java.util.Map<String, String> fieldValues) {

		return getService().isUnique(employeeId, fieldValues);
	}

	public static void onOrganizationDetailBeforeUpdate(
		com.adjecti.mdm.liferay.model.OrganizationDetail oldObject,
		com.adjecti.mdm.liferay.model.OrganizationDetail newObject) {

		getService().onOrganizationDetailBeforeUpdate(oldObject, newObject);
	}

	public static void performWorkFlowAction(long employeeId, String action)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().performWorkFlowAction(employeeId, action);
	}

	public static java.util.List<com.adjecti.pis.liferay.model.Employee>
		searchEmployeeModel(
			java.util.Map<String, String> searchFilter, String orderBy) {

		return getService().searchEmployeeModel(searchFilter, orderBy);
	}

	public static com.liferay.portal.kernel.json.JSONArray searchEmployees(
			long organizationId, long tradeId, long gradeId, long designationId,
			long designationGroup, long cadreId, String keywords, int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().searchEmployees(
			organizationId, tradeId, gradeId, designationId, designationGroup,
			cadreId, keywords, status);
	}

	public static java.util.List<com.adjecti.pis.liferay.model.Employee>
		searchEmployees(java.util.Map<String, String> searchFilter) {

		return getService().searchEmployees(searchFilter);
	}

	public static java.util.List<com.adjecti.pis.liferay.model.Employee>
		searchEmployees(
			java.util.Map<String, String[]> searchFilter, String orderBy) {

		return getService().searchEmployees(searchFilter, orderBy);
	}

	public static void submitEmployeeJoining(long employeeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().submitEmployeeJoining(employeeId);
	}

	/**
	 * Updates the employee in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employee the employee
	 * @return the employee that was updated
	 */
	public static com.adjecti.pis.liferay.model.Employee updateEmployee(
		com.adjecti.pis.liferay.model.Employee employee) {

		return getService().updateEmployee(employee);
	}

	public static boolean updateIDAMUser(
		com.adjecti.pis.liferay.model.Employee employee,
		java.util.Map<String, String[]> fieldValues) {

		return getService().updateIDAMUser(employee, fieldValues);
	}

	public static boolean updateIDAMUser(
		long employeeId, java.util.Map<String, String[]> fieldValues) {

		return getService().updateIDAMUser(employeeId, fieldValues);
	}

	public static com.adjecti.pis.liferay.model.Employee updateStatus(
			long userId, long employeeId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return getService().updateStatus(
			userId, employeeId, status, serviceContext);
	}

	public static EmployeeLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<EmployeeLocalService, EmployeeLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(EmployeeLocalService.class);

		ServiceTracker<EmployeeLocalService, EmployeeLocalService>
			serviceTracker =
				new ServiceTracker<EmployeeLocalService, EmployeeLocalService>(
					bundle.getBundleContext(), EmployeeLocalService.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}