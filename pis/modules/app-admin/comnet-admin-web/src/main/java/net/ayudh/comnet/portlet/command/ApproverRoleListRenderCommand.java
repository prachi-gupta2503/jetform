package net.ayudh.comnet.portlet.command;

import com.adjecti.pis.constant.OnboardingUserRole;
import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

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
		"mvc.command.name=" +MVCCommandNames.APPROVER_ROLE_LIST },
	service = MVCRenderCommand.class)
public class ApproverRoleListRenderCommand implements MVCRenderCommand{
	final static String APPROVER_ROLE_LIST="/jsp/approver_role_list.jsp";
	final static String ERROR="/jsp/error.jsp";
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		try {
			System.out.println("Approver role List command File");
			List<Employee> employees=new ArrayList<Employee>();
			for(Employee employee:EmployeeLocalServiceUtil.getEmployees(QueryUtil.ALL_POS, QueryUtil.ALL_POS)) {
				User user;
				try {
				user=UserLocalServiceUtil.getUser(employee.getUserId());
				List<Role> roles=user.getRoles();
				System.out.println(roles.size());
				
				for(Role role:roles) {
					if(role.getType()== RoleConstants.TYPE_ORGANIZATION && role.getName().equalsIgnoreCase(OnboardingUserRole.valueOf(OnboardingUserRole.APPROVER_ROLE))) {
						employees.add(employee);
					}
				}
				}catch (Exception e) {
					e.getMessage();
				}
				
			}
			System.out.println(employees.size());
			renderRequest.setAttribute("employees", employees);
			System.out.println("Approver role List Genarated");
			return APPROVER_ROLE_LIST;
		}
		catch (Exception e) {
			e.getMessage();
			return ERROR;
		}

		
	}

}


