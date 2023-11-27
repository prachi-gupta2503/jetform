package com.adjecti.mdm.liferay.command;

import com.adjecti.mdm.liferay.constants.MDMPortletKeys;
import com.adjecti.mdm.liferay.dto.PostDTO;
import com.adjecti.mdm.liferay.handler.PostHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + MDMPortletKeys.MDM,
"mvc.command.name=addPost","mvc.command.name=deletePost","mvc.command.name=updatePost" }, service = MVCActionCommand.class)


public class PostActionCommand extends BaseMVCActionCommand{

	@Reference
	PostHandler postHandler;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String mvcActionCommand = ParamUtil.getString(actionRequest, "mvcActionCommand");

		if(mvcActionCommand.equalsIgnoreCase("updatePost"))
		{
			updatePost(actionRequest,actionResponse);	
		}
		else if(mvcActionCommand.equalsIgnoreCase("addPost"))
		{	
			addPost(actionRequest, actionResponse);
		}
		else if(mvcActionCommand.equalsIgnoreCase("deletePost"))
		{	
			deletePost(actionRequest,actionResponse);
		}
	}
	
	void addPost(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException
	{
		PostDTO postDTO = new PostDTO();
		postDTO.setCode(ParamUtil.getString(actionRequest, "code"));
		postDTO.setName_En(ParamUtil.getString(actionRequest, "name_En"));
		postDTO.setName_Hi(ParamUtil.getString(actionRequest, "name_Hi"));
		postDTO.setDesignationId(ParamUtil.getLong(actionRequest, "designationId"));
		postDTO.setPostBox(ParamUtil.getBoolean(actionRequest, "postBox"));
		postDTO.setDescription(ParamUtil.getString(actionRequest, "description"));
		postDTO.setOrganizationIds(ParamUtil.getLongValues(actionRequest, "organizationIds"));
		postHandler.addPost(postDTO);
	}
	
	void deletePost(ActionRequest actionRequest,ActionResponse actionResponse) throws PortalException
	{
		long postId = ParamUtil.getLong(actionRequest,"postId");
		postHandler.deletePost(postId);
	}
	
	void updatePost(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException
	{	
		PostDTO postDTO = new PostDTO();
		postDTO.setPostId(ParamUtil.getLong(actionRequest, "postId"));
		postDTO.setCode(ParamUtil.getString(actionRequest, "code"));
		postDTO.setName_En(ParamUtil.getString(actionRequest, "name_En"));
		postDTO.setName_Hi(ParamUtil.getString(actionRequest, "name_Hi"));
		postDTO.setDesignationId(ParamUtil.getLong(actionRequest, "designationId"));
		postDTO.setPostBox(ParamUtil.getBoolean(actionRequest, "postBox"));
		postDTO.setDescription(ParamUtil.getString(actionRequest, "description"));
		postDTO.setOrganizationIds(ParamUtil.getLongValues(actionRequest, "organizationIds"));
		postHandler.updatePost(postDTO);		
	}
}