package com.adj.liferay.documentmedia.commands;


import com.adj.liferay.documentmedia.constants.DocumentMediaPortletKeys;
import com.adj.liferay.documentmedia.constants.MVCCommandName;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.ParamUtil;
import java.io.IOException;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
@Component(
		immediate = true,
		property = {
		"javax.portlet.name=" + DocumentMediaPortletKeys.DOCUMENTMEDIA,
		"mvc.command.name=" + MVCCommandName.DOCUMENTMEDIA_DOWNLOAD },
	service = MVCResourceCommand.class)
public class DocumentMediaResourceCommand implements MVCResourceCommand{

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException {	
		try {
			downloadFileEntry(resourceRequest, resourceResponse);
		    } 
		catch (PortalException | IOException e) 
		   {
			e.printStackTrace();
		   }
		return false;
	}
	private void downloadFileEntry(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortalException {

		long fileEntryId = ParamUtil.getLong(resourceRequest, "downloadId");

		DLFileEntry fileEntry=DLFileEntryLocalServiceUtil.getFileEntry(fileEntryId);
		
		PortletResponseUtil.sendFile(
				resourceRequest, resourceResponse, fileEntry.getFileName(),
				fileEntry.getContentStream(), 0, fileEntry.getMimeType(),
				HttpHeaders.CONTENT_DISPOSITION_ATTACHMENT);
		}
	}


