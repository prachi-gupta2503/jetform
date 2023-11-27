package net.ayudh.comnet.admin.portlet;

import com.adjecti.pis.configuration.OnBoardingConfig;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import net.ayudh.comnet.admin.constants.ComnetAdminWebPortletKeys;
import net.ayudh.comnet.admin.model.ApplicationUser;
import net.ayudh.comnet.admin.service.ApplicationUserLocalServiceUtil;


/**
 * @author jiten
 */
@Component(
		immediate = true,
		property = {
				"com.liferay.portlet.display-category=category.sample",
				"com.liferay.portlet.header-portlet-css=/css/main.css",
				"com.liferay.portlet.instanceable=true",
				"javax.portlet.display-name=ComnetAdminWeb",
				"javax.portlet.init-param.template-path=/",
				"javax.portlet.init-param.view-template=/view.jsp",
				"javax.portlet.name=" + ComnetAdminWebPortletKeys.COMNETADMINWEB,
				"javax.portlet.resource-bundle=content.Language",
				"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
		)
public class ComnetAdminWebPortlet extends MVCPortlet {
	
	@Reference
	private OnBoardingConfig configuration;
	
	static Logger logger=Logger.getLogger(ComnetAdminWebPortlet.class.getName());
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		//System.out.println("==============>"+configuration.createIdamUser());
		try {
		List<Role> regularRoles=RoleLocalServiceUtil.getTypeRoles(RoleConstants.TYPE_REGULAR);
		List<Role> organizationRoles=RoleLocalServiceUtil.getTypeRoles(RoleConstants.TYPE_ORGANIZATION);
		List<Role> siteRoles=RoleLocalServiceUtil.getTypeRoles(RoleConstants.TYPE_SITE);
		List<Organization> orgnizations=OrganizationLocalServiceUtil.getOrganizations(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		List<Organization> typeUnitOrgnizations=new ArrayList<Organization>();
		for (Organization organization : orgnizations) {
			if(organization.getType().equalsIgnoreCase("Unit")) {
				typeUnitOrgnizations.add(organization);
			}
		} 
		renderRequest.setAttribute("orgnizationTypeUnit", typeUnitOrgnizations);
		renderRequest.setAttribute("regularRole", regularRoles);
		renderRequest.setAttribute("organizationRole", organizationRoles);
		renderRequest.setAttribute("siteRole", siteRoles);
		}
		catch (Exception e) {
			e.getMessage();
		}
		super.doView(renderRequest, renderResponse);
	}
	
	public void selectedData(ActionRequest request, ActionResponse response) {

		String screenName=ParamUtil.getString(request, "screenName");
		long[] regularRoleIds=ParamUtil.getLongValues(request, "regularRoleId");
		long[] organizationaRoleIds=ParamUtil.getLongValues(request,"organizationRoleId");
		//long[] siteRoleIds=ParamUtil.getLongValues(request,"siteRoleId");
		long[] organizationTypeUnitIds=ParamUtil.getLongValues(request,"organizationTypeUnitId");

		ServiceContext serviceContext=ServiceContextThreadLocal.getServiceContext();
		long companyId=serviceContext.getCompanyId();
		try {
			User user=UserLocalServiceUtil.getUserByScreenName(companyId, screenName);
			if(regularRoleIds.length!=0) {
				RoleLocalServiceUtil.clearUserRoles(user.getUserId());
				RoleLocalServiceUtil.setUserRoles(user.getUserId(), regularRoleIds);
			}
			if(organizationaRoleIds.length!=0) {
				UserGroupRoleLocalServiceUtil.deleteUserGroupRolesByUserId(user.getUserId());
				UserGroupRoleLocalServiceUtil.addUserGroupRoles(user.getUserId(), user.getGroupId(), organizationaRoleIds);
			}
			if(organizationTypeUnitIds.length!=0) {
			
				for (long l : organizationTypeUnitIds) {
					UserLocalServiceUtil.addOrganizationUser(l, user);
				}
			}
		} catch (PortalException e) {
			System.out.println("User Not Found");
			e.printStackTrace();
		}

	}

	
	public void createApplicationUser(ActionRequest request, ActionResponse response) throws NumberFormatException, PortalException {

		try {
		
			
		ApplicationUser applicationUser=ApplicationUserLocalServiceUtil.createApplicationUser(0);
		applicationUser.setIdamUser(ParamUtil.getBoolean(request, "idamUser"));
		applicationUser.setEmailAccess(ParamUtil.getBoolean(request, "emailAccess"));
		applicationUser.setDigitalSigning(ParamUtil.getBoolean(request, "digitalSigning"));
		applicationUser.setEGovAccess(ParamUtil.getBoolean(request, "eGovAccess"));
		applicationUser.setPisAccess(ParamUtil.getBoolean(request, "pisAccess"));
		ApplicationUserLocalServiceUtil.updateApplicationUser(applicationUser);  //updateApplicationUser(applicationUser,ParamUtil.getLong(request, "applicationUserId"));
		
//		PISUserUtil.updateIDAMUser(loginId, attributes, oldValues, newValues)
//		ApplicationUser applicationUser=ApplicationUserLocalServiceUtil.getApplicationUser(ParamUtil.getLong(request, "applicationUserId"));
//		applicationUser.setIdamUser(ParamUtil.getBoolean(request, "idamUser"));
//		applicationUser.setEmailAccess(ParamUtil.getBoolean(request, "emailAccess"));
//		applicationUser.setDigitalSigning(ParamUtil.getBoolean(request, "digitalSigning"));
//		applicationUser.setEGovAccess(ParamUtil.getBoolean(request, "eGovAccess"));
//		applicationUser.setPisAccess(ParamUtil.getBoolean(request, "pisAccess"));
//		String error=updateApplicationAccess();
//		if(error.equals("")){
//			
//			applicationUser.setIdamServiceMessage("");
//			applicationUser.setIdamServiceStatus(true);
//		}
//		else { 	
//			applicationUser.setIdamServiceMessage(error);
//			applicationUser.setIdamServiceStatus(false);
//		}
//		
//		ApplicationUserLocalServiceUtil.updateApplicationUser(applicationUser);
		
		}
		catch (Exception e) {
			e.getMessage();
			logger.log(Level.INFO, "Application_User Not Found!");
		}
	}	
	
	public void updateApplicationUser(ActionRequest request, ActionResponse response) throws NumberFormatException, PortalException {
		try {
		
			
		ApplicationUser applicationUser=ApplicationUserLocalServiceUtil.createApplicationUser(0);
		applicationUser.setIdamUser(ParamUtil.getBoolean(request, "idamUser"));
		applicationUser.setEmailAccess(ParamUtil.getBoolean(request, "emailAccess"));
		applicationUser.setDigitalSigning(ParamUtil.getBoolean(request, "digitalSigning"));
		applicationUser.setEGovAccess(ParamUtil.getBoolean(request, "eGovAccess"));
		applicationUser.setPisAccess(ParamUtil.getBoolean(request, "pisAccess"));
		ApplicationUserLocalServiceUtil.updateApplicationUser(applicationUser,ParamUtil.getLong(request, "applicationUserId"));
		
//		PISUserUtil.updateIDAMUser(loginId, attributes, oldValues, newValues)
//		ApplicationUser applicationUser=ApplicationUserLocalServiceUtil.getApplicationUser(ParamUtil.getLong(request, "applicationUserId"));
//		applicationUser.setIdamUser(ParamUtil.getBoolean(request, "idamUser"));
//		applicationUser.setEmailAccess(ParamUtil.getBoolean(request, "emailAccess"));
//		applicationUser.setDigitalSigning(ParamUtil.getBoolean(request, "digitalSigning"));
//		applicationUser.setEGovAccess(ParamUtil.getBoolean(request, "eGovAccess"));
//		applicationUser.setPisAccess(ParamUtil.getBoolean(request, "pisAccess"));
//		String error=updateApplicationAccess();
//		if(error.equals("")){
//			
//			applicationUser.setIdamServiceMessage("");
//			applicationUser.setIdamServiceStatus(true);
//		}
//		else { 	
//			applicationUser.setIdamServiceMessage(error);
//			applicationUser.setIdamServiceStatus(false);
//		}
//		
//		ApplicationUserLocalServiceUtil.updateApplicationUser(applicationUser);
		
		}
		catch (Exception e) {
			e.getMessage();
			logger.log(Level.INFO, "Application_User Not Found!");
		}
	}
	
	public String disableApplicationUser(ActionRequest request, ActionResponse response) throws PortalException {
		try {
			Long applicationUserId=ParamUtil.getLong(request,"applicationUserId");
			ApplicationUser applicationUser=ApplicationUserLocalServiceUtil.getApplicationUser(applicationUserId);
			applicationUser.setStatus(1);
			ApplicationUserLocalServiceUtil.updateApplicationUser(applicationUser);
			logger.log(Level.INFO, "Application_User Disabled where Id is "+applicationUserId);
			return "Application User Disabled";
		}
		catch (Exception e) {
			e.getMessage();
			logger.log(Level.INFO, "Application_User Not Found!");
			return "Faild to Disabled Application User";
		}
	}
	
	public void enableApplicationUser(ActionRequest request, ActionResponse response) throws PortalException {
		try {
		Long applicationUserId=ParamUtil.getLong(request,"applicationUserId");
		ApplicationUser applicationUser=ApplicationUserLocalServiceUtil.getApplicationUser(applicationUserId);
		applicationUser.setStatus(0);
		ApplicationUserLocalServiceUtil.updateApplicationUser(applicationUser);
		logger.log(Level.INFO, "Application_User Enabled where Id is "+applicationUserId);
		}
		catch (Exception e) {
			e.getMessage();
			logger.log(Level.INFO, "Application_User Not Found!");
		}	
	}
	
	public void deleteEmployee(ActionRequest request, ActionResponse response) throws PortalException {
		try {
			long applicationUserId=ParamUtil.getLong(request,"applicationUserId");
			//ApplicationUser applicationUser=ApplicationUserLocalServiceUtil.getApplicationUser(applicationUserId);
			//ApplicationUserLocalServiceUtil.deleteApplicationUser(applicationUser);
			//EmployeeLocalServiceUtil.deleteByEmployeeId(applicationUser.getEmployeeId());
			//logger.log(Level.INFO, "Employee Deleted where Id is "+applicationUser.getEmployeeId());
		}
		catch (Exception e) {
			e.getMessage();
			logger.log(Level.INFO, "Employee Not Deleted!");
		}
	}
	

	public String updateApplicationAccess(){
		
	      String error="";  
	      if(configuration.createIdamUser()) {
	    	  return error;
	      }
	      else{
	    	 error="Idam User Permissions not set";
	      }
	      return error;
	}
	
	
	

}