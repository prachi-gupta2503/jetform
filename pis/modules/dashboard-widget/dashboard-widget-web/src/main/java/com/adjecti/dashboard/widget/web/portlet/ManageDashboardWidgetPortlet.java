package com.adjecti.dashboard.widget.web.portlet;

import com.adjecti.dashboard.widget.web.constants.DashboardWidgetPortletKeys;
import com.adjecti.jetform.liferay.service.JetFormBuilderLocalService;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author adj
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.header-portlet-css=/css/select2.min.css",
		"com.liferay.portlet.header-portlet-css=/css/multistep.form.css",
		"com.liferay.portlet.header-portlet-css=/css/master.data.css",
		"com.liferay.portlet.header-portlet-css=/css/pis-custom.css",
		"com.liferay.portlet.header-portlet-css=/css/hrms-style.css",
		"com.liferay.portlet.header-portlet-css=/fonts/font-awesome/css/font-awesome.min.css",
		"com.liferay.portlet.header-portlet-css=/css/jquery.dataTables.min.css",
		"com.liferay.portlet.header-portlet-css=/css/buttons.dataTables.min.css",
		"com.liferay.portlet.header-portlet-css=/css/select.dataTables.min.css",
		// "com.liferay.portlet.header-portlet-javascript=/js/jquery-3.5.1.min.js",
		"com.liferay.portlet.header-portlet-javascript=/js/jquery-ui.min.js",
		"com.liferay.portlet.header-portlet-javascript=/js/popper.min.js",
		"com.liferay.portlet.header-portlet-javascript=/js/handlebars.min.js",
		"com.liferay.portlet.header-portlet-javascript=/js/jquery.dataTables.min.js",
		"com.liferay.portlet.header-portlet-javascript=/js/dataTables.select.min.js",
		"com.liferay.portlet.header-portlet-javascript=/js/dataTables.buttons.min.js",
		"com.liferay.portlet.header-portlet-javascript=/js/select2.min.js",
		"com.liferay.portlet.header-portlet-javascript=/js/multistep.form.js",
		"com.liferay.portlet.header-portlet-javascript=/js/jetform-custom.js", 
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Manage Dashboard Widgets",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/manage-dashboard-widget.jsp",
		"javax.portlet.name=" + DashboardWidgetPortletKeys.MANAGEDASHBOARDWIDGET,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ManageDashboardWidgetPortlet extends MVCPortlet {
	
	@Reference
	JetFormBuilderLocalService jetFormBuilderLocalService;
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		renderRequest.setAttribute("jetFormBuilderLocalService", jetFormBuilderLocalService);
		super.doView(renderRequest, renderResponse);

	}

	
}