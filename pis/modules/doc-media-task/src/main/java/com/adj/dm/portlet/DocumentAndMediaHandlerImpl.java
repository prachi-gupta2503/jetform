package com.adj.dm.portlet;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFileEntryMetadata;
import com.liferay.document.library.kernel.model.DLFileEntryType;
import com.liferay.document.library.kernel.model.DLFileVersion;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryMetadataLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryTypeLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.document.library.kernel.util.comparator.RepositoryModelTitleComparator;
import com.liferay.dynamic.data.mapping.kernel.DDMFormFieldValue;
import com.liferay.dynamic.data.mapping.kernel.DDMFormValues;
import com.liferay.dynamic.data.mapping.kernel.DDMStructure;
import com.liferay.dynamic.data.mapping.kernel.StorageEngineManagerUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.RenderRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component
public class DocumentAndMediaHandlerImpl implements DocumentAndMediaHandler {
	@Reference
	private DLAppService _dlAppService;
	
	

	public List<FileViewModel> getAllDocumentinfo(RenderRequest renderRequest) throws PortalException {
		String folderName="Downloads";
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();
		DLFolder folder=DLFolderLocalServiceUtil.getFolder(groupId, 0, folderName);
		List<DLFileEntry> fileEntries=new ArrayList<DLFileEntry>();
		updateFileList(folder.getFolderId(), fileEntries, groupId);
		List<FileViewModel> fileVMs = new ArrayList<FileViewModel>();
		for (DLFileEntry file : fileEntries) {
			FileViewModel fileVM = new FileViewModel();
			DLFileEntryType dlFileEntryType = DLFileEntryTypeLocalServiceUtil.getDLFileEntryType(
			DLFileEntryLocalServiceUtil.getFileEntry(file.getFileEntryId()).getFileEntryTypeId());
			User user=UserLocalServiceUtil.getUser(file.getUserId());
			List<Organization> orgList = OrganizationLocalServiceUtil.getUserOrganizations(user.getUserId());
			String orgName="";
			for(Organization org:orgList) {
				orgName=org.getName();
			}
			fileVM.setOrganizationName(orgName);
			fileVM.setDocumentType(dlFileEntryType.getName());
			fileVM.setDocumentName(file.getFileName());
			fileVM.setMetadata(getMetadata(dlFileEntryType, file));
			SimpleDateFormat dateFormatter=new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat timeFormatter=new SimpleDateFormat("HH:mm:ss");
			Date date=file.getModifiedDate();
			
			fileVM.setLastUpdatedDate(dateFormatter.format(date));
			fileVM.setLastUpdatedTime(timeFormatter.format(date));
			fileVM.setDocumentUrl(genrateDownloadLink(themeDisplay,file));
			fileVMs.add(fileVM);
			
		}
		return fileVMs;
	}

	private String genrateDownloadLink(ThemeDisplay themeDisplay, DLFileEntry file) throws PortalException {
		 return  themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/"
				+ themeDisplay.getScopeGroupId() + "/" + file.getFolder().getFolderId() + "/"
				+ file.getTitle() + "/" + file.getUuid() + "?t=" + file.getFileEntryId()
				+ "&download=true";
	}



	private Map<String, String> getMetadata(DLFileEntryType dlFileEntryType, DLFileEntry file) throws PortalException {
		List<DDMStructure> ddmStructures = dlFileEntryType.getDDMStructures();
		Map<String,String> metaFields=new HashMap<String, String>();
		if (ddmStructures.size() != 0) {

			for (DDMStructure ddmStructure : ddmStructures) {
				DLFileVersion dlFileVersion = DLFileEntryLocalServiceUtil.getDLFileEntry(file.getFileEntryId()).getFileVersion();
				DLFileEntryMetadata dlFileEntryMetadata = DLFileEntryMetadataLocalServiceUtil.getFileEntryMetadata(ddmStructure.getStructureId(), dlFileVersion.getFileVersionId());
				DDMFormValues ddmFormValues = StorageEngineManagerUtil.getDDMFormValues(dlFileEntryMetadata.getDDMStorageId());
				List<DDMFormFieldValue> list1 = ddmFormValues.getDDMFormFieldValues();

				for (DDMFormFieldValue ddmFormValue : list1) {
					metaFields.put(ddmFormValue.getName(),ddmFormValue.getValue().getString(Locale.ROOT));
				}

			}
		}
		return metaFields;
	}
	
	
	public void updateFileList(long folderId,List<DLFileEntry> fileList,long groupId) throws PortalException{
		fileList.addAll( getFiles(folderId,groupId));
		List<DLFolder> subFolders=DLFolderLocalServiceUtil.getFolders(groupId, folderId);
		for(DLFolder subFolder:subFolders) {
			updateFileList(subFolder.getFolderId(),fileList,groupId);
		}
	
	}

	private List<DLFileEntry> getFiles(long folderId, long groupId) throws PortalException {
		List<FileEntry> fileEntries = _dlAppService.getFileEntries(groupId, folderId, new String[] {}, QueryUtil.ALL_POS,QueryUtil.ALL_POS, new RepositoryModelTitleComparator<>());
		List<DLFileEntry> dlFileEntry=new ArrayList<DLFileEntry>();
		for(FileEntry entry:fileEntries) {
			if(!entry.isInTrash()) {
				dlFileEntry.add(DLFileEntryLocalServiceUtil.getDLFileEntry(entry.getFileEntryId()));
			}
		}
		return dlFileEntry;
		
		
	}
}
