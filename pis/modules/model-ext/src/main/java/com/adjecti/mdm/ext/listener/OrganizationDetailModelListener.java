package com.adjecti.mdm.ext.listener;

import com.adjecti.mdm.liferay.model.OrganizationDetail;
import com.adjecti.mdm.liferay.service.OrganizationDetailLocalServiceUtil;
import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.liferay.model.EmployeeConfirmation;
import com.adjecti.pis.liferay.model.EmployeeExperience;
import com.adjecti.pis.liferay.model.EmployeeJoining;
import com.adjecti.pis.liferay.model.EmployeeOrganization;
import com.adjecti.pis.liferay.model.EmployeePromotion;
import com.adjecti.pis.liferay.model.EmployeeTraining;
import com.adjecti.pis.liferay.model.EmployeeTransfer;
import com.adjecti.pis.liferay.model.EmployeeVerification;
import com.adjecti.pis.liferay.model.JoiningProcess;
import com.adjecti.pis.liferay.model.SingleUserOnboarding;
import com.adjecti.pis.liferay.service.EmployeeConfirmationLocalServiceUtil;
import com.adjecti.pis.liferay.service.EmployeeExperienceLocalServiceUtil;
import com.adjecti.pis.liferay.service.EmployeeJoiningLocalServiceUtil;
import com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil;
import com.adjecti.pis.liferay.service.EmployeeOrganizationLocalServiceUtil;
import com.adjecti.pis.liferay.service.EmployeePromotionLocalServiceUtil;
import com.adjecti.pis.liferay.service.EmployeeTrainingLocalServiceUtil;
import com.adjecti.pis.liferay.service.EmployeeTransferLocalServiceUtil;
import com.adjecti.pis.liferay.service.EmployeeVerificationLocalServiceUtil;
import com.adjecti.pis.liferay.service.JoiningProcessLocalServiceUtil;
import com.adjecti.pis.liferay.service.PeopleLocalServiceUtil;
import com.adjecti.pis.liferay.service.SingleUserOnboardingLocalServiceUtil;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;

import java.util.List;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, service = ModelListener.class)
public class OrganizationDetailModelListener extends BaseModelListener<OrganizationDetail> {

	final static Log LOGGER = LogFactoryUtil.getLog(OrganizationDetailModelListener.class.getName());

	@Override
	public void onAfterCreate(OrganizationDetail model) throws ModelListenerException {
		LOGGER.info("OrganizationDetailModelListener:onAfterCreate-method called");
	}

	@Override
	public void onAfterUpdate(OrganizationDetail model) throws ModelListenerException {
		LOGGER.info("OrganizationDetailModelListener:onAfterUpdate-method called");
	}

