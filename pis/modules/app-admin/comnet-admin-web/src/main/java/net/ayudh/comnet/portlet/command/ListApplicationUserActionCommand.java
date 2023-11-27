package net.ayudh.comnet.portlet.command;
import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

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
		"mvc.command.name=" + MVCCommandNames.APPLICATION_USER_LIST },
	service = MVCActionCommand.class)
public class ListApplicationUserActionCommand implements MVCActionCommand {
	final static String LIST_APPLICATION_USER="/list_application_user.jsp";
	final static String ERROR="/jsp/error.jsp";
	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		try {
			String personalNo=ParamUtil.getString(actionRequest, "personalNo");
			if(!personalNo.isEmpty()){
				ApplicationUser applicationUser=ApplicationUserLocalServiceUtil.getApplicationUserByPersonalNo(personalNo);
				Employee employee=EmployeeLocalServiceUtil.getEmployee(applicationUser.getEmployeeId());
				ApplicationUserDto applicationUserDto=new ApplicationUserDto(applicationUser,employee);
				List<ApplicationUserDto> applicationUserDtos=new ArrayList<ApplicationUserDto>();
				applicationUserDtos.add(applicationUserDto);
				actionRequest.setAttribute("applicationUserDtos", applicationUserDtos);
			}
			return true;
	}catch (Exception e) {
		e.printStackTrace();
		return false;
	}
	}
	
	
//	<%
//	  List<ApplicationUserDto> applicationUserDtos=new ArrayList<ApplicationUserDto>();
//	  	
//	  	String personalNo=ParamUtil.getString(request, "personalNo", "");
//		if(!personalNo.isEmpty()){
//			try{
//	  			ApplicationUser applicationUser=ApplicationUserLocalServiceUtil.getApplicationUserByPersonalNo(personalNo);
//				Employee employee=EmployeeLocalServiceUtil.getEmployee(applicationUser.getEmployeeId());
//				ApplicationUserDto applicationUserDto=new ApplicationUserDto(applicationUser,employee);
//				applicationUserDtos.add(applicationUserDto);
//			}catch(Exception e){
//	  			e.printStackTrace();	
//	  		}
//		}
//	  	
//	%>

	
	
//	@Override
//	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
//		try {
//			System.out.println("Hello");
//			String personalNo=ParamUtil.getString(renderRequest, "personalNo");
//			ApplicationUser applicationUser=ApplicationUserLocalServiceUtil.getApplicationUserByPersonalNo(personalNo);
//			Employee employee=EmployeeLocalServiceUtil.getEmployee(applicationUser.getEmployeeId());
//			ApplicationUserDto applicationUserDto=new ApplicationUserDto(applicationUser,employee);
//			List<ApplicationUserDto> applicationUserDtos=new ArrayList<ApplicationUserDto>();
//			applicationUserDtos.add(applicationUserDto);
//			renderRequest.setAttribute("applicationUserDtos", applicationUserDtos);
//			System.out.println(applicationUserDto.getFullName());
//			return LIST_APPLICATION_USER;
//		}catch (Exception e) {
//			return ERROR;
//		}
//		
//	}
//	
}