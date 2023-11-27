package com.adj.liferay.documentmedia.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFileEntryConstants;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.expando.kernel.exception.NoSuchTableException;
import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.expando.kernel.model.ExpandoColumnConstants;
import com.liferay.expando.kernel.model.ExpandoTable;
import com.liferay.expando.kernel.model.ExpandoValue;
import com.liferay.expando.kernel.service.ExpandoColumnLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoRowLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoTableLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portlet.documentlibrary.util.DLAppUtil;
import java.io.File;
import javax.portlet.ActionRequest;

public class DocumentMngmnt {

	public static long uploadDocumentMedia(File file, ActionRequest actionRequest) {
		String folderName = "DocumentAndMedia";
		Long fileEntryTypeId=ParamUtil.getLong(actionRequest, "documentType");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();
		long repositoryId = groupId;
		String title=ParamUtil.getString(actionRequest,"title");
		String description=ParamUtil.getString(actionRequest, "subject");
		Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
		DLFileEntry dlFileEntry = null;
		long fileEntryId=ParamUtil.getLong(actionRequest,"fileEntryId");
		long classNameId = ClassNameLocalServiceUtil.getClassNameId(DLFileEntry.class.getName());
		ServiceContext serviceContext=ServiceContextThreadLocal.getServiceContext();
		String name = String.valueOf(CounterLocalServiceUtil.increment(DLFileEntry.class.getName()));
		if(fileEntryId > 0) {
			try {
				dlFileEntry=DLFileEntryLocalServiceUtil.getDLFileEntry(fileEntryId);
			} catch (PortalException e) {
				e.printStackTrace();
			}
		}
		else {
		 
        dlFileEntry=DLFileEntryLocalServiceUtil.createDLFileEntry(CounterLocalServiceUtil.increment(DLFileEntry.class.getName()));
		
		}

		if (!isFolderExist(groupId, parentFolderId, folderName)) {
			createDLFolder(actionRequest, themeDisplay.getUserId(), groupId, folderName, description);
		}

		try {
			System.out.println(ParamUtil.getLong(serviceContext, "classPK")+" : classPk");
			Folder folder = DLAppServiceUtil.getFolder(groupId, parentFolderId, folderName);
			      dlFileEntry.setName(name);
				  dlFileEntry.setUserId(themeDisplay.getUserId());
				  dlFileEntry.setGroupId(groupId);
				  dlFileEntry.setRepositoryId(repositoryId);
				  dlFileEntry.setFolderId(folder.getFolderId());
				  dlFileEntry.setFileName(file.getName());
				  dlFileEntry.setMimeType(MimeTypesUtil.getContentType(file)); 
				  dlFileEntry.setClassNameId(classNameId);
				  dlFileEntry.setTitle(title);
				  dlFileEntry.setDescription(description);
				  dlFileEntry.setFileEntryTypeId(fileEntryTypeId);
				  dlFileEntry.setSize(file.length());
				  dlFileEntry.setClassPK( ParamUtil.getLong(actionRequest, "organization"));
				  dlFileEntry.setUserName(themeDisplay.getUser().getFullName());
				  dlFileEntry.setExtension(DLAppUtil.getExtension(title, file.getName()));
				  dlFileEntry.setVersion(DLFileEntryConstants.VERSION_DEFAULT);
				  dlFileEntry.setTreePath(dlFileEntry.buildTreePath());
				  dlFileEntry= DLFileEntryLocalServiceUtil.updateDLFileEntry(dlFileEntry);
			      addCustomField(actionRequest,themeDisplay,serviceContext);
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dlFileEntry.getFileEntryId();

	}
	
	private static void createDLFolder(ActionRequest renderRequest, long userId, long groupId, String folderName,String description) {
			long repositoryId = groupId;
			boolean mountPoint = false; 
								
			long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
			boolean hidden = false;
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), renderRequest);
			DLFolderLocalServiceUtil.addFolder(userId, groupId, repositoryId, mountPoint, parentFolderId, folderName,description, hidden, serviceContext);
		    }
		catch (PortalException e1) {
			e1.printStackTrace();
		} catch (SystemException e1) {
			e1.printStackTrace();
		}
	}

	private static boolean isFolderExist(long groupId, long parentFolderId, String folderName) {
		try {
			DLFolderLocalServiceUtil.getFolder(groupId, parentFolderId, folderName);
		    }
		catch (PortalException e)
		     {
			return false;
		     }
	 return true;
	}
	
	private static void addCustomField(ActionRequest actionRequest,ThemeDisplay themeDisplay,ServiceContext serviceContext) throws PortalException {
		long companyId=themeDisplay.getCompanyId();
		String className = DLFileEntry.class.getName();
		String columnName = "OrganizationId";
		ExpandoTable expandoTable;
		try { 
			expandoTable = ExpandoTableLocalServiceUtil.getDefaultTable(companyId, className);
		} catch (NoSuchTableException e) {
			expandoTable = ExpandoTableLocalServiceUtil.addDefaultTable(companyId, className);
		}
		ExpandoColumn expandoColumn;
		expandoColumn = ExpandoColumnLocalServiceUtil.getColumn(expandoTable.getTableId(), columnName);
		if (expandoColumn==null){
			expandoColumn = ExpandoColumnLocalServiceUtil.addColumn(
					expandoTable.getTableId(), 
					columnName, 
					ExpandoColumnConstants.BOOLEAN);
		}
		long classNameId = ClassNameLocalServiceUtil.getClassNameId(DLFileEntry.class.getName());
//		ExpandoValueLocalServiceUtil.addValue(companyId, className, "CUSTOM_FIELDS", columnName, 0, ParamUtil.getString(actionRequest, "organization"));
	   ExpandoValueLocalServiceUtil.addValue(classNameId, expandoTable.getTableId(), ExpandoColumnLocalServiceUtil.getColumn(expandoTable.getTableId(), columnName).getColumnId(),ParamUtil.getLong(actionRequest, "organization"),ParamUtil.getString(actionRequest, "organization") );
	}
}

