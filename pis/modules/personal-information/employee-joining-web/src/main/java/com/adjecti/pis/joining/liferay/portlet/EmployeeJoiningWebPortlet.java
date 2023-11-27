package com.adjecti.pis.joining.liferay.portlet;

import com.adjecti.pis.joining.liferay.constants.EmployeeJoiningWebPortletKeys;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import com.adjecti.pis.joining.liferay.web.config.EmployeeViewConfiguration;

/**
 * @author jiten
 */
@Component(
		immediate = true,
		property = {
				"com.liferay.portlet.display-category=category.sample",
				"com.liferay.portlet.header-portlet-css=/css/main.css",
				"com.liferay.portlet.header-portlet-css=/css/select2.min.css",
				"com.liferay.portlet.header-portlet-css=/css/pis-custom.css",
				"com.liferay.portlet.header-portlet-css=/css/hrms-style.css",
				// "com.liferay.portlet.header-portlet-css=/fonts/font-awesome/css/font-awesome.min.css",
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
				"com.liferay.portlet.header-portlet-javascript=/js/jetform-custom.js", 
				"com.liferay.portlet.instanceable=true",
				"javax.portlet.display-name=EmployeeJoiningWeb",
				"javax.portlet.init-param.template-path=/",
				"javax.portlet.init-param.view-template=/view.jsp",
				"javax.portlet.name=" + EmployeeJoiningWebPortletKeys.EMPLOYEEJOININGWEB,
				"javax.portlet.resource-bundle=content.Language",
				"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
		)
public class EmployeeJoiningWebPortlet extends MVCPortlet {
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException{
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		UploadPortletRequest uploadRequest=PortalUtil.getUploadPortletRequest(resourceRequest);
		File requestFile = null;
		requestFile = uploadRequest.getFile("file");
		long fileEntryId = DocumentMgtmt.fileUploadByApp(requestFile, themeDisplay, resourceRequest);

		resourceResponse.setContentType("application/json");
		PrintWriter out = resourceResponse.getWriter();
		String request = JSONFactoryUtil.looseSerialize(fileEntryId);
		out.write(request);
		out.flush();
		super.serveResource(resourceRequest, resourceResponse);
	}


	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		renderRequest.setAttribute(EmployeeViewConfiguration.class.getName(), _employeeViewConfiguration);
		final String FOLDER_NAME = "PIS Documents";
		ServiceContext serviceContext=ServiceContextThreadLocal.getServiceContext();
		if(EmployeeJoiningWebPortletKeys.documentFolderId ==0) {
			try {
				EmployeeJoiningWebPortletKeys.documentFolderId = DLAppServiceUtil.getFolder(serviceContext.getScopeGroupId(), 0, FOLDER_NAME).getFolderId();
				EmployeeJoiningWebPortletKeys.documentRepositoryId = serviceContext.getScopeGroupId();
			} catch (Exception e) {
				//Do nothing
				//throw new PortletException("Document folder (Employee Joining) is not available");
			}
		}
		
		super.doView(renderRequest, renderResponse);
	}

	

	@Activate
	@Modified
	protected void activate(Map<Object, Object> properties) {
		_employeeViewConfiguration = ConfigurableUtil.createConfigurable(EmployeeViewConfiguration.class, properties);
	}
	public String getEmployeePortletView(Map labels) {
		return (String) labels.get(_employeeViewConfiguration.employeePortletView());
	}
	
	private volatile EmployeeViewConfiguration _employeeViewConfiguration;
}