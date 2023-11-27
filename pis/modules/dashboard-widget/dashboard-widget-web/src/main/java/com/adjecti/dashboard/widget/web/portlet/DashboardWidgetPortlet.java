package com.adjecti.dashboard.widget.web.portlet;

import com.adjecti.dashboard.widget.model.DashboardWidget;
import com.adjecti.dashboard.widget.service.DashboardWidgetLocalServiceUtil;
import com.adjecti.dashboard.widget.web.constants.DashboardWidgetPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.LayoutTypePortlet;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author adj
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Dashboard Widget", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/dashboard-widget.jsp",
		"javax.portlet.name=" + DashboardWidgetPortletKeys.DASHBOARDWIDGET,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class DashboardWidgetPortlet extends MVCPortlet {
	private static final int noOfColumnsInDashboardLayout = 20;

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		List<DashboardWidget> allDashboardWidgets = DashboardWidgetLocalServiceUtil.getDashboardWidgets(-1, -1);
		CopyOnWriteArrayList<DashboardWidget> dashboardWidgets = new CopyOnWriteArrayList<DashboardWidget>();
		dashboardWidgets.addAll(allDashboardWidgets);
		List<String> widgetsAddedInPage = getPortletsAddedInThePage(themeDisplay);
		for (DashboardWidget dashboardWidget : dashboardWidgets) {
			for(String addedWidget:widgetsAddedInPage) {
				if(dashboardWidget.getPortletName().equals(addedWidget)) {
					dashboardWidgets.remove(dashboardWidget);
				}
			}
		}
		renderRequest.setAttribute("dashboardWidgets", dashboardWidgets);
		super.doView(renderRequest, renderResponse);
	}

	private List<String> getPortletsAddedInThePage(ThemeDisplay themeDisplay) {
		List<String> portlets = new ArrayList<String>();
		try {
			Layout layout = LayoutLocalServiceUtil.getFriendlyURLLayout(themeDisplay.getScopeGroupId(), true,
					themeDisplay.getLayout().getFriendlyURL());

			for (int i = 1; i <= noOfColumnsInDashboardLayout; i++) {
				portlets.add(layout.getTypeSettingsProperties().getProperty("column-" + i));
			}
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return portlets;
	}

	public void addWidgetToPage(ActionRequest request, ActionResponse response) throws PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		String portletId = request.getParameter("porletName");
		long groupId = themeDisplay.getScopeGroupId();
		String friendlyURL = themeDisplay.getLayout().getFriendlyURL();
		boolean privateLayout = true;
		long userId = themeDisplay.getUserId();

		try {

			Layout layout = LayoutLocalServiceUtil.getFriendlyURLLayout(groupId, privateLayout, friendlyURL);
			LayoutTypePortlet layoutTypePortlet = (LayoutTypePortlet) layout.getLayoutType();
			for (int i = 1; i <= noOfColumnsInDashboardLayout; i++) {
				String column = layout.getTypeSettingsProperties().getProperty("column-" + i);
				if (column == null) {
					layoutTypePortlet.addPortletId(userId, portletId, "column-" + i, 1);
					break;
				}
			}

			LayoutLocalServiceUtil.updateLayout(layout.getGroupId(), layout.getPrivateLayout(), layout.getLayoutId(),
					layout.getTypeSettings());
			request.setAttribute("isPortletAdded", true);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Override
		public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
				throws IOException, PortletException {
			String widgetName = resourceRequest.getParameter("widgetName");
			String portletId = widgetName.replaceFirst("portlet-topper-toolbar_", "");
			System.out.println("Widget Removed*******************"+portletId);
			
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long groupId = themeDisplay.getScopeGroupId();
			String friendlyURL = themeDisplay.getLayout().getFriendlyURL();
			boolean privateLayout = true;
			long userId = themeDisplay.getUserId();
	
			try {
				Layout layout = LayoutLocalServiceUtil.getFriendlyURLLayout(groupId, privateLayout, friendlyURL);
				LayoutTypePortlet layoutTypePortlet = (LayoutTypePortlet) layout.getLayoutType();
				layoutTypePortlet.removePortletId(userId, portletId);
				
				LayoutLocalServiceUtil.updateLayout(layout.getGroupId(), layout.getPrivateLayout(), layout.getLayoutId(),
						layout.getTypeSettings());
	
			} catch (Exception e) {
				e.printStackTrace();
			}
			super.serveResource(resourceRequest, resourceResponse);
		}
	
}