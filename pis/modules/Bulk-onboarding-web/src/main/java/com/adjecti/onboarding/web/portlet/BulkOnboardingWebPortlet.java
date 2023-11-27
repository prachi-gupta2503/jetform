package com.adjecti.onboarding.web.portlet;

import com.adjecti.onboarding.web.command.UploadOnboardingFileActionCommand;
import com.adjecti.onboarding.web.config.BulkOnboardingWebPortletConfig;
import com.adjecti.onboarding.web.constants.BulkOnboardingWebPortletKeys;
import com.adjecti.pis.dto.RegistrationRequestDTO;
import com.adjecti.pis.model.RegistrationRequest;
import com.adjecti.pis.service.RegistrationRequestLocalServiceUtil;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.lang.StringUtils;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

/**
 * @author adj
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.header-portlet-css=/css/select2.min.css", 
		"com.liferay.portlet.header-portlet-css=/css/jquery.dataTables.min.css",
		"com.liferay.portlet.header-portlet-css=/css/buttons.dataTables.min.css", 
		"com.liferay.portlet.header-portlet-css=/css/select.dataTables.min.css",
		"com.liferay.portlet.header-portlet-javascript=/js/jquery-ui.min.js",
		"com.liferay.portlet.header-portlet-javascript=/js/popper.min.js",
		"com.liferay.portlet.header-portlet-javascript=/js/handlebars.min.js",
		"com.liferay.portlet.header-portlet-javascript=/js/jquery.dataTables.min.js",
		"com.liferay.portlet.header-portlet-javascript=/js/dataTables.select.min.js",
		"com.liferay.portlet.header-portlet-javascript=/js/dataTables.buttons.min.js",
		"com.liferay.portlet.header-portlet-javascript=/js/dataTables.fixedColumns.min.js",
		"com.liferay.portlet.header-portlet-javascript=/js/select2.min.js",
		"com.liferay.portlet.header-portlet-javascript=/js/jetform-custom.js",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Bulk Onboarding Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + BulkOnboardingWebPortletKeys.BULKONBOARDINGWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class BulkOnboardingWebPortlet extends MVCPortlet {
	private static Log LOGGER = LogFactoryUtil.getLog(UploadOnboardingFileActionCommand.class);
	@Reference
	private RegistrationRequestHandler registrationRequestHandler;
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse ) 
			throws IOException, PortletException {
		LOGGER.info("***************BulkOnboardingWebPortlet:doView method ******************");
		LOGGER.debug("doView");
		
		String viewName = "/error.jsp";
		try {
			LOGGER.info("registrationRequestHandler"+  registrationRequestHandler.isAdmin());
			User user=PortalUtil.getUser(renderRequest);
			if(user == null) {
				viewName = "/error.jsp";
			}else if (registrationRequestHandler.isAdmin()) {
			    viewName = "/admin_report_view.jsp";
			}else if ( registrationRequestHandler.isUploader(user)) {
				viewName = "/report_view.jsp";
			}else if (registrationRequestHandler.isApprover(user)) {
				viewName = "/approver_view.jsp";
			}
		} catch (PortalException e) {
			LOGGER.error(e);
		}
		
		include(viewName, renderRequest, renderResponse);
	}

		
	@ProcessAction(name = "approve_registration")
	public void approveRegistration(ActionRequest request, ActionResponse response)
			throws IOException, PortletException {
		try {
			String action = ParamUtil.getString(request, "action");
			String remarks = ParamUtil.getString(request, "remarks");
			User user = PortalUtil.getUser(request);
			registrationRequestHandler.performWorkflowAction(ParamUtil.getLong(request, "requestId"),
					action, remarks, ParamUtil.getLong(request, "taskId"), user.getUserId());
			
			TimeUnit.SECONDS.sleep(10);
		} catch (Exception e) {
			throw new PortletException(e);
		}
	}

	public void selectedProcessed(ActionRequest request, ActionResponse response) throws IOException, PortletException {
		String[] requestIds = ParamUtil.getParameterValues(request, "selected-request");
		String remarks = ParamUtil.getString(request, "remarks","Action Remarks");
		
		String action = ParamUtil.getString(request, "action"); 
		
		try {
			User user = PortalUtil.getUser(request);

			registrationRequestHandler.performWorkflowAction(requestIds, action, remarks, user.getUserId());
			
			TimeUnit.SECONDS.sleep(5);
		} catch (PortalException e) {
			throw new PortletException(e);
		} catch (InterruptedException e) {
			
		}
	}

	public void findByStatus(ActionRequest request, ActionResponse response) throws IOException {
		String status = ParamUtil.getString(request, "status");
		List<RegistrationRequestDTO> filterRecords = registrationRequestHandler.findByStatus(status);
		request.setAttribute("filterRecords", filterRecords);
		request.setAttribute("currentState", status);
		response.sendRedirect("mvcPath", "/admin_view.jsp");
	}
	
	
	public void findByOrganization(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortalException {
		long organizationId = ParamUtil.getLong(actionRequest, "organizationId");
		User user = PortalUtil.getUser(actionRequest);
		List<RegistrationRequestDTO> filterRecords = RegistrationRequestLocalServiceUtil.findByUnitId(organizationId);
		actionRequest.setAttribute("currentOrganization", organizationId);
		actionRequest.setAttribute("filterRecords", filterRecords);
		actionResponse.sendRedirect("mvcPath", "/approver_view.jsp");
	}
	
	public void findByStatusAndOnboardingId(ActionRequest request, ActionResponse response) throws IOException {
		String status = ParamUtil.getString(request, "status");
	}

	public void processActionAll(ActionRequest request, ActionResponse response) throws IOException, PortletException {

		String action = ParamUtil.getString(request, "action");
		String remarks = ParamUtil.getString(request, "remarks");
		String[] stringValues = ParamUtil.getStringValues(request, "selected-request");
		for(String s:stringValues) {
			LOGGER.info(s);
		}
		try {
			User user = PortalUtil.getUser(request);
			int recordProcessed = registrationRequestHandler.processActionAll(action, remarks, user);

			if (recordProcessed == 0) {
				SessionErrors.add(request, "actionError");
			}

			TimeUnit.SECONDS.sleep(5);
		} catch (Exception e) {
			throw new PortletException(e);
		}
	}
	
	
	public void processActionAllById(ActionRequest request, ActionResponse response) throws IOException, PortletException {

		String action = ParamUtil.getString(request, "action");
		String remarks = " Action Remarks";
		long bulkOnbordingFileId = ParamUtil.getLong(request, "bulkOnbordingFileId");
		try {
			User user = PortalUtil.getUser(request);
			int recordProcessed = registrationRequestHandler.processActionAllById(action, remarks, bulkOnbordingFileId, user);

			if (recordProcessed == 0) {
				SessionErrors.add(request, "actionError");
			}
			TimeUnit.SECONDS.sleep(5);
		} catch (Exception e) {
			throw new PortletException(e);
		}
	}

	public void deleteRequest(ActionRequest request, ActionResponse response) throws IOException, PortletException {
		try {
			registrationRequestHandler.deleteRequest(ParamUtil.getLong(request, "requestId"));
		} catch (Exception e) {
			throw new PortletException(e);
		}
	}

	public void deleteAll(ActionRequest request, ActionResponse response) {
		try {
		
			User user = PortalUtil.getUser(request);
			
			long bulkOnbordingFileId = ParamUtil.getLong(request, "bulkOnbordingFileId");
			LOGGER.info("deleteAll - bulkOnbordingFileId - "+bulkOnbordingFileId);	
			registrationRequestHandler.deleteAll(user, bulkOnbordingFileId);
		
		} catch (PortalException e) {
			LOGGER.error(e);
		}
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException, IOException {
		long requestId = ParamUtil.getLong(resourceRequest, "requestId");
		String resource = ParamUtil.getString(resourceRequest, "resource");
		if (!resource.isEmpty() && resource.equalsIgnoreCase("registrationRequest") && requestId != 0) {

			resourceResponse.setContentType("application/json");
			PrintWriter out = resourceResponse.getWriter();
			String request = JSONFactoryUtil.looseSerialize(registrationRequestHandler.findByRequestId(requestId));
			out.write(request);
			out.flush();
		}
	}
	
	@ProcessAction(name = "get_record_actions")
	public void getRecordActions(ActionRequest request, ActionResponse response) {
		response.setRenderParameter("mvcPath", "/record_actions.jsp");
	}


	public void addRequest(ActionRequest request, ActionResponse response) {
		ServiceContext serviceContext=null;
		try {
			serviceContext=ServiceContextFactory.getInstance(request);
		} catch (PortalException e) {
			e.printStackTrace();
		}
		RegistrationRequest registrationRequest = registrationRequestHandler.addRegistrationRequest(getRegistrationRequestDTO(request), serviceContext);
		response.setRenderParameter("editFlag", "true");
		response.setRenderParameter("registrationId", Long.toString(registrationRequest.getRegistrationRequestId()));
		response.setRenderParameter("mvcPath", "/edit_entry.jsp");
	}

	public void updateRequest(ActionRequest request, ActionResponse response) throws PortalException, IOException {
		long registrationId = ParamUtil.getLong(request, "registrationId");
		ServiceContext serviceContext=null;
		try {
			serviceContext=ServiceContextFactory.getInstance(request);
		} catch (PortalException e) {
			e.printStackTrace();
		}
		registrationRequestHandler.updateRequest(getRegistrationRequestDTO(request), serviceContext);
		response.setRenderParameter("editFlag", "true");
		response.setRenderParameter("registrationId", Long.toString(registrationId));
		response.setRenderParameter("mvcPath", "/edit_entry.jsp");
		RegistrationRequest req=RegistrationRequestLocalServiceUtil.getRegistrationRequest(registrationId);
		if(StringUtils.isNotBlank(req.getErrorMessage())) {
			SessionErrors.add(request, "actionError");
		}
	}

	private RegistrationRequestDTO getRegistrationRequestDTO(ActionRequest request) {

		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		RegistrationRequestDTO registration = new RegistrationRequestDTO();
		registration.setRegistrationRequestId(ParamUtil.getLong(request, "registrationId"));
		registration.setUnit(ParamUtil.getString(request, "unit"));
		registration.setUnitId(ParamUtil.getLong(request, "unitId"));
		registration.setPersonalNo(ParamUtil.getLong(request, "personalNo"));
		registration.setRecordNo(ParamUtil.getLong(request, "recordNo"));
		registration.setFirstName(ParamUtil.getString(request, "firstName"));
		registration.setMiddleName(ParamUtil.getString(request, "middleName"));
		registration.setLastName(ParamUtil.getString(request, "lastName"));
		registration.setGenderName(ParamUtil.getString(request, "gender"));
		registration.setDesignationId(ParamUtil.getLong(request, "designation"));
		registration.setTradeId(ParamUtil.getLong(request, "trade"));
		registration.setGradeId(ParamUtil.getLong(request, "grade"));
		registration.setDateOfBirth(ParamUtil.getDate(request, "dateOfBirth", simpleDateFormat));
		registration.setDateOfJoiningOrganization(ParamUtil.getDate(request, "dateOfJoiningOrganization", simpleDateFormat));
		registration.setCastCategory(ParamUtil.getString(request, "casteCategory"));
		registration.setMobile(ParamUtil.getLong(request, "mobile"));
		registration.setEmailAddress(ParamUtil.getString(request, "emailAddress"));
		registration.setDateOfJoiningUnit(ParamUtil.getDate(request, "dateOfJoiningUnit", simpleDateFormat));
		registration.setGpfnpsType(ParamUtil.getString(request, "type"));
		registration.setGpfnpsNumber(ParamUtil.getLong(request, "type_number"));
		
		registration.setSectionId(ParamUtil.getLong(request, "section"));
		
		registration.setPostBox(ParamUtil.getString(request, "postBox"));
		
		registration.setRank(ParamUtil.getLong(request, "rank"));

		registration.setIdamUser(ParamUtil.getString(request, "is_idam").equalsIgnoreCase("true"));

		registration.setEmailAccess(ParamUtil.getString(request, "is_email_access").equalsIgnoreCase("true"));

		registration.setDigitalSigning(ParamUtil.getString(request, "is_digital_signing").equalsIgnoreCase("true"));

		registration.seteGovAccess(ParamUtil.getString(request, "is_egov_access").equalsIgnoreCase("true"));

		registration.setPisAccess(ParamUtil.getString(request, "is_pis_access").equalsIgnoreCase("true"));
		
		return registration;
	}
	
	public void backPage() {
		
	}
	
    @Activate
    @Modified
    protected void activate(Map<Object, Object> properties) {
    	bulkOnboardingWebPortletConfig = ConfigurableUtil.createConfigurable(
        		BulkOnboardingWebPortletConfig.class, properties);
    }

    private volatile BulkOnboardingWebPortletConfig bulkOnboardingWebPortletConfig;
}