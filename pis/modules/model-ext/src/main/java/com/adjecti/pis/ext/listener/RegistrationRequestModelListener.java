package com.adjecti.pis.ext.listener;


import com.adjecti.pis.liferay.exception.NoSuchEmployeePermissionException;
import com.adjecti.pis.liferay.model.EmployeePermission;
import com.adjecti.pis.liferay.service.EmployeePermissionLocalServiceUtil;
import com.adjecti.pis.model.RegistrationRequest;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;

import org.osgi.service.component.annotations.Component;

@Component(
	    immediate = true,
	    service = ModelListener.class
	)
public class RegistrationRequestModelListener extends BaseModelListener<RegistrationRequest> {

	static final Log LOGGER = LogFactoryUtil.getLog(RegistrationRequestModelListener.class.getName());
	
	@Override
	public void onAfterCreate(RegistrationRequest model) throws ModelListenerException {
		LOGGER.info("*********** RegistrationRequestModelListener:onAfterCreate");
		
	}
	
	@Override
	public void onAfterUpdate(RegistrationRequest model) throws ModelListenerException {
		
		if(model.getState().equalsIgnoreCase("Approved")) {
			checkingEmployeePermissionExistOrNotByRegistrationRequestId(model) ;
		}
	
		LOGGER.info("*********** RegistrationRequestModelListener:onAfterUpdate");	
	}
	
	
	@Override
	public void onAfterAddAssociation(Object classPK, String associationClassName,Object associationClassPK) throws ModelListenerException {
		LOGGER.info("*********** RegistrationRequestModelListener:onAfterAddAssociation");
	}

	@Override
	public void onAfterRemove(RegistrationRequest model) throws ModelListenerException {
		LOGGER.info("*********** RegistrationRequestModelListener:onAfterRemove");
	}

	@Override
	public void onAfterRemoveAssociation(Object classPK, String associationClassName, Object associationClassPK) throws ModelListenerException {
		LOGGER.info("*********** RegistrationRequestModelListener:onAfterRemoveAssociation");
	}
	
	@Override
	public void onBeforeCreate(RegistrationRequest model) throws ModelListenerException {
		LOGGER.info("*********** RegistrationRequestModelListener:onBeforeCreate");
		
	}

	@Override
	public void onBeforeRemove(RegistrationRequest model) throws ModelListenerException {
		LOGGER.info("*********** RegistrationRequestModelListener:onAfterRemoveAssociation");
	}

	@Override
	public void onBeforeRemoveAssociation(Object classPK, String associationClassName,	Object associationClassPK)
		throws ModelListenerException {
		LOGGER.info("*********** RegistrationRequestModelListener:onBeforeRemoveAssociation");
	}

	@Override
	public void onBeforeUpdate(RegistrationRequest model) throws ModelListenerException {
		LOGGER.info("RegistrationRequestModelListener:onBeforeUpdate");
	}
	public EmployeePermission checkingEmployeePermissionExistOrNotByRegistrationRequestId(RegistrationRequest model) {
		EmployeePermission employeePermission=null;
		
		try {
			employeePermission=EmployeePermissionLocalServiceUtil.getEmployeePermissionsByRegistrationRequestId(model.getRegistrationRequestId());
			if(employeePermission!=null) {
		     employeePermission.setUserCreated(model.getAppUserCreated());
		     employeePermission.setEmployeeCreated(model.getEmployeeCreated());
		     employeePermission.setIdamUserCreated(model.getIdamUserCreated());
		     employeePermission.setDigitalSigning(model.getDigitalSigning());
			 employeePermission.setEGovAccess(model.getEGovAccess());
			 employeePermission.setPisAccess(model.getPisAccess());
			 employeePermission.setEmailAccess(model.getEmailAccess());
		     EmployeePermissionLocalServiceUtil.updateEmployeePermission(employeePermission);
			}
		   
		} catch (NoSuchEmployeePermissionException e2) {
			LOGGER.info(" NO EmployeePermission found  with this Registration Request  "+model.getRegistrationRequestId());
		}
		if(employeePermission==null) {
			try {
				employeePermission = EmployeePermissionLocalServiceUtil.createEmployeePermission(CounterLocalServiceUtil.increment());
				employeePermission.setDigitalSigning(model.getDigitalSigning());
				employeePermission.setEmailAccess(model.getEmailAccess());
				employeePermission.setEGovAccess(model.getEGovAccess());
				employeePermission.setIdamUser(model.getIdamUser());
				employeePermission.setPisAccess(model.getPisAccess());
				employeePermission.setPersonalNo(model.getPersonalNo());
				employeePermission.setFirstName(model.getFirstName());
				employeePermission.setLastName(model.getLastName());
				employeePermission.setForm("RegistrationRequest");
				employeePermission.setRegistrationRequestId(model.getRegistrationRequestId());
				employeePermission.setDesignationId(model.getDesignationId());
				employeePermission.setEmailAddress(model.getEmailAddress());
				employeePermission.setCurrentState("Approved");
				employeePermission.setUserCreated(model.getAppUserCreated());
			    employeePermission.setEmployeeCreated(model.getEmployeeCreated());
			    employeePermission.setIdamUserCreated(model.getIdamUserCreated());
				 employeePermission.setIdamUser(true);
				EmployeePermissionLocalServiceUtil.updateEmployeePermission(employeePermission);
				LOGGER.info("EmployeePermission created successfully with registrationRequestId "+model.getRegistrationRequestId());
		} catch(Exception e) {
			    LOGGER.info("EmployeePermission creation failed with registrationRequestId "+model.getRegistrationRequestId());
		}
		}
		return employeePermission;
	}	

}
