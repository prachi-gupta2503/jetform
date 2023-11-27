package net.ofb.comnet2.dashboard.pis.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import net.ofb.comnet2.dashboard.pis.constants.DashboardPisPortletKeys;

/**
 * @author Chinm
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.dashboard",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=DashboardPis",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + DashboardPisPortletKeys.DASHBOARDPIS,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class DashboardPisPortlet extends MVCPortlet {
}