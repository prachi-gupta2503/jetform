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

import com.adjecti.mdm.liferay.exception.NoSuchDesignationException;
import com.adjecti.mdm.liferay.model.CadreDesignation;
import com.adjecti.mdm.liferay.model.Designation;
import com.adjecti.mdm.liferay.model.Grade;
import com.adjecti.mdm.liferay.service.CadreDesignationLocalServiceUtil;
import com.adjecti.mdm.liferay.service.DesignationLocalServiceUtil;
import com.adjecti.mdm.liferay.service.GradeLocalServiceUtil;
import com.adjecti.mdm.liferay.service.base.DesignationLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the designation local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.adjecti.mdm.liferay.service.DesignationLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DesignationLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.adjecti.mdm.liferay.model.Designation",
	service = AopService.class
)
public class DesignationLocalServiceImpl
	extends DesignationLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.adjecti.mdm.liferay.service.DesignationLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.adjecti.mdm.liferay.service.DesignationLocalServiceUtil</code>.
	 */
	
	public List<Designation> getDesignationByName(String designationName) {
		 if(StringUtils.isNotEmpty(designationName)) {
			return designationPersistence.findByName(designationName);
		}
		return null;
	}
	
	public Grade getGradesByDesignationId(long designationId) {
		try {
			Designation designation = DesignationLocalServiceUtil.getDesignation(designationId);
			Grade grade = GradeLocalServiceUtil.getGrade(designation.getGradeId());
			return grade;
		} catch (PortalException e) {
			
			
		}
		return null;
		
	}
	public List<Designation> getByDesignationGroup(String designationGroupName){
		
		return designationPersistence.findByDesignationGroup(designationGroupName,0);
	}
	public Designation getDesignationByCode(String code) {
		 if(StringUtils.isNotEmpty(code)) {
			try {
				return designationPersistence.findByCode(code);
			} catch (NoSuchDesignationException e) {
			}
		}
		return null;
	}
	
	public List<Designation> getDesignationsByGradeId(long gradeId) {
		return designationPersistence.findByGradeId(gradeId, false);
	}
	
	
	public List<Designation> getDesignationsByStatus(int status) {
				return designationPersistence.findByStatus(status);
	}
	public int getDesignationsCountByGradeId(long gradeId){
		try {
			return designationPersistence.countByGradeId(gradeId, false);
		}catch(Exception e) {}
		return 0;
	}
	
	public List<Designation> getDesignationsByDesignationClassId(long designationClassId) {
		return designationPersistence.findByDesignationClassId(designationClassId);
	}
	
	public int getDesignationsCountByDesignationClassId(long designationClassId){
		try {
			return designationPersistence.countByDesignationClassId(designationClassId);
		}catch(Exception e) {}
		return 0;
	}
	
	public List<Designation> getDesignationsByDesignationGroupId(long designationGroupId) {
		
		return designationPersistence.findByDesignationGroupId(designationGroupId);
	}
	
	public int getDesignationsCountByDesignationGroupId(long designationGroupId,boolean deleted){
		return designationPersistence.findByDesignationGroupIdAndDeleted(designationGroupId,deleted).size();
	}
	
	public List<Designation> getDesignationsByCadreId(long cadreId) {
		List<CadreDesignation> cadreDesigs=CadreDesignationLocalServiceUtil.getCadreDesignationsByCadreId(cadreId);
		List<Long> desigIds=new ArrayList<Long>();
		for(CadreDesignation cd:cadreDesigs) {
			desigIds.add(cd.getDesignationId());
		}
		List<Designation> result=new ArrayList<Designation>();

		if(desigIds.size()>0) {
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Designation.class, getClass().getClassLoader()); 
			dynamicQuery.add(RestrictionsFactoryUtil.in("designationId", desigIds));
			result=dynamicQuery(dynamicQuery);
		}
		return result;
	}
}