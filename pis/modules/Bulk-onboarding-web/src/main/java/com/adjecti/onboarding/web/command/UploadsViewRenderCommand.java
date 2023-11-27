package com.adjecti.onboarding.web.command;

import com.adjecti.onboarding.web.constants.BulkOnboardingWebPortletKeys;
import com.adjecti.onboarding.web.dto.BulkOnboardingRecordDTO;
import com.adjecti.onboarding.web.portlet.helper.BulkOnboardingViewHelper;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.OrganizationServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(
		 property = {
		 "javax.portlet.name="+BulkOnboardingWebPortletKeys.BULKONBOARDINGWEB,
		 "mvc.command.name=uploads-view"
		 }, service = MVCRenderCommand.class
		 )
public class UploadsViewRenderCommand implements MVCRenderCommand{
	private static Log LOGGER = LogFactoryUtil.getLog(UploadOnboardingFileActionCommand.class);
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		LOGGER.info("UploadsViewRenderCommand.render()");
		long unitId = ParamUtil.getLong(renderRequest, "unitId");
		LOGGER.info("UnitId : "+unitId);
		try {
			User user=PortalUtil.getUser(renderRequest);
			List<BulkOnboardingRecordDTO> bulkOnboardingList = BulkOnboardingViewHelper.getBulkOnboardingRecordsByUnitId(user.getUserId(),unitId);
			LOGGER.info(bulkOnboardingList.toString());
			
			renderRequest.setAttribute("currentUnit", OrganizationServiceUtil.getOrganization(unitId));
			renderRequest.setAttribute("bulkOnboardingList", bulkOnboardingList);
		
		} catch (PortalException e) {
			LOGGER.error(e);
		}
		LOGGER.info("Printing the file Id : "+unitId);
		return "/uploads_view.jsp";
	}

}
