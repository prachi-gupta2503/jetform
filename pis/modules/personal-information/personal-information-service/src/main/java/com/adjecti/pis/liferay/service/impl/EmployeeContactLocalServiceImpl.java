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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeContactException;
import com.adjecti.pis.liferay.model.Contact;
import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.liferay.model.EmployeeContact;
import com.adjecti.pis.liferay.service.ContactLocalServiceUtil;
import com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil;
import com.adjecti.pis.liferay.service.base.EmployeeContactLocalServiceBaseImpl;
import com.adjecti.pis.liferay.util.PISUserUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the employee contact local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.adjecti.pis.liferay.service.EmployeeContactLocalService</code>
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeContactLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.adjecti.pis.liferay.model.EmployeeContact", service = AopService.class)
public class EmployeeContactLocalServiceImpl extends EmployeeContactLocalServiceBaseImpl {

	private final static Log LOGGER = LogFactoryUtil.getLog(EmployeeContactLocalServiceImpl.class.getName());

	public EmployeeContact getEmployeeContactByEmployeeId(long employeeId) throws NoSuchEmployeeContactException {
		try {
			return employeeContactPersistence.findByEmployeeId(employeeId).get(0);
		}catch(Exception e) {}
		return null;
	}
	
	public List<EmployeeContact> getEmployeeContactsByEmployeeId(long employeeId) {
		return employeeContactPersistence.findByEmployeeId(employeeId);
	}

	public EmployeeContact getByPersonalNo(String personalNo) {
		Employee employee;
		try {
			employee = employeePersistence.findByPersonalNo(personalNo);
			if (employee != null) {
				return employeeContactPersistence.findByEmployeeId(employee.getEmployeeId()).get(0);
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return null;

	}
	
	public boolean beforeUpdateEmployeeContact(Object entity, Map<String, String[]> fieldValues) {
		
		LOGGER.info("beforeUpdateEmployeeContact(EmployeeContact) # fieldValues ");
		for(Map.Entry<String, String[]> x: fieldValues.entrySet()) {
			
			String[] y=x.getValue();
			String values="";
			if(y!=null) {
				for(String xs:y) {
					values+=xs+",";
				}
			}
			LOGGER.info("x.getKey() : "+x.getKey()+", values : ["+values+"]");
		}
		
		String oldMobile="";
		String newMobile="";
		EmployeeContact empContact=null;
		Employee employee=null;
		long employeeId=0;
		long contactId=0;
		
		try {
			employeeId=Long.parseLong(fieldValues.get("employeeId")[0].trim());
			employee=EmployeeLocalServiceUtil.getEmployee(employeeId);
		}catch(Exception e) {
			LOGGER.info(e.getMessage());
		}
		
		if(employee==null) {
			return false;
		}
		try {
			contactId=Long.parseLong(fieldValues.get("contactId")[0].trim());
		}catch(Exception e) {
			LOGGER.info(e.getMessage());
		}

		try {
			if(contactId==0) {
				contactId=Long.parseLong(fieldValues.get("contact_formClassPK")[0].trim());
				
			}
			if(contactId>0) {
				Contact contact=ContactLocalServiceUtil.getContact(contactId);
				oldMobile=contact.getMobile();
			}
		}catch(Exception e) {
			LOGGER.error(e);
		}
		
		List<String> attributes=new ArrayList<String>();
		List<String> oldValues=new ArrayList<String>();
		List<String> newValues=new ArrayList<String>();
		
		LOGGER.info("Before phone......");
		
		try {
			LOGGER.info("oldPhone : "+oldMobile);
			
			oldMobile = StringUtils.trim(oldMobile);
			newMobile = StringUtils.trim(fieldValues.get("contact_mobile")[0]);
			
			LOGGER.info("newMobile : "+newMobile);
			if((!StringUtils.isBlank(oldMobile) || !StringUtils.isBlank(newMobile)) && !StringUtils.equals(oldMobile, newMobile)) {
				attributes.add("mobile");
				
				if(!StringUtils.isBlank(oldMobile)) {
					oldValues.add(oldMobile);
				}
				
				if(!StringUtils.isBlank(newMobile)) {
					newValues.add(newMobile);
				}
			}
		}catch(Exception e) {
			LOGGER.error(e.getMessage());
		}
		return PISUserUtil.updateIDAMUser(employee.getLoginId(), attributes, oldValues, newValues);
	}
}