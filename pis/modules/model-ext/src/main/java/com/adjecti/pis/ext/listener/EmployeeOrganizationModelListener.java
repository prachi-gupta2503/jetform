package com.adjecti.pis.ext.listener;

import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.liferay.model.EmployeeOrganization;
import com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil;
import com.adjecti.pis.liferay.service.EmployeeOrganizationLocalServiceUtil;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;

import org.osgi.service.component.annotations.Component;

@Component(
	    immediate = true,
	    service = ModelListener.class
	)
public class EmployeeOrganizationModelListener extends BaseModelListener<EmployeeOrganization> {

	static final Log LOGGER = LogFactoryUtil.getLog(EmployeeOrganizationModelListener.class.getName());
	
	@Override
	public void onAfterCreate(EmployeeOrganization model) throws ModelListenerException {
		LOGGER.info("*********** EmployeeOrganizationEntityListener:onAfterCreate");		
	}
	
	@Override
	public void onAfterUpdate(EmployeeOrganization model) throws ModelListenerException {
		LOGGER.info("*********** EmployeeOrganizationEntityListener:onAfterUpdate");	
	}
	
	
	@Override
	public void onAfterAddAssociation(Object classPK, String associationClassName,Object associationClassPK) throws ModelListenerException {
		LOGGER.info("*********** EmployeeOrganizationEntityListener:onAfterAddAssociation");
	}

	@Override
	public void onAfterRemove(EmployeeOrganization model) throws ModelListenerException {
		LOGGER.info("*********** EmployeeOrganizationEntityListener:onAfterRemove");
	}

	@Override
	public void onAfterRemoveAssociation(Object classPK, String associationClassName, Object associationClassPK) throws ModelListenerException {
		LOGGER.info("*********** EmployeeOrganizationEntityListener:onAfterRemoveAssociation");
	}
	
	@Override
	public void onBeforeCreate(EmployeeOrganization model) throws ModelListenerException {
		LOGGER.info("***********1. EmployeeOrganizationEntityListener:onBeforeCreate");
		int count=EmployeeOrganizationLocalServiceUtil.getEmployeeOrganizationCountByEmployeeIdAndOrganizationId(model.getEmployeeId(), model.getSubOrganizationId());
		if(count>0) {
			throw new ModelListenerException("Already an EmployeeOrganization exists for this employee id ["+model.getEmployeeId()+"] and section id ["+model.getSubOrganizationId()+"]");
		}
		
		try {
			Employee employee = EmployeeLocalServiceUtil.getEmployee(model.getEmployeeId());
			if(employee.getSubOrganizationId()==model.getSubOrganizationId()) {
				throw new ModelListenerException("Already Primary Section exists for this employee id ["+model.getEmployeeId()+"] and section id ["+model.getSubOrganizationId()+"]");
			}
		} catch (PortalException e) {
			LOGGER.error(e.getMessage());
			throw new ModelListenerException(e.getMessage());
		}catch(NullPointerException e) {
			throw new ModelListenerException(e.getMessage());
		}
	}

	@Override
	public void onBeforeRemove(EmployeeOrganization model) throws ModelListenerException {
		LOGGER.info("*********** EmployeeOrganizationEntityListener:onAfterRemoveAssociation");
	}

	@Override
	public void onBeforeRemoveAssociation(Object classPK, String associationClassName,	Object associationClassPK)
		throws ModelListenerException {
		LOGGER.info("*********** EmployeeOrganizationEntityListener:onBeforeRemoveAssociation");
	}

	@Override
	public void onBeforeUpdate(EmployeeOrganization model) throws ModelListenerException {
		LOGGER.info("EmployeeOrganizationEntityListener:onBeforeUpdate");
	}

}
