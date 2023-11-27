package com.adjecti.onboarding.web.command;

import com.adjecti.onboarding.web.constants.BulkOnboardingWebPortletKeys;
import com.adjecti.onboarding.web.portlet.RegistrationRequestHandler;
import com.adjecti.pis.model.BulkOnbordingFile;
import com.adjecti.pis.model.RegistrationRequest;
import com.adjecti.pis.service.BulkOnbordingFileLocalServiceUtil;
import com.adjecti.pis.service.RegistrationRequestLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + BulkOnboardingWebPortletKeys.BULKONBOARDINGWEB, 
		"mvc.command.name=delete_all_records" }, service = MVCActionCommand.class)

public class BulkOnboardingDeleteAllRecordsActionCommand implements MVCActionCommand {
	private static Log LOGGER = LogFactoryUtil.getLog(BulkOnboardingDeleteAllRecordsActionCommand.class);
	@Reference
	private RegistrationRequestHandler registrationRequestHandler;

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {

		List<RegistrationRequest> registrationrequest = RegistrationRequestLocalServiceUtil.getRegistrationRequests(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		for (RegistrationRequest request : registrationrequest) {
			try {
				RegistrationRequestLocalServiceUtil.deleteRegistrationRequest(request.getRegistrationRequestId());
			} catch (PortalException e) {
				LOGGER.error(e);
			}
		}

		List<BulkOnbordingFile> bordinglist = BulkOnbordingFileLocalServiceUtil.getBulkOnbordingFiles(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		for (BulkOnbordingFile bulkonbording : bordinglist) {
			try {
				BulkOnbordingFileLocalServiceUtil.deleteBulkOnbordingFile(bulkonbording.getBulkOnbordingFileId());
			} catch (PortalException e) {
				LOGGER.error(e);
			}

		}
		LOGGER.info("delete all");
		return true;
	}

}
