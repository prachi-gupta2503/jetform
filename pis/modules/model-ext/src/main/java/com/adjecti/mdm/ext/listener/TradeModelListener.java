package com.adjecti.mdm.ext.listener;

import com.adjecti.mdm.liferay.model.Trade;
import com.adjecti.mdm.liferay.service.TradeLocalServiceUtil;
import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.liferay.model.IDAMFailedTransaction;
import com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil;
import com.adjecti.pis.liferay.service.IDAMFailedTransactionLocalServiceUtil;
import com.adjecti.pis.liferay.util.PISUserUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.osgi.service.component.annotations.Component;

@Component(
	    immediate = true,
	    service = ModelListener.class
	)
public class TradeModelListener extends BaseModelListener<Trade> {

	static final Log LOGGER = LogFactoryUtil.getLog(TradeModelListener.class.getName());
	
	@Override
	public void onAfterCreate(Trade model) throws ModelListenerException {
		//System.out.println("***********1. OrganizationDetailEntityListener:onAfterCreate");
		
	}
	
	@Override
	public void onAfterUpdate(Trade model) throws ModelListenerException {
		//System.out.println("*********** OrganizationDetailEntityListener:onAfterUpdate:onAfterUpdate");
	}
	
	
	@Override
	public void onAfterAddAssociation(Object classPK, String associationClassName,Object associationClassPK) throws ModelListenerException {
	//	System.out.println("*********** OrganizationDetailEntityListener:onAfterUpdate:onAfterAddAssociation");
	}

	@Override
	public void onAfterRemove(Trade model) throws ModelListenerException {
		//System.out.println("*********** OrganizationDetailEntityListener:onAfterRemove");
	}

	@Override
	public void onAfterRemoveAssociation(Object classPK, String associationClassName, Object associationClassPK) throws ModelListenerException {
		//System.out.println("*********** OrganizationDetailEntityListener:onAfterRemoveAssociation");
	}
	
	@Override
	public void onBeforeCreate(Trade model) throws ModelListenerException {
		//System.out.println("***********1. OrganizationDetailEntityListener:onBeforeCreate");
		// throw new ModelListenerException ("code test");
		// System.out.println(model.getExpandoBridge().getAttribute("Code"));
	}

	@Override
	public void onBeforeRemove(Trade model) throws ModelListenerException {
		LOGGER.info("*********** OrganizationDetailEntityListener:onAfterRemoveAssociation");
		int count= EmployeeLocalServiceUtil.getEmployeeCountByTradeId(model.getTradeId());
		if(count>0) {
			throw new ModelListenerException("One or more employee exists for this trade id ["+model.getTradeId()+"].");
		}
	}

	@Override
	public void onBeforeRemoveAssociation(Object classPK, String associationClassName,	Object associationClassPK)
		throws ModelListenerException {
		//System.out.println("*********** OrganizationDetailEntityListener:onAfterRemoveAssociation");
	}

	@Override
	public void onBeforeUpdate(Trade model) throws ModelListenerException {
		LOGGER.info("OrganizationDetailEntityListener:onBeforeUpdate-method called");
		if(model.getDeleted()) {
			int count= EmployeeLocalServiceUtil.getEmployeeCountByTradeId(model.getTradeId());
			if(count>0) {
				throw new ModelListenerException("One or more employee exists for this trade id ["+model.getTradeId()+"].");
			}
		}else {
		Trade trade=null;
		try {
			trade=TradeLocalServiceUtil.getTrade(model.getTradeId());
		} catch (PortalException e1) {
			LOGGER.error(e1.getMessage());
		}

		String oldCode=trade.getCode();
		LOGGER.info("oldcode : "+oldCode);
		String code=model.getCode();
		LOGGER.info("new code : "+code);
		
		String oldName=trade.getName();
		LOGGER.info("oldname : "+oldName);
		String name=model.getName();
		LOGGER.info("new name : "+name);
		
		String oldDescription=trade.getDescription();
		LOGGER.info("oldDescription : "+oldDescription);
		String description=model.getDescription();
		LOGGER.info("new description : "+description);
		
		List<Employee> employees = EmployeeLocalServiceUtil.getEmployeeByTradeId(model.getTradeId());
		
		for(Employee employee:employees) {
			
			List<String> attributes=new ArrayList<String>();
			List<String> oldValues=new ArrayList<String>();
			List<String> newValues=new ArrayList<String>();
			
			try {
				
				if(!StringUtils.equals(oldCode,code)) {
					attributes.add("tradecode");
					oldValues.add(oldCode);
					newValues.add(code);
				}
				
				if(!StringUtils.equals(oldName,name)) {
					
					attributes.add("trade");
					oldValues.add(oldName);
					newValues.add(name);
				}
				
				if(!StringUtils.equals(oldDescription,description)) {
					
					attributes.add("tradedescription");
					oldValues.add(oldDescription);
					newValues.add(description);
				}
				
			} catch (Exception e1) {
				LOGGER.error(e1.getMessage());
			}
			
			
			boolean status=PISUserUtil.updateIDAMUser(employee.getLoginId(), attributes, oldValues, newValues);
			LOGGER.info("attributes"+attributes);
			LOGGER.info("oldValues"+oldValues);
			LOGGER.info("newValues"+newValues);
			
			if(!status) {
				saveIDAMFailedTransaction(model,attributes,oldValues,newValues,employee.getEmployeeId());
			}
		}
	}
	}

	private void saveIDAMFailedTransaction(Trade model, List<String> attributes, List<String> oldValues,
			List<String> newValues, long employeeId) {
		
		IDAMFailedTransaction idamFailedTransaction = IDAMFailedTransactionLocalServiceUtil.createIDAMFailedTransaction(CounterLocalServiceUtil.increment());
		idamFailedTransaction.setEmployeeId(employeeId);
		idamFailedTransaction.setIdamUrl(PISUserUtil.getIdamAPIEndPoint());
		idamFailedTransaction.setFiredon(new Date());
		idamFailedTransaction.setClassId(model.getTradeId());
		idamFailedTransaction.setClassName(Trade.class.getSimpleName());
		idamFailedTransaction.setAttribute(String.join(",", attributes));;
		idamFailedTransaction.setOldValue(String.join(",",oldValues));
		idamFailedTransaction.setNewValue(String.join(",", newValues));;
		IDAMFailedTransactionLocalServiceUtil.updateIDAMFailedTransaction(idamFailedTransaction);
		
	}

}
