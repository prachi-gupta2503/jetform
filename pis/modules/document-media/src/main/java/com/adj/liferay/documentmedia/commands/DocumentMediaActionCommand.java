package com.adj.liferay.documentmedia.commands;

import com.adj.liferay.documentmedia.constants.DocumentMediaPortletKeys;
import com.adj.liferay.documentmedia.constants.MVCCommandName;
import com.adj.liferay.documentmedia.portlet.DocumentMngmnt;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.File;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = { "javax.portlet.name=" + DocumentMediaPortletKeys.DOCUMENTMEDIA,
		"mvc.command.name=" + MVCCommandName.DOCUMENTMEDIA_ADD }, service = MVCActionCommand.class)
public class DocumentMediaActionCommand extends BaseMVCActionCommand {
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		File requestFile = null;
		requestFile = uploadRequest.getFile("document");
		long fileEntryId = DocumentMngmnt.uploadDocumentMedia(requestFile, actionRequest);
		System.out.println(fileEntryId);
	}

}
