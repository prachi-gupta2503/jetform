package com.adjecti.liferay.workarea.hierarchy.portlet;

import com.adjecti.liferay.workarea.hierarchy.constants.WorkAreaHierarchyChartPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author user
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=WorkAreaHierarchyChart",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + WorkAreaHierarchyChartPortletKeys.WORKAREAHIERARCHYCHART,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class WorkAreaHierarchyChartPortlet extends MVCPortlet {
}