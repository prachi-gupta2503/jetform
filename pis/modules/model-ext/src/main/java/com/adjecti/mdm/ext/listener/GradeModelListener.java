package com.adjecti.mdm.ext.listener;

import com.adjecti.mdm.liferay.model.Grade;
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
public class GradeModelListener extends BaseModelListener<Grade> {

	final static Log LOGGER = LogFactoryUtil.getLog(GradeModelListener.class.getName());
	
	@Override
	public void onAfterCreate(Grade model) throws ModelListenerException {
		//System.out.println("***********1. OrganizationDetailEntityListener:onAfterCreate");
		
	}
	
	@Override
	public void onAfterUpdate(Grade model) throws ModelListenerException {
		//System.out.println("*********** OrganizationDetailEntityListener:onAfterUpdate:onAfterUpdate");
	}
	
	
	@Override
	public void onAfterAddAssociation(Object classPK, String associationClassName,Object associationClassPK) throws ModelListenerException {
	//	System.out.println("*********** OrganizationDetailEntityListener:onAfterUpdate:onAfterAddAssociation");
	}

	@Override
	public void onAfterRemove(Grade model) throws ModelListenerException {
		//System.out.println("*********** OrganizationDetailEntityListener:onAfterRemove");
	}

	@Override
	public void onAfterRemoveAssociation(Object classPK, String associationClassName, Object associationClassPK) throws ModelListenerException {
		//System.out.println("*********** OrganizationDetailEntityListener:onAfterRemoveAssociation");
	}
	
	@Override
	public void onBeforeCreate(Grade model) throws ModelListenerException {
		//System.out.println("***********1. OrganizationDetailEntityListener:onBeforeCreate");
		// throw new ModelListenerException ("code test");
		// System.out.println(model.getExpandoBridge().getAttribute("Code"));
	}

	@Override
	public void onBeforeRemove(Grade model) throws ModelListenerException {
		//System.out.println("*********** OrganizationDetailEntityListener:onAfterRemoveAssociation");
		int count=EmployeeLocalServiceUtil.getEmployeeCountByGradeId(model.getGradeId());
		if(count>0) {
			LOGGER.info("Count "+count);
			throw new ModelListenerException("One or more employee exists for this grade id ["+model.getGradeId()+"].");
		}
	
		int count2=DesignationLocalServiceUtil.getDesignationsCountByGradeId(model.getGradeId());
		if(count2>0) {
			LOGGER.info(" Count2 "+count2);
			throw new ModelListenerException("One or more designation exists for this grade id ["+model.getGradeId()+"].");
		}
		LOGGER.info("Count "+count+" Count2 "+count2);
	}

	@Override
	public void onBeforeRemoveAssociation(Object classPK, String associationClassName,	Object associationClassPK)
		throws ModelListenerException {
		//System.out.println("*********** OrganizationDetailEntityListener:onAfterRemoveAssociation");
	}

	@Override
	public void onBeforeUpdate(Grade model) throws ModelListenerException {
		LOGGER.info("OrganizationDetailEntityListener:onBeforeUpdate-method called");
		
		if(model.getDeleted()) {
		//SingleUserOnboarding-. GradeId	
			int count=EmployeeLocalServiceUtil.getEmployeeCountByGradeId(model.getGradeId());
			//
			if(count>0) {
				LOGGER.info("Count "+count);
				throw new ModelListenerException("One or more employee exists for this grade id ["+model.getGradeId()+"].");
			}
		
			int count2=DesignationLocalServiceUtil.getDesignationsCountByGradeId(model.getGradeId());
			if(count2>0) {
				LOGGER.info("Count2 "+count2);
				throw new ModelListenerException("One or more designation exists for this grade id ["+model.getGradeId()+"].");
			}
			LOGGER.info("Count "+count+"Count2 "+count2);
		}else {
		
		Grade grade=null;
		try {
			grade= GradeLocalServiceUtil.getGrade(model.getGradeId());
		} catch (PortalException e1) {
			LOGGER.error(e1.getMessage());
		}

		String oldCode=grade.getCode();
		LOGGER.info("oldcode : "+oldCode);
		String code=model.getCode();
		LOGGER.info("new code : "+code);
		
		String oldName=grade.getName();
		LOGGER.info("oldname : "+oldName);
		String name=model.getName();
		LOGGER.info("new name : "+name);
		
		String oldDescription=grade.getDescription();
		LOGGER.info("olddescription : "+oldDescription);
		String description=model.getDescription();
		LOGGER.info("new description : "+description);
		
		List<Employee> employees = EmployeeLocalServiceUtil.getEmployeeByGradeId(model.getGradeId());
		
		for(Employee employee:employees) {
			
			List<String> attributes=new ArrayList<String>();
			List<String> oldValues=new ArrayList<String>();
			List<String> newValues=new ArrayList<String>();
			
			try {
				
				if(!StringUtils.equals(oldCode,code)) {
					attributes.add("gradecode");
					oldValues.add(oldCode);
					newValues.add(code);
				}
				
				if(!StringUtils.equals(oldName,name)) {
					
					attributes.add("grade");
					oldValues.add(oldName);
					newValues.add(name);
				}
				
				if(!StringUtils.equals(oldDescription,description)) {
					
					attributes.add("gradedescription");
					oldValues.add(oldDescription);
					newValues.add(description);
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

	private void saveIDAMFailedTransaction(Grade model, List<String> attributes, List<String> oldValues,
			List<String> newValues, long employeeId) {
		
		IDAMFailedTransaction idamFailedTransaction = IDAMFailedTransactionLocalServiceUtil.createIDAMFailedTransaction(CounterLocalServiceUtil.increment());
		idamFailedTransaction.setEmployeeId(employeeId);
		idamFailedTransaction.setIdamUrl(PISUserUtil.getIdamAPIEndPoint());
		idamFailedTransaction.setFiredon(new Date());
		idamFailedTransaction.setClassId(model.getGradeId());
		idamFailedTransaction.setClassName(Grade.class.getSimpleName());
		idamFailedTransaction.setAttribute(String.join(",", attributes));;
		idamFailedTransaction.setOldValue(String.join(",",oldValues));
		idamFailedTransaction.setNewValue(String.join(",", newValues));;
		IDAMFailedTransactionLocalServiceUtil.updateIDAMFailedTransaction(idamFailedTransaction);
		
	}

}
