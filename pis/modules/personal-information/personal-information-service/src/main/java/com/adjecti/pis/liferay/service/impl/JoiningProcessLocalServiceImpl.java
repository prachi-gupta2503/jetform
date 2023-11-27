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

import com.adjecti.pis.liferay.model.JoiningProcess;
import com.adjecti.pis.liferay.model.ServiceRequest;
import com.adjecti.pis.liferay.model.SingleUserOnboarding;
import com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil;
import com.adjecti.pis.liferay.service.JoiningProcessLocalServiceUtil;
import com.adjecti.pis.liferay.service.ServiceRequestLocalServiceUtil;
import com.adjecti.pis.liferay.service.base.JoiningProcessLocalServiceBaseImpl;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.PropsUtil;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.osgi.service.component.annotations.Component;

@Component(property = "model.class.name=com.adjecti.pis.liferay.model.JoiningProcess", service = AopService.class)
public class JoiningProcessLocalServiceImpl extends JoiningProcessLocalServiceBaseImpl {
	private static final Log LOGGER = LogFactoryUtil.getLog(JoiningProcessLocalServiceImpl.class.getName());

	public int currentStatusByJoiningProcessId(long joiningProcessId) throws PortalException {
		JoiningProcess joiningProcess = JoiningProcessLocalServiceUtil.getJoiningProcess(joiningProcessId);
		return joiningProcess.getProcessStatus();

	}

	public String updateStatusByJoiningProcessId(long joiningProcessId, int status) throws PortalException {

		JoiningProcess joiningProcess = JoiningProcessLocalServiceUtil.getJoiningProcess(joiningProcessId);
		joiningProcess.setProcessStatus(status);
		joiningProcess.setReason("");
		JoiningProcessLocalServiceUtil.updateJoiningProcess(joiningProcess);

		if (status !=1) {
			return "success";
		}
		
			
			
			ServiceRequest serviceRequest= null;
			  
			     try {
			    	 serviceRequest = serviceRequestPersistence.findByJoiningProcessId(joiningProcessId).get(0);
			     } catch (Exception ex) {
			    	 LOGGER.error("No ServiceRequest exist with this JoiningProcessId :" + joiningProcessId);
			     }

			     
			try {
                 
				ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
				long userId = serviceContext.getUserId();
				Date createdDate = serviceContext.getCreateDate();
				User user = UserLocalServiceUtil.getUser(userId);
				String userName = user.getFullName();
				String loginId = user.getEmailAddress();

			

				long serviceRequestId = serviceRequest==null?CounterLocalServiceUtil.increment(ServiceRequest.class.getName()):0;
				 serviceRequest = serviceRequest==null ? ServiceRequestLocalServiceUtil.createServiceRequest(serviceRequestId) : serviceRequest;

				serviceRequest.setUserId(userId);
				serviceRequest.setUserName(userName);
				serviceRequest.setCreateDate(createdDate);
				serviceRequest.setOrganizationId(joiningProcess.getUnitId());
				serviceRequest.setEmployeeId(EmployeeLocalServiceUtil.getEmployeeByEmailId(loginId).getEmployeeId());

				try {
					String strRequestTypeId = PropsUtil.get("joining.service.request.type.id");
					LOGGER.info("joining.service.request.type.id: " + strRequestTypeId);
					serviceRequest.setServiceRequestTypeId(Long.parseLong(StringUtils.trim(strRequestTypeId)));
				} catch (Exception ex) {

					LOGGER.info("joining.service.request.type.id not found ");

				}

				serviceRequest.setSubject(joiningProcess.getName());
				serviceRequest.setDescription("Approval of " + joiningProcess.getName());
				serviceRequest.setStatus(1);
				serviceRequest.setJoiningProcessId(joiningProcessId);

				ServiceRequestLocalServiceUtil.updateServiceRequest(serviceRequest);
			} catch (Exception e) {
				LOGGER.error("Error creating service request :" + e.getMessage());
			}
			     
		return "success";

	}
	
	public List<JoiningProcess> getByUnitId(Long unitId)
	{
	return joiningProcessPersistence.findByUnitId(unitId);	
	}
	
	

}