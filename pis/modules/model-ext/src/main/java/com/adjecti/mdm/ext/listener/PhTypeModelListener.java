package com.adjecti.mdm.ext.listener;

import com.adjecti.mdm.liferay.model.PhType;
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
public class PhTypeModelListener extends BaseModelListener<PhType> {

	final static Log LOGGER = LogFactoryUtil.getLog(PhTypeModelListener.class.getName());
	
	@Override
	public void onAfterCreate(PhType model) throws ModelListenerException {
		//System.out.println("***********1. PhTypeEntityListener:onAfterCreate");
		
	}
	
	@Override
	public void onAfterUpdate(PhType model) throws ModelListenerException {
		//System.out.println("*********** PhTypeEntityListener:onAfterUpdate:onAfterUpdate");
	}
	
	
	@Override
	public void onAfterAddAssociation(Object classPK, String associationClassName,Object associationClassPK) throws ModelListenerException {
	//	System.out.println("*********** PhTypeEntityListener:onAfterUpdate:onAfterAddAssociation");
	}

	@Override
	public void onAfterRemove(PhType model) throws ModelListenerException {
		//System.out.println("*********** PhTypeEntityListener:onAfterRemove");
	}

	@Override
	public void onAfterRemoveAssociation(Object classPK, String associationClassName, Object associationClassPK) throws ModelListenerException {
		//System.out.println("*********** PhTypeEntityListener:onAfterRemoveAssociation");
	}
	
	@Override
	public void onBeforeCreate(PhType model) throws ModelListenerException {
		//System.out.println("***********1. PhTypeEntityListener:onBeforeCreate");
		// throw new ModelListenerException ("code test");
		// System.out.println(model.getExpandoBridge().getAttribute("Code"));
	}

	@Override
	public void onBeforeRemove(PhType model) throws ModelListenerException {
		LOGGER.info("*********** PhTypeEntityListener:onAfterRemoveAssociation");
		int count= PeopleLocalServiceUtil.getPeopleCountByPhTypeId(model.getPhTypeId());
		if(count>0) {
			throw new ModelListenerException("One or more employee exists for this PhType id ["+model.getPhTypeId()+"].");
		}
	}

	@Override
	public void onBeforeRemoveAssociation(Object classPK, String associationClassName,	Object associationClassPK)
		throws ModelListenerException {
		//System.out.println("*********** PhTypeEntityListener:onAfterRemoveAssociation");
	}

	@Override
	public void onBeforeUpdate(PhType model) throws ModelListenerException {
		LOGGER.info("PhTypeEntityListener:onBeforeUpdate-method called");
		if(model.getDeleted()) {
			int count= PeopleLocalServiceUtil.getPeopleCountByPhTypeId(model.getPhTypeId());
			if(count>0) {
				throw new ModelListenerException("One or more employee exists for this PhType id ["+model.getPhTypeId()+"].");
			}
		}
	}

}
