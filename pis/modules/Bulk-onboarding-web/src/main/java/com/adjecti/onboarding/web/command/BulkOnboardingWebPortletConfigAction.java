package com.adjecti.onboarding.web.command;
import com.adjecti.onboarding.web.config.BulkOnboardingWebPortletConfig;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;
@Component(
		configurationPid="com.adjecti.onboarding.web.config.BulkOnboardingWebPortletConfig",
		configurationPolicy=ConfigurationPolicy.OPTIONAL,
		immediate=true,
		property= {
				"javax.portlet.name=com_adjecti_onboarding_web_BulkOnboardingWebPortlet",
		},
		service=ConfigurationAction.class
	)
public class BulkOnboardingWebPortletConfigAction extends DefaultConfigurationAction{
	private static Log LOGGER = LogFactoryUtil.getLog(BulkOnboardingWebPortletConfigAction.class);
	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		uploadFile(uploadPortletRequest, actionRequest);
		super.processAction(portletConfig, actionRequest, actionResponse);
	}
	public void uploadFile(UploadPortletRequest uploadPortletRequest,ActionRequest actionRequest) throws PortalException {
		String folderName ="template";
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();

		long repositoryId = groupId;
		String mimeType = MimeTypesUtil.getContentType(uploadPortletRequest.getFileName("uploadFile"));
		String title = uploadPortletRequest.getFileName("uploadFile");
		String description = "This file is added programatically";
		String changeLog = "hi";//TODO to be identified
		Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
		
		DLFolder dir = DLFolderLocalServiceUtil.getFolder(groupId, parentFolderId, "PisDocuments");
		
		long parentId=dir.getFolderId();
		FileEntry fileEntry = null;
		if (!isFolderExist(groupId, parentId, folderName)) {
			createDLFolder(actionRequest, themeDisplay.getUserId(), groupId, folderName, description,parentId);
		}
		try {
			Folder folder = DLAppServiceUtil.getFolder(groupId, parentId, folderName);
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(),
					actionRequest);
			
			String fileName = uploadPortletRequest.getFileName("uploadFile");
			File file=uploadPortletRequest.getFile("uploadFile");
			InputStream is = new FileInputStream(file);
			
			
			fileEntry = DLAppServiceUtil.addFileEntry(repositoryId, folder.getFolderId(), fileName, mimeType,
					fileName, description, changeLog, is, file.length(), serviceContext);
		} catch (Exception e) {
			LOGGER.error(e);
		}

	}
	@Override
	public void include(PortletConfig portletConfig, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
		
		httpServletRequest.setAttribute(BulkOnboardingWebPortletConfig.class.getName(),bulkOnboardingWebPortletConfig);
		super.include(portletConfig, httpServletRequest, httpServletResponse);
		
	}	
	@Activate
    @Modified
    protected void activate(Map<Object, Object> properties) {
		bulkOnboardingWebPortletConfig = ConfigurableUtil.createConfigurable(
				BulkOnboardingWebPortletConfig.class, properties);
    }
	
	
	private static void createDLFolder(ActionRequest renderRequest, long userId, long groupId, String folderName,
			String description,long flderid) {
		long repositoryId = groupId;
		boolean mountPoint = false; 
		boolean hidden = false;
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), renderRequest);
			DLFolderLocalServiceUtil.addFolder(userId, groupId, repositoryId, mountPoint, flderid, folderName,
					description, hidden, serviceContext);
		} catch (PortalException e1) {
			LOGGER.error(e1);
		} catch (SystemException e1) {
			LOGGER.error(e1);
		}
	}

	private static boolean isFolderExist(long groupId, long parentFolderId, String folderName) {
		try {
			DLFolderLocalServiceUtil.getFolder(groupId, parentFolderId, folderName);
		} catch (PortalException e) {
			return false;
		}
		return true;
	}

	private volatile BulkOnboardingWebPortletConfig bulkOnboardingWebPortletConfig;
}
