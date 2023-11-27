package com.adjecti.mdm.ext.listener;

import com.adjecti.mdm.liferay.model.MaritalStatus;
import com.adjecti.pis.liferay.service.PeopleLocalServiceUtil;
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
public class MaritalStatusModelListener extends BaseModelListener<MaritalStatus> {

	final static Log LOGGER = LogFactoryUtil.getLog(MaritalStatusModelListener.class.getName());
	
	@Override
	public void onAfterCreate(MaritalStatus model) throws ModelListenerException {
		//System.out.println("***********1. MaritalStatusEntityListener:onAfterCreate");
		
	}
	
	@Override
	public void onAfterUpdate(MaritalStatus model) throws ModelListenerException {
		//System.out.println("*********** MaritalStatusEntityListener:onAfterUpdate:onAfterUpdate");
	}
	
	
	@Override
	public void onAfterAddAssociation(Object classPK, String associationClassName,Object associationClassPK) throws ModelListenerException {
	//	System.out.println("*********** MaritalStatusEntityListener:onAfterUpdate:onAfterAddAssociation");
	}

	@Override
	public void onAfterRemove(MaritalStatus model) throws ModelListenerException {
		//System.out.println("*********** MaritalStatusEntityListener:onAfterRemove");
	}

	@Override
	public void onAfterRemoveAssociation(Object classPK, String associationClassName, Object associationClassPK) throws ModelListenerException {
		//System.out.println("*********** MaritalStatusEntityListener:onAfterRemoveAssociation");
	}
	
	@Override
	public void onBeforeCreate(MaritalStatus model) throws ModelListenerException {
		//System.out.println("***********1. MaritalStatusEntityListener:onBeforeCreate");
		// throw new ModelListenerException ("code test");
		// System.out.println(model.getExpandoBridge().getAttribute("Code"));
	}

	@Override
	public void onBeforeRemove(MaritalStatus model) throws ModelListenerException {
		LOGGER.info("*********** MaritalStatusEntityListener:onAfterRemoveAssociation");
		int count= PeopleLocalServiceUtil.getPeopleCountByMaritalStatusId(model.getMaritalStatusId());
		if(count>0) {
			throw new ModelListenerException("One or more employee exists for this MaritalStatus id ["+model.getMaritalStatusId()+"].");
		}
		
	}

	@Override
	public void onBeforeRemoveAssociation(Object classPK, String associationClassName,	Object associationClassPK)
		throws ModelListenerException {
		//System.out.println("*********** MaritalStatusEntityListener:onAfterRemoveAssociation");
	}

	@Override
	public void onBeforeUpdate(MaritalStatus model) throws ModelListenerException {
		LOGGER.info("MaritalStatusEntityListener:onBeforeUpdate-method called");
		if(model.getDeleted()) {
			int count= PeopleLocalServiceUtil.getPeopleCountByMaritalStatusId(model.getMaritalStatusId());
			if(count>0) {
				throw new ModelListenerException("One or more employee exists for this MaritalStatus id ["+model.getMaritalStatusId()+"].");
			}
		}
	}

}
