package com.adjecti.mdm.ext.listener;

import com.adjecti.mdm.liferay.model.AccomodationType;
import com.adjecti.pis.liferay.model.Address;
import com.adjecti.pis.liferay.model.EmployeeAddress;
import com.adjecti.pis.liferay.service.EmployeeAddressLocalServiceUtil;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.util.PortalUtil;

import java.util.List;

import javax.faces.context.FacesContext;
import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
@Component(
	    immediate = true,
	    service = ModelListener.class
	)
public class AccommodationTypeModelListener extends BaseModelListener<AccomodationType> {

final static Log LOGGER = LogFactoryUtil.getLog(AccommodationTypeModelListener.class.getName());
	@Override
	public void onAfterAddAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		// TODO Auto-generated method stub
		
		super.onAfterAddAssociation(classPK, associationClassName, associationClassPK);
	}

	@Override
	public void onAfterCreate(AccomodationType model) throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onAfterCreate(model);
	}

	@Override
	public void onAfterRemove(AccomodationType model) throws ModelListenerException {
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
	public void onAfterUpdate(AccomodationType model) throws ModelListenerException {
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
	public void onBeforeCreate(AccomodationType model) throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onBeforeCreate(model);
	}

	@Override
	public void onBeforeRemove(AccomodationType model) throws ModelListenerException {
		int count=0;
		if(model.getDeleted()==true) {
			try {
				List<Address> accomodationTypeByAccomodationTypeId = com.adjecti.pis.liferay.service.AddressLocalServiceUtil.getAccomodationTypeByAccomodationTypeId(model.getAccomodationTypeId());
				List<EmployeeAddress> employeeAddresses = EmployeeAddressLocalServiceUtil.getAccomodationTypeByAccomodationTypeId(model.getAccomodationTypeId());
				LOGGER.info("AccommodationTypeModelListener:onBeforeUpdate-method called: Size Of ListOfEmployeeAddress: "+employeeAddresses.size());
				LOGGER.info("AccommodationTypeModelListener:onBeforeUpdate-method called: Size OF ListOfAddress        : "+accomodationTypeByAccomodationTypeId.size());
				
					if(accomodationTypeByAccomodationTypeId.size()>0 ||employeeAddresses.size()>0) {
						count++;
					}
					
				
		            } catch(Exception e) {
					
				}
			if(count>0) {
				throw new ModelListenerException("One or more employee exists for this accomodation id ["+model.getAccomodationTypeId()+"].");
			}
			} 
		
	
		}

	@Override
	public void onBeforeRemoveAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onBeforeRemoveAssociation(classPK, associationClassName, associationClassPK);
	}

	@Override
	public void onBeforeUpdate(AccomodationType model) throws ModelListenerException {
		int count=0;
		
		if(model.getDeleted()==true) {
		try {
			List<Address> accomodationTypeByAccomodationTypeId = com.adjecti.pis.liferay.service.AddressLocalServiceUtil.getAccomodationTypeByAccomodationTypeId(model.getAccomodationTypeId());
			List<EmployeeAddress> employeeAddresses = EmployeeAddressLocalServiceUtil.getAccomodationTypeByAccomodationTypeId(model.getAccomodationTypeId());
			LOGGER.info("AccommodationTypeModelListener:onBeforeUpdate-method called: Size Of ListOfEmployeeAddress: "+employeeAddresses.size());
			LOGGER.info("AccommodationTypeModelListener:onBeforeUpdate-method called: Size OF ListOfAddress        : "+accomodationTypeByAccomodationTypeId.size());
			
				if(accomodationTypeByAccomodationTypeId.size()>0 ||employeeAddresses.size()>0) {
					count++;
				}
				
			
	            } catch(Exception e) {
				
			}
		if(count>0) {
			throw new ModelListenerException("One or more employee exists for this accomodation id ["+model.getAccomodationTypeId()+"].");
		}
		} /*
			 * else { try { List<EmployeeAddress> employeeAddresses =
			 * EmployeeAddressLocalServiceUtil.getEmployeeAddresses(-1, -1); LOGGER.
			 * info("AccommodationTypeModelListener:onBeforeUpdate-method called:  ListOfEmployeeAddress: "
			 * +employeeAddresses); LOGGER.
			 * info("AccommodationTypeModelListener:onBeforeUpdate-method called:  model.getAccomodationTypeId(): "
			 * +model.getAccomodationTypeId()); for(EmployeeAddress
			 * employeeaddress:employeeAddresses) {
			 * if(employeeaddress.getAccomodationTypeId()==model.getAccomodationTypeId()) {
			 * count++; }
			 * 
			 * } } catch(Exception e) {
			 * 
			 * } }
			 * 
			 */
	}
	

}
