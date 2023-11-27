package com.adjecti.pis.joining.liferay.web.action;

import com.adjecti.pis.joining.liferay.constants.EmployeeJoiningWebPortletKeys;
import com.adjecti.pis.liferay.dto.EmployeeDTO;
import com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + EmployeeJoiningWebPortletKeys.EMPLOYEEJOININGWEB,
			"mvc.command.name=" +"/joining/employee/search"
		},
		service = MVCRenderCommand.class
	)
public class SearchEmployeeMVCRenderCommand implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		System.out.println("In Render Command");
		long organizationId =ParamUtil.getLong(renderRequest, "unit");
		long tradeId =ParamUtil.getLong(renderRequest, "trade");
		long gradeId =ParamUtil.getLong(renderRequest, "grade");
		long designationId =ParamUtil.getLong(renderRequest, "designation");
		String searchKeyword=ParamUtil.getString(renderRequest, "keywords");
		System.out.println(organizationId+"--"+tradeId+"--"+gradeId+"--"+designationId+"----"+searchKeyword);
		
//		List<EmployeeDTO> employees= EmployeeLocalServiceUtil.getEmployeesByKeywords(organizationId,tradeId,gradeId,designationId,searchKeyword);
//		if(employees.isEmpty())
//			employees=null;
//		renderRequest.setAttribute("employees", employees);
		return "/view.jsp";
	}
	
}
