package net.ayudh.comnet.portlet.command;

import com.adjecti.pis.constant.OnboardingUserRole;
import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.model.UserGroupRole;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.UserGroupLocalServiceUtil;
import com.liferay.portal.kernel.service.UserGroupRoleLocalService;
import com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;

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
		"mvc.command.name=" +MVCCommandNames.UPLOADER_ROLE_LIST },
	service = MVCRenderCommand.class)
public class UploaderRoleListRenderCommand implements MVCRenderCommand{
	final static String UPLOADER_ROLE_LIST="/jsp/uploader_role_list.jsp";
	final static String ERROR="/jsp/error.jsp";
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		try {
			
//			List<Role> roles=RoleLocalServiceUtil.get
//			for(User user:users) {	
//				List<Role> roles=user.getRoles();
//				for(Role role:roles) {
//					System.out.println(role.getName());
//				}
//			}
			
			List<Role> organizationRoles=RoleLocalServiceUtil.getTypeRoles(RoleConstants.TYPE_ORGANIZATION);
			Role organizationRole =null;
			List<UserGroup> userGroups=null;
			for (Role role : organizationRoles) {
				if(role.getName().equals("PIS UPLOADER")) {
					organizationRole=role;
				}
				
			}
			
			List<UserGroupRole> userGroupRoles=UserGroupRoleLocalServiceUtil.getUserGroupRoles(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			List<User> users=new ArrayList<User>();
			for (UserGroupRole userGroupRole : userGroupRoles) {
				if(organizationRole.getRoleId()==userGroupRole.getRoleId()) {
					users.add(userGroupRole.getUser());
				}
			}
			
//			for (User user : users) {
//				EmployeeLocalServiceUtil.getEmployeeByLoginId();
//				System.out.println(user.getEmailAddress());
//			}
			
			//ServiceContext serviceContext=ServiceContextThreadLocal.getServiceContext();
			//long groupId=serviceContext.getScopeGroupId();
//			ThemeDisplay themeDisplay=serviceContext.getThemeDisplay();
//			long groupId=themeDisplay.getLayout().getGroupId();
//			List<UserGroupRole> userGroupRoles=UserGroupRoleLocalServiceUtil.getUserGroup
//			System.out.println("List Length"+userGroupRoles.size());
//			for (UserGroupRole userGroupRole : userGroupRoles) {
//				System.out.println(userGroupRole.getUserId());
//			}
			/*
			 * ServiceContext serviceContext=ServiceContextThreadLocal.getServiceContext();
			 * System.out.println(">>>"+RoleLocalServiceUtil.getRole(serviceContext.
			 * getCompanyId(), "PIS UPLOADER").getRoleId()); Role
			 * role=RoleLocalServiceUtil.getRole(serviceContext.getCompanyId(),
			 * "PIS UPLOADER"); role.get long[]
			 * userIds=UserLocalServiceUtil.getRoleUserIds(role.getRoleId());
			 */
			return UPLOADER_ROLE_LIST;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		/*
		try {
			System.out.println("Uploader role List command File");
			List<Employee> employees=new ArrayList<Employee>();
			for(Employee employee:EmployeeLocalServiceUtil.getEmployees(QueryUtil.ALL_POS, QueryUtil.ALL_POS)) {
				User user;
				try {
				user=UserLocalServiceUtil.getUser(employee.getUserId());
				List<Role> roles=user.getRoles();
				System.out.println(roles.size());
				for(Role role:roles) {
					if(role.getType()== RoleConstants.TYPE_ORGANIZATION && role.getName().equalsIgnoreCase(OnboardingUserRole.valueOf(OnboardingUserRole.CREATER_ROLE))) {
						employees.add(employee);
					}
				}
				}catch (Exception e) {
					e.getMessage();
				}
				
			}
			renderRequest.setAttribute("employees", employees);
			System.out.println(employees.size());
			System.out.println("Uploader role List Genarated");
			return UPLOADER_ROLE_LIST;
		}
		catch (Exception e) {
			e.getMessage();
			return ERROR;
		}
		*/
	}
}
