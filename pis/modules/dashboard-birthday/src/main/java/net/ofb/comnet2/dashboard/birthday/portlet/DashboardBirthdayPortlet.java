package net.ofb.comnet2.dashboard.birthday.portlet;

import com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import javax.portlet.PortletPreferences;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import net.ofb.comnet2.dashboard.birthday.constants.DashboardBirthdayPortletKeys;
import net.ofb.comnet2.dashboard.birthday.portlet.configuration.BirthdayConfiguration;

/**
 * @author Chinm
 */
@Component(
		configurationPid ="net.ofb.comnet2.dashboard.birthday.portlet.configuration.BirthdayConfiguration",
		immediate = true,property = { "com.liferay.portlet.display-category=category.dashboard",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=DashboardBirthday", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + DashboardBirthdayPortletKeys.DASHBOARDBIRTHDAY,
		"javax.portlet.resource-bundle=content.Language",
"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class DashboardBirthdayPortlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		renderRequest.setAttribute(BirthdayConfiguration.class.getName(), _configuration);
		PortletPreferences preferences = renderRequest.getPreferences();
		String designationGroupName = preferences.getValue("selectGroup", _configuration.selectGroup());
		System.out.println("Group Name "+designationGroupName);
		JSONArray array = null;
		try {
			JSONArray byDateOfBirth = EmployeeLocalServiceUtil.getByDateOfBirth(designationGroupName);
			
			renderRequest.setAttribute("birthdayList", byDateOfBirth);
		} catch (PortalException e) {
			e.printStackTrace();
		}
		System.out.println("hello");
		super.doView(renderRequest, renderResponse);
	}


	public String getGroup(Map colors) { 
		return (String)colors.get(_configuration.selectGroup());
	}


	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_configuration = ConfigurableUtil.createConfigurable(BirthdayConfiguration.class, properties);
	}

	private volatile BirthdayConfiguration _configuration;

}
