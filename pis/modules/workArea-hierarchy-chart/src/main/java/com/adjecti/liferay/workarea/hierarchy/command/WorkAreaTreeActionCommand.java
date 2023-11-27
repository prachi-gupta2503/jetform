package com.adjecti.liferay.workarea.hierarchy.command;

import com.adjecti.liferay.workarea.hierarchy.constants.MVCCommandNames;
import com.adjecti.liferay.workarea.hierarchy.constants.WorkAreaHierarchyChartPortletKeys;
import com.adjecti.mdm.liferay.service.WorkAreaLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		property = {
		"javax.portlet.name=" +WorkAreaHierarchyChartPortletKeys.WORKAREAHIERARCHYCHART,
		"mvc.command.name=" + MVCCommandNames.WORKAREA_ADD },
	service = MVCActionCommand.class)
public class WorkAreaTreeActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		long workAreaId =ParamUtil.getLong(actionRequest, "workAreaId");
		System.out.println(workAreaId+" : workAreaId");
		long parentId =ParamUtil.getLong(actionRequest, "parentId");
		String name=ParamUtil.getString(actionRequest, "name");
		long workAreaTypeId=ParamUtil.getLong(actionRequest, "workAreaTypeId");
		WorkAreaLocalServiceUtil.addWorkArea(workAreaId, parentId, name, workAreaTypeId);
		
	}

}
