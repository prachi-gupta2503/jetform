package com.adjecti.mdm.ext.listener;

import com.adjecti.mdm.liferay.model.Qualification;
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
public class QualificationModelListener extends BaseModelListener<Qualification> {

	static final Log LOGGER = LogFactoryUtil.getLog(QualificationModelListener.class.getName());
	
	@Override
	public void onAfterCreate(Qualification model) throws ModelListenerException {
		//System.out.println("***********1. QualificationEntityListener:onAfterCreate");
		
	}
	
	@Override
	public void onAfterUpdate(Qualification model) throws ModelListenerException {
		//System.out.println("*********** QualificationEntityListener:onAfterUpdate:onAfterUpdate");
	}
	
	
	@Override
	public void onAfterAddAssociation(Object classPK, String associationClassName,Object associationClassPK) throws ModelListenerException {
	//	System.out.println("*********** QualificationEntityListener:onAfterUpdate:onAfterAddAssociation");
	}

	@Override
	public void onAfterRemove(Qualification model) throws ModelListenerException {
		//System.out.println("*********** QualificationEntityListener:onAfterRemove");
	}

	@Override
	public void onAfterRemoveAssociation(Object classPK, String associationClassName, Object associationClassPK) throws ModelListenerException {
		//System.out.println("*********** QualificationEntityListener:onAfterRemoveAssociation");
	}
	
	@Override
	public void onBeforeCreate(Qualification model) throws ModelListenerException {
		//System.out.println("***********1. QualificationEntityListener:onBeforeCreate");
		// throw new ModelListenerException ("code test");
		// System.out.println(model.getExpandoBridge().getAttribute("Code"));
	}

	@Override
	public void onBeforeRemove(Qualification model) throws ModelListenerException {
		LOGGER.info("*********** QualificationEntityListener:onAfterRemoveAssociation");
		int count=EmployeeQualificationLocalServiceUtil.getEmployeeQualificationCountByQualificationId(model.getPrimaryKey());
		if(count>0) {
			throw new ModelListenerException("One or more employee qualification exists for this Qualification id ["+model.getPrimaryKey()+"].");
		}
	}

	@Override
	public void onBeforeRemoveAssociation(Object classPK, String associationClassName,	Object associationClassPK)
		throws ModelListenerException {
		//System.out.println("*********** QualificationEntityListener:onAfterRemoveAssociation");
	}

	@Override
	public void onBeforeUpdate(Qualification model) throws ModelListenerException {
		LOGGER.info("QualificationEntityListener:onBeforeUpdate-method called");
		if(model.getDeleted()) {
			int count=EmployeeQualificationLocalServiceUtil.getEmployeeQualificationCountByQualificationId(model.getPrimaryKey());
			if(count>0) {
				throw new ModelListenerException("One or more employee qualification exists for this Qualification id ["+model.getPrimaryKey()+"].");
			}
		}
	}

}
