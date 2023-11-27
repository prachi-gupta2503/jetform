package com.adjecti.pis.liferay.portlet;

import com.adjecti.pis.liferay.config.PISMVCPortletConfig;
import com.adjecti.pis.liferay.constants.PISMVCPortletKeys;
import com.adjecti.pis.liferay.web.helper.DocumentUploadHelper;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
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

/**
 * @author arjun
 */
@Component(immediate = true, configurationPid = "com.adjecti.pis.liferay.web.config.PISPortletViewConfig", 
property = { "com.liferay.portlet.display-category=category.sample",
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
		"javax.portlet.display-name=PIS Portlet", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp", "javax.portlet.name=" + PISMVCPortletKeys.PISMVC,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)

public class PISMVCPortlet extends MVCPortlet {
	final static Log LOGGER = LogFactoryUtil.getLog(PISMVCPortlet.class.getName());

	/*
	 * @Reference JetFormBuilderLocalService jetFormBuilderLocalService;
	 */
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		// TODO Auto-generated method stub
		// LOGGER.info("Calling JetFormMVCPortlet render()");
		// LOGGER.info("Calling JetFormMVCPortlet render()-1");
		// HttpServletRequest
		// hsRequest=PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		//renderRequest.setAttribute("jetFormBuilderLocalService", jetFormBuilderLocalService);

		/*
		 * Enumeration<String> en= hsRequest.getParameterNames();
		 * while(en.hasMoreElements()){ String param=en.nextElement();
		 * LOGGER.info("param    :"+param+"  # value = ["+hsRequest.getParameter(param)+
		 * "]"); renderRequest.setAttribute(param, hsRequest.getParameter(param)); }
		 */
		
		super.render(renderRequest, renderResponse);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		// TODO Auto-generated method stub

		System.out.println("hello");
		LOGGER.info("doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
		File requestFile = null;
		requestFile = uploadRequest.getFile("file");
		long fileEntryId = DocumentUploadHelper.fileUploadByApp(requestFile, themeDisplay, resourceRequest);

		resourceResponse.setContentType("application/json");
		PrintWriter out;
		try {
			out = resourceResponse.getWriter();
			String request = JSONFactoryUtil.looseSerialize(fileEntryId);
			System.out.println(request);
			LOGGER.info(request);
			out.write(request);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Activate
	@Modified
	protected void activate(Map<Object, Object> properties) {
		_pisPortletConfig = ConfigurableUtil.createConfigurable(PISMVCPortletConfig.class, properties);
	}

	public String getPortletView(Map labels) {
		return (String) labels.get(_pisPortletConfig.portletView());
	}

	private volatile PISMVCPortletConfig _pisPortletConfig;
}