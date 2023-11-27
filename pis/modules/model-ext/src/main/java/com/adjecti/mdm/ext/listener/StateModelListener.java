package com.adjecti.mdm.ext.listener;

import com.adjecti.mdm.liferay.model.District;
import com.adjecti.mdm.liferay.model.OrganizationDetail;
import com.adjecti.mdm.liferay.model.State;
import com.adjecti.mdm.liferay.service.DistrictLocalServiceUtil;
import com.adjecti.mdm.liferay.service.OrganizationDetailLocalServiceUtil;
import com.adjecti.pis.liferay.model.Address;
import com.adjecti.pis.liferay.model.EmployeeAddress;
import com.adjecti.pis.liferay.service.AddressLocalServiceUtil;
import com.adjecti.pis.liferay.service.EmployeeAddressLocalServiceUtil;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.model.ModelListener;

import java.util.List;

import org.osgi.service.component.annotations.Component;
@Component(
	    immediate = true,
	    service = ModelListener.class
	)
public class StateModelListener extends BaseModelListener<State>{

	@Override
	public void onAfterAddAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onAfterAddAssociation(classPK, associationClassName, associationClassPK);
	}

	@Override
	public void onAfterCreate(State model) throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onAfterCreate(model);
	}

	@Override
	public void onAfterRemove(State model) throws ModelListenerException {
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
	public void onAfterUpdate(State model) throws ModelListenerException {
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
	public void onBeforeCreate(State model) throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onBeforeCreate(model);
	}

	@Override
	public void onBeforeRemove(State model) throws ModelListenerException {
		int count=0;
		try {
			//List<EmployeeAddress> employeeAddresses1 = EmployeeAddressLocalServiceUtil.getEmployeeAddresses(-1, -1);
			List<EmployeeAddress> employeeAddresses = EmployeeAddressLocalServiceUtil.getByStateId(model.getStateId());
			List<Address> addresses = AddressLocalServiceUtil.getByStateId(model.getStateId());
			List<OrganizationDetail> organizationDetail = OrganizationDetailLocalServiceUtil.getByStateId(model.getStateId());
			
			if(employeeAddresses.size()>0 || addresses.size()>0 || organizationDetail.size()>0) {
				count++;
			}
			
			/*
			 * for(EmployeeAddress employeeAddress:employeeAddresses) {
			 * if(employeeAddress.getStateId()==model.getStateId()) { count++; } }
			 * 
			 * 
			 * for(Address address:addresses) { if(address.getStateId()==model.getStateId())
			 * { count++; } }
			 */
			
			List<District> districts = DistrictLocalServiceUtil.getDistrictList(model.getStateId());
			for(District district:districts) {
				if(district.getStateId()==model.getStateId()) {
					count++;
				}
			}
			
			
			
			} catch(Exception e) {
				
			}
			
			if(count>0) {
				throw new ModelListenerException("One or more employee exists for this state id ["+model.getStateId()+"].");
			}
	}

	@Override
	public void onBeforeRemoveAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onBeforeRemoveAssociation(classPK, associationClassName, associationClassPK);
	}

	@Override
	public void onBeforeUpdate(State model) throws ModelListenerException {
		int count=0;
		if(model.getDeleted()==true) {
			try {
				//List<OrganizationDetail> organizationDetail = OrganizationDetailLocalServiceUtil.getByStateId(model.getStateId());
				
				List<EmployeeAddress> employeeAddresses = EmployeeAddressLocalServiceUtil.getEmployeeAddresses(-1,-1);
				List<Address> byAddressIds = AddressLocalServiceUtil.getByStateId(model.getStateId());
				List<District> byDistrictIdAndDeleted = DistrictLocalServiceUtil.getByStateIdAndDeleted(model.getStateId(), false);
				if(byDistrictIdAndDeleted.size()>0) {count++;}
				else {
				
					ab: for(Address byAddressId:byAddressIds) {
					for(EmployeeAddress empaddress:employeeAddresses) {
						
						if( empaddress.getAddressId()==byAddressId.getAddressId()) {
							count++;
							break ab;
						}
					}
				}
				}
				/*List<EmployeeAddress> employeeAddresses1 = EmployeeAddressLocalServiceUtil.getEmployeeAddresses(-1, -1);
				List<EmployeeAddress> employeeAddresses = EmployeeAddressLocalServiceUtil.getByStateId(model.getStateId());
				List<Address> addresses = AddressLocalServiceUtil.getByStateId(model.getStateId());
				List<OrganizationDetail> organizationDetail = OrganizationDetailLocalServiceUtil.getByStateId(model.getStateId());
				
				if(employeeAddresses.size()>0 || addresses.size()>0 || organizationDetail.size()>0) {
					count++;
				}
				*/
				/*
				 * for(EmployeeAddress employeeAddress:employeeAddresses) {
				 * if(employeeAddress.getStateId()==model.getStateId()) { count++; } }
				 * 
				 * 
				 * for(Address address:addresses) { if(address.getStateId()==model.getStateId())
				 * { count++; } }
				 */
				/*
				List<District> districts = DistrictLocalServiceUtil.getDistrictList(model.getStateId());
				for(District district:districts) {
					if(district.getStateId()==model.getStateId()) {
						count++;
					}
				}
				*/
				
				
				} catch(Exception e) {
					
				}
				
				if(count>0) {
					throw new ModelListenerException("One or more employee exists for this state id ["+model.getStateId()+"].");
				}
		} /*
			 * else { try { List<EmployeeAddress> employeeAddresses =
			 * EmployeeAddressLocalServiceUtil.getEmployeeAddresses(-1, -1);
			 * 
			 * for(EmployeeAddress employeeaddress:employeeAddresses) {
			 * if(employeeaddress.getStateId()==model.getStateId()) { count++; } } }
			 * catch(Exception e) {
			 * 
			 * } try { List<District> districts =
			 * DistrictLocalServiceUtil.getDistrictList(model.getStateId()); for(District
			 * district:districts) { if(district.getStateId()==model.getStateId()) {
			 * count++; } } } catch(Exception e) {
			 * 
			 * }
			 * 
			 * }
			 */
	}

}
