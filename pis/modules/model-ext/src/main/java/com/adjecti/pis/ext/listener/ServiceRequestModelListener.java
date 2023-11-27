package com.adjecti.pis.ext.listener;

import com.adjecti.mdm.liferay.service.ServiceRequestTypeLocalServiceUtil;
import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.liferay.model.JoiningProcess;
import com.adjecti.pis.liferay.model.ServiceRequest;
import com.adjecti.pis.liferay.notification.PISNotificationUtil;
import com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil;
import com.adjecti.pis.liferay.service.JoiningProcessLocalServiceUtil;
import com.adjecti.pis.liferay.util.PISUserUtil;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.PropsUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;

/*@Component(immediate = true, service = ModelListener.class)*/
public class ServiceRequestModelListener extends BaseModelListener<ServiceRequest> {

	final static Log LOGGER = LogFactoryUtil.getLog(ServiceRequestModelListener.class.getName());

	@Override
	public void onAfterCreate(ServiceRequest model) throws ModelListenerException {
		LOGGER.info("*********** ServiceRequestEntityListener:onAfterCreatr:onAfterCreate");

		//sendNotificationToApprover(model);
	}

	@Override
	public void onAfterUpdate(ServiceRequest model) throws ModelListenerException {
		LOGGER.info("*********** ServiceRequestEntityListener:onAfterUpdate:onAfterUpdate");

		
		
		 JoiningProcess joiningProcess = null; 
		 try { 
			 joiningProcess =JoiningProcessLocalServiceUtil.getJoiningProcess(model.getJoiningProcessId()); 
			 joiningProcess.setProcessStatus(model.getStatus()); 
			 String reason = model.getStatus() == 4 ? model.getComments():""; 
			 joiningProcess.setReason(reason);
		  JoiningProcessLocalServiceUtil.updateJoiningProcess(joiningProcess);
		  }
		  catch(PortalException e) { }
		 
		 

		/*
		 * if (model.getStatus() == 1) { sendNotificationToApprover(model); } else {
		 * 
		 * sendNotificationToUser(model); }
		 */
	}

	@Override
	public void onAfterAddAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {

	}

	@Override
	public void onAfterRemove(ServiceRequest model) throws ModelListenerException {

	}

	@Override
	public void onAfterRemoveAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {

	}

	@Override
	public void onBeforeCreate(ServiceRequest model) throws ModelListenerException {

	}

	@Override
	public void onBeforeRemove(ServiceRequest model) throws ModelListenerException {

	}

	@Override
	public void onBeforeRemoveAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {

	}

	@Override
	public void onBeforeUpdate(ServiceRequest model) throws ModelListenerException {

	}

	public void sendNotificationToApprover(ServiceRequest serviceRequest) {

		List<User> approvers = UserLocalServiceUtil.getUsers(-1, -1).stream().filter(u -> {
			try {
				return PISUserUtil.isApprover(u.getUserId());

			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}).collect(Collectors.toList());

		List<User> organizationApprovers = new ArrayList<>();
		Employee employee = null;

		try {
			employee = EmployeeLocalServiceUtil.getEmployeeByEmployeeId(serviceRequest.getEmployeeId());

			if (employee != null) {

				for (User u : approvers) {
					List<Organization> organizations = new ArrayList<Organization>();
					try {
						organizations = u.getOrganizations();

					} catch (Exception e) {
						e.printStackTrace();
					}
					for (Organization organization : organizations) {
						if (organization.getOrganizationId() == employee.getOrganizationId()) {
							organizationApprovers.add(u);

						}

					}
				}

				String serviceRequestType = ServiceRequestTypeLocalServiceUtil
						.getServiceRequestType(serviceRequest.getServiceRequestTypeId()).getName();
				String notificationMassge = "One Service Request for " + serviceRequestType + " assign to you";
				PISNotificationUtil.sendNotificationToApprovers(organizationApprovers, notificationMassge);
			}

		} catch (Exception e) {
			LOGGER.error(e);
		}

	}

	public void sendNotificationToUser(ServiceRequest serviceRequest) {

		Map<Integer, String> status = new HashMap<>();
		status.put(2, "approved");
		status.put(3, "rejected");
		status.put(4, "returned");

		Employee employee = null;
		User user = null;
		String serviceRequestType = "";
		try {
			employee = EmployeeLocalServiceUtil.getEmployeeByEmployeeId(serviceRequest.getEmployeeId());
			if (employee != null) {
				user = UserLocalServiceUtil.getUserByEmailAddress(employee.getCompanyId(), employee.getEmailId());
				if (user != null) {
					serviceRequestType = ServiceRequestTypeLocalServiceUtil.getServiceRequestType(serviceRequest.getServiceRequestTypeId()).getName();

					String notificationMassge = "Approver has " + status.get(serviceRequest.getStatus()) + " your Service Request for " + serviceRequestType;
					PISNotificationUtil.sendNotificationToUser(user, notificationMassge);
				}
			}
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

}