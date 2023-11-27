package com.adjecti.mdm.ext.listener;

import com.adjecti.mdm.liferay.model.TrainingCourse;
import com.adjecti.mdm.liferay.service.TrainingCourseLocalServiceUtil;
import com.adjecti.pis.liferay.model.EmployeeTraining;
import com.adjecti.pis.liferay.model.EmployeeWorkArea;
import com.adjecti.pis.liferay.service.EmployeeTrainingLocalServiceUtil;
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
public class TrainingCourseModelListener  extends BaseModelListener<TrainingCourse>{

	@Override
	public void onAfterAddAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onAfterAddAssociation(classPK, associationClassName, associationClassPK);
	}

	@Override
	public void onAfterCreate(TrainingCourse model) throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onAfterCreate(model);
	}

	@Override
	public void onAfterRemove(TrainingCourse model) throws ModelListenerException {
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
	public void onAfterUpdate(TrainingCourse model) throws ModelListenerException {
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
	public void onBeforeCreate(TrainingCourse model) throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onBeforeCreate(model);
	}

	@Override
	public void onBeforeRemove(TrainingCourse model) throws ModelListenerException {
		int count=0;
        List<EmployeeTraining> employeeTrainings = EmployeeTrainingLocalServiceUtil.getEmployeeTrainings(-1,-1);
				for(EmployeeTraining employeeTraining:employeeTrainings) {
					if(employeeTraining.getCourseId()==model.getTrainingCourseId()) {
						count++;
					}
				}
				if(count>0) {
					throw new ModelListenerException("One or more employee exists for this training course id ["+model.getTrainingCourseId()+"].");
				}
				
	}

	@Override
	public void onBeforeRemoveAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onBeforeRemoveAssociation(classPK, associationClassName, associationClassPK);
	}

	@Override
	public void onBeforeUpdate(TrainingCourse model) throws ModelListenerException {
		int count=0;
        if(model.getDeleted()==true) {
        	
        	List<EmployeeTraining> employeeTrainings = EmployeeTrainingLocalServiceUtil.getEmployeeTrainings(-1,-1);
			for(EmployeeTraining employeeTraining:employeeTrainings) {
				if(employeeTraining.getCourseId()==model.getTrainingCourseId()) {
					count++;
				}
			}
			if(count>0) {
				throw new ModelListenerException("One or more employee exists for this training course id ["+model.getTrainingCourseId()+"].");
			}
        }else {
        	
        }
	}

}
