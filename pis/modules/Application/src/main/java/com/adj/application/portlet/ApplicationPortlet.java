package com.adj.application.portlet;

import com.adj.application.constants.ApplicationPortletKeys;
import com.adj.userportlet.model.UserPortlet;
import com.adj.userportlet.service.UserPortletLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.LayoutTypePortlet;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.audit.storage.model.AuditEvent;
import com.liferay.portal.security.audit.storage.service.AuditEventLocalServiceUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author adj_2
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Application", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp", "javax.portlet.name=" + ApplicationPortletKeys.APPLICATION,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class ApplicationPortlet extends MVCPortlet {
	private static final int noOfColumnsInDashboardLayout=20;

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		List<UserPortlet> userPortletList = UserPortletLocalServiceUtil.getUserPortlets(-1, -1);
		Map<String, String> portletNameAndThumbnailMap = new HashMap<>();
		for (UserPortlet userPortlet : userPortletList) {
			portletNameAndThumbnailMap.put(userPortlet.getPortletId(), userPortlet.getThumbnail());
		}
		List<String> userPortlets = userPortletList.stream().map(s -> s.getPortletId()).collect(Collectors.toList());

		Layout layout1;
		try {
			layout1 = LayoutLocalServiceUtil.getFriendlyURLLayout(themeDisplay.getScopeGroupId(), true,
					themeDisplay.getLayout().getFriendlyURL());

			List<String> portlets = new ArrayList<String>();
			for (int i = 1; i <= noOfColumnsInDashboardLayout; i++) {
				portlets.add(layout1.getTypeSettingsProperties().getProperty("column-" + i));
			}

			for (String portlet : portlets) {
				if (portlet != null) {
					/*
					 * int index = portlet.indexOf("_INSTANCE"); String s = portlet.substring(0,
					 * index);
					 */
					if (userPortlets.contains(portlet)) {
						userPortlets.remove(portlet);
					}
				}
			}
		} catch (PortalException e) {
			e.printStackTrace();
		}
		renderRequest.setAttribute("userPortlets", userPortlets);
		renderRequest.setAttribute("portletNameAndThumbnailMap", portletNameAndThumbnailMap);
		super.doView(renderRequest, renderResponse);

	}

	public void addPortlet(ActionRequest request, ActionResponse response) throws PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		String portletId = request.getParameter("porletId");
		long groupId = themeDisplay.getScopeGroupId();
		String friendlyURL = themeDisplay.getLayout().getFriendlyURL();
		boolean privateLayout = true;
		long userId = themeDisplay.getUserId();

		try {

			Layout layout = LayoutLocalServiceUtil.getFriendlyURLLayout(groupId, privateLayout, friendlyURL);
			LayoutTypePortlet layoutTypePortlet = (LayoutTypePortlet) layout.getLayoutType();
			for (int i = 1; i <= noOfColumnsInDashboardLayout; i++) {
				String column = layout.getTypeSettingsProperties().getProperty("column-"+i);
				if (column == null) {
					layoutTypePortlet.addPortletId(userId, portletId, "column-"+i, 1);
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

}