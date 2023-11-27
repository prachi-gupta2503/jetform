package com.adjecti.mdm.ext.listener;

import com.adjecti.mdm.liferay.model.BenefitScheme;
import com.adjecti.pis.liferay.model.EmployeeAddress;
import com.adjecti.pis.liferay.model.EmployeeBenefitScheme;
import com.adjecti.pis.liferay.model.FamilyBenefitScheme;
import com.adjecti.pis.liferay.service.EmployeeBenefitSchemeLocalServiceUtil;
import com.adjecti.pis.liferay.service.FamilyBenefitSchemeLocalServiceUtil;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;

import java.util.List;

import org.osgi.service.component.annotations.Component;
@Component(
	    immediate = true,
	    service = ModelListener.class
	)

public class BenefitSchemeModelListener extends BaseModelListener<BenefitScheme> {

	@Override
	public void onAfterAddAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onAfterAddAssociation(classPK, associationClassName, associationClassPK);
	}

	@Override
	public void onAfterCreate(BenefitScheme model) throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onAfterCreate(model);
	}

	@Override
	public void onAfterRemove(BenefitScheme model) throws ModelListenerException {
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
	public void onAfterUpdate(BenefitScheme model) throws ModelListenerException {
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
	public void onBeforeCreate(BenefitScheme model) throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onBeforeCreate(model);
	}

	@Override
	public void onBeforeRemove(BenefitScheme model) throws ModelListenerException {
		System.out.println("In side  onBeforeRemove(BenefitScheme");
		int count=0;
		try {
		List<EmployeeBenefitScheme> employeeBenefitSchemes = EmployeeBenefitSchemeLocalServiceUtil.getEmployeeBenefitSchemes(-1,-1);
		for(EmployeeBenefitScheme employeeBenefitScheme:employeeBenefitSchemes) {
			System.out.println("In side for  onBeforeRemove(BenefitScheme "+count);
			if(employeeBenefitScheme.getBenefitSchemeId()==model.getBenefitSchemeId()) {
				
				count++;
				System.out.println("In side if  onBeforeRemove(BenefitScheme "+count);
			}
		}
		} catch(Exception e) {
			
		}
		if(count>0) {
			throw new ModelListenerException("One or more employee exists for this BenefitScheme id ["+model.getBenefitSchemeId()+"].");
		}
	}

	@Override
	public void onBeforeRemoveAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onBeforeRemoveAssociation(classPK, associationClassName, associationClassPK);
	}

	@Override
	public void onBeforeUpdate(BenefitScheme model) throws ModelListenerException {
		int count=0;
		if(model.getDeleted()==true) {
			try {
				List<EmployeeBenefitScheme> employeeBenefitSchemes = EmployeeBenefitSchemeLocalServiceUtil.getEmployeeBenefitSchemes(-1,-1);
				for(EmployeeBenefitScheme employeeBenefitScheme:employeeBenefitSchemes) {
					if(employeeBenefitScheme.getBenefitSchemeId()==model.getBenefitSchemeId()) {
						count++;
					}
				}
				} catch(Exception e) {
					
				}
			 if(count>0) { throw new
				  ModelListenerException("One or more employee exists for this BenefitScheme id ["+model.getBenefitSchemeId()+"]."); }
		}else {
			try {
				List<EmployeeBenefitScheme> employeeBenefitSchemes = EmployeeBenefitSchemeLocalServiceUtil.getEmployeeBenefitSchemes(-1,-1);
				for(EmployeeBenefitScheme employeeBenefitScheme:employeeBenefitSchemes) {
					if(employeeBenefitScheme.getBenefitSchemeId()==model.getBenefitSchemeId()) {
						count++;
					}
				}
				} catch(Exception e) {
					
				}
		}
		/*
		 * if(count>0) { throw new
		 * ModelListenerException("One or more employee exists for this BenefitScheme id ["
		 * +model.getBenefitSchemeId()+"]."); }
		 */
	}

}
