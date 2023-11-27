package net.ofb.comnet2.dashboard.mis.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import net.ofb.comnet2.dashboard.mis.constants.DashboardMisPortletKeys;

/**
 * @author Chinm
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.dashboard",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=DashboardMis",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + DashboardMisPortletKeys.DASHBOARDMIS,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class DashboardMisPortlet extends MVCPortlet {
}