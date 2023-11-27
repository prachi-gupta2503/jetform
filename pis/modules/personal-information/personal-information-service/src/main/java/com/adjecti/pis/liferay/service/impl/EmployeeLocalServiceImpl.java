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

package com.adjecti.pis.liferay.service.impl;

import com.adjecti.common.util.DateUtils;
import com.adjecti.common.util.ReflectionUtil;
import com.adjecti.mdm.liferay.enumeration.model.CasteCategory;
import com.adjecti.mdm.liferay.enumeration.model.Gender;
import com.adjecti.mdm.liferay.model.Designation;
import com.adjecti.mdm.liferay.model.DesignationGroup;
import com.adjecti.mdm.liferay.model.Grade;
import com.adjecti.mdm.liferay.model.OrganizationDetail;
import com.adjecti.mdm.liferay.model.Trade;
import com.adjecti.mdm.liferay.service.CasteCategoryLocalServiceUtil;
import com.adjecti.mdm.liferay.service.DesignationGroupLocalServiceUtil;
import com.adjecti.mdm.liferay.service.DesignationLocalServiceUtil;
import com.adjecti.mdm.liferay.service.EnumerationEntityServiceUtil;
import com.adjecti.mdm.liferay.service.GenderLocalServiceUtil;
import com.adjecti.mdm.liferay.service.GradeLocalServiceUtil;
import com.adjecti.mdm.liferay.service.OrganizationDetailLocalServiceUtil;
import com.adjecti.mdm.liferay.service.TradeLocalServiceUtil;
import com.adjecti.pis.liferay.constant.PISUserRole;
import com.adjecti.pis.liferay.exception.NoSuchEmployeeException;
import com.adjecti.pis.liferay.model.Contact;
import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.liferay.model.EmployeeAddress;
import com.adjecti.pis.liferay.model.EmployeeApplication;
import com.adjecti.pis.liferay.model.EmployeeContact;
import com.adjecti.pis.liferay.model.EmployeeDocument;
import com.adjecti.pis.liferay.model.EmployeeJoining;
import com.adjecti.pis.liferay.model.EmployeePastExperience;
import com.adjecti.pis.liferay.model.EmployeeQualification;
import com.adjecti.pis.liferay.model.EmployeeVerification;
import com.adjecti.pis.liferay.model.People;
import com.adjecti.pis.liferay.model.impl.EmployeeImpl;
import com.adjecti.pis.liferay.model.impl.EmployeeJoiningImpl;
import com.adjecti.pis.liferay.model.impl.PeopleImpl;
import com.adjecti.pis.liferay.service.ContactLocalServiceUtil;
import com.adjecti.pis.liferay.service.EmployeeContactLocalServiceUtil;
import com.adjecti.pis.liferay.service.EmployeeJoiningLocalServiceUtil;
import com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil;
import com.adjecti.pis.liferay.service.PeopleLocalServiceUtil;
import com.adjecti.pis.liferay.service.base.EmployeeLocalServiceBaseImpl;
import com.adjecti.pis.liferay.util.PISUserUtil;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetLinkConstants;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroupRole;
import com.liferay.portal.kernel.model.WorkflowInstanceLink;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalServiceUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowLog;
import com.liferay.portal.kernel.workflow.WorkflowLogManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowTask;
import com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil;
import com.liferay.portal.kernel.workflow.comparator.WorkflowComparatorFactoryUtil;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the employee local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.adjecti.pis.liferay.service.EmployeeLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.adjecti.pis.liferay.model.Employee", service = AopService.class)
public class EmployeeLocalServiceImpl extends EmployeeLocalServiceBaseImpl {

	final static Log LOGGER = LogFactoryUtil.getLog(EmployeeLocalServiceImpl.class.getName());

	@Indexable(type = IndexableType.REINDEX)
	public long addEmployee(long peopleId) throws PortalException {
		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		long userId = serviceContext.getUserId();
		User user = userLocalService.getUser(userId);
		long companyId = user.getCompanyId();

		long groupId = getUserOrgGroupId(user, serviceContext);


		long employeeId = counterLocalService.increment(Employee.class.getName());

		Employee employee = employeeLocalService.createEmployee(employeeId);

		employee.setEmployeeId(employeeId);
		employee.setGroupId(groupId);
		employee.setUserId(userId);
		employee.setCompanyId(companyId);
		employee.setUserName(user.getFullName());
		employee.setPeopleId(peopleId);
		employee.setStatus(WorkflowConstants.STATUS_DRAFT);
		employee = super.addEmployee(employee);

		return employee.getEmployeeId();

	}

	private long getUserOrgGroupId(User user, ServiceContext serviceContext) {
		List<Organization> organizations;
		try {
			organizations = user.getOrganizations();
			for (Organization organization : organizations) {
				return organization.getGroupId();
			}
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return serviceContext.getScopeGroupId();
	}


	public void submitEmployeeJoining(long employeeId) throws PortalException {

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		long userId = serviceContext.getUserId();
		User user = userLocalService.getUser(userId);

		Employee employee = employeePersistence.fetchByEmployeeId(employeeId);

		Organization organization=OrganizationLocalServiceUtil.getOrganization(employee.getOrganizationId());
		long groupId=organization.getGroupId();
		employee.setStatus(WorkflowConstants.STATUS_DRAFT);
		employee.setState("DRAFT");
		employee.setStatusByUserId(userId);
		employee.setStatusByUserName(user.getFullName());
		employee.setStatusDate(serviceContext.getModifiedDate(null));
		employee.setGroupId(groupId);



		employeePersistence.update(employee);

		AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId, groupId, employee.getCreateDate(),
				employee.getModifiedDate(), Employee.class.getName(), employeeId, employee.getUuid(), 0,
				serviceContext.getAssetCategoryIds(), serviceContext.getAssetTagNames(), true, true, null, null, null,
				null, ContentTypes.TEXT_HTML, employee.getUserName(), null, null, null, null, 0, 0, null);

		assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(), serviceContext.getAssetLinkEntryIds(),
				AssetLinkConstants.TYPE_RELATED);

