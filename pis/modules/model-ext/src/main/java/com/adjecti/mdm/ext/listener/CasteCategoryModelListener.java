package com.adjecti.mdm.ext.listener;

import com.adjecti.mdm.liferay.model.CasteCategory;
import com.adjecti.pis.liferay.model.IDAMFailedTransaction;
import com.adjecti.pis.liferay.service.IDAMFailedTransactionLocalServiceUtil;
import com.adjecti.pis.liferay.service.PeopleLocalServiceUtil;
import com.adjecti.pis.liferay.util.PISUserUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

@Component(
	    immediate = true,
	    service = ModelListener.class
	)
public class CasteCategoryModelListener extends BaseModelListener<CasteCategory> {

	final static Log LOGGER = LogFactoryUtil.getLog(CasteCategoryModelListener.class.getName());
	
	@Override
	public void onAfterCreate(CasteCategory model) throws ModelListenerException {
		//System.out.println("***********1. CasteCategoryEntityListener:onAfterCreate");
		
	}
	
	@Override
	public void onAfterUpdate(CasteCategory model) throws ModelListenerException {
		//System.out.println("*********** CasteCategoryEntityListener:onAfterUpdate:onAfterUpdate");
	}
	
	
	@Override
	public void onAfterAddAssociation(Object classPK, String associationClassName,Object associationClassPK) throws ModelListenerException {
	//	System.out.println("*********** CasteCategoryEntityListener:onAfterUpdate:onAfterAddAssociation");
	}

	@Override
	public void onAfterRemove(CasteCategory model) throws ModelListenerException {
		//System.out.println("*********** CasteCategoryEntityListener:onAfterRemove");
	}

	@Override
	public void onAfterRemoveAssociation(Object classPK, String associationClassName, Object associationClassPK) throws ModelListenerException {
		//System.out.println("*********** CasteCategoryEntityListener:onAfterRemoveAssociation");
	}
	
	@Override
	public void onBeforeCreate(CasteCategory model) throws ModelListenerException {
		//System.out.println("***********1. CasteCategoryEntityListener:onBeforeCreate");
		// throw new ModelListenerException ("code test");
		// System.out.println(model.getExpandoBridge().getAttribute("Code"));
	}

	@Override
	public void onBeforeRemove(CasteCategory model) throws ModelListenerException {
		LOGGER.info("*********** CasteCategoryEntityListener:onAfterRemoveAssociation");
		int count= PeopleLocalServiceUtil.getPeopleCountByCasteCategoryId(model.getCasteCategoryId());
		if(count>0) {
			throw new ModelListenerException("One or more employee exists for this CasteCategory id ["+model.getCasteCategoryId()+"].");
		}
	}

	@Override
	public void onBeforeRemoveAssociation(Object classPK, String associationClassName,	Object associationClassPK)
		throws ModelListenerException {
		//System.out.println("*********** CasteCategoryEntityListener:onAfterRemoveAssociation");
	}

	@Override
	public void onBeforeUpdate(CasteCategory model) throws ModelListenerException {
		LOGGER.info("CasteCategoryEntityListener:onBeforeUpdate-method called");
		
		if(model.getDeleted()) {
			
			int count= PeopleLocalServiceUtil.getPeopleCountByCasteCategoryId(model.getCasteCategoryId());
			if(count>0) {
				throw new ModelListenerException("One or more employee exists for this CasteCategory id ["+model.getCasteCategoryId()+"].");
			}
		}
	}
	
	

}
