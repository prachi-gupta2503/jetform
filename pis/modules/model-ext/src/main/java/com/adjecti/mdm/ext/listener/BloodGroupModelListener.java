package com.adjecti.mdm.ext.listener;

import com.adjecti.mdm.liferay.model.BloodGroup;
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
public class BloodGroupModelListener extends BaseModelListener<BloodGroup> {

	final static Log LOGGER = LogFactoryUtil.getLog(BloodGroupModelListener.class.getName());
	
	@Override
	public void onAfterCreate(BloodGroup model) throws ModelListenerException {
		//System.out.println("***********1. BloodGroupEntityListener:onAfterCreate");
		
	}
	
	@Override
	public void onAfterUpdate(BloodGroup model) throws ModelListenerException {
		//System.out.println("*********** BloodGroupEntityListener:onAfterUpdate:onAfterUpdate");
	}
	
	
	@Override
	public void onAfterAddAssociation(Object classPK, String associationClassName,Object associationClassPK) throws ModelListenerException {
	//	System.out.println("*********** BloodGroupEntityListener:onAfterUpdate:onAfterAddAssociation");
	}

	@Override
	public void onAfterRemove(BloodGroup model) throws ModelListenerException {
		//System.out.println("*********** BloodGroupEntityListener:onAfterRemove");
	}

	@Override
	public void onAfterRemoveAssociation(Object classPK, String associationClassName, Object associationClassPK) throws ModelListenerException {
		//System.out.println("*********** BloodGroupEntityListener:onAfterRemoveAssociation");
	}
	
	@Override
	public void onBeforeCreate(BloodGroup model) throws ModelListenerException {
		//System.out.println("***********1. BloodGroupEntityListener:onBeforeCreate");
		// throw new ModelListenerException ("code test");
		// System.out.println(model.getExpandoBridge().getAttribute("Code"));
	}

	@Override
	public void onBeforeRemove(BloodGroup model) throws ModelListenerException {
		LOGGER.info("*********** BloodGroupEntityListener:onAfterRemoveAssociation");
		int count= PeopleLocalServiceUtil.getPeopleCountByBloodGroupId(model.getBloodGroupId());
		if(count>0) {
			throw new ModelListenerException("One or more employee exists for this BloodGroup id ["+model.getBloodGroupId()+"].");
		}
		
	}

	@Override
	public void onBeforeRemoveAssociation(Object classPK, String associationClassName,	Object associationClassPK)
		throws ModelListenerException {
		//System.out.println("*********** BloodGroupEntityListener:onAfterRemoveAssociation");
	}

	@Override
	public void onBeforeUpdate(BloodGroup model) throws ModelListenerException {
		LOGGER.info("BloodGroupEntityListener:onBeforeUpdate-method called");
		
		if(model.getDeleted()) {
			
			int count= PeopleLocalServiceUtil.getPeopleCountByBloodGroupId(model.getBloodGroupId());
			if(count>0) {
				throw new ModelListenerException("One or more employee exists for this BloodGroup id ["+model.getBloodGroupId()+"].");
			}
		}else {
			
		}
	}

}
