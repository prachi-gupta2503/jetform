package com.adjecti.mdm.ext.listener;

import com.adjecti.mdm.liferay.model.Course;
import com.adjecti.mdm.liferay.model.SubjectOfTraining;
import com.adjecti.mdm.liferay.service.CourseLocalServiceUtil;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;

import java.util.List;

import org.osgi.service.component.annotations.Component;

@Component(
	    immediate = true,
	    service = ModelListener.class
	)
public class SubjectOfTrainingModelListener extends BaseModelListener<SubjectOfTraining> {

	@Override
	public void onAfterAddAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onAfterAddAssociation(classPK, associationClassName, associationClassPK);
	}

	@Override
	public void onAfterCreate(SubjectOfTraining model) throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onAfterCreate(model);
	}

	@Override
	public void onAfterRemove(SubjectOfTraining model) throws ModelListenerException {
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
	public void onAfterUpdate(SubjectOfTraining model) throws ModelListenerException {
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
	public void onBeforeCreate(SubjectOfTraining model) throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onBeforeCreate(model);
	}

	@Override
	public void onBeforeRemove(SubjectOfTraining model) throws ModelListenerException {
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
	public void onBeforeUpdate(SubjectOfTraining model) throws ModelListenerException {
		if(model.getDeleted()==true) {
			List<Course> subjectOfTraining = CourseLocalServiceUtil.getBySubjectOfTrainingIdAndStatus(model.getSubjectOfTrainingId(), 0);
		  if(subjectOfTraining.size()>0) {
			  throw new ModelListenerException("One or more employee exists for this state id ["+model.getSubjectOfTrainingId()+"].");
		  }
		}
	}

}
