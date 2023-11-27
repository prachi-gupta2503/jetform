package net.ofb.comnet2.dashboard.kms.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import net.ofb.comnet2.dashboard.kms.constants.DashboardKmsPortletKeys;

/**
 * @author Chinm
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.dashboard",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=DashboardKms",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + DashboardKmsPortletKeys.DASHBOARDKMS,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class DashboardKmsPortlet extends MVCPortlet {
}