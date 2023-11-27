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

package com.adjecti.pis.service.impl;

import com.adjecti.common.util.ReflectionUtil;
import com.adjecti.pis.configuration.OnBoardingConfig;
import com.adjecti.pis.constant.OnboardingUserRole;
import com.adjecti.pis.dto.RegistrationRequestDTO;
import com.adjecti.pis.dto.RegistrationRequestSearchParameter;
import com.adjecti.pis.exception.NoSuchRegistrationRequestException;
import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil;
import com.adjecti.pis.liferay.util.PISUserUtil;
import com.adjecti.pis.model.RegistrationRequest;
import com.adjecti.pis.service.base.RegistrationRequestLocalServiceBaseImpl;
import com.adjecti.pis.util.BulkOnboardUtils;
import com.adjecti.pis.util.OnboardingUtil;
import com.adjecti.pis.workflow.OnboardingWorkflowStarter;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetLinkConstants;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskManagerUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.model.UserGroupRole;
import com.liferay.portal.kernel.model.WorkflowInstanceLink;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.UserGroupLocalServiceUtil;
import com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.UserServiceUtil;
import com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalServiceUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowException;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowLog;
import com.liferay.portal.kernel.workflow.WorkflowLogManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowTask;
import com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil;
import com.liferay.portal.kernel.workflow.comparator.WorkflowComparatorFactoryUtil;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * The implementation of the registration request local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.adjecti.pis.service.RegistrationRequestLocalService</code>
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RegistrationRequestLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.adjecti.pis.model.RegistrationRequest", service = AopService.class)
public class RegistrationRequestLocalServiceImpl extends RegistrationRequestLocalServiceBaseImpl {
	
	private static Log LOGGER = LogFactoryUtil.getLog(RegistrationRequestLocalServiceImpl.class);
	
	
	@Reference
	OnBoardingConfig boardingConfig;
	
	
	
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use
	 * <code>com.adjecti.pis.service.RegistrationRequestLocalService</code> via
	 * injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use
	 * <code>com.adjecti.pis.service.RegistrationRequestLocalServiceUtil</code>.
	 */

	@Indexable(type = IndexableType.REINDEX)
	public RegistrationRequest addRegistrationRequest(RegistrationRequestDTO registrationRequestDto, ServiceContext serviceContext)
			throws PortalException {

		long requestId = CounterLocalServiceUtil.increment(RegistrationRequest.class.getName());
		RegistrationRequest registrationRequest = registrationRequestPersistence.create(requestId);
		
		long userId = serviceContext.getUserId();
		User user = userLocalService.getUserById(userId);

		long groupId = getUserOrgGroupId(user,registrationRequestDto,serviceContext);//serviceContext.getScopeGroupId();
		
		registrationRequest = convertToObject(registrationRequest, registrationRequestDto, serviceContext);

		/**
		 * These fields were updated only @ creation time
		 */
		registrationRequest.setUuid(serviceContext.getUuid());
		registrationRequest.setUserId(user.getUserId());
		registrationRequest.setGroupId(groupId);
		registrationRequest.setCompanyId(user.getCompanyId());
		registrationRequest.setUserName(user.getFullName());
		registrationRequest.setCreateDate(serviceContext.getCreateDate(new Date()));
		registrationRequest.setBulkOnbordingFileId(registrationRequestDto.getFileEntryId());

		/**
		 * These fields for workflow status @ creation time
		 */
		registrationRequest.setStatus(WorkflowConstants.STATUS_INCOMPLETE);
		registrationRequest.setStatusByUserId(userId);
		registrationRequest.setStatusByUserName(user.getFullName());
		registrationRequest.setStatusDate(serviceContext.getModifiedDate(null));
		registrationRequest.setState("Processing");

		registrationRequestPersistence.update(registrationRequest);

		resourceLocalService.addResources(user.getCompanyId(), groupId, userId, RegistrationRequest.class.getName(),
				requestId, false, true, true);

		AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId, groupId, registrationRequest.getCreateDate(),
				registrationRequest.getModifiedDate(), RegistrationRequest.class.getName(), requestId,
				registrationRequest.getUuid(), 0, serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(), true, true, null, null, null, null, ContentTypes.TEXT_HTML,
				registrationRequest.getFirstName(), null, null, null, null, 0, 0, null);

		assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(), serviceContext.getAssetLinkEntryIds(),
				AssetLinkConstants.TYPE_RELATED);
		LOGGER.info("RegistrationRequest created with id - "+registrationRequest.getRegistrationRequestId());
		Map<String, Serializable> taskContextMap = new HashMap<>();
		taskContextMap.put("registrationRequestId", registrationRequest.getPrimaryKey());
		taskContextMap.put("serviceContext", serviceContext);

		try {
			// Adding the job to liferay background manager
			com.liferay.portal.kernel.backgroundtask.BackgroundTask backgroundTask = BackgroundTaskManagerUtil.addBackgroundTask(
					userId, serviceContext.getScopeGroupId(), OnboardingWorkflowStarter.class.getName(),
					OnboardingWorkflowStarter.class.getName(), taskContextMap, serviceContext);

		} catch (Exception e) {
			LOGGER.error(e.getCause());
		}
		return registrationRequest;
	}

		
	private long getUserOrgGroupId(User user, RegistrationRequestDTO registrationRequestDto, ServiceContext serviceContext) {
		String orgName = registrationRequestDto.getUnit();
		List<Organization> organizations;
		long groupId=serviceContext.getScopeGroupId();
		try {
			organizations = user.getOrganizations();
			for (Organization organization : organizations) {
				if(organization.getName().equalsIgnoreCase(orgName)) {
					groupId=organization.getGroupId();
					break;
				}
			}
			
		} catch (PortalException e) {
			LOGGER.error(e);
		}
		
		return groupId;
	}

	private boolean isOrgInHierarchy(Organization organization, String orgName) {
		
		if (organization.getName().equalsIgnoreCase(orgName)) 
			return true;
		List<Organization> suborganizations = organization.getSuborganizations();
		for(Organization suborganization : suborganizations) {
			if(isOrgInHierarchy(suborganization,orgName)) {
				return true;
			}
		}
		return false;
	}

	@Indexable(type = IndexableType.REINDEX)
	public RegistrationRequest updateRegistrationRequest(RegistrationRequestDTO requestDto, ServiceContext serviceContext)
			throws PortalException, SystemException {
		RegistrationRequest request = getRegistrationRequest(requestDto.getRegistrationRequestId());
		
		if(request.getUnitId() != 0) {
			requestDto.setUnitId(request.getUnitId());
		}
		
		request = convertToObject(request, requestDto, serviceContext);
		registrationRequestPersistence.update(request);
		long groupId = request.getGroupId();

		resourceLocalService.updateResources(serviceContext.getCompanyId(), groupId,
				RegistrationRequest.class.getName(), request.getRegistrationRequestId(),
				serviceContext.getModelPermissions());

		AssetEntry assetEntry = assetEntryLocalService.updateEntry(request.getUserId(), groupId,
				request.getCreateDate(), request.getModifiedDate(), RegistrationRequest.class.getName(),
				request.getRegistrationRequestId(), request.getUuid(), 0, serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(), true, true, request.getCreateDate(), null, null, null,
				ContentTypes.TEXT_HTML, request.getFirstName(), null, null, null, null, 0, 0,
				serviceContext.getAssetPriority());

		assetLinkLocalService.updateLinks(serviceContext.getUserId(), assetEntry.getEntryId(),
				serviceContext.getAssetLinkEntryIds(), AssetLinkConstants.TYPE_RELATED);
		return request;
	}

	@Indexable(type = IndexableType.DELETE)
	public RegistrationRequest deleteRegistrationRequest(long requestId) throws PortalException {
		RegistrationRequest request = getRegistrationRequest(requestId);
		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		request = deleteRegistrationRequest(request);
		try {
			workflowInstanceLinkLocalService.deleteWorkflowInstanceLinks(request.getCompanyId(), request.getGroupId(),
					RegistrationRequest.class.getName(), request.getRegistrationRequestId());

			}catch(Exception ex) {
				LOGGER.info("deleteWorkflowInstanceLinks error : "+request.getRegistrationRequestId() +" : "+ex.getMessage());
			}
			
		try {
			AssetEntry assetEntry = assetEntryLocalService.fetchEntry(RegistrationRequest.class.getName(), requestId);
			assetLinkLocalService.deleteLinks(assetEntry.getEntryId());
			
			assetEntryLocalService.deleteEntry(assetEntry);
		}catch(Exception ex) {
			LOGGER.info("deleteEntry error : "+request.getRegistrationRequestId() +" : "+ex.getMessage());
		}
		try {
			resourceLocalService.deleteResource(serviceContext.getCompanyId(), RegistrationRequest.class.getName(),
				ResourceConstants.SCOPE_INDIVIDUAL, requestId);

		}catch(Exception ex) {
			LOGGER.info("deleteResource error : "+request.getRegistrationRequestId() +" : "+ex.getMessage());
		}
		return request;
	}

	public RegistrationRequest updateStatus(long userId, long requestId, int status, ServiceContext serviceContext)
			throws PortalException, SystemException {
		LOGGER.debug(" ************* RegistrationRequest.updateStatus " + status);
		User user = userLocalService.getUser(userId);
		RegistrationRequest request = getRegistrationRequest(requestId);

		request.setStatus(status);
		request.setStatusByUserId(userId);
		request.setStatusByUserName(user.getFullName());
		request.setStatusDate(new Date());

		if (status == WorkflowConstants.STATUS_DRAFT)
			request.setState("DRAFT");
		else if (status == WorkflowConstants.STATUS_APPROVED)
			request.setState("APPROVED");
		else if (status == WorkflowConstants.STATUS_DENIED)
			request.setState("REJECTED");
		else if (status == WorkflowConstants.STATUS_PENDING)
			request.setState("PENDING");
		else if (status == WorkflowConstants.STATUS_SCHEDULED)
			request.setState("APPROVAL PENDING");

		registrationRequestPersistence.update(request);

		if (status == WorkflowConstants.STATUS_APPROVED || status==WorkflowConstants.STATUS_DENIED) {
			assetEntryLocalService.updateVisible(RegistrationRequest.class.getName(), requestId, true);
		} else {
			assetEntryLocalService.updateVisible(RegistrationRequest.class.getName(), requestId, false);
		}

		String createUser = com.liferay.portal.kernel.util.PropsUtil.get("onboarding.workflow.user.creation");
		if (!StringUtils.equalsIgnoreCase(createUser, "disable")) {
			if (status == WorkflowConstants.STATUS_APPROVED) {
				// Task Completed
				try {
					BulkOnboardUtils.onboardEmployee(request,boardingConfig,user);
					registrationRequestPersistence.update(request);
				} catch (Exception e) {
					// TODO Exception to be handled
					LOGGER.error(e);
				}
			}
		}
		return request;
	}

	private boolean isTaskCompleted(List<WorkflowLog> workflowLogs, long companyId) throws WorkflowException {

		if (workflowLogs.size() > 0) {
			long taskId = workflowLogs.get(workflowLogs.size() - 1).getWorkflowTaskId();
			WorkflowTask task = WorkflowTaskManagerUtil.getWorkflowTask(companyId, taskId);

			if (task.isCompleted())
				return true;
			else
				return false;
		} else
			return true;
	}

	// TODO need to refactor code
	private boolean isAssigneeOfTask(List<WorkflowLog> workflowLogs, RegistrationRequest registration, long userId) throws WorkflowException {

		if (workflowLogs.size() > 0) {
			long taskId = workflowLogs.get(workflowLogs.size() - 1).getWorkflowTaskId();
			WorkflowTask task = WorkflowTaskManagerUtil.getWorkflowTask(registration.getCompanyId(), taskId);
			List<User> userList = WorkflowTaskManagerUtil.getAssignableUsers(registration.getCompanyId(), taskId);

			if (task.isCompleted())
				return false;
			if ((task.getAssigneeUserId() == userId)) {
				return true;
			} 
		} 
		return false;
	}

	public boolean hasOwnerRole(long userId, long companyId) {
		try {
			if (RoleLocalServiceUtil.hasUserRole(userId, companyId, OnboardingUserRole.valueOf(OnboardingUserRole.ADMIN_ROLE), true))
				return true;
		} catch (PortalException e) {
			LOGGER.info(e.getMessage());
		}

		try {
			
			List<UserGroupRole> userGroupRoles = UserGroupRoleLocalServiceUtil.getUserGroupRoles(userId);
			for (UserGroupRole userGroupRole : userGroupRoles) {
				int roleType = userGroupRole.getRole().getType();
				if (roleType == RoleConstants.TYPE_ORGANIZATION && userGroupRole.getRole().getName()
						.equalsIgnoreCase(OnboardingUserRole.valueOf(OnboardingUserRole.CREATER_ROLE))) {
					return true;
				}
			}

		} catch (PortalException e) {
			LOGGER.info(e.getMessage());
		}
		return false;

	}

	public List<RegistrationRequest> getRegistrationRequests(long groupId) {
		return registrationRequestPersistence.findByGroupId(groupId);
	}

	public List<RegistrationRequest> getRegistrationRequests(long groupId, int start, int end,
			OrderByComparator<RegistrationRequest> obc) {
		return registrationRequestPersistence.findByGroupId(groupId, start, end, obc);
	}

	
	
	public List<RegistrationRequest> getRegistrationRequests(long groupId, int start, int end) {
		return registrationRequestPersistence.findByGroupId(groupId, start, end);
	}

	@Override
	public List<RegistrationRequestDTO> getRegistrationRequestsByOnboardingId(long bulkOnbordingFileId) throws PortalException {
		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		List<RegistrationRequest>registrationRequests=	registrationRequestPersistence.findByBulkOnbordingFileId(bulkOnbordingFileId);
		return entityToDto(registrationRequests, serviceContext.getUserId());
	}
	

	public List<RegistrationRequestDTO> findByUnitId(long unitId) throws PortalException{
		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		return entityToDto(registrationRequestPersistence.findByUnitId(unitId),serviceContext.getUserId());
	}
	
	@Override
	public List<RegistrationRequest> getRegistrationRequests(long groupId, int status) throws SystemException {
		return registrationRequestPersistence.findByG_S(groupId, WorkflowConstants.STATUS_APPROVED);
	}

	public int getRegistrationRequestsCount(long groupId) {
		return registrationRequestPersistence.countByGroupId(groupId);
	}

	public void selectedProcessed(String[] requestIds, String action, String remarks, long userId) throws PortalException {
		for (String requestId : requestIds) {
			this.performWorkFlowACtion(Long.valueOf(requestId), action, remarks, 0, userId);
		}
	}

	public void performWorkFlowACtion(long pisId, String action, String remarks, long workflowTaskId, long userId)
			throws PortalException {
		LOGGER.info("performWorkFlowACtion for action - "+action);

		RegistrationRequest registration = registrationRequestPersistence.findByPrimaryKey(pisId);
		
		if("Approve".equalsIgnoreCase(action) || "Confirm".equalsIgnoreCase(action)){
			synchronized (this) {
				verifyAndUpdateLoginId(registration);
			}
		}
		

		WorkflowInstanceLink wil = WorkflowInstanceLinkLocalServiceUtil.getWorkflowInstanceLink(
				registration.getCompanyId(), registration.getGroupId(), RegistrationRequest.class.getName(),
				registration.getRegistrationRequestId());
		WorkflowInstance workflowInstance = WorkflowInstanceManagerUtil.getWorkflowInstance(registration.getCompanyId(), wil.getWorkflowInstanceId());
		Map<String, Serializable> workflowContext = workflowInstance.getWorkflowContext();
		List<Integer> logTypes_assign = new ArrayList<Integer>();
		logTypes_assign.add(WorkflowLog.TASK_ASSIGN);

		List<WorkflowLog> workflowLogs_assign = WorkflowLogManagerUtil.getWorkflowLogsByWorkflowInstance(
				registration.getCompanyId(), wil.getWorkflowInstanceId(), logTypes_assign, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, WorkflowComparatorFactoryUtil.getLogCreateDateComparator(true));

		if (workflowLogs_assign.size() > 0) {

			long taskId = workflowLogs_assign.get(workflowLogs_assign.size() - 1).getWorkflowTaskId();
			WorkflowTask task = WorkflowTaskManagerUtil.getWorkflowTask(registration.getCompanyId(), taskId);

			List<String> nextTransitionNames = WorkflowTaskManagerUtil.getNextTransitionNames(registration.getCompanyId(), userId, taskId);

			if (!nextTransitionNames.contains(action)) {
				LOGGER.info("*************************** invalid action- " + action);
			}
			
			workflowContext.put(WorkflowConstants.CONTEXT_USER_ID,String.valueOf(userId));
			
			if (task.getAssigneeUserId() <= 0) { // task is not assigned to user
				List<User> userList = WorkflowTaskManagerUtil.getAssignableUsers(registration.getCompanyId(), taskId);

				if (userList.stream().anyMatch(u -> u.getUserId() == userId)) {
					WorkflowTaskManagerUtil.assignWorkflowTaskToUser(registration.getCompanyId(), userId, taskId,
							userId, "Auto assign", task.getDueDate(), workflowContext);
					LOGGER.info("*************************** task not assigned");
				}

				task = WorkflowTaskManagerUtil.getWorkflowTask(registration.getCompanyId(), taskId);

			}

			nextTransitionNames = WorkflowTaskManagerUtil.getNextTransitionNames(registration.getCompanyId(), userId,
					taskId);

			if (task.getAssigneeUserId() == userId) {
				
				WorkflowTaskManagerUtil.completeWorkflowTask(registration.getCompanyId(), userId,
						taskId, action, remarks + action, workflowContext);
			} else {
				LOGGER.info("Not Authenticated ......" + userId);
			}
		}

		LOGGER.info("performWorkFlowACtion completed");
	}

	/**
	 * For Approve/reject action button @ FE
	 */
	private boolean isApproverOfRequest(RegistrationRequest registration, long userId) throws PortalException {
		// TODO duplicate code. need to refactor
		if(registration.getStatus()==WorkflowConstants.STATUS_INCOMPLETE) {
			return false;
		}

		/*
		 * PIS_ADMIN role is always Approver for self added Registration Requests User
		 * not an approver if not having PIS_ADMIN and CONTENT_APPROVER role
		 */
		if (isAdmin(userId)) {
			return (registration.getUserId() == userId);
		}
	
	
		if(!OnboardingUtil.isApprover(userId))
			return false;	
		

		List<WorkflowLog> workflowLogs_assign = this.getWorkflowLogsAssign(registration);
		return this.isAssignable(workflowLogs_assign, registration, userId);
	}
	
	public List<RegistrationRequestDTO> getAllRegistrations() throws PortalException {

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		User user = userLocalService.getUserById(serviceContext.getUserId());
		
		List<RegistrationRequest> requestList = new ArrayList<RegistrationRequest>();
		if (this.isApprover(user.getUserId())) {
			List<Organization> organizations = OnboardingUtil.getUnitsByRole(user.getUserId(), OnboardingUserRole.APPROVER_ROLE);
			for (Organization organization : organizations) {
					requestList.addAll(registrationRequestPersistence.findByGroupId(organization.getGroupId()));
			}
		} else
			requestList.addAll(registrationRequestPersistence.findByUserId(user.getUserId()));

		return entityToDto(requestList, serviceContext.getUserId());

	}
	
	public List<RegistrationRequestDTO> getRegistrationsByStatus(String status) throws PortalException {
		return this.getAllRegistrations().stream().filter(request->status.equalsIgnoreCase(request.getStatus())).map(request->request).collect(Collectors.toList());
		
	}
	
	public List<RegistrationRequest>  findByUnitIdsAndStatusList(long[] unitIds, int[] statuses) throws PortalException{
		
		return registrationRequestPersistence.findByUnitIdsAndStatusList(unitIds, statuses);
	}
	
	
	public List<RegistrationRequestDTO> getAllRegistrations(User user) throws PortalException {
		//TODO
		List<RegistrationRequest> requestList = new ArrayList<RegistrationRequest>();

		if (isAdmin(user.getUserId())) {
			requestList = registrationRequestPersistence.findByUserId(user.getUserId());
		}else if (isCreater(user.getUserId())) {
			requestList = registrationRequestPersistence.findByUserId(user.getUserId());
		}else if (isApprover(user.getUserId())) {
			requestList = getApproversRegistrationRequests(user);
		}

		return entityToDto(requestList, user.getUserId());
	}
	

	private List<RegistrationRequest> getApproversRegistrationRequests(User user) throws PortalException {
		List<RegistrationRequest> requestList = new ArrayList<RegistrationRequest>();
		List<Organization> unitList=OnboardingUtil.getUnitsByRole(user.getUserId(), OnboardingUserRole.APPROVER_ROLE);
		
		long [] unitIds = unitList.stream().mapToLong(org -> org.getOrganizationId()).toArray();
		
		int[] statusList = {WorkflowConstants.STATUS_SCHEDULED, WorkflowConstants.STATUS_APPROVED, WorkflowConstants.STATUS_DENIED};
				
		requestList = registrationRequestPersistence.findByUnitIdsAndStatusList(unitIds, statusList);
		
		
		return requestList;
	}

	

	public List<RegistrationRequestDTO> findByStatus(String status) throws PortalException {

		if (StringUtils.isNotBlank(status))
			return getAllRegistrations().stream().filter(request -> request.getStatus().equals(status))
					.collect(Collectors.toList());
		else
			return getAllRegistrations();
	}

	public List<RegistrationRequestDTO> findByStatusAndOnboardingId(String status ,long bulkOnbordingFileId) throws PortalException {

		if (StringUtils.isNotBlank(status))
			return getAllRegistrations().stream().filter(request -> request.getStatus().equals(status) && request.getBulkOnbordingFileId()==bulkOnbordingFileId)
					.collect(Collectors.toList());
		else
			return getRegistrationRequestsByOnboardingId(bulkOnbordingFileId);
	}
	
	public RegistrationRequest getRegistrationRequestById(long registrationRequestId) throws NoSuchRegistrationRequestException {
		return registrationRequestPersistence.findByPrimaryKey(registrationRequestId);
	}

	public RegistrationRequestDTO getRegistration(long registrationRequestId) throws PortalException {

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		RegistrationRequest registrationRequest = null;
		if (this.isApprover(serviceContext.getUserId())) {
			RegistrationRequest request = registrationRequestPersistence.findByPrimaryKey(registrationRequestId);
			User user = userLocalService.getUserById(serviceContext.getUserId());
			long[] organizationIds = user.getOrganizationIds();
			for (long organizationId : organizationIds) {
				long[] userIds = UserLocalServiceUtil.getOrganizationUserIds(organizationId);
				for (long userId : userIds) {
					if (userId == request.getUserId()) {
						registrationRequest = request;
						break;
					}
				}
			}
		} else {
			RegistrationRequest request = registrationRequestPersistence.findByPrimaryKey(registrationRequestId);
			if (serviceContext.getUserId() == request.getUserId()) {
				registrationRequest = request;
			}
		}

		if (registrationRequest == null) {
			return null;
		}
		long userId = serviceContext.getUserId();
		boolean isApprover = this.isApprover(userId);

		if (isApprover && !this.isAssignableOrCompleted(registrationRequest, userId))
			return null;

		return entityToDto(registrationRequest, serviceContext.getUserId(), isApprover);

	}

	public boolean isActionCompleted(RegistrationRequest registration) {
		try {
			WorkflowInstanceLink wil = WorkflowInstanceLinkLocalServiceUtil.getWorkflowInstanceLink(
					registration.getCompanyId(), registration.getGroupId(), RegistrationRequest.class.getName(),
					registration.getRegistrationRequestId());
			List<Integer> logTypes_complete = new ArrayList<Integer>();
			logTypes_complete.add(WorkflowLog.TASK_COMPLETION);
			List<WorkflowLog> workflowLogs_complete = WorkflowLogManagerUtil.getWorkflowLogsByWorkflowInstance(
					registration.getCompanyId(), wil.getWorkflowInstanceId(), logTypes_complete, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, WorkflowComparatorFactoryUtil.getLogCreateDateComparator(true));

			isAssignable(workflowLogs_complete, registration, 0);
			if (workflowLogs_complete.size() > 0) {
				return true;
			}
		} catch (Exception e) {
			LOGGER.info("Erroe isActionCompleted -"+e.getMessage());
		}
		return false;
	}

	private List<WorkflowLog> getWorkflowLogsAssign(RegistrationRequest registration) throws PortalException {
		if(registration.getStatus()==WorkflowConstants.STATUS_INCOMPLETE) {
			return new ArrayList<WorkflowLog>();
		}
		WorkflowInstanceLink wil = WorkflowInstanceLinkLocalServiceUtil.getWorkflowInstanceLink(
				registration.getCompanyId(), registration.getGroupId(), RegistrationRequest.class.getName(),
				registration.getRegistrationRequestId());
		List<Integer> logTypes_assign = new ArrayList<Integer>();
		logTypes_assign.add(WorkflowLog.TASK_ASSIGN);
		return WorkflowLogManagerUtil.getWorkflowLogsByWorkflowInstance(registration.getCompanyId(),
				wil.getWorkflowInstanceId(), logTypes_assign, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				WorkflowComparatorFactoryUtil.getLogCreateDateComparator(true));

	}

	public boolean isActiontaken(RegistrationRequest registration, long userId) throws PortalException {
		if(registration.getStatus()==WorkflowConstants.STATUS_INCOMPLETE) {
			return false;
		}
		
		List<WorkflowLog> workflowLogs = getWorkflowLogsAssign(registration);
		return isAssignable(workflowLogs, registration, userId);
	}

