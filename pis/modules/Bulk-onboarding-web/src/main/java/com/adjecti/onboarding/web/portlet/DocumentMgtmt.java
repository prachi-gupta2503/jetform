package com.adjecti.onboarding.web.portlet;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.MimeTypesUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import javax.portlet.ActionRequest;

import org.apache.commons.lang.math.RandomUtils;

public class DocumentMgtmt {
	private static Log LOGGER = LogFactoryUtil.getLog(DocumentMgtmt.class);
	public static long fileUploadByApp(File file, ThemeDisplay themeDisplay, ActionRequest renderRequest) {
		String folderName = "PisDocuments";
		LOGGER.info("Exist=>" + file.exists());

		long groupId = themeDisplay.getScopeGroupId();

		long repositoryId = groupId;
		String mimeType = MimeTypesUtil.getContentType(file);
		String title = file.getName();
		String description = "This file is added programatically";
		String changeLog = "hi";//TODO to be identified
		Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
		FileEntry fileEntry = null;

		if (!isFolderExist(groupId, parentFolderId, folderName)) {
			createDLFolder(renderRequest, themeDisplay.getUserId(), groupId, folderName, description);
		}

		try {
			Folder folder = DLAppServiceUtil.getFolder(groupId, parentFolderId, folderName);
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(),
					renderRequest);
			long rendomNum=RandomUtils.nextLong();
			String fileName = "bu_"+rendomNum +file.getName();
			InputStream is = new FileInputStream(file);
			
			
			fileEntry = DLAppServiceUtil.addFileEntry(repositoryId, folder.getFolderId(), fileName, mimeType,
					fileName, description, changeLog, is, file.length(), serviceContext);

		} catch (Exception e) {
			LOGGER.info("Exception");
			LOGGER.error(e);
		}
		return fileEntry.getFileEntryId();

	}

	private static void createDLFolder(ActionRequest renderRequest, long userId, long groupId, String folderName,
			String description) {
		long repositoryId = groupId;// repository id is same as groupId
		boolean mountPoint = false; // mountPoint which is a boolean specifying whether the folder is a facade for
									// mounting a third-party repository
		long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID; // or 0
		boolean hidden = false; // true if you want to hide the folder
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), renderRequest);
			DLFolderLocalServiceUtil.addFolder(userId, groupId, repositoryId, mountPoint, parentFolderId, folderName,
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

	public static String genrateDownloadLink(ThemeDisplay themeDisplay) throws PortalException {
		try {
		long groupId = themeDisplay.getScopeGroupId();

		long repositoryId = groupId;
		Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
		DLFolder dir = DLFolderLocalServiceUtil.getFolder(groupId, parentFolderId, "PisDocuments");
		  Folder folder =DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), dir.getFolderId(), "template"); 
		long parentId=dir.getFolderId();
		List<FileEntry> fileEntry =DLAppServiceUtil.getFileEntries(repositoryId, folder.getFolderId()); 
		LOGGER.info(fileEntry.get(0).getFileName());
		DLFileEntry file = getFile(fileEntry.get(0).getFileEntryId());
		 return  themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/"
				+ themeDisplay.getScopeGroupId() + "/" + file.getFolder().getFolderId() + "/"
				+ file.getTitle() + "/" + file.getUuid() + "?t=" + file.getFileEntryId()
				+ "&download=true";
		}catch (Exception e) {
			return "not found";
		}
	}
   
	private static DLFileEntry getFile(long fileEntryId) throws PortalException {
		return DLFileEntryLocalServiceUtil.getDLFileEntry(fileEntryId);
		
	}

}
