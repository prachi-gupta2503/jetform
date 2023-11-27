package com.adjecti.onboarding.web.command;

import com.adj.xls.bind.ExcelUtils;
import com.adj.xls.option.PoijiOptions;
import com.adj.xls.option.PoijiOptions.PoijiOptionsBuilder;
import com.adjecti.mdm.liferay.model.OrganizationDetail;
import com.adjecti.mdm.liferay.service.OrganizationDetailLocalServiceUtil;
import com.adjecti.onboarding.web.constants.BulkOnboardingWebPortletKeys;
import com.adjecti.onboarding.web.dto.RegistrationRecord;
import com.adjecti.onboarding.web.portlet.DocumentMgtmt;
import com.adjecti.onboarding.web.portlet.RegistrationRequestHandler;
import com.adjecti.onboarding.web.util.OnboardingCsvFileParser;
import com.adjecti.pis.model.BulkOnbordingFile;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.apache.commons.collections.CollectionUtils;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(property = { "javax.portlet.name=" + BulkOnboardingWebPortletKeys.BULKONBOARDINGWEB,
		"mvc.command.name=ubload_onboarding_file" }, service = MVCActionCommand.class)
public class UploadOnboardingFileActionCommand extends BaseMVCActionCommand {
	
	private static Log LOGGER = LogFactoryUtil.getLog(UploadOnboardingFileActionCommand.class);
	
	private final int titleLenght = 75;	
	private final int remarkLenght = 75;
	
	@Reference
	private RegistrationRequestHandler registrationRequestHandler;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		LOGGER.debug("doProcessAction start");
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		ServiceContext serviceContext=null;
		try {
			serviceContext=ServiceContextFactory.getInstance(actionRequest);
		} catch (PortalException e) {
			LOGGER.error(e);
		}
		
		long userId = PortalUtil.getUserId(actionRequest);
		
		String title = ParamUtil.getString(actionRequest, "popUpFileTitle");
		String remark = ParamUtil.getString(actionRequest, "popUpFileRemark");
		
		if(!registrationRequestHandler.validateFieldLength(title, titleLenght)) {
			SessionErrors.add(actionRequest, "errorCharacterLength");
			return;
		}
		if(!registrationRequestHandler.validateFieldLength(remark, remarkLenght)) {
			SessionErrors.add(actionRequest, "errorCharacterLength");
			return;
		}

		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);

		File requestFile = uploadRequest.getFile("pisDocument");
		
		List<RegistrationRecord> recordList = null ;

		if(requestFile.getName().endsWith(".csv")) {
			LOGGER.info("CSV File");
			recordList = OnboardingCsvFileParser.parse(requestFile);
		}else{
			PoijiOptions options = PoijiOptionsBuilder.settings()
									.datePattern("dd-MM-yyyy")
									.build(); 
										//.preferNullOverDefault(true)
			recordList = ExcelUtils.fromExcel(requestFile, RegistrationRecord.class, options);
		}
		if (CollectionUtils.isEmpty(recordList)){
			throw new PortletException("No record to upload");
		}
		Set<String> orgList = recordList.stream().map(record -> record.getUnit()).collect(Collectors.toSet());
		
		if(CollectionUtils.isEmpty(orgList)) {
			SessionErrors.add(actionRequest, "organizationNotFound");
			return;
		}
		
		if(orgList.contains("") || orgList.contains(" ")) {
			throw new PortletException("errorInvalidRecords"); //Invalid records found in sheet.
		}
		
		if(orgList.size()>1) {
			SessionErrors.add(actionRequest, "errorUploadMultipleUnits");
			return;
		}
		
		
		String fileOrgCode = orgList.stream().findFirst().get().trim();
		long selectedUnit = ParamUtil.getLong(actionRequest, "organization");
		LOGGER.info("selectedUnit : "+selectedUnit);
		OrganizationDetail organizationDetail= OrganizationDetailLocalServiceUtil.getOrganizationDetailByOrganizationId(selectedUnit);
		LOGGER.info("organizationDetail : "+organizationDetail);
		LOGGER.info("getOrganizationCode : "+(organizationDetail!=null?organizationDetail.getOrganizationCode():""));
		LOGGER.info("fileOrgCode : "+fileOrgCode);
		
		if(organizationDetail == null || !fileOrgCode.equalsIgnoreCase(organizationDetail.getOrganizationCode())) {
			SessionErrors.add(actionRequest, "unitNotMatchError");
			return;
		}
		
		if (!registrationRequestHandler.canUploadUnitData(userId, selectedUnit)) {
			System.err.println("not valid unit.....");
			SessionErrors.add(actionRequest, "errorUpload");
			return;
		}
		
		for(RegistrationRecord rec :recordList) {
			if(rec.getDateOfBirth()==null) {
				actionRequest.setAttribute("dateError", "Invalid date format in &quot;Date Of Birth&quot; column in row number -"+(rec.getRowIndex()+1)+".<br/> Please ensure all the date values are provided in &quot;dd-mm-yyyy&quot; format.");
				SessionErrors.add(actionRequest, "errorDateFormat");
				return;
			}else if(rec.getDateOfJoiningUnit()==null) {
				actionRequest.setAttribute("dateError", "Invalid date format in &quot;Date Of Joining&quot; column in row number -"+(rec.getRowIndex()+1)+".<br/> Please ensure all the date values are provided in &quot;dd-mm-yyyy&quot; format.");
				SessionErrors.add(actionRequest, "errorDateFormat");
				return;
			}
		}
		
		if(!registrationRequestHandler.validateRecordList(recordList)) {
			SessionErrors.add(actionRequest, "errorCharacterLength");
			return;
		}

		long fileEntryId = DocumentMgtmt.fileUploadByApp(requestFile, themeDisplay, actionRequest);

		BulkOnbordingFile bulkOnbordingFile = registrationRequestHandler.saveFileDetails(organizationDetail.getOrganizationId(), fileEntryId,
				requestFile.getName(), title, remark, recordList.size());
		
		registrationRequestHandler.validateAndUploadDocument(organizationDetail, recordList, bulkOnbordingFile.getPrimaryKey(), serviceContext);
		
		SessionMessages.add(actionRequest, "successUpload");
		LOGGER.debug("doProcessAction end");
	}

}
