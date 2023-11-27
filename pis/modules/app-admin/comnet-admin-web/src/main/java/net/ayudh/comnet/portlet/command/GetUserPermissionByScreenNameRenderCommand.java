package net.ayudh.comnet.portlet.command;

import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroupRole;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import net.ayudh.comnet.admin.constants.ComnetAdminWebPortletKeys;
import net.ayudh.comnet.admin.constants.MVCCommandNames;

@Component(
		immediate = true,
		property = {
		"javax.portlet.name=" +ComnetAdminWebPortletKeys.COMNETADMINWEB,
		"mvc.command.name=" +MVCCommandNames.PERMISSION_BY_SCREEN_NAME },
	service = MVCRenderCommand.class)
public class GetUserPermissionByScreenNameRenderCommand implements MVCRenderCommand{
	final static String FORM_APPLICATION_USER="/view.jsp";
	final static String ERROR="/error.jsp";
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			ServiceContext serviceContext=ServiceContextThreadLocal.getServiceContext();
			long companyId=serviceContext.getCompanyId();
			String screenName=ParamUtil.getString(renderRequest, "screenName");
			User user=UserLocalServiceUtil.getUserByScreenName(companyId, screenName);
			List<Role> regularRolesSelected=user.getRoles();
			List<Role> regularRoles=new ArrayList<Role>();
		
			for(Role role:RoleLocalServiceUtil.getTypeRoles(RoleConstants.TYPE_REGULAR)){
				if(regularRolesSelected.contains(role)==false) {
					regularRoles.add(role);
				}
			}
			List<Role> organizationSelectedRoles=new ArrayList<Role>();
			for(UserGroupRole ugr:UserGroupRoleLocalServiceUtil.getUserGroupRoles(user.getUserId())){
				organizationSelectedRoles.add(ugr.getRole());
			}
			List<Role> organizationRoles=new ArrayList<Role>();
			 for(Role role:RoleLocalServiceUtil.getTypeRoles(RoleConstants.TYPE_ORGANIZATION)) {
				 if(organizationSelectedRoles.contains(role)==false) {
					 organizationRoles.add(role);
				 }
			 }
			
			renderRequest.setAttribute("regularRole",regularRoles);
			renderRequest.setAttribute("regularRolesSelected", regularRolesSelected);
			
			renderRequest.setAttribute("organizationSelectedRoles",organizationSelectedRoles);
			renderRequest.setAttribute("organizationRole",organizationRoles);
			
			//renderRequest.setAttribute("siteSelectedRoles",siteSelectedRoles);
			//renderRequest.setAttribute("siteRole",siteRole);
			
			//renderRequest.setAttribute("unitTypeSelectedOrganization",unitTypeSelectedOrganization);
			//renderRequest.setAttribute("unitTypeOrganization",unitTypeOrganization);
			
			
			//List<Role> siteRole=
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		return FORM_APPLICATION_USER;
	}

}
