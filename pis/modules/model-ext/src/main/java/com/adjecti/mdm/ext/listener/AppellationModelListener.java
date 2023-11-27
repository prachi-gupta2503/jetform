package com.adjecti.mdm.ext.listener;

import com.adjecti.mdm.liferay.model.Appellation;
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
public class AppellationModelListener extends BaseModelListener<Appellation> {

	final static Log LOGGER = LogFactoryUtil.getLog(AppellationModelListener.class.getName());
	
	@Override
	public void onAfterCreate(Appellation model) throws ModelListenerException {
		//System.out.println("***********1. AppellationEntityListener:onAfterCreate");
		
	}
	
	@Override
	public void onAfterUpdate(Appellation model) throws ModelListenerException {
		//System.out.println("*********** AppellationEntityListener:onAfterUpdate:onAfterUpdate");
	}
	
	
	@Override
	public void onAfterAddAssociation(Object classPK, String associationClassName,Object associationClassPK) throws ModelListenerException {
	//	System.out.println("*********** AppellationEntityListener:onAfterUpdate:onAfterAddAssociation");
	}

	@Override
	public void onAfterRemove(Appellation model) throws ModelListenerException {
		//System.out.println("*********** AppellationEntityListener:onAfterRemove");
	}

	@Override
	public void onAfterRemoveAssociation(Object classPK, String associationClassName, Object associationClassPK) throws ModelListenerException {
		//System.out.println("*********** AppellationEntityListener:onAfterRemoveAssociation");
	}
	
	@Override
	public void onBeforeCreate(Appellation model) throws ModelListenerException {
		//System.out.println("***********1. AppellationEntityListener:onBeforeCreate");
		// throw new ModelListenerException ("code test");
		// System.out.println(model.getExpandoBridge().getAttribute("Code"));
	}

	@Override
	public void onBeforeRemove(Appellation model) throws ModelListenerException {
		LOGGER.info("*********** AppellationEntityListener:onAfterRemoveAssociation");
		int count= PeopleLocalServiceUtil.getPeopleCountByAppellationId(model.getAppellationId());
		if(count>0) {
			throw new ModelListenerException("One or more employee exists for this Appellation id ["+model.getAppellationId()+"].");
		}
		
	}

	@Override
	public void onBeforeRemoveAssociation(Object classPK, String associationClassName,	Object associationClassPK)
		throws ModelListenerException {
		//System.out.println("*********** AppellationEntityListener:onAfterRemoveAssociation");
	}

	@Override
	public void onBeforeUpdate(Appellation model) throws ModelListenerException {
		LOGGER.info("AppellationEntityListener:onBeforeUpdate-method called");
		if(model.getDeleted()) {
			int count= PeopleLocalServiceUtil.getPeopleCountByAppellationId(model.getAppellationId());
			if(count>0) {
				throw new ModelListenerException("One or more employee exists for this Appellation id ["+model.getAppellationId()+"].");
			}
		}
	}

}
