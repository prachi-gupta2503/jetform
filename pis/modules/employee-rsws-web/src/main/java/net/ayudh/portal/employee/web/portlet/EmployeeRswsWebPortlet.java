package net.ayudh.portal.employee.web.portlet;

import net.ayudh.portal.employee.web.config.ViewConfiguration;
import net.ayudh.portal.employee.web.constants.EmployeeRswsWebPortletKeys;


import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

/**
 * @author jiten
 */
@Component(
	configurationPid="net.ayudh.portal.employee.web.config.ViewConfiguration",
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=EmployeeRswsWeb",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + EmployeeRswsWebPortletKeys.EMPLOYEERSWSWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class EmployeeRswsWebPortlet extends MVCPortlet {
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		renderRequest.setAttribute(ViewConfiguration.class.getName(), _viewConfiguration);
		
		super.doView(renderRequest, renderResponse);
	}

	public String getPortletView(Map labels) {
		return (String) labels.get(_viewConfiguration.portletView());
	}
	
	public String getBaseUrl(Map labels) {
		return (String) labels.get(_viewConfiguration.baseUrl());
	}
	
	public String getGradeId(Map labels) {
		return (String) labels.get(_viewConfiguration.gradeId());
	}
	

	@Activate
	@Modified
	protected void activate(Map<Object, Object> properties) {
		_viewConfiguration = ConfigurableUtil.createConfigurable(ViewConfiguration.class, properties);
	}

	private volatile ViewConfiguration _viewConfiguration;
}