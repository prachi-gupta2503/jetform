package com.adjecti.mdm.ext.listener;

import com.adjecti.mdm.liferay.model.QualificationGrade;
import com.adjecti.mdm.liferay.service.QualificationGradeLocalServiceUtil;
import com.adjecti.pis.liferay.model.EmployeeQualification;
import com.adjecti.pis.liferay.model.EmployeeWorkArea;
import com.adjecti.pis.liferay.service.EmployeeQualificationLocalServiceUtil;
import com.adjecti.pis.liferay.service.EmployeeWorkAreaLocalServiceUtil;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;

import java.util.List;

import org.osgi.service.component.annotations.Component;
@Component(
	    immediate = true,
	    service = ModelListener.class
	)
public class QualificationGradeModelListener  extends BaseModelListener<QualificationGrade>{

	@Override
	public void onAfterAddAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onAfterAddAssociation(classPK, associationClassName, associationClassPK);
	}

	@Override
	public void onAfterCreate(QualificationGrade model) throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onAfterCreate(model);
	}

	@Override
	public void onAfterRemove(QualificationGrade model) throws ModelListenerException {
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
	public void onAfterUpdate(QualificationGrade model) throws ModelListenerException {
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
	public void onBeforeCreate(QualificationGrade model) throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onBeforeCreate(model);
	}

	@Override
	public void onBeforeRemove(QualificationGrade model) throws ModelListenerException {
		int count=0;
		try{
		List<EmployeeQualification> employeeQualifications = EmployeeQualificationLocalServiceUtil.getEmployeeQualifications(-1,-1);
				for(EmployeeQualification employeeQualification:employeeQualifications) {
					if(employeeQualification.getGradeId()==model.getQualificationGradeId()) {
						count++;
					}
				}
				} catch(Exception e){
		}
				if(count>0) {
					throw new ModelListenerException("One or more employee exists for this Qualification Grade id ["+model.getQualificationGradeId()+"].");
				}
	}

	@Override
	public void onBeforeRemoveAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onBeforeRemoveAssociation(classPK, associationClassName, associationClassPK);
	}

	@Override
	public void onBeforeUpdate(QualificationGrade model) throws ModelListenerException {
    int count=0;
	if(model.getDeleted()==true) {
		try{
			List<EmployeeQualification> employeeQualifications = EmployeeQualificationLocalServiceUtil.getEmployeeQualifications(-1,-1);
					for(EmployeeQualification employeeQualification:employeeQualifications) {
						if(employeeQualification.getGradeId()==model.getQualificationGradeId()) {
							count++;
						}
					}
					} catch(Exception e){
			}
					if(count>0) {
						throw new ModelListenerException("One or more employee exists for this Qualification Grade id ["+model.getQualificationGradeId()+"].");
					}
	}else {
		try{
			List<EmployeeQualification> employeeQualifications = EmployeeQualificationLocalServiceUtil.getEmployeeQualifications(-1,-1);
					for(EmployeeQualification employeeQualification:employeeQualifications) {
						if(employeeQualification.getGradeId()==model.getQualificationGradeId()) {
							count++;
						}
					}
					} catch(Exception e){
			}
				
	}
	}

}
