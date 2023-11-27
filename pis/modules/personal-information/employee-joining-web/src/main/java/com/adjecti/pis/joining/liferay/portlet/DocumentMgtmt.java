package com.adjecti.pis.joining.liferay.portlet;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.MimeTypesUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.portlet.ResourceRequest;

public class DocumentMgtmt {
	public static long fileUploadByApp(File file, ThemeDisplay themeDisplay, ResourceRequest resourceRequest) {
		String folderName = "EmployeeDocuments";
		// TODO if folder not available then create
		

		long groupId = themeDisplay.getScopeGroupId();

		long repositoryId = groupId;
		String mimeType = MimeTypesUtil.getContentType(file);
		String title = file.getName();
		String description = "This file is added programatically";
		String changeLog = "hi";//TODO to be identified
		Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
		FileEntry fileEntry = null;

		if (!isFolderExist(groupId, parentFolderId, folderName)) {
			createDLFolder(resourceRequest, themeDisplay.getUserId(), groupId, folderName, description);
		}

		try {
			
			Folder folder = DLAppServiceUtil.getFolder(groupId, parentFolderId, folderName);
			
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(),
					resourceRequest);
			InputStream is = new FileInputStream(file);

			fileEntry = DLAppServiceUtil.addFileEntry(repositoryId, folder.getFolderId(), file.getName(), mimeType,
					title, description, changeLog, is, file.length(), serviceContext);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileEntry.getFileEntryId();

	}
	
	private static void createDLFolder(ResourceRequest renderRequest, long userId, long groupId, String folderName,
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
			e1.printStackTrace();
		} catch (SystemException e1) {
			e1.printStackTrace();
		}
	}

	/*
	 * private static void createDLFolder(ActionRequest renderRequest, long userId,
	 * long groupId, String folderName, String description) { long repositoryId =
	 * groupId;// repository id is same as groupId boolean mountPoint = false; //
	 * mountPoint which is a boolean specifying whether the folder is a facade for
	 * // mounting a third-party repository long parentFolderId =
	 * DLFolderConstants.DEFAULT_PARENT_FOLDER_ID; // or 0 boolean hidden = false;
	 * // true if you want to hide the folder try { ServiceContext serviceContext =
	 * ServiceContextFactory.getInstance(DLFolder.class.getName(), renderRequest);
	 * DLFolderLocalServiceUtil.addFolder(userId, groupId, repositoryId, mountPoint,
	 * parentFolderId, folderName, description, hidden, serviceContext); } catch
	 * (PortalException e1) { e1.printStackTrace(); } catch (SystemException e1) {
	 * e1.printStackTrace(); } }
	 */

	private static boolean isFolderExist(long groupId, long parentFolderId, String folderName) {
		try {
			DLFolderLocalServiceUtil.getFolder(groupId, parentFolderId, folderName);
		} catch (PortalException e) {
			return false;
		}
		return true;
	}
}

