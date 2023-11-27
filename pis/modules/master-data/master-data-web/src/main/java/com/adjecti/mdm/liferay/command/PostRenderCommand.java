package com.adjecti.mdm.liferay.command;

import com.adjecti.mdm.liferay.constants.MDMPortletKeys;
import com.adjecti.mdm.liferay.service.PostOrganizationLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(property = { "javax.portlet.name=" + MDMPortletKeys.MDM,
		"mvc.command.name=editPost"}, service = MVCRenderCommand.class)


public class PostRenderCommand implements MVCRenderCommand {

	public final static String POST_EDIT_FORM = "/postEdit.jsp"; 
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
	
		long postId = ParamUtil.getLong(renderRequest, "postId");
		renderRequest.setAttribute("postId", postId);
		
		return POST_EDIT_FORM;
	}
	
	
	

}
