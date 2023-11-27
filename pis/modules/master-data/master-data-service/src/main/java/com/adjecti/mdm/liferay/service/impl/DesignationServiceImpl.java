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

package com.adjecti.mdm.liferay.service.impl;

import com.adjecti.mdm.liferay.model.Designation;
import com.adjecti.mdm.liferay.model.Grade;
import com.adjecti.mdm.liferay.service.DesignationLocalServiceUtil;
import com.adjecti.mdm.liferay.service.base.DesignationServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the designation remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.adjecti.mdm.liferay.service.DesignationService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DesignationServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=mdm",
		"json.web.service.context.path=Designation"
	},
	service = AopService.class
)
public class DesignationServiceImpl extends DesignationServiceBaseImpl {
	
	public List<Designation> getDesignations() {
		
		return DesignationLocalServiceUtil.getDesignations(QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);
	}
	public List<Designation> getDesignationsByGradeId(long gradeId) {
		return designationLocalService.getDesignationsByGradeId(gradeId);
	}
	public List<Designation> getDesignationsByDesignationClassId(long designationClassId) {
		return designationLocalService.getDesignationsByDesignationClassId(designationClassId);
	}
	public List<Designation> getDesignationsByDesignationGroupId(long designationGroupId) {
		return designationLocalService.getDesignationsByDesignationGroupId(designationGroupId);
	}
	public Grade getGradesByDesignationId(long designationId) {
		return designationLocalService.getGradesByDesignationId(designationId);
	}
	
	public List<Designation> getDesignationsByCadreId(long cadreId) {
		return null;
	}
}