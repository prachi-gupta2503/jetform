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

package net.ayudh.comnet.admin.service.impl;

import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil;
import com.adjecti.pis.liferay.util.PISUserUtil;
import com.adjecti.pis.model.RegistrationRequest;
import com.adjecti.pis.service.RegistrationRequestLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import net.ayudh.comnet.admin.model.ApplicationUser;
import net.ayudh.comnet.admin.service.base.ApplicationUserLocalServiceBaseImpl;

/**
 * The implementation of the application user local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>net.ayudh.comnet.admin.service.ApplicationUserLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ApplicationUserLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=net.ayudh.comnet.admin.model.ApplicationUser",
	service = AopService.class
)
public class ApplicationUserLocalServiceImpl
	extends ApplicationUserLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>net.ayudh.comnet.admin.service.ApplicationUserLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>net.ayudh.comnet.admin.service.ApplicationUserLocalServiceUtil</code>.
	 */
	
	
//	public void createApplicationUser(ApplicationUser applicationUser) throws PortalException {
//		
//		ServiceContext serviceContext=ServiceContextThreadLocal.getServiceContext();
//
//		long userId = serviceContext.getUserId();
//		User user = userLocalService.getUser(userId);
//		long companyId=user.getCompanyId();
//		long groupId=user.getGroupId();
//		ApplicationUser appUser=null;
//		long applicationUserId =0;
//		if(applicationUser.getApplicationUserId()==0) {
//			applicationUserId =counterLocalService.increment(ApplicationUser.class.getName());
//
//			appUser=applicationUserPersistence.create(applicationUserId);
//		}else {
//			
//			applicationUserId =applicationUser.getApplicationUserId();
//			
//			try {
//				appUser=applicationUserPersistence.findByPrimaryKey(applicationUserId);
//			} catch (NoSuchApplicationUserException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		appUser.setApplicationUserId(applicationUserId);
//		appUser.setGroupId(groupId);
//		appUser.setCompanyId(companyId);
//		appUser.setUserId(applicationUserId);
//		appUser.setUserName(applicationUser.getUserName());
//		appUser.setEmployeeId(applicationUser.getEmployeeId());
//		appUser.setStatus(applicationUser.getStatus());
//		appUser.setDeleted(applicationUser.getDeleted());
//		appUser.setIdamUser(applicationUser.getIdamUser());
//		appUser.setEmailAccess(applicationUser.getEmailAccess());
//		appUser.setDigitalSigning(applicationUser.getDigitalSigning());
//		appUser.setEGovAccess(applicationUser.getEGovAccess());
//		appUser.setPisAccess(applicationUser.getPisAccess());
//		
//		
//		
////		appUser.setLastIdamUser(applicationUser.getLastIdamUser());
////		appUser.setLastEmailAccess(applicationUser.getLastEmailAccess());
////		appUser.setLastDigitalSigning(applicationUser.getLastDigitalSigning());
////		appUser.setLastEGovAccess(applicationUser.getLastEGovAccess());
////		appUser.setLastPisAccess(applicationUser.getLastPisAccess());
//		Employee employee=EmployeeLocalServiceUtil.getEmployee(applicationUser.getEmployeeId());
//		
//	}

	public boolean createApplicationUser() {
		try {
			ServiceContext serviceContext=ServiceContextThreadLocal.getServiceContext();
			long applicationUserId=CounterLocalServiceUtil.increment(ApplicationUser.class.getName());
			applicationUserPersistence.create(applicationUserId);
			ApplicationUser applicationUser=fetchApplicationUser(applicationUserId);
//			applicationUser.setGroupId(employee.getGroupId());
//			applicationUser.setCompanyId(serviceContext.getCompanyId());
//			applicationUser.setUserId(employee.getUserId());
//			applicationUser.setUserName(employee.getUserName());
//			applicationUser.setEmployeeId(employee.getEmployeeId());
//			applicationUser.setLoginId(employee.getLoginId());
//			applicationUserPersistence.update(applicationUser);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	public boolean updateApplicationUser(ApplicationUser applicationUser, long applicationUserId) {
		try {
			System.out.println("Method call Successfuly "+applicationUserId);
			ApplicationUser applicationUser1=applicationUserPersistence.fetchByPrimaryKey(applicationUserId);
			Employee employee=EmployeeLocalServiceUtil.getEmployee(applicationUser1.getEmployeeId());
			
			applicationUser1.setIdamUser(applicationUser.isIdamUser());
			applicationUser1.setEmailAccess(applicationUser.isEmailAccess());
			applicationUser1.setDigitalSigning(applicationUser.isDigitalSigning());
			applicationUser1.setEGovAccess(applicationUser.isEGovAccess());
			applicationUser1.setPisAccess(applicationUser.isPisAccess());			
			//String oldIdamUser=getStatus(applicationUser1.isIdamUser());
			String oldEmailAccess=getStatus(applicationUser1.isEmailAccess());
			String oldDigitalSigning=getStatus(applicationUser1.isDigitalSigning());
			String oldEGovAccess=getStatus(applicationUser1.isEGovAccess());
			String oldPisAccess=getStatus(applicationUser1.isPisAccess());		
			//String newIdamUser=getStatus(applicationUser.isIdamUser());
			String newEmailAccess=getStatus(applicationUser.isEmailAccess());
			String newDigitalSigning=getStatus(applicationUser.isDigitalSigning());
			String newEGovAccess=getStatus(applicationUser.isEGovAccess());
			String newPisAccess=getStatus(applicationUser.isPisAccess());
			String[] attributes= {"zimbra","DSC","EGOV","liferay"};
			String[] oldValues= {oldEmailAccess,oldDigitalSigning,oldEGovAccess,oldPisAccess};
			String[] newValues= {newEmailAccess,newDigitalSigning,newEGovAccess,newPisAccess};
			PISUserUtil.updateIDAMUser(employee.getLoginId(), attributes, oldValues, newValues);
			String personalNo=employee.getPersonalNo();
	    	RegistrationRequest registrationRequest=RegistrationRequestLocalServiceUtil.getRegistrationRequestByPersonalNo(Long.parseLong(personalNo));
			Long registrationRequestId=registrationRequest.getRegistrationRequestId();
	    	RegistrationRequestLocalServiceUtil.createUser(registrationRequestId);
			System.out.println("Update Method call");
			applicationUserPersistence.update(applicationUser1);
			System.out.println("Task Done");
			return true;
		}catch (Exception e) {
			e.getMessage();
			return false;
		}
		
	}
	
	private String getStatus(boolean permission) {
		if(permission) {
			return "Y";
		}
		else {
			return "N";
		}
	}
  
	public ApplicationUser getApplicationUserByPersonalNo(String personalNo) {
		try {
			List<Organization> organizations=PISUserUtil.getUnitByRoles(PrincipalThreadLocal.getUserId());
			Employee employee=EmployeeLocalServiceUtil.getEmployeeByPersonalNo(personalNo);
			boolean hasUnit=false;
			for(Organization o:organizations){
				if(o.getOrganizationId()==employee.getOrganizationId()) {
					hasUnit=true;
					break;
				}
			}
			//if(hasUnit) {
				ApplicationUser applicationUser=applicationUserPersistence.findByEmployeeId(employee.getEmployeeId());
				return applicationUser;
			//}
			//else {
			//	return null;
			//}
			
		}catch (Exception e) {
			return null;
		}
	}

}