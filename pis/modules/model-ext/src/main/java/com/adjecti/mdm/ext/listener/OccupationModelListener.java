package com.adjecti.mdm.ext.listener;

import com.adjecti.mdm.liferay.model.Occupation;
import com.adjecti.pis.liferay.service.EmployeeFamilyLocalServiceUtil;
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
public class OccupationModelListener extends BaseModelListener<Occupation> {

	static final Log LOGGER = LogFactoryUtil.getLog(OccupationModelListener.class.getName());
	
	@Override
	public void onAfterCreate(Occupation model) throws ModelListenerException {
		//System.out.println("***********1. OccupationEntityListener:onAfterCreate");
		
	}
	
	@Override
	public void onAfterUpdate(Occupation model) throws ModelListenerException {
		//System.out.println("*********** OccupationEntityListener:onAfterUpdate:onAfterUpdate");
	}
	
	
	@Override
	public void onAfterAddAssociation(Object classPK, String associationClassName,Object associationClassPK) throws ModelListenerException {
	//	System.out.println("*********** OccupationEntityListener:onAfterUpdate:onAfterAddAssociation");
	}

	@Override
	public void onAfterRemove(Occupation model) throws ModelListenerException {
		LOGGER.info("After Remove");
		//System.out.println("*********** OccupationEntityListener:onAfterRemove");
	}

	@Override
	public void onAfterRemoveAssociation(Object classPK, String associationClassName, Object associationClassPK) throws ModelListenerException {
		//System.out.println("*********** OccupationEntityListener:onAfterRemoveAssociation");
	}
	
	@Override
	public void onBeforeCreate(Occupation model) throws ModelListenerException {
		//System.out.println("***********1. OccupationEntityListener:onBeforeCreate");
		// throw new ModelListenerException ("code test");
		// System.out.println(model.getExpandoBridge().getAttribute("Code"));
	}

	@Override
	public void onBeforeRemove(Occupation model) throws ModelListenerException {
		LOGGER.info("Before Remove");
		/*
		 * int
		 * count=EmployeeFamilyLocalServiceUtil.getEmployeeFamilyCountByOccupationId(
		 * model.getPrimaryKey()); if(count>0) { throw new
		 * ModelListenerException("One or more employee family member exists for this occupation id ["
		 * +model.getPrimaryKey()+"]."); }
		 */
		
	}

	@Override
	public void onBeforeRemoveAssociation(Object classPK, String associationClassName,	Object associationClassPK)
		throws ModelListenerException {
		//System.out.println("*********** OccupationEntityListener:onAfterRemoveAssociation");
	}

	@Override
	public void onBeforeUpdate(Occupation model) throws ModelListenerException {
		LOGGER.info("OccupationEntityListener:onBeforeUpdate-method called");
		
		if(model.getDeleted()) {
			
			int count=EmployeeFamilyLocalServiceUtil.getEmployeeFamilyCountByOccupationId(model.getPrimaryKey());
			if(count>0) {
				throw new ModelListenerException("One or more employee family member exists for this occupation id ["+model.getPrimaryKey()+"].");
			}
		}
	}

}
