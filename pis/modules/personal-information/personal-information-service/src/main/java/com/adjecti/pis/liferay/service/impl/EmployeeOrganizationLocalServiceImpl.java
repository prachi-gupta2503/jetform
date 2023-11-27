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

import com.adjecti.mdm.liferay.model.OrganizationDetail;
import com.adjecti.mdm.liferay.service.OrganizationDetailLocalServiceUtil;
import com.adjecti.mdm.liferay.util.MDMUtils;
import com.adjecti.pis.liferay.exception.NoSuchEmployeeException;
import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.liferay.model.EmployeeOrganization;
import com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil;
import com.adjecti.pis.liferay.service.EmployeeOrganizationLocalServiceUtil;
import com.adjecti.pis.liferay.service.base.EmployeeOrganizationLocalServiceBaseImpl;
import com.adjecti.pis.liferay.util.PISUserUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PropsUtil;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the employee organization local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.adjecti.pis.liferay.service.EmployeeOrganizationLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeOrganizationLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.adjecti.pis.liferay.model.EmployeeOrganization",
	service = AopService.class
)
public class EmployeeOrganizationLocalServiceImpl
	extends EmployeeOrganizationLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.adjecti.pis.liferay.service.EmployeeOrganizationLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.adjecti.pis.liferay.service.EmployeeOrganizationLocalServiceUtil</code>.
	 */
	private final static Log LOGGER = LogFactoryUtil.getLog(EmployeeOrganizationLocalServiceImpl.class.getName());
	
	
	public List<EmployeeOrganization> getEmployeeOrganizationsByPersonalNo(String personalNo){
		try {
			Employee employee=EmployeeLocalServiceUtil.getEmployeeByPersonalNo(personalNo);
			return employeeOrganizationPersistence.findByEmployeeId(employee.getEmployeeId());
		}catch(Exception e) {}
		return null;
	}
	
	public List<EmployeeOrganization> getEmployeeOrganizationsByEmployeeId(long employeeId){
		try {
			return employeeOrganizationPersistence.findByEmployeeId(employeeId);
		}catch(Exception e) {}
		return null;
	}
	public Map<String,String> importEmployeeOrganization(List<Map<String, String[]>> records) {
		LOGGER.info("In importEmployeeOrganization(List<Map<String, String[]>> records)");
		Map<String,String> result=new HashMap<String,String>();
		int importCtr=0;
		int failedCtr=0;
		
		result.put("totalCtr", String.valueOf(CollectionUtils.isEmpty(records)?0:records.size()));
		result.put("importCtr", String.valueOf(importCtr));
		result.put("failedCtr", String.valueOf(failedCtr));
		
		if(CollectionUtils.isEmpty(records)) {
			return result;
		}
		
		int ctr=0;
		
		Map<String, List<String>> mapSectionCodes=new HashMap<String, List<String>>();
		Map<String, List<String>> mapSectionShortNames=new HashMap<String, List<String>>();
		Map<String, List<String>> mapSectionLongNames=new HashMap<String, List<String>>();
		for(Map<String, String[]> paramMap : records) {
			ctr++;
			String error="";
			/*String keys="";
			String values="";
			for(Map.Entry<String, String[]> entry:paramMap.entrySet()) {
				keys+=entry.getKey()+", ";
				if(entry.getValue()==null) {
					values+="null, ";
					continue;
				}
				values+="[";
				for(String s:entry.getValue()) {
					values+=s+",";
				}
				values+="],";
			}
			
			LOGGER.info(ctr+" keys : "+keys);
			LOGGER.info(ctr+" values : "+values);*/
			try {
				String personalNo=paramMap.get("personalNo")[0];
				String unitCode=paramMap.get("unitCode")[0];
				String sectionCode=paramMap.get("sectionCode")[0];
				
				Employee employee=EmployeeLocalServiceUtil.getEmployeeByPersonalNo(personalNo);
				if(employee==null) {
					error="No employee found with personal number : "+personalNo;
					result.put("Row"+ctr, error);
					continue;
				}
				LOGGER.info("Employee : employeeId - "+employee.getEmployeeId() +", personalNo : " + employee.getPersonalNo());
				List<OrganizationDetail> unitList=OrganizationDetailLocalServiceUtil.getOrganizationDetailByTypeAndOrganizationCode("Unit", unitCode);
				OrganizationDetail unit=null;
				
				if(CollectionUtils.isEmpty(unitList)) {
					error="No unit exists with the Unit Code "+unitCode;
					result.put("Row"+ctr, error);
					continue;
				}
				unit = unitList.get(0);
				LOGGER.info("unit : unitId - "+unit.getOrganizationDetailId()+", unit code : " + unit.getOrganizationCode() +", unit name : " + unit.getShortName());
				//OrganizationDetail section=OrganizationDetailLocalServiceUtil.getSectionByUnitCodeAndSectionCode(unitCode, sectionCode);
				
				OrganizationDetail section=null;
				
				try {
					section=OrganizationDetailLocalServiceUtil.getOrganizationDetailByParentIdAndOrganizationCode(unit.getOrganizationDetailId(), sectionCode).get(0);
				}catch(Exception e) {
					LOGGER.error(e.getMessage());
				}
				if(section==null) {
					error="There is no section found with section code '"+sectionCode+"' under unit "+unitCode;
					result.put("Row"+ctr, error);
					continue;
				}
				
				LOGGER.info("section : sectionId - "+section.getOrganizationDetailId()+", section code : " + section.getOrganizationCode() +", section name : " + section.getShortName());
				
				if(employee.getSubOrganizationId()==section.getOrganizationDetailId()) {
					error="Already '"+sectionCode+"' under unit '"+unitCode+"' has been assigned as primary section for personal no:"+personalNo;
					result.put("Row"+ctr, error);
					continue;
				}
				
				/*boolean mappingExists=false;
				List<EmployeeOrganization> empOrgList= employeeOrganizationPersistence.findByEmployeeId(employee.getEmployeeId());
				if(CollectionUtils.isNotEmpty(empOrgList)) {
					for(EmployeeOrganization empOrg: empOrgList) {
						if(empOrg.getSubOrganizationId()==section.getOrganizationDetailId() && empOrg.getOrganizationId()==unit.getOrganizationDetailId()) {
							mappingExists=true;
							break;
						}
					}
				}*/
				
				if(existsEmployeeSubOrganization(employee.getEmployeeId(), section.getOrganizationDetailId())){
				//if(mappingExists) {
					error="Already a mapping exists for personal no: "+personalNo+" for section :"+sectionCode+" and unit : "+unitCode;
					result.put("Row"+ctr, error);
					continue;
				}
				
				long empOrgId=CounterLocalServiceUtil.increment(EmployeeOrganization.class.getName());
				EmployeeOrganization empOrg=employeeOrganizationPersistence.create(empOrgId);
				empOrg.setEmployeeId(employee.getEmployeeId());
				empOrg.setPersonalNo(personalNo);
				empOrg.setOrganizationId(unit.getOrganizationDetailId());
				empOrg.setOrganizationCode(unit.getOrganizationCode());
				empOrg.setSubOrganizationId(section.getOrganizationDetailId());
				empOrg.setSubOrganizationCode(section.getOrganizationCode());
				employeeOrganizationPersistence.update(empOrg);
				
				String mappingString="section (";
				try {
					List<String> mapSectionCode=mapSectionCodes.get(employee.getLoginId());
					if(mapSectionCode==null) {
						mapSectionCode=new ArrayList<String>();
					}
					mapSectionCode.add(section.getOrganizationCode());
					mapSectionCodes.put(employee.getLoginId(), mapSectionCode);
					mappingString+=section.getOrganizationCode()+",";
				}catch(Exception e) {LOGGER.error(e);}
				
				try {
					List<String> mapSectionShortName=mapSectionShortNames.get(employee.getLoginId());
					if(mapSectionShortName==null) {
						mapSectionShortName=new ArrayList<String>();
					}
					mapSectionShortName.add(section.getShortName());
					mapSectionShortNames.put(employee.getLoginId(), mapSectionShortName);
					mappingString+=section.getShortName()+",";
				}catch(Exception e) {LOGGER.error(e);}
				
				try {
					List<String> mapSectionLongName=mapSectionLongNames.get(employee.getLoginId());
					if(mapSectionLongName==null) {
						mapSectionLongName=new ArrayList<String>();
					}
					
					mapSectionLongName.add(section.getLongName());
					mapSectionLongNames.put(employee.getLoginId(), mapSectionLongName);
					mappingString+=section.getLongName();
					
				}catch(Exception e) {LOGGER.error(e);}
				
				LOGGER.info("Section mapped for employee["+employee.getLoginId()+"] - "+mappingString+")");
				result.put("Row"+ctr, "Success");
				
				importCtr++;
			}catch(Exception e) {
				LOGGER.info(e);
			}
		}
		
		String [] attributes=new String [] {"sectioncode", "section", "sectiondescription"};
		String [] oldValues=null;
		String [] newValues=new String [] {"","",""};		
		try {
			for(Map.Entry<String, List<String>> entry:mapSectionCodes.entrySet()) {
				String loginId=entry.getKey();
				
				List<String> sectionCodes=entry.getValue();
				List<String> sectionNames=mapSectionShortNames.get(loginId);				
				List<String> sectionLongNames=mapSectionLongNames.get(loginId);
				
				for(int i=0;i<sectionCodes.size();i++) {
					newValues[0]="";
					newValues[1]="";
					newValues[2]="";
					
					newValues[0]=sectionCodes.get(i);
					if(sectionNames.size()>i) {
						newValues[1]=sectionNames.get(i);
					}else {
						newValues[1]="";
					}
					if(sectionLongNames.size()>i) {
						newValues[2]=sectionLongNames.get(i);
					}else {
						newValues[2]="";
					}

					LOGGER.info("Before calling  PISUserUtil.updateIDAMUser("+loginId+",sectioncode="+newValues[0]+", section="+newValues[1]+", sectiondecription="+newValues[1]+")");
					PISUserUtil.updateIDAMUser(loginId, attributes, oldValues, newValues);

				}
				
				//DO nothing
			}
		}catch(Exception e) {LOGGER.error(e);}
		
		
		result.put("importCtr", String.valueOf(importCtr));
		result.put("failedCtr", String.valueOf(records.size()-importCtr));

		//LOGGER.info(""+result);
		
		return result;
		
	}
	
	public boolean beforeUpdateEmployeeOrganization(Object entity, Map<String, String[]> fieldValues) throws PortalException{
		LOGGER.info("beforeUpdateEmployeeOrganization(Object) is called");
		//try {
			EmployeeOrganization eo=(EmployeeOrganization)entity;
			return beforeUpdateEmployeeOrganization(eo, fieldValues);
		/*}catch(PortalException e) {
			LOGGER.info(e.getMessage());
			throw e;
		}*/
	}
	

	public boolean beforeUpdateEmployeeOrganization(EmployeeOrganization entity, Map<String, String[]> fieldValues) throws PortalException {
		LOGGER.info("beforeUpdateEmployeeOrganization(EmployeeOrganization) is called with fieldValues");
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
		String error="";
		long employeeId=0;
		long organizationId=0;
		long subOrganizationId=0;
		try {
			employeeId=Long.parseLong(fieldValues.get("employeeId")[0].trim());
			organizationId=Long.parseLong(fieldValues.get("organizationId")[0].trim());
			subOrganizationId=Long.parseLong(fieldValues.get("subOrganizationId")[0].trim());
		}catch(Exception e) {
			LOGGER.error(e);
		}
		
		if(employeeId==0 || organizationId==0 || subOrganizationId==0) {
			error="Invalid data with blank or zero values passed!";
			throw new PortalException(error);
		}
		
		Employee emp=null;
		try {
			emp=EmployeeLocalServiceUtil.getEmployee(employeeId);
			if(emp.getSubOrganizationId()==subOrganizationId) {
				error="Already this section has been assigned as primary section of the employee.";
				throw new PortalException(error);
			}
		}catch(PortalException e) {
			LOGGER.error(e);
			throw e;
		}catch(Exception e) {
			LOGGER.error(e);
			throw new PortalException(e);
		}
		
		LOGGER.info("employeeId : "+employeeId+",  organizationId : "+organizationId+", subOrganizationId: "+subOrganizationId);
		/*boolean mappingExists=false;
		List<EmployeeOrganization> empOrgList= employeeOrganizationPersistence.findByEmployeeId(employeeId);
		if(CollectionUtils.isNotEmpty(empOrgList)) {
			for(EmployeeOrganization empOrg: empOrgList) {
				if(empOrg.getSubOrganizationId()==subOrganizationId && empOrg.getOrganizationId()==organizationId) {
					mappingExists=true;
					break;
				}
			}
		}*/
		
		if(existsEmployeeSubOrganization(emp.getEmployeeId(), subOrganizationId)){
		//if(mappingExists) {
			error="Already this section has been assigned to the employee.";
			throw new PortalException(error);
		}
		
		try {
			/*Organization org=OrganizationLocalServiceUtil.getOrganization(subOrganizationId);
			String sectionName=org.getName();
			String sectionCode=ExpandoValueLocalServiceUtil.getData(org.getCompanyId(), Organization.class.getName(), "CUSTOM_FIELDS", "code", subOrganizationId, "");
			String longName=ExpandoValueLocalServiceUtil.getData(org.getCompanyId(), Organization.class.getName(), "CUSTOM_FIELDS", "longName", subOrganizationId, "");
			*/
			OrganizationDetail org=OrganizationDetailLocalServiceUtil.getOrganizationDetail(subOrganizationId);
			String sectionCode=org.getOrganizationCode();
			String sectionName=org.getShortName();
			String longName=org.getLongName();
			String [] attributes=new String [] {"sectioncode", "section", "sectiondescription"};
			String [] oldValues=null;
			String [] newValues=new String [] {sectionCode, sectionName, longName};
			
			PISUserUtil.updateIDAMUser(emp.getLoginId(), attributes, oldValues, newValues);
			return true;
		}catch(Exception e) {
			LOGGER.error(e);
			throw new PortalException(e);
		}
	}
	
	public boolean beforeDeleteEmployeeOrganization(Object entity, boolean logical) throws PortalException {
		LOGGER.info("beforeDeleteEmployeeOrganization(Object) is called");
		
		//try {
			EmployeeOrganization empOrg=(EmployeeOrganization)entity;
			return beforeDeleteEmployeeOrganization(empOrg, logical);
		//	return true;
		/*}catch(Exception e) {LOGGER.error(e);
			if(e instanceof PortalException) {
				throw (PortalException)e;
			}else {
				throw new PortalException(e);
			}
		}*/
			
		/*
		 * String egovValidate=PropsUtil.get("organization.egov.validate.ondelete");
		 * if(StringUtils.containsIgnoreCase("true", StringUtils.trim(egovValidate))){
		 * return beforeDeleteEmployeeOrganization(empOrg, logical); }else { return
		 * true; }
		 */
	}
	
	public boolean beforeDeleteEmployeeOrganization(EmployeeOrganization entity, boolean logical) throws PortalException {
		LOGGER.info("beforeDeleteEmployeeOrganization(EmployeeOrganization) is called");
		//String egovValidate=PropsUtil.get("organization.egov.validate.ondelete");
		//if(StringUtils.containsIgnoreCase("true", StringUtils.trim(egovValidate))){	
		try {
			Employee emp=EmployeeLocalServiceUtil.getEmployee(entity.getEmployeeId());
			OrganizationDetail org=OrganizationDetailLocalServiceUtil.getOrganizationDetail(entity.getSubOrganizationId());
			
			if(StringUtils.isNotBlank(org.getOrganizationCode())) {
				boolean isInboxEmpty=PISUserUtil.isEgovInboxEmpty(emp.getLoginId(), org.getOrganizationCode());
				
				if(!isInboxEmpty) {
					return false;
				}
			}
			
			//long subOrganizationId=emp.getSubOrganizationId();
			/*Organization org=OrganizationLocalServiceUtil.getOrganization(subOrganizationId);
			String sectionName=org.getName();
			String sectionCode=ExpandoValueLocalServiceUtil.getData(org.getCompanyId(), Organization.class.getName(), "CUSTOM_FIELDS", "code", subOrganizationId, "");
			String longName=ExpandoValueLocalServiceUtil.getData(org.getCompanyId(), Organization.class.getName(), "CUSTOM_FIELDS", "longName", subOrganizationId, "");
			*/
			
			String sectionCode=org.getOrganizationCode();
			String sectionName=org.getShortName();
			String longName=org.getLongName();
			
			String [] attributes=new String [] {"sectioncode", "section", "sectiondescription"};
			String [] oldValues=new String [] {sectionCode, sectionName, longName};
			String [] newValues=null;			
			PISUserUtil.updateIDAMUser(emp.getLoginId(), attributes, oldValues, newValues);
			return true;
		}catch(Exception e) {
			LOGGER.error(e.getMessage());
			if(e instanceof PortalException) {
				throw (PortalException)e;
			}else {
				throw new PortalException(e.getMessage());
			}
		}
		
	}
	
	public boolean existsEmployeeOrganization(long employeeId, long organizationId) {
		try {
			if(employeeOrganizationPersistence.countByEmployeeIdAndOrganizationId(employeeId, organizationId)>0) {
				return true;
			}
		}catch(Exception e) {
			LOGGER.info(e);
		}
		return false;
	}
	
	public boolean existsEmployeeSubOrganization(long employeeId, long subOrganizationId) {
		try {
			if(employeeOrganizationPersistence.countByEmployeeIdAndSubOrganizationId(employeeId, subOrganizationId)>0) {
				return true;
			}
		}catch(Exception e) {
			LOGGER.info(e);
		}
		return false;
	}
	
	public List<EmployeeOrganization> getByEmployeeIdAndOrganizationId(long employeeId, long organizationId) {
		try {
			return employeeOrganizationPersistence.findByEmployeeIdAndOrganizationId(employeeId, organizationId);
		}catch(Exception e) {
			LOGGER.info(e);
		}
		return new ArrayList<EmployeeOrganization>();
	}
	
	public List<EmployeeOrganization> getByEmployeeIdAndSubOrganizationId(long employeeId, long subOrganizationId) {
		try {
			return employeeOrganizationPersistence.findByEmployeeIdAndSubOrganizationId(employeeId, subOrganizationId);
		}catch(Exception e) {
			LOGGER.info(e);
		}
		return new ArrayList<EmployeeOrganization>();
	}
	
	public int getEmployeeOrganizationCountByEmployeeIdAndOrganizationId(long employeeId, long organizationId) {
		try {
			return employeeOrganizationPersistence.countByEmployeeIdAndOrganizationId(employeeId, organizationId);
		}catch(Exception e) {
			LOGGER.info(e);
		}
		return 0;
	}
	
	public int getEmployeeOrganizationCountByEmployeeIdAndSubOrganizationId(long employeeId, long subOrganizationId) {
		try {
			return employeeOrganizationPersistence.countByEmployeeIdAndSubOrganizationId(employeeId, subOrganizationId);
		}catch(Exception e) {
			LOGGER.info(e);
		}
		return 0;
	}
	
	public List<Organization> getNonAssignedOrganizationsOfEmployee(long parentId,String type,long employeeId){
		List<Organization> organizations = MDMUtils.getOrganizationsByParentIdAndType(parentId, type);
		List<Organization> nonAssignedOrganizations=null;
		try {
			
			List<Long> assignedOrganizations = EmployeeOrganizationLocalServiceUtil.getEmployeeOrganizationsByEmployeeId(employeeId)
																			      .stream()
																			      .map(emporg->emporg.getSubOrganizationId())
																			      .collect(Collectors.toList());
			assignedOrganizations.add(EmployeeLocalServiceUtil.getEmployeeByEmployeeId(employeeId).getSubOrganizationId());
			nonAssignedOrganizations = organizations.parallelStream()
					                                  .filter(org->assignedOrganizations
					                                		  .parallelStream()
					                                		  .noneMatch(assignedOrg->assignedOrg.equals(org.getOrganizationId())))
					                                  .collect(Collectors.toList());
		
		}catch (NoSuchEmployeeException e) {
			LOGGER.error(e);
		}
		return nonAssignedOrganizations;
	}
	
	public String updateOrganization(ThemeDisplay themeDisplay, String status, long organizationId) {
		String returnValue="";
		if(status.equals("Dissolved") || status.equals("Merged") ||status.equals("Splited") ) {
			OrganizationDetail org=null;
			try {
				org = OrganizationDetailLocalServiceUtil.getOrganizationDetail(organizationId);
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String sectionCode=org.getOrganizationCode();
			boolean isEgovFileExist=  isEgovFileExist(sectionCode);
			if(!isEgovFileExist) {
				returnValue ="EOO1";
			}
			LOGGER.info(isEmployeeExistWithOrganizationId(organizationId));
			if(!isEmployeeExistWithOrganizationId(organizationId)) {
				returnValue ="EOO2";
			}
			if(isEmployeeExistWithOrganizationId(organizationId) && isEgovFileExist) {
				Organization updateStatus = OrganizationDetailLocalServiceUtil.updateStatus(themeDisplay, status, organizationId);
				returnValue="Updated";
			}
		}else {
			LOGGER.info(status);
			Organization updateStatus = OrganizationDetailLocalServiceUtil.updateStatus(themeDisplay, status, organizationId);
			returnValue="Updated";
		}
		LOGGER.info(returnValue);
		return returnValue ;
	}

	private boolean isEgovFileExist(String sectionCode) {
		boolean isEgovFileExist=false;
		try {
			isEgovFileExist= PISUserUtil.isEgovFileExist(sectionCode);
		} catch (PortalException | UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isEgovFileExist;
	}

	private boolean isEmployeeExistWithOrganizationId(long organizationId) {
		// TODO Auto-generated method stub
		List<Employee> employeeByOrganizationId;
		employeeByOrganizationId = EmployeeLocalServiceUtil.getEmployeesBySubOrganizationId(organizationId);
		LOGGER.info(employeeByOrganizationId.size());
		return employeeByOrganizationId.isEmpty();
	}
    public List<EmployeeOrganization> getByOrganizationId(long organizationId){
        return employeeOrganizationPersistence.findByOrganizationId(organizationId);
}
	public List<EmployeeOrganization> getBySubOrganizationIdAndActive(long subOrganizationId,boolean active){
		LOGGER.info(subOrganizationId);
		
		return employeeOrganizationPersistence.findBySubOrganizationIdAndActive(subOrganizationId, active);
		
	}
}