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

import com.adjecti.mdm.liferay.model.WorkArea;
import com.adjecti.mdm.liferay.service.WorkAreaLocalServiceUtil;
import com.adjecti.pis.liferay.model.EmployeeWorkArea;
import com.adjecti.pis.liferay.service.base.EmployeeWorkAreaServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.security.access.control.AccessControlled;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the employee work area remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.adjecti.pis.liferay.service.EmployeeWorkAreaService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeWorkAreaServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=pis",
		"json.web.service.context.path=EmployeeWorkArea"
	},
	service = AopService.class
)
public class EmployeeWorkAreaServiceImpl
	extends EmployeeWorkAreaServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>com.adjecti.pis.liferay.service.EmployeeWorkAreaServiceUtil</code> to access the employee work area remote service.
	 */
	
	@AccessControlled(guestAccessEnabled = true)
	public JSONArray getByEmployeeId(long employeeId) {
		 List<EmployeeWorkArea> workAreas = employeeWorkAreaLocalService.getByEmployeeId(employeeId);
		 return toJSONArray(workAreas);
	}
	@AccessControlled(guestAccessEnabled = true)
	public JSONArray getByPersonalNo(String personalNo) {
		List<EmployeeWorkArea> workAreas =  employeeWorkAreaLocalService.getByPersonalNo(personalNo);
		return toJSONArray(workAreas);
	}
	
	private JSONArray toJSONArray(List<EmployeeWorkArea> workAreas) {
		JSONArray result=JSONFactoryUtil.createJSONArray();
		for(EmployeeWorkArea ewa:workAreas) {
			try {
				WorkArea wa =WorkAreaLocalServiceUtil.getWorkArea(ewa.getWorkAreaMajorId());
				WorkArea pwa =(wa.getWorkAreaId()>0?WorkAreaLocalServiceUtil.getWorkArea(wa.getParentWorkAreaId()): null);
				
				JSONObject json=JSONFactoryUtil.createJSONObject();
				json.put("employeeWorkAreaId", ewa.getEmployeeWorkAreaId());
				json.put("workAreaId", ewa.getWorkAreaMajorId());
				json.put("workAreaName", wa.getName());
				json.put("parentWorkAreaId", wa.getParentWorkAreaId());
				json.put("parentWorkAreaName", pwa.getName());
				json.put("fromDate", ewa.getFromDate());
				json.put("toDate", ewa.getToDate());
				result.put(json);
			}catch(Exception e) {};
		}
		return result;
	}
}