package com.adjecti.mdm.ext.listener;

import com.adjecti.mdm.liferay.model.Gender;
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
public class GenderModelListener extends BaseModelListener<Gender> {

	final static Log LOGGER = LogFactoryUtil.getLog(GenderModelListener.class.getName());
	
	@Override
	public void onAfterCreate(Gender model) throws ModelListenerException {
		//System.out.println("***********1. GenderEntityListener:onAfterCreate");
		
	}
	
	@Override
	public void onAfterUpdate(Gender model) throws ModelListenerException {
		//System.out.println("*********** GenderEntityListener:onAfterUpdate:onAfterUpdate");
	}
	
	
	@Override
	public void onAfterAddAssociation(Object classPK, String associationClassName,Object associationClassPK) throws ModelListenerException {
	//	System.out.println("*********** GenderEntityListener:onAfterUpdate:onAfterAddAssociation");
	}

	@Override
	public void onAfterRemove(Gender model) throws ModelListenerException {
		//System.out.println("*********** GenderEntityListener:onAfterRemove");
	}

	@Override
	public void onAfterRemoveAssociation(Object classPK, String associationClassName, Object associationClassPK) throws ModelListenerException {
		//System.out.println("*********** GenderEntityListener:onAfterRemoveAssociation");
	}
	
	@Override
	public void onBeforeCreate(Gender model) throws ModelListenerException {
		//System.out.println("***********1. GenderEntityListener:onBeforeCreate");
		// throw new ModelListenerException ("code test");
		// System.out.println(model.getExpandoBridge().getAttribute("Code"));
	}

	@Override
	public void onBeforeRemove(Gender model) throws ModelListenerException {
		LOGGER.info("*********** GenderEntityListener:onAfterRemoveAssociation");
		int count= PeopleLocalServiceUtil.getPeopleCountByGenderId(model.getGenderId());
		if(count>0) {
			throw new ModelListenerException("One or more employee exists for this Gender id ["+model.getGenderId()+"].");
		}
		
	}

	@Override
	public void onBeforeRemoveAssociation(Object classPK, String associationClassName,	Object associationClassPK)
		throws ModelListenerException {
		//System.out.println("*********** GenderEntityListener:onAfterRemoveAssociation");
	}

	@Override
	public void onBeforeUpdate(Gender model) throws ModelListenerException {
		
		LOGGER.info("GenderEntityListener:onBeforeUpdate-method called");
		if(model.getDeleted()) {
			int count= PeopleLocalServiceUtil.getPeopleCountByGenderId(model.getGenderId());
			if(count>0) {
				throw new ModelListenerException("One or more employee exists for this Gender id ["+model.getGenderId()+"].");
			}
		}
		
	}
	
	private void saveIDAMFailedTransaction(Gender model,List<String> attributes,List<String> oldValues,List<String> newValues,long employeeId) {
		IDAMFailedTransaction idamFailedTransaction = IDAMFailedTransactionLocalServiceUtil.createIDAMFailedTransaction(CounterLocalServiceUtil.increment());
		idamFailedTransaction.setEmployeeId(employeeId);
		idamFailedTransaction.setIdamUrl(PISUserUtil.getIdamAPIEndPoint());
		idamFailedTransaction.setFiredon(new Date());
		idamFailedTransaction.setClassId(model.getGenderId());
		idamFailedTransaction.setClassName(Gender.class.getSimpleName());
		idamFailedTransaction.setAttribute(String.join(",", attributes));;
		idamFailedTransaction.setOldValue(String.join(",",oldValues));
		idamFailedTransaction.setNewValue(String.join(",", newValues));;
		IDAMFailedTransactionLocalServiceUtil.updateIDAMFailedTransaction(idamFailedTransaction);
	}

}
