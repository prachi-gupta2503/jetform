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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeApplicationException;
import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.liferay.model.EmployeeApplication;
import com.adjecti.pis.liferay.service.base.EmployeeApplicationLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the employee application local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.adjecti.pis.liferay.service.EmployeeApplicationLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeApplicationLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.adjecti.pis.liferay.model.EmployeeApplication",
	service = AopService.class
)
public class EmployeeApplicationLocalServiceImpl
	extends EmployeeApplicationLocalServiceBaseImpl {
	
	private final static Log _logger = LogFactoryUtil.getLog(EmployeeApplicationLocalServiceImpl.class.getName());

	public List<EmployeeApplication> addEmployeeApplications(List<EmployeeApplication> employeeApplications) throws PortalException{
		ServiceContext serviceContext=ServiceContextThreadLocal.getServiceContext();
				
				long userId = serviceContext.getUserId();
				User user = userLocalService.getUser(userId);
				long companyId=user.getCompanyId();
				long groupId=user.getGroupId();
				long employeeApplicationId=0;
				String userName=user.getFullName();
				EmployeeApplication application=null;
				List<EmployeeApplication> empApplication=new ArrayList<EmployeeApplication>();
				for(EmployeeApplication employeeApplication:employeeApplications) {
					
					if(employeeApplication.getEmployeeApplicationId()==0) {
						employeeApplicationId =counterLocalService.increment(EmployeeApplication.class.getName());
						application=employeeApplicationLocalService.createEmployeeApplication(employeeApplicationId);
					}else {
						application=	employeeApplicationPersistence.findByPrimaryKey(employeeApplication.getEmployeeApplicationId());
						employeeApplicationId=employeeApplication.getEmployeeApplicationId();
						
					}
					application.setApplicationId(employeeApplication.getApplicationId());
		            application.setUserId(userId);
		            application.setUserName(userName);
		            application.setCompanyId(companyId);
		            application.setGroupId(groupId);
		            application.setEmployeeApplicationId(employeeApplicationId);
		            application.setEmployeeId(employeeApplication.getEmployeeId());
		           application= employeeApplicationPersistence.update(application);
		           empApplication.add(application);
		            
				}
				return empApplication;
			}

		public List<EmployeeApplication> getByEmployeeId(long employeeId)
		{
			return employeeApplicationPersistence.findByEmployeeId(employeeId);
			
		}

		public List<EmployeeApplication> getByPersonaNo(String personalNo)
		{
			try
			{
			Employee employee = employeePersistence.findByPersonalNo(personalNo);
			if(employee != null)
			{
			return employeeApplicationPersistence.findByEmployeeId(employee.getEmployeeId());
			}
			}
			catch (Exception e) {
			_logger.error(e.getMessage());	
			}
			return null;
		}
}