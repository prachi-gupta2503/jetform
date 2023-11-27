package com.adj.addpage.portlet;

import com.adj.addpage.constants.AddPagePortletKeys;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.layout.page.template.model.LayoutPageTemplateEntry;
import com.liferay.layout.page.template.service.LayoutPageTemplateEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.portal.kernel.model.LayoutPrototype;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.service.LayoutPrototypeLocalServiceUtil;
import com.liferay.portal.kernel.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

/**
 * @author adj_2
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=AddPage", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp", "javax.portlet.name=" + AddPagePortletKeys.ADDPAGE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class AddPagePortlet extends MVCPortlet {

	public void addPageAction(ActionRequest request, ActionResponse response) throws PortletException, PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();
		long userId = themeDisplay.getUserId();
		Layout layout = LayoutLocalServiceUtil.getLayoutByFriendlyURL(groupId, true, "/dashboard-template");

		try {
			String friendlyUrl = layout.getFriendlyURL(Locale.ENGLISH) + "_" + userId;
			String title = ParamUtil.getString(request, "title");
			String description = ParamUtil.getString(request, "description");
			ServiceContext serviceContext = new ServiceContext();
			Layout childLayout = LayoutLocalServiceUtil.addLayout(userId, groupId, true, layout.getLayoutId(),
					layout.getName(Locale.ENGLISH) + "_" + userId, title, description, LayoutConstants.TYPE_PORTLET,
					false, friendlyUrl, serviceContext);
			childLayout.setTypeSettings(layout.getTypeSettings());
			childLayout.setThemeId(layout.getThemeId());
			LayoutLocalServiceUtil.updateLayout(childLayout);
			long userRoleId = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), "Site Member").getRoleId();
			ResourcePermissionLocalServiceUtil.removeResourcePermission(themeDisplay.getCompanyId(),
					layout.getModelClassName(), ResourceConstants.SCOPE_INDIVIDUAL,
					String.valueOf(layout.getPrimaryKey()), userRoleId, ActionKeys.VIEW);
			request.setAttribute("status", "success");

		} catch (Exception e) {
			request.setAttribute("status", "failure");
			e.printStackTrace();
		}

	}
}