// TODO    	need to refactor code       

	private boolean isAssignable(List<WorkflowLog> workflowLogs, RegistrationRequest registration, long userId)
			throws WorkflowException {

		if (workflowLogs.size() > 0) {
			long taskId = workflowLogs.get(workflowLogs.size() - 1).getWorkflowTaskId();
			WorkflowTask task = WorkflowTaskManagerUtil.getWorkflowTask(registration.getCompanyId(), taskId);
			List<User> userList = WorkflowTaskManagerUtil.getAssignableUsers(registration.getCompanyId(), taskId);
			
			if (task.isCompleted())
				return false;

			if ((task.getAssigneeUserId() == userId) || (userList.stream().anyMatch(u -> u.getUserId() == userId)))
				return true;
		} 
			
		return false;
	}


	public boolean isAssignableOrCompleted(RegistrationRequest registration, long userId) {
		try {
			List<WorkflowLog> workflowLogs_assign = this.getWorkflowLogsAssign(registration);

			if (isActionCompleted(registration) || this.isAssignable(workflowLogs_assign, registration, userId))
				return true;

		} catch (Exception e) {
			LOGGER.info("Error isAssignableOrCompleted - "+e.getMessage());
		}
		return false;

	}

	public List<RegistrationRequestDTO> entityToDto(List<RegistrationRequest> requestList, long userId)
			throws PortalException {

		if (null == requestList || requestList.size() == 0)
			return null;

		List<RegistrationRequestDTO> pisDtList = new ArrayList<RegistrationRequestDTO>();
		boolean isApprover = this.isApprover(userId);
		for (RegistrationRequest request : requestList) {

			if (isApprover && !this.isAssignableOrCompleted(request, userId))
				continue;

			pisDtList.add(entityToDto(request, userId, isApprover));
		}
		return pisDtList;
	}

	private RegistrationRequestDTO entityToDto(RegistrationRequest request, long userId, boolean isApprover)
			throws PortalException {

		RegistrationRequestDTO requestDto = new RegistrationRequestDTO();

		requestDto.setRegistrationRequestId(request.getRegistrationRequestId());
		requestDto.setUnitId(request.getUnitId());
		requestDto.setUnit(request.getUnit());
		requestDto.setRecordNo(request.getRecordNo());
		requestDto.setPersonalNo(request.getPersonalNo());
		requestDto.setFirstName(request.getFirstName());
		requestDto.setMiddleName(request.getMiddleName());
		requestDto.setLastName(request.getLastName());
	
		requestDto.setDesignationId(request.getDesignationId());
		requestDto.setDesignationName(request.getDesignation());
		requestDto.setDesignationCode(request.getDesignationCode());
		
		requestDto.setTradeId(request.getTradeId());
		requestDto.setTrade(request.getTrade());
		requestDto.setTradeCode(request.getTradeCode());
		
		requestDto.setGradeId(request.getGradeId());
		requestDto.setGrade(request.getGrade());
		requestDto.setGradeCode(request.getGradeCode());
		
		requestDto.setPostBox(request.getPostBox());
		requestDto.setRank(request.getRank());
		
		requestDto.setGenderId(request.getGenderId());
		requestDto.setGenderName(request.getGender());
		
		requestDto.setCasteCategoryId(request.getCasteCategoryId());
		requestDto.setCastCategory(request.getCasteCategory());
		
		requestDto.setDateOfBirth(request.getDateOfBirth());
		requestDto.setDateOfJoiningOrganization(request.getDateOfJoiningOrganization());
		
		requestDto.setMobile(request.getMobile());
		requestDto.setEmailAddress(request.getEmailAddress());
		requestDto.setDateOfJoiningUnit(request.getDateOfJoiningUnit());
		requestDto.setGpfnpsType(request.getGpfnpsType());
		requestDto.setGpfnpsNumber(request.getGpfnpsNumber());
		requestDto.setSection(request.getSection());
		requestDto.setLoginId(request.getLoginId());
		requestDto.setBulkOnbordingFileId(request.getBulkOnbordingFileId());
		requestDto.setModifiedDate(request.getModifiedDate());
		requestDto.setIdamUser(request.getIdamUser());
		requestDto.setDigitalSigning(request.getDigitalSigning());
		requestDto.setEmailAccess(request.getEmailAccess());
		requestDto.seteGovAccess(request.getEGovAccess());
		requestDto.setPisAccess(request.getPisAccess());

		requestDto.setAssignable(isActiontaken(request, userId));
		requestDto.setStatus(request.getStatus());
		requestDto.setApprover(isApproverOfRequest(request, userId));
		Map<Long, Set<String>> taskActionMap = getWorkFlowTask(request, userId);
		List<String> actionList = new ArrayList<String>();
		long taskId = 0;
		for (Long task : taskActionMap.keySet()) {
			taskId = task;
			actionList.addAll(taskActionMap.get(task));
		}
		requestDto.setActions(actionList);
		requestDto.setTaskId(taskId);
		requestDto.setErrorMessage(request.getErrorMessage());
		requestDto.setEditable(isEditableRequest(request, userId, taskId));

		return requestDto;
	}

	
	private Map<Long, Set<String>> getWorkFlowTask(RegistrationRequest registration, long userId)
			throws PortalException {
		Map<Long, Set<String>> taskActionMap = new HashMap<Long, Set<String>>();
		if(registration.getStatus()==WorkflowConstants.STATUS_INCOMPLETE) {
			return taskActionMap;
		}
		
		Set<String> actionList = new HashSet<String>();

		List<WorkflowLog> workflowLogs_assign = this.getWorkflowLogsAssign(registration);
		if (workflowLogs_assign.size() > 0) {
			for (WorkflowLog workflowLog : workflowLogs_assign) {
				long taskId = workflowLog.getWorkflowTaskId();
				WorkflowTask task = WorkflowTaskManagerUtil.getWorkflowTask(registration.getCompanyId(), taskId);
				if (null != task.getCompletionDate())
					continue;

				actionList.addAll(WorkflowTaskManagerUtil.getNextTransitionNames(registration.getCompanyId(), userId, taskId));
				taskActionMap.put(taskId, actionList);
			}
		} 
		
		return taskActionMap;
	}

	/*
	 * tskId is zero in case of final approve user can only edit if task assigned
	 */
	private boolean isEditableRequest(RegistrationRequest request, long userId, long taskId) throws WorkflowException {
		if(request.getStatus()==WorkflowConstants.STATUS_INCOMPLETE) {
			return false;
		}
		
		if (taskId == 0)
			return false;
		
		WorkflowTask task = WorkflowTaskManagerUtil.getWorkflowTask(request.getCompanyId(), taskId);
		List<User> userList = WorkflowTaskManagerUtil.getAssignableUsers(request.getCompanyId(), taskId);

		if (task.getAssigneeUserId() == 0 && userList.isEmpty())
			return false;
		else if (task.getAssigneeUserId() == userId || userList.stream().anyMatch(user -> user.getUserId() == userId))
			return true;

		return false;
	}

	public boolean isAdmin() throws PortalException {
		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		long userId = serviceContext.getUserId();
		LOGGER.info("userId"+ userId);
		return OnboardingUtil.isAdmin(userId);
	}
	
	public boolean isAdmin(long userId) throws PortalException {
		return OnboardingUtil.isAdmin(userId);
	}

	public boolean isApprover(long userId) throws PortalException {
		return OnboardingUtil.isApprover(userId);
	}

	public boolean isCreater(long userId) throws PortalException {
		return OnboardingUtil.isUploader(userId);
	}

	private RegistrationRequest convertToObject(RegistrationRequest request, RegistrationRequestDTO requestDto,
			ServiceContext serviceContext) throws PortalException {

		request.setModifiedDate(serviceContext.getModifiedDate(new Date()));

		request.setFirstName(requestDto.getFirstName());
		request.setMiddleName(requestDto.getMiddleName());
		request.setUnitId(requestDto.getUnitId());
		request.setUnit(requestDto.getUnit());
		request.setPersonalNo(requestDto.getPersonalNo());
		request.setRecordNo(requestDto.getRecordNo());
		request.setLastName(requestDto.getLastName());
		request.setGender(requestDto.getGenderName());
		request.setGenderId(requestDto.getGenderId());
		
		request.setDesignationId(requestDto.getDesignationId());
		request.setDesignation(requestDto.getDesignationName());
		request.setDesignationCode(requestDto.getDesignationCode());
		
		request.setTradeId(requestDto.getTradeId());
		request.setTrade(requestDto.getTrade());
		request.setTradeCode(requestDto.getTradeCode());
		
		request.setGrade(requestDto.getGrade());
		request.setGradeId(requestDto.getGradeId());
		request.setGradeCode(requestDto.getGradeCode());
		
		request.setDateOfBirth(requestDto.getDateOfBirth());
		request.setDateOfJoiningOrganization(requestDto.getDateOfJoiningOrganization());
		request.setCasteCategory(requestDto.getCastCategory());
		request.setCasteCategoryId(requestDto.getCasteCategoryId());
		request.setMobile(requestDto.getMobile());
		request.setEmailAddress(requestDto.getEmailAddress());
		request.setDateOfJoiningUnit(requestDto.getDateOfJoiningUnit());
		request.setGpfnpsType(requestDto.getGpfnpsType());
		request.setGpfnpsNumber(requestDto.getGpfnpsNumber());
		
		
		request.setSectionId(requestDto.getSectionId());
		request.setSection(requestDto.getSection());
		request.setSectionCode(requestDto.getSectionCode());
		
		request.setPostBox(requestDto.getPostBox());
		request.setRank(requestDto.getRank());
		
		request.setLoginId(requestDto.getLoginId());
		request.setIdamUser(requestDto.isIdamUser());
		request.setDigitalSigning(requestDto.isDigitalSigning());
		request.setEmailAccess(requestDto.isEmailAccess());
		request.setEGovAccess(requestDto.iseGovAccess());
		request.setPisAccess(requestDto.isPisAccess());
		request.setErrorMessage(requestDto.getErrorMessage());

		request.setExpandoBridgeAttributes(serviceContext);

		return request;
	}

	public boolean isPersonalNumberExists(long personalnumber, long requestId, long unitId) {
		List<RegistrationRequest> requestList = registrationRequestPersistence.findByPersonalNo(personalnumber);

		if (requestList.isEmpty()) {
			return false;
		}

		for (RegistrationRequest request : requestList) {
			if ((request.getRegistrationRequestId() != requestId) && unitId == request.getUnitId() 
					&& (request.getStatus() != WorkflowConstants.STATUS_DENIED)) {
				return true;
			}
		}
		return false;
	}

	public boolean isRecordNumberExists(long recordNo, long requestId) {
		List<RegistrationRequest> requestList = registrationRequestPersistence.findByRecordNo(recordNo);

		if (requestList.isEmpty()) {
			return false;
		}
		for (RegistrationRequest request : requestList) {
			if ((request.getRegistrationRequestId() != requestId) && (request.getStatus() != WorkflowConstants.STATUS_DENIED)) {
				return true;
			}
		}
		return false;
	}

    public boolean isEmailAddressExists(String emailAddress,long requestId)
    {
		List<RegistrationRequest> requestList = registrationRequestPersistence.findByEmailAddress(emailAddress);
		if (requestList.isEmpty()) {
			return false;
		}
		for (RegistrationRequest request : requestList) {
			if ((request.getRegistrationRequestId() != requestId) && (request.getStatus() != WorkflowConstants.STATUS_DENIED)) {
				return true;
			}
		}
		return false;
        
    }
    
	public void confirmRegistration(Map<String, Serializable> workflowContext) {
		LOGGER.info("************************************************************");
	}

	@Override
	public long getTotalApprovedCount(long bulkOnbordingFileId) {
		return registrationRequestPersistence.countByBulkOnbordingFileIdAndStatus(bulkOnbordingFileId, WorkflowConstants.STATUS_APPROVED); 
	}

	@Override
	public long getTotalCount(long bulkOnbordingFileId) {
		return registrationRequestPersistence.countByBulkOnbordingFileId(bulkOnbordingFileId);
	}

	@Override
	public long getTotalPendingCount(long bulkOnbordingFileId) {
		return registrationRequestPersistence.countByBulkOnbordingFileIdAndStatus(bulkOnbordingFileId, WorkflowConstants.STATUS_PENDING);
	}

	@Override
	public long getTotalApprovalPendingCount(long bulkOnbordingFileId) {
		return registrationRequestPersistence.countByBulkOnbordingFileIdAndStatus(bulkOnbordingFileId, WorkflowConstants.STATUS_SCHEDULED);
	}

	@Override
	public long getTotalRejectedCount(long bulkOnbordingFileId) {
		return registrationRequestPersistence.countByBulkOnbordingFileIdAndStatus(bulkOnbordingFileId, WorkflowConstants.STATUS_DENIED); 
	}

	@Override
	public long getTotalDraftCount(long bulkOnbordingFileId) {
		return registrationRequestPersistence.countByBulkOnbordingFileIdAndStatus(bulkOnbordingFileId, WorkflowConstants.STATUS_DRAFT);
	}
	
	@Override
	public long getTotalIncompleteCount(long bulkOnbordingFileId) {
		return registrationRequestPersistence.countByBulkOnbordingFileIdAndStatus(bulkOnbordingFileId, WorkflowConstants.STATUS_INCOMPLETE);
	}
	
	@Override
	public int getTotalCountByUnit(String unit) {
		return registrationRequestPersistence.countByUnit(unit); 
	}
	
	@Override
	public int getTotalCountByUnitAndStatus(String unit, int status) {
		return registrationRequestPersistence.countByUnitAndStatus(unit, status); 
	}
	
	
	public List<RegistrationRequestDTO> findBySearchParameter(RegistrationRequestSearchParameter registrationRequestSearchParameter) throws PortalException{
		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		List<RegistrationRequest>  registrationRequest=registrationRequestFinder.findBySearchParameter(registrationRequestSearchParameter);
		return entityToDto(registrationRequest, serviceContext.getUserId());
		
	}
	

	public List<RegistrationRequestDTO> findBySearchParameter(User user, RegistrationRequestSearchParameter registrationRequestSearchParameter) throws PortalException{
		
		List<RegistrationRequest> requestList = new ArrayList<RegistrationRequest>();
		
		if (this.isApprover(user.getUserId())) {
			long [] unitIds=registrationRequestSearchParameter.getUnitIds();
			List<Organization> organizations = OnboardingUtil.getUnitsByRole(user.getUserId(), OnboardingUserRole.APPROVER_ROLE);
			
			if(unitIds==null || unitIds.length ==0) { 
				unitIds = organizations.stream().mapToLong(org -> org.getOrganizationId()).toArray();
			}else {
				List<Organization> unitList = new ArrayList<Organization>();
				for(long unitId : unitIds) {
					Organization org =  OrganizationLocalServiceUtil.getOrganization(unitId);
					if(OnboardingUtil.isApprover(user.getUserId(), org)) {
						unitList.add(org);
					}
				}
				unitIds =unitList.stream().mapToLong(org -> org.getOrganizationId()).toArray();
			}
			registrationRequestSearchParameter.setUnitIds(unitIds);
			
			requestList.addAll(registrationRequestFinder.findBySearchParameter(registrationRequestSearchParameter));
		} else {
			requestList.addAll(registrationRequestFinder.findBySearchParameter(registrationRequestSearchParameter));
		}
		
		return entityToDto(requestList, user.getUserId());
	}
	
	
	private void verifyAndUpdateLoginId(RegistrationRequest registrationRequest) {
		
		if(registrationRequest == null) {
			return;
		}
		
		String loginId = registrationRequest.getLoginId();
		
		if(StringUtils.isBlank(loginId)){
			loginId = generateLoginId(registrationRequest.getFirstName(),registrationRequest.getMiddleName(),registrationRequest.getLastName());
		}
		
		loginId = loginId.replaceAll("[^a-zA-Z0-9._]", "");  
		
		loginId = StringUtils.lowerCase(loginId);
		String nextLoginId = getAvailableLoginId(loginId);
		registrationRequest.setLoginId(nextLoginId);
		
		registrationRequestPersistence.update(registrationRequest);
	}


	private String generateLoginId(String firstName, String middleName, String lastName) {
		
		String loginId =null;
		
		if(firstName == null) {
			firstName ="";
		}
		if(middleName == null) {
			middleName ="";
		}
		if(lastName == null) {
			lastName ="";
		}
		
		firstName = firstName.replaceAll("[^a-zA-Z0-9_]", "").toLowerCase();  
		middleName = middleName.replaceAll("[^a-zA-Z0-9_]", "").toLowerCase();  
		lastName = lastName.replaceAll("[^a-zA-Z0-9_]", "").toLowerCase(); 
		
		int firstNameLength = StringUtils.length(firstName);  
		int middleNameLength = StringUtils.length(middleName);  
		int lastNameLength = StringUtils.length(lastName); 
		
		if(middleNameLength>0) {
			if(lastNameLength>0){
				if(firstNameLength > 2) {
					loginId = firstName+"."+lastName;
				}else { //firstNameLength <=2
					loginId = firstName+middleName+"."+lastName;
				}
			}else {
				if(firstNameLength > 2) {
					loginId = firstName;
				}else { //firstNameLength <=2
					loginId = firstName+middleName;
				}
			}
		}else {
			if(lastNameLength>0){
				loginId = firstName+"."+lastName;
			}else {
				loginId = firstName;
			}
		}
		return loginId;
	}


	private String getAvailableLoginId(String loginId) {
		if(isLoginIdAvailable(loginId)) {
			return loginId;
		}
		
		String nextId = loginId;
		StringBuilder sbDigits = new StringBuilder();
		for (int i = loginId.length() - 1; i >= 0; i --) {
		    char c = loginId.charAt(i);
		    if (Character.isDigit(c)) {
		    	sbDigits.insert(0, c);
		    } else {
		        break;
		    }
		}
		
		if(sbDigits.length()==0) {
			nextId=nextId+"1";
		}else {
			nextId = loginId.replaceAll(sbDigits.toString()+"$", "");
			StringBuilder newDigits = new StringBuilder();
			int nextNumber = Integer.parseInt(sbDigits.toString())+1;
			newDigits.append(nextNumber);
			while(newDigits.length()<sbDigits.length()) {
				newDigits.insert(0,0);
			}
			nextId = nextId+newDigits.toString();
		}
		return getAvailableLoginId(nextId);
	}


	private boolean isLoginIdAvailable(String loginId) {
		//verify in approved records Liferay Users  and Employee
		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		List<RegistrationRequest> requsetList= registrationRequestPersistence.findByLoginIdAndStatus(loginId, WorkflowConstants.STATUS_APPROVED);
          Employee employeeByLoginId = EmployeeLocalServiceUtil.getEmployeeByLoginId(loginId);
		
		
		if(employeeByLoginId!=null ||!requsetList.isEmpty()) {
			return false;
		}
		
		try {
			User user = UserServiceUtil.getUserByScreenName(serviceContext.getCompanyId(), loginId);
			if(user!=null)
					return false;
		} catch (PortalException e) {
			LOGGER.debug(e.getMessage());
		}
	
		return true;
	}
	public String createUser(long registrationRequestId) {
		String message=null;
		
		try {
			RegistrationRequest record=registrationRequestPersistence.findByPrimaryKey(registrationRequestId);
			return createUser(record);
		}catch(Exception e) {
			message="Error: User creation failed "+e.getMessage();
		}
		
		return (message==null?"success":message);
	}
	
	public String createUser(RegistrationRequest record) {
		String message=null;
		
		try {
			synchronized (this) {
				if(StringUtils.isBlank(record.getLoginId())) {
					verifyAndUpdateLoginId(record);
				}
			}

			message=BulkOnboardUtils.recreateIDAMUser(record, boardingConfig );
			registrationRequestPersistence.update(record);
		}catch(Exception e) {
			message="Error: User creation failed "+e.getMessage();
		}
		
		return (message==null?"success":message);
	}
	
	public boolean beforeUpdateRegistrationRequest(Object entity, Map<String, String[]> paramMap) {
		boolean newPisAccess=false;
		boolean newEmailAccess=false;
		boolean newEGovAccess=false;
		boolean newDigitalSigning=false;
		RegistrationRequest request=(RegistrationRequest)entity;
		
		LOGGER.info("In beforeUpdateRegistrationRequest ");
		
		for(Map.Entry<String, String[]> entry:paramMap.entrySet()) {
			String keyValue=	entry.getKey()+" : ";
			for(String str:entry.getValue()) {
				keyValue+=str+", ";
			}
			LOGGER.info(keyValue);
		}
		try {
			String strPisAccess = StringUtils.trim(paramMap.get("pisAccess")!=null?paramMap.get("pisAccess")[0]:"0");
			String strEmailAccess = StringUtils.trim(paramMap.get("emailAccess")!=null?paramMap.get("emailAccess")[0]:"0");
			String strEGovAccess = StringUtils.trim(paramMap.get("eGovAccess")!=null?paramMap.get("eGovAccess")[0]:"0");
			String strDigitalSigning = StringUtils.trim(paramMap.get("digitalSigning")!=null?paramMap.get("digitalSigning")[0]:"0");

			if(strPisAccess.equals("1")) {
				newPisAccess=true;
			}else {
				paramMap.put("pisAccess", new String[] {"0"});
			}
			
			if(strEmailAccess.equals("1")) {
				newEmailAccess=true;
			}else {
				paramMap.put("emailAccess", new String[] {"0"});
			}
			
			if(strEGovAccess.equals("1")) {
				newEGovAccess=true;
			}else {
				paramMap.put("eGovAccess", new String[] {"0"});
			}
			
			if(strDigitalSigning.equals("1")) {
				newDigitalSigning=true;
			}else {
				paramMap.put("digitalSigning", new String[] {"0"});
			}
			
			LOGGER.info("strPisAccess : "+strPisAccess+", strEmailAccess : "+strEmailAccess+", strEGovAccess : "+strEGovAccess +", strDigitalSigning : "+strDigitalSigning);
			LOGGER.info("newPisAccess : "+newPisAccess+", request.getPisAccess() : "+request.getPisAccess());
		}catch(Exception e) {
			LOGGER.error(e);
		}
		try {
			
			LOGGER.info("request.getLoginId() : "+request.getLoginId());
			
			Employee employee=EmployeeLocalServiceUtil.getEmployeeByLoginId(request.getLoginId());
			
			LOGGER.info("employee.getLoginId(): "+employee.getLoginId()+", newPisAccess : "+newPisAccess+", request.getPisAccess() : "+request.getPisAccess());
			if(newPisAccess != request.getPisAccess()) {
				Role empRole= RoleLocalServiceUtil.getRole(request.getCompanyId(), boardingConfig.getEmployeeRole());
				//Role userRole= RoleLocalServiceUtil.getRole(request.getCompanyId(), boardingConfig.getUserRole());
				UserGroup userGroup= UserGroupLocalServiceUtil.getUserGroup(request.getCompanyId(), boardingConfig.getUserGroup());
				Group group=GroupLocalServiceUtil.getGroup(request.getCompanyId(),boardingConfig.getGroup());
				
				User user=null;
				
				try {
					user=UserLocalServiceUtil.getUserByScreenName(request.getCompanyId(), request.getLoginId());
				}catch(Exception e) {}
				
				if(newPisAccess) {
					if(user==null) {
						user=createAppUser(request.getRegistrationRequestId(), employee.getEmployeeId());
					}else {
						
						RoleLocalServiceUtil.addUserRole(user.getUserId(), empRole.getRoleId());
						//RoleLocalServiceUtil.addUserRole(user.getUserId(), userRole);
						UserGroupLocalServiceUtil.addUserUserGroup(user.getUserId(), userGroup.getUserGroupId());
						GroupLocalServiceUtil.addUserGroup(user.getUserId(), group.getGroupId());
						//UserLocalServiceUtil.addUserGroupUser(group.getGroupId(), user.getUserId());
						UserLocalServiceUtil.updateUser(user);
					}
				}else if(user!=null) {
					RoleLocalServiceUtil.deleteUserRole(user.getUserId(), empRole.getRoleId());
					//RoleLocalServiceUtil.deleteUserRole(user.getUserId(), userRole);
					UserGroupLocalServiceUtil.deleteUserUserGroup(user.getUserId(), userGroup.getUserGroupId());
					GroupLocalServiceUtil.deleteUserGroup(user.getUserId(), group.getGroupId());
					//UserLocalServiceUtil.deleteUserGroupUser(group.getGroupId(), user.getUserId());
					UserLocalServiceUtil.updateUser(user);
				}
			}
			
		}catch(Exception e) {
			LOGGER.error(e);
		}
		//RegistrationRequest request=null;
		try {
			//request=registrationRequestPersistence.findByPrimaryKey(Long.parseLong(paramMap.get("registrationRequestId")[0]));
		
			String [] attributes=new String [] {"liferay", "zimbra", "EGOV", "DSC"};
			String [] oldValues=null;
			if(request!=null) {
				oldValues=new String [] {(request.getPisAccess()?"Y":"N"), (request.getEmailAccess()?"Y":"N"), (request.getEGovAccess()?"Y":"N"), (request.getDigitalSigning()?"Y":"N")};
			}
			String [] newValues=new String [] {(newPisAccess?"Y":"N"), (newEmailAccess?"Y":"N"), (newEGovAccess?"Y":"N"), (newDigitalSigning?"Y":"N")};
			/*
			PISUserUtil.updateIDAMUser(request.getLoginId(), "liferay", (request.getPisAccess()?"Y":"N"), (newPisAccess?"Y":"N"));
			PISUserUtil.updateIDAMUser(request.getLoginId(), "zimbra", (request.getEmailAccess()?"Y":"N"), (newEmailAccess?"Y":"N"));
			PISUserUtil.updateIDAMUser(request.getLoginId(), "EGOV", (request.getEGovAccess()?"Y":"N"), (newEGovAccess?"Y":"N"));
			PISUserUtil.updateIDAMUser(request.getLoginId(), "DSC", (request.getDigitalSigning()?"Y":"N"), (newDigitalSigning?"Y":"N"));
			*/
			
			return PISUserUtil.updateIDAMUser(request.getLoginId(), attributes, oldValues, newValues);
			//return true;
		}catch(Exception e) {
			LOGGER.error(e);
		}
		return false;
	}
	
	public boolean afterUpdateRegistrationRequest(RegistrationRequest entity, Map<String, String[]> paramMap) {
		try {
			LOGGER.info("Update afterUpdateRegistrationRequest ");
			
			for(Map.Entry<String, String[]> entry:paramMap.entrySet()) {
				String keyValue=	entry.getKey()+" : ";
				for(String str:entry.getValue()) {
					keyValue+=str+", ";
				}
				LOGGER.info(keyValue);
			}
			return true;
		}catch(Exception e) {
			LOGGER.error(e);
		}

		return false;
	}
	public List<RegistrationRequest> searchRegistrationRequests(Map<String, String> searchFilter){
		List<RegistrationRequest> result=null;
		try {
			if(searchFilter!=null && searchFilter.size()>1) {
				DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(RegistrationRequest.class, getClass().getClassLoader()); 
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
					Method method=ReflectionUtil.getAccessorMethodByFieldName(RegistrationRequest.class, entry.getKey());
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
				result=registrationRequestPersistence.findAll();
			}
		}catch(Exception e) {
			LOGGER.error(e);
		}
		return result;
	}
	
	public RegistrationRequest getRegistrationRequestByPersonalNo(Long personalNo) {
		List<RegistrationRequest> registrationRequests=registrationRequestPersistence.findByPersonalNo(personalNo);
		
		if(registrationRequests!=null && registrationRequests.size()>=1) {
			return registrationRequests.get(0);
		}
		return null;
		
	}
	
	public Map<String, List<String>> deduplicateLoginIds(String duplicateLoginIds) {
		LOGGER.info("Calling deduplicateLoginId "+duplicateLoginIds);
		Map<String, List<String>> mapNewLoginIds=new HashMap<String, List<String>>();
		try {
			String[] arrDupLoginIds=duplicateLoginIds.split(",");
			for(String tmpDupLoginId:arrDupLoginIds) {
				List<String> newLoginIds=new ArrayList<String>();
				String dupLoginId=StringUtils.trim(tmpDupLoginId);
				List<RegistrationRequest> records=registrationRequestPersistence.findByLoginIdStatusStateAndIdamUserCreated(dupLoginId, 0, "APPROVED", false);
				if(records!=null && !records.isEmpty()) {
					for(RegistrationRequest record: records) {
						//if(("APPROVED").equalsIgnoreCase(record.getState()) && !record.isIdamUserCreated()) {
						createUser(record);
						newLoginIds.add(record.getPersonalNo()+" - "+record.getFirstName()+" - "+record.getLastName()+" - "+record.getLoginId());
						//}
					}
				}
				mapNewLoginIds.put(tmpDupLoginId, newLoginIds);
			}
		}catch(Exception e) {
			LOGGER.error(e);
		}
		LOGGER.info("Before returning deduplicateLoginId "+mapNewLoginIds);
		return mapNewLoginIds;
		
	}
	
	public Employee createEmployee(long requestId) {
		RegistrationRequest request=null;
		Employee employee= null;
		try {
			request = getRegistrationRequest(requestId);
		} catch (PortalException e) {
			LOGGER.error(e);
		}
		if(request!=null) {
			employee= BulkOnboardUtils.createEmployee(request, boardingConfig);
			if(employee!=null && boardingConfig.createEmployee()) {
				
				request.setEmployeeCreated(true);
				registrationRequestPersistence.update(request);
			}else {
				LOGGER.info(request.getFirstName()+" "+request.getLastName()+ " Employee not created");
			}
		}
		return employee;
	}
	
	public User createAppUser(long requestId,long employeeId) {
		RegistrationRequest request=null;
		Employee employee= null;
		
		try {
			request = getRegistrationRequest(requestId);
			employee=EmployeeLocalServiceUtil.getEmployee(employeeId);
		} catch (PortalException e) {
			LOGGER.error(e);
		}
		
		if(request!=null && employee!=null) {
			User user=BulkOnboardUtils.createAppUser(request, employee, boardingConfig);
			if(user!=null) {
				request.setAppUserCreated(true);
				registrationRequestPersistence.update(request);
				return user;
			}
			
		}else {
			LOGGER.info(request.getFirstName()+" "+request.getLastName()+ " User not created");
		}
			
		return null;
	}
	public RegistrationRequest updateRegistrationRequest(RegistrationRequest request) {
		
		registrationRequestPersistence.update(request);
		return request;
		
	}
	public String createUserWithPermission(long registrationRequestId,boolean emailAccess,boolean digitalSigning,boolean eGovAccess,boolean pisAccess) throws NoSuchRegistrationRequestException {
      String message=null;
		
		try {
			RegistrationRequest record=registrationRequestPersistence.findByPrimaryKey(registrationRequestId);
			record.setEmailAccess(emailAccess);
			record.setEGovAccess(eGovAccess);
			record.setDigitalSigning(digitalSigning);
			record.setPisAccess(pisAccess);
			LOGGER.info("createUserWithPermission "+record);
			LOGGER.info("emailAccess : " +emailAccess+"  digitalSigning : "+digitalSigning+"  eGovAccess : "+eGovAccess+"  pisAccess : "+pisAccess);
			return createUser(record);
		}catch(Exception e) {
			message="Error: User creation failed "+e.getMessage();
		}
		
		return (message==null?"success":message);
	}
		
		
	
}