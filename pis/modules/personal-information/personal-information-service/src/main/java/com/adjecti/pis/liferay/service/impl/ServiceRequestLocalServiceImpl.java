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

import com.adjecti.pis.liferay.model.ServiceRequest;
import com.adjecti.pis.liferay.service.ServiceRequestLocalServiceUtil;
import com.adjecti.pis.liferay.service.base.ServiceRequestLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the service request local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.adjecti.pis.liferay.service.ServiceRequestLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ServiceRequestLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.adjecti.pis.liferay.model.ServiceRequest",
	service = AopService.class
)
public class ServiceRequestLocalServiceImpl
	extends ServiceRequestLocalServiceBaseImpl {

	

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.adjecti.pis.liferay.service.ServiceRequestLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.adjecti.pis.liferay.service.ServiceRequestLocalServiceUtil</code>.
	 */
	private static Log LOGGER = LogFactoryUtil.getLog(ServiceRequestLocalServiceImpl.class);
	
	public List<ServiceRequest> getServiceRequestByStatus(int status){
		
		return serviceRequestPersistence.findByStatus(status).stream().filter(s->s.getDeleted()==false).collect(Collectors.toList());
		
	}
	public List<ServiceRequest> getServiceRequestByStatusAndOrganization(int status,long organizationId){
		
		return serviceRequestPersistence.findByStatusAndOrganization(status, organizationId).stream().filter(s->s.getDeleted()==false).collect(Collectors.toList());
		
	}
	
	
public List<ServiceRequest> getByServiceRequestTypeIdAndDeleted(long serviceRequestTypeId,boolean deleted){
		
		return serviceRequestPersistence.findByServiceRequestTypeIdAndDeleted(serviceRequestTypeId, deleted);
		
	}
	
	
}