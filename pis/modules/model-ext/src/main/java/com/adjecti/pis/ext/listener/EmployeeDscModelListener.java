package com.adjecti.pis.ext.listener;

import com.adjecti.common.util.DateUtils;
import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.liferay.model.EmployeeDsc;
import com.adjecti.pis.liferay.service.EmployeeDscLocalServiceUtil;
import com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil;
import com.adjecti.pis.liferay.util.PISUserUtil;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, service = ModelListener.class)
public class EmployeeDscModelListener extends BaseModelListener<EmployeeDsc> {

	static final Log LOGGER = LogFactoryUtil.getLog(EmployeeDscModelListener.class.getName());

	@Override
	public void onAfterCreate(EmployeeDsc model) throws ModelListenerException {
		LOGGER.info("*********** EmployeeDscEntityListener:onAfterCreate");
		boolean status=updateIDAMUser(model,false);
		LOGGER.info("IDEM USER STATUS "+status);
		if(!status) {
			throw new ModelListenerException("IDAM User updation failed for DSC" );
		}
	}

	@Override
	public void onAfterUpdate(EmployeeDsc model) throws ModelListenerException {
		LOGGER.info("*********** EmployeeDscEntityListener:onAfterUpdate");
	}

	@Override
	public void onAfterAddAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		LOGGER.info("*********** EmployeeDscEntityListener:onAfterAddAssociation");
	}

	@Override
	public void onAfterRemove(EmployeeDsc model) throws ModelListenerException {
		LOGGER.info("*********** EmployeeDscEntityListener:onAfterRemove");
	}

	@Override
	public void onAfterRemoveAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		LOGGER.info("*********** EmployeeDscEntityListener:onAfterRemoveAssociation");
	}

	@Override
	public void onBeforeCreate(EmployeeDsc model) throws ModelListenerException {
		LOGGER.info("***********1. EmployeeDscEntityListener:onBeforeCreate");
		
	}

	@Override
	public void onBeforeRemove(EmployeeDsc model) throws ModelListenerException {
		LOGGER.info("*********** EmployeeDscEntityListener:onAfterRemoveAssociation");
	}

	@Override
	public void onBeforeRemoveAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		LOGGER.info("*********** EmployeeDscEntityListener:onBeforeRemoveAssociation");
	}

	@Override
	public void onBeforeUpdate(EmployeeDsc model) throws ModelListenerException {
		LOGGER.info("EmployeeDscEntityListener:onBeforeUpdate");
		boolean status=updateIDAMUser(model,true);
		LOGGER.info("IDEM USER STATUS "+status);
		if(!status) {
			throw new ModelListenerException("IDAM User updation failed for DSC" );
		}
			
	}
	
	public boolean updateIDAMUser(EmployeeDsc model,boolean isDSCExist) {
	
		List<String> attributes=new ArrayList<String>();
		List<String> oldValues=new ArrayList<String>();
		List<String> newValues=new ArrayList<String>();
		EmployeeDsc employeeDsc=null;
		if(isDSCExist) {
			
			try {
				employeeDsc = EmployeeDscLocalServiceUtil.getEmployeeDsc(model.getEmployeeDscId());
			} catch (PortalException e1) {
				LOGGER.error(e1.getMessage());
			}
		}
			
		
		 if(employeeDsc!=null && employeeDsc.getOfbDSCRevocationStatus() &&  model.getOfbDSCReissueStatus()){
			model.setOfbDSCRevocationStatus(false);	
			 model.setOfbDSCReissueDate(new Date());
		}
			 
		 else if(employeeDsc!=null && employeeDsc.isOfbDSCReissueStatus() && model.isOfbDSCRevocationStatus()){
			model.setOfbDSCReissueStatus(false);
			model.setOfbDSCRevocationDate(new Date());
		}
		 else if( model.getOfbDSCRevocationStatus() && !model.getOfbDSCReissueStatus()){
			
			 model.setOfbDSCRevocationDate(new Date());
		}
		try {
			String oldRevokedDate=null;
			if(employeeDsc!=null) {
				 oldRevokedDate=DateUtils.format(employeeDsc.getOfbDSCRevocationDate(), DateUtils.YYYY_MM_DD);
			}
			LOGGER.info("revokedDate : "+oldRevokedDate);
			String revokedDate=DateUtils.format(model.getOfbDSCRevocationDate(), DateUtils.YYYY_MM_DD);
			LOGGER.info("newRevokedDate : "+revokedDate);
			attributes.add("ofbDSCRevocationDate");
			oldValues.add(oldRevokedDate);
			newValues.add(revokedDate);
			String oldissueDate=null;
			if(employeeDsc!=null) {
				
				 oldissueDate=DateUtils.format(employeeDsc.getOfbDSCReissueDate(), DateUtils.YYYY_MM_DD);
			}
			LOGGER.info("oldissueDate : "+oldissueDate);
			String issueDate=DateUtils.format(model.getOfbDSCReissueDate(), DateUtils.YYYY_MM_DD) ;
			LOGGER.info("new issueDate : "+issueDate);
			attributes.add("ofbDSCReissueDate");
			oldValues.add(oldissueDate);
			newValues.add(issueDate);
			
			String oldRevoked="false";
			if(employeeDsc!=null) {
				
				oldRevoked=String.valueOf(employeeDsc.getOfbDSCRevocationStatus());
			}
			LOGGER.info("oldRevoked : "+oldRevoked);
			String revoked=String.valueOf(model.getOfbDSCRevocationStatus());
			LOGGER.info("new revoked : "+revoked);
			attributes.add("ofbDSCRevocationStatus");
			oldValues.add(oldRevoked);
			newValues.add(revoked);
			
			String oldReissued="false";
			if(employeeDsc!=null) {
				
				 oldReissued=String.valueOf(employeeDsc.getOfbDSCReissueStatus());
			}
			LOGGER.info("oldReissued : "+oldReissued);
			String reissued=String.valueOf(model.getOfbDSCReissueStatus());
			LOGGER.info("new reissue : "+reissued);
			attributes.add("ofbDSCReissueStatus");
			oldValues.add(oldReissued);
			newValues.add(reissued);
			
		} catch (Exception e1) {
			LOGGER.error(e1.getMessage());
		}
		
		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		Employee employee=null; 
		try {
			User user = UserLocalServiceUtil.getUser(serviceContext.getUserId());
			employee =  EmployeeLocalServiceUtil.getEmployeeByEmailId(user.getEmailAddress());
		   
		} catch (PortalException e1) {
			LOGGER.error(e1.getMessage());
		}
		
		return PISUserUtil.updateIDAMUser(employee.getLoginId(), attributes, oldValues, newValues);
		
	}
	
	
}
