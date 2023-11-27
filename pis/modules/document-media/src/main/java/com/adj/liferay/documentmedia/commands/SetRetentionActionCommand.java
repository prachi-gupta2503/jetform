package com.adj.liferay.documentmedia.commands;

import com.adj.liferay.documentmedia.constants.DocumentMediaPortletKeys;
import com.adj.liferay.documentmedia.constants.MVCCommandName;
import com.adj.liferay.documentmedia.portlet.DocumentMediaExpando;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
@Component(
	    immediate = true,
	    property = {
	    		"javax.portlet.name=" + DocumentMediaPortletKeys.DOCUMENTMEDIA,
	    		"mvc.command.name=" + MVCCommandName.SETRETENTION },
	    service = MVCActionCommand.class
	)
public class SetRetentionActionCommand extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		/* String optionValues=ParamUtil.getString(actionRequest, "radioOptions"); */
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		ServiceContext serviceContext=ServiceContextThreadLocal.getServiceContext();
		String columnName="Retention Value";
		String className = DLFileEntry.class.getName();
	    DocumentMediaExpando.addCustomField(actionRequest, themeDisplay, serviceContext, columnName, className);
	}

}
