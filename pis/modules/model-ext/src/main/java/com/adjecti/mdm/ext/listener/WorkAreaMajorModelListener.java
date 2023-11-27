package com.adjecti.mdm.ext.listener;

import com.adjecti.mdm.liferay.model.WorkAreaMajor;
import com.adjecti.mdm.liferay.model.WorkAreaMinor;
import com.adjecti.mdm.liferay.service.WorkAreaMinorLocalServiceUtil;
import com.adjecti.pis.liferay.model.EmployeeExperience;
import com.adjecti.pis.liferay.model.EmployeePastExperience;
import com.adjecti.pis.liferay.service.EmployeeExperienceLocalServiceUtil;
import com.adjecti.pis.liferay.service.EmployeePastExperienceLocalServiceUtil;
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
public class WorkAreaMajorModelListener extends BaseModelListener<WorkAreaMajor>{

	final static Log LOGGER = LogFactoryUtil.getLog(WorkAreaMajorModelListener.class.getName());
	
	@Override
	public void onAfterAddAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onAfterAddAssociation(classPK, associationClassName, associationClassPK);
	}

	@Override
	public void onAfterCreate(WorkAreaMajor model) throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onAfterCreate(model);
	}

	@Override
	public void onAfterRemove(WorkAreaMajor model) throws ModelListenerException {
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
	public void onAfterUpdate(WorkAreaMajor model) throws ModelListenerException {
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
	public void onBeforeCreate(WorkAreaMajor model) throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onBeforeCreate(model);
	}

	@Override
	public void onBeforeRemove(WorkAreaMajor model) throws ModelListenerException {
		
	}

	@Override
	public void onBeforeRemoveAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onBeforeRemoveAssociation(classPK, associationClassName, associationClassPK);
	}

	@Override
	public void onBeforeUpdate(WorkAreaMajor model) throws ModelListenerException {
	System.out.println("On Update1");
		if(model.getDeleted()==true) {
		int count=0;
		try {
		
			List<EmployeePastExperience> employeePastExperiences = EmployeePastExperienceLocalServiceUtil.getByWorkAreaMajorId(model.getWorkAreaMajorId());
		    LOGGER.info("employeePastExperiences "+employeePastExperiences);
			List<EmployeeExperience> employeeExperiences = EmployeeExperienceLocalServiceUtil.getByWorkAreaMajorId(model.getWorkAreaMajorId());
			LOGGER.info("employeeExperiences "+employeeExperiences);
			List<WorkAreaMinor> workAreaMinor = WorkAreaMinorLocalServiceUtil.getByWorkAreaMajorIdAndDeleted(model.getWorkAreaMajorId(), false);
			LOGGER.info("workAreaMinor "+workAreaMinor);
			if(employeePastExperiences.size()>0 || employeeExperiences.size()>0 || workAreaMinor.size()>0)
		    {
		    	count++;
		    	System.out.println("in side if Count : "+count);
		    }
		    	System.out.println("On Update Count : "+count);
		}catch(Exception e) {}
		    	if(count>0) {
					throw new ModelListenerException("One or more employee exists for this workarea id ["+model.getWorkAreaMajorId()+"].");
				}
	}
	}
	

}