		WorkflowHandlerRegistryUtil.startWorkflowInstance(employee.getCompanyId(), groupId,
				employee.getUserId(), Employee.class.getName(), employee.getPrimaryKey(), employee, serviceContext);

	}

	@Override
	@Indexable(type = IndexableType.REINDEX)
	public Employee updateEmployee(Employee employee) {
		return super.updateEmployee(employee);
	}

	@Override
	@Indexable(type = IndexableType.DELETE)
	public Employee deleteEmployee(long employeeId) throws PortalException {
		return super.deleteEmployee(employeeId);
	}

	public List<Employee> getEmployeeByOrganizationId(long organizationId) {
		return employeePersistence.findByOrganizationId(organizationId);
	}

	public List<Employee> getEmployeesBySubOrganizationId(long subOrganizationId) {
		return employeePersistence.findBySubOrganizationId(subOrganizationId);
	}

	public List<Employee> getEmployeeByorgAndTradeAndGradeAndDesignationAndGroupId(long unitId, long groupId,
			long tradeId, long gradeId, long designationId) {
		return employeePersistence.findByorgAndTradeAndGradeAndDesignationAndGroupId(unitId, groupId, tradeId, gradeId,
				designationId);
	}

	public Employee getEmployeeByEmployeeId(long employeeId) throws NoSuchEmployeeException {
		try {
			return employeePersistence.findByEmployeeId(employeeId);
		}catch(Exception e) {}
		return null;
	}

	public Employee getEmployeeByPersonalNo(String personalNo) throws NoSuchEmployeeException {
		try {
			return employeePersistence.findByPersonalNo(personalNo);
		}catch(Exception e) {}
		return null;
	}

	public Employee updateStatus(long userId, long employeeId, int status, ServiceContext serviceContext)
			throws PortalException, SystemException {
		User user = userLocalService.getUser(userId);

		Employee employee = getEmployee(employeeId);

		employee.setStatus(status);
		employee.setStatusByUserId(userId);
		employee.setStatusByUserName(user.getFullName());
		employee.setStatusDate(new Date());

		if (status == WorkflowConstants.STATUS_DRAFT)
			employee.setState("DRAFT");
		else if (status == WorkflowConstants.STATUS_APPROVED)
			employee.setState("APPROVED");
		else if (status == WorkflowConstants.STATUS_DENIED)
			employee.setState("REJECTED");
		else if (status == WorkflowConstants.STATUS_PENDING)
			employee.setState("PENDING");
		else if (status == WorkflowConstants.STATUS_SCHEDULED)
			employee.setState("APPROVAL PENDING");

		employeePersistence.update(employee);

		return employee;
	}

	public String getEmployeeGroupCode(long employeeId) throws PortalException {

		Employee employee = employeePersistence.fetchByEmployeeId(employeeId);
		Designation designation=DesignationLocalServiceUtil.getDesignation(employee.getDesignationId());
		DesignationGroup designationGroup=DesignationGroupLocalServiceUtil.getDesignationGroup(designation.getDesignationGroupId());
		return designationGroup.getCode();

	}

	public JSONArray  getEmployeeList() throws PortalException{
		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		User user =userLocalService.getUserById(serviceContext.getUserId());
		List<Employee> employeeList = new ArrayList<>();

		if (PISUserUtil.isCreater(user.getUserId())) {
			employeeList =  getEmployeeListForCreater(user.getUserId());
		}else if (PISUserUtil.isApprover(user.getUserId())){
			employeeList = getEmployeeListForApproval(user.getUserId());


		}
		return entityToJsonArray(employeeList, user.getUserId());
	}

	private List<Employee>  getEmployeeListForCreater(long userId) throws PortalException{
		List<Employee> employees=new ArrayList<Employee>();
		List<Organization> units= PISUserUtil.getUnitsByRole(userId, PISUserRole.CREATER);
		long [] groups =units.stream().mapToLong(org -> org.getGroupId()).toArray();
		if(groups!=null && groups.length>0) {
			employees=  employeePersistence.findByGroupIds(groups);
		}
		return employees;
	}
	private List<Employee>  getEmployeeListForApproval(long userId) throws PortalException{

		List<Organization> units= PISUserUtil.getUnitsByRole(userId, PISUserRole.APPROVER);
		long [] groups =units.stream().mapToLong(org -> org.getGroupId()).toArray();
		int [] status = {WorkflowConstants.STATUS_SCHEDULED};

		return employeePersistence.findByGroupIdAndStatusList(groups, status);
	}

	public List<Organization> getUserUnit(){
		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		User user =null;
		List<Organization> units=new ArrayList<>();
		try {
			user=userLocalService.getUserById(serviceContext.getUserId());
			if(isCreater(user.getUserId()))
				units=PISUserUtil.getUnitsByRole(user.getUserId(), PISUserRole.CREATER);
			else if(isApprover(user.getUserId()))
				units=PISUserUtil.getUnitsByRole(user.getUserId(), PISUserRole.APPROVER);


		} catch (PortalException e) {
			e.printStackTrace();
		}
		return units;
	}

	public boolean isApprover(long userId) throws PortalException {

		List<UserGroupRole> userGroupRoles = UserGroupRoleLocalServiceUtil.getUserGroupRoles(userId);
		boolean isApprover = false;
		for (UserGroupRole role : userGroupRoles) {
			if (role.getRole().getName().equalsIgnoreCase("PIS_GR_A_Approver"))
				isApprover = true;
		}
		return isApprover;

	}

	public boolean isCreater(long userId) throws PortalException {

		List<UserGroupRole> userGroupRoles = UserGroupRoleLocalServiceUtil.getUserGroupRoles(userId);
		boolean isApprover = false;
		for (UserGroupRole role : userGroupRoles) {
			if (role.getRole().getName().equalsIgnoreCase("PIS_GR_A_Entry"))
				isApprover = true;
		}
		return isApprover;

	}



	private Map<Long, Set<String>> getWorkFlowTask(Employee employee, long userId)
			throws PortalException {
		Map<Long, Set<String>> taskActionMap = new HashMap<>();
		if(employee.getStatus()==WorkflowConstants.STATUS_DRAFT)
			return taskActionMap;
		Set<String> actionList = new HashSet<>();

		List<WorkflowLog> workflowLogs_assign = this.getWorkflowLogsAssign(employee);
		if (!workflowLogs_assign.isEmpty()) {
			for (WorkflowLog workflowLog : workflowLogs_assign) {
				long taskId = workflowLog.getWorkflowTaskId();
				WorkflowTask task = WorkflowTaskManagerUtil.getWorkflowTask(employee.getCompanyId(), taskId);
				if (null != task.getCompletionDate())
					continue;

				actionList.addAll(
						WorkflowTaskManagerUtil.getNextTransitionNames(employee.getCompanyId(), userId, taskId));

				taskActionMap.put(taskId, actionList);
			}
			return taskActionMap;
		} else
			return taskActionMap;
	}


	private List<WorkflowLog> getWorkflowLogsAssign(Employee employee) throws PortalException {
		WorkflowInstanceLink wil = WorkflowInstanceLinkLocalServiceUtil.getWorkflowInstanceLink(
				employee.getCompanyId(), employee.getGroupId(), Employee.class.getName(),
				employee.getEmployeeId());
		List<Integer> logTypes_assign = new ArrayList<Integer>();
		logTypes_assign.add(WorkflowLog.TASK_ASSIGN);
		return WorkflowLogManagerUtil.getWorkflowLogsByWorkflowInstance(employee.getCompanyId(),
				wil.getWorkflowInstanceId(), logTypes_assign, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				WorkflowComparatorFactoryUtil.getLogCreateDateComparator(true));

	}



	public JSONArray entityToJsonArray(List<Employee> employeeList, long userId)
			throws PortalException {
		boolean isApprover=false;
		try {
			isApprover=isApprover(userId);
		} catch (PortalException e) {

			e.printStackTrace();
		}
		JSONArray employeeJsonArray = JSONFactoryUtil.createJSONArray();

		for(Employee employee : employeeList) {
			JSONObject jsonObject=entityToJson(employee);
			JSONArray employeeTaskJsonArray = JSONFactoryUtil.createJSONArray();
			if(isApprover) {
				for(String task:getActionList(employee, userId)) {
					employeeTaskJsonArray.put(task);
				}

				jsonObject.put("actionList", employeeTaskJsonArray);
			}
			employeeJsonArray.put(jsonObject);
		}

		return employeeJsonArray; 
	}

	public void performWorkFlowAction(long employeeId, String action)
			throws PortalException {

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		long userId=serviceContext.getUserId();
		Employee employee =employeePersistence.findByPrimaryKey(employeeId);

		WorkflowInstanceLink wil = WorkflowInstanceLinkLocalServiceUtil.getWorkflowInstanceLink(
				employee.getCompanyId(), employee.getGroupId(), Employee.class.getName(),
				employee.getEmployeeId());
		WorkflowInstance workflowInstance = WorkflowInstanceManagerUtil.getWorkflowInstance(employee.getCompanyId(),
				wil.getWorkflowInstanceId());
		Map<String, Serializable> workflowContext = workflowInstance.getWorkflowContext();
		List<Integer> logTypes_assign = new ArrayList<>();
		logTypes_assign.add(WorkflowLog.TASK_ASSIGN);

		List<WorkflowLog> workflowLogs_assign = WorkflowLogManagerUtil.getWorkflowLogsByWorkflowInstance(
				employee.getCompanyId(), wil.getWorkflowInstanceId(), logTypes_assign, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, WorkflowComparatorFactoryUtil.getLogCreateDateComparator(true));

		if (!workflowLogs_assign.isEmpty()) {

			long taskId = workflowLogs_assign.get(workflowLogs_assign.size() - 1).getWorkflowTaskId();
			WorkflowTask task = WorkflowTaskManagerUtil.getWorkflowTask(employee.getCompanyId(), taskId);

			WorkflowTaskManagerUtil.getNextTransitionNames(employee.getCompanyId(), userId, taskId);



			if (task.getAssigneeUserId() <= 0) { // task is not assigned to user
				List<User> userList = WorkflowTaskManagerUtil.getAssignableUsers(employee.getCompanyId(), taskId);

				if (userList.stream().anyMatch(u -> u.getUserId() == userId)) {
					WorkflowTaskManagerUtil.assignWorkflowTaskToUser(employee.getCompanyId(), userId, taskId,
							userId, "Auto assign", task.getDueDate(), workflowContext);
				}

				task = WorkflowTaskManagerUtil.getWorkflowTask(employee.getCompanyId(), taskId);

			}

			WorkflowTaskManagerUtil.getNextTransitionNames(employee.getCompanyId(), userId,taskId);

			if (task.getAssigneeUserId() == userId) {
				WorkflowTaskManagerUtil.completeWorkflowTask(employee.getCompanyId(), employee.getUserId(),
						taskId, action, "next task " + action, workflowContext);
			} 
		}

	}

	public JSONArray getEmployeesByKeywords(long organizationId,long tradeId,long gradeId,long designationId,long designationGroupId,
			String keywords) throws PortalException {
		int status=0;
		ServiceContext context=ServiceContextThreadLocal.getServiceContext();
		boolean isApprover=false;
		try {
			isApprover=isApprover(context.getUserId());
		} catch (PortalException e) {

			e.printStackTrace();
		}
		if(isApprover) {
			status= WorkflowConstants.STATUS_SCHEDULED;
		}
		else {
			status=-2;
		}
		return  searchEmployees( organizationId, tradeId, gradeId, designationId,designationGroupId,0 ,keywords ,status) ;
	}

	public JSONArray getEmployeeBySearchFilter(long organizationId,long tradeId,long gradeId,long designationId, long designationGroup, long cadreId,
			String keywords) throws PortalException{
		LOGGER.info("Method getEmployeeBySearchFilter");
		int status=0;
		return  searchEmployees( organizationId, tradeId, gradeId, designationId,designationGroup,cadreId,keywords ,status) ;

	}

	public JSONArray searchEmployees(long organizationId,long tradeId,long gradeId,long designationId,long designationGroup,long cadreId,
			String keywords ,int status) throws PortalException{
		List<Employee> list=new ArrayList<Employee>();
		ServiceContext context=ServiceContextThreadLocal.getServiceContext();
		boolean isApprover=false;
		try {
			isApprover=isApprover(context.getUserId());
		} catch (PortalException e) {

			e.printStackTrace();
		}

		DynamicQuery employeeQuery =dynamicQuery();
		if(status!=-2) 
			employeeQuery.add(RestrictionsFactoryUtil.eq("status", status));

		if(organizationId!=0) 
			employeeQuery.add(RestrictionsFactoryUtil.eq("organizationId", organizationId));
		if(tradeId!=0)
			employeeQuery.add(RestrictionsFactoryUtil.eq("tradeId", tradeId));
		if(gradeId!=0) 
			employeeQuery.add(RestrictionsFactoryUtil.eq("gradeId", gradeId));
		if(designationId!=0) 
			employeeQuery.add(RestrictionsFactoryUtil.eq("designationId", designationId));
		if(designationGroup!=0) 
			employeeQuery.add(RestrictionsFactoryUtil.eq("designationGroupId", designationGroup));
		if(cadreId!=0) 
			employeeQuery.add(RestrictionsFactoryUtil.eq("cadreId", cadreId));

		List<Employee> employees=EmployeeLocalServiceUtil.dynamicQuery(employeeQuery);

		if(StringUtils.isNotBlank(keywords)) {
			List<People> peoples=PeopleLocalServiceUtil.searchPeople(keywords);

			if(!peoples.isEmpty()) {
				for(Employee employee:employees) {
					for(People people:peoples) {
						if(employee.getPeopleId()==people.getPeopleId())
							list.add(employee);
					}
				}
			}
			employees=list;
		}

		if(status==-2) {
			list=new ArrayList<Employee>();
			System.out.println("Employees "+ employees);
			ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
			User user =userLocalService.getUserById(serviceContext.getUserId());
			List<Employee> createrEmployees= getEmployeeListForCreater(user.getUserId());
			for(Employee employee:employees) {
				for(Employee createrEmployee:createrEmployees) {
					if(employee.getEmployeeId()==createrEmployee.getEmployeeId())
						list.add(employee);
				}
			}
			employees=new ArrayList<>();
			employees=list;
		}

		JSONArray employeeJsonArray = JSONFactoryUtil.createJSONArray();
		for(Employee employee : employees) {
			JSONObject jsonObject=entityToJson(employee);
			JSONArray employeeTaskJsonArray = JSONFactoryUtil.createJSONArray();
			if(isApprover) {
				for(String task:getActionList(employee, context.getUserId())) {
					employeeTaskJsonArray.put(task);
				}
				jsonObject.put("actionList", employeeTaskJsonArray);
			}
			employeeJsonArray.put(jsonObject);
		}
		return employeeJsonArray; 
	}

	public JSONArray getEmployees() throws PortalException{

		List<Employee> employeeList = new ArrayList<>();

		employeeList.addAll(employeePersistence.findByStatus(0));

		JSONArray employeeJsonArray = JSONFactoryUtil.createJSONArray();

		for(Employee employee : employeeList) {
			employeeJsonArray.put(entityToJson(employee));
		}

		return employeeJsonArray;  
	}

	public JSONObject entityToJson(Employee employee) throws PortalException {
		Organization organization=null;
		Designation designation=null;
		Trade trade=null;
		Grade grade=null;
		SimpleDateFormat targetFormat = new SimpleDateFormat("dd-MM-yyyy");
		JSONObject employeeJson = JSONFactoryUtil.createJSONObject();
		employeeJson.put("employeeId", employee.getEmployeeId());
		employeeJson.put("personalNo", employee.getPersonalNo());

		if(employee.getOrganizationId()!=0) {
			organization=OrganizationLocalServiceUtil.getOrganization(employee.getOrganizationId());
			employeeJson.put("organizationName", organization.getName());
		}else {
			employeeJson.put("organizationName", "");
		}

		if(employee.getSubOrganizationId()!=0) {
			try{
				OrganizationDetail section =  OrganizationDetailLocalServiceUtil.getOrganizationDetail(employee.getSubOrganizationId());
				employeeJson.put("sectionName", section.getShortName());
			}catch(Exception ex) {
				employeeJson.put("sectionName", "");
			}
		}else {
			employeeJson.put("sectionName", "");
		}

		if(employee.getRetirementDate()!=null) {
			employeeJson.put("retirementDate",new SimpleDateFormat("dd-MM-yyyy").format(employee.getRetirementDate()));
		}else {
			employeeJson.put("retirementDate","");
		}

		if(employee.getDesignationId()!=0) {
			designation=DesignationLocalServiceUtil.getDesignation(employee.getDesignationId());
			employeeJson.put("designationName", designation.getName_En());
		}else {
			employeeJson.put("designationName", "");
		}

		if(employee.getTradeId()!=0){
			trade=TradeLocalServiceUtil.getTrade(employee.getTradeId());
			employeeJson.put("tradeName",trade.getName());
		}else {
			employeeJson.put("tradeName", "");
		}

		if(employee.getGradeId()!=0) {
			grade=GradeLocalServiceUtil.getGrade(employee.getGradeId());
			employeeJson.put("gradeName", grade.getName());
		}else {
			employeeJson.put("gradeName", "");
		}

		if(employee.getCurrentDesignationDate()!=null) {
			employeeJson.put("currentDesignationDate",new SimpleDateFormat("dd-MM-yyyy").format(employee.getCurrentDesignationDate()));
		}else {
			employeeJson.put("currentDesignationDate", "");
		}
		if(employee.getDateOfJoining()!=null) {
			employeeJson.put("dateOfJoining",new SimpleDateFormat("dd-MM-yyyy").format(employee.getDateOfJoining()));
		}else {
			employeeJson.put("dateOfJoining", "");
		}

		if(employee.getBioData()!=null) {
			employeeJson.put("biodata", employee.getBioData());
		}

		if(employee.getMessage()!=null) {
			employeeJson.put("message", employee.getMessage());
		}

		if(employee.getState()!=null) {
			employeeJson.put("status",employee.getState());
		}else {
			employeeJson.put("status", "");
		}



		employeeJson.put("emailId", employee.getEmailId());


		People people= PeopleLocalServiceUtil.getPeople(employee.getPeopleId());


		employeeJson.put("fullName",people.getFirstName_En()+" "+people.getMiddleName_En()+" "+people.getLastName_En());

		if(people.getProfileImageId()!=0) {

			DLFileEntry fileEntry= DLFileEntryLocalServiceUtil.getDLFileEntry(people.getProfileImageId());
			String profileImageUrl=fileEntry.getRepositoryId()+(StringUtils.equals(fileEntry.getTreePath(),"/")?"/0/":"/"+String.valueOf(fileEntry.getFolderId())+"/")+fileEntry.getFileName();
			employeeJson.put("profileImage", profileImageUrl);
		}else {
			employeeJson.put("profileImage","");
		}

		if(people.getDateOfBirth()!=null) {

			//				daterOfBirth = new java.sql.Date(sourceFormat.parse(people.getDateOfBirth().toString()).getTime());
			employeeJson.put("daterOfBirth", new SimpleDateFormat("dd-MM-yyyy").format(people.getDateOfBirth()));
		}	
		else
			employeeJson.put("daterOfBirth","");

		if (people.getGenderId() != 0) {
			//			employeeJson.put("gender",EnumerationEntityServiceUtil.getGender(new Long(people.getGenderId()).intValue()).getName());
			employeeJson.put("gender" ,GenderLocalServiceUtil.getGender(people.getGenderId()).getName());
		}else {
			employeeJson.put("gender", "");
		}

		if (people.getCasteCategoryId() != 0) {
			//			employeeJson.put("casteCategory", EnumerationEntityServiceUtil
			//					.getCasteCategory(new Long(people.getCasteCategoryId()).intValue()).getName());
			employeeJson.put("casteCategory", "");
		} else {
			employeeJson.put("casteCategory", "");
		}

		List<EmployeeJoining> employeeJoinings= EmployeeJoiningLocalServiceUtil.getJoiningByEmployeeId(employee.getEmployeeId());

		if(!employeeJoinings.isEmpty()) {
			EmployeeJoining employeeJoining=employeeJoinings.get(0);

			if(employeeJoining.getDesignationId()!=0)
				employeeJson.put("joiningDesignation",DesignationLocalServiceUtil.getDesignation(employeeJoining.getDesignationId()).getName_En());
			else
				employeeJson.put("joiningDesignation","");
		}
		Contact contact=null;
		EmployeeContact employeeContact=null;
		try {
			employeeContact=EmployeeContactLocalServiceUtil.getEmployeeContactByEmployeeId(employee.getEmployeeId());

			if(employeeContact!=null)
				contact=ContactLocalServiceUtil.getContact(employeeContact.getContactId());
			else
				contact=ContactLocalServiceUtil.createContact(0);
		}
		catch(Exception e) {
			employeeJson.put("phoneNo","");
			employeeJson.put("mobile","");
			employeeJson.put("fax","");
		}
		if(contact.getPhone()!=null) {
			employeeJson.put("phoneNo",contact.getPhone());
		}else {
			employeeJson.put("phoneNo","");
		}
		if(contact.getMobile()!=null) {
			employeeJson.put("mobile",contact.getMobile());
		}else {
			employeeJson.put("mobile","");
		}
		if(contact.getFax()!=null) {
			employeeJson.put("fax",contact.getFax());
		}else {
			employeeJson.put("fax","");
		}
		if(contact.getLandline()!=null) {
			employeeJson.put("landLine",contact.getLandline());
		}else {
			employeeJson.put("landLine","");
		}
		return employeeJson;
	}


	public JSONArray getByGradeName(String gradeName) throws PortalException {

		List<Grade> grades=GradeLocalServiceUtil.getGradeByName(gradeName) ;
		Grade grade=grades.get(0);
		JSONArray employeeJsonArray = JSONFactoryUtil.createJSONArray();
		List<Employee> employees=employeePersistence.findByGradeIdAndStatus(grade.getGradeId(),0);
		for(Employee employee : employees) {
			employeeJsonArray.put(entityToJson(employee));
		}
		return employeeJsonArray;

	}

	public JSONArray getByTradeName(String tradeName) throws PortalException {

		List<Trade> trades=TradeLocalServiceUtil.getTradeByName(tradeName) ;
		Trade trade=trades.get(0);
		JSONArray employeeJsonArray = JSONFactoryUtil.createJSONArray();
		List<Employee> employees=employeePersistence.findByTradeId(trade.getTradeId());
		for(Employee employee : employees) {
			employeeJsonArray.put(entityToJson(employee));
		}
		return employeeJsonArray;

	}

	private List<String> getActionList(Employee employee, long userId) throws PortalException {

		Map<Long, Set<String>> taskActionMap = getWorkFlowTask(employee, userId);
		List<String> actionList = new ArrayList<String>();
		long taskId = 0;
		for (Long task : taskActionMap.keySet()) {
			taskId = task;
			actionList.addAll(taskActionMap.get(task));
		}
		return actionList;
	}

	public void deleteAllData() throws PortalException {

		peoplePersistence.removeAll();
		addressPersistence.removeAll();
		employeeAddressPersistence.removeAll();
		employeeQualificationPersistence.removeAll();
		employeePastExperiencePersistence.removeAll();
		employeeVerificationPersistence.removeAll();
		employeeJoiningPersistence.removeAll();
		employeeDocumentPersistence.removeAll();
		employeeApplicationPersistence.removeAll();
		employeePersistence.removeAll();
	}

	public JSONArray getByDateOfBirth(String designationGroupName) throws PortalException {
		/*	JSONArray employeeJsonArray = JSONFactoryUtil.createJSONArray();
		List<Long> designationIds;
				if(designationGroupName.equalsIgnoreCase("-1")) {
					designationIds=DesignationLocalServiceUtil.getDesignationsByStatus(0).stream().map(dig->dig.getDesignationId()).collect(Collectors.toList());;
				}else {
					designationIds = DesignationLocalServiceUtil.getByDesignationGroup(designationGroupName).stream().map(dig->dig.getDesignationId()).collect(Collectors.toList());
				}
//			===============================================================
				System.out.println(designationIds);
		List<People> peoples=PeopleLocalServiceUtil.getByDateOfBirth();
		if(CollectionUtils.isEmpty(peoples)) {
			return employeeJsonArray;
		}

		List<Employee> employees=new ArrayList<>();
		List<Long> peopleIdList=new ArrayList<Long>();
		int ctr=0;
		for (People people : peoples) {
			peopleIdList.add(people.getPeopleId());
		}
		
			DynamicQuery employeeQuery =dynamicQuery();
//			ClassLoader classLoader = getClass().getClassLoader();
//			DynamicQuery designationQuery = DynamicQueryFactoryUtil.forClass(Designation.class,"mdm_designation",PortletClassLoaderUtil.getClassLoader());

//			designationQuery.setProjection(ProjectionFa`ctoryUtil.property("designationId")).add(
//					PropertyFactoryUtil.forName("mdm_designation.designationId").eqProperty(
//							"designationId"));
			Criterion designationCriterion = null;

			employeeQuery.add(RestrictionsFactoryUtil.in("peopleId",peopleIdList));
			employeeQuery.add(RestrictionsFactoryUtil.eq("status", 0));
			employeeQuery.add(RestrictionsFactoryUtil.in("designationId",designationIds));
			if(!designationGroupName.equalsIgnoreCase("-1")) {
//				designationCriterion = RestrictionsFactoryUtil.eq("mdm_designation.designationGroup",
//						designationGroupName);
//				designationQuery.add(designationCriterion);
				


			}
			//			employeeQuery.add(PropertyFactoryUtil.forName("designationId").eq(designationCriterion));
						employeeQuery.add(designationCriterion);*/
		JSONArray employeeJsonArray = JSONFactoryUtil.createJSONArray();
		List<Employee> employees=new ArrayList<>();
		try {
			 LocalDate date = LocalDate.now(); 
			 int day=date.getDayOfMonth();
			 int month=date.getMonthValue();
		employees= employeeFinder.findEmployeeByDesignationGroupAndEmployeeStatus(designationGroupName,day,month);
		}catch(Exception e) {
			LOGGER.error(e);
		}

		LOGGER.info(employees);

		for(Employee employee : employees) {
			JSONObject jsonObject=entityToJson(employee);
			employeeJsonArray.put(jsonObject);
		}			
		return employeeJsonArray;  
	}

	public JSONArray getByRetirementMonth(int year, int month,long organizationId) throws PortalException {
		JSONArray employeeJsonArray = JSONFactoryUtil.createJSONArray();
		List<Employee> employees=new ArrayList<Employee>();
		Calendar firstDay=Calendar.getInstance();
		firstDay.set(Calendar.DAY_OF_MONTH, 1);
		firstDay.set(Calendar.HOUR_OF_DAY, 0);
		firstDay.set(Calendar.MINUTE, 0);
		firstDay.set(Calendar.SECOND, 0);
		firstDay.set(Calendar.MILLISECOND, 0);

		Calendar lastDay=Calendar.getInstance();
		lastDay.setTime(firstDay.getTime());
		lastDay.add(Calendar.MONTH, 1);

		LOGGER.info("today : "+firstDay +", tomorrow: "+lastDay);

		try {
			DynamicQuery peopleQuery =dynamicQuery();
			peopleQuery.add(RestrictionsFactoryUtil.between("retirementDate", firstDay.getTime(), lastDay.getTime()));
			LOGGER.info("OrganizationId "+organizationId );
			if(organizationId!=0) {
				peopleQuery.add(RestrictionsFactoryUtil.eq("organizationId", organizationId));
			}
			employees=EmployeeLocalServiceUtil.dynamicQuery(peopleQuery);
		} catch (Exception e) {
			LOGGER.error(e);
		}

		LOGGER.info("peoples : "+employees);
		for(Employee employee : employees) {
			JSONObject jsonObject=entityToJson(employee);
			employeeJsonArray.put(jsonObject);
		}
		return employeeJsonArray; 

	}

	public Employee getEmployeeByEmailId(String emailId) throws NoSuchEmployeeException {
		Employee employee=null;
		try {
			employee=employeePersistence.findByEmailId(emailId).get(0);
		}catch(Exception e) {}
		return employee;
	}

	public void deleteByEmployeeId(long employeeId) throws PortalException {
		deleteEmployee(employeeId, true);
	}

	public void deleteEmployee(long employeeId, boolean cascade) throws PortalException {
		Employee employee = employeePersistence.findByPrimaryKey(employeeId);
		try {
			if(cascade) {
				deleteEmployeeAssociations(employee);
			}
		}catch(Exception e) {
			LOGGER.error(e);
		}
	}

	public void deleteEmployeeAssociations(Employee employee) throws PortalException {


		List<EmployeeAddress> addresses=employeeAddressPersistence.findByEmployeeId(employee.getEmployeeId());
		for(EmployeeAddress address:addresses) {
			addressPersistence.remove(address.getAddressId());
			employeeAddressPersistence.remove(address.getEmployeeAddressId());
		}

		List<EmployeeQualification> employeeQualifications=employeeQualificationPersistence.findByEmployeeId(employee.getEmployeeId());

		for(EmployeeQualification employeeQualification:employeeQualifications) {
			employeeQualificationPersistence.remove(employeeQualification.getEmployeeQualificationId());
		}

		List<EmployeePastExperience> employeePastExperiences = employeePastExperiencePersistence.findByEmployeeId(employee.getEmployeeId());

		for (EmployeePastExperience employeePastExperience : employeePastExperiences) {
			employeePastExperiencePersistence.remove(employeePastExperience.getEmployeePastExperienceId());
		}


		List<EmployeeVerification> employeeVerifications = employeeVerificationPersistence.findByEmployeeId(employee.getEmployeeId());

		for (EmployeeVerification employeeVerification : employeeVerifications) {
			employeeVerificationPersistence.remove(employeeVerification.getEmployeeVerificationId());
		}

		List<EmployeeDocument> employeeDocuments = employeeDocumentPersistence.findByEmployeeId(employee.getEmployeeId());

		for (EmployeeDocument employeeDocument : employeeDocuments) {
			employeeDocumentPersistence.remove(employeeDocument.getEmployeeDocumentId());
		}

		List<EmployeeApplication> employeeApplications = employeeApplicationPersistence.findByEmployeeId(employee.getEmployeeId());

		for (EmployeeApplication employeeApplication : employeeApplications) {
			employeeApplicationPersistence.remove(employeeApplication.getApplicationId());
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		try {
			workflowInstanceLinkLocalService.deleteWorkflowInstanceLinks(employee.getCompanyId(), employee.getGroupId(),
					Employee.class.getName(), employee.getEmployeeId());

		}catch(Exception ex) {
			LOGGER.error("deleteWorkflowInstanceLinks error : "+employee.getEmployeeId() +" : "+ex.getMessage());
		}
		try {
			AssetEntry assetEntry = assetEntryLocalService.fetchEntry(Employee.class.getName(),  employee.getEmployeeId());

			LOGGER.error("Deleting asset"+assetEntry);
			if(assetEntry!=null) {
				assetEntryLocalService.deleteEntry(assetEntry);
				LOGGER.error("Deleted assetLink");
				LOGGER.error("Deleting assetLink");
				assetLinkLocalService.deleteLinks(assetEntry.getEntryId());
				LOGGER.error("Deleted assetLink");
			}
		}catch(Exception ex) {
			LOGGER.error("deleteEntry error : "+ employee.getEmployeeId() +" : "+ex.getMessage());
		}
		LOGGER.error("Deleting resource");
		try {
						resourceLocalService.deleteResource(serviceContext.getCompanyId(), Employee.class.getName(),
								ResourceConstants.SCOPE_INDIVIDUAL,  employee.getEmployeeId());

		}catch(Exception ex) {
			LOGGER.error("deleteResource error : "+ employee.getEmployeeId() +" : "+ex.getMessage());
		}
		employee = employeePersistence.remove(employee.getEmployeeId());
		People people=peoplePersistence.findByPrimaryKey(employee.getPeopleId());
		peoplePersistence.remove(people.getPeopleId());
	}

	public List<Employee> searchEmployees(Map<String, String> searchFilter){
		List<Employee> result=null;
		try {
			if(searchFilter!=null && searchFilter.size()>1) {
				DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Employee.class, getClass().getClassLoader()); 
				for(Map.Entry<String, String> entry:searchFilter.entrySet()) {
					if(entry.getKey().equalsIgnoreCase("objectClass")) {
						continue;
					}
					/* OLD Code
					 * Method method=ReflectionUtil.getAccessorMethodByFieldName(Employee.class, entry.getKey());
					if(method!=null) {
						Object paramValue=ReflectionUtil.parseStringToDataType(entry.getValue(), method.getReturnType());
						if(paramValue!=null) {
							dynamicQuery.add(RestrictionsFactoryUtil.eq(entry.getKey(), paramValue));
						}
					}*/

					LOGGER.info("Params- "+entry.getKey() +" : "+entry.getValue());
					Method method=ReflectionUtil.getAccessorMethodByFieldName(Employee.class, entry.getKey());
					if(method!=null) {
						if(entry.getValue()!=null) {
							List<Object> valuelist = new ArrayList<Object>(); 
							String strValue=entry.getValue();
							String[] strValues=null;

							//If an attribute has comma separated values
							if(strValue.indexOf(",")>0) {
								strValues=strValue.split(",");
								for(String sv:strValues) {
									Object paramValue=ReflectionUtil.parseStringToDataType(StringUtils.trim(sv), method.getReturnType());
									if(paramValue!=null) {
										valuelist.add(paramValue);
									}
								}
							}else {
								Object paramValue=ReflectionUtil.parseStringToDataType(strValue, method.getReturnType());
								if(paramValue!=null) {
									valuelist.add(paramValue);
								}
							}

							if(CollectionUtils.isNotEmpty(valuelist)) {
								if(valuelist.size()==1) {
									dynamicQuery.add(RestrictionsFactoryUtil.eq(entry.getKey(), valuelist.get(0)));
								}else {
									dynamicQuery.add(RestrictionsFactoryUtil.in(entry.getKey(), valuelist));
								}
							}
						}
					}
				}
				result=dynamicQuery(dynamicQuery);
			}else{
				result=employeePersistence.findAll();
			}
		}catch(Exception e) {
			LOGGER.error(e);
		}
		return result;
	}

	public List<Employee> searchEmployees(Map<String, String[]> searchFilter, String orderBy){
		LOGGER.info("searchEmployees 1 - "+searchFilter);
		List<Employee> result=null;
		try {
			if(MapUtils.isNotEmpty(searchFilter)) {
				DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Employee.class, getClass().getClassLoader()); 
				for(Map.Entry<String, String[]> entry:searchFilter.entrySet()) {
					if(entry.getKey().equalsIgnoreCase("objectClass")) {
						continue;
					}
					LOGGER.info("Params- "+entry.getKey() +" : "+entry.getValue());
					Method method=ReflectionUtil.getAccessorMethodByFieldName(Employee.class, entry.getKey());
					if(method!=null) {
						if(entry.getValue()!=null) {
							List<Object> valuelist = new ArrayList<Object>(); 
							for(String strValue:entry.getValue()) {
								String[] strValues=null;

								//If an attribute has comma separated values
								if(strValue.indexOf(",")>0) {
									strValues=strValue.split(",");
									for(String sv:strValues) {
										Object paramValue=ReflectionUtil.parseStringToDataType(StringUtils.trim(sv), method.getReturnType());
										if(paramValue!=null) {
											valuelist.add(paramValue);
										}
									}
								}else {
									Object paramValue=ReflectionUtil.parseStringToDataType(strValue, method.getReturnType());
									if(paramValue!=null) {
										valuelist.add(paramValue);
									}
								}

							}
							if(CollectionUtils.isNotEmpty(valuelist)) {
								if(valuelist.size()==1) {
									dynamicQuery.add(RestrictionsFactoryUtil.eq(entry.getKey(), valuelist.get(0)));
								}else {
									dynamicQuery.add(RestrictionsFactoryUtil.in(entry.getKey(), valuelist));
								}
							}
						}
					}
				}

				if(StringUtils.isNotBlank(orderBy)) {
					Method method=ReflectionUtil.getAccessorMethodByFieldName(Employee.class, orderBy);
					if(method!=null) {
						dynamicQuery.addOrder(OrderFactoryUtil.asc(orderBy));
					}
				}else {
					dynamicQuery.addOrder(OrderFactoryUtil.asc("designationId")).addOrder(OrderFactoryUtil.asc("rank"));
					//dynamicQuery.addOrder(OrderFactoryUtil.asc("rank"));
				}

				result=dynamicQuery(dynamicQuery);
			}else {
				LOGGER.info("Find All");
				result=employeePersistence.findAll();
			}
		}catch(Exception e) {
			LOGGER.error(e);
		}
		LOGGER.error("Keyword - "+searchFilter.get("keyword"));
		if(searchFilter.containsKey("keyword")) {
			System.out.println("Keyword - "+searchFilter.get("keyword"));
			List<Employee> list = new ArrayList<Employee>();
			List<People> peoples=PeopleLocalServiceUtil.searchPeople(searchFilter.get("keyword")[0]);

			if(!peoples.isEmpty()) {
				for(Employee employee:result) {
					for(People people:peoples) {
						if(employee.getPeopleId()==people.getPeopleId())
							list.add(employee);
					}
				}
			}
			result=list;
		}

		return result;
	}

	public JSONArray getEmployees(Map<String, String> parameters) throws PortalException{

		List<Employee> employeeList;
		if(MapUtils.isEmpty(parameters)) {
			System.out.println("getEmployees 1");
			employeeList = employeePersistence.findByStatus(0);
		}else {
			System.out.println("getEmployees 2");
			Map<String, String[]> multiValuedParams = new HashMap<String, String[]>();
			for (String key : parameters.keySet()) {
				String []value = {parameters.get(key)};
				multiValuedParams.put(key, value);
			}

			employeeList = searchEmployees(multiValuedParams,parameters.get("orderBy"));
		}

		JSONArray employeeJsonArray = JSONFactoryUtil.createJSONArray();

		for(Employee employee : employeeList) {
			employeeJsonArray.put(entityToJson(employee));
		}
		//searchEmployeeModel(parameters,parameters.get("orderBy"));
		return employeeJsonArray;  
	}

	public JSONArray getEmployeeList(Map<String, String[]> parameters) throws PortalException{

		List<Employee> employeeList;
		if(MapUtils.isEmpty(parameters)) {
			System.out.println("getEmployees 1");
			employeeList = employeePersistence.findByStatus(0);
		}else {
			System.out.println("getEmployees 2");
			if(parameters.get("orderBy") !=null && parameters.get("orderBy").length>0) {
				employeeList = searchEmployees(parameters,parameters.get("orderBy")[0]);
			}else {
				employeeList = searchEmployees(parameters,null);
			}
		}

		JSONArray employeeJsonArray = JSONFactoryUtil.createJSONArray();

		for(Employee employee : employeeList) {
			employeeJsonArray.put(entityToJson(employee));
		}
		//searchEmployeeModel(parameters,parameters.get("orderBy"));
		return employeeJsonArray;  
	}

	public List<Employee> searchEmployeeModel(Map<String, String> searchFilter, String orderBy){
		LOGGER.info("searchEmployeeModel test 2- "+searchFilter);
		Organization org =OrganizationLocalServiceUtil.getOrganizations(0, 1).get(0);
		List<Employee> result=null;
		Session session = null;
		List<Object[]> list = new ArrayList();
		System.out.println(org.getClass().getName());
		try {
			session = employeePersistence.openSession();
			String sql = "SELECT employee.*, people.*, employeejoining.*, organization.name as unit_name, designation.name_en as designation_name,"
					+ "grade.name as grade_name, trade.name as trade_name "
					+ "FROM pis_employee as employee "  
					+ "inner join pis_people as people ON employee.peopleid=people.peopleid "
					+ "left join pis_employeejoining employeejoining on employeejoining.employeeid= employee.employeeid "
					+ "left join organization_ as organization ON organization.organizationid=employee.organizationid "
					+ "left join mdm_designation designation on designation.designationid=employee.designationid " 
					+ "left join mdm_grade grade on grade.gradeid=employee.gradeid "
					+ "left join mdm_trade trade on trade.tradeid=employee.tradeid ";


			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			queryObject.addEntity("employee", EmployeeImpl.class);
			queryObject.addEntity("people", PeopleImpl.class);
			queryObject.addEntity("employeejoining", EmployeeJoiningImpl.class);
			queryObject.addScalar("unit_name", Type.STRING);
			queryObject.addScalar("designation_name", Type.STRING);
			queryObject.addScalar("grade_name", Type.STRING);
			queryObject.addScalar("trade_name", Type.STRING);


			QueryPos qPos = QueryPos.getInstance(queryObject);
			list = queryObject.list();
			for(int i=0; i<list.size();i++) {
				Employee emp = (Employee)list.get(i)[0];
				People people= (People)list.get(i)[1];
				EmployeeJoining employeeJoining= (EmployeeJoining)list.get(i)[2];
				String organization= (String)list.get(i)[3];
				String designation= (String)list.get(i)[4];
				String gradeName= (String)list.get(i)[5];
				System.out.println(i+" : "+emp.getEmailId()+" : "+people.getFirstName_En()+" : "+organization);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			employeePersistence.closeSession(session);
		}

		return result;
	}

	public boolean isUnique(long employeeId, Map<String, String> fieldValues) {
		List<Employee> list=searchEmployees(fieldValues);
		boolean unique=true;
		for(Employee e:list) {
			if(e.getEmployeeId()!=employeeId) {
				unique=false;
				break;
			}
		}

		return unique;
	}

	public boolean beforeUpdateEmployee(Object entity, Map<String, String[]> fieldValues) {

		long employeeId=0;

		try {
			employeeId=Long.parseLong(fieldValues.get("employeeId")[0].trim());
		}catch(Exception e) {
			LOGGER.error(e);
		}

		if(employeeId<=0) {
			return false;
		}
		return updateIDAMUser(employeeId, fieldValues);
	}

	public boolean updateIDAMUser(long employeeId,  Map<String, String[]> fieldValues) {
		Employee employee=null;
		try {
			employee=employeePersistence.findByPrimaryKey(employeeId);
			//LOGGER.info(employee);
		}catch(Exception e) {
			LOGGER.error(e);
		}

		if(employee==null) {
			return false;
		}
		return updateIDAMUser(employee, fieldValues);
	}

	public boolean updateIDAMUser(Employee employee,  Map<String, String[]> fieldValues) {		
		List<String> attributes=new ArrayList<String>();
		List<String> oldValues=new ArrayList<String>();
		List<String> newValues=new ArrayList<String>();
		User user=userLocalService.fetchUserByScreenName(employee.getCompanyId(), employee.getLoginId());
		LOGGER.info("Before personalNo......");
		String personalNo=null;

		try {
			String oldPersonalNo=employee.getPersonalNo();
			LOGGER.info("oldPersonalNo : "+oldPersonalNo);
			personalNo = StringUtils.trim(fieldValues.get("personalNo")[0]);
			LOGGER.info("newPersonalNo : "+personalNo);
			if(!StringUtils.isEmpty(oldPersonalNo) && !StringUtils.isEmpty(personalNo) && !oldPersonalNo.equals(personalNo)) {
				attributes.add("accountno");
				oldValues.add(oldPersonalNo);
				newValues.add(personalNo);
			}
		}catch(Exception e) {
			LOGGER.error(e.getMessage());
		}

		LOGGER.info("Before emailId......");

		try {
			String oldEmailId=employee.getEmailId();
			LOGGER.info("oldEmailId : "+oldEmailId);
			String newEmailId = StringUtils.trim(fieldValues.get("emailId")[0]);
			LOGGER.info("newemailId : "+newEmailId);
			if(!StringUtils.equals(oldEmailId,newEmailId)) {
				attributes.add("email");
				oldValues.add(oldEmailId);
				newValues.add(newEmailId);
			}
		}catch(Exception e) {
			LOGGER.error(e.getMessage());
		}

		LOGGER.info("Before organization......");

		try {
			long oldId=employee.getOrganizationId();
			LOGGER.info("oldOrganizationId : "+oldId);
			long newId = Long.parseLong(fieldValues.get("organizationId")[0]);
			LOGGER.info("newOrganizationId : "+newId);
			OrganizationDetail oldObject=OrganizationDetailLocalServiceUtil.getOrganizationDetail(oldId);
			OrganizationDetail newObject=OrganizationDetailLocalServiceUtil.getOrganizationDetail(newId);

			if(!StringUtils.equals(oldObject.getShortName(),newObject.getShortName())){
				attributes.add("unit");
				oldValues.add(oldObject.getShortName());
				newValues.add(newObject.getShortName());
				
				List<Organization> organizations = user.getOrganizations();
				long organizationIds[]=new long[organizations.size()];
				LOGGER.info(organizations.size());
				int i=0;
				Organization organization = OrganizationLocalServiceUtil.getOrganization(employee.getCompanyId(), oldObject.getShortName());
				for (Organization organizationUnit : organizations) {
					if(organization.getOrganizationId()!=organizationUnit.getOrganizationId()) {
						organizationIds[i]=organization.getOrganizationId();
						LOGGER.info(organizationIds[i]);
						i++;
					}
				}
				organization=OrganizationLocalServiceUtil.getOrganization(newObject.getOrganizationId());
				ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
				organizationIds[organizations.size()-1]=organization.getOrganizationId();
				userLocalService.updateOrganizations(user.getUserId(), organizationIds, serviceContext);
			}

			if(!StringUtils.equals(oldObject.getOrganizationCode(),newObject.getOrganizationCode())){
				attributes.add("unitcode");
				oldValues.add(oldObject.getOrganizationCode());
				newValues.add(newObject.getOrganizationCode());
			}

			if(!StringUtils.equals(oldObject.getLongName(),newObject.getLongName())){
				attributes.add("unitdescription");
				oldValues.add(oldObject.getLongName());
				newValues.add(newObject.getLongName());
			}

			String oldOuAddress=oldObject.getAddress1()+", "+oldObject.getAddress2()+", "+oldObject.getAddress3()+", "+oldObject.getCity()+", "+oldObject.getPin();
			String newOuAddress=newObject.getAddress1()+", "+newObject.getAddress2()+", "+newObject.getAddress3()+", "+newObject.getCity()+", "+newObject.getPin();

			if(!StringUtils.equals(oldOuAddress,newOuAddress)){
				attributes.add("unitaddress");
				oldValues.add(oldOuAddress);
				newValues.add(newOuAddress);
			}
		}catch(Exception e) {
			LOGGER.error(e.getMessage());
		}

		LOGGER.info("Before subOrganization......");

		try {
			long oldId=employee.getSubOrganizationId();
			LOGGER.info("oldSubOrganizationId : "+oldId);
			long newId = Long.parseLong(fieldValues.get("subOrganizationId")[0]);
			LOGGER.info("newSubOrganizationId : "+newId);

			OrganizationDetail oldObject=OrganizationDetailLocalServiceUtil.getOrganizationDetail(oldId);
			OrganizationDetail newObject=OrganizationDetailLocalServiceUtil.getOrganizationDetail(newId);
			if(!StringUtils.equals(oldObject.getShortName(),newObject.getShortName())){
				attributes.add("section");
				oldValues.add(oldObject.getShortName());
				newValues.add(newObject.getShortName());
			}

			if(!StringUtils.equals(oldObject.getOrganizationCode(),newObject.getOrganizationCode())){
				attributes.add("sectioncode");
				oldValues.add(oldObject.getOrganizationCode());
				newValues.add(newObject.getOrganizationCode());
			}
			if(!StringUtils.equals(oldObject.getLongName(),newObject.getLongName())){
				attributes.add("sectiondescription");
				oldValues.add(oldObject.getLongName());
				newValues.add(newObject.getLongName());
			}
		}catch(Exception e) {
			LOGGER.error(e.getMessage());
		}

		LOGGER.info("Before designation......");
		long designationId=0;

		try {
			long oldDesignationId=employee.getDesignationId();
			LOGGER.info("oldDesignationId : "+oldDesignationId);
			designationId = Long.parseLong(fieldValues.get("designationId")[0]);
			LOGGER.info("newDesignationId : "+designationId);
			if(oldDesignationId!=0 && designationId!=0 && oldDesignationId!=designationId) {
				Designation oldDesignation=DesignationLocalServiceUtil.getDesignation(oldDesignationId);
				Designation newDesignation=DesignationLocalServiceUtil.getDesignation(designationId);
				attributes.add("designation");
				//oldValues.add(oldDesignation.getShortName());
				//newValues.add(newDesignation.getShortName());
				oldValues.add(oldDesignation.getName_En());
				newValues.add(newDesignation.getName_En());

				attributes.add("designationcode");
				oldValues.add(oldDesignation.getCode());
				newValues.add(newDesignation.getCode());

				attributes.add("designationdescription");
				oldValues.add(oldDesignation.getLongName());
				newValues.add(newDesignation.getLongName());

				if(oldDesignation.getDesignationGroupId()!=newDesignation.getDesignationGroupId()) {
					try {
						DesignationGroup oldDesGrp=DesignationGroupLocalServiceUtil.getDesignationGroup(oldDesignation.getDesignationGroupId());
						DesignationGroup newDesGrp=DesignationGroupLocalServiceUtil.getDesignationGroup(newDesignation.getDesignationGroupId());
						attributes.add("designationgroup");
						oldValues.add(oldDesGrp.getName());
						newValues.add(newDesGrp.getName());
					}catch(Exception e) {}
				}
			}
		}catch(Exception e) {
			LOGGER.error(e.getMessage());
		}

		LOGGER.info("Before grade......");
		long gradeId=0;
		try {
			long oldGradeId=employee.getGradeId();
			LOGGER.info("oldGradeId......"+oldGradeId);
			gradeId = Long.parseLong(fieldValues.get("gradeId")[0]);
			LOGGER.info("newGradeId......"+gradeId);
			if(oldGradeId!=0 && gradeId!=0 && oldGradeId!=gradeId) {
				Grade oldGrade=GradeLocalServiceUtil.getGrade(oldGradeId);
				Grade newGrade=GradeLocalServiceUtil.getGrade(gradeId);
				attributes.add("grade");
				oldValues.add(oldGrade.getName());
				newValues.add(newGrade.getName());

				attributes.add("gradecode");
				oldValues.add(oldGrade.getCode());
				newValues.add(newGrade.getCode());

				attributes.add("gradedescription");
				oldValues.add(oldGrade.getDescription());
				newValues.add(newGrade.getDescription());
			}
		}catch(Exception e) {
			LOGGER.error(e.getMessage());
		}

		LOGGER.info("Before trade......");
		try {
			long oldTradeId=employee.getTradeId();
			LOGGER.info("oldTradeId......"+oldTradeId);
			long newTradeId = Long.parseLong(fieldValues.get("tradeId")[0]);
			LOGGER.info("newTradeId......"+newTradeId);

			if(oldTradeId!=0 && newTradeId!=0 && oldTradeId!=newTradeId) {
				Trade oldTrade=TradeLocalServiceUtil.getTrade(oldTradeId);
				Trade newTrade=TradeLocalServiceUtil.getTrade(newTradeId);
				attributes.add("trade");
				oldValues.add(oldTrade.getName());
				newValues.add(newTrade.getName());

				attributes.add("tradecode");
				oldValues.add(oldTrade.getCode());
				newValues.add(newTrade.getCode());

				attributes.add("tradedescription");
				oldValues.add(oldTrade.getDescription());
				newValues.add(newTrade.getDescription());

			}
		}catch(Exception e) {
			LOGGER.error(e.getMessage());
		}

		LOGGER.info("Before postName......");
		try {
			String oldPostName=employee.getPostName();
			LOGGER.info("oldPostName......"+oldPostName);
			String newPostName = fieldValues.get("postName")[0].trim();
			LOGGER.info("newPostName......"+newPostName);
			if(!StringUtils.equals(oldPostName, newPostName)) {
				attributes.add("postbox");
				oldValues.add(oldPostName);
				newValues.add(newPostName);
			}
		}catch(Exception e) {
			LOGGER.error(e.getMessage());
		}

		LOGGER.info("Before dateOfJoiningUnit......");
		try {
			String oldDoj=DateUtils.format(employee.getDateOfJoining(), DateUtils.YYYY_MM_DD) ;
			LOGGER.info("oldDoj......"+oldDoj);
			String newDoj = fieldValues.get("dateOfJoining")[0].trim();
			LOGGER.info("newPostName......"+newDoj);
			if(!StringUtils.equals(oldDoj, newDoj)) {
				attributes.add("dateOfJoiningUnit");
				oldValues.add(oldDoj);
				newValues.add(newDoj);
			}
		}catch(Exception e) {
			LOGGER.error(e.getMessage());
		}


		LOGGER.info("attributes.size()......"+attributes.size());
		if(attributes.isEmpty()) {
			return true;
		}
		/*		String[] arrAttributes=new String[attributes.size()];
		String[] arrOldValues=new String[attributes.size()];
		String[] arrNewValues=new String[attributes.size()];

		try {
			for(int i=0;i<attributes.size();i++) {
				arrAttributes[i]=attributes.get(i);
				arrOldValues[i]=oldValues.get(i);
				arrNewValues[i]=newValues.get(i);
			}

			LOGGER.info("Before......PISUserUtil.updateIDAMUser");
			PISUserUtil.updateIDAMUser(employee.getLoginId(), arrAttributes, arrOldValues, arrNewValues);
		}catch(Exception e) {
			LOGGER.error(e.getMessage());
		}*/
		return PISUserUtil.updateIDAMUser(employee.getLoginId(), attributes, oldValues, newValues);
	}


	public void initEmployeesList() {
		List<Employee> employees=employeeLocalService.getEmployees(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		for (Employee employee : employees) {
			try {
				deleteByEmployeeId(employee.getEmployeeId());
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void onOrganizationDetailBeforeUpdate(OrganizationDetail oldObject, OrganizationDetail newObject) {
		boolean idamProp=false;
		try {
			idamProp=Boolean.parseBoolean(StringUtils.trim(PropsUtil.get("organization.change.propagation.idam")));
		}catch(Exception e) {}

		//Send the change to IDAM if propagation = true
		if(idamProp) {
			if(!StringUtils.equals(oldObject.getOrganizationCode(), newObject.getOrganizationCode()) 
					|| !StringUtils.equals(oldObject.getShortName(), newObject.getShortName())
					|| !StringUtils.equals(oldObject.getLongName(), newObject.getLongName())) {
				if(oldObject.getType().equals("Unit")) {
					LOGGER.info("Update Unit");
					updateIDAMUserUnit(oldObject, newObject);
				}else if(oldObject.getType().equals("Section")) {
					LOGGER.info("Update Section Test 1- "+oldObject.getOrganizationCode() +":"+newObject.getOrganizationCode());
					updateIDAMUserSection(oldObject, newObject);
					LOGGER.info("After Update Section Test 1- "+oldObject.getOrganizationCode() +":"+newObject.getOrganizationCode());
				}
			}
		}
	}

	private int updateIDAMUserUnit(OrganizationDetail oldObject, OrganizationDetail newObject) {
		List<Employee> employees=employeePersistence.findByOrganizationId(oldObject.getOrganizationId());
		int updateCount=0;
		for(Employee employee:employees) {
			if(updateIDAMUserUnit(employee, oldObject, newObject)) {
				updateCount++;
			}
		}
		return updateCount;
	}

	private boolean updateIDAMUserUnit(Employee employee, OrganizationDetail oldObject, OrganizationDetail newObject) {
		List<String> attributes=new ArrayList<String>();
		List<String> oldValues=new ArrayList<String>();
		List<String> newValues=new ArrayList<String>();
		LOGGER.info("Before updateIDAMUserUnit......");

		try {
			if(!StringUtils.equals(oldObject.getShortName(),newObject.getShortName())){
				attributes.add("unit");
				oldValues.add(oldObject.getShortName());
				newValues.add(newObject.getShortName());
			}

			if(!StringUtils.equals(oldObject.getOrganizationCode(),newObject.getOrganizationCode())){
				attributes.add("unitcode");
				oldValues.add(oldObject.getOrganizationCode());
				newValues.add(newObject.getOrganizationCode());
			}

			if(!StringUtils.equals(oldObject.getLongName(),newObject.getLongName())){
				attributes.add("unitdescription");
				oldValues.add(oldObject.getLongName());
				newValues.add(newObject.getLongName());
			}

			String oldOuAddress=oldObject.getAddress1()+", "+oldObject.getAddress2()+", "+oldObject.getAddress3()+", "+oldObject.getCity()+", "+oldObject.getPin();
			String newOuAddress=newObject.getAddress1()+", "+newObject.getAddress2()+", "+newObject.getAddress3()+", "+newObject.getCity()+", "+newObject.getPin();
			if(!StringUtils.equals(oldOuAddress,newOuAddress)){
				attributes.add("unitaddress");
				oldValues.add(oldOuAddress);
				newValues.add(newOuAddress);
			}
		}catch(Exception e) {
			LOGGER.error(e.getMessage());
		}

		LOGGER.info("attributes.size()......"+attributes.size());
		return PISUserUtil.updateIDAMUser(employee.getLoginId(), attributes, oldValues, newValues);
	}

	private int updateIDAMUserSection(OrganizationDetail oldObject, OrganizationDetail newObject) {
		LOGGER.info("Update Section Test 21- "+oldObject.getOrganizationCode() +":"+newObject.getOrganizationCode());
		List<Employee> employees=employeePersistence.findBySubOrganizationId(oldObject.getOrganizationId());
		LOGGER.info("Update Section Test 22- "+employees.size());
		int updateCount=0;
		for(Employee employee:employees) {
			if(updateIDAMUserSection(employee, oldObject, newObject)) {
				updateCount++;
			}
		}
		return updateCount;
	}

	private boolean updateIDAMUserSection(Employee employee, OrganizationDetail oldObject, OrganizationDetail newObject) {
		List<String> attributes=new ArrayList<String>();
		List<String> oldValues=new ArrayList<String>();
		List<String> newValues=new ArrayList<String>();
		LOGGER.info("Before updateIDAMUserSection......");

		try {
			if(!StringUtils.equals(oldObject.getShortName(),newObject.getShortName())){
				attributes.add("section");
				oldValues.add(oldObject.getShortName());
				newValues.add(newObject.getShortName());
			}

			if(!StringUtils.equals(oldObject.getOrganizationCode(),newObject.getOrganizationCode())){
				attributes.add("sectioncode");
				oldValues.add(oldObject.getOrganizationCode());
				newValues.add(newObject.getOrganizationCode());
			}

			if(!StringUtils.equals(oldObject.getLongName(),newObject.getLongName())){
				attributes.add("sectiondescription");
				oldValues.add(oldObject.getLongName());
				newValues.add(newObject.getLongName());
			}
		}catch(Exception e) {
			LOGGER.error(e.getMessage());
		}

		LOGGER.info("attributes.size()......"+attributes.size());
		return PISUserUtil.updateIDAMUser(employee.getLoginId(), attributes, oldValues, newValues);
	}

	public List<Employee> getEmployeesByOrganizationIdAndPersonalNo(long organizationId, String personalNo){

		List<Employee> result= null;
		try {
			result=employeePersistence.findByOrganizationIdAndPersonalNo(organizationId, personalNo);
		}catch(Exception e) {}
		return result;
	}

	public Employee getEmployeeByLoginId(String loginId){
		try {
			return employeePersistence.findByLoginId(loginId).get(0);
		}catch(Exception e) {}
		return null;
	}

	public List<Employee> getEmployeeByDesignationId(long designationId){
		try {
			return employeePersistence.findByDesignationId(designationId);
		}catch(Exception e) {}
		return null;
	}

	public int getEmployeeCountByDesignationId(long designationId) {
		try {
			return employeePersistence.countByDesignationId(designationId);
		}catch(Exception e) {}
		return 0;
	}

	public List<Employee> getEmployeeByGradeId(long gradeId){
		try {
			return employeePersistence.findByGradeId(gradeId);
		}catch(Exception e) {}
		return null;
	}

	public int getEmployeeCountByGradeId(long gradeId) {
		try {
			return employeePersistence.countByGradeId(gradeId);
		}catch(Exception e) {}
		return 0;
	}

	public List<Employee> getEmployeeByTradeId(long tradeId){
		try {
			return employeePersistence.findByTradeId(tradeId);
		}catch(Exception e) {}
		return null;
	}

	public int getEmployeeCountByTradeId(long tradeId){
		try {
			return employeePersistence.countByTradeId(tradeId);
		}catch(Exception e) {}
		return 0;
	}

	public List<Employee> getEmployeeByDesignationGroupId(long designationGroupId){
		try {
			return employeePersistence.findByDesignationGroupId(designationGroupId);
		}catch(Exception e) {}
		return null;
	}

	public int getEmployeeCountByDesignationGroupId(long designationGroupId){
		try {
			return employeePersistence.countByDesignationGroupId(designationGroupId);
		}catch(Exception e) {}
		return 0;
	}

	public List<Employee> getEmployeeByCadreId(long cadreId){
		try {
			return employeePersistence.findByCadreId(cadreId);
		}catch(Exception e) {}
		return null;
	}

	public int getEmployeeCountByCadreId(long cadreId){
		try {
			return employeePersistence.countByCadreId(cadreId);
		}catch(Exception e) {}
		return 0;
	}

	public List<Employee> getGradeModeByGradeModeId(long gradeModeId){
		return employeePersistence.findByGradeModeId(gradeModeId);
}
	
	public List<Employee> getBySubOrganizationId(long subOrganizationId){
		return employeePersistence.findBySubOrganizationId(subOrganizationId);
}
}