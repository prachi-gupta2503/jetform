package com.adj.dm.portlet;

import com.liferay.portal.kernel.exception.PortalException;

import java.util.List;

import javax.portlet.RenderRequest;

public interface DocumentAndMediaHandler {
	public List<FileViewModel> getAllDocumentinfo(RenderRequest renderRequest) throws PortalException;
	
}
