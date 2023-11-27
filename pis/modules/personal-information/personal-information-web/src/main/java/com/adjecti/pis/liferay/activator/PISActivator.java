package com.adjecti.pis.liferay.activator;

import com.adjecti.common.util.FormEntityCache;
import com.adjecti.common.util.JetFormResourceCache;
import com.adjecti.jetform.liferay.activator.JetformActivator;
import com.adjecti.jetform.liferay.model.EntityWorkflow;
import com.adjecti.mdm.liferay.model.DeputationType;
import com.adjecti.mdm.liferay.model.OrganizationDetail;

import com.adjecti.pis.liferay.model.Address;
import com.adjecti.pis.liferay.model.Contact;
import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.liferay.model.EmployeeAddress;
import com.adjecti.pis.liferay.model.EmployeeBenefitScheme;
import com.adjecti.pis.liferay.model.EmployeeBiodata;
import com.adjecti.pis.liferay.model.EmployeeConfirmation;
import com.adjecti.pis.liferay.model.EmployeeContact;
import com.adjecti.pis.liferay.model.EmployeeDeputation;
import com.adjecti.pis.liferay.model.EmployeeDeputationRequest;
import com.adjecti.pis.liferay.model.EmployeeDsc;
import com.adjecti.pis.liferay.model.EmployeeExperience;
import com.adjecti.pis.liferay.model.EmployeeFamily;
import com.adjecti.pis.liferay.model.EmployeeJoining;
import com.adjecti.pis.liferay.model.EmployeeOrganization;
import com.adjecti.pis.liferay.model.EmployeePastExperience;
import com.adjecti.pis.liferay.model.EmployeePermission;
import com.adjecti.pis.liferay.model.EmployeePost;
import com.adjecti.pis.liferay.model.EmployeePromotion;
import com.adjecti.pis.liferay.model.EmployeePromotionRequest;
import com.adjecti.pis.liferay.model.EmployeeQualification;
import com.adjecti.pis.liferay.model.EmployeeReporting;
import com.adjecti.pis.liferay.model.EmployeeSeparationRequest;
import com.adjecti.pis.liferay.model.EmployeeTraining;
import com.adjecti.pis.liferay.model.EmployeeTransfer;
import com.adjecti.pis.liferay.model.EmployeeTransferRequest;
import com.adjecti.pis.liferay.model.EmployeeVerification;
import com.adjecti.pis.liferay.model.EmployeeWorkstation;
import com.adjecti.pis.liferay.model.IDAMFailedTransaction;
import com.adjecti.pis.liferay.model.JoiningProcess;
import com.adjecti.pis.liferay.model.JoiningProcessRequest;
import com.adjecti.pis.liferay.model.People;
import com.adjecti.pis.liferay.model.ProcessFile;
import com.adjecti.pis.liferay.model.ServiceRequest;
import com.adjecti.pis.liferay.model.SingleUserOnboarding;
import com.adjecti.pis.model.RegistrationRequest;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.model.Region;
import com.liferay.portal.kernel.util.PropsUtil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class PISActivator extends JetformActivator  implements BundleActivator  {

	public PISActivator() {
		log.info("pis-Activator");
		formDefinationPath = PropsUtil.get("jetform.formDefinition.location");
		formsLocation = PropsUtil.get("jetform.pisforms.location");
		registerFormEntity();
	}

	@Override
	public void registerFormEntity() {

		FormEntityCache.registerFormClass(People.class);
		FormEntityCache.registerFormClass(RegistrationRequest.class);
		FormEntityCache.registerFormClass(Employee.class);
		FormEntityCache.registerFormClass(EmployeePost.class);
		FormEntityCache.registerFormClass(JoiningProcessRequest.class);
		FormEntityCache.registerFormClass(com.liferay.portal.kernel.model.Address.class);
		FormEntityCache.registerFormClass(Country.class);
		FormEntityCache.registerFormClass(Region.class);
		FormEntityCache.registerFormClass(EmployeeDeputationRequest.class);
		FormEntityCache.registerFormClass(EmployeeSeparationRequest.class);
		FormEntityCache.registerFormClass(EmployeeTransferRequest.class);
		FormEntityCache.registerFormClass(EmployeePromotionRequest.class);
		FormEntityCache.registerFormClass(ServiceRequest.class);
		FormEntityCache.registerFormClass(EmployeeAddress.class);
		FormEntityCache.registerFormClass(OrganizationDetail.class);
		FormEntityCache.registerFormClass(EmployeeOrganization.class);
		FormEntityCache.registerFormClass(IDAMFailedTransaction.class);
		FormEntityCache.registerFormClass(EmployeeWorkstation.class);
		FormEntityCache.registerFormClass(EmployeeBenefitScheme.class);
		FormEntityCache.registerFormClass(EmployeeExperience.class);
		FormEntityCache.registerFormClass(EmployeeTraining.class);
		FormEntityCache.registerFormClass(EmployeeFamily.class);
		FormEntityCache.registerFormClass(EmployeeQualification.class);
		FormEntityCache.registerFormClass(EmployeeReporting.class);
		FormEntityCache.registerFormClass(EmployeeJoining.class);
		FormEntityCache.registerFormClass(EmployeeDeputation.class);
		FormEntityCache.registerFormClass(EmployeeConfirmation.class);
		FormEntityCache.registerFormClass(EmployeePastExperience.class);
		FormEntityCache.registerFormClass(EmployeePromotion.class);
		FormEntityCache.registerFormClass(EmployeeTransfer.class);
		FormEntityCache.registerFormClass(EmployeeVerification.class);
		FormEntityCache.registerFormClass(DeputationType.class);
		FormEntityCache.registerFormClass(Employee.class);
		FormEntityCache.registerFormClass(EmployeeContact.class);
		FormEntityCache.registerFormClass(EmployeeContact.class);
		FormEntityCache.registerFormClass(Contact.class);
		FormEntityCache.registerFormClass(EmployeeBiodata.class);
		FormEntityCache.registerFormClass(People.class);
		FormEntityCache.registerFormClass(Address.class);
		FormEntityCache.registerFormClass(ProcessFile.class);
		FormEntityCache.registerFormClass(SingleUserOnboarding.class);

		FormEntityCache.registerFormClass(EmployeePermission.class);
		// FormEntityCache.registerFormClass(TransferProcess.class);
		// FormEntityCache.registerFormClass(TransferProcessRequest.class);

		FormEntityCache.registerFormClass(EmployeePermission.class);
		FormEntityCache.registerFormClass(JoiningProcess.class);
		// FormEntityCache.registerFormClass(DeputationProcess.class);
		// FormEntityCache.registerFormClass(DeputationProcessRequest.class);

		FormEntityCache.registerFormClass(EmployeeDsc.class);
		FormEntityCache.registerFormClass(EntityWorkflow.class);
		FormEntityCache.registerFormClass(EntityWorkflow.class);

	}

	@Override
	public void stop(BundleContext context) throws Exception {
		log.info("Bundle stoped");
	}

	private Log log = LogFactoryUtil.getLog(this.getClass());

}
