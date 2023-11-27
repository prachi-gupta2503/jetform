package com.adjecti.pis.liferay.config;

import com.adjecti.pis.liferay.constants.PISMVCPortletKeys;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
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

@Component(configurationPid = "com.adjecti.pis.liferay.web.config.PISPortletViewConfig", configurationPolicy = ConfigurationPolicy.OPTIONAL, immediate = true, property = {
		"javax.portlet.name=" + PISMVCPortletKeys.PISMVC }, service = ConfigurationAction.class)

public class PISMVCPortletConfigAction extends DefaultConfigurationAction {
	final static Log LOGGER = LogFactoryUtil.getLog(PISMVCPortletConfigAction.class.getName());

	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {

		String portletView = ParamUtil.getString(actionRequest, PISMVCPortletConfig.PORTLET_VIEW);
		setPreference(actionRequest, PISMVCPortletConfig.PORTLET_VIEW, portletView);
		LOGGER.info("portletView : " + portletView);
		super.processAction(portletConfig, actionRequest, actionResponse);
	}

	@Override
	public void include(PortletConfig portletConfig, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {

		httpServletRequest.setAttribute(PISMVCPortletConfig.class.getName(), _pisPortletConfig);

		super.include(portletConfig, httpServletRequest, httpServletResponse);
	}

	@Activate
	@Modified
	protected void activate(Map<Object, Object> properties) {
		_pisPortletConfig = ConfigurableUtil.createConfigurable(PISMVCPortletConfig.class, properties);
	}

	private volatile PISMVCPortletConfig _pisPortletConfig;

}
