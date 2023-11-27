package net.ayudh.portal.employee.web.config;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;

import net.ayudh.portal.employee.web.constants.EmployeeRswsWebPortletKeys;

@Component(
		configurationPid = "net.ayudh.portal.employee.web.config.ViewConfiguration", 
		configurationPolicy = ConfigurationPolicy.OPTIONAL, 
		immediate = true, 
		property = {"javax.portlet.name=net_ayudh_portal_employee_web_EmployeeRswsWebPortlet"}, 
		service = ConfigurationAction.class)

public class ViewConfigurationAction extends DefaultConfigurationAction  {

	
	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {

		String portletView = ParamUtil.getString(actionRequest, "portletView");
        setPreference(actionRequest, "portletView", portletView);
        System.out.println(portletView);
        
        String baseUrl = ParamUtil.getString(actionRequest, "baseUrl");
        setPreference(actionRequest, "baseUrl", baseUrl);
        System.out.println(baseUrl);
        
        String gradeId = ParamUtil.getString(actionRequest, "gradeId");
        setPreference(actionRequest, "gradeId", gradeId);
        System.out.println(baseUrl);
        String designationGroup = ParamUtil.getString(actionRequest, "designationGroup");
        setPreference(actionRequest, "gradeId", designationGroup);
		super.processAction(portletConfig, actionRequest, actionResponse);
	}

	@Override
	public void include(PortletConfig portletConfig, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {

		httpServletRequest.setAttribute(ViewConfiguration.class.getName(), _viewConfiguration);

		super.include(portletConfig, httpServletRequest, httpServletResponse);
	}

	@Activate
	@Modified
	protected void activate(Map<Object, Object> properties) {
		_viewConfiguration = ConfigurableUtil.createConfigurable(ViewConfiguration.class, properties);
	}

	private volatile ViewConfiguration _viewConfiguration;
	
	
}
