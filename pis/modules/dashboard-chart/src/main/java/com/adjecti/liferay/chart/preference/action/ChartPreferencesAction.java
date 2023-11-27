package com.adjecti.liferay.chart.preference.action;

import com.adjecti.liferay.chart.config.ChartConfiguration;
import com.adjecti.liferay.chart.constants.ChartViewPortletKeys;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;

import aQute.bnd.annotation.metatype.Configurable;

@Component(
		configurationPid = ChartViewPortletKeys.CONFIGURATION_ID,
		configurationPolicy = ConfigurationPolicy.OPTIONAL, 
		immediate = true,
		property = "javax.portlet.name=" + ChartViewPortletKeys.CHARTVIEW,
		service = ConfigurationAction.class
	)

public class ChartPreferencesAction extends DefaultConfigurationAction {

	private volatile ChartConfiguration chartConfiguration;

	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		String chart = ParamUtil.getString(actionRequest, "chart");
		String labels = ParamUtil.getString(actionRequest, "labels");
		String values = ParamUtil.getString(actionRequest, "values");
		String name = ParamUtil.getString(actionRequest, "name");
		setPreference(actionRequest, "chart", chart);
		setPreference(actionRequest, "labels", labels);
		setPreference(actionRequest, "values", values);
		setPreference(actionRequest, "name", name);

		super.processAction(portletConfig, actionRequest, actionResponse);
	}

	@Activate
	@Modified
	protected void activate(Map<Object, Object> properties) {
		chartConfiguration = Configurable.createConfigurable(ChartConfiguration.class, properties);
	}


}


