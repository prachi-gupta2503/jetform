package com.adjecti.mdm.ext.listener;

import com.adjecti.mdm.liferay.model.FamilyRelation;
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
public class FamilyRelationModelListener extends BaseModelListener<FamilyRelation> {

	static final Log LOGGER = LogFactoryUtil.getLog(FamilyRelationModelListener.class.getName());
	
	@Override
	public void onAfterCreate(FamilyRelation model) throws ModelListenerException {
		//System.out.println("***********1. FamilyRelationEntityListener:onAfterCreate");
		
	}
	
	@Override
	public void onAfterUpdate(FamilyRelation model) throws ModelListenerException {
		//System.out.println("*********** FamilyRelationEntityListener:onAfterUpdate:onAfterUpdate");
	}
	
	
	@Override
	public void onAfterAddAssociation(Object classPK, String associationClassName,Object associationClassPK) throws ModelListenerException {
	//	System.out.println("*********** FamilyRelationEntityListener:onAfterUpdate:onAfterAddAssociation");
	}

	@Override
	public void onAfterRemove(FamilyRelation model) throws ModelListenerException {
		//System.out.println("*********** FamilyRelationEntityListener:onAfterRemove");
	}

	@Override
	public void onAfterRemoveAssociation(Object classPK, String associationClassName, Object associationClassPK) throws ModelListenerException {
		//System.out.println("*********** FamilyRelationEntityListener:onAfterRemoveAssociation");
	}
	
	@Override
	public void onBeforeCreate(FamilyRelation model) throws ModelListenerException {
		//System.out.println("***********1. FamilyRelationEntityListener:onBeforeCreate");
		// throw new ModelListenerException ("code test");
		// System.out.println(model.getExpandoBridge().getAttribute("Code"));
	}

	@Override
	public void onBeforeRemove(FamilyRelation model) throws ModelListenerException {
		LOGGER.info("*********** FamilyRelationEntityListener:onAfterRemoveAssociation");
		int count=EmployeeFamilyLocalServiceUtil.getEmployeeFamilyCountByRelationId(model.getPrimaryKey());
		if(count>0) {
			throw new ModelListenerException("One or more employee family member exists for this relation id ["+model.getPrimaryKey()+"].");
		}
	}

	@Override
	public void onBeforeRemoveAssociation(Object classPK, String associationClassName,	Object associationClassPK)
		throws ModelListenerException {
		//System.out.println("*********** FamilyRelationEntityListener:onAfterRemoveAssociation");
	}

	@Override
	public void onBeforeUpdate(FamilyRelation model) throws ModelListenerException {
		LOGGER.info("FamilyRelationEntityListener:onBeforeUpdate-method called");
		if(model.getDeleted()) {
			int count=EmployeeFamilyLocalServiceUtil.getEmployeeFamilyCountByRelationId(model.getPrimaryKey());
			if(count>0) {
				throw new ModelListenerException("One or more employee family member exists for this relation id ["+model.getPrimaryKey()+"].");
			}
		}
	}

}
