package com.adjecti.mdm.ext.listener;

import com.adjecti.mdm.liferay.model.District;
import com.adjecti.mdm.liferay.model.JoiningMode;
import com.adjecti.mdm.liferay.service.DistrictLocalServiceUtil;
import com.adjecti.pis.liferay.model.EmployeeAddress;
import com.adjecti.pis.liferay.model.EmployeeJoining;
import com.adjecti.pis.liferay.service.EmployeeAddressLocalServiceUtil;
import com.adjecti.pis.liferay.service.EmployeeJoiningLocalServiceUtil;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;

import java.util.List;

import org.osgi.service.component.annotations.Component;
@Component(
	    immediate = true,
	    service = ModelListener.class
	)
public class JoiningModeModelListener extends BaseModelListener<JoiningMode> {

	@Override
	public void onAfterAddAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onAfterAddAssociation(classPK, associationClassName, associationClassPK);
	}

	@Override
	public void onAfterCreate(JoiningMode model) throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onAfterCreate(model);
	}

	@Override
	public void onAfterRemove(JoiningMode model) throws ModelListenerException {
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
	public void onAfterUpdate(JoiningMode model) throws ModelListenerException {
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
	public void onBeforeCreate(JoiningMode model) throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onBeforeCreate(model);
	}

	@Override
	public void onBeforeRemove(JoiningMode model) throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onBeforeRemove(model);
	}

	@Override
	public void onBeforeRemoveAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onBeforeRemoveAssociation(classPK, associationClassName, associationClassPK);
	}

	@Override
	public void onBeforeUpdate(JoiningMode model) throws ModelListenerException {
		int count=0;
		
		if(model.getDeleted()==true) {
			try {
				List<EmployeeJoining> employeeJoinings = EmployeeJoiningLocalServiceUtil.getEmployeeJoinings(-1,-1);
				for( EmployeeJoining employeeJoining:employeeJoinings) {
					if(employeeJoining.getJoiningModeId()==model.getJoiningModeId()) {
						count++;
					}
				}
				} catch(Exception e) {
					
				}
				
				if(count>0) {
					throw new ModelListenerException("One or more employee exists for this state id ["+model.getJoiningModeId()+"].");
				}
		}else {
			try {
				List<EmployeeJoining> employeeJoinings = EmployeeJoiningLocalServiceUtil.getEmployeeJoinings(-1,-1);
				for( EmployeeJoining employeeJoining:employeeJoinings) {
					if(employeeJoining.getJoiningModeId()==model.getJoiningModeId()) {
						count++;
					}
				}
				} catch(Exception e) {
					
				}
				
		}
	}

}
