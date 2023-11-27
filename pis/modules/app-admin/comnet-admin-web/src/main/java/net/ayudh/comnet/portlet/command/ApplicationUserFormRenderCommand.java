package net.ayudh.comnet.portlet.command;

import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

import net.ayudh.comnet.admin.constants.ComnetAdminWebPortletKeys;
import net.ayudh.comnet.admin.constants.MVCCommandNames;
import net.ayudh.comnet.admin.dto.ApplicationUserDto;
import net.ayudh.comnet.admin.model.ApplicationUser;
import net.ayudh.comnet.admin.service.ApplicationUserLocalServiceUtil;

@Component(
		immediate = true,
		property = {
		"javax.portlet.name=" +ComnetAdminWebPortletKeys.COMNETADMINWEB,
		"mvc.command.name=" +MVCCommandNames.APPLICATION_USER_FORM },
	service = MVCRenderCommand.class)
public class ApplicationUserFormRenderCommand implements MVCRenderCommand{
	final static String FORM_APPLICATION_USER="/jsp/application_usere_form.jsp";
	final static String ERROR="/error.jsp";
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		try {
			HttpServletRequest servletRequest = PortalUtil.getHttpServletRequest(renderRequest);
			long applicationUserId=Long.parseLong(servletRequest.getParameter("userId"));
			ApplicationUser applicationUser=ApplicationUserLocalServiceUtil.getApplicationUser(applicationUserId);
			ApplicationUserDto applicationUserDto=new ApplicationUserDto();
			Employee employee = EmployeeLocalServiceUtil.getEmployee(applicationUser.getEmployeeId());
			applicationUserDto.setApplicationUserId(applicationUser.getApplicationUserId());
			applicationUserDto.setPersonalNo(employee.getPersonalNo());
			applicationUserDto.setFullName(employee.getFullName_En());
			applicationUserDto.setEmail(employee.getEmailId());
			applicationUserDto.setLoginId(employee.getLoginId());
			applicationUserDto.setIdamUser(applicationUser.isIdamUser());
			applicationUserDto.setIdamServiceStatus(applicationUser.getIdamServiceStatus());
			applicationUserDto.setIdamServiceMessage(applicationUser.getIdamServiceMessage());
			applicationUserDto.setEmailAccess(applicationUser.isEmailAccess());
			applicationUserDto.setDigitalSigning(applicationUser.isDigitalSigning());
			applicationUserDto.seteGovAccess(applicationUser.isEGovAccess());
			applicationUserDto.setPisAccess(applicationUser.getPisAccess());
//			applicationUserDto.setLastIdamUser(applicationUser.isLastIdamUser());
//			applicationUserDto.setLastEmailAccess(applicationUser.isLastEmailAccess());
//			applicationUserDto.setLastDigitalSigning(applicationUser.isLastDigitalSigning());
//			applicationUserDto.setLastEGovAccess(applicationUser.isLastEGovAccess());
//			applicationUserDto.setLastPisAccess(applicationUser.getLastPisAccess());
			
			renderRequest.setAttribute("applicationUserDto", applicationUserDto);
		
			return FORM_APPLICATION_USER;
		
	}catch (Exception e) {
		return ERROR;
	}
  }
	
//	public void updateApplicationUser(ActionRequest request, ActionResponse response) {
//		
//	}
}
		
	
