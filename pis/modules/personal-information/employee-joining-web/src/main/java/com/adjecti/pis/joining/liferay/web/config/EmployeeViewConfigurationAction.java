package com.adjecti.pis.joining.liferay.web.config;

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

@Component(
		configurationPid = "com.adjecti.pis.joining.liferay.web.config.EmployeeViewConfiguration", 
		configurationPolicy = ConfigurationPolicy.OPTIONAL, 
		immediate = true, 
		property = {"javax.portlet.name=com_adjecti_pis_joining_liferay_EmployeeJoiningWebPortlet"}, 
		service = ConfigurationAction.class)

public class EmployeeViewConfigurationAction extends DefaultConfigurationAction  {

	
	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {

		String portletView = ParamUtil.getString(actionRequest, "employeePortletView");
        setPreference(actionRequest, "employeePortletView", portletView);
        System.out.println(portletView);
        super.processAction(portletConfig, actionRequest, actionResponse);
	}

	@Override
	public void include(PortletConfig portletConfig, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {

		httpServletRequest.setAttribute(EmployeeViewConfiguration.class.getName(), _employeeViewConfiguration);

		super.include(portletConfig, httpServletRequest, httpServletResponse);
	}

	@Activate
	@Modified
	protected void activate(Map<Object, Object> properties) {
		_employeeViewConfiguration = ConfigurableUtil.createConfigurable(EmployeeViewConfiguration.class, properties);
	}

	private volatile EmployeeViewConfiguration _employeeViewConfiguration;
	
	
}
