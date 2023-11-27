package com.adjecti.mdm.ext.listener;

import com.adjecti.mdm.liferay.model.VerificationType;
import com.adjecti.mdm.liferay.service.VerificationTypeLocalServiceUtil;
import com.adjecti.pis.liferay.model.EmployeeTransfer;
import com.adjecti.pis.liferay.model.EmployeeVerification;
import com.adjecti.pis.liferay.service.EmployeeTransferLocalServiceUtil;
import com.adjecti.pis.liferay.service.EmployeeVerificationLocalServiceUtil;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;

import java.util.List;

import org.osgi.service.component.annotations.Component;

@Component(
	    immediate = true,
	    service = ModelListener.class
	)
public class VerificationTypeModelListener extends BaseModelListener<VerificationType>{

	@Override
	public void onAfterAddAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onAfterAddAssociation(classPK, associationClassName, associationClassPK);
	}

	@Override
	public void onAfterCreate(VerificationType model) throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onAfterCreate(model);
	}

	@Override
	public void onAfterRemove(VerificationType model) throws ModelListenerException {
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
	public void onAfterUpdate(VerificationType model) throws ModelListenerException {
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
	public void onBeforeCreate(VerificationType model) throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onBeforeCreate(model);
	}

	@Override
	public void onBeforeRemove(VerificationType model) throws ModelListenerException {
		int count=0;
		try {
		List<EmployeeVerification> employeeVerifications = EmployeeVerificationLocalServiceUtil.getEmployeeVerifications(-1,-1);
				for(EmployeeVerification employeeVerification:employeeVerifications) {
					if(employeeVerification.getVerificationTypeId()==model.getVerificationTypeId()) {
						count++;
					}
				}
		} catch(Exception e) {
			
		}
				if(count>0) {
					throw new ModelListenerException("One or more employee exists for this verificationType id ["+model.getVerificationTypeId()+"].");
				}
	}

	@Override
	public void onBeforeRemoveAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onBeforeRemoveAssociation(classPK, associationClassName, associationClassPK);
	}

	@Override
	public void onBeforeUpdate(VerificationType model) throws ModelListenerException {
		int count=0;
		
		
		if(model.getDeleted()==true) {
			try {
				List<EmployeeVerification> employeeVerifications = EmployeeVerificationLocalServiceUtil.getEmployeeVerifications(-1,-1);
				for(EmployeeVerification employeeVerification:employeeVerifications) {
					if(employeeVerification.getVerificationTypeId()==model.getVerificationTypeId()) {
						count++;
					}
				}
			
				} catch(Exception e) {
					
				}
			 if(count>0) { throw new
				  ModelListenerException("One or more employee exists for this GradeMode id ["+model.getVerificationTypeId()+"]."); }
		}else {
			try {
				List<EmployeeVerification> employeeVerifications = EmployeeVerificationLocalServiceUtil.getEmployeeVerifications(-1,-1);
				for(EmployeeVerification employeeVerification:employeeVerifications) {
					if(employeeVerification.getVerificationTypeId()==model.getVerificationTypeId()) {
						count++;
					}
				}
			
				} catch(Exception e) {
					
				}
		
		
		}	
	}

}
