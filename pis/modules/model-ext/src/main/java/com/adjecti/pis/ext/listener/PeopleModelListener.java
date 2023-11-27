package com.adjecti.pis.ext.listener;


import com.adjecti.pis.liferay.model.JoiningProcess;
import com.adjecti.pis.liferay.model.People;
import com.adjecti.pis.liferay.service.JoiningProcessLocalServiceUtil;
import com.adjecti.pis.liferay.service.PeopleLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
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
public class PeopleModelListener extends BaseModelListener<People> {

	static final Log LOGGER = LogFactoryUtil.getLog(PeopleModelListener.class.getName());
	
	@Override
	public void onAfterCreate(People model) throws ModelListenerException {
		LOGGER.info("*********** PeopleModelListener:onAfterCreate");
		try {
			LOGGER.debug("model.getJoiningProcessId() : "+model.getJoiningProcessId());
			if(model.getJoiningProcessId()>0) {
				JoiningProcess joiningProcess=JoiningProcessLocalServiceUtil.getJoiningProcess(model.getJoiningProcessId());
				if(joiningProcess.getProcessStatus()==-2) {
					joiningProcess.setName("New Joining - "+model.getFirstName_En()+" "+model.getLastName_En()+" - New Joining");
					joiningProcess.setDescription("This is the new joining process for "+model.getFirstName_En()+" "+model.getLastName_En());
					joiningProcess.setProcessStatus(-1);
					JoiningProcessLocalServiceUtil.updateJoiningProcess(joiningProcess);
				}
			}
		} catch (Exception e) {
			LOGGER.error("Error in updating JoiningProcess after people object creation");	
			e.printStackTrace();
		}
	}
	
	@Override
	public void onAfterUpdate(People model) throws ModelListenerException {
		JoiningProcess joiningProcess=null;
		try {
			joiningProcess = JoiningProcessLocalServiceUtil.getJoiningProcess(model.getJoiningProcessId());
			if(joiningProcess.getProcessStatus()==2) {
				return;
			}
			joiningProcess.setName("New Joining - "+model.getFirstName_En()+" "+model.getLastName_En()+" - New Joining");
			joiningProcess.setDescription("This is the new joining process for "+model.getFirstName_En()+" "+model.getLastName_En());
			JoiningProcessLocalServiceUtil.updateJoiningProcess(joiningProcess);
		} catch (PortalException e) {
			
			e.printStackTrace();
		}
		
	
		LOGGER.info("*********** PeopleModelListener:onAfterUpdate");	
	}
	
	
	@Override
	public void onAfterAddAssociation(Object classPK, String associationClassName,Object associationClassPK) throws ModelListenerException {
		LOGGER.info("*********** PeopleModelListener:onAfterAddAssociation");
	}

	@Override
	public void onAfterRemove(People model) throws ModelListenerException {
		LOGGER.info("*********** PeopleModelListener:onAfterRemove");
	}

	@Override
	public void onAfterRemoveAssociation(Object classPK, String associationClassName, Object associationClassPK) throws ModelListenerException {
		LOGGER.info("*********** PeopleModelListener:onAfterRemoveAssociation");
	}
	
	@Override
	public void onBeforeCreate(People model) throws ModelListenerException {
		LOGGER.info("*********** PeopleModelListener:onBeforeCreate");
		model.setFatherName_En(model.getFatherName_En().toUpperCase());
	}

	@Override
	public void onBeforeRemove(People model) throws ModelListenerException {
		LOGGER.info("*********** PeopleModelListener:onAfterRemoveAssociation");
	}

	@Override
	public void onBeforeRemoveAssociation(Object classPK, String associationClassName,	Object associationClassPK)
		throws ModelListenerException {
		LOGGER.info("*********** PeopleModelListener:onBeforeRemoveAssociation");
	}

	@Override
	public void onBeforeUpdate(People model) throws ModelListenerException {
		LOGGER.info("PeopleModelListener:onBeforeUpdate");
		model.setFatherName_En(model.getFatherName_En().toUpperCase());
	}

}
