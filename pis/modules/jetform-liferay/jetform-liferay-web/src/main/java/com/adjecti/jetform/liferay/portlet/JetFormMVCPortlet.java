package com.adjecti.jetform.liferay.portlet;

import com.adjecti.jetform.liferay.constants.JetFormMVCPortletKeys;
import com.adjecti.jetform.liferay.service.JetFormBuilderLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.IOException;
import java.util.Enumeration;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author arjun
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.header-portlet-css=/fonts/font-awesome/css/font-awesome.min.css", 
		"com.liferay.portlet.header-portlet-css=/css/bootstrap-slider.min.css",
		"com.liferay.portlet.header-portlet-css=/css/jquery.dataTables.css",	
		"com.liferay.portlet.header-portlet-css=/css/master.data.css",	
		"com.liferay.portlet.header-portlet-css=/css/select2.min.css",	
		/*"com.liferay.portlet.header-portlet-javascript=/js/jquery-3.5.1.min.js",
		"com.liferay.portlet.header-portlet-javascript=/js/bootstrap-slider.min.js",
		"com.liferay.portlet.header-portlet-javascript=/js/buttons.html5.min.js",
		"com.liferay.portlet.header-portlet-javascript=/js/jquery.dataTables.js",
		"com.liferay.portlet.header-portlet-javascript=/js/dataTables.buttons.min.js",
		"com.liferay.portlet.header-portlet-javascript=/js/jquery.paginate.js",
		"com.liferay.portlet.header-portlet-javascript=/js/jszip.min.js",
		"com.liferay.portlet.header-portlet-javascript=/js/select2.min.js",
		"com.liferay.portlet.header-portlet-javascript=/js/handlebars.min.js",
		"com.liferay.portlet.header-portlet-javascript=/js/jetform-custom.js",*/
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=JetForm Generator",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + JetFormMVCPortletKeys.JETFORMMVC,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class JetFormMVCPortlet extends MVCPortlet {
	private static final Log LOGGER = LogFactoryUtil.getLog(JetFormMVCPortlet.class.getName());

	@Reference
	JetFormBuilderLocalService jetFormBuilderLocalService;
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		// TODO Auto-generated method stub
		//LOGGER.info("Calling JetFormMVCPortlet render()");
		//LOGGER.info("Calling JetFormMVCPortlet render()-1");
		HttpServletRequest hsRequest=PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		renderRequest.setAttribute("jetFormBuilderLocalService", jetFormBuilderLocalService);
		
		Enumeration<String> en= hsRequest.getParameterNames();
		while(en.hasMoreElements()){
			String param=en.nextElement();
			//LOGGER.info("param    :"+param+"  # value = ["+hsRequest.getParameter(param)+"]");
			renderRequest.setAttribute(param, hsRequest.getParameter(param));
		}
		super.render(renderRequest, renderResponse);
	}
	
}