	@Override
	public void onAfterAddAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		LOGGER.info("OrganizationDetailModelListener:onAfterAddAssociation-method called");
	}

	@Override
	public void onAfterRemove(OrganizationDetail model) throws ModelListenerException {
		LOGGER.info("OrganizationDetailModelListener:onAfterRemove-method called");

	}

	@Override
	public void onAfterRemoveAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		LOGGER.info("OrganizationDetailModelListener:onAfterRemoveAssociation-method called");
	}

	@Override
	public void onBeforeCreate(OrganizationDetail model) throws ModelListenerException {
		 model.setStatus(1); 

		LOGGER.info("OrganizationDetailModelListener:onBeforeCreate-method called");
	}

	@Override
	public void onBeforeRemove(OrganizationDetail model) throws ModelListenerException {
		LOGGER.info("onBeforeRemove-method called"+model.getType());

		if (model.getType().equalsIgnoreCase("section")) {
		LOGGER.info("INSIDE SECTIon ");
			int count = 0;
			
			try {
			LOGGER.info(model.getOrganizationDetailId());
			List<EmployeeOrganization> employeeOrganization = EmployeeOrganizationLocalServiceUtil.getBySubOrganizationIdAndActive(model.getOrganizationDetailId(), false);
			List<SingleUserOnboarding> singleUserOnboarding = SingleUserOnboardingLocalServiceUtil.getBySectionAndStatus(model.getOrganizationDetailId(),0);
		    List<Employee> employee = EmployeeLocalServiceUtil.getBySubOrganizationId(model.getOrganizationDetailId());
		  //  List<Employee> employeeByOrganizationId = EmployeeLocalServiceUtil.getEmployeeByOrganizationId(model.getOrganizationDetailId());
		    List<EmployeeJoining> employeeJoining = EmployeeJoiningLocalServiceUtil.findBySubOrganizationId(model.getOrganizationDetailId());
		    
		    LOGGER.info("employeeOrganization.size()  "+employeeOrganization.size()+" singleUserOnboarding.size()  "+singleUserOnboarding.size()+" employee.size() "+employee.size()+" employeeJoining.size()  "+employeeJoining.size());
		    if(employeeOrganization.size()>0 || singleUserOnboarding.size()>0 || employee.size()>0 || employeeJoining.size()>0) {
			count++;
		}
		}catch (Exception e) {
			
		}
			
			if (count > 0) {
				LOGGER.info(" Inside if Count " + count);
				throw new ModelListenerException(
						"One or more employee exists for this organization id [" + model.getOrganizationId() + "].");

			}
			LOGGER.info("Delete Organization Based On Role");
			Organization deleteOrganization = null;
			try {
				deleteOrganization = OrganizationLocalServiceUtil.deleteOrganization(model.getOrganizationDetailId());
			if(deleteOrganization==null) {
			count++;	
						}
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				LOGGER.info("Inside Exception Count : "+count);
				count++;
				e.printStackTrace();
				LOGGER.info("Inside Exception Count : "+count);
				LOGGER.error(e);
			}
			
			if (count > 0) {
				throw new ModelListenerException(
						"One or more employee exists for this organization id [" + model.getOrganizationId() + "].");

			}
			LOGGER.info(" Delete Organization Based On Role Count " + count);
            LOGGER.info("Delete ORg remove deleteOrganization"+deleteOrganization);
			
		}
		
		
		
		if (model.getType().equalsIgnoreCase("institute")) {
			int count = 0;
			try {
				// List<EmployeeJoining> findByOrganizationID =
				// EmployeeJoiningLocalServiceUtil.findByOrganizationID(model.getOrganizationId());
				// List<EmployeeTraining> findByInstituteId =
				// EmployeeTrainingLocalServiceUtil.findByInstituteId(model.getOrganizationId());
				// List<Employee> list=
				// EmployeeLocalServiceUtil.getEmployeeByOrganizationId(model.getOrganizationId());

				List<Employee> list = EmployeeLocalServiceUtil.getEmployeeByOrganizationId(model.getOrganizationId());
				List<EmployeeJoining> findByOrganizationID = EmployeeJoiningLocalServiceUtil
						.findByOrganizationID(model.getOrganizationId());
				List<EmployeeTraining> employeeTrainings = EmployeeTrainingLocalServiceUtil.getEmployeeTrainings(-1,
						-1);
				for (EmployeeTraining employeeTraining : employeeTrainings) {
					LOGGER.info("employeeTraining.getInstituteId()  " + employeeTraining.getInstituteId()
							+ "   model.getOrganizationId()  " + model.getOrganizationId());
					if (employeeTraining.getInstituteId() == model.getOrganizationId()) {
						count++;
						LOGGER.info("employeeTraining.getInstituteId()  " + employeeTraining.getInstituteId()
								+ "   model.getOrganizationId()  " + model.getOrganizationId() + " COUNT " + count);
					}
				}

				if (findByOrganizationID.size() > 0 || list.size() > 0) {
					count++;
					LOGGER.info("Count Inside If List " + count);
				}

				LOGGER.info("Count " + count);

			} catch (Exception e) {
			}

			if (count > 0) {
				LOGGER.info(" Inside if Count " + count);
				throw new ModelListenerException(
						"One or more employee exists for this organization id [" + model.getOrganizationId() + "].");

			}
			Organization deleteOrganization = null;
			try {
				deleteOrganization = OrganizationLocalServiceUtil.deleteOrganization(model.getOrganizationDetailId());
			if(deleteOrganization==null) {
			count++;	
						}
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				LOGGER.info("Inside Exception Count : "+count);
				count++;
				e.printStackTrace();
				LOGGER.info("Inside Exception Count : "+count);
				LOGGER.error(e);
			}
			
			if (count > 0) {
				throw new ModelListenerException(
						"One or more employee exists for this organization id [" + model.getOrganizationId() + "].");

			}
			LOGGER.info(" Delete Organization Based On Role Count " + count);
            LOGGER.info("Delete ORg remove deleteOrganization"+deleteOrganization);
		}

		if (model.getType().equalsIgnoreCase("unit")) {
			LOGGER.info(" Inside Unit Count 12");
			int count = 0;

			// List<EmployeeTransfer> employeeTransfers =
			// EmployeeTransferLocalServiceUtil.getEmployeeTransfers(-1,-1);
			List<SingleUserOnboarding> singleUserOnboarding = SingleUserOnboardingLocalServiceUtil
					.getByUnitId(String.valueOf(model.getOrganizationId()));
			LOGGER.info("SingleUserOnboarding " + singleUserOnboarding);
			List<JoiningProcess> joiningProcess = JoiningProcessLocalServiceUtil.getByUnitId(model.getOrganizationId());
			LOGGER.info("JoiningProcess" + joiningProcess);
			List<EmployeeTransfer> employeeTransferByFromOrganizationId = EmployeeTransferLocalServiceUtil
					.getByFromOrganizationId(model.getOrganizationId());
			LOGGER.info("EmployeeTransfer " + employeeTransferByFromOrganizationId);
			List<EmployeeTransfer> employeeTransferByToOrganizationId = EmployeeTransferLocalServiceUtil
					.getByToOrganizationId(model.getOrganizationId());
			LOGGER.info("EmployeeTransfer " + employeeTransferByToOrganizationId);
			List<EmployeePromotion> employeePromotion = EmployeePromotionLocalServiceUtil
					.getByOrganizationId(model.getOrganizationId());
			LOGGER.info("EmployeePromotion " + employeePromotion);
			List<EmployeeJoining> employeeJoining = EmployeeJoiningLocalServiceUtil
					.findByOrganizationID(model.getOrganizationId());
			LOGGER.info("EmployeeJoining " + employeeJoining);
			List<EmployeeConfirmation> employeeConfirmation = EmployeeConfirmationLocalServiceUtil
					.getByOrganizationId(model.getOrganizationId());
			LOGGER.info("EmployeeConfirmation " + employeeConfirmation);
			List<EmployeeExperience> employeeExperience = EmployeeExperienceLocalServiceUtil
					.getByUnitId(model.getOrganizationId());
			LOGGER.info("EmployeeExperience" + employeeExperience);
			List<EmployeeVerification> employeeVerification = EmployeeVerificationLocalServiceUtil
					.getByUnitId(model.getOrganizationId());
			LOGGER.info("EmployeeVerification" + employeeVerification);
			List<EmployeeOrganization> employeeOrganization = EmployeeOrganizationLocalServiceUtil
					.getByOrganizationId(model.getOrganizationId());
			LOGGER.info("EmployeeOrganization " + employeeOrganization);
			List<EmployeeTraining> employeeTraining = EmployeeTrainingLocalServiceUtil
					.findByOrganizationID(model.getOrganizationId());
			LOGGER.info("EmployeeTraining " + employeeTraining);
			List<Employee> employeeByOrganizationId = EmployeeLocalServiceUtil.getEmployeeByOrganizationId(model.getOrganizationDetailId());
			LOGGER.info("employeeByOrganizationId " + employeeByOrganizationId);
			
			List<OrganizationDetail> organizationDetail = OrganizationDetailLocalServiceUtil.getByParentIdAndType(model.getOrganizationId(),"Section");
					LOGGER.info("organizationDetail " + organizationDetail);

			if ((employeeTraining.size() > 0) || (singleUserOnboarding.size() > 0) || (joiningProcess.size() > 0)
					|| (employeeTransferByFromOrganizationId.size() > 0)
					|| (employeeTransferByToOrganizationId.size() > 0) || (employeePromotion.size() > 0)
					|| (employeeJoining.size() > 0) || (employeeConfirmation.size() > 0)
					|| (employeeExperience.size() > 0) || (employeeVerification.size() > 0)
					|| (employeeOrganization.size() > 0) || (employeeByOrganizationId.size()>0)
					|| (organizationDetail.size()>0)) {
				LOGGER.info("IN SIDE CONDITION CHECK Count " + count);
				count++;
				LOGGER.info("IN SIDE CONDITION CHECK Count " + count);
			}
			LOGGER.info("After  CONDITION CHECK Count " + count);
			if (count > 0) {
				LOGGER.info("Countn " + count);
				throw new ModelListenerException(
						"One or more employee exists for this Unit id [" + model.getOrganizationId() + "].");
			}
			Organization deleteOrganization = null;
			
			try {
				deleteOrganization = OrganizationLocalServiceUtil.deleteOrganization(model.getOrganizationDetailId());
			if(deleteOrganization==null) {
			count++;	
						}
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				LOGGER.info("Inside Exception Count : "+count);
				count++;
				e.printStackTrace();
				LOGGER.info("Inside Exception Count : "+count);
				LOGGER.error(e);
			}
			
			if (count > 0) {
				throw new ModelListenerException(
						"One or more employee exists for this organization id [" + model.getOrganizationId() + "].");

			}
			LOGGER.info(" Delete Organization Based On Role Count " + count);
            LOGGER.info("Delete ORg remove deleteOrganization"+deleteOrganization);
			

		}

	}

	@Override
	public void onBeforeRemoveAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		LOGGER.info("OrganizationDetailModelListener:onBeforeRemoveAssociation-method called");
	}

	@Override
	public void onBeforeUpdate(OrganizationDetail model) throws ModelListenerException {
		LOGGER.info("onBeforeUpdate-method called");

		/*
		 * int count=0; if(model.getType().equalsIgnoreCase("institute")) { try {
		 * //List<EmployeeJoining> findByOrganizationID =
		 * EmployeeJoiningLocalServiceUtil.findByOrganizationID(model.getOrganizationId(
		 * )); //List<EmployeeTraining> findByInstituteId =
		 * EmployeeTrainingLocalServiceUtil.findByInstituteId(model.getOrganizationId())
		 * ; //List<Employee> list=
		 * EmployeeLocalServiceUtil.getEmployeeByOrganizationId(model.getOrganizationId(
		 * ));
		 * 
		 * List<Employee> list=
		 * EmployeeLocalServiceUtil.getEmployeeByOrganizationId(model.getOrganizationId(
		 * )); List<EmployeeJoining> findByOrganizationID =
		 * EmployeeJoiningLocalServiceUtil.findByOrganizationID(model.getOrganizationId(
		 * )); List<EmployeeTraining> employeeTrainings =
		 * EmployeeTrainingLocalServiceUtil.getEmployeeTrainings(-1,-1);
		 * for(EmployeeTraining employeeTraining:employeeTrainings) {
		 * LOGGER.info("employeeTraining.getInstituteId()  "+employeeTraining.
		 * getInstituteId()+"   model.getOrganizationId()  "+model.getOrganizationId());
		 * if(employeeTraining.getInstituteId()==model.getOrganizationId()) { count++;
		 * LOGGER.info("employeeTraining.getInstituteId()  "+employeeTraining.
		 * getInstituteId()+"   model.getOrganizationId()  "+model.getOrganizationId()
		 * +" COUNT "+count); } }
		 * 
		 * if(findByOrganizationID.size()>0 || list.size()>0){ count++;
		 * LOGGER.info("Count Inside If List "+ count); }
		 * 
		 * LOGGER.info("Count "+ count);
		 * 
		 * 
		 * 
		 * 
		 * }catch(Exception e) {}
		 * 
		 * if(count>0 ){ LOGGER.info(" Inside if Count "+ count); throw new
		 * ModelListenerException("One or more employee exists for this organization id ["
		 * +model.getOrganizationId()+"].");
		 * 
		 * } }
		 * 
		 * 
		 * if(model.getType().equalsIgnoreCase("unit")) {
		 * LOGGER.info(" Inside Unit Count 12"+ count); int countn=0;
		 * //List<EmployeeTransfer> employeeTransfers =
		 * EmployeeTransferLocalServiceUtil.getEmployeeTransfers(-1,-1);
		 * List<SingleUserOnboarding>
		 * singleUserOnboarding=SingleUserOnboardingLocalServiceUtil.getByUnitId(String.
		 * valueOf(model.getOrganizationId()));
		 * LOGGER.info("SingleUserOnboarding "+singleUserOnboarding);
		 * List<JoiningProcess>
		 * joiningProcess=JoiningProcessLocalServiceUtil.getByUnitId(model.
		 * getOrganizationId()); LOGGER.info("JoiningProcess"+joiningProcess);
		 * List<EmployeeTransfer> employeeTransferByFromOrganizationId =
		 * EmployeeTransferLocalServiceUtil.getByFromOrganizationId(model.
		 * getOrganizationId());
		 * LOGGER.info("EmployeeTransfer "+employeeTransferByFromOrganizationId);
		 * List<EmployeeTransfer> employeeTransferByToOrganizationId =
		 * EmployeeTransferLocalServiceUtil.getByToOrganizationId(model.
		 * getOrganizationId());
		 * LOGGER.info("EmployeeTransfer "+employeeTransferByToOrganizationId);
		 * List<EmployeePromotion> employeePromotion =
		 * EmployeePromotionLocalServiceUtil.getByOrganizationId(model.getOrganizationId
		 * ()); LOGGER.info("EmployeePromotion "+employeePromotion);
		 * List<EmployeeJoining> employeeJoining
		 * =EmployeeJoiningLocalServiceUtil.findByOrganizationID(model.getOrganizationId
		 * ()); LOGGER.info("EmployeeJoining "+employeeJoining);
		 * List<EmployeeConfirmation> employeeConfirmation =
		 * EmployeeConfirmationLocalServiceUtil.getByOrganizationId(model.
		 * getOrganizationId());
		 * LOGGER.info("EmployeeConfirmation "+employeeConfirmation);
		 * List<EmployeeExperience> employeeExperience =
		 * EmployeeExperienceLocalServiceUtil.getByUnitId(model.getOrganizationId());
		 * LOGGER.info("EmployeeExperience"+employeeExperience);
		 * List<EmployeeVerification> employeeVerification =
		 * EmployeeVerificationLocalServiceUtil.getByUnitId(model.getOrganizationId());
		 * LOGGER.info("EmployeeVerification"+employeeVerification);
		 * List<EmployeeOrganization> employeeOrganization =
		 * EmployeeOrganizationLocalServiceUtil.getByOrganizationId(model.
		 * getOrganizationId());
		 * LOGGER.info("EmployeeOrganization "+employeeOrganization);
		 * List<EmployeeTraining> employeeTraining =
		 * EmployeeTrainingLocalServiceUtil.findByOrganizationID(model.getOrganizationId
		 * ()); LOGGER.info("EmployeeTraining "+employeeTraining);
		 * LOGGER.info("employeeTraining.size()  "+employeeTraining.size()
		 * +"  singleUserOnboarding.size()  "+singleUserOnboarding.size()
		 * +" joiningProcess.size()  "+ joiningProcess.size()
		 * +"  employeeTransferByFromOrganizationId.size() " +
		 * employeeTransferByFromOrganizationId.size()
		 * +"  employeeTransferByToOrganizationId.size() "+
		 * employeeTransferByToOrganizationId.size()
		 * +" employeePromotion.size() "+employeePromotion.size()
		 * +" employeeJoining.size() "+employeeJoining.size()
		 * +"employeeConfirmation.size() "+employeeConfirmation.size()
		 * +" employeeExperience.size() "+
		 * employeeExperience.size()+" employeeVerification.size() "+
		 * employeeVerification.size()+" employeeOrganization.size() "
		 * +employeeOrganization.size());
		 * 
		 * if((employeeTraining.size()>0) || (singleUserOnboarding.size() > 0) ||(
		 * joiningProcess.size() > 0) ||( employeeTransferByFromOrganizationId.size() >
		 * 0) || (employeeTransferByToOrganizationId.size() > 0) ||
		 * (employeePromotion.size() > 0) || (employeeJoining.size() > 0) ||
		 * (employeeConfirmation.size() > 0) ||( employeeExperience.size()>0 )||(
		 * employeeVerification.size() >0 )|| (employeeOrganization.size()>0)) {
		 * LOGGER.info("IN SIDE CONDITION CHECK Count "+countn); countn++;
		 * LOGGER.info("IN SIDE CONDITION CHECK Count "+countn); }
		 * LOGGER.info("After  CONDITION CHECK Count "+countn); if(countn>0) {
		 * LOGGER.info("Countn "+countn); throw new
		 * ModelListenerException("One or more employee exists for this Unit id ["+model
		 * .getOrganizationId()+"]."); } if(countn==0 && model.getDeleted()==true) {
		 * 
		 * 
		 * long organizationDetailId = model.getOrganizationDetailId();
		 * LOGGER.info(organizationDetailId); boolean deleteOrganizationDetail =
		 * OrganizationDetailLocalServiceUtil.deleteeOrganizationDetail(model.
		 * getOrganizationDetailId());
		 * 
		 * 
		 * LOGGER.info("Deleted Successfully deleteOrganizationDetail"
		 * +deleteOrganizationDetail);
		 * 
		 * } //throw new
		 * ModelListenerException("One or more employee exists for this organization id ["
		 * +model.getOrganizationId()+"]."); }
		 * 
		 * 
		 */

		/*
		 * try { OrganizationDetail oldDetail =
		 * OrganizationDetailLocalServiceUtil.getOrganizationDetail(model.
		 * getOrganizationDetailId());
		 * EmployeeLocalServiceUtil.onOrganizationDetailBeforeUpdate(oldDetail, model);
		 * 
		 * } catch (PortalException e) { LOGGER.error(e); }
		 */
	}

}
