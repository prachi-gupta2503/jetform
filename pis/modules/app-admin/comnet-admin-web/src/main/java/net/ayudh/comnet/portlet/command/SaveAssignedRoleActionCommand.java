package net.ayudh.comnet.portlet.command;

import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroupRole;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

import net.ayudh.comnet.admin.constants.ComnetAdminWebPortletKeys;
import net.ayudh.comnet.admin.constants.MVCCommandNames;
import net.ayudh.comnet.admin.model.ApplicationUser;
import net.ayudh.comnet.admin.service.ApplicationUserLocalServiceUtil;

@Component(
		immediate = true,
		property = {
		"javax.portlet.name=" +ComnetAdminWebPortletKeys.COMNETADMINWEB,
		"mvc.command.name=" +MVCCommandNames.USER_ASSIGN_ROLE_FORM },
	service = MVCActionCommand.class)
public class SaveAssignedRoleActionCommand implements MVCActionCommand{

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		
		System.out.println("saveAssignRole");
		long applicationUserId=ParamUtil.getLong(actionRequest, "applicationUserId");
		long[] avalibleUnits=ParamUtil.getLongValues(actionRequest, "avalibleUnit");		
		long[] selectedUnit=ParamUtil.getLongValues(actionRequest, "selectedUnit");
		String selectedRole=ParamUtil.getString(actionRequest, "selectedRole");
		ServiceContext serviceContext=ServiceContextThreadLocal.getServiceContext();
		try {
			ApplicationUser applicationUser=ApplicationUserLocalServiceUtil.getApplicationUser(applicationUserId);
			Employee employee=EmployeeLocalServiceUtil.getEmployee(applicationUser.getEmployeeId());		
			User user=UserLocalServiceUtil.getUserByScreenName(serviceContext.getCompanyId(), employee.getLoginId());
			long userId=user.getUserId();
			List<Role> roleTypeOrg=RoleLocalServiceUtil.getTypeRoles(RoleConstants.TYPE_ORGANIZATION);
			Role orgRole = null;
			for (Role role : roleTypeOrg) {
				if(role.getName().equals(selectedRole)) {
					orgRole=role;
					break;
				}
			}
			if(selectedUnit.length>0) {
				for(long unitId:selectedUnit) {
					Organization organization=OrganizationLocalServiceUtil.getOrganization(unitId);
					OrganizationLocalServiceUtil.addUserOrganization(userId, organization.getOrganizationId());
					RoleLocalServiceUtil.addUserRole(userId, orgRole.getRoleId());
					UserGroupRoleLocalServiceUtil.addUserGroupRole(userId, organization.getGroupId(), orgRole.getRoleId());		
				}
			}
			if(avalibleUnits.length>0) {	
				for(long unitId:avalibleUnits) {
					Organization organization=OrganizationLocalServiceUtil.getOrganization(unitId);
					List<UserGroupRole> userGroupRoles=UserGroupRoleLocalServiceUtil.getUserGroupRoles(userId, organization.getGroupId());
					for (UserGroupRole userGroupRole : userGroupRoles) {
						UserGroupRoleLocalServiceUtil.deleteUserGroupRole(userGroupRole);
					}
				}
				System.out.println("Work is done");
			}
			actionResponse.setRenderParameter("jspPage", "/jsp/save_assigned_role_response.jsp");
			SessionMessages.add(actionRequest, "success");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	

}
