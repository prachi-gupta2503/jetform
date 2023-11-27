package com.adjecti.mdm.ext.listener;

import com.adjecti.mdm.liferay.model.Religion;
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
public class ReligionModelListener extends BaseModelListener<Religion> {

	final static Log LOGGER = LogFactoryUtil.getLog(ReligionModelListener.class.getName());
	
	@Override
	public void onAfterCreate(Religion model) throws ModelListenerException {
		//System.out.println("***********1. ReligionEntityListener:onAfterCreate");
		
	}
	
	@Override
	public void onAfterUpdate(Religion model) throws ModelListenerException {
		//System.out.println("*********** ReligionEntityListener:onAfterUpdate:onAfterUpdate");
	}
	
	
	@Override
	public void onAfterAddAssociation(Object classPK, String associationClassName,Object associationClassPK) throws ModelListenerException {
	//	System.out.println("*********** ReligionEntityListener:onAfterUpdate:onAfterAddAssociation");
	}

	@Override
	public void onAfterRemove(Religion model) throws ModelListenerException {
		//System.out.println("*********** ReligionEntityListener:onAfterRemove");
	}

	@Override
	public void onAfterRemoveAssociation(Object classPK, String associationClassName, Object associationClassPK) throws ModelListenerException {
		//System.out.println("*********** ReligionEntityListener:onAfterRemoveAssociation");
	}
	
	@Override
	public void onBeforeCreate(Religion model) throws ModelListenerException {
		//System.out.println("***********1. ReligionEntityListener:onBeforeCreate");
		// throw new ModelListenerException ("code test");
		// System.out.println(model.getExpandoBridge().getAttribute("Code"));
	}

	@Override
	public void onBeforeRemove(Religion model) throws ModelListenerException {
		LOGGER.info("*********** ReligionEntityListener:onAfterRemoveAssociation");
		int count= PeopleLocalServiceUtil.getPeopleCountByReligionId(model.getReligionId());
		if(count>0) {
			throw new ModelListenerException("One or more employee exists for this Religion id ["+model.getReligionId()+"].");
		}
	}

	@Override
	public void onBeforeRemoveAssociation(Object classPK, String associationClassName,	Object associationClassPK)
		throws ModelListenerException {
		//System.out.println("*********** ReligionEntityListener:onAfterRemoveAssociation");
	}

	@Override
	public void onBeforeUpdate(Religion model) throws ModelListenerException {
		LOGGER.info("ReligionEntityListener:onBeforeUpdate-method called");
		
		if(model.getDeleted()) {
			int count= PeopleLocalServiceUtil.getPeopleCountByReligionId(model.getReligionId());
			if(count>0) {
				throw new ModelListenerException("One or more employee exists for this Religion id ["+model.getReligionId()+"].");
			}
		}
	}

}
