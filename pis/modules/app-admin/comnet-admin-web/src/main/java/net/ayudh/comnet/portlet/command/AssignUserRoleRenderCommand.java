package net.ayudh.comnet.portlet.command;

import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroupRole;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import net.ayudh.comnet.admin.constants.ComnetAdminWebPortletKeys;
import net.ayudh.comnet.admin.constants.MVCCommandNames;
import net.ayudh.comnet.admin.model.ApplicationUser;
import net.ayudh.comnet.admin.service.ApplicationUserLocalServiceUtil;

@Component(
		immediate = true,
		property = {
		"javax.portlet.name=" +ComnetAdminWebPortletKeys.COMNETADMINWEB,
		"mvc.command.name=" +MVCCommandNames.ASSIGN_ROLE_FORM },
	service = MVCRenderCommand.class)
public class AssignUserRoleRenderCommand implements MVCRenderCommand{
	final static String ASSIGN_USER_ROLE_FORM="/jsp/application_user_role.jsp";
	final static String ERROR="/error.jsp";
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
			long applicationUserId=ParamUtil.getLong(renderRequest,"applicationUserId");
			ApplicationUser applicationUser;
			Organization organization;
			Employee employee;
			String logMessage="";
			
			List<Organization> childOrganizationsTypeUnit=new ArrayList<Organization>();
			List<Organization> units=new ArrayList<Organization>();
			List<Organization> selectedUnit=new ArrayList<Organization>();
			
			try {
				childOrganizationsTypeUnit=new ArrayList<Organization>();
				logMessage="No Application_User exists with the primary key "+applicationUserId;
				applicationUser=ApplicationUserLocalServiceUtil.getApplicationUser(applicationUserId);
				long employeeId=applicationUser.getEmployeeId();
				logMessage="No pis_employee exists with the primary key "+employeeId;
				employee=EmployeeLocalServiceUtil.getEmployee(employeeId);
				long organizationId=employee.getOrganizationId();
				logMessage="No Organization exists with the primary key "+organizationId;
			    organization=OrganizationLocalServiceUtil.getOrganization(employee.getOrganizationId());
			    Organization parentOrgTypeDivision=getOrgnizationTypeDivision(organization);
			    ServiceContext context = ServiceContextThreadLocal.getServiceContext();
			    List<Organization> childOrganizations=OrganizationLocalServiceUtil.getSuborganizations(context.getCompanyId(), parentOrgTypeDivision.getOrganizationId());
			    for (Organization org : childOrganizations) {
					if(org.getType().equals("Unit")){
						childOrganizationsTypeUnit.add(org);
					}
				}
			    ServiceContext serviceContext=ServiceContextThreadLocal.getServiceContext();
			    User user=UserLocalServiceUtil.getUserByScreenName(serviceContext.getCompanyId(), employee.getLoginId());
			    List<UserGroupRole> userGroupRoles=UserGroupRoleLocalServiceUtil.getUserGroupRoles(user.getUserId());
			    if(userGroupRoles.size()>0) {
			    	if(RoleLocalServiceUtil.getRole(userGroupRoles.get(0).getRoleId()).getName().equals("PIS APPROVER")) {
			    		renderRequest.setAttribute("selectedRole", "PIS APPROVER");
			    	}
			    	if(RoleLocalServiceUtil.getRole(userGroupRoles.get(0).getRoleId()).getName().equals("PIS UPLOADER")) {
			    		renderRequest.setAttribute("selectedRole", "PIS UPLOADER");
			    	}
			    	renderRequest.setAttribute("dropdownProp", "true");
			    }
			    else {
			    	renderRequest.setAttribute("dropdownProp", "false");
			    }
			    if(userGroupRoles.size()>0) {
			    	for(Organization org:childOrganizationsTypeUnit) {
			    		if(UserGroupRoleLocalServiceUtil.hasUserGroupRole(user.getUserId(), org.getGroupId(), userGroupRoles.get(0).getRoleId())) {
			    			selectedUnit.add(org);
			    		}
			    		else {
			    			units.add(org);
			    		}
			    	}
			    }
			    else {
			    	for(Organization org:childOrganizationsTypeUnit) {
			    		units.add(org);
			    	}
			    	
			    }
	
			} catch (PortalException e) {
				System.out.println(logMessage);
				LOGGER.log(Level.INFO, logMessage);
			}
			

			
			renderRequest.setAttribute("units", units);
			renderRequest.setAttribute("selectedUnits", selectedUnit);
		    renderRequest.setAttribute("applicationUserId", applicationUserId);
			return ASSIGN_USER_ROLE_FORM;
  }

	private Organization getOrgnizationTypeDivision(Organization organization) throws PortalException {
		if(organization.getType().equals("Unit")) {
			organization=getOrgnizationTypeDivision(organization.getParentOrganization());
		}
		if(organization.getType().equals("Division")) {
			return organization;
		}
		return organization;
	}

	
//	public void updateApplicationUser(ActionRequest request, ActionResponse response) {
//		
//	}
}
		
	
