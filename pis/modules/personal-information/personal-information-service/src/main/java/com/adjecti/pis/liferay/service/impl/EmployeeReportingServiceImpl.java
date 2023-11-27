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

import com.adjecti.mdm.liferay.model.Designation;
import com.adjecti.mdm.liferay.service.DesignationLocalServiceUtil;
import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.liferay.model.EmployeeReporting;
import com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil;
import com.adjecti.pis.liferay.service.base.EmployeeReportingServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.security.access.control.AccessControlled;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the employee reporting remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.adjecti.pis.liferay.service.EmployeeReportingService</code>
 * interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeReportingServiceBaseImpl
 */
@Component(property = { "json.web.service.context.name=pis",
		"json.web.service.context.path=EmployeeReporting" }, service = AopService.class)
public class EmployeeReportingServiceImpl extends EmployeeReportingServiceBaseImpl {

	@AccessControlled(guestAccessEnabled = true)
	public JSONArray getByEmployeeId(long employeeId) {
		 List<EmployeeReporting> reportings = employeeReportingLocalService.getByEmployeeId(employeeId);
		 return toJSONArray(reportings);
	}
	
	@AccessControlled(guestAccessEnabled = true)
	public JSONArray getByReportingToId(long reportingToId) {
		 List<EmployeeReporting> reportings = employeeReportingLocalService.getByReportingToId(reportingToId);
		 JSONArray result=JSONFactoryUtil.createJSONArray();
		 for(EmployeeReporting er:reportings) {
			try {
				Employee e = EmployeeLocalServiceUtil.getEmployee(er.getEmployeeId());
				Designation d = DesignationLocalServiceUtil.getDesignation(e.getDesignationId());
				JSONObject json=JSONFactoryUtil.createJSONObject();
				json.put("employeeReportingId", er.getEmployeeReportingId());
				json.put("employeeId", er.getEmployeeId());
				json.put("name_En", e.getFullName_En());
				json.put("designationId", e.getDesignationId());
				json.put("designationName", d.getName_En());
				json.put("fromDate", er.getFromDate());
				json.put("toDate", er.getToDate());
				result.put(json);
			}catch(Exception e) {};
		 }
		 return toJSONArray(reportings);
	}
	
	@AccessControlled(guestAccessEnabled = true)
	public JSONArray getByPersonalNo(String personalNo) {
		List<EmployeeReporting> reportings =  employeeReportingLocalService.getByPersonalNo(personalNo);
		return toJSONArray(reportings);
	}
	
	private JSONArray toJSONArray(List<EmployeeReporting> reportings) {
		JSONArray result=JSONFactoryUtil.createJSONArray();
		for(EmployeeReporting er:reportings) {
			try {
				Employee e= EmployeeLocalServiceUtil.getEmployee(er.getReportingToId());
				Designation d=DesignationLocalServiceUtil.getDesignation(e.getDesignationId());
				JSONObject json=JSONFactoryUtil.createJSONObject();
				json.put("employeeReportingId", er.getEmployeeReportingId());
				json.put("reportingToId", er.getReportingToId());
				json.put("reportingToName_En", e.getFullName_En());
				json.put("reportingToDesignationId", e.getDesignationId());
				json.put("reportingToDesignationName", d.getName_En());
				json.put("fromDate", er.getFromDate());
				json.put("toDate", er.getToDate());
				result.put(json);
			}catch(Exception e) {};
		}
		return result;
	}
}