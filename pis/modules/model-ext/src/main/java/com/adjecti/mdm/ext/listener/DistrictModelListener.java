package com.adjecti.mdm.ext.listener;

import com.adjecti.mdm.liferay.model.District;
import com.adjecti.mdm.liferay.service.DistrictLocalServiceUtil;
import com.adjecti.pis.liferay.model.Address;
import com.adjecti.pis.liferay.model.EmployeeAddress;
import com.adjecti.pis.liferay.service.AddressLocalServiceUtil;
import com.adjecti.pis.liferay.service.EmployeeAddressLocalServiceUtil;
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
public class DistrictModelListener extends BaseModelListener<District>{
	final static Log LOGGER = LogFactoryUtil.getLog(DistrictModelListener.class.getName());
	
	@Override
	public void onAfterAddAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onAfterAddAssociation(classPK, associationClassName, associationClassPK);
	}

	@Override
	public void onAfterCreate(District model) throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onAfterCreate(model);
	}

	@Override
	public void onAfterRemove(District model) throws ModelListenerException {
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
	public void onAfterUpdate(District model) throws ModelListenerException {
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
	public void onBeforeCreate(District model) throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onBeforeCreate(model);
	}

	@Override
	public void onBeforeRemove(District model) throws ModelListenerException {
		LOGGER.info("DistrictModelListenerremove");
		int count=0;
		try {
			List<EmployeeAddress> employeeAddresses = EmployeeAddressLocalServiceUtil.getByDistrictId(model.getDistrictId());
			List<Address> address = AddressLocalServiceUtil.getByDistrictId(model.getDistrictId());
				LOGGER.info("employeeAddresses  "+employeeAddresses);
				LOGGER.info("address  "+address);
			if(employeeAddresses.size()>0 || address.size()>0) {
					count++;
				}
			LOGGER.info("count "+count);
			/*
				 * for(EmployeeAddress employeeaddress:employeeAddresses) {
				 * if(employeeaddress.getDistrictId()==model.getDistrictId()) { count++; } else
				 * { District district =
				 * DistrictLocalServiceUtil.getDistrict(employeeaddress.getDistrictId());
				 * if(district.getName().equalsIgnoreCase(model.getName())) { count++; } } }
				 */
			} catch(Exception e) {
				
			}
			if(count>0) {
				throw new ModelListenerException("One or more employee exists for this district id ["+model.getDistrictId()+"].");
			}
		
	}

	@Override
	public void onBeforeRemoveAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onBeforeRemoveAssociation(classPK, associationClassName, associationClassPK);
	}

	@Override
	public void onBeforeUpdate(District model) throws ModelListenerException {
		
		int count=0;
		if(model.getDeleted()==true) {
		try {
		List<EmployeeAddress> employeeAddresses = EmployeeAddressLocalServiceUtil.getEmployeeAddresses(-1,-1);
		List<Address> byAddressIds = AddressLocalServiceUtil.getByDistrictId(model.getDistrictId());
		
				
				
				ab: for(Address byAddressId:byAddressIds) {
					
					for(EmployeeAddress empaddress:employeeAddresses) {
				 
				
				if( empaddress.getAddressId()==byAddressId.getAddressId()) {
					
					count++;
					
					break ab;
				}
			}
			
		}
		
		
		/*
			 * for(EmployeeAddress employeeaddress:employeeAddresses) {
			 * if(employeeaddress.getDistrictId()==model.getDistrictId()) { count++; } else
			 * { District district =
			 * DistrictLocalServiceUtil.getDistrict(employeeaddress.getDistrictId());
			 * if(district.getName().equalsIgnoreCase(model.getName())) { count++; } } }
			 */
		} catch(Exception e) {
			
		}
		if(count>0) {
			throw new ModelListenerException("One or more employee exists for this district id ["+model.getDistrictId()+"].");
		}
	}
	}
}














