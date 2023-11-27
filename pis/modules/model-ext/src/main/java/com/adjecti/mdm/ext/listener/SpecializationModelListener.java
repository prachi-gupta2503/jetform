package com.adjecti.mdm.ext.listener;

import com.adjecti.mdm.liferay.model.Specialization;
import com.adjecti.pis.liferay.service.EmployeeQualificationLocalServiceUtil;
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
public class SpecializationModelListener extends BaseModelListener<Specialization> {

	static final Log LOGGER = LogFactoryUtil.getLog(SpecializationModelListener.class.getName());
	
	@Override
	public void onAfterCreate(Specialization model) throws ModelListenerException {
		//System.out.println("***********1. SpecializationEntityListener:onAfterCreate");
		
	}
	
	@Override
	public void onAfterUpdate(Specialization model) throws ModelListenerException {
		//System.out.println("*********** SpecializationEntityListener:onAfterUpdate:onAfterUpdate");
	}
	
	
	@Override
	public void onAfterAddAssociation(Object classPK, String associationClassName,Object associationClassPK) throws ModelListenerException {
	//	System.out.println("*********** SpecializationEntityListener:onAfterUpdate:onAfterAddAssociation");
	}

	@Override
	public void onAfterRemove(Specialization model) throws ModelListenerException {
		//System.out.println("*********** SpecializationEntityListener:onAfterRemove");
	}

	@Override
	public void onAfterRemoveAssociation(Object classPK, String associationClassName, Object associationClassPK) throws ModelListenerException {
		//System.out.println("*********** SpecializationEntityListener:onAfterRemoveAssociation");
	}
	
	@Override
	public void onBeforeCreate(Specialization model) throws ModelListenerException {
		//System.out.println("***********1. SpecializationEntityListener:onBeforeCreate");
		// throw new ModelListenerException ("code test");
		// System.out.println(model.getExpandoBridge().getAttribute("Code"));
	}

	@Override
	public void onBeforeRemove(Specialization model) throws ModelListenerException {
		LOGGER.info("*********** SpecializationEntityListener:onAfterRemoveAssociation");
		int count=EmployeeQualificationLocalServiceUtil.getEmployeeQualificationCountBySpecializationId(model.getPrimaryKey());
		if(count>0) {
			throw new ModelListenerException("One or more employee qualification exists for this Specialization id ["+model.getPrimaryKey()+"].");
		}
	}

	@Override
	public void onBeforeRemoveAssociation(Object classPK, String associationClassName,	Object associationClassPK)
		throws ModelListenerException {
		//System.out.println("*********** SpecializationEntityListener:onAfterRemoveAssociation");
	}

	@Override
	public void onBeforeUpdate(Specialization model) throws ModelListenerException {
		LOGGER.info("SpecializationEntityListener:onBeforeUpdate-method called");
		if(model.getDeleted()) {
			int count=EmployeeQualificationLocalServiceUtil.getEmployeeQualificationCountBySpecializationId(model.getPrimaryKey());
			if(count>0) {
				throw new ModelListenerException("One or more employee qualification exists for this Specialization id ["+model.getPrimaryKey()+"].");
			}
		}
	}

}
