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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EmployeeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeLocalService
 * @generated
 */
public class EmployeeLocalServiceWrapper
	implements EmployeeLocalService, ServiceWrapper<EmployeeLocalService> {

	public EmployeeLocalServiceWrapper(
		EmployeeLocalService employeeLocalService) {

		_employeeLocalService = employeeLocalService;
	}

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
	@Override
	public com.adjecti.pis.liferay.model.Employee addEmployee(
		com.adjecti.pis.liferay.model.Employee employee) {

		return _employeeLocalService.addEmployee(employee);
	}

	@Override
	public long addEmployee(long peopleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeLocalService.addEmployee(peopleId);
	}

	@Override
	public boolean beforeUpdateEmployee(
		Object entity, java.util.Map<String, String[]> fieldValues) {

		return _employeeLocalService.beforeUpdateEmployee(entity, fieldValues);
	}

	/**
	 * Creates a new employee with the primary key. Does not add the employee to the database.
	 *
	 * @param employeeId the primary key for the new employee
	 * @return the new employee
	 */
	@Override
	public com.adjecti.pis.liferay.model.Employee createEmployee(
		long employeeId) {

		return _employeeLocalService.createEmployee(employeeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeLocalService.createPersistedModel(primaryKeyObj);
	}

	@Override
	public void deleteAllData()
		throws com.liferay.portal.kernel.exception.PortalException {

		_employeeLocalService.deleteAllData();
	}

	@Override
	public void deleteByEmployeeId(long employeeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_employeeLocalService.deleteByEmployeeId(employeeId);
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
	@Override
	public com.adjecti.pis.liferay.model.Employee deleteEmployee(
		com.adjecti.pis.liferay.model.Employee employee) {

		return _employeeLocalService.deleteEmployee(employee);
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
	@Override
	public com.adjecti.pis.liferay.model.Employee deleteEmployee(
			long employeeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeLocalService.deleteEmployee(employeeId);
	}

	@Override
	public void deleteEmployee(long employeeId, boolean cascade)
		throws com.liferay.portal.kernel.exception.PortalException {

		_employeeLocalService.deleteEmployee(employeeId, cascade);
	}

	@Override
	public void deleteEmployeeAssociations(
			com.adjecti.pis.liferay.model.Employee employee)
		throws com.liferay.portal.kernel.exception.PortalException {

		_employeeLocalService.deleteEmployeeAssociations(employee);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeeLocalService.dynamicQuery();
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

		return _employeeLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _employeeLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _employeeLocalService.dynamicQuery(
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

		return _employeeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _employeeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject entityToJson(
			com.adjecti.pis.liferay.model.Employee employee)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeLocalService.entityToJson(employee);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray entityToJsonArray(
			java.util.List<com.adjecti.pis.liferay.model.Employee> employeeList,
			long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeLocalService.entityToJsonArray(employeeList, userId);
	}

	@Override
	public com.adjecti.pis.liferay.model.Employee fetchEmployee(
		long employeeId) {

		return _employeeLocalService.fetchEmployee(employeeId);
	}

	/**
	 * Returns the employee matching the UUID and group.
	 *
	 * @param uuid the employee's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee, or <code>null</code> if a matching employee could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.Employee fetchEmployeeByUuidAndGroupId(
		String uuid, long groupId) {

		return _employeeLocalService.fetchEmployeeByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _employeeLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getByDateOfBirth(
			String designationGroupName)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeLocalService.getByDateOfBirth(designationGroupName);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getByGradeName(
			String gradeName)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeLocalService.getByGradeName(gradeName);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getByRetirementMonth(
			int year, int month, long organizationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeLocalService.getByRetirementMonth(
			year, month, organizationId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.Employee>
		getBySubOrganizationId(long subOrganizationId) {

		return _employeeLocalService.getBySubOrganizationId(subOrganizationId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getByTradeName(
			String tradeName)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeLocalService.getByTradeName(tradeName);
	}

	/**
	 * Returns the employee with the primary key.
	 *
	 * @param employeeId the primary key of the employee
	 * @return the employee
	 * @throws PortalException if a employee with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.Employee getEmployee(long employeeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeLocalService.getEmployee(employeeId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.Employee>
		getEmployeeByCadreId(long cadreId) {

		return _employeeLocalService.getEmployeeByCadreId(cadreId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.Employee>
		getEmployeeByDesignationGroupId(long designationGroupId) {

		return _employeeLocalService.getEmployeeByDesignationGroupId(
			designationGroupId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.Employee>
		getEmployeeByDesignationId(long designationId) {

		return _employeeLocalService.getEmployeeByDesignationId(designationId);
	}

	@Override
	public com.adjecti.pis.liferay.model.Employee getEmployeeByEmailId(
			String emailId)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return _employeeLocalService.getEmployeeByEmailId(emailId);
	}

	@Override
	public com.adjecti.pis.liferay.model.Employee getEmployeeByEmployeeId(
			long employeeId)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return _employeeLocalService.getEmployeeByEmployeeId(employeeId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.Employee>
		getEmployeeByGradeId(long gradeId) {

		return _employeeLocalService.getEmployeeByGradeId(gradeId);
	}

	@Override
	public com.adjecti.pis.liferay.model.Employee getEmployeeByLoginId(
		String loginId) {

		return _employeeLocalService.getEmployeeByLoginId(loginId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.Employee>
		getEmployeeByorgAndTradeAndGradeAndDesignationAndGroupId(
			long unitId, long groupId, long tradeId, long gradeId,
			long designationId) {

		return _employeeLocalService.
			getEmployeeByorgAndTradeAndGradeAndDesignationAndGroupId(
				unitId, groupId, tradeId, gradeId, designationId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.Employee>
		getEmployeeByOrganizationId(long organizationId) {

		return _employeeLocalService.getEmployeeByOrganizationId(
			organizationId);
	}

	@Override
	public com.adjecti.pis.liferay.model.Employee getEmployeeByPersonalNo(
			String personalNo)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return _employeeLocalService.getEmployeeByPersonalNo(personalNo);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getEmployeeBySearchFilter(
			long organizationId, long tradeId, long gradeId, long designationId,
			long designationGroup, long cadreId, String keywords)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeLocalService.getEmployeeBySearchFilter(
			organizationId, tradeId, gradeId, designationId, designationGroup,
			cadreId, keywords);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.Employee>
		getEmployeeByTradeId(long tradeId) {

		return _employeeLocalService.getEmployeeByTradeId(tradeId);
	}

	/**
	 * Returns the employee matching the UUID and group.
	 *
	 * @param uuid the employee's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee
	 * @throws PortalException if a matching employee could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.Employee getEmployeeByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeLocalService.getEmployeeByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public int getEmployeeCountByCadreId(long cadreId) {
		return _employeeLocalService.getEmployeeCountByCadreId(cadreId);
	}

	@Override
	public int getEmployeeCountByDesignationGroupId(long designationGroupId) {
		return _employeeLocalService.getEmployeeCountByDesignationGroupId(
			designationGroupId);
	}

	@Override
	public int getEmployeeCountByDesignationId(long designationId) {
		return _employeeLocalService.getEmployeeCountByDesignationId(
			designationId);
	}

	@Override
	public int getEmployeeCountByGradeId(long gradeId) {
		return _employeeLocalService.getEmployeeCountByGradeId(gradeId);
	}

	@Override
	public int getEmployeeCountByTradeId(long tradeId) {
		return _employeeLocalService.getEmployeeCountByTradeId(tradeId);
	}

	@Override
	public String getEmployeeGroupCode(long employeeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeLocalService.getEmployeeGroupCode(employeeId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getEmployeeList()
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeLocalService.getEmployeeList();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getEmployeeList(
			java.util.Map<String, String[]> parameters)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeLocalService.getEmployeeList(parameters);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getEmployees()
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeLocalService.getEmployees();
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
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.Employee> getEmployees(
		int start, int end) {

		return _employeeLocalService.getEmployees(start, end);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getEmployees(
			java.util.Map<String, String> parameters)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeLocalService.getEmployees(parameters);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getEmployeesByKeywords(
			long organizationId, long tradeId, long gradeId, long designationId,
			long designationGroupId, String keywords)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeLocalService.getEmployeesByKeywords(
			organizationId, tradeId, gradeId, designationId, designationGroupId,
			keywords);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.Employee>
		getEmployeesByOrganizationIdAndPersonalNo(
			long organizationId, String personalNo) {

		return _employeeLocalService.getEmployeesByOrganizationIdAndPersonalNo(
			organizationId, personalNo);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.Employee>
		getEmployeesBySubOrganizationId(long subOrganizationId) {

		return _employeeLocalService.getEmployeesBySubOrganizationId(
			subOrganizationId);
	}

	/**
	 * Returns all the employees matching the UUID and company.
	 *
	 * @param uuid the UUID of the employees
	 * @param companyId the primary key of the company
	 * @return the matching employees, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.Employee>
		getEmployeesByUuidAndCompanyId(String uuid, long companyId) {

		return _employeeLocalService.getEmployeesByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.Employee>
		getEmployeesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.adjecti.pis.liferay.model.Employee> orderByComparator) {

		return _employeeLocalService.getEmployeesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of employees.
	 *
	 * @return the number of employees
	 */
	@Override
	public int getEmployeesCount() {
		return _employeeLocalService.getEmployeesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _employeeLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.Employee>
		getGradeModeByGradeModeId(long gradeModeId) {

		return _employeeLocalService.getGradeModeByGradeModeId(gradeModeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _employeeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.model.Organization>
		getUserUnit() {

		return _employeeLocalService.getUserUnit();
	}

	@Override
	public void initEmployeesList() {
		_employeeLocalService.initEmployeesList();
	}

	@Override
	public boolean isApprover(long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeLocalService.isApprover(userId);
	}

	@Override
	public boolean isCreater(long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeLocalService.isCreater(userId);
	}

	@Override
	public boolean isUnique(
		long employeeId, java.util.Map<String, String> fieldValues) {

		return _employeeLocalService.isUnique(employeeId, fieldValues);
	}

	@Override
	public void onOrganizationDetailBeforeUpdate(
		com.adjecti.mdm.liferay.model.OrganizationDetail oldObject,
		com.adjecti.mdm.liferay.model.OrganizationDetail newObject) {

		_employeeLocalService.onOrganizationDetailBeforeUpdate(
			oldObject, newObject);
	}

	@Override
	public void performWorkFlowAction(long employeeId, String action)
		throws com.liferay.portal.kernel.exception.PortalException {

		_employeeLocalService.performWorkFlowAction(employeeId, action);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.Employee>
		searchEmployeeModel(
			java.util.Map<String, String> searchFilter, String orderBy) {

		return _employeeLocalService.searchEmployeeModel(searchFilter, orderBy);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray searchEmployees(
			long organizationId, long tradeId, long gradeId, long designationId,
			long designationGroup, long cadreId, String keywords, int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeLocalService.searchEmployees(
			organizationId, tradeId, gradeId, designationId, designationGroup,
			cadreId, keywords, status);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.Employee>
		searchEmployees(java.util.Map<String, String> searchFilter) {

		return _employeeLocalService.searchEmployees(searchFilter);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.Employee>
		searchEmployees(
			java.util.Map<String, String[]> searchFilter, String orderBy) {

		return _employeeLocalService.searchEmployees(searchFilter, orderBy);
	}

	@Override
	public void submitEmployeeJoining(long employeeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_employeeLocalService.submitEmployeeJoining(employeeId);
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
	@Override
	public com.adjecti.pis.liferay.model.Employee updateEmployee(
		com.adjecti.pis.liferay.model.Employee employee) {

		return _employeeLocalService.updateEmployee(employee);
	}

	@Override
	public boolean updateIDAMUser(
		com.adjecti.pis.liferay.model.Employee employee,
		java.util.Map<String, String[]> fieldValues) {

		return _employeeLocalService.updateIDAMUser(employee, fieldValues);
	}

	@Override
	public boolean updateIDAMUser(
		long employeeId, java.util.Map<String, String[]> fieldValues) {

		return _employeeLocalService.updateIDAMUser(employeeId, fieldValues);
	}

	@Override
	public com.adjecti.pis.liferay.model.Employee updateStatus(
			long userId, long employeeId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _employeeLocalService.updateStatus(
			userId, employeeId, status, serviceContext);
	}

	@Override
	public EmployeeLocalService getWrappedService() {
		return _employeeLocalService;
	}

	@Override
	public void setWrappedService(EmployeeLocalService employeeLocalService) {
		_employeeLocalService = employeeLocalService;
	}

	private EmployeeLocalService _employeeLocalService;

}