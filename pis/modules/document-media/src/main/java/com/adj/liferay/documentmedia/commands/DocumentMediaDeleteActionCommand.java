package com.adj.liferay.documentmedia.commands;

import com.adj.liferay.documentmedia.constants.DocumentMediaPortletKeys;
import com.adj.liferay.documentmedia.constants.MVCCommandName;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLTrashService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.TrashedModel;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.repository.capabilities.TrashCapability;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.HashMapBuilder;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	    immediate = true,
	    property = {
	    		"javax.portlet.name=" + DocumentMediaPortletKeys.DOCUMENTMEDIA,
	    		"mvc.command.name=" + MVCCommandName.DOCUMENTMEDIA_DELETE },
	    service = MVCActionCommand.class
	    )
public class DocumentMediaDeleteActionCommand extends BaseMVCActionCommand{

	@Reference
	private DLAppService _dlAppService;
	@Reference
	private DLTrashService _dlTrashService;
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
//		System.out.println(ParamUtil.getLong(actionRequest, "deleteId"));
//		DLFileEntry dlFileEntry=DLFileEntryLocalServiceUtil.createDLFileEntry(ParamUtil.getLong(actionRequest, "deleteId"));
//		DLFileEntryLocalServiceUtil.deleteDLFileEntry(dlFileEntry);
		_deleteFileEntry(actionRequest,false);
	}
	private void _deleteFileEntry(
				ActionRequest actionRequest, boolean moveToTrash)
			throws PortalException {

			long fileEntryId = ParamUtil.getLong(actionRequest, "fileEntryId");

			if (fileEntryId == 0) {
				return;
			}

			String version = ParamUtil.getString(actionRequest, "version");

			if (Validator.isNotNull(version)) {
				_dlAppService.deleteFileVersion(fileEntryId, version);

				return;
			}

			if (!moveToTrash) {
				_dlAppService.deleteFileEntry(fileEntryId);

				return;
			}

			FileEntry fileEntry = _dlAppService.getFileEntry(fileEntryId);

			if (!fileEntry.isRepositoryCapabilityProvided(TrashCapability.class)) {
				hideDefaultSuccessMessage(actionRequest);

				return;
			}

			fileEntry = _dlTrashService.moveFileEntryToTrash(fileEntryId);

			addDeleteSuccessData(
				actionRequest,
				HashMapBuilder.<String, Object>put(
					"trashedModels",
					ListUtil.fromArray((TrashedModel)fileEntry.getModel())
				).build());
		}
	}


