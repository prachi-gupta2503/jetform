package com.adjecti.mdm.ext.listener;

import com.adjecti.mdm.liferay.model.GradeMode;
import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.liferay.model.EmployeeConfirmation;
import com.adjecti.pis.liferay.model.EmployeeGrade;
import com.adjecti.pis.liferay.model.EmployeeJoining;
import com.adjecti.pis.liferay.model.EmployeePromotion;
import com.adjecti.pis.liferay.model.EmployeeTransfer;
import com.adjecti.pis.liferay.service.EmployeeConfirmationLocalServiceUtil;
import com.adjecti.pis.liferay.service.EmployeeGradeLocalServiceUtil;
import com.adjecti.pis.liferay.service.EmployeeJoiningLocalServiceUtil;
import com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil;
import com.adjecti.pis.liferay.service.EmployeePromotionLocalServiceUtil;
import com.adjecti.pis.liferay.service.EmployeeTransferLocalServiceUtil;
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
public class GradeModeModelListener extends BaseModelListener<GradeMode> {
	final static Log LOGGER = LogFactoryUtil.getLog(GradeModeModelListener.class.getName());
	@Override
	public void onAfterAddAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onAfterAddAssociation(classPK, associationClassName, associationClassPK);
	}

	@Override
	public void onAfterCreate(GradeMode model) throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onAfterCreate(model);
	}

	@Override
	public void onAfterRemove(GradeMode model) throws ModelListenerException {
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
	public void onAfterUpdate(GradeMode model) throws ModelListenerException {
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
	public void onBeforeCreate(GradeMode model) throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onBeforeCreate(model);
	}

	@Override
	public void onBeforeRemove(GradeMode model) throws ModelListenerException {
	int count=0;
		
		
		if(model.getDeleted()==true) {
			try {
				List<Employee> gradeModeByGradeModeId6 = EmployeeLocalServiceUtil.getGradeModeByGradeModeId(model.getGradeModeId());
				List<EmployeeTransfer> gradeModeByGradeModeId2 = EmployeeTransferLocalServiceUtil.getGradeModeByGradeModeId(model.getGradeModeId());
				List<EmployeeConfirmation> gradeModeByGradeModeId = EmployeeConfirmationLocalServiceUtil.getGradeModeByGradeModeId(model.getGradeModeId());
				List<EmployeePromotion> gradeModeByGradeModeId3 = EmployeePromotionLocalServiceUtil.getGradeModeByGradeModeId(model.getGradeModeId());
				List<EmployeeGrade> gradeModeByGradeModeId4 = EmployeeGradeLocalServiceUtil.getGradeModeByGradeModeId(model.getGradeModeId());
				List<EmployeeConfirmation> gradeModeByGradeModeId5 = EmployeeConfirmationLocalServiceUtil.getGradeModeByGradeModeId(model.getGradeModeId());
				List<EmployeeJoining> gradeModeByGradeModeId7 = EmployeeJoiningLocalServiceUtil.getGradeModeByGradeModeId(model.getGradeModeId());
				LOGGER.info(gradeModeByGradeModeId6.size()+"  "+gradeModeByGradeModeId2.size()+"  "+gradeModeByGradeModeId3.size()+"  "+
						gradeModeByGradeModeId.size()+"  "+gradeModeByGradeModeId4.size()+"  "+gradeModeByGradeModeId5.size()+"  "+
						gradeModeByGradeModeId7.size());
				if(gradeModeByGradeModeId6.size()>0||gradeModeByGradeModeId2.size()>0||gradeModeByGradeModeId3.size()>0||
						gradeModeByGradeModeId.size()>0||gradeModeByGradeModeId4.size()>0||gradeModeByGradeModeId5.size()>0||
						gradeModeByGradeModeId7.size()>0) {
					count++;
				}
				LOGGER.info("Count value : "+count);
				/*
				 * List<EmployeeConfirmation> employeeConfirmations =
				 * EmployeeConfirmationLocalServiceUtil.getEmployeeConfirmations(-1,-1);
				 * List<Employee> employees = EmployeeLocalServiceUtil.getEmployees(-1, -1);
				 * List<EmployeeTransfer> employeeTransfers =
				 * EmployeeTransferLocalServiceUtil.getEmployeeTransfers(-1,-1);
				 * List<EmployeeJoining> employeeJoinings =
				 * EmployeeJoiningLocalServiceUtil.getEmployeeJoinings(-1,-1);
				 */
				
				/*for(EmployeeConfirmation employeeConfirmation:employeeConfirmations) {
					if(employeeConfirmation.getGradeModeId()==model.getGradeModeId()) {
						count++;
						
					}
				}
				
				
				
				for(Employee employee:employees) {
					if(employee.getGradeModeId()==model.getGradeModeId()) {
						count++;
						
					}
				}
				
				
				
				for(EmployeeJoining employeeJoining:employeeJoinings) {
					if(employeeJoining.getGradeModeId()==model.getGradeModeId()) {
						count++;
						
					}
				}
				for(EmployeeTransfer employeeTransfer:employeeTransfers) {
					if(employeeTransfer.getGradeModeId()==model.getGradeModeId()) {
						count++;
						
					}
				}*/
			
				} catch(Exception e) {
					
				}
			 if(count>0) { throw new
				  ModelListenerException("One or more employee exists for this GradeMode id ["+model.getGradeModeId()+"]."); }
		}
	}

	@Override
	public void onBeforeRemoveAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onBeforeRemoveAssociation(classPK, associationClassName, associationClassPK);
	}

	@Override
	public void onBeforeUpdate(GradeMode model) throws ModelListenerException {
		int count=0;
		
		
		if(model.getDeleted()==true) {
			try {
				List<Employee> gradeModeByGradeModeId6 = EmployeeLocalServiceUtil.getGradeModeByGradeModeId(model.getGradeModeId());
				List<EmployeeTransfer> gradeModeByGradeModeId2 = EmployeeTransferLocalServiceUtil.getGradeModeByGradeModeId(model.getGradeModeId());
				List<EmployeeConfirmation> gradeModeByGradeModeId = EmployeeConfirmationLocalServiceUtil.getGradeModeByGradeModeId(model.getGradeModeId());
				List<EmployeePromotion> gradeModeByGradeModeId3 = EmployeePromotionLocalServiceUtil.getGradeModeByGradeModeId(model.getGradeModeId());
				List<EmployeeGrade> gradeModeByGradeModeId4 = EmployeeGradeLocalServiceUtil.getGradeModeByGradeModeId(model.getGradeModeId());
				List<EmployeeConfirmation> gradeModeByGradeModeId5 = EmployeeConfirmationLocalServiceUtil.getGradeModeByGradeModeId(model.getGradeModeId());
				List<EmployeeJoining> gradeModeByGradeModeId7 = EmployeeJoiningLocalServiceUtil.getGradeModeByGradeModeId(model.getGradeModeId());
				LOGGER.info(gradeModeByGradeModeId6.size()+"  "+gradeModeByGradeModeId2.size()+"  "+gradeModeByGradeModeId3.size()+"  "+
						gradeModeByGradeModeId.size()+"  "+gradeModeByGradeModeId4.size()+"  "+gradeModeByGradeModeId5.size()+"  "+
						gradeModeByGradeModeId7.size());
				if(gradeModeByGradeModeId6.size()>0||gradeModeByGradeModeId2.size()>0||gradeModeByGradeModeId3.size()>0||
						gradeModeByGradeModeId.size()>0||gradeModeByGradeModeId4.size()>0||gradeModeByGradeModeId5.size()>0||
						gradeModeByGradeModeId7.size()>0) {
					count++;
				}
				LOGGER.info("Count value : "+count);
				/*
				 * List<EmployeeConfirmation> employeeConfirmations =
				 * EmployeeConfirmationLocalServiceUtil.getEmployeeConfirmations(-1,-1);
				 * List<Employee> employees = EmployeeLocalServiceUtil.getEmployees(-1, -1);
				 * List<EmployeeTransfer> employeeTransfers =
				 * EmployeeTransferLocalServiceUtil.getEmployeeTransfers(-1,-1);
				 * List<EmployeeJoining> employeeJoinings =
				 * EmployeeJoiningLocalServiceUtil.getEmployeeJoinings(-1,-1);
				 */
				
				/*for(EmployeeConfirmation employeeConfirmation:employeeConfirmations) {
					if(employeeConfirmation.getGradeModeId()==model.getGradeModeId()) {
						count++;
						
					}
				}
				
				
				
				for(Employee employee:employees) {
					if(employee.getGradeModeId()==model.getGradeModeId()) {
						count++;
						
					}
				}
				
				
				
				for(EmployeeJoining employeeJoining:employeeJoinings) {
					if(employeeJoining.getGradeModeId()==model.getGradeModeId()) {
						count++;
						
					}
				}
				for(EmployeeTransfer employeeTransfer:employeeTransfers) {
					if(employeeTransfer.getGradeModeId()==model.getGradeModeId()) {
						count++;
						
					}
				}*/
			
				} catch(Exception e) {
					
				}
			 if(count>0) { throw new
				  ModelListenerException("One or more employee exists for this GradeMode id ["+model.getGradeModeId()+"]."); }
		}
	}

}
