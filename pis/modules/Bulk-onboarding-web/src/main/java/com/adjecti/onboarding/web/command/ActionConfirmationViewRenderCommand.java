package com.adjecti.onboarding.web.command;


import com.adjecti.onboarding.web.constants.BulkOnboardingWebPortletKeys;
import com.adjecti.onboarding.web.portlet.RegistrationRequestHandler;
import com.adjecti.onboarding.web.portlet.helper.BulkOnboardingViewHelper;
import com.adjecti.pis.dto.RegistrationRequestDTO;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.lang.StringUtils;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		 property = {
		 "javax.portlet.name="+BulkOnboardingWebPortletKeys.BULKONBOARDINGWEB,
		 "mvc.command.name=action_confirmation_view"
		 }, service = MVCRenderCommand.class
		 )
public class ActionConfirmationViewRenderCommand implements MVCRenderCommand {
	public final static String VIEW_ACTION_PERFORM ="/action_perform.jsp";
	public final static String ERROR="/error.jsp";
	private static Log LOGGER = LogFactoryUtil.getLog(ActionConfirmationViewRenderCommand.class);
	 @Reference
	 private RegistrationRequestHandler registrationRequestHandler;
	 @Override
	 public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		 try {
			 	User user=PortalUtil.getUser(renderRequest);
			 	String currentAction = ParamUtil.getString(renderRequest, "action");
			 	long bulkOnbordingFileId = ParamUtil.getLong(renderRequest, "bulkOnbordingFileId",0);
				List<RegistrationRequestDTO> registrationRequestList = new ArrayList<RegistrationRequestDTO>();
				List<RegistrationRequestDTO> requestList = new ArrayList<RegistrationRequestDTO>();
								
				if(registrationRequestHandler.isApprover(user)) {
					registrationRequestList = BulkOnboardingViewHelper.getRegistrationRequestList(user);
					for(RegistrationRequestDTO requestDTO : registrationRequestList) {
						if(requestDTO.getStatus().equalsIgnoreCase("APPROVAL PENDING")) {
							requestList.add(requestDTO);
						}
					}
				}else if((registrationRequestHandler.isAdmin(user) || registrationRequestHandler.isUploader(user)) && bulkOnbordingFileId > 0) {
					registrationRequestList = registrationRequestHandler.findByStatusAndOnboardingId("", bulkOnbordingFileId);
					for(RegistrationRequestDTO requestDTO : registrationRequestList) {
						if(StringUtils.isEmpty(requestDTO.getErrorMessage()) && requestDTO.getStatus().equalsIgnoreCase("PENDING") ) {		
							requestList.add(requestDTO);
						}
					}
				}
										
				List<String> states = registrationRequestList.stream().map(request -> request.getStatus())
							.collect(Collectors.toSet()).stream().collect(Collectors.toList());

				renderRequest.setAttribute("states", states);
				
				renderRequest.setAttribute("bulkOnbordingFileId",bulkOnbordingFileId);
				renderRequest.setAttribute("currentAction", currentAction);
				renderRequest.setAttribute("requestList", requestList);
		 }catch(Exception e){
			 LOGGER.error("Error in loading -"+e.getMessage());
			 return ERROR;
		 }
		 
		 return VIEW_ACTION_PERFORM;
	 }
	
}
