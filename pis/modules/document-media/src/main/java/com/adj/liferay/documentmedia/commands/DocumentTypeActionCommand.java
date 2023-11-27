package com.adj.liferay.documentmedia.commands;

import com.adj.liferay.documentmedia.constants.DocumentMediaPortletKeys;
import com.adj.liferay.documentmedia.constants.MVCCommandName;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

@Component(
	    immediate = true,
	    property = {
	    		"javax.portlet.name=" + DocumentMediaPortletKeys.DOCUMENTMEDIA,
	    		"mvc.command.name=" + MVCCommandName.DOCUMENTTYPE_ADD },
	    service = MVCActionCommand.class
	)
public class DocumentTypeActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		System.out.println("inside document type action command");
		
	}

}
