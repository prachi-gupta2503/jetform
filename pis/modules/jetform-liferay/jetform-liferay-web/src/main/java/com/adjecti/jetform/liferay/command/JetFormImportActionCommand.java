package com.adjecti.jetform.liferay.command;

import com.adjecti.jetform.liferay.constants.JetFormMVCPortletKeys;
import com.adjecti.jetform.liferay.service.JetFormBuilderLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + JetFormMVCPortletKeys.JETFORMMVC,
"mvc.command.name=importData" }, service = MVCActionCommand.class)

public class JetFormImportActionCommand extends BaseMVCActionCommand {
	private static final Log LOGGER = LogFactoryUtil.getLog(JetFormImportActionCommand.class.getName());
	
	@Reference
	JetFormBuilderLocalService jetFormBuilderLocalService;
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// TODO Auto-generated method stub
		process(actionRequest, actionResponse);

	}

	void process(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		LOGGER.info("Before calling process(ActionRequest actionRequest, ActionResponse actionResponse)");
		File file=getUploadedFile(actionRequest);
		
		importData(file, actionRequest);
		boolean save=ParamUtil.getBoolean(actionRequest, "save", false);
		if(save) {
			saveFile(actionRequest);
		}
	}

	public File getUploadedFile(ActionRequest actionRequest) {
		LOGGER.info("Before calling getUploadedFile(ActionRequest actionRequest)");
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);

		String fileName = uploadPortletRequest.getFileName("uploadedFile");
		File file = uploadPortletRequest.getFile("uploadedFile");
		String mimeType = uploadPortletRequest.getContentType("uploadedFile");
		String title = fileName;
		String description = "This file is added via programatically";
		
		LOGGER.info("Uploaded file :"+file.getAbsolutePath());
		
		return file;
	}

	private void saveFile(ActionRequest actionRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		/*uploadPortletRequest.getParameter("savePermanent");
		long repositoryId = themeDisplay.getScopeGroupId();
		System.out.println("Title=>" + title);
		try {
			Folder folder = getFolder(themeDisplay);
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(),
					actionRequest);
			InputStream is = new FileInputStream(file);
			DLAppServiceUtil.addFileEntry(repositoryId, folder.getFolderId(), fileName, mimeType, title, description,
					"", is, file.getTotalSpace(), serviceContext);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}*/
	}
	private void importData(File file, ActionRequest actionRequest) {
		String formClass=ParamUtil.getString(actionRequest, "formClass");
		jetFormBuilderLocalService.importData(formClass, file);
	}
	
}
