package com.adjecti.mdm.ext.listener;

import com.adjecti.mdm.liferay.model.Cadre;
import com.adjecti.mdm.liferay.model.Designation;
import com.adjecti.mdm.liferay.service.DesignationLocalServiceUtil;
import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;

import java.util.List;

import org.osgi.service.component.annotations.Component;

@Component(
	    immediate = true,
	    service = ModelListener.class
	)
public class CadreModelListener extends BaseModelListener<Cadre> {

	final static Log LOGGER = LogFactoryUtil.getLog(CadreModelListener.class.getName());
	
	@Override
	public void onAfterCreate(Cadre model) throws ModelListenerException {
		//System.out.println("***********1. OrganizationDetailEntityListener:onAfterCreate");
		
	}
	
	@Override
	public void onAfterUpdate(Cadre model) throws ModelListenerException {
		//System.out.println("*********** OrganizationDetailEntityListener:onAfterUpdate:onAfterUpdate");
	}
	
	
	@Override
	public void onAfterAddAssociation(Object classPK, String associationClassName,Object associationClassPK) throws ModelListenerException {
	//	System.out.println("*********** OrganizationDetailEntityListener:onAfterUpdate:onAfterAddAssociation");
	}

	@Override
	public void onAfterRemove(Cadre model) throws ModelListenerException {
		//System.out.println("*********** OrganizationDetailEntityListener:onAfterRemove");
	}

	@Override
	public void onAfterRemoveAssociation(Object classPK, String associationClassName, Object associationClassPK) throws ModelListenerException {
		//System.out.println("*********** OrganizationDetailEntityListener:onAfterRemoveAssociation");
	}
	
	@Override
	public void onBeforeCreate(Cadre model) throws ModelListenerException {
		//System.out.println("***********1. OrganizationDetailEntityListener:onBeforeCreate");
		// throw new ModelListenerException ("code test");
		// System.out.println(model.getExpandoBridge().getAttribute("Code"));
	}

	@Override
	public void onBeforeRemove(Cadre model) throws ModelListenerException {
		//System.out.println("*********** OrganizationDetailEntityListener:onAfterRemoveAssociation");
		int count= EmployeeLocalServiceUtil.getEmployeeCountByCadreId(model.getCadreId());
		if(count>0) {
			throw new ModelListenerException("One or more employee exists for this Cadre id ["+model.getCadreId()+"].");
		}
		
		try {
			List<Designation> list= DesignationLocalServiceUtil.getDesignationsByCadreId(model.getCadreId());
			if(!list.isEmpty()) {
				throw new ModelListenerException("One or more designation exists for this Cadre id ["+model.getCadreId()+"].");
			}
		}catch(ModelListenerException e) {
			throw e;
		}catch(Exception e) {}
		
	}

	@Override
	public void onBeforeRemoveAssociation(Object classPK, String associationClassName,	Object associationClassPK)
		throws ModelListenerException {
		//System.out.println("*********** OrganizationDetailEntityListener:onAfterRemoveAssociation");
	}

	@Override
	public void onBeforeUpdate(Cadre model) throws ModelListenerException {
		LOGGER.info("OrganizationDetailEntityListener:onBeforeUpdate-method called");
		
		if(model.getDeleted()) {
			int count= EmployeeLocalServiceUtil.getEmployeeCountByCadreId(model.getCadreId());
			if(count>0) {
				throw new ModelListenerException("One or more employee exists for this Cadre id ["+model.getCadreId()+"].");
			}
			
			try {
				List<Designation> list= DesignationLocalServiceUtil.getDesignationsByCadreId(model.getCadreId());
				if(!list.isEmpty()) {
					throw new ModelListenerException("One or more designation exists for this Cadre id ["+model.getCadreId()+"].");
				}
			}catch(ModelListenerException e) {
				throw e;
			}catch(Exception e) {}
			
		}
	}

}
