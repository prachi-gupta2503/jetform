package com.adjecti.mdm.ext.listener;

import com.adjecti.mdm.liferay.model.Designation;
import com.adjecti.mdm.liferay.model.DesignationGroup;
import com.adjecti.mdm.liferay.model.Grade;
import com.adjecti.mdm.liferay.service.DesignationGroupLocalServiceUtil;
import com.adjecti.mdm.liferay.service.DesignationLocalServiceUtil;
import com.adjecti.mdm.liferay.service.GradeLocalServiceUtil;
import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.liferay.model.IDAMFailedTransaction;
import com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil;
import com.adjecti.pis.liferay.service.IDAMFailedTransactionLocalServiceUtil;
import com.adjecti.pis.liferay.util.PISUserUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.osgi.service.component.annotations.Component;

@Component(
	    immediate = true,
	    service = ModelListener.class
	)
public class DesignationModelListener extends BaseModelListener<Designation> {

	final static Log LOGGER = LogFactoryUtil.getLog(DesignationModelListener.class.getName());
	
	@Override
	public void onAfterCreate(Designation model) throws ModelListenerException {
		//System.out.println("***********1. DesignationEntityListener:onAfterCreate");
		
	}
	
	@Override
	public void onAfterUpdate(Designation model) throws ModelListenerException {
		LOGGER.info("*********** DesignationEntityListener:onAfterUpdate:onAfterUpdate");
				
			

	}
	
	
	@Override
	public void onAfterAddAssociation(Object classPK, String associationClassName,Object associationClassPK) throws ModelListenerException {
	//	System.out.println("*********** DesignationEntityListener:onAfterUpdate:onAfterAddAssociation");
	}

	@Override
	public void onAfterRemove(Designation model) throws ModelListenerException {
		//System.out.println("*********** DesignationEntityListener:onAfterRemove");
	}

	@Override
	public void onAfterRemoveAssociation(Object classPK, String associationClassName, Object associationClassPK) throws ModelListenerException {
		//System.out.println("*********** DesignationEntityListener:onAfterRemoveAssociation");
	}
	
	@Override
	public void onBeforeCreate(Designation model) throws ModelListenerException {
		//System.out.println("***********1. DesignationEntityListener:onBeforeCreate");
		// throw new ModelListenerException ("code test");
		// System.out.println(model.getExpandoBridge().getAttribute("Code"));
	}

	@Override
	public void onBeforeRemove(Designation model) throws ModelListenerException {
		LOGGER.info("DesignationEntityListener.onBeforeRemove");
		int count=EmployeeLocalServiceUtil.getEmployeeCountByDesignationId(model.getDesignationId());
		if(count>0) {
			throw new ModelListenerException("One or more employee exists for this designation id ["+model.getDesignationId()+"].");
		}
		
	}

	@Override
	public void onBeforeRemoveAssociation(Object classPK, String associationClassName,	Object associationClassPK)
		throws ModelListenerException {
		//System.out.println("*********** DesignationEntityListener:onAfterRemoveAssociation");
	}

