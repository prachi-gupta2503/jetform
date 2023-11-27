package com.adjecti.mdm.ext.listener;

import com.adjecti.mdm.liferay.model.QualificationGrade;
import com.adjecti.mdm.liferay.model.QualificationLevel;
import com.adjecti.mdm.liferay.service.QualificationGradeLocalServiceUtil;
import com.adjecti.mdm.liferay.service.QualificationLevelLocalServiceUtil;
import com.adjecti.pis.liferay.model.EmployeeQualification;
import com.adjecti.pis.liferay.service.EmployeeQualificationLocalServiceUtil;
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
public class QualificationLevelModelListener extends BaseModelListener<QualificationLevel> {

	static final Log LOGGER = LogFactoryUtil.getLog(QualificationLevelModelListener.class.getName());
	
	@Override
	public void onAfterAddAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onAfterAddAssociation(classPK, associationClassName, associationClassPK);
	}

	@Override
	public void onAfterCreate(QualificationLevel model) throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onAfterCreate(model);
	}

	@Override
	public void onAfterRemove(QualificationLevel model) throws ModelListenerException {
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
	public void onAfterUpdate(QualificationLevel model) throws ModelListenerException {
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
	public void onBeforeCreate(QualificationLevel model) throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onBeforeCreate(model);
	}

	@Override
	public void onBeforeRemove(QualificationLevel model) throws ModelListenerException {
		int count=0;
		try{
		List<QualificationLevel> qualificationLevels = QualificationLevelLocalServiceUtil.getQualificationLevels(-1, -1);
				for(QualificationLevel qualificationLevel:qualificationLevels) {
					if(qualificationLevel.getQualificationLevelId()==model.getQualificationLevelId()) {
						count++;
					}
				}
		} catch(Exception e){
		}
				if(count>0) {
					throw new ModelListenerException("One or more employee exists for this Qualification level id ["+model.getQualificationLevelId()+"].");
				}
	}

	@Override
	public void onBeforeRemoveAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onBeforeRemoveAssociation(classPK, associationClassName, associationClassPK);
	}

	@Override
	public void onBeforeUpdate(QualificationLevel model) throws ModelListenerException {
		if(model.getDeleted()==true) {
			LOGGER.info("Inside Delete");
		int count=0;
		try{
			List<EmployeeQualification> qualificationLevels = EmployeeQualificationLocalServiceUtil.getEmployeeQualificationsByQualificationLevelId(model.getQualificationLevelId());
				for(EmployeeQualification qualificationLevel:qualificationLevels) {
					if(qualificationLevel.getLevelId()==model.getQualificationLevelId()) {
						count++;
						LOGGER.info("Inside If count "+count);
					}
				}
				
		} catch(Exception e){
		}
		LOGGER.info("Count "+count);
				if(count>0) {
					throw new ModelListenerException("One or more employee exists for this Qualification level id ["+model.getQualificationLevelId()+"].");
				}
	}
	}
}
