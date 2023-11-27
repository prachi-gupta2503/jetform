package com.adjecti.onboarding.web.command;

import com.adjecti.onboarding.web.constants.BulkOnboardingWebPortletKeys;
import com.adjecti.onboarding.web.portlet.helper.BulkOnboardingViewHelper;
import com.adjecti.pis.dto.RegistrationRequestDTO;
import com.adjecti.pis.dto.RegistrationRequestSearchParameter;
import com.adjecti.pis.service.RegistrationRequestLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(property = { "javax.portlet.name=" + BulkOnboardingWebPortletKeys.BULKONBOARDINGWEB,
		"mvc.command.name=view_registration_info" }, service = MVCRenderCommand.class)
public class RecordListViewRenderCommand implements MVCRenderCommand {
	
	private static Log LOGGER = LogFactoryUtil.getLog(RecordListViewRenderCommand.class);

	public final static String VIEW_REGISTRATION_INFO = "/record_list_view.jsp";
	public final static String ERROR = "/error.jsp";

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		LOGGER.info("in RecordListViewRenderCommand Command ");
		long bulkOnbordingFileId = ParamUtil.getLong(renderRequest, "bulkOnbordingFileId");
		String status = ParamUtil.getString(renderRequest, "status");
		String backURL =  ParamUtil.getString(renderRequest, "backURL");
		String search =  ParamUtil.getString(renderRequest, "search",null);;
			
		List<RegistrationRequestDTO> registrationRequestList = new ArrayList<RegistrationRequestDTO>();
		List<RegistrationRequestDTO> filterRegistrationRequestList = new ArrayList<RegistrationRequestDTO>();
		List<String> actions = new ArrayList<String>();
		
		try {
			if (status.equals("") || status == null) {
				filterRegistrationRequestList = RegistrationRequestLocalServiceUtil.getRegistrationRequestsByOnboardingId(bulkOnbordingFileId);
			} else {
				filterRegistrationRequestList = RegistrationRequestLocalServiceUtil.findByStatusAndOnboardingId(status,bulkOnbordingFileId);
			}
			
				registrationRequestList = RegistrationRequestLocalServiceUtil.getRegistrationRequestsByOnboardingId(bulkOnbordingFileId);

			if (null != registrationRequestList && registrationRequestList.size() > 0) {
				registrationRequestList.stream()
						.filter(request -> request.isAssignable())
						.map(request -> request.getActions())
						.collect(Collectors.toSet())
						.forEach(action -> actions.addAll(action.stream().map(actionName -> actionName).collect(Collectors.toList())));
				
				List<String> states = registrationRequestList.stream().map(request -> request.getStatus())
						.collect(Collectors.toSet()).stream().collect(Collectors.toList());
				
				renderRequest.setAttribute("states", states);
			}
			
			renderRequest.setAttribute("filterRecords", filterRegistrationRequestList);
			renderRequest.setAttribute("currentState", status);
			renderRequest.setAttribute("onboardingId", bulkOnbordingFileId);
			renderRequest.setAttribute("actions", actions);
			renderRequest.setAttribute("requestList", registrationRequestList);
			renderRequest.setAttribute("bulkOnbordingFileId", bulkOnbordingFileId);
			renderRequest.setAttribute("backURL", backURL);

		} catch (Exception e) {
			LOGGER.error(e);
			return ERROR;
		}
		LOGGER.info("************************** Return Test **************" +VIEW_REGISTRATION_INFO);
		return VIEW_REGISTRATION_INFO;
	}
	
	
	private List<RegistrationRequestDTO> resultBySearchParameter(RenderRequest renderRequest,
			RenderResponse renderResponse) throws PortletException {
		long designation = ParamUtil.getLong(renderRequest, "designation");
		long grade = ParamUtil.getLong(renderRequest, "grade");
		long trade = ParamUtil.getLong(renderRequest, "trade");
		long keyword = ParamUtil.getLong(renderRequest, "keywords");
		long status = ParamUtil.getLong(renderRequest, "status");
		RegistrationRequestSearchParameter searchParameter = new RegistrationRequestSearchParameter();
		searchParameter.setUnitIds(new long[] { 38218, 38482 });
		searchParameter.setGroupIds(new long[] { 38220 });
		searchParameter.setStatuses(new int[] { 1, 7 });
		searchParameter.setDesignationId(designation);
		searchParameter.setGradeId(grade);
		searchParameter.setTradeId(trade);
		BulkOnboardingViewHelper bulkOnboardingViewHelper = new BulkOnboardingViewHelper();
		List<RegistrationRequestDTO> registrationRequestList = null;
		try {
			registrationRequestList = bulkOnboardingViewHelper.findBySearch(searchParameter);
		} catch (PortalException e) {
			LOGGER.error(e);
		}
		return registrationRequestList;

	}
	
}