	@Override
	public void onBeforeUpdate(Designation model) throws ModelListenerException {
		LOGGER.info("DesignationEntityListener:onBeforeUpdate-method called");
		
		if(model.getDeleted()) {
			int count=EmployeeLocalServiceUtil.getEmployeeCountByDesignationId(model.getDesignationId());
			if(count>0) {
				throw new ModelListenerException("One or more employee exists for this designation id ["+model.getDesignationId()+"].");
			}
			
		}else {

		Designation designation=null;
		try {
			designation= DesignationLocalServiceUtil.getDesignation(model.getDesignationId());
		} catch (PortalException e1) {
			LOGGER.error(e1.getMessage());
		}
		String oldCode=designation.getCode();
		LOGGER.info("oldcode : "+oldCode);
		String code=model.getCode();
		LOGGER.info("new code : "+code);
		
		String oldName_En=designation.getName_En();
		LOGGER.info("oldname_En : "+oldName_En);
		String name_En=model.getName_En();
		LOGGER.info("new name_En : "+name_En);
		
		String oldLongName=designation.getLongName();
		LOGGER.info("oldlongName : "+oldLongName);
		String longName=model.getLongName();
		LOGGER.info("new longName : "+longName);
		
		long designationGroupId=0;
		long oldDesignationGroupId=designation.getDesignationGroupId();
		LOGGER.info("olddesignationGroupId : "+oldDesignationGroupId);
		designationGroupId=model.getDesignationGroupId();
		LOGGER.info("new olddesignationGroupId : "+designationGroupId);
		
		long gradeId=0;
		long oldGradeId=designation.getGradeId();
		LOGGER.info("oldGradeId : "+oldGradeId);
		 gradeId=model.getGradeId();
		LOGGER.info("new GradeId : "+gradeId);

		String oldOrganizationType=designation.getOrganizationType();
		LOGGER.info("oldOrganizationType : "+oldOrganizationType);
		String organizationType=model.getOrganizationType();
		LOGGER.info("new organizationType : "+organizationType);
		
		List<Employee> employees = EmployeeLocalServiceUtil.getEmployeeByDesignationId(model.getDesignationId());
		
		for(Employee employee:employees) {
			
			List<String> attributes=new ArrayList<String>();
			List<String> oldValues=new ArrayList<String>();
			List<String> newValues=new ArrayList<String>();
			
			try {
				
				
				if(!StringUtils.equals(oldCode,code)) {
					attributes.add("designationcode");
					oldValues.add(oldCode);
					newValues.add(code);
				}
				
				if(!StringUtils.equals(oldName_En,name_En)) {
					
					attributes.add("designation");
					oldValues.add(oldName_En);
					newValues.add(name_En);
				}
				
				if(!StringUtils.equals(oldLongName,longName)) {
					
					attributes.add("designationdescription");
					oldValues.add(oldLongName);
					newValues.add(longName);
				}
				
				if(oldDesignationGroupId!=0 && designationGroupId!=0 && oldDesignationGroupId!=designationGroupId) {
					DesignationGroup oldDesignationGroup = DesignationGroupLocalServiceUtil.getDesignationGroup(oldDesignationGroupId);
					DesignationGroup newDesignationGroup = DesignationGroupLocalServiceUtil.getDesignationGroup(designationGroupId);
					
					attributes.add("designationGroup");
					oldValues.add(oldDesignationGroup.getName());
					newValues.add(newDesignationGroup.getName());
					
					/*
					 * attributes.add("designationGroupCode");
					 * oldValues.add(oldDesignationGroup.getCode());
					 * newValues.add(newDesignationGroup.getCode());
					 */
				}
				
				if(oldGradeId!=0 && gradeId!=0 && oldGradeId!=gradeId) {
					Grade oldGrade = GradeLocalServiceUtil.getGrade(oldGradeId);
					Grade newGrade = GradeLocalServiceUtil.getGrade(gradeId);
					
					attributes.add("grade");
					oldValues.add(oldGrade.getName());
					newValues.add(newGrade.getName());
					
					attributes.add("gradecode");
					oldValues.add(oldGrade.getCode());
					newValues.add(newGrade.getCode());
					
					attributes.add("gradedescription");
					oldValues.add(oldGrade.getDescription());
					newValues.add(newGrade.getDescription());
				}
				
				
				if(!StringUtils.equals(oldOrganizationType,organizationType)) {
					
					attributes.add("OrganizationType");
					oldValues.add(oldOrganizationType);
					newValues.add(organizationType);
				}
				
			} catch (Exception e1) {
				LOGGER.error(e1.getMessage());
			}
			
			
			boolean status=PISUserUtil.updateIDAMUser(employee.getLoginId(), attributes, oldValues, newValues);
			LOGGER.info("attributes"+attributes);
			LOGGER.info("oldValues"+oldValues);
			LOGGER.info("newValues"+newValues);
			
			//status=false;
			if(!status) {
				saveIDAMFailedTransaction(model,attributes,oldValues,newValues,employee.getEmployeeId());
			}
		}
		}	
	}
	
	private void saveIDAMFailedTransaction(Designation model,List<String> attributes,List<String> oldValues,List<String> newValues,long employeeId) {
		IDAMFailedTransaction idamFailedTransaction = IDAMFailedTransactionLocalServiceUtil.createIDAMFailedTransaction(CounterLocalServiceUtil.increment());
		idamFailedTransaction.setEmployeeId(employeeId);
		idamFailedTransaction.setIdamUrl(PISUserUtil.getIdamAPIEndPoint());
		idamFailedTransaction.setFiredon(new Date());
		idamFailedTransaction.setClassId(model.getDesignationId());
		idamFailedTransaction.setClassName(Designation.class.getSimpleName());
		idamFailedTransaction.setAttribute(String.join(",", attributes));;
		idamFailedTransaction.setOldValue(String.join(",",oldValues));
		idamFailedTransaction.setNewValue(String.join(",", newValues));;
		IDAMFailedTransactionLocalServiceUtil.updateIDAMFailedTransaction(idamFailedTransaction);
	}

}
