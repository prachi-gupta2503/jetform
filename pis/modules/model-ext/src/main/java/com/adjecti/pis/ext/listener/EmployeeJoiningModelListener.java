package com.adjecti.pis.ext.listener;


import com.adjecti.pis.liferay.model.EmployeeJoining;
import com.adjecti.pis.liferay.model.JoiningProcess;
import com.adjecti.pis.liferay.service.JoiningProcessLocalServiceUtil;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;

import org.osgi.service.component.annotations.Component;

@Component(
	    immediate = true,
	    service = ModelListener.class
	)
public class EmployeeJoiningModelListener extends BaseModelListener<EmployeeJoining> {

	static final Log LOGGER = LogFactoryUtil.getLog(EmployeeJoiningModelListener.class.getName());
	
	@Override
	public void onAfterCreate(EmployeeJoining model) throws ModelListenerException {
		LOGGER.info("*********** EmployeeJoiningEntityListener:onAfterCreate");	
		try {
			JoiningProcess joiningProcess = JoiningProcessLocalServiceUtil.getJoiningProcess(model.getJoiningProcessId());
			joiningProcess.setUnitId(model.getOrganizationId());
			JoiningProcessLocalServiceUtil.updateJoiningProcess(joiningProcess);
		} catch (PortalException e) {
			LOGGER.info("Issue in EmployeeJoining during update organizationId");	
			
		}
	}
	
	@Override
	public void onAfterUpdate(EmployeeJoining model) throws ModelListenerException {
		LOGGER.info("*********** EmployeeJoiningEntityListener:onAfterUpdate");	
		
		try {
			JoiningProcess joiningProcess = JoiningProcessLocalServiceUtil.getJoiningProcess(model.getJoiningProcessId());
			if(joiningProcess.getProcessStatus()!=2) {
			joiningProcess.setUnitId(model.getOrganizationId());
			JoiningProcessLocalServiceUtil.updateJoiningProcess(joiningProcess);
			}
		} catch (PortalException e) {
			LOGGER.info("Issue in EmployeeJoining during update organizationId");	
			
		}
	}
	
	
	
	@Override
	public void onAfterAddAssociation(Object classPK, String associationClassName,Object associationClassPK) throws ModelListenerException {
		LOGGER.info("*********** EmployeeJoiningEntityListener:onAfterAddAssociation");
	}

	@Override
	public void onAfterRemove(EmployeeJoining model) throws ModelListenerException {
		LOGGER.info("*********** EmployeeJoiningEntityListener:onAfterRemove");
	}

	@Override
	public void onAfterRemoveAssociation(Object classPK, String associationClassName, Object associationClassPK) throws ModelListenerException {
		LOGGER.info("*********** EmployeeJoiningEntityListener:onAfterRemoveAssociation");
	}
	
	@Override
	public void onBeforeCreate(EmployeeJoining model) throws ModelListenerException {
		LOGGER.info("***********1. EmployeeJoiningEntityListener:onBeforeCreate");
		
	}

	@Override
	public void onBeforeRemove(EmployeeJoining model) throws ModelListenerException {
		LOGGER.info("*********** EmployeeJoiningEntityListener:onAfterRemoveAssociation");
	}

	@Override
	public void onBeforeRemoveAssociation(Object classPK, String associationClassName,	Object associationClassPK)
		throws ModelListenerException {
		LOGGER.info("*********** EmployeeJoiningEntityListener:onBeforeRemoveAssociation");
	}

	@Override
	public void onBeforeUpdate(EmployeeJoining model) throws ModelListenerException {
		LOGGER.info("EmployeeJoiningEntityListener:onBeforeUpdate");
	}

}
