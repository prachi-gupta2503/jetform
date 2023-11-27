package com.adjecti.mdm.ext.listener;

import com.adjecti.mdm.liferay.model.Course;
import com.adjecti.pis.liferay.model.EmployeeTraining;
import com.adjecti.pis.liferay.service.EmployeeTrainingLocalServiceUtil;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;

import java.util.List;

import org.osgi.service.component.annotations.Component;
@Component(
		immediate = true,
		service = ModelListener.class
		)
public class CourseModelListener extends BaseModelListener<Course> {
	final static Log LOGGER = LogFactoryUtil.getLog(CourseModelListener.class.getName());
	@Override
	public void onAfterAddAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onAfterAddAssociation(classPK, associationClassName, associationClassPK);
	}

	@Override
	public void onAfterCreate(Course model) throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onAfterCreate(model);
	}

	@Override
	public void onAfterRemove(Course model) throws ModelListenerException {
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
	public void onAfterUpdate(Course model) throws ModelListenerException {
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
	public void onBeforeCreate(Course model) throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onBeforeCreate(model);
	}

	@Override
	public void onBeforeRemove(Course model) throws ModelListenerException {
		LOGGER.info("*********** CourseEntityListener:onBeforeRemove");
		int count=0;
		try {
			List<EmployeeTraining> employeeTrainings = EmployeeTrainingLocalServiceUtil.getEmployeeTrainings(-1,-1);
			for(EmployeeTraining employeeTraining:employeeTrainings) {
				if(employeeTraining.getCourseId()==model.getCourseId()) {
					count++;
				}
			}
		} catch(Exception e) {

		}
		if(count>0) {
			throw new ModelListenerException("One or more employee exists for this training course id ["+model.getCourseId()+"].");
		}
	}

	@Override
	public void onBeforeRemoveAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onBeforeRemoveAssociation(classPK, associationClassName, associationClassPK);
	}

	@Override
	public void onBeforeUpdate(Course model) throws ModelListenerException {
		LOGGER.info("*********** CourseEntityListener:onBeforeUpdate");
		int count=0;
		if(model.getDeleted()==true) {
		try {
			if(model.getDeleted()==true) {
				List<EmployeeTraining> employeeTrainings = EmployeeTrainingLocalServiceUtil.getEmployeeTrainings(-1,-1);
				for(EmployeeTraining employeeTraining:employeeTrainings) {
					if(employeeTraining.getCourseId()==model.getCourseId()) {
						count++;
					}
				}
			}
		} catch(Exception e) {

		}
		if(count>0) {
			throw new ModelListenerException("One or more employee exists for this training course id ["+model.getCourseId()+"].");
		}
		}

	}

}
