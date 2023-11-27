package com.adj.liferay.documentmedia.portlet;

import com.adj.liferay.documentmedia.constants.DocumentMediaPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
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
		"javax.portlet.display-name=DocumentMedia",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + DocumentMediaPortletKeys.DOCUMENTMEDIA,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class DocumentMediaPortlet extends MVCPortlet {
	
	public void addDocumentMedia(ActionRequest request,ActionResponse response) {
		System.out.println("inside addDocuments");
	}
}