package com.adjecti.liferay.workarea.hierarchy.command;

import com.adjecti.liferay.workarea.hierarchy.constants.MVCCommandNames;
import com.adjecti.liferay.workarea.hierarchy.constants.WorkAreaHierarchyChartPortletKeys;
import com.adjecti.mdm.liferay.model.WorkArea;
import com.adjecti.mdm.liferay.service.WorkAreaLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = {
		"javax.portlet.name=" + WorkAreaHierarchyChartPortletKeys.WORKAREAHIERARCHYCHART,
		"mvc.command.name=" + MVCCommandNames.WORKAREA_SEARCH }, service = MVCResourceCommand.class)
public class WorkAreaTreeResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		{
			Writer wtr = null;
			try {
				wtr = resourceResponse.getWriter();
			} catch (IOException e) {
				e.printStackTrace();
			}
			long parentId=ParamUtil.getLong(resourceRequest, "id", 0);
			List<WorkArea> parentWorkAreas = WorkAreaLocalServiceUtil.getWorkAreasByParentId(parentId);
			String request = JSONFactoryUtil.looseSerializeDeep(parentWorkAreas);
			try {
				wtr.write(request);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
