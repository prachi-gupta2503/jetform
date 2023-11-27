package com.adjecti.mdm.ext.listener;

import com.adjecti.mdm.liferay.model.ServiceRequestType;
import com.adjecti.mdm.liferay.service.ServiceRequestTypeLocalServiceUtil;
import com.adjecti.pis.ext.listener.ServiceRequestModelListener;
import com.adjecti.pis.liferay.model.ServiceRequest;
import com.adjecti.pis.liferay.service.ServiceRequestLocalServiceUtil;
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

public class ServiceRequestTypeModelListener  extends BaseModelListener<ServiceRequestType>{

	final static Log LOGGER = LogFactoryUtil.getLog(ServiceRequestTypeModelListener.class.getName());
	@Override
	public void onAfterAddAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onAfterAddAssociation(classPK, associationClassName, associationClassPK);
	}

	@Override
	public void onAfterCreate(ServiceRequestType model) throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onAfterCreate(model);
	}

	@Override
	public void onAfterRemove(ServiceRequestType model) throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onAfterRemove(model);
	}

	@Override
	public void onAfterRemoveAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onAfterRemoveAssociation(classPK, associationClassName, associationClassPK);
	}

	@Override
	public void onAfterUpdate(ServiceRequestType model) throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onAfterUpdate(model);
	}

	@Override
	public void onBeforeAddAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onBeforeAddAssociation(classPK, associationClassName, associationClassPK);
	}

	@Override
	public void onBeforeCreate(ServiceRequestType model) throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onBeforeCreate(model);
	}

	@Override
	public void onBeforeRemove(ServiceRequestType model) throws ModelListenerException {
		LOGGER.info("Before Remove");
		int count=0;
		try {
		
		
			List<ServiceRequest> serviceRequests = ServiceRequestLocalServiceUtil.getByServiceRequestTypeIdAndDeleted(model.getServiceRequestTypeId(), false);
			if(serviceRequests.size()>0) {
				count++;
				LOGGER.info("Count "+count);
			}
				
		} catch(Exception e) {
			
		}
				if(count>0) {
					throw new ModelListenerException("One or more employee exists for this Service Request Type id ["+model.getServiceRequestTypeId()+"].");
				}
	}

	@Override
	public void onBeforeRemoveAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onBeforeRemoveAssociation(classPK, associationClassName, associationClassPK);
	}

	@Override
	public void onBeforeUpdate(ServiceRequestType model) throws ModelListenerException {
		LOGGER.info("onBeforeUpdate ");
		int count=0;
		
	if(model.getDeleted()==true) {
		try {
			List<ServiceRequest> serviceRequests = ServiceRequestLocalServiceUtil.getByServiceRequestTypeIdAndDeleted(model.getServiceRequestTypeId(), false);

			if(serviceRequests.size()>0) {
				count++;
				LOGGER.info("Count "+count);
			}
		
		} catch(Exception e) {
			
		}
		if(count>0) {
			throw new ModelListenerException("One or more employee exists for this Service Request Type id ["+model.getServiceRequestTypeId()+"].");
		}
	}else {
		System.out.println("Service request Else Block");
	}
	}

}
