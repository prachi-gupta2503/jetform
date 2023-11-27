package net.ofb.comnet2.dashboard.birthday.portlet.configuration;

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


import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;
@Component(configurationPid ="net.ofb.comnet2.dashboard.birthday.portlet.configuration.BirthdayConfiguration",
configurationPolicy = ConfigurationPolicy.OPTIONAL, 
immediate = true, 
property = {"javax.portlet.name=net_ofb_comnet2_dashboard_approval_DashboardBirthdayPortlet"}, 
service = ConfigurationAction.class)
public class BithdayConfigurationAction  extends DefaultConfigurationAction {

	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		// TODO Auto-generated method stub
		
		String selectGroup = ParamUtil.getString(actionRequest, "selectGroup");
        setPreference(actionRequest, "selectGroup", selectGroup);
        System.out.println(selectGroup);
		super.processAction(portletConfig, actionRequest, actionResponse);
	}
	@Override
	public void include(PortletConfig portletConfig, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {

		httpServletRequest.setAttribute(BirthdayConfiguration.class.getName(), _configuration);

		super.include(portletConfig, httpServletRequest, httpServletResponse);
	}
	public String getGroup(Map group) {
		return (String) group.get(_configuration.selectGroup()); 
		}


	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_configuration = ConfigurableUtil.createConfigurable(
				BirthdayConfiguration.class, properties);
	}

	
	
	

	private volatile BirthdayConfiguration _configuration;

}
